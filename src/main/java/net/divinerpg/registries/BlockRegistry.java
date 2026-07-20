package net.divinerpg.registries;

import net.divinerpg.blocks.arcana.BlockArcanaDoor;
import net.divinerpg.blocks.base.BlockModWool;
import net.divinerpg.blocks.base.DivineLeavesBlock;
import net.divinerpg.blocks.iceika.BlockCandyCane;
import net.divinerpg.blocks.iceika.BlockCozybarkLeaves;
import net.divinerpg.blocks.iceika.BlockLights;
import net.divinerpg.blocks.vethea.VetheaLog;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.ColorRGBA;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import static net.divinerpg.DivineRPG.MODID;
import static net.divinerpg.registries.DivineRegistries.BLOCKS;
import static net.divinerpg.registries.DivineRegistries.ITEMS;
import static net.divinerpg.registries.ItemRegistry.*;
import static net.divinerpg.registries.SoundRegistry.*;
import static net.minecraft.sounds.SoundEvents.IRON_GOLEM_DEATH;
import static net.minecraft.sounds.SoundEvents.WOOD_STEP;

public class BlockRegistry {

    public static final WoodType SHIVERSPINE_WOOD_TYPE = WoodType.register(new WoodType("shiverspine", BlockSetType.OAK));
    public static final WoodType AURORAOAK_WOOD_TYPE = WoodType.register(new WoodType("auroraoak", BlockSetType.OAK));
    public static final WoodType COZYBARK_WOOD_TYPE = WoodType.register(new WoodType("cozybark", BlockSetType.CHERRY));
    public static final WoodType STREAMLEAF_WOOD_TYPE = WoodType.register(new WoodType("streamleaf", BlockSetType.WARPED));
    public static final WoodType EUCALYPTUS_WOOD_TYPE = WoodType.register(new WoodType("eucalyptus", BlockSetType.OAK));
    public static final WoodType EDEN_WOOD_TYPE = WoodType.register(new WoodType("eden", BlockSetType.OAK));
    public static final WoodType WILDWOOD_WOOD_TYPE = WoodType.register(new WoodType("wildwood", BlockSetType.OAK));
    public static final WoodType APALACHIA_WOOD_TYPE = WoodType.register(new WoodType("apalachia", BlockSetType.WARPED));
    public static final WoodType SKYTHERN_WOOD_TYPE = WoodType.register(new WoodType("skythern", BlockSetType.WARPED));
    public static final WoodType MORTUM_WOOD_TYPE = WoodType.register(new WoodType("mortum", BlockSetType.DARK_OAK));

