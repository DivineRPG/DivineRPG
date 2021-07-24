package divinerpg.entities.vethea;

import java.util.Random;

import divinerpg.entities.base.EntityVetheaMob;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class EntityDreamwrecker extends EntityVetheaMob {

    public EntityDreamwrecker(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
    }
    
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 4.0F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.dreamwreckerHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.dreamwreckerDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.dreamwreckerSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.dreamwreckerFollowRange);
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
    public void tick() {
        super.tick();
        PlayerEntity player = this.level.getNearestPlayer(this, 64.0D);

        if(player != null && !player.isCreative() && player.distanceTo(this) < 20) {
            this.setTarget(player);
        }

        Entity attackTarget = this.getTarget();
        if(attackTarget != null && attackTarget instanceof PlayerEntity && !((PlayerEntity)attackTarget).isCreative() && attackTarget.isAlive() && this.canSee(attackTarget)) {
            attackTarget.setDeltaMovement(getDeltaMovement().x + Math.signum(this.getX() - attackTarget.getX()) * 0.029, getDeltaMovement().y, getDeltaMovement().z + Math.signum(this.getZ() - attackTarget.getZ()) * 0.029);
        }
        else {
            this.setTarget(null);
        }
    }

    @Override
    public int getSpawnLayer() {
        return 1;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DREAMWRECKER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DREAMWRECKER_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DREAMWRECKER_HURT;
    }
}