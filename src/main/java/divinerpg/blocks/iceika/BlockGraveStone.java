package divinerpg.blocks.iceika;

import divinerpg.blocks.base.BlockMod;
import divinerpg.registries.*;
import divinerpg.world.placement.Surface;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.*;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.shapes.*;
import org.jetbrains.annotations.Nullable;

public class BlockGraveStone extends BlockMod {
    public static final VoxelShape
        SHAPEZ = Shapes.or(Block.box(0, 0, 3, 16, 2, 13), Block.box(0, 2, 5, 16, 15, 11)),
        SHAPEX = Shapes.or(Block.box(3, 0, 0, 13, 2, 16), Block.box(5, 2, 0, 11, 15, 16));
    public BlockGraveStone() {
        super(Properties.of().strength(2.0F, 6.0F).sound(SoundType.STONE).mapColor(MapColor.ICE));
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
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.playerDestroy(level, player, pos, state, blockEntity, tool);
        if(level instanceof ServerLevel s && !EnchantmentHelper.hasTag(tool, EnchantmentTags.PREVENTS_BEE_SPAWNS_WHEN_MINING)) {
            if(s.getDifficulty() != Difficulty.PEACEFUL) {
                spawnFrozenFlesh(s, player, pos.offset(3, 0, 0));
                spawnFrozenFlesh(s, player, pos.offset(1, 0, 2));
                spawnFrozenFlesh(s, player, pos.offset(-1, 0, 2));
                spawnFrozenFlesh(s, player, pos.offset(-3, 0, 0));
                spawnFrozenFlesh(s, player, pos.offset(1, 0, -2));
                spawnFrozenFlesh(s, player, pos.offset(-1, 0, -2));
            } level.playSound(null, pos, SoundRegistry.FREEZE.get(), SoundSource.BLOCKS, 1F, 1F);
            level.playSound(null, pos, SoundEvents.SCULK_SHRIEKER_SHRIEK, SoundSource.BLOCKS, .6F, 1.5F);
        }
    }
    static void spawnFrozenFlesh(ServerLevel level, Player player, BlockPos pos) {
        int y = Surface.getSurface(Surface.Surface_Type.HIGHEST_GROUND, Surface.Mode.FULL, pos.getY() - 7, pos.getY() + 7, 0, level, player.getRandom(), pos.getX(), pos.getY());
        EntityRegistry.FROZEN_FLESH.get().spawn(level, (e) -> e.setPersistentAngerTarget(player.getUUID()), new BlockPos(pos.getX(), y, pos.getZ()), MobSpawnType.TRIGGERED, true, false);
    }
}
