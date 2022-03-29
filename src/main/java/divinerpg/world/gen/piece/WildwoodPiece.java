package divinerpg.world.gen.piece;

import com.google.common.collect.*;
import divinerpg.*;
import divinerpg.registries.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.*;

import java.util.*;

public class WildwoodPiece {
    private static final BlockPos STRUCTURE_OFFSET = new BlockPos(0, 0, 0);

    public static class Piece extends TemplateStructurePiece {
        private final Rotation rotation;
        private static List<ResourceLocation> locations = new ArrayList();

        public Piece(TemplateManager p_i48904_1_, BlockPos p_i48904_3_, Rotation p_i48904_4_) {
            super(StructureRegistry.Pieces.WILDWOOD_PIECE, 0);
            this.templatePosition = p_i48904_3_;
            this.rotation = p_i48904_4_;
            this.loadTemplate(p_i48904_1_);
        }

        public Piece(TemplateManager p_i50445_1_, CompoundNBT p_i50445_2_) {
            super(StructureRegistry.Pieces.WILDWOOD_PIECE, p_i50445_2_);
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
                    new ResourceLocation(DivineRPG.MODID, "twilight/wildwood/giant_mangroove"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/wildwood/giant_mangroove_dead"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/wildwood/giant_mangroove_treehouse"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/wildwood/heavily_overgrown_wildwood_portal1"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/wildwood/heavily_overgrown_wildwood_portal2"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/wildwood/heavily_overgrown_wildwood_portal3"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/wildwood/termasect_nest"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/wildwood/wildwood_dungeon1"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/wildwood/wildwood_house"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/wildwood/wildwood_outpost"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/wildwood/wildwood_pillar1"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/wildwood/wildwood_pillar2"),
                    new ResourceLocation(DivineRPG.MODID, "twilight/wildwood/wildwood_treehouse")
            ));
            Template template = manager.getOrCreate(locations.get(rand.nextInt(locations.size())));
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE).setRotationPivot(WildwoodPiece.STRUCTURE_OFFSET).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
            this.setup(template, this.templatePosition, placementsettings);
        }

        @Override
        protected void handleDataMarker(String function, BlockPos pos, IServerWorld worldIn, Random rand, MutableBoundingBox sbb) {
            if ("Chest".equals(function)) {
                worldIn.setBlock(pos, StructurePiece.reorient(worldIn, pos, Blocks.CHEST.defaultBlockState()), 18 );
                LockableLootTileEntity.setLootTable(worldIn, rand, pos, new ResourceLocation(DivineRPG.MODID, "chests/twilight/wildwood/chest"));
            }
        }

        @Override
        public boolean postProcess(ISeedReader world, StructureManager manager, ChunkGenerator generator, Random random, MutableBoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
            return super.postProcess(world, manager, generator, random, boundingBox, chunkPos, blockPos);
        }
    }
}