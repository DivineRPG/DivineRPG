package naturix.divinerpg.bases.blocks;

import naturix.divinerpg.DivineRPG;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockBase extends Block {

	private static final CreativeTabs tab = DivineRPG.BlocksTab;
	protected String name;

	public BlockBase(Material material, String name) {
		super(material);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		this.setHardness(2);
	}
	
	public void registerItemModel(Item itemBlock) {
		DivineRPG.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	
	public BlockBase setCreativeTab() {
		super.setCreativeTab(tab);
		return this;
	}

}