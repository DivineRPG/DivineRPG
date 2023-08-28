package divinerpg.entities.vanilla.overworld;

import divinerpg.DivineRPG;
import divinerpg.entities.base.EntityDivineWaterMob;
import divinerpg.registries.SoundRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.control.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityShark extends EntityDivineWaterMob {
    private int attackTick;

    public EntityShark(EntityType<? extends EntityShark> type, Level worldIn) {
        super(type, worldIn);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.15F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.59375F;
    }

    @Override
    public boolean isAggressive() {
        return true;
    }

    @Override
    public ItemEntity spawnAtLocation(ItemStack stack) {
        ItemEntity itementity = this.spawnAtLocation(stack, 0.0F);
        if (itementity != null) {
            itementity.setExtendedLifetime();
        }
        return itementity;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag p_33353_) {
        super.addAdditionalSaveData(p_33353_);
        p_33353_.putInt("AttackTick", this.attackTick);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag p_33344_) {
        super.readAdditionalSaveData(p_33344_);
        this.attackTick = p_33344_.getInt("AttackTick");
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if (this.isAlive()) {
            if (this.attackTick > 0) {
                --this.attackTick;
            }
        }
    }

    @Override
    public void handleEntityEvent(byte p_33335_) {
        if (p_33335_ == 4) {
            this.attackTick = 10;
        }

        super.handleEntityEvent(p_33335_);
    }

    public int getAttackTick() {
        return this.attackTick;
    }

    @Override
    public boolean doHurtTarget(Entity target) {
        this.attackTick = 10;
        this.level().broadcastEntityEvent(this, (byte)4);
        if(!level().isClientSide()) {
            if (level().getRandom().nextInt(12) == 2) {
                spawnAtLocation(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shark_tooth")));
            }
        }
        return super.doHurtTarget(target);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SHARK.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.SHARK_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.SHARK_HURT.get();
    }

}