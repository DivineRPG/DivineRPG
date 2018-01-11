package naturix.divinerpg.utils.blocknitems;

import naturix.divinerpg.Divine;
import net.minecraft.block.BlockRedstoneLight;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class LampBase extends BlockRedstoneLight {
	private final boolean isOn;
	private static final CreativeTabs tab = Divine.BlocksTab;
	protected String name;

	public LampBase(boolean material, String name, boolean isOn) {
		super(material);
	
		this.name = name;
	
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(tab);
		this.isOn = isOn;

        if (isOn)
        {
            this.setLightLevel(1.0F);
        }
    }
	
	public void registerItemModel(Item itemBlock) {
		Divine.proxy.registerItemRenderer(itemBlock, 0, name);
	}
	
	public Item createItemBlock() {
		return new ItemBlock(this).setRegistryName(getRegistryName());
	}
	
	public LampBase setCreativeTab() {
		super.setCreativeTab(tab);
		return this;
	}

}