package divinerpg.entities.vethea;

import java.util.Random;

import divinerpg.entities.base.EntityVetheaMob;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;

public class EntityVermenous extends EntityVetheaMob {

    public EntityVermenous(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2.5F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.vermenousHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.vermenousDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.vermenousSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.vermenousFollowRange);
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
        PlayerEntity var1 = this.level.getNearestPlayer(this, 64.0D);

        if (var1 == null || var1.isCreative())
            return;
        else {
            Vector3d var3 = var1.getLookAngle().normalize();
            Vector3d var4 = new Vector3d(this.getX() - var1.getX(), this.getBoundingBox().minY + this.getEyeHeight() / 2.0F - (var1.getY() + var1.getEyeHeight()), this.getZ() - var1.getZ());
            double var5 = var4.length();
            var4 = var4.normalize();
            double var7 = var3.dot(var4);
            if( var7 > 1.0D - 0.025D / var5 && var1.canSee(this)) {
                var1.hurt(DamageSource.mobAttack(this), 4);
            }
        }
    }

    @Override
    public int getSpawnLayer() {
        return 3;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.VERMENOUS;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.VERMENOUS_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.VERMENOUS_HURT;
    }
}