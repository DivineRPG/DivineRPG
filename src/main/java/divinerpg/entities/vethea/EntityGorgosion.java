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
import net.minecraft.world.Explosion.Mode;
import net.minecraft.world.*;

public class EntityGorgosion extends EntityVetheaMob {

	public EntityGorgosion(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.2F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.gorgosionHealth).add(Attributes.MOVEMENT_SPEED, EntityStats.gorgosionSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.gorgosionFollowRange);
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
		PlayerEntity closestPlayer = this.level.getNearestPlayer(this, 10);
		if(closestPlayer != null && !closestPlayer.isCreative() && this.random.nextInt(30) == 0) {
			this.setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y + 1, getDeltaMovement().z);
		}
	}
	
	@Override
    public boolean causeFallDamage(float distance, float damageMultiplier) {
		if(distance > 2) {
			this.level.explode(this, this.getX(), this.getY(), this.getZ(), 3, false, Mode.NONE);
			return false;
		}
		return super.causeFallDamage(distance, damageMultiplier);
    }

	@Override
	public int getSpawnLayer() {
		return 2;
	}

	@Override
	protected SoundEvent getAmbientSound() {
		return SoundRegistry.GORGOSION;
	}

	@Override
	protected SoundEvent getHurtSound(DamageSource source) {
		return SoundRegistry.GORGOSION_HURT;
	}

	@Override
	protected SoundEvent getDeathSound() {
		return SoundRegistry.GORGOSION_HURT;
	}
}