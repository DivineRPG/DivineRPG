package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.projectile.EntityDivineArrow;
import divinerpg.enums.ArrowType;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.level.*;

public class EntityAridWarrior extends EntityDivineMonster implements RangedAttackMob {

    public EntityAridWarrior(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.875F;
    }

    @Override
    public boolean isAggressive() {
        return true;
    }

    @Override
    protected void registerGoals() {
    	super.registerGoals();
        goalSelector.addGoal(0, new RangedAttackGoal(this, this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 5, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (isAlive() && getTarget() != null && !level().isClientSide) {
            EntityDivineArrow projectile = new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), level(), ArrowType.ARID_WARRIOR_ARROW, this, target, 1.6F, 0.8F);
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 0.8F);
            this.level().addFreshEntity(projectile);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ARID_WARRIOR.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ARID_WARRIOR_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ARID_WARRIOR_HURT.get();
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
        return 0.0F;
    }
}
