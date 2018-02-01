package naturix.divinerpg.bases;

import naturix.divinerpg.Divine;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BeaconBase extends Block {

	private static final CreativeTabs tab = Divine.BlocksTab;
	protected String name;

	public BeaconBase(Material material, String name) {
		super(material);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
	}
	
	public void registerItemModel(Item itemBlock) {
		Divine.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	
	public BeaconBase setCreativeTab() {
		super.setCreativeTab(tab);
		return this;
	}
	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon)
    {
        return this == this;
    }
}