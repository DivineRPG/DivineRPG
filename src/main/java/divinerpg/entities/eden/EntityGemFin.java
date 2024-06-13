package divinerpg.entities.eden;

import divinerpg.registries.*;
import divinerpg.util.LocalizeUtils;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

public class EntityGemFin extends AbstractSchoolingFish {
    private byte variant;
    private boolean hasBeenFed = false;

    public EntityGemFin(EntityType<? extends EntityGemFin> type, Level level) {
        super(type, level);
    }

    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("HasBeenFed", isFed());
        compound.putByte("Variant", variant);
    }

    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if(compound.contains("HasBeenFed")) setFed(compound.getBoolean("HasBeenFed"));
        variant = compound.contains("Variant") ? compound.getByte("Variant") : (byte) getRandom().nextInt(3);
    }

    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack heldItem = player.getItemInHand(hand);
        if(!hasBeenFed && heldItem.getItem() == BlockRegistry.gemOfTheDunes.get().asItem()) {
            if(!player.isCreative()) heldItem.shrink(1);
            setFed(true);
            for(int i = 0; i < 7; ++i) {
                double d0 = random.nextGaussian() * .02, d1 = random.nextGaussian() * .02, d2 = random.nextGaussian() * .02;
                level().addParticle(ParticleTypes.HEART, getRandomX(1D), getRandomY() + .5, getRandomZ(1D), d0, d1, d2);
            } return InteractionResult.SUCCESS;
        } else if(heldItem.getItem() == Items.WATER_BUCKET && isAlive()) {
            Bucketable.bucketMobPickup(player, hand, this);
            return InteractionResult.SUCCESS;
        } else if(!hasBeenFed && !(heldItem.getItem() == BlockRegistry.gemOfTheDunes.get().asItem() || (heldItem.getItem() == Items.WATER_BUCKET))) {
            player.displayClientMessage(LocalizeUtils.clientMessage("feed_gem"), true);
            return InteractionResult.CONSUME;
        } else if(hasBeenFed && heldItem.getItem() == BlockRegistry.gemOfTheDunes.get().asItem()) return InteractionResult.FAIL;
        else return InteractionResult.PASS;
    }

    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return !hasBeenFed;
    }

    public ItemStack getBucketItemStack() {
        return new ItemStack(ItemRegistry.gem_fin_bucket.get());
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.COD_AMBIENT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.COD_HURT;
    }

    protected SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    public void setFed(boolean bool) {
        hasBeenFed = bool;
    }

    public boolean isFed() {
        return hasBeenFed;
    }

    public byte getVariant() {
        return variant;
    }
}
