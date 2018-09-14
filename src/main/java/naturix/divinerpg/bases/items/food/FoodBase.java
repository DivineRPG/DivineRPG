package naturix.divinerpg.bases.items.food;


import naturix.divinerpg.DivineRPG;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class FoodBase extends ItemFood {
	public boolean isWolfsFavoriteMeat;
	public String name;
	public int healAmount;
	public FoodBase(String name, int healAmount, boolean alwaysEdible) {
		super(healAmount, alwaysEdible);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(DivineRPG.ItemsTab);
		this.healAmount=healAmount;
	}
	public FoodBase(String name, int healAmount, boolean alwaysEdible, boolean isWolfsFavoriteMeat) {
		super(healAmount, alwaysEdible);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(DivineRPG.ItemsTab);
		this.healAmount=healAmount;
		this.isWolfsFavoriteMeat=isWolfsFavoriteMeat;
	}
	@Override
	public int getHealAmount(ItemStack stack)
    {
        return this.healAmount;
    }

	public void registerItemModel() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}
	
}