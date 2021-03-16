package divinerpg.world.gen.structure.structures;

import com.mojang.serialization.*;
import divinerpg.world.gen.structure.piece.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.registry.*;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.*;

import java.util.*;

public class HutStructure extends Structure<NoFeatureConfig> {
    public HutStructure(Codec<NoFeatureConfig> p_i231989_1_) {
        super(p_i231989_1_);
    }

    @Override
    public Structure.IStartFactory<NoFeatureConfig> getStartFactory() {
        return HutStructure.Start::new;
    }

    @Override
    public GenerationStage.Decoration step() {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }

    @Override
    public List<MobSpawnInfo.Spawners> getDefaultSpawnList() {
        return null;
    }

    @Override
    public List<MobSpawnInfo.Spawners> getDefaultCreatureSpawnList() {
        return null;
    }

    public static class Start extends StructureStart<NoFeatureConfig> {
        public Start(Structure<NoFeatureConfig> p_i225817_1_, int p_i225817_2_, int p_i225817_3_, MutableBoundingBox p_i225817_4_, int p_i225817_5_, long p_i225817_6_) {
            super(p_i225817_1_, p_i225817_2_, p_i225817_3_, p_i225817_4_, p_i225817_5_, p_i225817_6_);
        }

        public void generatePieces(DynamicRegistries p_230364_1_, ChunkGenerator p_230364_2_, TemplateManager p_230364_3_, int p_230364_4_, int p_230364_5_, Biome p_230364_6_, NoFeatureConfig p_230364_7_) {
            Rotation rotation = Rotation.getRandom(this.random);
            Mirror mirror = this.random.nextFloat() < 0.5F ? Mirror.NONE : Mirror.FRONT_BACK;
            BlockPos blockpos = new BlockPos(p_230364_4_ * 16, 90, p_230364_5_ * 16);
            HutPiece.addPieces(p_230364_3_, blockpos, rotation, mirror, this.pieces, this.random);
            this.calculateBoundingBox();
        }
    }
}