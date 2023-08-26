package divinerpg.entities.base;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;

import javax.annotation.Nullable;
import java.util.UUID;

public abstract class EntityPeacefulUntilAttacked extends EntityDivineMonster {
    protected int angerLevel;
    protected UUID angerTargetUUID;
    public EntityPeacefulUntilAttacked(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("Anger", angerLevel);
        if(angerTargetUUID != null) compound.putString("HurtBy", angerTargetUUID.toString());
        else compound.putString("HurtBy", "");
    }
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        angerLevel = compound.getInt("Anger");
        String s = compound.getString("HurtBy");
        if(!s.isEmpty()) {
            angerTargetUUID = UUID.fromString(s);
            setTarget(level().getPlayerByUUID(angerTargetUUID));
        }
    }
    @Override
    public void setTarget(@Nullable LivingEntity livingBase) {
    	super.setTarget(livingBase);
        if(livingBase != null && livingBase instanceof Player) {
        	angerTargetUUID = livingBase.getUUID();
        	alertOthers();
        }
    }
    protected void alert(@Nullable LivingEntity livingBase) {
    	super.setTarget(livingBase);
        if(livingBase != null && livingBase instanceof Player) angerTargetUUID = livingBase.getUUID();
    }
    protected void alertOthers() {
        double d0 = getAttributeValue(Attributes.FOLLOW_RANGE);
        AABB aabb = AABB.unitCubeFromLowerCorner(position()).inflate(d0, 10D, d0);
        level().getEntitiesOfClass(getClass(), aabb, EntitySelector.NO_SPECTATORS).stream().filter((entity) -> {
           return entity != this && entity != null && entity.getTarget() == null && !entity.isAlliedTo(getTarget());
        }).forEach((entity) -> {
           entity.alert(getTarget());
        });
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        angerLevel = 400 + random.nextInt(400);
        return super.hurt(source, amount);
    }
    @Override
    public void tick() {
        super.tick();
        angerLevel--;
        if(!isAggressive() && getTarget() != null) setTarget(null);
    }
    @Override
    public boolean isAggressive() {
        return angerLevel > 0;
    }
}