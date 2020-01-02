package divinerpg.objects.entities.entity.vethea;

import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityHelio extends VetheaMob {
	
    public EntityHelio(World var1) {
        super(var1);
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(140);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(40);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27000000417232513D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(20);
    }

    @Override
    public int getSpawnLayer() {
    	return 4;
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }


    @Override
    public boolean attackEntityAsMob(Entity par1Entity) {
        int var2 = (int) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();

        if (this.isPotionActive(MobEffects.STRENGTH)) {
            var2 += 3 << this.getActivePotionEffect(MobEffects.STRENGTH).getAmplifier();
        }

        if (this.isPotionActive(MobEffects.WEAKNESS)) {
            var2 -= 2 << this.getActivePotionEffect(MobEffects.WEAKNESS).getAmplifier();
        }
        int var3 = 7;
        
        if (par1Entity instanceof EntityLiving) {
            var2 += EnchantmentHelper.getEfficiencyModifier((EntityLiving)par1Entity);
            var3 += EnchantmentHelper.getKnockbackModifier((EntityLiving)par1Entity);
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
    protected ResourceLocation getLootTable()
    {
        return DRPGLootTables.ENTITIES_HELIO;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.HELIO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.HELIO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.HELIO_HURT;
    }
}
