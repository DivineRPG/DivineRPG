package divinerpg.blocks.vanilla;

import com.mojang.serialization.MapCodec;
import divinerpg.block_entities.bosses.AyeracoSpawnBlockEntity;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.phys.shapes.*;

import javax.annotation.Nullable;

public class BlockAyeracoSpawn extends BaseEntityBlock {
    public static final MapCodec<BlockAyeracoSpawn> CODEC = simpleCodec(BlockAyeracoSpawn::new);
    @Override public MapCodec<BlockAyeracoSpawn> codec() {return CODEC;}
    public BlockAyeracoSpawn(Properties properties) {
        super(properties.strength(6000000, 6000000).noOcclusion().randomTicks());
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
    	return level.isClientSide ? null : createTickerHelper(type, BlockEntityRegistry.AYERACO_SPAWN.get(), AyeracoSpawnBlockEntity::serverTick);
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new AyeracoSpawnBlockEntity(p_153215_, p_153216_);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_220071_1_, BlockGetter p_220071_2_, BlockPos p_220071_3_, CollisionContext p_220071_4_) {
        return Shapes.empty();
    }

    public RenderShape getRenderShape(BlockState p_149645_1_) {
        return RenderShape.MODEL;
    }

}
