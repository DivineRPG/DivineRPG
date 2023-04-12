package divinerpg.blocks.iceika;

import divinerpg.blocks.base.*;
import divinerpg.client.containers.*;
import divinerpg.registries.*;
import divinerpg.block_entities.chests.*;
import net.minecraft.core.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.*;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.*;
import net.minecraft.world.level.block.state.*;
import net.minecraft.world.level.material.*;

import javax.annotation.*;

public class BlockPresentBox extends BlockModChest {

    public BlockPresentBox() {
        super(Properties.of(Material.WOOD).sound(SoundType.STONE).strength(2, 1000000), () -> BlockEntityRegistry.PRESENT_BOX.get());
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
