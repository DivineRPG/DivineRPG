package divinerpg.entities.vethea;

import java.util.Random;

import divinerpg.entities.base.EntityVetheaMob;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class EntityFakeVhraak extends EntityVetheaMob {

    private int lifeTick = 20;

    public EntityFakeVhraak(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.8F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.vhraakHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.vhraakDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.vhraakSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.vhraakFollowRange);
    }
    
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        addAttackingAI();
    }


    @Override
    public void tick() {
        super.tick();

        this.lifeTick--;
        if(this.lifeTick <= 0) {
            this.kill();
        }
    }

    @Override
    public int getSpawnLayer() {
        return 0;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.VHRAAK;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.VHRAAK_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.VHRAAK_HURT;
    }
}