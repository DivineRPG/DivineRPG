package divinerpg.entities.eden;

import divinerpg.registries.AttachmentRegistry;
import divinerpg.registries.BlockRegistry;
import divinerpg.registries.ItemRegistry;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Bucketable;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.fish.AbstractSchoolingFish;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

import static net.minecraft.core.particles.ParticleTypes.HEART;
import static net.minecraft.world.item.Items.WATER_BUCKET;

public class EntityGemFin extends AbstractSchoolingFish {
    private boolean hasBeenFed = false;

    public EntityGemFin(EntityType<? extends EntityGemFin> type, Level level) {
        super(type, level);
        if (!level.isClientSide() && !this.hasData(AttachmentRegistry.VARIANT.attachment.get())) {
            this.setData(AttachmentRegistry.VARIANT.attachment.get(), (byte) getRandom().nextInt(3));
        }
    }

    @Override
    public void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putBoolean("HasBeenFed", isFed());
    }

    @Override
    public void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
        setFed(input.getBooleanOr("HasBeenFed", false));
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack heldItem = player.getItemInHand(hand);
        if (!hasBeenFed && heldItem.is(BlockRegistry.gemOfTheDunes.get().asItem())) {
            heldItem.consume(1, player);
            setFed(true);
            for (int i = 0; i < 7; ++i) {
                double d0 = random.nextGaussian() * 0.02D;
                double d1 = random.nextGaussian() * 0.02D;
                double d2 = random.nextGaussian() * 0.02D;
                level().addParticle(HEART, getRandomX(1.0D), getRandomY() + 0.5D, getRandomZ(1.0D), d0, d1, d2);
            }
            return InteractionResult.SUCCESS;
        } else if (heldItem.is(WATER_BUCKET) && isAlive()) {
            return Bucketable.bucketMobPickup(player, hand, this).orElse(InteractionResult.PASS);
        } else if (!hasBeenFed && !(heldItem.is(BlockRegistry.gemOfTheDunes.get().asItem()) || heldItem.is(WATER_BUCKET))) {
            player.sendSystemMessage(LocalizeUtils.clientMessage("feed_gem"));
            return InteractionResult.CONSUME;
        } else if (hasBeenFed && heldItem.is(BlockRegistry.gemOfTheDunes.get().asItem())) {
            return InteractionResult.FAIL;
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return !hasBeenFed;
    }

    @Override
    public void saveToBucketTag(ItemStack stack) {
        super.saveToBucketTag(stack);
        CustomData.update(DataComponents.BUCKET_ENTITY_DATA, stack, tag -> tag.putByte("Variant", getVariant()));
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(ItemRegistry.gem_fin_bucket.get());
    }

    public void setFed(boolean bool) {
        hasBeenFed = bool;
    }

    public boolean isFed() {
        return hasBeenFed;
    }

    public byte getVariant() {
        return this.getData(AttachmentRegistry.VARIANT.attachment.get());
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.COD_AMBIENT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.COD_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.COD_HURT;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }
}