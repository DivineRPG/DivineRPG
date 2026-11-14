package divinerpg.blocks.iceika;

import divinerpg.registries.*;
import divinerpg.utils.Utils;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.*;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.Difficulty;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.phys.shapes.*;

public class Gravestone extends Block {
    public static final VoxelShape
            SHAPEZ = Shapes.or(Block.box(0, 0, 3, 16, 2, 13), Block.box(0, 2, 5, 16, 15, 11)),
            SHAPEX = Shapes.or(Block.box(3, 0, 0, 13, 2, 16), Block.box(5, 2, 0, 11, 15, 16));
    public Gravestone(Properties p) {
        super(p);
        registerDefaultState(getStateDefinition().any().setValue(HorizontalDirectionalBlock.FACING, Direction.NORTH));
    }
    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(HorizontalDirectionalBlock.FACING);
        return direction.getAxis() == Direction.Axis.X ? SHAPEX : SHAPEZ;
    }
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, context.getHorizontalDirection().getOpposite());
    }
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HorizontalDirectionalBlock.FACING);
    }

    @Override
    public void playerDestroy(ServerLevel level, ServerPlayer player, BlockPos pos, BlockState state, @org.jspecify.annotations.Nullable BlockEntity blockEntity, ItemStack destroyedWith) {
        super.playerDestroy(level, player, pos, state, blockEntity, destroyedWith);
        if(level instanceof ServerLevel s && !EnchantmentHelper.hasTag(destroyedWith, EnchantmentTags.PREVENTS_BEE_SPAWNS_WHEN_MINING)) {
            if(s.getDifficulty() != Difficulty.PEACEFUL) {
                var type = EntityRegistry.FROZEN_FLESH.get();
                Utils.summonEntityAt(s, type, pos.offset(3, 0, 0), player);
                Utils.summonEntityAt(s, type, pos.offset(1, 0, 2), player);
                Utils.summonEntityAt(s, type, pos.offset(-1, 0, 2), player);
                Utils.summonEntityAt(s, type, pos.offset(-3, 0, 0), player);
                Utils.summonEntityAt(s, type, pos.offset(1, 0, -2), player);
                Utils.summonEntityAt(s, type, pos.offset(-1, 0, -2), player);
            } level.playSound(null, pos, SoundRegistry.FREEZE.get(), SoundSource.BLOCKS, 1F, 1F);
            level.playSound(null, pos, SoundEvents.SCULK_SHRIEKER_SHRIEK, SoundSource.BLOCKS, .6F, 1.5F);
        }
    }
}