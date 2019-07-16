package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGTameable;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Vermsillion extends EntityDivineRPGTameable {
	
    private float field_70926_e;
    private float field_70924_f;
    private boolean isShaking;
    private boolean field_70928_h;
    private float timeWolfIsShaking;
    private float prevTimeWolfIsShaking;
    private int waitTick;

    public Vermsillion(World var1) {
        super(var1);
        this.setSize(0.6F, 0.8F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.vermsillionHealth);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.vermsillionSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.vermsillionFollowRange);
    }

    @Override
    protected void updateAITasks() {
        if (this.getAttackTarget() != null && this.waitTick <= 0) {
            this.waitTick = 50;
        }
        else if (this.waitTick == 1) {
            this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
            --this.waitTick;
        }
        else if (this.waitTick == 10) {
            this.setAIMoveSpeed(0);
            --this.waitTick;
        }
        else if (this.waitTick > 0) {
            --this.waitTick;
            this.moveRelative(0F, (float) this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue(),0F,0F);
        }

        this.dataManager.set(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
        super.updateAITasks();
    }

    @Override
    public void setAttackTarget(EntityLivingBase var1) {
        super.setAttackTarget(var1);

        if (var1 instanceof EntityPlayer) {
            this.setAngry(true);
        }
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(DATA_HEALTH_ID, Float.valueOf(this.getHealth()));
    }
 
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound var1) {
        super.writeEntityToNBT(var1);
        var1.setBoolean("Angry", this.isAngry());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound var1) {
        super.readEntityFromNBT(var1);
        this.setAngry(var1.getBoolean("Angry"));
    }

    @Override
    protected boolean canDespawn() {
        return this.isAngry();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (!this.world.isRemote && this.isShaking && !this.field_70928_h && !this.hasPath() && this.onGround) {
            this.field_70928_h = true;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
            this.world.setEntityState(this, (byte)8);
        }
    }
 
    @Override
    public void onUpdate() {
        super.onUpdate();
        this.field_70924_f = this.field_70926_e;

        if (this.func_70922_bv()) {
            this.field_70926_e += (1.0F - this.field_70926_e) * 0.4F;
        } else {
            this.field_70926_e += (0.0F - this.field_70926_e) * 0.4F;
        }

        if (this.func_70922_bv()) {
            this.ticksSinceLastSwing = 10;
        }

        if (this.isWet()) {
            this.isShaking = true;
            this.field_70928_h = false;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
        }
        else if ((this.isShaking || this.field_70928_h) && this.field_70928_h) {
            if (this.timeWolfIsShaking == 0.0F) {
                this.playSound(SoundEvents.ENTITY_WOLF_SHAKE, this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            }

            this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
            this.timeWolfIsShaking += 0.05F;

            if (this.prevTimeWolfIsShaking >= 2.0F) {
                this.isShaking = false;
                this.field_70928_h = false;
                this.prevTimeWolfIsShaking = 0.0F;
                this.timeWolfIsShaking = 0.0F;
            }

            if (this.timeWolfIsShaking > 0.4F) {
                float var1 = (float)this.getEntityBoundingBox().minY;
                int var2 = (int)(MathHelper.sin((this.timeWolfIsShaking - 0.4F) * (float)Math.PI) * 7.0F);

                for (int var3 = 0; var3 < var2; ++var3) {
                    float var4 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    float var5 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    this.world.spawnParticle(EnumParticleTypes.WATER_SPLASH, this.posX + var4, var1 + 0.8F, this.posZ + var5, this.motionX, this.motionY, this.motionZ);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean getWolfShaking() {
        return this.isShaking;
    }

    @SideOnly(Side.CLIENT)
    public float getShadingWhileShaking(float var1) {
        return 0.75F + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * var1) / 2.0F * 0.25F;
    }

    @SideOnly(Side.CLIENT)
    public float getShakeAngle(float var1, float var2) {
        float var3 = (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * var1 + var2) / 1.8F;

        if (var3 < 0.0F) {
            var3 = 0.0F;
        }
        else if (var3 > 1.0F) {
            var3 = 1.0F;
        }

        return MathHelper.sin(var3 * (float)Math.PI) * MathHelper.sin(var3 * (float)Math.PI * 11.0F) * 0.15F * (float)Math.PI;
    }

    @SideOnly(Side.CLIENT)
    public float getInterestedAngle(float var1) {
        return (this.field_70924_f + (this.field_70926_e - this.field_70924_f) * var1) * 0.15F * (float)Math.PI;
    }

    @Override
    public float getEyeHeight() {
        return this.height * 0.8F;
    }
 
    @Override
    public int getVerticalFaceSpeed() {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }
 
    public boolean attackEntityFrom(DamageSource var1, int var2) {
        Entity var3 = var1.getTrueSource();
        this.aiSit.setSitting(false);

        if (var3 != null && !(var3 instanceof EntityPlayer) && !(var3 instanceof EntityArrow)) {
            var2 = (var2 + 1) / 2;
        }

        return super.attackEntityFrom(var1, var2);
    }

    @Override
    public boolean attackEntityAsMob(Entity var1) {
        int var2 = (int) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
        var1.addVelocity(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * 3 * 0.5F, 0.1D, MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * 3 * 0.5F);
        this.motionX *= 0.6D;
        this.motionZ *= 0.6D;
        return var1.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
    }
 
    @Override
    public boolean processInteract(EntityPlayer var1, EnumHand hand) {
        ItemStack var2 = var1.inventory.getCurrentItem();

        if (this.isTamed()) {
            if (var2 != null && var2.getItem() instanceof ItemFood) {
                ItemFood var3 = (ItemFood)var2.getItem();

                if (var3.isWolfsFavoriteMeat()) {
                	//FIXME - Data Watcher
//                		&& this.dataWatcher.getWatchableObjectInt(18) < this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).getAttributeValue()) {
                    if (!var1.capabilities.isCreativeMode) {
                        var2.shrink(1);
                    }
                    this.heal(var3.getHealAmount(var2));
                    return true;
                }
            }

            if (var1.getDisplayName().equals(this.getOwner().getDisplayName()) && !this.world.isRemote && !this.isWheat(var2)) {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.getBlockPathWeight(var1.getPosition());
            }
        }
        /*
        else if (var2 != null && var2.itemID == VetheaItemHelper.fyrossom.itemID && !this.isAngry())
        {
            if (!var1.capabilities.isCreativeMode)
            {
                --var2.stackSize;
            }
            if (var2.stackSize <= 0)
            {
                var1.inventory.setInventorySlotContents(var1.inventory.currentItem, (ItemStack)null);
            }
            if (!this.worldObj.isRemote)
            {
                if (this.rand.nextInt(3) == 0)
                {
                    this.setTamed(true);
                    this.setPathToEntity((PathEntity)null);
                    this.setAttackTarget((EntityLiving)null);
                    this.aiSit.setSitting(true);
                    this.setHealth((float) this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue());
                    this.setOwner(var1.username);
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte)7);
                }
                else
                {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState(this, (byte)6);
                }
            }
            return true;
        }*/

        return super.processInteract(var1, hand);
    }
    private static final DataParameter<Float> DATA_HEALTH_ID = EntityDataManager.<Float>createKey(EntityWolf.class, DataSerializers.FLOAT);
    

    @SideOnly(Side.CLIENT)
    public float getTailRotation()
    {
        if (this.isAngry())
        {
            return 1.5393804F;
        }
        else
        {
            return this.isTamed() ? (0.55F - (this.getMaxHealth() - ((Float)this.dataManager.get(DATA_HEALTH_ID)).floatValue()) * 0.02F) * (float)Math.PI : ((float)Math.PI / 5F);
        }
    }

    public boolean isWheat(ItemStack var1) {
        return var1 == null ? false : (!(var1.getItem() instanceof ItemFood) ? false : ((ItemFood)var1.getItem()).isWolfsFavoriteMeat());
    }
 
    @Override
    public int getMaxSpawnedInChunk() {
        return 8;
    }

    public boolean isAngry()
    {
        return (((Byte)this.dataManager.get(TAMED)).byteValue() & 2) != 0;
    }

    public void setAngry(boolean angry)
    {
        byte b0 = ((Byte)this.dataManager.get(TAMED)).byteValue();

        if (angry)
        {
            this.dataManager.set(TAMED, Byte.valueOf((byte)(b0 | 2)));
        }
        else
        {
            this.dataManager.set(TAMED, Byte.valueOf((byte)(b0 & -3)));
        }
    }
 
    @Override
    public EntityAnimal createChild(EntityAgeable var1) {
        Vermsillion var2 = new Vermsillion(this.world);
        var2.setOwnerId(this.getOwnerId());
        var2.setTamed(true);
        return var2;
    }

    public void func_70918_i(boolean var1) {
    	//FIXME - Unsure what this method is
//        byte var2 = this.dataWatcher.getWatchableObjectByte(19);
//
//        if (var1) {
//            this.dataWatcher.updateObject(19, Byte.valueOf((byte)1));
//        } else {
//            this.dataWatcher.updateObject(19, Byte.valueOf((byte)0));
//        }
    }
 
    @Override
    public boolean canMateWith(EntityAnimal var1) {
        if (var1 == this)
            return false;
        else if (!this.isTamed())
            return false;
        else if (!(var1 instanceof Vermsillion))
            return false;
        else {
            Vermsillion var2 = (Vermsillion)var1;
            return !var2.isTamed() ? false : (var2.isSitting() ? false : this.isInLove() && var2.isInLove());
        }
    }

    public boolean func_70922_bv() {
		return false;
    	//FIXME - unsure what this does
//        return this.dataWatcher.getWatchableObjectByte(19) == 1;
    }
 
    @Override
    public boolean getCanSpawnHere() {
        int var1 = MathHelper.floor(this.posX);
        int var2 = MathHelper.floor(this.getEntityBoundingBox().minY);
        int var3 = MathHelper.floor(this.posZ);
        return this.getBlockPathWeight(new BlockPos(var1, var2, var3)) >= 0.0F && this.world.checkNoEntityCollision(this.getEntityBoundingBox()) && this.world.getCollisionBoxes(this, this.getEntityBoundingBox()).isEmpty() && !this.world.containsAnyLiquid(this.getEntityBoundingBox());
    }

}