package divinerpg.entities.eden;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.AttachmentRegistry;
import divinerpg.registries.EntityRegistry;
import divinerpg.registries.SoundRegistry;
import divinerpg.registries.TagRegistry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

import static net.minecraft.world.Difficulty.PEACEFUL;

public class EntityGlinthop extends EntityDivineTameable {
    public EntityGlinthop(EntityType<? extends EntityGlinthop> type, Level level) {
        super(type, level, 1.5F);
        if (!level.isClientSide() && !this.hasData(AttachmentRegistry.SPECIAL.attachment.get())) {
            this.setData(AttachmentRegistry.SPECIAL.attachment.get(), getRandom().nextInt(50) == 1);
        }
    }

    @Override
    public void die(DamageSource source) {
        super.die(source);
        if (!level().isClientSide() && !isTame() && !level().getDifficulty().equals(PEACEFUL)) {
            transform();
        }
    }

    private void transform() {
        if (level() instanceof ServerLevel serverLevel) {
            EntityRegistry.ANGRY_GLINTHOP.get().spawn(
                    serverLevel,
                    ItemStack.EMPTY,
                    null,
                    blockPosition(),
                    EntitySpawnReason.MOB_SUMMONED,
                    true,
                    false
            );
        }
        remove(RemovalReason.KILLED);
    }

    @Override
    public void setTarget(@Nullable LivingEntity target) {
        super.setTarget(target);
        if (isTame()) {
            this.setData(AttachmentRegistry.ANGRY.attachment.get(), target != null);
        }
    }

    public boolean isSpecialAlt() {
        return this.getData(AttachmentRegistry.SPECIAL.attachment.get());
    }

    @Nullable
    @Override
    public LivingEntity getTarget() {
        LivingEntity entity = super.getTarget();
        if (entity != null && ((isTame() && distanceToSqr(entity) < 144.0D) || !isTame())) {
            return entity;
        }
        return null;
    }

    @Override
    public boolean isFood(ItemStack item) {
        return item.is(TagRegistry.PET_GLINTHOP);
    }

    @Override
    protected boolean isTamingFood(ItemStack item) {
        return item.is(TagRegistry.TAMING_GLINTHOP);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GLINTHOP.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GLINTHOP_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GLINTHOP_HURT.get();
    }
}