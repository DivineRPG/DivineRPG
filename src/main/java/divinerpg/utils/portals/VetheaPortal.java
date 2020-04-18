package divinerpg.utils.portals;

import divinerpg.registry.ModDimensions;
import divinerpg.utils.NbtUtil;
import divinerpg.utils.portals.description.IPortalDescription;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.Tuple;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityTravelToDimensionEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class VetheaPortal extends ServerPortal {
    /**
     * Nightmare bed location. Long
     */
    private final String BedKey = "VetheaBedPos";
    /**
     * Dimension of Nightmare bed. String
     */
    private final String BedDimKey = "VetheaBedDimension";


    public VetheaPortal(int radius, int recheckDelay) {
        super(radius, recheckDelay);

        MinecraftForge.EVENT_BUS.register(this);
    }

    /**
     * Should listen all here to save/restore inventory
     *
     * @param e
     */
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onDimensionChange(EntityTravelToDimensionEvent e) {
        if (e.isCanceled() || !(e.getEntity() instanceof EntityPlayer))
            return;

        DimensionType from = e.getEntity().getEntityWorld().provider.getDimensionType();
        DimensionType to = DimensionType.getById(e.getDimension());

        if (ModDimensions.vetheaDimension != to && ModDimensions.vetheaDimension != from)
            return;

        EntityPlayer player = (EntityPlayer) e.getEntity();
        NBTTagCompound tag = NbtUtil.getPersistedDivineTag(player);

        List<String> tagNames = Arrays.asList("OverworldInv", "VetheaInv");

        if (from == ModDimensions.vetheaDimension) {
            Collections.reverse(tagNames);
        }

        String saveTo = tagNames.get(0);
        tag.setTag(saveTo, player.inventory.writeToNBT(new NBTTagList()));
        player.inventory.clear();

        String loadFrom = tagNames.get(1);
        NBTBase base = tag.getTag(loadFrom);
        if (base instanceof NBTTagList) {
            player.inventory.readFromNBT((NBTTagList) base);
        }

        player.inventoryContainer.detectAndSendChanges();
    }

    @Override
    public void placeEntity(World world, Entity entity, float yaw) {
        DimensionType destination = world.provider.getDimensionType();

        if (destination != ModDimensions.vetheaDimension) {
            // going home
            if (entity instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) entity;
                Tuple<DimensionType, BlockPos> posTuple = NbtUtil.tryReaPosition(NbtUtil.getPersistedDivineTag(player), BedDimKey, BedKey);

                if (posTuple == null) {
                    BlockPos bedPos = player.getBedLocation(destination.getId());
                    if (bedPos == null) {
                        bedPos = world.getSpawnPoint();
                    }

                    posTuple = new Tuple<>(destination, bedPos);
                }

                //ItemTeleportationCrystal.teleportToDimension(entity, posTuple.getFirst(), posTuple.getSecond());

                BlockPos pos = posTuple.getSecond();

                if (player instanceof EntityPlayerMP) {
                    ((EntityPlayerMP) player).connection.setPlayerLocation(pos.getX(), pos.getY(), pos.getZ(),
                            yaw, player.rotationPitch);
                } else {
                    entity.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
                }

            } else {
                BlockPos pos = world.getSpawnPoint();
                entity.setPositionAndUpdate(pos.getX(), pos.getY(), pos.getZ());
            }

            return;
        }

        if (entity instanceof EntityPlayer) {
            NBTTagCompound tag = NbtUtil.getPersistedDivineTag((EntityPlayer) entity);

            tag.setString(BedDimKey, entity.getEntityWorld().provider.getDimensionType().getName());
            tag.setLong(BedKey, entity.getPosition().toLong());
        }

        super.placeEntity(world, entity, yaw);

        if (entity instanceof EntityPlayer) {
            ((EntityPlayer) entity).setSpawnChunk(entity.getPosition(), true, world.provider.getDimensionType().getId());
        }
    }

    @Nullable
    @Override
    protected BlockPattern.PatternHelper findFromCache(World world, IPortalDescription description, List<WorkingPortalInfo> activePortals, BlockPos pos, int radius) {
        return super.findFromCache(world, description, activePortals, pos, 1024);
    }

    @Override
    protected BlockPos findSuitablePosition(World destination, IPortalDescription description, Entity e, BlockPos min, BlockPos max) {
        //
        // getting here only if teleporting to vethea
        //

        // teleporting only on first floor
        min = new BlockPos(min.getX(), 17, min.getZ());
        max = new BlockPos(max.getX(), 17, max.getZ());

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        BlockPos size = description.getMaxSize();

        for (int x = min.getX(); x <= max.getX(); x++) {
            for (int z = min.getZ(); z <= max.getZ(); z++) {
                for (int y = min.getY(); y <= max.getY(); y++) {
                    pos.setPos(x, y, z);

                    if (isAirBlocks(destination, new AxisAlignedBB(pos, pos.add(size)))) {
                        return pos;
                    }
                }
            }
        }

        BlockPos.getAllInBoxMutable(min, min.add(size)).forEach(destination::setBlockToAir);
        return min;
    }
}
