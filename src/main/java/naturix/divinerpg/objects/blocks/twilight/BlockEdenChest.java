package naturix.divinerpg.objects.blocks.twilight;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.blocks.BlockModChest;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityEdenChest;
import naturix.divinerpg.utils.GUIHandler;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEdenChest extends BlockModChest {

    public BlockEdenChest(String name) {
        super(name, Material.ROCK);
        setSoundType(SoundType.STONE);
        setHardness(15);
        setResistance(1000000);
    }

    public int getGuiID() {
        return GUIHandler.EDEN_CHEST_GUI_ID;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityEdenChest();
    }
}
