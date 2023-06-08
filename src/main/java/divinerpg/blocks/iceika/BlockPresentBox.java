package divinerpg.blocks.iceika;

import divinerpg.block_entities.chests.PresentBoxBlockEntity;
import divinerpg.blocks.base.BlockModChest;
import divinerpg.client.containers.PresentBoxContainer;
import divinerpg.registries.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;

import javax.annotation.Nullable;

public class BlockPresentBox extends BlockModChest {

    public BlockPresentBox() {
        super(Properties.of().mapColor(MapColor.COLOR_BLUE).sound(SoundType.WOOD).strength(2.5F), () -> BlockEntityRegistry.PRESENT_BOX.get());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos p_153215_, BlockState p_153216_) {
        return new PresentBoxBlockEntity(p_153215_, p_153216_);
    }

    @Nullable
    public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
        BlockEntity blockEntity = worldIn.getBlockEntity(pos);
        if (blockEntity instanceof PresentBoxBlockEntity) {
            Component itextcomponent = ((Nameable)blockEntity).getDisplayName();
            return new SimpleMenuProvider((id, inventory, player) -> {
                return new PresentBoxContainer(id, inventory, 3);
            }, itextcomponent);
        } else {
            return null;
        }
    }
}
