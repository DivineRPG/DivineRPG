package naturix.divinerpg.utils;

import naturix.divinerpg.DivineRPG;
import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.util.Random;

/**
 * Created by LiteWolf101 on Jan
 * /27/2019
 */
public class DRPGStructureHandler extends WorldGenerator implements IStructure {
    public String structureName;

    public DRPGStructureHandler(String name) {
        this.structureName = name;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        generateStructure(worldIn, position);
        return true;
    }

    public void generateStructure(World world, BlockPos pos){
        MinecraftServer mcServer = world.getMinecraftServer();
        TemplateManager manager = worldServer.getStructureTemplateManager();
        ResourceLocation location = new ResourceLocation(Reference.MODID, structureName);
        Template template = manager.get(mcServer, location);
        if (template != null){
            IBlockState state = world.getBlockState(pos);
            world.notifyBlockUpdate(pos, state, state, 3);
            template.addBlocksToWorldChunk(world, pos, settings);
        }
    }
}