    public static final Block.Properties FROZEN_DIRT_PROPS = Block.Properties.of().mapColor(MapColor.ICE).strength(0.5F);
    public static final Block.Properties ARCANITE_DIRT_PROPS = Block.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).strength(0.5F);
    public static final Block.Properties SCORCHDIRT_PROPS = Block.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(0.5F);
    public static final Block.Properties RAY_DIRT_PROPS = Block.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.5F);
    public static final Block.Properties WILDWOOD_DIRT_PROPS = Block.Properties.of().mapColor(MapColor.LAPIS).strength(0.5F);
    public static final Block.Properties APALACHIA_DIRT_PROPS = Block.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).strength(0.5F);
    public static final Block.Properties SKYTHERN_DIRT_PROPS = Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(0.5F);
    public static final Block.Properties MORTUM_DIRT_PROPS = Block.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(0.5F);
    public static final Block.Properties DREAM_DIRT_PROPS = Block.Properties.of().mapColor(MapColor.COLOR_CYAN).strength(0.5F);
    public static final Block.Properties DREAM_STONE_PROPS = Block.Properties.of().mapColor(MapColor.COLOR_CYAN).strength(1.5F);
    public static final Block.Properties FROZEN_GRAVEL_PROPS = Block.Properties.ofFullCopy(Blocks.GRAVEL).mapColor(MapColor.STONE).instrument(NoteBlockInstrument.SNARE).strength(0.6F).sound(SoundType.GRAVEL);
    public static final Block.Properties ARCANITE_SAND_PROPS = Block.Properties.ofFullCopy(Blocks.SAND).mapColor(MapColor.COLOR_LIGHT_BLUE).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND);
    public static final Block.Properties ARCANIC_SAND_PROPS = Block.Properties.ofFullCopy(Blocks.SAND).mapColor(MapColor.COLOR_CYAN).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND);
    public static final Block.Properties ARCANIUM_RICH_SAND_PROPS = Block.Properties.ofFullCopy(Blocks.SAND).mapColor(MapColor.COLOR_BLUE).instrument(NoteBlockInstrument.SNARE).strength(0.5F).sound(SoundType.SAND);
    public static final Block.Properties COBBLED_FROZEN_PROPS = Block.Properties.ofFullCopy(Blocks.COBBLESTONE).mapColor(MapColor.GLOW_LICHEN).strength(2.0F, 6.0F);
    public static final Block.Properties FROZEN_STONE_PROPS = Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.GLOW_LICHEN).strength(1.5F, 6.0F);
    public static final Block.Properties COBALTITE_PROPS = Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.COLOR_LIGHT_BLUE).strength(1.5F, 6.0F);
    public static final Block.Properties COALSTONE_PROPS = Block.Properties.ofFullCopy(Blocks.POLISHED_BLACKSTONE).mapColor(MapColor.COLOR_GRAY).strength(1.5F, 6.0F);
    public static final Block.Properties ARCANITE_PROPS = Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.COLOR_CYAN).strength(1.5F, 6.0F);
    public static final Block.Properties TWILIGHT_PROPS = Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).strength(1.5F, 6.0F);
    public static final Block.Properties SCORCHALT_PROPS = Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_PINK).strength(1.5F, 6.0F);
    public static final Block.Properties COBBLED_SCORCHALT_PROPS = Block.Properties.ofFullCopy(Blocks.COBBLESTONE).mapColor(MapColor.TERRACOTTA_PINK).strength(2.0F, 6.0F);
    public static final Block.Properties RAY_STONE_PROPS = Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.GOLD).strength(1.5F, 6.0F);
    public static final Block.Properties DESIGN_PROPS = Block.Properties.ofFullCopy(Blocks.OAK_PLANKS);
    public static final Block.Properties DIVINE_LOG_PROPS = Block.Properties.ofFullCopy(Blocks.OAK_LOG).mapColor(MapColor.TERRACOTTA_LIGHT_GREEN).sound(SoundType.CHERRY_WOOD);
    public static final Block.Properties DIVINE_PLANKS_PROPS = Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.TERRACOTTA_LIGHT_GREEN).sound(SoundType.CHERRY_WOOD);
    public static final Block.Properties SHIVERSPINE_LOG_PROPS = Block.Properties.ofFullCopy(Blocks.OAK_LOG).mapColor(MapColor.GLOW_LICHEN);
    public static final Block.Properties SHIVERSPINE_PLANKS_PROPS = Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.GLOW_LICHEN);
    public static final Block.Properties AURORAOAK_LOG_PROPS = Block.Properties.ofFullCopy(Blocks.CHERRY_LOG).mapColor(MapColor.COLOR_BROWN);
    public static final Block.Properties AURORAOAK_PLANKS_PROPS = Block.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).mapColor(MapColor.ICE);
    public static final Block.Properties COZYBARK_LOG_PROPS = Block.Properties.ofFullCopy(Blocks.CHERRY_LOG).mapColor(MapColor.TERRACOTTA_PURPLE).sound(SoundType.CHERRY_WOOD);
    public static final Block.Properties COZYBARK_PLANKS_PROPS = Block.Properties.ofFullCopy(Blocks.CHERRY_PLANKS).mapColor(MapColor.TERRACOTTA_PURPLE).sound(SoundType.CHERRY_WOOD);
    public static final Block.Properties STREAMLEAF_LOG_PROPS = Block.Properties.ofFullCopy(Blocks.WARPED_STEM).mapColor(MapColor.TERRACOTTA_BROWN).sound(SoundType.NETHER_WOOD);
    public static final Block.Properties STREAMLEAF_PLANKS_PROPS = Block.Properties.ofFullCopy(Blocks.WARPED_PLANKS).mapColor(MapColor.ICE).sound(SoundType.NETHER_WOOD);
    public static final Block.Properties EUCALYPTUS_LOG_PROPS = Block.Properties.ofFullCopy(Blocks.OAK_LOG).mapColor(MapColor.TERRACOTTA_WHITE);
    public static final Block.Properties EUCALYPTUS_PLANKS_PROPS = Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.TERRACOTTA_WHITE);
    public static final Block.Properties EDEN_LOG_PROPS = Block.Properties.ofFullCopy(Blocks.OAK_LOG).mapColor(MapColor.SAND);
    public static final Block.Properties EDEN_PLANKS_PROPS = Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.SAND);
    public static final Block.Properties WILDWOOD_LOG_PROPS = Block.Properties.ofFullCopy(Blocks.OAK_LOG).mapColor(MapColor.COLOR_LIGHT_BLUE);
    public static final Block.Properties WILDWOOD_PLANKS_PROPS = Block.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_LIGHT_BLUE);
    public static final Block.Properties APALACHIA_LOG_PROPS = Block.Properties.ofFullCopy(Blocks.WARPED_STEM).mapColor(MapColor.COLOR_MAGENTA);
    public static final Block.Properties APALACHIA_PLANKS_PROPS = Block.Properties.ofFullCopy(Blocks.WARPED_PLANKS).mapColor(MapColor.COLOR_MAGENTA);
    public static final Block.Properties SKYTHERN_LOG_PROPS = Block.Properties.ofFullCopy(Blocks.WARPED_STEM).mapColor(MapColor.WOOL).sound(SoundType.NETHER_WOOD);
    public static final Block.Properties SKYTHERN_PLANKS_PROPS = Block.Properties.ofFullCopy(Blocks.WARPED_PLANKS).mapColor(MapColor.WOOL).sound(SoundType.NETHER_WOOD);
    public static final Block.Properties MORTUM_LOG_PROPS = Block.Properties.ofFullCopy(Blocks.DARK_OAK_LOG).mapColor(MapColor.TERRACOTTA_PINK);
    public static final Block.Properties MORTUM_PLANKS_PROPS = Block.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS).mapColor(MapColor.COLOR_GRAY);
    public static final Block.Properties ASPHALT_PROPS = Block.Properties.ofFullCopy(Blocks.BLACKSTONE).strength(2.0F, 6.0F).speedFactor(1.2F);

    public static final DeferredBlock<Block> frozenDirt = registerBlock("frozen_dirt", Block::new, FROZEN_DIRT_PROPS);
    public static final DeferredBlock<Block> arcaniteDirt = registerBlock("arcanite_dirt", Block::new, ARCANITE_DIRT_PROPS);
    public static final DeferredBlock<Block> scorchedDirt = registerBlock("scorched_dirt", Block::new, SCORCHDIRT_PROPS);
    public static final DeferredBlock<Block> rayDirt = registerBlock("ray_dirt", Block::new, RAY_DIRT_PROPS);
    public static final DeferredBlock<Block> wildwoodDirt = registerBlock("wildwood_dirt", Block::new, WILDWOOD_DIRT_PROPS);
    public static final DeferredBlock<Block> apalachiaDirt = registerBlock("apalachia_dirt", Block::new, APALACHIA_DIRT_PROPS);
    public static final DeferredBlock<Block> skythernDirt = registerBlock("skythern_dirt", Block::new, SKYTHERN_DIRT_PROPS);
    public static final DeferredBlock<Block> mortumDirt = registerBlock("mortum_dirt", Block::new, MORTUM_DIRT_PROPS);
    public static final DeferredBlock<Block> dreamDirt = registerBlock("dream_dirt", Block::new, DREAM_DIRT_PROPS);
    public static final DeferredBlock<Block> dreamStone = registerBlock("dream_stone", Block::new, DREAM_STONE_PROPS);

    public static final DeferredBlock<Block> frozenGrass = registerBlock("frozen_grass", PlaceholderGrass::new, Block.Properties.of().mapColor(MapColor.DIAMOND));
    public static final DeferredBlock<Block> arcaniteGrass = registerBlock("arcanite_grass", PlaceholderGrass::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE));
    public static final DeferredBlock<Block> scorchedGrass = registerBlock("scorched_grass", PlaceholderGrass::new, SCORCHDIRT_PROPS);
    public static final DeferredBlock<Block> rayGrass = registerBlock("ray_grass", PlaceholderGrass::new, Block.Properties.of().mapColor(MapColor.COLOR_YELLOW));
    public static final DeferredBlock<Block> wildwoodGrass = registerBlock("wildwood_grass", PlaceholderGrass::new, Block.Properties.of().mapColor(MapColor.WATER));
    public static final DeferredBlock<Block> apalachiaGrass = registerBlock("apalachia_grass", PlaceholderGrass::new, Block.Properties.of().mapColor(MapColor.COLOR_PURPLE));
    public static final DeferredBlock<Block> skythernGrass = registerBlock("skythern_grass", PlaceholderGrass::new, Block.Properties.of().mapColor(MapColor.WOOL));
    public static final DeferredBlock<Block> mortumGrass = registerBlock("mortum_grass", PlaceholderGrass::new, Block.Properties.of().mapColor(MapColor.STONE));
    public static final DeferredBlock<Block> flameGrass = registerBlock("flame_grass", PlaceholderGrass::new, Block.Properties.of().mapColor(MapColor.COLOR_ORANGE));
    public static final DeferredBlock<Block> dreamGrass = registerBlock("dream_grass", PlaceholderGrass::new, Block.Properties.of().mapColor(MapColor.WARPED_WART_BLOCK));
    public static final DeferredBlock<Block> evergrass = registerBlock("evergrass", PlaceholderGrass::new, Block.Properties.of().mapColor(MapColor.COLOR_MAGENTA));

    public static final DeferredBlock<Block> gelidite = registerBlock("gelidite", Block::new, Block.Properties.ofFullCopy(Blocks.MUD));

    public static final DeferredBlock<ColoredFallingBlock> frozenGravel = registerBlock("frozen_gravel",(p) -> new ColoredFallingBlock(new ColorRGBA(-8356741), p),FROZEN_GRAVEL_PROPS);
    public static final DeferredBlock<Block> rakedFrozenGravel = registerBlock("raked_frozen_gravel", Block::new, Block.Properties.ofFullCopy(Blocks.GRAVEL));

    public static final DeferredBlock<Block> glaciline = registerBlock("glaciline", Block::new, Block.Properties.ofFullCopy(Blocks.BLUE_ICE).mapColor(MapColor.COLOR_LIGHT_BLUE).friction(0.992F));

    public static final DeferredBlock<SandBlock> arcaniteSand = registerBlock("arcanite_sand",(p) -> new SandBlock(new ColorRGBA(7911916), p),ARCANITE_SAND_PROPS);
    public static final DeferredBlock<SandBlock> arcanicSand = registerBlock("arcanic_sand",(p) -> new SandBlock(new ColorRGBA(4027550), p),ARCANIC_SAND_PROPS);
    public static final DeferredBlock<SandBlock> arcaniumRichSand = registerBlock("arcanium_rich_sand", (p) -> new SandBlock(new ColorRGBA(1130855), p),ARCANIUM_RICH_SAND_PROPS);

    public static final DeferredBlock<Block> soulSludge = registerBlock("soul_sludge", Block::new, Block.Properties.ofFullCopy(Blocks.SOUL_SAND).mapColor(MapColor.COLOR_GRAY));
    public static final DeferredBlock<Block> soulSludgeBreakable = registerBlock("soul_sludge_breakable", Block::new, Block.Properties.ofFullCopy(Blocks.SOUL_SAND).mapColor(MapColor.COLOR_GRAY));

    public static final DeferredBlock<Block> brittleMoss = registerBlock("brittle_moss", Block::new, Block.Properties.ofFullCopy(Blocks.MOSS_BLOCK));
    public static final DeferredBlock<Block> arcaniteMoss = registerBlock("arcanite_moss", Block::new, Block.Properties.ofFullCopy(Blocks.MOSS_BLOCK).mapColor(MapColor.COLOR_LIGHT_BLUE));

    public static final DeferredBlock<Block> frozenStone = registerBlock("frozen_stone", Block::new, FROZEN_STONE_PROPS);
    public static final DeferredBlock<StairBlock> frozenStairs = registerBlock("frozen_stairs", p -> new StairBlock(frozenStone.get().defaultBlockState(), p), FROZEN_STONE_PROPS);
    public static final DeferredBlock<SlabBlock> frozenSlab = registerBlock("frozen_slab", SlabBlock::new, FROZEN_STONE_PROPS);
    public static final DeferredBlock<PressurePlateBlock> frozenPressurePlate = registerBlock("frozen_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p), FROZEN_STONE_PROPS);
    public static final DeferredBlock<ButtonBlock> frozenButton = registerBlock("frozen_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), FROZEN_STONE_PROPS);
    public static final DeferredBlock<Block> cobbledFrozenStone = registerBlock("cobbled_frozen_stone", Block::new, COBBLED_FROZEN_PROPS);
    public static final DeferredBlock<StairBlock> cobbledFrozenStairs = registerBlock("cobbled_frozen_stairs", p -> new StairBlock(cobbledFrozenStone.get().defaultBlockState(), p), COBBLED_FROZEN_PROPS);
    public static final DeferredBlock<SlabBlock> cobbledFrozenSlab = registerBlock("cobbled_frozen_slab", SlabBlock::new, COBBLED_FROZEN_PROPS);
    public static final DeferredBlock<WallBlock> cobbledFrozenWall = registerBlock("cobbled_frozen_wall", WallBlock::new, COBBLED_FROZEN_PROPS);
    public static final DeferredBlock<PressurePlateBlock> cobbledFrozenPressurePlate = registerBlock("cobbled_frozen_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p), COBBLED_FROZEN_PROPS);
    public static final DeferredBlock<ButtonBlock> cobbledFrozenButton = registerBlock("cobbled_frozen_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), COBBLED_FROZEN_PROPS);
    public static final DeferredBlock<Block> cobaltite = registerBlock("cobaltite", Block::new, COBALTITE_PROPS);
    public static final DeferredBlock<StairBlock> cobaltiteStairs = registerBlock("cobaltite_stairs", p -> new StairBlock(cobaltite.get().defaultBlockState(), p), COBALTITE_PROPS);
    public static final DeferredBlock<SlabBlock> cobaltiteSlab = registerBlock("cobaltite_slab", SlabBlock::new, COBALTITE_PROPS);
    public static final DeferredBlock<WallBlock> cobaltiteWall = registerBlock("cobaltite_wall", WallBlock::new, COBALTITE_PROPS);
    public static final DeferredBlock<PressurePlateBlock> cobaltitePressurePlate = registerBlock("cobaltite_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p), COBALTITE_PROPS);
    public static final DeferredBlock<ButtonBlock> cobaltiteButton = registerBlock("cobaltite_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), COBALTITE_PROPS);
    public static final DeferredBlock<Block> icyStone = registerBlock("icy_stone", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.ICE).strength(50.0F, 1200.0F));
    public static final DeferredBlock<Block> blueStone = registerBlock("blue_stone", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.COLOR_LIGHT_BLUE).lightLevel(s -> 15));
    public static final DeferredBlock<Block> icicle = registerBlock("icicle", Block::new, Block.Properties.ofFullCopy(Blocks.ICE).noCollision());
    public static final DeferredBlock<Block> coalstone = registerBlock("coalstone", Block::new, COALSTONE_PROPS);
    public static final DeferredBlock<StairBlock> coalstoneStairs = registerBlock("coalstone_stairs", p -> new StairBlock(coalstone.get().defaultBlockState(), p), COALSTONE_PROPS);
    public static final DeferredBlock<SlabBlock> coalstoneSlab = registerBlock("coalstone_slab", SlabBlock::new, COALSTONE_PROPS);
    public static final DeferredBlock<WallBlock> coalstoneWall = registerBlock("coalstone_wall", WallBlock::new, COALSTONE_PROPS);
    public static final DeferredBlock<PressurePlateBlock> coalstonePressurePlate = registerBlock("coalstone_pressure_plate", p -> new PressurePlateBlock(BlockSetType.POLISHED_BLACKSTONE, p), COALSTONE_PROPS);
    public static final DeferredBlock<ButtonBlock> coalstoneButton = registerBlock("coalstone_button", p -> new ButtonBlock(BlockSetType.POLISHED_BLACKSTONE, 20, p), COALSTONE_PROPS);
    public static final DeferredBlock<Block> thermalVent = registerBlock("thermal_vent", /*BlockThermalVent::new*/ Block::new, Block.Properties.ofFullCopy(Blocks.STONE));
    public static final DeferredBlock<Block> arcaniteStone = registerBlock("arcanite_stone", Block::new, ARCANITE_PROPS);
    public static final DeferredBlock<StairBlock> arcaniteStairs = registerBlock("arcanite_stairs", p -> new StairBlock(arcaniteStone.get().defaultBlockState(), p), ARCANITE_PROPS);
    public static final DeferredBlock<SlabBlock> arcaniteSlab = registerBlock("arcanite_slab", SlabBlock::new, ARCANITE_PROPS);
    public static final DeferredBlock<WallBlock> arcaniteWall = registerBlock("arcanite_wall", WallBlock::new, ARCANITE_PROPS);
    public static final DeferredBlock<PressurePlateBlock> arcanitePressurePlate = registerBlock("arcanite_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p), ARCANITE_PROPS);
    public static final DeferredBlock<ButtonBlock> arcaniteButton = registerBlock("arcanite_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), ARCANITE_PROPS);
    public static final DeferredBlock<Block> ancientStone = registerBlock("ancient_stone", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> ancientStoneBreakable = registerBlock("ancient_stone_breakable", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.COLOR_GRAY));
    public static final DeferredBlock<Block> soulStone = registerBlock("soul_stone", Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> soulStoneBreakable = registerBlock("soul_stone_breakable", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_BLUE));
    public static final DeferredBlock<Block> twilightStone = registerBlock("twilight_stone", Block::new, TWILIGHT_PROPS);
    public static final DeferredBlock<StairBlock> twilightStairs = registerBlock("twilight_stairs", p -> new StairBlock(twilightStone.get().defaultBlockState(), p), TWILIGHT_PROPS);
    public static final DeferredBlock<SlabBlock> twilightSlab = registerBlock("twilight_slab", SlabBlock::new, TWILIGHT_PROPS);
    public static final DeferredBlock<WallBlock> twilightWall = registerBlock("twilight_wall", WallBlock::new, TWILIGHT_PROPS);
    public static final DeferredBlock<PressurePlateBlock> twilightPressurePlate = registerBlock("twilight_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p), TWILIGHT_PROPS);
    public static final DeferredBlock<ButtonBlock> twilightButton = registerBlock("twilight_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), TWILIGHT_PROPS);
    public static final DeferredBlock<Block> scorchalt = registerBlock("scorchalt", Block::new, SCORCHALT_PROPS);
    public static final DeferredBlock<StairBlock> scorchaltStairs = registerBlock("scorchalt_stairs", p -> new StairBlock(scorchalt.get().defaultBlockState(), p), SCORCHALT_PROPS);
    public static final DeferredBlock<SlabBlock> scorchaltSlab = registerBlock("scorchalt_slab", SlabBlock::new, SCORCHALT_PROPS);
    public static final DeferredBlock<WallBlock> scorchaltWall = registerBlock("scorchalt_wall", WallBlock::new, SCORCHALT_PROPS);
    public static final DeferredBlock<PressurePlateBlock> scorchaltPressurePlate = registerBlock("scorchalt_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p), SCORCHALT_PROPS);
    public static final DeferredBlock<ButtonBlock> scorchaltButton = registerBlock("scorchalt_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), SCORCHALT_PROPS);
    public static final DeferredBlock<Block> cobbledScorchalt = registerBlock("cobbled_scorchalt", Block::new, COBBLED_SCORCHALT_PROPS);
    public static final DeferredBlock<StairBlock> cobbledScorchaltStairs = registerBlock("cobbled_scorchalt_stairs", p -> new StairBlock(cobbledScorchalt.get().defaultBlockState(), p), COBBLED_SCORCHALT_PROPS);
    public static final DeferredBlock<SlabBlock> cobbledScorchaltSlab = registerBlock("cobbled_slab", SlabBlock::new, COBBLED_SCORCHALT_PROPS);
    public static final DeferredBlock<WallBlock> cobbledScorchaltWall = registerBlock("cobbled_scorchalt_wall", WallBlock::new, COBBLED_SCORCHALT_PROPS);
    public static final DeferredBlock<PressurePlateBlock> cobbledScorchaltPressurePlate = registerBlock("cobbled_scorchalt_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p), COBBLED_SCORCHALT_PROPS);
    public static final DeferredBlock<ButtonBlock> cobbledScorchaltButton = registerBlock("cobbled_scorchalt_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), COBBLED_SCORCHALT_PROPS);
    public static final DeferredBlock<Block> exposedScorchalt = registerBlock("exposed_scorchalt", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.GOLD).strength(1.5F, 6.0F));
    public static final DeferredBlock<Block> rayStone = registerBlock("ray_stone", Block::new, RAY_STONE_PROPS);
    public static final DeferredBlock<StairBlock> rayStoneStairs = registerBlock("ray_stone_stairs", p -> new StairBlock(rayStone.get().defaultBlockState(), p), RAY_STONE_PROPS);
    public static final DeferredBlock<SlabBlock> rayStoneSlab = registerBlock("ray_stone_slab", SlabBlock::new, RAY_STONE_PROPS);
    public static final DeferredBlock<WallBlock> rayStoneWall = registerBlock("ray_stone_wall", WallBlock::new, RAY_STONE_PROPS);
    public static final DeferredBlock<PressurePlateBlock> rayStonePressurePlate = registerBlock("ray_stone_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p), RAY_STONE_PROPS);
    public static final DeferredBlock<ButtonBlock> rayStoneButton = registerBlock("ray_stone_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), RAY_STONE_PROPS);
    public static final DeferredBlock<Block> draughtStone = registerBlock("draught_stone", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.WOOD));
    public static final DeferredBlock<Block> milkStone = registerBlock("milk_stone", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.WOOL));
    public static final DeferredBlock<Block> divineMossStone = registerBlock("divine_moss_stone", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> divineRock = registerBlock("divine_rock", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_YELLOW));
    public static final DeferredBlock<Block> lunaStone = registerBlock("luna_stone", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_BLUE).strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> everstone = registerBlock("everstone", Block::new, Block.Properties.of().mapColor(MapColor.PLANT).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> whiteEverstone = registerBlock("white_everstone", Block::new, Block.Properties.of().mapColor(MapColor.WOOL).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> darkEverstone = registerBlock("dark_everstone", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> blackHungerstone = registerBlock("black_hungerstone", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> greenHungerstone = registerBlock("green_hungerstone", Block::new, Block.Properties.of().mapColor(MapColor.PLANT).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> hiveWall = registerBlock("hive_wall", Block::new, Block.Properties.ofFullCopy(Blocks.HONEYCOMB_BLOCK).mapColor(MapColor.COLOR_GREEN).lightLevel(s -> 7));
    public static final DeferredBlock<Block> fireCrystal = registerBlock("fire_crystal", Block::new, Block.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.COLOR_RED).lightLevel(s -> 15));
    public static final DeferredBlock<Block> firelight = registerBlock("firelight", Block::new, Block.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.COLOR_BLUE).lightLevel(s -> 15));
    public static final DeferredBlock<Block> realmiteOre = registerBlock("realmite_ore", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_ORE).strength(3.0F, 3.0F));
    public static final DeferredBlock<Block> realmiteOreDeepslate = registerBlock("realmite_ore_deepslate", Block::new, Block.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE).strength(4.5F, 3.0F));
    public static final DeferredBlock<Block> arlemiteOre = registerBlock("arlemite_ore", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_ORE).strength(3.0F, 3.0F));
    public static final DeferredBlock<Block> arlemiteOreDeepslate = registerBlock("arlemite_ore_deepslate", Block::new, Block.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE).strength(4.5F, 3.0F));
    public static final DeferredBlock<Block> rupeeOre = registerBlock("rupee_ore", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_ORE).strength(3.0F, 3.0F));
    public static final DeferredBlock<Block> rupeeOreDeepslate = registerBlock("rupee_ore_deepslate", Block::new, Block.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE).strength(4.5F, 3.0F));
    public static final DeferredBlock<DropExperienceBlock> bloodgemOre = registerBlock("bloodgem_ore", p -> new DropExperienceBlock(UniformInt.of(3, 7), p), Block.Properties.ofFullCopy(Blocks.NETHER_GOLD_ORE));
    public static final DeferredBlock<Block> torriditeOre = registerBlock("torridite_ore", Block::new, Block.Properties.ofFullCopy(Blocks.NETHER_GOLD_ORE).strength(3.0F, 1200.0F));
    public static final DeferredBlock<DropExperienceBlock> anthraciteOre = registerBlock("anthracite_ore", p -> new DropExperienceBlock(UniformInt.of(0, 2), p), Block.Properties.ofFullCopy(Blocks.COAL_ORE).mapColor(MapColor.GLOW_LICHEN));
    public static final DeferredBlock<Block> oxdriteOre = registerBlock("oxdrite_ore", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.GLOW_LICHEN).strength(3.0F, 3.0F));
    public static final DeferredBlock<Block> rawArcanium = registerBlock("raw_arcanium", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(5.0F, 6.0F));
    public static final DeferredBlock<Block> scorchaltEdenOre = registerBlock("scorchalt_eden_ore", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_PINK).strength(3.0F, 32.0F));
    public static final DeferredBlock<Block> twilightEdenOre = registerBlock("twilight_eden_ore", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).strength(3.0F, 32.0F));
    public static final DeferredBlock<Block> wildwoodOre = registerBlock("wildwood_ore", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).strength(3.0F, 32.0F));
    public static final DeferredBlock<Block> apalachiaOre = registerBlock("apalachia_ore", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).strength(3.0F, 32.0F));
    public static final DeferredBlock<Block> skythernOre = registerBlock("skythern_ore", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).strength(3.0F, 32.0F));
    public static final DeferredBlock<Block> mortumOre = registerBlock("mortum_ore", Block::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).strength(3.0F, 32.0F));
    public static final DeferredBlock<Block> rawRealmiteBlock = registerBlock("raw_realmite_block", Block::new, Block.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.COLOR_ORANGE).strength(5.0F, 6.0F));
    public static final DeferredBlock<Block> rawArlemiteBlock = registerBlock("raw_arlemite_block", Block::new, Block.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.COLOR_LIGHT_GREEN).strength(5.0F, 6.0F));
    public static final DeferredBlock<Block> rawRupeeBlock = registerBlock("raw_rupee_block", Block::new, Block.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.COLOR_LIGHT_BLUE).strength(5.0F, 6.0F));
    public static final DeferredBlock<Block> rawTorriditeBlock = registerBlock("raw_torridite_block", Block::new, Block.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.CRIMSON_NYLIUM).strength(5.0F, 1200.0F));
    public static final DeferredBlock<Block> rawOxdriteBlock = registerBlock("raw_oxdrite_block", Block::new, Block.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.COLOR_BROWN).strength(5.0F, 6.0F));
    public static final DeferredBlock<Block> realmiteBlock = registerBlock("realmite_block", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_ORANGE).strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> arlemiteBlock = registerBlock("arlemite_block", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_LIGHT_GREEN).strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> rupeeBlock = registerBlock("rupee_block", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_LIGHT_BLUE).strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> bloodgemBlock = registerBlock("bloodgem_block", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.CRIMSON_STEM).strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> oxdriteBlock = registerBlock("oxdrite_block", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_BROWN).strength(3.0F, 6.0F).sound(SoundType.COPPER));
    public static final DeferredBlock<Block> arcaniumBlock = registerBlock("arcanium_block", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_LIGHT_BLUE).strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> shadowBlock = registerBlock("shadow_block", Block::new, Block.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).mapColor(MapColor.COLOR_BLACK).strength(5.0F, 6.0F).sound(SoundType.NETHERITE_BLOCK));
    public static final DeferredBlock<Block> torriditeBlock = registerBlock("torridite_block", Block::new, Block.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK).mapColor(MapColor.CRIMSON_NYLIUM).strength(5.0F, 1200.0F).requiresCorrectToolForDrops().sound(SoundType.METAL));
    public static final DeferredBlock<Block> edenBlock = registerBlock("eden_block", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_ORANGE).strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> wildwoodBlock = registerBlock("wildwood_block", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.LAPIS).strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> apalachiaBlock = registerBlock("apalachia_block", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_MAGENTA).strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> skythernBlock = registerBlock("skythern_block", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.WOOL).strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> mortumBlock = registerBlock("mortum_block", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_GRAY).strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> arcanaPortalFrame = registerBlock("arcana_portal_frame", /*BlockArcanaPortalFrame::new*/ Block::new, Block.Properties.ofFullCopy(Blocks.END_PORTAL_FRAME));
    public static final DeferredBlock<AmethystBlock> olivineBlock = registerBlock("olivine_block", AmethystBlock::new, Block.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.COLOR_GREEN).lightLevel(s -> 1));
    public static final DeferredBlock<Block> buddingOlivine = registerBlock("budding_olivine", /*BlockBuddingOlivine::new*/ Block::new, Block.Properties.ofFullCopy(Blocks.BUDDING_AMETHYST).mapColor(MapColor.COLOR_GREEN).lightLevel(s -> 2));
    public static final DeferredBlock<AmethystClusterBlock> olivineCluster = registerBlock("olivine_cluster", p -> new AmethystClusterBlock(7, 3, p), Block.Properties.ofFullCopy(Blocks.AMETHYST_CLUSTER).mapColor(MapColor.COLOR_GREEN).lightLevel(s -> 3));
    public static final DeferredBlock<Block> buddingDravite = registerBlock("budding_dravite", Block::new, Block.Properties.ofFullCopy(Blocks.BUDDING_AMETHYST).mapColor(MapColor.COLOR_BROWN).lightLevel(s -> 2));
    public static final DeferredBlock<Block> plankDesign = registerBlock("plank_design", Block::new, DESIGN_PROPS);
    public static final DeferredBlock<StairBlock> stairDesign = registerBlock("stair_design", p -> new StairBlock(plankDesign.get().defaultBlockState(), p), DESIGN_PROPS);
    public static final DeferredBlock<SlabBlock> slabDesign = registerBlock("slab_design", SlabBlock::new, DESIGN_PROPS);
    public static final DeferredBlock<Block> divineLog = registerBlock("divine_log", RotatedPillarBlock::new, DIVINE_LOG_PROPS);
    public static final DeferredBlock<Block> divineWood = registerBlock("divine_wood", RotatedPillarBlock::new, DIVINE_LOG_PROPS);
    public static final DeferredBlock<Block> strippedDivineLog = registerBlock("stripped_divine_log", RotatedPillarBlock::new, DIVINE_LOG_PROPS);
    public static final DeferredBlock<Block> strippedDivineWood = registerBlock("stripped_divine_wood", RotatedPillarBlock::new, DIVINE_LOG_PROPS);
    public static final DeferredBlock<Block> divinePlanks = registerBlock("divine_planks", Block::new, DIVINE_PLANKS_PROPS);
    public static final DeferredBlock<StairBlock> divineStairs = registerBlock("divine_stairs", p -> new StairBlock(divinePlanks.get().defaultBlockState(), p), DIVINE_PLANKS_PROPS);
    public static final DeferredBlock<SlabBlock> divineSlab = registerBlock("divine_slab", SlabBlock::new, DIVINE_PLANKS_PROPS);
    public static final DeferredBlock<FenceBlock> divineFence = registerBlock("divine_fence", FenceBlock::new, DIVINE_PLANKS_PROPS);
    public static final DeferredBlock<FenceGateBlock> divineFenceGate = registerBlock("divine_fence_gate", p -> new FenceGateBlock(new WoodType("divine", BlockSetType.OAK), p), DIVINE_PLANKS_PROPS);
    public static final DeferredBlock<Block> divineSapling = registerBlock("divine_sapling", p -> new SaplingBlock(new TreeGrower("divine", Optional.empty(), Optional.of(FeatureRegistry.DIVINE_TREE_KEY), Optional.empty()), p), Block.Properties.ofFullCopy(Blocks.OAK_SAPLING));
    public static final DeferredBlock<Block> divineLeaves = registerBlock("divine_leaves", DivineLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.OAK_LEAVES).mapColor(MapColor.GOLD).sound(SoundType.CHERRY_LEAVES));
    public static final DeferredBlock<DoorBlock> divineDoor = registerBlock("divine_door",p -> new DoorBlock(BlockSetType.OAK, p),DIVINE_PLANKS_PROPS);
    public static final DeferredBlock<TrapDoorBlock> divineTrapdoor = registerBlock("divine_trapdoor",p -> new TrapDoorBlock(BlockSetType.OAK, p),DIVINE_PLANKS_PROPS);
    public static final DeferredBlock<PressurePlateBlock> divinePressurePlate = registerBlock("divine_pressure_plate",p -> new PressurePlateBlock(BlockSetType.OAK, p),DIVINE_PLANKS_PROPS);
    public static final DeferredBlock<ButtonBlock> divineButton = registerBlock("divine_button",p -> new ButtonBlock(BlockSetType.OAK, 20, p),DIVINE_PLANKS_PROPS);
    public static final DeferredBlock<Block> shiverspineLog = registerBlock("shiverspine_log", RotatedPillarBlock::new, SHIVERSPINE_LOG_PROPS);
    public static final DeferredBlock<Block> shiverspineWood = registerBlock("shiverspine_wood", RotatedPillarBlock::new, SHIVERSPINE_LOG_PROPS);
    public static final DeferredBlock<Block> strippedShiverspineLog = registerBlock("stripped_shiverspine_log", RotatedPillarBlock::new, SHIVERSPINE_LOG_PROPS);
    public static final DeferredBlock<Block> strippedShiverspineWood = registerBlock("stripped_shiverspine_wood", RotatedPillarBlock::new, SHIVERSPINE_LOG_PROPS);
    public static final DeferredBlock<Block> shiverspinePlanks = registerBlock("shiverspine_planks", Block::new, SHIVERSPINE_PLANKS_PROPS);
    public static final DeferredBlock<StairBlock> shiverspineStairs = registerBlock("shiverspine_stairs", p -> new StairBlock(shiverspinePlanks.get().defaultBlockState(), p), SHIVERSPINE_PLANKS_PROPS);
    public static final DeferredBlock<SlabBlock> shiverspineSlab = registerBlock("shiverspine_slab", SlabBlock::new, SHIVERSPINE_PLANKS_PROPS);
    public static final DeferredBlock<Block> shiverspineFence = registerBlock("shiverspine_fence", FenceBlock::new, SHIVERSPINE_PLANKS_PROPS);
    public static final DeferredBlock<Block> shiverspineFenceGate = registerBlock("shiverspine_fence_gate", p -> new FenceGateBlock(new WoodType("shiverspine", BlockSetType.OAK), p), SHIVERSPINE_PLANKS_PROPS);
    public static final DeferredBlock<LadderBlock> shiverspineLadder = registerBlock("shiverspine_ladder", LadderBlock::new, SHIVERSPINE_PLANKS_PROPS);
    public static final DeferredBlock<Block> shiverspineSapling = registerBlock("shiverspine_sapling", p -> new SaplingBlock(new TreeGrower("shiverspine", Optional.empty(), Optional.of(/*FeatureRegistry.SHIVERSPINE_TREE_KEY*/FeatureRegistry.DIVINE_TREE_KEY), Optional.empty()), p), Block.Properties.ofFullCopy(Blocks.OAK_SAPLING));
    public static final DeferredBlock<Block> brittleLeaves = registerBlock("brittle_leaves", DivineLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.OAK_LEAVES).mapColor(MapColor.WOOL).sound(SoundType.GRASS));
    public static final DeferredBlock<Block> shiverspineDoor = registerBlock("shiverspine_door", p -> new DoorBlock(BlockSetType.OAK, p), SHIVERSPINE_PLANKS_PROPS);
    public static final DeferredBlock<Block> shiverspineTrapdoor = registerBlock("shiverspine_trapdoor", p -> new TrapDoorBlock(BlockSetType.OAK, p), SHIVERSPINE_PLANKS_PROPS);
    public static final DeferredBlock<PressurePlateBlock> shiverspinePressurePlate = registerBlock("shiverspine_pressure_plate", p -> new PressurePlateBlock(BlockSetType.OAK, p), SHIVERSPINE_PLANKS_PROPS);
    public static final DeferredBlock<ButtonBlock> shiverspineButton = registerBlock("shiverspine_button", p -> new ButtonBlock(BlockSetType.OAK, 20, p), SHIVERSPINE_PLANKS_PROPS);
