package divinerpg.entities.arcana;

import divinerpg.entities.base.*;
import divinerpg.registries.*;
import divinerpg.util.*;
import net.minecraft.block.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.nbt.*;
import net.minecraft.network.datasync.*;
import net.minecraft.potion.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class EntityWraith extends EntityDivineTameable {

    private static final DataParameter<Byte> DATA_ID_FLAGS = EntityDataManager.defineId(EntityWraith.class, DataSerializers.BYTE);
    private static final EntityPredicate RESTING_TARGETING = (new EntityPredicate()).range(4.0D).allowSameTeam();
    private BlockPos targetPosition;
	
	public EntityWraith(EntityType<? extends TameableEntity> type, World worldIn, PlayerEntity player) {
        super(type, worldIn);
        setHealth(getMaxHealth());
        tame(player);
        this.setResting(true);
    }
	
	public <T extends Entity> EntityWraith(EntityType<T> type, World worldIn) {
        super((EntityType<? extends TameableEntity>) type, worldIn);
        setHealth(getMaxHealth());
    }
	
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 1.5F;
    }
    
    public static AttributeModifierMap.MutableAttribute attributes() {
        return TameableEntity.createMobAttributes().add(Attributes.MAX_HEALTH, EntityStats.seimerHealth).add(Attributes.MOVEMENT_SPEED, EntityStats.seimerSpeed).add(Attributes.FOLLOW_RANGE, EntityStats.seimerFollowRange);
    }
    
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        Item item = itemstack.getItem();
        if (this.isTame()) {
            if (isFood(itemstack)) {
                if (!player.isCreative()) {
                    itemstack.shrink(1);
                }
                this.heal((float) item.getFoodProperties().getNutrition());
                return ActionResultType.PASS;
            } else {
                tame(player);
                this.setTame(true);
            }
        }
        return super.mobInteract(player, hand);
    }

    public boolean isFood(ItemStack stack) {
        Item item = stack.getItem();
        return item.isEdible() && item.getFoodProperties().isMeat();
    }

    @Override
    public boolean doHurtTarget(Entity entity) {
        float damage = (float) getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue();

        if (this.hasEffect(Effects.DAMAGE_BOOST)) {
            damage += 3 << this.getEffect(Effects.DAMAGE_BOOST).getAmplifier();
        }
        if (this.hasEffect(Effects.WEAKNESS)) {
            damage -= 2 << this.getEffect(Effects.WEAKNESS).getAmplifier();
        }

        int knockback = 0;
        if (entity instanceof LivingEntity) {
            damage += EnchantmentHelper.getBlockEfficiency((LivingEntity) entity);
            knockback += EnchantmentHelper.getKnockbackBonus((LivingEntity) entity);
        }

        boolean attacked = entity.hurt(DamageSource.mobAttack(this), damage);

        if (attacked) {
            if (knockback > 0) {
                entity.setDeltaMovement(-MathHelper.sin(this.xRot * (float) Math.PI / 180.0F) * knockback * 0.5F,
                        0.1D, MathHelper.cos(this.xRot * (float) Math.PI / 180.0F) * knockback * 0.5F);
                this.setDeltaMovement(getDeltaMovement().x * 0.6D, getDeltaMovement().y, getDeltaMovement().z * 0.6D);
            }

            int fire = EnchantmentHelper.getFireAspect(this);
            if (fire > 0) {
                entity.setRemainingFireTicks(fire * 4);
            }
        }

        return attacked;
    }
    
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        if (this.getOwnerUUID() == null) {
            compound.putString("Owner", "");
        } else {
            compound.putString("Owner", this.getOwnerUUID().toString());
        }
        compound.putBoolean("Sitting", this.isOrderedToSit());
        compound.putByte("BatFlags", this.entityData.get(DATA_ID_FLAGS));
    }
    
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(DATA_ID_FLAGS, compound.getByte("BatFlags"));
    }
    
    @Override
    protected float getSoundVolume() {
        return 0.1F;
    }
    
    @Override
    protected float getVoicePitch() {
        return super.getVoicePitch() * 0.95F;
    }
    
    @Nullable
    @Override
    public SoundEvent getAmbientSound() {
        return this.isResting() && this.random.nextInt(4) != 0 ? null : SoundRegistry.WRAITH;
    }
    
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundRegistry.WRAITH_HURT;
    }
    
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.WRAITH_HURT;
    }

    public boolean isPushable() {
        return false;
    }

    protected void doPush(Entity p_82167_1_) {
    }

    protected void pushEntities() {
    }

    public boolean isResting() {
        return (this.entityData.get(DATA_ID_FLAGS) & 1) != 0;
    }

    public void setResting(boolean p_82236_1_) {
        byte b0 = this.entityData.get(DATA_ID_FLAGS);
        if (p_82236_1_) {
            this.entityData.set(DATA_ID_FLAGS, (byte)(b0 | 1));
        } else {
            this.entityData.set(DATA_ID_FLAGS, (byte)(b0 & -2));
        }

    }
    
    @Override
    public void tick() {
        if (this.isResting()) {
            this.setDeltaMovement(Vector3d.ZERO);
            this.setPosRaw(this.getX(), (double)MathHelper.floor(this.getY()) + 1.0D - (double)this.getBbHeight(), this.getZ());
        } else {
            this.setDeltaMovement(this.getDeltaMovement().multiply(1.0D, 0.6D, 1.0D));
        }

    }
    
    @Override
    protected void customServerAiStep() {
        super.customServerAiStep();
        BlockPos blockpos = this.blockPosition();
        BlockPos blockpos1 = blockpos.above();
        if (this.isResting()) {
            boolean flag = this.isSilent();
            if (this.level.getBlockState(blockpos1).isRedstoneConductor(this.level, blockpos)) {
                if (this.random.nextInt(200) == 0) {
                    this.yHeadRot = (float)this.random.nextInt(360);
                }

                if (this.level.getNearestPlayer(RESTING_TARGETING, this) != null) {
                    this.setResting(false);
                    if (!flag) {
                        this.level.levelEvent((PlayerEntity)null, 1025, blockpos, 0);
                    }
                }
            } else {
                this.setResting(false);
                if (!flag) {
                    this.level.levelEvent((PlayerEntity)null, 1025, blockpos, 0);
                }
            }
        } else {
            if (this.targetPosition != null && (!this.level.isEmptyBlock(this.targetPosition) || this.targetPosition.getY() < 1)) {
                this.targetPosition = null;
            }

            if (this.targetPosition == null || this.random.nextInt(30) == 0 || this.targetPosition.closerThan(this.position(), 2.0D)) {
                this.targetPosition = new BlockPos(this.getX() + (double)this.random.nextInt(7) - (double)this.random.nextInt(7), this.getY() + (double)this.random.nextInt(6) - 2.0D, this.getZ() + (double)this.random.nextInt(7) - (double)this.random.nextInt(7));
            }

            double d2 = (double)this.targetPosition.getX() + 0.5D - this.getX();
            double d0 = (double)this.targetPosition.getY() + 0.1D - this.getY();
            double d1 = (double)this.targetPosition.getZ() + 0.5D - this.getZ();
            Vector3d vector3d = this.getDeltaMovement();
            Vector3d vector3d1 = vector3d.add((Math.signum(d2) * 0.5D - vector3d.x) * (double)0.1F, (Math.signum(d0) * (double)0.7F - vector3d.y) * (double)0.1F, (Math.signum(d1) * 0.5D - vector3d.z) * (double)0.1F);
            this.setDeltaMovement(vector3d1);
            float f = (float)(MathHelper.atan2(vector3d1.z, vector3d1.x) * (double)(180F / (float)Math.PI)) - 90.0F;
            float f1 = MathHelper.wrapDegrees(f - this.yRot);
            this.zza = 0.5F;
            this.yRot += f1;
            if (this.random.nextInt(100) == 0 && this.level.getBlockState(blockpos1).isRedstoneConductor(this.level, blockpos1)) {
                this.setResting(true);
            }
        }
    }

    protected boolean isMovementNoisy() {
        return false;
    }

    public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
        return false;
    }

    protected void checkFallDamage(double p_184231_1_, boolean p_184231_3_, BlockState p_184231_4_, BlockPos p_184231_5_) {
    }

    public boolean isIgnoringBlockTriggers() {
        return true;
    }

}
