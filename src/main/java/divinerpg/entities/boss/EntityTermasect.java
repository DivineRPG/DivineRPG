package divinerpg.entities.boss;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.entities.projectile.EntityWildwoodLog;
import divinerpg.entities.wildwood.EntityTermid;
import divinerpg.registries.EntityRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.*;
import net.minecraft.world.server.ServerBossInfo;

import java.util.*;

public class EntityTermasect extends EntityDivineFlyingMob implements IRangedAttackMob {
    private ServerBossInfo bossInfo = (ServerBossInfo) (new ServerBossInfo(this.getDisplayName(), BossInfo.Color.BLUE,
            BossInfo.Overlay.PROGRESS));
    public EntityTermasect(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 1500;
    }

    @Override
    protected void registerGoals() {
        goalSelector.addGoal(2, new NearestAttackableTargetGoal<PlayerEntity>(this, PlayerEntity.class, false));
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 40, 20.0F));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 64.0F));
        goalSelector.addGoal(1, new FlyToPlayer(this));
        addAttackingAI();
    }

    @Override
    public CreatureAttribute getMobType() {
        return CreatureAttribute.UNDEFINED;
    }
    @Override
    public void performRangedAttack(LivingEntity entity, float range) {
        if(this.isAlive()) {
            if (getTarget() != null) {
                EntityWildwoodLog shot = new EntityWildwoodLog(EntityRegistry.WILDWOOD_LOG, this, this.level);
                double d0 = getTarget().getX() - this.getX();
                double d1 = getTarget().getY(0.3333333333333333D) - shot.getY();
                double d2 = getTarget().getZ() - this.getZ();
                double d3 = (double) MathHelper.sqrt(d0 * d0 + d2 * d2);
                shot.shoot(d0, d1 + d3 * (double) 0.2F, d2, 2.3F, (float) (14 - this.level.getDifficulty().getId() * 4));
                if (!this.level.isClientSide)
                    this.level.addFreshEntity(shot);
            }
        }
    }



    @Override
    public boolean removeWhenFarAway(double dist) {
        return false;
    }

    public BossInfo.Color getBarColor() {
        return BossInfo.Color.BLUE;
    }

    @Override
    public void startSeenByPlayer(ServerPlayerEntity player) {
        super.startSeenByPlayer(player);
        bossInfo.setColor(getBarColor());
        this.bossInfo.addPlayer(player);
    }

    @Override
    public void stopSeenByPlayer(ServerPlayerEntity player) {
        super.stopSeenByPlayer(player);
        this.bossInfo.removePlayer(player);
    }

    @Override
    public void tick() {
        super.tick();
        this.bossInfo.setPercent(this.getHealth() / this.getMaxHealth());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.WOOD_STEP;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.WOOD_HIT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.WOOD_BREAK;
    }

    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, 1050).add(Attributes.ATTACK_DAMAGE, 0)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.skythernCoriSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.skythernCoriFollowRange).add(Attributes.FLYING_SPEED, EntityStats.skythernCoriSpeed);
    }
    @Override
    public void customServerAiStep() {
        super.customServerAiStep();
        if (this.isAlive() && this.random.nextInt(1000) < this.ambientSoundTime++)
        {
            this.playAmbientSound();
            if(!this.level.isClientSide) {
                EntityTermid termid = new EntityTermid(EntityRegistry.TERMID, level);
                termid.moveTo(this.getX() + random.nextInt(8), this.getY(), this.getZ() + random.nextInt(8), this.xRot, this.yRot);
                if (random.nextInt(10) == 1) {
                    level.addFreshEntity(termid);
                }
            }
        }
    }


    static class FlyToPlayer extends Goal {
        private final EntityDivineFlyingMob parentEntity;

        public FlyToPlayer(EntityDivineFlyingMob ent) {
            this.parentEntity = ent;
            this.setFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        /**
         * Returns whether execution should begin. You can also read and cache any state necessary for execution in this
         * method as well.
         */
        public boolean canUse() {
            MovementController movementcontroller = this.parentEntity.getMoveControl();
            if (!movementcontroller.hasWanted()) {
                return true;
            } else {
                double d0 = movementcontroller.getWantedX() - this.parentEntity.getX();
                double d1 = movementcontroller.getWantedY() - this.parentEntity.getY();
                double d2 = movementcontroller.getWantedZ() - this.parentEntity.getZ();
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                return d3 < 1.0D || d3 > 3600.0D;
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean canContinueToUse() {
            return false;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void start() {
            Random random = this.parentEntity.getRandom();
            if (parentEntity.level.getNearestPlayer(parentEntity, 64) != null) {
                double d0 = random.nextInt(48) + parentEntity.level.getNearestPlayer(parentEntity, 64).getX();
                double d1 = random.nextInt(16) + parentEntity.level.getNearestPlayer(parentEntity, 64).getY();
                double d2 = random.nextInt(48) + parentEntity.level.getNearestPlayer(parentEntity, 64).getZ();
                this.parentEntity.getMoveControl().setWantedPosition(d0, d1, d2, 1.0D);
            } else {
                double d0 = this.parentEntity.getX() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
                double d1 = this.parentEntity.getY() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
                double d2 = this.parentEntity.getZ() + (double)((random.nextFloat() * 2.0F - 1.0F) * 16.0F);
                this.parentEntity.getMoveControl().setWantedPosition(d0, d1, d2, 1.0D);
            }
        }
    }
}
