package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.*;

import java.util.List;

public class EntityHastreus extends EntityDivineMonster {
    private int attackTick;
    public EntityHastreus(EntityType<? extends Monster> type, Level worldIn) {super(type, worldIn);}
    @Override protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {return 1.15625F;}
    @Override public boolean isAggressive() {return true;}
    @Override public void tick() {
    	if(level().getRandom().nextInt(10) == 0) {
            List<Entity> e = level().getEntities(this, new AABB(blockPosition().offset(-25, -16, -25), blockPosition().offset(25, 16, 25)));
            for(Entity entity : e) if(entity instanceof LivingEntity) {
    	        if(entity instanceof EntityHastreus || (entity instanceof Player && (((Player)entity).isCreative() || entity.isSpectator()))) continue;
    	        if(isLookingAtMe((LivingEntity) entity)) ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 18, true, false));
    	    }
    	}
        super.tick();
    }
    boolean isLookingAtMe(LivingEntity entity) {
        Vec3 vec3 = entity.getViewVector(1).normalize();
        Vec3 vec31 = new Vec3(getX() - entity.getX(), getEyeY() - entity.getEyeY(), getZ() - entity.getZ());
        double d0 = vec31.length();
        vec31 = vec31.normalize();
        double d1 = vec3.dot(vec31);
        return d1 > 1 - .025 / d0 && entity.hasLineOfSight(this);
    }
    @Override public void addAdditionalSaveData(CompoundTag p_33353_) {
        super.addAdditionalSaveData(p_33353_);
        p_33353_.putInt("AttackTick", attackTick);
    }
    @Override public void readAdditionalSaveData(CompoundTag p_33344_) {
        super.readAdditionalSaveData(p_33344_);
        attackTick = p_33344_.getInt("AttackTick");
    }
    @Override public void aiStep() {
        super.aiStep();
        if (isAlive() && attackTick > 0) --attackTick;
    }
    @Override public void handleEntityEvent(byte p_33335_) {
        if (p_33335_ == 4) attackTick = 10;
        super.handleEntityEvent(p_33335_);
    }
    public int getAttackTick() {return attackTick;}
    @Override public boolean doHurtTarget(Entity p_33328_) {
        attackTick = 10;
        level().broadcastEntityEvent(this, (byte)4);
        return super.doHurtTarget(p_33328_);
    }
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.HASTREUS.get();}
    @Override protected SoundEvent getHurtSound(DamageSource source) {return SoundRegistry.HASTREUS_HURT.get();}
    @Override protected SoundEvent getDeathSound() {return SoundRegistry.HASTREUS_HURT.get();}
    @Override public int getMaxSpawnClusterSize() {return 3;}
    @Override public boolean isMaxGroupSizeReached(int i) {return i > 3;}
}