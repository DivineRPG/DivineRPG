package divinerpg.utils;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.vanilla.EntityLivestockMerchant;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
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
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.FMLCommonHandler;

import javax.annotation.Nullable;
import java.util.Iterator;
import java.util.Map;
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
    public DRPGStructureHandler(String name, Function<TileEntityChestArgs, ResourceLocation> lootTableFunc) {
        this.structureName = name;
        this.lootTableFunc = lootTableFunc;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        generateStructure(worldIn, position);
        return true;
    }

    public void generateStructure(World world, BlockPos pos) {
        Template template = load(world);

        if (template != null) {
            PlacementSettings placementSettings = getSettings(pos);
            template.addBlocksToWorld(world, pos, placementSettings);
            generateLoot(world, template, pos, placementSettings);

            Map<BlockPos, String> map = template.getDataBlocks(pos, placementSettings);
            Iterator var16 = map.entrySet().iterator();

            while(var16.hasNext()) {
                Map.Entry<BlockPos, String> entry = (Map.Entry)var16.next();
                if ("LivestockMerchant".equals(entry.getValue())) {
                    BlockPos spawnPos = (BlockPos)entry.getKey();
                    EntityLivestockMerchant merchant = new EntityLivestockMerchant(world);
                    merchant.enablePersistence();
                    merchant.moveToBlockPosAndAngles(spawnPos, 0.0F, 0.0F);
                    world.spawnEntity(merchant);
                    world.setBlockToAir(spawnPos);
                }
            }
        }
    }

    public void generateLoot(World world, Template template, BlockPos pos, PlacementSettings placementSettings) {
        if (lootTableFunc == null)
            return;

        BlockPos.getAllInBox(BlockPos.ORIGIN, template.getSize()).forEach(x -> {
            BlockPos templatePos = Template.transformedBlockPos(placementSettings, x).add(pos);

            TileEntity tile = world.getTileEntity(templatePos);

            if (tile instanceof TileEntityLockableLoot) {
                // Getting loot table from current chest
                ResourceLocation lootTable = lootTableFunc.apply(new TileEntityChestArgs(world, (TileEntityLockableLoot) tile, templatePos));

                if (lootTable != null)
                    ((TileEntityLockableLoot) tile).setLootTable(lootTable, world.rand.nextLong());
                else {
                    System.out.println("Can't find loot table for tile entity :" + templatePos.toString());
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
        return new PlacementSettings().setIgnoreEntities(false)
                .setIgnoreStructureBlock(false).setMirror(Mirror.NONE).setRotation(Rotation.NONE);
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

    public class TileEntityChestArgs {

        private World world;
        private TileEntityLockableLoot tileEntity;
        private BlockPos pos;

        public TileEntityChestArgs(World world, TileEntityLockableLoot tileEntity, BlockPos pos) {
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
