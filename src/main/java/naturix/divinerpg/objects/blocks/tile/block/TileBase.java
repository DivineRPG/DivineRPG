package naturix.divinerpg.objects.blocks.tile.block;

import javax.annotation.Nullable;

import naturix.divinerpg.registry.DivineRPGTabs;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public abstract class TileBase<TE extends TileEntity> extends BlockContainer {

	public TileBase(Material material, String name) {
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(DivineRPGTabs.BlocksTab);
		this.setTickRandomly(true);
	}

	@Nullable
	@Override
	public abstract TE createTileEntity(World world, IBlockState state);

	public TE getTileEntity(IBlockAccess world, BlockPos pos) {
		return (TE) world.getTileEntity(pos);
	}

	public abstract Class<TE> getTileEntityClass();

	@Override
	public boolean hasTileEntity(IBlockState state) {
		return true;
	}

}