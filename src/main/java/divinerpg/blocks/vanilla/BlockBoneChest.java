package divinerpg.blocks.vanilla;

import divinerpg.block_entities.chests.BoneChestBlockEntity;
import divinerpg.blocks.base.BlockModChest;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import javax.annotation.Nullable;

public class BlockBoneChest extends BlockModChest {

    public BlockBoneChest() {
        super(Properties.of().mapColor(MapColor.WOOL).requiresCorrectToolForDrops().strength(2.5F).noOcclusion().sound(SoundType.BONE_BLOCK), () -> BlockEntityRegistry.BONE_CHEST.get());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new BoneChestBlockEntity(p_153215_, p_153216_);
    }
}
