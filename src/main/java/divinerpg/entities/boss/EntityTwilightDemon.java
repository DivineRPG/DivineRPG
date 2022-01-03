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

public class EntityTwilightDemon extends EntityDivineBoss {

    int shooting;

    public EntityTwilightDemon(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.twilightDemonHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.twilightDemonDamage)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.twilightDemonSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.twilightDemonFollowRange);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 3.5F;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new LookAtGoal(this, PlayerEntity.class, 40.0F, 50));
    }

    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    public void tick() {
        super.tick();
            if (!this.level.isClientSide) {
                if (this.tickCount % 160 == 0)
                    this.shooting = 100;
                this.setTarget(this.level.getNearestPlayer(this, 40.0D));
                if (this.getTarget() != null && this.shooting > 0) {
                    if (canAttack(getTarget())) {
                    double tx = this.getTarget().getX() - this.getX();
                    double ty = this.getTarget().getBoundingBox().minY - this.getY() - 2;
                    double tz = this.getTarget().getZ() - this.getZ();
                    double angle = Math.atan(-(tx) / (tz));
                    EntityTwilightDemonShot projectile = new EntityTwilightDemonShot(EntityRegistry.TWILIGHT_DEMON_SHOT, this, this.level, this.random.nextInt(50) == 0 ?
                            BulletType.TWILIGHT_DEMON_RED_SHOT : BulletType.TWILIGHT_DEMON_BLACK_SHOT);
                    double d0 = getTarget().getX() - this.getX();
                    double d1 = getTarget().getY(0.3333333333333333D) - projectile.getY();
                    double d2 = getTarget().getZ() - this.getZ();
                    double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
                    projectile.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
                    this.level.addFreshEntity(projectile);

                    EntityTwilightDemonShot projectile2 = new EntityTwilightDemonShot(EntityRegistry.TWILIGHT_DEMON_SHOT, this, this.level, this.random.nextInt(50) == 0 ?
                            BulletType.TWILIGHT_DEMON_RED_SHOT : BulletType.TWILIGHT_DEMON_BLACK_SHOT);
                    projectile2.shoot(d0, d1 + d3 * (double) 0.2F, d2, 1.6F, (float) (14 - this.level.getDifficulty().getId() * 4));
                    this.level.addFreshEntity(projectile2);
                }
                if (this.shooting > 0) {
                    this.shooting--;
                }
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.INSECT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.INSECT;
    }

    @Override
    public Color getBarColor() {
        return Color.RED;
    }
}
