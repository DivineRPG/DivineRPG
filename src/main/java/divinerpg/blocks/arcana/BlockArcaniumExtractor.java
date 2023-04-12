package divinerpg.blocks.arcana;

import divinerpg.registries.BlockEntityRegistry;
import divinerpg.block_entities.furnace.*;
import net.minecraft.core.*;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.*;
import net.minecraft.world.phys.shapes.*;

import javax.annotation.*;

public class BlockArcaniumExtractor extends FurnaceBlock {
    public static final VoxelShape BLOCK_AABB = Shapes.create(new AABB(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F));
    public BlockArcaniumExtractor() {
        super(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE).strength(60000000F).noOcclusion());
    }
    @Override
    public VoxelShape getCollisionShape(BlockState p_220071_1_, BlockGetter p_220071_2_, BlockPos p_220071_3_, CollisionContext p_220071_4_) {
        return BLOCK_AABB;
    }
    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }
    @Override
    protected void openContainer(Level world, BlockPos pos, Player player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof ArcaniumExtractorBlockEntity) player.openMenu((MenuProvider)blockEntity);
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return BlockEntityRegistry.ARCANIUM_EXTRACTOR.get().create(pos, state);
    }
    @Override
    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState state1, boolean b) {
        if (!state.is(state1.getBlock())) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ArcaniumExtractorBlockEntity) {
                Containers.dropContents(world, pos, (ArcaniumExtractorBlockEntity)blockEntity);
                ((ArcaniumExtractorBlockEntity)blockEntity).getRecipesToAwardAndPopExperience((ServerLevel) world, Vec3.atCenterOf(pos));
                world.updateNeighbourForOutputSignal(pos, this);
            }
            super.onRemove(state, world, pos, state1, b);
        }
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
    	return createFurnaceTicker(type, level);
    }
	@Nullable
    protected static <T extends BlockEntity> BlockEntityTicker<T> createFurnaceTicker(BlockEntityType<T> p_151989_, Level p_151988_) {
       return p_151988_.isClientSide ? null : createTickerHelper(p_151989_, BlockEntityRegistry.ARCANIUM_EXTRACTOR.get(), ArcaniumExtractorBlockEntity::serverTick);
    }
	@Override public void animateTick(BlockState p_221253_, Level p_221254_, BlockPos p_221255_, RandomSource p_221256_) {}
}