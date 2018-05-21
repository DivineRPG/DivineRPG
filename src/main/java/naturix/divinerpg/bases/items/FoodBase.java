package naturix.divinerpg.bases.items;


import naturix.divinerpg.DivineRPG;
import net.minecraft.item.ItemFood;

public class FoodBase extends ItemFood {

	protected String name;
	
	public FoodBase(String name, int healAmount, boolean alwaysEdible) {
		super(healAmount, alwaysEdible);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(DivineRPG.ItemsTab);
	}
	
	public void registerItemModel() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}

}