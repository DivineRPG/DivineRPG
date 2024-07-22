package divinerpg.blocks.base;

import divinerpg.registries.BlockRegistry;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.lighting.LightEngine;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Supplier;

public class BlockModGrass extends BlockMod implements BonemealableBlock {
    protected final Supplier<Block> dirtSupplier;
    public BlockModGrass(Supplier<Block> dirt, MapColor colour) {
        super(Block.Properties.of().mapColor(colour).randomTicks().strength(0.6F).sound(SoundType.GRASS));
        dirtSupplier = dirt;
    }
    public BlockModGrass(Supplier<Block> dirt) {
        super(Block.Properties.of().mapColor(MapColor.COLOR_CYAN).randomTicks().strength(2F, 6F).sound(SoundType.NYLIUM).instrument(NoteBlockInstrument.BASEDRUM));
        dirtSupplier = dirt;
    }
//    @Override
//    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
//        Block block = plantable.getPlant(world, pos.above()).getBlock();
//        if (block instanceof BushBlock && !(block instanceof WaterlilyBlock) && !(block instanceof CropBlock)) {
//            return true;
//        }
//        return false;
//    }
    public BlockState grass() {
        if(this == BlockRegistry.edenGrass.get()) return BlockRegistry.edenBrush.get().defaultBlockState();
        if(this == BlockRegistry.wildwoodGrass.get()) return BlockRegistry.moonlightFern.get().defaultBlockState();
        if(this == BlockRegistry.apalachiaGrass.get()) return BlockRegistry.apalachiaTallgrass.get().defaultBlockState();
        if(this == BlockRegistry.skythernGrass.get()) return BlockRegistry.skythernBrush.get().defaultBlockState();
        if(this == BlockRegistry.mortumGrass.get()) return BlockRegistry.mortumBrush.get().defaultBlockState();
        return null;
    }
    @Override public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state) {
        return level.getBlockState(pos.above()).isAir();
    }
    @Override public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }
    @Override public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
    	BlockState myState = defaultBlockState();
		place(level, random, pos.above(), myState);
		place(level, random, pos.below(), myState);
		place(level, random, pos.north(), myState);
		place(level, random, pos.east(), myState);
		place(level, random, pos.south(), myState);
		place(level, random, pos.west(), myState);
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
    private static boolean canBeGrass(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.above();
        BlockState blockstate = level.getBlockState(blockpos);
        if(blockstate.is(Blocks.SNOW) || blockstate.is(Blocks.SNOW_BLOCK) || blockstate.is(Blocks.POWDER_SNOW)) return true;
        else if(blockstate.getFluidState().getAmount() == 8) return false;
        else {
            int i = LightEngine.getLightBlockInto(level, state, pos, blockstate, blockpos, Direction.UP, blockstate.getLightBlock(level, blockpos));
            return i < level.getMaxLightLevel();
        }
    }
    private static boolean canPropagate(BlockState state, LevelReader level, BlockPos pos) {
        return canBeGrass(state, level, pos) && !level.getFluidState(pos.above()).is(FluidTags.WATER);
    }
    @Override public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(!canBeGrass(state, level, pos)) level.setBlockAndUpdate(pos, dirtSupplier.get().defaultBlockState());
        else if(level.getMaxLocalRawBrightness(pos.above()) >= 9) {
        	BlockState blockstate = defaultBlockState();
        	for(int i = 0; i < 4; ++i) {
        		BlockPos blockpos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
        		if(level.getBlockState(blockpos).is(dirtSupplier.get()) && canPropagate(blockstate, level, blockpos));
        	}
        }
    }
}
