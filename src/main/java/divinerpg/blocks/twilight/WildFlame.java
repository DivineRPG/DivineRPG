package divinerpg.blocks.twilight;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class WildFlame extends TwilightFire {
    public WildFlame() {
        super(4F);
    }
    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(entity instanceof LivingEntity e && !e.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
            level.playSound(null, pos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1F, .5F);
            e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 3));
            e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 250, 2));
        } super.entityInside(state, level, pos, entity);
    }
}