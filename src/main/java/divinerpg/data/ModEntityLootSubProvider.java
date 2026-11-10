package divinerpg.data;

import divinerpg.registries.*;
import net.minecraft.advancements.predicates.FluidPredicate;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.predicates.LocationPredicate;
import net.minecraft.advancements.predicates.entity.EntityEquipmentPredicate;
import net.minecraft.advancements.predicates.entity.EntityFlagsPredicate;
import net.minecraft.advancements.predicates.entity.EntityPredicate;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.data.loot.LootTableSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.*;
import net.minecraft.world.level.storage.loot.predicates.*;
import net.minecraft.world.level.storage.loot.providers.number.floats.ContextFloatProviders;
import net.minecraft.world.level.storage.loot.providers.number.ints.ContextIntProviders;
import net.neoforged.neoforge.common.Tags;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static divinerpg.registries.EntityRegistry.*;

public class ModEntityLootSubProvider extends EntityLootSubProvider {

    // Loot table
    private final Map<EntityType<?>, LootTable.Builder> lootTableMap = new HashMap<>();

    // Registry access is required for loot conditions and functions: Minecraft uses it to look up
    // item and fluid tags, as well as the Looting enchantment
    private final HolderGetter<Item> itemLookup = output.lookup(Registries.ITEM);
    private final HolderGetter<Fluid> fluidLookup = output.lookup(Registries.FLUID);
    private final HolderGetter<Enchantment> enchantmentLookup = output.lookup(Registries.ENCHANTMENT);

    private final LootItemCondition.Builder smeltPredicate = createSmeltPredicate();

    public ModEntityLootSubProvider(LootTableSubProvider.Context output) {
        super(FeatureFlags.REGISTRY.allFlags(), output);
        registerTables();
    }

    // One item with the default count of 1 and withot Looting bonus
    private LootItem.Builder<?> lootItem(ItemLike item) {
        return LootItem.lootTableItem(item);
    }