//    public static final DeferredBlock<StandingSignBlock> shiverspineSign = registerBlock("shiverspine_sign",p -> new StandingSignBlock(SHIVERSPINE_WOOD_TYPE, p),SHIVERSPINE_PLANKS_PROPS.noCollision().strength(1.0F));
//    public static final DeferredBlock<WallSignBlock> shiverspineWallSign = registerBlock("shiverspine_wall_sign",p -> new WallSignBlock(SHIVERSPINE_WOOD_TYPE, p),SHIVERSPINE_PLANKS_PROPS.noCollision().strength(1.0F));
//    public static final DeferredBlock<CeilingHangingSignBlock> shiverspineHangingSign = registerBlock("shiverspine_hanging_sign",p -> new CeilingHangingSignBlock(SHIVERSPINE_WOOD_TYPE, p),SHIVERSPINE_PLANKS_PROPS.noCollision().strength(1.0F));
//    public static final DeferredBlock<WallHangingSignBlock> shiverspineHangingWallSign = registerBlock("shiverspine_wall_hanging_sign",p -> new WallHangingSignBlock(SHIVERSPINE_WOOD_TYPE, p),SHIVERSPINE_PLANKS_PROPS.noCollision().strength(1.0F));
    public static final DeferredBlock<Block> auroraoakLog = registerBlock("auroraoak_log", RotatedPillarBlock::new, AURORAOAK_LOG_PROPS);
    public static final DeferredBlock<Block> auroraoakWood = registerBlock("auroraoak_wood", RotatedPillarBlock::new, AURORAOAK_LOG_PROPS);
    public static final DeferredBlock<Block> strippedAuroraoakLog = registerBlock("stripped_auroraoak_log", RotatedPillarBlock::new, AURORAOAK_LOG_PROPS);
    public static final DeferredBlock<Block> strippedAuroraoakWood = registerBlock("stripped_auroraoak_wood", RotatedPillarBlock::new, AURORAOAK_LOG_PROPS);
    public static final DeferredBlock<Block> auroraoakPlanks = registerBlock("auroraoak_planks", Block::new, AURORAOAK_PLANKS_PROPS);
    public static final DeferredBlock<StairBlock> auroraoakStairs = registerBlock("auroraoak_stairs", p -> new StairBlock(auroraoakPlanks.get().defaultBlockState(), p), AURORAOAK_PLANKS_PROPS);
    public static final DeferredBlock<SlabBlock> auroraoakSlab = registerBlock("auroraoak_slab", SlabBlock::new, AURORAOAK_PLANKS_PROPS);
    public static final DeferredBlock<FenceBlock> auroraoakFence = registerBlock("auroraoak_fence", FenceBlock::new, AURORAOAK_PLANKS_PROPS);
    public static final DeferredBlock<FenceGateBlock> auroraoakFenceGate = registerBlock("auroraoak_fence_gate", p -> new FenceGateBlock(new WoodType("auroraoak", BlockSetType.OAK), p), AURORAOAK_PLANKS_PROPS);
    public static final DeferredBlock<Block> auroraoakSapling = registerBlock("auroraoak_sapling", p -> new SaplingBlock(new TreeGrower("auroraoak", Optional.empty(), Optional.of(/*FeatureRegistry.AURORAOAK_TREE_KEY*/FeatureRegistry.DIVINE_TREE_KEY), Optional.empty()), p), Block.Properties.ofFullCopy(Blocks.OAK_SAPLING));
    public static final DeferredBlock<Block> auroraoakLeaves = registerBlock("auroraoak_leaves", DivineLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.CHERRY_LEAVES).mapColor(MapColor.COLOR_PURPLE));
    public static final DeferredBlock<DoorBlock> auroraoakDoor = registerBlock("auroraoak_door", p -> new DoorBlock(BlockSetType.OAK, p), AURORAOAK_PLANKS_PROPS);
    public static final DeferredBlock<TrapDoorBlock> auroraoakTrapdoor = registerBlock("auroraoak_trapdoor", p -> new TrapDoorBlock(BlockSetType.OAK, p), AURORAOAK_PLANKS_PROPS);
    public static final DeferredBlock<PressurePlateBlock> auroraoakPressurePlate = registerBlock("auroraoak_pressure_plate", p -> new PressurePlateBlock(BlockSetType.OAK, p), AURORAOAK_PLANKS_PROPS);
    public static final DeferredBlock<ButtonBlock> auroraoakButton = registerBlock("auroraoak_button", p -> new ButtonBlock(BlockSetType.OAK, 20, p), AURORAOAK_PLANKS_PROPS);
//    public static final DeferredBlock<StandingSignBlock> auroraoakSign = registerBlock("auroraoak_sign", p -> new StandingSignBlock(AURORAOAK_WOOD_TYPE, p), AURORAOAK_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallSignBlock> auroraoakWallSign = registerBlock("auroraoak_wall_sign", p -> new WallSignBlock(AURORAOAK_WOOD_TYPE, p), AURORAOAK_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<CeilingHangingSignBlock> auroraoakHangingSign = registerBlock("auroraoak_hanging_sign", p -> new CeilingHangingSignBlock(AURORAOAK_WOOD_TYPE, p), AURORAOAK_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallHangingSignBlock> auroraoakHangingWallSign = registerBlock("auroraoak_wall_hanging_sign", p -> new WallHangingSignBlock(AURORAOAK_WOOD_TYPE, p), AURORAOAK_PLANKS_PROPS.noCollision());
    public static final DeferredBlock<Block> cozybarkLog = registerBlock("cozybark_log", RotatedPillarBlock::new, COZYBARK_LOG_PROPS);
    public static final DeferredBlock<Block> cozybarkWood = registerBlock("cozybark_wood", RotatedPillarBlock::new, COZYBARK_LOG_PROPS);
    public static final DeferredBlock<Block> strippedCozybarkLog = registerBlock("stripped_cozybark_log", RotatedPillarBlock::new, COZYBARK_LOG_PROPS);
    public static final DeferredBlock<Block> strippedCozybarkWood = registerBlock("stripped_cozybark_wood", RotatedPillarBlock::new, COZYBARK_LOG_PROPS);
    public static final DeferredBlock<Block> cozybarkPlanks = registerBlock("cozybark_planks", Block::new, COZYBARK_PLANKS_PROPS);
    public static final DeferredBlock<StairBlock> cozybarkStairs = registerBlock("cozybark_stairs", p -> new StairBlock(cozybarkPlanks.get().defaultBlockState(), p), COZYBARK_PLANKS_PROPS);
    public static final DeferredBlock<SlabBlock> cozybarkSlab = registerBlock("cozybark_slab", SlabBlock::new, COZYBARK_PLANKS_PROPS);
    public static final DeferredBlock<FenceBlock> cozybarkFence = registerBlock("cozybark_fence", FenceBlock::new, COZYBARK_PLANKS_PROPS);
    public static final DeferredBlock<FenceGateBlock> cozybarkFenceGate = registerBlock("cozybark_fence_gate", p -> new FenceGateBlock(new WoodType("cozybark", BlockSetType.CHERRY), p), COZYBARK_PLANKS_PROPS);
    public static final DeferredBlock<Block> cozybarkSapling = registerBlock("cozybark_sapling", p -> new SaplingBlock(new TreeGrower("cozybark", Optional.empty(), Optional.of(/*FeatureRegistry.COZYBARK_TREE_KEY*/FeatureRegistry.DIVINE_TREE_KEY), Optional.empty()), p), Block.Properties.ofFullCopy(Blocks.CRIMSON_STEM));
    public static final DeferredBlock<Block> cozybarkLeaves = registerBlock("cozybark_leaves", BlockCozybarkLeaves::new, Block.Properties.ofFullCopy(Blocks.CHERRY_LEAVES));
    public static final DeferredBlock<DoorBlock> cozybarkDoor = registerBlock("cozybark_door", p -> new DoorBlock(BlockSetType.CHERRY, p), COZYBARK_PLANKS_PROPS);
    public static final DeferredBlock<TrapDoorBlock> cozybarkTrapdoor = registerBlock("cozybark_trapdoor", p -> new TrapDoorBlock(BlockSetType.CHERRY, p), COZYBARK_PLANKS_PROPS);
    public static final DeferredBlock<PressurePlateBlock> cozybarkPressurePlate = registerBlock("cozybark_pressure_plate", p -> new PressurePlateBlock(BlockSetType.CHERRY, p), COZYBARK_PLANKS_PROPS);
    public static final DeferredBlock<ButtonBlock> cozybarkButton = registerBlock("cozybark_button", p -> new ButtonBlock(BlockSetType.CHERRY, 20, p), COZYBARK_PLANKS_PROPS);
//    public static final DeferredBlock<StandingSignBlock> cozybarkSign = registerBlock("cozybark_sign", p -> new StandingSignBlock(COZYBARK_WOOD_TYPE, p), COZYBARK_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallSignBlock> cozybarkWallSign = registerBlock("cozybark_wall_sign", p -> new WallSignBlock(COZYBARK_WOOD_TYPE, p), COZYBARK_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<CeilingHangingSignBlock> cozybarkHangingSign = registerBlock("cozybark_hanging_sign", p -> new CeilingHangingSignBlock(COZYBARK_WOOD_TYPE, p), COZYBARK_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallHangingSignBlock> cozybarkHangingWallSign = registerBlock("cozybark_wall_hanging_sign", p -> new WallHangingSignBlock(COZYBARK_WOOD_TYPE, p), COZYBARK_PLANKS_PROPS.noCollision());
    public static final DeferredBlock<Block> streamleafLog = registerBlock("streamleaf_log", RotatedPillarBlock::new, STREAMLEAF_LOG_PROPS);
    public static final DeferredBlock<Block> streamleafWood = registerBlock("streamleaf_wood", RotatedPillarBlock::new, STREAMLEAF_LOG_PROPS);
    public static final DeferredBlock<Block> strippedStreamleafLog = registerBlock("stripped_streamleaf_log", RotatedPillarBlock::new, STREAMLEAF_LOG_PROPS);
    public static final DeferredBlock<Block> strippedStreamleafWood = registerBlock("stripped_streamleaf_wood", RotatedPillarBlock::new, STREAMLEAF_LOG_PROPS);
    public static final DeferredBlock<Block> streamleafPlanks = registerBlock("streamleaf_planks", Block::new, STREAMLEAF_PLANKS_PROPS);
    public static final DeferredBlock<StairBlock> streamleafStairs = registerBlock("streamleaf_stairs", p -> new StairBlock(streamleafPlanks.get().defaultBlockState(), p), STREAMLEAF_PLANKS_PROPS);
    public static final DeferredBlock<SlabBlock> streamleafSlab = registerBlock("streamleaf_slab", SlabBlock::new, STREAMLEAF_PLANKS_PROPS);
    public static final DeferredBlock<FenceBlock> streamleafFence = registerBlock("streamleaf_fence", FenceBlock::new, STREAMLEAF_PLANKS_PROPS);
    public static final DeferredBlock<FenceGateBlock> streamleafFenceGate = registerBlock("streamleaf_fence_gate", p -> new FenceGateBlock(new WoodType("streamleaf", BlockSetType.WARPED), p), STREAMLEAF_PLANKS_PROPS);
    public static final DeferredBlock<Block> streamleafSapling = registerBlock("streamleaf_sapling", p -> new SaplingBlock(new TreeGrower("streamleaf", Optional.empty(), Optional.of(/*FeatureRegistry.STREAMLEAF_TREE_KEY*/FeatureRegistry.DIVINE_TREE_KEY), Optional.empty()), p), Block.Properties.ofFullCopy(Blocks.WARPED_ROOTS));
    public static final DeferredBlock<Block> streamleafLeaves = registerBlock("streamleaf_leaves", DivineLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.WARPED_WART_BLOCK).mapColor(MapColor.GLOW_LICHEN));
    public static final DeferredBlock<DoorBlock> streamleafDoor = registerBlock("streamleaf_door", p -> new DoorBlock(BlockSetType.WARPED, p), STREAMLEAF_PLANKS_PROPS);
    public static final DeferredBlock<TrapDoorBlock> streamleafTrapdoor = registerBlock("streamleaf_trapdoor", p -> new TrapDoorBlock(BlockSetType.WARPED, p), STREAMLEAF_PLANKS_PROPS);
    public static final DeferredBlock<PressurePlateBlock> streamleafPressurePlate = registerBlock("streamleaf_pressure_plate", p -> new PressurePlateBlock(BlockSetType.WARPED, p), STREAMLEAF_PLANKS_PROPS);
    public static final DeferredBlock<ButtonBlock> streamleafButton = registerBlock("streamleaf_button", p -> new ButtonBlock(BlockSetType.WARPED, 20, p), STREAMLEAF_PLANKS_PROPS);
//    public static final DeferredBlock<StandingSignBlock> streamleafSign = registerBlock("streamleaf_sign", p -> new StandingSignBlock(STREAMLEAF_WOOD_TYPE, p), STREAMLEAF_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallSignBlock> streamleafWallSign = registerBlock("streamleaf_wall_sign", p -> new WallSignBlock(STREAMLEAF_WOOD_TYPE, p), STREAMLEAF_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<CeilingHangingSignBlock> streamleafHangingSign = registerBlock("streamleaf_hanging_sign", p -> new CeilingHangingSignBlock(STREAMLEAF_WOOD_TYPE, p), STREAMLEAF_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallHangingSignBlock> streamleafHangingWallSign = registerBlock("streamleaf_wall_hanging_sign", p -> new WallHangingSignBlock(STREAMLEAF_WOOD_TYPE, p), STREAMLEAF_PLANKS_PROPS.noCollision());
    public static final DeferredBlock<Block> glowsprout = registerBlock("glowsprout",/*p -> new FungusBlock(FeatureRegistry.GLOWSPROUT_KEY, gelidite.get(), p)*/Block::new,Block.Properties.ofFullCopy(Blocks.WARPED_FUNGUS).mapColor(MapColor.COLOR_CYAN));
    public static final DeferredBlock<Block> glowsproutBulb = registerBlock("glowsprout_bulb",HalfTransparentBlock::new,Block.Properties.ofFullCopy(Blocks.OCHRE_FROGLIGHT).noOcclusion().lightLevel(s -> 10).mapColor(MapColor.DIAMOND));
    public static final DeferredBlock<Block> glowsproutStem = registerBlock("glowsprout_stem",RotatedPillarBlock::new,Block.Properties.ofFullCopy(Blocks.WARPED_STEM).mapColor(MapColor.COLOR_LIGHT_BLUE));
    public static final DeferredBlock<Block> lowsprout = registerBlock("lowsprout",/*p -> new FungusBlock(FeatureRegistry.LOWSPROUT_KEY, gelidite.get(), p)*/Block::new,Block.Properties.ofFullCopy(Blocks.WARPED_FUNGUS).mapColor(MapColor.COLOR_GREEN));
    public static final DeferredBlock<Block> lowsproutBulb = registerBlock("lowsprout_bulb",HalfTransparentBlock::new,Block.Properties.ofFullCopy(Blocks.VERDANT_FROGLIGHT).noOcclusion().lightLevel(s -> 10).mapColor(MapColor.WARPED_WART_BLOCK));
    public static final DeferredBlock<Block> lowsproutStem = registerBlock("lowsprout_stem",RotatedPillarBlock::new,Block.Properties.ofFullCopy(Blocks.WARPED_STEM).mapColor(MapColor.GLOW_LICHEN));
    public static final DeferredBlock<Block> slowsprout = registerBlock("slowsprout",/*p -> new FungusBlock(FeatureRegistry.SLOWSPROUT_KEY, gelidite.get(), p)*/Block::new,Block.Properties.ofFullCopy(Blocks.WARPED_FUNGUS).mapColor(MapColor.COLOR_MAGENTA));
    public static final DeferredBlock<Block> slowsproutBulb = registerBlock("slowsprout_bulb",HalfTransparentBlock::new,Block.Properties.ofFullCopy(Blocks.PEARLESCENT_FROGLIGHT).noOcclusion().lightLevel(s -> 10).mapColor(MapColor.ICE));
    public static final DeferredBlock<Block> slowsproutStem = registerBlock("slowsprout_stem",RotatedPillarBlock::new,Block.Properties.ofFullCopy(Blocks.WARPED_STEM).mapColor(MapColor.COLOR_PINK));
    public static final DeferredBlock<Block> eucalyptusLog = registerBlock("eucalyptus_log", RotatedPillarBlock::new, EUCALYPTUS_LOG_PROPS.mapColor(MapColor.COLOR_LIGHT_GRAY));
    public static final DeferredBlock<Block> eucalyptusWood = registerBlock("eucalyptus_wood", RotatedPillarBlock::new, EUCALYPTUS_LOG_PROPS.mapColor(MapColor.COLOR_LIGHT_GRAY));
    public static final DeferredBlock<Block> strippedEucalyptusLog = registerBlock("stripped_eucalyptus_log", RotatedPillarBlock::new, EUCALYPTUS_LOG_PROPS.mapColor(MapColor.WOOD));
    public static final DeferredBlock<Block> strippedEucalyptusWood = registerBlock("stripped_eucalyptus_wood", RotatedPillarBlock::new, EUCALYPTUS_LOG_PROPS.mapColor(MapColor.WOOD));
    public static final DeferredBlock<Block> eucalyptusPlanks = registerBlock("eucalyptus_planks", Block::new, EUCALYPTUS_PLANKS_PROPS);
    public static final DeferredBlock<StairBlock> eucalyptusStairs = registerBlock("eucalyptus_stairs", p -> new StairBlock(eucalyptusPlanks.get().defaultBlockState(), p), EUCALYPTUS_PLANKS_PROPS);
    public static final DeferredBlock<SlabBlock> eucalyptusSlab = registerBlock("eucalyptus_slab", SlabBlock::new, EUCALYPTUS_PLANKS_PROPS);
    public static final DeferredBlock<FenceBlock> eucalyptusFence = registerBlock("eucalyptus_fence", FenceBlock::new, EUCALYPTUS_PLANKS_PROPS);
    public static final DeferredBlock<FenceGateBlock> eucalyptusFenceGate = registerBlock("eucalyptus_fence_gate", p -> new FenceGateBlock(new WoodType("eucalyptus", BlockSetType.OAK), p), EUCALYPTUS_PLANKS_PROPS);
    public static final DeferredBlock<DoorBlock> eucalyptusDoor = registerBlock("eucalyptus_door", p -> new DoorBlock(BlockSetType.OAK, p), EUCALYPTUS_PLANKS_PROPS);
    public static final DeferredBlock<TrapDoorBlock> eucalyptusTrapdoor = registerBlock("eucalyptus_trapdoor", p -> new TrapDoorBlock(BlockSetType.OAK, p), EUCALYPTUS_PLANKS_PROPS);
    public static final DeferredBlock<PressurePlateBlock> eucalyptusPressurePlate = registerBlock("eucalyptus_pressure_plate", p -> new PressurePlateBlock(BlockSetType.OAK, p), EUCALYPTUS_PLANKS_PROPS);
    public static final DeferredBlock<ButtonBlock> eucalyptusButton = registerBlock("eucalyptus_button", p -> new ButtonBlock(BlockSetType.OAK, 20, p), EUCALYPTUS_PLANKS_PROPS);
