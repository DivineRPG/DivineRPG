package divinerpg.objects.blocks.vethea;

import divinerpg.DivineRPG;
import divinerpg.objects.blocks.BlockMod;
import divinerpg.objects.blocks.tile.entity.TileEntityDreamLamp;
import divinerpg.proxy.GUIHandler;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockDreamLamp extends BlockMod implements ITileEntityProvider {

    public static final PropertyBool POWERED = PropertyBool.create("powered");

    public BlockDreamLamp(String name) {
        super(name, 3.0F, Material.REDSTONE_LIGHT);
        this.setDefaultState(this.blockState.getBaseState().withProperty(POWERED, false));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, POWERED);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return meta == 0 ? this.getDefaultState() : this.getDefaultState().withProperty(POWERED, true);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(POWERED) ? 1 : 0;
    }

    public void setOn(World worldIn, BlockPos pos) {
        worldIn.setBlockState(pos, this.getDefaultState().withProperty(POWERED, true), 2);
    }

    public void setOff(World worldIn, BlockPos pos) {
        worldIn.setBlockState(pos, this.getDefaultState(), 2);
    }

    public boolean isPowered(IBlockState state) {
        return state.getValue(POWERED);
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        return state.getValue(POWERED) ? 15 : 0;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntityDreamLamp entity = (TileEntityDreamLamp)worldIn.getTileEntity(pos);

        if(entity == null || playerIn.isSneaking()) {
            System.out.println("Tile entity is null!");
        }

        playerIn.openGui(DivineRPG.instance, GUIHandler.DREAM_LAMP_GUI_ID, worldIn, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World w, int meta) {
        return new TileEntityDreamLamp();
    }
}