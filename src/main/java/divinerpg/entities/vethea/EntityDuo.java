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

public class EntityDuo extends EntityVetheaMob {

    private static int ability;
    private final int SLOW = 0, FAST = 1;
    private int abilityCoolDown;
    float moveSpeed = 0.25F;

    public EntityDuo(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
    }
    
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.8F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.duoHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.duoDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.duoSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.duoFollowRange);
    }
    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return reason == SpawnReason.SPAWNER || worldIn.getBlockState(pos.below()).isValidSpawn(worldIn, pos.below(), typeIn);
    }

    @Override
    protected void registerGoals() {
    	if (ability == SLOW && this.abilityCoolDown == 0) {
            ability = FAST;
            this.abilityCoolDown = 350;
            this.setSpeed(moveSpeed * 3);
        }

        this.abilityCoolDown--;

        if (ability == FAST && this.abilityCoolDown == 0) {
            ability = SLOW;
            this.abilityCoolDown = 350;
            this.setSpeed(moveSpeed);
        }
    	super.registerGoals();
        addAttackingAI();
    }

    @Override
    public int getSpawnLayer() {
        return 1;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.DUO;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.DUO_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.DUO_HURT;
    }
}