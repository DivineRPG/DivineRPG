package naturix.divinerpg.objects.blocks.arcana;

import naturix.divinerpg.objects.blocks.BlockModFurnace;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityGreenlightFurnace;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.utils.GUIHandler;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockGreenlightFurnace extends BlockModFurnace implements ITileEntityProvider {
    protected String name;

    public BlockGreenlightFurnace(String name, boolean isBurnging) {
        super(name, isBurnging);
        this.name = name;
    }

    public int getGuiID() {
        return GUIHandler.GREENLIGHT_FURNACE_GUI_ID;
    }

    public static void setState(boolean active, World worldIn, BlockPos pos) {
        IBlockState iblockstate = worldIn.getBlockState(pos);
        TileEntity tileentity = worldIn.getTileEntity(pos);
        Block block = iblockstate.getBlock();

        keepInventory = true;
        if (active) {
            worldIn.setBlockState(pos,
                    ModBlocks.greenlightFurnaceOn.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)),
                    3);
        } else {
            worldIn.setBlockState(pos,
                    ModBlocks.greenlightFurnace.getDefaultState().withProperty(FACING, iblockstate.getValue(FACING)),
                    3);
        }
        keepInventory = false;

        if (tileentity != null) {
            tileentity.validate();
            worldIn.setTileEntity(pos, tileentity);
        }
    }

    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityGreenlightFurnace();
    }
}
