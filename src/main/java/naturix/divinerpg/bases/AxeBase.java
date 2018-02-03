package naturix.divinerpg.bases;

import naturix.divinerpg.DivineRPG;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;

public class AxeBase extends ItemAxe {

	private String name;

	public AxeBase(ToolMaterial material, String name, float damage, float speed) {
		super(material, damage, speed);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(DivineRPG.ToolsTab);
		this.name = name;
	}
	
	public void registerItemModel(Item item) {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}

}