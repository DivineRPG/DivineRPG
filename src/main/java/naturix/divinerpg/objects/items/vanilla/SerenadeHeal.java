package naturix.divinerpg.objects.items.vanilla;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.objects.items.base.ItemMod;
import naturix.divinerpg.registry.DRPGCreativeTabs;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class SerenadeHeal extends ItemMod {

	public SerenadeHeal(String name) {
		super(name);
		this.setCreativeTab(DRPGCreativeTabs.utility);
		setMaxDamage(7);
		setMaxStackSize(1);
	}

	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
		tooltip.add("Heals the user");
		tooltip.add(stack.getMaxDamage() - stack.getItemDamage() + " uses left");
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
		entity.heal(entity.getMaxHealth());
		entity.extinguish();

		getDefaultInstance();
		entity.getFoodStats().addStats(20, 1);

		entity.getHeldItem(hand).damageItem(1, entity);
		return ar;
	}
}