package divinerpg.blocks.vanilla;


import divinerpg.block_entities.chest.BoneChestBlockEntity;
import divinerpg.blocks.base.ModChest;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class BoneChest extends ModChest {
    public BoneChest(Properties p) {
        super(p, BlockEntityRegistry.BONE_CHEST::get);
    }
    @Nullable @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new BoneChestBlockEntity(p_153215_, p_153216_);
    }
    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }
}