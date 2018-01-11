package naturix.divinerpg.utils.blocknitems;

import naturix.divinerpg.Divine;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class SwordBase extends ItemSword {

	private String name;

	public SwordBase(ToolMaterial material, String name) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(Divine.CombatTab);
		this.name = name;
	}
	
	public void registerItemModel(Item item) {
		Divine.proxy.registerItemRenderer(this, 0, name);
	}

}