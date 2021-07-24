package divinerpg.entities.vethea;

import java.util.Random;

import divinerpg.entities.base.EntityVetheaMob;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class EntityHelio extends EntityVetheaMob {

    public EntityHelio(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.8F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.helioHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.helioDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.helioSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.helioFollowRange);
    }
    
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public boolean canAttack(LivingEntity target) {
        if(super.canAttack(target)) {
            target.setDeltaMovement(getDeltaMovement().x + MathHelper.sin(this.xRot * (float)Math.PI / 180.0F) * 7.0F * 0.5F, getDeltaMovement().y + 0.4D, getDeltaMovement().z + MathHelper.cos(this.xRot * (float)Math.PI / 180.0F) * 7.0F * 0.5F);
            //this.motionX *= 0.6D;
            //this.motionZ *= 0.6D;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int getSpawnLayer() {
        return 4;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HELIO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.HELIO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.HELIO_HURT;
    }
}