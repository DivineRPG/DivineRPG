package divinerpg.world.gen.structure.piece;

import divinerpg.*;
import divinerpg.world.gen.structure.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.*;

import java.util.*;

public class HutPiece {
    private static final BlockPos STRUCTURE_OFFSET = new BlockPos(0, -2, 0);
    private static final ResourceLocation STRUCTURE = new ResourceLocation(DivineRPG.MODID, "overworld/livestock_merchant_hut");

    public static void func_204760_a(TemplateManager p_204760_0_, BlockPos p_204760_1_, Rotation p_204760_2_, Mirror p_204760_3_, List<StructurePiece> p_204760_4_, Random p_204760_5_) {
        p_204760_4_.add(new HutPiece.Piece(p_204760_0_, p_204760_1_, p_204760_2_, p_204760_3_));
    }

    public static class Piece extends TemplateStructurePiece {
        private final Rotation rotation;
        private final Mirror mirror;

        public Piece(TemplateManager p_i48904_1_, BlockPos p_i48904_3_, Rotation rotationIn, Mirror mirrorIn) {
            super(DivineStructures.Pieces.HUT_PIECE, 0);
            this.templatePosition = p_i48904_3_;
            this.rotation = rotationIn;
            this.mirror = mirrorIn;
            this.func_204754_a(p_i48904_1_);
        }

        public Piece(TemplateManager p_i50445_1_, CompoundNBT p_i50445_2_) {
            super(DivineStructures.Pieces.HUT_PIECE, p_i50445_2_);
            this.rotation = Rotation.valueOf(p_i50445_2_.getString("Rot"));
            this.mirror = Mirror.valueOf(p_i50445_2_.getString("Mirror"));
            this.func_204754_a(p_i50445_1_);
        }

        @Override
        protected void readAdditional(CompoundNBT tagCompound) {
            super.readAdditional(tagCompound);
            tagCompound.putString("Rot", this.rotation.name());
            tagCompound.putString("Mirror", this.mirror.name());
        }

        private void func_204754_a(TemplateManager p_204754_1_) {
            Template template = p_204754_1_.getTemplateDefaulted(STRUCTURE);
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(this.mirror).setCenterOffset(HutPiece.STRUCTURE_OFFSET).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
            this.setup(template, this.templatePosition, placementsettings);
        }

        @Override
        protected void handleDataMarker(String function, BlockPos pos, IServerWorld worldIn, Random rand, MutableBoundingBox sbb) {

        }

        @Override
        public boolean func_230383_a_(ISeedReader p_230383_1_, StructureManager p_230383_2_, ChunkGenerator p_230383_3_, Random p_230383_4_, MutableBoundingBox p_230383_5_, ChunkPos p_230383_6_, BlockPos p_230383_7_) {
            int i = 256;
            BlockPos blockpos = this.template.getSize();
            int k = blockpos.getX() * blockpos.getZ();
            if (k != 0) {
                BlockPos blockpos1 = this.templatePosition.add(blockpos.getX() - 1, 0, blockpos.getZ() - 1);

                for(BlockPos blockpos2 : BlockPos.getAllInBoxMutable(this.templatePosition, blockpos1)) {
                    int l = p_230383_1_.getHeight(Heightmap.Type.WORLD_SURFACE_WG, blockpos2.getX(), blockpos2.getZ());
                    i = Math.min(i, l);
                }
            }

            this.templatePosition = new BlockPos(this.templatePosition.getX(), i, this.templatePosition.getZ());
            return super.func_230383_a_(p_230383_1_, p_230383_2_, p_230383_3_, p_230383_4_, p_230383_5_, p_230383_6_, p_230383_7_);
        }
    }
}