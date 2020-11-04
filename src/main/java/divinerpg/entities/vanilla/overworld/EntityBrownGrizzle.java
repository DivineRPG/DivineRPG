package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class EntityBrownGrizzle extends EntityDivineTameable {
    public <T extends Entity> EntityBrownGrizzle(EntityType<T> type, World worldIn) {
        super((EntityType<? extends TameableEntity>) type, worldIn);
        setHealth(getMaxHealth());
    }
    protected EntityBrownGrizzle(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        setTamedBy(player);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.2F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.grizzleHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.grizzleDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.grizzleSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.grizzleFollowRange);
    }
    public ActionResultType func_230254_b_(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        Item item = itemstack.getItem();
        if (this.isTamed()) {
            if (item.getFood().isMeat()) {
                if (!player.abilities.isCreativeMode) {
                    itemstack.shrink(1);
                    this.heal(item.getFood().getHealing());
                }
                if (this.rand.nextInt(3) == 0 && !net.minecraftforge.event.ForgeEventFactory.onAnimalTame(this, player)) {
                    this.setTamedBy(player);
                    this.navigator.clearPath();
                    this.setAttackTarget((LivingEntity)null);
                    this.world.setEntityState(this, (byte)7);
                } else {
                    this.world.setEntityState(this, (byte)6);
                }
            } else {
                setTamedBy(player);
                this.playTameEffect(true);
            }
        }
        return super.func_230254_b_(player, hand);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GRIZZLE;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GRIZZLE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GRIZZLE_HURT;
    }



    class MeleeAttackGoal extends net.minecraft.entity.ai.goal.MeleeAttackGoal {
        public MeleeAttackGoal() {
            super(EntityBrownGrizzle.this, 1.25D, true);
        }

        protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
            double d0 = this.getAttackReachSqr(enemy);
            if (distToEnemySqr <= d0 && this.func_234040_h_()) {
                this.func_234039_g_();
                this.attacker.attackEntityAsMob(enemy);
            } else {
                this.func_234039_g_();

            }
        }
        public void resetTask() {
            super.resetTask();
        }

        protected double getAttackReachSqr(LivingEntity attackTarget) {
            return (double)(4.0F + attackTarget.getWidth());
        }
    }
    class HurtByTargetGoal extends net.minecraft.entity.ai.goal.HurtByTargetGoal {
        public HurtByTargetGoal() {
            super(EntityBrownGrizzle.this);
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            super.startExecuting();
            if (EntityBrownGrizzle.this.isChild()) {
                this.alertOthers();
                this.resetTask();
            }

        }

        protected void setAttackTarget(MobEntity mobIn, LivingEntity targetIn) {
            if (mobIn instanceof EntityBrownGrizzle && !mobIn.isChild()) {
                super.setAttackTarget(mobIn, targetIn);
            }

        }
    }
}
