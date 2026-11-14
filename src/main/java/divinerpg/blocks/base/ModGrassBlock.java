package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;

import java.util.function.Supplier;

import static divinerpg.registries.BlockRegistry.*;

public class ModGrassBlock extends GrassBlock {
    private final boolean requiresLightToRegrow;
    protected final Supplier<Block> dirtSupplier, grass;
    public ModGrassBlock(Properties p, Supplier<Block> dirt) {
        this(p, dirt, null, true);
    }
    public ModGrassBlock(Properties p, Supplier<Block> dirt, boolean requiresLightToRegrow) {
        this(p, dirt, null, requiresLightToRegrow);
    }
    public ModGrassBlock(Properties p, Supplier<Block> dirt, Supplier<Block> grass) {
        this(p, dirt, grass, true);
    }
    public ModGrassBlock(Properties p, Supplier<Block> dirt, Supplier<Block> grass, boolean requiresLightToRegrow) {
        super(p);
        dirtSupplier = dirt;
        this.grass = grass;
        this.requiresLightToRegrow = requiresLightToRegrow;
    }
    public void place(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if(random.nextBoolean()) pos = pos.relative(Direction.getRandom(random));
        BlockPos above = pos.above();
        if(canPropagate(state, level, pos)) {
            if(level.getBlockState(pos).is(dirtSupplier.get())) level.setBlock(pos, state, 3);
            else if(grass != null && level.getBlockState(pos).is(this)) level.setBlock(above, grass.get().defaultBlockState(), 3);
        }
    }
    //TODO: to do it the way vanilla does that
    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state, BonemealSource source) {
        BlockState myState = defaultBlockState();
        place(level, random, pos.above(), myState);
        place(level, random, pos.below(), myState);
        place(level, random, pos.north(), myState);
        place(level, random, pos.east(), myState);
        place(level, random, pos.south(), myState);
        place(level, random, pos.west(), myState);
        super.performBonemeal(level, random, pos, state, source);
    }

    //TODO: to force grass blocks turn into dirt when a tree grows on top of them
    private static boolean canBeGrass(BlockState state, LevelReader levelReader, BlockPos pos) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = levelReader.getBlockState(blockpos);
        if(blockstate.is(Blocks.SNOW) && (blockstate.getValue(SnowLayerBlock.LAYERS) == 1 || state.getBlock() == frozenSoil.getLast().get())) return true;
        else if(blockstate.getFluidState().getAmount() == 8) return false;
        else {
            int lightDampeningTopFace = LightEngine.getLightDampeningInto(state, blockstate, Direction.UP, blockstate.getLightDampening());
            return lightDampeningTopFace < 15;
        }
    }
    private static boolean canPropagate(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.above();
        return canBeGrass(state, level, pos) && !level.getFluidState(blockpos).is(FluidTags.WATER);
    }
    @Override protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(!canBeGrass(state, level, pos)) {
            if(!level.isAreaLoaded(pos, 1)) return;
            level.setBlockAndUpdate(pos, dirtSupplier.get().defaultBlockState());
        } else {
            if(!level.isAreaLoaded(pos, 3)) return;
            if(level.getMaxLocalRawBrightness(pos.above()) >= 9 || !requiresLightToRegrow) {
                BlockState blockstate = defaultBlockState();
                for(int i = 0; i < 4; ++i) {
                    BlockPos blockpos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if(level.getBlockState(blockpos).is(dirtSupplier.get()) && canPropagate(blockstate, level, blockpos))
                        level.setBlockAndUpdate(blockpos, blockstate.setValue(SNOWY, level.getBlockState(blockpos.above()).is(Blocks.SNOW)));
                }
            }
        }
    }
}