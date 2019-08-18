package naturix.divinerpg.events;

import naturix.divinerpg.objects.items.base.ItemHealingSword;
import naturix.divinerpg.objects.items.base.RangedWeaponBase;
import net.minecraft.item.ItemSword;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventTooltip {
	@SubscribeEvent
	public void tooltip(ItemTooltipEvent evt) {
		for(int i = 0; i < evt.getToolTip().size(); i++) {
			if(evt.getToolTip().get(i).contains("Attack Damage") && evt.getToolTip().get(i).contains("+") && (evt.getItemStack().getItem() instanceof ItemSword || evt.getItemStack().getItem() instanceof RangedWeaponBase)) {
				evt.getToolTip().remove(i);
				evt.getToolTip().remove(i-1);
			}
		}
		 
//		if(!(evt.getItemStack().getItem() instanceof ItemModSword) && evt.getItemStack().getItem() instanceof ItemSword) {
//			evt.getToolTip().add(TooltipLocalizer.meleeDam(((ItemSword)evt.getItemStack().getItem()).getAttackDamage()+4));
//		}
		
		if(evt.getItemStack().getItem() instanceof ItemHealingSword) {
			for(int i = 0; i < evt.getToolTip().size(); i++) {
				if(evt.getToolTip().get(i).isEmpty()) evt.getToolTip().remove(i);
			}
		}
	}

}