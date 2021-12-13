package divinerpg.world.surface;

import com.mojang.serialization.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.tags.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.chunk.*;
import net.minecraft.world.gen.surfacebuilders.*;

import java.util.*;

public class IceikaSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    protected static final BlockState PACKED_ICE = Blocks.PACKED_ICE.defaultBlockState();
    protected static final BlockState SNOW = Blocks.SNOW.defaultBlockState();
    protected static final BlockState STONE = BlockRegistry.frozenStone.defaultBlockState();
    protected static final BlockState DIRT = BlockRegistry.frozenDirt.defaultBlockState();
    protected static final BlockState GRASS = BlockRegistry.frozenGrass.defaultBlockState();
    protected static final BlockState AIR = Blocks.AIR.defaultBlockState();

    public IceikaSurfaceBuilder(Codec<SurfaceBuilderConfig> p_i232126_1_) {
        super(p_i232126_1_);
    }

    public void apply(Random random, IChunk chunk, Biome biome, int posX, int posZ, int startHeight, double noiseAmp, BlockState block, BlockState fluid, int sea, long seed, SurfaceBuilderConfig config) {
        this.apply(random, chunk, biome, posX, posZ, startHeight, noiseAmp, block, fluid, config.getTopMaterial(), config.getUnderMaterial(), config.getUnderwaterMaterial(), sea);
    }

    protected void apply(Random random, IChunk chunk, Biome biome, int p_206967_4_, int p_206967_5_, int p_206967_6_, double p_206967_7_, BlockState p_206967_9_, BlockState p_206967_10_, BlockState p_206967_11_, BlockState p_206967_12_, BlockState p_206967_13_, int p_206967_14_) {
        BlockState blockstate = p_206967_11_;
        BlockState blockstate1 = p_206967_12_;
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        int i = -1;
        int j = (int)(p_206967_7_ / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        int k = p_206967_4_ & 15;
        int l = p_206967_5_ & 15;

        for(int i1 = p_206967_6_; i1 >= 0; --i1) {
            blockpos$mutable.set(k, i1, l);
            BlockState blockstate2 = chunk.getBlockState(blockpos$mutable);
            if (blockstate2.isAir()) {
                i = -1;
            } else if (blockstate2.is(p_206967_9_.getBlock())) {
                if (i == -1) {
                    if (j <= 0) {
                        blockstate = Blocks.AIR.defaultBlockState();
                        blockstate1 = p_206967_9_;
                    } else if (i1 >= p_206967_14_ - 4 && i1 <= p_206967_14_ + 1) {
                        blockstate = p_206967_11_;
                        blockstate1 = p_206967_12_;
                    }

                    if (i1 < p_206967_14_ && (blockstate == null || blockstate.isAir())) {
                        if (biome.getTemperature(blockpos$mutable.set(p_206967_4_, i1, p_206967_5_)) < 0.15F) {
                            blockstate = Blocks.ICE.defaultBlockState();
                        } else {
                            blockstate = p_206967_10_;
                        }

                        blockpos$mutable.set(k, i1, l);
                    }

                    i = j;
                    if (i1 >= p_206967_14_ - 1) {
                        chunk.setBlockState(blockpos$mutable, blockstate, false);
                    } else if (i1 < p_206967_14_ - 7 - j) {
                        blockstate = Blocks.AIR.defaultBlockState();
                        blockstate1 = p_206967_9_;
                        chunk.setBlockState(blockpos$mutable, p_206967_13_, false);
                    } else {
                        chunk.setBlockState(blockpos$mutable, blockstate1, false);
                    }
                } else if (i > 0) {
                    --i;
                    chunk.setBlockState(blockpos$mutable, blockstate1, false);
                    if (i == 0 && blockstate1.is(Blocks.SAND) && j > 1) {
                        i = random.nextInt(4) + Math.max(0, i1 - 63);
                        blockstate1 = blockstate1.is(Blocks.RED_SAND) ? Blocks.RED_SANDSTONE.defaultBlockState() : Blocks.SANDSTONE.defaultBlockState();
                    }
                }
                if(chunk.getBlockState(blockpos$mutable).is(Blocks.STONE)){
                    chunk.setBlockState(blockpos$mutable, STONE, false);
                }
                if(chunk.getBlockState(blockpos$mutable).is(Blocks.WATER)){
                    chunk.setBlockState(blockpos$mutable, PACKED_ICE, false);
                }
                if(chunk.getBlockState(blockpos$mutable).is(BlockRegistry.frozenGrass)){
                    chunk.setBlockState(blockpos$mutable.above(), SNOW, false);
                }

                if(chunk.getBlockState(blockpos$mutable).is(BlockRegistry.frozenGrass) && random.nextInt(240) == 0) {
                    int treeHeight = 12;
                    int extraHeight = treeHeight + random.nextInt(1) + 1;
                    BlockPos pos = blockpos$mutable;
                    if (!heightCheck(chunk, pos, extraHeight + 4, 1)) {


                        BlockPos.Mutable mut = new BlockPos.Mutable().set(pos.below());
                        BlockState log = BlockRegistry.frozenLog.defaultBlockState();
                        BlockState leaves = BlockRegistry.brittleLeaves.defaultBlockState();


                        //Tree trunk
                        for (int g = 0; g < extraHeight; g++) {
                            chunk.setBlockState(mut.move(Direction.UP), log, false);
                        }
                        chunk.setBlockState(pos.offset(1, 0, 0), log, false);
                        chunk.setBlockState(pos.offset(0, 0, 1), log,  false);
                        chunk.setBlockState(pos.offset(-1, 0, 0), log,  false);
                        chunk.setBlockState(pos.offset(0, 0, -1), log,  false);

                        //Leaves
                        chunk.setBlockState(pos.offset(1, treeHeight - 3, 0), leaves, false);
                        chunk.setBlockState(pos.offset(1, treeHeight - 2, 0), leaves, false);
                        chunk.setBlockState(pos.offset(1, treeHeight - 1, 0), leaves, false);
                        chunk.setBlockState(pos.offset(1, treeHeight, 0), leaves, false);
                        chunk.setBlockState(pos.offset(1, treeHeight + 1, 0), leaves, false);
                        chunk.setBlockState(pos.offset(1, treeHeight + 2, 0), leaves, false);

                        chunk.setBlockState(pos.offset(-1, treeHeight - 3, 0), leaves, false);
                        chunk.setBlockState(pos.offset(-1, treeHeight - 2, 0), leaves, false);
                        chunk.setBlockState(pos.offset(-1, treeHeight - 1, 0), leaves, false);
                        chunk.setBlockState(pos.offset(-1, treeHeight, 0), leaves, false);
                        chunk.setBlockState(pos.offset(-1, treeHeight + 1, 0), leaves, false);
                        chunk.setBlockState(pos.offset(-1, treeHeight + 2, 0), leaves, false);

                        chunk.setBlockState(pos.offset(0, treeHeight - 3, 1), leaves, false);
                        chunk.setBlockState(pos.offset(0, treeHeight - 2, 1), leaves, false);
                        chunk.setBlockState(pos.offset(0, treeHeight - 1, 1), leaves, false);
                        chunk.setBlockState(pos.offset(0, treeHeight, 1), leaves, false);
                        chunk.setBlockState(pos.offset(0, treeHeight + 1, 1), leaves, false);

                        chunk.setBlockState(pos.offset(0, treeHeight - 3, -1), leaves, false);
                        chunk.setBlockState(pos.offset(0, treeHeight - 2, -1), leaves, false);
                        chunk.setBlockState(pos.offset(0, treeHeight - 1, -1), leaves, false);
                        chunk.setBlockState(pos.offset(0, treeHeight, -1), leaves, false);
                        chunk.setBlockState(pos.offset(0, treeHeight + 1, -1), leaves, false);
                        chunk.setBlockState(pos.offset(0, treeHeight + 2, -1), leaves, false);

                        chunk.setBlockState(pos.offset(0, treeHeight, 0), leaves, false);
                        chunk.setBlockState(pos.offset(0, treeHeight + 1, 0), leaves, false);
                        chunk.setBlockState(pos.offset(0, treeHeight + 2, 0), leaves, false);
                        chunk.setBlockState(pos.offset(0, treeHeight + 3, 0), leaves, false);
                    }
                }
            }

        }

    }
    protected boolean heightCheck(IChunk world, BlockPos pos, int maxHeight, int width) {
        if (pos.getY() >= 1 && pos.getY() + maxHeight < 256) {
            for (int i = 1; i <= maxHeight; i++) {
                for (int x = 0; x < width; x++) {
                    for (int z = 0; z < width; z++) {
                        if (!hasSpace(world, pos.offset(x, i, z)))
                            return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
    protected static boolean hasSpace(IChunk world, BlockPos pos) {
        BlockState oldState = world.getBlockState(pos);
        Block oldBlock = oldState.getBlock();
        return oldBlock.isAir(oldState, world, pos) || oldBlock.is(BlockTags.LEAVES) || oldBlock.is(BlockTags.FLOWERS);
    }
}