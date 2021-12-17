package divinerpg.blocks.iceika;

import divinerpg.blocks.base.*;
import divinerpg.client.containers.*;
import divinerpg.registries.*;
import divinerpg.tiles.chests.*;
import net.minecraft.block.*;
import net.minecraft.block.material.*;
import net.minecraft.inventory.container.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;

public class BlockPresentBox extends BlockModChest {

    public BlockPresentBox(String name) {
        super(name, Properties.of(Material.WOOD).sound(SoundType.STONE).strength(2, 1000000), () -> TileRegistry.PRESENT_BOX);
    }

    @Nullable
    @Override
    public TileEntity newBlockEntity(IBlockReader p_196283_1_) {
        return new TileEntityPresentBox();
    }

    @Nullable
    public INamedContainerProvider getMenuProvider(BlockState state, World worldIn, BlockPos pos) {
        TileEntity tileentity = worldIn.getBlockEntity(pos);
        if (tileentity instanceof TileEntityPresentBox) {
            ITextComponent itextcomponent = ((INameable)tileentity).getDisplayName();
            return new SimpleNamedContainerProvider((id, inventory, player) -> {
                return new PresentBoxContainer(id, inventory, 3);
            }, itextcomponent);
        } else {
            return null;
        }
    }
}
