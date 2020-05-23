package divinerpg.objects.entities.entity.arcana.death;

import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
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

public abstract class EntityDeathBase extends EntityDivineRPGMob {
    private final Potion potionEffect;

    private EntityDeathBase(World w) {
        this(w, MobEffects.SLOWNESS);
    }

    protected EntityDeathBase(World world, Potion potionEffect) {
        super(world);
        this.setSize(1.0F, 1.2F);
        this.potionEffect = potionEffect;
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
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DEATHCRYX;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DEATHCRYX_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DEATHCRYX_HURT;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        float damage = (float) getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();

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
        return LootTableRegistry.ENTITIES_DEATHCRYX;
    }

    @Override
    public boolean getCanSpawnHere() {
        return this.posY < 40.0D && super.getCanSpawnHere();
    }
}
