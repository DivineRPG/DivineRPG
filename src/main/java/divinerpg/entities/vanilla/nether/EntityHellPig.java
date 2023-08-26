package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineTameable;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

public class EntityHellPig extends EntityDivineTameable {
    private static final EntityDataAccessor<Boolean> ANGRY = SynchedEntityData.defineId(EntityHellPig.class,
            EntityDataSerializers.BOOLEAN);

    public EntityHellPig(EntityType<? extends TamableAnimal> type, Level worldIn) {
        super(type, worldIn, 2F);
        this.setTame(false);
    }

    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return .99375F;
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        entityData.define(ANGRY, Boolean.FALSE);
    }

    @Override
    public void setTarget(LivingEntity attackTarget) {
        super.setTarget(attackTarget);
        if(attackTarget == null) setAngry(false);
        else if(!isTame()) setAngry(true);
    }

    @Override
    public boolean isFood(ItemStack item) {
    	return isMeat(item);
    }

    @Override
    protected boolean isTamingFood(ItemStack item) {
    	return item.is(Items.BLAZE_POWDER) && !isAngry();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("Angry", this.isAngry());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setAngry(tag.getBoolean("Angry"));
    }

    @Override
    public boolean isAngry() {
        return entityData.get(ANGRY);
    }

    public void setAngry(boolean angry) {
        entityData.set(ANGRY, angry);
    }

    @Override
    public boolean removeWhenFarAway(double d) {
    	return !isTame();
    }
}
