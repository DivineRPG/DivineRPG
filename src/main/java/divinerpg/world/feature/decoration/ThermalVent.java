package divinerpg.world.feature.decoration;

import divinerpg.DivineRPG;
import divinerpg.blocks.iceika.BlockThermalVent;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.ForgeRegistries;

public class ThermalVent extends Feature<NoneFeatureConfiguration> {
	public ThermalVent() {super(NoneFeatureConfiguration.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		return place(null, context.level(), null, context.random(), context.origin());
	}
	@Override
	public boolean place(NoneFeatureConfiguration c, WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
		BlockState state = level.getBlockState(pos);
		if(state.isAir()) {
			state = level.getBlockState(pos.below());
			if(!state.isAir() && !state.is(Blocks.WATER)) {
				setBlock(level, pos.below(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "coalstone")).defaultBlockState());
				setBlock(level, pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "thermal_vent")).defaultBlockState().setValue(BlockThermalVent.WATERLOGGED, false));
				return true;
			}
		} else if(state.is(Blocks.WATER)) {
			state = level.getBlockState(pos.below());
			if(!state.isAir() && !state.is(Blocks.WATER)) {
				setBlock(level, pos.below(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "coalstone")).defaultBlockState());
				setBlock(level, pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "thermal_vent")).defaultBlockState());
				return true;
			}
		} else {
			state = level.getBlockState(pos.above());
			if(state.isAir()) {
				setBlock(level, pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "coalstone")).defaultBlockState());
				setBlock(level, pos.above(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "thermal_vent")).defaultBlockState().setValue(BlockThermalVent.WATERLOGGED, false));
				return true;
			} else if(state.is(Blocks.WATER)) {
				setBlock(level, pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "coalstone")).defaultBlockState());
				setBlock(level, pos.above(), ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "thermal_vent")).defaultBlockState());
				return true;
			}
		}
		return false;
	}
}