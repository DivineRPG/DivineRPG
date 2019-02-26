package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.objects.blocks.itemblock.ItemBlockVariants;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BeaconBaseBase extends Block implements IHasModel {
	public boolean isBeaconBase = Config.isBeaconBase;
	protected String name;

	public BeaconBaseBase(String name) {
		super(Material.ROCK);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(DivineRPG.BlocksTab);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}

	@Override
	public boolean isBeaconBase(IBlockAccess world, BlockPos pos, BlockPos beacon) {
		return isBeaconBase;
	}

	public BeaconBaseBase setBeaconBase(boolean b) {
		isBeaconBase = b;
		return this;
	}

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}