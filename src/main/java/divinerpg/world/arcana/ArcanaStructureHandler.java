package divinerpg.world.arcana;

import divinerpg.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.feature.template.*;
import net.minecraft.world.server.*;

import javax.annotation.*;
import java.util.*;

public class ArcanaStructureHandler {
    protected String structureName;

    public ArcanaStructureHandler(String name) {
        this.structureName = name;
    }

    public String getName() {
        return this.structureName;
    }

    //Replacement to make passing in predefined rotations easier
    public boolean generateWithRotation(ServerWorld world, Random rand, BlockPos pos, Rotation rotation) {
        BlockPos size = this.getSize(world);
        BlockPos adjustedPosition = adjustForRotation(pos, size, rotation);
        Template template = load(world);

        if (template != null) {
            template.placeInWorldChunk(world, adjustedPosition, new PlacementSettings().setIgnoreEntities(false).setMirror(Mirror.NONE).setRotation(rotation).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK), rand);
            List<Template.BlockInfo> map = template.filterBlocks(pos, new PlacementSettings().setIgnoreEntities(false).setMirror(Mirror.NONE).setRotation(rotation).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK), Blocks.STRUCTURE_BLOCK, true);
            Iterator var16 = map.iterator();

            if(var16.hasNext()) {
                handleDataMarkers(world, rand, var16);
            }
        }
        return true;
    }

    /*
     * Adjust where the structure starts generating to account for rotations and prevent cascading world generation.
     */
    private BlockPos adjustForRotation(BlockPos position, BlockPos size, Rotation rotation) {
        switch(rotation) {
            case NONE:
                return position;
            case CLOCKWISE_90:
                return position.offset(size.getZ() - 1, 0, 0);
            case CLOCKWISE_180:
                return position.offset(size.getX() - 1, 0, size.getZ() - 1);
            case COUNTERCLOCKWISE_90:
                return position.offset(0, 0, size.getX() - 1);
            default:
                DivineRPG.LOGGER.warn("Invalid structure rotation passed in somehow, please report this.");
                return position;
        }
    }

    public BlockPos getSize(World world) {
        Template template = load(world);
        if (template != null) {
            return template.getSize();
        }
        return null;
    }
    public void handleDataMarkers(World world, Random random, Iterator iterator) {
    }
    @Nullable
    private Template load(World world) {
        ResourceLocation location = new ResourceLocation(DivineRPG.MODID, structureName);
        return world.getServer().getLevel(world.dimension()).getStructureManager().get(location);
    }

}