package naturix.divinerpg.objects.entities.entity.arcana;

import naturix.divinerpg.objects.entities.entity.EntityDivineRPGTameable;
import naturix.divinerpg.objects.entities.entity.EntityStats;
import naturix.divinerpg.objects.entities.entity.projectiles.EntityFyracryxFireball;
import naturix.divinerpg.registry.ModSounds;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class Fyracryx extends EntityDivineRPGTameable implements IRangedAttackMob {
	
    public Fyracryx(World par1World, EntityPlayer par2EntityPlayer) {
        this(par1World);
        this.setTamed(true);
        this.isImmuneToFire=true;
        this.setOwnerId(par2EntityPlayer.getUniqueID()); //setOwner
    }

    public Fyracryx(World par1World) {
        super(par1World);
        this.setSize(2F, 2F);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EntityStats.fyracryxHealth);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(EntityStats.fyracryxSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(EntityStats.fyracryxFollowRange);
    }


    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.DEATHCRYX;
    }
 
    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return ModSounds.DEATHCRYX_HURT;
    }
 
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DEATHCRYX;
    }

    @Override
    public boolean processInteract(EntityPlayer par1EntityPlayer, EnumHand hand) {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

        if (this.isTamed()) {
            if (var2 != null) {
                if (var2.getItem() instanceof ItemFood) {
                    ItemFood var3 = (ItemFood)var2.getItem();

//                    if (var3.isWolfsFavoriteMeat() && this.dataManager.get(18) < 20) {
                    if(var3.isWolfsFavoriteMeat()) {
                        if (!par1EntityPlayer.capabilities.isCreativeMode) {
                            var2.shrink(1);
                        }
                        this.heal(var3.getHealAmount(var2));
                        return true;
                    }
                }
            }
        } else {
            this.setTamed(true);
            this.setOwnerId(par1EntityPlayer.getUniqueID());
            this.playTameEffect(true);
        }
        return super.processInitialInteract(par1EntityPlayer, hand);
    }

    @Override
    public EntityAgeable createChild(EntityAgeable var1) {
        return null;
    }
    
    @Override
    public void onUpdate() {
    	super.onUpdate();
    	if(this.getAttackTarget() != null && !this.world.isRemote && this.ticksExisted%20==0)this.attackEntityWithRangedAttack(this.getAttackTarget(), 0);
    }

    @Override
    public void attackEntityWithRangedAttack(EntityLivingBase e, float f) {
    	double tx = e.posX - this.posX;
        double ty = e.getEntityBoundingBox().minY - this.posY;
        double tz = e.posZ - this.posZ;
        float var9 = MathHelper.sqrt(this.getDistance(this)) * 0.5F;
        //FIXME - ummm what
//        this.world.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);

        EntityFyracryxFireball var11 = new EntityFyracryxFireball(this.world, this, tx + this.rand.nextGaussian() * var9, ty, tz + this.rand.nextGaussian() * var9);
        var11.posY = this.posY + this.height / 2.0F + 0.5D;
        this.world.spawnEntity(var11);
    }

	@Override
	public void setSwingingArms(boolean swingingArms) {
	}
}