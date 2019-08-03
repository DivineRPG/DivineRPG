package naturix.divinerpg.objects.blocks.iceika;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.blocks.BlockModChest;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityPresentBox;
import naturix.divinerpg.utils.GUIHandler;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockPresentBox extends BlockModChest {

    public BlockPresentBox(String name) {
        super(name, Material.WOOD);
        setSoundType(SoundType.STONE);
        setResistance(1000000);
        setHardness(2);
    }

    public int getGuiID() {
        return GUIHandler.PRESENT_BOX_GUI_ID;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityPresentBox();
    }
}