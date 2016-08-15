package net.divinerpg.entities.vanilla;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityJungleSpider extends EntityDivineRPGMob {
	
    public EntityJungleSpider(World var1) {
        super(var1);
        this.setSize(1.4F, 0.9F);
        addAttackingAI();
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.jungleSpiderHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.jungleSpiderDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.jungleSpiderSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.jungleSpiderFollowRange);
    }

	@Override
    protected void entityInit() {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }

	@Override
    public void onUpdate() {
        super.onUpdate();

        if(!this.worldObj.isRemote) {
        	this.setBesideClimbableBlock(this.isCollidedHorizontally);
        }
    }
    
	@Override
    public double getMountedYOffset() {
        return (double)this.height * 0.75D - 0.5D;
    }

	@Override
    protected boolean canTriggerWalking() {
        return false;
    }

	@Override
    protected Entity findPlayerToAttack() {
        float var1 = this.getBrightness(1.0F);

        if(var1 < 1.0F) {
            double var2 = 16.0D;
            return this.worldObj.getClosestVulnerablePlayerToEntity(this, var2);
        } else {
            return null;
        }
    }

	@Override
    protected String getLivingSound() {
        return Sounds.getSoundName(Sounds.jungleSpider);
    }

	@Override
    protected String getHurtSound() {
        return "mob.spider.say";
    }

	@Override
    protected String getDeathSound() {
        return "mob.spider.death";
    }

	@Override
    protected void attackEntity(Entity var1, float var2) {
        if(var2 > 2.0F && var2 < 6.0F && this.rand.nextInt(10) == 0) {
            if(this.onGround) {
                double var3 = var1.posX - this.posX;
                double var5 = var1.posZ - this.posZ;
                float var7 = MathHelper.sqrt_double(var3 * var3 + var5 * var5);
                this.motionX = var3 / (double)var7 * 0.5D * 0.800000011920929D + this.motionX * 0.20000000298023224D;
                this.motionZ = var5 / (double)var7 * 0.5D * 0.800000011920929D + this.motionZ * 0.20000000298023224D;
                this.motionY = 0.4000000059604645D;
            }
        } else {
            super.attackEntity(var1, var2);
        }
    }
    
	@Override
    public boolean attackEntityAsMob(Entity entity) {
        int var2 = (int)this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();

        if(this.isPotionActive(Potion.damageBoost)) {
            var2 += 3 << this.getActivePotionEffect(Potion.damageBoost).getAmplifier();
        }

        if(this.isPotionActive(Potion.weakness)) {
            var2 -= 2 << this.getActivePotionEffect(Potion.weakness).getAmplifier();
        }

        int var3 = 0;

        if(entity instanceof EntityLiving) {
            var2 += EnchantmentHelper.getEnchantmentModifierLiving(this, (EntityLiving)entity);
            var3 += EnchantmentHelper.getKnockbackModifier(this, (EntityLiving)entity);
        }

        boolean var4 = entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);

        if(var4) {
            if(var3 > 0) {
                entity.addVelocity((double)(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * (float)var3 * 0.5F), 0.1D, (double)(MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * (float)var3 * 0.5F));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }
            
            
            int var5 = EnchantmentHelper.getFireAspectModifier(this);
            
            if(entity instanceof EntityLivingBase)((EntityLivingBase)entity).addPotionEffect(new PotionEffect(Potion.poison.id, var2 * 20, 0));

            if(var5 > 0) {
                entity.setFire(var5 * 4);
            }
        }
        return var4;
    }

	@Override
    protected void dropFewItems(boolean var1, int var2) {
		int var3 = this.rand.nextInt(2 + var2);
		
		for (int var4 = 0; var4 < var3; var4++) {
			this.dropItem(VanillaItemsOther.jungleShards, 1);
		}
		
		var3 = this.rand.nextInt(2 + var2);
		
		for (int var4 = 0; var4 < var3; var4++) {
			this.dropItem(VanillaItemsOther.jungleShards, 2);
		}

    }

	@Override
    public boolean isOnLadder() {
        return this.isBesideClimbableBlock();
    }

	@Override
    public void setInWeb() {}

	@Override
    public EnumCreatureAttribute getCreatureAttribute() {
        return EnumCreatureAttribute.ARTHROPOD;
    }

    public boolean isBesideClimbableBlock() {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }

    public void setBesideClimbableBlock(boolean var1) {
        byte var2 = this.dataWatcher.getWatchableObjectByte(16);

        if(var1) {
            var2 = (byte)(var2 | 1);
        } else {
            var2 &= -2;
        }
        this.dataWatcher.updateObject(16, Byte.valueOf(var2));
    }

	@Override
	public String mobName() {
		return "Jungle Spider";
	}
}