package divinerpg.blocks.base;

import divinerpg.block_entities.bosses.StatueBlockEntity;
import net.minecraft.core.*;
import net.minecraft.sounds.*;
import net.minecraft.world.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.*;
import javax.annotation.Nullable;
import java.util.function.Supplier;

public class BlockStatue extends BlockMod implements EntityBlock {
    public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
    private final Supplier<SoundEvent> statueSound;
    public BlockStatue(Supplier<SoundEvent> soundIn) {
        super(Properties.of().strength(2, 6).noOcclusion().requiresCorrectToolForDrops());
        statueSound = soundIn;
    }
    @Override public boolean skipRendering(BlockState state, BlockState state1, Direction dir) {return true;}
    @Nullable
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return new StatueBlockEntity(pos, state);}
    @Override public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }
    @Override protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {builder.add(FACING);}
    @Override public void setPlacedBy(Level world, BlockPos pos, BlockState state, @Nullable LivingEntity player, ItemStack stack) {
        world.setBlock(pos, state.setValue(FACING, player.getDirection().getOpposite()), 2);
    }
    @Override public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult trace) {
        if((player.isCrouching() && !player.getItemInHand(hand).isEmpty()) || statueSound == null) return InteractionResult.PASS;
        world.playSound(player, pos, statueSound.get(), SoundSource.BLOCKS, 3, 1);
        return InteractionResult.SUCCESS;
    }
    @Override public BlockState mirror(BlockState state, Mirror mirror) {return state.setValue(FACING, mirror.mirror(state.getValue(FACING)));}
    @Override public BlockState rotate(BlockState state, Rotation rot) {return state.setValue(FACING, rot.rotate(state.getValue(FACING)));}
    @Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return Shapes.create(new AABB(.2, 0, .2, .8, 1, .8));
    }
}