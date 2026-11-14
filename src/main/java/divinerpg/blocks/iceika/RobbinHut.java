package divinerpg.blocks.iceika;

import divinerpg.block_entities.block.RobbinHutBlockEntity;
import divinerpg.registries.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.*;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.storage.*;
import net.minecraft.world.phys.shapes.*;

public class RobbinHut extends BaseEntityBlock {
    protected static final VoxelShape BASE_SHAPE = box(2, 0, 2, 14, 16, 14);
    public RobbinHut(Properties properties) {
        super(properties);}
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return BASE_SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockPos spawnPos = pos.offset(state.getValue(HorizontalDirectionalBlock.FACING).getUnitVec3i());

        if (level.getBlockEntity(pos) instanceof RobbinHutBlockEntity block && !(block.robbin1 == null && block.robbin2 == null) && level.getBlockState(spawnPos).isAir()) {
            if (block.robbin2 == null) {
                if (block.robbin1 != null) {
                    ValueInput input = TagValueInput.create(ProblemReporter.DISCARDING, level.registryAccess(), block.robbin1);
                    EntityRegistry.ROBBIN.get().spawn(level, (en) -> en.load(input), spawnPos, EntitySpawnReason.DISPENSER, true, true);
                    block.robbin1 = null;
                }
            } else {
                ValueInput input = TagValueInput.create(ProblemReporter.DISCARDING, level.registryAccess(), block.robbin2);
                var entity = EntityRegistry.ROBBIN.get().spawn(level, (en) -> en.load(input), spawnPos, EntitySpawnReason.DISPENSER, true, true);
                if (entity != null) {
                    entity.wantsNest = block.robbin1 != null;
                }
                block.robbin2 = null;
            }
        }
    }

    public static boolean hasSpace(ServerLevel level, BlockPos pos) {
        return level.getBlockEntity(pos) instanceof RobbinHutBlockEntity block && (block.robbin1 == null || block.robbin2 == null);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.ROBBIN_HUT.get().create(pos, state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HorizontalDirectionalBlock.FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState().setValue(HorizontalDirectionalBlock.FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rot) {
        return state.setValue(HorizontalDirectionalBlock.FACING, rot.rotate(state.getValue(HorizontalDirectionalBlock.FACING)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState state, Mirror mir) {
        return state.rotate(mir.getRotation(state.getValue(HorizontalDirectionalBlock.FACING)));
    }
}