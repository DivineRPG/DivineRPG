package divinerpg.world.arcana;

import divinerpg.*;
import net.minecraft.server.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;
import net.minecraft.world.gen.feature.template.*;

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
    public boolean generateWithRotation(World worldIn, Random rand, BlockPos position, Rotation rotation) {
        BlockPos size = this.getSize(worldIn);
        BlockPos adjustedPosition = adjustForRotation(position, size, rotation);
        generateStructure(worldIn, rand, rotation, adjustedPosition);
        return true;
    }

    public void generateStructure(World world, Random random, Rotation rotation, BlockPos pos) {
        Template template = load(world);

        if (template != null) {
            PlacementSettings placementSettings = getSettings(pos, rotation);
            template.placeInWorld(world.getServer().getLevel(world.dimension()), pos, placementSettings, world.random);

        }
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


    public PlacementSettings getSettings(BlockPos pos, Rotation rotation) {
        return new PlacementSettings().setIgnoreEntities(false).setMirror(Mirror.NONE).setRotation(rotation).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_BLOCK);
    }

    public BlockPos getSize(World world) {
        Template template = load(world);
        if (template != null) {
            return template.getSize();
        }
        return null;
    }

    @Nullable
    private Template load(World world) {
        MinecraftServer mcServer = world.getServer();
        TemplateManager manager = mcServer.getStructureManager();
        ResourceLocation location = new ResourceLocation(DivineRPG.MODID, structureName);
        return manager.get(location);
    }
}