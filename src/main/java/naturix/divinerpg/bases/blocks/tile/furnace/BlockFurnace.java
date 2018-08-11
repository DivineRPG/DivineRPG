package naturix.divinerpg.bases.blocks.tile.furnace;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.bases.blocks.tile.furnace.entity.TileEntityFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class BlockFurnace extends BlockTileEntity<TileEntityFurnace> {

	public BlockFurnace(String name) {
		super(Material.ROCK, name);
	}
	
	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
		 if (world.isRemote)
	        {
	            return true;
	        }
	        else
	        {
	            TileEntity tileentity = world.getTileEntity(pos);

	            if (tileentity instanceof TileEntityFurnace)
	            {
	                player.displayGUIChest((TileEntityFurnace)tileentity);
	                player.addStat(StatList.FURNACE_INTERACTION);
	            }

	            return true;
	        }
	}
	
	@Override
	public Class<TileEntityFurnace> getTileEntityClass() {
		return TileEntityFurnace.class;
	}
	
	@Nullable
	@Override
	public TileEntityFurnace createTileEntity(World world, IBlockState state) {
		return new TileEntityFurnace();
	}
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add("Not yet implimented");
    }
}