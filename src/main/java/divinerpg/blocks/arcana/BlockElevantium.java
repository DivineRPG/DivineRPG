package divinerpg.blocks.arcana;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.shapes.*;

import javax.annotation.Nullable;

import static divinerpg.registries.SoundRegistry.CONSTRUCTOR_PUNCH;
import static net.minecraft.sounds.SoundSource.BLOCKS;
import static net.minecraft.world.level.block.Blocks.DIAMOND_BLOCK;
import static net.minecraft.world.level.material.MapColor.COLOR_LIGHT_BLUE;
import static net.minecraft.world.level.material.PushReaction.DESTROY;

public class BlockElevantium extends BlockMod {
    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    protected static final VoxelShape ELEVANTIUM = Shapes.or(box(1, 0, 1, 15, 1, 15),
                                                             box(4.5, 1, 4.5, 11.5, 2, 11.5));
    public BlockElevantium() {
        super(Properties.ofFullCopy(DIAMOND_BLOCK).mapColor(COLOR_LIGHT_BLUE).pushReaction(DESTROY));
        registerDefaultState(stateDefinition.any().setValue(POWERED, false));
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(POWERED);}
    @Override public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        int signal = level.getBestNeighborSignal(pos);
        boolean canJump = !level.getBlockCollisions(entity, entity.getBoundingBox().expandTowards(0, 2, 0)).iterator().hasNext();
        if(signal > 0 && !entity.isSuppressingBounce() && canJump) {
            //TODO: holding the jump button or pressing the shift down at the right timing causes the sound to play, but ignores the launch (seems like the reason is that setDeltaMovement doesn't apply immediately)
            entity.push(0, signal * .25, 0);
            level.playSound(null, pos, CONSTRUCTOR_PUNCH.get(), BLOCKS, .75F, .9F);
        }
    }
    @Override protected void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if(!level.isClientSide) {
            boolean flag = state.getValue(POWERED);
            if(flag != level.hasNeighborSignal(pos)) {
                if(flag) level.scheduleTick(pos, this, 4);
                else level.setBlock(pos, state.cycle(POWERED), 2);
            }
        }
    }
    @Override protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(state.getValue(POWERED) && !level.hasNeighborSignal(pos)) level.setBlock(pos, state.cycle(POWERED), 2);
    }
    @Override public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {return ELEVANTIUM;}
    @Override public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return Shapes.create(ELEVANTIUM.bounds().inflate(.0625, .125, .0625));
    }
    @Override public boolean canConnectRedstone(BlockState state, BlockGetter level, BlockPos pos, @Nullable Direction direction) {return true;}
}