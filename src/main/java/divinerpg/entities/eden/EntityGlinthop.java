package divinerpg.entities.eden;

import divinerpg.entities.base.EntityDivineTameable;
import divinerpg.registries.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class EntityGlinthop extends EntityDivineTameable {
    public EntityGlinthop(EntityType<? extends EntityGlinthop> type, Level worldIn) {
        super(type, worldIn, 1.5F);
        if(!worldIn.isClientSide) setData(AttachmentRegistry.SPECIAL.attachment, random.nextInt(50) == 1);
    }
    @Override public void onAddedToLevel() {
        super.onAddedToLevel();
        if(level().isClientSide) AttachmentRegistry.SPECIAL.requestAttachment(this, null);
    }
    @Override public void die(DamageSource source) {
        super.die(source);
        if(!level().isClientSide && !isTame()) transform();
    }
    @Override public void setTarget(LivingEntity e) {
    	super.setTarget(e);
    	if(isTame()) AttachmentRegistry.ANGRY.set(this, e != null);
    }
    public boolean isSpecialAlt() {return AttachmentRegistry.SPECIAL.get(this);}
    @Nullable @Override public LivingEntity getTarget() {
        LivingEntity entity = super.getTarget();
        if(entity != null && ((isTame() && distanceToSqr(entity) < 144) || !isTame())) return entity;
        return null;
    }
    private void transform() {
        EntityRegistry.ANGRY_GLINTHOP.get().spawn((ServerLevel) level(), ItemStack.EMPTY, null, blockPosition(), MobSpawnType.MOB_SUMMONED, true, false);
        remove(RemovalReason.KILLED);
    }
    @Override public boolean isFood(ItemStack item) {return item.is(TagRegistry.PET_FOODS_GLINTHOP);}
    @Override protected boolean isTamingFood(ItemStack item) {return item.is(TagRegistry.PET_TAMING_FOODS_GLINTHOP);}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.GLINTHOP.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.GLINTHOP_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.GLINTHOP_HURT.get();}
}