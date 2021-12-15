package divinerpg.entities.base;

import divinerpg.entities.projectile.*;
import divinerpg.enums.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.player.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

import java.util.*;

public class EntityMageBase extends EntityDivineMob {
    private final BulletType bullet;

    public EntityMageBase(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
        this.bullet = BulletType.MAGE_SHOT;
    }
    public EntityMageBase(EntityType<? extends MobEntity> type, World worldIn, BulletType bullet) {
        super(type, worldIn);
        this.bullet = bullet;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 2F;
    }
    public static AttributeModifierMap.MutableAttribute attributes() {
        return MonsterEntity.createMonsterAttributes().add(Attributes.MAX_HEALTH, EntityStats.behemothHealth).add(Attributes.ATTACK_DAMAGE, EntityStats.behemothDamage).add(Attributes.MOVEMENT_SPEED, EntityStats.behemothSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.behemothFollowRange);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, 0, true, false, null));
    }

    @Override
    public void tick() {
        super.tick();
        if (this.tickCount % 20 == 0) {
            setTarget(this.level.getNearestPlayer(this, 16D));
            if (this.getTarget() != null && !this.level.isClientSide) {
                double tx = this.getTarget().getX() - this.getX();
                double ty = this.getTarget().getBoundingBox().minY - this.getY();
                double tz = this.getTarget().getZ() - this.getZ();
                EntityTwilightMageShot shot = new EntityTwilightMageShot(EntityRegistry.MAGE_SHOT, this, level, bullet);
                shot.shoot(tx, ty, tz, 1.6f, 0);
                this.level.addFreshEntity(shot);
                level.playSound(null, this.getTarget().getX(), this.getTarget().getY(),
                        this.getTarget().getZ(), SoundRegistry.MAGE_FIRE, SoundCategory.HOSTILE, 1.0F, 1.0F);
            }
        }
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.INSECT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.INSECT;
    }

    public static boolean canSpawnOn(EntityType<? extends MobEntity> typeIn, IWorld worldIn, SpawnReason reason, BlockPos pos, Random randomIn) {
        return !worldIn.getBlockState(pos.below()).is(Blocks.BEDROCK);
    }
    @Override
    public float getWalkTargetValue(BlockPos pos, IWorldReader world) {
        return 0.0F;
    }
}