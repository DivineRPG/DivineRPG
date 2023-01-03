package divinerpg.world.feature.plant;


import divinerpg.DivineRPG;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.ForgeRegistries;

public class ArcaniteVines extends Feature<NoneFeatureConfiguration> {
	public ArcaniteVines() {super(NoneFeatureConfiguration.CODEC);}
	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
		return place(null, context.level(), null, context.random(), context.origin());
	}
	@Override
	public boolean place(NoneFeatureConfiguration c, WorldGenLevel level, ChunkGenerator g, RandomSource random, BlockPos pos) {
		pos = new BlockPos(pos.getX(), 46, pos.getZ());
		while(!level.getBlockState(pos).is(ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_moss")))) {
			pos = pos.above();
			if(pos.getY() > 76) return false;
		}
		do {
			pos = pos.below();
			if(level.getBlockState(pos).isAir()) setBlock(level, pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_vines_body")).defaultBlockState());
			else break;
		} while(random.nextBoolean());
		setBlock(level, pos, ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "arcanite_vines_head")).defaultBlockState());
		return true;
	}
}