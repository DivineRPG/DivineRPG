package divinerpg.registries;

import divinerpg.entities.base.EntityDivineMerchant.*;
import divinerpg.recipe.*;
import divinerpg.recipe.brewing.*;
import net.minecraft.core.registries.*;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.*;
import net.minecraft.world.item.alchemy.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.saveddata.maps.MapDecorationTypes;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.registries.*;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.ItemRegistry.*;
import static divinerpg.registries.BlockRegistry.*;

public class RecipeRegistry {
    public static class Types {
        public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, MODID);

        public static final DeferredHolder<RecipeType<?>, RecipeType<ArcaniumExtractorRecipe>> ARCANIUM_EXTRACTOR_RECIPE_TYPE = RECIPE_TYPES.register("arcanium_extractor", () -> ArcaniumExtractorRecipe.TYPE);
        public static final DeferredHolder<RecipeType<?>, RecipeType<InfusionTableRecipe>> INFUSION_TABLE_RECIPE_TYPE = RECIPE_TYPES.register("infusion_table", () -> InfusionTableRecipe.TYPE);
        public static final DeferredHolder<RecipeType<?>, RecipeType<MaulSmashingRecipe>> MAUL_SMASHING = RECIPE_TYPES.register("maul_smashing", () -> MaulSmashingRecipe.TYPE);
        public static final DeferredHolder<RecipeType<?>, RecipeType<FireConversionRecipe>> FIRE_CONVERSION = RECIPE_TYPES.register("fire_conversion", () -> FireConversionRecipe.TYPE);
    }
    public static class Serializers {
        public static final DeferredRegister<RecipeSerializer<?>> SERIALIZER = DeferredRegister.create(Registries.RECIPE_SERIALIZER, MODID);
        //TODO: Unknown recipe category 'divinerpg:arcanium_extractor/divinerpg:extracting/arcanium', etc.
        public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ArcaniumExtractorRecipe>> ARCANIUM_EXTRACTOR_SERIALIZER = SERIALIZER.register("arcanium_extractor", () -> new SimpleCookingSerializer<>(ArcaniumExtractorRecipe::new, 100));
        public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<InfusionTableRecipe>> INFUSION_TABLE_SERIALIZER = SERIALIZER.register("infusion_table", InfusionTableRecipe.Serializer::new);
        public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<MaulSmashingRecipe>> MAUL_SMASHING_SERIALIZER = SERIALIZER.register("maul_smashing", MaulSmashingRecipe.Serializer::new);
        public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<FireConversionRecipe>> FIRE_CONVERSION_SERIALIZER = SERIALIZER.register("fire_conversion", FireConversionRecipe.Serializer::new);
    }
    @SubscribeEvent
    public void registerBrewingRecipes(RegisterBrewingRecipesEvent e) {
        e.getBuilder().addRecipe(new PotionOfWarmthRecipe());
        e.getBuilder().addRecipe(new PotionOfLongWarmthRecipe());
        e.getBuilder().addRecipe(new TeaRecipe());
        e.getBuilder().addRecipe(new GrogRecipe());
    }
    public static class Trades {
        @FunctionalInterface
        public interface TradeGetter {DivineTrades[] get(Level level, RandomSource random);}
        //TODO: to make trade costs vary (and increase when NPCs are hit) + more trades appear if you keep trading
        public static final TradeGetter
            LIVESTOCK_MERCHANT = (level, random) -> new DivineTrades[] {
                new DivineTrades(divineLog.toStack(16), shadow_coins.toStack(4), ehu_egg.toStack(2), random.nextInt(7), 5),
                new DivineTrades(divineLog.toStack(64), shadow_coins.toStack(7), husk_egg.toStack(2), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Blocks.STONE, 64), shadow_coins.toStack(3), stone_golem_egg.toStack(), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Blocks.NETHER_BRICKS, 32), shadow_coins.toStack(5), smelter_egg.toStack(), random.nextInt(7), 5),
                new DivineTrades(jungle_stone.toStack(2), shadow_coins.toStack(4), snapper_egg.toStack(3), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Items.LEATHER, 10), shadow_coins.toStack(8), white_grizzle_egg.toStack(2), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Items.LEATHER, 10), shadow_coins.toStack(8), brown_grizzle_egg.toStack(2), random.nextInt(7), 5)
            },
            //TODO: to make them trade armor pieces of the same type + scythe at all times (instead of random items)
            JACK_O_MAN = (level, random) -> new DivineTrades[] {
                new DivineTrades(new ItemStack(Items.BONE, 15), new ItemStack(Items.SPIDER_EYE, 5), skeleman_helmet.toStack(), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Items.BONE, 20), new ItemStack(Items.SPIDER_EYE, 10), skeleman_chestplate.toStack(), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Items.BONE, 20), new ItemStack(Items.SPIDER_EYE, 10), skeleman_leggings.toStack(), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Items.BONE, 15), new ItemStack(Items.SPIDER_EYE, 5), skeleman_boots.toStack(), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Blocks.PUMPKIN, 10), new ItemStack(Items.ENDER_PEARL, 1), jack_o_man_helmet.toStack(), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Blocks.PUMPKIN, 15), new ItemStack(Items.ENDER_PEARL, 2), jack_o_man_chestplate.toStack(), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Blocks.PUMPKIN, 15), new ItemStack(Items.ENDER_PEARL, 2), jack_o_man_leggings.toStack(), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Blocks.PUMPKIN, 10), new ItemStack(Items.ENDER_PEARL, 1), jack_o_man_boots.toStack(), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Items.WITHER_SKELETON_SKULL, 1), wither_reaper_helmet.toStack(), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Items.WITHER_SKELETON_SKULL, 1), wither_reaper_chestplate.toStack(), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Items.WITHER_SKELETON_SKULL, 1), wither_reaper_leggings.toStack(), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Items.WITHER_SKELETON_SKULL, 1), wither_reaper_boots.toStack(), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Items.BONE, 25), new ItemStack(Items.ENDER_PEARL, 4), scythe.toStack(), random.nextInt(7), 5)
            },
            DIAMOND_DAVE = (level, random) -> new DivineTrades[] {
                new DivineTrades(new ItemStack(Items.DIAMOND, 16 + random.nextInt(8)), level == null || random.nextBoolean() ? realmite_pickaxe.toStack() : EnchantmentHelper.enchantItem(random, realmite_pickaxe.toStack(), random.nextInt(30), level.registryAccess(), level.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.ON_TRADED_EQUIPMENT)), random.nextInt(3), 5),
                new DivineTrades(new ItemStack(Items.COAL, 8 + random.nextInt(2)), new ItemStack(Items.TORCH, 16), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Items.RAW_IRON, 4), new ItemStack(Items.GLOW_BERRIES, 2 + random.nextInt(14)), random.nextInt(7), 5),
                new DivineTrades(new ItemStack(Blocks.DEEPSLATE, 32 + random.nextInt(32)), new ItemStack(Items.ARROW, 16), random.nextInt(3), 5),
                new DivineTrades(new ItemStack(random.nextBoolean() ? Items.DIAMOND : Items.EMERALD, 8 + random.nextInt(2)), PotionContents.createItemStack(Items.POTION, Potions.NIGHT_VISION), random.nextInt(2), 5),
                new DivineTrades(new ItemStack(Items.COAL, 4 + random.nextInt(12)), divineLog.toStack(4 + random.nextInt(12)), random.nextInt(3), 5)
            },
            WORKSHOP_MERCHANT = (level, random) -> new DivineTrades[]{
                new DivineTrades(snowflake.toStack(6), seng_fur_helmet.toStack(), random.nextInt(7), 5),
                new DivineTrades(snowflake.toStack(6), seng_fur_chestplate.toStack(), random.nextInt(7), 5),
                new DivineTrades(snowflake.toStack(6), seng_fur_leggings.toStack(), random.nextInt(7), 5),
                new DivineTrades(snowflake.toStack(6), seng_fur_boots.toStack(), random.nextInt(7), 5),
                new DivineTrades(ice_stone.toStack(3), egg_nog.toStack(), random.nextInt(7), 5),
                new DivineTrades(ice_stone.toStack(3), chocolate_log.toStack(5), random.nextInt(7), 5),
                new DivineTrades(ice_stone.toStack(3), peppermints.toStack(16), random.nextInt(7), 5),
                new DivineTrades(ice_stone.toStack(3), fruit_cake.toStack(3), random.nextInt(7), 5),
                new DivineTrades(snowflake.toStack(20), icicle_bane.toStack(), random.nextInt(7), 5),
                new DivineTrades(ice_stone.toStack(3), greenFairyLights.toStack(16), random.nextInt(7), 5),
                new DivineTrades(ice_stone.toStack(3), redFairyLights.toStack(16), random.nextInt(7), 5),
                new DivineTrades(ice_stone.toStack(3), blueFairyLights.toStack(16), random.nextInt(7), 5),
                new DivineTrades(ice_stone.toStack(3), yellowFairyLights.toStack(16), random.nextInt(7), 5),
                new DivineTrades(ice_stone.toStack(3), purpleFairyLights.toStack(16), random.nextInt(7), 5),
                new DivineTrades(ice_stone.toStack(9), presentBox.toStack(), random.nextInt(7), 5),
                new DivineTrades(ice_stone.toStack(3), blueCandyCane.toStack(4), random.nextInt(7), 5),
                new DivineTrades(ice_stone.toStack(3), greenCandyCane.toStack(4), random.nextInt(7), 5),
                new DivineTrades(ice_stone.toStack(3), pinkCandyCane.toStack(4), random.nextInt(7), 5),
                new DivineTrades(ice_stone.toStack(3), redCandyCane.toStack(4), random.nextInt(7), 5),
                new DivineTrades(ice_stone.toStack(3), yellowCandyCane.toStack(4), random.nextInt(7), 5)
            },
            WORKSHOP_TINKERER = (level, random) -> new DivineTrades[]{
                new DivineTrades(snowflake.toStack(), shuriken.toStack(16), snowflake_shuriken.toStack(16), random.nextInt(7), 5),
                new DivineTrades(snowflake.toStack(4), serenade_striker.toStack(), serenade_of_ice.toStack(), random.nextInt(7), 5),
                new DivineTrades(snowflake.toStack(7), slime_sword.toStack(), glacier_sword.toStack(), random.nextInt(7), 5),
                //TODO: redundant trade
                new DivineTrades(snowflake.toStack(12), shadow_bow.toStack(), icicle_bow.toStack(), random.nextInt(7), 5),
                new DivineTrades(snowflake.toStack(6), massivence.toStack(), frossivence.toStack(), random.nextInt(7), 5),
                new DivineTrades(snowflake.toStack(12), crabclaw_cannon.toStack(), frostclaw_cannon.toStack(), random.nextInt(7), 5),
                new DivineTrades(snowflake.toStack(12), frost_cannon.toStack(), fractite_cannon.toStack(), random.nextInt(7), 5),
                new DivineTrades(snowflake.toStack(15), frost_sword.toStack(), frostking_sword.toStack(), random.nextInt(7), 5),
                new DivineTrades(snowflake.toStack(18), sound_of_music.toStack(), sound_of_carols.toStack(), random.nextInt(7), 5),
                new DivineTrades(snowflake.toStack(25), ender_sword.toStack(), enderice.toStack(), random.nextInt(7), 5),
                new DivineTrades(snowflake.toStack(30), soulfire_bow.toStack(), snowstorm_bow.toStack(), random.nextInt(7), 5),
                new DivineTrades(snowflake.toStack(45), bedrock_maul.toStack(), frozen_maul.toStack(), random.nextInt(7), 5),
                new DivineTrades(snowflake.toStack(40), divine_sword.toStack(), icine_sword.toStack(), random.nextInt(7), 5),
                new DivineTrades(snowflake.toStack(15), sandslash.toStack(), snowslash.toStack(), random.nextInt(7), 5)
            },
            GROGLIN_CHIEFTAIN = (level, random) -> new DivineTrades[]{
                new DivineTrades(olivine.toStack(5), frostPumpkin.toStack(), random.nextInt(7), 3),
                new DivineTrades(olivine.toStack(25), seng_fur.toStack(), random.nextInt(7), 5),
                new DivineTrades(olivine.toStack(7), PotionContents.createItemStack(Items.POTION, PotionRegistry.GROG), random.nextInt(7), 2),
                new DivineMapTrades(olivine.toStack(20), raw_wolpertinger_meat.toStack(5), "filled_map.groglin_raid_target", TagRegistry.RAID_TARGETS, MapDecorationTypes.TARGET_X, 15),
                new DivineTrades(olivine.toStack(), ice_stone.toStack(2), random.nextInt(7), 1),
                new DivineTrades(olivine.toStack(10), raw_wolpertinger_meat.toStack(2), sabear_sabre.toStack(), random.nextInt(7), 8)
            },
            GROGLIN_HUNTER = (level, random) -> new DivineTrades[]{
                new DivineTrades(olivine.toStack(24), seng_fur.toStack(), random.nextInt(7), 5),
                new DivineTrades(olivine.toStack(12), raw_seng_meat.toStack(2), random.nextInt(7), 5),
                new DivineTrades(olivine.toStack(6), raw_wolpertinger_meat.toStack(5), random.nextInt(7), 5),
                new DivineTrades(olivine.toStack(10), cauldron_flesh.toStack(5), random.nextInt(7), 1),
                new DivineTrades(olivine.toStack(), ice_stone.toStack(3), random.nextInt(7), 1)
            },
            GROGLIN_MERCHANT = (level, random) -> new DivineTrades[]{
                new DivineTrades(olivine.toStack(20), iceLamp.toStack(), random.nextInt(7), 5),
                new DivineTrades(olivine.toStack(3), winterberry.toStack(), random.nextInt(7), 5),
                new DivineTrades(olivine.toStack(5), PotionContents.createItemStack(Items.POTION, PotionRegistry.TEA), random.nextInt(7), 5),
                new DivineTrades(olivine.toStack(64), olivine.toStack(64), glacial_wall_totem.toStack(), random.nextInt(7), 25),
                new DivineTrades(olivine.toStack(15), raw_wolpertinger_meat.toStack(), armor_pouch.toStack(), random.nextInt(7), 5)
            },
            GROGLIN_RANGER = (level, random) -> new DivineTrades[]{
                new DivineTrades(olivine.toStack(3), glaconPumpkin.toStack(2), random.nextInt(7), 1),
                new DivineTrades(olivine.toStack(5), robbin_egg.toStack(), random.nextInt(7), 5),
                new DivineTrades(PotionContents.createItemStack(Items.POTION, PotionRegistry.GROG), olivine.toStack(), random.nextInt(7), 1),
                new DivineTrades(raw_wolpertinger_meat.toStack(10), olivine.toStack(), random.nextInt(7), 1),
                new DivineTrades(olivine.toStack(), ice_stone.toStack(2), random.nextInt(7), 1)
            },
            GROGLIN_SHARLATAN = (level, random) -> new DivineTrades[]{
                new DivineTrades(olivine.toStack(6), PotionContents.createItemStack(Items.POTION, PotionRegistry.GROG), random.nextInt(7), 2),
                new DivineTrades(olivine.toStack(4), PotionContents.createItemStack(Items.POTION, PotionRegistry.TEA), random.nextInt(7), 2),
                new DivineTrades(olivine.toStack(15), PotionContents.createItemStack(Items.POTION, PotionRegistry.LONG_WARMTH), random.nextInt(7), 2),
                new DivineMapTrades(olivine.toStack(25), raw_wolpertinger_meat.toStack(5), "filled_map.whale_skull", TagRegistry.WHALE_SKULL, MapDecorationTypes.OCEAN_MONUMENT, 25),
                new DivineTrades(olivine.toStack(16), raw_wolpertinger_meat.toStack(4), frostedAllure.toStack(), random.nextInt(7), 8)
            },
            GROGLIN_WARRIOR = (level, random) ->  new DivineTrades[]{
                new DivineTrades(olivine.toStack(12), snowBricks.toStack(8), random.nextInt(7), 1),
                new DivineTrades(olivine.toStack(14), raw_seng_meat.toStack(2), random.nextInt(7), 5),
                new DivineTrades(olivine.toStack(16), workshopCarpet.toStack(6), random.nextInt(7), 2),
                new DivineTrades(olivine.toStack(8), cauldron_flesh.toStack(5), random.nextInt(7), 1),
                new DivineTrades(olivine.toStack(), ice_stone.toStack(4), random.nextInt(7), 1)
            },
            GRUZZORLUG_CANNONEER = (level, random) -> new DivineTrades[]{
                new DivineTrades(olivine.toStack(10), workshopLamp.toStack(4), random.nextInt(7), 1),
                new DivineTrades(olivine.toStack(2), PotionContents.createItemStack(Items.POTION, PotionRegistry.TEA), random.nextInt(7), 1),
                new DivineTrades(olivine.toStack(18), sabear_tooth.toStack(), random.nextInt(7), 5),
                new DivineTrades(olivine.toStack(13), sabear_fur.toStack(), random.nextInt(7), 5),
                new DivineTrades(olivine.toStack(), ice_stone.toStack(2), random.nextInt(7), 1)
            },
            GRUZZORLUG_COMMANDER = (level, random) -> new DivineTrades[]{
                new DivineTrades(olivine.toStack(), ice_shards.toStack(12), random.nextInt(7), 1),
                new DivineMapTrades(olivine.toStack(25), raw_wolpertinger_meat.toStack(5), "filled_map.whale_skull", TagRegistry.WHALE_SKULL, MapDecorationTypes.OCEAN_MONUMENT, 25),
                new DivineTrades(olivine.toStack(8), icyBricks.toStack(4), random.nextInt(7), 1),
                new DivineTrades(olivine.toStack(10), icyStone.toStack(4), random.nextInt(7), 1),
                new DivineTrades(olivine.toStack(12), runicIcyBricks.toStack(4), random.nextInt(7), 1)
            },
            GRUZZORLUG_GENERAL = (level, random) -> new DivineTrades[]{
                new DivineTrades(olivine.toStack(12), workshopBookcase.toStack(3), random.nextInt(7), 3),
                new DivineMapTrades(olivine.toStack(20), raw_wolpertinger_meat.toStack(5), "filled_map.gruzzorlug_raid_target", TagRegistry.GRUZZORLUG_RAID_TARGETS, MapDecorationTypes.TARGET_X, 15),
                new DivineTrades(oxdrite_ingot.toStack(8), olivine.toStack(2), random.nextInt(7), 1),
                new DivineTrades(anthracite.toStack(16), olivine.toStack(2), random.nextInt(7), 1),
                new DivineTrades(olivine.toStack(6), ice_stone.toStack(12), random.nextInt(7), 1)
            },
            GRUZZORLUG_KNIGHT = (level, random) -> new DivineTrades[]{
                new DivineTrades(olivine.toStack(8), winterberry.toStack(), random.nextInt(7), 1),
                new DivineTrades(olivine.toStack(4), PotionContents.createItemStack(Items.POTION, PotionRegistry.TEA), random.nextInt(7), 1),
                new DivineTrades(olivine.toStack(14), raw_wolpertinger_meat.toStack(), sabear_tooth.toStack(), random.nextInt(7), 5),
                new DivineTrades(olivine.toStack(10), raw_wolpertinger_meat.toStack(), sabear_fur.toStack(), random.nextInt(7), 5),
                new DivineTrades(olivine.toStack(), ice_stone.toStack(3), random.nextInt(7), 1)
            },
            GRUZZORLUG_MINER = (level, random) -> new DivineTrades[]{
                new DivineTrades(oxdrite_pickaxe.toStack(), olivine.toStack(2), random.nextInt(7), 2),
                new DivineTrades(olivine.toStack(7), brittleMoss.toStack(), random.nextInt(7), 2),
                new DivineTrades(olivine.toStack(12), cobaltite.toStack(10), random.nextInt(7), 2),
                new DivineTrades(olivine.toStack(8), raw_oxdrite.toStack(2), random.nextInt(7), 1),
                new DivineTrades(olivine.toStack(4), anthracite.toStack(2), random.nextInt(7), 1)
            },
            GRUZZORLUG_SWORDSMAN = (level, random) -> new DivineTrades[]{
                new DivineTrades(olivine.toStack(16), sabear_tooth.toStack(), random.nextInt(7), 10),
                new DivineTrades(olivine.toStack(18), sabear_fur.toStack(), random.nextInt(7), 10),
                new DivineTrades(olivine.toStack(2), raw_wolpertinger_meat.toStack(4), random.nextInt(7), 1),
                new DivineTrades(olivine.toStack(5), PotionContents.createItemStack(Items.POTION, PotionRegistry.TEA), random.nextInt(7), 1),
                new DivineTrades(olivine.toStack(), ice_stone.toStack(4), random.nextInt(7), 1)
            },
            CAPTAIN_MERIK = (level, random) -> new DivineTrades[]{
                new DivineTrades(arcanium.toStack(), grenade.toStack(10), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(10), korma_chestplate.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(10), korma_leggings.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(12), ender_scepter.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(12), firefly.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(20), captains_sparkler.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(20), ghostbane.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(5), storm_sword.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(6), korma_boots.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(6), korma_helmet.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(6), la_vekor.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(8), arcanium_saber.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(8), shadow_saber.toStack(), random.nextInt(7), 5),
                new DivineTrades(dungeon_tokens.toStack(15), meriks_missile.toStack(), random.nextInt(7), 5),
                new DivineTrades(dungeon_tokens.toStack(30), livicia_sword.toStack(), random.nextInt(7), 5)
            },
            DATTICON = (level, random) -> new DivineTrades[]{
                new DivineTrades(arcanium.toStack(8), starBridge.toStack(16), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(8), slimeLight.toStack(16), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(2), arcaniteTubes.toStack(16), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(2), arcaniteLadder.toStack(16), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(2), moltenFurnace.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(3), greenlightFurnace.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(4), oceanfireFurnace.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(5), moonlightFurnace.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(7), whitefireFurnace.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(9), demonFurnace.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(3), elevantium.toStack(9), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(3), acceleron.toStack(3), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(), arcaniteLadder.toStack(8), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(6), korma_helmet.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(10), korma_chestplate.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(10), korma_leggings.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(6), korma_boots.toStack(), random.nextInt(7), 5)
            },
            KAZARI = (level, random) -> new DivineTrades[]{
                new DivineTrades(collector.toStack(13), ancient_key.toStack(), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(13), degraded_key.toStack(), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(13), soul_key.toStack(), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(13), sludge_key.toStack(), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(2), ancientBricksBreakable.toStack(16), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(2), ancientStoneBreakable.toStack(16), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(2), ancientTileBreakable.toStack(16), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(2), arcaniumMetalBreakable.toStack(16), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(2), arcaniumPowerBreakable.toStack(4), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(2), degradedBricksBreakable.toStack(16), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(2), dungeonLampBreakable.toStack(4), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(2), soulSludgeBreakable.toStack(16), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(2), soulStoneBreakable.toStack(16), random.nextInt(7), 5)
            },
            LEORNA = (level, random) -> new DivineTrades[]{
                new DivineTrades(arcanium.toStack(), eucalyptus_root_seeds.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(2), marsine_seeds.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(2), firestock_seeds.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(3), pinfly_seeds.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(4), aquamarine_seeds.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(5), hitchak_seeds.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(7), veilo_seeds.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(9), lamona_seeds.toStack(), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(2), arcaniteDirt.toStack(16), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(2), arcaniteGrass.toStack(16), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(6), staff_of_enrichment.toStack(), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(8), serenade_of_infusion.toStack(), random.nextInt(7), 5)
            },
            LORD_VATTICUS = (level, random) -> new DivineTrades[]{
                new DivineTrades(collector.toStack(), new ItemStack(Items.BLUE_DYE, 8), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(2), new ItemStack(Items.EXPERIENCE_BOTTLE, 12), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(2), soulSludgeBreakable.toStack(8), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(2), weak_arcana_potion.toStack(2), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(4), strong_arcana_potion.toStack(2), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(), new ItemStack(Items.BLAZE_ROD, 2), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(2), arcaniteMoss.toStack(8), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(2), wizards_book.toStack(), random.nextInt(7), 5),
                new DivineTrades(collector.toStack(3), new ItemStack(Blocks.ENCHANTING_TABLE, 1), random.nextInt(7), 5)
            },
            WAR_GENERAL = (level, random) -> new DivineTrades[]{
                new DivineTrades(arcanium.toStack(10), vemos_chestplate.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(10), vemos_leggings.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(18), arcanite_blaster.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(18), generals_staff.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(30), arcanite_blade.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(4), starlight.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(6), divine_accumulator.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(6), vemos_boots.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(6), vemos_helmet.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(7), arcanium_attractor.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(7), arcanium_reflector.toStack(), random.nextInt(7), 5),
                new DivineTrades(dungeon_tokens.toStack(17), meteor_mash.toStack(), random.nextInt(7), 5),
                new DivineTrades(dungeon_tokens.toStack(20), staff_of_starlight.toStack(), random.nextInt(7), 5)
            },
            ZELUS = (level, random) -> new DivineTrades[]{
                new DivineTrades(arcanium.toStack(2), fyracryx_egg.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(3), seimer_egg.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(3), paratiku_egg.toStack(), random.nextInt(7), 5),
                new DivineTrades(arcanium.toStack(5), golem_of_rejuvenation_egg.toStack(), random.nextInt(7), 5)
            },
            THE_HUNGER = (level, random) -> new DivineTrades[]{
                new DivineTrades(dirty_pearls.toStack(), dream_carrot.toStack(2), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(3), dream_melon.toStack(4), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(5), dream_pie.toStack(5), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(10), dream_cake.toStack(8), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(10), dream_shovel.toStack(), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(10), dream_pickaxe.toStack(), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(10), dream_axe.toStack(), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(5), barredDoor.toStack(), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(3), disk_template.toStack(), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(5), dissipator_template.toStack(), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(3), cannon_template.toStack(), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(3), backsword_template.toStack(), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(3), hammer_template.toStack(), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(3), bow_template.toStack(), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(3), staff_template.toStack(), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(3), claw_template.toStack(), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(5), degraded_template.toStack(), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(), lightDreamBricks.toStack(16), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(), darkDreamBricks.toStack(16), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(), redDreamBricks.toStack(16), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(2), dreamDirt.toStack(64), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(), smoothGlass.toStack(16), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(4), firelight.toStack(), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(4), new ItemStack(Blocks.CHEST, 1), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(2), teaker_arrow.toStack(32), random.nextInt(7), 0),
                new DivineTrades(dirty_pearls.toStack(25), mortumBlock.toStack(4), random.nextInt(5), 1),
                new DivineTrades(clean_pearls.toStack(), dream_sweets.toStack(4), random.nextInt(7), 0),
                new DivineTrades(clean_pearls.toStack(5), finished_template.toStack(), random.nextInt(7), 0),
                new DivineTrades(clean_pearls.toStack(2), darven_arrow.toStack(32), random.nextInt(7), 0),
                new DivineTrades(clean_pearls.toStack(4), pardimal_arrow.toStack(32), random.nextInt(7), 0),
                new DivineTrades(clean_pearls.toStack(6), karos_arrow.toStack(32), random.nextInt(7), 0),
                new DivineTrades(clean_pearls.toStack(15), miners_amulet.toStack(), random.nextInt(7), 0),
                new DivineTrades(polished_pearls.toStack(20), dream_flint.toStack(), random.nextInt(7), 0),
                new DivineTrades(polished_pearls.toStack(5), glistening_template.toStack(), random.nextInt(7), 0),
                new DivineTrades(polished_pearls.toStack(5), demonized_template.toStack(), random.nextInt(7), 0),
                new DivineTrades(shiny_pearls.toStack(40), moon_clock.toStack(), random.nextInt(7), 0),
                new DivineTrades(shiny_pearls.toStack(25), band_of_lheiva_hunting.toStack(), random.nextInt(7), 0),
                new DivineTrades(shiny_pearls.toStack(), dream_sours.toStack(4), random.nextInt(7), 0),
                new DivineTrades(shiny_pearls.toStack(4), ever_arrow.toStack(32), random.nextInt(7), 0),
                new DivineTrades(shiny_pearls.toStack(5), tormented_template.toStack(), random.nextInt(7), 0),
                new DivineTrades(rock_chunks.toStack(25), karos_rockmaul.toStack(), random.nextInt(7), 0),
            };
    }
}