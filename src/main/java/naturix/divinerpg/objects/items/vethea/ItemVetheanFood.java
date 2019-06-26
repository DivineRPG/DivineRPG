package naturix.divinerpg.objects.items.vethea;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.items.base.ItemModFood;
import naturix.divinerpg.registry.DivineRPGTabs;
import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemVetheanFood extends ItemModFood {
	
	private int food;
	protected float saturation;
	private String name;
	
	public ItemVetheanFood(int par2, float par3, String name) {
		super(par2, par3, false, name);
		food = par2;
		saturation = par3;
		this.setCreativeTab(DivineRPGTabs.vethea);
	}

	@Override
	public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
		list.add("Replenishes " + food + " Hunger");
		list.add(saturation + " Saturation");
		list.add("Pet Food: False");
		list.add(TooltipLocalizer.vethean());
	}
}