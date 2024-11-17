package net.divinerpg.utils.events;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.TwilightItemsArmor;
import net.divinerpg.utils.items.VanillaItemsArmor;
import net.divinerpg.utils.items.VetheaItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventArmorFullSet {

    private float                flyTemp;

    private Item                 boots          = null;
    private Item                 body           = null;
    private Item                 legs           = null;
    private Item                 helmet         = null;

    public static final String[] isImmuneToFire = new String[] { "ae", "field_70178_ae", "isImmuneToFire" };
    public static final String[] isJumping      = new String[] { "bc", "field_70703_bu", "isJumping" };

    private World                world;
    
    @SubscribeEvent
    public void onPlayerHurtEvent(LivingHurtEvent evt) {
        if (evt.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) evt.entity;

            ItemStack stackBoots = player.inventory.armorItemInSlot(0);
            ItemStack stackLegs = player.inventory.armorItemInSlot(1);
            ItemStack stackBody = player.inventory.armorItemInSlot(2);
            ItemStack stackHelmet = player.inventory.armorItemInSlot(3);

            if (stackBoots != null) boots = stackBoots.getItem();
            else boots = null;

            if (stackBody != null) body = stackBody.getItem();
            else body = null;

            if (stackLegs != null) legs = stackLegs.getItem();
            else legs = null;

            if (stackHelmet != null) helmet = stackHelmet.getItem();
            else helmet = null;

            DamageSource s = evt.source;

            //Bedrock
            if ((boots == VanillaItemsArmor.bedrockBoots && legs == VanillaItemsArmor.bedrockLegs && body == VanillaItemsArmor.bedrockBody && helmet == VanillaItemsArmor.bedrockHelmet)) {
                if (s.isExplosion()) {
                    evt.setCanceled(true);
                }
            }
            
            //Ender
            if ((boots == VanillaItemsArmor.enderBoots || boots == VanillaItemsArmor.redEnderBoots || boots == VanillaItemsArmor.yellowEnderBoots || boots == VanillaItemsArmor.greenEnderBoots || boots == VanillaItemsArmor.blueEnderBoots || boots == VanillaItemsArmor.grayEnderBoots) && (legs == VanillaItemsArmor.enderLegs || legs == VanillaItemsArmor.redEnderLegs || legs == VanillaItemsArmor.yellowEnderLegs || legs == VanillaItemsArmor.greenEnderLegs || legs == VanillaItemsArmor.blueEnderLegs || legs == VanillaItemsArmor.grayEnderLegs) && (body == VanillaItemsArmor.enderBody || body == VanillaItemsArmor.redEnderBody || body == VanillaItemsArmor.yellowEnderBody || body == VanillaItemsArmor.greenEnderBody || body == VanillaItemsArmor.blueEnderBody || body == VanillaItemsArmor.grayEnderBody) && (helmet == VanillaItemsArmor.enderHelmet || helmet == VanillaItemsArmor.redEnderHelmet || helmet == VanillaItemsArmor.yellowEnderHelmet || helmet == VanillaItemsArmor.greenEnderHelmet || helmet == VanillaItemsArmor.blueEnderHelmet || helmet == VanillaItemsArmor.grayEnderHelmet)) {
                if (s.isExplosion()) {
                    evt.setCanceled(true);
                }
            }

            //Arlemite
            if (boots == VanillaItemsArmor.arlemiteBoots && legs == VanillaItemsArmor.arlemiteLegs && body == VanillaItemsArmor.arlemiteBody && helmet == VanillaItemsArmor.arlemiteHelmet) {
                if (s.isProjectile() || s.damageType.equals("thrown")) {
                    evt.ammount *= 0.3;
                }
            }

            //Rupee
            if ((boots == VanillaItemsArmor.rupeeBoots || boots == VanillaItemsArmor.redRupeeBoots || boots == VanillaItemsArmor.yellowRupeeBoots || boots == VanillaItemsArmor.greenRupeeBoots || boots == VanillaItemsArmor.blueRupeeBoots || boots == VanillaItemsArmor.grayRupeeBoots) && (legs == VanillaItemsArmor.rupeeLegs || legs == VanillaItemsArmor.redRupeeLegs || legs == VanillaItemsArmor.yellowRupeeLegs || legs == VanillaItemsArmor.greenRupeeLegs || legs == VanillaItemsArmor.blueRupeeLegs || legs == VanillaItemsArmor.grayRupeeLegs) && (body == VanillaItemsArmor.rupeeBody || body == VanillaItemsArmor.redRupeeBody || body == VanillaItemsArmor.yellowRupeeBody || body == VanillaItemsArmor.greenRupeeBody || body == VanillaItemsArmor.blueRupeeBody || body == VanillaItemsArmor.grayRupeeBody) && (helmet == VanillaItemsArmor.rupeeHelmet || helmet == VanillaItemsArmor.redRupeeHelmet || helmet == VanillaItemsArmor.yellowRupeeHelmet || helmet == VanillaItemsArmor.greenRupeeHelmet || helmet == VanillaItemsArmor.blueRupeeHelmet || helmet == VanillaItemsArmor.grayRupeeHelmet)) {
                if ((s.damageType.equals("mob")) && !s.isProjectile()) {
                    evt.ammount *= 0.3;
                }
            }

            //Santa
            if (boots == IceikaItems.santaBoots && legs == IceikaItems.santaPants && body == IceikaItems.santaTunic && helmet == IceikaItems.santaCap) {
                if (evt.entityLiving.worldObj.provider.dimensionId == ConfigurationHelper.iceika) {
                    evt.ammount *= 0.2;
                }
            }
            
            //Vethean
            
            if(body == VetheaItems.degradedBody && legs == VetheaItems.degradedLegs && boots == VetheaItems.degradedBoots) {
            	if((helmet == VetheaItems.degradedHelmet && !s.isProjectile() && !s.isMagicDamage()) || (helmet == VetheaItems.degradedMask && s.isProjectile() && !s.isMagicDamage()) || (helmet == VetheaItems.degradedHood && s.isMagicDamage())) evt.ammount *= 0.82;
            }
            
            if(body == VetheaItems.finishedBody && legs == VetheaItems.finishedLegs && boots == VetheaItems.finishedBoots) {
            	if((helmet == VetheaItems.finishedHelmet && !s.isProjectile() && !s.isMagicDamage()) || (helmet == VetheaItems.finishedMask && s.isProjectile() && !s.isMagicDamage()) || (helmet == VetheaItems.finishedHood && s.isMagicDamage())) evt.ammount *= 0.773;
            }
            
            if(body == VetheaItems.glisteningBody && legs == VetheaItems.glisteningLegs && boots == VetheaItems.glisteningBoots) {
            	if((helmet == VetheaItems.glisteningHelmet && !s.isProjectile() && !s.isMagicDamage()) || (helmet == VetheaItems.glisteningMask && s.isProjectile() && !s.isMagicDamage()) || (helmet == VetheaItems.glisteningHood && s.isMagicDamage())) evt.ammount *= 0.7;
            }
            
            if(body == VetheaItems.demonizedBody && legs == VetheaItems.demonizedLegs && boots == VetheaItems.demonizedBoots) {
            	if((helmet == VetheaItems.demonizedHelmet && !s.isProjectile() && !s.isMagicDamage()) || (helmet == VetheaItems.demonizedMask && s.isProjectile() && !s.isMagicDamage()) || (helmet == VetheaItems.demonizedHood && s.isMagicDamage())) evt.ammount *= 0.625;
            }
            
            if(body == VetheaItems.tormentedBody && legs == VetheaItems.tormentedLegs && boots == VetheaItems.tormentedBoots) {
            	if((helmet == VetheaItems.tormentedHelmet && !s.isProjectile() && !s.isMagicDamage()) || (helmet == VetheaItems.tormentedMask && s.isProjectile() && !s.isMagicDamage()) || (helmet == VetheaItems.tormentedHood && s.isMagicDamage())) evt.ammount *= 0.348;
            }

        }
    }

    @SubscribeEvent
    public void onJump(LivingJumpEvent event) {
        if (event.entityLiving instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.entityLiving;
            ItemStack stackBoots = player.inventory.armorItemInSlot(0);
            ItemStack stackLegs = player.inventory.armorItemInSlot(1);
            ItemStack stackBody = player.inventory.armorItemInSlot(2);
            ItemStack stackHelmet = player.inventory.armorItemInSlot(3);

            if (stackBoots != null) boots = stackBoots.getItem();
            else boots = null;

            if (stackBody != null) body = stackBody.getItem();
            else body = null;

            if (stackLegs != null) legs = stackLegs.getItem();
            else legs = null;

            if (stackHelmet != null) helmet = stackHelmet.getItem();
            else helmet = null;

            //Divine
            if (boots == VanillaItemsArmor.divineBoots && body == VanillaItemsArmor.divineBody && legs == VanillaItemsArmor.divineLegs && helmet == VanillaItemsArmor.divineHelmet) {
                player.addVelocity(0, 0.2D, 0);
            }

            //Skythern
            if (boots == TwilightItemsArmor.skythernBoots && body == TwilightItemsArmor.skythernChestplate && legs == TwilightItemsArmor.skythernLeggings && helmet == TwilightItemsArmor.skythernHelmet) {
                player.addVelocity(0, 0.5D, 0);
            }
            
            //Vethean
            
            if(body == VetheaItems.glisteningBody && legs == VetheaItems.glisteningLegs && boots == VetheaItems.glisteningBoots && helmet == VetheaItems.glisteningHood) {
            	player.addVelocity(0, 0.2D, 0);
            }
                
            if(body == VetheaItems.demonizedBody && legs == VetheaItems.demonizedLegs && boots == VetheaItems.demonizedBoots && helmet == VetheaItems.demonizedHood) {
            	player.addVelocity(0, 0.3D, 0);
            }
                
            if(body == VetheaItems.tormentedBody && legs == VetheaItems.tormentedLegs && boots == VetheaItems.tormentedBoots && helmet == VetheaItems.tormentedHood) {
            	player.addVelocity(0, 0.4D, 0);
            }

        }
    }

    @SubscribeEvent
    public void onBlockDrops(HarvestDropsEvent event) {
    	if (event.block != null && event.block instanceof BlockMod && ((BlockMod)event.block).isTwilightOre()) {
    		if(event.harvester != null && event.harvester instanceof EntityPlayer) {
    			EntityPlayer player = event.harvester;
    			ItemStack stackBoots = player.inventory.armorItemInSlot(0);
    			ItemStack stackLegs = player.inventory.armorItemInSlot(1);
    			ItemStack stackBody = player.inventory.armorItemInSlot(2);
    			ItemStack stackHelmet = player.inventory.armorItemInSlot(3);
            
    	        if (stackBoots != null) boots = stackBoots.getItem();
    	        else boots = null;

    	        if (stackBody != null) body = stackBody.getItem();
    	        else body = null;

    	        if (stackLegs != null) legs = stackLegs.getItem();
    	        else legs = null;

    	        if (stackHelmet != null) helmet = stackHelmet.getItem();
    	        else helmet = null;

    	        //Eden
    	        if (boots == TwilightItemsArmor.edenBoots && body == TwilightItemsArmor.edenChestplate && legs == TwilightItemsArmor.edenLeggings && helmet == TwilightItemsArmor.edenHelmet) {
    	        	if(!event.isSilkTouching) {
	    	        	ItemStack fragment = event.drops.get(0);
		        		event.drops.add(fragment.copy());
		        		event.drops.add(fragment.copy());
		        		event.drops.add(fragment.copy());
    	        	}
    	        }
    		}
    	}
    }

    @SubscribeEvent
    public void onPlayerAttackEvent(LivingAttackEvent e) {
        if (e.entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.entity;

            ItemStack stackBoots = player.inventory.armorItemInSlot(0);
            ItemStack stackLegs = player.inventory.armorItemInSlot(1);
            ItemStack stackBody = player.inventory.armorItemInSlot(2);
            ItemStack stackHelmet = player.inventory.armorItemInSlot(3);

            if (stackBoots != null) boots = stackBoots.getItem();
            else boots = null;

            if (stackBody != null) body = stackBody.getItem();
            else body = null;

            if (stackLegs != null) legs = stackLegs.getItem();
            else legs = null;

            if (stackHelmet != null) helmet = stackHelmet.getItem();
            else helmet = null;

            DamageSource s = e.source;

            //Kraken and Aquastrive
            if ((boots == VanillaItemsArmor.aquastriveBoots && body == VanillaItemsArmor.aquastriveBody && legs == VanillaItemsArmor.aquastriveLegs && helmet == VanillaItemsArmor.aquastriveHelmet)
                    || (boots == VanillaItemsArmor.krakenBoots && body == VanillaItemsArmor.krakenBody && legs == VanillaItemsArmor.krakenLegs && helmet == VanillaItemsArmor.krakenHelmet)) {
                if (s.equals(DamageSource.drown)) {
                    e.setCanceled(true);
                }
            }

            //Uvite
            if (boots == TwilightItemsArmor.apalachiaBoots && legs == TwilightItemsArmor.apalachiaLeggings && body == TwilightItemsArmor.apalachiaChestplate && helmet == TwilightItemsArmor.apalachiaHelmet) {
                if (s.equals(DamageSource.cactus) || s.equals(DamageSource.fallingBlock) || s.equals(DamageSource.anvil) || s.equals(DamageSource.inWall) || s.equals(Util.trapSource)) {
                    e.setCanceled(true);
                }
            }

            //Wither Reaper
            if (boots == VanillaItemsArmor.witherReaperBoots && legs == VanillaItemsArmor.witherReaperLegs && body == VanillaItemsArmor.witherReaperBody && helmet == VanillaItemsArmor.witherReaperHelmet) {
                if (s.equals(DamageSource.wither)) {
                    e.setCanceled(true);
                }
            }
            
            //Jungle
            if (boots == VanillaItemsArmor.jungleBoots && legs == VanillaItemsArmor.jungleLegs && body == VanillaItemsArmor.jungleBody && helmet == VanillaItemsArmor.jungleHelmet) {
                if (s.equals(DamageSource.magic)) {
                    e.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public void onLivingHurtEvent(LivingHurtEvent e) {
        if (e.source.getEntity() != null && e.source.getEntity() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) e.source.getEntity();
            
            ItemStack stackBoots = player.inventory.armorItemInSlot(0);
            ItemStack stackLegs = player.inventory.armorItemInSlot(1);
            ItemStack stackBody = player.inventory.armorItemInSlot(2);
            ItemStack stackHelmet = player.inventory.armorItemInSlot(3);

            if (stackBoots != null) boots = stackBoots.getItem();
            else boots = null;

            if (stackBody != null) body = stackBody.getItem();
            else body = null;

            if (stackLegs != null) legs = stackLegs.getItem();
            else legs = null;

            if (stackHelmet != null) helmet = stackHelmet.getItem();
            else helmet = null;
        }

        DamageSource s = e.source;

        //Santa
        if (boots == IceikaItems.santaBoots && body == IceikaItems.santaTunic && legs == IceikaItems.santaPants && helmet == IceikaItems.santaCap) {
            if ((e.entityLiving.worldObj.provider.dimensionId == ConfigurationHelper.iceika) && ((s.getEntity() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                e.ammount += 6;
            }
        }
            
        //Halite
        if (boots == TwilightItemsArmor.haliteBoots && body == TwilightItemsArmor.haliteChestplate && legs == TwilightItemsArmor.haliteLeggings && helmet == TwilightItemsArmor.haliteHelmet) {
            if (((s.getEntity() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                e.ammount += 16;
            }
        }
        
        //Divine
        if (boots == VanillaItemsArmor.divineBoots && body == VanillaItemsArmor.divineBody && legs == VanillaItemsArmor.divineLegs && helmet == VanillaItemsArmor.divineHelmet) {
            if (((s.getEntity() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                e.ammount += 6;
            }
        }
        
        //Corrupted
        if(body == VanillaItemsArmor.corruptedBody && legs == VanillaItemsArmor.corruptedLegs && boots == VanillaItemsArmor.corruptedBoots && helmet == VanillaItemsArmor.corruptedHelmet) {
        	if (((s.getEntity() instanceof EntityPlayer) && s.isProjectile())) {
                e.ammount *= 1.2;
            }
        }

        //Vethean
        if(body == VetheaItems.glisteningBody && legs == VetheaItems.glisteningLegs && boots == VetheaItems.glisteningBoots && helmet == VetheaItems.glisteningHelmet) {
        	if (((s.getEntity() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                e.ammount += 3;
            }
        }
            
        if(body == VetheaItems.demonizedBody && legs == VetheaItems.demonizedLegs && boots == VetheaItems.demonizedBoots && helmet == VetheaItems.demonizedHelmet) {
        	if (((s.getEntity() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                e.ammount += 6;
            }
        }
            
        if(body == VetheaItems.tormentedBody && legs == VetheaItems.tormentedLegs && boots == VetheaItems.tormentedBoots && helmet == VetheaItems.tormentedHelmet) {
        	if (((s.getEntity() instanceof EntityPlayer) && !s.isProjectile() && !s.isMagicDamage())) {
                e.ammount += 9;
            }
        }
    }
}
