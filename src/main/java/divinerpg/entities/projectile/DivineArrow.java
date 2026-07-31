package divinerpg.entities.projectile;

// import divinerpg.effect.mob.EnderAttachmentEffect;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.arrow.AbstractArrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.phys.*;

import javax.annotation.Nullable;

public abstract class DivineArrow extends AbstractArrow {
    public float powerMultiplier = 1.0F;

    public DivineArrow(EntityType<? extends DivineArrow> entityType, Level level) {super(entityType, level);}
    public DivineArrow(EntityType<? extends AbstractArrow> type, Level level, LivingEntity owner, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(type, owner, level, pickupItemStack, firedFromWeapon);
    }
    public DivineArrow(EntityType<? extends AbstractArrow> type, Level level, double x, double y, double z, ItemStack pickupItemStack, @Nullable ItemStack firedFromWeapon) {
        super(type, x, y, z, level, pickupItemStack, firedFromWeapon);
    }
    public float getArrowPower() {
        return 2.0F;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        setBaseDamage(getArrowPower() * powerMultiplier);
        super.onHitEntity(result);
    }

    @Override
    protected void addAdditionalSaveData(ValueOutput output) {
        super.addAdditionalSaveData(output);
        output.putFloat("power_m", powerMultiplier);
    }

    @Override
    protected void readAdditionalSaveData(ValueInput input) {
        super.readAdditionalSaveData(input);
    powerMultiplier = input.getFloatOr("power_m", 1);
    }

    public void addEffect(MobEffectInstance effectInstance) {
        Iterable<MobEffectInstance> contents = getPotionContents().getAllEffects();
        for (MobEffectInstance c : contents) {
            if (c.is(effectInstance.getEffect())) {
                return;
            }
        }
        setPotionContents(getPotionContents().withEffectAdded(effectInstance));
    }

    protected PotionContents getPotionContents() {
        return getPickupItem().getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY);
    }

    private void setPotionContents(PotionContents potionContents) {
        getPickupItem().set(DataComponents.POTION_CONTENTS, potionContents);
    }

    @Override
    protected void doPostHurtEffects(LivingEntity living) {
        super.doPostHurtEffects(living);
        Entity entity = getEffectSource();
        PotionContents potioncontents = getPotionContents();

        if (potioncontents.potion().isPresent()) {
            for (MobEffectInstance mobeffectinstance : potioncontents.potion().get().value().getEffects()) {
                if (mobeffectinstance.getEffect().value().isInstantaneous()) {
                    mobeffectinstance.getEffect().value().applyInstantaneousEffect(level().getServer().getLevel(level().dimension()), getOwner(), this, living, mobeffectinstance.getAmplifier(), 1.0D);
                } else {
                    living.addEffect(new MobEffectInstance(mobeffectinstance.getEffect(), Math.max(mobeffectinstance.mapDuration((duration) -> duration / 8), 1), mobeffectinstance.getAmplifier(), mobeffectinstance.isAmbient(), mobeffectinstance.isVisible()), entity);
                }
            }
        }

        for (MobEffectInstance mobeffectinstance1 : potioncontents.customEffects()) {
            if (mobeffectinstance1.getEffect().value().isInstantaneous()) {
                mobeffectinstance1.getEffect().value().applyInstantaneousEffect(level().getServer().getLevel(level().dimension()), getOwner(), this, living, mobeffectinstance1.getAmplifier(), 1.0D);
            } else {
                living.addEffect(mobeffectinstance1, entity);
            }
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!level().isClientSide()) {
            PotionContents potionContents = getPotionContents();
            /* TODO: Uncomment once EnderAttachmentEffect is ported
            if (potionContents.potion().isPresent()) {
                for (MobEffectInstance instance : potionContents.potion().get().value().getEffects()) {
                    if (instance.getEffect().value() instanceof EnderAttachmentEffect e) {
                        e.hitBlock(getOwner(), this);
                    }
                }
            }
            for (MobEffectInstance instance : potionContents.customEffects()) {
                if (instance.getEffect().value() instanceof EnderAttachmentEffect e) {
                    e.hitBlock(getOwner(), this);
                }
            }
            */
        }
    }
}