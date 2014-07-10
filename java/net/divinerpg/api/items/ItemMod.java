package net.divinerpg.api.items;

import java.util.List;

import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemMod extends Item {

	protected String name;
	protected int healAmount = 0;

	public ItemMod(String name){
		this(name, name, DivineRPGTabs.items);
	}

	public ItemMod(String name, DivineRPGTabs tab){
		this(name, name, tab);
	}

	public ItemMod(String name, String textureName, DivineRPGTabs tab){
		this.name = name;
		setUnlocalizedName(name);
		setTextureName(Reference.PREFIX + textureName);
		setCreativeTab(tab);
		GameRegistry.registerItem(this, name);
		LangRegistry.addItem(this);
		if(ConfigurationHelper.showItemsBetter)
			setFull3D();
	}

	public ItemMod setHealAmount(int healAmount){
		this.healAmount = healAmount;
		return this;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(Util.DARK_AQUA + Reference.MOD_NAME);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(healAmount != 0){
			if(player.getHealth() < player.getMaxHealth()){
				player.heal(healAmount);
				player.inventory.consumeInventoryItem(this);
			}
		}
		return stack;
	}
}
