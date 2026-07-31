package divinerpg.effect.mob;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.InstantaneousMobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import javax.annotation.Nullable;

import static net.minecraft.world.effect.MobEffectCategory.NEUTRAL;

public class EnderAttachmentEffect extends InstantaneousMobEffect {
    public EnderAttachmentEffect() {super(NEUTRAL, 10494192);}

    @Override
    public void applyInstantaneousEffect(ServerLevel level, @org.jspecify.annotations.Nullable Entity source, @org.jspecify.annotations.Nullable Entity owner, LivingEntity mob, int amplification, double scale) {
//        if(source != null && indirectSource != null && !source.level().isClientSide()) source.changeDimension(new DimensionTransition((ServerLevel)indirectSource.level(), indirectSource.position(), source.getDeltaMovement(), source.getYRot(), source.getXRot(), false, (entity) -> entity.playSound(PLAYER_TELEPORT)));
    }
    public void hitBlock(@Nullable Entity source, @Nullable Entity indirectSource) {
//        if(source != null && indirectSource != null && !source.level().isClientSide()) source.changeDimension(new DimensionTransition((ServerLevel)indirectSource.level(), indirectSource.position(), source.getDeltaMovement(), source.getYRot(), source.getXRot(), false, (entity) -> entity.playSound(PLAYER_TELEPORT)));
    }
    @Override public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return true;}
}