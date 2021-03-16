package divinerpg.blocks.base;

import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.*;
import java.util.function.Supplier;

public class BlockModGrass extends BlockMod implements IGrowable {
    protected Supplier<Block> dirtSupplier;

    public BlockModGrass(String name, Supplier<Block> dirt, float hardness, MaterialColor color) {
        super(name, Block.Properties.of(Material.DIRT, color).randomTicks().requiresCorrectToolForDrops().strength(hardness, 3.0F).harvestLevel(0).harvestTool(ToolType.SHOVEL).sound(SoundType.GRASS));
        this.dirtSupplier = dirt;
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

    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        super.tick(state, world, pos, rand);
        if (!world.isClientSide) {
            if (!world.isAreaLoaded(pos, 3))
                return;

            Block dirt = dirtSupplier.get();

            if (world.getLightEmission((pos.above())) < 4
                    && world.getBlockState(pos.above()).getLightValue(world, pos.above()) > 2) {
                world.setBlock(pos, dirt.defaultBlockState(), 0);
            } else {
                for (int l = 0; l < 4; ++l) {
                    BlockPos blockpos = pos.offset(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                    if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !world.isLoaded(blockpos)) {
                        return;
                    }

                    BlockState iblockstate = world.getBlockState(blockpos.above());
                    BlockState iblockstate1 = world.getBlockState(blockpos);

                    if (iblockstate1.getBlock() == dirt && world.getLightEmission(blockpos.above()) >= 4
                            && iblockstate.getLightValue(world, pos.above()) <= 2) {
                        world.setBlock(blockpos, this.defaultBlockState(), 0);
                    }
                }
            }
        }
    }
}
