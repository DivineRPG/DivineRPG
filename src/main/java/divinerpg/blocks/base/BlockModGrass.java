package divinerpg.blocks.base;

import divinerpg.DivineRPG;
import net.minecraft.core.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.lighting.LightEngine;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.registries.ForgeRegistries;

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
    @Override
    public boolean canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction facing, IPlantable plantable) {
        Block block = plantable.getPlant(world, pos.above()).getBlock();
        if (block instanceof BushBlock && !(block instanceof WaterlilyBlock) && !(block instanceof CropBlock)) {
            return true;
        }
        return false;
    }
    public BlockState grass() {
        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_grass"))) return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "eden_brush")).defaultBlockState();
        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_grass"))) return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "moonlight_fern")).defaultBlockState();
        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_grass"))) return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_tallgrass")).defaultBlockState();
        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_grass"))) return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_brush")).defaultBlockState();
        if(this == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_grass"))) return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_brush")).defaultBlockState();
        return null;
    }
    public boolean isValidBonemealTarget(LevelReader level, BlockPos pos, BlockState state, boolean b) {
        return level.getBlockState(pos.above()).isAir();
    }
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
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
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
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
