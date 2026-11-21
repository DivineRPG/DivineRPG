package divinerpg.blocks.twilight;

import divinerpg.block_entities.chest.EdenChestBlockEntity;
import divinerpg.blocks.base.ModChest;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class EdenChest extends ModChest {
    public EdenChest(Properties p) {
        super(p, BlockEntityRegistry.EDEN_CHEST::get);
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new EdenChestBlockEntity(pos, state);
    }
    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }
}