package divinerpg.blocks.iceika;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.block.RobbinNestBlockEntity;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.*;
import org.jspecify.annotations.Nullable;

public class BlockRobbinNest extends BaseEntityBlock {
    public static final MapCodec<BlockRobbinNest> CODEC = simpleCodec(BlockRobbinNest::new);
    @Override public MapCodec<BlockRobbinNest> codec() {return CODEC;}
    protected static final VoxelShape BASE_SHAPE = Block.box(2, 0, 2, 14, 4, 14);
    public BlockRobbinNest(Properties properties) {super(properties.randomTicks().noOcclusion().mapColor(MapColor.COLOR_BROWN).isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).pushReaction(PushReaction.DESTROY).isRedstoneConductor((state, getter, pos) -> false));}
    @Override public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {return BASE_SHAPE;}
    @Override public RenderShape getRenderShape(BlockState state) {return RenderShape.MODEL;}
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return BlockEntityRegistry.ROBBIN_NEST.get().create(pos, state);}
    @Override public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(state.is(this) && random.nextBoolean() && level.getBlockEntity(pos) instanceof RobbinNestBlockEntity block && block.getItem().is(ItemRegistry.robbin_egg.get())) {
            block.removeItem(0, 1);
            EntityRegistry.ROBBIN.get().spawn(level, pos, EntitySpawnReason.BREEDING);
        }
    }
    @Override
    public boolean hasAnalogOutputSignal(BlockState state) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos, Direction direction) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
    }



    @Override public InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(level.getBlockEntity(pos) instanceof RobbinNestBlockEntity block) {
            if(stack == null || stack.isEmpty()) {
                if(!block.getItem().isEmpty()) {
                    player.setItemInHand(hand, block.getItem());
                    block.setItemSilent(ItemStack.EMPTY);
                    return InteractionResult.SUCCESS;
                } return InteractionResult.FAIL;
            } if(block.getItem().isEmpty()) {
                block.setItemSilent(stack.copy());
                if(!player.isCreative()) player.setItemInHand(hand, ItemStack.EMPTY);
                return InteractionResult.SUCCESS;
            } level.addFreshEntity(new ItemEntity(level, pos.getX() + .5, pos.getY() + .1, pos.getZ() + .5, block.getItem()));
            block.setItemSilent(ItemStack.EMPTY);
            return InteractionResult.SUCCESS;
        } return InteractionResult.PASS;
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack destroyedWith) {
        if(level.getBlockEntity(pos) instanceof RobbinNestBlockEntity block) {
            if(!block.isEmpty()) Containers.dropContents(level, pos, block);
            level.removeBlockEntity(pos);
            level.updateNeighbourForOutputSignal(pos, this);
        }
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
    }

}