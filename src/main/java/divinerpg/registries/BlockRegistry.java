package divinerpg.registries;

import divinerpg.blocks.arcana.*;
import divinerpg.blocks.base.*;
import divinerpg.blocks.iceika.*;
import divinerpg.blocks.twilight.*;
import divinerpg.blocks.vanilla.*;
import divinerpg.blocks.vethea.*;
import divinerpg.items.base.block.*;
import divinerpg.world.ConfiguredFeatureKeys;
import divinerpg.world.feature.tree.grower.*;
import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.*;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.*;
import java.util.Objects;
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
            //Dirt & Dream Stone
            frozenDirt = registerBlock("frozen_dirt", () -> new BlockModDirt(ICE)),
            arcaniteDirt = registerBlock("arcanite_dirt", () -> new BlockModDirt(TERRACOTTA_BLUE)),
            edenDirt = registerBlock("eden_dirt", () -> new BlockModDirt(TERRACOTTA_YELLOW)),
            wildwoodDirt = registerBlock("wildwood_dirt", () -> new BlockModDirt(LAPIS)),
            apalachiaDirt = registerBlock("apalachia_dirt", () -> new BlockModDirt(TERRACOTTA_BLUE)),
            skythernDirt = registerBlock("skythern_dirt", () -> new BlockModDirt(COLOR_LIGHT_GRAY)),
            mortumDirt = registerBlock("mortum_dirt", () -> new BlockModDirt(COLOR_GRAY)),
            dreamDirt = registerBlock("dream_dirt", () -> new BlockModDirt(COLOR_CYAN)),
            dreamStone = registerBlock("dream_stone", () -> new BlockMod(COLOR_CYAN, 1.5F, 6)),

            //Grass Blocks
            frozenGrass = registerBlock("frozen_grass", () -> new BlockModGrass(frozenDirt, DIAMOND)),
            arcaniteGrass = registerBlock("arcanite_grass", () -> new BlockModGrass(arcaniteDirt, TERRACOTTA_LIGHT_BLUE)),
            edenGrass = registerBlock("eden_grass", () -> new BlockModGrass(edenDirt, COLOR_YELLOW)),
            wildwoodGrass = registerBlock("wildwood_grass", () -> new BlockModGrass(wildwoodDirt, WATER)),
            apalachiaGrass = registerBlock("apalachia_grass", () -> new BlockModGrass(apalachiaDirt, COLOR_PURPLE)),
            skythernGrass = registerBlock("skythern_grass", () -> new BlockModGrass(skythernDirt, WOOL)),
            mortumGrass = registerBlock("mortum_grass", () -> new BlockModGrass(mortumDirt, STONE)),
            flameGrass = registerBlock("flame_grass", () -> new BlockDreamGrass(COLOR_ORANGE)),
            dreamGrass = registerBlock("dream_grass", () -> new BlockDreamGrass(WARPED_WART_BLOCK)),
            evergrass = registerBlock("evergrass", () -> new BlockDreamGrass(COLOR_MAGENTA)),
            scorchedGrass = registerBlock("scorched_grass", () -> new BlockModGrass(dreamStone)),

            //Mud
            gelidite = registerBlock("gelidite", () -> new BlockMod(Properties.copy(Blocks.MUD))),

            //Gravel
            frozenGravel = registerBlock("frozen_gravel", () -> new GravelBlock(Properties.copy(Blocks.GRAVEL).mapColor(GLOW_LICHEN))),

            //Sand
            arcaniteSand = registerBlock("arcanite_sand", () -> new SandBlock(7579884, Properties.copy(Blocks.SAND).mapColor(COLOR_LIGHT_BLUE))),
            arcanicSand = registerBlock("arcanic_sand", () -> new SandBlock(7579884, Properties.copy(Blocks.SAND).mapColor(COLOR_CYAN))),
            arcanium_rich_sand = registerBlock("arcanium_rich_sand", () -> new SandBlock(7579884, Properties.copy(Blocks.SAND).mapColor(COLOR_BLUE))),
            soulSludge = registerBlock("soul_sludge", () -> new BlockModUnbreakable(Properties.copy(Blocks.SOUL_SAND).strength(-1, 3600000).mapColor(COLOR_GRAY))),
            soulSludgeBreakable = registerBlock("soul_sludge_breakable", () -> new BlockMod(Properties.copy(Blocks.SOUL_SAND).mapColor(COLOR_GRAY))),

            //Ice
            glaciline = registerBlock("glaciline", () -> new BlockMod(Properties.copy(Blocks.BLUE_ICE).mapColor(COLOR_LIGHT_BLUE).friction(.992F))),

            //Moss
            brittleMoss = registerBlock("brittle_moss", BlockBrittleMoss::new),
            arcaniteMoss = registerBlock("arcanite_moss", () -> new BlockModMoss(Properties.copy(Blocks.MOSS_BLOCK).mapColor(COLOR_LIGHT_BLUE))),

            //Stone & Stuff
            milkStone = registerBlock("milk_stone", () -> new BlockMod(WOOL, 1.5F, 6)),
            frozenStone = registerBlock("frozen_stone", () -> new BlockMod(GLOW_LICHEN, 1.5F, 6)),
            frozenStairs = registerBlock("frozen_stairs", () -> new BlockModStairs(frozenStone.get())),
            frozenSlab = registerBlock("frozen_slab", () -> new BlockModSlab(frozenStone.get())),
            frozenPressurePlate = registerBlock("frozen_pressure_plate", () -> new BlockModPressurePlate(Blocks.STONE_PRESSURE_PLATE, GLOW_LICHEN, BlockSetType.STONE)),
            frozenButton = registerBlock("frozen_button", () -> new BlockModButton(BlockSetType.STONE)),
            cobbledFrozenStone = registerBlock("cobbled_frozen_stone", () -> new BlockMod(GLOW_LICHEN, 2, 6)),
            cobbledFrozenStairs = registerBlock("cobbled_frozen_stairs", () -> new BlockModStairs(cobbledFrozenStone.get())),
            cobbledFrozenSlab = registerBlock("cobbled_frozen_slab", () -> new BlockModSlab(cobbledFrozenStone.get())),
            cobbledFrozenWall = registerBlock("cobbled_frozen_wall", () -> new BlockModWall(cobbledFrozenStone.get())),
            cobbledFrozenPressurePlate = registerBlock("cobbled_frozen_pressure_plate", () -> new BlockModPressurePlate(Blocks.STONE_PRESSURE_PLATE, GLOW_LICHEN, BlockSetType.STONE)),
            cobbledFrozenButton = registerBlock("cobbled_frozen_button", () -> new BlockModButton(BlockSetType.STONE)),
            cobaltite = registerBlock("cobaltite", () -> new BlockMod(COLOR_LIGHT_BLUE, 1.5F, 6)),
            cobaltiteStairs = registerBlock("cobaltite_stairs", () -> new BlockModStairs(cobaltite.get())),
            cobaltiteSlab = registerBlock("cobaltite_slab", () -> new BlockModSlab(cobaltite.get())),
            cobaltiteWall = registerBlock("cobaltite_wall", () -> new BlockModWall(cobaltite.get())),
            cobaltitePressurePlate = registerBlock("cobaltite_pressure_plate", () -> new BlockModPressurePlate(Blocks.STONE_PRESSURE_PLATE, COLOR_LIGHT_BLUE, BlockSetType.STONE)),
            cobaltiteButton = registerBlock("cobaltite_button", () -> new BlockModButton(BlockSetType.STONE)),
            icyStone = registerBlock("icy_stone", () -> new BlockMod(ICE, 50, 1200)),
            blueStone = registerBlock("blue_stone", () -> new BlockLightCrystal(COLOR_LIGHT_BLUE)),
            icicle = registerBlock("icicle", BlockIcicle::new),
            coalstone = registerBlock("coalstone", () -> new BlockMod(COLOR_GRAY, 1.5F, 6)),
            coalstoneStairs = registerBlock("coalstone_stairs", () -> new BlockModStairs(coalstone.get())),
            coalstoneSlab = registerBlock("coalstone_slab", () -> new BlockModSlab(coalstone.get())),
            coalstoneWall = registerBlock("coalstone_wall", () -> new BlockModWall(coalstone.get())),
            coalstonePressurePlate = registerBlock("coalstone_pressure_plate", () -> new BlockModPressurePlate(Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE, COLOR_GRAY, BlockSetType.STONE)),
            coalstoneButton = registerBlock("coalstone_button", () -> new BlockModButton(BlockSetType.STONE)),
            thermalVent = registerBlock("thermal_vent", BlockThermalVent::new),
            arcaniteStone = registerBlock("arcanite_stone", () -> new BlockMod(COLOR_CYAN, 1.5F, 6)),
            ancientStone = registerBlock("ancient_stone", () -> new BlockModUnbreakable(COLOR_GRAY)),
            ancientStoneBreakable = registerBlock("ancient_stone_breakable", () -> new BlockMod(COLOR_GRAY, 1.5F, 6)),
            soulStone = registerBlock("soul_stone", () -> new BlockModUnbreakable(TERRACOTTA_BLUE)),
            soulStoneBreakable = registerBlock("soul_stone_breakable", () -> new BlockMod(TERRACOTTA_BLUE, 1.5F, 6)),
            twilightStone = registerBlock("twilight_stone", () -> new BlockMod(TERRACOTTA_LIGHT_BLUE, 1.5F, 6)),
            divineMossStone = registerBlock("divine_moss_stone", () -> new BlockMod(STONE, 2, 6)),
            divineRock = registerBlock("divine_rock", () -> new BlockMod(TERRACOTTA_YELLOW, 1.5F, 6)),
            everstone = registerBlock("everstone", () -> new BlockModUnbreakable(PLANT)),
            whiteEverstone = registerBlock("white_everstone", () -> new BlockModUnbreakable(WOOL)),
            darkEverstone = registerBlock("dark_everstone", () -> new BlockModUnbreakable(COLOR_BLACK)),
            blackHungerstone = registerBlock("black_hungerstone", () -> new BlockModUnbreakable(COLOR_BLACK)),
            greenHungerstone = registerBlock("green_hungerstone", () -> new BlockModUnbreakable(PLANT)),
            lunaStone = registerBlock("luna_stone", () -> new BlockMod(TERRACOTTA_BLUE, 2, 6)),
            hiveWall = registerBlock("hive_wall", () -> new BlockMod(Properties.copy(Blocks.HONEYCOMB_BLOCK).mapColor(COLOR_GREEN).lightLevel((state) -> 7))),
            fireCrystal = registerBlock("fire_crystal", () -> new BlockLightCrystal(COLOR_RED)),
            firelight = registerBlock("firelight", () -> new BlockLightCrystal(COLOR_BLUE)),

            //Ores
            arlemiteOre = registerBlock("arlemite_ore", () -> new BlockMod(STONE, 3, 3)),
            arlemiteOreDeepslate = registerBlock("arlemite_ore_deepslate", () -> new BlockMod(DEEPSLATE, 4.5F, 3, SoundType.DEEPSLATE, NoteBlockInstrument.BASEDRUM)),
            realmiteOre = registerBlock("realmite_ore", () -> new BlockMod(STONE, 3, 3)),
            realmiteOreDeepslate = registerBlock("realmite_ore_deepslate", () -> new BlockMod(DEEPSLATE, 4.5F, 3, SoundType.DEEPSLATE, NoteBlockInstrument.BASEDRUM)),
            rupeeOre  = registerBlock("rupee_ore", () -> new BlockMod(STONE, 3, 3)),
            rupeeOreDeepslate = registerBlock("rupee_ore_deepslate", () -> new BlockMod(DEEPSLATE, 4.5F, 3, SoundType.DEEPSLATE, NoteBlockInstrument.BASEDRUM)),
            bloodgemOre	= registerBlock("bloodgem_ore", () -> new DropExperienceBlock(Properties.copy(Blocks.NETHER_GOLD_ORE), UniformInt.of(3, 7))),
            torriditeOre = registerBlock("torridite_ore", () -> new BlockMod(NETHER, 3, 1200, SoundType.NETHER_ORE, NoteBlockInstrument.BASEDRUM)),
            anthraciteOre = registerBlock("anthracite_ore", () -> new DropExperienceBlock(Properties.copy(Blocks.COAL_ORE).mapColor(GLOW_LICHEN), UniformInt.of(0, 2))),
            oxdriteOre = registerBlock("oxdrite_ore", () -> new BlockMod(GLOW_LICHEN, 3, 3)),
            rawArcanium = registerBlock("raw_arcanium", () -> new BlockMod(COLOR_BLACK, 5, 6)),
            edenOre = registerBlock("eden_ore", () -> new BlockMod(TERRACOTTA_LIGHT_BLUE, 3, 32)),
            wildwoodOre = registerBlock("wildwood_ore", () -> new BlockMod(TERRACOTTA_LIGHT_BLUE, 3, 32)),
            apalachiaOre = registerBlock("apalachia_ore", () -> new BlockMod(TERRACOTTA_LIGHT_BLUE, 3, 32)),
            skythernOre = registerBlock("skythern_ore", () -> new BlockMod(TERRACOTTA_LIGHT_BLUE, 3, 32)),
            mortumOre = registerBlock("mortum_ore", () -> new BlockMod(TERRACOTTA_LIGHT_BLUE, 3, 32)),

            //Compressed Ore Blocks
            rawArlemiteBlock= registerBlock("raw_arlemite_block",() -> new BlockMod(COLOR_LIGHT_GREEN, 5, 6)),
            arlemiteBlock	= registerBlock("arlemite_block",	() -> new BlockMod(COLOR_LIGHT_GREEN, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            rawRealmiteBlock= registerBlock("raw_realmite_block",() -> new BlockMod(COLOR_ORANGE, 5, 6)),
            realmiteBlock	= registerBlock("realmite_block",	() -> new BlockMod(COLOR_ORANGE, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            rawRupeeBlock	= registerBlock("raw_rupee_block",	() -> new BlockMod(COLOR_LIGHT_BLUE, 5, 6)),
            rupeeBlock		= registerBlock("rupee_block",		() -> new BlockMod(COLOR_LIGHT_BLUE, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            bloodgemBlock	= registerBlock("bloodgem_block",	() -> new BlockMod(CRIMSON_STEM, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            rawTorriditeBlock= registerBlock("raw_torridite_block",() -> new BlockMod(CRIMSON_NYLIUM, 5, 1200)),
            torriditeBlock  = registerFireResistantBlock("torridite_block",() -> new BlockMod(Properties.of().mapColor(CRIMSON_NYLIUM).strength(5F, 1200).requiresCorrectToolForDrops().sound(SoundType.METAL))),
            rawOxdriteBlock = registerBlock("raw_oxdrite_block", () -> new BlockMod(COLOR_BROWN, 5, 6)),
            oxdriteBlock = registerBlock("oxdrite_block", () -> new BlockMod(COLOR_BROWN, 5, 6, SoundType.COPPER, NoteBlockInstrument.HARP)),
            arcaniumBlock = registerBlock("arcanium_block", () -> new BlockMod(COLOR_LIGHT_BLUE, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),

            //Twilight Compressed Ore Blocks
            edenBlock = registerBlock("eden_block", () -> new BlockMod(COLOR_ORANGE, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            wildwoodBlock = registerBlock("wildwood_block", () -> new BlockMod(LAPIS, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            apalachiaBlock = registerBlock("apalachia_block", () -> new BlockMod(COLOR_MAGENTA, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            skythernBlock = registerBlock("skythern_block", () -> new BlockMod(WOOL, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            mortumBlock = registerBlock("mortum_block", () -> new BlockMod(COLOR_GRAY, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),

            //Arcana Portal Frames
            arcanaHardPortalFrame = registerBlock("arcana_hard_portal_frame", () -> new BlockArcanaPortalFrame(-1, 3600000)),
            arcanaPortalFrame = registerBlock("arcana_portal_frame", () -> new BlockArcanaPortalFrame(5, 6)),

            //Clusters etc.
            olivineBlock = registerBlock("olivine_block", () -> new AmethystBlock(Properties.copy(Blocks.AMETHYST_BLOCK).mapColor(COLOR_GREEN).lightLevel((state) -> 1))),
            buddingOlivine = registerBlock("budding_olivine", () -> new BlockBuddingOlivine(Properties.copy(Blocks.BUDDING_AMETHYST).mapColor(COLOR_GREEN).lightLevel((state) -> 2))),
            olivineCluster = registerBlock("olivine_cluster", () -> new AmethystClusterBlock(7, 3, Properties.copy(Blocks.AMETHYST_CLUSTER).mapColor(COLOR_GREEN).lightLevel((state) -> 3))),

            //Extra Wood Blocks
            plankDesign = registerBlock("plank_design", () -> new BlockModPlanks(WOOD, SoundType.WOOD)),

            //Divine Tree
            divineSapling = registerBlock("divine_sapling", () -> new BlockModSapling(GOLD, () -> Blocks.GRASS, () -> Blocks.DIRT, new DivineTreeGrower())),
            divineLeaves = registerBlock("divine_leaves", () -> new BlockModLeaves(GOLD, SoundType.GRASS)),
            divineLog = registerBlock("divine_log", () -> new BlockModLog(TERRACOTTA_LIGHT_GREEN, SoundType.CHERRY_WOOD)),
            divineWood = registerBlock("divine_wood", () -> new BlockModLog(TERRACOTTA_LIGHT_GREEN, SoundType.CHERRY_WOOD)),
            strippedDivineLog = registerBlock("stripped_divine_log", () -> new BlockModLog(TERRACOTTA_LIGHT_GREEN, SoundType.CHERRY_WOOD)),
            strippedDivineWood = registerBlock("stripped_divine_wood", () -> new BlockModLog(TERRACOTTA_LIGHT_GREEN, SoundType.CHERRY_WOOD)),
            divinePlanks = registerBlock("divine_planks", () -> new BlockModPlanks(TERRACOTTA_LIGHT_GREEN, SoundType.CHERRY_WOOD)),
            divineStairs = registerBlock("divine_stairs", () -> new BlockModStairs(divinePlanks.get())),
            divineSlab = registerBlock("divine_slab", () -> new BlockModSlab(divinePlanks.get())),
            divineFence = registerBlock("divine_fence", () -> new BlockModFence(TERRACOTTA_LIGHT_GREEN, SoundType.CHERRY_WOOD)),
            divineFenceGate = registerBlock("divine_fence_gate", () -> new BlockModGate(TERRACOTTA_LIGHT_GREEN, WoodType.CHERRY)),
            divineDoor = registerBlock("divine_door", () -> new BlockModDoor(TERRACOTTA_LIGHT_GREEN, BlockSetType.CHERRY)),
            divineTrapdoor = registerBlock("divine_trapdoor", () -> new BlockModTrapdoor(TERRACOTTA_LIGHT_GREEN, BlockSetType.CHERRY)),
            divinePressurePlate = registerBlock("divine_pressure_plate", () -> new BlockModPressurePlate(TERRACOTTA_LIGHT_GREEN, BlockSetType.CHERRY)),
            divineButton = registerBlock("divine_button", () -> new BlockModButton(BlockSetType.CHERRY)),

            //Shiverspine
            shiverspineSapling = registerBlock("shiverspine_sapling", () -> new BlockModSapling(GLOW_LICHEN, frozenGrass, frozenDirt, new ShiverspineTreeGrower())),
            brittleLeaves = registerBlock("brittle_leaves", () -> new BlockModLeaves(WOOL, SoundType.GRASS)),
            shiverspineLog = registerBlock("shiverspine_log", () -> new BlockModLog(GLOW_LICHEN, SoundType.WOOD)),
            shiverspineWood = registerBlock("shiverspine_wood", () -> new BlockModLog(COLOR_LIGHT_GRAY, SoundType.WOOD)),
            strippedShiverspineLog = registerBlock("stripped_shiverspine_log", () -> new BlockModLog(GLOW_LICHEN, SoundType.WOOD)),
            strippedShiverspineWood = registerBlock("stripped_shiverspine_wood", () -> new BlockModLog(GLOW_LICHEN, SoundType.WOOD)),
            shiverspinePlanks = registerBlock("shiverspine_planks", () -> new BlockModPlanks(GLOW_LICHEN, SoundType.WOOD)),
            shiverspineStairs = registerBlock("shiverspine_stairs", () -> new BlockModStairs(shiverspinePlanks.get())),
            shiverspineSlab = registerBlock("shiverspine_slab", () -> new BlockModSlab(shiverspinePlanks.get())),
            shiverspineFence = registerBlock("shiverspine_fence", () -> new BlockModFence(GLOW_LICHEN, SoundType.WOOD)),
            shiverspineFenceGate = registerBlock("shiverspine_fence_gate", () -> new BlockModGate(GLOW_LICHEN, WoodType.SPRUCE)),
            shiverspineLadder = registerBlock("shiverspine_ladder", BlockModLadder::new),
            shiverspineDoor = registerBlock("shiverspine_door", () -> new BlockModDoor(GLOW_LICHEN, BlockSetType.SPRUCE)),
            shiverspineTrapdoor = registerBlock("shiverspine_trapdoor", () -> new BlockModTrapdoor(GLOW_LICHEN, BlockSetType.SPRUCE)),
            shiverspinePressurePlate = registerBlock("shiverspine_pressure_plate", () -> new BlockModPressurePlate(GLOW_LICHEN, BlockSetType.SPRUCE)),
            shiverspineButton = registerBlock("shiverspine_button", () -> new BlockModButton(BlockSetType.SPRUCE)),
            
            //Auroraoak
            auroraoakSapling = registerBlock("auroraoak_sapling", () -> new BlockModSapling(COLOR_PURPLE, frozenGrass, frozenDirt, new AuroraoakTreeGrower())),
            auroraoakLeaves = registerBlock("auroraoak_leaves", () -> new BlockModLeaves(COLOR_PURPLE, SoundType.CHERRY_LEAVES)),
            auroraoakLog = registerBlock("auroraoak_log", () -> new BlockModLog(ICE, SoundType.WOOD)),
            auroraoakWood = registerBlock("auroraoak_wood", () -> new BlockModLog(COLOR_BROWN, SoundType.WOOD)),
            strippedAuroraoakLog = registerBlock("stripped_auroraoak_log", () -> new BlockModLog(ICE, SoundType.WOOD)),
            strippedAuroraoakWood = registerBlock("stripped_auroraoak_wood", () -> new BlockModLog(ICE, SoundType.WOOD)),
            auroraoakPlanks = registerBlock("auroraoak_planks", () -> new BlockModPlanks(ICE, SoundType.WOOD)),
            auroraoakStairs = registerBlock("auroraoak_stairs", () -> new BlockModStairs(auroraoakPlanks.get())),
            auroraoakSlab = registerBlock("auroraoak_slab", () -> new BlockModSlab(auroraoakPlanks.get())),
            auroraoakFence = registerBlock("auroraoak_fence", () -> new BlockModFence(ICE, SoundType.WOOD)),
            auroraoakFenceGate = registerBlock("auroraoak_fence_gate", () -> new BlockModGate(ICE, WoodType.OAK)),
            auroraoakDoor = registerBlock("auroraoak_door", () -> new BlockModDoor(ICE, BlockSetType.OAK)),
            auroraoakTrapdoor = registerBlock("auroraoak_trapdoor", () -> new BlockModTrapdoor(ICE, BlockSetType.OAK)),
            auroraoakPressurePlate = registerBlock("auroraoak_pressure_plate", () -> new BlockModPressurePlate(ICE, BlockSetType.OAK)),
            auroraoakButton = registerBlock("auroraoak_button", () -> new BlockModButton(BlockSetType.OAK)),
            
    		//Cozybark
            cozybarkSapling = registerBlock("cozybark_sapling", () -> new BlockModSapling(CRIMSON_STEM, frozenGrass, frozenDirt, new CozybarkTreeGrower())),
            cozybarkLeaves = registerBlock("cozybark_leaves", BlockCozybarkLeaves::new),
            cozybarkLog = registerBlock("cozybark_log", () -> new BlockModLog(TERRACOTTA_PURPLE, SoundType.WOOD)),
            cozybarkWood = registerBlock("cozybark_wood", () -> new BlockModLog(TERRACOTTA_PURPLE, SoundType.WOOD)),
            strippedCozybarkLog = registerBlock("stripped_cozybark_log", () -> new BlockModLog(TERRACOTTA_PURPLE, SoundType.WOOD)),
            strippedCozybarkWood = registerBlock("stripped_cozybark_wood", () -> new BlockModLog(TERRACOTTA_PURPLE, SoundType.WOOD)),
            cozybarkPlanks = registerBlock("cozybark_planks", () -> new BlockModPlanks(TERRACOTTA_PURPLE, SoundType.WOOD)),
            cozybarkStairs = registerBlock("cozybark_stairs", () -> new BlockModStairs(cozybarkPlanks.get())),
            cozybarkSlab = registerBlock("cozybark_slab", () -> new BlockModSlab(cozybarkPlanks.get())),
            cozybarkFence = registerBlock("cozybark_fence", () -> new BlockModFence(TERRACOTTA_PURPLE, SoundType.WOOD)),
            cozybarkFenceGate = registerBlock("cozybark_fence_gate", () -> new BlockModGate(TERRACOTTA_PURPLE, WoodType.DARK_OAK)),
            cozybarkDoor = registerBlock("cozybark_door", () -> new BlockModDoor(TERRACOTTA_PURPLE, BlockSetType.DARK_OAK)),
            cozybarkTrapdoor = registerBlock("cozybark_trapdoor", () -> new BlockModTrapdoor(TERRACOTTA_PURPLE, BlockSetType.DARK_OAK)),
            cozybarkPressurePlate = registerBlock("cozybark_pressure_plate", () -> new BlockModPressurePlate(TERRACOTTA_PURPLE, BlockSetType.DARK_OAK)),
            cozybarkButton = registerBlock("cozybark_button", () -> new BlockModButton(BlockSetType.DARK_OAK)),
            
            //Streamleaf
            streamleafSapling = registerBlock("streamleaf_sapling", () -> new BlockModSapling(GLOW_LICHEN, frozenGrass, frozenDirt, new StreamleafTreeGrower())),
            streamleafLeaves = registerBlock("streamleaf_leaves", () -> new BlockModLeaves(GLOW_LICHEN, SoundType.AZALEA_LEAVES)),
            streamleafLog = registerBlock("streamleaf_log", () -> new BlockModLog(ICE, SoundType.NETHER_WOOD)),
            streamleafWood = registerBlock("streamleaf_wood", () -> new BlockModLog(TERRACOTTA_BROWN, SoundType.NETHER_WOOD)),
            strippedStreamleafLog = registerBlock("stripped_streamleaf_log", () -> new BlockModLog(ICE, SoundType.NETHER_WOOD)),
            strippedStreamleafWood = registerBlock("stripped_streamleaf_wood", () -> new BlockModLog(ICE, SoundType.NETHER_WOOD)),
            streamleafPlanks = registerBlock("streamleaf_planks", () -> new BlockModPlanks(ICE, SoundType.NETHER_WOOD)),
            streamleafStairs = registerBlock("streamleaf_stairs", () -> new BlockModStairs(streamleafPlanks.get())),
            streamleafSlab = registerBlock("streamleaf_slab", () -> new BlockModSlab(streamleafPlanks.get())),
            streamleafFence = registerBlock("streamleaf_fence", () -> new BlockModFence(ICE, SoundType.NETHER_WOOD)),
            streamleafFenceGate = registerBlock("streamleaf_fence_gate", () -> new BlockModGate(ICE, WoodType.WARPED)),
            streamleafDoor = registerBlock("streamleaf_door", () -> new BlockModDoor(ICE, BlockSetType.WARPED)),
            streamleafTrapdoor = registerBlock("streamleaf_trapdoor", () -> new BlockModTrapdoor(ICE, BlockSetType.WARPED)),
            streamleafPressurePlate = registerBlock("streamleaf_pressure_plate", () -> new BlockModPressurePlate(ICE, BlockSetType.WARPED)),
            streamleafButton = registerBlock("streamleaf_button", () -> new BlockModButton(BlockSetType.WARPED)),
            
            //Glowsprout
    		glowsprout = registerBlock("glowsprout", () -> new FungusBlock(Properties.copy(Blocks.WARPED_FUNGUS).mapColor(COLOR_CYAN), ConfiguredFeatureKeys.GLOWSPROUT, gelidite.get())),
            glowsproutBulb = registerBlock("glowsprout_bulb", () -> new HalfTransparentBlock(Properties.copy(Blocks.OCHRE_FROGLIGHT).noOcclusion().lightLevel((state) -> 10).mapColor(DIAMOND))),
            glowsproutStem = registerBlock("glowsprout_stem", () -> new BlockModStem(COLOR_LIGHT_BLUE)),
			
			//Lowsprout
    		lowsprout = registerBlock("lowsprout", () -> new FungusBlock(Properties.copy(Blocks.WARPED_FUNGUS).mapColor(COLOR_GREEN), ConfiguredFeatureKeys.LOWSPROUT, gelidite.get())),
            lowsproutBulb = registerBlock("lowsprout_bulb", () -> new HalfTransparentBlock(Properties.copy(Blocks.VERDANT_FROGLIGHT).noOcclusion().lightLevel((state) -> 10).mapColor(WARPED_WART_BLOCK))),
            lowsproutStem = registerBlock("lowsprout_stem", () -> new BlockModStem(GLOW_LICHEN)),
			
			//Slowsprout
    		slowsprout = registerBlock("slowsprout", () -> new FungusBlock(Properties.copy(Blocks.WARPED_FUNGUS).mapColor(COLOR_MAGENTA), ConfiguredFeatureKeys.SLOWSPROUT, gelidite.get())),
            slowsproutBulb = registerBlock("slowsprout_bulb", () -> new HalfTransparentBlock(Properties.copy(Blocks.PEARLESCENT_FROGLIGHT).noOcclusion().lightLevel((state) -> 10).mapColor(ICE))),
            slowsproutStem = registerBlock("slowsprout_stem", () -> new BlockModStem(COLOR_PINK)),

            //Eucalyptus
            eucalyptusLog = registerBlock("eucalyptus_log", () -> new BlockModLog(TERRACOTTA_WHITE, SoundType.WOOD)),
            eucalyptusWood = registerBlock("eucalyptus_wood", () -> new BlockModLog(COLOR_LIGHT_GRAY, SoundType.WOOD)),
            strippedEucalyptusLog = registerBlock("stripped_eucalyptus_log", () -> new BlockModLog(TERRACOTTA_WHITE, SoundType.WOOD)),
            strippedEucalyptusWood = registerBlock("stripped_eucalyptus_wood", () -> new BlockModLog(WOOD, SoundType.WOOD)),
            eucalyptusPlanks = registerBlock("eucalyptus_planks", () -> new BlockModPlanks(TERRACOTTA_WHITE, SoundType.WOOD)),
            eucalyptusStairs = registerBlock("eucalyptus_stairs", () -> new BlockModStairs(eucalyptusPlanks.get())),
            eucalyptusSlab = registerBlock("eucalyptus_slab", () -> new BlockModSlab(eucalyptusPlanks.get())),
            eucalyptusFence = registerBlock("eucalyptus_fence", () -> new BlockModFence(TERRACOTTA_WHITE, SoundType.WOOD)),
            eucalyptusFenceGate = registerBlock("eucalyptus_fence_gate", () -> new BlockModGate(TERRACOTTA_WHITE, WoodType.BIRCH)),
            eucalyptusDoor = registerBlock("eucalyptus_door", () -> new BlockModDoor(TERRACOTTA_WHITE, BlockSetType.BIRCH)),
            eucalyptusTrapdoor = registerBlock("eucalyptus_trapdoor", () -> new BlockModTrapdoor(TERRACOTTA_WHITE, BlockSetType.BIRCH)),
            eucalyptusPressurePlate = registerBlock("eucalyptus_pressure_plate", () -> new BlockModPressurePlate(TERRACOTTA_WHITE, BlockSetType.BIRCH)),
            eucalyptusButton = registerBlock("eucalyptus_button", () -> new BlockModButton(BlockSetType.BIRCH)),

            //Eden Tree
            edenSapling = registerBlock("eden_sapling", () -> new BlockModSapling(GOLD, edenGrass, edenDirt, new EdenTreeGrower())),
            edenLeaves = registerBlock("eden_leaves", () -> new BlockModLeaves(GOLD, SoundType.AZALEA_LEAVES)),
            edenLog = registerBlock("eden_log", () -> new BlockModLog(SAND, SoundType.WOOD)),
            edenWood = registerBlock("eden_wood", () -> new BlockModLog(COLOR_BROWN, SoundType.WOOD)),
            strippedEdenLog = registerBlock("stripped_eden_log", () -> new BlockModLog(SAND, SoundType.WOOD)),
            strippedEdenWood = registerBlock("stripped_eden_wood", () -> new BlockModLog(SAND, SoundType.WOOD)),
            edenPlanks = registerBlock("eden_planks", () -> new BlockModPlanks(SAND, SoundType.WOOD)),
            edenStairs = registerBlock("eden_stairs", () -> new BlockModStairs(edenPlanks.get())),
            edenSlab = registerBlock("eden_slab", () -> new BlockModSlab(edenPlanks.get())),
            edenFence = registerBlock("eden_fence", () -> new BlockModFence(SAND, SoundType.WOOD)),
            edenFenceGate = registerBlock("eden_fence_gate", () -> new BlockModGate(SAND, WoodType.OAK)),
            edenDoor = registerBlock("eden_door", () -> new BlockModDoor(SAND, BlockSetType.OAK)),
            edenTrapdoor = registerBlock("eden_trapdoor", () -> new BlockModTrapdoor(SAND, BlockSetType.OAK)),
            edenPressurePlate = registerBlock("eden_pressure_plate", () -> new BlockModPressurePlate(SAND, BlockSetType.OAK)),
            edenButton = registerBlock("eden_button", () -> new BlockModButton(BlockSetType.OAK)),

            //Wildwood Tree
            wildwoodSapling = registerBlock("wildwood_sapling", () -> new BlockModSapling(COLOR_LIGHT_BLUE, wildwoodGrass, wildwoodDirt, new WildwoodTreeGrower())),
            wildwoodLeaves = registerBlock("wildwood_leaves", () -> new BlockModLeaves(COLOR_LIGHT_BLUE, SoundType.AZALEA_LEAVES)),
            wildwoodLog = registerBlock("wildwood_log", () -> new BlockModLog(COLOR_LIGHT_BLUE, SoundType.WOOD)),
            wildwoodWood = registerBlock("wildwood_wood", () -> new BlockModLog(COLOR_BLUE, SoundType.WOOD)),
            strippedWildwoodLog = registerBlock("stripped_wildwood_log", () -> new BlockModLog(COLOR_LIGHT_BLUE, SoundType.WOOD)),
            strippedWildwoodWood = registerBlock("stripped_wildwood_wood", () -> new BlockModLog(COLOR_LIGHT_BLUE, SoundType.WOOD)),
            wildwoodPlanks = registerBlock("wildwood_planks", () -> new BlockModPlanks(COLOR_LIGHT_BLUE, SoundType.WOOD)),
            wildwoodStairs = registerBlock("wildwood_stairs", () -> new BlockModStairs(wildwoodPlanks.get())),
            wildwoodSlab = registerBlock("wildwood_slab", () -> new BlockModSlab(wildwoodPlanks.get())),
            wildwoodFence = registerBlock("wildwood_fence", () -> new BlockModFence(COLOR_LIGHT_BLUE, SoundType.WOOD)),
            wildwoodFenceGate = registerBlock("wildwood_fence_gate", () -> new BlockModGate(COLOR_LIGHT_BLUE, WoodType.DARK_OAK)),
            wildwoodDoor = registerBlock("wildwood_door", () -> new BlockModDoor(COLOR_LIGHT_BLUE, BlockSetType.DARK_OAK)),
            wildwoodTrapdoor = registerBlock("wildwood_trapdoor", () -> new BlockModTrapdoor(COLOR_LIGHT_BLUE, BlockSetType.DARK_OAK)),
            wildwoodPressurePlate = registerBlock("wildwood_pressure_plate", () -> new BlockModPressurePlate(COLOR_LIGHT_BLUE, BlockSetType.DARK_OAK)),
            wildwoodButton = registerBlock("wildwood_button", () -> new BlockModButton(BlockSetType.DARK_OAK)),

            //Apalachia Tree
            apalachiaSapling = registerBlock("apalachia_sapling", () -> new BlockModSapling(COLOR_MAGENTA, apalachiaGrass, apalachiaDirt, new ApalachiaTreeGrower())),
            apalachiaLeaves = registerBlock("apalachia_leaves", () -> new BlockModLeaves(COLOR_MAGENTA, SoundType.AZALEA_LEAVES)),
            apalachiaLog = registerBlock("apalachia_log", () -> new BlockModLog(COLOR_MAGENTA, SoundType.WOOD)),
            apalachiaWood = registerBlock("apalachia_wood", () -> new BlockModLog(WARPED_HYPHAE, SoundType.WOOD)),
            strippedApalachiaLog = registerBlock("stripped_apalachia_log", () -> new BlockModLog(COLOR_MAGENTA, SoundType.WOOD)),
            strippedApalachiaWood = registerBlock("stripped_apalachia_wood", () -> new BlockModLog(COLOR_MAGENTA, SoundType.WOOD)),
            apalachiaPlanks = registerBlock("apalachia_planks", () -> new BlockModPlanks(COLOR_MAGENTA, SoundType.WOOD)),
            apalachiaStairs = registerBlock("apalachia_stairs", () -> new BlockModStairs(apalachiaPlanks.get())),
            apalachiaSlab = registerBlock("apalachia_slab", () -> new BlockModSlab(apalachiaPlanks.get())),
            apalachiaFence = registerBlock("apalachia_fence", () -> new BlockModFence(COLOR_MAGENTA, SoundType.WOOD)),
            apalachiaFenceGate = registerBlock("apalachia_fence_gate", () -> new BlockModGate(COLOR_MAGENTA, WoodType.ACACIA)),
            apalachiaDoor = registerBlock("apalachia_door", () -> new BlockModDoor(COLOR_MAGENTA, BlockSetType.ACACIA)),
            apalachiaTrapdoor = registerBlock("apalachia_trapdoor", () -> new BlockModTrapdoor(COLOR_MAGENTA, BlockSetType.ACACIA)),
            apalachiaPressurePlate = registerBlock("apalachia_pressure_plate", () -> new BlockModPressurePlate(COLOR_MAGENTA, BlockSetType.ACACIA)),
            apalachiaButton = registerBlock("apalachia_button", () -> new BlockModButton(BlockSetType.ACACIA)),

            //Skythern Tree
            skythernSapling = registerBlock("skythern_sapling", () -> new BlockModSapling(WOOL, skythernGrass, skythernDirt, new SkythernTreeGrower())),
            skythernLeaves = registerBlock("skythern_leaves", () -> new BlockModLeaves(COLOR_LIGHT_GRAY, SoundType.AZALEA_LEAVES)),
            skythernLog = registerBlock("skythern_log", () -> new BlockModLog(WOOL, SoundType.NETHER_WOOD)),
            skythernWood = registerBlock("skythern_wood", () -> new BlockModLog(COLOR_LIGHT_GRAY, SoundType.NETHER_WOOD)),
            strippedSkythernLog = registerBlock("stripped_skythern_log", () -> new BlockModLog(WOOL, SoundType.NETHER_WOOD)),
            strippedSkythernWood = registerBlock("stripped_skythern_wood", () -> new BlockModLog(WOOL, SoundType.NETHER_WOOD)),
            skythernPlanks = registerBlock("skythern_planks", () -> new BlockModPlanks(WOOL, SoundType.NETHER_WOOD)),
            skythernStairs = registerBlock("skythern_stairs", () -> new BlockModStairs(skythernPlanks.get())),
            skythernSlab = registerBlock("skythern_slab", () -> new BlockModSlab(skythernPlanks.get())),
            skythernFence = registerBlock("skythern_fence", () -> new BlockModFence(WOOL, SoundType.NETHER_WOOD)),
            skythernFenceGate = registerBlock("skythern_fence_gate", () -> new BlockModGate(WOOL, WoodType.CRIMSON)),
            skythernDoor = registerBlock("skythern_door", () -> new BlockModDoor(WOOL, BlockSetType.CRIMSON)),
            skythernTrapdoor = registerBlock("skythern_trapdoor", () -> new BlockModTrapdoor(WOOL, BlockSetType.CRIMSON)),
            skythernPressurePlate = registerBlock("skythern_pressure_plate", () -> new BlockModPressurePlate(WOOL, BlockSetType.CRIMSON)),
            skythernButton = registerBlock("skythern_button", () -> new BlockModButton(BlockSetType.CRIMSON)),

            //Mortum Tree
            mortumSapling = registerBlock("mortum_sapling", () -> new BlockModSapling(COLOR_GRAY, mortumGrass, mortumDirt, new MortumTreeGrower())),
            mortumLeaves = registerBlock("mortum_leaves", () -> new BlockModLeaves(COLOR_BLACK, SoundType.AZALEA_LEAVES)),
            mortumLog = registerBlock("mortum_log", () -> new BlockModLog(TERRACOTTA_PINK, SoundType.WOOD)),
            mortumWood = registerBlock("mortum_wood", () -> new BlockModLog(TERRACOTTA_PINK, SoundType.WOOD)),
            strippedMortumLog = registerBlock("stripped_mortum_log", () -> new BlockModLog(TERRACOTTA_PINK, SoundType.WOOD)),
            strippedMortumWood = registerBlock("stripped_mortum_wood", () -> new BlockModLog(TERRACOTTA_PINK, SoundType.WOOD)),
            mortumPlanks = registerBlock("mortum_planks", () -> new BlockModPlanks(COLOR_GRAY, SoundType.WOOD)),
            mortumStairs = registerBlock("mortum_stairs", () -> new BlockModStairs(mortumPlanks.get())),
            mortumSlab = registerBlock("mortum_slab", () -> new BlockModSlab(mortumPlanks.get())),
            mortumFence = registerBlock("mortum_fence", () -> new BlockModFence(COLOR_GRAY, SoundType.WOOD)),
            mortumFenceGate = registerBlock("mortum_fence_gate", () -> new BlockModGate(COLOR_GRAY, WoodType.MANGROVE)),
            mortumDoor = registerBlock("mortum_door", () -> new BlockModDoor(COLOR_GRAY, BlockSetType.MANGROVE)),
            mortumTrapdoor = registerBlock("mortum_trapdoor", () -> new BlockModTrapdoor(COLOR_GRAY, BlockSetType.MANGROVE)),
            mortumPressurePlate = registerBlock("mortum_pressure_plate", () -> new BlockModPressurePlate(COLOR_GRAY, BlockSetType.MANGROVE)),
            mortumButton = registerBlock("mortum_button", () -> new BlockModButton(BlockSetType.MANGROVE)),

            //Firewood
            firewoodLeaves = registerBlock("firewood_leaves", () -> new BlockModLeaves(CRIMSON_NYLIUM, SoundType.GRASS)),
            firewoodLog = registerBlock("firewood_log", () -> new BlockModLog(TERRACOTTA_ORANGE, SoundType.WOOD)),
            firewoodWood = registerBlock("firewood_wood", () -> new BlockModLog(COLOR_RED, SoundType.WOOD)),
            strippedFirewoodLog = registerBlock("stripped_firewood_log", () -> new BlockModLog(TERRACOTTA_ORANGE, SoundType.WOOD)),
            strippedFirewoodWood = registerBlock("stripped_firewood_wood", () -> new BlockModLog(TERRACOTTA_ORANGE, SoundType.WOOD)),

            //Dreamwood
            dreamwoodLeaves = registerBlock("dreamwood_leaves", () -> new BlockModLeaves(COLOR_CYAN, SoundType.GRASS)),
            dreamwoodLog = registerBlock("dreamwood_log", () -> new BlockModLog(COLOR_LIGHT_BLUE, SoundType.WOOD)),
            dreamwoodWood = registerBlock("dreamwood_wood", () -> new BlockModLog(COLOR_CYAN, SoundType.WOOD)),
            strippedDreamwoodLog = registerBlock("stripped_dreamwood_log", () -> new BlockModLog(COLOR_LIGHT_BLUE, SoundType.WOOD)),
            strippedDreamwoodWood = registerBlock("stripped_dreamwood_wood", () -> new BlockModLog(COLOR_LIGHT_BLUE, SoundType.WOOD)),

            //Hyrewood
            hyrewoodLeaves = registerBlock("hyrewood_leaves", () -> new BlockModLeaves(COLOR_BLUE, SoundType.GRASS)),
            hyrewoodLog = registerBlock("hyrewood_log", () -> new BlockModLog(COLOR_BLUE, SoundType.WOOD)),
            hyrewoodWood = registerBlock("hyrewood_wood", () -> new BlockModLog(COLOR_BLUE, SoundType.WOOD)),
            strippedHyrewoodLog = registerBlock("stripped_hyrewood_log", () -> new BlockModLog(COLOR_BLUE, SoundType.WOOD)),
            strippedHyrewoodWood = registerBlock("stripped_hyrewood_wood", () -> new BlockModLog(COLOR_BLUE, SoundType.WOOD)),

            //Mintwood
            mintwoodLeaves = registerBlock("mintwood_leaves", () -> new BlockModLeaves(WARPED_WART_BLOCK, SoundType.GRASS)),
            mintwoodLog = registerBlock("mintwood_log", () -> new BlockModLog(DIAMOND, SoundType.WOOD)),
            mintwoodWood = registerBlock("mintwood_wood", () -> new BlockModLog(WARPED_WART_BLOCK, SoundType.WOOD)),
            strippedMintwoodLog = registerBlock("stripped_mintwood_log", () -> new BlockModLog(DIAMOND, SoundType.WOOD)),
            strippedMintwoodWood = registerBlock("stripped_mintwood_wood", () -> new BlockModLog(COLOR_CYAN, SoundType.WOOD)),

            //Wool
            checker = registerBlock("checker", () -> new BlockMod(WOOL,.8F, .8F, 60, 30, SoundType.WOOL, NoteBlockInstrument.GUITAR)),
            fancyWool = registerBlock("fancy_wool", () -> new BlockMod(CRIMSON_HYPHAE,.8F, .8F, 60, 30, SoundType.WOOL, NoteBlockInstrument.GUITAR)),
            rainbowWool = registerBlock("rainbow_wool", () -> new BlockMod(COLOR_PURPLE,.8F, .8F, 60, 30, SoundType.WOOL, NoteBlockInstrument.GUITAR)),
            workshopCarpet = registerBlock("workshop_carpet", () -> new BlockMod(TERRACOTTA_RED,.8F, .8F, 60, 30, SoundType.WOOL, NoteBlockInstrument.GUITAR)),

            //Bookshelves
            workshopBookcase = registerBlock("workshop_bookcase", () -> new BlockModBookshelf(COLOR_GRAY)),
            dungeonBookshelf = registerBlock("dungeon_bookshelf", () -> new BlockModBookshelf(COLOR_BLUE)),

            //Asphalt
            asphalt = registerBlock("asphalt", () -> new BlockMod(COLOR_BLACK, 1.5F, 6)),
            asphaltStairs = registerBlock("asphalt_stairs", () -> new BlockModStairs(asphalt.get())),
            asphaltSlab = registerBlock("asphalt_slab", () -> new BlockModSlab(asphalt.get())),

            //Darkstone & Crying Obsidian variants
            darkstone = registerBlock("darkstone", () -> new BlockMod(TERRACOTTA_GREEN, 4)),
            bleedingObsidian = registerBlock("bleeding_obsidian", () -> new BlockMod(COLOR_BLACK, 10)),
            shiningObsidian = registerBlock("shining_obsidian", () -> new BlockMod(COLOR_BLACK, 10)),
            glitteringObsidian = registerBlock("glittering_obsidian", () -> new BlockMod(COLOR_BLACK, 10)),
            seepingObsidian = registerBlock("seeping_obsidian", () -> new BlockMod(COLOR_BLACK, 10)),
            vwoopingObsidian = registerBlock("vwooping_obsidian", () -> new BlockMod(COLOR_BLACK, 10)),

            //Bricks
            milkStoneBricks = registerBlock("milk_stone_bricks", () -> new BlockMod(WOOL, 2, 6, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            ironBricks = registerBlock("iron_bricks", () -> new BlockMod(METAL, 2, 6, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            torriditeBricks = registerFireResistantBlock("torridite_bricks", () -> new BlockMod(CRIMSON_NYLIUM, 2, 1200, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            lavaBricks = registerBlock("lava_bricks", () -> new BlockMod(Block.Properties.of().mapColor(FIRE).requiresCorrectToolForDrops().strength(2, 6).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM).lightLevel((state) -> 6))),
            realmiteBricks = registerBlock("realmite_bricks", () -> new BlockMod(COLOR_ORANGE, 2, 6, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            goldBricks = registerBlock("gold_bricks", () -> new BlockMod(GOLD, 2, 6, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            arlemiteBricks = registerBlock("arlemite_bricks", () -> new BlockMod(COLOR_LIGHT_GREEN, 2, 6, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            greenBricks = registerBlock("green_bricks", () -> new BlockMod(COLOR_GREEN, 2, 6, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            darkstoneBricks = registerBlock("darkstone_bricks", () -> new BlockMod(Block.Properties.copy(darkstone.get()).strength(6, 1200).sound(SoundType.NETHER_BRICKS))),
            aquatonicBricks = registerBlock("aquatonic_bricks", () -> new BlockMod(WARPED_NYLIUM, 2, 6, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            diamondBricks = registerBlock("diamond_bricks", () -> new BlockMod(DIAMOND, 2, 6, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            lapisLazuliBricks = registerBlock("lapis_lazuli_bricks", () -> new BlockMod(LAPIS, 2, 6, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            purpleBricks = registerBlock("purple_bricks", () -> new BlockMod(COLOR_PURPLE, 2, 6, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            magentaBricks = registerBlock("magenta_bricks", () -> new BlockMod(COLOR_MAGENTA, 2, 6, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            bloodgemBricks = registerBlock("bloodgem_bricks", () -> new BlockMod(CRIMSON_STEM, 2, 6, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),

            //Minibricks
            minibricks = registerBlock("minibricks", () -> new BlockMod(STONE, 2, 6)),
            bedrockMinibricks = registerFireResistantBlock("bedrock_minibricks", () -> new BlockMod(COLOR_GRAY, 6, 1200, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            torriditeMinibricks = registerFireResistantBlock("torridite_minibricks", () -> new BlockMod(CRIMSON_NYLIUM, 2, 1200, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            realmiteMinibricks = registerBlock("realmite_minibricks", () -> new BlockMod(COLOR_ORANGE, 2, 6, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            arlemiteMinibricks = registerBlock("arlemite_minibricks", () -> new BlockMod(COLOR_LIGHT_GREEN, 2, 6, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            rupeeMinibricks = registerBlock("rupee_minibricks", () -> new BlockMod(COLOR_LIGHT_BLUE, 2, 6, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            bloodgemMinibricks = registerBlock("bloodgem_minibricks", () -> new BlockMod(CRIMSON_STEM, 2, 6, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),

            //Iceika Bricks & Other Blocks
            frozenBricks = registerBlock("frozen_bricks", () -> new BlockMod(GLOW_LICHEN, 1.5F, 6)),
            frozenBrickStairs = registerBlock("frozen_brick_stairs", () -> new BlockModStairs(frozenBricks.get())),
            frozenBrickSlab = registerBlock("frozen_brick_slab", () -> new BlockModSlab(frozenBricks.get())),
            frozenBrickWall = registerBlock("frozen_brick_wall", () -> new BlockModWall(frozenBricks.get())),
            frozenBrickPressurePlate = registerBlock("frozen_brick_pressure_plate", () -> new BlockModPressurePlate(Blocks.STONE_PRESSURE_PLATE, GLOW_LICHEN, BlockSetType.STONE)),
            frozenBrickButton = registerBlock("frozen_brick_button", () -> new BlockModButton(BlockSetType.STONE)),
            snowBricks = registerBlock("snow_bricks", () -> new BlockMod(SNOW, 1.5F, 6)),
            icyBricks = registerBlock("icy_bricks", () -> new BlockMod(ICE, 50, 1200)),
            chiseledIcyBricks = registerBlock("chiseled_icy_bricks", () -> new BlockMod(ICE, 50, 1200)),
            coalstoneBricks = registerBlock("coalstone_bricks", () -> new BlockMod(COLOR_GRAY, 1.5F, 6)),
            coalstoneBrickStairs = registerBlock("coalstone_brick_stairs", () -> new BlockModStairs(coalstoneBricks.get())),
            coalstoneBrickSlab = registerBlock("coalstone_brick_slab", () -> new BlockModSlab(coalstoneBricks.get())),
            coalstoneBrickWall = registerBlock("coalstone_brick_wall", () -> new BlockModWall(coalstoneBricks.get())),
            coalstoneBrickPressurePlate = registerBlock("coalstone_brick_pressure_plate", () -> new BlockModPressurePlate(Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE, COLOR_GRAY, BlockSetType.POLISHED_BLACKSTONE)),
            coalstoneBrickButton = registerBlock("coalstone_brick_button", () -> new BlockModButton(BlockSetType.POLISHED_BLACKSTONE)),
            chiseledCoalstoneBricks = registerBlock("chiseled_coalstone_bricks", () -> new BlockMod(COLOR_GRAY, 1.5F, 6)),
            polishedCoalstone = registerBlock("polished_coalstone", () -> new BlockMod(COLOR_GRAY, 1.5F, 6)),
            polishedCoalstoneStairs = registerBlock("polished_coalstone_stairs", () -> new BlockModStairs(polishedCoalstone.get())),
            polishedCoalstoneSlab = registerBlock("polished_coalstone_slab", () -> new BlockModSlab(polishedCoalstone.get())),
            polishedCoalstoneWall = registerBlock("polished_coalstone_wall", () -> new BlockModWall(polishedCoalstone.get())),
            polishedCoalstonePressurePlate = registerBlock("polished_coalstone_pressure_plate", () -> new BlockModPressurePlate(Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE, COLOR_GRAY, BlockSetType.POLISHED_BLACKSTONE)),
            polishedCoalstoneButton = registerBlock("polished_coalstone_button", () -> new BlockModButton(BlockSetType.POLISHED_BLACKSTONE)),
            polishedCobaltite = registerBlock("polished_cobaltite", () -> new BlockMod(COLOR_LIGHT_BLUE, 1.5F, 6)),
            polishedCobaltiteStairs = registerBlock("polished_cobaltite_stairs", () -> new BlockModStairs(polishedCobaltite.get())),
            polishedCobaltiteSlab = registerBlock("polished_cobaltite_slab", () -> new BlockModSlab(polishedCobaltite.get())),
            polishedCobaltiteWall = registerBlock("polished_cobaltite_wall", () -> new BlockModWall(polishedCobaltite.get())),
            polishedCobaltitePressurePlate = registerBlock("polished_cobaltite_pressure_plate", () -> new BlockModPressurePlate(Blocks.STONE_PRESSURE_PLATE, COLOR_LIGHT_BLUE, BlockSetType.STONE)),
            polishedCobaltiteButton = registerBlock("polished_cobaltite_button", () -> new BlockModButton(BlockSetType.STONE)),
            cutOxdrite = registerBlock("cut_oxdrite", () -> new BlockMod(Properties.of().mapColor(COLOR_BROWN).requiresCorrectToolForDrops().strength(5, 6).sound(SoundType.COPPER).noOcclusion())),
            cutOxdriteStairs = registerBlock("cut_oxdrite_stairs", () -> new BlockModStairs(cutOxdrite.get())),
            cutOxdriteSlab = registerBlock("cut_oxdrite_slab", () -> new BlockModSlab(cutOxdrite.get())),
            cutOxdriteWall = registerBlock("cut_oxdrite_wall", () -> new BlockModWall(cutOxdrite.get())),
            cutOxdritePressurePlate = registerBlock("cut_oxdrite_pressure_plate", () -> new BlockModPressurePlate(Blocks.STONE_PRESSURE_PLATE, COLOR_BROWN, BlockSetType.IRON)),
            cutOxdriteButton = registerBlock("cut_oxdrite_button", () -> new BlockModButton(BlockSetType.IRON)),

            //Arcana Bricks & Other Blocks
            ancientBricks = registerBlock("ancient_bricks", () -> new BlockModUnbreakable(WARPED_NYLIUM)),
            ancientBrickStairs = registerBlock("ancient_brick_stairs", () -> new BlockModStairs(ancientBricks.get())),
            ancientBrickSlab = registerBlock("ancient_brick_slab", () -> new BlockModSlab(ancientBricks.get())),
            ancientBrickWall = registerBlock("ancient_brick_wall", () -> new BlockModWall(ancientBricks.get())),
            degradedBricks = registerBlock("degraded_bricks", () -> new BlockModUnbreakable(COLOR_BLUE)),
            degradedBrickStairs = registerBlock("degraded_brick_stairs", () -> new BlockModStairs(degradedBricks.get())),
            degradedBrickSlab = registerBlock("degraded_brick_slab", () -> new BlockModSlab(degradedBricks.get())),
            degradedBrickWall = registerBlock("degraded_brick_wall", () -> new BlockModWall(degradedBricks.get())),
            lightDegradedBrick = registerBlock("light_degraded_brick", () -> new BlockModUnbreakable(COLOR_CYAN)),
            darkDegradedBrick = registerBlock("dark_degraded_brick", () -> new BlockModUnbreakable(COLOR_BLACK)),
            ancientTile = registerBlock("ancient_tile", () -> new BlockModUnbreakable(COLOR_BLUE)),
            arcaniumMetal = registerBlock("arcanium_metal", () -> new BlockModPillar(TERRACOTTA_BLUE, -1, 3600000, SoundType.METAL)),
            arcaniumPower = registerBlock("arcanium_power", () -> new BlockModUnbreakable(COLOR_GRAY)),
            battleBricks = registerBlock("battle_bricks", () -> new BlockModUnbreakable(FIRE)),
            gildedBricks = registerBlock("gilded_bricks", () -> new BlockModUnbreakable(COLOR_ORANGE)),
            ancientBricksBreakable = registerBlock("ancient_bricks_breakable", () -> new BlockMod(WARPED_NYLIUM, 1.5F, 6)),
            ancientBrickStairsBreakable = registerBlock("ancient_brick_stairs_breakable", () -> new BlockModStairs(ancientBricksBreakable.get())),
            ancientBrickSlabBreakable = registerBlock("ancient_brick_slab_breakable", () -> new BlockModSlab(ancientBricksBreakable.get())),
            ancientBrickWallBreakable = registerBlock("ancient_brick_wall_breakable", () -> new BlockModWall(ancientBricksBreakable.get())),
            degradedBricksBreakable = registerBlock("degraded_bricks_breakable", () -> new BlockMod(COLOR_BLUE, 1.5F, 6)),
            degradedBrickStairsBreakable = registerBlock("degraded_brick_stairs_breakable", () -> new BlockModStairs(degradedBricksBreakable.get())),
            degradedBrickSlabBreakable = registerBlock("degraded_brick_slab_breakable", () -> new BlockModSlab(degradedBricksBreakable.get())),
            degradedBrickWallBreakable = registerBlock("degraded_brick_wall_breakable", () -> new BlockModWall(degradedBricksBreakable.get())),
            ancientTileBreakable = registerBlock("ancient_tile_breakable", () -> new BlockMod(COLOR_BLUE, 2, 6)),
            arcaniumMetalBreakable = registerBlock("arcanium_metal_breakable", () -> new BlockModPillar(TERRACOTTA_BLUE, 5, 6, SoundType.METAL)),
            arcaniumPowerBreakable = registerBlock("arcanium_power_breakable", () -> new BlockMod(COLOR_GRAY, 2, 6)),
            arcaniteTubes = registerBlock("arcanite_tubes", BlockModLadder::new),
            arcaniteLadder = registerBlock("arcanite_ladder", BlockModLadder::new),

            //Twilight Bricks
            edenBricks = registerBlock("eden_bricks", () -> new BlockMod(COLOR_YELLOW, 1.5F, 6)),
            wildwoodBricks = registerBlock("wildwood_bricks", () -> new BlockMod(COLOR_LIGHT_BLUE, 1.5F, 6)),
            apalachiaBricks = registerBlock("apalachia_bricks", () -> new BlockMod(COLOR_MAGENTA, 1.5F, 6)),
            skythernBricks = registerBlock("skythern_bricks", () -> new BlockMod(WOOL, 1.5F, 6)),
            mortumBricks = registerBlock("mortum_bricks", () -> new BlockMod(COLOR_GRAY, 1.5F, 6)),

            //Vethea Bricks & Extra Blocks
            hallWall = registerBlock("hall_wall", () -> new BlockModUnbreakable(NETHER)),
            redDreamBricks = registerBlock("red_dream_bricks", () -> new BlockMod(CRIMSON_NYLIUM, 1.5F, 6)),
            lightDreamBricks = registerBlock("light_dream_bricks", () -> new BlockMod(LAPIS, 1.5F, 6)),
            darkDreamBricks = registerBlock("dark_dream_bricks", () -> new BlockMod(COLOR_BLUE, 1.5F, 6)),
            blueKarosBricks = registerBlock("blue_karos_bricks", () -> new BlockModUnbreakable(COLOR_BLUE)),
            blackKarosBricks = registerBlock("black_karos_bricks", () -> new BlockModUnbreakable(COLOR_BLACK)),
            metalCaging = registerBlock("metal_caging", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_GREEN).requiresCorrectToolForDrops().strength(5).sound(SoundType.METAL).noOcclusion())),
            helioticBeam = registerBlock("heliotic_beam", BlockHelioticBeam::new),
            lunaBricks = registerBlock("luna_bricks", () -> new BlockMod(COLOR_BLUE, 2, 6)),
            cryptFloor = registerBlock("crypt_floor", () -> new BlockModUnbreakable(TERRACOTTA_GREEN)),
            cryptWall = registerBlock("crypt_wall", () -> new BlockModUnbreakable(COLOR_BROWN)),
            chamberWall = registerBlock("chamber_wall", () -> new BlockModUnbreakable(COLOR_BROWN)),
            shiftedChamberWall = registerBlock("shifted_chamber_wall", () -> new BlockModUnbreakable(COLOR_BROWN)),
            stackedChamberWall = registerBlock("stacked_chamber_wall", () -> new BlockModUnbreakable(COLOR_BROWN)),

            //Steel
            steel = registerBlock("steel", () -> new BlockMod(METAL, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            blackSteel = registerBlock("black_steel", () -> new BlockMod(COLOR_BLACK, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            redSteel = registerBlock("red_steel", () -> new BlockMod(COLOR_RED, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            orangeSteel = registerBlock("orange_steel", () -> new BlockMod(COLOR_ORANGE, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            yellowSteel = registerBlock("yellow_steel", () -> new BlockMod(COLOR_YELLOW, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            greenSteel = registerBlock("green_steel", () -> new BlockMod(COLOR_GREEN, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            cyanSteel = registerBlock("cyan_steel", () -> new BlockMod(COLOR_CYAN, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            blueSteel = registerBlock("blue_steel", () -> new BlockMod(COLOR_BLUE, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            purpleSteel = registerBlock("purple_steel", () -> new BlockMod(COLOR_PURPLE, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),
            magentaSteel = registerBlock("magenta_steel", () -> new BlockMod(COLOR_MAGENTA, 5, 6, SoundType.METAL, NoteBlockInstrument.HARP)),

            //Candy Canes
            redCandyCane = registerBlock("red_candy_cane", () -> new BlockCandyCane(COLOR_RED)),
            yellowCandyCane = registerBlock("yellow_candy_cane", () -> new BlockCandyCane(COLOR_YELLOW)),
            greenCandyCane = registerBlock("green_candy_cane", () -> new BlockCandyCane(EMERALD)),
            blueCandyCane = registerBlock("blue_candy_cane", () -> new BlockCandyCane(COLOR_BLUE)),
            pinkCandyCane = registerBlock("pink_candy_cane", () -> new BlockCandyCane(COLOR_MAGENTA)),

            //Lights
            redFairyLights = registerBlock("red_fairy_lights", BlockLights::new),
            yellowFairyLights = registerBlock("yellow_fairy_lights", BlockLights::new),
            greenFairyLights = registerBlock("green_fairy_lights", BlockLights::new),
            blueFairyLights = registerBlock("blue_fairy_lights", BlockLights::new),
            purpleFairyLights = registerBlock("purple_fairy_lights", BlockLights::new),

            //Torches
            aquaTorch = BLOCKS.register("aqua_torch", BlockAquaTorch::new),
            aquaWallTorch = BLOCKS.register("aqua_wall_torch", BlockAquaWallTorch::new),
            arcaniumTorch = BLOCKS.register("arcanium_torch", BlockModTorch::new),
            arcaniumWallTorch = BLOCKS.register("arcanium_wall_torch", BlockModWallTorch::new),
            edenTorch = BLOCKS.register("eden_torch", BlockModTorch::new),
            edenWallTorch = BLOCKS.register("eden_wall_torch", BlockModWallTorch::new),
            skeletonTorch = BLOCKS.register("skeleton_torch", () -> new TorchBlock(Properties.copy(Blocks.TORCH).sound(SoundType.BONE_BLOCK), FLAME)),
            skeletonWallTorch = BLOCKS.register("skeleton_wall_torch", () -> new WallTorchBlock(Properties.copy(Blocks.WALL_TORCH).sound(SoundType.BONE_BLOCK), FLAME)),

            //Stone Lamps
            moltenLamp = registerBlock("molten_lamp", () -> new BlockModLamp(COLOR_ORANGE, SoundType.GLASS)),
            divineLamp = registerBlock("divine_lamp", () -> new BlockModLamp(TERRACOTTA_YELLOW, SoundType.GLASS)),
            jungleLamp = registerBlock("jungle_lamp", () -> new BlockModLamp(COLOR_LIGHT_GREEN, SoundType.GLASS)),
            terranLamp = registerBlock("terran_lamp", () -> new BlockModLamp(EMERALD, SoundType.GLASS)),
            iceLamp = registerBlock("ice_lamp", () -> new BlockModLamp(COLOR_CYAN, SoundType.GLASS)),
            soulfireLamp = registerBlock("soulfire_lamp", () -> new BlockModLamp(WATER, SoundType.GLASS)),
            enderStoneLamp = registerBlock("ender_stone_lamp", () -> new BlockModLamp(COLOR_PURPLE, SoundType.GLASS)),

            //Other Lamps
            milkyLamp = registerBlock("milky_lamp", () -> new BlockModLamp(QUARTZ)),
            edenLamp = registerBlock("eden_lamp", () -> new BlockModLamp(COLOR_RED)),
            torriditeLamp = registerBlock("torridite_lamp", () -> new BlockModLamp(CRIMSON_NYLIUM)),
            lavaLamp = registerBlock("lava_lamp", () -> new BlockModLamp(FIRE)),
            drakenLamp = registerBlock("draken_lamp", () -> new BlockModLamp(COLOR_ORANGE)),
            realmiteLamp = registerBlock("realmite_lamp", () -> new BlockModLamp(COLOR_ORANGE)),
            blazeLamp = registerBlock("blaze_lamp", () -> new BlockModLamp(COLOR_YELLOW)),
            goldLamp = registerBlock("gold_lamp", () -> new BlockModLamp(GOLD)),
            arlemiteLamp = registerBlock("arlemite_lamp", () -> new BlockModLamp(COLOR_LIGHT_GREEN)),
            krakenLamp = registerBlock("kraken_lamp", () -> new BlockModLamp(WARPED_NYLIUM)),
            diamondLamp = registerBlock("diamond_lamp", () -> new BlockModLamp(DIAMOND)),
            rupeeLamp = registerBlock("rupee_lamp", () -> new BlockModLamp(COLOR_LIGHT_BLUE)),
            lapisLazuliLamp = registerBlock("lapis_lazuli_lamp", () -> new BlockModLamp(LAPIS)),
            aquaLamp = registerBlock("aqua_lamp", () -> new BlockModLamp(COLOR_BLUE)),
            enderLamp = registerBlock("ender_lamp", () -> new BlockModLamp(COLOR_PURPLE)),
            bloodgemLamp = registerBlock("bloodgem_lamp", () -> new BlockModLamp(COLOR_PINK)),

            //Extra Lamps
            slimeLight = registerBlock("slime_light", BlockModLight::new),
            workshopLamp = registerBlock("workshop_lamp", () -> new BlockModLamp(COLOR_LIGHT_BLUE, SoundType.GLASS)),
            dungeonLamp = registerBlock("dungeon_lamp", () -> new BlockModUnbreakable(QUARTZ, true)),
            dungeonLampBreakable = registerBlock("dungeon_lamp_breakable", () -> new BlockMod(Properties.of().mapColor(QUARTZ).strength(.3F).sound(SoundType.GLASS).instrument(NoteBlockInstrument.HAT).lightLevel((state) -> 15))),
            cellLamp = registerBlock("cell_lamp", () -> new BlockModLamp(COLOR_LIGHT_GREEN, SoundType.GLASS)),
            villageLamp = registerBlock("village_lamp", () -> new BlockModLamp(TERRACOTTA_RED, SoundType.GLASS)),
            dreamLamp = registerBlock("dream_lamp", BlockDreamLamp::new),

            //Bridges
            darkBridge = registerBlock("dark_bridge", BlockModBridge::new),
            starBridge = registerBlock("star_bridge", BlockModBridge::new),

            //Powered Fences
            redFence = registerBlock("red_fence", () -> new BlockModLightFence(COLOR_RED)),
            blueFence = registerBlock("blue_fence", () -> new BlockModLightFence(COLOR_BLUE)),
            greenFence = registerBlock("green_fence", () -> new BlockModLightFence(COLOR_GREEN)),

            //Glass
            frostedGlass = registerBlock("frosted_glass", BlockModGlass::new),
            stainedGlass = registerBlock("stained_glass", BlockModGlass::new),
            smoothGlass = registerBlock("smooth_glass", BlockModGlass::new),

            //Plants & Fungi
            brittleGrass = registerBlock("brittle_grass", BlockBrittleGrass::new),
            winterberryBush = registerBlock("winterberry_bush", BlockWinterberryBush::new),
            winterberryVinesBody = BLOCKS.register("winterberry_vines_body", () -> new BlockWinterberryVinesBody(Properties.copy(Blocks.WEEPING_VINES_PLANT).sound(SoundType.CAVE_VINES))),
            winterberryVinesHead = registerBlock("winterberry_vines_head", () -> new BlockWinterberryVinesHead(Properties.copy(Blocks.WEEPING_VINES).sound(SoundType.CAVE_VINES))),
            crimpetal = registerBlock("crimpetal", () -> new FlowerBlock(() -> MobEffects.FIRE_RESISTANCE, 7, Properties.copy(Blocks.POPPY).mapColor(COLOR_MAGENTA))),
            roofbell = registerBlock("roofbell", () -> new FlowerBlock(() -> MobEffects.POISON, 14, Properties.copy(Blocks.RED_MUSHROOM).mapColor(COLOR_PINK))),
            winterbloom = registerBlock("winterbloom", () -> new FlowerBlock(() -> MobEffects.LEVITATION, 8, Properties.copy(Blocks.LILY_OF_THE_VALLEY).mapColor(SNOW))),
            wispLeaf = registerBlock("wisp_leaf", () -> new FlowerBlock(() -> MobEffects.DOLPHINS_GRACE, 10, Properties.copy(Blocks.ALLIUM).mapColor(COLOR_LIGHT_GRAY))),
            globebrush = registerBlock("globebrush", () -> new BlockModDoublePlant(frozenGrass, SNOW)),
            thermoliage = registerBlock("thermoliage", () -> new BlockModDoublePlant(frozenGrass, COLOR_PINK)),
            arcanaBrush = registerBlock("arcana_brush", () -> new BlockTwilightGrass(arcaniteSand, ICE)),
            arcanaBush = registerBlock("arcana_bush", () -> new BlockTwilightGrass(arcaniteSand, TERRACOTTA_BLUE)),
            gemOfTheDunes = registerBlock("gem_of_the_dunes", () -> new BlockTwilightFlower(arcaniteSand, COLOR_MAGENTA), Rarity.EPIC),
            arcaniteVinesBody = BLOCKS.register("arcanite_vines_body", () -> new BlockArcaniteVinesBody(Properties.copy(Blocks.WEEPING_VINES_PLANT).sound(SoundType.CAVE_VINES))),
            arcaniteVinesHead = registerBlock("arcanite_vines_head", () -> new BlockArcaniteVinesHead(Properties.copy(Blocks.WEEPING_VINES).sound(SoundType.CAVE_VINES))),
            edenBrush = registerBlock("eden_brush", () -> new BlockTwilightGrass(edenGrass, COLOR_YELLOW)),
            sunBlossom = registerBlock("sun_blossom", () -> new BlockTwilightFlower(edenGrass, .9, .6, PLANT)),
            sunbloom = registerBlock("sunbloom", () -> new BlockTwilightFlower(edenGrass, TERRACOTTA_YELLOW)),
            moonlightFern = registerBlock("moonlight_fern", () -> new BlockTwilightGrass(wildwoodGrass, ICE)),
            moonBud = registerBlock("moon_bud", () -> new BlockTwilightFlower(wildwoodGrass, .8, .7, QUARTZ)),
            wildwoodTallgrass = registerBlock("wildwood_tallgrass", () -> new BlockModDoublePlant(wildwoodGrass, COLOR_BLUE, SoundType.GRASS)),
            truffle = registerBlock("truffle", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_BROWN).strength(1).pushReaction(PushReaction.DESTROY).sound(SoundType.WOOD))),
            wildwoodVine = registerBlock("wildwood_vine", () -> new BlockModVine(COLOR_LIGHT_BLUE)),
            apalachiaTallgrass = registerBlock("apalachia_tallgrass", () -> new BlockTwilightGrass(apalachiaGrass, TERRACOTTA_BLUE)),
            duskBloom = registerBlock("dusk_bloom", () -> new BlockTwilightFlower(apalachiaGrass, .5, .5, TERRACOTTA_BLUE)),
            duskFlower = registerBlock("dusk_flower", () -> new BlockModDoublePlant(apalachiaGrass, TERRACOTTA_BLUE)),
            skythernBrush = registerBlock("skythern_brush", () -> new BlockTwilightGrass(skythernGrass, WOOL)),
            dustLily = registerBlock("dust_lily", () -> new BlockTwilightFlower(skythernGrass, WOOL)),
            dustBrambles = registerBlock("dust_brambles", () -> new BlockBrambles(skythernGrass, WOOL)),
            mortumBrush = registerBlock("mortum_brush", () -> new BlockTwilightGrass(mortumGrass, COLOR_GRAY)),
            eyePlant = registerBlock("eye_plant", () -> new BlockTwilightFlower(mortumGrass, .5, .5, COLOR_GRAY)),
            demonBrambles = registerBlock("demon_brambles", () -> new BlockBrambles(mortumGrass, COLOR_GRAY)),
            shineGrass = registerBlock("shine_grass", () -> new BlockTwilightFlower(dreamGrass, COLOR_CYAN)),
            cracklespike = registerBlock("cracklespike", () -> new BlockTwilightFlower(dreamGrass, COLOR_CYAN)),
            fernite = registerBlock("fernite", () -> new BlockTwilightFlower(dreamGrass, COLOR_CYAN)),
            dreamglow = registerBlock("dreamglow", () -> new BlockTwilightFlower(dreamGrass, COLOR_CYAN)),
            bulbatobe = registerBlock("bulbatobe", () -> new BlockTwilightFlower(dreamGrass, COLOR_CYAN)),
            shimmer = registerBlock("shimmer", () -> new BlockTwilightFlower(dreamGrass, COLOR_CYAN)),
            yellowDulah = registerBlock("yellow_dulah", () -> new BlockTwilightFlower(dreamGrass, COLOR_CYAN)),
            greenDulah = registerBlock("green_dulah", () -> new BlockTwilightFlower(dreamGrass, COLOR_CYAN)),
            greenGemtop = registerBlock("green_gemtop", () -> new BlockTwilightFlower(dreamGrass, COLOR_CYAN)),
            purpleGemtop = registerBlock("purple_gemtop", () -> new BlockTwilightFlower(dreamGrass, COLOR_CYAN)),
            weedwoodVine = registerBlock("weedwood_vine", () -> new BlockModVine(COLOR_BLUE)),
            blossomedWeedwoodVine = registerBlock("blossomed_weedwood_vine", () -> new BlockModVine(COLOR_BLUE)),

            //Crops
            tomatoPlant = registerBlock("tomato_plant", () -> new BlockModCrop(ItemRegistry.tomato_seeds.getId())),
            whiteMushroomPlant = registerBlock("white_mushroom_plant", () -> new BlockModCrop(ItemRegistry.white_mushroom_seeds.getId())),
            aquamarinePlant = registerBlock("aquamarine_plant", () -> new BlockModCrop(ItemRegistry.aquamarine_seeds.getId())),
            eucalyptusPlant = registerBlock("eucalyptus_plant", () -> new BlockModCrop(ItemRegistry.eucalyptus_root_seeds.getId())),
            firestockPlant = registerBlock("firestock_plant", () -> new BlockStackPlant(ItemRegistry.firestock_seeds.getId())),
            hitchakPlant = registerBlock("hitchak_plant", () -> new BlockModCrop(ItemRegistry.hitchak_seeds.getId())),
            lamonaPlant = registerBlock("lamona_plant", () -> new BlockModCrop(ItemRegistry.lamona_seeds.getId())),
            marsinePlant = registerBlock("marsine_plant", () -> new BlockModCrop(ItemRegistry.marsine_seeds.getId())),
            pinflyPlant = registerBlock("pinfly_plant", () -> new BlockStackPlant(ItemRegistry.pinfly_seeds.getId())),
            veiloPlant = registerBlock("veilo_plant", () -> new BlockModCrop(ItemRegistry.veilo_seeds.getId())),
            moonbulbPlant = registerBlock("moonbulb_plant", () -> new BlockModDoubleCrop(4, ItemRegistry.moonbulb_seeds.getId())),
            purpleGlowbonePlant = registerBlock("purple_glowbone_plant", () -> new BlockModDoubleCrop(6, ItemRegistry.purple_glowbone_seeds.getId())),
            pinkGlowbonePlant = registerBlock("pink_glowbone_plant", () -> new BlockModDoubleCrop(6, ItemRegistry.pink_glowbone_seeds.getId())),
            skyPlant = registerBlock("sky_plant", () -> new BlockModCrop(ItemRegistry.sky_plant_seeds.getId())),

            //Mob Pumpkins
            blazePumpkin = registerBlock("blaze_pumpkin", () -> new BlockMobPumpkin(() -> BLAZE_AMBIENT, COLOR_YELLOW)),
            creeperPumpkin = registerBlock("creeper_pumpkin", () -> new BlockMobPumpkin(() -> CREEPER_PRIMED, EMERALD)),
            cyclopsPumpkin = registerBlock("cyclops_pumpkin", () -> new BlockMobPumpkin(CYCLOPS, TERRACOTTA_LIGHT_GREEN)),
            enderPumpkin = registerBlock("ender_pumpkin", () -> new BlockMobPumpkin(() -> ENDERMAN_SCREAM, COLOR_BLACK)),
            enderWatcherPumpkin = registerBlock("ender_watcher_pumpkin", () -> new BlockMobPumpkin(() -> ENDERMAN_AMBIENT, TERRACOTTA_BLUE)),
            frostPumpkin = registerBlock("frost_pumpkin", () -> new BlockMobPumpkin(FROST, WARPED_STEM)),
            ghastPumpkin = registerBlock("ghast_pumpkin", () -> new BlockMobPumpkin(() -> GHAST_SCREAM, SNOW)),
            glaconPumpkin = registerBlock("glacon_pumpkin", () -> new BlockMobPumpkin(GLACIDE, COLOR_CYAN)),
            hellspiderPumpkin = registerBlock("hellspider_pumpkin", () -> new BlockMobPumpkin(HELL_SPIDER, NETHER)),
            jungleSpiderPumpkin = registerBlock("jungle_spider_pumpkin", () -> new BlockMobPumpkin(JUNGLE_SPIDER, PLANT)),
            skeletonPumpkin = registerBlock("skeleton_pumpkin", () -> new BlockMobPumpkin(() -> SKELETON_AMBIENT, WOOL)),
            spiderPumpkin = registerBlock("spider_pumpkin", () -> new BlockMobPumpkin(() -> SPIDER_AMBIENT, COLOR_GRAY)),
            zombiePumpkin = registerBlock("zombie_pumpkin", () -> new BlockMobPumpkin(() -> ZOMBIE_AMBIENT, COLOR_GREEN)),

            //Statues
            ancientEntityStatue = registerWithRender("ancient_entity_statue", () -> new BlockStatue(() -> IRON_GOLEM_DEATH), Rarity.RARE),
            theWatcherStatue = registerWithRender("the_watcher_statue", () -> new BlockStatue(ROAR), Rarity.RARE),
            kingOfScorchersStatue = registerWithRender("king_of_scorchers_statue", () -> new BlockStatue(KING_OF_SCORCHERS), Rarity.RARE),
            kitraStatue = registerWithRender("kitra_statue", () -> new BlockStatue(WHALE), Rarity.RARE),
            ayeracoStatue = registerWithRender("ayeraco_statue", BlockStatueColored::new, Rarity.RARE),
            dramixStatue = registerWithRender("dramix_statue", () -> new BlockStatue(DRAMIX), Rarity.RARE),
            parasectaStatue = registerWithRender("parasecta_statue", () -> new BlockStatue(PARASECTA), Rarity.RARE),
            sunstormStatue = registerWithRender("sunstorm_statue", () -> new BlockStatue(SPARKLER), Rarity.RARE),
            termasectStatue = registerWithRender("termasect_statue", () -> new BlockStatue(() -> WOOD_STEP), Rarity.RARE),
            eternalArcherStatue = registerWithRender("eternal_archer_statue", () -> new BlockStatue(ARCHER), Rarity.RARE),
            experiencedCoriStatue = registerWithRender("experienced_cori_statue", () -> new BlockStatue(CORI), Rarity.RARE),
            vamacheronStatue = registerWithRender("vamacheron_statue", () -> new BlockStatue(null), Rarity.RARE),
            karotStatue = registerWithRender("karot_statue", () -> new BlockStatue(null), Rarity.RARE),
            twilightDemonStatue = registerWithRender("twilight_demon_statue", () -> new BlockStatue(INSECT), Rarity.RARE),
            densosStatue = registerWithRender("densos_statue", () -> new BlockStatue(DENSOS), Rarity.RARE),
            reyvorStatue = registerWithRender("reyvor_statue", () -> new BlockStatue(REYVOR), Rarity.RARE),
            soulFiendStatue = registerWithRender("soul_fiend_statue", () -> new BlockStatue(null), Rarity.RARE),
            
            //Proximity Spawner
            proximitySpawner = registerBlock("proximity_spawner", BlockModProximitySpawner::new),

            //Encaged Arcana Creatures
            encagedCaptainMerik = registerBlock("encaged_captain_merik", () -> new BlockModMobCage(EntityRegistry.CAPTAIN_MERIK.getId(), ItemRegistry.firestock.getId())),
            encagedDatticon = registerBlock("encaged_datticon", () -> new BlockModMobCage(EntityRegistry.DATTICON.getId(), ItemRegistry.aquamarine.getId())),
            encagedKazari = registerBlock("encaged_kazari", () -> new BlockModMobCage(EntityRegistry.KAZARI.getId(), ItemRegistry.lamona.getId())),
            encagedLeorna = registerBlock("encaged_leorna", () -> new BlockModMobCage(EntityRegistry.LEORNA.getId(), ItemRegistry.hitchak.getId())),
            encagedLordVatticus = registerBlock("encaged_lord_vatticus", () -> new BlockModMobCage(EntityRegistry.LORD_VATTICUS.getId(), ItemRegistry.marsine.getId())),
            encagedWarGeneral = registerBlock("encaged_war_general", () -> new BlockModMobCage(EntityRegistry.WAR_GENERAL.getId(), ItemRegistry.pinfly.getId())),
            encagedZelus = registerBlock("encaged_zelus", () -> new BlockModMobCage(EntityRegistry.ZELUS.getId(), ItemRegistry.veilo.getId())),

            //Boss Spawners
            calcifiedBrain = registerBlock("calcified_brain", () -> new BlockModMobCage(Properties.copy(Blocks.BONE_BLOCK), EntityRegistry.KITRA.getId(), ItemRegistry.liopleurodon_skull.getId(), new BlockPos(0, 5, 0))),
            sunstormSpawner = registerBlock("sunstorm_spawner", () -> new BlockModMobCage(EntityRegistry.SUNSTORM.getId(), ItemRegistry.eden_chunk.getId(), COLOR_YELLOW)),
            termasectSpawner = registerBlock("termasect_spawner", () -> new BlockModMobCage(EntityRegistry.TERMASECT.getId(), ItemRegistry.wildwood_chunk.getId(), COLOR_LIGHT_BLUE, new BlockPos(0, 11, 0))),
            eternalArcherSpawner = registerBlock("eternal_archer_spawner", () -> new BlockModMobCage(EntityRegistry.ETERNAL_ARCHER.getId(), ItemRegistry.apalachia_chunk.getId(), COLOR_MAGENTA)),
            experiencedCoriSpawner = registerBlock("experienced_cori_spawner", () -> new BlockModMobCage(EntityRegistry.EXPERIENCED_CORI.getId(), ItemRegistry.skythern_chunk.getId(), COLOR_LIGHT_GRAY, new BlockPos(0, 11, 0))),

            //Boss Altars
            dramixAltar = registerWithRender("dramix_altar", () -> new BlockModAltar(CRIMSON_HYPHAE), Rarity.COMMON),
            parasectaAltar = registerWithRender("parasecta_altar", () -> new BlockModAltar(TERRACOTTA_BROWN), Rarity.COMMON),
            karosAltar = registerBlock("karos_altar", () -> new BlockKarosAltar(WARPED_WART_BLOCK)),
            lunicAltar = registerBlock("lunic_altar", () -> new BlockLunicAltar(COLOR_BLUE)),
            quadroticAltar = registerBlock("quadrotic_altar", () -> new BlockQuadroticAltar(COLOR_BLUE)),
            raglokAltar = registerBlock("raglok_altar", () -> new BlockRaglokAltar(COLOR_BROWN)),
            wreckAltar = registerBlock("wreck_altar", () -> new BlockWreckAltar(COLOR_RED)),

            //Hive Egg
            hiveEgg = registerBlock("hive_egg", BlockHiveEgg::new),

            //Ayeraco Technical Blocks
            ayeracoBeamRed = BLOCKS.register("ayeraco_beam_red", () -> new BlockAyeracoBeam(BossBarColor.RED)),
            ayeracoBeamYellow = BLOCKS.register("ayeraco_beam_yellow", () -> new BlockAyeracoBeam(BossBarColor.YELLOW)),
            ayeracoBeamGreen = BLOCKS.register("ayeraco_beam_green", () -> new BlockAyeracoBeam(BossBarColor.GREEN)),
            ayeracoBeamBlue = BLOCKS.register("ayeraco_beam_blue", () -> new BlockAyeracoBeam(BossBarColor.BLUE)),
            ayeracoBeamPurple = BLOCKS.register("ayeraco_beam_purple", () -> new BlockAyeracoBeam(BossBarColor.PURPLE)),
            ayeracoBeamPink = BLOCKS.register("ayeraco_beam_pink", () -> new BlockAyeracoBeam(BossBarColor.PINK)),
            ayeracoSpawn = BLOCKS.register("ayeraco_spawn", BlockAyeracoSpawn::new),

            //Doors
            steelDoor = registerBlock("steel_door", () -> new BlockModDoor(METAL)),
            ancientBrickDoor = registerBlock("ancient_brick_door", () -> new BlockArcanaDoor(WARPED_NYLIUM, ItemRegistry.ancient_key.getId())),
            degradedBrickDoor = registerBlock("degraded_brick_door", () -> new BlockArcanaDoor(COLOR_BLUE, ItemRegistry.degraded_key.getId())),
            soulSludgeDoor = registerBlock("soul_sludge_door", () -> new BlockArcanaDoor(COLOR_GRAY, ItemRegistry.sludge_key.getId())),
            soulStoneDoor = registerBlock("soul_stone_door", () -> new BlockArcanaDoor(TERRACOTTA_BLUE, ItemRegistry.soul_key.getId())),
            barredDoor = registerBlock("barred_door", () -> new BlockModDoor(PLANT)),

            //Crafting & Stuff
            altarOfCorruption = registerBlock("altar_of_corruption", BlockAltarOfCorruption::new, Rarity.UNCOMMON),
            arcaniumExtractor = registerWithRender("arcanium_extractor", BlockArcaniumExtractor::new, Rarity.RARE),
            infusionTable = registerBlock("infusion_table", BlockInfusionTable::new, Rarity.RARE),

            //Furnaces
            coalstoneFurnace = registerBlock("coalstone_furnace", () -> new BlockModInfiniFurnace(BlockEntityRegistry.COALSTONE_FURNACE::get, COLOR_GRAY)),
            moltenFurnace = registerBlock("molten_furnace", () -> new BlockModInfiniFurnace(BlockEntityRegistry.MOLTEN_FURNACE::get, TERRACOTTA_LIGHT_GRAY), Rarity.UNCOMMON),
            greenlightFurnace = registerBlock("greenlight_furnace", () -> new BlockModFurnace(BlockEntityRegistry.GREENLIGHT_FURNACE::get, TERRACOTTA_LIGHT_GREEN), Rarity.UNCOMMON),
            oceanfireFurnace = registerBlock("oceanfire_furnace", () -> new BlockModInfiniFurnace(BlockEntityRegistry.OCEANFIRE_FURNACE::get, COLOR_CYAN), Rarity.UNCOMMON),
            moonlightFurnace = registerBlock("moonlight_furnace", () -> new BlockModFurnace(BlockEntityRegistry.MOONLIGHT_FURNACE::get, TERRACOTTA_BLUE), Rarity.UNCOMMON),
            whitefireFurnace = registerBlock("whitefire_furnace", () -> new BlockModInfiniFurnace(BlockEntityRegistry.WHITEFIRE_FURNACE::get, SNOW), Rarity.UNCOMMON),
            demonFurnace = registerWithRender("demon_furnace", BlockDemonFurnace::new, Rarity.EPIC),

            //Chests
            crate = registerBlock("crate", BlockCrate::new),
            boneChest = registerWithRender("bone_chest", BlockBoneChest::new, Rarity.COMMON),
            frostedChest = registerWithRender("frosted_chest", BlockFrostedChest::new, Rarity.COMMON),
            presentBox = registerWithRender("present_box", BlockPresentBox::new, Rarity.COMMON),
            edenChest = registerWithRender("eden_chest", BlockEdenChest::new, Rarity.COMMON),

            //Nightmare Bed
            nightmareBed = BLOCKS.register("nightmare_bed", BlockNightmareBed::new),

            //Other Utility Blocks
            hellfireSponge = registerBlock("hellfire_sponge", BlockHellfireSponge::new),
            coldHellfireSponge = registerBlock("cold_hellfire_sponge", BlockColdHellfireSponge::new),
            frostedAllure = registerBlock("frosted_allure", BlockFrostedAllure::new, Rarity.UNCOMMON),
            robbinNest = registerBlock("robbin_nest", BlockRobbinNest::new),
            robbinHut = registerBlock("robbin_hut", BlockRobbinHut::new),
            acceleron = registerBlock("acceleron", BlockAcceleron::new, Rarity.UNCOMMON),
            elevantium = registerBlock("elevantium", BlockElevantium::new, Rarity.UNCOMMON),
            soulTrap = registerBlock("soul_trap", BlockModSoulTrap::new),

            //Traps
            spikeBlock = registerBlock("spike_block", () -> new BlockSpike(false, METAL)),
            hotSpikeBlock = registerBlock("hot_spike_block", () -> new BlockSpike(true, CRIMSON_NYLIUM)),
            heatTrap = registerBlock("heat_trap", BlockHeatTrap::new),
            karosHeatTile = registerBlock("karos_heat_tile", BlockKarosHeatTile::new),
            karosDispenser = registerBlock("karos_dispenser", BlockKarosDispenser::new),

            //Acid
            acidBlock = registerBlock("acid_block", BlockAcid::new),
            bacterialAcid = registerBlock("bacterial_acid", BlockAcid::new),
            lunicAcid = registerBlock("lunic_acid", BlockAcid::new),

            //Fire
            iceikaFire = registerBlock("iceika_fire", BlockIceikaFire::new),
            blueFire = registerBlock("blue_fire", BlockBlueFire::new),

            //Portals
            arcanaPortal = registerBlock("arcana_portal", BlockArcanaPortal::new),
            iceikaPortal = registerBlock("iceika_portal", () -> new BlockModPortal(Blocks.SNOW_BLOCK)),
            edenPortal = registerBlock("eden_portal", () -> new BlockModPortal(divineRock.get())),
            wildwoodPortal = registerBlock("wildwood_portal", () -> new BlockModPortal(edenBlock.get())),
            apalachiaPortal = registerBlock("apalachia_portal", () -> new BlockModPortal(wildwoodBlock.get())),
            skythernPortal = registerBlock("skythern_portal", () -> new BlockModPortal(apalachiaBlock.get())),
            mortumPortal = registerBlock("mortum_portal", () -> new BlockModPortal(skythernBlock.get())),
            vetheaPortal = registerBlock("vethea_portal", () -> new BlockModPortal(mortumBlock.get())),

            //Air
            dungeonAir = registerBlock("dungeon_air", BlockModDungeonAir::new, Rarity.EPIC),
            
            //Creative Mode Blocks
            randomItemDropper = registerBlock("random_item_dropper", BlockRandomItemDropper::new);

    //Flower Pots
    public static final RegistryObject<FlowerPotBlock>
            //Saplings
            divineSaplingPot = registerFlowerPot("divine_sapling_pot", divineSapling),
            shiverspineSaplingPot = registerFlowerPot("shiverspine_sapling_pot", shiverspineSapling),
            auroraoakSaplingPot = registerFlowerPot("auroraoak_sapling_pot", auroraoakSapling),
            cozybarkSaplingPot = registerFlowerPot("cozybark_sapling_pot", cozybarkSapling),
            streamleafSaplingPot = registerFlowerPot("streamleaf_sapling_pot", streamleafSapling),
            edenSaplingPot = registerFlowerPot("eden_sapling_pot", edenSapling),
            wildwoodSaplingPot = registerFlowerPot("wildwood_sapling_pot", wildwoodSapling),
            apalachiaSaplingPot = registerFlowerPot("apalachia_sapling_pot", apalachiaSapling),
            skythernSaplingPot = registerFlowerPot("skythern_sapling_pot", skythernSapling),
            mortumSaplingPot = registerFlowerPot("mortum_sapling_pot", mortumSapling),
            //Mushrooms
            glowsproutPot = registerFlowerPot("glowsprout_pot", glowsprout),
            lowsproutPot = registerFlowerPot("lowsprout_pot", lowsprout),
            slowsproutPot = registerFlowerPot("slowsprout_pot", slowsprout),
            dreamglowPot = registerFlowerPot("dreamglow_pot", dreamglow),
            //Short Flowers
            crimpetalPot = registerFlowerPot("crimpetal_pot", crimpetal),
            roofbellPot = registerFlowerPot("roofbell_pot", roofbell),
            winterbloomPot = registerFlowerPot("winterbloom_pot", winterbloom),
            wispLeafPot = registerFlowerPot("wisp_leaf_pot", wispLeaf),
            gemOfTheDunesPot = registerFlowerPot("gem_of_the_dunes_pot", gemOfTheDunes),
            sunBlossomPot = registerFlowerPot("sun_blossom_pot", sunBlossom),
            sunbloomPot = registerFlowerPot("sunbloom_pot", sunbloom),
            moonlightFernPot = registerFlowerPot("moonlight_fern_pot", moonlightFern),
            moonBudPot = registerFlowerPot("moon_bud_pot", moonBud),
            duskBloomPot = registerFlowerPot("dusk_bloom_pot", duskBloom),
            dustLilyPot = registerFlowerPot("dust_lily_pot", dustLily),
            eyePlantPot = registerFlowerPot("eye_plant_pot", eyePlant),
            shineGrassPot = registerFlowerPot("shine_grass_pot", shineGrass),
            cracklespikePot = registerFlowerPot("cracklespike_pot", cracklespike),
            fernitePot = registerFlowerPot("fernite_pot", fernite),
            bulbatobePot = registerFlowerPot("bulbatobe_pot", bulbatobe),
            shimmerPot = registerFlowerPot("shimmer_pot", shimmer),
            yellowDulahPot = registerFlowerPot("yellow_dulah_pot", yellowDulah),
            greenDulahPot = registerFlowerPot("green_dulah_pot", greenDulah),
            greenGemtopPot = registerFlowerPot("green_gemtop_pot", greenGemtop),
            purpleGemtopPot = registerFlowerPot("purple_gemtop_pot", purpleGemtop),
            //Tall Flowers
            globebrushPot = registerFlowerPot("globebrush_pot", globebrush),
            thermoliagePot = registerFlowerPot("thermoliage_pot", thermoliage),
            duskFlowerPot = registerFlowerPot("dusk_flower_pot", duskFlower),
            dustBramblesPot = registerFlowerPot("dust_brambles_pot", dustBrambles),
            demonBramblesPot = registerFlowerPot("demon_brambles_pot", demonBrambles),
            //Bushes
            arcanaBushPot = registerFlowerPot("arcana_bush_pot", arcanaBush);

    private static RegistryObject<FlowerPotBlock> registerFlowerPot(String name, Supplier<? extends Block> flower) {
        return BLOCKS.register(name, () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, flower, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, Rarity.COMMON);
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String registryName, Supplier<T> block, Rarity rarity) {
        RegistryObject<T> registeredBlock = BLOCKS.register(registryName, block);
        BLOCK_ITEMS.register(registryName, () -> new BlockItem(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        return registeredBlock;
    }
    private static <T extends Block> RegistryObject<T> registerFireResistantBlock(String registryName, Supplier<T> block) {
        RegistryObject<T> registeredBlock = BLOCKS.register(registryName, block);
        BLOCK_ITEMS.register(registryName, () -> new BlockItem(registeredBlock.get(), new Item.Properties().fireResistant()));
        return registeredBlock;
    }
    private static <T extends Block> RegistryObject<T> registerWithRender(String registryName, Supplier<T> block, Rarity rarity) {
        RegistryObject<T> registeredBlock = BLOCKS.register(registryName, block);
        if(Objects.equals(registryName, "arcanium_extractor")) BLOCK_ITEMS.register(registryName, () -> new ItemArcaniumExtractor(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        else if(Objects.equals(registryName, "bone_chest")) BLOCK_ITEMS.register(registryName, () -> new ItemBoneChest(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        else if(Objects.equals(registryName, "demon_furnace")) BLOCK_ITEMS.register(registryName, () -> new ItemDemonFurnace(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        else if(Objects.equals(registryName, "frosted_chest")) BLOCK_ITEMS.register(registryName, () -> new ItemFrostedChest(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        else if(Objects.equals(registryName, "present_box")) BLOCK_ITEMS.register(registryName, () -> new ItemPresentBox(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        else if(Objects.equals(registryName, "eden_chest")) BLOCK_ITEMS.register(registryName, () -> new ItemEdenChest(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        else if(Objects.equals(registryName, "parasecta_altar")) BLOCK_ITEMS.register(registryName, () -> new ItemParasectaAltar(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        else if(Objects.equals(registryName, "dramix_altar")) BLOCK_ITEMS.register(registryName, () -> new ItemDramixAltar(registeredBlock.get(), new Item.Properties().rarity(rarity)));
        else BLOCK_ITEMS.register(registryName, () -> new ItemStatueBlock(registeredBlock::get, new Item.Properties().rarity(rarity).fireResistant()));
        return registeredBlock;
    }
}