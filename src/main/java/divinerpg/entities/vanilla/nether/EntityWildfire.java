package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.projectile.EntityDivineArrow;
import divinerpg.enums.ArrowType;
import divinerpg.registries.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.level.Level;

public class EntityWildfire extends EntityDivineMonster implements RangedAttackMob {
    public EntityWildfire(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.75F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    protected void registerGoals() {
    	super.registerGoals();
        goalSelector.addGoal(0, new RangedAttackGoal(this, this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 3, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
    }
    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (isAlive() && getTarget() != null && !level.isClientSide) {
            EntityDivineArrow projectile = new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), level, ArrowType.WILDFIRE_ARROW, this, target, 1.3F, 1.2F);
            double d0 = getTarget().getX() - this.getX();
            double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
            double d2 = getTarget().getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, 1.2F);
            this.level.addFreshEntity(projectile);
        }
    }
    @Override
    public boolean fireImmune() {
    	return true;
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.WILDFIRE.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.WILDFIRE_HURT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.WILDFIRE_HURT.get();
    }
}
