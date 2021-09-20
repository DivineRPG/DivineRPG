package divinerpg.entities.ai;

import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.util.math.*;

public class AISunstormAttack extends Goal {
        /** The entity the AI instance has been applied to */
        private final MobEntity entityHost;
        /** The entity (as a RangedAttackMob) the AI instance has been applied to. */
        private final IRangedAttackMob rangedAttackEntityHost;
        private LivingEntity attackTarget;
        /**
         * A decrementing tick that spawns a ranged attack once this value reaches 0. It is then set back to the
         * maxRangedAttackTime.
         */
        private int rangedAttackTime;
        private final double entityMoveSpeed;
        private int seeTime;
        private final int attackIntervalMin;
        /** The maximum time the AI has to wait before peforming another ranged attack. */
        private final int maxRangedAttackTime;
        private final float attackRadius;
        private final float maxAttackDistance;

    public AISunstormAttack(IRangedAttackMob attacker, double movespeed, int maxAttackTime, float maxAttackDistanceIn)
        {
            this(attacker, movespeed, maxAttackTime, maxAttackTime, maxAttackDistanceIn);
        }

    public AISunstormAttack(IRangedAttackMob attacker, double movespeed, int p_i1650_4_, int maxAttackTime, float maxAttackDistanceIn)
        {
            this.rangedAttackTime = -1;

            if (!(attacker instanceof MobEntity))
            {
                throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
            }
            else
            {
                this.rangedAttackEntityHost = attacker;
                this.entityHost = (MobEntity)attacker;
                this.entityMoveSpeed = movespeed;
                this.attackIntervalMin = p_i1650_4_;
                this.maxRangedAttackTime = maxAttackTime;
                this.attackRadius = maxAttackDistanceIn;
                this.maxAttackDistance = maxAttackDistanceIn * maxAttackDistanceIn;
            }
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            LivingEntity entitylivingbase = this.entityHost.getTarget();
            if(entitylivingbase == null) {
                return false;
            }

            double distance = this.entityHost.distanceToSqr(entitylivingbase.xo, entitylivingbase.getBoundingBox().minY, entitylivingbase.zo);
            if(distance < 4 || entitylivingbase == null) {
                return false;
            }
            else
            {
                this.attackTarget = entitylivingbase;
                return true;
            }
        }

    @Override
    public boolean canUse() {
        return this.shouldExecute() || !this.entityHost.getNavigation().isDone();
    }

    public boolean canContinueToUse()
        {
            return this.shouldExecute() || !this.entityHost.getNavigation().isDone();
        }

        public void stop()
        {
            this.attackTarget = null;
            this.seeTime = 0;
            this.rangedAttackTime = -1;
        }

        public void tick()
        {
            double d0 = this.entityHost.distanceToSqr(this.attackTarget.xo, this.attackTarget.getBoundingBox().minY, this.attackTarget.zo);
            boolean flag = this.entityHost.canSee(this.attackTarget);

            if (flag)
            {
                ++this.seeTime;
            }
            else
            {
                this.seeTime = 0;
            }

            if (d0 <= (double)this.maxAttackDistance && this.seeTime >= 20)
            {
                this.entityHost.getNavigation().stop();
            }
            else
            {
                this.entityHost.getNavigation().moveTo(this.attackTarget, this.entityMoveSpeed);
            }

            this.entityHost.getLookControl().setLookAt(this.attackTarget, 30.0F, 30.0F);

            if (--this.rangedAttackTime == 0)
            {
                if (!flag)
                {
                    return;
                }

                float f = MathHelper.sqrt(d0) / this.attackRadius;
                float lvt_5_1_ = MathHelper.clamp(f, 0.1F, 1.0F);
                this.rangedAttackEntityHost.performRangedAttack(this.attackTarget, lvt_5_1_);
                this.rangedAttackTime = MathHelper.floor(f * (float)(this.maxRangedAttackTime - this.attackIntervalMin) + (float)this.attackIntervalMin);
            }
            else if (this.rangedAttackTime < 0)
            {
                float f2 = MathHelper.sqrt(d0) / this.attackRadius;
                this.rangedAttackTime = MathHelper.floor(f2 * (float)(this.maxRangedAttackTime - this.attackIntervalMin) + (float)this.attackIntervalMin);
            }
        }
}
