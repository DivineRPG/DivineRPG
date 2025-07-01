package divinerpg.blocks.vanilla;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.bosses.AyeracoSpawnBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.*;

import javax.annotation.Nullable;

import static divinerpg.registries.BlockEntityRegistry.AYERACO_SPAWN;
import static net.minecraft.world.level.block.RenderShape.MODEL;

public class BlockAyeracoSpawn extends BaseEntityBlock {
    public static final MapCodec<BlockAyeracoSpawn> CODEC = simpleCodec(BlockAyeracoSpawn::new);
    @Override public MapCodec<BlockAyeracoSpawn> codec() {return CODEC;}
    public BlockAyeracoSpawn(Properties properties) {super(properties.strength(-1, 3600000).noLootTable().noOcclusion().randomTicks());}
    @Override public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
    	return level.isClientSide ? null : createTickerHelper(type, AYERACO_SPAWN.get(), AyeracoSpawnBlockEntity::serverTick);
    }
    @Nullable
    @Override public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {return new AyeracoSpawnBlockEntity(pos, state);}
    @Override public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {return Shapes.empty();}
    @Override public RenderShape getRenderShape(BlockState state) {return MODEL;}
}