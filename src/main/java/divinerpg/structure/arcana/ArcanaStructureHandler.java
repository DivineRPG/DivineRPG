package divinerpg.structure.arcana;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.npc.*;
import divinerpg.utils.IStructure;
import divinerpg.utils.WorldGenUtils;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.FMLCommonHandler;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class ArcanaStructureHandler extends WorldGenerator implements IStructure {
    protected String structureName;

    public ArcanaStructureHandler(String name) {
        this.structureName = name;
    }

    //Replacement to make passing in predefined rotations easier
    public boolean generateWithRotation(World worldIn, Random rand, BlockPos position, Rotation rotation) {
        BlockPos size = this.getSize(worldIn);
        BlockPos adjustedPosition = adjustForRotation(position, size, rotation);
        generateStructure(worldIn, rand, rotation, adjustedPosition);
        return true;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        return false;
    }

    public void generateStructure(World world, Random random, Rotation rotation, BlockPos pos) {
        Template template = load(world);

        if (template != null) {
            PlacementSettings placementSettings = getSettings(pos, rotation);
            template.addBlocksToWorld(world, pos, placementSettings);

            Map<BlockPos, String> map = template.getDataBlocks(pos, placementSettings);
            Iterator var16 = map.entrySet().iterator();

            if(var16.hasNext()) {
                handleDataMarkers(world, random, var16);
            }
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
                return position.add(size.getZ() - 1, 0, 0);
            case CLOCKWISE_180:
                return position.add(size.getX() - 1, 0, size.getZ() - 1);
            case COUNTERCLOCKWISE_90:
                return position.add(0, 0, size.getX() - 1);
            default:
                DivineRPG.logger.warn("Invalid structure rotation passed in somehow, please report this.");
                return position;
        }
    }

    public void handleDataMarkers(World world, Random random, Iterator iterator) {
    }

    @Override
    public WorldServer getWorldServer(World world) {
        return FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(world.provider.getDimension());
    }

    @Override
    public PlacementSettings getSettings(BlockPos pos, Rotation rotation) {
        return new PlacementSettings().setIgnoreEntities(false).setIgnoreStructureBlock(false).setMirror(Mirror.NONE).setRotation(rotation);
    }

    @Override
    public BlockPos getSize(World world) {
        Template template = load(world);
        if (template != null) {
            return template.getSize();
        }
        return null;
    }

    @Nullable
    private Template load(World world) {
        MinecraftServer mcServer = world.getMinecraftServer();
        TemplateManager manager = getWorldServer(world).getStructureTemplateManager();
        ResourceLocation location = new ResourceLocation(DivineRPG.MODID, structureName);
        return manager.get(mcServer, location);
    }
}
