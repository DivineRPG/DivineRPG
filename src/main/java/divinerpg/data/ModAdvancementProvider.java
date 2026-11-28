package divinerpg.data;

import divinerpg.registries.LevelRegistry;
import net.minecraft.advancements.*;
import net.minecraft.advancements.predicates.*;
import net.minecraft.advancements.predicates.entity.EntityPredicate;
import net.minecraft.advancements.triggers.*;
import net.minecraft.core.*;
import net.minecraft.core.component.DataComponentExactPredicate;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.Optional;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.blocks.arcana.HeatTrap.ACTIVE;
import static divinerpg.registries.BiomeRegistry.*;
import static divinerpg.registries.BlockRegistry.*;
import static divinerpg.registries.DataComponentRegistry.variant;
import static divinerpg.registries.EntityRegistry.*;
import static divinerpg.registries.ItemRegistry.*;
import static divinerpg.registries.LootTableRegistry.ANCIENT_TOMB;
import static divinerpg.registries.StructureRegistry.Iceika.DUNGEON;
import static divinerpg.registries.TagRegistry.Items.*;
import static divinerpg.registries.TagRegistry.BlockItems.*;
import static net.minecraft.advancements.AdvancementType.*;
import static net.minecraft.advancements.triggers.CriteriaTriggers.*;
import static net.minecraft.resources.Identifier.*;
import static net.minecraft.world.entity.EntityTypes.*;
import static net.minecraft.world.item.Items.*;

