package naturix.divinerpg.events;

import naturix.divinerpg.objects.blocks.BlockMod;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.Reference;
import naturix.divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class EventArmorSet {

private ModItems item = new ModItems();
private ModBlocks block = new ModBlocks();
private Item boots = null, body = null, legs = null, helmet = null;

@SubscribeEvent
public void onBlockDrops(HarvestDropsEvent event) {
	if (event.getState().getBlock() != null && event.getState().getBlock() instanceof BlockMod
	        && ((BlockMod) event.getState().getBlock()).isTwilightOre()) {
		if (event.getHarvester() != null && event.getHarvester() instanceof EntityPlayer) {
			EntityPlayer player = event.getHarvester();

			ItemStack stackBoots = player.inventory.armorInventory.get(0);
			ItemStack stackLegs = player.inventory.armorInventory.get(1);
			ItemStack stackBody = player.inventory.armorInventory.get(2);
			ItemStack stackHelmet = player.inventory.armorInventory.get(3);

			if (stackBoots != null) {
				boots = stackBoots.getItem();
			} else {
				boots = null;
			}

			if (stackBody != null) {
				body = stackBody.getItem();
			} else {
				body = null;
			}

			if (stackLegs != null) {
				legs = stackLegs.getItem();
			} else {
				legs = null;
			}

			if (stackHelmet != null) {
				helmet = stackHelmet.getItem();
			} else {
				helmet = null;
			}

			// Eden
			if (boots == ModItems.edenBoots && body == ModItems.edenChestplate && legs == ModItems.edenLeggings
			        && helmet == ModItems.edenHelmet) {
				if (!event.isSilkTouching()) {
					ItemStack fragment = event.getDrops().get(0);
					event.getDrops().add(fragment.copy());
					event.getDrops().add(fragment.copy());
					event.getDrops().add(fragment.copy());
				}
			}
		}
	}
}

@SubscribeEvent
public void onJump(LivingJumpEvent event) {
	if (event.getEntityLiving() instanceof EntityPlayer) {
		EntityPlayer player = (EntityPlayer) event.getEntityLiving();

		ItemStack stackBoots = player.inventory.armorInventory.get(0);
		ItemStack stackLegs = player.inventory.armorInventory.get(1);
		ItemStack stackBody = player.inventory.armorInventory.get(2);
		ItemStack stackHelmet = player.inventory.armorInventory.get(3);
		if (stackBoots != null) {
			boots = stackBoots.getItem();
		} else {
			boots = null;
		}
		if (stackBody != null) {
			body = stackBody.getItem();
		} else {
			body = null;
		}
		if (stackLegs != null) {
			legs = stackLegs.getItem();
		} else {
			legs = null;
		}
		if (stackHelmet != null) {
			helmet = stackHelmet.getItem();
		} else {
			helmet = null;
		}
		// Divine
		if (boots == ModItems.divineBoots && body == ModItems.divineBody && legs == ModItems.divineLegs
		        && helmet == ModItems.divineHelmet) {
			player.addVelocity(0, 0.2D, 0);
		}

		// Skythern
		if (boots == ModItems.skythernBoots && body == ModItems.skythernChestplate && legs == ModItems.skythernLeggings
		        && helmet == ModItems.skythernHelmet) {
			player.addVelocity(0, 0.5D, 0);
		}

		// Vethean

		if (body == ModItems.glisteningBody && legs == ModItems.glisteningLegs && boots == ModItems.glisteningBoots
		        && helmet == ModItems.glisteningHood) {
			player.addVelocity(0, 0.2D, 0);
		}

		if (body == ModItems.demonizedBody && legs == ModItems.demonizedLegs && boots == ModItems.demonizedBoots
		        && helmet == ModItems.demonizedHood) {
			player.addVelocity(0, 0.3D, 0);
		}

		if (body == ModItems.tormentedBody && legs == ModItems.tormentedLegs && boots == ModItems.tormentedBoots
		        && helmet == ModItems.tormentedHood) {
			player.addVelocity(0, 0.4D, 0);
		}

	}
}

@SubscribeEvent
public void onPlayerAttackEvent(LivingAttackEvent e) {
	// if(e.getEntityLiving().world.isRemote) {
	if (e.getEntity() instanceof EntityPlayer) {
		EntityPlayer player = (EntityPlayer) e.getEntityLiving();

		ItemStack stackBoots = player.inventory.armorInventory.get(0);
		ItemStack stackLegs = player.inventory.armorInventory.get(1);
		ItemStack stackBody = player.inventory.armorInventory.get(2);
		ItemStack stackHelmet = player.inventory.armorInventory.get(3);

		if (stackBoots != null) {
			boots = stackBoots.getItem();
		} else {
			boots = null;
		}

		if (stackBody != null) {
			body = stackBody.getItem();
		} else {
			body = null;
		}

		if (stackLegs != null) {
			legs = stackLegs.getItem();
		} else {
			legs = null;
		}

		if (stackHelmet != null) {
			helmet = stackHelmet.getItem();
		} else {
			helmet = null;
		}

		DamageSource s = e.getSource();

		// Kraken and Aquastrive
		if ((boots == ModItems.aquastriveBoots && body == ModItems.aquastriveBody && legs == ModItems.aquastriveLegs
		        && helmet == ModItems.aquastriveHelmet)
		        || (boots == ModItems.krakenBoots && body == ModItems.krakenBody && legs == ModItems.krakenLegs
		                && helmet == ModItems.krakenHelmet)) {
			if (s.equals(DamageSource.DROWN)) {
				e.setCanceled(true);
			}
		}

		// Uvite
		if (boots == ModItems.apalachiaBoots && legs == ModItems.apalachiaLeggings
		        && body == ModItems.apalachiaChestplate && helmet == ModItems.apalachiaHelmet) {
			if (s.equals(DamageSource.CACTUS) || s.equals(DamageSource.FALLING_BLOCK) || s.equals(DamageSource.ANVIL)
			        || s.equals(DamageSource.IN_WALL) || s.equals(Utils.trapSource)) {
				e.setCanceled(true);
			}
		}

		// Wither Reaper
		if (boots == ModItems.witherReaperBoots && legs == ModItems.witherReaperLegs
		        && body == ModItems.witherReaperBody && helmet == ModItems.witherReaperHelmet) {
			if (s.equals(DamageSource.WITHER)) {
				e.setCanceled(true);
			}
		}

		// Jungle
		if (boots == ModItems.jungleBoots && legs == ModItems.jungleLegs && body == ModItems.jungleBody
		        && helmet == ModItems.jungleHelmet) {
			if (s.equals(DamageSource.MAGIC)) {
				e.setCanceled(true);
			}
		}
	}
}
//
// @SubscribeEvent
// public void onLivingHurtEvent(LivingHurtEvent e) {
// if (e.source.getEntity() != null && e.source.getEntity() instanceof
// EntityPlayer) {
// EntityPlayer player = (EntityPlayer) e.source.getEntity();
//
// ItemStack stackBoots = player.inventory.armorItemInSlot(0);
// ItemStack stackLegs = player.inventory.armorItemInSlot(1);
// ItemStack stackBody = player.inventory.armorItemInSlot(2);
// ItemStack stackHelmet = player.inventory.armorItemInSlot(3);
//
// if (stackBoots != null) boots = stackBoots.getItem();
// else boots = null;
//
// if (stackBody != null) body = stackBody.getItem();
// else body = null;
//
// if (stackLegs != null) legs = stackLegs.getItem();
// else legs = null;
//
// if (stackHelmet != null) helmet = stackHelmet.getItem();
// else helmet = null;
// }
//
// DamageSource s = e.source;
//
// //Santa
// if (boots == IceikaItems.santaBoots && body == IceikaItems.santaTunic && legs
// == IceikaItems.santaPants && helmet == IceikaItems.santaCap) {
// if ((e.entityLiving.worldObj.provider.dimensionId ==
// ConfigurationHelper.iceika) && ((s.getEntity() instanceof EntityPlayer) &&
// !s.isProjectile() && !s.isMagicDamage())) {
// e.ammount += 6;
// }
// }
//
// //Halite
// if (boots == TwilightItemsArmor.haliteBoots && body ==
// TwilightItemsArmor.haliteChestplate && legs ==
// TwilightItemsArmor.haliteLeggings && helmet ==
// TwilightItemsArmor.haliteHelmet) {
// if (((s.getEntity() instanceof EntityPlayer) && !s.isProjectile() &&
// !s.isMagicDamage())) {
// e.ammount += 16;
// }
// }
//
// //Divine
// if (boots == VanillaItemsArmor.divineBoots && body ==
// VanillaItemsArmor.divineBody && legs == VanillaItemsArmor.divineLegs &&
// helmet == VanillaItemsArmor.divineHelmet) {
// if (((s.getEntity() instanceof EntityPlayer) && !s.isProjectile() &&
// !s.isMagicDamage())) {
// e.ammount += 6;
// }
// }
//
// //Corrupted
// if(body == VanillaItemsArmor.corruptedBody && legs ==
// VanillaItemsArmor.corruptedLegs && boots == VanillaItemsArmor.corruptedBoots
// && helmet == VanillaItemsArmor.corruptedHelmet) {
// if (((s.getEntity() instanceof EntityPlayer) && s.isProjectile())) {
// e.ammount *= 1.2;
// }
// }
//
// //Vethean
// if(body == VetheaItems.glisteningBody && legs == VetheaItems.glisteningLegs
// && boots == VetheaItems.glisteningBoots && helmet ==
// VetheaItems.glisteningHelmet) {
// if (((s.getEntity() instanceof EntityPlayer) && !s.isProjectile() &&
// !s.isMagicDamage())) {
// e.ammount += 3;
// }
// }
//
// if(body == VetheaItems.demonizedBody && legs == VetheaItems.demonizedLegs &&
// boots == VetheaItems.demonizedBoots && helmet == VetheaItems.demonizedHelmet)
// {
// if (((s.getEntity() instanceof EntityPlayer) && !s.isProjectile() &&
// !s.isMagicDamage())) {
// e.ammount += 6;
// }
// }
//
// if(body == VetheaItems.tormentedBody && legs == VetheaItems.tormentedLegs &&
// boots == VetheaItems.tormentedBoots && helmet == VetheaItems.tormentedHelmet)
// {
// if (((s.getEntity() instanceof EntityPlayer) && !s.isProjectile() &&
// !s.isMagicDamage())) {
// e.ammount += 9;
// }
// }
// }
// }
}