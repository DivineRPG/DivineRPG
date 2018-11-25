package naturix.divinerpg.bases.blocks.tile.block;


import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.blocks.tile.entity.TileEntityChestIceika;

public class IceikaChest extends TileBase<TileEntityChestIceika> {
	String name;
	public IceikaChest(String name) {
		super(Material.ROCK, name);
		this.name=name;
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			TileEntityChestIceika tile = getTileEntity(world, pos);
			
		}
		return true;
	}
	
	@Override
	public Class<TileEntityChestIceika> getTileEntityClass() {
		return TileEntityChestIceika.class;
	}
	
	@Nullable
	@Override
	public TileEntityChestIceika createTileEntity(World world, IBlockState state) {
		return new TileEntityChestIceika();
	}
	public void registerItemModel(Item itemBlock) {
		DivineRPG.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		// TODO Auto-generated method stub
		return new TileEntityChestIceika();
	}
}