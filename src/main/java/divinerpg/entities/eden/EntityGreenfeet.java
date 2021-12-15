package divinerpg.entities.eden;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityGreenfeet extends EntityDivineMob {

    public EntityGreenfeet(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.75F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.greenfeetHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.greenfeetDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.greenfeetSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.greenfeetFollowRange);
    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, IWorldReader reader) {
        return 0.0F;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public int getArmorValue() {
        return 10;
    }

    @Override
    public void tick() {
        if (this.level.isDay() && !this.level.isClientSide) {
            float lightLevel = this.getBrightness();
            if (lightLevel > 0.5F
                    && this.level.canSeeSky(new BlockPos(MathHelper.floor(this.getX()), MathHelper.floor(this.getY()),
                    MathHelper.floor(this.getZ())))
                    && this.random.nextFloat() * 30.0F < (lightLevel - 0.4F) * 2.0F) {
                this.setRemainingFireTicks(8);
            }
        }
        super.tick();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.NESRO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.NESRO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.NESRO_HURT;
    }

}
