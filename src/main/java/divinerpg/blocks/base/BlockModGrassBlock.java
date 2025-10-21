package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.lighting.LightEngine;
import net.minecraft.world.level.material.MapColor;
import java.util.function.Supplier;

import static divinerpg.registries.BlockRegistry.*;
import static net.minecraft.world.level.block.Blocks.*;
import static net.minecraft.world.level.material.MapColor.COLOR_CYAN;

public class BlockModGrassBlock extends GrassBlock {
    private final boolean requiresLightToRegrow;
    protected final Supplier<Block> dirtSupplier;
    public BlockModGrassBlock(Supplier<Block> dirt, MapColor color, boolean requiresLightToRegrow) {
        super(Properties.ofFullCopy(GRASS_BLOCK).mapColor(color));
        dirtSupplier = dirt;
        this.requiresLightToRegrow = requiresLightToRegrow;
    }
    public BlockModGrassBlock(Supplier<Block> dirt, MapColor color) {
        this(dirt, color, true);
    }
    public BlockModGrassBlock(Supplier<Block> dirt) {
        super(Properties.ofFullCopy(CRIMSON_NYLIUM).mapColor(COLOR_CYAN).strength(2, 6));
        dirtSupplier = dirt;
        requiresLightToRegrow = false;
    }
    public BlockState grass() {
        if(this == rayGrass.get()) return edenBrush.get().defaultBlockState();
        if(this == wildwoodGrass.get()) return moonlightFern.get().defaultBlockState();
        if(this == apalachiaGrass.get()) return apalachiaTallgrass.get().defaultBlockState();
        if(this == skythernGrass.get()) return skythernBrush.get().defaultBlockState();
        if(this == mortumGrass.get()) return mortumBrush.get().defaultBlockState();
        return null;
    }
    public void place(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        if(random.nextBoolean()) pos = pos.relative(Direction.getRandom(random));
        BlockPos above = pos.above();
        if(canPropagate(state, level, pos)) {
            if(level.getBlockState(pos).is(dirtSupplier.get())) level.setBlock(pos, state, 3);
            else if(level.getBlockState(pos).is(this)) {
                BlockState grass = grass();
                if(grass != null) level.setBlock(above, grass, 3);
            }
        }
    }
    //TODO: to do it the way vanilla does that
    @Override public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
    	BlockState myState = defaultBlockState();
		place(level, random, pos.above(), myState);
		place(level, random, pos.below(), myState);
		place(level, random, pos.north(), myState);
		place(level, random, pos.east(), myState);
		place(level, random, pos.south(), myState);
		place(level, random, pos.west(), myState);
    }
    //TODO: to force grass blocks turn into dirt when a tree grows on top of them
    private static boolean canBeGrass(BlockState state, LevelReader levelReader, BlockPos pos) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = levelReader.getBlockState(blockpos);
        if(blockstate.is(Blocks.SNOW) && (blockstate.getValue(SnowLayerBlock.LAYERS) == 1 || state.getBlock() == frozenGrass.get())) return true;
        else if(blockstate.getFluidState().getAmount() == 8) return false;
        else {
            int i = LightEngine.getLightBlockInto(levelReader, state, pos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(levelReader, blockpos));
            return i < levelReader.getMaxLightLevel();
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