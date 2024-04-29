package divinerpg.blocks.vethea;

import divinerpg.blocks.base.BlockMod;
import divinerpg.util.DamageSources;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.*;

public class BlockAcid extends BlockMod {
    public BlockAcid() {super(Block.Properties.copy(Blocks.SNOW).noCollission());}
    @Override public VoxelShape getShape(BlockState state, BlockGetter source, BlockPos pos, CollisionContext context) {return Block.box(0, 0, 0, 16, 2, 16);}
    @Override public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor level, BlockPos pos, BlockPos pos1) {return !state.canSurvive(level, pos) ? Blocks.AIR.defaultBlockState() : state;}
    @Override public void randomTick(BlockState state, ServerLevel worldIn, BlockPos pos, RandomSource random) {if(random.nextInt(5) == 0) worldIn.removeBlock(pos, true);}
    @Override public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {if(entity instanceof Player && entity.onGround()) entity.hurt(DamageSources.source(level, DamageSources.ACID), 3);}
    @Override public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockState blockstate = level.getBlockState(pos.below());
        if(blockstate.is(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON)) return true;
        return Block.isFaceFull(blockstate.getCollisionShape(level, pos.below()), Direction.UP);
    }
}