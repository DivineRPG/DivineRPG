package divinerpg.objects.entities.entity.arcana;

import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.DRPGLootTables;
import divinerpg.registry.ModSounds;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityDeathcryx extends EntityDivineRPGMob {
    protected Potion potionEffect;

    public EntityDeathcryx(World world) {
        super(world);
        this.setSize(1.0F, 1.2F);

        potionEffect = MobEffects.SLOWNESS;
    }

    @Override
    public float getEyeHeight() {
        return 0.85F;
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(160.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.DEATHCRYX;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.DEATHCRYX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.DEATHCRYX_HURT;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        float damage = (float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();

        if (this.isPotionActive(MobEffects.INSTANT_DAMAGE)) {
            damage += 3 << this.getActivePotionEffect(MobEffects.INSTANT_DAMAGE).getAmplifier();
        }

        if (this.isPotionActive(MobEffects.WEAKNESS)) {
            damage -= 2 << this.getActivePotionEffect(MobEffects.WEAKNESS).getAmplifier();
        }

        int knockback = 0;
        if (entity instanceof EntityLivingBase) {
            damage += EnchantmentHelper.getEfficiencyModifier((EntityLivingBase) entity);
            knockback += EnchantmentHelper.getKnockbackModifier((EntityLivingBase) entity);
            ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(potionEffect, 16 * 20, 2));
        }

        boolean attacked = entity.attackEntityFrom(DamageSource.causeMobDamage(this), damage);
        if (attacked) {
            if (knockback > 0) {
                entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * knockback * 0.5F,
                        0.1D, MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * knockback * 0.5F);
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }

            int fire = EnchantmentHelper.getFireAspectModifier(this);
            if (fire > 0) {
                entity.setFire(fire * 4);
            }
        }

        return attacked;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return DRPGLootTables.ENTITIES_DEATHCRYX;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }


}