package divinerpg.data;

import com.google.common.collect.Maps;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.BlockFamily;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.Nullable;

import java.util.Map;
import java.util.function.*;
import java.util.stream.Stream;

import static divinerpg.registries.BlockRegistry.*;

public class ModBlockFamilies {
    private static final Map<Block, BlockFamily> MAP = Maps.newHashMap();
    private static final String
        RECIPE_GROUP_PREFIX_WOODEN = "wooden",
        RECIPE_GROUP_PREFIX_WOOLEN = "woolen",
        RECIPE_UNLOCKED_BY_HAS_PLANKS = "has_planks";
    @SuppressWarnings("unused")
    public static final BlockFamily
        PLANK_DESIGN = familyBuilder(plankDesign.get()).stairs(stairDesign.get()).slab(slabDesign.get()).recipeGroupPrefix(RECIPE_GROUP_PREFIX_WOODEN).recipeUnlockedBy(RECIPE_UNLOCKED_BY_HAS_PLANKS).getFamily(),
        DIVINE_PLANKS = createWoodFamily(divine),
        SHIVERSPINE_PLANKS = createWoodFamily(shiverspine),
        AURORAOAK_PLANKS = createWoodFamily(auroraoak),
        COZYBARK_PLANKS = createWoodFamily(cozybark),
        STREAMLEAF_PLANKS = createWoodFamily(streamleaf),
        EUCALYPTUS_PLANKS = familyBuilder(eucalyptus.planks().get()).log(eucalyptus.log().get()).strippedLog(eucalyptus.strippedLog().get()).stairs(eucalyptus.stairs().get()).slab(eucalyptus.slab().get()).fence(eucalyptus.fence().get()).fenceGate(eucalyptus.gate().get()).door(eucalyptus.door().get()).trapdoor(eucalyptus.trapdoor().get()).pressurePlate(eucalyptus.pressurePlate().get()).button(eucalyptus.button().get()).sign(eucalyptus.sign().get(), eucalyptus.wallSign().get()).hangingSign(eucalyptus.hangingSign().get(), eucalyptus.wallHangingSign().get()).recipeGroupPrefix(RECIPE_GROUP_PREFIX_WOODEN).recipeUnlockedBy(RECIPE_UNLOCKED_BY_HAS_PLANKS).getFamily(),
        EDEN_PLANKS = createWoodFamily(eden),
        CRIMSEEKER_PLANKS = createWoodFamily(crimseeker),
        WILDWOOD_PLANKS = createWoodFamily(wildwood),
        APALACHIA_PLANKS = createWoodFamily(apalachia),
        SKYTHERN_PLANKS = createWoodFamily(skythern),
        MORTUM_PLANKS = createWoodFamily(mortum),
        DARKSTONE = simpleBrickFamily(darkstone, darkstoneBricks),
        MILK_STONE = simpleBrickFamily(milkStone, milkStoneBricks),
        ASPHALT = familyBuilder(asphalt.block().get()).stairs(asphalt.stairs().get()).slab(asphalt.slab().get()).generateStonecutterRecipe().getFamily(),
        FROZEN_STONE = stoneFamily(frozen, b -> b.cobbled(cobbledFrozen.block().get()).bricks(frozenBrick.block().get())),
        COBBLED_FROZEN_STONE = stoneFamily(cobbledFrozen),
        FROZEN_BRICKS = stoneFamily(frozenBrick),
        COBALTITE = stoneFamily(cobaltite, b -> b.polished(polishedCobaltite.block().get())),
        POLISHED_COBALTITE = stoneFamily(polishedCobaltite),
        COALSTONE = stoneFamily(coalstone, b -> b.polished(polishedCoalstone.block().get())),
        POLISHED_COALSTONE = stoneFamily(polishedCoalstone, b -> b.bricks(coalstoneBrick.block().get())),
        COALSTONE_BRICKS = stoneFamily(coalstoneBrick, b -> b.chiseled(chiseledCoalstoneBricks.get())),
        OXDRITE = familyBuilder(oxdrite.block().get()).cut(cutOxdrite.block().get()).generateStonecutterRecipe().getFamily(),
        CUT_OXDRITE = stoneFamily(cutOxdrite),
        ARCANITE_STONE = stoneFamily(arcanite, b -> b.tiles(arcaniteTile.block().get())),
        ARCANITE_TILES = stoneFamily(arcaniteTile),
        ANCIENT_BRICKS = familyBuilder(ancientBrick.block().get()).stairs(ancientBrick.stairs().get()).slab(ancientBrick.slab().get()).wall(ancientBrick.wall().get()).dontGenerateCraftingRecipe().dontGenerateSmeltingRecipe().getFamily(),
        ANCIENT_BRICKS_BREAKABLE = familyBuilder(ancientBrick.blockBreakable().get()).stairs(ancientBrick.stairsBreakable().get()).slab(ancientBrick.slabBreakable().get()).wall(ancientBrick.wallBreakable().get()).generateStonecutterRecipe().getFamily(),
        DEGRADED_BRICKS = familyBuilder(degradedBrick.block().get()).stairs(degradedBrick.stairs().get()).slab(degradedBrick.slab().get()).wall(degradedBrick.wall().get()).dontGenerateCraftingRecipe().dontGenerateSmeltingRecipe().getFamily(),
        DEGRADED_BRICKS_BREAKABLE = familyBuilder(degradedBrick.blockBreakable().get()).stairs(degradedBrick.stairsBreakable().get()).slab(degradedBrick.slabBreakable().get()).wall(degradedBrick.wallBreakable().get()).generateStonecutterRecipe().getFamily(),
        TWILIGHT_STONE = stoneFamily(twilight, b -> b.bricks(twilightBrick.block().get())),
        TWILIGHT_BRICKS = stoneFamily(twilightBrick),
        SCORCHALT = stoneFamily(scorchalt, b -> b.cobbled(cobbledScorchalt.block().get()).polished(polishedScorchalt.block().get())),
        COBBLED_SCORCHALT = stoneFamily(cobbledScorchalt, b -> b.chiseled(chiseledScorchalt.get())),
        POLISHED_SCORCHALT = stoneFamily(polishedScorchalt),
        RAY_STONE = stoneFamily(rayStone, b -> b.polished(polishedRayStone.block().get())),
        POLISHED_RAY_STONE = stoneFamily(polishedRayStone),
        CHECKER = createWoolFamily(checker),
        RAINBOW_WOOL = createWoolFamily(rainbow),
        FANCY_WOOL = createWoolFamily(fancy),
        WORKSHOP_CARPET = familyBuilder(workshopCarpet.block().get()).stairs(workshopCarpet.stairs().get()).slab(workshopCarpet.slab().get()).recipeGroupPrefix(RECIPE_GROUP_PREFIX_WOOLEN).getFamily();
    public static Stream<BlockFamily> getAllFamilies() {
        return MAP.values().stream();
    }
    public static @Nullable BlockFamily getFamily(Block base) {
        return MAP.get(base);
    }
    private static BlockFamily.Builder familyBuilder(Block base) {
        BlockFamily.Builder builder = new BlockFamily.Builder(base);
        BlockFamily blockFamily = MAP.put(base, builder.getFamily());
        if(blockFamily != null) throw new IllegalStateException("Duplicate family definition for " + BuiltInRegistries.BLOCK.getKey(base));
        else return builder;
    }
    private static BlockFamily createWoodFamily(Tree tree) {
        return familyBuilder(tree.planks().get()).log(tree.log().get()).strippedLog(tree.strippedLog().get()).stairs(tree.stairs().get()).slab(tree.slab().get()).fence(tree.fence().get()).fenceGate(tree.gate().get()).door(tree.door().get()).trapdoor(tree.trapdoor().get()).pressurePlate(tree.pressurePlate().get()).button(tree.button().get()).sign(tree.sign().get(), tree.wallSign().get()).hangingSign(tree.hangingSign().get(), tree.wallHangingSign().get()).recipeGroupPrefix(RECIPE_GROUP_PREFIX_WOODEN).recipeUnlockedBy(RECIPE_UNLOCKED_BY_HAS_PLANKS).getFamily();
    }
    private static BlockFamily stoneFamily(RockSet set, UnaryOperator<BlockFamily.Builder> config) {
        BlockFamily.Builder builder = familyBuilder(set.block().get()).stairs(set.stairs().get()).slab(set.slab().get()).wall(set.wall().get()).pressurePlate(set.pressurePlate().get()).button(set.button().get()).generateStonecutterRecipe();
        return config.apply(builder).getFamily();
    }
    private static BlockFamily stoneFamily(RockSet set) {
        return stoneFamily(set, builder -> builder);
    }
    private static BlockFamily simpleBrickFamily(Supplier<? extends Block> base, Supplier<? extends Block> bricks) {
        return familyBuilder(base.get()).bricks(bricks.get()).generateStonecutterRecipe().getFamily();
    }
    private static BlockFamily createWoolFamily(WoolSet set) {
        BlockFamily.Builder builder = familyBuilder(set.wool().get()).stairs(set.stairs().get()).slab(set.slab().get()).recipeGroupPrefix(RECIPE_GROUP_PREFIX_WOOLEN);
        if(set.carpet() != null) builder.carpet(set.carpet().get());
        return builder.getFamily();
    }
}