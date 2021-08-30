package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.tags.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.lighting.*;
import net.minecraft.world.server.*;
import net.minecraftforge.common.*;

import java.util.*;
import java.util.function.*;

public class BlockModGrass extends BlockMod implements IGrowable {
    protected Supplier<Block> dirtSupplier;

    public BlockModGrass(String name, Supplier<Block> dirt, float hardness, MaterialColor colour) {
        super(name, Block.Properties.of(Material.DIRT, colour).randomTicks().requiresCorrectToolForDrops().strength(hardness, 3.0F).harvestLevel(0).harvestTool(ToolType.SHOVEL).sound(SoundType.GRASS));
        this.dirtSupplier = dirt;
    }

    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, IPlantable plantable) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(World p_180670_1_, Random p_180670_2_, BlockPos p_180670_3_, BlockState p_180670_4_) {
        return p_180670_1_.getBlockState(p_180670_3_.above()).isAir();
    }

    @Override
    public boolean isValidBonemealTarget(IBlockReader p_176473_1_, BlockPos p_176473_2_, BlockState p_176473_3_, boolean p_176473_4_) {
        return true;
    }

    @Override
    public void performBonemeal(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = this.defaultBlockState();


        label48:
        for (int i = 0; i < 128; ++i) {
            BlockPos blockpos1 = blockpos;

            for (int j = 0; j < i / 16; ++j) {
                blockpos1 = blockpos1.offset(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                if (!worldIn.getBlockState(blockpos1.below()).is(this) || worldIn.getBlockState(blockpos1).isFertile(worldIn, blockpos1)) {
                    continue label48;
                }
            }

            BlockState blockstate2 = worldIn.getBlockState(blockpos1);
            if (blockstate2.is(blockstate.getBlock()) && rand.nextInt(10) == 0) {
                ((IGrowable) blockstate.getBlock()).performBonemeal(worldIn, rand, blockpos1, blockstate2);
            }

            if (blockstate2.isAir()) {
                BlockState blockstate1;
                if (rand.nextInt(8) == 0) {
                    List<ConfiguredFeature<?, ?>> list = worldIn.getBiome(blockpos1).getGenerationSettings().getFlowerFeatures();
                    if (list.isEmpty()) {
                        continue;
                    }

                    ConfiguredFeature<?, ?> configuredfeature = list.get(0);
                    FlowersFeature flowersfeature = (FlowersFeature) configuredfeature.feature;
                    blockstate1 = flowersfeature.getRandomFlower(rand, blockpos1, configuredfeature.config());
                } else {
                    blockstate1 = blockstate;
                }

                if (blockstate1.canSurvive(worldIn, blockpos1)) {
                    worldIn.setBlock(blockpos1, blockstate1, 3);
                }
            }
        }
    }




    private static boolean canBeGrass(BlockState p_220257_0_, IWorldReader p_220257_1_, BlockPos p_220257_2_) {
        BlockPos blockpos = p_220257_2_.above();
        BlockState blockstate = p_220257_1_.getBlockState(blockpos);
        if (blockstate.is(Blocks.SNOW) && blockstate.getValue(SnowBlock.LAYERS) == 1) {
            return true;
        } else if (blockstate.getFluidState().getAmount() == 8) {
            return false;
        } else {
            int i = LightEngine.getLightBlockInto(p_220257_1_, p_220257_0_, p_220257_2_, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(p_220257_1_, blockpos));
            return i < p_220257_1_.getMaxLightLevel();
        }
    }

    private static boolean canPropagate(BlockState p_220256_0_, IWorldReader p_220256_1_, BlockPos p_220256_2_) {
        BlockPos blockpos = p_220256_2_.above();
        return canBeGrass(p_220256_0_, p_220256_1_, p_220256_2_) && !p_220256_1_.getFluidState(blockpos).is(FluidTags.WATER);
    }

    public void randomTick(BlockState p_225542_1_, ServerWorld p_225542_2_, BlockPos p_225542_3_, Random p_225542_4_) {
        if (!canBeGrass(p_225542_1_, p_225542_2_, p_225542_3_)) {
            if (!p_225542_2_.isAreaLoaded(p_225542_3_, 3)) return; // Forge: prevent loading unloaded chunks when checking neighbor's light and spreading
            p_225542_2_.setBlockAndUpdate(p_225542_3_, dirtSupplier.get().defaultBlockState());
        } else {
            if (p_225542_2_.getMaxLocalRawBrightness(p_225542_3_.above()) >= 9) {
                BlockState blockstate = this.defaultBlockState();

                for(int i = 0; i < 4; ++i) {
                    BlockPos blockpos = p_225542_3_.offset(p_225542_4_.nextInt(3) - 1, p_225542_4_.nextInt(5) - 3, p_225542_4_.nextInt(3) - 1);
                    if (p_225542_2_.getBlockState(blockpos).is(dirtSupplier.get()) && canPropagate(blockstate, p_225542_2_, blockpos)) {
                        p_225542_2_.setBlockAndUpdate(blockpos, blockstate.getBlockState());
                    }
                }
            }

        }
    }
}
