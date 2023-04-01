package divinerpg.registries;

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
import net.minecraft.world.level.material.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.*;

import java.util.function.Supplier;

import static divinerpg.DivineRPG.*;
import static net.minecraft.world.level.material.MaterialColor.*;
import static net.minecraft.sounds.SoundEvents.*;
import static divinerpg.registries.SoundRegistry.*;
import static net.minecraft.core.particles.ParticleTypes.FLAME;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockRegistry {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Block>
            arlemiteOre			 = registerBlock("arlemite_ore",			() -> new BlockMod(Properties.of(Material.STONE, STONE).requiresCorrectToolForDrops().strength(3F, 2000F).sound(SoundType.STONE))),
            arlemiteOreDeepslate = registerBlock("arlemite_ore_deepslate",  () -> new Block(Properties.copy(Blocks.DEEPSLATE_GOLD_ORE).sound(SoundType.DEEPSLATE))),
            realmiteOre			 = registerBlock("realmite_ore",			() -> new BlockMod(Properties.of(Material.STONE, STONE).requiresCorrectToolForDrops().strength(3F, 2000F).sound(SoundType.STONE))),
            realmiteOreDeepslate = registerBlock("realmite_ore_deepslate",  () -> new Block(Properties.copy(Blocks.IRON_ORE).sound(SoundType.DEEPSLATE))),
            rupeeOre			 = registerBlock("rupee_ore",				() -> new BlockMod(Properties.of(Material.STONE, STONE).requiresCorrectToolForDrops().strength(3F, 2000F).sound(SoundType.STONE))),
            rupeeOreDeepslate	 = registerBlock("rupee_ore_deepslate",  	() -> new Block(Properties.copy(Blocks.DEEPSLATE_GOLD_ORE).sound(SoundType.DEEPSLATE))),
            bloodgemOre			 = registerBlock("bloodgem_ore",			() -> new BlockMod(Properties.of(Material.STONE, STONE).requiresCorrectToolForDrops().strength(3F, 2000F).sound(SoundType.NETHER_ORE))),
            torriditeOre		 = registerBlock("torridite_ore",			() -> new BlockMod(Properties.of(Material.STONE, STONE).requiresCorrectToolForDrops().strength(3F, 2000F).sound(SoundType.NETHER_ORE)));

    public static final RegistryObject<Block>// Compressed ore blocks
            arlemiteBlock	= registerBlock("arlemite_block",	() -> new BlockMod(Properties.of(Material.METAL, METAL).requiresCorrectToolForDrops().strength(5F, 3F))),
            rawArlemiteBlock= registerBlock("raw_arlemite_block",() -> new BlockMod(Properties.of(Material.METAL, METAL).requiresCorrectToolForDrops().strength(4.5F, 2.75F))),
            realmiteBlock	= registerBlock("realmite_block",	() -> new BlockMod(Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arlemite_block"))))),
            rawRealmiteBlock= registerBlock("raw_realmite_block",() -> new BlockMod(Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "raw_arlemite_block"))))),
            rupeeBlock		= registerBlock("rupee_block",		() -> new BlockMod(Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arlemite_block"))))),
            rawRupeeBlock	= registerBlock("raw_rupee_block",	() -> new BlockMod(Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "raw_arlemite_block"))))),
            bloodgemBlock	= registerBlock("bloodgem_block",	() -> new BlockMod(Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arlemite_block"))))),
            torriditeBlock  = registerFireResistantBlock("torridite_block",() -> new BlockMod(Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arlemite_block")))), Rarity.COMMON),
            rawTorriditeBlock= registerBlock("raw_torridite_block",() -> new BlockMod(Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "raw_arlemite_block")))));

    public static final RegistryObject<Block>// Boss spawners
            sunstormSpawner			= registerBlock("sunstorm_spawner",			() -> new BlockModMobCage(new ResourceLocation(MODID, "sunstorm"), new ResourceLocation(MODID, "eden_chunk"))),
            termasectSpawner		= registerBlock("termasect_spawner",		() -> new BlockModMobCage(new ResourceLocation(MODID, "termasect"), new ResourceLocation(MODID, "wildwood_chunk"), new BlockPos(0, 11, 0))),
            eternalArcherSpawner	= registerBlock("eternal_archer_spawner",	() -> new BlockModMobCage(new ResourceLocation(MODID, "eternal_archer"), new ResourceLocation(MODID, "apalachia_chunk"))),
            experiencedCoriSpawner  = registerBlock("experienced_cori_spawner", () -> new BlockModMobCage(new ResourceLocation(MODID, "experienced_cori"), new ResourceLocation(MODID, "skythern_chunk"), new BlockPos(0, 11, 0)));

    public static final RegistryObject<Block>// Mob pumpkins
            blazePumpkin		= registerBlock("blaze_pumpkin", () -> new BlockMobPumpkin(() -> BLAZE_AMBIENT)),
            creeperPumpkin		= registerBlock("creeper_pumpkin", () -> new BlockMobPumpkin(() -> CREEPER_PRIMED)),
            cyclopsPumpkin		= registerBlock("cyclops_pumpkin", () -> new BlockMobPumpkin(() -> CYCLOPS.get())),
            enderPumpkin		= registerBlock("ender_pumpkin", () -> new BlockMobPumpkin(() -> ENDERMAN_SCREAM)),
            enderWatcherPumpkin = registerBlock("ender_watcher_pumpkin", () -> new BlockMobPumpkin(() -> ENDERMAN_AMBIENT)),
            frostPumpkin		= registerBlock("frost_pumpkin", () -> new BlockMobPumpkin(() -> FROST.get())),
            ghastPumpkin		= registerBlock("ghast_pumpkin", () -> new BlockMobPumpkin(() -> GHAST_SCREAM)),
            glaconPumpkin		= registerBlock("glacon_pumpkin", () -> new BlockMobPumpkin(() -> GLACIDE.get())),
            hellspiderPumpkin	= registerBlock("hellspider_pumpkin", () -> new BlockMobPumpkin(() -> HELL_SPIDER.get())),
            jungleSpiderPumpkin = registerBlock("jungle_spider_pumpkin", () -> new BlockMobPumpkin(() -> HELL_SPIDER.get())),
            skeletonPumpkin		= registerBlock("skeleton_pumpkin", () -> new BlockMobPumpkin(() -> SKELETON_AMBIENT)),
            spiderPumpkin		= registerBlock("spider_pumpkin", () -> new BlockMobPumpkin(() -> SPIDER_AMBIENT)),
            zombiePumpkin		= registerBlock("zombie_pumpkin", () -> new BlockMobPumpkin(() -> ZOMBIE_AMBIENT));

    public static final RegistryObject<Block>// Torches
            aquaTorch		 = BLOCKS.register("aqua_torch", () -> new BlockModTorch(FLAME)),
            aquaWallTorch	 = BLOCKS.register("aqua_wall_torch", () -> new BlockModWallTorch(FLAME)),
            skeletonWallTorch= BLOCKS.register("skeleton_wall_torch", () -> new BlockModWallTorch(FLAME)),
            skeletonTorch	 = BLOCKS.register("skeleton_torch", () -> new BlockModTorch(FLAME));

    // Decorative blocks

    public static final RegistryObject<Block>// Steel
            blackSteel = registerBlock("black_steel", () -> new BlockMod(Properties.of(Material.METAL, METAL).requiresCorrectToolForDrops().strength(9F, 60F).sound(SoundType.METAL))),
            blueSteel = registerBlock("blue_steel", () -> new BlockMod(Properties.of(Material.METAL, METAL).requiresCorrectToolForDrops().strength(9F, 60F).sound(SoundType.METAL))),
            brightRedSteel = registerBlock("bright_red_steel", () -> new BlockMod(Properties.of(Material.METAL, METAL).requiresCorrectToolForDrops().strength(9F, 60F).sound(SoundType.METAL))),
            greenSteel = registerBlock("green_steel", () -> new BlockMod(Properties.of(Material.METAL, METAL).requiresCorrectToolForDrops().strength(9F, 60F).sound(SoundType.METAL))),
            orangeSteel = registerBlock("orange_steel", () -> new BlockMod(Properties.of(Material.METAL, METAL).requiresCorrectToolForDrops().strength(9F, 60F).sound(SoundType.METAL))),
            purpleSteel = registerBlock("purple_steel", () -> new BlockMod(Properties.of(Material.METAL, METAL).requiresCorrectToolForDrops().strength(9F, 60F).sound(SoundType.METAL))),
            redSteel = registerBlock("red_steel", () -> new BlockMod(Properties.of(Material.METAL, METAL).requiresCorrectToolForDrops().strength(9F, 60F).sound(SoundType.METAL))),
            whiteSteel = registerBlock("white_steel", () -> new BlockMod(Properties.of(Material.METAL, METAL).requiresCorrectToolForDrops().strength(9F, 60F).sound(SoundType.METAL))),
            yellowSteel = registerBlock("yellow_steel", () -> new BlockMod(Properties.of(Material.METAL, METAL).requiresCorrectToolForDrops().strength(9F, 60F).sound(SoundType.METAL))),
            tealSteel = registerBlock("teal_steel", () -> new BlockMod(Properties.of(Material.METAL, METAL).requiresCorrectToolForDrops().strength(9F, 60F).sound(SoundType.METAL)));

    public static final RegistryObject<Block>// Vanes
            blueVane = registerBlock("blue_vane", () -> new BlockMod(2F, 10F)),
            cyanVane = registerBlock("cyan_vane", () -> new BlockMod(2F, 10F)),
            purpleVane = registerBlock("purple_vane", () -> new BlockMod(2F, 10F)),
            redVane = registerBlock("red_vane", () -> new BlockMod(2F, 10F)),
            yellowVane = registerBlock("yellow_vane", () -> new BlockMod(2F, 10F));

    public static final RegistryObject<Block>// Bricks
            aquatonicBricks = registerBlock("aquatonic_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            lavaBricks = registerBlock("lava_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            arlemiteBricks = registerBlock("arlemite_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            darkstoneBricks = registerBlock("darkstone_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            diamondBricks = registerBlock("diamond_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            goldBricks = registerBlock("gold_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            greenBricks = registerBlock("green_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            ironBricks = registerBlock("iron_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            lapisLazuliBricks = registerBlock("lapis_lazuli_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            milkStoneBricks = registerBlock("milk_stone_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            torriditeBricks = registerFireResistantBlock("torridite_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops()), Rarity.COMMON),
            pinkBricks = registerBlock("pink_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            purpleBricks = registerBlock("purple_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            realmiteBricks = registerBlock("realmite_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            redstoneBricks = registerBlock("redstone_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            edenBricks = registerBlock("eden_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            wildwoodBricks = registerBlock("wildwood_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            apalachiaBricks = registerBlock("apalachia_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            skythernBricks = registerBlock("skythern_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            mortumBricks = registerBlock("mortum_bricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block>// Minibricks
            minibricks = registerBlock("minibricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            arlemiteMinibricks = registerBlock("arlemite_minibricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            bedrockMinibricks = registerFireResistantBlock("bedrock_minibricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops()), Rarity.COMMON),
            torriditeMinibricks = registerFireResistantBlock("torridite_minibricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops()), Rarity.COMMON),
            realmiteMinibricks = registerBlock("realmite_minibricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            bloodgemMinibricks = registerBlock("bloodgem_minibricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops())),
            rupeeMinibricks = registerBlock("rupee_minibricks", () -> new BlockMod(Properties.of(Material.STONE).strength(3F, 30F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block>// Lamps
            aquaLamp = registerBlock("aqua_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            arlemiteLamp = registerBlock("arlemite_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            blazeLamp = registerBlock("blaze_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            soulfireLamp = registerBlock("soulfire_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            diamondLamp = registerBlock("diamond_lamp", () -> new BlockModLamp( 0.3F, 30F, 15)),
            divineLamp = registerBlock("divine_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            drakenLamp = registerBlock("draken_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            edenLamp = registerBlock("eden_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            enderLamp = registerBlock("ender_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            enderStoneLamp = registerBlock("ender_stone_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            goldLamp = registerBlock("gold_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            iceLamp = registerBlock("ice_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            jungleLamp = registerBlock("jungle_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            krakenLamp = registerBlock("kraken_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            lapisLazuliLamp = registerBlock("lapis_lazuli_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            lavaLamp = registerBlock("lava_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            milkyLamp = registerBlock("milky_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            moltenLamp = registerBlock("molten_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            torriditeLamp = registerBlock("torridite_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            realmiteLamp = registerBlock("realmite_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            redstoneOreLamp = registerBlock("redstone_ore_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            rupeeLamp = registerBlock("rupee_lamp", () -> new BlockModLamp(0.3F, 30F, 15)),
            terranLamp = registerBlock("terran_lamp", () -> new BlockModLamp(0.3F, 30F, 15));

    public static final RegistryObject<Block>// Powered fences
            blueFence = registerBlock("blue_fence", () -> new BlockModLightFence(COLOR_BLUE, 0.5F)),
            greenFence = registerBlock("green_fence", () -> new BlockModLightFence(COLOR_GREEN, 0.5F)),
            redFence = registerBlock("red_fence", () -> new BlockModLightFence(COLOR_RED, 0.5F));

    public static final RegistryObject<Block>// Miscellaneous decorative blocks
            asphalt = registerBlock("asphalt", () -> new BlockMod(Properties.of(Material.STONE).strength(2F, 3F).requiresCorrectToolForDrops())),
            asphaltStairs = registerBlock("asphalt_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "asphalt")))),
            asphaltSlab = registerBlock("asphalt_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "asphalt")), 3F)),
            blueStone = registerBlock("blue_stone", () -> new BlockLightCrystal(1F)),
            checker = registerBlock("checker", () -> new BlockMod(0.8F, 3F, Material.CLOTH_DECORATION)),
            crate = registerBlock("crate", () -> new BlockMod(2.5F, 3F, Material.WOOD)),
            darkstone = registerBlock("darkstone", () -> new BlockMod(Properties.of(Material.STONE, COLOR_BLACK).requiresCorrectToolForDrops().strength(50F, 3F).sound(SoundType.STONE).lightLevel((p_235464_0_) -> {
                return 1;}))),
            fancyWool = registerBlock("fancy_wool", () -> new BlockMod(0.8F, 3F, Material.CLOTH_DECORATION)),
            milkStone = registerBlock("milk_stone", () -> new BlockMod(1.5F, 10F)),
            plankDesign = registerBlock("plank_design", () -> new BlockMod(2.5F, 3F, Material.WOOD)),
            rainbowWool = registerBlock("rainbow_wool", () -> new BlockMod(0.8F, 3F, Material.CLOTH_DECORATION));

    public static final RegistryObject<Block>// Spike blocks
            spikeBlock = registerBlock("spike_block", () -> new BlockSpike(false)),
            hotSpikeBlock = registerBlock("hot_spike_block", () -> new BlockSpike(true));

    public static final RegistryObject<Block>// Utility blocks
            altarOfCorruption = registerBlock("altar_of_corruption", () -> new BlockAltarOfCorruption()),
            boneChest = registerWithRender("bone_chest", () -> new BlockBoneChest(), Rarity.COMMON),
            frostedAllure = registerBlock("frosted_allure", () -> new BlockFrostedAllure());

    public static final RegistryObject<Block>// Divine blocks
            divineSapling = registerBlock("divine_sapling", () -> new BlockModSapling(() -> Blocks.GRASS, () -> Blocks.DIRT, new DivineTreeGrower())),
            divineLog = registerBlock("divine_log", () -> new BlockModLog(COLOR_YELLOW)),
            strippedDivineLog = registerBlock("stripped_divine_log", () -> new BlockModLog(COLOR_YELLOW)),
            divineLeaves = registerBlock("divine_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, COLOR_YELLOW).strength(0.2F, 0.3F).randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false))),
            divinePlanks = registerBlock("divine_planks", () -> new Block(Properties.copy(Blocks.BIRCH_PLANKS))),
            divineStairs = registerBlock("divine_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "divine_planks")))),
            divineMossStone = registerBlock("divine_moss_stone", () -> new BlockMod(2F, 10F)),
            divineRock = registerBlock("divine_rock", () -> new BlockMod(1.5F, 10F));

    public static final RegistryObject<Block>// Miscellaneous utility
            slimeLight = registerBlock("slime_light", () -> new BlockModLight(1.5F)),
            darkBridge = registerBlock("dark_bridge", () -> new BlockModBridge(1.5F));

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
            experiencedCoriStatue = registerWithRender("experienced_cori_statue", () -> new BlockStatue(() -> CORI.get()), Rarity.RARE);

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
            frozenDirt = registerBlock("frozen_dirt", () -> new BlockModDirt(0.5F, TERRACOTTA_WHITE)),
            frozenGrass = registerBlock("frozen_grass", () -> new BlockModGrass( () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "frozen_dirt")), 1, COLOR_LIGHT_BLUE)),
            frozenStone = registerBlock("frozen_stone", () -> new BlockMod(6F, 3F)),
            frozenLog = registerBlock("frozen_log", () -> new BlockModLog(TERRACOTTA_WHITE)),
            strippedFrozenLog = registerBlock("stripped_frozen_log", () -> new BlockModLog(TERRACOTTA_WHITE)),
            brittleLeaves = registerBlock("brittle_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, TERRACOTTA_WHITE).strength(0.2F, 10).randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false))),
            frozenPlanks = registerBlock("frozen_planks", () -> new BlockMod(2F, 3F, Material.WOOD, SoundType.WOOD)),
            frozenStairs = registerBlock("frozen_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "frozen_planks")))),
            frozenSapling = registerBlock("frozen_sapling", () -> new BlockModSapling(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "frozen_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "frozen_dirt")), new FrozenTreeGrower())),
            icicle = registerBlock("icicle", () -> new BlockIcicle()),
            thermalVent = registerBlock("thermal_vent", () -> new BlockThermalVent()),
            brittleMoss = registerBlock("brittle_moss", () -> new BlockBrittleMoss()),
            brittleGrass = registerBlock("brittle_grass", () -> new BlockBrittleGrass()),
            winterberryVinesHead = registerBlock("winterberry_vines_head", () -> new BlockWinterberryVinesHead(Properties.copy(Blocks.WEEPING_VINES))),
            winterberryVinesBody = BLOCKS.register("winterberry_vines_body", () -> new BlockWinterberryVinesBody(Properties.copy(Blocks.WEEPING_VINES_PLANT)));

    public static final RegistryObject<Block>// Structure blocks
            coalstone = registerBlock("coalstone", () -> new BlockMod(3F, 3F)),
            coalstoneBricks = registerBlock("coalstone_bricks", () -> new BlockMod(3F, 3F)),
            coalstoneStairs = registerBlock("coalstone_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "coalstone")))),
            coalstoneFurnace = registerBlock("coalstone_furnace", () -> new BlockModInfiniFurnace(() -> BlockEntityRegistry.COALSTONE_FURNACE.get())),
            frostedChest = registerWithRender("frosted_chest", () -> new BlockFrostedChest(), Rarity.COMMON),
            frostedGlass = registerBlock("frosted_glass", () -> new BlockModGlass(1F)),
            icyBricks = registerBlock("icy_bricks", () -> new BlockMod(1.5F, 3F)),
            icyStone = registerBlock("icy_stone", () -> new BlockMod(2F, 3F)),
            snowBricks = registerBlock("snow_bricks", () -> new BlockMod(6F, 3F)),
            steelDoor = registerBlock("steel_door", () -> new BlockModDoor(Material.METAL, 7F, 3F, SoundType.METAL)),
            workshopBookcase = registerBlock("workshop_bookcase", () -> new BlockModBookshelf(1.5F, Material.STONE)),
            workshopCarpet = registerBlock("workshop_carpet", () -> new BlockMod(0.1F, 3F, Material.CLOTH_DECORATION, SoundType.WOOL)),
            workshopLamp = registerBlock("workshop_lamp", () -> new BlockModLamp(0.3F, 3F, 15));

    public static final RegistryObject<Block>// Candy canes
            blueCandyCane = registerBlock("blue_candy_cane", () -> new BlockMod(Properties.of(Material.STONE).strength(1F, 1F).requiresCorrectToolForDrops())),
            greenCandyCane = registerBlock("green_candy_cane", () -> new BlockMod(Properties.of(Material.STONE).strength(1F, 1F).requiresCorrectToolForDrops())),
            pinkCandyCane = registerBlock("pink_candy_cane", () -> new BlockMod(Properties.of(Material.STONE).strength(1F, 1F).requiresCorrectToolForDrops())),
            redCandyCane = registerBlock("red_candy_cane", () -> new BlockMod(Properties.of(Material.STONE).strength(1F, 1F).requiresCorrectToolForDrops())),
            yellowCandyCane = registerBlock("yellow_candy_cane", () -> new BlockMod(Properties.of(Material.STONE).strength(1F, 1F).requiresCorrectToolForDrops()));

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
            edenDirt = registerBlock("eden_dirt", () -> new BlockModDirt(0.5F, COLOR_YELLOW)),
            wildwoodDirt = registerBlock("wildwood_dirt", () -> new BlockModDirt(0.5F, COLOR_BLUE)),
            apalachiaDirt = registerBlock("apalachia_dirt", () -> new BlockModDirt(0.5F, COLOR_PURPLE)),
            skythernDirt = registerBlock("skythern_dirt", () -> new BlockModDirt(0.5F, COLOR_GRAY)),
            mortumDirt = registerBlock("mortum_dirt", () -> new BlockModDirt(0.5F, COLOR_BLACK));

    public static final RegistryObject<Block>// Grass
            edenGrass = registerBlock("eden_grass", () -> new BlockModGrass(edenDirt, .6F, COLOR_YELLOW)),
            wildwoodGrass = registerBlock("wildwood_grass", () -> new BlockModGrass(wildwoodDirt, .6F, COLOR_BLUE)),
            apalachiaGrass = registerBlock("apalachia_grass", () -> new BlockModGrass(apalachiaDirt, .6F, COLOR_PURPLE)),
            skythernGrass = registerBlock("skythern_grass", () -> new BlockModGrass(skythernDirt, .6F, COLOR_LIGHT_GRAY)),
            mortumGrass = registerBlock("mortum_grass", () -> new BlockModGrass(mortumDirt, .6F, COLOR_BLACK));

    // Stone
    public static final RegistryObject<Block> twilightStone = registerBlock("twilight_stone", () -> new BlockMod(Properties.of(Material.STONE).strength(6F, 3F).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block>// Ore
            edenOre = registerBlock("eden_ore", () -> new BlockMod(Properties.of(Material.STONE, STONE).requiresCorrectToolForDrops().strength(5F, 32F).sound(SoundType.STONE))),
            wildwoodOre = registerBlock("wildwood_ore", () -> new BlockMod(Properties.of(Material.STONE, STONE).requiresCorrectToolForDrops().strength(6F, 32F).sound(SoundType.STONE))),
            apalachiaOre = registerBlock("apalachia_ore", () -> new BlockMod(Properties.of(Material.STONE, STONE).requiresCorrectToolForDrops().strength(7F, 32F).sound(SoundType.STONE))),
            skythernOre = registerBlock("skythern_ore", () -> new BlockMod(Properties.of(Material.STONE, STONE).requiresCorrectToolForDrops().strength(8F, 32F).sound(SoundType.STONE))),
            mortumOre = registerBlock("mortum_ore", () -> new BlockMod(Properties.of(Material.STONE, STONE).requiresCorrectToolForDrops().strength(9F, 32F).sound(SoundType.STONE)));

    public static final RegistryObject<Block>// Sapling
            edenSapling = registerBlock("eden_sapling", () -> new BlockModSapling(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_dirt")), new EdenTreeGrower())),
            wildwoodSapling = registerBlock("wildwood_sapling", () -> new BlockModSapling(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_dirt")), new WildwoodTreeGrower())),
            apalachiaSapling = registerBlock("apalachia_sapling", () -> new BlockModSapling(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_dirt")), new ApalachiaTreeGrower())),
            skythernSapling = registerBlock("skythern_sapling", () -> new BlockModSapling(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_dirt")), new SkythernTreeGrower())),
            mortumSapling = registerBlock("mortum_sapling", () -> new BlockModSapling(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_dirt")), new MortumTreeGrower()));

    public static final RegistryObject<Block>// Logs
            edenLog = registerBlock("eden_log", () -> new BlockModLog(COLOR_YELLOW)),
            wildwoodLog = registerBlock("wildwood_log", () -> new BlockModLog(COLOR_BLUE)),
            apalachiaLog = registerBlock("apalachia_log", () -> new BlockModLog(COLOR_PURPLE)),
            skythernLog = registerBlock("skythern_log", () -> new BlockModLog(COLOR_GRAY)),
            mortumLog = registerBlock("mortum_log", () -> new BlockModLog(COLOR_RED));

    public static final RegistryObject<Block>// Stripped Logs
            strippedEdenLog = registerBlock("stripped_eden_log", () -> new BlockModLog(COLOR_YELLOW)),
            strippedWildwoodLog = registerBlock("stripped_wildwood_log", () -> new BlockModLog(COLOR_BLUE)),
            strippedApalachiaLog = registerBlock("stripped_apalachia_log", () -> new BlockModLog(COLOR_PURPLE)),
            strippedSkythernLog = registerBlock("stripped_skythern_log", () -> new BlockModLog(COLOR_GRAY)),
            strippedMortumLog = registerBlock("stripped_mortum_log", () -> new BlockModLog(COLOR_RED));

    public static final RegistryObject<Block>// Leaves
            edenLeaves = registerBlock("eden_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, COLOR_YELLOW).strength(0.2F, 0.5F).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false))),
            wildwoodLeaves = registerBlock("wildwood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, COLOR_LIGHT_BLUE).strength(0.2F, 0.5F).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false))),
            apalachiaLeaves = registerBlock("apalachia_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, COLOR_PURPLE).strength(0.2F, 0.5F).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false))),
            skythernLeaves = registerBlock("skythern_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, TERRACOTTA_WHITE).strength(0.2F, 0.5F).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false))),
            mortumLeaves = registerBlock("mortum_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, COLOR_RED).strength(0.2F, 0.5F).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false)));

    public static final RegistryObject<Block>// Planks
            edenPlanks = registerBlock("eden_planks", () -> new BlockMod(2F, 3F, Material.WOOD, SoundType.WOOD)),
            wildwoodPlanks = registerBlock("wildwood_planks", () -> new BlockMod(2F, 3F, Material.WOOD, SoundType.WOOD)),
            apalachiaPlanks = registerBlock("apalachia_planks", () -> new BlockMod(2F, 3F, Material.WOOD, SoundType.WOOD)),
            skythernPlanks = registerBlock("skythern_planks", () -> new BlockMod(2F, 3F, Material.WOOD, SoundType.WOOD)),
            mortumPlanks = registerBlock("mortum_planks", () -> new BlockMod(2F, 3F, Material.WOOD, SoundType.WOOD));

    public static final RegistryObject<Block>// Stairs
            edenStairs = registerBlock("eden_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_planks")))),
            wildwoodStairs = registerBlock("wildwood_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_planks")))),
            apalachiaStairs = registerBlock("apalachia_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_planks")))),
            skythernStairs = registerBlock("skythern_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_planks")))),
            mortumStairs = registerBlock("mortum_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_planks"))));

    public static final RegistryObject<Block>//Doors
            edenDoor = registerBlock("eden_door", () -> new BlockModDoor(Material.WOOD, 2f, 3F, SoundType.WOOD)),
            wildwoodDoor = registerBlock("wildwood_door", () -> new BlockModDoor(Material.WOOD, 2f, 3F, SoundType.WOOD)),
            apalachiaDoor = registerBlock("apalachia_door", () -> new BlockModDoor(Material.WOOD, 2f, 3F, SoundType.WOOD)),
            skythernDoor = registerBlock("skythern_door", () -> new BlockModDoor(Material.WOOD, 2f, 3F, SoundType.WOOD)),
            mortumDoor = registerBlock("mortum_door", () -> new BlockModDoor(Material.WOOD, 2f, 3F, SoundType.WOOD)),
            divineDoor = registerBlock("divine_door", () -> new BlockModDoor(Material.WOOD, 2f, 3F, SoundType.WOOD)),
            frozenDoor = registerBlock("frozen_door", () -> new BlockModDoor(Material.WOOD, 2f, 3F, SoundType.WOOD)),
            eucalyptusDoor = registerBlock("eucalyptus_door", () -> new BlockModDoor(Material.WOOD, 2f, 3F, SoundType.WOOD));


    public static final RegistryObject<Block>//Trapdoors
            edenTrapdoor = registerBlock("eden_trapdoor", () -> new BlockModTrapdoor()),
            wildwoodTrapdoor = registerBlock("wildwood_trapdoor", () -> new BlockModTrapdoor()),
            apalachiaTrapdoor = registerBlock("apalachia_trapdoor", () -> new BlockModTrapdoor()),
            skythernTrapdoor = registerBlock("skythern_trapdoor", () -> new BlockModTrapdoor()),
            mortumTrapdoor = registerBlock("mortum_trapdoor", () -> new BlockModTrapdoor()),
            divineTrapdoor = registerBlock("divine_trapdoor", () -> new BlockModTrapdoor()),
            frozenTrapdoor = registerBlock("frozen_trapdoor", () -> new BlockModTrapdoor()),
            eucalyptusTrapdoor = registerBlock("eucalyptus_trapdoor", () -> new BlockModTrapdoor());

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
            edenPressurePlate = registerBlock("eden_pressure_plate", () -> new BlockModPressurePlate()),
            wildwoodPressurePlate = registerBlock("wildwood_pressure_plate", () -> new BlockModPressurePlate()),
            apalachiaPressurePlate = registerBlock("apalachia_pressure_plate", () -> new BlockModPressurePlate()),
            skythernPressurePlate = registerBlock("skythern_pressure_plate", () -> new BlockModPressurePlate()),
            mortumPressurePlate = registerBlock("mortum_pressure_plate", () -> new BlockModPressurePlate()),
            divinePressurePlate = registerBlock("divine_pressure_plate", () -> new BlockModPressurePlate()),
            frozenPressurePlate = registerBlock("frozen_pressure_plate", () -> new BlockModPressurePlate()),
            eucalyptusPressurePlate = registerBlock("eucalyptus_pressure_plate", () -> new BlockModPressurePlate());

    public static final RegistryObject<Block>//Fence
            edenFence = registerBlock("eden_fence", () -> new BlockModFence()),
            wildwoodFence = registerBlock("wildwood_fence", () -> new BlockModFence()),
            apalachiaFence = registerBlock("apalachia_fence", () -> new BlockModFence()),
            skythernFence = registerBlock("skythern_fence", () -> new BlockModFence()),
            mortumFence = registerBlock("mortum_fence", () -> new BlockModFence()),
            divineFence = registerBlock("divine_fence", () -> new BlockModFence()),
            frozenFence = registerBlock("frozen_fence", () -> new BlockModFence()),
            eucalyptusFence = registerBlock("eucalyptus_fence", () -> new BlockModFence());

    public static final RegistryObject<Block>//Fence Gate
            edenFenceGate = registerBlock("eden_fence_gate", () -> new BlockModGate()),
            wildwoodFenceGate = registerBlock("wildwood_fence_gate", () -> new BlockModGate()),
            apalachiaFenceGate = registerBlock("apalachia_fence_gate", () -> new BlockModGate()),
            skythernFenceGate = registerBlock("skythern_fence_gate", () -> new BlockModGate()),
            mortumFenceGate = registerBlock("mortum_fence_gate", () -> new BlockModGate()),
            divineFenceGate = registerBlock("divine_fence_gate", () -> new BlockModGate()),
            frozenFenceGate = registerBlock("frozen_fence_gate", () -> new BlockModGate()),
            eucalyptusFenceGate = registerBlock("eucalyptus_fence_gate", () -> new BlockModGate());

    public static final RegistryObject<Block>// Compressed blocks
            edenBlock = registerBlock("eden_block", () -> new BlockMod(9F)),
            wildwoodBlock = registerBlock("wildwood_block", () -> new BlockMod(9F)),
            apalachiaBlock = registerBlock("apalachia_block", () -> new BlockMod(9F)),
            skythernBlock = registerBlock("skythern_block", () -> new BlockMod(9F)),
            mortumBlock = registerBlock("mortum_block", () -> new BlockMod(9F));

    // Twilight dimension ground foliage
    public static final RegistryObject<Block>// Eden
            sunBlossom = registerBlock("sun_blossom", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_grass")), 0.9, 0.6, COLOR_YELLOW)),
            sunbloom = registerBlock("sunbloom", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_grass")), COLOR_YELLOW)),
            edenBrush = registerBlock("eden_brush", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_grass")), COLOR_YELLOW));

    public static final RegistryObject<Block>// Wildwood
            moonBud = registerBlock("moon_bud", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_grass")), 0.8, 0.7, COLOR_BLUE)),
            moonlightFern = registerBlock("moonlight_fern", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_grass")), 0.8, 0.8, COLOR_BLUE)),
            wildwoodTallgrass = registerBlock("wildwood_tallgrass", () -> new BlockModDoublePlant(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_grass")), COLOR_BLUE));

    public static final RegistryObject<Block>// Apalachia
            duskBloom = registerBlock("dusk_bloom", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_grass")), 0.5, 0.5, COLOR_PURPLE)),
            duskFlower = registerBlock("dusk_flower", () -> new BlockModDoublePlant(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_grass")), COLOR_PURPLE)),
            apalachiaTallgrass = registerBlock("apalachia_tallgrass", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_grass")), COLOR_PURPLE));

    public static final RegistryObject<Block>// Skythern
            dustBrambles = registerBlock("dust_brambles", () -> new BlockBrambles(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_grass")), COLOR_GRAY)),
            dustLily = registerBlock("dust_lily", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_grass")), COLOR_GRAY)),
            skythernBrush = registerBlock("skythern_brush", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_grass")), COLOR_GRAY));

    public static final RegistryObject<Block>// Mortum
            demonBrambles = registerBlock("demon_brambles", () -> new BlockBrambles(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_grass")), COLOR_BLACK)),
            eyePlant = registerBlock("eye_plant", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_grass")), 0.5, 0.5, COLOR_BLACK)),
            mortumBrush = registerBlock("mortum_brush", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_grass")), COLOR_BLACK));

    public static final RegistryObject<Block>// Crops
            moonbulbPlant = registerBlock("moonbulb_plant", () -> new BlockMoonbulb()),
            pinkGlowbonePlant = registerBlock("pink_glowbone_plant", () -> new BlockPinkGlowbone()),
            purpleGlowbonePlant = registerBlock("purple_glowbone_plant", () -> new BlockPurpleGlowbone()),
            skyPlant = registerBlock("sky_plant", () -> new BlockSkyPlant());

    // Vine
    public static final RegistryObject<Block> wildwoodVine = registerBlock("wildwood_vine", () -> new BlockModVine());

    public static final RegistryObject<Block>// Other
            blueFire = registerBlock("blue_fire", () -> new BlockModFire()),

    edenTorch = BLOCKS.register("eden_torch", () -> new BlockModTorch(FLAME)),

    edenWallTorch = BLOCKS.register("eden_wall_torch", () -> new BlockModWallTorch(FLAME)),
            edenChest = registerWithRender("eden_chest", () -> new BlockEdenChest(), Rarity.COMMON),
            truffle = registerBlock("truffle", () -> new BlockMod(1F, 3F, Material.PLANT));

    // Arcana

    public static final RegistryObject<Block>// Dirt
            arcaniteDirt = registerBlock("arcanite_dirt", () -> new BlockModDirt(0.5F, COLOR_BLUE)),
            arcaniteSand = registerBlock("arcanite_sand", () -> new SandBlock(7579884, Properties.copy(Blocks.SAND).color(COLOR_BLUE))),
            arcanicSand = registerBlock("arcanic_sand", () -> new SandBlock(7579884, Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arcanite_sand"))))),
            arcanium_rich_sand = registerBlock("arcanium_rich_sand", () -> new SandBlock(7579884, Properties.copy(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arcanite_sand")))));

    public static final RegistryObject<Block>// Grass
            arcaniteGrass = registerBlock("arcanite_grass", () -> new BlockArcaniteGrass(0.6F)),
            arcaniteMoss = registerBlock("arcanite_moss", () -> new BlockModMoss(Properties.copy(Blocks.MOSS_BLOCK).strength(0.5F, 2F)));

    // Ore
    public static final RegistryObject<Block> rawArcanium = registerBlock("raw_arcanium", () -> new BlockMod(Properties.of(Material.DIRT, LAPIS).requiresCorrectToolForDrops().strength(2F, 3F).sound(SoundType.STONE)));

    // Storage block
    public static final RegistryObject<Block> arcaniumBlock = registerBlock("arcanium_block", () -> new BlockMod(5F));

    // Structure blocks
    public static final RegistryObject<Block>// Normal
            ancientBricks = registerBlock("ancient_bricks", () -> new BlockModUnbreakable()),
            ancientBrickStairs = registerBlock("ancient_brick_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks")))),
            ancientStone = registerBlock("ancient_stone", () -> new BlockModUnbreakable()),
            ancientTile = registerBlock("ancient_tile", () -> new BlockModUnbreakable()),
            arcaniteTubes = registerBlock("arcanite_tubes", () -> new BlockModLadder()),
            arcaniteLadder = registerBlock("arcanite_ladder", () -> new BlockModLadder()),
            arcaniumMetal = registerBlock("arcanium_metal", () -> new BlockModPillar(Material.METAL, -1F, 6000000F, SoundType.METAL)),
            arcaniumPower = registerBlock("arcanium_power", () -> new BlockModUnbreakable()),
            darkDegradedBrick = registerBlock("dark_degraded_brick", () -> new BlockModUnbreakable()),
            degradedBricks = registerBlock("degraded_bricks", () -> new BlockModUnbreakable()),
            degradedBrickStairs = registerBlock("degraded_brick_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks")))),
            dungeonBookshelf = registerBlock("dungeon_bookshelf", () -> new BlockModBookshelf(1.5F, Material.STONE)),
            dungeonLamp = registerBlock("dungeon_lamp", () -> new BlockModUnbreakable(true)),
            heatTrap = registerBlock("heat_trap", () -> new BlockHeatTrap()),
            lightDegradedBrick = registerBlock("light_degraded_brick", () -> new BlockModUnbreakable()),
            soulSludge = registerBlock("soul_sludge", () -> new BlockModUnbreakable()),
            soulStone = registerBlock("soul_stone", () -> new BlockModUnbreakable()),
            battleBricks = registerBlock("battle_bricks", () -> new BlockModUnbreakable()),
            gildedBricks = registerBlock("gilded_bricks", () -> new BlockModUnbreakable());

    public static final RegistryObject<Block>// Breakable
            ancientBricksBreakable = registerBlock("ancient_bricks_breakable", () -> new BlockMod(2F, 3F)),
            ancientBrickStairsBreakable = registerBlock("ancient_brick_stairs_breakable", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks_breakable")))),
            ancientBrickSlabBreakable = registerBlock("ancient_brick_slab_breakable", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks_breakable")), 2F)),
            ancientBrickWallBreakable = registerBlock("ancient_brick_wall_breakable", () -> new BlockModWall(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks_breakable")), 2F)),
            ancientStoneBreakable = registerBlock("ancient_stone_breakable", () -> new BlockMod(2F, 3F)),
            ancientTileBreakable = registerBlock("ancient_tile_breakable", () -> new BlockMod(2F, 3F)),
            arcaniumMetalBreakable = registerBlock("arcanium_metal_breakable", () -> new BlockModPillar(Material.METAL, 2F, 3F, SoundType.METAL)),
            arcaniumPowerBreakable = registerBlock("arcanium_power_breakable", () -> new BlockMod(2F, 3F)),
            degradedBricksBreakable = registerBlock("degraded_bricks_breakable", () -> new BlockMod(2F, 3F)),
            degradedBrickStairsBreakable = registerBlock("degraded_brick_stairs_breakable", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks_breakable")))),
            degradedBrickSlabBreakable = registerBlock("degraded_brick_slab_breakable", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks_breakable")), 2F)),
            degradedBrickWallBreakable = registerBlock("degraded_brick_wall_breakable", () -> new BlockModWall(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks_breakable")), 2F)),
            dungeonLampBreakable = registerBlock("dungeon_lamp_breakable", () -> new BlockMod(Properties.of(Material.STONE, STONE).requiresCorrectToolForDrops().strength(1, 3F).sound(SoundType.STONE).lightLevel((p_235464_0_) -> {
                return 15;}))),
            soulSludgeBreakable = registerBlock("soul_sludge_breakable", () -> new BlockMod(Properties.copy(Blocks.SOUL_SAND))),
            soulStoneBreakable = registerBlock("soul_stone_breakable", () -> new BlockMod(2F, 3F)),
            arcaniteStone = registerBlock("arcanite_stone", () -> new BlockMod(2F, 3F));

    public static final RegistryObject<Block>// Door
            ancientBrickDoor = registerBlock("ancient_brick_door", () -> new BlockArcanaDoor(new ResourceLocation(MODID, "ancient_key"))),
            degradedBrickDoor = registerBlock("degraded_brick_door", () -> new BlockArcanaDoor(new ResourceLocation(MODID, "degraded_key"))),
            soulSludgeDoor = registerBlock("soul_sludge_door", () -> new BlockArcanaDoor(new ResourceLocation(MODID, "sludge_key"))),
            soulStoneDoor = registerBlock("soul_stone_door", () -> new BlockArcanaDoor(new ResourceLocation(MODID, "soul_key")));

    // Utility
    public static final RegistryObject<Block> arcaniumExtractor = registerWithRender("arcanium_extractor", () -> new BlockArcaniumExtractor(), Rarity.RARE);

    public static final RegistryObject<Block>// Boss altars
            dramixAltar = registerWithRender("dramix_altar", () -> new BlockModAltar(), Rarity.COMMON),
            parasectaAltar = registerWithRender("parasecta_altar", () -> new BlockModAltar(), Rarity.COMMON);

    public static final RegistryObject<Block>// Stained glass
            stainedGlass = registerBlock("stained_glass", () -> new BlockModGlass(0.3F)),
            stainedGlass2 = registerBlock("stained_glass2", () -> new BlockModGlass(0.3F)),
            stainedGlass3 = registerBlock("stained_glass3", () -> new BlockModGlass(0.3F)),
            stainedGlass4 = registerBlock("stained_glass4", () -> new BlockModGlass(0.3F)),
            stainedGlass5 = registerBlock("stained_glass5", () -> new BlockModGlass(0.3F)),
            stainedGlass6 = registerBlock("stained_glass6", () -> new BlockModGlass(0.3F)),
            stainedGlass7 = registerBlock("stained_glass7", () -> new BlockModGlass(0.3F)),
            stainedGlass8 = registerBlock("stained_glass8", () -> new BlockModGlass(0.3F));

    public static final RegistryObject<Block>// Eucalyptus
            eucalyptusLog = registerBlock("eucalyptus_log", () -> new BlockModLog(COLOR_PINK)),
            strippedEucalyptusLog = registerBlock("stripped_eucalyptus_log", () -> new BlockModLog(COLOR_PINK)),
            eucalyptusPlanks = registerBlock("eucalyptus_planks", () -> new BlockMod(2F, 3F, Material.WOOD, SoundType.WOOD)),
            eucalyptusStairs = registerBlock("eucalyptus_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eucalyptus_planks"))));

    public static final RegistryObject<Block>// Plants
            aquamarinePlant = registerBlock("aquamarine_plant", () -> new BlockModCrop(3, new ResourceLocation(MODID, "aquamarine_seeds"))),
            eucalyptusPlant = registerBlock("eucalyptus_plant", () -> new BlockModCrop(3, new ResourceLocation(MODID, "eucalyptus_root_seeds"))),
            firestockPlant = registerBlock("firestock_plant", () -> new BlockFirestock()),
            hitchakPlant = registerBlock("hitchak_plant", () -> new BlockModCrop(3, new ResourceLocation(MODID, "hitchak_seeds"))),
            lamonaPlant = registerBlock("lamona_plant", () -> new BlockModCrop(3, new ResourceLocation(MODID, "lamona_seeds"))),
            marsinePlant = registerBlock("marsine_plant", () -> new BlockModCrop(2, new ResourceLocation(MODID, "marsine_seeds"))),
            pinflyPlant = registerBlock("pinfly_plant", () -> new BlockPinfly()),
            veiloPlant = registerBlock("veilo_plant", () -> new BlockModCrop(3, new ResourceLocation(MODID, "veilo_seeds"))),
            arcaniteVinesHead = registerBlock("arcanite_vines_head", () -> new BlockArcaniteVinesHead(Properties.copy(Blocks.WEEPING_VINES))),
            arcaniteVinesBody = BLOCKS.register("arcanite_vines_body", () -> new BlockArcaniteVinesBody(Properties.copy(Blocks.WEEPING_VINES_PLANT))),
            arcanaBrush = registerBlock("arcana_brush", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arcanite_sand")), COLOR_BLUE)),
            arcanaBush = registerBlock("arcana_bush", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arcanite_sand")), COLOR_BLUE)),
            gemOfTheDunes = registerBlock("gem_of_the_dunes", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arcanite_sand")), COLOR_BLUE), Rarity.EPIC);

    public static final RegistryObject<Block>// Furnace
            greenlightFurnace = registerBlock("greenlight_furnace", () -> new BlockModFurnace(() -> BlockEntityRegistry.GREENLIGHT_FURNACE.get()), Rarity.COMMON),
            oceanfireFurnace = registerBlock("oceanfire_furnace", () -> new BlockModInfiniFurnace(() -> BlockEntityRegistry.OCEANFIRE_FURNACE.get()), Rarity.COMMON),
            moltenFurnace = registerBlock("molten_furnace", () -> new BlockModInfiniFurnace(() -> BlockEntityRegistry.MOLTEN_FURNACE.get()), Rarity.COMMON),
            whitefireFurnace = registerBlock("whitefire_furnace", () -> new BlockModInfiniFurnace(() -> BlockEntityRegistry.WHITEFIRE_FURNACE.get()), Rarity.COMMON),
            moonlightFurnace = registerBlock("moonlight_furnace", () -> new BlockModFurnace(() -> BlockEntityRegistry.MOONLIGHT_FURNACE.get()), Rarity.COMMON),
            demonFurnace = registerWithRender("demon_furnace", () -> new BlockDemonFurnace(), Rarity.COMMON);

    public static final RegistryObject<Block>// Miscellaneous utility
            acceleron = registerBlock("acceleron", () -> new BlockAcceleron(), Rarity.UNCOMMON),

    arcaniumTorch = BLOCKS.register("arcanium_torch", () -> new BlockModTorch(FLAME)),

    arcaniumWallTorch = BLOCKS.register("arcanium_wall_torch", () -> new BlockModWallTorch(FLAME)),
            elevantium = registerBlock("elevantium", () -> new BlockElevantium(), Rarity.UNCOMMON),
            starBridge = registerBlock("star_bridge", () -> new BlockModBridge(1.5F)),

    encagedCaptainMerik = registerBlock("encaged_captain_merik", () -> new BlockModMobCage(new ResourceLocation(MODID, "captain_merik"), new ResourceLocation(MODID, "firestock"))),
            encagedDatticon = registerBlock("encaged_datticon", () -> new BlockModMobCage(new ResourceLocation(MODID, "datticon"), new ResourceLocation(MODID, "aquamarine"))),
            encagedKazari = registerBlock("encaged_kazari", () -> new BlockModMobCage(new ResourceLocation(MODID, "kazari"), new ResourceLocation(MODID, "lamona"))),
            encagedLeorna = registerBlock("encaged_leorna", () -> new BlockModMobCage(new ResourceLocation(MODID, "leorna"), new ResourceLocation(MODID, "hitchak"))),
            encagedLordVatticus = registerBlock("encaged_lord_vatticus", () -> new BlockModMobCage(new ResourceLocation(MODID, "lord_vatticus"), new ResourceLocation(MODID, "marsine"))),
            encagedWarGeneral = registerBlock("encaged_war_general", () -> new BlockModMobCage(new ResourceLocation(MODID, "war_general"), new ResourceLocation(MODID, "pinfly"))),
            encagedZelus = registerBlock("encaged_zelus", () -> new BlockModMobCage(new ResourceLocation(MODID, "zelus"), new ResourceLocation(MODID, "veilo")));

    // Vethea

    public static final RegistryObject<Block>// Terrain
            dreamDirt = registerBlock("dream_dirt", () -> new BlockModDirt(0.5F, COLOR_LIGHT_GREEN)),
            dreamGrass = registerBlock("dream_grass", () -> new BlockDreamGrass(0.6F)),
            dreamStone = registerBlock("dream_stone", () -> new BlockMod(1.5F)),
            evergrass = registerBlock("evergrass", () -> new BlockDreamGrass(0.6F, COLOR_PURPLE)),
            flameGrass = registerBlock("flame_grass", () -> new BlockDreamGrass(0.6F, COLOR_RED)),
            scorchedGrass = registerBlock("scorched_grass", () -> new BlockModGrass(() -> dreamStone.get(), 1.5F, COLOR_LIGHT_BLUE));

    public static final RegistryObject<Block>// Logs
            dreamwoodLog = registerBlock("dreamwood_log", () -> new BlockModLog(COLOR_LIGHT_BLUE)),
            firewoodLog = registerBlock("firewood_log", () -> new BlockModLog(COLOR_RED)),
            hyrewoodLog = registerBlock("hyrewood_log", () -> new BlockModLog(COLOR_BLUE)),
            mintwoodLog = registerBlock("mintwood_log", () -> new BlockModLog(COLOR_LIGHT_BLUE));

    public static final RegistryObject<Block>// Stripped Logs
            strippedDreamwoodLog = registerBlock("stripped_dreamwood_log", () -> new BlockModLog(COLOR_LIGHT_BLUE)),
            strippedFirewoodLog = registerBlock("stripped_firewood_log", () -> new BlockModLog(COLOR_RED)),
            strippedHyrewoodLog = registerBlock("stripped_hyrewood_log", () -> new BlockModLog(COLOR_BLUE)),
            strippedMintwoodLog = registerBlock("stripped_mintwood_log", () -> new BlockModLog(COLOR_LIGHT_BLUE));

    public static final RegistryObject<Block>// Leaves
            dreamwoodLeaves = registerBlock("dreamwood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, COLOR_RED).strength(0.2F, 0.1F).randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false))),
            firewoodLeaves = registerBlock("firewood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, COLOR_RED).strength(0.2F, 0.1F).randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false))),
            hyrewoodLeaves = registerBlock("hyrewood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, COLOR_RED).strength(0.2F, 0.1F).randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false))),
            mintwoodLeaves = registerBlock("mintwood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, COLOR_RED).strength(0.2F, 0.1F).randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false)));

    public static final RegistryObject<Block>// Ground foliage
            bulbatobe = registerBlock("bulbatobe", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_GREEN)),
            cracklespike = registerBlock("cracklespike", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_GREEN)),
            dreamglow = registerBlock("dreamglow", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_GREEN)),
            fernite = registerBlock("fernite", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_GREEN)),
            greenDulah = registerBlock("green_dulah", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_GREEN)),
            greenGemtop = registerBlock("green_gemtop", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_GREEN)),
            purpleGemtop = registerBlock("purple_gemtop", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_GREEN)),
            shimmer = registerBlock("shimmer", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_GREEN)),
            shineGrass = registerBlock("shine_grass", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_GREEN)),
            yellowDulah = registerBlock("yellow_dulah", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_GREEN));

    public static final RegistryObject<Block>// Vines
            weedwoodVine = registerBlock("weedwood_vine", () -> new BlockModVine()),
            blossomedWeedwoodVine = registerBlock("blossomed_weedwood_vine", () -> new BlockModVine());

    public static final RegistryObject<Block>// Building blocks
            darkDreamBricks = registerBlock("dark_dream_bricks", () -> new BlockMod(1F, 3F)),
            lightDreamBricks = registerBlock("light_dream_bricks", () -> new BlockMod(1F, 3F)),
            redDreamBricks = registerBlock("red_dream_bricks", () -> new BlockMod(1F, 3F)),
            smoothGlass = registerBlock("smooth_glass", () -> new BlockModGlass(0.3F));

    // Door
    public static final RegistryObject<Block> barredDoor = registerBlock("barred_door", () -> new BlockModDoor(Material.HEAVY_METAL, 2f, 1F, SoundType.STONE));

    public static final RegistryObject<Block>// Lighting
            fireCrystal = registerBlock("fire_crystal", () -> new BlockLightCrystal(1F)),
            firelight = registerBlock("firelight", () -> new BlockLightCrystal(1F));

    // Structure
    public static final RegistryObject<Block>// General
            dreamLamp = registerBlock("dream_lamp", () -> new BlockDreamLamp()),
            everstone = registerBlock("everstone", () -> new BlockModUnbreakable()),
            darkEverstone = registerBlock("dark_everstone", () -> new BlockModUnbreakable()),
            whiteEverstone = registerBlock("white_everstone", () -> new BlockModUnbreakable());

    public static final RegistryObject<Block>// Crypt
            blackHungerstone = registerBlock("black_hungerstone", () -> new BlockModUnbreakable()),
            greenHungerstone = registerBlock("green_hungerstone", () -> new BlockModUnbreakable()),
            cryptFloor = registerBlock("crypt_floor", () -> new BlockModUnbreakable()),
            cryptWall = registerBlock("crypt_wall", () -> new BlockMod(1F, 3F)),
            metalCaging = registerBlock("metal_caging", () -> new BlockModGlass(1F));

    // Village
    public static final RegistryObject<Block> villageLamp = registerBlock("village_lamp", () -> new BlockModLamp(1F, 3F, 15));

    public static final RegistryObject<Block>// Hive
            cellLamp = registerBlock("cell_lamp", () -> new BlockModLamp(1F, 3F, 15)),
            hiveWall = registerBlock("hive_wall", () -> new BlockMod(Properties.of(Material.STONE, STONE).requiresCorrectToolForDrops().strength(1F, 3F).sound(SoundType.GLASS).lightLevel((p_235464_0_) -> {
                return 7;
            })));

    public static final RegistryObject<Block>// Karos Madhouse
            blackKarosBricks = registerBlock("black_karos_bricks", () -> new BlockModUnbreakable()),
            blueKarosBricks = registerBlock("blue_karos_bricks", () -> new BlockModUnbreakable()),
            helioticBeam = registerBlock("heliotic_beam", () -> new BlockHelioticBeam()),
            karosDispenser = registerBlock("karos_dispenser", () -> new BlockKarosDispenser()),
            karosHeatTileGreen = registerBlock("karos_heat_tile_green", () -> new BlockKarosHeatTile()),
            karosHeatTileRed = registerBlock("karos_heat_tile_red", () -> new BlockKarosHeatTile());

    public static final RegistryObject<Block>// Lunic Garden
            lunaBricks = registerBlock("luna_bricks", () -> new BlockMod(1F)),
            lunaStone = registerBlock("luna_stone", () -> new BlockMod(2F));

    public static final RegistryObject<Block>// Raglok Chamber
            chamberWall = registerBlock("chamber_wall", () -> new BlockModUnbreakable()),
            shiftedChamberWall = registerBlock("shifted_chamber_wall", () -> new BlockModUnbreakable()),
            stackedChamberWall = registerBlock("stacked_chamber_wall", () -> new BlockModUnbreakable());

    // Wreck Hall
    public static final RegistryObject<Block> hallWall = registerBlock("hall_wall", () -> new BlockModUnbreakable());

    // Utility
    public static final RegistryObject<Block> infusionTable = registerBlock("infusion_table", () -> new BlockInfusionTable());

    // Hive egg
    public static final RegistryObject<Block> hiveEgg = registerBlock("hive_egg", () -> new BlockHiveEgg());

    public static final RegistryObject<Block>// Boss altars
            karosAltar = registerBlock("karos_altar", () -> new BlockKarosAltar()),
            lunicAltar = registerBlock("lunic_altar", () -> new BlockLunicAltar()),
            quadroticAltar = registerBlock("quadrotic_altar", () -> new BlockQuadroticAltar()),
            raglokAltar = registerBlock("raglok_altar", () -> new BlockRaglokAltar()),
            wreckAltar = registerBlock("wreck_altar", () -> new BlockWreckAltar());

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
            arcanaPortalFrame = registerBlock("arcana_portal_frame", () -> new BlockArcanaPortalFrame(BlockBehaviour.Properties.of(Material.STONE).strength(5F))),
            arcanaHardPortalFrame = registerBlock("arcana_hard_portal_frame", () -> new BlockArcanaPortalFrame(BlockBehaviour.Properties.of(Material.STONE).strength(5F).strength(-1, 6000000F)));

    public static final RegistryObject<Block>// Slabs
            edenSlab = registerBlock("eden_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_planks")), 2F)),
            wildwoodSlab = registerBlock("wildwood_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_planks")), 2F)),
            apalachiaSlab = registerBlock("apalachia_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_planks")), 2F)),
            skythernSlab = registerBlock("skythern_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_planks")), 2F)),
            mortumSlab = registerBlock("mortum_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_planks")), 2F)),
            divineSlab = registerBlock("divine_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "divine_planks")), 2F)),
            frozenSlab = registerBlock("frozen_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "frozen_planks")), 2F)),
            eucalyptusSlab = registerBlock("eucalyptus_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eucalyptus_planks")), 2F)),
            ancientBrickSlab = registerBlock("ancient_brick_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks")), -1F)),
            degradedBrickSlab = registerBlock("degraded_brick_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks")), -1F));

    public static final RegistryObject<Block>// Walls
            ancientBrickWall = registerBlock("ancient_brick_wall", () -> new BlockModWall(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks")), -1F)),
            degradedBrickWall = registerBlock("degraded_brick_wall", () -> new BlockModWall(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks")), -1F));

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