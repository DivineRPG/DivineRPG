package divinerpg.utils.portals;

import baubles.api.BaublesApi;
import baubles.api.cap.IBaublesItemHandler;
import divinerpg.config.GeneralConfig;
import divinerpg.registry.DimensionRegistry;
import divinerpg.utils.NbtUtil;
import divinerpg.utils.PositionHelper;
import divinerpg.utils.portals.description.IPortalDescription;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
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

        int sourceDimension = e.getEntity().getEntityWorld().provider.getDimension();
        int destinationDimension = e.getDimension();

        int vetheaID = GeneralConfig.dimensionIDs.vetheaDimensionID;

        if (vetheaID != sourceDimension && vetheaID != destinationDimension)
            return;

        EntityPlayer player = (EntityPlayer) e.getEntity();
        NBTTagCompound tag = NbtUtil.getPersistedDivineTag(player);

        List<String> tagNames = Arrays.asList("OverworldInv", "VetheaInv");

        if (sourceDimension == vetheaID) {
            Collections.reverse(tagNames);
        }

        String saveTo = tagNames.get(0);
        tag.setTag(saveTo, player.inventory.writeToNBT(new NBTTagList()));
        player.inventory.clear();

        String loadFrom = tagNames.get(1);
        NBTBase newDimensionNBT = tag.getTag(loadFrom);
        if (newDimensionNBT instanceof NBTTagList) {
            player.inventory.readFromNBT((NBTTagList) newDimensionNBT);
        }

        player.inventoryContainer.detectAndSendChanges();

        changeBaubles(player, tag, sourceDimension == vetheaID);
    }

    private void changeBaubles(EntityPlayer player, NBTTagCompound tag, boolean backToOverworld) {
        List<String> tagNames = Arrays.asList("Baubles_Overworld", "Baubles_Vethea");
        if (backToOverworld) {
            Collections.reverse(tagNames);
        }

        String saveTo = tagNames.get(0);
        String loadFrom = tagNames.get(1);

        IBaublesItemHandler handler = BaublesApi.getBaublesHandler(player);

        tag.setTag(saveTo, serializeBaubles(handler));
        deserializeBaubles(handler, ((NBTTagList) tag.getTag(loadFrom)));
    }

    private NBTTagList serializeBaubles(IBaublesItemHandler baublesHandler) {
        NBTTagList serializedInventory = new NBTTagList();

        for (int slotIndex = 0; slotIndex < baublesHandler.getSlots(); slotIndex++) {
            NBTTagCompound serializedSlot = baublesHandler.getStackInSlot(slotIndex).writeToNBT(new NBTTagCompound());
            serializedInventory.appendTag(serializedSlot);
        }

        return serializedInventory;
    }

    private void deserializeBaubles(IBaublesItemHandler baublesHandler, NBTTagList serializedInventory) {
        for (int slotIndex = 0; slotIndex < baublesHandler.getSlots(); slotIndex++) {
            if (serializedInventory == null) {
                baublesHandler.setStackInSlot(slotIndex, ItemStack.EMPTY);
            } else {
                NBTBase slotNbt = serializedInventory.get(slotIndex);
                if (slotNbt instanceof NBTTagCompound) {
                    ItemStack deserializedItem = new ItemStack(((NBTTagCompound) serializedInventory.get(slotIndex)));
                    baublesHandler.setStackInSlot(slotIndex, deserializedItem);
                } else {
                    baublesHandler.setStackInSlot(slotIndex, ItemStack.EMPTY);
                }
            }
        }
    }

    @Override
    public void placeEntity(World world, Entity entity, float yaw) {
        DimensionType destination = world.provider.getDimensionType();

        if (destination != DimensionRegistry.vetheaDimension) {
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
    protected BlockPos findSuitablePosition(World destination, IPortalDescription description, Entity e, int radius) {
        int floorHeight = 17;

        BlockPos center = new BlockPos(e.posX, floorHeight, e.posZ);
        BlockPos portalSize = description.getMaxSize();

        return PositionHelper.searchInRadius(destination, center, radius, pos -> {
            if (pos.getY() != floorHeight)
                return false;

            return isAirBlocks(destination, new AxisAlignedBB(pos, pos.add(portalSize)));
        });
    }
}
