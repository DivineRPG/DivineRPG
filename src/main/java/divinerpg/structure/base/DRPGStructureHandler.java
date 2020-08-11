package divinerpg.structure.base;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.npc.EntityWorkshopMerchant;
import divinerpg.objects.entities.entity.npc.EntityWorkshopTinkerer;
import divinerpg.objects.entities.entity.npc.EntityLivestockMerchant;
import divinerpg.objects.entities.entity.npc.EntityTheHunger;
import divinerpg.registry.LootTableRegistry;
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

public class DRPGStructureHandler extends WorldGenerator implements IStructure {
    protected String structureName;

    public DRPGStructureHandler(String name) {
        this.structureName = name;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position) {
        Rotation rotation = WorldGenUtils.getRandomRotation(rand);
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
        Template template = manager.get(mcServer, location);
        if (template == null) {
           DivineRPG.logger.error("Couldn't find template for structure " + this.structureName);
        }
        return template;
    }
}
