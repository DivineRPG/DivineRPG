package naturix.divinerpg.bases.items;

import naturix.divinerpg.DivineRPG;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSword;

public class SwordBase extends ItemSword {

	private String name;

	public SwordBase(ToolMaterial material, String name) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(DivineRPG.CombatTab);
		this.name = name;
	}
	
	public void registerItemModel() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}

}