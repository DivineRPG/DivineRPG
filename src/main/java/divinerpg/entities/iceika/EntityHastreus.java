package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityDivineMonster;
import divinerpg.registries.SoundRegistry;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class EntityHastreus extends EntityDivineMonster {

    public EntityHastreus(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.15625F;
    }

    @Override
    public boolean isAggressive() {
        return true;
    }

    @Override
    public void tick() {
    	if(level().getRandom().nextInt(10) == 0) {
            List<Entity> e = level().getEntities(this, new AABB(blockPosition().offset(-25, -16, -25), blockPosition().offset(25, 16, 25)));
            for(Entity entity : e) if(entity instanceof LivingEntity) {
    	        if(entity instanceof EntityHastreus || (entity instanceof Player && (((Player)entity).isCreative() || ((Player)entity).isSpectator()))) continue;
    	        if(isLookingAtMe((LivingEntity) entity)) ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 60, 18, true, false));
    	    }
    	}
        super.tick();
    }
    boolean isLookingAtMe(LivingEntity entity) {
        Vec3 vec3 = entity.getViewVector(1F).normalize();
        Vec3 vec31 = new Vec3(getX() - entity.getX(), getEyeY() - entity.getEyeY(), getZ() - entity.getZ());
        double d0 = vec31.length();
        vec31 = vec31.normalize();
        double d1 = vec3.dot(vec31);
        return d1 > 1D - .025D / d0 ? entity.hasLineOfSight(this) : false;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.HASTREUS.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.HASTREUS_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.HASTREUS_HURT.get();
    }

    @Override
    public int getMaxSpawnClusterSize() {
    	return 3;
    }

    @Override
    public boolean isMaxGroupSizeReached(int i) {
    	return i > 3;
    }
}
