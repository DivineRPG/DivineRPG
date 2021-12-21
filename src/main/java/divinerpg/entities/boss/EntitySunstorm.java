package divinerpg.entities.boss;

import divinerpg.entities.ai.*;
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

public class EntitySunstorm extends EntityDivineBoss implements IRangedAttackMob {

    public EntitySunstorm(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 1000;
    }

    @Override
    public void performRangedAttack(LivingEntity target, float distanceFactor) {
            if(distanceTo(target) < 3){
                target.setSecondsOnFire(3);
            }
            EntityTwilightMageShot projectile = new EntityTwilightMageShot(EntityRegistry.MAGE_SHOT, this, level, BulletType.SUNSTORM);
            double d0 = target.getX() - this.getX();
            double d1 = target.getY(0.3333333333333333D) - projectile.getY();
            double d2 = target.getZ() - this.getZ();
            double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
            projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
            this.level.addFreshEntity(projectile);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(0, new AISunstormAttack(this, 0.27F, 50, 10));
        this.targetSelector.addGoal(1, new MeleeAttackGoal(this, 1, true));
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 0, true, false, null));
    }

    @Override
    public CreatureAttribute getMobType() {
        return CreatureAttribute.UNDEFINED;
    }

    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }

    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SPARKLER;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.FIRE_EXTINGUISH;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.FIRE_EXTINGUISH;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 1000).add(Attributes.ATTACK_DAMAGE, 8)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.vamacheronSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.vamacheronFollowRange);
    }
}
