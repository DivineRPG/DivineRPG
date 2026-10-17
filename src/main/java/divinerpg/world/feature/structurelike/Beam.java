package divinerpg.world.feature.structurelike;

import static divinerpg.registries.StructureRegistry.placeStructure;

import com.mojang.serialization.MapCodec;
import divinerpg.DivineRPG;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.*;

public class Beam implements Feature {
	public static final MapCodec<Beam> CODEC = MapCodec.unit(Beam::new);
	public static StructureTemplate base, middle, top;

	@Override
	public MapCodec<Beam> codec() {
		return CODEC;
	}

	@Override
	public boolean place(WorldGenLevel level, ChunkGenerator gen, RandomSource random, BlockPos pos) {
		if(base == null) {
			StructureTemplateManager manager = level.getLevel().getServer().getStructureTemplateManager();
			base = manager.getOrCreate(Identifier.fromNamespaceAndPath(DivineRPG.MODID, "vethea/all_biomes/beam_base"));
			middle = manager.getOrCreate(Identifier.fromNamespaceAndPath(DivineRPG.MODID, "vethea/all_biomes/beam_middle"));
			top = manager.getOrCreate(Identifier.fromNamespaceAndPath(DivineRPG.MODID, "vethea/all_biomes/beam_top"));
		}
		MutableBlockPos p = pos.mutable();
		placeStructure(base, level, random, p);
		p.move(0, 5, 0);
		do {
			placeStructure(middle, level, random, p);
		} while(!level.isOutsideBuildHeight(p.move(0, 4, 0)) && level.getBlockState(p).isAir());
		p.move(0, -4, 0);
		placeStructure(top, level, random, p);
		return true;
	}
}