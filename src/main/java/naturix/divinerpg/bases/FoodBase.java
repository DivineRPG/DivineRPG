package naturix.divinerpg.bases;


import naturix.divinerpg.Divine;
import net.minecraft.item.ItemFood;

public class FoodBase extends ItemFood {

	protected String name;
	
	public FoodBase(String name, int healAmount, boolean alwaysEdible) {
		super(healAmount, alwaysEdible);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		this.setCreativeTab(Divine.ItemsTab);
	}
	
	public void registerItemModel() {
		Divine.proxy.registerItemRenderer(this, 0, name);
	}

}