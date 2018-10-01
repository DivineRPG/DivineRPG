package naturix.divinerpg.events;

import naturix.divinerpg.registry.ModItems;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class EventArmorSet{


	private ModItems item = new ModItems();
	private Item boots = null, body = null, legs = null, helmet = null;

	@SubscribeEvent
	public void playerTick(PlayerTickEvent event) {
		ItemStack stackBoots = event.player.inventory.armorItemInSlot(0);
		ItemStack stackLegs = event.player.inventory.armorItemInSlot(1);
		ItemStack stackBody = event.player.inventory.armorItemInSlot(2);
		ItemStack stackHelmet = event.player.inventory.armorItemInSlot(3);
		if(stackBoots != null) boots = stackBoots.getItem();
		else boots = null;
		if(stackBody != null) body = stackBody.getItem();
		else body = null;
		if(stackLegs != null) legs = stackLegs.getItem();
		else legs = null;
		if(stackHelmet != null) helmet = stackHelmet.getItem();
		else helmet = null;

		if(helmet == 
				ModItems.angelicHelmet && body == 
				ModItems.angelicChestplate && legs ==
				ModItems.angelicLeggings && boots == 
				ModItems.angelicBoots) 
		{
		event.player.fallDistance = 0;
		event.player.capabilities.allowFlying = true;
		}else {
			if(event.player.isCreative() != true) {
			event.player.capabilities.isFlying = false;
			event.player.capabilities.allowFlying = false;
		}
		}
		if(helmet == 
				ModItems.aquastriveHelmet && body == 
				ModItems.aquastriveChestplate && legs ==
				ModItems.aquastriveLeggings && boots == 
				ModItems.aquastriveBoots) 
		{

       	 event.player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("water_breathing"), 2, 5));
		}
		if(helmet == 
				ModItems.krakenHelmet && body == 
				ModItems.krakenChestplate && legs ==
				ModItems.krakenLeggings && boots == 
				ModItems.krakenBoots) 
		{

       	 event.player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("water_breathing"), 2, 5));
		}
		if(helmet == 
				ModItems.eliteRealmiteHelmet && body == 
				ModItems.eliteRealmiteChestplate && legs ==
				ModItems.eliteRealmiteLeggings && boots == 
				ModItems.eliteRealmiteBoots) 
		{

       	 event.player.fallDistance = -0.5F;
       	 }
		
		
		}

		@SubscribeEvent
		public void onJump(LivingJumpEvent event) {

		}

		@SubscribeEvent
		public void onLivingHurtEvent(LivingHurtEvent e) {

		}
}