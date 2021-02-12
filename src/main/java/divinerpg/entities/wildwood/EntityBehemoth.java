package divinerpg.entities.wildwood;

import divinerpg.entities.ai.EntityBehemothEatWood;
import divinerpg.entities.base.EntityDivineMob;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityBehemoth extends EntityDivineMob {


    public EntityBehemoth(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.7F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.behemothHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.behemothDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.behemothSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.behemothFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
//        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
        //TODO - spawn return
        return true;
    }

    @Override
    protected void registerGoals() {
        targetSelector.addGoal(2, new HurtByTargetGoal(this));
        goalSelector.addGoal(0, new SwimGoal(this));
        goalSelector.addGoal(1, new EntityBehemothEatWood(this));
        goalSelector.addGoal(2, new MeleeAttackGoal(this, 1, true));
        goalSelector.addGoal(7, new WaterAvoidingRandomWalkingGoal(this, getAttributeValue(Attributes.MOVEMENT_SPEED)));
        goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 8.0F));
    }


    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.ENDIKU;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.ENDIKU_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.ENDIKU_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_BEHEMOTH;
    }
}