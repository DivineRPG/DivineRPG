package divinerpg.blocks.twilight;

import divinerpg.blocks.base.PortalBlock;
import divinerpg.registries.BlockRegistry;
import divinerpg.registries.LevelRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import static net.minecraft.sounds.SoundEvents.AXE_STRIP;
import static net.minecraft.sounds.SoundSource.BLOCKS;

public class WildFlame extends PortalFire {
    public WildFlame() {super(4);}
    @Override public PortalBlock getPortalBlock(Level level, BlockState frame, byte timeOfDay) {
        return frame.is(BlockRegistry.wildwoodBlock) && (timeOfDay == 1 || (timeOfDay == 0 && level.dimension() == LevelRegistry.WILDWOOD)) ? (PortalBlock)BlockRegistry.wildwoodPortal.get() : null;
    }
    @Override public Block getRift(byte timeOfDay) {
        return timeOfDay == 1 ? BlockRegistry.wildwoodRift.get() : null;
    }
    @Override protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if(entity instanceof LivingEntity e && !e.hasEffect(MobEffects.DAMAGE_RESISTANCE)) {
            level.playSound(null, pos, AXE_STRIP, BLOCKS, 1, .5F);
            e.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200, 3));
            e.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 250, 2));
        } super.entityInside(state, level, pos, entity);
    }
}