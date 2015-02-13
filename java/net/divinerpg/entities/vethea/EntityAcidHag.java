package net.divinerpg.entities.vethea;

import net.divinerpg.entities.base.EntityDivineRPGMob;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityAcidHag extends VetheaMob {
	
    public EntityAcidHag(World var1) {
        super(var1);
        addAttackingAI();
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();

        int var1 = MathHelper.floor_double(this.posX);
        int var2 = MathHelper.floor_double(this.posZ);

        for (var1 = 0; var1 < 4; ++var1) {
            var2 = MathHelper.floor_double(this.posX + (var1 % 2 * 2 - 1) * 0.25F);
            int var3 = MathHelper.floor_double(this.posY);
            int var4 = MathHelper.floor_double(this.posZ + (var1 / 2 % 2 * 2 - 1) * 0.25F);

            if (this.worldObj.getBlock(var2, var3 - 1, var4).getMaterial().isSolid() && Blocks.snow.canPlaceBlockAt(this.worldObj, var2, var3, var4)) {
                this.worldObj.setBlock(var2, var3, var4, VetheaBlocks.blockAcid);
            }
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(net.divinerpg.entities.base.EntityStats.acidHagHealth);
        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(net.divinerpg.entities.base.EntityStats.acidHagDamage);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(net.divinerpg.entities.base.EntityStats.acidHagSpeed);
        this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(net.divinerpg.entities.base.EntityStats.acidHagFollowRange);
    }

    @Override
    protected String getLivingSound() {
        return Sounds.acidHag.getPrefixedName();
    }

    @Override
    protected String getHurtSound() {
        return Sounds.acidHagHurt.getPrefixedName();
    }

    @Override
    protected String getDeathSound() {
        return getHurtSound();
    }

    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        int var2 =  5;

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
            ((EntityLiving) par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, 16 * 5, 1));
        }

        boolean var4 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), var2);

        if (var4) {
            if (var3 > 0) {
                par1Entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F) * var3 * 0.5F, 0.1D, MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F) * var3 * 0.5F);
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
    public int getSpawnLayer() {
    	return 1;
    }

    @Override
    protected void dropFewItems(boolean beenHit, int lootingLevel) {
        this.dropItem(VetheaItems.dirtyPearls, 1);
        this.dropItem(VetheaItems.acid, this.rand.nextInt(3)+1);
    }

	@Override
	public String mobName() {
		return "Acid Hag";
	}
}