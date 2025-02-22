package divinerpg.effect.mob;

import net.minecraft.server.level.*;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.portal.DimensionTransition;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class EnderAttachmentEffect extends InstantenousMobEffect {
    public EnderAttachmentEffect() {super(MobEffectCategory.NEUTRAL, 10494192);}
    @Override
    public void applyInstantenousEffect(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity livingEntity, int amplifier, double health) {
       if(source != null && indirectSource != null && !source.level().isClientSide()) source.changeDimension(new DimensionTransition((ServerLevel)indirectSource.level(), indirectSource.position(), source.getDeltaMovement(), source.getYRot(), source.getXRot(), false, (entity) -> {entity.playSound(SoundEvents.PLAYER_TELEPORT);}));
    }
    public void hitBlock(@Nullable Entity source, @Nullable Entity indirectSource) {
        if(source != null && indirectSource != null && !source.level().isClientSide()) source.changeDimension(new DimensionTransition((ServerLevel)indirectSource.level(), indirectSource.position(), source.getDeltaMovement(), source.getYRot(), source.getXRot(), false, (entity) -> {entity.playSound(SoundEvents.PLAYER_TELEPORT);}));
    }
    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {return true;}
}