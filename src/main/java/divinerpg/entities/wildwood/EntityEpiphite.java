package divinerpg.entities.wildwood;

import divinerpg.entities.base.EntityPeacefulUntilAttacked;
import divinerpg.registries.*;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;

public class EntityEpiphite extends EntityPeacefulUntilAttacked {
    public EntityEpiphite(EntityType<? extends Monster> type, Level worldIn) {
        super(type, worldIn);
        xpReward=40;
    }

    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
    	return 1.1F;
    }

    @Override
    public boolean fireImmune() {
        return true;
    }
    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(source == DamageSource.LIGHTNING_BOLT) return false;
        return super.hurt(source, amount);
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        if(random.nextInt(5) == 0) {
            LightningBolt bolt = new LightningBolt(EntityType.LIGHTNING_BOLT, level);
            bolt.setPos(entity.getX(), entity.getY(), entity.getZ());
            if (level.isClientSide) {
                level.addFreshEntity(bolt);
            }
        }
        return super.doHurtTarget(entity);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.GROWL.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.GROWL_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.GROWL_HURT.get();
    }

    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader world) {
        return 0.0F;
    }
}