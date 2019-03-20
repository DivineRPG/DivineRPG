package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockModFence extends BlockFence implements IHasModel {
	public BlockModFence(MapColor mapColor, String name) {
		super(Material.WOOD, mapColor);
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(DRPGCreativeTabs.BlocksTab);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	public BlockModFence(String name) {
		this(MapColor.WOOD, name);
	}

	@Override
	public boolean canBeConnectedTo(IBlockAccess world, BlockPos pos, EnumFacing facing) {
		BlockPos other = pos.offset(facing);
		Block block = world.getBlockState(other).getBlock();

		return block instanceof BlockFence || block instanceof BlockFenceGate;
	}

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
