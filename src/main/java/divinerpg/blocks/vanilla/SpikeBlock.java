package divinerpg.blocks.vanilla;

import divinerpg.registries.DamageRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SpikeBlock extends Block {
    private final boolean isHot;
    public SpikeBlock(Properties p, boolean isHot) {
        super(p);
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
                } entity.hurt(level.damageSources().source(DamageRegistry.SPIKE), 8);
            } else entity.hurt(level.damageSources().source(DamageRegistry.SPIKE), 5);
        } super.stepOn(level, pos, state, entity);
    }
}