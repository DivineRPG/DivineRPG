package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityPeacefulUntilAttacked;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityCrab extends EntityPeacefulUntilAttacked {

    public EntityCrab(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        experienceValue=40;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.6F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.crabHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.crabDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.crabSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.crabFollowRange);
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CRAB;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CRAB_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CRAB_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_CRAB;
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return world.getDimensionKey() == World.OVERWORLD && super.canSpawn(worldIn, spawnReasonIn);
    }
}
