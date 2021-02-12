package divinerpg.entities.skythern;

import divinerpg.entities.base.EntityPeacefulUntilAttacked;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.*;

public class EntitySamek extends EntityPeacefulUntilAttacked {


    public EntitySamek(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        experienceValue=40;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.7F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.samekHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.samekDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.samekSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.samekFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
//        return world.getBiome(getPosition()).doesSnowGenerate(worldIn, getPosition());
        //TODO - spawn return
        return true;
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

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_SAMEK;
    }
}