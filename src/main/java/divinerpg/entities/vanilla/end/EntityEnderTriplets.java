package divinerpg.entities.vanilla.end;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.registries.LootTableRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.world.*;

public class EntityEnderTriplets extends EntityDivineFlyingMob {
    public EntityEnderTriplets(EntityType<? extends FlyingEntity> type, World worldIn) {
        super(type, worldIn);
        this.xpReward = 5;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.enderTripletsHealth).add(Attributes.MOVEMENT_SPEED, EntityStats.enderTripletsSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.enderTripletsFollowRange);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.0F;
    }@Override
    protected float getSoundVolume() {
        return 10.0F;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.GHAST_SCREAM;
    }
    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return level.dimension() == World.END;
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.GHAST_DEATH;
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return LootTableRegistry.ENTITIES_ENDER_TRIPLETS;
    }
    //TODO - Ender triplets fireball attack
//    @Nullable
//    @Override
//    protected AIDivineFireballAttack createShootAI() {
//        return new AIDivineFireballAttack(this,
//                (world1, parent, x, y, z, fireballStrength) -> new EntityEnderTripletsFireball(world, parent, x, y, z));
//    }
}
