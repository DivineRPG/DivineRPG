package divinerpg.blocks.iceika;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.block.RobbinHutBlockEntity;
import divinerpg.registries.BlockEntityRegistry;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ProblemReporter;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class BlockRobbinHut extends BaseEntityBlock {
    public static final MapCodec<BlockRobbinHut> CODEC = simpleCodec(BlockRobbinHut::new);
    protected static final VoxelShape BASE_SHAPE = box(2, 0, 2, 14, 16, 14);

    @Override
    public MapCodec<BlockRobbinHut> codec() {
        return CODEC;
    }

    public BlockRobbinHut(Properties properties) {
        super(properties.randomTicks().mapColor(MapColor.COLOR_LIGHT_GRAY).isSuffocating((state, getter, pos) -> false).isViewBlocking((state, getter, pos) -> false).isRedstoneConductor((state, getter, pos) -> false));
    }

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