package divinerpg.utils;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.iceika.EntityWorkshopMerchant;
import divinerpg.objects.entities.entity.iceika.EntityWorkshopTinkerer;
import divinerpg.objects.entities.entity.vanilla.EntityLivestockMerchant;
import divinerpg.objects.entities.entity.vethea.EntityTheHunger;
import divinerpg.registry.LootTableRegistry;
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
        Rotation rotation = WorldGenUtils.getRandomRotation(rand);
        System.out.println("Attempting to generate structure at " + position + " with rotation " + rotation.toString() + " with size " + this.getSize(worldIn));
        BlockPos size = this.getSize(worldIn);
        BlockPos adjustedPosition = adjustForRotation(position, size, rotation);
        generateStructure(worldIn, rand, rotation, adjustedPosition);
        return true;
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
                return position.add(size.getZ(), 0, 0);
            case CLOCKWISE_180:
                return position.add(size.getX(), 0, size.getZ());
            case COUNTERCLOCKWISE_90:
                return position.add(0, 0, size.getX());
            default:
                DivineRPG.logger.warn("Invalid structure rotation passed in somehow, please report this.");
                return position;
        }
    }

    private void handleDataMarkers(World world, Random random, Iterator iterator) {
        while(iterator.hasNext()) {
            Map.Entry<BlockPos, String> entry = (Map.Entry)iterator.next();
            BlockPos pos = entry.getKey();

            switch(entry.getValue()) {
                case "LivestockMerchant":
                    WorldGenUtils.spawnPersistentEntity(world, pos, new EntityLivestockMerchant(world));
                    break;
                case "TheHunger":
                    WorldGenUtils.spawnPersistentEntity(world, pos, new EntityTheHunger(world));
                    break;
                case "WorkshopMerchant":
                    WorldGenUtils.spawnPersistentEntity(world, pos, new EntityWorkshopMerchant(world));
                    break;
                case "WorkshopTinkerer":
                    WorldGenUtils.spawnPersistentEntity(world, pos, new EntityWorkshopTinkerer(world));
                    break;
                case "WorkshopHouse1Loot":
                    WorldGenUtils.populateLootChestBelow(world, pos, random, LootTableRegistry.ICEIKA_CHEST_HUT);
                    break;
                case "WorkshopHouse2Loot":
                    WorldGenUtils.populateLootChestBelow(world, pos, random, LootTableRegistry.ICEIKA_CHEST_HUT);
                    break;
                case "WorkshopHouse3Loot":
                    WorldGenUtils.populateLootChestBelow(world, pos, random, LootTableRegistry.ICEIKA_CHEST_HUT);
                    break;
                case "WorkshopHouse4Loot":
                    WorldGenUtils.populateLootChestBelow(world, pos, random, LootTableRegistry.ICEIKA_CHEST_HUT);
                    break;
                default:
                    DivineRPG.logger.warn("Unexpected data marker: " + entry.getValue() + " in a structure, please report this.");
                    break;
            }

            if(world.getBlockState(pos).getBlock() == Blocks.STRUCTURE_BLOCK) {
                world.setBlockToAir(pos);
            }
        }
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
