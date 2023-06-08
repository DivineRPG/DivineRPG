package divinerpg.entities.vethea;

import divinerpg.entities.base.EntityDivineFlyingMob;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class EntityLorgaflight extends EntityDivineFlyingMob {
    public boolean canSpawnMinions;
    public EntityLorgaflight(EntityType<? extends EntityDivineFlyingMob> type, Level worldIn) {
        this(type, worldIn, true);
    }
    public EntityLorgaflight(EntityType<? extends EntityDivineFlyingMob> type, Level worldIn, boolean canSpawnMinions) {
        super(type, worldIn);
        this.canSpawnMinions = canSpawnMinions;
    }
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.9375F;
    }
    @Override
    public boolean causeFallDamage(float p_225503_1_, float p_225503_2_, DamageSource damagesource) {
        return false;
    }
    @Override
    public void checkFallDamage(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }
    @Override
    protected int calculateFallDamage(float p_225508_1_, float p_225508_2_) {
        return 0;
    }
    @Override
    public double getMeleeAttackRangeSqr(LivingEntity entity) {
        return super.getMeleeAttackRangeSqr(entity) * 1.5;
    }
    @Override
    protected void customServerAiStep() {
        if(getTarget() == null && random.nextBoolean()) {
            List<EntityLorgaflight> list = level().getEntitiesOfClass(EntityLorgaflight.class, new AABB(blockPosition().offset(-5, -5, -5), blockPosition().offset(5, 5, 5)));
            if(!list.isEmpty()) {
                EntityLorgaflight partner = list.get(0);
                if(partner.pathfindPos != null) pathfindPos = partner.pathfindPos.add(position().subtract(partner.position()).multiply(.9, .9, .9));
            }
        }
        super.customServerAiStep();
    }
    @Override
    public void tick() {
        super.tick();
        if(!level().isClientSide && canSpawnMinions && getRandom().nextInt(64) == 0 && level().getEntities(null, new AABB(blockPosition().offset(-10, -3, -10), blockPosition().offset(10, 3, 10))).size() < 8) {
            BlockPos pos = blockPosition().offset(random.nextInt(5) - 2, 0, random.nextInt(5) - 2);
            if(level().getBlockState(pos).isAir() && level().getBlockState(pos.above()).isAir()) ((EntityLorgaflight) EntityRegistry.LORGA_FLIGHT.get().spawn((ServerLevel) level(), (ItemStack) null, null, pos, MobSpawnType.MOB_SUMMONED, false, false)).canSpawnMinions = false;
        }
    }
    @Override
    public int getMaxSpawnClusterSize() {
        return 8;
    }
    @Override
    public boolean isMaxGroupSizeReached(int i) {
        return i < 8;
    }
    @Override public boolean isAggressive() {return true;}
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("CanSpawnMinions", canSpawnMinions);
    }
    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        canSpawnMinions = tag.getBoolean("CanSpawnMinions");
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.LORGAFLIGHT.get();
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.LORGAFLIGHT_HURT.get();
    }
    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.LORGAFLIGHT_HURT.get();
    }
}