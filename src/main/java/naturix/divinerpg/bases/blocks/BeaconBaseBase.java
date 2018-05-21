package naturix.divinerpg.bases.blocks;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.utils.Config;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BeaconBaseBase extends Block {
	public boolean isBeaconBase = Config.isBeaconBase;
	private static final CreativeTabs tab = DivineRPG.BlocksTab; 
	protected String name;

	public BeaconBaseBase(Material material, String name) {
		super(material);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
	}
	
	public void registerItemModel(Item itemBlock) {
		DivineRPG.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	
	public BeaconBaseBase setCreativeTab() {
		super.setCreativeTab(tab);
		return this;
	}
	public BeaconBaseBase setBeaconBase(boolean b){
		isBeaconBase = b;
		return this;
	}
	@Override
	public boolean isBeaconBase(IBlockAccess world, BlockPos pos, BlockPos beacon){
		return isBeaconBase;
	}
}