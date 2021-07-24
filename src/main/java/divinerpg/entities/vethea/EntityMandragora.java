package divinerpg.entities.vethea;

import java.util.Random;

import divinerpg.entities.base.EntityVetheaMob;
import divinerpg.entities.projectile.EntityMandragoraProjectile;
import divinerpg.registries.*;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;

public class EntityMandragora extends EntityVetheaMob {

    public EntityMandragora(EntityType<? extends MobEntity> type, World worldIn) {
		super(type, worldIn);
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.8F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.mandragoraHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.mandragoraDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.mandragoraSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.mandragoraFollowRange);
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
    public int getSpawnLayer() {
        return 2;
    }

    @Override
    protected float getSoundVolume() {
        return 0.7F;
    }
    
    @Override
    public void tick() {
        super.tick();
        PlayerEntity target = this.level.getNearestPlayer(this, 16);
        if(!level.isClientSide && target != null && this.tickCount%20 == 0) attackEntity(target);
    }

    public void attackEntity(LivingEntity e) {
  //      double tx = e.getX() - this.getX();
    //    double ty = e.getBoundingBox().minY - this.getY();
      //  double tz = e.getZ() - this.getZ();
        EntityMandragoraProjectile p = new EntityMandragoraProjectile(EntityRegistry.MANDRAGORA_PROJECTILE, this, this.level);
//        p.setThrowableHeading(tx, ty, tz, 1.3f, 15);
        this.playSound(SoundRegistry.MANDRAGORA, 2.0F, 2.0F);
        if(!level.isClientSide)this.level.addFreshEntity(p);
    }   
    
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.MANDRAGORA;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.MANDRAGORA;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.MANDRAGORA;
    }
}