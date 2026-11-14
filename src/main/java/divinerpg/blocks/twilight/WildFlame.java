package divinerpg.blocks.twilight;

import divinerpg.blocks.base.Fire;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.sounds.SoundEvents.AXE_STRIP;
import static net.minecraft.sounds.SoundSource.BLOCKS;

public class WildFlame extends Fire {
    public WildFlame(Properties p) {super(p, 4);}

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        if(entity instanceof LivingEntity e && !e.hasEffect(MobEffects.RESISTANCE)) {
            level.playSound(null, pos, AXE_STRIP.value(), BLOCKS, 1, .5F);
            e.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 200, 3));
            e.addEffect(new MobEffectInstance(MobEffects.RESISTANCE, 250, 2));
        } super.entityInside(state, level, pos, entity, effectApplier, isPrecise);
    }
}