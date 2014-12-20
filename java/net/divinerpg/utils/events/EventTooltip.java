package net.divinerpg.utils.events;

import net.divinerpg.api.items.ItemHealingSword;
import net.minecraft.init.Items;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventTooltip {
	
	@SubscribeEvent
	public void tooltip(ItemTooltipEvent evt) {
		for(int i = 0; i < evt.toolTip.size(); i++) {
			if(evt.toolTip.get(i).contains("Attack Damage") && evt.toolTip.get(i).contains("+")) {
				evt.toolTip.remove(i);
				evt.toolTip.remove(i-1);
			}
		}
		
		if(evt.itemStack.getItem() == Items.wooden_sword || evt.itemStack.getItem() == Items.stone_sword || evt.itemStack.getItem() == Items.golden_sword || evt.itemStack.getItem() == Items.iron_sword || evt.itemStack.getItem() == Items.diamond_sword) {
			evt.toolTip.add((int)(((ItemSword)evt.itemStack.getItem()).func_150931_i()+4) + " Melee Damage");
		}
		
		if(evt.itemStack.getItem() instanceof ItemHealingSword) {
			for(int i = 0; i < evt.toolTip.size(); i++) {
				if(evt.toolTip.get(i).isEmpty()) evt.toolTip.remove(i);
			}
		}
	}

}
