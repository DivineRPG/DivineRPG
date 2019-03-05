package naturix.divinerpg.objects.blocks.arcana;

import naturix.divinerpg.objects.blocks.FurnaceBase;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityMoltenFurnace;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.utils.GUIHandler;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class MoltenFurnace extends FurnaceBase implements ITileEntityProvider {
    protected String name;

    public MoltenFurnace(String name, boolean isBurnging) {
        super(name, isBurnging, GUIHandler.MOLTEN_FURNACE_GUI_ID);
        this.name = name;
    }

    public static void setState(boolean active, World worldIn, BlockPos pos) {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        Block block = iblockstate.getBlock();

        keepInventory = true;
        if (active) {
            worldIn.setBlockState(pos,
                    ModBlocks.moltenFurnaceOn.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        } else {
            worldIn.setBlockState(pos,
                    ModBlocks.moltenFurnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)), 3);
        }
        keepInventory = false;

        if (tileentity != null) {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityMoltenFurnace();
    }
}
