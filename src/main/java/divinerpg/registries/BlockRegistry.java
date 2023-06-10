package divinerpg.registries;

import divinerpg.DivineRPG;
import divinerpg.blocks.arcana.*;
import divinerpg.blocks.base.*;
import divinerpg.blocks.iceika.*;
import divinerpg.blocks.twilight.*;
import divinerpg.blocks.vanilla.*;
import divinerpg.blocks.vethea.*;
import divinerpg.items.base.block.*;
import divinerpg.world.feature.tree.grower.*;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.*;

import java.util.function.Supplier;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.SoundRegistry.*;
import static net.minecraft.core.particles.ParticleTypes.FLAME;
import static net.minecraft.sounds.SoundEvents.*;
import static net.minecraft.world.level.material.MapColor.*;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Block>
            arlemiteOre			 = registerBlock("arlemite_ore",			() -> new BlockMod(Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(3F))),
            arlemiteOreDeepslate = registerBlock("arlemite_ore_deepslate",  () -> new Block(Properties.copy(Blocks.DEEPSLATE_GOLD_ORE).sound(SoundType.DEEPSLATE).mapColor(DEEPSLATE))),
            realmiteOre			 = registerBlock("realmite_ore",			() -> new BlockMod(Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(3F))),
            realmiteOreDeepslate = registerBlock("realmite_ore_deepslate",  () -> new Block(Properties.copy(Blocks.IRON_ORE).sound(SoundType.DEEPSLATE).mapColor(DEEPSLATE))),
            rupeeOre			 = registerBlock("rupee_ore",				() -> new BlockMod(Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(3F))),
            rupeeOreDeepslate	 = registerBlock("rupee_ore_deepslate",  	() -> new Block(Properties.copy(Blocks.DEEPSLATE_GOLD_ORE).sound(SoundType.DEEPSLATE).mapColor(DEEPSLATE))),
            bloodgemOre			 = registerBlock("bloodgem_ore",			() -> new BlockMod(Properties.of().mapColor(MapColor.NETHER).requiresCorrectToolForDrops().strength(3F).sound(SoundType.NETHER_ORE))),
            torriditeOre		 = registerBlock("torridite_ore",			() -> new BlockMod(Properties.of().mapColor(MapColor.NETHER).requiresCorrectToolForDrops().strength(3F, 1200F).sound(SoundType.NETHER_ORE)));

    public static final RegistryObject<Block>// Compressed ore blocks
            arlemiteBlock	= registerBlock("arlemite_block",	() -> new BlockMod(Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).requiresCorrectToolForDrops().strength(5F, 6F).sound(SoundType.METAL))),
            rawArlemiteBlock= registerBlock("raw_arlemite_block",() -> new BlockMod(Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).requiresCorrectToolForDrops().strength(5F, 6F))),
            realmiteBlock	= registerBlock("realmite_block",	() -> new BlockMod(Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arlemite_block"))).mapColor(MapColor.COLOR_ORANGE))),
            rawRealmiteBlock= registerBlock("raw_realmite_block",() -> new BlockMod(Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "raw_arlemite_block"))).mapColor(MapColor.COLOR_ORANGE))),
            rupeeBlock		= registerBlock("rupee_block",		() -> new BlockMod(Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arlemite_block"))).mapColor(MapColor.COLOR_LIGHT_BLUE))),
            rawRupeeBlock	= registerBlock("raw_rupee_block",	() -> new BlockMod(Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "raw_arlemite_block"))).mapColor(MapColor.COLOR_LIGHT_BLUE))),
            bloodgemBlock	= registerBlock("bloodgem_block",	() -> new BlockMod(Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arlemite_block"))).mapColor(CRIMSON_STEM))),
            torriditeBlock  = registerFireResistantBlock("torridite_block",() -> new BlockMod(Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arlemite_block"))).strength(5F, 1200F).mapColor(CRIMSON_NYLIUM)), Rarity.COMMON),
            rawTorriditeBlock= registerBlock("raw_torridite_block",() -> new BlockMod(Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "raw_arlemite_block"))).strength(5F, 1200F).mapColor(CRIMSON_NYLIUM)));

    public static final RegistryObject<Block>// Boss spawners
            sunstormSpawner			= registerBlock("sunstorm_spawner",			() -> new BlockModMobCage(new ResourceLocation(MODID, "sunstorm"), new ResourceLocation(MODID, "eden_chunk"), COLOR_YELLOW)),
            termasectSpawner		= registerBlock("termasect_spawner",		() -> new BlockModMobCage(new ResourceLocation(MODID, "termasect"), new ResourceLocation(MODID, "wildwood_chunk"), COLOR_LIGHT_BLUE, new BlockPos(0, 11, 0))),
            eternalArcherSpawner	= registerBlock("eternal_archer_spawner",	() -> new BlockModMobCage(new ResourceLocation(MODID, "eternal_archer"), new ResourceLocation(MODID, "apalachia_chunk"), COLOR_MAGENTA)),
            experiencedCoriSpawner  = registerBlock("experienced_cori_spawner", () -> new BlockModMobCage(new ResourceLocation(MODID, "experienced_cori"), new ResourceLocation(MODID, "skythern_chunk"), COLOR_LIGHT_GRAY, new BlockPos(0, 11, 0)));

    public static final RegistryObject<Block>// Mob pumpkins
            blazePumpkin		= registerBlock("blaze_pumpkin", () -> new BlockMobPumpkin(() -> BLAZE_AMBIENT, COLOR_YELLOW)),
            creeperPumpkin		= registerBlock("creeper_pumpkin", () -> new BlockMobPumpkin(() -> CREEPER_PRIMED, EMERALD)),
            cyclopsPumpkin		= registerBlock("cyclops_pumpkin", () -> new BlockMobPumpkin(() -> CYCLOPS.get(), TERRACOTTA_LIGHT_GREEN)),
            enderPumpkin		= registerBlock("ender_pumpkin", () -> new BlockMobPumpkin(() -> ENDERMAN_SCREAM, COLOR_BLACK)),
            enderWatcherPumpkin = registerBlock("ender_watcher_pumpkin", () -> new BlockMobPumpkin(() -> ENDERMAN_AMBIENT, COLOR_BLACK)),
            frostPumpkin		= registerBlock("frost_pumpkin", () -> new BlockMobPumpkin(() -> FROST.get(), WARPED_STEM)),
            ghastPumpkin		= registerBlock("ghast_pumpkin", () -> new BlockMobPumpkin(() -> GHAST_SCREAM, SNOW)),
            glaconPumpkin		= registerBlock("glacon_pumpkin", () -> new BlockMobPumpkin(() -> GLACIDE.get(), COLOR_LIGHT_BLUE)),
            hellspiderPumpkin	= registerBlock("hellspider_pumpkin", () -> new BlockMobPumpkin(() -> HELL_SPIDER.get(), NETHER)),
            jungleSpiderPumpkin = registerBlock("jungle_spider_pumpkin", () -> new BlockMobPumpkin(() -> JUNGLE_SPIDER.get(), PLANT)),
            skeletonPumpkin		= registerBlock("skeleton_pumpkin", () -> new BlockMobPumpkin(() -> SKELETON_AMBIENT, WOOL)),
            spiderPumpkin		= registerBlock("spider_pumpkin", () -> new BlockMobPumpkin(() -> SPIDER_AMBIENT, COLOR_GRAY)),
            zombiePumpkin		= registerBlock("zombie_pumpkin", () -> new BlockMobPumpkin(() -> ZOMBIE_AMBIENT, TERRACOTTA_GREEN));

    public static final RegistryObject<Block>// Torches
            aquaTorch		 = BLOCKS.register("aqua_torch", () -> new BlockModTorch(FLAME)),
            aquaWallTorch	 = BLOCKS.register("aqua_wall_torch", () -> new BlockModWallTorch(FLAME)),
            skeletonWallTorch= BLOCKS.register("skeleton_wall_torch", () -> new BlockModWallTorch(FLAME)),
            skeletonTorch	 = BLOCKS.register("skeleton_torch", () -> new BlockModTorch(FLAME));

    // Decorative blocks

    public static final RegistryObject<Block>// Steel
            blackSteel = registerBlock("black_steel", () -> new BlockMod(Properties.of().mapColor(COLOR_GRAY).requiresCorrectToolForDrops().strength(5F, 6F).sound(SoundType.METAL))),
            blueSteel = registerBlock("blue_steel", () -> new BlockMod(Properties.of().mapColor(COLOR_LIGHT_BLUE).requiresCorrectToolForDrops().strength(5F, 6F).sound(SoundType.METAL))),
            brightRedSteel = registerBlock("bright_red_steel", () -> new BlockMod(Properties.of().mapColor(CRIMSON_NYLIUM).requiresCorrectToolForDrops().strength(5F, 6F).sound(SoundType.METAL))),
            greenSteel = registerBlock("green_steel", () -> new BlockMod(Properties.of().mapColor(COLOR_GREEN).requiresCorrectToolForDrops().strength(5F, 6F).sound(SoundType.METAL))),
            orangeSteel = registerBlock("orange_steel", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_ORANGE).requiresCorrectToolForDrops().strength(5F, 6F).sound(SoundType.METAL))),
            purpleSteel = registerBlock("purple_steel", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_BLUE).requiresCorrectToolForDrops().strength(5F, 6F).sound(SoundType.METAL))),
            redSteel = registerBlock("red_steel", () -> new BlockMod(Properties.of().mapColor(COLOR_RED).requiresCorrectToolForDrops().strength(5F, 6F).sound(SoundType.METAL))),
            whiteSteel = registerBlock("white_steel", () -> new BlockMod(Properties.of().mapColor(WOOL).requiresCorrectToolForDrops().strength(5F, 6F).sound(SoundType.METAL))),
            yellowSteel = registerBlock("yellow_steel", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_YELLOW).requiresCorrectToolForDrops().strength(5F, 6F).sound(SoundType.METAL))),
            tealSteel = registerBlock("teal_steel", () -> new BlockMod(Properties.of().mapColor(WARPED_WART_BLOCK).requiresCorrectToolForDrops().strength(5F, 6F).sound(SoundType.METAL)));

    public static final RegistryObject<Block>// Vanes
            blueVane = registerBlock("blue_vane", () -> new BlockMod(COLOR_BLUE, 0)),
            cyanVane = registerBlock("cyan_vane", () -> new BlockMod(COLOR_CYAN, 0)),
            purpleVane = registerBlock("purple_vane", () -> new BlockMod(TERRACOTTA_PURPLE, 0)),
            redVane = registerBlock("red_vane", () -> new BlockMod(NETHER, 0)),
            yellowVane = registerBlock("yellow_vane", () -> new BlockMod(TERRACOTTA_LIGHT_GREEN, 0));

    public static final RegistryObject<Block>// Bricks
            aquatonicBricks = registerBlock("aquatonic_bricks", () -> new BlockMod(Properties.of().mapColor(WARPED_NYLIUM).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            lavaBricks = registerBlock("lava_bricks", () -> new BlockMod(Properties.of().mapColor(FIRE).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            arlemiteBricks = registerBlock("arlemite_bricks", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_GREEN).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            darkstoneBricks = registerBlock("darkstone_bricks", () -> new BlockMod(Properties.of().mapColor(COLOR_BLACK).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            diamondBricks = registerBlock("diamond_bricks", () -> new BlockMod(Properties.of().mapColor(DIAMOND).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            goldBricks = registerBlock("gold_bricks", () -> new BlockMod(Properties.of().mapColor(GOLD).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            greenBricks = registerBlock("green_bricks", () -> new BlockMod(Properties.of().mapColor(PLANT).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            ironBricks = registerBlock("iron_bricks", () -> new BlockMod(Properties.of().mapColor(COLOR_CYAN).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            lapisLazuliBricks = registerBlock("lapis_lazuli_bricks", () -> new BlockMod(Properties.of().mapColor(COLOR_BLUE).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            milkStoneBricks = registerBlock("milk_stone_bricks", () -> new BlockMod(Properties.of().mapColor(WOOL).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            torriditeBricks = registerFireResistantBlock("torridite_bricks", () -> new BlockMod(Properties.of().mapColor(NETHER).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)), Rarity.COMMON),
            pinkBricks = registerBlock("pink_bricks", () -> new BlockMod(Properties.of().mapColor(COLOR_PURPLE).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            purpleBricks = registerBlock("purple_bricks", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_BLUE).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            realmiteBricks = registerBlock("realmite_bricks", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_ORANGE).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            redstoneBricks = registerBlock("redstone_bricks", () -> new BlockMod(Properties.of().mapColor(CRIMSON_NYLIUM).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            edenBricks = registerBlock("eden_bricks", () -> new BlockMod(Properties.of().mapColor(COLOR_YELLOW).strength(1.5F, 6F).requiresCorrectToolForDrops())),
            wildwoodBricks = registerBlock("wildwood_bricks", () -> new BlockMod(Properties.of().mapColor(COLOR_LIGHT_BLUE).strength(1.5F, 6F).requiresCorrectToolForDrops())),
            apalachiaBricks = registerBlock("apalachia_bricks", () -> new BlockMod(Properties.of().mapColor(COLOR_MAGENTA).strength(1.5F, 6F).requiresCorrectToolForDrops())),
            skythernBricks = registerBlock("skythern_bricks", () -> new BlockMod(Properties.of().mapColor(WOOL).strength(1.5F, 6F).requiresCorrectToolForDrops())),
            mortumBricks = registerBlock("mortum_bricks", () -> new BlockMod(Properties.of().mapColor(COLOR_GRAY).strength(1.5F, 6F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block>// Minibricks
            minibricks = registerBlock("minibricks", () -> new BlockMod(Properties.of().mapColor(DEEPSLATE).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            arlemiteMinibricks = registerBlock("arlemite_minibricks", () -> new BlockMod(Properties.of().mapColor(PLANT).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            bedrockMinibricks = registerFireResistantBlock("bedrock_minibricks", () -> new BlockMod(Properties.of().mapColor(COLOR_BLACK).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)), Rarity.COMMON),
            torriditeMinibricks = registerFireResistantBlock("torridite_minibricks", () -> new BlockMod(Properties.of().mapColor(NETHER).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)), Rarity.COMMON),
            realmiteMinibricks = registerBlock("realmite_minibricks", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_BROWN).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            bloodgemMinibricks = registerBlock("bloodgem_minibricks", () -> new BlockMod(Properties.of().mapColor(CRIMSON_STEM).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS))),
            rupeeMinibricks = registerBlock("rupee_minibricks", () -> new BlockMod(Properties.of().mapColor(WATER).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));

    public static final RegistryObject<Block>// Lamps
            aquaLamp = registerBlock("aqua_lamp", () -> new BlockModLamp(COLOR_LIGHT_BLUE)),
            arlemiteLamp = registerBlock("arlemite_lamp", () -> new BlockModLamp(EMERALD)),
            blazeLamp = registerBlock("blaze_lamp", () -> new BlockModLamp(COLOR_YELLOW)),
            soulfireLamp = registerBlock("soulfire_lamp", () -> new BlockModLamp(WATER, SoundType.GLASS)),
            diamondLamp = registerBlock("diamond_lamp", () -> new BlockModLamp(DIAMOND)),
            divineLamp = registerBlock("divine_lamp", () -> new BlockModLamp(COLOR_YELLOW, SoundType.GLASS)),
            drakenLamp = registerBlock("draken_lamp", () -> new BlockModLamp(COLOR_ORANGE)),
            edenLamp = registerBlock("eden_lamp", () -> new BlockModLamp(COLOR_YELLOW)),
            enderLamp = registerBlock("ender_lamp", () -> new BlockModLamp(COLOR_PURPLE)),
            enderStoneLamp = registerBlock("ender_stone_lamp", () -> new BlockModLamp(COLOR_PURPLE, SoundType.GLASS)),
            goldLamp = registerBlock("gold_lamp", () -> new BlockModLamp(GOLD)),
            iceLamp = registerBlock("ice_lamp", () -> new BlockModLamp(DIAMOND, SoundType.GLASS)),
            jungleLamp = registerBlock("jungle_lamp", () -> new BlockModLamp(EMERALD, SoundType.GLASS)),
            krakenLamp = registerBlock("kraken_lamp", () -> new BlockModLamp(COLOR_LIGHT_GREEN)),
            lapisLazuliLamp = registerBlock("lapis_lazuli_lamp", () -> new BlockModLamp(WATER)),
            lavaLamp = registerBlock("lava_lamp", () -> new BlockModLamp(TERRACOTTA_ORANGE)),
            milkyLamp = registerBlock("milky_lamp", () -> new BlockModLamp(QUARTZ)),
            moltenLamp = registerBlock("molten_lamp", () -> new BlockModLamp(CRIMSON_NYLIUM, SoundType.GLASS)),
            torriditeLamp = registerBlock("torridite_lamp", () -> new BlockModLamp(CRIMSON_NYLIUM)),
            realmiteLamp = registerBlock("realmite_lamp", () -> new BlockModLamp(TERRACOTTA_YELLOW)),
            redstoneOreLamp = registerBlock("redstone_ore_lamp", () -> new BlockModLamp(CRIMSON_STEM)),
            rupeeLamp = registerBlock("rupee_lamp", () -> new BlockModLamp(COLOR_BLUE)),
            terranLamp = registerBlock("terran_lamp", () -> new BlockModLamp(TERRACOTTA_GREEN, SoundType.GLASS));

    public static final RegistryObject<Block>// Powered fences
            blueFence = registerBlock("blue_fence", () -> new BlockModLightFence(COLOR_BLUE)),
            greenFence = registerBlock("green_fence", () -> new BlockModLightFence(COLOR_GREEN)),
            redFence = registerBlock("red_fence", () -> new BlockModLightFence(COLOR_RED));

    public static final RegistryObject<Block>// Miscellaneous decorative blocks
            asphalt = registerBlock("asphalt", () -> new BlockMod(Properties.of().mapColor(COLOR_BLACK).strength(1.5F, 6F).requiresCorrectToolForDrops())),
            asphaltStairs = registerBlock("asphalt_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "asphalt")), 0, 0)),
            asphaltSlab = registerBlock("asphalt_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "asphalt")), 0, 0)),
            blueStone = registerBlock("blue_stone", () -> new BlockLightCrystal(COLOR_LIGHT_BLUE)),
            checker = registerBlock("checker", () -> new BlockMod(0.8F, 0.8F, WOOL, SoundType.WOOL, 60, 30)),
            crate = registerBlock("crate", () -> new BlockMod(2.5F, 2.5F, WOOD, SoundType.WOOD, 20, 5)),
            darkstone = registerBlock("darkstone", () -> new BlockMod(TERRACOTTA_GREEN, 3)),
            fancyWool = registerBlock("fancy_wool", () -> new BlockMod(0.8F, 0.8F, CRIMSON_HYPHAE, SoundType.WOOL, 60, 30)),
            milkStone = registerBlock("milk_stone", () -> new BlockMod(Properties.of().mapColor(WOOL).strength(1.5F, 6F).requiresCorrectToolForDrops())),
            plankDesign = registerBlock("plank_design", () -> new BlockModPlanks(WOOD)),
            rainbowWool = registerBlock("rainbow_wool", () -> new BlockMod(0.8F, 0.8F, COLOR_PURPLE, SoundType.WOOL, 60, 30));

    public static final RegistryObject<Block>// Spike blocks
            spikeBlock = registerBlock("spike_block", () -> new BlockSpike(false, COLOR_GRAY)),
            hotSpikeBlock = registerBlock("hot_spike_block", () -> new BlockSpike(true, COLOR_RED));

    public static final RegistryObject<Block>// Utility blocks
            altarOfCorruption = registerBlock("altar_of_corruption", () -> new BlockAltarOfCorruption()),
            boneChest = registerWithRender("bone_chest", () -> new BlockBoneChest(), Rarity.COMMON),
            frostedAllure = registerBlock("frosted_allure", () -> new BlockFrostedAllure());

    public static final RegistryObject<Block>// Divine blocks
            divineSapling = registerBlock("divine_sapling", () -> new BlockModSapling(GOLD, () -> Blocks.GRASS, () -> Blocks.DIRT, new DivineTreeGrower())),
            divineLog = registerBlock("divine_log", () -> new BlockModLog(TERRACOTTA_LIGHT_GREEN)),
            strippedDivineLog = registerBlock("stripped_divine_log", () -> new BlockModLog(TERRACOTTA_LIGHT_GREEN)),
            divineLeaves = registerBlock("divine_leaves", () -> new BlockModLeaves(GOLD, SoundType.GRASS)),
            divinePlanks = registerBlock("divine_planks", () -> new BlockModPlanks(TERRACOTTA_LIGHT_GREEN)),
            divineStairs = registerBlock("divine_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "divine_planks")), 20, 5)),
            divineMossStone = registerBlock("divine_moss_stone", () -> new BlockMod(STONE, 2F, 6F)),
            divineRock = registerBlock("divine_rock", () -> new BlockMod(GOLD, 1.5F, 6F));

    public static final RegistryObject<Block>// Miscellaneous utility
            slimeLight = registerBlock("slime_light", () -> new BlockModLight()),
            darkBridge = registerBlock("dark_bridge", () -> new BlockModBridge());

    public static final RegistryObject<Block>// Crops
            tomatoPlant = registerBlock("tomato_plant", () -> new BlockTomatoPlant()),
            whiteMushroomPlant = registerBlock("white_mushroom_plant", () -> new BlockWhiteMushroomPlant());

    public static final RegistryObject<Block>// Boss statues
            ancientEntityStatue = registerWithRender("ancient_entity_statue", () -> new BlockStatue(() -> IRON_GOLEM_DEATH), Rarity.RARE),
            ayeracoStatue = registerWithRender("ayeraco_statue", () -> new BlockStatue(() -> AYERACO.get()), Rarity.RARE),
            densosStatue = registerWithRender("densos_statue", () -> new BlockStatue(() -> DENSOS.get()), Rarity.RARE),
            dramixStatue = registerWithRender("dramix_statue", () -> new BlockStatue(() -> DRAMIX.get()), Rarity.RARE),
            eternalArcherStatue = registerWithRender("eternal_archer_statue", () -> new BlockStatue(() -> ARCHER.get()), Rarity.RARE),
            karotStatue = registerWithRender("karot_statue", () -> new BlockStatue(null), Rarity.RARE),
            kingOfScorchersStatue = registerWithRender("king_of_scorchers_statue", () -> new BlockStatue(() -> KING_OF_SCORCHERS.get()), Rarity.RARE),
            parasectaStatue = registerWithRender("parasecta_statue", () -> new BlockStatue(() -> PARASECTA.get()), Rarity.RARE),
            reyvorStatue = registerWithRender("reyvor_statue", () -> new BlockStatue(() -> REYVOR.get()), Rarity.RARE),
            soulFiendStatue = registerWithRender("soul_fiend_statue", () -> new BlockStatue(null), Rarity.RARE),
            theWatcherStatue = registerWithRender("the_watcher_statue", () -> new BlockStatue(() -> ROAR.get()), Rarity.RARE),
            twilightDemonStatue = registerWithRender("twilight_demon_statue", () -> new BlockStatue(() -> INSECT.get()), Rarity.RARE),
            vamacheronStatue = registerWithRender("vamacheron_statue", () -> new BlockStatue(null), Rarity.RARE),
            termasectStatue = registerWithRender("termasect_statue", () -> new BlockStatue(() -> WOOD_STEP), Rarity.RARE),
            sunstormStatue = registerWithRender("sunstorm_statue", () -> new BlockStatue(() -> SPARKLER.get()), Rarity.RARE),
            experiencedCoriStatue = registerWithRender("experienced_cori_statue", () -> new BlockStatue(() -> CORI.get()), Rarity.RARE),
            etherealcetusStatue = registerWithRender("etherealcetus_statue", () -> new BlockStatue(() -> WHALE.get()), Rarity.RARE);

    public static final RegistryObject<Block>// Ayeraco technical blocks
            ayeracoBeamBlue = BLOCKS.register("ayeraco_beam_blue", () -> new BlockAyeracoBeam(BossBarColor.BLUE)),
            ayeracoBeamGreen = BLOCKS.register("ayeraco_beam_green", () -> new BlockAyeracoBeam(BossBarColor.GREEN)),
            ayeracoBeamPink = BLOCKS.register("ayeraco_beam_pink", () -> new BlockAyeracoBeam(BossBarColor.PINK)),
            ayeracoBeamPurple = BLOCKS.register("ayeraco_beam_purple", () -> new BlockAyeracoBeam(BossBarColor.PURPLE)),
            ayeracoBeamRed = BLOCKS.register("ayeraco_beam_red", () -> new BlockAyeracoBeam(BossBarColor.RED)),
            ayeracoBeamYellow = BLOCKS.register("ayeraco_beam_yellow", () -> new BlockAyeracoBeam(BossBarColor.YELLOW)),

    ayeracoSpawn = BLOCKS.register("ayeraco_spawn", () -> new BlockAyeracoSpawn());

    // Iceika

    public static final RegistryObject<Block>// Terrain
            frozenDirt = registerBlock("frozen_dirt", () -> new BlockModDirt(SNOW)),
            frozenGrass = registerBlock("frozen_grass", () -> new BlockModGrass( () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "frozen_dirt")), DIAMOND)),
            frozenStone = registerBlock("frozen_stone", () -> new BlockMod(GLOW_LICHEN, 1.5F, 6F)),
            frozenBricks = registerBlock("frozen_bricks", () -> new BlockMod(GLOW_LICHEN, 1.5F, 6F)),
            frozenLog = registerBlock("frozen_log", () -> new BlockModLog(ICE)),
            strippedFrozenLog = registerBlock("stripped_frozen_log", () -> new BlockModLog(ICE)),
            brittleLeaves = registerBlock("brittle_leaves", () -> new BlockModLeaves(WOOL, SoundType.GRASS)),
            frozenPlanks = registerBlock("frozen_planks", () -> new BlockModPlanks(ICE)),
            frozenStairs = registerBlock("frozen_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "frozen_planks")), 20, 5)),
            frozenSapling = registerBlock("frozen_sapling", () -> new BlockModSapling(ICE, () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "frozen_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "frozen_dirt")), new FrozenTreeGrower())),
            icicle = registerBlock("icicle", () -> new BlockIcicle()),
            thermalVent = registerBlock("thermal_vent", () -> new BlockThermalVent()),
            brittleMoss = registerBlock("brittle_moss", () -> new BlockBrittleMoss()),
            brittleGrass = registerBlock("brittle_grass", () -> new BlockBrittleGrass()),
            winterberryVinesHead = registerBlock("winterberry_vines_head", () -> new BlockWinterberryVinesHead(Properties.copy(Blocks.WEEPING_VINES).sound(SoundType.CAVE_VINES))),
            winterberryVinesBody = BLOCKS.register("winterberry_vines_body", () -> new BlockWinterberryVinesBody(Properties.copy(Blocks.WEEPING_VINES_PLANT).sound(SoundType.CAVE_VINES)));

    public static final RegistryObject<Block>// Structure blocks
            coalstone = registerBlock("coalstone", () -> new BlockMod(COLOR_GRAY, 1.5F, 6F)),
            coalstoneBricks = registerBlock("coalstone_bricks", () -> new BlockMod(COLOR_GRAY, 1.5F, 6F)),
            coalstoneStairs = registerBlock("coalstone_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "coalstone")), 0, 0)),
            coalstoneSlab = registerBlock("coalstone_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "coalstone")), 0, 0)),
            coalstoneFurnace = registerBlock("coalstone_furnace", () -> new BlockModInfiniFurnace(() -> BlockEntityRegistry.COALSTONE_FURNACE.get(), COLOR_GRAY)),
            frostedChest = registerWithRender("frosted_chest", () -> new BlockFrostedChest(), Rarity.COMMON),
            frostedGlass = registerBlock("frosted_glass", () -> new BlockModGlass()),
            icyBricks = registerBlock("icy_bricks", () -> new BlockMod(ICE, 1.5F, 6F)),
            icyStone = registerBlock("icy_stone", () -> new BlockMod(GLOW_LICHEN, 2F, 6F)),
            snowBricks = registerBlock("snow_bricks", () -> new BlockMod(SNOW, 1.5F, 6F)),
            steelDoor = registerBlock("steel_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(METAL).requiresCorrectToolForDrops().strength(5F).noOcclusion(), BlockSetType.IRON)),
            workshopBookcase = registerBlock("workshop_bookcase", () -> new BlockModBookshelf(COLOR_GRAY)),
            workshopCarpet = registerBlock("workshop_carpet", () -> new BlockMod(0.8F, 0.8F, TERRACOTTA_RED, SoundType.WOOL, 60, 30)),
            workshopLamp = registerBlock("workshop_lamp", () -> new BlockModLamp(COLOR_LIGHT_BLUE, SoundType.GLASS));

    public static final RegistryObject<Block>// Candy canes
            blueCandyCane = registerBlock("blue_candy_cane", () -> new BlockMod(Properties.of().mapColor(COLOR_BLUE).strength(0.75F).requiresCorrectToolForDrops())),
            greenCandyCane = registerBlock("green_candy_cane", () -> new BlockMod(Properties.of().mapColor(EMERALD).strength(0.75F).requiresCorrectToolForDrops())),
            pinkCandyCane = registerBlock("pink_candy_cane", () -> new BlockMod(Properties.of().mapColor(COLOR_MAGENTA).strength(0.75F).requiresCorrectToolForDrops())),
            redCandyCane = registerBlock("red_candy_cane", () -> new BlockMod(Properties.of().mapColor(FIRE).strength(0.75F).requiresCorrectToolForDrops())),
            yellowCandyCane = registerBlock("yellow_candy_cane", () -> new BlockMod(Properties.of().mapColor(COLOR_YELLOW).strength(0.75F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block>// Christmas lights
            blueFairyLights = registerBlock("blue_fairy_lights", () -> new BlockLights()),
            greenFairyLights = registerBlock("green_fairy_lights", () -> new BlockLights()),
            purpleFairyLights = registerBlock("purple_fairy_lights", () -> new BlockLights()),
            redFairyLights = registerBlock("red_fairy_lights", () -> new BlockLights()),
            yellowFairyLights = registerBlock("yellow_fairy_lights", () -> new BlockLights());

    // Chest
    public static final RegistryObject<Block> presentBox = registerWithRender("present_box", () -> new BlockPresentBox(), Rarity.COMMON);

    // Crops
    public static final RegistryObject<Block> winterberryBush = registerBlock("winterberry_bush", () -> new BlockWinterberryBush());

    // Other
    public static final RegistryObject<Block> iceikaFire = registerBlock("iceika_fire", () -> new BlockModFire());

    // Twilight dimensions

    public static final RegistryObject<Block>// Dirt
            edenDirt = registerBlock("eden_dirt", () -> new BlockModDirt(TERRACOTTA_YELLOW)),
            wildwoodDirt = registerBlock("wildwood_dirt", () -> new BlockModDirt(LAPIS)),
            apalachiaDirt = registerBlock("apalachia_dirt", () -> new BlockModDirt(COLOR_PURPLE)),
            skythernDirt = registerBlock("skythern_dirt", () -> new BlockModDirt(COLOR_LIGHT_GRAY)),
            mortumDirt = registerBlock("mortum_dirt", () -> new BlockModDirt(COLOR_GRAY));

    public static final RegistryObject<Block>// Grass
            edenGrass = registerBlock("eden_grass", () -> new BlockModGrass(edenDirt, COLOR_YELLOW)),
            wildwoodGrass = registerBlock("wildwood_grass", () -> new BlockModGrass(wildwoodDirt, WATER)),
            apalachiaGrass = registerBlock("apalachia_grass", () -> new BlockModGrass(apalachiaDirt, COLOR_PURPLE)),
            skythernGrass = registerBlock("skythern_grass", () -> new BlockModGrass(skythernDirt, SNOW)),
            mortumGrass = registerBlock("mortum_grass", () -> new BlockModGrass(mortumDirt, STONE));

    // Stone
    public static final RegistryObject<Block> twilightStone = registerBlock("twilight_stone", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_LIGHT_BLUE).strength(1.5F, 6F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block>// Ore
            edenOre = registerBlock("eden_ore", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_LIGHT_BLUE).requiresCorrectToolForDrops().strength(3F, 32F))),
            wildwoodOre = registerBlock("wildwood_ore", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_LIGHT_BLUE).requiresCorrectToolForDrops().strength(3F, 32F))),
            apalachiaOre = registerBlock("apalachia_ore", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_LIGHT_BLUE).requiresCorrectToolForDrops().strength(3F, 32F))),
            skythernOre = registerBlock("skythern_ore", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_LIGHT_BLUE).requiresCorrectToolForDrops().strength(3F, 32F))),
            mortumOre = registerBlock("mortum_ore", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_LIGHT_BLUE).requiresCorrectToolForDrops().strength(3F, 32F)));

    public static final RegistryObject<Block>// Sapling
            edenSapling = registerBlock("eden_sapling", () -> new BlockModSapling(SAND, () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_dirt")), new EdenTreeGrower())),
            wildwoodSapling = registerBlock("wildwood_sapling", () -> new BlockModSapling(COLOR_LIGHT_BLUE, () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_dirt")), new WildwoodTreeGrower())),
            apalachiaSapling = registerBlock("apalachia_sapling", () -> new BlockModSapling(COLOR_MAGENTA, () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_dirt")), new ApalachiaTreeGrower())),
            skythernSapling = registerBlock("skythern_sapling", () -> new BlockModSapling(WOOL, () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_dirt")), new SkythernTreeGrower())),
            mortumSapling = registerBlock("mortum_sapling", () -> new BlockModSapling(COLOR_GRAY, () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_dirt")), new MortumTreeGrower()));

    public static final RegistryObject<Block>// Logs
            edenLog = registerBlock("eden_log", () -> new BlockModLog(COLOR_YELLOW)),
            wildwoodLog = registerBlock("wildwood_log", () -> new BlockModLog(LAPIS)),
            apalachiaLog = registerBlock("apalachia_log", () -> new BlockModLog(COLOR_MAGENTA)),
            skythernLog = registerBlock("skythern_log", () -> new BlockModLog(QUARTZ)),
            mortumLog = registerBlock("mortum_log", () -> new BlockModLog(TERRACOTTA_PINK));

    public static final RegistryObject<Block>// Stripped Logs
            strippedEdenLog = registerBlock("stripped_eden_log", () -> new BlockModLog(COLOR_YELLOW)),
            strippedWildwoodLog = registerBlock("stripped_wildwood_log", () -> new BlockModLog(LAPIS)),
            strippedApalachiaLog = registerBlock("stripped_apalachia_log", () -> new BlockModLog(COLOR_MAGENTA)),
            strippedSkythernLog = registerBlock("stripped_skythern_log", () -> new BlockModLog(QUARTZ)),
            strippedMortumLog = registerBlock("stripped_mortum_log", () -> new BlockModLog(TERRACOTTA_PINK));

    public static final RegistryObject<Block>// Leaves
            edenLeaves = registerBlock("eden_leaves", () -> new BlockModLeaves(COLOR_YELLOW, SoundType.AZALEA_LEAVES)),
            wildwoodLeaves = registerBlock("wildwood_leaves", () -> new BlockModLeaves(COLOR_LIGHT_BLUE, SoundType.AZALEA_LEAVES)),
            apalachiaLeaves = registerBlock("apalachia_leaves", () -> new BlockModLeaves(COLOR_MAGENTA, SoundType.AZALEA_LEAVES)),
            skythernLeaves = registerBlock("skythern_leaves", () -> new BlockModLeaves(QUARTZ, SoundType.AZALEA_LEAVES)),
            mortumLeaves = registerBlock("mortum_leaves", () -> new BlockModLeaves(COLOR_BLACK, SoundType.AZALEA_LEAVES));

    public static final RegistryObject<Block>// Planks
            edenPlanks = registerBlock("eden_planks", () -> new BlockModPlanks(SAND)),
            wildwoodPlanks = registerBlock("wildwood_planks", () -> new BlockModPlanks(COLOR_LIGHT_BLUE)),
            apalachiaPlanks = registerBlock("apalachia_planks", () -> new BlockModPlanks(COLOR_MAGENTA)),
            skythernPlanks = registerBlock("skythern_planks", () -> new BlockModPlanks(WOOL)),
            mortumPlanks = registerBlock("mortum_planks", () -> new BlockModPlanks(COLOR_GRAY));

    public static final RegistryObject<Block>// Stairs
            edenStairs = registerBlock("eden_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_planks")), 20, 5)),
            wildwoodStairs = registerBlock("wildwood_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_planks")), 20, 5)),
            apalachiaStairs = registerBlock("apalachia_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_planks")), 20, 5)),
            skythernStairs = registerBlock("skythern_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_planks")), 20, 5)),
            mortumStairs = registerBlock("mortum_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_planks")), 20, 5));

    public static final RegistryObject<Block>//Doors
            edenDoor = registerBlock("eden_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_planks"))).strength(2.0F, 1.0F).noOcclusion(), BlockSetType.OAK)),
            wildwoodDoor = registerBlock("wildwood_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_planks"))).strength(2.0F, 1.0F).noOcclusion(), BlockSetType.DARK_OAK)),
            apalachiaDoor = registerBlock("apalachia_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_planks"))).strength(2.0F, 1.0F).noOcclusion(), BlockSetType.ACACIA)),
            skythernDoor = registerBlock("skythern_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_planks"))).strength(2.0F, 1.0F).noOcclusion(), BlockSetType.CRIMSON)),
            mortumDoor = registerBlock("mortum_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_planks"))).strength(2.0F, 1.0F).noOcclusion(), BlockSetType.MANGROVE)),
            divineDoor = registerBlock("divine_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_planks"))).strength(2.0F, 1.0F).noOcclusion(), BlockSetType.CHERRY)),
            frozenDoor = registerBlock("frozen_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_planks"))).strength(2.0F, 1.0F).noOcclusion(), BlockSetType.OAK));


    public static final RegistryObject<Block>//Trapdoors
            edenTrapdoor = registerBlock("eden_trapdoor", () -> new BlockModTrapdoor(SAND)),
            wildwoodTrapdoor = registerBlock("wildwood_trapdoor", () -> new BlockModTrapdoor(COLOR_LIGHT_BLUE)),
            apalachiaTrapdoor = registerBlock("apalachia_trapdoor", () -> new BlockModTrapdoor(COLOR_MAGENTA)),
            skythernTrapdoor = registerBlock("skythern_trapdoor", () -> new BlockModTrapdoor(WOOL)),
            mortumTrapdoor = registerBlock("mortum_trapdoor", () -> new BlockModTrapdoor(COLOR_GRAY)),
            divineTrapdoor = registerBlock("divine_trapdoor", () -> new BlockModTrapdoor(TERRACOTTA_LIGHT_GREEN)),
            frozenTrapdoor = registerBlock("frozen_trapdoor", () -> new BlockModTrapdoor(ICE)),
            eucalyptusTrapdoor = registerBlock("eucalyptus_trapdoor", () -> new BlockModTrapdoor(TERRACOTTA_WHITE));

    public static final RegistryObject<Block>//Buttons
            edenButton = registerBlock("eden_button", () -> new BlockModButton()),
            wildwoodButton = registerBlock("wildwood_button", () -> new BlockModButton()),
            apalachiaButton = registerBlock("apalachia_button", () -> new BlockModButton()),
            skythernButton = registerBlock("skythern_button", () -> new BlockModButton()),
            mortumButton = registerBlock("mortum_button", () -> new BlockModButton()),
            divineButton = registerBlock("divine_button", () -> new BlockModButton()),
            frozenButton = registerBlock("frozen_button", () -> new BlockModButton()),
            eucalyptusButton = registerBlock("eucalyptus_button", () -> new BlockModButton());

    public static final RegistryObject<Block>//Pressure Plate
            edenPressurePlate = registerBlock("eden_pressure_plate", () -> new BlockModPressurePlate(SAND)),
            wildwoodPressurePlate = registerBlock("wildwood_pressure_plate", () -> new BlockModPressurePlate(COLOR_LIGHT_BLUE)),
            apalachiaPressurePlate = registerBlock("apalachia_pressure_plate", () -> new BlockModPressurePlate(COLOR_MAGENTA)),
            skythernPressurePlate = registerBlock("skythern_pressure_plate", () -> new BlockModPressurePlate(WOOL)),
            mortumPressurePlate = registerBlock("mortum_pressure_plate", () -> new BlockModPressurePlate(COLOR_GRAY)),
            divinePressurePlate = registerBlock("divine_pressure_plate", () -> new BlockModPressurePlate(TERRACOTTA_LIGHT_GREEN)),
            frozenPressurePlate = registerBlock("frozen_pressure_plate", () -> new BlockModPressurePlate(ICE)),
            eucalyptusPressurePlate = registerBlock("eucalyptus_pressure_plate", () -> new BlockModPressurePlate(TERRACOTTA_WHITE));

    public static final RegistryObject<Block>//Fence
            edenFence = registerBlock("eden_fence", () -> new BlockModFence(SAND)),
            wildwoodFence = registerBlock("wildwood_fence", () -> new BlockModFence(COLOR_LIGHT_BLUE)),
            apalachiaFence = registerBlock("apalachia_fence", () -> new BlockModFence(COLOR_MAGENTA)),
            skythernFence = registerBlock("skythern_fence", () -> new BlockModFence(WOOL)),
            mortumFence = registerBlock("mortum_fence", () -> new BlockModFence(COLOR_GRAY)),
            divineFence = registerBlock("divine_fence", () -> new BlockModFence(TERRACOTTA_LIGHT_GREEN)),
            frozenFence = registerBlock("frozen_fence", () -> new BlockModFence(ICE)),
            eucalyptusFence = registerBlock("eucalyptus_fence", () -> new BlockModFence(TERRACOTTA_WHITE));

    public static final RegistryObject<Block>//Fence Gate
            edenFenceGate = registerBlock("eden_fence_gate", () -> new BlockModGate(SAND)),
            wildwoodFenceGate = registerBlock("wildwood_fence_gate", () -> new BlockModGate(COLOR_LIGHT_BLUE)),
            apalachiaFenceGate = registerBlock("apalachia_fence_gate", () -> new BlockModGate(COLOR_MAGENTA)),
            skythernFenceGate = registerBlock("skythern_fence_gate", () -> new BlockModGate(WOOL)),
            mortumFenceGate = registerBlock("mortum_fence_gate", () -> new BlockModGate(COLOR_GRAY)),
            divineFenceGate = registerBlock("divine_fence_gate", () -> new BlockModGate(TERRACOTTA_LIGHT_GREEN)),
            frozenFenceGate = registerBlock("frozen_fence_gate", () -> new BlockModGate(ICE)),
            eucalyptusFenceGate = registerBlock("eucalyptus_fence_gate", () -> new BlockModGate(TERRACOTTA_WHITE));

    public static final RegistryObject<Block>// Compressed blocks
            edenBlock = registerBlock("eden_block", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_ORANGE).requiresCorrectToolForDrops().strength(1.5F, 6F))),
            wildwoodBlock = registerBlock("wildwood_block", () -> new BlockMod(Properties.of().mapColor(LAPIS).requiresCorrectToolForDrops().strength(1.5F, 6F))),
            apalachiaBlock = registerBlock("apalachia_block", () -> new BlockMod(Properties.of().mapColor(COLOR_MAGENTA).requiresCorrectToolForDrops().strength(1.5F, 6F))),
            skythernBlock = registerBlock("skythern_block", () -> new BlockMod(Properties.of().mapColor(WOOL).requiresCorrectToolForDrops().strength(1.5F, 6F))),
            mortumBlock = registerBlock("mortum_block", () -> new BlockMod(Properties.of().mapColor(COLOR_GRAY).requiresCorrectToolForDrops().strength(1.5F, 6F)));

    // Twilight dimension ground foliage
    public static final RegistryObject<Block>// Eden
            sunBlossom = registerBlock("sun_blossom", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_grass")), 0.9, 0.6, COLOR_YELLOW)),
            sunbloom = registerBlock("sunbloom", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_grass")), TERRACOTTA_YELLOW)),
            edenBrush = registerBlock("eden_brush", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_grass")), COLOR_YELLOW));

    public static final RegistryObject<Block>// Wildwood
            moonBud = registerBlock("moon_bud", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_grass")), 0.8, 0.7, COLOR_LIGHT_BLUE)),
            moonlightFern = registerBlock("moonlight_fern", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_grass")), COLOR_LIGHT_BLUE)),
            wildwoodTallgrass = registerBlock("wildwood_tallgrass", () -> new BlockModDoublePlant(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_grass")), COLOR_LIGHT_BLUE));

    public static final RegistryObject<Block>// Apalachia
            duskBloom = registerBlock("dusk_bloom", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_grass")), 0.5, 0.5, COLOR_PURPLE)),
            duskFlower = registerBlock("dusk_flower", () -> new BlockModDoublePlant(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_grass")), BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).mapColor(COLOR_PURPLE).noOcclusion().instabreak().sound(SoundType.ROOTS).offsetType(BlockBehaviour.OffsetType.XZ).noCollission().randomTicks())),
            apalachiaTallgrass = registerBlock("apalachia_tallgrass", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_grass")), COLOR_PURPLE));

    public static final RegistryObject<Block>// Skythern
            dustBrambles = registerBlock("dust_brambles", () -> new BlockBrambles(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_grass")), WOOL)),
            dustLily = registerBlock("dust_lily", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_grass")), WOOL)),
            skythernBrush = registerBlock("skythern_brush", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_grass")), WOOL));

    public static final RegistryObject<Block>// Mortum
            demonBrambles = registerBlock("demon_brambles", () -> new BlockBrambles(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_grass")), COLOR_GRAY)),
            eyePlant = registerBlock("eye_plant", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_grass")), 0.5, 0.5, COLOR_GRAY)),
            mortumBrush = registerBlock("mortum_brush", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_grass")), COLOR_GRAY));

    public static final RegistryObject<Block>// Crops
            moonbulbPlant = registerBlock("moonbulb_plant", () -> new BlockMoonbulb()),
            pinkGlowbonePlant = registerBlock("pink_glowbone_plant", () -> new BlockPinkGlowbone()),
            purpleGlowbonePlant = registerBlock("purple_glowbone_plant", () -> new BlockPurpleGlowbone()),
            skyPlant = registerBlock("sky_plant", () -> new BlockSkyPlant());

    // Vine
    public static final RegistryObject<Block> wildwoodVine = registerBlock("wildwood_vine", () -> new BlockModVine(COLOR_LIGHT_BLUE));

    public static final RegistryObject<Block>// Other
            blueFire = registerBlock("blue_fire", () -> new BlockModFire()),

    edenTorch = BLOCKS.register("eden_torch", () -> new BlockModTorch(FLAME)),

    edenWallTorch = BLOCKS.register("eden_wall_torch", () -> new BlockModWallTorch(FLAME)),
            edenChest = registerWithRender("eden_chest", () -> new BlockEdenChest(), Rarity.COMMON),
            truffle = registerBlock("truffle", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_BROWN).strength(1.0F).pushReaction(PushReaction.DESTROY).sound(SoundType.WOOD)));

    // Arcana

    public static final RegistryObject<Block>// Dirt
            arcaniteDirt = registerBlock("arcanite_dirt", () -> new BlockModDirt(COLOR_BLUE)),
            arcaniteSand = registerBlock("arcanite_sand", () -> new SandBlock(7579884, Properties.copy(Blocks.SAND).mapColor(ICE))),
            arcanicSand = registerBlock("arcanic_sand", () -> new SandBlock(7579884, Properties.copy(Blocks.SAND).mapColor(MapColor.COLOR_LIGHT_BLUE))),
            arcanium_rich_sand = registerBlock("arcanium_rich_sand", () -> new SandBlock(7579884, Properties.copy(Blocks.SAND).mapColor(MapColor.COLOR_BLUE)));

    public static final RegistryObject<Block>// Grass
            arcaniteGrass = registerBlock("arcanite_grass", () -> new BlockArcaniteGrass()),
            arcaniteMoss = registerBlock("arcanite_moss", () -> new BlockModMoss(Properties.copy(Blocks.MOSS_BLOCK).mapColor(MapColor.COLOR_LIGHT_BLUE)));

    // Ore
    public static final RegistryObject<Block> rawArcanium = registerBlock("raw_arcanium", () -> new BlockMod(Properties.of().mapColor(COLOR_BLACK).requiresCorrectToolForDrops().strength(5F, 6F)));

    // Storage block
    public static final RegistryObject<Block> arcaniumBlock = registerBlock("arcanium_block", () -> new BlockMod(Properties.of().mapColor(COLOR_LIGHT_BLUE).requiresCorrectToolForDrops().strength(5F, 6F).sound(SoundType.METAL)));

    // Structure blocks
    public static final RegistryObject<Block>// Normal
            ancientBricks = registerBlock("ancient_bricks", () -> new BlockModUnbreakable(WARPED_NYLIUM)),
            ancientBrickStairs = registerBlock("ancient_brick_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks")), 0, 0)),
            ancientStone = registerBlock("ancient_stone", () -> new BlockModUnbreakable(COLOR_GRAY)),
            ancientTile = registerBlock("ancient_tile", () -> new BlockModUnbreakable(COLOR_BLUE)),
            arcaniteTubes = registerBlock("arcanite_tubes", () -> new BlockModLadder()),
            arcaniteLadder = registerBlock("arcanite_ladder", () -> new BlockModLadder()),
            arcaniumMetal = registerBlock("arcanium_metal", () -> new BlockModPillar(TERRACOTTA_BLUE, -1F, 3600000F, SoundType.METAL)),
            arcaniumPower = registerBlock("arcanium_power", () -> new BlockModUnbreakable(COLOR_GRAY)),
            darkDegradedBrick = registerBlock("dark_degraded_brick", () -> new BlockModUnbreakable(COLOR_BLACK)),
            degradedBricks = registerBlock("degraded_bricks", () -> new BlockModUnbreakable(COLOR_BLUE)),
            degradedBrickStairs = registerBlock("degraded_brick_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks")), 0, 0)),
            dungeonBookshelf = registerBlock("dungeon_bookshelf", () -> new BlockModBookshelf(COLOR_BLUE)),
            dungeonLamp = registerBlock("dungeon_lamp", () -> new BlockModUnbreakable(QUARTZ, true)),
            heatTrap = registerBlock("heat_trap", () -> new BlockHeatTrap()),
            lightDegradedBrick = registerBlock("light_degraded_brick", () -> new BlockModUnbreakable(COLOR_CYAN)),
            soulSludge = registerBlock("soul_sludge", () -> new BlockModUnbreakable(Properties.copy(Blocks.SOUL_SAND).strength(-1F, 3600000F).mapColor(MapColor.COLOR_GRAY))),
            soulStone = registerBlock("soul_stone", () -> new BlockModUnbreakable(TERRACOTTA_BLUE)),
            battleBricks = registerBlock("battle_bricks", () -> new BlockModUnbreakable(FIRE)),
            gildedBricks = registerBlock("gilded_bricks", () -> new BlockModUnbreakable(COLOR_ORANGE));

    public static final RegistryObject<Block>// Breakable
            ancientBricksBreakable = registerBlock("ancient_bricks_breakable", () -> new BlockMod(Properties.of().mapColor(WARPED_NYLIUM).requiresCorrectToolForDrops().strength(1.5F, 6F))),
            ancientBrickStairsBreakable = registerBlock("ancient_brick_stairs_breakable", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks_breakable")), 0, 0)),
            ancientBrickSlabBreakable = registerBlock("ancient_brick_slab_breakable", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks_breakable")), 0, 0)),
            ancientBrickWallBreakable = registerBlock("ancient_brick_wall_breakable", () -> new BlockModWall(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks_breakable")))),
            ancientStoneBreakable = registerBlock("ancient_stone_breakable", () -> new BlockMod(Properties.of().mapColor(COLOR_GRAY).requiresCorrectToolForDrops().strength(1.5F, 6F))),
            ancientTileBreakable = registerBlock("ancient_tile_breakable", () -> new BlockMod(Properties.of().mapColor(COLOR_BLUE).requiresCorrectToolForDrops().strength(2F, 6F))),
            arcaniumMetalBreakable = registerBlock("arcanium_metal_breakable", () -> new BlockModPillar(TERRACOTTA_BLUE, 5F, 6F, SoundType.METAL)),
            arcaniumPowerBreakable = registerBlock("arcanium_power_breakable", () -> new BlockMod(Properties.of().mapColor(COLOR_GRAY).requiresCorrectToolForDrops().strength(2F, 6F))),
            degradedBricksBreakable = registerBlock("degraded_bricks_breakable", () -> new BlockMod(Properties.of().mapColor(COLOR_BLUE).requiresCorrectToolForDrops().strength(1.5F, 6F))),
            degradedBrickStairsBreakable = registerBlock("degraded_brick_stairs_breakable", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks_breakable")), 0, 0)),
            degradedBrickSlabBreakable = registerBlock("degraded_brick_slab_breakable", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks_breakable")), 0, 0)),
            degradedBrickWallBreakable = registerBlock("degraded_brick_wall_breakable", () -> new BlockModWall(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks_breakable")))),
            dungeonLampBreakable = registerBlock("dungeon_lamp_breakable", () -> new BlockMod(Properties.of().mapColor(QUARTZ).strength(0.3F).sound(SoundType.GLASS).lightLevel((p_235464_0_) -> {
                return 15;}))),
            soulSludgeBreakable = registerBlock("soul_sludge_breakable", () -> new BlockMod(Properties.copy(Blocks.SOUL_SAND).mapColor(MapColor.COLOR_GRAY))),
            soulStoneBreakable = registerBlock("soul_stone_breakable", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_BLUE).requiresCorrectToolForDrops().strength(1.5F, 6F))),
            arcaniteStone = registerBlock("arcanite_stone", () -> new BlockMod(Properties.of().mapColor(COLOR_LIGHT_BLUE).requiresCorrectToolForDrops().strength(1.5F, 6F)));

    public static final RegistryObject<Block>// Door
            ancientBrickDoor = registerBlock("ancient_brick_door", () -> new BlockArcanaDoor(WARPED_NYLIUM, new ResourceLocation(MODID, "ancient_key"))),
            degradedBrickDoor = registerBlock("degraded_brick_door", () -> new BlockArcanaDoor(COLOR_BLUE, new ResourceLocation(MODID, "degraded_key"))),
            soulSludgeDoor = registerBlock("soul_sludge_door", () -> new BlockArcanaDoor(COLOR_GRAY, new ResourceLocation(MODID, "sludge_key"))),
            soulStoneDoor = registerBlock("soul_stone_door", () -> new BlockArcanaDoor(TERRACOTTA_BLUE, new ResourceLocation(MODID, "soul_key")));

    // Utility
    public static final RegistryObject<Block> arcaniumExtractor = registerWithRender("arcanium_extractor", () -> new BlockArcaniumExtractor(), Rarity.RARE);

    public static final RegistryObject<Block>// Boss altars
            dramixAltar = registerWithRender("dramix_altar", () -> new BlockModAltar(CRIMSON_HYPHAE), Rarity.COMMON),
            parasectaAltar = registerWithRender("parasecta_altar", () -> new BlockModAltar(TERRACOTTA_BROWN), Rarity.COMMON);

    public static final RegistryObject<Block>// Stained glass
            stainedGlass = registerBlock("stained_glass", () -> new BlockModGlass()),
            stainedGlass2 = registerBlock("stained_glass2", () -> new BlockModGlass()),
            stainedGlass3 = registerBlock("stained_glass3", () -> new BlockModGlass()),
            stainedGlass4 = registerBlock("stained_glass4", () -> new BlockModGlass()),
            stainedGlass5 = registerBlock("stained_glass5", () -> new BlockModGlass()),
            stainedGlass6 = registerBlock("stained_glass6", () -> new BlockModGlass()),
            stainedGlass7 = registerBlock("stained_glass7", () -> new BlockModGlass()),
            stainedGlass8 = registerBlock("stained_glass8", () -> new BlockModGlass());

    public static final RegistryObject<Block>// Eucalyptus
            eucalyptusLog = registerBlock("eucalyptus_log", () -> new BlockModLog(TERRACOTTA_WHITE)),
            strippedEucalyptusLog = registerBlock("stripped_eucalyptus_log", () -> new BlockModLog(TERRACOTTA_WHITE)),
            eucalyptusPlanks = registerBlock("eucalyptus_planks", () -> new BlockModPlanks(TERRACOTTA_WHITE)),
            eucalyptusStairs = registerBlock("eucalyptus_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eucalyptus_planks")), 20, 5)),
            eucalyptusDoor = registerBlock("eucalyptus_door", () -> new DoorBlock(BlockBehaviour.Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eucalyptus_planks"))).strength(2.0F, 1.0F).noOcclusion(), BlockSetType.BIRCH));

    public static final RegistryObject<Block>// Plants
            aquamarinePlant = registerBlock("aquamarine_plant", () -> new BlockModCrop(3, new ResourceLocation(MODID, "aquamarine_seeds"))),
            eucalyptusPlant = registerBlock("eucalyptus_plant", () -> new BlockModCrop(3, new ResourceLocation(MODID, "eucalyptus_root_seeds"))),
            firestockPlant = registerBlock("firestock_plant", () -> new BlockFirestock()),
            hitchakPlant = registerBlock("hitchak_plant", () -> new BlockModCrop(3, new ResourceLocation(MODID, "hitchak_seeds"))),
            lamonaPlant = registerBlock("lamona_plant", () -> new BlockModCrop(3, new ResourceLocation(MODID, "lamona_seeds"))),
            marsinePlant = registerBlock("marsine_plant", () -> new BlockModCrop(2, new ResourceLocation(MODID, "marsine_seeds"))),
            pinflyPlant = registerBlock("pinfly_plant", () -> new BlockPinfly()),
            veiloPlant = registerBlock("veilo_plant", () -> new BlockModCrop(3, new ResourceLocation(MODID, "veilo_seeds"))),
            arcaniteVinesHead = registerBlock("arcanite_vines_head", () -> new BlockArcaniteVinesHead(Properties.copy(Blocks.WEEPING_VINES).sound(SoundType.CAVE_VINES))),
            arcaniteVinesBody = BLOCKS.register("arcanite_vines_body", () -> new BlockArcaniteVinesBody(Properties.copy(Blocks.WEEPING_VINES_PLANT).sound(SoundType.CAVE_VINES))),
            arcanaBrush = registerBlock("arcana_brush", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arcanite_sand")), COLOR_BLUE)),
            arcanaBush = registerBlock("arcana_bush", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arcanite_sand")), COLOR_BLUE)),
            gemOfTheDunes = registerBlock("gem_of_the_dunes", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arcanite_sand")), COLOR_LIGHT_BLUE), Rarity.EPIC);

    public static final RegistryObject<Block>// Furnace
            greenlightFurnace = registerBlock("greenlight_furnace", () -> new BlockModFurnace(() -> BlockEntityRegistry.GREENLIGHT_FURNACE.get(), TERRACOTTA_LIGHT_GREEN), Rarity.COMMON),
            oceanfireFurnace = registerBlock("oceanfire_furnace", () -> new BlockModInfiniFurnace(() -> BlockEntityRegistry.OCEANFIRE_FURNACE.get(), COLOR_LIGHT_BLUE), Rarity.COMMON),
            moltenFurnace = registerBlock("molten_furnace", () -> new BlockModInfiniFurnace(() -> BlockEntityRegistry.MOLTEN_FURNACE.get(), TERRACOTTA_LIGHT_GRAY), Rarity.COMMON),
            whitefireFurnace = registerBlock("whitefire_furnace", () -> new BlockModInfiniFurnace(() -> BlockEntityRegistry.WHITEFIRE_FURNACE.get(), SNOW), Rarity.COMMON),
            moonlightFurnace = registerBlock("moonlight_furnace", () -> new BlockModFurnace(() -> BlockEntityRegistry.MOONLIGHT_FURNACE.get(), COLOR_BLUE), Rarity.COMMON),
            demonFurnace = registerWithRender("demon_furnace", () -> new BlockDemonFurnace(), Rarity.COMMON);

    public static final RegistryObject<Block>// Miscellaneous utility
            acceleron = registerBlock("acceleron", () -> new BlockAcceleron(), Rarity.UNCOMMON),

    arcaniumTorch = BLOCKS.register("arcanium_torch", () -> new BlockModTorch(FLAME)),

    arcaniumWallTorch = BLOCKS.register("arcanium_wall_torch", () -> new BlockModWallTorch(FLAME)),
            elevantium = registerBlock("elevantium", () -> new BlockElevantium(), Rarity.UNCOMMON),
            starBridge = registerBlock("star_bridge", () -> new BlockModBridge()),

    encagedCaptainMerik = registerBlock("encaged_captain_merik", () -> new BlockModMobCage(new ResourceLocation(MODID, "captain_merik"), new ResourceLocation(MODID, "firestock"))),
            encagedDatticon = registerBlock("encaged_datticon", () -> new BlockModMobCage(new ResourceLocation(MODID, "datticon"), new ResourceLocation(MODID, "aquamarine"))),
            encagedKazari = registerBlock("encaged_kazari", () -> new BlockModMobCage(new ResourceLocation(MODID, "kazari"), new ResourceLocation(MODID, "lamona"))),
            encagedLeorna = registerBlock("encaged_leorna", () -> new BlockModMobCage(new ResourceLocation(MODID, "leorna"), new ResourceLocation(MODID, "hitchak"))),
            encagedLordVatticus = registerBlock("encaged_lord_vatticus", () -> new BlockModMobCage(new ResourceLocation(MODID, "lord_vatticus"), new ResourceLocation(MODID, "marsine"))),
            encagedWarGeneral = registerBlock("encaged_war_general", () -> new BlockModMobCage(new ResourceLocation(MODID, "war_general"), new ResourceLocation(MODID, "pinfly"))),
            encagedZelus = registerBlock("encaged_zelus", () -> new BlockModMobCage(new ResourceLocation(MODID, "zelus"), new ResourceLocation(MODID, "veilo")));

    // Vethea

    public static final RegistryObject<Block>// Terrain
            dreamDirt = registerBlock("dream_dirt", () -> new BlockModDirt(COLOR_CYAN)),
            dreamGrass = registerBlock("dream_grass", () -> new BlockDreamGrass(WARPED_WART_BLOCK)),
            dreamStone = registerBlock("dream_stone", () -> new BlockMod(Properties.of().mapColor(COLOR_CYAN).strength(1.5F, 6F))),
            evergrass = registerBlock("evergrass", () -> new BlockDreamGrass(COLOR_MAGENTA)),
            flameGrass = registerBlock("flame_grass", () -> new BlockDreamGrass(COLOR_ORANGE)),
            scorchedGrass = registerBlock("scorched_grass", () -> new BlockModGrass(() -> dreamStone.get()));

    public static final RegistryObject<Block>// Logs
            dreamwoodLog = registerBlock("dreamwood_log", () -> new BlockModLog(COLOR_LIGHT_BLUE)),
            firewoodLog = registerBlock("firewood_log", () -> new BlockModLog(FIRE)),
            hyrewoodLog = registerBlock("hyrewood_log", () -> new BlockModLog(COLOR_BLUE)),
            mintwoodLog = registerBlock("mintwood_log", () -> new BlockModLog(DIAMOND));

    public static final RegistryObject<Block>// Stripped Logs
            strippedDreamwoodLog = registerBlock("stripped_dreamwood_log", () -> new BlockModLog(COLOR_LIGHT_BLUE)),
            strippedFirewoodLog = registerBlock("stripped_firewood_log", () -> new BlockModLog(FIRE)),
            strippedHyrewoodLog = registerBlock("stripped_hyrewood_log", () -> new BlockModLog(COLOR_BLUE)),
            strippedMintwoodLog = registerBlock("stripped_mintwood_log", () -> new BlockModLog(DIAMOND));

    public static final RegistryObject<Block>// Leaves
            dreamwoodLeaves = registerBlock("dreamwood_leaves", () -> new BlockModLeaves(COLOR_CYAN, SoundType.GRASS)),
            firewoodLeaves = registerBlock("firewood_leaves", () -> new BlockModLeaves(CRIMSON_NYLIUM, SoundType.GRASS)),
            hyrewoodLeaves = registerBlock("hyrewood_leaves", () -> new BlockModLeaves(COLOR_BLUE, SoundType.GRASS)),
            mintwoodLeaves = registerBlock("mintwood_leaves", () -> new BlockModLeaves(WARPED_WART_BLOCK, SoundType.GRASS));

    public static final RegistryObject<Block>// Ground foliage
            bulbatobe = registerBlock("bulbatobe", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            cracklespike = registerBlock("cracklespike", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            dreamglow = registerBlock("dreamglow", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            fernite = registerBlock("fernite", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            greenDulah = registerBlock("green_dulah", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            greenGemtop = registerBlock("green_gemtop", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            purpleGemtop = registerBlock("purple_gemtop", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            shimmer = registerBlock("shimmer", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            shineGrass = registerBlock("shine_grass", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            yellowDulah = registerBlock("yellow_dulah", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN));

    public static final RegistryObject<Block>// Vines
            weedwoodVine = registerBlock("weedwood_vine", () -> new BlockModVine(COLOR_BLUE)),
            blossomedWeedwoodVine = registerBlock("blossomed_weedwood_vine", () -> new BlockModVine(COLOR_BLUE));

    public static final RegistryObject<Block>// Building blocks
            darkDreamBricks = registerBlock("dark_dream_bricks", () -> new BlockMod(Properties.of().mapColor(COLOR_BLUE).requiresCorrectToolForDrops().strength(1.5F, 6F))),
            lightDreamBricks = registerBlock("light_dream_bricks", () -> new BlockMod(Properties.of().mapColor(LAPIS).requiresCorrectToolForDrops().strength(1.5F, 6F))),
            redDreamBricks = registerBlock("red_dream_bricks", () -> new BlockMod(Properties.of().mapColor(FIRE).requiresCorrectToolForDrops().strength(1.5F, 6F))),
            smoothGlass = registerBlock("smooth_glass", () -> new BlockModGlass());

    // Door
    public static final RegistryObject<Block> barredDoor = registerBlock("barred_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(PLANT).requiresCorrectToolForDrops().strength(5F).noOcclusion(), BlockSetType.IRON));

    public static final RegistryObject<Block>// Lighting
            fireCrystal = registerBlock("fire_crystal", () -> new BlockLightCrystal(COLOR_RED)),
            firelight = registerBlock("firelight", () -> new BlockLightCrystal(COLOR_BLUE));

    // Structure
    public static final RegistryObject<Block>// General
            dreamLamp = registerBlock("dream_lamp", () -> new BlockDreamLamp()),
            everstone = registerBlock("everstone", () -> new BlockModUnbreakable(PLANT)),
            darkEverstone = registerBlock("dark_everstone", () -> new BlockModUnbreakable(COLOR_BLACK)),
            whiteEverstone = registerBlock("white_everstone", () -> new BlockModUnbreakable(WOOL));

    public static final RegistryObject<Block>// Crypt
            blackHungerstone = registerBlock("black_hungerstone", () -> new BlockModUnbreakable(COLOR_BLACK)),
            greenHungerstone = registerBlock("green_hungerstone", () -> new BlockModUnbreakable(PLANT)),
            cryptFloor = registerBlock("crypt_floor", () -> new BlockModUnbreakable(TERRACOTTA_GREEN)),
            cryptWall = registerBlock("crypt_wall", () -> new BlockModUnbreakable(PODZOL)),
            metalCaging = registerBlock("metal_caging", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_GREEN).requiresCorrectToolForDrops().strength(5F).sound(SoundType.METAL).noOcclusion()));

    // Village
    public static final RegistryObject<Block> villageLamp = registerBlock("village_lamp", () -> new BlockModLamp(TERRACOTTA_RED, SoundType.GLASS));

    public static final RegistryObject<Block>// Hive
            cellLamp = registerBlock("cell_lamp", () -> new BlockModLamp(COLOR_LIGHT_GREEN, SoundType.GLASS)),
            hiveWall = registerBlock("hive_wall", () -> new BlockMod(Properties.of().mapColor(PLANT).strength(0.3F).sound(SoundType.GLASS).lightLevel((state) -> {
                return 7;
            })));

    public static final RegistryObject<Block>// Karos Madhouse
            blackKarosBricks = registerBlock("black_karos_bricks", () -> new BlockModUnbreakable(COLOR_GRAY)),
            blueKarosBricks = registerBlock("blue_karos_bricks", () -> new BlockModUnbreakable(COLOR_BLUE)),
            helioticBeam = registerBlock("heliotic_beam", () -> new BlockHelioticBeam()),
            karosDispenser = registerBlock("karos_dispenser", () -> new BlockKarosDispenser()),
            karosHeatTileGreen = registerBlock("karos_heat_tile_green", () -> new BlockKarosHeatTile(EMERALD)),
            karosHeatTileRed = registerBlock("karos_heat_tile_red", () -> new BlockKarosHeatTile(FIRE));

    public static final RegistryObject<Block>// Lunic Garden
            lunaBricks = registerBlock("luna_bricks", () -> new BlockMod(Properties.of().mapColor(COLOR_BLUE).requiresCorrectToolForDrops().strength(2F, 6F))),
            lunaStone = registerBlock("luna_stone", () -> new BlockMod(Properties.of().mapColor(COLOR_BLUE).requiresCorrectToolForDrops().strength(2F, 6F)));

    public static final RegistryObject<Block>// Raglok Chamber
            chamberWall = registerBlock("chamber_wall", () -> new BlockModUnbreakable(COLOR_BROWN)),
            shiftedChamberWall = registerBlock("shifted_chamber_wall", () -> new BlockModUnbreakable(COLOR_BROWN)),
            stackedChamberWall = registerBlock("stacked_chamber_wall", () -> new BlockModUnbreakable(COLOR_BROWN));

    // Wreck Hall
    public static final RegistryObject<Block> hallWall = registerBlock("hall_wall", () -> new BlockModUnbreakable(CRIMSON_HYPHAE));

    // Utility
    public static final RegistryObject<Block> infusionTable = registerBlock("infusion_table", () -> new BlockInfusionTable());

    // Hive egg
    public static final RegistryObject<Block> hiveEgg = registerBlock("hive_egg", () -> new BlockHiveEgg());

    public static final RegistryObject<Block>// Boss altars
            karosAltar = registerBlock("karos_altar", () -> new BlockKarosAltar(WARPED_WART_BLOCK)),
            lunicAltar = registerBlock("lunic_altar", () -> new BlockLunicAltar(COLOR_BLUE)),
            quadroticAltar = registerBlock("quadrotic_altar", () -> new BlockQuadroticAltar(COLOR_BLUE)),
            raglokAltar = registerBlock("raglok_altar", () -> new BlockRaglokAltar(COLOR_BROWN)),
            wreckAltar = registerBlock("wreck_altar", () -> new BlockWreckAltar(COLOR_RED));

    public static final RegistryObject<Block>// Acid
            acidBlock = registerBlock("acid_block", () -> new BlockAcid(true)),
            bacterialAcid = registerBlock("bacterial_acid", () -> new BlockAcid(false)),
            lunicAcid = registerBlock("lunic_acid", () -> new BlockAcid(true));

    public static final RegistryObject<Block>// Nightmare bed
            nightmareBed = BLOCKS.register("nightmare_bed_block", () -> new BlockNightmareBed());

    // Portal blocks
    public static final RegistryObject<Block>// Portal
            iceikaPortal = registerBlock("iceika_portal", () -> new BlockModPortal(Blocks.SNOW_BLOCK)),
            edenPortal = registerBlock("eden_portal", () -> new BlockModPortal(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "divine_rock")))),
            wildwoodPortal = registerBlock("wildwood_portal", () -> new BlockModPortal(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_block")))),
            apalachiaPortal = registerBlock("apalachia_portal", () -> new BlockModPortal(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_block")))),
            skythernPortal = registerBlock("skythern_portal", () -> new BlockModPortal(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_block")))),
            mortumPortal = registerBlock("mortum_portal", () -> new BlockModPortal(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_block")))),
            vetheaPortal = registerBlock("vethea_portal", () -> new BlockModPortal(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_block"))));

    public static final RegistryObject<Block>// Arcana blocks
            arcanaPortal = registerBlock("arcana_portal", () -> new BlockArcanaPortal()),
            arcanaPortalFrame = registerBlock("arcana_portal_frame", () -> new BlockArcanaPortalFrame(5F, 6F)),
            arcanaHardPortalFrame = registerBlock("arcana_hard_portal_frame", () -> new BlockArcanaPortalFrame(-1, 3600000F));

    public static final RegistryObject<Block>// Slabs
            edenSlab = registerBlock("eden_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_planks")), 20, 5)),
            wildwoodSlab = registerBlock("wildwood_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_planks")), 20, 5)),
            apalachiaSlab = registerBlock("apalachia_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_planks")), 20, 5)),
            skythernSlab = registerBlock("skythern_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_planks")), 20, 5)),
            mortumSlab = registerBlock("mortum_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_planks")), 20, 5)),
            divineSlab = registerBlock("divine_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "divine_planks")), 20, 5)),
            frozenSlab = registerBlock("frozen_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "frozen_planks")), 20, 5)),
            eucalyptusSlab = registerBlock("eucalyptus_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eucalyptus_planks")), 20, 5)),
            ancientBrickSlab = registerBlock("ancient_brick_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks")), 0, 0)),
            degradedBrickSlab = registerBlock("degraded_brick_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks")), 0, 0));

    public static final RegistryObject<Block>// Walls
            ancientBrickWall = registerBlock("ancient_brick_wall", () -> new BlockModWall(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks")))),
            degradedBrickWall = registerBlock("degraded_brick_wall", () -> new BlockModWall(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks"))));

    public static final RegistryObject<Block> dungeonAir = registerTablessBlock("dungeon_air", () -> new BlockModDungeonAir());

    //Flower Pots
    public static final RegistryObject<FlowerPotBlock>
            bulbatobePot = registerFlowerPot("bulbatobe_pot", bulbatobe),
            cracklespikePot = registerFlowerPot("cracklespike_pot", cracklespike),
            dreamglowPot = registerFlowerPot("dreamglow_pot", dreamglow),
            fernitePot = registerFlowerPot("fernite_pot", fernite),
            greenDulahPot = registerFlowerPot("green_dulah_pot", greenDulah),
            greenGemtopPot = registerFlowerPot("green_gemtop_pot", greenGemtop),
            purpleGemtopPot = registerFlowerPot("purple_gemtop_pot", purpleGemtop),
            shimmerPot = registerFlowerPot("shimmer_pot", shimmer),
            shineGrassPot = registerFlowerPot("shine_grass_pot", shineGrass),
            yellowDulahPot = registerFlowerPot("yellow_dulah_pot", yellowDulah),
            arcanaBrushPot = registerFlowerPot("arcana_brush_pot", arcanaBrush),
            arcanaBushPot = registerFlowerPot("arcana_bush_pot", arcanaBush),
            gemOfTheDunesPot = registerFlowerPot("gem_of_the_dunes_pot", gemOfTheDunes),
            demonBramblesPot = registerFlowerPot("demon_brambles_pot", demonBrambles),
            eyePlantPot = registerFlowerPot("eye_plant_pot", eyePlant),
            mortumBrushPot = registerFlowerPot("mortum_brush_pot", mortumBrush),
            dustBramblesPot = registerFlowerPot("dust_brambles_pot", dustBrambles),
            dustLilyPot = registerFlowerPot("dust_lily_pot", dustLily),
            skythernBrushPot = registerFlowerPot("skythern_brush_pot", skythernBrush),
            duskBloomPot = registerFlowerPot("dusk_bloom_pot", duskBloom),
            duskFlowerPot = registerFlowerPot("dusk_flower_pot", duskFlower),
            moonBudPot = registerFlowerPot("moon_bud_pot", moonBud),
            moonlightFernPot = registerFlowerPot("moonlight_fern_pot", moonlightFern),
            sunBlossomPot = registerFlowerPot("sun_blossom_pot", sunBlossom),
            sunbloomPot = registerFlowerPot("sunbloom_pot", sunbloom),
            edenBrushPot = registerFlowerPot("eden_brush_pot", edenBrush),
            edenSaplingPot = registerFlowerPot("eden_sapling_pot", edenSapling),
            wildwoodSaplingPot = registerFlowerPot("wildwood_sapling_pot", wildwoodSapling),
            apalachiaSaplingPot = registerFlowerPot("apalachia_sapling_pot", apalachiaSapling),
            skythernSaplingPot = registerFlowerPot("skythern_sapling_pot", skythernSapling),
            mortumSaplingPot = registerFlowerPot("mortum_sapling_pot", mortumSapling),
            brittleGrassPot = registerFlowerPot("brittle_grass_pot", brittleGrass),
            frozenSaplingPot = registerFlowerPot("frozen_sapling_pot", frozenSapling),
            divineSaplingPot = registerFlowerPot("divine_sapling_pot", divineSapling);



    private static RegistryObject<FlowerPotBlock> registerFlowerPot(String name, Supplier<? extends Block> flower) {
        return BLOCKS.register(name, () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, flower, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    }
    private static <T extends Block> RegistryObject<T> registerTablessBlock(String name, Supplier<T> block) {
        return registerTablessBlock(name, block, Rarity.COMMON);
    }
    private static <T extends Block> RegistryObject<T> registerTablessBlock(String registryName, Supplier<T> block, Rarity rarity) {
        RegistryObject<T> registeredBlock = BLOCKS.register(registryName, block);
        BLOCK_ITEMS.register(registryName, () -> new BlockItem(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        return registeredBlock;
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, Rarity.COMMON);
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String registryName, Supplier<T> block, Rarity rarity) {
        RegistryObject<T> registeredBlock = BLOCKS.register(registryName, block);
        BLOCK_ITEMS.register(registryName, () -> new BlockItem(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        return registeredBlock;
    }

    private static <T extends Block> RegistryObject<T> registerFireResistantBlock(String registryName, Supplier<T> block, Rarity rarity) {
        RegistryObject<T> registeredBlock = BLOCKS.register(registryName, block);
        BLOCK_ITEMS.register(registryName, () -> new BlockItem(registeredBlock.get(), new Item.Properties().rarity(rarity).fireResistant()));
        return registeredBlock;
    }

    private static <T extends Block> RegistryObject<T> registerWithRender(String registryName, Supplier<T> block, Rarity rarity) {
        RegistryObject<T> registeredBlock = BLOCKS.register(registryName, block);
        if(registryName == "arcanium_extractor") BLOCK_ITEMS.register(registryName, () -> new ItemArcaniumExtractor(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        else if(registryName == "bone_chest") BLOCK_ITEMS.register(registryName, () -> new ItemBoneChest(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        else if(registryName == "demon_furnace") BLOCK_ITEMS.register(registryName, () -> new ItemDemonFurnace(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        else if(registryName == "frosted_chest") BLOCK_ITEMS.register(registryName, () -> new ItemFrostedChest(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        else if(registryName == "present_box") BLOCK_ITEMS.register(registryName, () -> new ItemPresentBox(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        else if(registryName == "eden_chest") BLOCK_ITEMS.register(registryName, () -> new ItemEdenChest(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        else if(registryName == "parasecta_altar") BLOCK_ITEMS.register(registryName, () -> new ItemParasectaAltar(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        else if(registryName == "dramix_altar") BLOCK_ITEMS.register(registryName, () -> new ItemDramixAltar(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        else BLOCK_ITEMS.register(registryName, () -> new ItemStatueBlock(() -> registeredBlock.get(), new Item.Properties().rarity(rarity).fireResistant()));
        return registeredBlock;
    }
}