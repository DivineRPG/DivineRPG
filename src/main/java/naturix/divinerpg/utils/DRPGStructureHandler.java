package naturix.divinerpg.utils;

import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;

/**
 * Created by LiteWolf101 on Jan
 * /27/2019
 */
public class DRPGStructureHandler extends WorldGenerator implements IStructure {
    public String structureName;
    public ResourceLocation lootTable;

    public DRPGStructureHandler(String name) {
        this(name, null);
    }

    public DRPGStructureHandler(String name, ResourceLocation lootTable) {
        this.structureName = name;
        this.lootTable = lootTable;
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

            generateLoot(template, pos);
        }
    }

    public void generateLoot(Template template, BlockPos pos) {
        if (lootTable == null)
            return;

        List<Template.BlockInfo> allBlocks;

        /*
            We can't accept to all temple blocks, so I use reflection here
            Maybe we can inject loot directly in structure NBT?..
         */
        try {
            Field field = template.getClass().getDeclaredField("blocks");
            field.setAccessible(true);

            allBlocks = (List<Template.BlockInfo>) field.get(template);

        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return;

        } catch (NoSuchFieldException e) {
            System.out.println("Template class was changed, need to change code. Exception is below:\n" + e.toString());
            return;
        }

        if (allBlocks == null)
            return;

        allBlocks
                .forEach(blockInfo -> {
                    if (blockInfo.tileentityData == null)
                        return;

                    // Get correct blockpos from seed-relative
                    BlockPos correct = blockInfo.pos.add(pos.getX(), pos.getY(), pos.getZ());

                    TileEntity tileEntity = worldServer.getTileEntity(correct);

                    if (tileEntity instanceof TileEntityLockableLoot){
                        ((TileEntityLockableLoot)tileEntity).setLootTable(lootTable, worldServer.rand.nextLong());
                    }
                });

    }
}
