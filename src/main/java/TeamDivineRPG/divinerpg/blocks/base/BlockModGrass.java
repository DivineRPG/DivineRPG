package TeamDivineRPG.divinerpg.blocks.base;

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
        super(name, Block.Properties.create(Material.EARTH, color).tickRandomly().func_235861_h_().hardnessAndResistance(hardness, 3.0F).harvestLevel(0).harvestTool(ToolType.SHOVEL).sound(SoundType.GROUND));
        this.dirtSupplier = dirt;
    }

    @Override
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.up()).isAir();
    }

    @Override
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        BlockPos blockpos = pos.up();
        BlockState blockstate = this.getDefaultState();

        label48:
        for (int i = 0; i < 128; ++i) {
            BlockPos blockpos1 = blockpos;

            for (int j = 0; j < i / 16; ++j) {
                blockpos1 = blockpos1.add(rand.nextInt(3) - 1, (rand.nextInt(3) - 1) * rand.nextInt(3) / 2, rand.nextInt(3) - 1);
                if (!worldIn.getBlockState(blockpos1.down()).isIn(this) || worldIn.getBlockState(blockpos1).func_235785_r_(worldIn, blockpos1)) {
                    continue label48;
                }
            }

            BlockState blockstate2 = worldIn.getBlockState(blockpos1);
            if (blockstate2.isIn(blockstate.getBlock()) && rand.nextInt(10) == 0) {
                ((IGrowable) blockstate.getBlock()).grow(worldIn, rand, blockpos1, blockstate2);
            }

            if (blockstate2.isAir()) {
                BlockState blockstate1;
                if (rand.nextInt(8) == 0) {
                    List<ConfiguredFeature<?, ?>> list = worldIn.getBiome(blockpos1).func_242440_e().func_242496_b();
                    if (list.isEmpty()) {
                        continue;
                    }

                    ConfiguredFeature<?, ?> configuredfeature = list.get(0);
                    FlowersFeature flowersfeature = (FlowersFeature) configuredfeature.feature;
                    blockstate1 = flowersfeature.getFlowerToPlace(rand, blockpos1, configuredfeature.func_242767_c());
                } else {
                    blockstate1 = blockstate;
                }

                if (blockstate1.isValidPosition(worldIn, blockpos1)) {
                    worldIn.setBlockState(blockpos1, blockstate1, 3);
                }
            }
        }
    }

    public void tick(BlockState state, ServerWorld world, BlockPos pos, Random rand) {
        super.tick(state, world, pos, rand);
        if (!world.isRemote) {
            if (!world.isAreaLoaded(pos, 3))
                return;

            Block dirt = dirtSupplier.get();

            if (world.getLight((pos.up())) < 4
                    && world.getBlockState(pos.up()).getOpacity(world, pos.up()) > 2) {
                world.setBlockState(pos, dirt.getDefaultState());
            } else {
                for (int l = 0; l < 4; ++l) {
                    BlockPos blockpos = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                    if (blockpos.getY() >= 0 && blockpos.getY() < 256 && !world.isBlockLoaded(blockpos)) {
                        return;
                    }

                    BlockState iblockstate = world.getBlockState(blockpos.up());
                    BlockState iblockstate1 = world.getBlockState(blockpos);

                    if (iblockstate1.getBlock() == dirt && world.getLight(blockpos.up()) >= 4
                            && iblockstate.getOpacity(world, pos.up()) <= 2) {
                        world.setBlockState(blockpos, this.getDefaultState());
                    }
                }
            }
        }
    }
}
