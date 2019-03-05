package naturix.divinerpg.objects.blocks.arcana;

import naturix.divinerpg.objects.blocks.FurnaceBase;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityDemonFurnace;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.utils.GUIHandler;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DemonFurnace extends FurnaceBase implements ITileEntityProvider {
    protected String name;

    public DemonFurnace(String name, boolean isBurning) {
        super(name, isBurning, GUIHandler.DEMON_FURNACE_GUI_ID);
        this.name = name;
    }

    public static void setState(boolean active, World worldIn, BlockPos pos) {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        Block block = iblockstate.getBlock();

        keepInventory = true;
        if (active) {
            worldIn.setBlockState(pos,
                    ModBlocks.demonFurnaceOn.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        } else {
            worldIn.setBlockState(pos,
                    ModBlocks.demonFurnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }
        keepInventory = false;

        if (tileentity != null) {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
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
        return new TileEntityDemonFurnace();
    }
}
