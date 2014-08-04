package net.divinerpg.items.vanilla;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSerenadeOfHealth extends ItemMod {
	
	public ItemSerenadeOfHealth(String name){
		super(name);
		setCreativeTab(DivineRPGTabs.tools);
		LangRegistry.addItem(this);
		setMaxDamage(20);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		float current = player.getHealth();
        if ((current >= 0.0F) && (current < 20.0F)) {
            player.setHealth(20.0F);
            stack.damageItem(1, player);
            Sounds.getSoundName(Sounds.heal);
        }
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
		infoList.add(20 - item.getItemDamage() + " Uses Remaining");
	}
}
