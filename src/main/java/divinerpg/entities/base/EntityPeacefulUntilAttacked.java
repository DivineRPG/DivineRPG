package divinerpg.entities.base;

import divinerpg.registries.AttachmentRegistry;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;

public abstract class EntityPeacefulUntilAttacked extends EntityDivineMonster {
    public EntityPeacefulUntilAttacked(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    public void onAddedToLevel() {
        super.onAddedToLevel();
        if(level().isClientSide()) AttachmentRegistry.ANGRY.requestAttachment(this, null);
    }
    @Override
    public void setTarget(@Nullable LivingEntity livingBase) {
    	super.setTarget(livingBase);
        setAngryAt(livingBase);
        if(livingBase instanceof Player) alertOthers();
    }
    protected void alert(@Nullable LivingEntity livingBase) {
    	super.setTarget(livingBase);
        setAngryAt(livingBase);
    }
    protected void setAngryAt(@Nullable LivingEntity livingBase) {
        if(livingBase == null) {
//            AttachmentRegistry.ANGRY_AT.set(this, AttachmentRegistry.zero);
            AttachmentRegistry.ANGER_TIME.set(this, 0);
            AttachmentRegistry.ANGRY.set(this, false);
        } else {
//            AttachmentRegistry.ANGRY_AT.set(this, livingBase.getUUID());
            AttachmentRegistry.ANGER_TIME.set(this, 400 + random.nextInt(400));
            AttachmentRegistry.ANGRY.set(this, true);
        }
    }
    protected void alertOthers() {
        double d0 = getAttributeValue(Attributes.FOLLOW_RANGE);
        AABB aabb = AABB.unitCubeFromLowerCorner(position()).inflate(d0, 10D, d0);
        level().getEntitiesOfClass(getClass(), aabb, EntitySelector.NO_SPECTATORS).stream().filter(entity -> entity != this && entity != null && entity.getTarget() == null && !entity.isAlliedTo(getTarget())).forEach(entity -> entity.alert(getTarget()));
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(!level().isClientSide() && AttachmentRegistry.ANGRY.get(this)) AttachmentRegistry.ANGER_TIME.set(this, 400 + random.nextInt(400));
        return super.hurt(source, amount);
    }
    @Override
    public void tick() {
        super.tick();
        if(!level().isClientSide()) {
            int angerLevel = AttachmentRegistry.ANGER_TIME.get(this);
            if(angerLevel > 0) {
                angerLevel--;
                AttachmentRegistry.ANGER_TIME.set(this, angerLevel);
                if(angerLevel == 0) setTarget(null);
            }
        }
    }
    @Override
    public boolean isAggressive() {
        return AttachmentRegistry.ANGRY.get(this);
    }

    @Override
    public boolean isPreventingPlayerRest(Player player) {
        return isAggressive();
    }
    @Override
    protected boolean shouldDespawnInPeaceful() {
        return false;
    }
}