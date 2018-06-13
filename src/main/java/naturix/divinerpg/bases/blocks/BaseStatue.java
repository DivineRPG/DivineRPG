package naturix.divinerpg.bases.blocks;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.blocks.statues.tiles.TileWatcher;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class BaseStatue<TE extends TileEntity> extends BlockBase {

	public BaseStatue(Material material, String name) {
		super(material, name);
		this.setCreativeTab(DivineRPG.TrophyTab);
	}
	
	public abstract Class<TileWatcher> getTileEntityClass();
	
	public TileEntity getTileEntity(IBlockAccess world, BlockPos pos) {
		return (TE)world.getTileEntity(pos);
	}
	
	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}
	@Override
	@Deprecated
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	@Deprecated
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Nullable
	@Override
	public abstract TileWatcher createTileEntity(World world, IBlockState state);
	{}
}