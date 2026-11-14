package divinerpg.blocks.vanilla;

import divinerpg.block_entities.block.AyeracoSpawnBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

import static divinerpg.registries.BlockEntityRegistry.AYERACO_SPAWN;
import static net.minecraft.world.level.block.RenderShape.MODEL;

public class AyeracoSpawn extends BaseEntityBlock {
    public AyeracoSpawn(Properties properties) {super(properties);}
    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide() ? null : createTickerHelper(type, AYERACO_SPAWN.get(), AyeracoSpawnBlockEntity::serverTick);
    }
    @Nullable
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return new AyeracoSpawnBlockEntity(pos, state);}
    @Override public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {return Shapes.empty();}
    @Override public RenderShape getRenderShape(BlockState state) {return MODEL;}
}