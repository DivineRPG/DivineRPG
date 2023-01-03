package divinerpg.entities.apalachia;


import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.registries.*;
import net.minecraft.sounds.*;
import net.minecraft.util.*;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.*;
import net.minecraft.world.entity.monster.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.*;

public class EntityEnchantedArcher extends EntityDivineMonster implements RangedAttackMob {


    public EntityEnchantedArcher(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 2.9F;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    protected void registerGoals() {
        super.registerGoals();
        goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, 0, true, false, null));
        goalSelector.addGoal(0, new RangedAttackGoal(this, 1, 15, 60, 15));
    }

    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (isAlive() && getTarget() != null) {
            EntityDivineArrow projectile = new EntityDivineArrow(EntityRegistry.ARROW_SHOT.get(), level, ArrowType.ENCHANTED_ARCHER_ARROW, this, target, 1.6F, 12.0F);
            double d0 = target.getX() - this.getX();
            double d1 = target.getY(0.3333333333333333D) - projectile.getY();
            double d2 = target.getZ() - this.getZ();
            double d3 = Mth.sqrt((float) (d0 * d0 + d2 * d2));
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
            this.level.addFreshEntity(projectile);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ARCHER.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.HIGH_HIT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.HIGH_HIT.get();
    }

}
