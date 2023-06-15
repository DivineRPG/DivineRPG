package divinerpg.entities.eden;

import divinerpg.registries.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.world.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cod;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.Fluids;


public class EntityGemFin extends Cod {
    private int variant;
    private boolean hasBeenFed;

    public EntityGemFin(EntityType<? extends Cod> type, Level level) {
        super(type, level);
        variant = getRandom().nextInt(3);
        hasBeenFed = false;
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Variant", variant);
        compound.putBoolean("HasBeenFed", hasBeenFed);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        if (compound.contains("Variant")) {
            variant = compound.getInt("Variant");
        }
        if (compound.contains("HasBeenFed")) {
            hasBeenFed = compound.getBoolean("HasBeenFed");
        }
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack heldItem = player.getItemInHand(hand);
        if (heldItem.getItem() == BlockRegistry.gemOfTheDunes.get().asItem()) {
            if (!player.isCreative()) {
                heldItem.shrink(1);
            }
            setFed();
            return InteractionResult.CONSUME;
        } else if (heldItem.getItem() instanceof BucketItem && ((BucketItem) heldItem.getItem()).getFluid() == Fluids.EMPTY) {
            ItemStack fishBucket = this.getBucketItemStack();
            heldItem.shrink(1);
            if (heldItem.isEmpty()) {
                player.setItemInHand(hand, fishBucket);
            } else if (!player.getInventory().add(fishBucket)) {
                player.drop(fishBucket, false);
            }
            remove(RemovalReason.UNLOADED_WITH_PLAYER);
            return InteractionResult.SUCCESS;
        } else {
            if (!player.level().isClientSide) {
                player.displayClientMessage(MutableComponent.create(new TranslatableContents("message.feed_gem", null, null)), false);
            }
            return InteractionResult.FAIL;
        }
    }

    public void setFed() {
            hasBeenFed = true;
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return !hasBeenFed && super.removeWhenFarAway(distanceToClosestPlayer);
    }

    @Override
    public ItemStack getBucketItemStack() {
        ItemStack bucketStack = new ItemStack(ItemRegistry.gem_fin_bucket.get());
        CompoundTag entityData = bucketStack.getOrCreateTagElement("EntityTag");
        entityData.putInt("Variant", getVariant());
        entityData.putBoolean("HasBeenFed", getFed());
        bucketStack.setTag(entityData);
        return bucketStack;
    }

    public int getVariant() {
        return variant;
    }

    public boolean getFed() {
        return hasBeenFed;
    }
}