package divinerpg.blocks.vanilla;

import divinerpg.registries.BlockEntityRegistry;
import divinerpg.tiles.bosses.*;
import net.minecraft.core.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;
import net.minecraft.world.phys.shapes.*;

import javax.annotation.*;

public class BlockAyeracoSpawn extends BaseEntityBlock {
    public BlockAyeracoSpawn() {
        super(BlockBehaviour.Properties.of(Material.FIRE).strength(6000000F, 6000000F).noOcclusion().randomTicks());
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
    	return level.isClientSide ? null : createTickerHelper(type, BlockEntityRegistry.AYERACO_SPAWN.get(), TileEntityAyeracoSpawn::serverTick);
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new TileEntityAyeracoSpawn(p_153215_, p_153216_);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_220071_1_, BlockGetter p_220071_2_, BlockPos p_220071_3_, CollisionContext p_220071_4_) {
        return Shapes.empty();
    }

    public RenderShape getRenderShape(BlockState p_149645_1_) {
        return RenderShape.MODEL;
    }

}
