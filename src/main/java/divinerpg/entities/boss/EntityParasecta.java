package divinerpg.entities.boss;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.BossInfo.*;
import net.minecraft.world.*;

public class EntityParasecta extends EntityDivineBoss {

    private BlockPos currentFlightTarget;

    public EntityParasecta(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.7F;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.parasectaHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.parasectaDamage)
                .add(Attributes.MOVEMENT_SPEED, EntityStats.parasectaSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.parasectaFollowRange);
    }
    @Override
    public Color getBarColor() {
        return Color.YELLOW;
    }

    @Override
    protected float getSoundVolume() {
        return 0.1F;
    }

    @Override
    protected float getVoicePitch() {
        return super.getVoicePitch() * 0.95F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return this.random.nextInt(4) != 0 ? null : SoundRegistry.PARASECTA;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource s) {
        return SoundRegistry.PARASECTA_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.PARASECTA_HURT;
    }

    @Override
    public void tick() {
        super.tick();
        this.setDeltaMovement(getDeltaMovement().x, getDeltaMovement().y*0.6000000238418579D, getDeltaMovement().z);
    }

    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();

        if (this.getTarget() != null) {
            int x = (int) this.getTarget().getX();
            int y = (int) this.getTarget().getY();
            int z = (int) this.getTarget().getZ();
            this.currentFlightTarget = new BlockPos(x, y, z);
        }

        setDeltaMovement(getDeltaMovement().x, 0, getDeltaMovement().z);

        if (this.currentFlightTarget != null) {
            double x = this.currentFlightTarget.getX() - this.getX();
            double y = this.currentFlightTarget.getY() - this.getY();
            double z = this.currentFlightTarget.getZ() - this.getZ();

            if (Math.signum(x) != 0 || Math.signum(y) != 0 || Math.signum(z) != 0) {
                setDeltaMovement(getDeltaMovement().x + (Math.signum(x) * 0.5D - this.getDeltaMovement().x) * 0.10000000149011612D, getDeltaMovement().y + (Math.signum(y) * 1.699999988079071D - this.getDeltaMovement().y) * 0.10000000149011612D, getDeltaMovement().z + (Math.signum(z) * 0.5D - this.getDeltaMovement().z) * 0.10000000149011612D);
                float var7 = (float) (Math.atan2(this.getDeltaMovement().z, this.getDeltaMovement().x) * 180.0D / Math.PI) - 90.0F;
                float var8 = MathHelper.wrapDegrees(var7 - this.xRot);
                this.moveDist = 0.5F;
                this.xRot += var8;
            }
        }
    }

    public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
        return false;
    }

    protected void checkFallDamage(double p_184231_1_, boolean p_184231_3_, BlockState p_184231_4_, BlockPos p_184231_5_) {
    }

}