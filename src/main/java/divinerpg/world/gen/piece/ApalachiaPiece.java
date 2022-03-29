package divinerpg.world.gen.piece;

import com.google.common.collect.*;
import divinerpg.*;
import divinerpg.registries.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.*;

import java.util.*;

public class ApalachiaPiece {
    private static final BlockPos STRUCTURE_OFFSET = new BlockPos(0, 0, 0);

    public static class Piece extends TemplateStructurePiece {
        private final Rotation rotation;
        private static List<ResourceLocation> locations = new ArrayList();

        public Piece(TemplateManager p_i48904_1_, BlockPos p_i48904_3_, Rotation p_i48904_4_) {
            super(StructureRegistry.Pieces.APALACHIA_PIECE, 0);
            this.templatePosition = p_i48904_3_;
            this.rotation = p_i48904_4_;
            this.loadTemplate(p_i48904_1_);
        }

        public Piece(TemplateManager p_i50445_1_, CompoundNBT p_i50445_2_) {
            super(StructureRegistry.Pieces.APALACHIA_PIECE, p_i50445_2_);
            this.rotation = Rotation.valueOf(p_i50445_2_.getString("Rot"));
            this.loadTemplate(p_i50445_1_);
        }

        @Override
        protected void addAdditionalSaveData(CompoundNBT tagCompound) {
            super.addAdditionalSaveData(tagCompound);
            tagCompound.putString("Rot", this.rotation.name());
        }

        private void loadTemplate(TemplateManager manager) {
            Random rand = new Random();
            locations.addAll(ImmutableList.of(
                    new ResourceLocation(DivineRPG.MODID, "twilight/apalachia/apalachia_fallen_log"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/apalachia/apalachia_fallen_log2"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/apalachia/apalachia_fallen_log3"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/apalachia/apalachia_fallen_log4"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/apalachia/apalachia_fallen_log5"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/apalachia/apalachia_house"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/apalachia/apalachia_pillar1"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/apalachia/apalachia_pillar2"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/apalachia/apalachia_pillar3"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/apalachia/apalachia_pillar4"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/apalachia/apalachia_portal_remnants1"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/apalachia/apalachia_portal_remnants2"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/apalachia/apalachia_shrine"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/apalachia/eternal_archer_dungeon")
            ));
            Template template = manager.getOrCreate(locations.get(rand.nextInt(locations.size())));
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE).setRotationPivot(ApalachiaPiece.STRUCTURE_OFFSET).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
            this.setup(template, this.templatePosition, placementsettings);
        }

        @Override
        public boolean postProcess(ISeedReader world, StructureManager manager, ChunkGenerator generator, Random random, MutableBoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            return super.postProcess(world, manager, generator, random, boundingBox, chunkPos, blockPos);
        }

        @Override
        protected void handleDataMarker(String p_186175_1_, BlockPos p_186175_2_, IServerWorld p_186175_3_, Random p_186175_4_, MutableBoundingBox p_186175_5_) {

        }
    }
}