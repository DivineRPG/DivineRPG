package divinerpg.entities.skythern;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.potion.*;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.*;

public class EntityMegalith extends EntityDivineMob {


    public EntityMegalith(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 3.6F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.megalithHealth).createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 1).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.megalithDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.27 * 0.9).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.megalithFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
//        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
        //TODO - spawn return
        return true;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public boolean attackEntityAsMob(Entity entity) {
        boolean attack = super.attackEntityAsMob(entity);
        if (attack) {
            if (entity instanceof LivingEntity) {
                ((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SLOWNESS, 100, 2, false, false));
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