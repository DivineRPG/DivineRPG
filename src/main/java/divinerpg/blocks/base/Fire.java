package divinerpg.blocks.base;

import net.minecraft.core.*;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.*;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;

public class Fire extends BaseFireBlock {
    public Fire(Properties properties) {
        super(properties, 8);
    }
    public Fire(Properties properties, float fireDamage) {
        super(properties, fireDamage);
    }
    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        super.entityInside(state, level, pos, entity, effectApplier, isPrecise);
        if(!entity.isAlive()) level.playSound(entity, pos, SoundEvents.GENERIC_EXTINGUISH_FIRE, SoundSource.NEUTRAL, .6F, 1.3F);
    }
    @Override public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        if((level.getGameTime() & 0b11) == 0) level.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, pos.getX() + .5, pos.getY() + .5, pos.getZ() + .5, 0D, .04, 0D);
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState();
    }
    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        BlockPos po = pos.below();
        BlockState st = level.getBlockState(po);
        return !st.isAir() && st.isFaceSturdy(level, po, Direction.UP) ? defaultBlockState() : Blocks.AIR.defaultBlockState();
    }
    @Override
    public boolean canSurvive(BlockState s, LevelReader level, BlockPos pos) {
        BlockPos p = pos.below();
        BlockState state = level.getBlockState(p);
        return !state.isAir() && state.isFaceSturdy(level, p, Direction.UP);
    }
    @Override
    protected boolean canBurn(BlockState state) {
        return !state.isAir();
    }
}