package divinerpg.objects.blocks.tile.entity;

import divinerpg.DivineRPG;
import divinerpg.utils.LocalizeUtils;
import divinerpg.utils.PositionHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.common.util.FakePlayer;

public class TileEntitySingleUseSpawner extends TileEntity implements ITickable {

    private ResourceLocation entityId;
    private int delay;
    private int blockReachDistance;
    private boolean isActivated = false;

    /**
     * Search radius for boss spawn
     */
    private BlockPos searchRadius = new BlockPos(8, 4, 8);
    private BlockPos baseOffset;

    /**
     * NBT ctor
     */
    public TileEntitySingleUseSpawner() {

    }

    /**
     * @param entityClass        - entity to spawn
     * @param delay              - delay in ticks
     * @param blockReachDistance - auto spawn nearh player. Pass zero to ignore
     */
    public TileEntitySingleUseSpawner(Class<? extends Entity> entityClass,
                                      int delay,
                                      int blockReachDistance,
                                      BlockPos baseOffset) {
        this.entityId = EntityList.getKey(entityClass);
        this.delay = delay;
        this.blockReachDistance = blockReachDistance;
        this.baseOffset = baseOffset;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        NBTTagCompound result = super.writeToNBT(compound);
        result.setInteger("delay", delay);
        result.setLong("addY", baseOffset.toLong());
        result.setBoolean("activated", isActivated);
        result.setInteger("spawnNearPlayer", blockReachDistance);
        result.setString("entityID", entityId.toString());
        return result;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        delay = compound.getInteger("delay");
        baseOffset = BlockPos.fromLong(compound.getLong("addY"));
        isActivated = compound.getBoolean("activated");
        blockReachDistance = compound.getInteger("spawnNearPlayer");
        entityId = new ResourceLocation(compound.getString("entityID"));
    }

    @Override
    public void update() {
        tryActivateByNearPlayer();

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

        entity = getRelocatedEntity(entity);

        if (entity != null)
            world.spawnEntity(entity);
        else
            DivineRPG.logger.warn("Can't summon entity, there is no free place here");
    }

    /**
     * Searches for player nearby and activate spawner
     */
    private void tryActivateByNearPlayer() {
        if (blockReachDistance <= 0 || isActivated)
            return;

        EntityPlayer player = world.getNearestAttackablePlayer(pos, blockReachDistance, blockReachDistance);

        if (player == null || player instanceof FakePlayer)
            return;

        activate(player);
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
            // TODO entity name is not colored
            //

            ITextComponent msg = LocalizeUtils.getClientSideTranslation(player, LocalizeUtils.i18n(String.format("entity.%s.name", EntityList.getTranslationName(entityId))));
            msg.getStyle().setColor(TextFormatting.AQUA);
            player.sendMessage(msg);

            msg = LocalizeUtils.getClientSideTranslation(player, "summon.single_use_spawner.delay", delay / 20);
            msg.getStyle().setColor(TextFormatting.WHITE);

            player.sendMessage(msg);
        }
    }

    protected Entity getRelocatedEntity(Entity e) {
        BlockPos intialSpawnPosition = pos.up(searchRadius.getY() / 2).add(baseOffset);

        BlockPos blockPos = PositionHelper.searchInRadius(world, intialSpawnPosition, searchRadius, x -> {
            e.setPosition(x.getX(), x.getY(), x.getZ());

            return world.getCollisionBoxes(e, e.getEntityBoundingBox()).isEmpty();
        });

        if (blockPos == null)
            return null;

        e.setPosition(blockPos.getX(), blockPos.getY(), blockPos.getZ());
        return e;
    }

    public boolean isActivated() {
        return isActivated;
    }

    private void removeBlock() {
        world.setBlockToAir(pos);
    }
}
