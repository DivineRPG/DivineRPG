package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.utils.material.EnumBlockType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockModGlass extends BlockMod {

    public BlockModGlass(String name, float hardness) {
        super(EnumBlockType.GLASS, name, hardness);
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }
}