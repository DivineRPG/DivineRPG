package net.divinerpg.utils.events;

import net.divinerpg.items.base.ItemHealingSword;
import net.divinerpg.items.base.ItemModSword;
import net.divinerpg.items.base.ItemProjectileShooter;
import net.divinerpg.utils.TooltipLocalizer;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventTooltip {
	
	@SubscribeEvent
	public void tooltip(ItemTooltipEvent evt) {
		for(int i = 0; i < evt.toolTip.size(); i++) {
			if(evt.toolTip.get(i).contains("Attack Damage") && evt.toolTip.get(i).contains("+") && (evt.itemStack.getItem() instanceof ItemSword || evt.itemStack.getItem() instanceof ItemProjectileShooter)) {
				evt.toolTip.remove(i);
				evt.toolTip.remove(i-1);
			}
		}
		
		if(!(evt.itemStack.getItem() instanceof ItemModSword) && evt.itemStack.getItem() instanceof ItemSword) {
			evt.toolTip.add(TooltipLocalizer.meleeDam(((ItemSword)evt.itemStack.getItem()).func_150931_i()+5));
		}
		
		if(evt.itemStack.getItem() instanceof ItemHealingSword) {
			for(int i = 0; i < evt.toolTip.size(); i++) {
				if(evt.toolTip.get(i).isEmpty()) evt.toolTip.remove(i);
			}
		}
	}

}
