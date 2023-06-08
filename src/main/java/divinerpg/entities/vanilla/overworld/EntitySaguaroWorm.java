package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.entities.projectile.EntitySaguaroWormShot;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.navigation.*;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraftforge.common.Tags.Blocks;

public class EntitySaguaroWorm extends EntityDivineMonster implements RangedAttackMob {
    private static final EntityDataAccessor<Boolean> PROVOKED = SynchedEntityData.defineId(EntitySaguaroWorm.class, EntityDataSerializers.BOOLEAN);

    public EntitySaguaroWorm(EntityType<? extends EntitySaguaroWorm> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(4, new RangedAttackGoal(this, this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 3, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
    }

    public double getMyRidingOffset() {
        return (double) (2.5F);
    }

    protected PathNavigation createNavigation(Level worldIn) {
        return new WallClimberNavigation(this, worldIn);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(PROVOKED, Boolean.valueOf(false));
    }

    public boolean getProvoked() {
        return this.entityData.get(PROVOKED);
    }

    public void setProvoked(boolean provoked) {
        entityData.set(PROVOKED, provoked);
    }

    public void tick() {
        super.tick();
        if (!this.level().isClientSide && this.getHealth() > 0.0f) {
            Player player = this.level().getNearestPlayer(this, 10.0D);
            if (player != null && !player.isCreative() && !player.isSpectator() && this.hasLineOfSight(player)) {
                this.setTarget(player);
                this.setNoAi(false);
                this.setProvoked(true);
            } else {
                this.setTarget(null);
                this.setProvoked(false);
                this.setNoAi(true);
            }
        }
        if (!this.getProvoked()) {
            this.xRotO = 0;
        }
    }


    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setProvoked(tag.getBoolean("Provoked"));
    }

    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Provoked", this.getProvoked());
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.SAGUARO_WORM.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.SAGUARO_WORM.get();
    }


    public static boolean saguaroWormSpawnRule(EntityType<? extends Mob> typeIn, LevelAccessor worldIn, MobSpawnType reason, BlockPos pos, RandomSource randomIn) {
        return reason == MobSpawnType.SPAWNER || worldIn.getBlockState(pos.below()).is(Blocks.SAND);
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
        return 0.0F;
    }

    @Override
    public void performRangedAttack(LivingEntity e, float p_33318_) {
        if (isAlive() && getTarget() != null && !level().isClientSide && this.tickCount % 30 == 0 && this.getProvoked()) {
            double y = this.getBoundingBox().minY + 2.7D;
            double tx = e.getX() - getX();
            double ty = e.getBoundingBox().minY - y;
            double tz = e.getZ() - getZ();
            for (double h = -1.5; h < 1.5; h += 0.5) {
                for (double r = 0; r < 1.5 - Math.abs(h); r += 0.5) {
                    for (double theta = 0; theta < Math.PI * 2; theta += Math.PI / 2) {
                        EntitySaguaroWormShot shot = new EntitySaguaroWormShot(EntityRegistry.SAGUARO_WORM_SHOT.get(), this, this.level());
                        shot.xo = this.xo + r * Math.cos(theta);
                        shot.yo = this.yo + 5 + h;
                        shot.zo = this.zo + r * Math.sin(theta);
                        shot.shoot(tx, ty, tz, 0.9f, 5);
                        level().addFreshEntity(shot);
                    }
                }
            }
            }
        }
}