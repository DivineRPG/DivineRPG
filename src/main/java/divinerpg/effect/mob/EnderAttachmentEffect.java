package divinerpg.effect.mob;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantenousMobEffect;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.portal.DimensionTransition;
import org.jetbrains.annotations.Nullable;

import static net.minecraft.sounds.SoundEvents.PLAYER_TELEPORT;
import static net.minecraft.world.effect.MobEffectCategory.NEUTRAL;

public class EnderAttachmentEffect extends InstantenousMobEffect {
    public EnderAttachmentEffect() {super(NEUTRAL, 10494192);}
    @Override public void applyInstantenousEffect(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity livingEntity, int amplifier, double health) {
       if(source != null && indirectSource != null && !source.level().isClientSide) source.changeDimension(new DimensionTransition((ServerLevel)indirectSource.level(), indirectSource.position(), source.getDeltaMovement(), source.getYRot(), source.getXRot(), false, (entity) -> entity.playSound(PLAYER_TELEPORT)));
    }
    public void hitBlock(@Nullable Entity source, @Nullable Entity indirectSource) {
        if(source != null && indirectSource != null && !source.level().isClientSide) source.changeDimension(new DimensionTransition((ServerLevel)indirectSource.level(), indirectSource.position(), source.getDeltaMovement(), source.getYRot(), source.getXRot(), false, (entity) -> entity.playSound(PLAYER_TELEPORT)));
    }
    @Override public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return true;}
}