package naturix.divinerpg.objects.blocks;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.IShearable;

public class BlockModLeaves extends BlockLeaves implements IShearable, IHasModel {
	private Block sapling;

	public BlockModLeaves(String name, float hardness) {
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setHardness(hardness);
		this.setLightOpacity(1);
		this.setCreativeTab(DRPGCreativeTabs.BlocksTab);
		this.setTickRandomly(true);

		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public BlockModLeaves(String name, float hardness, Block sapling) {
		this(name, hardness);
		this.sapling = sapling;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return (this.sapling != null) ? Item.getItemFromBlock(this.sapling) : null;
	}

	@Override
	public BlockPlanks.EnumType getWoodType(int meta) {
		return BlockPlanks.EnumType.OAK;
	}

	@Override
	public NonNullList<ItemStack> onSheared(ItemStack item, net.minecraft.world.IBlockAccess world, BlockPos pos,
	        int fortune) {
		return NonNullList.withSize(1, new ItemStack(this, 1, 0));
	}

	// private boolean isFancy(IBlockAccess world, int x, int y, int z) {
	// if (Minecraft.getMinecraft().gameSettings.fancyGraphics || world.getBlock(x,
	// y, z) == VetheaBlocks.firewoodLeaves || world.getBlock(x, y, z) ==
	// VetheaBlocks.hyrewoodLeaves || world.getBlock(x, y, z) ==
	// VetheaBlocks.dreamWoodLeaves || world.getBlock(x, y, z) ==
	// VetheaBlocks.mintwoodLeaves)
	// return true;
	// return false;
	// }

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
