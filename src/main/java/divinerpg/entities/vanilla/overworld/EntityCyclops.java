package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityPeacefulUntilAttacked;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

import java.util.Random;

public class EntityCyclops extends EntityPeacefulUntilAttacked {


    public EntityCyclops(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        experienceValue = 40;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 3.5F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.func_234295_eP_().createMutableAttribute(Attributes.MAX_HEALTH, EntityStats.cyclopsHealth).createMutableAttribute(Attributes.ATTACK_DAMAGE, EntityStats.cyclopsDamage).createMutableAttribute(Attributes.MOVEMENT_SPEED, EntityStats.cyclopsSpeed).createMutableAttribute(Attributes.FOLLOW_RANGE, EntityStats.cyclopsFollowRange);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CYCLOPS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CYCLOPS_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CYCLOPS_HURT;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableRegistry.ENTITIES_CYCLOPS;
    }

    public static boolean canMonsterSpawnInLight(EntityType<? extends MonsterEntity> type, IServerWorld world, SpawnReason reason, BlockPos blockpos, Random rand) {
        if (world.getLightFor(LightType.SKY, blockpos) > rand.nextInt(32)) {
            return false;
        } else {
            int i = world.getLight(blockpos);

            if (world.getWorld().isThundering()) {
                int j = world.getSkylightSubtracted();
                world.getLightManager().onBlockEmissionIncrease(blockpos, 10);
                i = world.getLight(blockpos);
                world.getLightManager().onBlockEmissionIncrease(blockpos, j);
            }

            return i <= rand.nextInt(8);
        }
    }

    public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
        return world.getDimensionKey() == World.OVERWORLD && getPosition().getY() > world.getSeaLevel();
    }
}