//    public static final DeferredBlock<StandingSignBlock> eucalyptusSign = registerBlock("eucalyptus_sign", p -> new StandingSignBlock(EUCALYPTUS_WOOD_TYPE, p), EUCALYPTUS_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallSignBlock> eucalyptusWallSign = registerBlock("eucalyptus_wall_sign", p -> new WallSignBlock(EUCALYPTUS_WOOD_TYPE, p), EUCALYPTUS_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<CeilingHangingSignBlock> eucalyptusHangingSign = registerBlock("eucalyptus_hanging_sign", p -> new CeilingHangingSignBlock(EUCALYPTUS_WOOD_TYPE, p), EUCALYPTUS_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallHangingSignBlock> eucalyptusHangingWallSign = registerBlock("eucalyptus_wall_hanging_sign", p -> new WallHangingSignBlock(EUCALYPTUS_WOOD_TYPE, p), EUCALYPTUS_PLANKS_PROPS.noCollision());
    public static final DeferredBlock<Block> edenLog = registerBlock("eden_log", RotatedPillarBlock::new, EDEN_LOG_PROPS.mapColor(MapColor.COLOR_BROWN));
    public static final DeferredBlock<Block> edenWood = registerBlock("eden_wood", RotatedPillarBlock::new, EDEN_LOG_PROPS.mapColor(MapColor.COLOR_BROWN));
    public static final DeferredBlock<Block> strippedEdenLog = registerBlock("stripped_eden_log", RotatedPillarBlock::new, EDEN_LOG_PROPS);
    public static final DeferredBlock<Block> strippedEdenWood = registerBlock("stripped_eden_wood", RotatedPillarBlock::new, EDEN_LOG_PROPS);
    public static final DeferredBlock<Block> edenPlanks = registerBlock("eden_planks", Block::new, EDEN_PLANKS_PROPS);
    public static final DeferredBlock<StairBlock> edenStairs = registerBlock("eden_stairs", p -> new StairBlock(edenPlanks.get().defaultBlockState(), p), EDEN_PLANKS_PROPS);
    public static final DeferredBlock<SlabBlock> edenSlab = registerBlock("slab", SlabBlock::new, EDEN_PLANKS_PROPS);
    public static final DeferredBlock<FenceBlock> edenFence = registerBlock("eden_fence", FenceBlock::new, EDEN_PLANKS_PROPS);
    public static final DeferredBlock<FenceGateBlock> edenFenceGate = registerBlock("eden_fence_gate", p -> new FenceGateBlock(new WoodType("eden", BlockSetType.OAK), p), EDEN_PLANKS_PROPS);
    public static final DeferredBlock<Block> edenSapling = registerBlock("eden_sapling", p -> new SaplingBlock(new TreeGrower("eden", Optional.empty(), Optional.of(/*FeatureRegistry.EDEN_TREE_KEY*/FeatureRegistry.DIVINE_TREE_KEY), Optional.empty()), p), Block.Properties.ofFullCopy(Blocks.OAK_SAPLING));
    public static final DeferredBlock<Block> edenLeaves = registerBlock("eden_leaves", DivineLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.OAK_LEAVES).mapColor(MapColor.GOLD));
    public static final DeferredBlock<DoorBlock> edenDoor = registerBlock("eden_door", p -> new DoorBlock(BlockSetType.OAK, p), EDEN_PLANKS_PROPS);
    public static final DeferredBlock<TrapDoorBlock> edenTrapdoor = registerBlock("eden_trapdoor", p -> new TrapDoorBlock(BlockSetType.OAK, p), EDEN_PLANKS_PROPS);
    public static final DeferredBlock<PressurePlateBlock> edenPressurePlate = registerBlock("eden_pressure_plate", p -> new PressurePlateBlock(BlockSetType.OAK, p), EDEN_PLANKS_PROPS);
    public static final DeferredBlock<ButtonBlock> edenButton = registerBlock("eden_button", p -> new ButtonBlock(BlockSetType.OAK, 20, p), EDEN_PLANKS_PROPS);
//    public static final DeferredBlock<StandingSignBlock> edenSign = registerBlock("eden_sign", p -> new StandingSignBlock(EDEN_WOOD_TYPE, p), EDEN_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallSignBlock> edenWallSign = registerBlock("eden_wall_sign", p -> new WallSignBlock(EDEN_WOOD_TYPE, p), EDEN_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<TorchBlock> edenTorch = registerBlock("eden_torch", p -> new TorchBlock(ParticleTypes.FLAME, p), Block.Properties.ofFullCopy(Blocks.TORCH));
//    public static final DeferredBlock<WallTorchBlock> edenWallTorch = registerBlock("eden_wall_torch", p -> new WallTorchBlock(ParticleTypes.FLAME, p), Block.Properties.ofFullCopy(Blocks.WALL_TORCH));
    public static final DeferredBlock<Block> crimseekerSapling = registerBlock("crimseeker_sapling",p -> new SaplingBlock(new TreeGrower("crimseeker", Optional.empty(), Optional.of(/*FeatureRegistry.WILDWOOD_TREE_KEY*/FeatureRegistry.DIVINE_TREE_KEY), Optional.empty()), p),Block.Properties.ofFullCopy(Blocks.CRIMSON_FUNGUS));
    public static final DeferredBlock<Block> crimmseekerLog = registerBlock("crimseeker_log",RotatedPillarBlock::new,Block.Properties.ofFullCopy(Blocks.CRIMSON_STEM).mapColor(MapColor.COLOR_RED));
    public static final DeferredBlock<Block> wildwoodLog = registerBlock("wildwood_log", RotatedPillarBlock::new, WILDWOOD_LOG_PROPS.mapColor(MapColor.COLOR_BLUE));
    public static final DeferredBlock<Block> wildwoodWood = registerBlock("wildwood_wood", RotatedPillarBlock::new, WILDWOOD_LOG_PROPS.mapColor(MapColor.COLOR_BLUE));
    public static final DeferredBlock<Block> strippedWildwoodLog = registerBlock("stripped_wildwood_log", RotatedPillarBlock::new, WILDWOOD_LOG_PROPS);
    public static final DeferredBlock<Block> strippedWildwoodWood = registerBlock("stripped_wildwood_wood", RotatedPillarBlock::new, WILDWOOD_LOG_PROPS);
    public static final DeferredBlock<Block> wildwoodPlanks = registerBlock("wildwood_planks", Block::new, WILDWOOD_PLANKS_PROPS);
    public static final DeferredBlock<StairBlock> wildwoodStairs = registerBlock("wildwood_stairs", p -> new StairBlock(wildwoodPlanks.get().defaultBlockState(), p), WILDWOOD_PLANKS_PROPS);
    public static final DeferredBlock<SlabBlock> wildwoodSlab = registerBlock("wildwood_slab", SlabBlock::new, WILDWOOD_PLANKS_PROPS);
    public static final DeferredBlock<FenceBlock> wildwoodFence = registerBlock("wildwood_fence", FenceBlock::new, WILDWOOD_PLANKS_PROPS);
    public static final DeferredBlock<FenceGateBlock> wildwoodFenceGate = registerBlock("wildwood_fence_gate", p -> new FenceGateBlock(new WoodType("wildwood", BlockSetType.OAK), p), WILDWOOD_PLANKS_PROPS);
    public static final DeferredBlock<Block> wildwoodSapling = registerBlock("wildwood_sapling", p -> new SaplingBlock(new TreeGrower("wildwood", Optional.empty(), Optional.of(/*FeatureRegistry.WILDWOOD_TREE_KEY*/FeatureRegistry.DIVINE_TREE_KEY), Optional.empty()), p), Block.Properties.ofFullCopy(Blocks.OAK_SAPLING));
    public static final DeferredBlock<Block> wildwoodLeaves = registerBlock("wildwood_leaves", DivineLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.OAK_LEAVES).mapColor(MapColor.COLOR_LIGHT_BLUE));
    public static final DeferredBlock<DoorBlock> wildwoodDoor = registerBlock("wildwood_door", p -> new DoorBlock(BlockSetType.OAK, p), WILDWOOD_PLANKS_PROPS);
    public static final DeferredBlock<TrapDoorBlock> wildwoodTrapdoor = registerBlock("wildwood_trapdoor", p -> new TrapDoorBlock(BlockSetType.OAK, p), WILDWOOD_PLANKS_PROPS);
    public static final DeferredBlock<PressurePlateBlock> wildwoodPressurePlate = registerBlock("wildwood_pressure_plate", p -> new PressurePlateBlock(BlockSetType.OAK, p), WILDWOOD_PLANKS_PROPS);
    public static final DeferredBlock<ButtonBlock> wildwoodButton = registerBlock("wildwood_button", p -> new ButtonBlock(BlockSetType.OAK, 20, p), WILDWOOD_PLANKS_PROPS);
//    public static final DeferredBlock<StandingSignBlock> wildwoodSign = registerBlock("wildwood_sign", p -> new StandingSignBlock(WILDWOOD_WOOD_TYPE, p), WILDWOOD_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallSignBlock> wildwoodWallSign = registerBlock("wildwood_wall_sign", p -> new WallSignBlock(WILDWOOD_WOOD_TYPE, p), WILDWOOD_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<CeilingHangingSignBlock> wildwoodHangingSign = registerBlock("wildwood_hanging_sign", p -> new CeilingHangingSignBlock(WILDWOOD_WOOD_TYPE, p), WILDWOOD_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallHangingSignBlock> wildwoodHangingWallSign = registerBlock("wildwood_wall_hanging_sign", p -> new WallHangingSignBlock(WILDWOOD_WOOD_TYPE, p), WILDWOOD_PLANKS_PROPS.noCollision());
    public static final DeferredBlock<Block> apalachiaLog = registerBlock("apalachia_log", RotatedPillarBlock::new, APALACHIA_LOG_PROPS.mapColor(MapColor.WARPED_HYPHAE));
    public static final DeferredBlock<Block> apalachiaWood = registerBlock("apalachia_wood", RotatedPillarBlock::new, APALACHIA_LOG_PROPS.mapColor(MapColor.WARPED_HYPHAE));
    public static final DeferredBlock<Block> strippedApalachiaLog = registerBlock("stripped_apalachia_log", RotatedPillarBlock::new, APALACHIA_LOG_PROPS);
    public static final DeferredBlock<Block> strippedApalachiaWood = registerBlock("stripped_apalachia_wood", RotatedPillarBlock::new, APALACHIA_LOG_PROPS);
    public static final DeferredBlock<Block> apalachiaPlanks = registerBlock("apalachia_planks", Block::new, APALACHIA_PLANKS_PROPS);
    public static final DeferredBlock<StairBlock> apalachiaStairs = registerBlock("apalachia_stairs", p -> new StairBlock(apalachiaPlanks.get().defaultBlockState(), p), APALACHIA_PLANKS_PROPS);
    public static final DeferredBlock<SlabBlock> apalachiaSlab = registerBlock("apalachia_slab", SlabBlock::new, APALACHIA_PLANKS_PROPS);
    public static final DeferredBlock<FenceBlock> apalachiaFence = registerBlock("apalachia_fence", FenceBlock::new, APALACHIA_PLANKS_PROPS);
    public static final DeferredBlock<FenceGateBlock> apalachiaFenceGate = registerBlock("apalachia_fence_gate", p -> new FenceGateBlock(new WoodType("apalachia", BlockSetType.WARPED), p), APALACHIA_PLANKS_PROPS);
    public static final DeferredBlock<Block> apalachiaSapling = registerBlock("apalachia_sapling", p -> new SaplingBlock(new TreeGrower("apalachia", Optional.empty(), Optional.of(/*FeatureRegistry.APALACHIA_TREE_KEY*/FeatureRegistry.DIVINE_TREE_KEY), Optional.empty()), p), Block.Properties.ofFullCopy(Blocks.WARPED_FUNGUS));
    public static final DeferredBlock<Block> apalachiaLeaves = registerBlock("apalachia_leaves", DivineLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.WARPED_WART_BLOCK).mapColor(MapColor.COLOR_MAGENTA));
    public static final DeferredBlock<DoorBlock> apalachiaDoor = registerBlock("apalachia_door", p -> new DoorBlock(BlockSetType.WARPED, p), APALACHIA_PLANKS_PROPS);
    public static final DeferredBlock<TrapDoorBlock> apalachiaTrapdoor = registerBlock("apalachia_trapdoor", p -> new TrapDoorBlock(BlockSetType.WARPED, p), APALACHIA_PLANKS_PROPS);
    public static final DeferredBlock<PressurePlateBlock> apalachiaPressurePlate = registerBlock("apalachia_pressure_plate", p -> new PressurePlateBlock(BlockSetType.WARPED, p), APALACHIA_PLANKS_PROPS);
    public static final DeferredBlock<ButtonBlock> apalachiaButton = registerBlock("apalachia_button", p -> new ButtonBlock(BlockSetType.WARPED, 20, p), APALACHIA_PLANKS_PROPS);
//    public static final DeferredBlock<StandingSignBlock> apalachiaSign = registerBlock("apalachia_sign", p -> new StandingSignBlock(APALACHIA_WOOD_TYPE, p), APALACHIA_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallSignBlock> apalachiaWallSign = registerBlock("apalachia_wall_sign", p -> new WallSignBlock(APALACHIA_WOOD_TYPE, p), APALACHIA_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<CeilingHangingSignBlock> apalachiaHangingSign = registerBlock("apalachia_hanging_sign", p -> new CeilingHangingSignBlock(APALACHIA_WOOD_TYPE, p), APALACHIA_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallHangingSignBlock> apalachiaHangingWallSign = registerBlock("apalachia_wall_hanging_sign", p -> new WallHangingSignBlock(APALACHIA_WOOD_TYPE, p), APALACHIA_PLANKS_PROPS.noCollision());
    public static final DeferredBlock<Block> skythernLog = registerBlock("skythern_log", RotatedPillarBlock::new, SKYTHERN_LOG_PROPS.mapColor(MapColor.COLOR_LIGHT_GRAY));
    public static final DeferredBlock<Block> skythernWood = registerBlock("skythern_wood", RotatedPillarBlock::new, SKYTHERN_LOG_PROPS.mapColor(MapColor.COLOR_LIGHT_GRAY));
    public static final DeferredBlock<Block> strippedSkythernLog = registerBlock("stripped_skythern_log", RotatedPillarBlock::new, SKYTHERN_LOG_PROPS);
    public static final DeferredBlock<Block> strippedSkythernWood = registerBlock("stripped_skythern_wood", RotatedPillarBlock::new, SKYTHERN_LOG_PROPS);
    public static final DeferredBlock<Block> skythernPlanks = registerBlock("skythern_planks", Block::new, SKYTHERN_PLANKS_PROPS);
    public static final DeferredBlock<StairBlock> skythernStairs = registerBlock("skythern_stairs", p -> new StairBlock(skythernPlanks.get().defaultBlockState(), p), SKYTHERN_PLANKS_PROPS);
    public static final DeferredBlock<SlabBlock> skythernSlab = registerBlock("skythern_slab", SlabBlock::new, SKYTHERN_PLANKS_PROPS);
    public static final DeferredBlock<FenceBlock> skythernFence = registerBlock("skythern_fence", FenceBlock::new, SKYTHERN_PLANKS_PROPS);
    public static final DeferredBlock<FenceGateBlock> skythernFenceGate = registerBlock("skythern_fence_gate", p -> new FenceGateBlock(new WoodType("skythern", BlockSetType.WARPED), p), SKYTHERN_PLANKS_PROPS);
    public static final DeferredBlock<Block> skythernSapling = registerBlock("skythern_sapling", p -> new SaplingBlock(new TreeGrower("skythern", Optional.empty(), Optional.of(/*FeatureRegistry.SKYTHERN_TREE_KEY*/FeatureRegistry.DIVINE_TREE_KEY), Optional.empty()), p), Block.Properties.ofFullCopy(Blocks.WARPED_ROOTS));
    public static final DeferredBlock<Block> skythernLeaves = registerBlock("skythern_leaves", DivineLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.WARPED_WART_BLOCK).mapColor(MapColor.COLOR_LIGHT_GRAY));
    public static final DeferredBlock<DoorBlock> skythernDoor = registerBlock("skythern_door", p -> new DoorBlock(BlockSetType.WARPED, p), SKYTHERN_PLANKS_PROPS);
    public static final DeferredBlock<TrapDoorBlock> skythernTrapdoor = registerBlock("skythern_trapdoor", p -> new TrapDoorBlock(BlockSetType.WARPED, p), SKYTHERN_PLANKS_PROPS);
    public static final DeferredBlock<PressurePlateBlock> skythernPressurePlate = registerBlock("skythern_pressure_plate", p -> new PressurePlateBlock(BlockSetType.WARPED, p), SKYTHERN_PLANKS_PROPS);
    public static final DeferredBlock<ButtonBlock> skythernButton = registerBlock("skythern_button", p -> new ButtonBlock(BlockSetType.WARPED, 20, p), SKYTHERN_PLANKS_PROPS);
//    public static final DeferredBlock<StandingSignBlock> skythernSign = registerBlock("skythern_sign", p -> new StandingSignBlock(SKYTHERN_WOOD_TYPE, p), SKYTHERN_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallSignBlock> skythernWallSign = registerBlock("skythern_wall_sign", p -> new WallSignBlock(SKYTHERN_WOOD_TYPE, p), SKYTHERN_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<CeilingHangingSignBlock> skythernHangingSign = registerBlock("skythern_hanging_sign", p -> new CeilingHangingSignBlock(SKYTHERN_WOOD_TYPE, p), SKYTHERN_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallHangingSignBlock> skythernHangingWallSign = registerBlock("skythern_wall_hanging_sign", p -> new WallHangingSignBlock(SKYTHERN_WOOD_TYPE, p), SKYTHERN_PLANKS_PROPS.noCollision());
    public static final DeferredBlock<Block> mortumLog = registerBlock("mortum_log", RotatedPillarBlock::new, MORTUM_LOG_PROPS);
    public static final DeferredBlock<Block> mortumWood = registerBlock("mortum_wood", RotatedPillarBlock::new, MORTUM_LOG_PROPS);
    public static final DeferredBlock<Block> strippedMortumLog = registerBlock("stripped_mortum_log", RotatedPillarBlock::new, MORTUM_LOG_PROPS);
    public static final DeferredBlock<Block> strippedMortumWood = registerBlock("stripped_mortum_wood", RotatedPillarBlock::new, MORTUM_LOG_PROPS);
    public static final DeferredBlock<Block> mortumPlanks = registerBlock("mortum_planks", Block::new, MORTUM_PLANKS_PROPS);
    public static final DeferredBlock<StairBlock> mortumStairs = registerBlock("mortum_stairs", p -> new StairBlock(mortumPlanks.get().defaultBlockState(), p), MORTUM_PLANKS_PROPS);
    public static final DeferredBlock<SlabBlock> mortumSlab = registerBlock("mortum_slab", SlabBlock::new, MORTUM_PLANKS_PROPS);
    public static final DeferredBlock<FenceBlock> mortumFence = registerBlock("mortum_fence", FenceBlock::new, MORTUM_PLANKS_PROPS);
    public static final DeferredBlock<FenceGateBlock> mortumFenceGate = registerBlock("mortum_fence_gate", p -> new FenceGateBlock(new WoodType("mortum", BlockSetType.DARK_OAK), p), MORTUM_PLANKS_PROPS);
    public static final DeferredBlock<Block> mortumSapling = registerBlock("mortum_sapling", p -> new SaplingBlock(new TreeGrower("mortum", Optional.empty(), Optional.of(/*FeatureRegistry.MORTUM_TREE_KEY*/FeatureRegistry.DIVINE_TREE_KEY), Optional.empty()), p), Block.Properties.ofFullCopy(Blocks.DARK_OAK_SAPLING));
    public static final DeferredBlock<Block> mortumLeaves = registerBlock("mortum_leaves", DivineLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.DARK_OAK_LEAVES).mapColor(MapColor.COLOR_BLACK));
    public static final DeferredBlock<DoorBlock> mortumDoor = registerBlock("mortum_door", p -> new DoorBlock(BlockSetType.DARK_OAK, p), MORTUM_PLANKS_PROPS);
    public static final DeferredBlock<TrapDoorBlock> mortumTrapdoor = registerBlock("mortum_trapdoor", p -> new TrapDoorBlock(BlockSetType.DARK_OAK, p), MORTUM_PLANKS_PROPS);
    public static final DeferredBlock<PressurePlateBlock> mortumPressurePlate = registerBlock("mortum_pressure_plate", p -> new PressurePlateBlock(BlockSetType.DARK_OAK, p), MORTUM_PLANKS_PROPS);
    public static final DeferredBlock<ButtonBlock> mortumButton = registerBlock("mortum_button", p -> new ButtonBlock(BlockSetType.DARK_OAK, 20, p), MORTUM_PLANKS_PROPS);
