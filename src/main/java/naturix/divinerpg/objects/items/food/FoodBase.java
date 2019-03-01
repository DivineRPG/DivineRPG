package naturix.divinerpg.objects.items.food;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.IHasModel;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class FoodBase extends ItemFood implements IHasModel {
	public boolean isWolfsFavoriteMeat;
	public String name;
	public int healAmount;

	public FoodBase(String name, int healAmount, boolean alwaysEdible) {
		super(healAmount, alwaysEdible);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(DivineRPG.ItemsTab);
		this.healAmount = healAmount;
		ModItems.ITEMS.add(this);
	}

	public FoodBase(String name, int healAmount, boolean alwaysEdible, boolean isWolfsFavoriteMeat) {
		super(healAmount, alwaysEdible);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(DivineRPG.ItemsTab);
		this.healAmount = healAmount;
		this.isWolfsFavoriteMeat = isWolfsFavoriteMeat;
		ModItems.ITEMS.add(this);
	}

	@Override
	public int getHealAmount(ItemStack stack) {
		return this.healAmount;
	}

	@Override
	public void registerModels() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}

}