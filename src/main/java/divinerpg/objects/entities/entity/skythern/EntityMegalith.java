package divinerpg.objects.entities.entity.skythern;

import divinerpg.objects.entities.entity.EntityDivineMob;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.SoundRegistry;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityMegalith extends EntityDivineMob {

    public EntityMegalith(World worldIn) {
        super(worldIn);
        this.setSize(1.2F, 4F);
    }

    @Override
    public float getEyeHeight() {
        return 3.6F;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();


        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.27 * 0.9);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        addAttackingAI();
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        boolean attack = super.attackEntityAsMob(entity);
        if (attack) {
            if (entity instanceof EntityLivingBase) {
                ((EntityLivingBase) entity)
                        .addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 100, 2, false, false));
            }
            entity.addVelocity(-MathHelper.sin(this.rotationYaw * (float) Math.PI / 180.0F) * 1.5f, 0.1D,
                    MathHelper.cos(this.rotationYaw * (float) Math.PI / 180.0F) * 1.5f);
        }
        return attack;
    }

    @Override
    public int getTotalArmorValue() {
        return 10;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.MEGALITH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.MEGALITH_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.MEGALITH_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_MEGALITH;
    }
}