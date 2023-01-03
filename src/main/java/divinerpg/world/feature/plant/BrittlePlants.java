package divinerpg.world.feature.plant;

import divinerpg.DivineRPG;
import divinerpg.blocks.iceika.BlockBrittleGrass;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.ForgeRegistries;

public class BrittlePlants extends Feature<NoneFeatureConfiguration> {
	public BrittlePlants() {super(NoneFeatureConfiguration.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		return place(null, context.level(), null, context.random(), context.origin());
	}
	@Override
	public boolean place(NoneFeatureConfiguration c, WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
		if(level.getBlockState(pos).is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "brittle_moss")))) {
			BlockPos p;
			if(level.getBlockState(p = pos.above()).isAir() && random.nextBoolean()) setBlock(level, p, random.nextBoolean() ? ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry_bush")).defaultBlockState() : ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "brittle_grass")).defaultBlockState());
			else if(level.getBlockState(p = pos.below()).isAir()) {
				if(random.nextBoolean()) {
					int length = random.nextInt(4);
					for(int i = 0; i < length && level.getBlockState(p.below()).isAir(); i++) {
						setBlock(level, p, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry_vines_body")).defaultBlockState());
						p = p.below();
					}
					setBlock(level, p, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "winterberry_vines_head")).defaultBlockState());
				} else setBlock(level, p, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "brittle_grass")).defaultBlockState().setValue(BlockBrittleGrass.HANGING, true));
			} else return false;
			return true;
		} return false;
	}
}