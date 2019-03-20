package naturix.divinerpg.objects.blocks;

import java.util.Random;

import naturix.divinerpg.registry.DRPGCreativeTabs;
import net.minecraft.block.BlockDoor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

/**
 * Created by LiteWolf101 on Jan /29/2019
 */
public class SteelDoor extends BlockDoor {
	protected String name;

	public SteelDoor(String name, Material materialIn) {
		super(materialIn);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(DRPGCreativeTabs.BlocksTab);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(this);
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
	        EntityPlayer player) {
		return new ItemStack(this);
	}
}
