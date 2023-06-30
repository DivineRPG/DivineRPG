package divinerpg.entities.iceika;

import divinerpg.entities.base.EntityPeacefulUntilAttacked;
import divinerpg.registries.SoundRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;

public class EntityFrosty extends EntityPeacefulUntilAttacked {
    public EntityFrosty(EntityType<EntityFrosty> type, Level worldIn) {
        super(type, worldIn);
    }
    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntityDimensions sizeIn) {
        return 1.85F;
    }
    @Override
    public boolean doHurtTarget(Entity entity) {
        boolean attack = super.doHurtTarget(entity);
        if (attack && entity instanceof LivingEntity) {
            if(entity instanceof Player player){
                if(player.isCreative() || player.isSpectator()) {
                    return false;
                }
            }
            ((LivingEntity) entity).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 100, 2, true, false));
            entity.setDeltaMovement(-Mth.sin(this.xRot * (float) Math.PI / 180.0F) * 2.5 * 0.5F, 0.1D,
                    Mth.cos(this.xRot * (float) Math.PI / 180.0F) * 2.5 * 0.5F);
        }
        return attack;
    }
    @Override
    protected SoundEvent getAmbientSound() {
        return SoundRegistry.FROSTY.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundRegistry.FROSTY_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundRegistry.FROSTY_HURT.get();
    }
    @Override
    public float getWalkTargetValue(BlockPos pos, LevelReader reader) {
        return 0.0F;
    }
}