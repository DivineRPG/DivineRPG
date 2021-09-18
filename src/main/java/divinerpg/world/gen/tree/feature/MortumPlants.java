package divinerpg.world.gen.tree.feature;

import com.mojang.serialization.*;
import divinerpg.blocks.base.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.state.properties.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;

import java.util.*;

public class MortumPlants extends Feature<BlockStateProvidingFeatureConfig> {
    public MortumPlants(Codec<BlockStateProvidingFeatureConfig> codec) {
        super(codec);
    }

    public boolean place(ISeedReader world, ChunkGenerator chunk, Random random, BlockPos pos, BlockStateProvidingFeatureConfig config) {
        return place(world, random, pos, config, 8, 4);
    }

    public static boolean place(IWorld world, Random random, BlockPos pos, BlockStateProvidingFeatureConfig config, int min, int max) {
        Block block = world.getBlockState(pos.below()).getBlock();
        if (!block.is(BlockRegistry.mortumGrass)) {
            return false;
        } else {
            int i = pos.getY();
            if (i >= 1 && i + 1 < 256 ) {
                int j = 0;

                for(int k = 0; k < min * min; ++k) {
                    BlockPos blockpos = pos.offset(random.nextInt(min) - random.nextInt(min), random.nextInt(max) - random.nextInt(max), random.nextInt(min) - random.nextInt(min));
                    BlockState blockstate = config.stateProvider.getState(random, blockpos);
                    if(world.getBlockState(blockpos.below()) == config.stateProvider.getState(random, blockpos) && world.getBlockState(blockpos.below()).getBlock() instanceof BlockModDoublePlant){
                        blockstate = world.getBlockState(blockpos.below()).setValue(BlockStateProperties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.UPPER);
                    }
                    if (world.isEmptyBlock(blockpos) && blockpos.getY() > 0 && blockstate.canSurvive(world, blockpos) && !world.getBlockState(blockpos.below()).is(Blocks.AIR) && blockstate != null) {
                        world.setBlock(blockpos, blockstate, 2);
                        ++j;
                    }
                }

                return j > 0;
            } else {
                return false;
            }
        }
    }
}