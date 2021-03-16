package divinerpg.entities.eden;

import divinerpg.entities.base.EntityPeacefulUntilAttacked;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityEdenTomo extends EntityPeacefulUntilAttacked {

    public EntityEdenTomo(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        xpReward = 40;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.6F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.edenTomoHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.edenTomoDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.edenTomoSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.edenTomoFollowRange);
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.dimension() == KeyRegistry.EDEN_WORLD;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CROAK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GROWL_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GROWL_HURT;
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return LootTableRegistry.ENTITIES_EDEN_TOMO;
    }
}
