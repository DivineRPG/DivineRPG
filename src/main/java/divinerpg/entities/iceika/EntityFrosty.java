package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityPeacefulUntilAttacked;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityFrosty extends EntityPeacefulUntilAttacked {


    public EntityFrosty(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.85F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.frostyHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.frostyDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.frostySpeed).add(Attributes.FOLLOW_RANGE, EntityStats.frostyFollowRange);
    }


    @Override
    public boolean doHurtTarget(Entity entity) {
        boolean attack = super.doHurtTarget(entity);
        if (attack && entity instanceof LivingEntity) {
            ((LivingEntity) entity).addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 100, 2, true, false));
            entity.setDeltaMovement(-MathHelper.sin(this.xRot * (float) Math.PI / 180.0F) * 2.5 * 0.5F, 0.1D,
                    MathHelper.cos(this.xRot * (float) Math.PI / 180.0F) * 2.5 * 0.5F);
        }
        return attack;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.FROSTY;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.FROSTY_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.FROSTY_HURT;
    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return true;
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, IWorldReader reader) {
        return 0.0F;
    }
}