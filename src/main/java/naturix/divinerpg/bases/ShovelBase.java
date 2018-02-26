package naturix.divinerpg.bases;

import naturix.divinerpg.DivineRPG;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;

public class ShovelBase extends ItemSpade {

	private String name;

	public ShovelBase(ToolMaterial material, String name, float damage, float speed) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(name);
		setCreativeTab(DivineRPG.ToolsTab);
		this.name = name;
	}
	
	public void registerItemModel(Item item) {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}

}