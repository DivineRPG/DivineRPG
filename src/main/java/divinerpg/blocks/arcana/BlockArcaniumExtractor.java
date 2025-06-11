package divinerpg.blocks.arcana;

import divinerpg.block_entities.furnace.ArcaniumExtractorBlockEntity;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.*;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class BlockArcaniumExtractor extends FurnaceBlock {

    private static VoxelShape CUSTOM_SHAPE = null;


    public BlockArcaniumExtractor() {
        super(Properties.of()
                .mapColor(MapColor.COLOR_LIGHT_BLUE)
                .strength(-1F, 3600000F)
                .instrument(NoteBlockInstrument.BASEDRUM)
                .noOcclusion()
                .dynamicShape()
        );


        List<VoxelShape> parts = new ArrayList<>();

        parts.add(Shapes.box(1 / 16F, 0, 1 / 16F, 15 / 16F, 2 / 16F, 15 / 16F));
        parts.add(Shapes.box(1 / 16F, 10 / 16F, 1 / 16F, 15 / 16F, 12 / 16F, 15 / 16F));
        parts.add(Shapes.box(1 / 16F, 20 / 16F, 1 / 16F, 15 / 16F, 22 / 16F, 15 / 16F));

        parts.add(Shapes.box(11 / 16F, 12 / 16F, 11 / 16F, 13 / 16F, 20 / 16F, 13 / 16F));
        parts.add(Shapes.box(11 / 16F, 12 / 16F, 3 / 16F, 13 / 16F, 20 / 16F, 5 / 16F));
        parts.add(Shapes.box(3 / 16F, 12 / 16F, 3 / 16F, 5 / 16F, 20 / 16F, 5 / 16F));
        parts.add(Shapes.box(3 / 16F, 12 / 16F, 11 / 16F, 5 / 16F, 20 / 16F, 13 / 16F));
        parts.add(Shapes.box(10 / 16F, 2 / 16F, 10 / 16F, 12 / 16F, 10 / 16F, 12 / 16F));
        parts.add(Shapes.box(10 / 16F, 2 / 16F, 4 / 16F, 12 / 16F, 10 / 16F, 6 / 16F));
        parts.add(Shapes.box(4 / 16F, 2 / 16F, 4 / 16F, 6 / 16F, 10 / 16F, 6 / 16F));
        parts.add(Shapes.box(4 / 16F, 2 / 16F, 10 / 16F, 6 / 16F, 10 / 16F, 12 / 16F));
        CUSTOM_SHAPE = parts.stream().reduce(Shapes::or).orElse(Shapes.block());
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return CUSTOM_SHAPE;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @Override
    protected void openContainer(Level world, BlockPos pos, Player player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof ArcaniumExtractorBlockEntity) {
            player.openMenu((MenuProvider) blockEntity);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.ARCANIUM_EXTRACTOR.get().create(pos, state);
    }

    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ArcaniumExtractorBlockEntity extractor) {
                Containers.dropContents(world, pos, extractor);
                extractor.getRecipesToAwardAndPopExperience((ServerLevel) world, Vec3.atCenterOf(pos));
                world.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, world, pos, newState, isMoving);
        }
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return createFurnaceTicker(type, level);
    }

    @Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createFurnaceTicker(BlockEntityType<T> blockEntityType, Level level) {
        return level.isClientSide ? null : createTickerHelper(blockEntityType, BlockEntityRegistry.ARCANIUM_EXTRACTOR.get(), ArcaniumExtractorBlockEntity::serverTick);
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
    }
}
