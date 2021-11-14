package divinerpg.world.arcana;

import divinerpg.*;
import divinerpg.entities.arcana.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.nbt.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.structure.*;
import net.minecraft.world.gen.feature.template.*;

import java.util.*;

public class ArcanaPieces {


    public static void addStructure(TemplateManager manager, BlockPos pos, Rotation rotation, List<StructurePiece> piece, ResourceLocation location)
    {
        piece.add(new ArcanaPieces.Piece(manager, location, pos, rotation));
    }

    public static class Piece extends TemplateStructurePiece
    {
        private final ResourceLocation templateLocation;
        private final Rotation rotation;

        public Piece(TemplateManager manager, ResourceLocation location, BlockPos pos, Rotation rotation)
        {
            super(StructureRegistry.Pieces.ARCANA_PIECE, 0);
            this.templateLocation = location;
            this.templatePosition = pos;
            this.rotation = rotation;
            this.loadTemplate(manager);
        }

        public Piece(TemplateManager manager, CompoundNBT nbt)
        {
            super(StructureRegistry.Pieces.ARCANA_PIECE, nbt);
            this.templateLocation = new ResourceLocation(nbt.getString("Template"));
            this.rotation = Rotation.valueOf(nbt.getString("Rot"));
            this.loadTemplate(manager);
        }

        private void loadTemplate(TemplateManager manager)
        {
            Template template = manager.getOrCreate(this.templateLocation);
            PlacementSettings placementsettings = (new PlacementSettings()).setRotation(this.rotation).setMirror(Mirror.NONE).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
            this.setup(template, this.templatePosition, placementsettings);
        }

        @Override
        protected void addAdditionalSaveData(CompoundNBT nbt)
        {
            super.addAdditionalSaveData(nbt);
            nbt.putString("Template", this.templateLocation.toString());
            nbt.putString("Rot", this.rotation.name());
        }

        @Override
        protected void handleDataMarker(String data, BlockPos pos, IServerWorld world, Random rand, MutableBoundingBox box)
        {
                switch(data) {
                    case "CaptainMerik":
                        Utils.spawnPersistentEntity(world.getLevel(), pos, new EntityCaptainMerik(EntityRegistry.CAPTAIN_MERIK, world.getLevel()));
                        break;
                    case "Datticon":
                        Utils.spawnPersistentEntity(world.getLevel(), pos, new EntityDatticon(EntityRegistry.DATTICON, world.getLevel()));
                        break;
                    case "Kazari":
                        Utils.spawnPersistentEntity(world.getLevel(), pos, new EntityKazari(EntityRegistry.KAZARI, world.getLevel()));
                        break;
                    case "Leorna":
                        Utils.spawnPersistentEntity(world.getLevel(), pos, new EntityLeorna(EntityRegistry.LEORNA, world.getLevel()));
                        break;
                    case "LordVatticus":
                        Utils.spawnPersistentEntity(world.getLevel(), pos, new EntityLordVatticus(EntityRegistry.LORD_VATTICUS, world.getLevel()));
                        break;
                    case "WarGeneral":
                        Utils.spawnPersistentEntity(world.getLevel(), pos, new EntityWarGeneral(EntityRegistry.WAR_GENERAL, world.getLevel()));
                        break;
                    case "Zelus":
                        Utils.spawnPersistentEntity(world.getLevel(), pos, new EntityZelus(EntityRegistry.ZELUS, world.getLevel()));
                        break;
                    default:
                        DivineRPG.LOGGER.warn("Unexpected data marker: " + data + " in a structure, please report this.");
                        break;
                }

                if(world.getBlockState(pos).getBlock() == Blocks.STRUCTURE_BLOCK) {
                    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 0);
                }
        }


        @Override
        public boolean postProcess(ISeedReader reader, StructureManager manager, ChunkGenerator chunkGenerator, Random rand, MutableBoundingBox box, ChunkPos chunkPos, BlockPos pos)
        {
            BlockPos blockpos1 = this.templatePosition;
            int i = reader.getHeight(Heightmap.Type.WORLD_SURFACE_WG, blockpos1.getX(), blockpos1.getZ());
            BlockPos blockpos2 = this.templatePosition;
            this.templatePosition = this.templatePosition.offset(0, i - 90 - 2, 0);
            boolean flag = super.postProcess(reader, manager, chunkGenerator, rand, box, chunkPos, pos);
            this.templatePosition = blockpos2;
            return flag;
        }
    }



}