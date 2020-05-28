package divinerpg.objects.blocks.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.blocks.BlockModUnbreakable;
import divinerpg.objects.blocks.tile.entity.TileEntityInfusionTable;
import divinerpg.proxy.GUIHandler;
import divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockInfusionTable extends BlockModUnbreakable implements ITileEntityProvider {

    public BlockInfusionTable(String name) {
        super(name);
        setCreativeTab(DivineRPGTabs.vethea);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityInfusionTable();
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(playerIn.isSneaking()) {
            return true;
        }

        playerIn.openGui(DivineRPG.instance, GUIHandler.INFUSION_TABLE_GUI_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
}
