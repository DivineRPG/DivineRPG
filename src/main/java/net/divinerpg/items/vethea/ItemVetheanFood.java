package net.divinerpg.items.vethea;

import java.util.List;

import net.divinerpg.items.base.ItemModFood;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.MessageLocalizer;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.util.EnumChatFormatting;

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
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add((MessageLocalizer.norecolor("tooltip.fills")) + (double) func_150905_g(stack) / 2 + (MessageLocalizer.norecolor("tooltip.health")));
		list.add(func_150906_h(stack) + (MessageLocalizer.norecolor("tooltip.saturation")));
		list.add(!isWolfsFavoriteMeat() ? Util.BLUE + (MessageLocalizer.norecolor("tooltip.petfood")) + EnumChatFormatting.RESET + (MessageLocalizer.norecolor("tooltip.true")): Util.BLUE + (MessageLocalizer.norecolor("tooltip.petfood")) + EnumChatFormatting.RESET + (MessageLocalizer.norecolor("tooltip.false")));
		list.add(TooltipLocalizer.vethean());
	}
}