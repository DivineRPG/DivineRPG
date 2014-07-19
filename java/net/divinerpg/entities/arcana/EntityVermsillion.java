package net.divinerpg.entities.arcana;

import net.divinerpg.api.entity.EntityDivineRPGTameable;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityVermsillion extends EntityDivineRPGTameable {
	
    private float field_70926_e;
    private float field_70924_f;
    private boolean isShaking;
    private boolean field_70928_h;
    private float timeWolfIsShaking;
    private float prevTimeWolfIsShaking;
    private int waitTick;

    public EntityVermsillion(World var1) {
        super(var1);
        this.setSize(0.6F, 0.8F);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.api.entity.EntityStats.vermsillionHealth);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.api.entity.EntityStats.vermsillionSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.api.entity.EntityStats.vermsillionFollowRange);
    }

    @Override
    protected void updateAITasks() {
        if (this.getAttackTarget() != null && this.waitTick <= 0) {
            this.waitTick = 50;
        }
        else if (this.waitTick == 1) {
            this.setAIMoveSpeed((float) this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
            --this.waitTick;
        }
        else if (this.waitTick == 10) {
            this.setAIMoveSpeed(0);
            --this.waitTick;
        }
        else if (this.waitTick > 0) {
            --this.waitTick;
            this.moveEntityWithHeading(0F, (float) this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
        }

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
        this.dataWatcher.addObject(19, new Byte((byte)0));
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
    protected String getLivingSound() {
        return "";
    }

    @Override
    protected String getHurtSound() {
        return "";
    }

    @Override
    protected String getDeathSound() {
        return "";
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (!this.worldObj.isRemote && this.isShaking && !this.field_70928_h && !this.hasPath() && this.onGround) {
            this.field_70928_h = true;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
            this.worldObj.setEntityState(this, (byte)8);
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
            this.numTicksToChaseTarget = 10;
        }

        if (this.isWet()) {
            this.isShaking = true;
            this.field_70928_h = false;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
        }
        else if ((this.isShaking || this.field_70928_h) && this.field_70928_h) {
            if (this.timeWolfIsShaking == 0.0F) {
                this.worldObj.playSoundAtEntity(this, "mob.wolf.shake", this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
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
                float var1 = (float)this.boundingBox.minY;
                int var2 = (int)(MathHelper.sin((this.timeWolfIsShaking - 0.4F) * (float)Math.PI) * 7.0F);

                for (int var3 = 0; var3 < var2; ++var3) {
                    float var4 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    float var5 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    this.worldObj.spawnParticle("splash", this.posX + var4, var1 + 0.8F, this.posZ + var5, this.motionX, this.motionY, this.motionZ);
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
        Entity var3 = var1.getEntity();
        this.aiSit.setSitting(false);

        if (var3 != null && !(var3 instanceof EntityPlayer) && !(var3 instanceof EntityArrow)) {
            var2 = (var2 + 1) / 2;
        }

        return super.attackEntityFrom(var1, var2);
    }

    @Override
    public boolean attackEntityAsMob(Entity var1) {
        int var2 = (int) this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
        var1.addVelocity(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * 3 * 0.5F, 0.1D, MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * 3 * 0.5F);
        this.motionX *= 0.6D;
        this.motionZ *= 0.6D;
        return var1.attackEntityFrom(DamageSource.causeMobDamage(this), var2);
    }
 
    @Override
    public boolean interact(EntityPlayer var1) {
        ItemStack var2 = var1.inventory.getCurrentItem();

        if (this.isTamed()) {
            if (var2 != null && var2.getItem() instanceof ItemFood) {
                ItemFood var3 = (ItemFood)var2.getItem();

                if (var3.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectInt(18) < this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue()) {
                    if (!var1.capabilities.isCreativeMode) {
                        --var2.stackSize;
                    }

                    this.heal(var3.func_150905_g(var2));

                    if (var2.stackSize <= 0) {
                        var1.inventory.setInventorySlotContents(var1.inventory.currentItem, (ItemStack)null);
                    }

                    return true;
                }
            }

            if (var1.getDisplayName().equalsIgnoreCase(this.func_152113_b()) && !this.worldObj.isRemote && !this.isWheat(var2)) {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.setPathToEntity((PathEntity)null);
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

        return super.interact(var1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte var1) {
        if (var1 == 8) {
            this.field_70928_h = true;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
        } else {
            super.handleHealthUpdate(var1);
        }
    }

    @SideOnly(Side.CLIENT)
    public float getTailRotation() {
        return this.isAngry() ? 1.5393804F : (this.isTamed() ? (0.55F - (20 - this.dataWatcher.getWatchableObjectInt(18)) * 0.02F) * (float)Math.PI : ((float)Math.PI / 5F));
    }

    public boolean isWheat(ItemStack var1) {
        return var1 == null ? false : (!(var1.getItem() instanceof ItemFood) ? false : ((ItemFood)var1.getItem()).isWolfsFavoriteMeat());
    }
 
    @Override
    public int getMaxSpawnedInChunk() {
        return 8;
    }

    public boolean isAngry() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
    }

    public void setAngry(boolean var1) {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if (var1) {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 | 2)));
        } else {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(var2 & -3)));
        }
    }
 
    @Override
    public EntityAnimal createChild(EntityAgeable var1) {
        EntityVermsillion var2 = new EntityVermsillion(this.worldObj);
        var2.func_152115_b(this.func_152113_b());
        var2.setTamed(true);
        return var2;
    }

    public void func_70918_i(boolean var1) {
        byte var2 = this.dataWatcher.getWatchableObjectByte(19);

        if (var1) {
            this.dataWatcher.updateObject(19, Byte.valueOf((byte)1));
        } else {
            this.dataWatcher.updateObject(19, Byte.valueOf((byte)0));
        }
    }
 
    @Override
    public boolean canMateWith(EntityAnimal var1) {
        if (var1 == this)
            return false;
        else if (!this.isTamed())
            return false;
        else if (!(var1 instanceof EntityVermsillion))
            return false;
        else {
            EntityVermsillion var2 = (EntityVermsillion)var1;
            return !var2.isTamed() ? false : (var2.isSitting() ? false : this.isInLove() && var2.isInLove());
        }
    }

    public boolean func_70922_bv() {
        return this.dataWatcher.getWatchableObjectByte(19) == 1;
    }
 
    @Override
    public boolean getCanSpawnHere() {
        int var1 = MathHelper.floor_double(this.posX);
        int var2 = MathHelper.floor_double(this.boundingBox.minY);
        int var3 = MathHelper.floor_double(this.posZ);
        return this.getBlockPathWeight(var1, var2, var3) >= 0.0F && this.worldObj.checkNoEntityCollision(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).isEmpty() && !this.worldObj.isAnyLiquid(this.boundingBox);
    }

	@Override
	public String mobName() {
		return "Vermsillion";
	}
}