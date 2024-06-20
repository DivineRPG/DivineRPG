package divinerpg.entities.vanilla.overworld;

import divinerpg.entities.base.EntityPeacefulUntilAttacked;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.*;

public class EntityCrab extends EntityPeacefulUntilAttacked {

    public static boolean crabSpawnRule(EntityType<? extends Mob> type, LevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource random) {
    	return Mob.checkMobSpawnRules(type, world, reason, pos, random) && world.canSeeSky(pos);
    }
    public EntityCrab(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 0.4375F;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.CRAB.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.CRAB_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.CRAB_HURT.get();
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
        return 0.0F;
    }

    @Override
    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }
}
