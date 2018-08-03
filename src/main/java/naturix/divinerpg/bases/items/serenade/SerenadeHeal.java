package naturix.divinerpg.bases.items.serenade;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.bases.items.ItemBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class SerenadeHeal extends ItemBase{

	public SerenadeHeal(String name) {
		super(name);
		setCreativeTab(DivineRPG.CombatTab);
		setMaxDamage(7);
		setMaxStackSize(1);
		showDurabilityBar(getDefaultInstance());
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer entity, EnumHand hand) {
		ActionResult<ItemStack> ar = super.onItemRightClick(world, entity, hand);
		entity.heal(entity.getMaxHealth());	
		entity.extinguish();

		ItemStack stack = getDefaultInstance();
        entity.getFoodStats().addStats(20, 1);

		entity.getHeldItem(hand).damageItem(1, entity);
		return ar;
	}
	
}