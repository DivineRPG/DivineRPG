package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.*;
import net.minecraftforge.common.Tags.Biomes;

public class EntityCaveclops extends EntityDivineMonster implements RangedAttackMob {
    public EntityCaveclops(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 3.5F;
    }
    public boolean canSpawn(LevelAccessor worldIn, MobSpawnType spawnReasonIn) {
        return getY() < 20 && level().dimension() == Level.OVERWORLD;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    protected void registerGoals() {
    	super.registerGoals();
        goalSelector.addGoal(0, new RangedAttackGoal(this, 0.27F, 30, 10));
        goalSelector.addGoal(0, new FleeSunGoal(this, 0.27D));
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CYCLOPS.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CYCLOPS_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CYCLOPS_HURT.get();
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (isAlive() && getTarget() != null && !level().isClientSide) {
            ThrowableProjectile projectile = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), this, level(), BulletType.CAVE_ROCK);
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * .2, d2, 1.6F, 0.8F);
            level().addFreshEntity(projectile);
        }
    }

    public static boolean caveClopsSpawnRule(EntityType<? extends Monster> typeIn, ServerLevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
        return Monster.checkMonsterSpawnRules(typeIn, worldIn, reason, pos, randomIn) && (pos.getY() < 32 || (worldIn.getBiome(pos).is(Biomes.IS_LUSH) && pos.getY() < 60));
    }
}