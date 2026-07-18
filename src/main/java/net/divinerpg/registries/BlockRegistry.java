package net.divinerpg.registries;

import net.divinerpg.blocks.DivineLeavesBlock;
import net.divinerpg.world.feature.DivineTree;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Optional;
import java.util.function.Function;

import static net.divinerpg.DivineRPG.MODID;

public class BlockRegistry {

    public static final Block.Properties FROZEN_STONE_PROPS = Block.Properties.of().mapColor(MapColor.GLOW_LICHEN).strength(1.5F, 6.0F);
    public static final Block.Properties COBBLED_FROZEN_STONE_PROPS = Block.Properties.of().mapColor(MapColor.GLOW_LICHEN).strength(2.0F, 6.0F);
    public static final Block.Properties COBALTITE_PROPS = Block.Properties.of().mapColor(MapColor.COLOR_LIGHT_BLUE).strength(1.5F, 6.0F);
    public static final Block.Properties COALSTONE_PROPS = Block.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1.5F, 6.0F);
    public static final Block.Properties ARCANITE_STONE_PROPS = Block.Properties.of().mapColor(MapColor.COLOR_CYAN).strength(1.5F, 6.0F);
    public static final Block.Properties TWILIGHT_STONE_PROPS = Block.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE).strength(1.5F, 6.0F);
    public static final Block.Properties SCORCHALT_PROPS = Block.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).strength(1.5F, 6.0F);
    public static final Block.Properties RAY_STONE_PROPS = Block.Properties.of().mapColor(MapColor.GOLD).strength(1.5F, 6.0F);
    public static final Block.Properties COBBLED_SCORCHALT_PROPS = Block.Properties.of().mapColor(MapColor.TERRACOTTA_PINK).strength(1.5F, 6.0F);

    public static final DeferredBlock<Block> frozenStone = registerBlock("frozen_stone", Block::new, FROZEN_STONE_PROPS);
    public static final DeferredBlock<StairBlock> frozenStairs = registerBlock("frozen_stairs", p -> new PlaceholderStairs(frozenStone, p), Block.Properties.ofFullCopy(Blocks.STONE_STAIRS).mapColor(MapColor.GLOW_LICHEN));
    public static final DeferredBlock<SlabBlock> frozenSlab = registerBlock("frozen_slab", SlabBlock::new, Block.Properties.ofFullCopy(Blocks.STONE_SLAB).mapColor(MapColor.GLOW_LICHEN));
    public static final DeferredBlock<PressurePlateBlock> frozenPressurePlate = registerBlock("frozen_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p), Block.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).mapColor(MapColor.GLOW_LICHEN));
    public static final DeferredBlock<ButtonBlock> frozenButton = registerBlock("frozen_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), Block.Properties.ofFullCopy(Blocks.STONE_BUTTON));

    public static final DeferredBlock<Block> cobaltite = registerBlock("cobaltite", Block::new, COBALTITE_PROPS);
    public static final DeferredBlock<StairBlock> cobaltiteStairs = registerBlock("cobaltite_stairs", p -> new StairBlock(cobaltite.get().defaultBlockState(), p), COBALTITE_PROPS);
    public static final DeferredBlock<SlabBlock> cobaltiteSlab = registerBlock("cobaltite_slab", SlabBlock::new, COBALTITE_PROPS);
    public static final DeferredBlock<WallBlock> cobaltiteWall = registerBlock("cobaltite_wall", WallBlock::new, COBALTITE_PROPS);
    public static final DeferredBlock<PressurePlateBlock> cobaltitePressurePlate = registerBlock("cobaltite_pressure_plate", p -> new PressurePlateBlock(BlockSetType.STONE, p), Block.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).mapColor(MapColor.COLOR_LIGHT_BLUE));
    public static final DeferredBlock<ButtonBlock> cobaltiteButton = registerBlock("cobaltite_button", p -> new ButtonBlock(BlockSetType.STONE, 20, p), Block.Properties.ofFullCopy(Blocks.STONE_BUTTON));

    public static final DeferredBlock<Block> coalstone = registerBlock("coalstone", Block::new, COALSTONE_PROPS);
    public static final DeferredBlock<StairBlock> coalstoneStairs = registerBlock("coalstone_stairs", p -> new PlaceholderStairs(coalstone, p), COALSTONE_PROPS);
    public static final DeferredBlock<SlabBlock> coalstoneSlab = registerBlock("coalstone_slab", SlabBlock::new, COALSTONE_PROPS);
    public static final DeferredBlock<WallBlock> coalstoneWall = registerBlock("coalstone_wall", WallBlock::new, COALSTONE_PROPS);

    public static final DeferredBlock<Block> arcaniteStone = registerBlock("arcanite_stone", Block::new, ARCANITE_STONE_PROPS);
    public static final DeferredBlock<StairBlock> arcaniteStairs = registerBlock("arcanite_stairs", p -> new PlaceholderStairs(arcaniteStone, p), ARCANITE_STONE_PROPS);
    public static final DeferredBlock<SlabBlock> arcaniteSlab = registerBlock("arcanite_slab", SlabBlock::new, ARCANITE_STONE_PROPS);
    public static final DeferredBlock<WallBlock> arcaniteWall = registerBlock("arcanite_wall", WallBlock::new, ARCANITE_STONE_PROPS);

    public static final DeferredBlock<Block> twilightStone = registerBlock("twilight_stone", Block::new, TWILIGHT_STONE_PROPS);
    public static final DeferredBlock<StairBlock> twilightStairs = registerBlock("twilight_stairs", p -> new PlaceholderStairs(twilightStone, p), TWILIGHT_STONE_PROPS);
    public static final DeferredBlock<SlabBlock> twilightSlab = registerBlock("twilight_slab", SlabBlock::new, TWILIGHT_STONE_PROPS);
    public static final DeferredBlock<WallBlock> twilightWall = registerBlock("twilight_wall", WallBlock::new, TWILIGHT_STONE_PROPS);

    public static final DeferredBlock<Block> scorchalt = registerBlock("scorchalt", Block::new, SCORCHALT_PROPS);
    public static final DeferredBlock<StairBlock> scorchaltStairs = registerBlock("scorchalt_stairs", p -> new PlaceholderStairs(scorchalt, p), SCORCHALT_PROPS);
    public static final DeferredBlock<SlabBlock> scorchaltSlab = registerBlock("scorchalt_slab", SlabBlock::new, SCORCHALT_PROPS);
    public static final DeferredBlock<WallBlock> scorchaltWall = registerBlock("scorchalt_wall", WallBlock::new, SCORCHALT_PROPS);

    public static final DeferredBlock<Block> rayStone = registerBlock("ray_stone", Block::new, RAY_STONE_PROPS);
    public static final DeferredBlock<StairBlock> rayStoneStairs = registerBlock("ray_stone_stairs", p -> new PlaceholderStairs(rayStone, p), RAY_STONE_PROPS);
    public static final DeferredBlock<SlabBlock> rayStoneSlab = registerBlock("ray_stone_slab", SlabBlock::new, RAY_STONE_PROPS);
    public static final DeferredBlock<WallBlock> rayStoneWall = registerBlock("ray_stone_wall", WallBlock::new, RAY_STONE_PROPS);

    public static final DeferredBlock<Block> cobbledFrozenStone = registerBlock("cobbled_frozen_stone", Block::new, COBBLED_FROZEN_STONE_PROPS);
    public static final DeferredBlock<StairBlock> cobbledFrozenStairs = registerBlock("cobbled_frozen_stairs", p -> new PlaceholderStairs(cobbledFrozenStone, p), COBBLED_FROZEN_STONE_PROPS);
    public static final DeferredBlock<SlabBlock> cobbledFrozenSlab = registerBlock("cobbled_frozen_slab", SlabBlock::new, COBBLED_FROZEN_STONE_PROPS);
    public static final DeferredBlock<WallBlock> cobbledFrozenWall = registerBlock("cobbled_frozen_wall", WallBlock::new, COBBLED_FROZEN_STONE_PROPS);

    public static final DeferredBlock<Block> cobbledScorchalt = registerBlock("cobbled_scorchalt", Block::new, COBBLED_SCORCHALT_PROPS);
    public static final DeferredBlock<StairBlock> cobbledScorchaltStairs = registerBlock("cobbled_scorchalt_stairs", p -> new PlaceholderStairs(cobbledScorchalt, p), COBBLED_SCORCHALT_PROPS);
    public static final DeferredBlock<SlabBlock> cobbledScorchaltSlab = registerBlock("cobbled_scorchalt_slab", SlabBlock::new, COBBLED_SCORCHALT_PROPS);
    public static final DeferredBlock<WallBlock> cobbledScorchaltWall = registerBlock("cobbled_scorchalt_wall", WallBlock::new, COBBLED_SCORCHALT_PROPS);

    public static final DeferredBlock<Block> frozenDirt = registerBlock("frozen_dirt", Block::new, Block.Properties.of().mapColor(MapColor.ICE).strength(0.5F));
    public static final DeferredBlock<Block> arcaniteDirt = registerBlock("arcanite_dirt", Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).strength(0.5F));
    public static final DeferredBlock<Block> scorchedDirt = registerBlock("scorched_dirt", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLACK).strength(0.5F));
    public static final DeferredBlock<Block> rayDirt = registerBlock("ray_dirt", Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_YELLOW).strength(0.5F));
    public static final DeferredBlock<Block> wildwoodDirt = registerBlock("wildwood_dirt", Block::new, Block.Properties.of().mapColor(MapColor.LAPIS).strength(0.5F));
    public static final DeferredBlock<Block> apalachiaDirt = registerBlock("apalachia_dirt", Block::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_BLUE).strength(0.5F));

    public static final DeferredBlock<Block> frozenGrass = registerBlock("frozen_grass", PlaceholderGrass::new, Block.Properties.of().mapColor(MapColor.DIAMOND));
    public static final DeferredBlock<Block> arcaniteGrass = registerBlock("arcanite_grass", PlaceholderGrass::new, Block.Properties.of().mapColor(MapColor.TERRACOTTA_LIGHT_BLUE));
    public static final DeferredBlock<Block> scorchedGrass = registerBlock("scorched_grass", PlaceholderGrass::new, Block.Properties.of().mapColor(MapColor.COLOR_RED));

    public static final DeferredBlock<Block> realmiteOre = registerBlock("realmite_ore", Block::new, Block.Properties.of().mapColor(MapColor.STONE).strength(3.0F, 3.0F));
    public static final DeferredBlock<Block> realmiteOreDeepslate = registerBlock("realmite_ore_deepslate", Block::new, Block.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE));
    public static final DeferredBlock<Block> arlemiteOre = registerBlock("arlemite_ore", Block::new, Block.Properties.of().mapColor(MapColor.STONE).strength(3.0F, 3.0F));
    public static final DeferredBlock<Block> arlemiteOreDeepslate = registerBlock("arlemite_ore_deepslate", Block::new, Block.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE));
    public static final DeferredBlock<Block> rupeeOre = registerBlock("rupee_ore", Block::new, Block.Properties.of().mapColor(MapColor.STONE).strength(3.0F, 3.0F));
    public static final DeferredBlock<Block> rupeeOreDeepslate = registerBlock("rupee_ore_deepslate", Block::new, Block.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE));

    public static final DeferredBlock<Block> fireCrystal = registerBlock("fire_crystal", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_RED).lightLevel(state -> 15));
    public static final DeferredBlock<Block> firelight = registerBlock("firelight", Block::new, Block.Properties.of().mapColor(MapColor.COLOR_BLUE).lightLevel(state -> 15));
    public static final DeferredBlock<Block> arcanaPortalFrame = registerBlock("arcana_portal_frame", Block::new, Block.Properties.ofFullCopy(Blocks.END_PORTAL_FRAME));

    public static final DeferredBlock<AmethystBlock> olivineBlock = registerBlock("olivine_block", AmethystBlock::new, Block.Properties.ofFullCopy(Blocks.AMETHYST_BLOCK).mapColor(MapColor.COLOR_GREEN).lightLevel((state) -> 1));
    public static final DeferredBlock<Block> bloodgemOre = registerBlock("bloodgem_ore", Block::new, Block.Properties.ofFullCopy(Blocks.NETHER_GOLD_ORE));
    public static final DeferredBlock<Block> torriditeOre = registerBlock("torridite_ore", Block::new, Block.Properties.ofFullCopy(Blocks.NETHER_GOLD_ORE));
    public static final DeferredBlock<Block> bloodgemBlock = registerBlock("bloodgem_block", Block::new, Block.Properties.ofFullCopy(Blocks.NETHERITE_BLOCK));
    public static final DeferredBlock<Block> realmiteBlock = registerBlock("realmite_block", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final DeferredBlock<Block> arlemiteBlock = registerBlock("arlemite_block", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final DeferredBlock<Block> rupeeBlock = registerBlock("rupee_block", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_BLOCK));
    public static final DeferredBlock<Block> torriditeBlock = registerBlock("torridite_block", Block::new, Block.Properties.ofFullCopy(Blocks.IRON_BLOCK));

    public static final DeferredBlock<Block> shiverspineLog = registerBlock("shiverspine_log", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> shiverspineWood = registerBlock("shiverspine_wood", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final DeferredBlock<Block> strippedShiverspineLog = registerBlock("stripped_shiverspine_log", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG));
    public static final DeferredBlock<Block> strippedShiverspineWood = registerBlock("stripped_shiverspine_wood", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD));
    public static final DeferredBlock<Block> shiverspinePlanks = registerBlock("shiverspine_planks", Block::new, Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final DeferredBlock<StairBlock> shiverspineStairs = registerBlock("shiverspine_stairs", p -> new StairBlock(shiverspinePlanks.get().defaultBlockState(), p), Properties.ofFullCopy(Blocks.OAK_STAIRS));
    public static final DeferredBlock<SlabBlock> shiverspineSlab = registerBlock("shiverspine_slab", SlabBlock::new, Properties.ofFullCopy(Blocks.OAK_SLAB));
    public static final DeferredBlock<FenceBlock> shiverspineFence = registerBlock("shiverspine_fence", FenceBlock::new, Properties.ofFullCopy(Blocks.OAK_FENCE));
    public static final DeferredBlock<FenceGateBlock> shiverspineFenceGate = registerBlock("shiverspine_fence_gate", p -> new FenceGateBlock(new WoodType("shiverspine", BlockSetType.OAK), p), Properties.ofFullCopy(Blocks.OAK_FENCE_GATE));
    public static final DeferredBlock<DoorBlock> shiverspineDoor = registerBlock("shiverspine_door", p -> new DoorBlock(BlockSetType.OAK, p), Properties.ofFullCopy(Blocks.OAK_DOOR));
    public static final DeferredBlock<TrapDoorBlock> shiverspineTrapdoor = registerBlock("shiverspine_trapdoor", p -> new TrapDoorBlock(BlockSetType.OAK, p), Properties.ofFullCopy(Blocks.OAK_TRAPDOOR));
    public static final DeferredBlock<PressurePlateBlock> shiverspinePressurePlate = registerBlock("shiverspine_pressure_plate", p -> new PressurePlateBlock(BlockSetType.OAK, p), Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE));
    public static final DeferredBlock<ButtonBlock> shiverspineButton = registerBlock("shiverspine_button", p -> new ButtonBlock(BlockSetType.OAK, 30, p), Properties.ofFullCopy(Blocks.OAK_BUTTON));
    public static final DeferredBlock<Block> brittleLeaves = registerBlock("brittle_leaves", DivineLeavesBlock::new, Properties.ofFullCopy(Blocks.OAK_LEAVES));
    public static final DeferredBlock<Block> shiverspineSapling = registerBlock("shiverspine_sapling", p -> new SaplingBlock(null, p), Properties.ofFullCopy(Blocks.OAK_SAPLING));

    public static final DeferredBlock<Block> auroraoakLog = registerBlock("auroraoak_log", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> auroraoakWood = registerBlock("auroraoak_wood", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final DeferredBlock<Block> strippedAuroraoakLog = registerBlock("stripped_auroraoak_log", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG));
    public static final DeferredBlock<Block> strippedAuroraoakWood = registerBlock("stripped_auroraoak_wood", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD));
    public static final DeferredBlock<Block> auroraoakPlanks = registerBlock("auroraoak_planks", Block::new, Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final DeferredBlock<StairBlock> auroraoakStairs = registerBlock("auroraoak_stairs", p -> new StairBlock(auroraoakPlanks.get().defaultBlockState(), p), Properties.ofFullCopy(Blocks.OAK_STAIRS));
    public static final DeferredBlock<SlabBlock> auroraoakSlab = registerBlock("auroraoak_slab", SlabBlock::new, Properties.ofFullCopy(Blocks.OAK_SLAB));
    public static final DeferredBlock<FenceBlock> auroraoakFence = registerBlock("auroraoak_fence", FenceBlock::new, Properties.ofFullCopy(Blocks.OAK_FENCE));
    public static final DeferredBlock<FenceGateBlock> auroraoakFenceGate = registerBlock("auroraoak_fence_gate", p -> new FenceGateBlock(new WoodType("auroraoak", BlockSetType.OAK), p), Properties.ofFullCopy(Blocks.OAK_FENCE_GATE));
    public static final DeferredBlock<DoorBlock> auroraoakDoor = registerBlock("auroraoak_door", p -> new DoorBlock(BlockSetType.OAK, p), Properties.ofFullCopy(Blocks.OAK_DOOR));
    public static final DeferredBlock<TrapDoorBlock> auroraoakTrapdoor = registerBlock("auroraoak_trapdoor", p -> new TrapDoorBlock(BlockSetType.OAK, p), Properties.ofFullCopy(Blocks.OAK_TRAPDOOR));
    public static final DeferredBlock<PressurePlateBlock> auroraoakPressurePlate = registerBlock("auroraoak_pressure_plate", p -> new PressurePlateBlock(BlockSetType.OAK, p), Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE));
    public static final DeferredBlock<ButtonBlock> auroraoakButton = registerBlock("auroraoak_button", p -> new ButtonBlock(BlockSetType.OAK, 30, p), Properties.ofFullCopy(Blocks.OAK_BUTTON));
    public static final DeferredBlock<Block> auroraoakLeaves = registerBlock("auroraoak_leaves", DivineLeavesBlock::new, Properties.ofFullCopy(Blocks.OAK_LEAVES));
    public static final DeferredBlock<Block> auroraoakSapling = registerBlock("auroraoak_sapling", p -> new SaplingBlock(null, p), Properties.ofFullCopy(Blocks.OAK_SAPLING));

    public static final DeferredBlock<Block> cozybarkLog = registerBlock("cozybark_log", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> cozybarkWood = registerBlock("cozybark_wood", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final DeferredBlock<Block> strippedCozybarkLog = registerBlock("stripped_cozybark_log", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG));
    public static final DeferredBlock<Block> strippedCozybarkWood = registerBlock("stripped_cozybark_wood", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD));
    public static final DeferredBlock<Block> cozybarkPlanks = registerBlock("cozybark_planks", Block::new, Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final DeferredBlock<StairBlock> cozybarkStairs = registerBlock("cozybark_stairs", p -> new StairBlock(cozybarkPlanks.get().defaultBlockState(), p), Properties.ofFullCopy(Blocks.OAK_STAIRS));
    public static final DeferredBlock<SlabBlock> cozybarkSlab = registerBlock("cozybark_slab", SlabBlock::new, Properties.ofFullCopy(Blocks.OAK_SLAB));
    public static final DeferredBlock<FenceBlock> cozybarkFence = registerBlock("cozybark_fence", FenceBlock::new, Properties.ofFullCopy(Blocks.OAK_FENCE));
    public static final DeferredBlock<FenceGateBlock> cozybarkFenceGate = registerBlock("cozybark_fence_gate", p -> new FenceGateBlock(new WoodType("cozybark", BlockSetType.OAK), p), Properties.ofFullCopy(Blocks.OAK_FENCE_GATE));
    public static final DeferredBlock<DoorBlock> cozybarkDoor = registerBlock("cozybark_door", p -> new DoorBlock(BlockSetType.OAK, p), Properties.ofFullCopy(Blocks.OAK_DOOR));
    public static final DeferredBlock<TrapDoorBlock> cozybarkTrapdoor = registerBlock("cozybark_trapdoor", p -> new TrapDoorBlock(BlockSetType.OAK, p), Properties.ofFullCopy(Blocks.OAK_TRAPDOOR));
    public static final DeferredBlock<PressurePlateBlock> cozybarkPressurePlate = registerBlock("cozybark_pressure_plate", p -> new PressurePlateBlock(BlockSetType.OAK, p), Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE));
    public static final DeferredBlock<ButtonBlock> cozybarkButton = registerBlock("cozybark_button", p -> new ButtonBlock(BlockSetType.OAK, 30, p), Properties.ofFullCopy(Blocks.OAK_BUTTON));
    public static final DeferredBlock<Block> cozybarkLeaves = registerBlock("cozybark_leaves", DivineLeavesBlock::new, Properties.ofFullCopy(Blocks.OAK_LEAVES));
    public static final DeferredBlock<Block> cozybarkSapling = registerBlock("cozybark_sapling", p -> new SaplingBlock(null, p), Properties.ofFullCopy(Blocks.OAK_SAPLING));

    public static final DeferredBlock<Block> streamleafLog = registerBlock("streamleaf_log", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> streamleafWood = registerBlock("streamleaf_wood", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final DeferredBlock<Block> strippedStreamleafLog = registerBlock("stripped_streamleaf_log", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG));
    public static final DeferredBlock<Block> strippedStreamleafWood = registerBlock("stripped_streamleaf_wood", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD));
    public static final DeferredBlock<Block> streamleafPlanks = registerBlock("streamleaf_planks", Block::new, Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final DeferredBlock<StairBlock> streamleafStairs = registerBlock("streamleaf_stairs", p -> new StairBlock(streamleafPlanks.get().defaultBlockState(), p), Properties.ofFullCopy(Blocks.OAK_STAIRS));
    public static final DeferredBlock<SlabBlock> streamleafSlab = registerBlock("streamleaf_slab", SlabBlock::new, Properties.ofFullCopy(Blocks.OAK_SLAB));
    public static final DeferredBlock<FenceBlock> streamleafFence = registerBlock("streamleaf_fence", FenceBlock::new, Properties.ofFullCopy(Blocks.OAK_FENCE));
    public static final DeferredBlock<FenceGateBlock> streamleafFenceGate = registerBlock("streamleaf_fence_gate", p -> new FenceGateBlock(new WoodType("streamleaf", BlockSetType.OAK), p), Properties.ofFullCopy(Blocks.OAK_FENCE_GATE));
    public static final DeferredBlock<DoorBlock> streamleafDoor = registerBlock("streamleaf_door", p -> new DoorBlock(BlockSetType.OAK, p), Properties.ofFullCopy(Blocks.OAK_DOOR));
    public static final DeferredBlock<TrapDoorBlock> streamleafTrapdoor = registerBlock("streamleaf_trapdoor", p -> new TrapDoorBlock(BlockSetType.OAK, p), Properties.ofFullCopy(Blocks.OAK_TRAPDOOR));
    public static final DeferredBlock<PressurePlateBlock> streamleafPressurePlate = registerBlock("streamleaf_pressure_plate", p -> new PressurePlateBlock(BlockSetType.OAK, p), Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE));
    public static final DeferredBlock<ButtonBlock> streamleafButton = registerBlock("streamleaf_button", p -> new ButtonBlock(BlockSetType.OAK, 30, p), Properties.ofFullCopy(Blocks.OAK_BUTTON));
    public static final DeferredBlock<Block> streamleafLeaves = registerBlock("streamleaf_leaves", DivineLeavesBlock::new, Properties.ofFullCopy(Blocks.OAK_LEAVES));
    public static final DeferredBlock<Block> streamleafSapling = registerBlock("streamleaf_sapling", p -> new SaplingBlock(null, p), Properties.ofFullCopy(Blocks.OAK_SAPLING));

    public static final DeferredBlock<Block> divineLog = registerBlock("divine_log", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.OAK_LOG));
    public static final DeferredBlock<Block> divineWood = registerBlock("divine_wood", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.OAK_WOOD));
    public static final DeferredBlock<Block> strippedDivineLog = registerBlock("stripped_divine_log", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG));
    public static final DeferredBlock<Block> strippedDivineWood = registerBlock("stripped_divine_wood", RotatedPillarBlock::new, Properties.ofFullCopy(Blocks.STRIPPED_OAK_WOOD));
    public static final DeferredBlock<Block> divinePlanks = registerBlock("divine_planks", Block::new, Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final DeferredBlock<Block> divineRock = registerBlock("divine_rock", Block::new, Properties.ofFullCopy(Blocks.STONE));
    public static final DeferredBlock<StairBlock> divineStairs = registerBlock("divine_stairs", p -> new StairBlock(divinePlanks.get().defaultBlockState(), p), Properties.ofFullCopy(Blocks.OAK_STAIRS));
    public static final DeferredBlock<SlabBlock> divineSlab = registerBlock("divine_slab", SlabBlock::new, Properties.ofFullCopy(Blocks.OAK_SLAB));
    public static final DeferredBlock<FenceBlock> divineFence = registerBlock("divine_fence", FenceBlock::new, Properties.ofFullCopy(Blocks.OAK_FENCE));
    public static final DeferredBlock<FenceGateBlock> divineFenceGate = registerBlock("divine_fence_gate", p -> new FenceGateBlock(new WoodType("divine", BlockSetType.OAK), p), Properties.ofFullCopy(Blocks.OAK_FENCE_GATE));
    public static final DeferredBlock<DoorBlock> divineDoor = registerBlock("divine_door", p -> new DoorBlock(BlockSetType.OAK, p), Properties.ofFullCopy(Blocks.OAK_DOOR));
    public static final DeferredBlock<TrapDoorBlock> divineTrapdoor = registerBlock("divine_trapdoor", p -> new TrapDoorBlock(BlockSetType.OAK, p), Properties.ofFullCopy(Blocks.OAK_TRAPDOOR));
    public static final DeferredBlock<PressurePlateBlock> divinePressurePlate = registerBlock("divine_pressure_plate", p -> new PressurePlateBlock(BlockSetType.OAK, p), Properties.ofFullCopy(Blocks.OAK_PRESSURE_PLATE));
    public static final DeferredBlock<ButtonBlock> divineButton = registerBlock("divine_button", p -> new ButtonBlock(BlockSetType.OAK, 30, p), Properties.ofFullCopy(Blocks.OAK_BUTTON));
    public static final DeferredBlock<Block> divineLeaves = registerBlock("divine_leaves", DivineLeavesBlock::new, Properties.ofFullCopy(Blocks.OAK_LEAVES));
    public static final DeferredBlock<Block> divineSapling = registerBlock("divine_sapling", p -> new SaplingBlock(new TreeGrower("divine", Optional.empty(), Optional.of(FeatureRegistry.DIVINE_TREE_KEY), Optional.empty()), p), Properties.ofFullCopy(Blocks.OAK_SAPLING));

    public static final DeferredBlock<Block> plankDesign = registerBlock("plank_design", Block::new, Properties.ofFullCopy(Blocks.OAK_PLANKS));
    public static final DeferredBlock<StairBlock> stairDesign = registerBlock("stair_design", p -> new StairBlock(plankDesign.get().defaultBlockState(), p), Properties.ofFullCopy(Blocks.OAK_STAIRS));
    public static final DeferredBlock<SlabBlock> slabDesign = registerBlock("slab_design", SlabBlock::new, Properties.ofFullCopy(Blocks.OAK_SLAB));


    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<Properties, T> blockFactory, Block.Properties properties) {
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MODID, name));
        properties.setId(blockKey);
        DeferredBlock<T> block = DivineRegistries.BLOCKS.register(name, () -> blockFactory.apply(properties));
        DivineRegistries.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().setId(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MODID, name)))));
        return block;
    }

    private static class PlaceholderGrass extends Block {
        public PlaceholderGrass(Block.Properties properties) { super(properties); }
    }

    private static class PlaceholderStairs extends StairBlock {
        public PlaceholderStairs(DeferredBlock<? extends Block> baseBlock, Block.Properties properties) {
            super(baseBlock.get().defaultBlockState(), properties);
        }
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
    public static void load() {}
}