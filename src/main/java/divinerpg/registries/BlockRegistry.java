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
import net.minecraft.world.level.block.state.properties.*;
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
            //Dirt & Dream Stone
            frozenDirt = registerBlock("frozen_dirt", () -> new BlockModDirt(ICE)),
            arcaniteDirt = registerBlock("arcanite_dirt", () -> new BlockModDirt(TERRACOTTA_BLUE)),
            edenDirt = registerBlock("eden_dirt", () -> new BlockModDirt(TERRACOTTA_YELLOW)),
            wildwoodDirt = registerBlock("wildwood_dirt", () -> new BlockModDirt(LAPIS)),
            apalachiaDirt = registerBlock("apalachia_dirt", () -> new BlockModDirt(COLOR_PURPLE)),
            skythernDirt = registerBlock("skythern_dirt", () -> new BlockModDirt(COLOR_LIGHT_GRAY)),
            mortumDirt = registerBlock("mortum_dirt", () -> new BlockModDirt(COLOR_GRAY)),
            dreamDirt = registerBlock("dream_dirt", () -> new BlockModDirt(COLOR_CYAN)),
            dreamStone = registerBlock("dream_stone", () -> new BlockMod(COLOR_CYAN, 1.5F, 6F)),

            //Grass Blocks
            frozenGrass = registerBlock("frozen_grass", () -> new BlockModGrass( () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "frozen_dirt")), DIAMOND)),
            arcaniteGrass = registerBlock("arcanite_grass", () -> new BlockArcaniteGrass()),
            edenGrass = registerBlock("eden_grass", () -> new BlockModGrass(edenDirt, COLOR_YELLOW)),
            wildwoodGrass = registerBlock("wildwood_grass", () -> new BlockModGrass(wildwoodDirt, WATER)),
            apalachiaGrass = registerBlock("apalachia_grass", () -> new BlockModGrass(apalachiaDirt, COLOR_PURPLE)),
            skythernGrass = registerBlock("skythern_grass", () -> new BlockModGrass(skythernDirt, SNOW)),
            mortumGrass = registerBlock("mortum_grass", () -> new BlockModGrass(mortumDirt, STONE)),
            flameGrass = registerBlock("flame_grass", () -> new BlockDreamGrass(COLOR_ORANGE)),
            dreamGrass = registerBlock("dream_grass", () -> new BlockDreamGrass(WARPED_WART_BLOCK)),
            evergrass = registerBlock("evergrass", () -> new BlockDreamGrass(COLOR_MAGENTA)),
            scorchedGrass = registerBlock("scorched_grass", () -> new BlockModGrass(() -> dreamStone.get())),

            //Sand
            arcaniteSand = registerBlock("arcanite_sand", () -> new SandBlock(7579884, Properties.copy(Blocks.SAND).mapColor(ICE))),
            arcanicSand = registerBlock("arcanic_sand", () -> new SandBlock(7579884, Properties.copy(Blocks.SAND).mapColor(MapColor.COLOR_LIGHT_BLUE))),
            arcanium_rich_sand = registerBlock("arcanium_rich_sand", () -> new SandBlock(7579884, Properties.copy(Blocks.SAND).mapColor(MapColor.COLOR_BLUE))),
            soulSludge = registerBlock("soul_sludge", () -> new BlockModUnbreakable(Properties.copy(Blocks.SOUL_SAND).strength(-1F, 3600000F).mapColor(MapColor.COLOR_GRAY))),
            soulSludgeBreakable = registerBlock("soul_sludge_breakable", () -> new BlockMod(Properties.copy(Blocks.SOUL_SAND).mapColor(MapColor.COLOR_GRAY))),

            //Moss
            brittleMoss = registerBlock("brittle_moss", () -> new BlockBrittleMoss()),
            arcaniteMoss = registerBlock("arcanite_moss", () -> new BlockModMoss(Properties.copy(Blocks.MOSS_BLOCK).mapColor(MapColor.COLOR_LIGHT_BLUE))),

            //Stone & Stuff
            milkStone = registerBlock("milk_stone", () -> new BlockMod(WOOL, 1.5F, 6F)),
            frozenStone = registerBlock("frozen_stone", () -> new BlockMod(GLOW_LICHEN, 1.5F, 6F)),
            icyStone = registerBlock("icy_stone", () -> new BlockMod(GLOW_LICHEN, 2F, 6F)),
            blueStone = registerBlock("blue_stone", () -> new BlockLightCrystal(COLOR_LIGHT_BLUE)),
            icicle = registerBlock("icicle", () -> new BlockIcicle()),
            coalstone = registerBlock("coalstone", () -> new BlockMod(COLOR_GRAY, 1.5F, 6F)),
            coalstoneStairs = registerBlock("coalstone_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "coalstone")), 0, 0)),
            coalstoneSlab = registerBlock("coalstone_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "coalstone")), 0, 0)),
            thermalVent = registerBlock("thermal_vent", () -> new BlockThermalVent()),
            arcaniteStone = registerBlock("arcanite_stone", () -> new BlockMod(COLOR_LIGHT_BLUE, 1.5F, 6F)),
            twilightStone = registerBlock("twilight_stone", () -> new BlockMod(TERRACOTTA_LIGHT_BLUE, 1.5F, 6F)),
            divineMossStone = registerBlock("divine_moss_stone", () -> new BlockMod(STONE, 2F, 6F)),
            divineRock = registerBlock("divine_rock", () -> new BlockMod(GOLD, 1.5F, 6F)),
            everstone = registerBlock("everstone", () -> new BlockModUnbreakable(PLANT)),
            whiteEverstone = registerBlock("white_everstone", () -> new BlockModUnbreakable(WOOL)),
            darkEverstone = registerBlock("dark_everstone", () -> new BlockModUnbreakable(COLOR_BLACK)),
            blackHungerstone = registerBlock("black_hungerstone", () -> new BlockModUnbreakable(COLOR_BLACK)),
            greenHungerstone = registerBlock("green_hungerstone", () -> new BlockModUnbreakable(PLANT)),
            cryptFloor = registerBlock("crypt_floor", () -> new BlockModUnbreakable(TERRACOTTA_GREEN)),
            lunaStone = registerBlock("luna_stone", () -> new BlockMod(COLOR_BLUE, 2F, 6F)),
            hiveWall = registerBlock("hive_wall", () -> new BlockMod(Properties.of().mapColor(PLANT).strength(0.3F).sound(SoundType.GLASS).instrument(NoteBlockInstrument.HAT).lightLevel((state) -> 7))),
            fireCrystal = registerBlock("fire_crystal", () -> new BlockLightCrystal(COLOR_RED)),
            firelight = registerBlock("firelight", () -> new BlockLightCrystal(COLOR_BLUE)),

            //Ores
            arlemiteOre			 = registerBlock("arlemite_ore",			() -> new BlockMod(STONE, 3F, 3F)),
            arlemiteOreDeepslate = registerBlock("arlemite_ore_deepslate",  () -> new BlockMod(DEEPSLATE, 4.5F, 3F, SoundType.DEEPSLATE, NoteBlockInstrument.BASEDRUM)),
            realmiteOre			 = registerBlock("realmite_ore",			() -> new BlockMod(STONE, 3F, 3F)),
            realmiteOreDeepslate = registerBlock("realmite_ore_deepslate",  () -> new BlockMod(DEEPSLATE, 4.5F, 3F, SoundType.DEEPSLATE, NoteBlockInstrument.BASEDRUM)),
            rupeeOre			 = registerBlock("rupee_ore",				() -> new BlockMod(STONE, 3F, 3F)),
            rupeeOreDeepslate	 = registerBlock("rupee_ore_deepslate",  	() -> new BlockMod(DEEPSLATE, 4.5F, 3F, SoundType.DEEPSLATE, NoteBlockInstrument.BASEDRUM)),
            bloodgemOre			 = registerBlock("bloodgem_ore",			() -> new BlockMod(NETHER, 3F, 3F, SoundType.NETHER_ORE, NoteBlockInstrument.BASEDRUM)),
            torriditeOre		 = registerBlock("torridite_ore",			() -> new BlockMod(NETHER, 3F, 1200F, SoundType.NETHER_ORE, NoteBlockInstrument.BASEDRUM)),
            rawArcanium = registerBlock("raw_arcanium", () -> new BlockMod(COLOR_BLACK, 5F, 6F)),
            edenOre = registerBlock("eden_ore", () -> new BlockMod(TERRACOTTA_LIGHT_BLUE, 3F, 32F)),
            wildwoodOre = registerBlock("wildwood_ore", () -> new BlockMod(TERRACOTTA_LIGHT_BLUE, 3F, 32F)),
            apalachiaOre = registerBlock("apalachia_ore", () -> new BlockMod(TERRACOTTA_LIGHT_BLUE, 3F, 32F)),
            skythernOre = registerBlock("skythern_ore", () -> new BlockMod(TERRACOTTA_LIGHT_BLUE, 3F, 32F)),
            mortumOre = registerBlock("mortum_ore", () -> new BlockMod(TERRACOTTA_LIGHT_BLUE, 3F, 32F)),

            //Compressed Ore Blocks
            rawArlemiteBlock= registerBlock("raw_arlemite_block",() -> new BlockMod(COLOR_LIGHT_GREEN, 5F, 6F)),
            arlemiteBlock	= registerBlock("arlemite_block",	() -> new BlockMod(COLOR_LIGHT_GREEN, 5F, 6F, SoundType.METAL, NoteBlockInstrument.HARP)),
            rawRealmiteBlock= registerBlock("raw_realmite_block",() -> new BlockMod(COLOR_ORANGE, 5F, 6F)),
            realmiteBlock	= registerBlock("realmite_block",	() -> new BlockMod(COLOR_ORANGE, 5F, 6F, SoundType.METAL, NoteBlockInstrument.HARP)),
            rawRupeeBlock	= registerBlock("raw_rupee_block",	() -> new BlockMod(COLOR_LIGHT_BLUE, 5F, 6F)),
            rupeeBlock		= registerBlock("rupee_block",		() -> new BlockMod(COLOR_LIGHT_BLUE, 5F, 6F, SoundType.METAL, NoteBlockInstrument.HARP)),
            bloodgemBlock	= registerBlock("bloodgem_block",	() -> new BlockMod(CRIMSON_STEM, 5F, 6F, SoundType.METAL, NoteBlockInstrument.HARP)),
            rawTorriditeBlock= registerBlock("raw_torridite_block",() -> new BlockMod(CRIMSON_NYLIUM, 5F, 1200F)),
            torriditeBlock  = registerFireResistantBlock("torridite_block",() -> new BlockMod(Properties.of().mapColor(CRIMSON_NYLIUM).strength(5F, 1200F).requiresCorrectToolForDrops().sound(SoundType.METAL)), Rarity.COMMON),
            arcaniumBlock = registerBlock("arcanium_block", () -> new BlockMod(COLOR_LIGHT_BLUE, 5F, 6F, SoundType.METAL, NoteBlockInstrument.HARP)),

            //Twilight Compressed Ore Blocks
            edenBlock = registerBlock("eden_block", () -> new BlockMod(TERRACOTTA_ORANGE, 1.5F, 6F)),
            wildwoodBlock = registerBlock("wildwood_block", () -> new BlockMod(LAPIS, 1.5F, 6F)),
            apalachiaBlock = registerBlock("apalachia_block", () -> new BlockMod(COLOR_MAGENTA, 1.5F, 6F)),
            skythernBlock = registerBlock("skythern_block", () -> new BlockMod(WOOL, 1.5F, 6F)),
            mortumBlock = registerBlock("mortum_block", () -> new BlockMod(COLOR_GRAY, 1.5F, 6F)),

            //Arcana Portal Frames
            arcanaHardPortalFrame = registerBlock("arcana_hard_portal_frame", () -> new BlockArcanaPortalFrame(-1, 3600000F)),
            arcanaPortalFrame = registerBlock("arcana_portal_frame", () -> new BlockArcanaPortalFrame(5F, 6F)),

            //Extra Wood Blocks
            crate = registerBlock("crate", () -> new BlockMod(WOOD,2.5F, 2.5F, 20, 5, SoundType.WOOD, NoteBlockInstrument.BASS)),
            plankDesign = registerBlock("plank_design", () -> new BlockModPlanks(WOOD, SoundType.WOOD)),

            //Divine Tree
            divineSapling = registerBlock("divine_sapling", () -> new BlockModSapling(GOLD, () -> Blocks.GRASS, () -> Blocks.DIRT, new DivineTreeGrower())),
            divineLeaves = registerBlock("divine_leaves", () -> new BlockModLeaves(GOLD, SoundType.GRASS)),
            divineLog = registerBlock("divine_log", () -> new BlockModLog(TERRACOTTA_LIGHT_GREEN, SoundType.CHERRY_WOOD)),
            divineWood = registerBlock("divine_wood", () -> new BlockModLog(TERRACOTTA_LIGHT_GREEN, SoundType.CHERRY_WOOD)),
            strippedDivineLog = registerBlock("stripped_divine_log", () -> new BlockModLog(TERRACOTTA_LIGHT_GREEN, SoundType.CHERRY_WOOD)),
            strippedDivineWood = registerBlock("stripped_divine_wood", () -> new BlockModLog(TERRACOTTA_LIGHT_GREEN, SoundType.CHERRY_WOOD)),
            divinePlanks = registerBlock("divine_planks", () -> new BlockModPlanks(TERRACOTTA_LIGHT_GREEN, SoundType.CHERRY_WOOD)),
            divineStairs = registerBlock("divine_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "divine_planks")), 20, 5)),
            divineSlab = registerBlock("divine_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "divine_planks")), 20, 5)),
            divineFence = registerBlock("divine_fence", () -> new BlockModFence(TERRACOTTA_LIGHT_GREEN, SoundType.CHERRY_WOOD)),
            divineFenceGate = registerBlock("divine_fence_gate", () -> new BlockModGate(TERRACOTTA_LIGHT_GREEN, WoodType.CHERRY)),
            divineDoor = registerBlock("divine_door", () -> new BlockModDoor(TERRACOTTA_LIGHT_GREEN, BlockSetType.CHERRY)),
            divineTrapdoor = registerBlock("divine_trapdoor", () -> new BlockModTrapdoor(TERRACOTTA_LIGHT_GREEN, BlockSetType.CHERRY)),
            divinePressurePlate = registerBlock("divine_pressure_plate", () -> new BlockModPressurePlate(TERRACOTTA_LIGHT_GREEN, BlockSetType.CHERRY)),
            divineButton = registerBlock("divine_button", () -> new BlockModButton(BlockSetType.CHERRY)),

            //Shiverspine
            shiverspineSapling = registerBlock("shiverspine_sapling", () -> new BlockModSapling(ICE, () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "frozen_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "frozen_dirt")), new ShiverspineTreeGrower())),
            brittleLeaves = registerBlock("brittle_leaves", () -> new BlockModLeaves(WOOL, SoundType.GRASS)),
            shiverspineLog = registerBlock("shiverspine_log", () -> new BlockModLog(ICE, SoundType.WOOD)),
            shiverspineWood = registerBlock("shiverspine_wood", () -> new BlockModLog(COLOR_LIGHT_GRAY, SoundType.WOOD)),
            strippedShiverspineLog = registerBlock("stripped_shiverspine_log", () -> new BlockModLog(ICE, SoundType.WOOD)),
            strippedShiverspineWood = registerBlock("stripped_shiverspine_wood", () -> new BlockModLog(ICE, SoundType.WOOD)),
            shiverspinePlanks = registerBlock("shiverspine_planks", () -> new BlockModPlanks(ICE, SoundType.WOOD)),
            shiverspineStairs = registerBlock("shiverspine_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "shiverspine_planks")), 20, 5)),
            shiverspineSlab = registerBlock("shiverspine_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "shiverspine_planks")), 20, 5)),
            shiverspineLadder = registerBlock("shiverspine_ladder", () -> new BlockModLadder()),
            shiverspineFence = registerBlock("shiverspine_fence", () -> new BlockModFence(ICE, SoundType.WOOD)),
            shiverspineFenceGate = registerBlock("shiverspine_fence_gate", () -> new BlockModGate(ICE, WoodType.SPRUCE)),
            shiverspineDoor = registerBlock("shiverspine_door", () -> new BlockModDoor(ICE, BlockSetType.SPRUCE)),
            shiverspineTrapdoor = registerBlock("shiverspine_trapdoor", () -> new BlockModTrapdoor(ICE, BlockSetType.SPRUCE)),
            shiverspinePressurePlate = registerBlock("shiverspine_pressure_plate", () -> new BlockModPressurePlate(ICE, BlockSetType.SPRUCE)),
            shiverspineButton = registerBlock("shiverspine_button", () -> new BlockModButton(BlockSetType.SPRUCE)),
            
            //Auroraoak
            auroraoakSapling = registerBlock("auroraoak_sapling", () -> new BlockModSapling(COLOR_MAGENTA, () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "frozen_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "frozen_dirt")), new AuroraoakTreeGrower())),
            auroraoakLeaves = registerBlock("auroraoak_leaves", () -> new BlockModLeaves(COLOR_MAGENTA, SoundType.CHERRY_LEAVES)),
            auroraoakLog = registerBlock("auroraoak_log", () -> new BlockModLog(SNOW, SoundType.WOOD)),
            auroraoakWood = registerBlock("auroraoak_wood", () -> new BlockModLog(COLOR_GRAY, SoundType.WOOD)),
            strippedAuroraoakLog = registerBlock("stripped_auroraoak_log", () -> new BlockModLog(SNOW, SoundType.WOOD)),
            strippedAuroraoakWood = registerBlock("stripped_auroraoak_wood", () -> new BlockModLog(SNOW, SoundType.WOOD)),
            auroraoakPlanks = registerBlock("auroraoak_planks", () -> new BlockModPlanks(SNOW, SoundType.WOOD)),
            auroraoakStairs = registerBlock("auroraoak_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "auroraoak_planks")), 20, 5)),
            auroraoakSlab = registerBlock("auroraoak_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "auroraoak_planks")), 20, 5)),
            auroraoakFence = registerBlock("auroraoak_fence", () -> new BlockModFence(SNOW, SoundType.WOOD)),
            auroraoakFenceGate = registerBlock("auroraoak_fence_gate", () -> new BlockModGate(SNOW, WoodType.OAK)),
            auroraoakDoor = registerBlock("auroraoak_door", () -> new BlockModDoor(SNOW, BlockSetType.OAK)),
            auroraoakTrapdoor = registerBlock("auroraoak_trapdoor", () -> new BlockModTrapdoor(SNOW, BlockSetType.OAK)),
            auroraoakPressurePlate = registerBlock("auroraoak_pressure_plate", () -> new BlockModPressurePlate(SNOW, BlockSetType.OAK)),
            auroraoakButton = registerBlock("auroraoak_button", () -> new BlockModButton(BlockSetType.OAK)),

            //Eucalyptus
            eucalyptusLog = registerBlock("eucalyptus_log", () -> new BlockModLog(TERRACOTTA_WHITE, SoundType.WOOD)),
            eucalyptusWood = registerBlock("eucalyptus_wood", () -> new BlockModLog(TERRACOTTA_WHITE, SoundType.WOOD)),
            strippedEucalyptusLog = registerBlock("stripped_eucalyptus_log", () -> new BlockModLog(TERRACOTTA_WHITE, SoundType.WOOD)),
            strippedEucalyptusWood = registerBlock("stripped_eucalyptus_wood", () -> new BlockModLog(TERRACOTTA_WHITE, SoundType.WOOD)),
            eucalyptusPlanks = registerBlock("eucalyptus_planks", () -> new BlockModPlanks(TERRACOTTA_WHITE, SoundType.WOOD)),
            eucalyptusStairs = registerBlock("eucalyptus_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eucalyptus_planks")), 20, 5)),
            eucalyptusSlab = registerBlock("eucalyptus_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eucalyptus_planks")), 20, 5)),
            eucalyptusFence = registerBlock("eucalyptus_fence", () -> new BlockModFence(TERRACOTTA_WHITE, SoundType.WOOD)),
            eucalyptusFenceGate = registerBlock("eucalyptus_fence_gate", () -> new BlockModGate(TERRACOTTA_WHITE, WoodType.BIRCH)),
            eucalyptusDoor = registerBlock("eucalyptus_door", () -> new BlockModDoor(TERRACOTTA_WHITE, BlockSetType.BIRCH)),
            eucalyptusTrapdoor = registerBlock("eucalyptus_trapdoor", () -> new BlockModTrapdoor(TERRACOTTA_WHITE, BlockSetType.BIRCH)),
            eucalyptusPressurePlate = registerBlock("eucalyptus_pressure_plate", () -> new BlockModPressurePlate(TERRACOTTA_WHITE, BlockSetType.BIRCH)),
            eucalyptusButton = registerBlock("eucalyptus_button", () -> new BlockModButton(BlockSetType.BIRCH)),

            //Eden Tree
            edenSapling = registerBlock("eden_sapling", () -> new BlockModSapling(SAND, () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_dirt")), new EdenTreeGrower())),
            edenLeaves = registerBlock("eden_leaves", () -> new BlockModLeaves(SAND, SoundType.AZALEA_LEAVES)),
            edenLog = registerBlock("eden_log", () -> new BlockModLog(SAND, SoundType.WOOD)),
            edenWood = registerBlock("eden_wood", () -> new BlockModLog(COLOR_BROWN, SoundType.WOOD)),
            strippedEdenLog = registerBlock("stripped_eden_log", () -> new BlockModLog(SAND, SoundType.WOOD)),
            strippedEdenWood = registerBlock("stripped_eden_wood", () -> new BlockModLog(SAND, SoundType.WOOD)),
            edenPlanks = registerBlock("eden_planks", () -> new BlockModPlanks(SAND, SoundType.WOOD)),
            edenStairs = registerBlock("eden_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_planks")), 20, 5)),
            edenSlab = registerBlock("eden_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_planks")), 20, 5)),
            edenFence = registerBlock("eden_fence", () -> new BlockModFence(SAND, SoundType.WOOD)),
            edenFenceGate = registerBlock("eden_fence_gate", () -> new BlockModGate(SAND, WoodType.OAK)),
            edenDoor = registerBlock("eden_door", () -> new BlockModDoor(SAND, BlockSetType.OAK)),
            edenTrapdoor = registerBlock("eden_trapdoor", () -> new BlockModTrapdoor(SAND, BlockSetType.OAK)),
            edenPressurePlate = registerBlock("eden_pressure_plate", () -> new BlockModPressurePlate(SAND, BlockSetType.OAK)),
            edenButton = registerBlock("eden_button", () -> new BlockModButton(BlockSetType.OAK)),

            //Wildwood Tree
            wildwoodSapling = registerBlock("wildwood_sapling", () -> new BlockModSapling(COLOR_LIGHT_BLUE, () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_dirt")), new WildwoodTreeGrower())),
            wildwoodLeaves = registerBlock("wildwood_leaves", () -> new BlockModLeaves(COLOR_LIGHT_BLUE, SoundType.AZALEA_LEAVES)),
            wildwoodLog = registerBlock("wildwood_log", () -> new BlockModLog(LAPIS, SoundType.WOOD)),
            wildwoodWood = registerBlock("wildwood_wood", () -> new BlockModLog(LAPIS, SoundType.WOOD)),
            strippedWildwoodLog = registerBlock("stripped_wildwood_log", () -> new BlockModLog(LAPIS, SoundType.WOOD)),
            strippedWildwoodWood = registerBlock("stripped_wildwood_wood", () -> new BlockModLog(LAPIS, SoundType.WOOD)),
            wildwoodPlanks = registerBlock("wildwood_planks", () -> new BlockModPlanks(COLOR_LIGHT_BLUE, SoundType.WOOD)),
            wildwoodStairs = registerBlock("wildwood_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_planks")), 20, 5)),
            wildwoodSlab = registerBlock("wildwood_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_planks")), 20, 5)),
            wildwoodFence = registerBlock("wildwood_fence", () -> new BlockModFence(COLOR_LIGHT_BLUE, SoundType.WOOD)),
            wildwoodFenceGate = registerBlock("wildwood_fence_gate", () -> new BlockModGate(COLOR_LIGHT_BLUE, WoodType.DARK_OAK)),
            wildwoodDoor = registerBlock("wildwood_door", () -> new BlockModDoor(COLOR_LIGHT_BLUE, BlockSetType.DARK_OAK)),
            wildwoodTrapdoor = registerBlock("wildwood_trapdoor", () -> new BlockModTrapdoor(COLOR_LIGHT_BLUE, BlockSetType.DARK_OAK)),
            wildwoodPressurePlate = registerBlock("wildwood_pressure_plate", () -> new BlockModPressurePlate(COLOR_LIGHT_BLUE, BlockSetType.DARK_OAK)),
            wildwoodButton = registerBlock("wildwood_button", () -> new BlockModButton(BlockSetType.DARK_OAK)),

            //Apalachia Tree
            apalachiaSapling = registerBlock("apalachia_sapling", () -> new BlockModSapling(COLOR_MAGENTA, () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_dirt")), new ApalachiaTreeGrower())),
            apalachiaLeaves = registerBlock("apalachia_leaves", () -> new BlockModLeaves(COLOR_MAGENTA, SoundType.AZALEA_LEAVES)),
            apalachiaLog = registerBlock("apalachia_log", () -> new BlockModLog(COLOR_MAGENTA, SoundType.WOOD)),
            apalachiaWood = registerBlock("apalachia_wood", () -> new BlockModLog(COLOR_MAGENTA, SoundType.WOOD)),
            strippedApalachiaLog = registerBlock("stripped_apalachia_log", () -> new BlockModLog(COLOR_MAGENTA, SoundType.WOOD)),
            strippedApalachiaWood = registerBlock("stripped_apalachia_wood", () -> new BlockModLog(COLOR_MAGENTA, SoundType.WOOD)),
            apalachiaPlanks = registerBlock("apalachia_planks", () -> new BlockModPlanks(COLOR_MAGENTA, SoundType.WOOD)),
            apalachiaStairs = registerBlock("apalachia_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_planks")), 20, 5)),
            apalachiaSlab = registerBlock("apalachia_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_planks")), 20, 5)),
            apalachiaFence = registerBlock("apalachia_fence", () -> new BlockModFence(COLOR_MAGENTA, SoundType.WOOD)),
            apalachiaFenceGate = registerBlock("apalachia_fence_gate", () -> new BlockModGate(COLOR_MAGENTA, WoodType.ACACIA)),
            apalachiaDoor = registerBlock("apalachia_door", () -> new BlockModDoor(COLOR_MAGENTA, BlockSetType.ACACIA)),
            apalachiaTrapdoor = registerBlock("apalachia_trapdoor", () -> new BlockModTrapdoor(COLOR_MAGENTA, BlockSetType.ACACIA)),
            apalachiaPressurePlate = registerBlock("apalachia_pressure_plate", () -> new BlockModPressurePlate(COLOR_MAGENTA, BlockSetType.ACACIA)),
            apalachiaButton = registerBlock("apalachia_button", () -> new BlockModButton(BlockSetType.ACACIA)),

            //Skythern Tree
            skythernSapling = registerBlock("skythern_sapling", () -> new BlockModSapling(WOOL, () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_dirt")), new SkythernTreeGrower())),
            skythernLeaves = registerBlock("skythern_leaves", () -> new BlockModLeaves(QUARTZ, SoundType.AZALEA_LEAVES)),
            skythernLog = registerBlock("skythern_log", () -> new BlockModLog(QUARTZ, SoundType.NETHER_WOOD)),
            skythernWood = registerBlock("skythern_wood", () -> new BlockModLog(COLOR_LIGHT_GRAY, SoundType.NETHER_WOOD)),
            strippedSkythernLog = registerBlock("stripped_skythern_log", () -> new BlockModLog(QUARTZ, SoundType.NETHER_WOOD)),
            strippedSkythernWood = registerBlock("stripped_skythern_wood", () -> new BlockModLog(QUARTZ, SoundType.NETHER_WOOD)),
            skythernPlanks = registerBlock("skythern_planks", () -> new BlockModPlanks(WOOL, SoundType.NETHER_WOOD)),
            skythernStairs = registerBlock("skythern_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_planks")), 20, 5)),
            skythernSlab = registerBlock("skythern_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_planks")), 20, 5)),
            skythernFence = registerBlock("skythern_fence", () -> new BlockModFence(WOOL, SoundType.NETHER_WOOD)),
            skythernFenceGate = registerBlock("skythern_fence_gate", () -> new BlockModGate(WOOL, WoodType.CRIMSON)),
            skythernDoor = registerBlock("skythern_door", () -> new BlockModDoor(WOOL, BlockSetType.CRIMSON)),
            skythernTrapdoor = registerBlock("skythern_trapdoor", () -> new BlockModTrapdoor(WOOL, BlockSetType.CRIMSON)),
            skythernPressurePlate = registerBlock("skythern_pressure_plate", () -> new BlockModPressurePlate(WOOL, BlockSetType.CRIMSON)),
            skythernButton = registerBlock("skythern_button", () -> new BlockModButton(BlockSetType.CRIMSON)),

            //Mortum Tree
            mortumSapling = registerBlock("mortum_sapling", () -> new BlockModSapling(COLOR_GRAY, () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_grass")), () -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_dirt")), new MortumTreeGrower())),
            mortumLeaves = registerBlock("mortum_leaves", () -> new BlockModLeaves(COLOR_BLACK, SoundType.AZALEA_LEAVES)),
            mortumLog = registerBlock("mortum_log", () -> new BlockModLog(TERRACOTTA_PINK, SoundType.WOOD)),
            mortumWood = registerBlock("mortum_wood", () -> new BlockModLog(TERRACOTTA_PINK, SoundType.WOOD)),
            strippedMortumLog = registerBlock("stripped_mortum_log", () -> new BlockModLog(TERRACOTTA_PINK, SoundType.WOOD)),
            strippedMortumWood = registerBlock("stripped_mortum_wood", () -> new BlockModLog(TERRACOTTA_PINK, SoundType.WOOD)),
            mortumPlanks = registerBlock("mortum_planks", () -> new BlockModPlanks(COLOR_GRAY, SoundType.WOOD)),
            mortumStairs = registerBlock("mortum_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_planks")), 20, 5)),
            mortumSlab = registerBlock("mortum_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_planks")), 20, 5)),
            mortumFence = registerBlock("mortum_fence", () -> new BlockModFence(COLOR_GRAY, SoundType.WOOD)),
            mortumFenceGate = registerBlock("mortum_fence_gate", () -> new BlockModGate(COLOR_GRAY, WoodType.MANGROVE)),
            mortumDoor = registerBlock("mortum_door", () -> new BlockModDoor(COLOR_GRAY, BlockSetType.MANGROVE)),
            mortumTrapdoor = registerBlock("mortum_trapdoor", () -> new BlockModTrapdoor(COLOR_GRAY, BlockSetType.MANGROVE)),
            mortumPressurePlate = registerBlock("mortum_pressure_plate", () -> new BlockModPressurePlate(COLOR_GRAY, BlockSetType.MANGROVE)),
            mortumButton = registerBlock("mortum_button", () -> new BlockModButton(BlockSetType.MANGROVE)),

            //Firewood
            firewoodLeaves = registerBlock("firewood_leaves", () -> new BlockModLeaves(CRIMSON_NYLIUM, SoundType.GRASS)),
            firewoodLog = registerBlock("firewood_log", () -> new BlockModLog(FIRE, SoundType.WOOD)),
            firewoodWood = registerBlock("firewood_wood", () -> new BlockModLog(FIRE, SoundType.WOOD)),
            strippedFirewoodLog = registerBlock("stripped_firewood_log", () -> new BlockModLog(FIRE, SoundType.WOOD)),
            strippedFirewoodWood = registerBlock("stripped_firewood_wood", () -> new BlockModLog(FIRE, SoundType.WOOD)),

            //Dreamwood
            dreamwoodLeaves = registerBlock("dreamwood_leaves", () -> new BlockModLeaves(COLOR_CYAN, SoundType.GRASS)),
            dreamwoodLog = registerBlock("dreamwood_log", () -> new BlockModLog(COLOR_LIGHT_BLUE, SoundType.WOOD)),
            dreamwoodWood = registerBlock("dreamwood_wood", () -> new BlockModLog(COLOR_LIGHT_BLUE, SoundType.WOOD)),
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
            mintwoodWood = registerBlock("mintwood_wood", () -> new BlockModLog(DIAMOND, SoundType.WOOD)),
            strippedMintwoodLog = registerBlock("stripped_mintwood_log", () -> new BlockModLog(DIAMOND, SoundType.WOOD)),
            strippedMintwoodWood = registerBlock("stripped_mintwood_wood", () -> new BlockModLog(DIAMOND, SoundType.WOOD)),

            //Wool
            checker = registerBlock("checker", () -> new BlockMod(WOOL,0.8F, 0.8F, 60, 30, SoundType.WOOL, NoteBlockInstrument.GUITAR)),
            fancyWool = registerBlock("fancy_wool", () -> new BlockMod(CRIMSON_HYPHAE,0.8F, 0.8F, 60, 30, SoundType.WOOL, NoteBlockInstrument.GUITAR)),
            rainbowWool = registerBlock("rainbow_wool", () -> new BlockMod(COLOR_PURPLE,0.8F, 0.8F, 60, 30, SoundType.WOOL, NoteBlockInstrument.GUITAR)),
            workshopCarpet = registerBlock("workshop_carpet", () -> new BlockMod(TERRACOTTA_RED,0.8F, 0.8F, 60, 30, SoundType.WOOL, NoteBlockInstrument.GUITAR)),

            //Bookshelves
            workshopBookcase = registerBlock("workshop_bookcase", () -> new BlockModBookshelf(COLOR_GRAY)),
            dungeonBookshelf = registerBlock("dungeon_bookshelf", () -> new BlockModBookshelf(COLOR_BLUE)),

            //Asphalt
            asphalt = registerBlock("asphalt", () -> new BlockMod(COLOR_BLACK, 1.5F, 6F)),
            asphaltStairs = registerBlock("asphalt_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "asphalt")), 0, 0)),
            asphaltSlab = registerBlock("asphalt_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "asphalt")), 0, 0)),

            //Darkstone & Vanes
            darkstone = registerBlock("darkstone", () -> new BlockMod(TERRACOTTA_GREEN, 3)),
            redVane = registerBlock("red_vane", () -> new BlockMod(NETHER, 0)),
            yellowVane = registerBlock("yellow_vane", () -> new BlockMod(TERRACOTTA_LIGHT_GREEN, 0)),
            cyanVane = registerBlock("cyan_vane", () -> new BlockMod(COLOR_CYAN, 0)),
            blueVane = registerBlock("blue_vane", () -> new BlockMod(COLOR_BLUE, 0)),
            purpleVane = registerBlock("purple_vane", () -> new BlockMod(TERRACOTTA_PURPLE, 0)),

            //Bricks
            milkStoneBricks = registerBlock("milk_stone_bricks", () -> new BlockMod(WOOL, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            darkstoneBricks = registerBlock("darkstone_bricks", () -> new BlockMod(COLOR_BLACK, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            torriditeBricks = registerFireResistantBlock("torridite_bricks", () -> new BlockMod(Properties.of().mapColor(NETHER).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM)), Rarity.COMMON),
            redstoneBricks = registerBlock("redstone_bricks", () -> new BlockMod(CRIMSON_NYLIUM, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            lavaBricks = registerBlock("lava_bricks", () -> new BlockMod(FIRE, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            realmiteBricks = registerBlock("realmite_bricks", () -> new BlockMod(TERRACOTTA_ORANGE, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            goldBricks = registerBlock("gold_bricks", () -> new BlockMod(GOLD, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            arlemiteBricks = registerBlock("arlemite_bricks", () -> new BlockMod(TERRACOTTA_GREEN, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            greenBricks = registerBlock("green_bricks", () -> new BlockMod(PLANT, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            aquatonicBricks = registerBlock("aquatonic_bricks", () -> new BlockMod(WARPED_NYLIUM, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            diamondBricks = registerBlock("diamond_bricks", () -> new BlockMod(DIAMOND, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            ironBricks = registerBlock("iron_bricks", () -> new BlockMod(COLOR_CYAN, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            lapisLazuliBricks = registerBlock("lapis_lazuli_bricks", () -> new BlockMod(COLOR_BLUE, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            purpleBricks = registerBlock("purple_bricks", () -> new BlockMod(TERRACOTTA_BLUE, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            pinkBricks = registerBlock("pink_bricks", () -> new BlockMod(COLOR_PURPLE, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),

            //Minibricks
            minibricks = registerBlock("minibricks", () -> new BlockMod(DEEPSLATE, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            bedrockMinibricks = registerFireResistantBlock("bedrock_minibricks", () -> new BlockMod(Properties.of().mapColor(COLOR_BLACK).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM)), Rarity.COMMON),
            torriditeMinibricks = registerFireResistantBlock("torridite_minibricks", () -> new BlockMod(Properties.of().mapColor(NETHER).strength(2F, 6F).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM)), Rarity.COMMON),
            realmiteMinibricks = registerBlock("realmite_minibricks", () -> new BlockMod(TERRACOTTA_BROWN, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            arlemiteMinibricks = registerBlock("arlemite_minibricks", () -> new BlockMod(PLANT, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            rupeeMinibricks = registerBlock("rupee_minibricks", () -> new BlockMod(WATER, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),
            bloodgemMinibricks = registerBlock("bloodgem_minibricks", () -> new BlockMod(CRIMSON_STEM, 2F, 6F, SoundType.NETHER_BRICKS, NoteBlockInstrument.BASEDRUM)),

            //Iceika Bricks
            frozenBricks = registerBlock("frozen_bricks", () -> new BlockMod(GLOW_LICHEN, 1.5F, 6F)),
            snowBricks = registerBlock("snow_bricks", () -> new BlockMod(SNOW, 1.5F, 6F)),
            icyBricks = registerBlock("icy_bricks", () -> new BlockMod(ICE, 1.5F, 6F)),
            coalstoneBricks = registerBlock("coalstone_bricks", () -> new BlockMod(COLOR_GRAY, 1.5F, 6F)),

            //Arcana Bricks & Other Blocks
            ancientBricks = registerBlock("ancient_bricks", () -> new BlockModUnbreakable(WARPED_NYLIUM)),
            ancientBrickStairs = registerBlock("ancient_brick_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks")), 0, 0)),
            ancientBrickSlab = registerBlock("ancient_brick_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks")), 0, 0)),
            ancientBrickWall = registerBlock("ancient_brick_wall", () -> new BlockModWall(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks")))),
            ancientStone = registerBlock("ancient_stone", () -> new BlockModUnbreakable(COLOR_GRAY)),
            ancientTile = registerBlock("ancient_tile", () -> new BlockModUnbreakable(COLOR_BLUE)),
            soulStone = registerBlock("soul_stone", () -> new BlockModUnbreakable(TERRACOTTA_BLUE)),
            arcaniumMetal = registerBlock("arcanium_metal", () -> new BlockModPillar(TERRACOTTA_BLUE, -1F, 3600000F, SoundType.METAL)),
            arcaniumPower = registerBlock("arcanium_power", () -> new BlockModUnbreakable(COLOR_GRAY)),
            lightDegradedBrick = registerBlock("light_degraded_brick", () -> new BlockModUnbreakable(COLOR_CYAN)),
            darkDegradedBrick = registerBlock("dark_degraded_brick", () -> new BlockModUnbreakable(COLOR_BLACK)),
            degradedBricks = registerBlock("degraded_bricks", () -> new BlockModUnbreakable(COLOR_BLUE)),
            degradedBrickStairs = registerBlock("degraded_brick_stairs", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks")), 0, 0)),
            degradedBrickSlab = registerBlock("degraded_brick_slab", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks")), 0, 0)),
            degradedBrickWall = registerBlock("degraded_brick_wall", () -> new BlockModWall(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks")))),
            battleBricks = registerBlock("battle_bricks", () -> new BlockModUnbreakable(FIRE)),
            gildedBricks = registerBlock("gilded_bricks", () -> new BlockModUnbreakable(COLOR_ORANGE)),
            ancientBricksBreakable = registerBlock("ancient_bricks_breakable", () -> new BlockMod(WARPED_NYLIUM, 1.5F, 6F)),
            ancientBrickStairsBreakable = registerBlock("ancient_brick_stairs_breakable", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks_breakable")), 0, 0)),
            ancientBrickSlabBreakable = registerBlock("ancient_brick_slab_breakable", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks_breakable")), 0, 0)),
            ancientBrickWallBreakable = registerBlock("ancient_brick_wall_breakable", () -> new BlockModWall(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "ancient_bricks_breakable")))),
            ancientStoneBreakable = registerBlock("ancient_stone_breakable", () -> new BlockMod(COLOR_GRAY, 1.5F, 6F)),
            ancientTileBreakable = registerBlock("ancient_tile_breakable", () -> new BlockMod(COLOR_BLUE, 2F, 6F)),
            soulStoneBreakable = registerBlock("soul_stone_breakable", () -> new BlockMod(TERRACOTTA_BLUE, 1.5F, 6F)),
            arcaniumMetalBreakable = registerBlock("arcanium_metal_breakable", () -> new BlockModPillar(TERRACOTTA_BLUE, 5F, 6F, SoundType.METAL)),
            arcaniumPowerBreakable = registerBlock("arcanium_power_breakable", () -> new BlockMod(COLOR_GRAY, 2F, 6F)),
            degradedBricksBreakable = registerBlock("degraded_bricks_breakable", () -> new BlockMod(COLOR_BLUE, 1.5F, 6F)),
            degradedBrickStairsBreakable = registerBlock("degraded_brick_stairs_breakable", () -> new BlockModStairs(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks_breakable")), 0, 0)),
            degradedBrickSlabBreakable = registerBlock("degraded_brick_slab_breakable", () -> new BlockModSlab(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks_breakable")), 0, 0)),
            degradedBrickWallBreakable = registerBlock("degraded_brick_wall_breakable", () -> new BlockModWall(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "degraded_bricks_breakable")))),
            arcaniteTubes = registerBlock("arcanite_tubes", () -> new BlockModLadder()),
            arcaniteLadder = registerBlock("arcanite_ladder", () -> new BlockModLadder()),

            //Twilight Bricks
            edenBricks = registerBlock("eden_bricks", () -> new BlockMod(COLOR_YELLOW, 1.5F, 6F)),
            wildwoodBricks = registerBlock("wildwood_bricks", () -> new BlockMod(COLOR_LIGHT_BLUE, 1.5F, 6F)),
            apalachiaBricks = registerBlock("apalachia_bricks", () -> new BlockMod(COLOR_MAGENTA, 1.5F, 6F)),
            skythernBricks = registerBlock("skythern_bricks", () -> new BlockMod(WOOL, 1.5F, 6F)),
            mortumBricks = registerBlock("mortum_bricks", () -> new BlockMod(COLOR_GRAY, 1.5F, 6F)),

            //Vethea Bricks & Extra Blocks
            hallWall = registerBlock("hall_wall", () -> new BlockModUnbreakable(CRIMSON_HYPHAE)),
            redDreamBricks = registerBlock("red_dream_bricks", () -> new BlockMod(FIRE, 1.5F, 6F)),
            lightDreamBricks = registerBlock("light_dream_bricks", () -> new BlockMod(LAPIS, 1.5F, 6F)),
            darkDreamBricks = registerBlock("dark_dream_bricks", () -> new BlockMod(COLOR_BLUE, 1.5F, 6F)),
            blueKarosBricks = registerBlock("blue_karos_bricks", () -> new BlockModUnbreakable(COLOR_BLUE)),
            blackKarosBricks = registerBlock("black_karos_bricks", () -> new BlockModUnbreakable(COLOR_GRAY)),
            metalCaging = registerBlock("metal_caging", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_GREEN).requiresCorrectToolForDrops().strength(5F).sound(SoundType.METAL).noOcclusion())),
            helioticBeam = registerBlock("heliotic_beam", () -> new BlockHelioticBeam()),
            lunaBricks = registerBlock("luna_bricks", () -> new BlockMod(COLOR_BLUE, 2F, 6F)),
            cryptWall = registerBlock("crypt_wall", () -> new BlockModUnbreakable(PODZOL)),
            chamberWall = registerBlock("chamber_wall", () -> new BlockModUnbreakable(COLOR_BROWN)),
            shiftedChamberWall = registerBlock("shifted_chamber_wall", () -> new BlockModUnbreakable(COLOR_BROWN)),
            stackedChamberWall = registerBlock("stacked_chamber_wall", () -> new BlockModUnbreakable(COLOR_BROWN)),

            //Steel
            whiteSteel = registerBlock("white_steel", () -> new BlockMod(WOOL, 5F, 6F, SoundType.METAL, NoteBlockInstrument.HARP)),
            blackSteel = registerBlock("black_steel", () -> new BlockMod(COLOR_GRAY, 5F, 6F, SoundType.METAL, NoteBlockInstrument.HARP)),
            brightRedSteel = registerBlock("bright_red_steel", () -> new BlockMod(CRIMSON_NYLIUM, 5F, 6F, SoundType.METAL, NoteBlockInstrument.HARP)),
            redSteel = registerBlock("red_steel", () -> new BlockMod(COLOR_RED, 5F, 6F, SoundType.METAL, NoteBlockInstrument.HARP)),
            orangeSteel = registerBlock("orange_steel", () -> new BlockMod(TERRACOTTA_ORANGE, 5F, 6F, SoundType.METAL, NoteBlockInstrument.HARP)),
            yellowSteel = registerBlock("yellow_steel", () -> new BlockMod(TERRACOTTA_YELLOW, 5F, 6F, SoundType.METAL, NoteBlockInstrument.HARP)),
            greenSteel = registerBlock("green_steel", () -> new BlockMod(COLOR_GREEN, 5F, 6F, SoundType.METAL, NoteBlockInstrument.HARP)),
            tealSteel = registerBlock("teal_steel", () -> new BlockMod(WARPED_WART_BLOCK, 5F, 6F, SoundType.METAL, NoteBlockInstrument.HARP)),
            blueSteel = registerBlock("blue_steel", () -> new BlockMod(COLOR_LIGHT_BLUE, 5F, 6F, SoundType.METAL, NoteBlockInstrument.HARP)),
            purpleSteel = registerBlock("purple_steel", () -> new BlockMod(TERRACOTTA_BLUE, 5F, 6F, SoundType.METAL, NoteBlockInstrument.HARP)),

            //Candy Canes
            redCandyCane = registerBlock("red_candy_cane", () -> new BlockMod(FIRE, 0.75F, 0.75F)),
            yellowCandyCane = registerBlock("yellow_candy_cane", () -> new BlockMod(COLOR_YELLOW, 0.75F, 0.75F)),
            greenCandyCane = registerBlock("green_candy_cane", () -> new BlockMod(EMERALD, 0.75F, 0.75F)),
            blueCandyCane = registerBlock("blue_candy_cane", () -> new BlockMod(COLOR_BLUE, 0.75F, 0.75F)),
            pinkCandyCane = registerBlock("pink_candy_cane", () -> new BlockMod(COLOR_MAGENTA, 0.75F, 0.75F)),

            //Lights
            redFairyLights = registerBlock("red_fairy_lights", () -> new BlockLights()),
            yellowFairyLights = registerBlock("yellow_fairy_lights", () -> new BlockLights()),
            greenFairyLights = registerBlock("green_fairy_lights", () -> new BlockLights()),
            blueFairyLights = registerBlock("blue_fairy_lights", () -> new BlockLights()),
            purpleFairyLights = registerBlock("purple_fairy_lights", () -> new BlockLights()),

            //Torches
            aquaTorch		 = BLOCKS.register("aqua_torch", () -> new BlockModTorch(FLAME)),
            aquaWallTorch	 = BLOCKS.register("aqua_wall_torch", () -> new BlockModWallTorch(FLAME)),
            skeletonWallTorch= BLOCKS.register("skeleton_wall_torch", () -> new BlockModWallTorch(FLAME)),
            skeletonTorch	 = BLOCKS.register("skeleton_torch", () -> new BlockModTorch(FLAME)),
            arcaniumTorch = BLOCKS.register("arcanium_torch", () -> new BlockModTorch(FLAME)),
            arcaniumWallTorch = BLOCKS.register("arcanium_wall_torch", () -> new BlockModWallTorch(FLAME)),
            edenTorch = BLOCKS.register("eden_torch", () -> new BlockModTorch(FLAME)),
            edenWallTorch = BLOCKS.register("eden_wall_torch", () -> new BlockModWallTorch(FLAME)),

            //Stone Lamps
            moltenLamp = registerBlock("molten_lamp", () -> new BlockModLamp(CRIMSON_NYLIUM, SoundType.GLASS)),
            divineLamp = registerBlock("divine_lamp", () -> new BlockModLamp(COLOR_YELLOW, SoundType.GLASS)),
            jungleLamp = registerBlock("jungle_lamp", () -> new BlockModLamp(EMERALD, SoundType.GLASS)),
            terranLamp = registerBlock("terran_lamp", () -> new BlockModLamp(TERRACOTTA_GREEN, SoundType.GLASS)),
            iceLamp = registerBlock("ice_lamp", () -> new BlockModLamp(DIAMOND, SoundType.GLASS)),
            soulfireLamp = registerBlock("soulfire_lamp", () -> new BlockModLamp(WATER, SoundType.GLASS)),
            enderStoneLamp = registerBlock("ender_stone_lamp", () -> new BlockModLamp(COLOR_PURPLE, SoundType.GLASS)),

            //Other Lamps
            milkyLamp = registerBlock("milky_lamp", () -> new BlockModLamp(QUARTZ)),
            edenLamp = registerBlock("eden_lamp", () -> new BlockModLamp(COLOR_YELLOW)),
            torriditeLamp = registerBlock("torridite_lamp", () -> new BlockModLamp(CRIMSON_NYLIUM)),
            lavaLamp = registerBlock("lava_lamp", () -> new BlockModLamp(TERRACOTTA_ORANGE)),
            drakenLamp = registerBlock("draken_lamp", () -> new BlockModLamp(COLOR_ORANGE)),
            realmiteLamp = registerBlock("realmite_lamp", () -> new BlockModLamp(TERRACOTTA_YELLOW)),
            blazeLamp = registerBlock("blaze_lamp", () -> new BlockModLamp(COLOR_YELLOW)),
            goldLamp = registerBlock("gold_lamp", () -> new BlockModLamp(GOLD)),
            arlemiteLamp = registerBlock("arlemite_lamp", () -> new BlockModLamp(EMERALD)),
            krakenLamp = registerBlock("kraken_lamp", () -> new BlockModLamp(COLOR_LIGHT_GREEN)),
            diamondLamp = registerBlock("diamond_lamp", () -> new BlockModLamp(DIAMOND)),
            aquaLamp = registerBlock("aqua_lamp", () -> new BlockModLamp(COLOR_LIGHT_BLUE)),
            lapisLazuliLamp = registerBlock("lapis_lazuli_lamp", () -> new BlockModLamp(WATER)),
            rupeeLamp = registerBlock("rupee_lamp", () -> new BlockModLamp(COLOR_BLUE)),
            enderLamp = registerBlock("ender_lamp", () -> new BlockModLamp(COLOR_PURPLE)),
            redstoneOreLamp = registerBlock("redstone_ore_lamp", () -> new BlockModLamp(CRIMSON_STEM)),

            //Extra Lamps
            slimeLight = registerBlock("slime_light", () -> new BlockModLight()),
            workshopLamp = registerBlock("workshop_lamp", () -> new BlockModLamp(COLOR_LIGHT_BLUE, SoundType.GLASS)),
            dungeonLamp = registerBlock("dungeon_lamp", () -> new BlockModUnbreakable(QUARTZ, true)),
            dungeonLampBreakable = registerBlock("dungeon_lamp_breakable", () -> new BlockMod(Properties.of().mapColor(QUARTZ).strength(0.3F).sound(SoundType.GLASS).instrument(NoteBlockInstrument.HAT).lightLevel((p_235464_0_) -> 15))),
            cellLamp = registerBlock("cell_lamp", () -> new BlockModLamp(COLOR_LIGHT_GREEN, SoundType.GLASS)),
            villageLamp = registerBlock("village_lamp", () -> new BlockModLamp(TERRACOTTA_RED, SoundType.GLASS)),
            dreamLamp = registerBlock("dream_lamp", () -> new BlockDreamLamp()),

            //Bridges
            darkBridge = registerBlock("dark_bridge", () -> new BlockModBridge()),
            starBridge = registerBlock("star_bridge", () -> new BlockModBridge()),

            //Powered Fences
            redFence = registerBlock("red_fence", () -> new BlockModLightFence(COLOR_RED)),
            blueFence = registerBlock("blue_fence", () -> new BlockModLightFence(COLOR_BLUE)),
            greenFence = registerBlock("green_fence", () -> new BlockModLightFence(COLOR_GREEN)),

            //Glass
            frostedGlass = registerBlock("frosted_glass", () -> new BlockModGlass()),
            stainedGlass = registerBlock("stained_glass", () -> new BlockModGlass()),
            stainedGlass2 = registerBlock("stained_glass2", () -> new BlockModGlass()),
            stainedGlass3 = registerBlock("stained_glass3", () -> new BlockModGlass()),
            stainedGlass4 = registerBlock("stained_glass4", () -> new BlockModGlass()),
            stainedGlass5 = registerBlock("stained_glass5", () -> new BlockModGlass()),
            stainedGlass6 = registerBlock("stained_glass6", () -> new BlockModGlass()),
            stainedGlass7 = registerBlock("stained_glass7", () -> new BlockModGlass()),
            stainedGlass8 = registerBlock("stained_glass8", () -> new BlockModGlass()),
            smoothGlass = registerBlock("smooth_glass", () -> new BlockModGlass()),

            //Plants & Fungi
            brittleGrass = registerBlock("brittle_grass", () -> new BlockBrittleGrass()),
            winterberryBush = registerBlock("winterberry_bush", () -> new BlockWinterberryBush()),
            winterberryVinesBody = BLOCKS.register("winterberry_vines_body", () -> new BlockWinterberryVinesBody(Properties.copy(Blocks.WEEPING_VINES_PLANT).sound(SoundType.CAVE_VINES))),
            winterberryVinesHead = registerBlock("winterberry_vines_head", () -> new BlockWinterberryVinesHead(Properties.copy(Blocks.WEEPING_VINES).sound(SoundType.CAVE_VINES))),
            arcanaBrush = registerBlock("arcana_brush", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arcanite_sand")), TERRACOTTA_LIGHT_BLUE)),
            arcanaBush = registerBlock("arcana_bush", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arcanite_sand")), COLOR_BLUE)), gemOfTheDunes = registerBlock("gem_of_the_dunes", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "arcanite_sand")), COLOR_LIGHT_BLUE), Rarity.EPIC),
            arcaniteVinesBody = BLOCKS.register("arcanite_vines_body", () -> new BlockArcaniteVinesBody(Properties.copy(Blocks.WEEPING_VINES_PLANT).sound(SoundType.CAVE_VINES))),
            arcaniteVinesHead = registerBlock("arcanite_vines_head", () -> new BlockArcaniteVinesHead(Properties.copy(Blocks.WEEPING_VINES).sound(SoundType.CAVE_VINES))),
            weedwoodVine = registerBlock("weedwood_vine", () -> new BlockModVine(COLOR_BLUE)),
            blossomedWeedwoodVine = registerBlock("blossomed_weedwood_vine", () -> new BlockModVine(COLOR_BLUE)),
            edenBrush = registerBlock("eden_brush", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_grass")), COLOR_YELLOW)),
            sunBlossom = registerBlock("sun_blossom", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_grass")), 0.9, 0.6, COLOR_YELLOW)),
            sunbloom = registerBlock("sunbloom", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_grass")), TERRACOTTA_YELLOW)),
            moonlightFern = registerBlock("moonlight_fern", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_grass")), COLOR_LIGHT_BLUE)),
            moonBud = registerBlock("moon_bud", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_grass")), 0.8, 0.7, COLOR_LIGHT_BLUE)),
            wildwoodTallgrass = registerBlock("wildwood_tallgrass", () -> new BlockModDoublePlant(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_grass")), COLOR_LIGHT_BLUE)),
            truffle = registerBlock("truffle", () -> new BlockMod(Properties.of().mapColor(TERRACOTTA_BROWN).strength(1.0F).pushReaction(PushReaction.DESTROY).sound(SoundType.WOOD))),
            wildwoodVine = registerBlock("wildwood_vine", () -> new BlockModVine(COLOR_LIGHT_BLUE)),
            apalachiaTallgrass = registerBlock("apalachia_tallgrass", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_grass")), COLOR_PURPLE)),
            duskBloom = registerBlock("dusk_bloom", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_grass")), 0.5, 0.5, COLOR_PURPLE)),
            duskFlower = registerBlock("dusk_flower", () -> new BlockModDoublePlant(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_grass")), BlockBehaviour.Properties.of().pushReaction(PushReaction.DESTROY).mapColor(COLOR_PURPLE).noOcclusion().instabreak().sound(SoundType.ROOTS).offsetType(BlockBehaviour.OffsetType.XZ).noCollission().randomTicks())),
            skythernBrush = registerBlock("skythern_brush", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_grass")), WOOL)),
            dustLily = registerBlock("dust_lily", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_grass")), WOOL)),
            dustBrambles = registerBlock("dust_brambles", () -> new BlockBrambles(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_grass")), WOOL)),
            mortumBrush = registerBlock("mortum_brush", () -> new BlockTwilightGrass(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_grass")), COLOR_GRAY)),
            eyePlant = registerBlock("eye_plant", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_grass")), 0.5, 0.5, COLOR_GRAY)),
            demonBrambles = registerBlock("demon_brambles", () -> new BlockBrambles(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_grass")), COLOR_GRAY)),
            shineGrass = registerBlock("shine_grass", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            cracklespike = registerBlock("cracklespike", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            fernite = registerBlock("fernite", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            dreamglow = registerBlock("dreamglow", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            bulbatobe = registerBlock("bulbatobe", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            shimmer = registerBlock("shimmer", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            yellowDulah = registerBlock("yellow_dulah", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            greenDulah = registerBlock("green_dulah", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            greenGemtop = registerBlock("green_gemtop", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),
            purpleGemtop = registerBlock("purple_gemtop", () -> new BlockTwilightFlower(() -> ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "dream_grass")), COLOR_CYAN)),

            //Crops
            tomatoPlant = registerBlock("tomato_plant", () -> new BlockTomatoPlant()),
            whiteMushroomPlant = registerBlock("white_mushroom_plant", () -> new BlockWhiteMushroomPlant()),
            aquamarinePlant = registerBlock("aquamarine_plant", () -> new BlockModCrop(3, new ResourceLocation(MODID, "aquamarine_seeds"))),
            eucalyptusPlant = registerBlock("eucalyptus_plant", () -> new BlockModCrop(3, new ResourceLocation(MODID, "eucalyptus_root_seeds"))),
            firestockPlant = registerBlock("firestock_plant", () -> new BlockFirestock()),
            hitchakPlant = registerBlock("hitchak_plant", () -> new BlockModCrop(3, new ResourceLocation(MODID, "hitchak_seeds"))),
            lamonaPlant = registerBlock("lamona_plant", () -> new BlockModCrop(3, new ResourceLocation(MODID, "lamona_seeds"))),
            marsinePlant = registerBlock("marsine_plant", () -> new BlockModCrop(2, new ResourceLocation(MODID, "marsine_seeds"))),
            pinflyPlant = registerBlock("pinfly_plant", () -> new BlockPinfly()),
            veiloPlant = registerBlock("veilo_plant", () -> new BlockModCrop(3, new ResourceLocation(MODID, "veilo_seeds"))),
            moonbulbPlant = registerBlock("moonbulb_plant", () -> new BlockMoonbulb()),
            pinkGlowbonePlant = registerBlock("pink_glowbone_plant", () -> new BlockPinkGlowbone()),
            purpleGlowbonePlant = registerBlock("purple_glowbone_plant", () -> new BlockPurpleGlowbone()),
            skyPlant = registerBlock("sky_plant", () -> new BlockSkyPlant()),

            //Mob Pumpkins
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
            zombiePumpkin		= registerBlock("zombie_pumpkin", () -> new BlockMobPumpkin(() -> ZOMBIE_AMBIENT, TERRACOTTA_GREEN)),

            //Statues
            ancientEntityStatue = registerWithRender("ancient_entity_statue", () -> new BlockStatue(() -> IRON_GOLEM_DEATH), Rarity.RARE),
            theWatcherStatue = registerWithRender("the_watcher_statue", () -> new BlockStatue(() -> ROAR.get()), Rarity.RARE),
            kingOfScorchersStatue = registerWithRender("king_of_scorchers_statue", () -> new BlockStatue(() -> KING_OF_SCORCHERS.get()), Rarity.RARE),
            kitraStatue = registerWithRender("kitra_statue", () -> new BlockStatue(() -> WHALE.get()), Rarity.RARE),
            ayeracoStatue = registerWithRender("ayeraco_statue", () -> new BlockStatue(() -> AYERACO.get()), Rarity.RARE),
            dramixStatue = registerWithRender("dramix_statue", () -> new BlockStatue(() -> DRAMIX.get()), Rarity.RARE),
            parasectaStatue = registerWithRender("parasecta_statue", () -> new BlockStatue(() -> PARASECTA.get()), Rarity.RARE),
            sunstormStatue = registerWithRender("sunstorm_statue", () -> new BlockStatue(() -> SPARKLER.get()), Rarity.RARE),
            termasectStatue = registerWithRender("termasect_statue", () -> new BlockStatue(() -> WOOD_STEP), Rarity.RARE),
            eternalArcherStatue = registerWithRender("eternal_archer_statue", () -> new BlockStatue(() -> ARCHER.get()), Rarity.RARE),
            experiencedCoriStatue = registerWithRender("experienced_cori_statue", () -> new BlockStatue(() -> CORI.get()), Rarity.RARE),
            vamacheronStatue = registerWithRender("vamacheron_statue", () -> new BlockStatue(null), Rarity.RARE),
            karotStatue = registerWithRender("karot_statue", () -> new BlockStatue(null), Rarity.RARE),
            twilightDemonStatue = registerWithRender("twilight_demon_statue", () -> new BlockStatue(() -> INSECT.get()), Rarity.RARE),
            densosStatue = registerWithRender("densos_statue", () -> new BlockStatue(() -> DENSOS.get()), Rarity.RARE),
            reyvorStatue = registerWithRender("reyvor_statue", () -> new BlockStatue(() -> REYVOR.get()), Rarity.RARE),
            soulFiendStatue = registerWithRender("soul_fiend_statue", () -> new BlockStatue(null), Rarity.RARE),

            //Encaged Arcana Creatures
            encagedCaptainMerik = registerBlock("encaged_captain_merik", () -> new BlockModMobCage(new ResourceLocation(MODID, "captain_merik"), new ResourceLocation(MODID, "firestock"))),
            encagedDatticon = registerBlock("encaged_datticon", () -> new BlockModMobCage(new ResourceLocation(MODID, "datticon"), new ResourceLocation(MODID, "aquamarine"))),
            encagedKazari = registerBlock("encaged_kazari", () -> new BlockModMobCage(new ResourceLocation(MODID, "kazari"), new ResourceLocation(MODID, "lamona"))),
            encagedLeorna = registerBlock("encaged_leorna", () -> new BlockModMobCage(new ResourceLocation(MODID, "leorna"), new ResourceLocation(MODID, "hitchak"))),
            encagedLordVatticus = registerBlock("encaged_lord_vatticus", () -> new BlockModMobCage(new ResourceLocation(MODID, "lord_vatticus"), new ResourceLocation(MODID, "marsine"))),
            encagedWarGeneral = registerBlock("encaged_war_general", () -> new BlockModMobCage(new ResourceLocation(MODID, "war_general"), new ResourceLocation(MODID, "pinfly"))),
            encagedZelus = registerBlock("encaged_zelus", () -> new BlockModMobCage(new ResourceLocation(MODID, "zelus"), new ResourceLocation(MODID, "veilo"))),

            //Boss Spawners
            sunstormSpawner			= registerBlock("sunstorm_spawner",			() -> new BlockModMobCage(new ResourceLocation(MODID, "sunstorm"), new ResourceLocation(MODID, "eden_chunk"), COLOR_YELLOW)),
            termasectSpawner		= registerBlock("termasect_spawner",		() -> new BlockModMobCage(new ResourceLocation(MODID, "termasect"), new ResourceLocation(MODID, "wildwood_chunk"), COLOR_LIGHT_BLUE, new BlockPos(0, 11, 0))),
            eternalArcherSpawner	= registerBlock("eternal_archer_spawner",	() -> new BlockModMobCage(new ResourceLocation(MODID, "eternal_archer"), new ResourceLocation(MODID, "apalachia_chunk"), COLOR_MAGENTA)),
            experiencedCoriSpawner  = registerBlock("experienced_cori_spawner", () -> new BlockModMobCage(new ResourceLocation(MODID, "experienced_cori"), new ResourceLocation(MODID, "skythern_chunk"), COLOR_LIGHT_GRAY, new BlockPos(0, 11, 0))),

            //Boss Altars
            dramixAltar = registerWithRender("dramix_altar", () -> new BlockModAltar(CRIMSON_HYPHAE), Rarity.COMMON),
            parasectaAltar = registerWithRender("parasecta_altar", () -> new BlockModAltar(TERRACOTTA_BROWN), Rarity.COMMON),
            karosAltar = registerBlock("karos_altar", () -> new BlockKarosAltar(WARPED_WART_BLOCK)),
            lunicAltar = registerBlock("lunic_altar", () -> new BlockLunicAltar(COLOR_BLUE)),
            quadroticAltar = registerBlock("quadrotic_altar", () -> new BlockQuadroticAltar(COLOR_BLUE)),
            raglokAltar = registerBlock("raglok_altar", () -> new BlockRaglokAltar(COLOR_BROWN)),
            wreckAltar = registerBlock("wreck_altar", () -> new BlockWreckAltar(COLOR_RED)),

            //Hive Egg
            hiveEgg = registerBlock("hive_egg", () -> new BlockHiveEgg()),

            //Ayeraco Technical Blocks
            ayeracoBeamRed = BLOCKS.register("ayeraco_beam_red", () -> new BlockAyeracoBeam(BossBarColor.RED)),
            ayeracoBeamYellow = BLOCKS.register("ayeraco_beam_yellow", () -> new BlockAyeracoBeam(BossBarColor.YELLOW)),
            ayeracoBeamGreen = BLOCKS.register("ayeraco_beam_green", () -> new BlockAyeracoBeam(BossBarColor.GREEN)),
            ayeracoBeamBlue = BLOCKS.register("ayeraco_beam_blue", () -> new BlockAyeracoBeam(BossBarColor.BLUE)),
            ayeracoBeamPurple = BLOCKS.register("ayeraco_beam_purple", () -> new BlockAyeracoBeam(BossBarColor.PURPLE)),
            ayeracoBeamPink = BLOCKS.register("ayeraco_beam_pink", () -> new BlockAyeracoBeam(BossBarColor.PINK)),
            ayeracoSpawn = BLOCKS.register("ayeraco_spawn", () -> new BlockAyeracoSpawn()),

            //Doors
            steelDoor = registerBlock("steel_door", () -> new BlockModDoor(METAL)),
            ancientBrickDoor = registerBlock("ancient_brick_door", () -> new BlockArcanaDoor(WARPED_NYLIUM, new ResourceLocation(MODID, "ancient_key"))),
            degradedBrickDoor = registerBlock("degraded_brick_door", () -> new BlockArcanaDoor(COLOR_BLUE, new ResourceLocation(MODID, "degraded_key"))),
            soulSludgeDoor = registerBlock("soul_sludge_door", () -> new BlockArcanaDoor(COLOR_GRAY, new ResourceLocation(MODID, "sludge_key"))),
            soulStoneDoor = registerBlock("soul_stone_door", () -> new BlockArcanaDoor(TERRACOTTA_BLUE, new ResourceLocation(MODID, "soul_key"))),
            barredDoor = registerBlock("barred_door", () -> new BlockModDoor(PLANT)),

            //Crafting & Stuff
            altarOfCorruption = registerBlock("altar_of_corruption", () -> new BlockAltarOfCorruption()),
            arcaniumExtractor = registerWithRender("arcanium_extractor", () -> new BlockArcaniumExtractor(), Rarity.RARE),
            infusionTable = registerBlock("infusion_table", () -> new BlockInfusionTable()),

            //Furnaces
            coalstoneFurnace = registerBlock("coalstone_furnace", () -> new BlockModInfiniFurnace(() -> BlockEntityRegistry.COALSTONE_FURNACE.get(), COLOR_GRAY)),
            greenlightFurnace = registerBlock("greenlight_furnace", () -> new BlockModFurnace(() -> BlockEntityRegistry.GREENLIGHT_FURNACE.get(), TERRACOTTA_LIGHT_GREEN), Rarity.COMMON),
            moonlightFurnace = registerBlock("moonlight_furnace", () -> new BlockModFurnace(() -> BlockEntityRegistry.MOONLIGHT_FURNACE.get(), COLOR_BLUE), Rarity.COMMON),
            moltenFurnace = registerBlock("molten_furnace", () -> new BlockModInfiniFurnace(() -> BlockEntityRegistry.MOLTEN_FURNACE.get(), TERRACOTTA_LIGHT_GRAY), Rarity.COMMON),
            oceanfireFurnace = registerBlock("oceanfire_furnace", () -> new BlockModInfiniFurnace(() -> BlockEntityRegistry.OCEANFIRE_FURNACE.get(), COLOR_LIGHT_BLUE), Rarity.COMMON),
            whitefireFurnace = registerBlock("whitefire_furnace", () -> new BlockModInfiniFurnace(() -> BlockEntityRegistry.WHITEFIRE_FURNACE.get(), SNOW), Rarity.COMMON),
            demonFurnace = registerWithRender("demon_furnace", () -> new BlockDemonFurnace(), Rarity.COMMON),

            //Chests
            boneChest = registerWithRender("bone_chest", () -> new BlockBoneChest(), Rarity.COMMON),
            frostedChest = registerWithRender("frosted_chest", () -> new BlockFrostedChest(), Rarity.COMMON),
            presentBox = registerWithRender("present_box", () -> new BlockPresentBox(), Rarity.COMMON),
            edenChest = registerWithRender("eden_chest", () -> new BlockEdenChest(), Rarity.COMMON),

            //Nightmare Bed
            nightmareBed = BLOCKS.register("nightmare_bed_block", () -> new BlockNightmareBed()),

            //Other Utility Blocks
            frostedAllure = registerBlock("frosted_allure", () -> new BlockFrostedAllure()),
            acceleron = registerBlock("acceleron", () -> new BlockAcceleron(), Rarity.UNCOMMON),
            elevantium = registerBlock("elevantium", () -> new BlockElevantium(), Rarity.UNCOMMON),

            //Traps
            spikeBlock = registerBlock("spike_block", () -> new BlockSpike(false, COLOR_GRAY)),
            hotSpikeBlock = registerBlock("hot_spike_block", () -> new BlockSpike(true, COLOR_RED)),
            heatTrap = registerBlock("heat_trap", () -> new BlockHeatTrap()),
            karosHeatTileGreen = registerBlock("karos_heat_tile_green", () -> new BlockKarosHeatTile(EMERALD)),
            karosHeatTileRed = registerBlock("karos_heat_tile_red", () -> new BlockKarosHeatTile(FIRE)),
            karosDispenser = registerBlock("karos_dispenser", () -> new BlockKarosDispenser()),

            //Acid
            acidBlock = registerBlock("acid_block", () -> new BlockAcid(true)),
            bacterialAcid = registerBlock("bacterial_acid", () -> new BlockAcid(false)),
            lunicAcid = registerBlock("lunic_acid", () -> new BlockAcid(true)),

            //Fire
            iceikaFire = registerBlock("iceika_fire", () -> new BlockModFire()),
            blueFire = registerBlock("blue_fire", () -> new BlockModFire()),

            //Portals
            arcanaPortal = registerBlock("arcana_portal", () -> new BlockArcanaPortal()),
            iceikaPortal = registerBlock("iceika_portal", () -> new BlockModPortal(Blocks.SNOW_BLOCK)),
            edenPortal = registerBlock("eden_portal", () -> new BlockModPortal(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "divine_rock")))),
            wildwoodPortal = registerBlock("wildwood_portal", () -> new BlockModPortal(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "eden_block")))),
            apalachiaPortal = registerBlock("apalachia_portal", () -> new BlockModPortal(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "wildwood_block")))),
            skythernPortal = registerBlock("skythern_portal", () -> new BlockModPortal(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "apalachia_block")))),
            mortumPortal = registerBlock("mortum_portal", () -> new BlockModPortal(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "skythern_block")))),
            vetheaPortal = registerBlock("vethea_portal", () -> new BlockModPortal(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(MODID, "mortum_block")))),

            //Air
            dungeonAir = registerTablessBlock("dungeon_air", () -> new BlockModDungeonAir());

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
            shiverspineSaplingPot = registerFlowerPot("shiverspine_sapling_pot", shiverspineSapling),
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