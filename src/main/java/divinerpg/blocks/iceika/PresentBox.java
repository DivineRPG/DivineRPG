package divinerpg.blocks.iceika;

import divinerpg.block_entities.chest.PresentBoxBlockEntity;
import divinerpg.blocks.base.ModChest;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class PresentBox extends ModChest {
    public PresentBox(Properties p) {
        super(p, BlockEntityRegistry.PRESENT_BOX::get);
    }
    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new PresentBoxBlockEntity(p_153215_, p_153216_);
    }
}