public class ModAdvancementProvider extends AdvancementSubProvider {
    public ModAdvancementProvider(BootstrapContext<Advancement> context) {
        super(context);
    }
    @SuppressWarnings("unused")
    @Override public void generate() {
        HolderGetter<Item> items = output.lookup(Registries.ITEM);
        HolderGetter<Block> blocks = output.lookup(Registries.BLOCK);
        HolderGetter<Biome> biomes = output.lookup(Registries.BIOME);
        HolderGetter<Structure> structures = output.lookup(Registries.STRUCTURE);
        HolderGetter<LootTable> lootTables = output.lookup(Registries.LOOT_TABLE);
        HolderGetter<EntityType<?>> entities = output.lookup(Registries.ENTITY_TYPE);
        AdvancementHolder
            adventureRoot = Advancement.Builder.advancement().build(withDefaultNamespace("adventure/root")),
            husbandryPlantSeed = Advancement.Builder.advancement().build(withDefaultNamespace("husbandry/plant_seed")),
            storyEnchant = Advancement.Builder.advancement().build(withDefaultNamespace("story/enchant_item")),
            netherRoot = Advancement.Builder.advancement().build(withDefaultNamespace("nether/root")),
            netherBlazeRod = Advancement.Builder.advancement().build(withDefaultNamespace("nether/obtain_blaze_rod")),
            endRoot = Advancement.Builder.advancement().build(withDefaultNamespace("end/root")),
            endKillDragon = Advancement.Builder.advancement().build(withDefaultNamespace("end/kill_dragon")),
            endElytra = Advancement.Builder.advancement().build(withDefaultNamespace("end/elytra")),
        // ADVENTURE
            badIdea = hiddenTask(adventureRoot, "adventure/bad_idea", SKELETON_SKULL, b -> b.addCriterion("open_tomb_chest", LootTableTrigger.TriggerInstance.lootTableUsed(lootTables.getOrThrow(ANCIENT_TOMB)))),
            earthbound = taskItem(adventureRoot, "adventure/earthbound", terran_shards.get(), "get_terran_shards", items),
            eyeOfEvil = taskImpossible(adventureRoot, "adventure/eye_of_evil", rupee_ingot.get(), "look_into_the_eye"),
            feedingOnTheFish = taskKill(adventureRoot, "adventure/feeding_on_the_fish", shark_fin.get(), "kill_shark", SHARK.get(), entities),
            groundDweller = taskItem(earthbound, "adventure/ground_dweller", terran_shifter.get(), "get_terran_shifter", items),
            halloweenSpirit = taskTrade(adventureRoot, "adventure/halloween_spirit", scythe.get(), "talk_to_jack_o_man", JACK_O_MAN.get(), entities),
            jungleStegosaurusSlayer = taskKill(adventureRoot, "adventure/jungle_stegosaurus_slayer", jungle_shards.get(), "kill_jungle_dramcryx", JUNGLE_DRAMCRYX.get(), entities),
            lonelyGuy = taskTrade(adventureRoot, "adventure/lonely_guy", realmite_pickaxe.get(), "trade_with_dave", DIAMOND_DAVE.get(), entities),
            makingTarzanProud = taskItem(adventureRoot, "adventure/making_tarzan_proud", jungle_hook.get(), "get_jungle_hook", items),
            theyWontBite = taskTrade(adventureRoot, "adventure/they_wont_bite", snapper_egg.get(), "trade_with_livestock_merchant", LIVESTOCK_MERCHANT.get(), entities),
            thickOfIt = baseBuilder(adventureRoot, "adventure/thick_of_it", BONE, CHALLENGE, false, false, true, b -> b.addCriterion("betrayal", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(entities, WOLF)))),
        // HUSBANDRY
            aMealToRemember = task(husbandryPlantSeed, "husbandry/a_meal_to_remember", chicken_dinner.get(), b -> b.addCriterion("eat_chicken_dinner", ConsumeItemTrigger.TriggerInstance.usedItem(ItemPredicate.Builder.item().of(items, chicken_dinner.get())))),
        // STORY
            perfectlyCorrupted = taskPlaceBlock(storyEnchant, "story/perfectly_corrupted", altarOfCorruption.get(), "in_altar", blocks),
            studyingMagic = taskPlaceBlock(storyEnchant, "story/studying_magic", infusionTable.get(), "in_extractor", blocks),
        // DIVINE
            divineRoot = Advancement.Builder.recipeAdvancement().display(new DisplayInfo(new ItemStackTemplate(rupee_shickaxe.get()), Component.translatable("advancement." + MODID + ".divine.root"), Component.translatable("advancement." + MODID + ".divine.root.desc"), Optional.of(new ClientAsset.ResourceTexture(fromNamespaceAndPath(MODID, "block/divine_rock"))), TASK, false, false, false)).addCriterion("first_world_load", PlayerTrigger.TriggerInstance.tick()).save(output, MODID + ":divine/root"),
            freezingFire = taskImpossible(divineRoot, "divine/freezing_fire", icyFire.asItem(), "create_icy_fire"),
            ninetySecondsToMidnight = Advancement.Builder.recipeAdvancement().parent(freezingFire).display(frozen_clock.get(), Component.translatable("advancement." + MODID + ".divine.90_seconds_to_midnight"), Component.translatable("advancement." + MODID + ".divine.90_seconds_to_midnight.desc"), GOAL, true, true, true).addCriterion("has_frozen_clock_variant_4", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, frozen_clock.get()).withComponents(DataComponentMatchers.Builder.components().exact(DataComponentExactPredicate.builder().expect(variant.get(), (byte) 4).build()).build()))).save(output, MODID + ":divine/90_seconds_to_midnight"),
            adaptiveStrategies = taskItem(divineRoot, "divine/adaptive_strategies", armor_pouch.get(), "get_armor_pouch", ARMOR_POUCHES, items),
            theRealStuff = taskItem(divineRoot, "divine/the_real_stuff", realmite_ingot.get(), "get_realmite_ingot", INGOTS_REALMITE, items),
            kineticMetal = taskItem(theRealStuff, "divine/kinetic_metal", arlemite_ingot.get(), "get_arlemite_ingot", INGOTS_ARLEMITE, items),
            deepBlue = taskItem(kineticMetal, "divine/deep_blue", rupee_ingot.get(), "get_rupee_ingot", INGOTS_RUPEE, items),
            devoidOfLight = taskItem(deepBlue, "divine/devoid_of_light", shadow_dust.get(), "get_shadow_dust", DUSTS_SHADOW, items),
            coinage = taskItem(devoidOfLight, "divine/coinage", shadow_coins.get(), "get_shadow_coins", COINS_SHADOW, items),
            crystallization = taskItem(devoidOfLight, "divine/crystallization", shadow_stone.get(), "get_shadow_stone", GEMS_SHADOW, items),
            borderline = taskItem(crystallization, "divine/borderline", bedrock_chunk.get(), "get_bedrock_chunk", CHUNKS_BEDROCK, items),
            toweringGuardian = goalKill(devoidOfLight, "divine/towering_guardian", sandslash.get(), "kill_boss_ancient_entity", ANCIENT_ENTITY.get(), entities),
            aDivinePlan = taskItem(toweringGuardian, "divine/a_divine_plan", divine_sword.get(), "craft_divine_sword", TOOLS_SWORD_DIVINE, items),
            attemptAtAscension = baseBuilder(aDivinePlan, "divine/attempt_at_ascension", DIVINE_HELMET.get(), CHALLENGE, true, true, false, b -> b.rewards(AdvancementRewards.Builder.experience(500)).addCriterion("divine_helmet", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, DIVINE_HELMET.get()))).addCriterion("divine_chestplate", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, DIVINE_CHESTPLATE.get()))).addCriterion("divine_leggings", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, DIVINE_LEGGINGS.get()))).addCriterion("divine_boots", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, DIVINE_BOOTS.get()))).addCriterion("divine_sword", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, TOOLS_SWORD_DIVINE))).addCriterion("divine_axe", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, divine_axe.get()))).addCriterion("divine_pickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, divine_pickaxe.get()))).addCriterion("divine_shovel", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, divine_shovel.get()))).addCriterion("divine_shickaxe", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, divine_shickaxe.get())))),
            temporalRecalibration = taskItem(freezingFire, "divine/temporal_recalibration", frozen_clock.get(), "get_frozen_clock", items),
            anUnstableCombination = taskImpossible(temporalRecalibration, "divine/an_unstable_combination", OBSIDIAN, "create_unstable_rift"),
            effectiveTrapping = taskItem(divineRoot, "divine/effective_trapping", spikeBlock.asItem(), "get_spike_block", METAL_SPIKE_BLOCKS.item(), items),
            observingTheCold = taskItem(crystallization, "divine/observing_the_cold", snow_globe.get(), "get_snow_globe", items),
            oops = baseBuilder(temporalRecalibration, "divine/oops", BONE, TASK, true, true, true, b -> b.addCriterion("explode_rift", IMPOSSIBLE.createCriterion(new ImpossibleTrigger.TriggerInstance()))),
            rippleSpaceTime = taskImpossible(temporalRecalibration, "divine/ripple_space_time", shiningObsidian.asItem(), "create_stable_rift"),
            theLink = taskImpossible(toweringGuardian, "divine/the_link", divineFlame.asItem(), "create_divine_flame"),
            ritualOrNot = taskImpossible(theLink, "divine/ritual_or_not", GOLDEN_APPLE, "remove_curse"),
            smashing = taskItem(theRealStuff, "divine/smashin", realmite_maul.get(), "get_maul", TOOLS_MAUL, items),
        // NETHER
            scorching = taskKill(netherBlazeRod, "nether/scorching", purple_blaze.get(), "kill_scorcher", SCORCHER.get(), entities),
            eternalFlame = goalKill(scorching, "nether/eternal_flame", fury_fire.get(), "kill_boss_king_of_scorchers", KING_OF_SCORCHERS.get(), entities),
            offKey = task(scorching, "nether/off_key", sound_of_music.get(), b -> b.addCriterion("use_sound_of_music", ItemDurabilityTrigger.TriggerInstance.changedDurability(Optional.of(ItemPredicate.Builder.item().of(items, sound_of_music.get()).build()), MinMaxBounds.Ints.ANY))),
            theOriginal = taskItem(netherRoot, "nether/the_original", torridite_ingot.get(), "get_torridite_ingot", INGOTS_TORRIDITE, items),
            tormentedSouls = taskImpossible(theOriginal, "nether/tormented_souls", hellfire.asItem(), "create_hellfire"),
            painInTheBar = taskItem(tormentedSouls, "nether/pain_in_the_bar", hellstone_ingot.get(), "get_hellstone_ingot", INGOTS_HELLSTONE, items),
            overseeingEye = goalKill(painInTheBar, "nether/overseeing_eye", soulfire_stone.get(), "kill_boss_the_watcher", THE_WATCHER.get(), entities),
        // ICEIKA
            iceikaRoot = Advancement.Builder.recipeAdvancement().display(new DisplayInfo(new ItemStackTemplate(snow_globe.get()), Component.translatable("advancement." + MODID + ".iceika.root"), Component.translatable("advancement." + MODID + ".iceika.root.desc"), Optional.of(new ClientAsset.ResourceTexture(fromNamespaceAndPath(MODID, "block/frozen_dirt"))), TASK, true, true, false)).addCriterion("iceika", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(LevelRegistry.ICEIKA)).save(output, MODID + ":iceika/root"),
            frozenGoods = baseBuilder(iceikaRoot, "iceika/frozen_goods", frostedChest.asItem(), GOAL, true, true, false, b -> b.addCriterion("get_snowflake", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, SNOWFLAKES)))),
            aLilGift = taskTrade(frozenGoods, "iceika/a_lil_gift", snowflake.get(), "talk_to_workshop_merchant", WORKSHOP_MERCHANT.get(), entities),
            aLilTinkering = taskTrade(frozenGoods, "iceika/a_lil_tinkering", frostking_sword.get(), "talk_to_workshop_tinkerer", WORKSHOP_TINKERER.get(), entities),
            chocolateOre = taskItem(iceikaRoot, "iceika/chocolate_ore", oxdrite_ingot.get(), "get_oxdrite_ingot", INGOTS_OXDRITE, items),
            advancedTechnology = taskItem(chocolateOre, "iceika/advanced_technology", capacitor.asItem(), "get_oxdrite_tech", OXDRITE_TECH_BLOCKS.item(), items),
            boneyard = task(iceikaRoot, "iceika/boneyard", BONE_BLOCK, b -> b.addCriterion("boneyard", PlayerTrigger.TriggerInstance.located(inBiome(biomes, ICEIKA_BONEYARD)))),
            icyCatacombs = baseBuilder(iceikaRoot, "iceika/icy_catacombs", icyBricks.asItem(), GOAL, true, true, false, b -> b.addCriterion("get_in_icy_catacombs", PlayerTrigger.TriggerInstance.located(inStructure(structures, DUNGEON)))),
            decode = taskItem(icyCatacombs, "iceika/decode", runicIcyBricks.asItem(), "get_icy_bricks", items),
            exploreIceika = baseBuilder(boneyard, "iceika/explore_iceika", frozenSoil.grass().asItem(), CHALLENGE, true, true, false, b -> Stream.of(ICEIKA_BONEYARD, ICEIKA_BOREALIS_STEEPS, ICEIKA_CHILL_PASSAGE, ICEIKA_CHILLY_CAVERN, ICEIKA_COZYBARK_FOREST, ICEIKA_DEEP_FROZEN_OCEAN, ICEIKA_FRACTAL_FOREST, ICEIKA_FROZEN_MENAGERIE, ICEIKA_FROZEN_OCEAN, ICEIKA_FROZEN_PEAKS, ICEIKA_GEYSER_PLATEAU, ICEIKA_GLOWING_DEEP, ICEIKA_ICE_SHEET, ICEIKA_ICE_SPIKES, ICEIKA_MORGUE_MARSH, ICEIKA_SHELTERED_GARDEN, ICEIKA_SHIVERSPINE_FOREST, ICEIKA_SNOW_BOG, ICEIKA_SNOWY_PEAKS, ICEIKA_THERMAL_VENTS, ICEIKA_TUNDRA).reduce(b.rewards(AdvancementRewards.Builder.experience(500)), (builder, biome) -> builder.addCriterion(biome.identifier().getPath().replaceFirst("^iceika/", ""), PlayerTrigger.TriggerInstance.located(inBiome(biomes, biome))), (b1, b2) -> b1)),
            feedThemBrittleGlass = task(iceikaRoot, "iceika/feed_them_brittle_glass", brittleGrass.plant().asItem(), b -> b.addCriterion("mammoth", BredAnimalsTrigger.TriggerInstance.bredAnimals(EntityPredicate.Builder.entity().of(entities, MAMOTH.get())))),
            killKitra = goalKill(boneyard, "iceika/kill_kitra", calcifiedBrain.asItem(), "kill_boss_kitra", KITRA.get(), entities),
            sapphireBeast = taskItem(iceikaRoot, "iceika/sapphire_beast", seng_fur.get(), "get_seng_fur", FURS_SENG, items),
            whatMakesYouBeautiful = challenge(sapphireBeast, "iceika/what_makes_you_beautiful", SENG_FUR_HELMET.get(), 50, b -> b.addCriterion("have_seng_armor", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, SENG_FUR_HELMET.get()), ItemPredicate.Builder.item().of(items, SENG_FUR_CHESTPLATE.get()), ItemPredicate.Builder.item().of(items, SENG_FUR_LEGGINGS.get()), ItemPredicate.Builder.item().of(items, SENG_FUR_BOOTS.get())))),
        // END
            blownAway = taskItem(endKillDragon, "end/blown_away", horde_horn.get(), "horde_horn", items),
            swarmOfTheVoid = goalKill(blownAway, "end/swarm_of_the_void", ayeracoStatue.asItem(), "ayeraco", AYERACO.get(), entities),
            tripleTheDanger = taskKill(endRoot, "end/triple_the_danger", ender_shards.get(), "kill_ender_triplets", ENDER_TRIPLETS.get(), entities),
            whenPigsFly = baseBuilder(endElytra, "end/when_pigs_fly", ANGELIC_HELMET.get(), CHALLENGE, true, true, true, b -> b.rewards(AdvancementRewards.Builder.experience(200)).addCriterion("get_angelic_armor", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ANGELIC_HELMET.get()), ItemPredicate.Builder.item().of(items, ANGELIC_CHESTPLATE.get()), ItemPredicate.Builder.item().of(items, ANGELIC_LEGGINGS.get()), ItemPredicate.Builder.item().of(items, ANGELIC_BOOTS.get())))),
        // ARCANA
            arcanaRoot = Advancement.Builder.recipeAdvancement().display(new DisplayInfo(new ItemStackTemplate(arcanaPortalFrame.asItem()), Component.translatable("advancement." + MODID + ".arcana.root"), Component.translatable("advancement." + MODID + ".arcana.root.desc"), Optional.of(new ClientAsset.ResourceTexture(fromNamespaceAndPath(MODID, "block/ancient_bricks"))), TASK, true, true, false)).addCriterion("arcana", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(LevelRegistry.ARCANA)).save(output, MODID + ":arcana/root"),
            disgusting = taskItem(arcanaRoot, "arcana/disgusting", weak_arcana_potion.get(), "get_arcana_potion", items),
            dungeonMaster = goalKill(arcanaRoot, "arcana/dungeon_master", dungeon_tokens.get(), "kill_boss_dramix", DRAMIX.get(), entities),
            evilDisease = goalKill(arcanaRoot, "arcana/evil_disease", wizards_book.get(), "kill_boss_parasecta", PARASECTA.get(), entities),
            theTempest = taskItem(arcanaRoot, "arcana/the_tempest", storm_sword.get(), "get_storm_sword", items),
            hotterThanHell = Advancement.Builder.recipeAdvancement().parent(arcanaRoot).display(heatTrap.asItem(), Component.translatable("advancement." + MODID + ".arcana.hotter_than_hell"), Component.translatable("advancement." + MODID + ".arcana.hotter_than_hell.desc"), TASK, true, false, true).addCriterion("walk_on_heat_trap", PlayerTrigger.TriggerInstance.located(EntityPredicate.Builder.entity().steppingOn(LocationPredicate.Builder.location().setBlock(BlockPredicate.Builder.block().of(blocks, heatTrap.get()).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(ACTIVE, true)))))).save(output, MODID + ":arcana/hotter_than_hell"),
            myLittleCreature = task(arcanaRoot, "arcana/my_little_creature", seimer_egg.get(), b -> b.addCriterion("tame_fyracryx", TameAnimalTrigger.TriggerInstance.tamedAnimal(EntityPredicate.Builder.entity().of(entities, FYRACRYX.get()))).addCriterion("tame_seimer", TameAnimalTrigger.TriggerInstance.tamedAnimal(EntityPredicate.Builder.entity().of(entities, SEIMER.get()))).addCriterion("tame_paratiku", TameAnimalTrigger.TriggerInstance.tamedAnimal(EntityPredicate.Builder.entity().of(entities, PARATIKU.get()))).addCriterion("tame_golem_of_rejuvenation", TameAnimalTrigger.TriggerInstance.tamedAnimal(EntityPredicate.Builder.entity().of(entities, GOLEM_OF_REJUVENATION.get())))),
            skyHigh = task(arcanaRoot, "arcana/sky_high", elevantium.asItem(), b -> b.addCriterion("step_on_elevantium", ENTER_BLOCK.createCriterion(new EnterBlockTrigger.TriggerInstance(Optional.empty(), Optional.of(HolderSet.direct(elevantium)), StatePropertiesPredicate.Builder.properties().hasProperty(BlockStateProperties.POWERED, true).build())))),
            totalDemonization = taskItem(arcanaRoot, "arcana/total_demonization", demonFurnace.asItem(), "obtain_demon_furnace", items),
        // TWILIGHT
            twilightRoot = Advancement.Builder.recipeAdvancement().display(new DisplayInfo(new ItemStackTemplate(divineRock.asItem()), Component.translatable("advancement.divinerpg.twilight.root"), Component.translatable("advancement.divinerpg.twilight.root.desc"), Optional.of(new ClientAsset.ResourceTexture(fromNamespaceAndPath(MODID, "block/twilight_stone"))), TASK, false, false, false)).addCriterion("divinerpg", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(LevelRegistry.EDEN)).save(output, "divinerpg:twilight/root"),
            possibilities1001 = taskDimension(twilightRoot, "twilight/1001_possibilities", eden.log().asItem(), "enter_eden", LevelRegistry.EDEN),
            aWayHome = task(possibilities1001, "twilight/a_way_home", edenBlock.asItem(), b -> b.addCriterion("enter_eden_portal", EnterBlockTrigger.TriggerInstance.entersBlock(blocks, edenPortal.get()))),
            friendOrFoe = taskKill(possibilities1001, "twilight/friend_or_foe", eden_soul.get(), "kill_twilight_glinthop", GLINTHOP.get(), entities),
            hardTimes = baseBuilder(possibilities1001, "twilight/hard_times", demonBrambles.asItem(), TASK, true, true, true, b -> b.addCriterion("killed_by_cori", KilledTrigger.TriggerInstance.entityKilledPlayer(Optional.of(EntityPredicate.Builder.entity().of(entities, WEAK_CORI.get()).build())))),
            whatHaveYouDone = baseBuilder(possibilities1001, "twilight/what_have_you_done", forbidden_fruit.get(), TASK, true, true, true, b -> b.addCriterion("requirement", ConsumeItemTrigger.TriggerInstance.usedItem(items, forbidden_fruit.get()))),
            championOfLight = goalKill(possibilities1001, "twilight/champion_of_light", eden_heart.get(), "kill_boss_sunstorm", SUNSTORM.get(), entities),
            wildernessAblaze = taskImpossible(championOfLight, "twilight/wilderness_ablaze", wildFlame.asItem(), "create_wild_flame"),
            forestIslands = taskDimension(wildernessAblaze, "twilight/forest_islands", wildwood.log().asItem(), "enter_wildwood", LevelRegistry.WILDWOOD),
            forestScourge = goalKill(forestIslands, "twilight/forest_scourge", wildwood_heart.get(), "kill_boss_termasect", TERMASECT.get(), entities),
            magicalIncineration = taskImpossible(forestScourge, "twilight/magical_incineration", enchantedFlame.asItem(), "create_enchanted_flame"),
            burningEnchanter = taskImpossible(magicalIncineration, "twilight/burning_enchanter", purple_glowbone.get(), "use_enchanted_flame"),
            purplePlanet = taskDimension(magicalIncineration, "twilight/purple_planet", apalachia.log().asItem(), "enter_apalachia", LevelRegistry.APALACHIA),
            archaicBowman = goalKill(purplePlanet, "twilight/archaic_bowman", apalachia_heart.get(), "kill_boss_eternal_archer", ETERNAL_ARCHER.get(), entities),
            skyFall = taskImpossible(archaicBowman, "twilight/sky_fall", skyFire.asItem(), "create_sky_fire"),
            yippie = task(skyFall, "twilight/yippie", FEATHER, b -> b.addCriterion("enter_sky_fire", EnterBlockTrigger.TriggerInstance.entersBlock(blocks, skyFire.get()))),
            colourlessLand = taskDimension(skyFall, "twilight/colourless_land", skythern.log().asItem(), "enter_skythern", LevelRegistry.SKYTHERN),
            observerOfTheSkies = goalKill(colourlessLand, "twilight/observer_of_the_skies", skythern_heart.get(), "kill_boss_experienced_cori", EXPERIENCED_CORI.get(), entities),
            glowingDeath = taskImpossible(observerOfTheSkies, "twilight/glowing_death", mortumEmbers.asItem(), "create_mortum_embers"),
            curses = taskImpossible(glowingDeath, "twilight/curses", mortum_soul.get(), "use_mortum_embers"),
            darkAnotherDay = taskDimension(glowingDeath, "twilight/dark_another_day", mortum.log().asItem(), "enter_mortum", LevelRegistry.MORTUM),
            angerManagementProblems = goalKill(darkAnotherDay, "twilight/anger_management_problems", halite_phaser.get(), "kill_boss_karot", KAROT.get(), entities),
            arachnophobia = goalKill(darkAnotherDay, "twilight/arachnophobia", halite_slicer.get(), "kill_boss_soul_fiend", SOUL_FIEND.get(), entities),
            arrowToTheKnee = baseBuilder(darkAnotherDay, "twilight/arrow_to_the_knee", twilight_bow.get(), TASK, true, true, true, b -> b.addCriterion("hurt_by_twilight_archer", EntityHurtPlayerTrigger.TriggerInstance.entityHurtPlayer(DamagePredicate.Builder.damageInstance().sourceEntity(EntityPredicate.Builder.entity().of(entities, TWILIGHT_ARCHER.get()).build())))),
            bicorn = goalKill(darkAnotherDay, "twilight/bicorn", halite_blade.get(), "kill_boss_vamacheron", VAMACHERON.get(), entities),
            exorcism = goalKill(darkAnotherDay, "twilight/exorcism", halite_bow.get(), "kill_boss_twilight_demon", TWILIGHT_DEMON.get(), entities),
            fiveHeadsAreBetterThanOne = goalKill(darkAnotherDay, "twilight/five_heads_are_better_than_one", HALITE_CHESTPLATE.get(), "kill_boss_densos", DENSOS.get(), entities),
            legolas = goalKill(darkAnotherDay, "twilight/legolas", HALITE_LEGGINGS.get(), "kill_boss_reyvor", REYVOR.get(), entities),
        // VETHEA
            vetheaRoot = Advancement.Builder.recipeAdvancement().display(new DisplayInfo(new ItemStackTemplate(dreamSoil.grass().asItem()), Component.translatable("advancement.divinerpg.vethea.root"), Component.translatable("advancement.divinerpg.vethea.root.desc"), Optional.of(new ClientAsset.ResourceTexture(fromNamespaceAndPath(MODID, "block/dream_stone"))), TASK, true, true, false)).addCriterion("vethea", ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(LevelRegistry.VETHEA)).save(output, "divinerpg:vethea/root"),
            forTheManWhoHasEverything = taskTrade(vetheaRoot, "vethea/for_the_man_who_has_everything", dirty_pearls.get(), "trade_with_hunger", THE_HUNGER.get(), entities),
            anElmOnNightmareStreet = baseBuilder(forTheManWhoHasEverything, "vethea/an_elm_on_nightmare_street", hyrewood.log().asItem(), TASK, true, true, true, b -> b.addCriterion("kill_ent", KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(entities, ENT.get())))),
            cryptRaider = taskItem(forTheManWhoHasEverything, "vethea/crypt_raider", amthirmis_lump.get(), "obtain_amthirmis_lump", LUMPS_AMTHIRMIS, items),
            gettingOutOfHand = goalKill(forTheManWhoHasEverything, "vethea/getting_out_of_hand", quadrotic_lump.get(), "kill_quadro", QUADRO.get(), entities),
            iAmMadScientist = goalKill(gettingOutOfHand, "vethea/i_am_mad_scientist", karos_lump.get(), "kill_karos", KAROS.get(), entities),
            swissCheese = goalKill(iAmMadScientist, "vethea/swiss_cheese", heliosis_lump.get(), "kill_raglok", RAGLOK.get(), entities),
            unlimitedPower = goalKill(swissCheese, "vethea/unlimited_power", arksiane_lump.get(), "kill_wreck", WRECK.get(), entities),
            lunarEmissary = goalKill(unlimitedPower, "vethea/lunar_emissary", moon_clock.get(), "kill_lady_luna", LADY_LUNA.get(), entities),
            everlasting = challenge(lunarEmissary, "vethea/everlasting", eversight.get(), 500, b -> Stream.of(everbright, everfright, everlight, evernight, eversight).reduce(b, (builder, item) -> builder.addCriterion("get_" + item.getId().getPath(), InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, item.get()))), (b1, b2) -> b1)),
            goodLife = task(forTheManWhoHasEverything, "vethea/good_life", dream_pie.get(), b -> b.addCriterion("eat_pie", ConsumeItemTrigger.TriggerInstance.usedItem(items, dream_pie.get()))),
            letThemEatCake = task(forTheManWhoHasEverything, "vethea/let_them_eat_cake", dream_cake.get(), b -> b.addCriterion("eat_cake", ConsumeItemTrigger.TriggerInstance.usedItem(items, dream_cake.get()))),
            licensedToKill = taskKill(forTheManWhoHasEverything, "vethea/licensed_to_kill", band_of_lheiva_hunting.get(), "kill_lheiva", LHEIVA.get(), entities),
            oneMaulToRuleThemAll = taskItem(iAmMadScientist, "vethea/one_maul_to_rule_them_all", karos_rockmaul.get(), "obtain_karos_rockmaul", items),
            royalBeeswax = goalKill(forTheManWhoHasEverything, "vethea/royal_beeswax", hiveEgg.asItem(), "kill_hive_queen", HIVE_QUEEN.get(), entities),
            templeOfDoom = taskItem(cryptRaider, "vethea/temple_of_doom", cermile_lump.get(), "obtain_cermile_lump", LUMPS_CERMILE, items);
        // GUIDE BOOK
