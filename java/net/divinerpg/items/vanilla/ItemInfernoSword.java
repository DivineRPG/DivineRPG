package net.divinerpg.items.vanilla;

import java.util.List;

import net.divinerpg.api.items.ItemModSword;
import net.divinerpg.utils.Util;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

public class ItemInfernoSword extends ItemModSword {

	public ItemInfernoSword(ToolMaterial toolMaterial, String name) {
		super(toolMaterial, name);
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase livingBase1, EntityLivingBase livingBase2) {
		stack.damageItem(1, livingBase2);
		livingBase1.setFire(12);
		return true;
	}

	@Override
	protected void addAdditionalInformation(List list) {
	    list.add(Util.BLUE + "On hit: " + EnumChatFormatting.RESET + "Burns victim for 12 seconds");
	}
}
