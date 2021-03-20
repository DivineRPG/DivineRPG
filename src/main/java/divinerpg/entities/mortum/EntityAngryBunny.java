package divinerpg.entities.mortum;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.*;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityAngryBunny extends EntityDivineMob {


    public EntityAngryBunny(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        xpReward=40;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.4F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.angryBunnyHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.angryBunnyDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.angryBunnySpeed).add(Attributes.FOLLOW_RANGE, EntityStats.angryBunnyFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.dimension() == KeyRegistry.MORTUM_WORLD;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        return entity.hurt(DamageSource.mobAttack(this), 12);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HISS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GROWL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GROWL_HURT;
    }

}