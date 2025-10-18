package divinerpg.blocks.vanilla;

import divinerpg.blocks.base.BlockMod;
import divinerpg.registries.DamageRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import static net.minecraft.world.level.block.SoundType.METAL;

public class BlockSpike extends BlockMod {
    private final boolean isHot;
    public BlockSpike(boolean isHot, MapColor color) {
        super(Properties.of().mapColor(color).strength(5, 6).requiresCorrectToolForDrops().sound(METAL));
        this.isHot = isHot;
    }
    @Override public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity){
        if(!entity.isSteppingCarefully() && entity instanceof LivingEntity) {
            if(isHot) {
                if(!entity.fireImmune()) {
                    //TODO: for some reason the fire ticks thingy does not work
//                    entity.setRemainingFireTicks(entity.getRemainingFireTicks() + 1);
//                    if(entity.getRemainingFireTicks() == 0)
                      entity.igniteForSeconds(10);
                } entity.hurt(level.damageSources().source(DamageRegistry.SPIKE.getKey()), 8);
            } else entity.hurt(level.damageSources().source(DamageRegistry.SPIKE.getKey()), 5);
        } super.stepOn(level, pos, state, entity);
    }
}