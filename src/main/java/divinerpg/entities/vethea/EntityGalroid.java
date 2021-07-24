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

public class EntityGalroid extends EntityVetheaMob {

    private int protectionTimer;

    public EntityGalroid(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
		this.protectionTimer = 200;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.5F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.galroidHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.galroidDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.galroidSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.galroidFollowRange);
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

        if (this.getProtectionTimer() <= 0 && !this.isInvulnerable()) {
            this.setProtectionTimer(200);
            this.setInvulnerable(true);
        }
        else if (this.isInvulnerable() && this.getProtectionTimer() <= 0) {
            this.setProtectionTimer(200);
            this.setInvulnerable(false);
        }
        this.setProtectionTimer(this.getProtectionTimer()-1);
    }

    private int getProtectionTimer() {
        return this.protectionTimer;
    }

    private void setProtectionTimer(int value) {
        this.protectionTimer = value;
    }

    @Override
    public int getSpawnLayer() {
        return 3;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GALROID;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GALROID_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GALROID_HURT;
    }
}