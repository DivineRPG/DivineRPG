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

public class EntityTocaxin extends EntityVetheaMob {

    private int hurtTimer;

    public EntityTocaxin(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
		this.hurtTimer = 10;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 3.0F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.tocaxinHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.tocaxinDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.tocaxinSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.tocaxinFollowRange);
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
        LivingEntity var1 = this.getTarget();
        if(var1 != null) {
            if(this.distanceTo(var1) > 8 || this.hurtTimer != 0) {
                this.hurtTimer--;
            }
            else {
                this.hurtTimer = 10;
                var1.hurt(DamageSource.mobAttack(this), (int) (8 - this.distanceTo(var1)));
            }
        }
    }

    @Override
    public int getSpawnLayer() {
        return 3;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.TOCAXIN;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.TOCAXIN_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.TOCAXIN_HURT;
    }
}