//    public static final DeferredBlock<StandingSignBlock> mortumSign = registerBlock("mortum_sign", p -> new StandingSignBlock(MORTUM_WOOD_TYPE, p), MORTUM_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallSignBlock> mortumWallSign = registerBlock("mortum_wall_sign", p -> new WallSignBlock(MORTUM_WOOD_TYPE, p), MORTUM_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<CeilingHangingSignBlock> mortumHangingSign = registerBlock("mortum_hanging_sign", p -> new CeilingHangingSignBlock(MORTUM_WOOD_TYPE, p), MORTUM_PLANKS_PROPS.noCollision());
//    public static final DeferredBlock<WallHangingSignBlock> mortumHangingWallSign = registerBlock("mortum_wall_hanging_sign", p -> new WallHangingSignBlock(MORTUM_WOOD_TYPE, p), MORTUM_PLANKS_PROPS.noCollision());
    public static final DeferredBlock<Block> firewoodLeaves = registerBlock("firewood_leaves", DivineLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.OAK_LEAVES).mapColor(MapColor.CRIMSON_NYLIUM).sound(SoundType.GRASS));
    public static final DeferredBlock<Block> firewoodLog = registerBlock("firewood_log", p -> new VetheaLog(MapColor.TERRACOTTA_ORANGE, MapColor.COLOR_RED, SoundType.WOOD, p), Block.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> firewoodWood = registerBlock("firewood_wood", p -> new VetheaLog(MapColor.COLOR_RED, SoundType.WOOD, p), Block.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> strippedFirewoodLog = registerBlock("stripped_firewood_log", p -> new VetheaLog(MapColor.TERRACOTTA_ORANGE, SoundType.WOOD, p), Block.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> strippedFirewoodWood = registerBlock("stripped_firewood_wood", p -> new VetheaLog(MapColor.TERRACOTTA_ORANGE, SoundType.WOOD, p), Block.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> dreamwoodLeaves = registerBlock("dreamwood_leaves", DivineLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.OAK_LEAVES).mapColor(MapColor.COLOR_CYAN).sound(SoundType.GRASS));
    public static final DeferredBlock<Block> dreamwoodLog = registerBlock("dreamwood_log", p -> new VetheaLog(MapColor.COLOR_LIGHT_BLUE, MapColor.COLOR_CYAN, SoundType.WOOD, p), Block.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> dreamwoodWood = registerBlock("dreamwood_wood", p -> new VetheaLog(MapColor.COLOR_CYAN, SoundType.WOOD, p), Block.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> strippedDreamwoodLog = registerBlock("stripped_dreamwood_log", p -> new VetheaLog(MapColor.COLOR_LIGHT_BLUE, SoundType.WOOD, p), Block.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> strippedDreamwoodWood = registerBlock("stripped_dreamwood_wood", p -> new VetheaLog(MapColor.COLOR_LIGHT_BLUE, SoundType.WOOD, p), Block.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> hyrewoodLeaves = registerBlock("hyrewood_leaves", DivineLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.OAK_LEAVES).mapColor(MapColor.COLOR_BLUE).sound(SoundType.GRASS));
    public static final DeferredBlock<Block> hyrewoodLog = registerBlock("hyrewood_log", p -> new VetheaLog(MapColor.COLOR_BLUE, SoundType.WOOD, p), Block.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> hyrewoodWood = registerBlock("hyrewood_wood", p -> new VetheaLog(MapColor.COLOR_BLUE, SoundType.WOOD, p), Block.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> strippedHyrewoodLog = registerBlock("stripped_hyrewood_log", p -> new VetheaLog(MapColor.COLOR_BLUE, SoundType.WOOD, p), Block.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> strippedHyrewoodWood = registerBlock("stripped_hyrewood_wood", p -> new VetheaLog(MapColor.COLOR_BLUE, SoundType.WOOD, p), Block.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> mintwoodLeaves = registerBlock("mintwood_leaves", DivineLeavesBlock::new, Block.Properties.ofFullCopy(Blocks.OAK_LEAVES).mapColor(MapColor.WARPED_WART_BLOCK).sound(SoundType.GRASS));
    public static final DeferredBlock<Block> mintwoodLog = registerBlock("mintwood_log", p -> new VetheaLog(MapColor.DIAMOND, MapColor.WARPED_WART_BLOCK, SoundType.NETHER_WOOD, p), Block.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> mintwoodWood = registerBlock("mintwood_wood", p -> new VetheaLog(MapColor.WARPED_WART_BLOCK, SoundType.NETHER_WOOD, p), Block.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> strippedMintwoodLog = registerBlock("stripped_mintwood_log", p -> new VetheaLog(MapColor.DIAMOND, MapColor.COLOR_CYAN, SoundType.NETHER_WOOD, p), Block.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> strippedMintwoodWood = registerBlock("stripped_mintwood_wood", p -> new VetheaLog(MapColor.COLOR_CYAN, SoundType.NETHER_WOOD, p), Block.Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> checker = registerBlock("checker", BlockModWool::new, Block.Properties.ofFullCopy(Blocks.WOOL.white()).mapColor(MapColor.WOOL));
    public static final DeferredBlock<Block> rainbowWool = registerBlock("rainbow_wool", BlockModWool::new, Block.Properties.ofFullCopy(Blocks.WOOL.white()).mapColor(MapColor.COLOR_PURPLE));
    public static final DeferredBlock<Block> fancyWool = registerBlock("fancy_wool", BlockModWool::new, Block.Properties.ofFullCopy(Blocks.WOOL.white()).mapColor(MapColor.CRIMSON_HYPHAE));
    public static final DeferredBlock<CarpetBlock> rainbowWoolCarpet = registerBlock("rainbow_carpet",p -> new CarpetBlock(p),Block.Properties.ofFullCopy(Blocks.CARPET.red()).mapColor(MapColor.COLOR_PURPLE));
    public static final DeferredBlock<Block> workshopCarpet = registerBlock("workshop_carpet",BlockModWool::new,Block.Properties.ofFullCopy(Blocks.WOOL.white()).mapColor(MapColor.TERRACOTTA_RED));
    public static final DeferredBlock<Block> asphalt = registerBlock("asphalt", Block::new, ASPHALT_PROPS);
    public static final DeferredBlock<StairBlock> asphaltStairs = registerBlock("asphalt_stairs",p -> new StairBlock(asphalt.get().defaultBlockState(), p),ASPHALT_PROPS);
    public static final DeferredBlock<SlabBlock> asphaltSlab = registerBlock("asphalt_slab",SlabBlock::new,ASPHALT_PROPS);
    public static final DeferredBlock<Block> darkstone = registerBlock("darkstone", Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).strength(4.0F));
    public static final DeferredBlock<Block> bleedingObsidian = registerBlock("bleeding_obsidian", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(10.0F));
    public static final DeferredBlock<Block> shiningObsidian = registerBlock("shining_obsidian", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(10.0F));
    public static final DeferredBlock<Block> glitteringObsidian = registerBlock("glittering_obsidian", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(10.0F));
    public static final DeferredBlock<Block> seepingObsidian = registerBlock("seeping_obsidian", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(10.0F));
    public static final DeferredBlock<Block> vwoopingObsidian = registerBlock("vwooping_obsidian", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(10.0F));
    public static final DeferredBlock<Block> broodingObsidian = registerBlock("brooding_obsidian", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(10.0F));
    public static final DeferredBlock<Block> milkStoneBricks = registerBlock("milk_stone_bricks", Block::new, Block.Properties.of().mapColor(MapColor.WOOL).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> ironBricks = registerBlock("iron_bricks", Block::new, Block.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> torriditeBricks = registerBlock("torridite_bricks", Block::new, Block.Properties.of().mapColor(MapColor.CRIMSON_NYLIUM).requiresCorrectToolForDrops().strength(2.0F, 1200.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> lavaBricks = registerBlock("lava_bricks", Block::new, Block.Properties.of().mapColor(MapColor.FIRE).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM).lightLevel((state) -> 6));
    public static final DeferredBlock<Block> realmiteBricks = registerBlock("realmite_bricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> goldBricks = registerBlock("gold_bricks", Block::new, Block.Properties.of().mapColor(MapColor.GOLD).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> arlemiteBricks = registerBlock("arlemite_bricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> greenBricks = registerBlock("green_bricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GREEN).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> darkstoneBricks = registerBlock("darkstone_bricks", Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).strength(6.0F, 1200.0F).sound(SoundType.NETHER_BRICKS));
    public static final DeferredBlock<Block> aquatonicBricks = registerBlock("aquatonic_bricks", Block::new, Block.Properties.of().mapColor(MapColor.WARPED_NYLIUM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> diamondBricks = registerBlock("diamond_bricks", Block::new, Block.Properties.of().mapColor(MapColor.DIAMOND).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> lapisLazuliBricks = registerBlock("lapis_lazuli_bricks", Block::new, Block.Properties.of().mapColor(MapColor.LAPIS).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> purpleBricks = registerBlock("purple_bricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_PURPLE).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> magentaBricks = registerBlock("magenta_bricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_MAGENTA).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> bloodgemBricks = registerBlock("bloodgem_bricks", Block::new, Block.Properties.of().mapColor(MapColor.CRIMSON_STEM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> minibricks = registerBlock("minibricks", Block::new, Block.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> bedrockMinibricks = registerBlock("bedrock_minibricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(6.0F, 1200.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> torriditeMinibricks = registerBlock("torridite_minibricks", Block::new, Block.Properties.of().mapColor(MapColor.CRIMSON_NYLIUM).requiresCorrectToolForDrops().strength(2.0F, 1200.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> realmiteMinibricks = registerBlock("realmite_minibricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> arlemiteMinibricks = registerBlock("arlemite_minibricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> rupeeMinibricks = registerBlock("rupee_minibricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> bloodgemMinibricks = registerBlock("bloodgem_minibricks", Block::new, Block.Properties.of().mapColor(MapColor.CRIMSON_STEM).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS).instrument(NoteBlockInstrument.BASEDRUM));
    public static final DeferredBlock<Block> frozenBricks = registerBlock("frozen_bricks", Block::new, Block.Properties.of().mapColor(MapColor.GLOW_LICHEN).strength(2.0F, 6.0F));
    public static final DeferredBlock<StairBlock> frozenBrickStairs = registerBlock("frozen_brick_stairs", p -> new StairBlock(frozenBricks.get().defaultBlockState(), p), Block.Properties.of().mapColor(MapColor.GLOW_LICHEN).strength(2.0F, 6.0F));
    public static final DeferredBlock<SlabBlock> frozenBrickSlab = registerBlock("frozen_brick_slab", SlabBlock::new, Block.Properties.of().mapColor(MapColor.GLOW_LICHEN).strength(2.0F, 6.0F));
    public static final DeferredBlock<WallBlock> frozenBrickWall = registerBlock("frozen_brick_wall", WallBlock::new, Block.Properties.of().mapColor(MapColor.GLOW_LICHEN).strength(2.0F, 6.0F));
    public static final DeferredBlock<PressurePlateBlock> frozenBrickPressurePlate = registerBlock("frozen_brick_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p), Block.Properties.of().mapColor(MapColor.GLOW_LICHEN).strength(2.0F, 6.0F));
    public static final DeferredBlock<ButtonBlock> frozenBrickButton = registerBlock("frozen_brick_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), Block.Properties.of().mapColor(MapColor.GLOW_LICHEN).strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> snowBricks = registerBlock("snow_bricks", Block::new, Block.Properties.of().mapColor(MapColor.SNOW).strength(0.5F));
    public static final DeferredBlock<Block> icyBricks = registerBlock("icy_bricks", Block::new, Block.Properties.of().mapColor(MapColor.ICE).strength(50.0F, 1200.0F).friction(0.98F));
    public static final DeferredBlock<Block> runicIcyBricks = registerBlock("runic_icy_bricks", Block::new, Block.Properties.of().mapColor(MapColor.ICE).strength(50.0F, 1200.0F).friction(0.98F));
    public static final DeferredBlock<Block> polishedCobaltite = registerBlock("polished_cobaltite", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).strength(3.0F, 6.0F));
    public static final DeferredBlock<StairBlock> polishedCobaltiteStairs = registerBlock("polished_cobaltite_stairs", p -> new StairBlock(polishedCobaltite.get().defaultBlockState(), p), Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).strength(3.0F, 6.0F));
    public static final DeferredBlock<SlabBlock> polishedCobaltiteSlab = registerBlock("polished_slab", SlabBlock::new, Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).strength(3.0F, 6.0F));
    public static final DeferredBlock<WallBlock> polishedCobaltiteWall = registerBlock("polished_cobaltite_wall", WallBlock::new, Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).strength(3.0F, 6.0F));
    public static final DeferredBlock<PressurePlateBlock> polishedCobaltitePressurePlate = registerBlock("polished_cobaltite_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p), Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).strength(3.0F, 6.0F));
    public static final DeferredBlock<ButtonBlock> polishedCobaltiteButton = registerBlock("polished_cobaltite_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).strength(3.0F, 6.0F));
    public static final DeferredBlock<Block> workshopBookcase = registerBlock("workshop_bookcase", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> coalstoneBricks = registerBlock("coalstone_bricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<StairBlock> coalstoneBrickStairs = registerBlock("coalstone_brick_stairs", p -> new StairBlock(coalstoneBricks.get().defaultBlockState(), p), Block.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<SlabBlock> coalstoneBrickSlab = registerBlock("coalstone_brick_slab", SlabBlock::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<WallBlock> coalstoneBrickWall = registerBlock("coalstone_brick_wall", WallBlock::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<PressurePlateBlock> coalstoneBrickPressurePlate = registerBlock("coalstone_brick_pressure_plate", p -> new PressurePlateBlock(BlockSetType.POLISHED_BLACKSTONE, p), Block.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<ButtonBlock> coalstoneBrickButton = registerBlock("coalstone_brick_button", p -> new ButtonBlock(BlockSetType.POLISHED_BLACKSTONE, 20, p), Block.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> chiseledCoalstoneBricks = registerBlock("chiseled_coalstone_bricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> polishedCoalstone = registerBlock("polished_coalstone", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<StairBlock> polishedCoalstoneStairs = registerBlock("polished_coalstone_stairs", p -> new StairBlock(polishedCoalstone.get().defaultBlockState(), p), Block.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<SlabBlock> polishedCoalstoneSlab = registerBlock("polished_coalstone_slab", SlabBlock::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<WallBlock> polishedCoalstoneWall = registerBlock("polished_coalstone_wall", WallBlock::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<PressurePlateBlock> polishedCoalstonePressurePlate = registerBlock("polished_coalstone_pressure_plate", p -> new PressurePlateBlock(BlockSetType.POLISHED_BLACKSTONE, p), Block.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<ButtonBlock> polishedCoalstoneButton = registerBlock("polished_coalstone_button", p -> new ButtonBlock(BlockSetType.POLISHED_BLACKSTONE, 20, p), Block.Properties.of().mapColor(MapColor.COLOR_GRAY).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> cutOxdrite = registerBlock("cut_oxdrite",p -> new WaterloggedTransparentBlock(p),Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_BROWN).strength(3.0F, 6.0F).sound(SoundType.COPPER_GRATE).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).isRedstoneConductor((state, getter, pos) -> false).isValidSpawn((state, getter, pos, entityType) -> false));
    public static final DeferredBlock<StairBlock> cutOxdriteStairs = registerBlock("cut_oxdrite_stairs",p -> new StairBlock(cutOxdrite.get().defaultBlockState(), p),Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_BROWN).strength(3.0F, 6.0F).sound(SoundType.COPPER_GRATE).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).isRedstoneConductor((state, getter, pos) -> false).isValidSpawn((state, getter, pos, entityType) -> false));
    public static final DeferredBlock<SlabBlock> cutOxdriteSlab = registerBlock("cut_oxdrite_slab",SlabBlock::new,Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_BROWN).strength(3.0F, 6.0F).sound(SoundType.COPPER_GRATE).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).isRedstoneConductor((state, getter, pos) -> false).isValidSpawn((state, getter, pos, entityType) -> false));
    public static final DeferredBlock<WallBlock> cutOxdriteWall = registerBlock("cut_oxdrite_wall",WallBlock::new,Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_BROWN).strength(3.0F, 6.0F).sound(SoundType.COPPER_GRATE).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).isRedstoneConductor((state, getter, pos) -> false).isValidSpawn((state, getter, pos, entityType) -> false));
    public static final DeferredBlock<PressurePlateBlock> cutOxdritePressurePlate = registerBlock("cut_oxdrite_pressure_plate",p -> new PressurePlateBlock(BlockSetType.IRON, p),Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_BROWN).strength(3.0F, 6.0F).sound(SoundType.COPPER_GRATE).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).isRedstoneConductor((state, getter, pos) -> false).isValidSpawn((state, getter, pos, entityType) -> false));
    public static final DeferredBlock<ButtonBlock> cutOxdriteButton = registerBlock("cut_oxdrite_button",p -> new ButtonBlock(BlockSetType.IRON, 20, p),Block.Properties.ofFullCopy(Blocks.IRON_BLOCK).mapColor(MapColor.COLOR_BROWN).strength(3.0F, 6.0F).sound(SoundType.COPPER_GRATE).noOcclusion().isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).isRedstoneConductor((state, getter, pos) -> false).isValidSpawn((state, getter, pos, entityType) -> false));
    public static final DeferredBlock<Block> arcaniteTiles = registerBlock("arcanite_tiles", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<StairBlock> arcaniteTileStairs = registerBlock("arcanite_tile_stairs", p -> new StairBlock(arcaniteTiles.get().defaultBlockState(), p), Block.Properties.of().mapColor(MapColor.COLOR_CYAN).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<SlabBlock> arcaniteTileSlab = registerBlock("arcanite_tile_slab", SlabBlock::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<WallBlock> arcaniteTileWall = registerBlock("arcanite_tile_wall", WallBlock::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<PressurePlateBlock> arcaniteTilePressurePlate = registerBlock("arcanite_tile_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p), Block.Properties.of().mapColor(MapColor.COLOR_CYAN).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<ButtonBlock> arcaniteTileButton = registerBlock("arcanite_tile_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), Block.Properties.of().mapColor(MapColor.COLOR_CYAN).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> ancientBricks = registerBlock("ancient_bricks", Block::new, Block.Properties.of().mapColor(MapColor.WARPED_NYLIUM).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<StairBlock> ancientBrickStairs = registerBlock("ancient_brick_stairs", p -> new StairBlock(ancientBricks.get().defaultBlockState(), p), Block.Properties.of().mapColor(MapColor.WARPED_NYLIUM).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<SlabBlock> ancientBrickSlab = registerBlock("ancient_brick_slab", SlabBlock::new, Block.Properties.of().mapColor(MapColor.WARPED_NYLIUM).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<WallBlock> ancientBrickWall = registerBlock("ancient_brick_wall", WallBlock::new, Block.Properties.of().mapColor(MapColor.WARPED_NYLIUM).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<BlockArcanaDoor> ancientBrickDoor = registerBlock("ancient_brick_door",p -> new BlockArcanaDoor(MapColor.WARPED_NYLIUM, ancient_key.getId(), BlockSetType.IRON, p),Block.Properties.of().mapColor(MapColor.WARPED_NYLIUM).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> lightDegradedBrick = registerBlock("light_degraded_brick", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> darkDegradedBrick = registerBlock("dark_degraded_brick", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> degradedBricks = registerBlock("degraded_bricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<StairBlock> degradedBrickStairs = registerBlock("degraded_brick_stairs", p -> new StairBlock(degradedBricks.get().defaultBlockState(), p), Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<SlabBlock> degradedBrickSlab = registerBlock("degraded_brick_slab", SlabBlock::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<WallBlock> degradedBrickWall = registerBlock("degraded_brick_wall", WallBlock::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<BlockArcanaDoor> degradedBrickDoor = registerBlock("degraded_brick_door",p -> new BlockArcanaDoor(MapColor.COLOR_BLUE, degraded_key.getId(), BlockSetType.IRON, p),Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> ancientTile = registerBlock("ancient_tile", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<RotatedPillarBlock> arcaniumMetal = registerBlock("arcanium_metal", RotatedPillarBlock::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> arcaniumPower = registerBlock("arcanium_power", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> battleBricks = registerBlock("battle_bricks", Block::new, Block.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> gildedBricks = registerBlock("gilded_bricks", Block::new, Block.Properties.ofFullCopy(Blocks.GILDED_BLACKSTONE).mapColor(MapColor.TERRACOTTA_YELLOW).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> ancientBricksBreakable = registerBlock("ancient_bricks_breakable", Block::new, Block.Properties.of().mapColor(MapColor.WARPED_NYLIUM).strength(2.0F, 6.0F));
    public static final DeferredBlock<StairBlock> ancientBrickStairsBreakable = registerBlock("ancient_brick_stairs_breakable", p -> new StairBlock(ancientBricksBreakable.get().defaultBlockState(), p), Block.Properties.of().mapColor(MapColor.WARPED_NYLIUM).strength(2.0F, 6.0F));
    public static final DeferredBlock<SlabBlock> ancientBrickSlabBreakable = registerBlock("ancient_brick_slab_breakable", SlabBlock::new, Block.Properties.of().mapColor(MapColor.WARPED_NYLIUM).strength(2.0F, 6.0F));
    public static final DeferredBlock<WallBlock> ancientBrickWallBreakable = registerBlock("ancient_brick_wall_breakable", WallBlock::new, Block.Properties.of().mapColor(MapColor.WARPED_NYLIUM).strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> dungeonBookshelf = registerBlock("dungeon_bookshelf", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> degradedBricksBreakable = registerBlock("degraded_bricks_breakable", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(2.0F, 6.0F));
    public static final DeferredBlock<StairBlock> degradedBrickStairsBreakable = registerBlock("degraded_brick_stairs_breakable", p -> new StairBlock(degradedBricksBreakable.get().defaultBlockState(), p), Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(2.0F, 6.0F));
    public static final DeferredBlock<SlabBlock> degradedBrickSlabBreakable = registerBlock("degraded_brick_slab_breakable", SlabBlock::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(2.0F, 6.0F));
    public static final DeferredBlock<WallBlock> degradedBrickWallBreakable = registerBlock("degraded_brick_wall_breakable", WallBlock::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> ancientTileBreakable = registerBlock("ancient_tile_breakable", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(2.0F, 6.0F));
    public static final DeferredBlock<RotatedPillarBlock> arcaniumMetalBreakable = registerBlock("arcanium_metal_breakable", RotatedPillarBlock::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> arcaniumPowerBreakable = registerBlock("arcanium_power_breakable", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(2.0F, 6.0F));
    public static final DeferredBlock<LadderBlock> arcaniteTubes = registerBlock("arcanite_tubes", LadderBlock::new, Block.Properties.of().strength(0.4F).sound(SoundType.WOOD).noOcclusion());
    public static final DeferredBlock<LadderBlock> arcaniteLadder = registerBlock("arcanite_ladder", LadderBlock::new, Block.Properties.of().strength(0.4F).sound(SoundType.WOOD).noOcclusion());
    public static final DeferredBlock<BlockArcanaDoor> soulSludgeDoor = registerBlock("soul_sludge_door",p -> new BlockArcanaDoor(MapColor.COLOR_GRAY, sludge_key.getId(), BlockSetType.IRON, p),Block.Properties.of().strength(5.0F, 1200.0F).noOcclusion());
    public static final DeferredBlock<BlockArcanaDoor> soulStoneDoor = registerBlock("soul_stone_door",p -> new BlockArcanaDoor(MapColor.TERRACOTTA_BLUE, soul_key.getId(), BlockSetType.IRON, p),Block.Properties.of().strength(5.0F, 1200.0F).noOcclusion());
    public static final DeferredBlock<Block> twilightBricks = registerBlock("twilight_bricks", Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<StairBlock> twilightBrickStairs = registerBlock("twilight_brick_stairs", p -> new StairBlock(twilightBricks.get().defaultBlockState(), p), Block.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<SlabBlock> twilightBrickSlab = registerBlock("twilight_brick_slab", SlabBlock::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<WallBlock> twilightBrickWall = registerBlock("twilight_brick_wall", WallBlock::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<PressurePlateBlock> twilightBrickPressurePlate = registerBlock("twilight_brick_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p), Block.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<ButtonBlock> twilightBrickButton = registerBlock("twilight_brick_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), Block.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> chiseledScorchalt = registerBlock("chiseled_scorchalt", Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> polishedScorchalt = registerBlock("polished_scorchalt", Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<StairBlock> polishedScorchaltStairs = registerBlock("polished_scorchalt_stairs", p -> new StairBlock(polishedScorchalt.get().defaultBlockState(), p), Block.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<SlabBlock> polishedScorchaltSlab = registerBlock("polished_scorchalt_slab", SlabBlock::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<WallBlock> polishedScorchaltWall = registerBlock("polished_scorchalt_wall", WallBlock::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<PressurePlateBlock> polishedScorchaltPressurePlate = registerBlock("polished_scorchalt_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p), Block.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<ButtonBlock> polishedScorchaltButton = registerBlock("polished_scorchalt_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), Block.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> polishedRayStone = registerBlock("polished_ray_stone", Block::new, Block.Properties.of().mapColor(MapColor.GOLD).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<StairBlock> polishedRayStoneStairs = registerBlock("polished_ray_stone_stairs", p -> new StairBlock(polishedRayStone.get().defaultBlockState(), p), Block.Properties.of().mapColor(MapColor.GOLD).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<SlabBlock> polishedRayStoneSlab = registerBlock("polished_ray_stone_slab", SlabBlock::new, Block.Properties.of().mapColor(MapColor.GOLD).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<WallBlock> polishedRayStoneWall = registerBlock("polished_ray_stone_wall", WallBlock::new, Block.Properties.of().mapColor(MapColor.GOLD).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<PressurePlateBlock> polishedRayStonePressurePlate = registerBlock("polished_ray_stone_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p), Block.Properties.of().mapColor(MapColor.GOLD).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<ButtonBlock> polishedRayStoneButton = registerBlock("polished_ray_stone_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), Block.Properties.of().mapColor(MapColor.GOLD).requiresCorrectToolForDrops().strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> edenBricks = registerBlock("eden_bricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> wildwoodBricks = registerBlock("wildwood_bricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> apalachiaBricks = registerBlock("apalachia_bricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_MAGENTA).strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> skythernBricks = registerBlock("skythern_bricks", Block::new, Block.Properties.of().mapColor(MapColor.WOOL).strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> mortumBricks = registerBlock("mortum_bricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> hallWall = registerBlock("hall_wall", Block::new, Block.Properties.of().mapColor(MapColor.NETHER).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> blueKarosBricks = registerBlock("blue_karos_bricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> blackKarosBricks = registerBlock("black_karos_bricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> cryptFloor = registerBlock("crypt_floor", Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> cryptWall = registerBlock("crypt_wall", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> chamberWall = registerBlock("chamber_wall", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> shiftedChamberWall = registerBlock("shifted_chamber_wall", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> stackedChamberWall = registerBlock("stacked_chamber_wall", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BROWN).strength(-1.0F, 3600000.0F));
    public static final DeferredBlock<Block> redDreamBricks = registerBlock("red_dream_bricks", Block::new, Block.Properties.of().mapColor(MapColor.CRIMSON_NYLIUM).strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> lightDreamBricks = registerBlock("light_dream_bricks", Block::new, Block.Properties.of().mapColor(MapColor.LAPIS).strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> darkDreamBricks = registerBlock("dark_dream_bricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> lunaBricks = registerBlock("luna_bricks", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(2.0F, 6.0F));
    public static final DeferredBlock<Block> metalCaging = registerBlock("metal_caging", Block::new,Block.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).requiresCorrectToolForDrops().strength(5.0F).sound(SoundType.METAL).noOcclusion());
    public static final DeferredBlock<DoorBlock> barredDoor = registerBlock("barred_door",p -> new DoorBlock(BlockSetType.IRON, p),Block.Properties.of().mapColor(MapColor.PLANT).strength(3.0F).noOcclusion());
    public static final DeferredBlock</*BlockHelioticBeam*/Block> helioticBeam = registerBlock("heliotic_beam",/*BlockHelioticBeam*/Block::new,Block.Properties.of().noOcclusion().lightLevel(s -> 15));
    public static final DeferredBlock<Block> steel = registerBlock("steel", Block::new, Block.Properties.of().mapColor(MapColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).instrument(NoteBlockInstrument.HARP));
    public static final DeferredBlock<Block> blackSteel = registerBlock("black_steel", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).instrument(NoteBlockInstrument.HARP));
    public static final DeferredBlock<Block> redSteel = registerBlock("red_steel", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).instrument(NoteBlockInstrument.HARP));
    public static final DeferredBlock<Block> orangeSteel = registerBlock("orange_steel", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).instrument(NoteBlockInstrument.HARP));
    public static final DeferredBlock<Block> yellowSteel = registerBlock("yellow_steel", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_YELLOW).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).instrument(NoteBlockInstrument.HARP));
    public static final DeferredBlock<Block> greenSteel = registerBlock("green_steel", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GREEN).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).instrument(NoteBlockInstrument.HARP));
    public static final DeferredBlock<Block> cyanSteel = registerBlock("cyan_steel", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).instrument(NoteBlockInstrument.HARP));
    public static final DeferredBlock<Block> blueSteel = registerBlock("blue_steel", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).instrument(NoteBlockInstrument.HARP));
    public static final DeferredBlock<Block> purpleSteel = registerBlock("purple_steel", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_PURPLE).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).instrument(NoteBlockInstrument.HARP));
    public static final DeferredBlock<Block> magentaSteel = registerBlock("magenta_steel", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_MAGENTA).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).instrument(NoteBlockInstrument.HARP));
    public static final DeferredBlock<DoorBlock> steelDoor = registerBlock("steel_door",p -> new DoorBlock(BlockSetType.IRON, p),Block.Properties.of().mapColor(MapColor.METAL).strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion());
    public static final DeferredBlock<Block> redCandyCane = registerBlock("red_candy_cane", p -> new BlockCandyCane(p), Block.Properties.of().mapColor(MapColor.COLOR_RED));
    public static final DeferredBlock<Block> yellowCandyCane = registerBlock("yellow_candy_cane", p -> new BlockCandyCane(p), Block.Properties.of().mapColor(MapColor.COLOR_YELLOW));
    public static final DeferredBlock<Block> greenCandyCane = registerBlock("green_candy_cane", p -> new BlockCandyCane(p), Block.Properties.of().mapColor(MapColor.EMERALD));
    public static final DeferredBlock<Block> blueCandyCane = registerBlock("blue_candy_cane", p -> new BlockCandyCane(p), Block.Properties.of().mapColor(MapColor.COLOR_BLUE));
    public static final DeferredBlock<Block> pinkCandyCane = registerBlock("pink_candy_cane", p -> new BlockCandyCane(p), Block.Properties.of().mapColor(MapColor.COLOR_MAGENTA));
    public static final DeferredBlock<Block> redFairyLights = registerBlock("red_fairy_lights", BlockLights::new, Block.Properties.of());
    public static final DeferredBlock<Block> yellowFairyLights = registerBlock("yellow_fairy_lights", BlockLights::new, Block.Properties.of());
    public static final DeferredBlock<Block> greenFairyLights = registerBlock("green_fairy_lights", BlockLights::new, Block.Properties.of());
    public static final DeferredBlock<Block> blueFairyLights = registerBlock("blue_fairy_lights", BlockLights::new, Block.Properties.of());
    public static final DeferredBlock<Block> purpleFairyLights = registerBlock("purple_fairy_lights", BlockLights::new, Block.Properties.of());
//    public static final DeferredBlock<Block> aquaTorch = registerBlock("aqua_torch", BlockAquaTorch::new, Block.Properties.ofFullCopy(Blocks.TORCH));
//    public static final DeferredBlock<Block> aquaWallTorch = registerBlock("aqua_wall_torch", BlockAquaWallTorch::new, Block.Properties.ofFullCopy(Blocks.WALL_TORCH));
//    public static final DeferredBlock<Block> arcaniumTorch = registerBlock("arcanium_torch", BlockModTorch::new, Block.Properties.ofFullCopy(Blocks.TORCH));
//    public static final DeferredBlock<Block> arcaniumWallTorch = registerBlock("arcanium_wall_torch", BlockModWallTorch::new, Block.Properties.ofFullCopy(Blocks.WALL_TORCH));
//    public static final DeferredBlock<Block> skeletonTorch = registerBlock("skeleton_torch", p -> new TorchBlock(ParticleTypes.FLAME, p), Block.Properties.ofFullCopy(Blocks.TORCH).sound(SoundType.BONE_BLOCK));
//    public static final DeferredBlock<Block> skeletonWallTorch = registerBlock("skeleton_wall_torch", p -> new WallTorchBlock(ParticleTypes.FLAME, p), Block.Properties.ofFullCopy(Blocks.WALL_TORCH).sound(SoundType.BONE_BLOCK));
    public static final DeferredBlock<Block> moltenLamp = registerBlock("molten_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.COLOR_ORANGE).sound(SoundType.GLASS));
    public static final DeferredBlock<Block> divineLamp = registerBlock("divine_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.TERRACOTTA_YELLOW).sound(SoundType.GLASS));
    public static final DeferredBlock<Block> jungleLamp = registerBlock("jungle_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.GLASS));
    public static final DeferredBlock<Block> terranLamp = registerBlock("terran_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.EMERALD).sound(SoundType.GLASS));
    public static final DeferredBlock<Block> iceLamp = registerBlock("ice_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.COLOR_CYAN).sound(SoundType.GLASS));
    public static final DeferredBlock<Block> soulfireLamp = registerBlock("soulfire_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.WATER).sound(SoundType.GLASS));
    public static final DeferredBlock<Block> enderStoneLamp = registerBlock("ender_stone_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.GLASS));
    public static final DeferredBlock<Block> milkyLamp = registerBlock("milky_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.QUARTZ).sound(SoundType.METAL));
    public static final DeferredBlock<Block> edenLamp = registerBlock("eden_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.COLOR_RED).sound(SoundType.METAL));
    public static final DeferredBlock<Block> torriditeLamp = registerBlock("torridite_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.CRIMSON_NYLIUM).sound(SoundType.METAL));
    public static final DeferredBlock<Block> lavaLamp = registerBlock("lava_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.FIRE).sound(SoundType.METAL));
    public static final DeferredBlock<Block> drakenLamp = registerBlock("draken_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.COLOR_ORANGE).sound(SoundType.METAL));
    public static final DeferredBlock<Block> realmiteLamp = registerBlock("realmite_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.COLOR_ORANGE).sound(SoundType.METAL));
    public static final DeferredBlock<Block> blazeLamp = registerBlock("blaze_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.COLOR_YELLOW).sound(SoundType.METAL));
    public static final DeferredBlock<Block> goldLamp = registerBlock("gold_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.GOLD).sound(SoundType.METAL));
    public static final DeferredBlock<Block> arlemiteLamp = registerBlock("arlemite_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.METAL));
    public static final DeferredBlock<Block> krakenLamp = registerBlock("kraken_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.WARPED_NYLIUM).sound(SoundType.METAL));
    public static final DeferredBlock<Block> diamondLamp = registerBlock("diamond_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.DIAMOND).sound(SoundType.METAL));
    public static final DeferredBlock<Block> rupeeLamp = registerBlock("rupee_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.METAL));
    public static final DeferredBlock<Block> lapisLazuliLamp = registerBlock("lapis_lazuli_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.LAPIS).sound(SoundType.METAL));
    public static final DeferredBlock<Block> aquaLamp = registerBlock("aqua_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.COLOR_BLUE).sound(SoundType.METAL));
    public static final DeferredBlock<Block> enderLamp = registerBlock("ender_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.COLOR_PURPLE).sound(SoundType.METAL));
    public static final DeferredBlock<Block> bloodgemLamp = registerBlock("bloodgem_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.COLOR_PINK).sound(SoundType.METAL));
    public static final DeferredBlock<Block> slimeLight = registerBlock("slime_light", p -> new RedstoneLampBlock(p), Block.Properties.of().lightLevel(s -> s.getValue(RedstoneLampBlock.LIT) ? 15 : 0).strength(0.3F).sound(SoundType.GLASS));
    public static final DeferredBlock<Block> workshopLamp = registerBlock("workshop_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.COLOR_LIGHT_BLUE).sound(SoundType.GLASS));
    public static final DeferredBlock<Block> cellLamp = registerBlock("cell_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.COLOR_LIGHT_GREEN).sound(SoundType.GLASS));
    public static final DeferredBlock<Block> villageLamp = registerBlock("village_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(2.0F).mapColor(MapColor.TERRACOTTA_RED).sound(SoundType.GLASS));
    public static final DeferredBlock<Block> dungeonLamp = registerBlock("dungeon_lamp", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(-1.0F, 3600000.0F).mapColor(MapColor.QUARTZ));
    public static final DeferredBlock<Block> dungeonLampBreakable = registerBlock("dungeon_lamp_breakable", Block::new, Block.Properties.of().lightLevel(s -> 15).strength(0.3F).mapColor(MapColor.QUARTZ).sound(SoundType.GLASS).instrument(NoteBlockInstrument.HAT));
    public static final DeferredBlock<Block> dreamLamp = registerBlock("dream_lamp", p -> new Block(p), Block.Properties.of().lightLevel(s -> 15));
    public static final DeferredBlock<Block> darkBridge = registerBlock("dark_bridge", Block::new, Block.Properties.of().strength(2.0F, 6.0F).noOcclusion());
    public static final DeferredBlock<Block> starBridge = registerBlock("star_bridge", Block::new, Block.Properties.of().strength(2.0F, 6.0F).noOcclusion());
    //TODO - Redstone logic
    public static final DeferredBlock<FenceBlock> redFence = registerBlock("red_fence", p -> new FenceBlock(p), Block.Properties.of().mapColor(MapColor.COLOR_RED).strength(2.0F, 6.0F).noOcclusion());
    public static final DeferredBlock<FenceBlock> blueFence = registerBlock("blue_fence", p -> new FenceBlock(p), Block.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(2.0F, 6.0F).noOcclusion());
    public static final DeferredBlock<FenceBlock> greenFence = registerBlock("green_fence", p -> new FenceBlock(p), Block.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(2.0F, 6.0F).noOcclusion());
    public static final DeferredBlock<Block> frostedGlass = registerBlock("frosted_glass", /*BlockModGlass*/Block::new, Block.Properties.of().noOcclusion().isSuffocating((s, g, p) -> false));
    public static final DeferredBlock<Block> stainedGlass = registerBlock("stained_glass", /*BlockModGlass*/Block::new, Block.Properties.of().noOcclusion().isSuffocating((s, g, p) -> false));
    public static final DeferredBlock<Block> smoothGlass = registerBlock("smooth_glass", /*BlockModGlass*/Block::new, Block.Properties.of().noOcclusion().isSuffocating((s, g, p) -> false));
    public static final DeferredBlock<Block> brittleGrass = registerBlock("brittle_grass", /*BlockBrittleGrass*/Block::new, Block.Properties.ofFullCopy(Blocks.SEAGRASS));
    public static final DeferredBlock<Block> winterberryBush = registerBlock("winterberry_bush", /*BlockWinterberryBush*/Block::new, Block.Properties.of().noOcclusion().randomTicks());
    public static final DeferredBlock<Block> winterberryVinesBody = registerBlock("winterberry_vines_body", /*BlockWinterberryVinesBody*/Block::new, Block.Properties.ofFullCopy(Blocks.WEEPING_VINES_PLANT).sound(SoundType.CAVE_VINES));
    public static final DeferredBlock<Block> winterberryVinesHead = registerBlock("winterberry_vines_head", /*BlockWinterberryVinesHead*/Block::new, Block.Properties.ofFullCopy(Blocks.WEEPING_VINES).sound(SoundType.CAVE_VINES));
    public static final DeferredBlock<Block> snowyMoss = registerBlock("snowy_moss", /*BlockSnowyMoss*/Block::new, Block.Properties.ofFullCopy(Blocks.MOSS_BLOCK));
    public static final DeferredBlock<Block> crimpetal = registerBlock("crimpetal", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_MAGENTA).noCollision().instabreak());
    public static final DeferredBlock<Block> roofbell = registerBlock("roofbell", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_PINK).noCollision().instabreak());
    public static final DeferredBlock<Block> winterbloom = registerBlock("winterbloom", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.SNOW).noCollision().instabreak());
    public static final DeferredBlock<Block> wispLeaf = registerBlock("wisp_leaf", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).noCollision().instabreak());
    public static final DeferredBlock<Block> globebrush = registerBlock("globebrush", /*BlockModDoubleFlower*/Block::new, Block.Properties.of().mapColor(MapColor.SNOW).noCollision().instabreak());
    public static final DeferredBlock<Block> thermoliage = registerBlock("thermoliage", /*BlockModDoubleFlower*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_PINK).noCollision().instabreak());
    public static final DeferredBlock<Block> arcanaBrush = registerBlock("arcana_brush", /*BlockModGrass*/Block::new, Block.Properties.of().mapColor(MapColor.ICE).noCollision().instabreak());
    public static final DeferredBlock<Block> arcanaBush = registerBlock("arcana_bush", /*BlockModGrass*/Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).noCollision().instabreak());
    public static final DeferredBlock<Block> gemOfTheDunes = registerBlock("gem_of_the_dunes", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_MAGENTA).noCollision().instabreak());
    public static final DeferredBlock<Block> arcaniteVinesBody = registerBlock("arcanite_vines_body", /*BlockArcaniteVinesBody*/Block::new, Block.Properties.ofFullCopy(Blocks.WEEPING_VINES_PLANT).sound(SoundType.CAVE_VINES));
    public static final DeferredBlock<Block> arcaniteVinesHead = registerBlock("arcanite_vines_head", /*BlockArcaniteVinesHead*/Block::new, Block.Properties.ofFullCopy(Blocks.WEEPING_VINES).sound(SoundType.CAVE_VINES));
    public static final DeferredBlock<Block> edenBrush = registerBlock("eden_brush", /*BlockModGrass*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_YELLOW).noCollision().instabreak());
    public static final DeferredBlock<Block> sunBlossom = registerBlock("sun_blossom", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.PLANT).noCollision().instabreak());
    public static final DeferredBlock<Block> sunbloom = registerBlock("sunbloom", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).noCollision().instabreak());
    public static final DeferredBlock<Block> lushroom = registerBlock("lushroom", /*Lushroom*/Block::new, Block.Properties.of().noCollision().instabreak().sound(SoundType.GRASS));
    public static final DeferredBlock<Block> duncap = registerBlock("duncap", /*Duncap*/Block::new, Block.Properties.of().noCollision().instabreak().sound(SoundType.GRASS));
    public static final DeferredBlock<Block> landVineStem = registerBlock("land_vine_stem", /*LandVineStem*/Block::new, Block.Properties.of().noCollision().instabreak().sound(SoundType.VINE));
    public static final DeferredBlock<Block> landVine = registerBlock("land_vine", /*LandVine*/Block::new, Block.Properties.of().noCollision().instabreak().sound(SoundType.VINE));
    public static final DeferredBlock<Block> wildwoodVine = registerBlock("wildwood_vine", /*BlockModVine*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).noCollision().instabreak().sound(SoundType.VINE));
    public static final DeferredBlock<Block> moonlightFern = registerBlock("moonlight_fern", /*BlockModGrass*/Block::new, Block.Properties.of().mapColor(MapColor.ICE).noCollision().instabreak().sound(SoundType.GRASS));
    public static final DeferredBlock<Block> moonBud = registerBlock("moon_bud", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.QUARTZ).noCollision().instabreak());
    public static final DeferredBlock<Block> wildwoodTallgrass = registerBlock("wildwood_tallgrass", /*BlockModDoublePlant*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).noCollision().instabreak().sound(SoundType.GRASS));
    public static final DeferredBlock<Block> apalachiaTallgrass = registerBlock("apalachia_tallgrass", /*BlockModGrass*/Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).noCollision().instabreak().sound(SoundType.GRASS));
    public static final DeferredBlock<Block> duskBloom = registerBlock("dusk_bloom", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).noCollision().instabreak());
    public static final DeferredBlock<Block> duskFlower = registerBlock("dusk_flower", /*BlockModDoubleFlower*/Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).noCollision().instabreak());
    public static final DeferredBlock<Block> skythernBrush = registerBlock("skythern_brush", /*BlockModGrass*/Block::new, Block.Properties.of().mapColor(MapColor.WOOL).noCollision().instabreak().sound(SoundType.GRASS));
    public static final DeferredBlock<Block> dustLily = registerBlock("dust_lily", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.WOOL).noCollision().instabreak());
    public static final DeferredBlock<Block> dustBrambles = registerBlock("dust_brambles", /*BlockBrambles*/Block::new, Block.Properties.of().mapColor(MapColor.WOOL).noCollision().instabreak().sound(SoundType.GRASS));
    public static final DeferredBlock<Block> mortumBrush = registerBlock("mortum_brush", /*BlockModGrass*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).noCollision().instabreak().sound(SoundType.GRASS));
    public static final DeferredBlock<Block> eyePlant = registerBlock("eye_plant", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).noCollision().instabreak());
    public static final DeferredBlock<Block> truffle = registerBlock("truffle", Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(1.0F).pushReaction(PushReaction.DESTROY).sound(SoundType.WOOD));
    public static final DeferredBlock<Block> demonBrambles = registerBlock("demon_brambles", /*BlockBrambles*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).noCollision().instabreak().sound(SoundType.GRASS));
    public static final DeferredBlock<Block> shineGrass = registerBlock("shine_grass", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollision().instabreak());
    public static final DeferredBlock<Block> cracklespike = registerBlock("cracklespike", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollision().instabreak());
    public static final DeferredBlock<Block> fernite = registerBlock("fernite", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollision().instabreak());
    public static final DeferredBlock<Block> dreamglow = registerBlock("dreamglow", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollision().instabreak());
    public static final DeferredBlock<Block> bulbatobe = registerBlock("bulbatobe", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollision().instabreak());
    public static final DeferredBlock<Block> shimmer = registerBlock("shimmer", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollision().instabreak());
    public static final DeferredBlock<Block> yellowDulah = registerBlock("yellow_dulah", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollision().instabreak());
    public static final DeferredBlock<Block> greenDulah = registerBlock("green_dulah", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollision().instabreak());
    public static final DeferredBlock<Block> greenGemtop = registerBlock("green_gemtop", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollision().instabreak());
    public static final DeferredBlock<Block> purpleGemtop = registerBlock("purple_gemtop", /*BlockModFlower*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).noCollision().instabreak());
    public static final DeferredBlock<Block> weedwoodVine = registerBlock("weedwood_vine", /*BlockModVine*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).noCollision().instabreak().sound(SoundType.VINE));
    public static final DeferredBlock<Block> blossomedWeedwoodVine = registerBlock("blossomed_weedwood_vine", /*BlockModVine*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).noCollision().instabreak().sound(SoundType.VINE));
    public static final DeferredBlock<Block> tomatoPlant = registerBlock("tomato_plant", /*BlockModCrop*/Block::new, Block.Properties.of().noCollision().instabreak().randomTicks().sound(SoundType.CROP));
    public static final DeferredBlock<Block> whiteMushroomPlant = registerBlock("white_mushroom_plant", /*BlockModCrop*/Block::new, Block.Properties.of().noCollision().instabreak().randomTicks().sound(SoundType.CROP));
    public static final DeferredBlock<Block> aquamarinePlant = registerBlock("aquamarine_plant", /*BlockModCrop*/Block::new, Block.Properties.of().noCollision().instabreak().randomTicks().sound(SoundType.CROP));
    public static final DeferredBlock<Block> eucalyptusPlant = registerBlock("eucalyptus_plant", /*BlockModCrop*/Block::new, Block.Properties.of().noCollision().instabreak().randomTicks().sound(SoundType.CROP));
    public static final DeferredBlock<Block> hitchakPlant = registerBlock("hitchak_plant", /*BlockModCrop*/Block::new, Block.Properties.of().noCollision().instabreak().randomTicks().sound(SoundType.CROP));
    public static final DeferredBlock<Block> lamonaPlant = registerBlock("lamona_plant", /*BlockModCrop*/Block::new, Block.Properties.of().noCollision().instabreak().randomTicks().sound(SoundType.CROP));
    public static final DeferredBlock<Block> marsinePlant = registerBlock("marsine_plant", /*BlockModCrop*/Block::new, Block.Properties.of().noCollision().instabreak().randomTicks().sound(SoundType.CROP));
    public static final DeferredBlock<Block> veiloPlant = registerBlock("veilo_plant", /*BlockModCrop*/Block::new, Block.Properties.of().noCollision().instabreak().randomTicks().sound(SoundType.CROP));
    public static final DeferredBlock<Block> skyPlant = registerBlock("sky_plant", /*BlockModCrop*/Block::new, Block.Properties.of().noCollision().instabreak().randomTicks().sound(SoundType.CROP));
    public static final DeferredBlock<Block> firestockPlant = registerBlock("firestock_plant", /*BlockArcanaDoubleCrop*/Block::new, Block.Properties.of().noCollision().instabreak().randomTicks().sound(SoundType.CROP));
    public static final DeferredBlock<Block> pinflyPlant = registerBlock("pinfly_plant", /*BlockArcanaDoubleCrop*/Block::new, Block.Properties.of().noCollision().instabreak().randomTicks().sound(SoundType.CROP));
    public static final DeferredBlock<Block> moonbulbPlant = registerBlock("moonbulb_plant", /*BlockModDoubleCrop*/Block::new, Block.Properties.of().noCollision().instabreak().randomTicks().sound(SoundType.CROP));
    public static final DeferredBlock<Block> purpleGlowbonePlant = registerBlock("purple_glowbone_plant", /*BlockModDoubleCrop*/Block::new, Block.Properties.of().noCollision().instabreak().randomTicks().sound(SoundType.CROP));
    public static final DeferredBlock<Block> pinkGlowbonePlant = registerBlock("pink_glowbone_plant", /*BlockModDoubleCrop*/Block::new, Block.Properties.of().noCollision().instabreak().randomTicks().sound(SoundType.CROP));
    public static final DeferredBlock<Block> blazePumpkin = registerBlock("blaze_pumpkin", /*BlockMobPumpkin*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_YELLOW).strength(1.0F).sound(SoundType.WOOD));
    public static final DeferredBlock<Block> creeperPumpkin = registerBlock("creeper_pumpkin", /*BlockMobPumpkin*/Block::new, Block.Properties.of().mapColor(MapColor.EMERALD).strength(1.0F).sound(SoundType.WOOD));
    public static final DeferredBlock<Block> cyclopsPumpkin = registerBlock("cyclops_pumpkin", /*BlockMobPumpkin*/Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GREEN).strength(1.0F).sound(SoundType.WOOD));
    public static final DeferredBlock<Block> enderPumpkin = registerBlock("ender_pumpkin", /*BlockMobPumpkin*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(1.0F).sound(SoundType.WOOD));
    public static final DeferredBlock<Block> enderWatcherPumpkin = registerBlock("ender_watcher_pumpkin", /*BlockMobPumpkin*/Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).strength(1.0F).sound(SoundType.WOOD));
    public static final DeferredBlock<Block> frostPumpkin = registerBlock("frost_pumpkin", /*BlockMobPumpkin*/Block::new, Block.Properties.of().mapColor(MapColor.WARPED_STEM).strength(1.0F).sound(SoundType.WOOD));
    public static final DeferredBlock<Block> ghastPumpkin = registerBlock("ghast_pumpkin", /*BlockMobPumpkin*/Block::new, Block.Properties.of().mapColor(MapColor.SNOW).strength(1.0F).sound(SoundType.WOOD));
    public static final DeferredBlock<Block> glaconPumpkin = registerBlock("glacon_pumpkin", /*BlockMobPumpkin*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).strength(1.0F).sound(SoundType.WOOD));
    public static final DeferredBlock<Block> hellspiderPumpkin = registerBlock("hellspider_pumpkin", /*BlockMobPumpkin*/Block::new, Block.Properties.of().mapColor(MapColor.NETHER).strength(1.0F).sound(SoundType.WOOD));
    public static final DeferredBlock<Block> jungleSpiderPumpkin = registerBlock("jungle_spider_pumpkin", /*BlockMobPumpkin*/Block::new, Block.Properties.of().mapColor(MapColor.PLANT).strength(1.0F).sound(SoundType.WOOD));
    public static final DeferredBlock<Block> skeletonPumpkin = registerBlock("skeleton_pumpkin", /*BlockMobPumpkin*/Block::new, Block.Properties.of().mapColor(MapColor.WOOL).strength(1.0F).sound(SoundType.WOOD));
    public static final DeferredBlock<Block> spiderPumpkin = registerBlock("spider_pumpkin", /*BlockMobPumpkin*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1.0F).sound(SoundType.WOOD));
    public static final DeferredBlock<Block> zombiePumpkin = registerBlock("zombie_pumpkin", /*BlockMobPumpkin*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GREEN).strength(1.0F).sound(SoundType.WOOD));
    public static final DeferredBlock<Block> ancientEntityStatue = registerBlock("ancient_entity_statue", /*BlockStatue*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F) /*() -> IRON_GOLEM_DEATH*/);
    public static final DeferredBlock<Block> theWatcherStatue = registerBlock("the_watcher_statue", /*BlockStatue*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F) /*ROAR*/);
    public static final DeferredBlock<Block> kingOfScorchersStatue = registerBlock("king_of_scorchers_statue", /*BlockStatue*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F) /*KING_OF_SCORCHERS*/);
    public static final DeferredBlock<Block> kitraStatue = registerBlock("kitra_statue", /*BlockStatue*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F) /*WHALE*/);
    public static final DeferredBlock<Block> ayeracoStatue = registerBlock("ayeraco_statue", /*BlockStatueColored*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F));
    public static final DeferredBlock<Block> dramixStatue = registerBlock("dramix_statue", /*BlockStatue*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F) /*DRAMIX*/);
    public static final DeferredBlock<Block> parasectaStatue = registerBlock("parasecta_statue", /*BlockStatue*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F) /*PARASECTA*/);
    public static final DeferredBlock<Block> sunstormStatue = registerBlock("sunstorm_statue", /*BlockStatue*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F) /*SPARKLER*/);
    public static final DeferredBlock<Block> termasectStatue = registerBlock("termasect_statue", /*BlockStatue*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F) /*() -> WOOD_STEP*/);
    public static final DeferredBlock<Block> eternalArcherStatue = registerBlock("eternal_archer_statue", /*BlockStatue*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F) /*ARCHER*/);
    public static final DeferredBlock<Block> experiencedCoriStatue = registerBlock("experienced_cori_statue", /*BlockStatue*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F) /*CORI*/);
    public static final DeferredBlock<Block> vamacheronStatue = registerBlock("vamacheron_statue", /*BlockStatue*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F) /*null*/);
    public static final DeferredBlock<Block> karotStatue = registerBlock("karot_statue", /*BlockStatue*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F) /*null*/);
    public static final DeferredBlock<Block> twilightDemonStatue = registerBlock("twilight_demon_statue", /*BlockStatue*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F) /*INSECT*/);
    public static final DeferredBlock<Block> densosStatue = registerBlock("densos_statue", /*BlockStatue*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F) /*DENSOS*/);
    public static final DeferredBlock<Block> reyvorStatue = registerBlock("reyvor_statue", /*BlockStatue*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F) /*REYVOR*/);
    public static final DeferredBlock<Block> soulFiendStatue = registerBlock("soul_fiend_statue", /*BlockStatue*/p -> new Block(p), Block.Properties.of().mapColor(MapColor.STONE).strength(2.0F) /*null*/);
    public static final DeferredBlock<Block> proximitySpawner = registerBlock("proximity_spawner", /*BlockModProximitySpawner*/Block::new, Block.Properties.ofFullCopy(Blocks.SPAWNER).noLootTable());
    public static final DeferredBlock<Block> kobblinBurrow = registerBlock("kobblin_burrow", /*KobblinBurrow*/Block::new, Block.Properties.ofFullCopy(Blocks.ROOTED_DIRT));
    public static final DeferredBlock<Block> encagedCaptainMerik = registerBlock("encaged_captain_merik", /*BlockModMobCage*/Block::new, Block.Properties.of().strength(2.0F) /*EntityRegistry.CAPTAIN_MERIK.getId(), SUMMONING_CAPTAIN_MERIK*/);
    public static final DeferredBlock<Block> encagedDatticon = registerBlock("encaged_datticon", /*BlockModMobCage*/Block::new, Block.Properties.of().strength(2.0F) /*EntityRegistry.DATTICON.getId(), SUMMONING_DATTICON*/);
    public static final DeferredBlock<Block> encagedKazari = registerBlock("encaged_kazari", /*BlockModMobCage*/Block::new, Block.Properties.of().strength(2.0F) /*EntityRegistry.KAZARI.getId(), SUMMONING_KAZARI*/);
    public static final DeferredBlock<Block> encagedLeorna = registerBlock("encaged_leorna", /*BlockModMobCage*/Block::new, Block.Properties.of().strength(2.0F) /*EntityRegistry.LEORNA.getId(), SUMMONING_LEORNA*/);
    public static final DeferredBlock<Block> encagedLordVatticus = registerBlock("encaged_lord_vatticus", /*BlockModMobCage*/Block::new, Block.Properties.of().strength(2.0F) /*EntityRegistry.LORD_VATTICUS.getId(), SUMMONING_LORD_VATTICUS*/);
    public static final DeferredBlock<Block> encagedWarGeneral = registerBlock("encaged_war_general", /*BlockModMobCage*/Block::new, Block.Properties.of().strength(2.0F) /*EntityRegistry.WAR_GENERAL.getId(), SUMMONING_WAR_GENERAL*/);
    public static final DeferredBlock<Block> encagedZelus = registerBlock("encaged_zelus", /*BlockModMobCage*/Block::new, Block.Properties.of().strength(2.0F) /*EntityRegistry.ZELUS.getId(), SUMMONING_ZELUS*/);
    public static final DeferredBlock<Block> calcifiedBrain = registerBlock("calcified_brain", /*BlockModMobCage*/Block::new, Block.Properties.ofFullCopy(Blocks.BONE_BLOCK) /*EntityRegistry.KITRA.getId(), SUMMONING_KITRA, new BlockPos(0, 5, 0)*/);
    public static final DeferredBlock<Block> sunstormSpawner = registerBlock("sunstorm_spawner", /*BlockModMobCage*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_YELLOW) /*EntityRegistry.SUNSTORM.getId(), SUMMONING_SUNSTORM*/);
    public static final DeferredBlock<Block> termasectSpawner = registerBlock("termasect_spawner", /*BlockModMobCage*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE) /*EntityRegistry.TERMASECT.getId(), SUMMONING_TERMASECT, new BlockPos(0, 11, 0)*/);
    public static final DeferredBlock<Block> eternalArcherSpawner = registerBlock("eternal_archer_spawner", /*BlockModMobCage*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_MAGENTA) /*EntityRegistry.ETERNAL_ARCHER.getId(), SUMMONING_ETERNAL_ARCHER*/);
    public static final DeferredBlock<Block> experiencedCoriSpawner = registerBlock("experienced_cori_spawner", /*BlockModMobCage*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY) /*EntityRegistry.EXPERIENCED_CORI.getId(), SUMMONING_EXPERIENCED_CORI, new BlockPos(0, 11, 0)*/);
    public static final DeferredBlock<Block> dramixAltar = registerBlock("dramix_altar", /*BlockArcanaAltar*/Block::new, Block.Properties.of().mapColor(MapColor.CRIMSON_HYPHAE).strength(3.0F)); /*Rarity.COMMON*/
    public static final DeferredBlock<Block> parasectaAltar = registerBlock("parasecta_altar", /*BlockArcanaAltar*/Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_BROWN).strength(3.0F)); /*Rarity.COMMON*/
    public static final DeferredBlock<Block> karosAltar = registerBlock("karos_altar", /*BlockKarosAltar*/Block::new, Block.Properties.of().strength(3.0F));
    public static final DeferredBlock<Block> lunicAltar = registerBlock("lunic_altar", /*BlockLunicAltar*/Block::new, Block.Properties.of().strength(3.0F));
    public static final DeferredBlock<Block> quadroticAltar = registerBlock("quadrotic_altar", /*BlockQuadroticAltar*/Block::new, Block.Properties.of().strength(3.0F));
    public static final DeferredBlock<Block> raglokAltar = registerBlock("raglok_altar", /*BlockRaglokAltar*/Block::new, Block.Properties.of().strength(3.0F));
    public static final DeferredBlock<Block> wreckAltar = registerBlock("wreck_altar", /*BlockWreckAltar*/Block::new, Block.Properties.of().strength(3.0F));
    public static final DeferredBlock<Block> hiveEgg = registerBlock("hive_egg", /*BlockHiveEgg*/Block::new, Block.Properties.ofFullCopy(Blocks.DRAGON_EGG));
    public static final DeferredBlock<Block> ayeracoBeamRed = registerBlock("ayeraco_beam_red", /*BlockAyeracoBeam*/Block::new, Block.Properties.of().noOcclusion() /*BossBarColor.RED*/);
    public static final DeferredBlock<Block> ayeracoBeamYellow = registerBlock("ayeraco_beam_yellow", /*BlockAyeracoBeam*/Block::new, Block.Properties.of().noOcclusion() /*BossBarColor.YELLOW*/);
    public static final DeferredBlock<Block> ayeracoBeamGreen = registerBlock("ayeraco_beam_green", /*BlockAyeracoBeam*/Block::new, Block.Properties.of().noOcclusion() /*BossBarColor.GREEN*/);
    public static final DeferredBlock<Block> ayeracoBeamBlue = registerBlock("ayeraco_beam_blue", /*BlockAyeracoBeam*/Block::new, Block.Properties.of().noOcclusion() /*BossBarColor.BLUE*/);
    public static final DeferredBlock<Block> ayeracoBeamPurple = registerBlock("ayeraco_beam_purple", /*BlockAyeracoBeam*/Block::new, Block.Properties.of().noOcclusion() /*BossBarColor.PURPLE*/);
    public static final DeferredBlock<Block> ayeracoBeamPink = registerBlock("ayeraco_beam_pink", /*BlockAyeracoBeam*/Block::new, Block.Properties.of().noOcclusion() /*BossBarColor.PINK*/);
    public static final DeferredBlock<Block> ayeracoSpawn = registerBlock("ayeraco_spawn", /*BlockAyeracoSpawn*/Block::new, Block.Properties.of());
    public static final DeferredBlock<Block> altarOfCorruption = registerBlock("altar_of_corruption", /*BlockAltarOfCorruption*/Block::new, Block.Properties.ofFullCopy(Blocks.ENCHANTING_TABLE)); /*Rarity.UNCOMMON*/
    public static final DeferredBlock<Block> arcaniumExtractor = registerBlock("arcanium_extractor", /*BlockArcaniumExtractor*/Block::new, Block.Properties.of().strength(3.0F)); /*Rarity.RARE*/
    public static final DeferredBlock<Block> infusionTable = registerBlock("infusion_table", /*BlockInfusionTable*/Block::new, Block.Properties.of().strength(3.0F)); /*Rarity.RARE*/
    public static final DeferredBlock<Block> coalstoneFurnace = registerBlock("coalstone_furnace", /*BlockModInfiniFurnace*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(3.5F) /*BlockEntityRegistry.COALSTONE_FURNACE::get*/);
    public static final DeferredBlock<Block> moltenFurnace = registerBlock("molten_furnace", /*BlockModInfiniFurnace*/Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GRAY).strength(3.5F)); /*Rarity.UNCOMMON, BlockEntityRegistry.MOLTEN_FURNACE::get*/
    public static final DeferredBlock<Block> greenlightFurnace = registerBlock("greenlight_furnace", /*BlockModFurnace*/Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_GREEN).strength(3.5F)); /*Rarity.UNCOMMON, BlockEntityRegistry.GREENLIGHT_FURNACE::get*/
    public static final DeferredBlock<Block> oceanfireFurnace = registerBlock("oceanfire_furnace", /*BlockModInfiniFurnace*/Block::new, Block.Properties.of().mapColor(MapColor.COLOR_CYAN).strength(3.5F)); /*Rarity.UNCOMMON, BlockEntityRegistry.OCEANFIRE_FURNACE::get*/
    public static final DeferredBlock<Block> moonlightFurnace = registerBlock("moonlight_furnace", /*BlockModFurnace*/Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).strength(3.5F)); /*Rarity.UNCOMMON, BlockEntityRegistry.MOONLIGHT_FURNACE::get*/
    public static final DeferredBlock<Block> whitefireFurnace = registerBlock("whitefire_furnace", /*BlockModInfiniFurnace*/Block::new, Block.Properties.of().mapColor(MapColor.SNOW).strength(3.5F)); /*Rarity.UNCOMMON, BlockEntityRegistry.WHITEFIRE_FURNACE::get*/
    public static final DeferredBlock<Block> demonFurnace = registerBlock("demon_furnace", /*BlockDemonFurnace*/Block::new, Block.Properties.of().strength(3.5F)); /*Rarity.EPIC*/
    public static final DeferredBlock<Block> boneChest = registerBlock("bone_chest", /*BlockBoneChest*/Block::new, Block.Properties.of().strength(2.5F)); /*Rarity.COMMON*/
    public static final DeferredBlock<Block> frostedChest = registerBlock("frosted_chest", /*BlockFrostedChest*/Block::new, Block.Properties.of().strength(2.5F)); /*Rarity.COMMON*/
    public static final DeferredBlock<Block> presentBox = registerBlock("present_box", /*BlockPresentBox*/Block::new, Block.Properties.of().strength(2.5F)); /*Rarity.COMMON*/
    public static final DeferredBlock<Block> edenChest = registerBlock("eden_chest", /*BlockEdenChest*/Block::new, Block.Properties.of().strength(2.5F)); /*Rarity.COMMON*/
    public static final DeferredBlock<Block> crate = registerBlock("crate", /*BlockCrate*/Block::new, Block.Properties.of().strength(2.5F));
    public static final DeferredBlock<Block> oxcrate = registerBlock("oxcrate", /*Oxcrate*/Block::new, Block.Properties.of().strength(2.5F));
    public static final DeferredBlock<Block> inserter = registerBlock("inserter", /*BlockInserter*/Block::new, Block.Properties.of().strength(2.0F));
    public static final DeferredBlock<Block> distributor = registerBlock("distributor", /*BlockDistributor*/Block::new, Block.Properties.of().strength(2.0F));
//    public static final DeferredBlock<Block> nightmareBed = registerBlock("nightmare_bed", /*BlockNightmareBed*/Block::new, Block.Properties.of().strength(2.0F)); /*registerBlockWithSpecialItem*/
    public static final DeferredBlock<Block> hellfireSponge = registerBlock("hellfire_sponge", /*BlockHellfireSponge*/Block::new, Block.Properties.of().strength(0.6F));
    public static final DeferredBlock<Block> coldHellfireSponge = registerBlock("cold_hellfire_sponge", /*BlockColdHellfireSponge*/Block::new, Block.Properties.of().strength(0.6F));
    public static final DeferredBlock<Block> frostedAllure = registerBlock("frosted_allure", /*BlockFrostedAllure*/Block::new, Block.Properties.of()); /*Rarity.UNCOMMON*/
    public static final DeferredBlock<Block> soulTrap = registerBlock("soul_trap", /*BlockModSoulTrap*/Block::new, Block.Properties.of().strength(2.0F));
    public static final DeferredBlock<Block> acceleron = registerBlock("acceleron", /*BlockAcceleron*/Block::new, Block.Properties.of().strength(2.0F)); /*Rarity.UNCOMMON*/
    public static final DeferredBlock<Block> graveStone = registerBlock("gravestone", /*BlockGraveStone*/Block::new, Block.Properties.of().strength(2.0F)); /*Rarity.UNCOMMON*/
    public static final DeferredBlock<Block> robbinHut = registerBlock("robbin_hut", /*BlockRobbinHut*/Block::new, Block.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS));
    public static final DeferredBlock<Block> robbinNest = registerBlock("robbin_nest", /*BlockRobbinNest*/Block::new, Block.Properties.ofFullCopy(Blocks.HAY_BLOCK));
    public static final DeferredBlock<Block> elevantium = registerBlock("elevantium", /*BlockElevantium*/Block::new, Block.Properties.of().strength(2.0F)); /*Rarity.UNCOMMON*/
    public static final DeferredBlock<Block> booster = registerBlock("booster", /*RedstoneBooster*/Block::new, Block.Properties.ofFullCopy(Blocks.REPEATER));
    public static final DeferredBlock<Block> limiter = registerBlock("limiter", /*RedstoneLimiter*/Block::new, Block.Properties.ofFullCopy(Blocks.REPEATER));
    public static final DeferredBlock<Block> oxdriteRail = registerBlock("oxdrite_rail", /*OxdriteRail*/Block::new, Block.Properties.of().strength(0.7F));
    public static final DeferredBlock<Block> oxdriteLamp = registerBlock("oxdrite_lamp", /*OxdriteLamp*/Block::new, Block.Properties.of().strength(2.0F));
    public static final DeferredBlock<Block> capacitor = registerBlock("capacitor", /*Capacitor*/Block::new, Block.Properties.of().strength(2.0F));
    public static final DeferredBlock<Block> miner = registerBlock("miner", /*MinerBlock*/Block::new, Block.Properties.of().strength(3.0F));
    public static final DeferredBlock<Block> softMiner = registerBlock("soft_miner", /*SoftMinerBlock*/Block::new, Block.Properties.of().strength(3.0F));
    public static final DeferredBlock<Block> placer = registerBlock("placer", /*PlacerBlock*/Block::new, Block.Properties.of().strength(3.0F));
    public static final DeferredBlock<Block> spikeBlock = registerBlock("spike_block", /*BlockSpike*/Block::new, Block.Properties.of().mapColor(MapColor.METAL).strength(2.0F)); /*false, METAL*/
    public static final DeferredBlock<Block> hotSpikeBlock = registerBlock("hot_spike_block", /*BlockSpike*/Block::new, Block.Properties.of().mapColor(MapColor.CRIMSON_NYLIUM).strength(2.0F)); /*true, CRIMSON_NYLIUM*/
    public static final DeferredBlock<Block> heatTrap = registerBlock("heat_trap", /*BlockHeatTrap*/Block::new, Block.Properties.of().strength(2.0F));
    public static final DeferredBlock<Block> karosHeatTile = registerBlock("karos_heat_tile", /*BlockKarosHeatTile*/Block::new, Block.Properties.of().strength(2.0F));
    public static final DeferredBlock<Block> karosDispenser = registerBlock("karos_dispenser", /*BlockKarosDispenser*/Block::new, Block.Properties.of());
    public static final DeferredBlock<Block> bacterialAcid = registerBlock("bacterial_acid", /*BlockAcid*/Block::new, Block.Properties.of().noCollision().instabreak());
    public static final DeferredBlock<Block> lunicAcid = registerBlock("lunic_acid", /*BlockAcid*/Block::new, Block.Properties.of().noCollision().instabreak());
    public static final DeferredBlock<Block> icyFire = registerBlock("icy_fire", /*BlockIcyFire*/Block::new, Block.Properties.ofFullCopy(Blocks.SOUL_FIRE));
    public static final DeferredBlock<Block> hellFire = registerBlock("hellfire", /*Fire*/Block::new, Block.Properties.of().replaceable().noCollision().instabreak()); /*8F*/
    public static final DeferredBlock<Block> divineFlame = registerBlock("divine_flame", /*DivineFlame*/Block::new, Block.Properties.of().replaceable().noCollision().instabreak());
    public static final DeferredBlock<Block> wildFlame = registerBlock("wild_flame", /*WildFlame*/Block::new, Block.Properties.of().replaceable().noCollision().instabreak());
    public static final DeferredBlock<Block> enchantedFlame = registerBlock("enchanted_flame", /*EnchantedFlame*/Block::new, Block.Properties.of().replaceable().noCollision().instabreak());
    public static final DeferredBlock<Block> skyFire = registerBlock("sky_fire", /*SkyFire*/Block::new, Block.Properties.of().replaceable().noCollision().instabreak());
    public static final DeferredBlock<Block> mortumEmbers = registerBlock("mortum_embers", /*MortumEmbers*/Block::new, Block.Properties.of().replaceable().noCollision().instabreak());
    public static final DeferredBlock<Block> gateway = registerBlock("gateway", /*BlockGateway*/Block::new, Block.Properties.ofFullCopy(Blocks.LODESTONE));
    public static final DeferredBlock<Block> divinePortal = registerBlock("divine_portal", /*SimplePortalBlock*/Block::new, Block.Properties.of().noCollision().instabreak()); /*Level.OVERWORLD, LevelRegistry.EDEN, divineRock.get(), ResourceLocation.fromNamespaceAndPath(MODID, "eden_portal")*/
    public static final DeferredBlock<Block> arcanaPortal = registerBlock("arcana_portal", /*BlockArcanaPortal*/Block::new, Block.Properties.of().noCollision().instabreak());
    public static final DeferredBlock<Block> iceikaPortal = registerBlock("iceika_portal", /*SimplePortalBlock*/Block::new, Block.Properties.of().noCollision().instabreak()); /*LevelRegistry.ICEIKA, Level.OVERWORLD, Blocks.SNOW_BLOCK, ResourceLocation.fromNamespaceAndPath(MODID, "frost")*/
    public static final DeferredBlock<Block> edenPortal = registerBlock("eden_portal", /*SimplePortalBlock*/Block::new, Block.Properties.of().noCollision().instabreak()); /*LevelRegistry.EDEN, Level.OVERWORLD, edenBlock.get(), ResourceLocation.fromNamespaceAndPath(MODID, "eden_portal")*/
    public static final DeferredBlock<Block> wildwoodPortal = registerBlock("wildwood_portal", /*SimplePortalBlock*/Block::new, Block.Properties.of().noCollision().instabreak()); /*LevelRegistry.WILDWOOD, LevelRegistry.EDEN, wildwoodBlock.get(), ResourceLocation.fromNamespaceAndPath(MODID, "wildwood_portal")*/
    public static final DeferredBlock<Block> apalachiaPortal = registerBlock("apalachia_portal", /*SimplePortalBlock*/Block::new, Block.Properties.of().noCollision().instabreak()); /*LevelRegistry.APALACHIA, LevelRegistry.WILDWOOD, apalachiaBlock.get(), ResourceLocation.fromNamespaceAndPath(MODID, "apalachia_portal")*/
    public static final DeferredBlock<Block> skythernPortal = registerBlock("skythern_portal", /*SimplePortalBlock*/Block::new, Block.Properties.of().noCollision().instabreak()); /*LevelRegistry.SKYTHERN, LevelRegistry.APALACHIA, skythernBlock.get(), ResourceLocation.fromNamespaceAndPath(MODID, "skythern_portal")*/
    public static final DeferredBlock<Block> mortumPortal = registerBlock("mortum_portal", /*SimplePortalBlock*/Block::new, Block.Properties.of().noCollision().instabreak()); /*LevelRegistry.MORTUM, LevelRegistry.SKYTHERN, mortumBlock.get(), ResourceLocation.fromNamespaceAndPath(MODID, "mortum_portal")*/
    public static final DeferredBlock<Block> vetheaPortal = registerBlock("vethea_portal", /*VetheaPortal*/Block::new, Block.Properties.of().noCollision().instabreak());
    public static final DeferredBlock<Block> overworldRift = registerBlock("overworld_rift", /*BlockModRift*/Block::new, Block.Properties.of().noCollision().instabreak()); /*Level.OVERWORLD, STABLE_OVERWORLD_RIFT, RIFT_RESONATING_OVERWORLD, RIFT_REPLENISHING_OVERWORLD, (byte)6*/
    public static final DeferredBlock<Block> edenRift = registerBlock("eden_rift", /*BlockModRift*/Block::new, Block.Properties.of().noCollision().instabreak()); /*LevelRegistry.EDEN, STABLE_EDEN_RIFT, RIFT_RESONATING_EDEN, RIFT_REPLENISHING_EDEN, (byte)1*/
    public static final DeferredBlock<Block> wildwoodRift = registerBlock("wildwood_rift", /*BlockModRift*/Block::new, Block.Properties.of().noCollision().instabreak()); /*LevelRegistry.WILDWOOD, STABLE_WILDWOOD_RIFT, RIFT_RESONATING_WILDWOOD, RIFT_REPLENISHING_WILDWOOD, (byte)2*/
    public static final DeferredBlock<Block> apalachiaRift = registerBlock("apalachia_rift", /*BlockModRift*/Block::new, Block.Properties.of().noCollision().instabreak()); /*LevelRegistry.APALACHIA, STABLE_APALACHIA_RIFT, RIFT_RESONATING_APALACHIA, RIFT_REPLENISHING_APALACHIA, (byte)3*/
    public static final DeferredBlock<Block> skythernRift = registerBlock("skythern_rift", /*BlockModRift*/Block::new, Block.Properties.of().noCollision().instabreak()); /*LevelRegistry.SKYTHERN, STABLE_SKYTHERN_RIFT, RIFT_RESONATING_SKYTHERN, RIFT_REPLENISHING_SKYTHERN, (byte)4*/
    public static final DeferredBlock<Block> mortumRift = registerBlock("mortum_rift", /*BlockModRift*/Block::new, Block.Properties.of().noCollision().instabreak()); /*LevelRegistry.MORTUM, STABLE_MORTUM_RIFT, RIFT_RESONATING_MORTUM, RIFT_REPLENISHING_MORTUM, (byte)5*/
    public static final DeferredBlock<Block> dungeonAir = registerBlock("dungeon_air", /*BlockModDungeonAir*/Block::new, Block.Properties.of().air().replaceable().noCollision()); /*Rarity.EPIC*/
    public static final DeferredBlock<Block> terranGhostBlock = registerBlock("terran_ghost_block", /*TerranGhostBlock*/Block::new, Block.Properties.of().noLootTable().noOcclusion().noCollision().air().replaceable());
    public static final DeferredBlock<Block> randomItemDropper = registerBlock("random_item_dropper", /*BlockRandomItemDropper*/Block::new, Block.Properties.of().strength(2.0F));

    public static final DeferredBlock<FlowerPotBlock>
            //Saplings
            divineSaplingPot = registerFlowerPot("divine_sapling_pot", divineSapling),
            shiverspineSaplingPot = registerFlowerPot("shiverspine_sapling_pot", shiverspineSapling),
            auroraoakSaplingPot = registerFlowerPot("auroraoak_sapling_pot", auroraoakSapling),
            cozybarkSaplingPot = registerFlowerPot("cozybark_sapling_pot", cozybarkSapling),
            streamleafSaplingPot = registerFlowerPot("streamleaf_sapling_pot", streamleafSapling),
            edenSaplingPot = registerFlowerPot("eden_sapling_pot", edenSapling),
            crimseekerSaplingPot = registerFlowerPot("crimseeker_sapling_pot", crimseekerSapling),
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
            lushroomPot = registerFlowerPot("lushroom_pot", lushroom),
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

    static {
        //Obsidian
        addAliases("red_vane", bleedingObsidian);
        addAliases("yellow_vane", shiningObsidian);
        addAliases("cyan_vane", glitteringObsidian);
        addAliases("blue_vane", seepingObsidian);
        addAliases("purple_vane", vwoopingObsidian);
        //Lamps
        addAliases("bluefire_lamp", soulfireLamp);
        addAliases("redstone_ore_lamp", bloodgemLamp);
        //Shiverspine
        addAliases("frozen_sapling", shiverspineSapling);
        addAliases("frozen_log", shiverspineLog);
        addAliases("stripped_frozen_log", strippedShiverspineLog);
        addAliases("frozen_planks", shiverspinePlanks);
        addAliases("frozen_fence", shiverspineFence);
        addAliases("frozen_fence_gate", shiverspineFenceGate);
        addAliases("frozen_door", shiverspineDoor);
        addAliases("frozen_trapdoor", shiverspineTrapdoor);
        //Fire
        addAliases("iceika_fire", icyFire);
        addVanillaAliases("blue_fire", Blocks.SOUL_FIRE);
        //Steel
        addAliases("white_steel", steel);
        addAliases("teal_steel", cyanSteel);
        addAliases("bright_red_steel", magentaSteel);
        //Stained Glass
        addAliases("stained_glass2", stainedGlass);
        addAliases("stained_glass3", stainedGlass);
        addAliases("stained_glass4", stainedGlass);
        addAliases("stained_glass5", stainedGlass);
        addAliases("stained_glass6", stainedGlass);
        addAliases("stained_glass7", stainedGlass);
        addAliases("stained_glass8", stainedGlass);
        //Extra Arcana
        addAliases("arcana_hard_portal_frame", arcanaPortalFrame);
        //Eden
        addAliases("eden_dirt", rayDirt);
        addAliases("eden_grass", rayGrass);
        addAliases("eden_ore", twilightEdenOre);
        addAliases("acid_block", bacterialAcid);
        addAliases("karos_heat_tile_green", karosHeatTile);
        addAliases("karos_heat_tile_red", karosHeatTile);
    }

    private static Identifier getIdentifierLocation(String path) {
        return Identifier.fromNamespaceAndPath(MODID, path);
    }

    private static void addAliases(String path, DeferredBlock<Block> block) {
        Identifier loc = getIdentifierLocation(path);
        BLOCKS.addAlias(loc, block.getId());
        ITEMS.addAlias(loc, block.getId());
    }
    private static void addVanillaAliases(String path, Block block) {
        Identifier loc = getIdentifierLocation(path);
        Identifier defLoc = Identifier.withDefaultNamespace(path);
        BLOCKS.addAlias(loc, defLoc);
        ITEMS.addAlias(loc, defLoc);
    }


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<Properties, T> blockFactory, Block.Properties properties) {
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MODID, name));
        properties.setId(blockKey);
        DeferredBlock<T> block = BLOCKS.register(name, () -> blockFactory.apply(properties));
        DivineRegistries.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)))));
        return block;
    }

    private static class PlaceholderGrass extends Block {
        public PlaceholderGrass(Block.Properties properties) { super(properties); }
    }

    private static DeferredBlock<StairBlock> registerStairs(String name, DeferredBlock<? extends Block> base, BlockBehaviour.Properties props) {
        return registerBlock(name, p -> new StairBlock(base.get().defaultBlockState(), p), props);
    }

    private static DeferredBlock<SlabBlock> registerSlab(String name, BlockBehaviour.Properties props) {
        return registerBlock(name, SlabBlock::new, props);
    }

    private static DeferredBlock<FenceBlock> registerFence(String name, BlockBehaviour.Properties props) {
        return registerBlock(name, FenceBlock::new, props);
    }

    private static DeferredBlock<FlowerPotBlock> registerFlowerPot(String name, Supplier<? extends Block> flower) {
        return registerBlock(name,properties -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, flower, properties),Block.Properties.ofFullCopy(Blocks.FLOWER_POT));
    }
    public static void load() {}
}