//        AdvancementHolder patchouliGuide = Advancement.Builder.recipeAdvancement().addCriterion("first_steps", PlayerTrigger.TriggerInstance.tick()).rewards(AdvancementRewards.Builder.loot(lootTables.getOrThrow(PATCHOULI))).build(PATCHOULI.identifier());
//        output.register(ResourceKey.create(Registries.ADVANCEMENT, PATCHOULI.identifier()), patchouliGuide.value(), new ModLoadedCondition("patchouli")); // TODO
    }
    private LocationPredicate.Builder inBiome(HolderGetter<Biome> biomes, ResourceKey<Biome> key) {
        return LocationPredicate.Builder.inBiome(biomes.getOrThrow(key));
    }
    private LocationPredicate.Builder inStructure(HolderGetter<Structure> structures, ResourceKey<Structure> key) {
        return LocationPredicate.Builder.inStructure(structures.getOrThrow(key));
    }
    private AdvancementHolder baseBuilder(AdvancementHolder parent, String path, Item icon, AdvancementType type, boolean toast, boolean chat, boolean hidden, UnaryOperator<Advancement.Builder> configure) {
        String langKey = "advancement." + MODID + "." + path.replace('/', '.');
        return configure.apply(Advancement.Builder.recipeAdvancement().parent(parent).display(icon, Component.translatable(langKey), Component.translatable(langKey + ".desc"), type, toast, chat, hidden)).save(output, fromNamespaceAndPath(MODID, path));
    }
    private AdvancementHolder task(AdvancementHolder parent, String path, Item icon, UnaryOperator<Advancement.Builder> configure) {
        return baseBuilder(parent, path, icon, TASK, true, true, false, configure);
    }
    private AdvancementHolder taskItem(AdvancementHolder parent, String path, Item icon, String criterion, TagKey<Item> tag, HolderGetter<Item> items) {
        return task(parent, path, icon, b -> b.addCriterion(criterion, InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, tag))));
    }
    private AdvancementHolder taskItem(AdvancementHolder parent, String path, Item item, String criterion, HolderGetter<Item> items) {
        return task(parent, path, item, b -> b.addCriterion(criterion, InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, item))));
    }
    private AdvancementHolder taskPlaceBlock(AdvancementHolder parent, String path, Block block, String criterion, HolderGetter<Block> blocks) {
        return task(parent, path, block.asItem(), b -> b.addCriterion(criterion, ItemUsedOnLocationTrigger.TriggerInstance.placedBlock(blocks, block)));
    }
    private AdvancementHolder taskKill(AdvancementHolder parent, String path, Item icon, String criterion, EntityType<?> target, HolderGetter<EntityType<?>> entities) {
        return task(parent, path, icon, b -> b.addCriterion(criterion, KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(entities, target))));
    }
    private AdvancementHolder taskTrade(AdvancementHolder parent, String path, Item icon, String criterion, EntityType<?> villager, HolderGetter<EntityType<?>> entities) {
        return task(parent, path, icon, b -> b.addCriterion(criterion, TradeTrigger.TriggerInstance.tradedWithVillager(EntityPredicate.Builder.entity().of(entities, villager))));
    }
    private AdvancementHolder taskDimension(AdvancementHolder parent, String path, Item icon, String criterion, ResourceKey<Level> dimension) {
        return task(parent, path, icon, b -> b.addCriterion(criterion, ChangeDimensionTrigger.TriggerInstance.changedDimensionTo(dimension)));
    }
    private AdvancementHolder taskImpossible(AdvancementHolder parent, String path, Item icon, String criterion) {
        return task(parent, path, icon, b -> b.addCriterion(criterion, IMPOSSIBLE.createCriterion(new ImpossibleTrigger.TriggerInstance())));
    }
    private AdvancementHolder hiddenTask(AdvancementHolder parent, String path, Item icon, UnaryOperator<Advancement.Builder> configure) {
        return baseBuilder(parent, path, icon, TASK, false, false, true, configure);
    }
    private AdvancementHolder goal(AdvancementHolder parent, String path, Item icon, UnaryOperator<Advancement.Builder> configure) {
        return baseBuilder(parent, path, icon, GOAL, true, true, false, configure);
    }
    private AdvancementHolder goalKill(AdvancementHolder parent, String path, Item icon, String criterion, EntityType<?> target, HolderGetter<EntityType<?>> entities) {
        return goal(parent, path, icon, b -> b.addCriterion(criterion, KilledTrigger.TriggerInstance.playerKilledEntity(EntityPredicate.Builder.entity().of(entities, target))));
    }
    private AdvancementHolder challenge(AdvancementHolder parent, String path, Item icon, int xpReward, UnaryOperator<Advancement.Builder> configure) {
        return baseBuilder(parent, path, icon, CHALLENGE, true, true, false, b -> configure.apply(b.rewards(AdvancementRewards.Builder.experience(xpReward))));
    }
}