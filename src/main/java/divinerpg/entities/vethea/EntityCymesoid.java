package divinerpg.entities.vethea;

import java.util.Random;

import divinerpg.entities.base.EntityVetheaMob;
import divinerpg.registries.SoundRegistry;
import divinerpg.util.EntityStats;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.*;

public class EntityCymesoid extends EntityVetheaMob {

    public EntityCymesoid(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }
    
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.7F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.cymesoidHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.cymesoidDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.cymesoidSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.cymesoidFollowRange);
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
        PlayerEntity player = this.level.getNearestPlayer(this, 64.0D);

        if (player == null || player.isCreative())
            return;
        else {
            Vector3d playerLook = player.getLookAngle().normalize();
            Vector3d positionQuotient = new Vector3d(this.getX() - player.getX(), this.getBoundingBox().minY + this.getEyeHeight() / 2.0F - (player.getY() + player.getEyeHeight()), this.getZ() - player.getZ());
            double distance = positionQuotient.length();
            positionQuotient = positionQuotient.normalize();
            double dotProduct = playerLook.dot(positionQuotient);
            if( dotProduct > 1.0D - 0.025D / distance && player.canSee(this)) {
                this.addEffect(new EffectInstance(Effects.INVISIBILITY, 200, 1));
            }
        }
    }

    @Override
    public int getSpawnLayer() {
        return 1;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CYMESOID;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CYMESOID_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CYMESOID_HURT;
    }
}