package naturix.divinerpg.objects.blocks;

import naturix.divinerpg.registry.DRPGCreativeTabs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class DirtBase extends BlockMod {

	public DirtBase(String name) {
		super(Material.GROUND, name);
		this.setCreativeTab(DRPGCreativeTabs.BlocksTab);
		this.setHardness(1f);
		setSoundType(SoundType.GROUND);
		this.setHarvestLevel("shovel", 0);
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
	}
}