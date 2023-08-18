package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineFireballMob;
import divinerpg.entities.projectile.EntityScorcherShot;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.projectile.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

public class EntityScorcher extends EntityDivineFireballMob {
    public EntityScorcher(EntityType<? extends EntityScorcher> type, Level world) {
        super(type, world);
        setPathfindingMalus(BlockPathTypes.LAVA, 8F);
        setPathfindingMalus(BlockPathTypes.DANGER_FIRE, 0F);
        setPathfindingMalus(BlockPathTypes.DAMAGE_FIRE, 0F);
    }
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.3437F;
    }
    @Override
    protected void registerGoals() {
    	super.registerGoals();
        goalSelector.addGoal(0, new RangedAttackGoal(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 8, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
    }
    @Override
    protected Fireball getProjectile() {
    	return new EntityScorcherShot(level(), this, 0, 0, 0);
    }
    public void aiStep() {
        super.aiStep();
        if(level().isClientSide()) {
            if(random.nextInt(24) == 0 && !isSilent()) level().playLocalSound(getX() + .5, getY() + .5, getZ() + .5, SoundEvents.BLAZE_BURN, getSoundSource(), 1F + random.nextFloat(), random.nextFloat() * .7F + .3F, false);
            for(int i = 0; i < 2; ++i) level().addParticle(ParticleTypes.LARGE_SMOKE, getRandomX(.5), getRandomY(), getRandomZ(.5), 0D, 0D, 0D);
        }
    }
    public boolean isSensitiveToWater() {
        return true;
    }
    @Override
    public boolean fireImmune() {
        return true;
    }
    @Override
    public int getMaxSpawnClusterSize() {
    	return 1;
    }
    @Override
    public boolean isMaxGroupSizeReached(int i) {
    	return i > 1;
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.SCORCHER.get();
    }
    @Override
    protected SoundEvent getShootSound() {
    	return SoundEvents.BLAZE_SHOOT;
    }
}