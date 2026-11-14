package divinerpg.blocks.vethea;

import divinerpg.registries.DamageRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.InsideBlockEffectApplier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class Acid extends Block {
    public Acid(Properties p) {super(p);}
    @Override public VoxelShape getShape(BlockState state, BlockGetter source, BlockPos pos, CollisionContext context) {return Block.box(0, 0, 0, 16, 2, 16);}
    @Override
    protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
        return state.canSurvive(level, pos) ? state : Blocks.AIR.defaultBlockState();
    }
    @Override public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {if(random.nextInt(5) == 0) worldIn.removeBlock(pos, true);}

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity, InsideBlockEffectApplier effectApplier, boolean isPrecise) {
        if(entity instanceof Player && entity.onGround()) entity.hurt(level.damageSources().source(DamageRegistry.ACID), 3);
    }
    @Override public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState blockstate = level.getBlockState(pos.below());
        return blockstate.is(BlockTags.SUPPORT_OVERRIDE_SNOW_LAYER) || Block.isFaceFull(blockstate.getCollisionShape(level, pos.below()), Direction.UP);
    }
}