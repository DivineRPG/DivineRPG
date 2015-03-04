package net.divinerpg.entities.vethea;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityGalroid extends VetheaMob {
	
    public EntityGalroid(World var1) {
        super(var1);
        addAttackingAI();
    }
    
    @Override
    public void entityInit() {
    	super.entityInit();
    	this.dataWatcher.addObject(19, 200);
    	this.dataWatcher.addObject(20, 1);
    }

    @Override
    public int getSpawnLayer() {
    	return 3;
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        if (this.getProtectionTimer() <= 0 && !this.getInvincible()) {
            this.setProtectionTimer(200);
            this.setInvincible(1);
        }
        else if (this.isEntityInvulnerable() && this.getProtectionTimer() <= 0) {
        	this.setProtectionTimer(200);
        	this.setInvincible(0);
        }
        this.setProtectionTimer(this.getProtectionTimer()-1);
    }
    
    public boolean getInvincible() {
    	return this.dataWatcher.getWatchableObjectInt(20) == 1;
    }
    
    public int getProtectionTimer() {
        return this.dataWatcher.getWatchableObjectInt(19);
    }
    
    public void setInvincible(int i) {
    	this.dataWatcher.updateObject(20, i);
    }
    
    public void setProtectionTimer(int i) {
    	this.dataWatcher.updateObject(19, i);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.galroidHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.galroidDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.galroidSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.galroidFollowRange);
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected String getLivingSound() {
        return Sounds.galroid.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.galroidHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        float var2 = 25;

        if (this.isPotionActive(Potion.damageBoost)) {
            var2 += 3 << this.getActivePotionEffect(Potion.damageBoost).getAmplifier();
        }

        if (this.isPotionActive(Potion.weakness)) {
            var2 -= 2 << this.getActivePotionEffect(Potion.weakness).getAmplifier();
        }

        int var3 = 0;

        if (par1Entity instanceof EntityLiving) {
            var2 += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLiving)par1Entity);
            var3 += EnchantmentHelper.getKnockbackModifier(this, (EntityLiving)par1Entity);
        }

        boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);

        if (var4) {
            if (var3 > 0) {
                par1Entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * var3 * 0.5F, 0.4D, MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * var3 * 0.5F);
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int var5 = EnchantmentHelper.getFireAspectModifier(this);

            if (var5 > 0) {
                par1Entity.setFire(var5 * 4);
            }
        }

        return var4;
    }

    @Override
    public boolean isEntityInvulnerable() {
        return this.getInvincible();
    }

    @Override
    protected void dropFewItems(boolean par1, int par2) {
        this.dropItem(VetheaItems.polishedPearls, 1);
    }

	@Override
	public String mobName() {
		return "Galroid";
	}
}