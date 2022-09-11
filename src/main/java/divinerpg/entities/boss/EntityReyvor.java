package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.BossInfo.*;
import net.minecraft.world.*;

public class EntityReyvor extends EntityDivineBoss implements IRangedAttackMob {


    public EntityReyvor(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.0F;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(6, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 0, true, false, null));
        this.targetSelector.addGoal(7, new RangedAttackGoal(this, 0.25, 40, 64));
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
        if (getTarget() != null && this.isAlive()) {
            EntityDivineArrow projectile = new EntityDivineArrow(EntityRegistry.ARROW_SHOT, level, ArrowType.REYVOR_ARROW, this, target, 1.6F, 12.0F);
            double d0 = target.getX() - this.getX();
            double d1 = target.getY(0.3333333333333333D) - projectile.getY();
            double d2 = target.getZ() - this.getZ();
            double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
            this.level.addFreshEntity(projectile);
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.REYVOR;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.REYVOR_HURT;
    }

    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.reyvorHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.reyvorDamage)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.reyvorSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.reyvorFollowRange);
    }
}
