package divinerpg.entities.arcana;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.TagRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class EntityParatiku extends EntityDivineTameable {
    private static final EntityDataAccessor<Byte> DATA_ID_FLAGS = SynchedEntityData.defineId(EntityParatiku.class, EntityDataSerializers.BYTE);
    private static final int FLAG_HANGING = 1;
    private static final TargetingConditions RESTING_TARGETING = TargetingConditions.forNonCombat().range(4.0);

    private @Nullable BlockPos targetPosition;

    public EntityParatiku(EntityType<? extends EntityParatiku> type, Level level) {
        super(type, level, 1F);
        if (!level.isClientSide()) {
            this.setIsParatikuHanging(true);
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder entityData) {
        super.defineSynchedData(entityData);
        entityData.define(DATA_ID_FLAGS, (byte) 0);
    }

    public boolean getIsParatikuHanging() {
        return (this.entityData.get(DATA_ID_FLAGS) & FLAG_HANGING) != 0;
    }

    public void setIsParatikuHanging(boolean isHanging) {
        byte current = this.entityData.get(DATA_ID_FLAGS);
        if (isHanging) {
            this.entityData.set(DATA_ID_FLAGS, (byte) (current | FLAG_HANGING));
        } else {
            this.entityData.set(DATA_ID_FLAGS, (byte) (current & ~FLAG_HANGING));
        }
    }

    @Override public boolean isPushable() {return false;}
    @Override protected void doPush(Entity ent) {}
    @Override protected void pushEntities() {}
    @Override protected void checkFallDamage(double d, boolean b, BlockState s, BlockPos p) {}
    @Override public boolean isIgnoringBlockTriggers() {return true;}

    @Override
    public void tick() {
        super.tick();
        if (getIsParatikuHanging()) {
            this.setDeltaMovement(Vec3.ZERO);
            this.setPosRaw(this.getX(), (double) Mth.floor(this.getY()) + 1.0 - this.getBbHeight(), this.getZ());
        } else {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0, 0.6, 1.0));
        }
    }

    @Override
    protected void customServerAiStep(ServerLevel level) {
        super.customServerAiStep(level);
        BlockPos blockpos = this.blockPosition();
        BlockPos blockpos1 = blockpos.above();

        if (getIsParatikuHanging()) {
            boolean flag = this.isSilent();
            if (level.getBlockState(blockpos1).isRedstoneConductor(level, blockpos)) {
                if (this.random.nextInt(200) == 0) {
                    this.yHeadRot = (float) this.random.nextInt(360);
                }

                if (level.getNearestPlayer(RESTING_TARGETING, this) != null) {
                    this.setIsParatikuHanging(false);
                    if (!flag) {
                        level.levelEvent(null, 1025, blockpos, 0);
                    }
                }
            } else {
                this.setIsParatikuHanging(false);
                if (!flag) {
                    level.levelEvent(null, 1025, blockpos, 0);
                }
            }
        } else {
            if (this.targetPosition != null && (!level.isEmptyBlock(this.targetPosition) || this.targetPosition.getY() <= level.getMinY())) {
                this.targetPosition = null;
            }

            if (this.targetPosition == null || this.random.nextInt(30) == 0 || this.targetPosition.closerToCenterThan(this.position(), 2.0)) {
                this.targetPosition = BlockPos.containing(
                        this.getX() + this.random.nextInt(7) - this.random.nextInt(7),
                        this.getY() + this.random.nextInt(6) - 2.0,
                        this.getZ() + this.random.nextInt(7) - this.random.nextInt(7)
                );
            }

            double d2 = this.targetPosition.getX() + 0.5 - this.getX();
            double d0 = this.targetPosition.getY() + 0.1 - this.getY();
            double d1 = this.targetPosition.getZ() + 0.5 - this.getZ();

            Vec3 movement = this.getDeltaMovement();
            Vec3 newMovement = movement.add(
                    (Math.signum(d2) * 0.5 - movement.x) * 0.1,
                    (Math.signum(d0) * 0.7 - movement.y) * 0.1,
                    (Math.signum(d1) * 0.5 - movement.z) * 0.1
            );

            this.setDeltaMovement(newMovement);
            float f = (float) (Mth.atan2(newMovement.z, newMovement.x) * Mth.RAD_TO_DEG) - 90.0F;
            float f1 = Mth.wrapDegrees(f - this.getYRot());
            this.zza = 0.5F;
            this.setYRot(this.getYRot() + f1);

            if (this.random.nextInt(100) == 0 && level.getBlockState(blockpos1).isRedstoneConductor(level, blockpos1)) {
                this.setIsParatikuHanging(true);
            }
        }
    }

    @Override
    public boolean hurtServer(ServerLevel level, DamageSource source, float amount) {
        if (this.isInvulnerableTo(level, source)) {
            return false;
        }

        if (getIsParatikuHanging()) {
            this.setIsParatikuHanging(false);
        }

        return super.hurtServer(level, source, amount);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        this.entityData.set(DATA_ID_FLAGS, input.getByteOr("ParatikuFlags", (byte) 0));
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putByte("ParatikuFlags", this.entityData.get(DATA_ID_FLAGS));
    }
    @Override public boolean isFood(ItemStack item) {return item.is(TagRegistry.PET_PARATIKU);}
    @Override protected boolean isTamingFood(ItemStack item) {return item.is(TagRegistry.TAMING_PARATIKU);}
    @Override protected float getSoundVolume() {return 0.1F;}
    @Override public float getVoicePitch() {return super.getVoicePitch() * 0.95F;}
    @Override protected SoundEvent getAmbientSound() {return getIsParatikuHanging() && this.random.nextInt(4) != 0 ? null : SoundEvents.BAT_AMBIENT;}
    @Override protected SoundEvent getHurtSound(DamageSource damageSourceIn) {return SoundEvents.BAT_HURT;}
    @Override protected SoundEvent getDeathSound() {return SoundEvents.BAT_DEATH;}
}