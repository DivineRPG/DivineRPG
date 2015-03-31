package net.divinerpg.items.vanilla;

import java.util.List;

import net.divinerpg.items.base.ItemModSword;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.Util;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ItemBurningSword extends ItemModSword {
    private int burnSeconds;
	public ItemBurningSword(ToolMaterial toolMaterial, String name, int seconds) {
		super(toolMaterial, name);
		this.burnSeconds = seconds;
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase livingBase1, EntityLivingBase livingBase2) {
		stack.damageItem(1, livingBase2);
		livingBase1.setFire(this.burnSeconds);
		return true;
	}

	@Override
	protected void addAdditionalInformation(List list) {
	    list.add(TooltipLocalizer.burn(this.burnSeconds));
	}
}