    // A fixed count: lootItem(Items.DIAMOND, 6) yields exactly 6 diamonds without a Looting bonus
    private LootItem.Builder<?> lootItem(ItemLike item, int count) {
        return lootItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.exactly(count)));
    }

    // An item with a random count between min and max, inclusive, without a Looting bonus
    private LootItem.Builder<?> lootItem(ItemLike item, int min, int max) {
        return lootItem(item).apply(SetItemCountFunction.setCount(ContextIntProviders.between(min, max)));
    }

    // One item plus a Looting bonus, used for hearts, pearls, and similar drops
    private LootItem.Builder<?> lootingItem(ItemLike item) {
        return lootItem(item).apply(lootingBonus());
    }

    // A random min max count plus a Looting bonus
    private LootItem.Builder<?> lootingItem(ItemLike item, int min, int max) {
        return lootItem(item, min, max).apply(lootingBonus());
    }

    // Looting count bonus add (a random value between 0 and 1) the enchantment level
    private EnchantedCountIncreaseFunction.Builder lootingBonus() {
        return EnchantedCountIncreaseFunction.lootingMultiplier(
                enchantmentLookup,
                ContextFloatProviders.between(0, 1)
        );
    }

    // A chance condition affected by "Looting" chance = baseChance + level * bonusPerLevel
    private LootItemCondition.Builder lootingChance(float baseChance, float bonusPerLevel) {
        return LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(
                enchantmentLookup,
                baseChance,
                bonusPerLevel
        );
    }

    // Requires the ATTACKER to hold an item from the tag in its main hand (ItemTags.PICKAXES)
    // The attacker is the killer for an arrow kill, it is the entity that fired the arrow
    private LootItemCondition.Builder attackerHolds(TagKey<Item> itemTag) {
        return mainHandHolds(LootContext.EntityTarget.ATTACKER, itemTag);
    }

    /**
     * General check for a main-hand item belonging to a tag
     * Targets selected through LootContext.EntityTarget
     *  ATTACKER - the killer (the shooter for a projectile attack)
     *  DIRECT_ATTACKER - the direct damage source (the arrow for an arrow hit)
     *  THIS - the mob whose loot is being calculated
     */
    private LootItemCondition.Builder mainHandHolds(LootContext.EntityTarget target, TagKey<Item> itemTag) {
        return LootItemEntityPropertyCondition.hasProperties(
                target,
                EntityPredicate.Builder.entity().equipment(
                        EntityEquipmentPredicate.Builder.equipment().mainhand(
                                ItemPredicate.Builder.item().of(itemLookup, itemTag)
                        )
                )
        );
    }

    /**
     * Requires the mob to stand on a block containing fluid from the tag (e.g. Tags.Fluids.WATER)
     * This checks the block position under its feet (steppingOn), rather than whether it is submerged
     */
    private LootItemCondition.Builder standingOnFluid(TagKey<Fluid> fluidTag) {
        return LootItemEntityPropertyCondition.hasProperties(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.entity().steppingOn(
                        LocationPredicate.Builder.location().setFluid(
                                FluidPredicate.Builder.fluid().of(fluidLookup.getOrThrow(fluidTag))
                        )
                )
        );
    }

    // Requires the mob to be in the specified dimension
    private LootItemCondition.Builder inDimension(ResourceKey<Level> dimension) {
        return LootItemEntityPropertyCondition.hasProperties(
                LootContext.EntityTarget.THIS,
                EntityPredicate.Builder.entity().located(
                        LocationPredicate.Builder.location().setDimension(dimension)
                )
        );
    }

    /**
     * Smelts an item (e.g. raw meat into cooked meat) only when the shared smeltPredicate
     * is satisfied. If no smelting recipe exists for the item, it remains unchanged
     */
    private SmeltItemFunction.Builder smelt() {
        return SmeltItemFunction.smelted().when(smeltPredicate);
    }

    // Smelts loot if the mob is burning OR the main hand of DIRECT_ATTACKER matches SMELTS_LOOT
    private LootItemCondition.Builder createSmeltPredicate() {
        return AnyOfCondition.anyOf(
                LootItemEntityPropertyCondition.hasProperties(
                        LootContext.EntityTarget.THIS,
                        EntityPredicate.Builder.entity().flags(EntityFlagsPredicate.Builder.flags().setOnFire(true))
                ),
                mainHandHolds(LootContext.EntityTarget.DIRECT_ATTACKER, TagRegistry.SMELTS_LOOT)
        );
    }

    ////  Pools methods
    // A standard pool ONE roll among the supplied entries
    private LootPool.Builder pool(LootPoolEntryContainer.Builder<?>... entries) {
        LootPool.Builder pool = LootPool.lootPool().setRolls(ContextIntProviders.exactly(1));
        for (LootPoolEntryContainer.Builder<?> entry : entries) {
            pool.add(entry);
        }
        return pool;
    }

    /**
     * A pool that requires the death to be credited to a player (usually because the player
     * recently damaged the mob). A subsequent death from falling, lava, or fire may still
     * be credited to that player. A death without recent player involvement fails this condition
     */
    private LootPool.Builder playerKillPool(LootPoolEntryContainer.Builder<?>... entries) {
        return pool(entries).when(LootItemKilledByPlayerCondition.killedByPlayer());
    }

    // Shortcuts for common single entry pools

    // A single-entry pool with a base count of 1 and a Looting bonus
    private LootPool.Builder lootingPool(ItemLike item) {
        return pool(lootingItem(item));
    }

    // A single entry pool with a min max count and a Looting bonus
    private LootPool.Builder lootingPool(ItemLike item, int min, int max) {
        return pool(lootingItem(item, min, max));
    }

    // Equivalent to lootingPool, but requires the death to be credited to a player
    private LootPool.Builder playerLootingPool(ItemLike item) {
        return playerKillPool(lootingItem(item));
    }

    private LootPool.Builder playerLootingPool(ItemLike item, int min, int max) {
        return playerKillPool(lootingItem(item, min, max));
    }

    /**
     * A rare item: requires player kill credit, with a chance increased by Looting
     * The count is left at its default of 1; no count bonus is applied
     */
    private LootPool.Builder rarePool(ItemLike item, float baseChance, float bonusPerLevel) {
        return playerKillPool(lootItem(item)).when(lootingChance(baseChance, bonusPerLevel));
    }

    // Boss statue awarded when the death is credited to a player
    private LootPool.Builder statue(ItemLike statueBlock) {
        return playerKillPool(lootItem(statueBlock));
    }

    // Bone meal with a fixed chance, unaffected by Looting
    private LootPool.Builder boneMealPool(float chance) {
        return pool(lootItem(Items.BONE_MEAL)).when(LootItemRandomChanceCondition.randomChance(chance));
    }

    // 0–2 string plus a Looting bonus, shared by all spiders
    private LootPool.Builder stringPool() {
        return lootingPool(Items.STRING, 0, 2);
    }

    // Spider eyes: requires player kill credit, with a count range of -1 1
    private LootPool.Builder spiderEyePool() {
        return playerLootingPool(Items.SPIDER_EYE, -1, 1);
    }

    // Dimension specific meat shared by related mobs

    // Wildwood magic meat 0–1 without Looting
    private LootPool.Builder magicMeat() {
        return pool(lootItem(ItemRegistry.magic_meat.get(), 0, 1));
    }

    // Apalachia enriched magic meat: 0–1, without Looting
    private LootPool.Builder enrichedMeat() {
        return pool(lootItem(ItemRegistry.enriched_magic_meat.get(), 0, 1));
    }

    // Raw empowered meat from Eden, which may drop cooked
    private LootPool.Builder empoweredMeat() {
        return pool(lootItem(ItemRegistry.raw_empowered_meat.get()).apply(smelt()).apply(lootingBonus()));
    }

    //// Potions

    // A poison potion using the vanilla effect through the POTION_CONTENTS component
    private LootItem.Builder<?> poisonPotion() {
        return lootItem(Items.POTION).apply(SetComponentsFunction.setComponent(
                DataComponents.POTION_CONTENTS,
                new PotionContents(BuiltInRegistries.POTION.get(Potions.POISON.getKey()).get())
        ));
    }

    // Wreck special potion a custom non-italic name lore and Fire Resistance lasting 1400 ticks (70 seconds)
    private LootItem.Builder<?> wreckPotion() {
        return lootItem(Items.POTION)
                .apply(SetNameFunction.setName(
                        Component.translatable("item.divinerpg.potion.wreck_potion").withStyle(style -> style.withItalic(false)),
                        SetNameFunction.Target.ITEM_NAME))
                .apply(SetLoreFunction.setLore()
                        .addLine(Component.translatable("lore.divinerpg.wreck_potion"))
                        .setMode(ListOperation.Append.INSTANCE))
                .apply(SetComponentsFunction.setComponent(
                        DataComponents.POTION_CONTENTS,
                        new PotionContents(Optional.empty(), Optional.empty(),
                                List.of(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1400)), Optional.empty())));
    }

    //  REGISTRATION
    /**
     * Registers one mobs loot table from a set of pools.
     * Accepts a Supplier, as exposed by EntityRegistry, so callers do not need .get().
     * Throws on duplicate registration: Map.put previously overwrote the old table silently,
     * making accidental duplicates difficult to notice =(
     */
    private void registerLoot(Supplier<? extends EntityType<?>> entity, LootPool.Builder... pools) {
        EntityType<?> type = entity.get();
        if (lootTableMap.containsKey(type)) {
            throw new IllegalStateException("Таблица лута уже зарегистрирована для: " + type);
        }
        LootTable.Builder table = LootTable.lootTable();
        for (LootPool.Builder pool : pools) {
            table.withPool(pool);
        }
        lootTableMap.put(type, table);
    }

    /**
     * Registers IDENTICAL loot for several mobs.
     * The same LootPool.Builder objects are passed to multiple registrations.
     * In registerLoot, table.withPool(pool) immediately calls pool.build(), storing a built
     * pool in the table. Adding .when(...) to the builder later does not alter previously
     * added pools, but does affect subsequent registrations using that builder.
     * Treat a shared builder as immutable after preparing it
     */
    private void registerGroup(List<? extends Supplier<? extends EntityType<?>>> entities, LootPool.Builder... pools) {
        entities.forEach(entity -> registerLoot(entity, pools));
    }

    // Registration order does not matter; dimension grouping is only for readability
    private void registerTables() {
        registerOverworldTables();
        registerVetheaTables();
        registerSkythernTables();
        registerIceikaTables();
        registerNetherTables();
        registerEndTables();
        registerArcanaTables();
        registerEdenTables();
        registerWildwoodTables();
        registerApalachiaTables();
        registerMortumTables();
        registerOtherTables();
        registerBossTables();
    }

    // Overworld
    private void registerOverworldTables() {
        // One pool with two entries: slime (weight 4) OR aqua ball (weight 1); slime is four times as likely.
        registerLoot(AEQUOREA,
                pool(lootingItem(Items.SLIME_BALL, 1, 3).setWeight(4), lootingItem(ItemRegistry.aqua_ball.get(), 1, 2)));

        // Two pools: sandstone and red wool roll independently, so both may drop
        registerLoot(ARID_WARRIOR,
                lootingPool(Items.SANDSTONE, 0, 3),
                lootingPool(Items.WOOL.red(), 0, 3));

        // Two independent pools, both requiring player kill credit:
        // realmite ingots and gold nuggets may drop together
        registerLoot(CAVECLOPS,
                playerLootingPool(ItemRegistry.realmite_ingot.get(), 0, 3),
                playerLootingPool(Items.GOLD_NUGGET, 0, 2));

        registerLoot(CAVE_CRAWLER,
                playerLootingPool(ItemRegistry.realmite_ingot.get(), 0, 2),
                playerKillPool(poisonPotion()).when(lootingChance(0.01F, 0.03F)));

        registerLoot(CRAB,
                lootingPool(ItemRegistry.crab_claw.get(), 0, 1));

        registerLoot(CYCLOPS,
                lootingPool(ItemRegistry.cyclops_eye_shards.get(), 0, 1),
                playerLootingPool(Items.GOLD_INGOT, 0, 1),
                rarePool(ItemRegistry.bloodgem.get(), 0.025F, 0.005F));

        // Desert Crawler: loot depends on the killers tool and the block the mob stands on
        registerLoot(DESERT_CRAWLER,
                // Pickaxe 1–3 sandstone (smelted when burning or SMELTS_LOOT applies)
                pool(lootItem(Blocks.SANDSTONE, 1, 3).apply(smelt())).when(attackerHolds(ItemTags.PICKAXES)),
                // Wrench 1–3 chiseled sandstone
                pool(lootItem(Blocks.CHISELED_SANDSTONE, 1, 3)).when(attackerHolds(Tags.Items.TOOLS_WRENCH)),
                // Shovel, mob NOT standing on water 1–4 sand (may be smelted)
                pool(lootItem(Blocks.SAND, 1, 4).apply(smelt()))
                        .when(InvertedLootItemCondition.invert(standingOnFluid(Tags.Fluids.WATER)))
                        .when(attackerHolds(ItemTags.SHOVELS)),
                // Shovel, mob standing ON water 1–4 sandstone
                pool(lootItem(Blocks.SANDSTONE, 1, 4))
                        .when(attackerHolds(ItemTags.SHOVELS))
                        .when(standingOnFluid(Tags.Fluids.WATER)),
                // Lava lamp: conditions apply to the ENTRY, not the pool. Requires burning/SMELTS_LOOT,
                // a MINING_ENCHANTABLE tool, and a 40% chance (+5 percentage points per Looting level).
                pool(lootItem(BlockRegistry.lavaLamp.get())
                        .when(smeltPredicate)
                        .when(lootingChance(0.4F, 0.05F))
                        .when(attackerHolds(ItemTags.MINING_ENCHANTABLE))));

        registerLoot(ENTHRALLED_DRAMCRYX,
                lootingPool(ItemRegistry.corrupted_shards.get(), 0, 2),
                lootingPool(ItemRegistry.corrupted_shards.get(), 0, 4),   // second pool with the same item; intentional?
                rarePool(ItemRegistry.arlemite_ingot.get(), 0.025F, 0.045F));

        registerLoot(FROST,
                lootingPool(ItemRegistry.ice_shards.get(), 0, 2),
                playerKillPool(lootItem(ItemRegistry.ice_stone.get(), 0, 1)).when(lootingChance(0.13F, 0.02F)),
                playerKillPool(lootingItem(ItemRegistry.tomato.get(), 0, 1)).when(lootingChance(0.5F, 0.01F)));

        registerLoot(GLACON,
                lootingPool(ItemRegistry.ice_shards.get(), 0, 3),
                playerKillPool(lootingItem(ItemRegistry.white_mushroom.get(), 0, 1)).when(lootingChance(0.5F, 0.01F)));

        // Two mobs with identical loot.
        registerGroup(List.of(JUNGLE_BAT, JUNGLE_DRAMCRYX),
                lootingPool(ItemRegistry.jungle_shards.get(), 0, 2));

        registerLoot(JUNGLE_SPIDER,
                lootingPool(ItemRegistry.jungle_shards.get(), 0, 1),
                lootingPool(ItemRegistry.jungle_shards.get(), 0, 2),      // two shard pools; intentional?
                stringPool(),
                spiderEyePool());

        registerLoot(KING_CRAB,
                lootingPool(ItemRegistry.crab_claw.get(), 0, 1),
                lootingPool(ItemRegistry.aquatic_pellets.get(), 0, 3));

        registerLoot(KOBBLIN,
                lootingPool(ItemRegistry.terran_shards.get(), 0, 2));

        registerLoot(LIOPLEURODON,
                // Skull 25% chance (+30 percentage points per Looting level), without requiring player kill credit
                pool(lootItem(ItemRegistry.liopleurodon_skull.get())).when(lootingChance(0.25F, 0.3F)),
                lootingPool(ItemRegistry.liopleurodon_teeth.get(), 0, 2));

        registerLoot(MINER,
                lootingPool(Items.ROTTEN_FLESH, 0, 2),
                // Rare reward a 2.5% chance (+1 percentage point per level) to select ONE of five entries
                playerKillPool(
                        lootItem(Items.POISONOUS_POTATO),
                        lootItem(Items.GOLD_INGOT),
                        lootItem(Items.IRON_INGOT),
                        lootItem(Items.DIAMOND),
                        lootItem(Items.TORCH, 4, 16))
                        .when(lootingChance(0.025F, 0.01F)));

        registerLoot(PUMPKIN_SPIDER,
                lootingPool(ItemRegistry.terran_shards.get(), 0, 2),
                pool(lootItem(Items.PUMPKIN)),
                stringPool(),
                spiderEyePool());

        registerLoot(RAINBOUR,
                playerKillPool(lootItem(ItemRegistry.healing_stone.get())),
                rarePool(ItemRegistry.color_template.get(), 0.005F, 0.001F));

        // No Looting the 0–2 count does not depend on the enchantment
        registerLoot(ROTATICK,
                playerKillPool(lootItem(Items.DIAMOND, 0, 2)));

        registerLoot(SAGUARO_WORM,
                lootingPool(ItemRegistry.terran_shards.get(), 0, 2),
                pool(lootItem(Items.CACTUS, 3, 5)));

        registerLoot(SHARK,
                lootingPool(ItemRegistry.shark_fin.get(), 1, 3));

        registerLoot(THE_EYE,
                playerLootingPool(Items.ECHO_SHARD, 0, 2),
                rarePool(ItemRegistry.rupee_ingot.get(), 0.125F, 0.02F));

        registerLoot(THE_GRUE,
                // Shards have a 70% base chance, without requiring player kill credit
                pool(lootingItem(ItemRegistry.corrupted_shards.get(), 2, 4)).when(lootingChance(0.7F, 0.02F)),
                rarePool(ItemRegistry.arlemite_ingot.get(), 0.125F, 0.02F));

        registerLoot(WHALE,
                lootingPool(ItemRegistry.whale_fin.get(), 1, 3));
    }

    // Vethea
    // Most mobs drop one of four pearl tiers when the death
    // is credited to a player.
    private void registerVetheaTables() {
        // Shared builders: used by several mobs; do not modify after creation.
        LootPool.Builder dirtyPearl    = playerLootingPool(ItemRegistry.dirty_pearls.get());
        LootPool.Builder cleanPearl    = playerLootingPool(ItemRegistry.clean_pearls.get());
        LootPool.Builder polishedPearl = playerLootingPool(ItemRegistry.polished_pearls.get());
        LootPool.Builder shinyPearl    = playerLootingPool(ItemRegistry.shiny_pearls.get());

        // The only Vethea mob with a second pool: acid does not require player kill credit
        registerLoot(ACID_HAG, dirtyPearl, lootingPool(ItemRegistry.acid.get(), 1, 3));

        registerGroup(List.of(CYMESOID, DREAMWRECKER, DUO, ENT, HIVE_SOLDIER, HOVER_STINGER, LORGA, SHADAHIER),
                dirtyPearl);
        registerGroup(List.of(BIPHRON, GORGOSION, INSECT_FOURTEEN, MANDRAGORA, TWINS, VERMENOUS),
                cleanPearl);
        registerGroup(List.of(BOHEMITE, GALROID, KAZROTIC, LHEIVA, LORGA_FLIGHT, TOCAXIN),
                polishedPearl);
        registerGroup(List.of(DISSIMENT, HELIO, VHRAAK, ZONE, ZORAGON),
                shinyPearl);
    }

    // Skythern
    private void registerSkythernTables() {
        registerGroup(List.of(ADVANCED_CORI, MYSTIC, SAMEK, SKYTHERN_ARCHER, SKYTHERN_FIEND, SKYTHERN_GOLEM),
                lootingPool(ItemRegistry.skythern_soul.get(), 0, 2));

        registerLoot(MEGALITH,
                lootingPool(ItemRegistry.skythern_soul.get(), 0, 1),
                playerKillPool(lootingItem(ItemRegistry.sky_plant_seeds.get(), 0, 2)).when(lootingChance(0.5F, 0.03F)));
    }

    // Iceika
    private void registerIceikaTables() {
        // Shared ice-shard builders: used by several mobs; do not modify after creation
        LootPool.Builder iceShards2 = lootingPool(ItemRegistry.ice_shards.get(), 0, 2);
        LootPool.Builder iceShards3 = lootingPool(ItemRegistry.ice_shards.get(), 0, 3);

        registerGroup(List.of(ALICANTO, PALE_ARCHER), iceShards2);

        registerLoot(BLUBBERTUSK,
                lootingPool(Items.LEATHER, 0, 2),
                lootingPool(ItemRegistry.blubber.get(), 1, 2),
                lootingPool(Items.BONE, 0, 2));

        registerLoot(CAULDRON_FISH,
                pool(lootItem(ItemRegistry.cauldron_flesh.get())),
                boneMealPool(0.05F));

        // One pool: each roll selects either feathers OR bones
        registerLoot(DOLOSSAL,
                pool(lootingItem(Items.FEATHER, 0, 2), lootingItem(Items.BONE, 0, 2)));

        registerLoot(FRACTITE,
                iceShards2,
                iceShards3,
                // TODO: Verify the 0.16 increase with a base chance of 0.13.
                playerKillPool(lootItem(ItemRegistry.ice_stone.get(), 1, 2)).when(lootingChance(0.13F, 0.16F)));

        registerLoot(FROZEN_FLESH,
                iceShards3,
                // One roll: snowballs (weight 9) OR peppermints (weight 1); usually snowballs
                playerKillPool(
                        lootItem(Items.SNOWBALL, 1, 3).setWeight(9),
                        lootingItem(ItemRegistry.peppermints.get(), 0, 2)));

        registerGroup(List.of(GLACIDE, HASTREUS), iceShards2, iceShards3);

        registerLoot(MAMOTH,
                playerLootingPool(BlockRegistry.fancyWool.get(), 1, 2),
                lootingPool(Items.BONE, 0, 4));

        registerLoot(ROBBIN,
                pool(lootItem(Items.FEATHER, 0, 1)));

        registerLoot(ROLLUM,
                iceShards2,
                iceShards3,
                playerKillPool(lootingItem(ItemRegistry.oxdrite_nugget.get(), 0, 3)).when(lootingChance(0.35F, 0.05F)));

        registerLoot(SABEAR,
                lootingPool(ItemRegistry.sabear_fur.get(), 0, 2),
                pool(lootItem(ItemRegistry.sabear_tooth.get(), 1, 2)).when(lootingChance(0.85F, 0.02F)));

        registerLoot(SENG,
                lootingPool(ItemRegistry.seng_fur.get(), 0, 2),
                // Function order matters: count first, then smelting, then the Looting bonus
                pool(lootItem(ItemRegistry.raw_seng_meat.get(), 1, 3).apply(smelt()).apply(lootingBonus())));

        registerLoot(WOLPERTINGER,
                lootingPool(Items.RABBIT_HIDE, 0, 1),
                pool(lootItem(ItemRegistry.raw_wolpertinger_meat.get(), 1, 2).apply(smelt()).apply(lootingBonus())),
                rarePool(Items.RABBIT_FOOT, 0.1F, 0.03F));
    }

    // Nether
    private void registerNetherTables() {
        registerLoot(HELL_PIG,
                lootingPool(Items.PORKCHOP, 1, 3));

        registerLoot(HELL_SPIDER,
                lootingPool(ItemRegistry.molten_shards.get(), 0, 1),
                // TODO: Verify the 0.42 increase with a base chance of 0.4.
                pool(lootItem(Items.NETHERRACK, 2, 5)).when(lootingChance(0.4F, 0.02F)),
                stringPool(),
                spiderEyePool());

        registerLoot(SCORCHER,
                playerLootingPool(ItemRegistry.purple_blaze.get(), 0, 1));

        registerLoot(WILDFIRE,
                lootingPool(ItemRegistry.molten_shards.get(), 1, 4),
                playerKillPool(lootingItem(ItemRegistry.torridite_nugget.get(), 0, 3)).when(lootingChance(0.35F, 0.05F)));
    }

    // End
    private void registerEndTables() {
        registerLoot(ENDER_SCROUNGE,
                pool(lootItem(ItemRegistry.ender_shards.get(), 0, 1)),
                // A ~24.5% base chance to select ONE item: ender pearl (weight 25), amethyst (8), or iron nugget (1)
                playerKillPool(
                        lootItem(Items.ENDER_PEARL).setWeight(25),
                        lootItem(Items.AMETHYST_SHARD).setWeight(8),
                        lootItem(Items.IRON_NUGGET))
                        .when(lootingChance(0.245F, 0.02F)));

        registerLoot(ENDER_SPIDER,
                pool(lootItem(ItemRegistry.ender_shards.get())),
                stringPool(),
                spiderEyePool(),
                // Watching eye: requires player kill credit and a 25% chance (entry condition),
                // and only drops in the End (pool condition)
                playerKillPool(lootItem(ItemRegistry.watching_eye.get()).when(LootItemRandomChanceCondition.randomChance(0.25F)))
                        .when(inDimension(Level.END)));

        registerLoot(ENDER_TRIPLETS,
                lootingPool(ItemRegistry.ender_shards.get(), 0, 6),
                lootingPool(Items.ENDER_EYE, 0, 3));

        registerLoot(ENDER_WATCHER,
                lootingPool(ItemRegistry.ender_shards.get(), 0, 2),
                playerKillPool(lootItem(ItemRegistry.watching_eye.get(), 0, 1)));
    }


    // Arcana
    private void registerArcanaTables() {
        // Shared builder: used by several mobs; do not modify after creation.
        LootPool.Builder fragments = lootingPool(ItemRegistry.collector_fragments.get(), 0, 2);

        registerGroup(List.of(DEATHCRYX, DEATH_HOUND, DUNGEON_DEMON, DUNGEON_PRISONER, LIVING_STATUE, ROAMER),
                fragments);

        registerLoot(RAZORBACK,
                fragments,
                rarePool(Items.AMETHYST_SHARD, 0.045F, 0.02F));

        // One roll selects one of four keys.
        registerLoot(DUNGEON_CONSTRUCTOR,
                pool(lootItem(ItemRegistry.ancient_key.get()),
                        lootItem(ItemRegistry.degraded_key.get()),
                        lootItem(ItemRegistry.sludge_key.get()),
                        lootItem(ItemRegistry.soul_key.get())));
    }

    // Eden
    private void registerEdenTables() {
        registerGroup(List.of(EDEN_CADILLION, SUN_ARCHER),
                lootingPool(ItemRegistry.eden_soul.get(), 0, 1),
                empoweredMeat());

        registerLoot(EDEN_TOMO,
                // Soul 50% chance (+2 percentage points per level), without requiring player kill credit
                pool(lootingItem(ItemRegistry.eden_soul.get())).when(lootingChance(0.5F, 0.02F)),
                empoweredMeat(),
                playerKillPool(lootItem(Items.GOLD_INGOT, 1, 3)).when(lootingChance(0.33F, 0.02F)));

        registerLoot(GEM_FIN,
                boneMealPool(0.05F));

        registerLoot(GLINTHOP,
                pool(lootingItem(ItemRegistry.eden_soul.get())).when(lootingChance(0.5F, 0.03F)));

        registerGroup(List.of(GREENFEET, WEAK_CORI),
                lootingPool(ItemRegistry.eden_soul.get(), 0, 2));

        registerLoot(MADIVEL,
                lootingPool(ItemRegistry.eden_soul.get(), 0, 2),
                empoweredMeat());
    }

    // Wildwood
    private void registerWildwoodTables() {
        registerGroup(List.of(BEHEMOTH, MAGE, VEREK, WILDWOOD_TOMO),
                lootingPool(ItemRegistry.wildwood_soul.get(), 0, 2),
                magicMeat());

        registerLoot(EPIPHITE,
                // TODO: Verify the 0.52 increase with a base value of 0.5
                pool(lootingItem(ItemRegistry.wildwood_soul.get())).when(lootingChance(0.5F, 0.02F)),
                magicMeat());

        registerLoot(TERMID,
                lootingPool(ItemRegistry.wildwood_soul.get(), 0, 2),
                pool(lootItem(BlockRegistry.wildwoodLog.get(), 0, 4)));

        registerLoot(WILDWOOD_CADILLION,
                lootingPool(ItemRegistry.wildwood_soul.get(), 0, 1),
                magicMeat());

        registerLoot(WILDWOOD_GOLEM,
                lootingPool(ItemRegistry.wildwood_soul.get(), 1, 3),
                magicMeat(),
                playerKillPool(lootingItem(ItemRegistry.moonbulb_seeds.get(), 1, 3)).when(lootingChance(0.5F, 0.03F)));
    }

    // Apalachia
    private void registerApalachiaTables() {
        registerLoot(APALACHIA_CADILLION,
                lootingPool(ItemRegistry.apalachia_soul.get(), 0, 1),
                enrichedMeat());

        registerLoot(APALACHIA_GOLEM,
                lootingPool(ItemRegistry.apalachia_soul.get(), 1, 3),
                enrichedMeat(),
                // purple or pink seeds
                playerKillPool(
                        lootingItem(ItemRegistry.purple_glowbone_seeds.get(), 1, 3),
                        lootingItem(ItemRegistry.pink_glowbone_seeds.get(), 1, 3))
                        .when(lootingChance(0.5F, 0.03F)));

        registerLoot(APALACHIA_TOMO,
                lootingPool(ItemRegistry.apalachia_soul.get(), 1, 2),
                enrichedMeat());

        registerLoot(ENCHANTED_ARCHER,
                lootingPool(ItemRegistry.apalachia_soul.get(), 0, 2));

        registerLoot(ENCHANTED_WARRIOR,
                lootingPool(ItemRegistry.apalachia_soul.get(), 1, 2));

        registerLoot(SPELLBINDER,
                lootingPool(ItemRegistry.apalachia_soul.get(), 0, 2),
                enrichedMeat());
    }

    //  Mortum (regular mobs)
    private void registerMortumTables() {
        registerGroup(List.of(BASILISK, DEMON_OF_DARKNESS, MORTUM_CADILLION, SORCERER, SOUL_STEALER, TWILIGHT_ARCHER),
                lootingPool(ItemRegistry.mortum_soul.get(), 0, 2));
    }

    //  Ping ghost?
    private void registerOtherTables() {
        registerLoot(PINK_GHOST_GLIDER,
                boneMealPool(0.2F).setBonusRolls(ContextFloatProviders.exactly(1)));
    }

    // Bosses
    /**
     * Template mortum boss
     *
     * @param boss        boss type
     * @param statueBlock statue
     * @param prizes      reward entries; one of them will appear in one draw
     */
    private void mortumBoss(Supplier<? extends EntityType<?>> boss, ItemLike statueBlock,
                            LootPoolEntryContainer.Builder<?>... prizes) {
        registerLoot(boss,
                lootingPool(ItemRegistry.mortum_heart.get()),
                playerKillPool(prizes),
                statue(statueBlock));
    }

    private void registerBossTables() {
        // Mortum bosses
        mortumBoss(DENSOS, BlockRegistry.densosStatue.get(),
                lootItem(ItemRegistry.HALITE_CHESTPLATE.get()));
        mortumBoss(KAROT, BlockRegistry.karotStatue.get(),
                lootItem(ItemRegistry.halite_shickaxe.get()),
                lootItem(ItemRegistry.halite_phaser.get()));
        mortumBoss(REYVOR, BlockRegistry.reyvorStatue.get(),
                lootItem(ItemRegistry.HALITE_LEGGINGS.get()));

        mortumBoss(SOUL_FIEND, BlockRegistry.soulFiendStatue.get(),
                lootItem(ItemRegistry.halite_slicer.get(), 200),
                lootItem(ItemRegistry.halite_blitz.get()));
        mortumBoss(TWILIGHT_DEMON, BlockRegistry.twilightDemonStatue.get(),
                lootItem(ItemRegistry.HALITE_BOOTS.get()),
                lootItem(ItemRegistry.HALITE_HELMET.get()));
        mortumBoss(VAMACHERON, BlockRegistry.vamacheronStatue.get(),
                lootItem(ItemRegistry.halite_blade.get()));

        // Bosses unique loot
        registerLoot(ANCIENT_ENTITY,
                lootingPool(ItemRegistry.divine_shards.get(), 3, 6),
                playerKillPool(lootItem(ItemRegistry.sandslash.get())),
                statue(BlockRegistry.ancientEntityStatue.get()));

        registerLoot(AYERACO,
                lootingPool(ItemRegistry.divine_shards.get(), 1, 3),
                rarePool(ItemRegistry.ender_sword.get(), 0.01F, 0.03F),
                statue(BlockRegistry.ayeracoStatue.get()));

        registerLoot(DRAMIX,
                playerLootingPool(ItemRegistry.dungeon_tokens.get(), 3, 5),
                statue(BlockRegistry.dramixStatue.get()));

        registerLoot(ETERNAL_ARCHER,
                lootingPool(ItemRegistry.apalachia_heart.get()),
                playerLootingPool(ItemRegistry.apalachia_fragments.get(), 0, 4),
                playerKillPool(lootItem(ItemRegistry.halite_bow.get())),
                statue(BlockRegistry.eternalArcherStatue.get()));

        registerLoot(EXPERIENCED_CORI,
                lootingPool(ItemRegistry.skythern_heart.get()),
                playerLootingPool(ItemRegistry.skythern_fragments.get(), 0, 4),
                // blitz OR shield
                playerKillPool(lootItem(ItemRegistry.skythern_blitz.get()).setWeight(9),
                        lootItem(ItemRegistry.halite_shield.get())),
                statue(BlockRegistry.experiencedCoriStatue.get()));

        registerLoot(HIVE_QUEEN,
                lootingPool(ItemRegistry.cermile_lump.get(), 17, 22),
                playerLootingPool(ItemRegistry.honeychunk.get(), 10, 15),
                playerLootingPool(ItemRegistry.honeysuckle.get(), 15, 20));

        registerLoot(KAROS,
                lootingPool(ItemRegistry.karos_lump.get(), 20, 25),
                playerLootingPool(ItemRegistry.rock_chunks.get(), 2, 3));

        registerLoot(KING_OF_SCORCHERS,
                playerLootingPool(ItemRegistry.fury_fire.get()),
                playerKillPool(lootItem(ItemRegistry.soulfire_stone.get(), 6)),
                statue(BlockRegistry.kingOfScorchersStatue.get()));

        registerLoot(KITRA,
                pool(lootItem(Items.BONE_BLOCK, 16, 24)),
                playerKillPool(lootItem(ItemRegistry.sound_of_whales.get()),
                        lootItem(ItemRegistry.icicle_dagger.get())),
                statue(BlockRegistry.kitraStatue.get()));

        // Ever loot
        registerLoot(LADY_LUNA,
                playerKillPool(lootItem(ItemRegistry.everbright.get()),
                        lootItem(ItemRegistry.everfright.get()),
                        lootItem(ItemRegistry.evernight.get()),
                        lootItem(ItemRegistry.everlight.get()),
                        lootItem(ItemRegistry.eversight.get())));

        registerLoot(PARASECTA,
                playerLootingPool(ItemRegistry.dungeon_tokens.get(), 6, 8),
                statue(BlockRegistry.parasectaStatue.get()));

        registerLoot(QUADRO,
                lootingPool(ItemRegistry.quadrotic_lump.get(), 20, 25));

        registerLoot(RAGLOK,
                lootingPool(ItemRegistry.heliosis_lump.get(), 20, 25));

        registerLoot(SUNSTORM,
                lootingPool(ItemRegistry.eden_heart.get()),
                playerLootingPool(ItemRegistry.eden_fragments.get(), 3, 6),
                playerKillPool(lootItem(ItemRegistry.eden_blitz.get())),
                statue(BlockRegistry.sunstormStatue.get()));

        registerLoot(TERMASECT,
                lootingPool(ItemRegistry.wildwood_heart.get()),
                playerLootingPool(ItemRegistry.wildwood_fragments.get(), 0, 4),
                pool(lootItem(BlockRegistry.wildwoodLog.get(), 64, 100)),
                playerKillPool(lootItem(ItemRegistry.wildwood_blitz.get())),
                statue(BlockRegistry.termasectStatue.get()));

        registerLoot(THE_WATCHER,
                lootingPool(ItemRegistry.divine_shards.get(), 3, 6),
                playerKillPool(lootItem(ItemRegistry.torridite_ingot.get(), 100)),
                playerKillPool(lootItem(ItemRegistry.soulfire_stone.get())),
                statue(BlockRegistry.theWatcherStatue.get()));

        registerLoot(WRECK,
                lootingPool(ItemRegistry.arksiane_lump.get(), 20, 25),
                playerKillPool(wreckPotion()).when(lootingChance(0.5F, 0.04F)));
    }

    @Override
    public void generate() {
        for (EntityType<?> entityType : getKnownEntityTypes().toList()) {
            add(entityType, lootTableMap.getOrDefault(entityType, LootTable.lootTable()));
        }
    }

    @Override
    protected @NotNull Stream<EntityType<?>> getKnownEntityTypes() {
        return DivineRegistries.ENTITIES.getEntries().stream().map(entry -> (EntityType<?>) entry.get());
    }
}
