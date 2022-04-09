package divinerpg.entities.vethea;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.projectile.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityZoragon extends EntityDivineFlyingMob {
    private static final int spawnLayer = 4;

    public EntityZoragon(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
    }
    
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.0F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.zoragonHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.zoragonDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.zoragonSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.zoragonFollowRange).add(Attributes.FLYING_SPEED, EntityStats.zoragonSpeed);
    }
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 20.0F));
    }
    
    @Override
    public boolean checkSpawnRules(IWorld world, SpawnReason spawnReason) {
        return this.getY() < 48.0D * spawnLayer && this.getY() > 48.0D * (spawnLayer - 1) && super.checkSpawnRules(world, spawnReason);
    }


    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
        super.performRangedAttack(entity, range);
        ProjectileEntity projectile = new EntityZoragonBomb(EntityRegistry.ZORAGON_BOMB, level);
        double d0 = getTarget().getX() - this.getX();
        double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
        double d2 = getTarget().getZ() - this.getZ();
        double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
        projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
        this.level.addFreshEntity(projectile);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ZORAGON;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ZORAGON_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ZORAGON_HURT;
    }

    @Override
    protected float getSoundVolume() {
        return 2.0F;
    }
}