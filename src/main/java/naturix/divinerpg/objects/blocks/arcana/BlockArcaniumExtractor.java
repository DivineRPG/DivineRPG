package naturix.divinerpg.objects.blocks.arcana;

import naturix.divinerpg.objects.blocks.BlockModFurnace;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityArcaniumExtractor;
import naturix.divinerpg.utils.GUIHandler;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockArcaniumExtractor extends BlockModFurnace implements ITileEntityProvider {
    public static final AxisAlignedBB BLOCK_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 1.5F, 1.0F);

    public BlockArcaniumExtractor(String name) {
        super(name, false);
        setBlockUnbreakable();
        setResistance(6000000F);
    }

    public int getGuiID() {
        return GUIHandler.ARCANIUM_EXTRACTOR_GUI_ID;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return BLOCK_AABB;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityArcaniumExtractor();
    }
}
