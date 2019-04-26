package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGTameable;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MoonWolf extends EntityDivineRPGTameable {
    
    private float headRotationX, headRotationY, timeWolfIsShaking, prevTimeWolfIsShaking;
    private boolean isShaking, shakingAndDry;

    public MoonWolf(World world) {
        super(world);
        this.setSize(0.6F, 0.8F);
    }

    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.moonWolfSpeed);
        if(!this.isTamed())this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.moonWolfHealth);
        else this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.moonWolfFollowRange);
    }
    
    @Override
    public void setTamed(boolean par1) {
        super.setTamed(par1);
    }
 
    public boolean isAIEnabled() {
        return true;
    }
  //FIXME - data watcher
//    @Override
//    protected void updateAITick() {
//        this.dataWatcher.updateObject(18, Float.valueOf(this.getHealth()));
//    }

    @Override
    protected void entityInit() {
        super.entityInit();
      //FIXME - data watcher
//        this.dataWatcher.addObject(18, new Float(this.getHealth()));
//        this.dataWatcher.addObject(19, new Byte((byte)0));
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
    protected SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : SoundEvents.ENTITY_WOLF_AMBIENT;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_WOLF_HURT;
    }
 
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_WOLF_DEATH;
    }
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/moon_wolf");
    
    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }


    @Override
    protected float getSoundVolume() {
        return 0.4F;
    }


    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if(!this.world.isRemote && this.isShaking && !this.shakingAndDry && !this.hasPath() && this.onGround) {
            this.shakingAndDry = true;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
            this.world.setEntityState(this, (byte)8);
        }
        
        if(this.isAngry()) {
            this.setAttackTarget(this.world.getClosestPlayerToEntity(this, 24));
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
            //FIXME - chase time ticks
//            this.numTicksToChaseTarget = 10;
        }

        if(this.isWet()) {
            this.isShaking = true;
            this.shakingAndDry = false;
            this.timeWolfIsShaking = 0.0F;
            this.prevTimeWolfIsShaking = 0.0F;
        }
        else if((this.isShaking || this.shakingAndDry) && this.shakingAndDry) {
            if(this.timeWolfIsShaking == 0.0F) {
                //FIXME - Moon Wolf Sound
                //                this.playSound("mob.wolf.shake", this.getSoundVolume(), (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
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
                float f = (float)this.getEntityBoundingBox().minY;
                int i = (int)(MathHelper.sin((this.timeWolfIsShaking - 0.4F) * (float)Math.PI) * 7.0F);

                for (int j = 0; j < i; ++j) {
                    float f1 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    float f2 = (this.rand.nextFloat() * 2.0F - 1.0F) * this.width * 0.5F;
                    //FIXME - Particle for moon wolf
//                    this.world.spawnParticle("splash", this.posX + (double)f1, (double)(f + 0.8F), this.posZ + (double)f2, this.motionX, this.motionY, this.motionZ);
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
        if(this.isEntityInvulnerable(source)) {
            return false;
        } else {
            Entity entity = source.getTrueSource();
//            this.aiSit.setSitting(false);

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
    public boolean processInteract(EntityPlayer player, EnumHand hand) {
        ItemStack stack = player.inventory.getCurrentItem();

        if(this.isTamed()) {
            if(stack != null && stack.getItem() instanceof ItemFood) {
                ItemFood food = (ItemFood)stack.getItem();
//FIXME - Datawatcher
//                if(food.isWolfsFavoriteMeat() && this.dataWatcher.getWatchableObjectFloat(18) < 200.0F) {
                    if(!player.capabilities.isCreativeMode) stack.shrink(1);

                    this.heal((float)food.getHealAmount(stack));

                    if(stack.getCount() <= 0)
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);

                    return true;
                }
            }
            //FIXME - unsure of this method
//            if(this.func_152114_e(player) && !this.world.isRemote && (stack == null || !this.isBreedingItem(stack))) {             
//                this.aiSit.setSitting(!this.isSitting());
//                this.isJumping = false;
//                this.setPathToEntity((PathEntity)null);
//                this.setTarget((Entity)null);
//                this.setAttackTarget((EntityLivingBase)null);
//            }
//        }
//        
//        else if(stack != null && stack.getItem() == Items.bone && !this.isAngry()) {
//            if(!player.capabilities.isCreativeMode) --stack.stackSize;
//
//            if(stack.stackSize <= 0)
//                player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
//
//            if(!this.world.isRemote) {
//                if(this.rand.nextInt(3) == 0) {
//                    this.setTamed(true);
//                    this.setPathToEntity((PathEntity)null);
//                    this.setAttackTarget((EntityLivingBase)null);
//                    this.aiSit.setSitting(true);
//                    this.setHealth(20.0F);
//                    this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
//                    this.func_152115_b(player.getUniqueID().toString());
//                    this.playTameEffect(true);
//                    this.world.setEntityState(this, (byte)7);
//                } else {
//                    this.playTameEffect(false);
//                    this.world.setEntityState(this, (byte)6);
//                }
//            }
//            return true;
//        }
        return super.processInteract(player, hand);
    }

    @SideOnly(Side.CLIENT)
    public float getTailRotation() {
        return 0;
        //FIXME - data watcher
//        return this.isAngry() ? 1.5393804F : (this.isTamed() ? (0.55F - (20.0F - this.dataWatcher.getWatchableObjectFloat(18)) * 0.02F) * (float)Math.PI : ((float)Math.PI / 5F));
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack == null ? false : (!(stack.getItem() instanceof ItemFood) ? false : ((ItemFood)stack.getItem()).isWolfsFavoriteMeat());
    }

    @Override
    public boolean isAngry() {
        return false;
      //FIXME - data watcher
        //        return (this.dataWatcher.getWatchableObjectByte(16) & 2) != 0;
    }

    public void setAngry(boolean par1) {
      //FIXME - data watcher
//        byte b = this.dataWatcher.getWatchableObjectByte(16);
//        if(par1) {
//            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b | 2)));
//        } else {
//            this.dataWatcher.updateObject(16, Byte.valueOf((byte)(b & -3)));
//        }
    }

    @Override
    public MoonWolf createChild(EntityAgeable par1EntityAgeable) {
        return null;
    }

    public boolean isRotatingCalled() {
        return false;
      //FIXME - data watcher
//        return this.dataWatcher.getWatchableObjectByte(19) == 1;
    }

    @Override
    protected boolean canDespawn() {
        return !this.isTamed();
    }
    

}