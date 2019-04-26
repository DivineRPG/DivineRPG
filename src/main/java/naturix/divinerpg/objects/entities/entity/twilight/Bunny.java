package naturix.divinerpg.objects.entities.entity.twilight;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGTameable;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.registry.ModSounds;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class Bunny extends EntityDivineRPGTameable {

    public Bunny(World var1) {
        super(var1);
        this.setSize(0.5F, 0.5F);
        this.experienceValue = 40;
    }
    
    @Override
    public void entityInit() {
        super.entityInit();
//        this.dataWatcher.addObject(19, 0);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        if(!this.isTamed())this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10);
        else this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }

    @Override
    protected boolean canDespawn() {
        return !this.isTamed();
    }

    @Override
    public void onDeath(DamageSource var1) {
        super.onDeath(var1);
        if(!this.world.isRemote && !this.isTamed()) {
            Entity var3 = var1.getTrueSource();
            if(var3 instanceof EntityPlayerMP) {
                //FIXME -Triger friend or foe
            }
            this.transform();
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity target) {
        double i = 1;
        if(this.isTamed()) {
//            this.dataWatcher.updateObject(19, 1);
        }
        return target.attackEntityFrom(DamageSource.causeMobDamage(this), (float)i);
    }
    
    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!this.world.isRemote) {
//            if(this.isTamed() && this.getAttackTarget() == null) this.dataWatcher.updateObject(19, 0);
        }
    }

    private void transform()  {
        if(!this.world.isRemote) {
            AngryBunny e = new AngryBunny(this.world);
            e.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.world.spawnEntity(e);
            this.setDead();
        }
    }
    @Override
    public boolean processInteract(EntityPlayer player, EnumHand hand)
    {
        ItemStack held = player.inventory.getCurrentItem();

        if(this.isTamed()) {
            if(held != null && held.getItem() instanceof ItemFood) {
                ItemFood food = (ItemFood)held.getItem();

                if(food.isWolfsFavoriteMeat() && this.getHealth() < 20) {
                    if(!player.capabilities.isCreativeMode) {
                        held.shrink(1);
                    }
                    this.heal((float)food.getHealAmount(held));
                    if(held.getCount() <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
                    }
                    return true;
                }
            }
            //FIXME - Line below causes crash
            if(player.getUniqueID().toString().equals(this.getOwnerId().toString()) && !this.world.isRemote) {
                this.aiSit.setSitting(!this.isSitting());
                this.isJumping = false;
//                this.setPathToEntity((PathEntity)null);
            }
        }
        else if(held != null && held.getItem() == ModItems.edenSparkles) {
            if(!player.capabilities.isCreativeMode) {
                held.shrink(1);
            }

            if(held.getCount() <= 0) {
                player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
            }

            if(!this.world.isRemote) {
                if(this.rand.nextInt(3) == 0) {
                    this.setTamed(true);
//                    this.setPathToEntity((PathEntity)null);
                    this.setAttackTarget((EntityLiving)null);
                    this.aiSit.setSitting(true);
                    this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20);
                    this.setHealth(20);
                    this.setOwnerId(player.getUniqueID());
                    this.playTameEffect(true);
                    this.world.setEntityState(this, (byte)7);
                } else {
                    this.playTameEffect(false);
                    this.world.setEntityState(this, (byte)6);
                }
            }
            return true;
        }
        return super.processInteract(player, hand);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.rand.nextInt(4) != 0 ? null : ModSounds.BUNNY;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.BUNNY_HURT;
    }
 
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.BUNNY_HURT;
    }
    public static final ResourceLocation LOOT = new ResourceLocation(Reference.MODID, "entities/twilight/bunny");
    
    @Override
    protected ResourceLocation getLootTable() {
        return this.LOOT;
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }
    
    @Override
    public EntityLivingBase getAttackTarget() {
        EntityLivingBase e = super.getAttackTarget();
        if(e != null && ((this.isTamed() && this.getDistanceSq(e) < 144) || !this.isTamed())) return e;
        return null;
    }
}