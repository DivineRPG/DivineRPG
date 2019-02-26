package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.DivineRPG;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class DirtBase extends BlockBase {

	public DirtBase(String name) {
		super(Material.GROUND, name);
		setCreativeTab(DivineRPG.BlocksTab);
		this.setHardness(1f);
		setSoundType(SoundType.GROUND);
		this.setHarvestLevel("shovel", 0);
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
	}
}