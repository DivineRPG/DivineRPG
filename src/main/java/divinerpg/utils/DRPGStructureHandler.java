package divinerpg.utils;

import divinerpg.DivineRPG;
import net.minecraft.block.state.IBlockState;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.template.PlacementSettings;
import net.minecraft.world.gen.structure.template.Template;
import net.minecraft.world.gen.structure.template.TemplateManager;
import net.minecraftforge.fml.common.FMLCommonHandler;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

/**
 * Created by LiteWolf101 on Jan
 * /27/2019
 */
public class DRPGStructureHandler extends WorldGenerator implements IStructure {
    protected String structureName;
    protected Function<TileEntityChestArgs, ResourceLocation> lootTableFunc;

    public DRPGStructureHandler(String name) {
        this(name, (ResourceLocation) null);
    }

    public DRPGStructureHandler(String name, ResourceLocation lootTable) {
        this(name, lootTable == null ? null : blockInfo -> lootTable);
    }

    /*
        For special needs whateber i need to put special loot tables for special chests
     */
    public DRPGStructureHandler(String name, Function<TileEntityChestArgs,ResourceLocation> lootTableFunc) {
        this.structureName = name;
        this.lootTableFunc = lootTableFunc;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        generateStructure(worldIn, position);
        return true;
    }

    public void generateStructure(World world, BlockPos pos){
        MinecraftServer mcServer = world.getMinecraftServer();
        TemplateManager manager = getWorldServer(world).getStructureTemplateManager();
        ResourceLocation location = new ResourceLocation(DivineRPG.MODID, structureName);
        Template template = manager.get(mcServer, location);
        if (template != null){
            IBlockState state = world.getBlockState(pos);
            world.notifyBlockUpdate(pos, state, state, 3);
            template.addBlocksToWorldChunk(world, pos, getSettings(pos));

            generateLoot(world, template, pos);
        }
    }

    public void generateLoot(World world, Template template, BlockPos pos) {
        if (lootTableFunc == null)
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

                    TileEntity tileEntity = world.getTileEntity(correct);

                    if (tileEntity instanceof TileEntityLockableLoot){
                        // Getting loot table from current chest
                        ResourceLocation lootTable = lootTableFunc.apply(new TileEntityChestArgs(world, (TileEntityLockableLoot)tileEntity, correct));

                        if (lootTable != null)
                            ((TileEntityLockableLoot)tileEntity).setLootTable(lootTable, world.rand.nextLong());
                        else {
                            System.out.println("Can't find loot table for tile entity :" + correct.toString());
                        }
                    }
                });

    }

    @Override
    public WorldServer getWorldServer(World world) {
        return FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(world.provider.getDimension());
    }

    @Override
    public PlacementSettings getSettings(BlockPos pos) {
        return new PlacementSettings().setChunk(new ChunkPos(pos)).setIgnoreEntities(false)
                .setIgnoreStructureBlock(false).setMirror(Mirror.NONE).setRotation(Rotation.NONE);
    }

    public class TileEntityChestArgs{

        private World world;
        private TileEntityLockableLoot tileEntity;
        private BlockPos pos;

        public TileEntityChestArgs(World world, TileEntityLockableLoot tileEntity, BlockPos pos){
            this.world = world;
            this.tileEntity = tileEntity;
            this.pos = pos;
        }

        public BlockPos getPos() {
            return pos;
        }

        public World getWorld() {
            return world;
        }

        public TileEntityLockableLoot getTileEntity() {
            return tileEntity;
        }
    }
}
