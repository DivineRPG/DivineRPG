package net.divinerpg.entities.twilight;

import net.divinerpg.entities.base.EntityDivineRPGTameable;
import net.divinerpg.entities.base.EntityStats;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityMoonWolf extends EntityDivineRPGTameable {
	
    private float headRotationX, headRotationY, timeWolfIsShaking, prevTimeWolfIsShaking;
    private boolean isShaking, shakingAndDry;

    public EntityMoonWolf(World world) {
        super(world);
        this.setSize(0.6F, 0.8F);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30000001192092896D);
        if(!this.isTamed())this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.moonWolfHealth);
        else this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.moonWolfFollowRange);
    }
    
    @Override
    public void setTamed(boolean par1) {
        super.setTamed(par1);
    }
 
    public boolean isAIEnabled() {
        return true;
    }

    @Override
    protected void updateAITick() {
        this.dataWatcher.updateObject(18, Float.valueOf(this.getHealth()));
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(18, new Float(this.getHealth()));
        this.dataWatcher.addObject(19, new Byte((byte)0));
    }

    @Override
    protected void func_145780_a(int x, int y, int z, Block steppedOn) {
        this.playSound("mob.wolf.step", 0.15F, 1.0F);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound compound) {
        super.writeEntityToNBT(compound);
        compound.setBoolean("Angry", this.isAngry());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound compound) {
        super.readEntityFromNBT(compound);
        this.setAngry(compound.getBoolean("Angry"));
    }

    @Override
    protected String getLivingSound() {
        return this.isAngry() ? "mob.wolf.growl" : (this.rand.nextInt(3) == 0 ? (this.isTamed() && this.dataWatcher.getWatchableObjectFloat(18) < 10.0F ? "mob.wolf.whine" : "mob.wolf.panting") : "mob.wolf.bark");
    }

    @Override
    protected String getHurtSound() {
        return "mob.wolf.hurt";
    }

    @Override
    protected String getDeathSound() {
        return "mob.wolf.death";
    }

    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }

    @Override
    protected Item getDropItem() {
        return null;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if(!this.worldObj.isRemote && this.isShaking && !this.shakingAndDry && !this.hasPath() && this.onGround) {
            this.shakingAndDry = true;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
            this.worldObj.setEntityState(this, (byte)8);
        }
        
        if(this.isAngry()) {
            this.setAttackTarget(this.worldObj.getClosestVulnerablePlayerToEntity(this, 24));
            if(this.rand.nextInt(400) == 0 && this.getAttackTarget() == null) this.setAngry(false);
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        this.headRotationY = this.headRotationX;

        if(this.isRotatingCalled()) {
            this.headRotationX += (1.0F - this.headRotationX) * 0.4F;
        } else {
            this.headRotationX += (0.0F - this.headRotationX) * 0.4F;
        }

        if(this.isRotatingCalled()) {
            this.numTicksToChaseTarget = 10;
        }

        if(this.isWet()) {
            this.isShaking = true;
            this.shakingAndDry = false;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
        }
        else if((this.isShaking || this.shakingAndDry) && this.shakingAndDry) {
            if(this.timeWolfIsShaking == 0.0F) {
                this.playSound("mob.wolf.shake", this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            }

            this.prevTimeWolfIsShaking = this.timeWolfIsShaking;
            this.timeWolfIsShaking += 0.05F;

            if(this.prevTimeWolfIsShaking >= 2.0F) {
                this.isShaking = false;
                this.shakingAndDry = false;
                this.prevTimeWolfIsShaking = 0.0F;
                this.timeWolfIsShaking = 0.0F;
            }

            if(this.timeWolfIsShaking > 0.4F) {
                float f = (float)this.boundingBox.minY;
                int i = (int)(MathHelper.sin((this.timeWolfIsShaking - 0.4F) * (float)Math.PI) * 7.0F);

                for (int j = 0; j < i; ++j) {
                    float f1 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    this.worldObj.spawnParticle("splash", this.posX + (double)f1, (double)(f + 0.8F), this.posZ + (double)f2, this.motionX, this.motionY, this.motionZ);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public boolean getWolfShaking()  {
        return this.isShaking;
    }

    @SideOnly(Side.CLIENT)
    public float getShadingWhileShaking(float par1) {
        return 0.75F + (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * par1) / 2.0F * 0.25F;
    }

    @SideOnly(Side.CLIENT)
    public float getShakeAngle(float par1, float par2) {
        float f2 = (this.prevTimeWolfIsShaking + (this.timeWolfIsShaking - this.prevTimeWolfIsShaking) * par1 + par2) / 1.8F;

        if(f2 < 0.0F) {
            f2 = 0.0F;
        }
        else if(f2 > 1.0F) {
            f2 = 1.0F;
        }

        return MathHelper.sin(f2 * (float)Math.PI) * MathHelper.sin(f2 * (float)Math.PI * 11.0F) * 0.15F * (float)Math.PI;
    }

    @Override
    public float getEyeHeight() {
        return this.height * 0.8F;
    }

    @SideOnly(Side.CLIENT)
    public float getInterestedAngle(float par1) {
        return (this.headRotationY + (this.headRotationX - this.headRotationY) * par1) * 0.15F * (float)Math.PI;
    }

    @Override
    public int getVerticalFaceSpeed() {
        return this.isSitting() ? 20 : super.getVerticalFaceSpeed();
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float par2) {
        if(this.isEntityInvulnerable()) {
            return false;
        } else {
            Entity entity = source.getEntity();
            this.aiSit.setSitting(false);

            if(entity != null && !(entity instanceof EntityPlayer) && !(entity instanceof EntityArrow)) {
                par2 = (par2 + 1.0F) / 2.0F;
            }
            
            if(entity instanceof EntityPlayer && !this.isTamed()) this.setAngry(true);

            return super.attackEntityFrom(source, par2);
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)EntityStats.moonWolfDamage);
    }

    @Override
    public boolean interact(EntityPlayer player) {
        ItemStack stack = player.inventory.getCurrentItem();

        if(this.isTamed()) {
            if(stack != null && stack.getItem() instanceof ItemFood) {
                ItemFood food = (ItemFood)stack.getItem();

                if(food.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectFloat(18) < 200.0F) {
                    if(!player.capabilities.isCreativeMode) --stack.stackSize;

                    this.heal((float)food.func_150905_g(stack));

                    if(stack.stackSize <= 0)
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);

                    return true;
                }
            }
            
            if(this.func_152114_e(player) && !this.worldObj.isRemote && (stack == null || !this.isBreedingItem(stack))) {             
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
                this.setPathToEntity((PathEntity)null);
                this.setTarget((Entity)null);
                this.setAttackTarget((EntityLivingBase)null);
            }
        }
        
        else if(stack != null && stack.getItem() == Items.bone && !this.isAngry()) {
            if(!player.capabilities.isCreativeMode) --stack.stackSize;

            if(stack.stackSize <= 0)
                player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);

            if(!this.worldObj.isRemote) {
                if(this.rand.nextInt(3) == 0) {
                    this.setTamed(true);
                    this.setPathToEntity((PathEntity)null);
                    this.setAttackTarget((EntityLivingBase)null);
                    this.aiSit.setSitting(true);
                    this.setHealth(20.0F);
                    this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(20);
                    this.func_152115_b(player.getUniqueID().toString());
                    this.playTameEffect(true);
                    this.worldObj.setEntityState(this, (byte)7);
                } else {
                    this.playTameEffect(false);
                    this.worldObj.setEntityState(this, (byte)6);
                }
            }
            return true;
        }
        return super.interact(player);
    }

    @SideOnly(Side.CLIENT)
    public float getTailRotation() {
        return this.isAngry() ? 1.5393804F : (this.isTamed() ? (0.55F - (20.0F - this.dataWatcher.getWatchableObjectFloat(18)) * 0.02F) * (float)Math.PI : ((float)Math.PI / 5F));
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack == null ? false : (!(stack.getItem() instanceof ItemFood) ? false : ((ItemFood)stack.getItem()).isWolfsFavoriteMeat());
    }

    @Override
    public boolean isAngry() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
    }

    public void setAngry(boolean par1) {
        byte b = this.dataWatcher.getWatchableObjectByte(16);
        if(par1) {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b | 2)));
        } else {
            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b & -3)));
        }
    }

    @Override
    public EntityMoonWolf createChild(EntityAgeable par1EntityAgeable) {
        return null;
    }

    public boolean isRotatingCalled() {
        return this.dataWatcher.getWatchableObjectByte(19) == 1;
    }

    @Override
    protected boolean canDespawn() {
        return !this.isTamed();
    }
    
	@Override
	public String mobName() {
		return "Moon Wolf";
	}
}