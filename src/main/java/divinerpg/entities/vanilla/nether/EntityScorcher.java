package divinerpg.entities.vanilla.nether;

import divinerpg.entities.base.EntityDivineFireballMob;
import divinerpg.entities.projectile.fireball.EntityScorcherShot;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathType;

public class EntityScorcher extends EntityDivineFireballMob {
    public EntityScorcher(EntityType<? extends EntityScorcher> type, Level world) {
        super(type, world);
        setPathfindingMalus(PathType.LAVA, 8);
        setPathfindingMalus(PathType.DANGER_FIRE, 0);
        setPathfindingMalus(PathType.DAMAGE_FIRE, 0);
        xpReward = XP_REWARD_LARGE;
    }
    @Override protected void registerGoals() {
        goalSelector.addGoal(1, new RangedAttackGoal(this, getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue(), 8, (float)getAttribute(Attributes.FOLLOW_RANGE).getBaseValue()));
    	super.registerGoals();
    }
    @Override protected Fireball getProjectile() {return new EntityScorcherShot(level(), this, 0, 0, 0);}
    @Override public void aiStep() {
        super.aiStep();
        if(level().isClientSide) {
            if(random.nextInt(24) == 0 && !isSilent()) level().playLocalSound(getX() + .5, getY() + .5, getZ() + .5, SoundEvents.BLAZE_BURN, getSoundSource(), 1 + random.nextFloat(), random.nextFloat() * .7F + .3F, false);
            for(int i = 0; i < 2; ++i) level().addParticle(ParticleTypes.LARGE_SMOKE, getRandomX(.5), getRandomY(), getRandomZ(.5), 0, 0, 0);
        }
    }
    @Override public boolean isSensitiveToWater() {return true;}
    @Override public boolean fireImmune() {return true;}
    @Override public int getMaxSpawnClusterSize() {return 1;}
    @Override public boolean isMaxGroupSizeReached(int i) {return i > 1;}
    @Override protected SoundEvent getAmbientSound() {return SoundRegistry.SCORCHER.get();}
    @Override protected SoundEvent getShootSound() {return SoundEvents.BLAZE_SHOOT;}
}