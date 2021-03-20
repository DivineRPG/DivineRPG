package divinerpg.entities.wildwood;

import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityVerek extends EntityDivineMob {

    public EntityVerek(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.8F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.verekHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.verekDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.verekSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.verekFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.dimension() == KeyRegistry.WILDWOOD_WORLD;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }

    @Override
    public int getArmorValue() {
        return 6;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.VEREK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.VEREK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.VEREK_HURT;
    }

}