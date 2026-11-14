package divinerpg.blocks.iceika;

import divinerpg.blocks.base.Fire;
import net.minecraft.core.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.*;

import static divinerpg.registries.SoundRegistry.FREEZE;
import static divinerpg.registries.TagRegistry.BASE_BLOCKS_ICY_FIRE;
import static net.minecraft.sounds.SoundSource.BLOCKS;

public class IcyFire extends Fire {
    public IcyFire(BlockBehaviour.Properties properties) {super(properties, 1);}
    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        if(!entity.isAlive()) return;
        if(entity.isOnFire()) entity.extinguishFire();
        if(entity.canFreeze() && !entity.isInLava()) {
            entity.setTicksFrozen(entity.getTicksFrozen() + 4);
            if(entity.tickCount % 15 == 0) {
                entity.hurt(level.damageSources().freeze(), 1);
                if(!entity.isAlive()) level.playSound(null, pos, FREEZE.get(), BLOCKS, .8F, 1.5F);
            }
        }
    }
    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        return canBurn(level.getBlockState(pos.below())) ? defaultBlockState() : Blocks.AIR.defaultBlockState();
    }
    @Override public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos posBelow = pos.below();
        BlockState stateBelow = level.getBlockState(posBelow);
        return canBurn(stateBelow) && !stateBelow.isAir() && stateBelow.isFaceSturdy(level, posBelow, Direction.UP);
    }
    @Override protected boolean canBurn(BlockState state) {return state.is(BASE_BLOCKS_ICY_FIRE);}
}