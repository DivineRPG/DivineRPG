package divinerpg.objects.blocks.tile.entity;

import divinerpg.DivineRPG;
import divinerpg.registry.ItemRegistry;
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
    private int defaultDelay;
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
        this.defaultDelay = delay;
        this.delay = 0;
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

        deactivate();
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
        delay = defaultDelay;

        if (!world.isRemote && delay > 0) {
        	if(player.getHeldItemMainhand().getItem() == ItemRegistry.edenChunk){
                player.sendMessage(LocalizeUtils.getClientSideTranslation(player, LocalizeUtils.i18n(TextFormatting.YELLOW, String.format("entity.%s.name", EntityList.getTranslationName(entityId)))));
            	}else
        	if(player.getHeldItemMainhand().getItem() == ItemRegistry.wildwoodChunk){
                player.sendMessage(LocalizeUtils.getClientSideTranslation(player, LocalizeUtils.i18n(TextFormatting.DARK_BLUE, String.format("entity.%s.name", EntityList.getTranslationName(entityId)))));
            	}else
        	if(player.getHeldItemMainhand().getItem() == ItemRegistry.apalachiaChunk){
                player.sendMessage(LocalizeUtils.getClientSideTranslation(player, LocalizeUtils.i18n(TextFormatting.DARK_GREEN, String.format("entity.%s.name", EntityList.getTranslationName(entityId)))));
            	}else
        	if(player.getHeldItemMainhand().getItem() == ItemRegistry.skythernChunk){
                player.sendMessage(LocalizeUtils.getClientSideTranslation(player, LocalizeUtils.i18n(TextFormatting.AQUA, String.format("entity.%s.name", EntityList.getTranslationName(entityId)))));
            	}
            player.sendMessage(LocalizeUtils.getClientSideTranslation(player, "summon.single_use_spawner.delay", delay / 20));
        }
    }

    private void deactivate() {
        this.isActivated = false;
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

}
