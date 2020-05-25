package divinerpg.objects.entities.entity.vanilla;

import divinerpg.objects.entities.entity.EntityDivineTameable;
import divinerpg.registry.LootTableRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityHellPig extends EntityDivineTameable {
    private static final DataParameter<Float> HEALTH = EntityDataManager.createKey(EntityHellPig.class,
            DataSerializers.FLOAT);
    private static final DataParameter<Boolean> ANGRY = EntityDataManager.createKey(EntityHellPig.class,
            DataSerializers.BOOLEAN);

    public EntityHellPig(World worldIn, EntityPlayer player) {
        this(worldIn);
        setOwnerId(player.getUniqueID());
    }

    public EntityHellPig(World worldIn) {
        super(worldIn);
        this.setSize(1F, 0.9F);
    }

    @Override
    public float getEyeHeight() {
        return 0.8F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        increaseHealthIfTimable();
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        dataManager.register(HEALTH, this.getHealth());
        dataManager.register(ANGRY, Boolean.FALSE);
    }

    @Override
    protected void updateAITasks() {
        super.updateAITasks();
        this.dataManager.set(HEALTH, this.getHealth());
    }

    @Override
    public void setAttackTarget(EntityLivingBase attackTarget) {
        super.setAttackTarget(attackTarget);
        if (attackTarget == null)
            this.setAngry(false);
        else if (!this.isTamed())
            this.setAngry(true);
    }

    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack itemstack = player.getHeldItem(hand);

        if (this.isTamed()) {
            if (!itemstack.isEmpty()) {
                if (itemstack.getItem() instanceof ItemFood) {
                    ItemFood food = (ItemFood) itemstack.getItem();
                    if (food.isWolfsFavoriteMeat() && this.dataManager.get(HEALTH) < 20.0F) {
                        if (!player.capabilities.isCreativeMode) {
                            itemstack.shrink(1);
                        }
                        this.heal(food.getHealAmount(itemstack));
                        return true;
                    }
                }
            }
        } else if (!itemstack.isEmpty() && itemstack.getItem() == Items.BLAZE_POWDER && !this.isAngry()) {
            if (!player.capabilities.isCreativeMode) {
                itemstack.shrink(1);
            }
            if (!this.world.isRemote) {
                if (this.rand.nextInt(3) == 0) {
                    this.setTamedBy(player);
                    this.navigator.clearPath();
                    this.setAttackTarget(null);
                    this.aiSit.setSitting(true);
                    this.setHealth(20.0F);
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte) 7);
                } else {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte) 6);
                }
            }
            return true;
        }

        return super.processInteract(player, hand);
    }

    @Override
    public void setTamed(boolean tamed) {
        super.setTamed(tamed);
        increaseHealthIfTimable();
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag) {
        super.writeEntityToNBT(tag);
        tag.setBoolean("Angry", this.isAngry());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag) {
        super.readEntityFromNBT(tag);
        setAngry(tag.getBoolean("Angry"));
    }

    public boolean isAngry() {
        return this.dataManager.get(ANGRY);
    }

    public void setAngry(boolean angry) {
        this.dataManager.set(ANGRY, angry);
    }

    @Override
    protected boolean canDespawn() {
        return !this.isTamed() && this.ticksExisted > 2400;
    }

    @Override
    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_WOLF_STEP, 0.15F, 1.0F);
    }

    @Override
    public boolean shouldAttackEntity(EntityLivingBase target, EntityLivingBase owner) {
        if (!(target instanceof EntityCreeper) && !(target instanceof EntityGhast)) {
            if (target instanceof EntityHellPig) {
                EntityHellPig pig = (EntityHellPig) target;
                if (pig.isTamed() && pig.getOwner() == owner)
                    return false;
            }
            return (!(target instanceof EntityPlayer) || !(owner instanceof EntityPlayer)
                    || ((EntityPlayer) owner).canAttackPlayer((EntityPlayer) target)) && (!(target instanceof EntityHorse) || !((EntityHorse) target).isTame());
        } else {
            return false;
        }
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.world.getDifficulty() != EnumDifficulty.PEACEFUL
                && this.world.getBlockState(getPosition().down()).getBlock() == Blocks.SOUL_SAND;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_HELL_PIG;
    }
}
