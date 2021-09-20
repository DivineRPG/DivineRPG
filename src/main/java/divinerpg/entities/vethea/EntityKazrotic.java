package divinerpg.entities.vethea;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityKazrotic extends EntityVetheaMob implements IRangedAttackMob {
	
    public EntityKazrotic(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.8F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.kazroticHealth).add(Attributes.MOVEMENT_SPEED, EntityStats.kazroticSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.kazroticFollowRange);
    }
    
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn);
    }

    @Override
    protected void registerGoals() {
    	this.targetSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
        this.goalSelector.addGoal(7, new RangedAttackGoal(this, 0.25F, 15, 40.0F));
    	super.registerGoals();
    }

    @Override
    public int getSpawnLayer() {
    	return 3;
    }
    
    @Override
	public void performRangedAttack(LivingEntity entity, float par2) {
		double tx = entity.getX() - this.getX();
        double ty = entity.getBoundingBox().minY - this.getY();
        double tz = entity.getZ() - this.getZ();
        EntityKazroticShot shot = new EntityKazroticShot(EntityRegistry.KAZROTIC_SHOT, entity, this.level);
        shot.shoot(tx, ty, tz, 0.6F, 0.3F);
        level.playSound(lastHurtByPlayer, this.blockPosition(), SoundEvents.ARROW_SHOOT, SoundCategory.HOSTILE, 1F, 1F);
        level.addFreshEntity(shot);
	}

    @Override
    public boolean hurt(DamageSource par1, float par2) {
        if (par1.isExplosion())
            return false;
        return super.hurt(par1, par2);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.KAZROTIC;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.KAZROTIC_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.KAZROTIC_HURT;
    }

}