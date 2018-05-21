package naturix.divinerpg.bases.items;


import naturix.divinerpg.DivineRPG;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;

public class HoeBase extends ItemHoe {

	private String name;

	public HoeBase(ToolMaterial material, String name, float damage, float speed) {
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