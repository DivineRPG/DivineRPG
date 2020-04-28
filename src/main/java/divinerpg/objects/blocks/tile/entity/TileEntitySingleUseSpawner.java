package divinerpg.objects.blocks.tile.entity;

import divinerpg.DivineRPG;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.EnumDifficulty;

public class TileEntitySingleUseSpawner extends TileEntity implements ITickable {

    private ResourceLocation entityId;
    private int delay;
    private boolean isActivated = false;

    /**
     * NBT ctor
     */
    public TileEntitySingleUseSpawner() {

    }

    public TileEntitySingleUseSpawner(Class<? extends Entity> entityClass, int delay) {
        this.entityId = EntityList.getKey(entityClass);
        this.delay = delay;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        NBTTagCompound result = super.writeToNBT(compound);
        result.setInteger("delay", delay);
        result.setBoolean("activated", isActivated);
        result.setString("entityID", entityId.toString());
        return result;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        delay = compound.getInteger("delay");
        isActivated = compound.getBoolean("activated");
        entityId = new ResourceLocation(compound.getString("entityID"));
    }

    @Override
    public void update() {
        if (!isActivated)
            return;

        // using delay
        if (delay > 0) {
            delay--;
            return;
        }

        // should spawn only on server side
        if (world.isRemote)
            return;

        // always remove block
        removeBlock();

        if (world.getDifficulty() == EnumDifficulty.PEACEFUL) {
            return;
        }

        // some error
        if (entityId == null) {
            String blockName = world.getBlockState(pos).getBlock().getRegistryName().toString();
            DivineRPG.logger.warn("Spawner block " + blockName + " can't summon entity, entityId is null");
            return;
        }

        Entity entity = EntityList.createEntityByIDFromName(entityId, world);

        if (entity == null) {
            String blockName = world.getBlockState(pos).getBlock().getRegistryName().toString();
            DivineRPG.logger.warn("Spawner block " + blockName + " can't summon entity, entity is null");
            return;
        }

        entity.setPosition(
                world.rand.nextInt(3) + pos.getX(),
                pos.getY() + 1,
                world.rand.nextInt(3) + pos.getZ());

        world.spawnEntity(entity);
    }

    /**
     * Should called when we eant to spawn entity
     *
     * @param player
     */
    public void activate(EntityPlayer player) {
        if (isActivated)
            return;

        isActivated = true;

        if (!world.isRemote && delay > 0) {
            //
            // TODO Sending chat message
            //

            ITextComponent msg = LocalizeUtils.getClientSideTranslation(player, LocalizeUtils.i18n(String.format("entity.%s.name", EntityList.getTranslationName(entityId))));
            msg.getStyle().setColor(TextFormatting.AQUA);
            msg.appendText("\n");
            ITextComponent name = LocalizeUtils.getClientSideTranslation(player, "summon.single_use_spawner.delay", delay);
            name.getStyle().setColor(TextFormatting.WHITE);
            msg.appendSibling(name);

            player.sendMessage(msg);
        }
    }

    public boolean isActivated() {
        return isActivated;
    }

    private void removeBlock() {
        world.setBlockToAir(pos);
    }
}
