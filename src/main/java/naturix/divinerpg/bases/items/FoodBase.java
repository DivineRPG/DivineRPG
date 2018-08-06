package naturix.divinerpg.bases.items;


import naturix.divinerpg.DivineRPG;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class FoodBase extends ItemFood {

	public String name;
	public FoodBase(String name, int healAmount, boolean alwaysEdible) {
		super(healAmount, alwaysEdible);
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(DivineRPG.ItemsTab);
		getHealAmount(getDefaultInstance());
		
	}
	
	public void registerItemModel() {
		DivineRPG.proxy.registerItemRenderer(this, 0, name);
	}
	
}