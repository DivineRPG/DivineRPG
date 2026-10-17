package divinerpg.blocks.arcana;

import divinerpg.block_entities.furnace.ArcaniumExtractorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

import static divinerpg.registries.BlockEntityRegistry.ARCANIUM_EXTRACTOR;
import static net.minecraft.world.level.material.MapColor.COLOR_LIGHT_BLUE;

public class BlockArcaniumExtractor extends AbstractFurnaceBlock {

    private static final VoxelShape CUSTOM_SHAPE;

    static {
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

    public BlockArcaniumExtractor(BlockBehaviour.Properties properties) {
        super(properties);
    }

    public BlockArcaniumExtractor() {
        this(BlockBehaviour.Properties.of().mapColor(COLOR_LIGHT_BLUE).strength(-1.0F, 3600000.0F).instrument(NoteBlockInstrument.BASEDRUM).noLootTable().noOcclusion().dynamicShape());
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return CUSTOM_SHAPE;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected void openContainer(Level level, BlockPos pos, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof ArcaniumExtractorBlockEntity) {
            player.openMenu((MenuProvider) blockEntity);
        }
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ArcaniumExtractorBlockEntity(pos, state);
    }

    @Override
    protected void affectNeighborsAfterRemoval(BlockState state, ServerLevel level, BlockPos pos, boolean isMoving) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof ArcaniumExtractorBlockEntity extractor) {
            Containers.dropContents(level, pos, extractor);
            extractor.getRecipesToAwardAndPopExperience(level, Vec3.atCenterOf(pos));
            level.updateNeighbourForOutputSignal(pos, this);
        }
        super.affectNeighborsAfterRemoval(state, level, pos, isMoving);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (level.isClientSide()) {
            return null;
        }
        return createTickerHelper(type, ARCANIUM_EXTRACTOR.get(), (lvl, pos, st, blockEntity) -> ArcaniumExtractorBlockEntity.serverTick(lvl.getServer().getLevel(lvl.dimension()), pos, st, blockEntity));
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {}
}