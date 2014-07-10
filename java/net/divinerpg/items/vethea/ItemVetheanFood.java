package net.divinerpg.items.vethea;

import java.util.List;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemVetheanFood extends ItemFood {
	
	private int food;
	protected float saturation;
	private String name;
	
	public ItemVetheanFood(int par2, float par3, String name) {
		super(par2, par3, false);
		food = par2;
		saturation = par3;
		LangRegistry.addItem(this);
		this.setCreativeTab(DivineRPGTabs.vethea);
	}

	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("Replenishes " + food + " Hunger");
		par3List.add(saturation + " Saturation");
		par3List.add("Pet Food: False");
		par3List.add(Util.GREEN + "Vethean");
	}

	public Item setTextureName(String par1Str) {
		this.iconString = (Reference.PREFIX + par1Str);
		return this;
	}

	public Item setName(String name){
		setTextureName(name);
		setUnlocalizedName(name);
		GameRegistry.registerItem(this, name);
		return this;
	}
}