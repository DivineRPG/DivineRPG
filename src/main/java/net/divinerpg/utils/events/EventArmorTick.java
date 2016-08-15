package net.divinerpg.utils.events;

import java.util.List;

import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.FlyingHelper;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.items.ArcanaItems;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.TwilightItemsArmor;
import net.divinerpg.utils.items.VanillaItemsArmor;
import net.divinerpg.utils.items.VetheaItems;
import net.divinerpg.utils.material.EnumArmor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class EventArmorTick {
	
	private float                flyTemp;

    private Item                 boots          = null;
    private Item                 body           = null;
    private Item                 legs           = null;
    private Item                 helmet         = null;

    public static final String[] isImmuneToFire = new String[] { "ae", "field_70178_ae", "isImmuneToFire" };
    public static final String[] isJumping      = new String[] { "bc", "field_70703_bu", "isJumping" };
    public static final String[] walkSpeed      = new String[] { "g", "field_75097_g", "walkSpeed" };

    private World                world;
    	
	@SubscribeEvent
    public void onTickEvent(PlayerTickEvent evt) {
        world = evt.player.worldObj;
        ItemStack stackBoots = evt.player.inventory.armorItemInSlot(0);
        ItemStack stackLegs = evt.player.inventory.armorItemInSlot(1);
        ItemStack stackBody = evt.player.inventory.armorItemInSlot(2);
        ItemStack stackHelmet = evt.player.inventory.armorItemInSlot(3);
        
        float speedMultiplier = 1;

        if (stackBoots != null) boots = stackBoots.getItem();
        else boots = null;

        if (stackBody != null) body = stackBody.getItem();
        else body = null;

        if (stackLegs != null) legs = stackLegs.getItem();
        else legs = null;

        if (stackHelmet != null) helmet = stackHelmet.getItem();
        else helmet = null;       
                
        if(boots != VanillaItemsArmor.angelicBoots && body != VanillaItemsArmor.angelicBody && legs != VanillaItemsArmor.angelicLegs && helmet != VanillaItemsArmor.angelicHelmet) {
            FlyingHelper.getProperties(evt.player).couldFly = evt.player.capabilities.allowFlying;
        }
        if(evt.player.capabilities.isCreativeMode) FlyingHelper.getProperties(evt.player).couldFly = false;
        
        if (boots == VanillaItemsArmor.angelicBoots && body == VanillaItemsArmor.angelicBody && legs == VanillaItemsArmor.angelicLegs && helmet == VanillaItemsArmor.angelicHelmet && ArcanaHelper.getProperties(evt.player).getBarValue() != 0) {
            evt.player.fallDistance = -0.5F;
            evt.player.triggerAchievement(DivineRPGAchievements.whenPigsFly);
            evt.player.capabilities.allowFlying = true;
            if(evt.player.capabilities.isFlying && !evt.player.capabilities.isCreativeMode && !FlyingHelper.getProperties(evt.player).couldFly) ArcanaHelper.getProperties(evt.player).useBar(0.5f);
            if(ArcanaHelper.getProperties(evt.player).getBarValue() < 1 && !evt.player.capabilities.isCreativeMode && !FlyingHelper.getProperties(evt.player).couldFly) {
            	evt.player.capabilities.isFlying = false;
            	evt.player.capabilities.allowFlying = false;
            }
        }
        else if(evt.player.capabilities.allowFlying && !evt.player.capabilities.isCreativeMode && !FlyingHelper.getProperties(evt.player).couldFly){
        	evt.player.capabilities.isFlying = false;
        	evt.player.capabilities.allowFlying = false;
        }
        
        //Elite Realmite
        if (boots == VanillaItemsArmor.eliteRealmiteBoots && body == VanillaItemsArmor.eliteRealmiteBody && legs == VanillaItemsArmor.eliteRealmiteLegs && helmet == VanillaItemsArmor.eliteRealmiteHelmet) {
            evt.player.fallDistance = -0.5F;
        }

        //Divine
        if (boots == VanillaItemsArmor.divineBoots && body == VanillaItemsArmor.divineBody && legs == VanillaItemsArmor.divineLegs && helmet == VanillaItemsArmor.divineHelmet) {
            evt.player.fallDistance = -0.5F;
        }

        //Wildwood
        if (boots == TwilightItemsArmor.wildwoodBoots && body == TwilightItemsArmor.wildwoodChestplate && legs == TwilightItemsArmor.wildwoodLeggings && helmet == TwilightItemsArmor.wildwoodHelmet) {
            if (evt.player.isInsideOfMaterial(Material.water)) {
                float current = evt.player.getHealth();
                if ((current > 0.0F) && (current < 20.0F)) {
                    evt.player.heal(0.25f);
                }
            }
        }
        
        //Korma
        if (boots == ArcanaItems.kormaBoots && body == ArcanaItems.kormaBody && legs == ArcanaItems.kormaLegs && helmet == ArcanaItems.kormaHelmet) {
        	ArcanaHelper.getProperties(evt.player).regen(1);
        }

        //Vemos
        if (boots == ArcanaItems.vemosBoots && body == ArcanaItems.vemosBody && legs == ArcanaItems.vemosLegs && helmet == ArcanaItems.vemosHelmet) {
            float current = evt.player.getHealth();
            if ((current > 0.0F) && (current < 20.0F)) {
                evt.player.setHealth(current + 0.1F);
            }
        }

        //Mortum
        if (boots == TwilightItemsArmor.mortumBoots && body == TwilightItemsArmor.mortumChestplate && legs == TwilightItemsArmor.mortumLeggings && helmet == TwilightItemsArmor.mortumHelmet) {
            evt.player.addPotionEffect(new PotionEffect(Potion.nightVision.id, 210, 10, true));
        }

        //Skythern
        if (boots == TwilightItemsArmor.skythernBoots && body == TwilightItemsArmor.skythernChestplate && legs == TwilightItemsArmor.skythernLeggings && helmet == TwilightItemsArmor.skythernHelmet) {
            evt.player.fallDistance = -0.5F;
        }

        //Netherite, Inferno, and Bedrock
        if ((boots == VanillaItemsArmor.netheriteBoots && legs == VanillaItemsArmor.netheriteLegs && body == VanillaItemsArmor.netheriteBody && helmet == VanillaItemsArmor.netheriteHelmet)
                || (boots == VanillaItemsArmor.infernoBoots && legs == VanillaItemsArmor.infernoLegs && body == VanillaItemsArmor.infernoBody && helmet == VanillaItemsArmor.infernoHelmet)
                || (boots == VanillaItemsArmor.bedrockBoots && legs == VanillaItemsArmor.bedrockLegs && body == VanillaItemsArmor.bedrockBody && helmet == VanillaItemsArmor.bedrockHelmet)) {
            evt.player.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 40, 0, true));
        }

        //Aquastrive
        if (boots == VanillaItemsArmor.aquastriveBoots && body == VanillaItemsArmor.aquastriveBody && legs == VanillaItemsArmor.aquastriveLegs && helmet == VanillaItemsArmor.aquastriveHelmet) {
            float speed = 1.1F;
            boolean isJumping = false;
            isJumping = (Boolean) ObfuscationReflectionHelper.getPrivateValue(EntityLivingBase.class, evt.player, EventArmorFullSet.isJumping);

            if (evt.player.isInWater()) {
                if (!evt.player.isSneaking() && !isJumping) {
                    if (evt.player.motionX > -speed && evt.player.motionX < speed) {
                        evt.player.motionX *= speed;
                        evt.player.motionY = 0F;
                    }
                    if (evt.player.motionZ > -speed && evt.player.motionZ < speed) {
                        evt.player.motionZ *= speed;
                        evt.player.motionY = 0F;
                    }
                }
                if (isJumping || evt.player.isSneaking()) {
                    evt.player.motionY *= speed;
                    if (evt.player.motionX > -speed && evt.player.motionX < speed) {
                        evt.player.motionX *= speed;
                    }
                    if (evt.player.motionZ > -speed && evt.player.motionZ < speed) {
                        evt.player.motionZ *= speed;
                    }
                }
            }
        }

        //Shadow
        if (boots == VanillaItemsArmor.shadowBoots && body == VanillaItemsArmor.shadowBody && legs == VanillaItemsArmor.shadowLegs && helmet == VanillaItemsArmor.shadowHelmet) {
            speedMultiplier = 3;
        }
        //Frozen
        if (boots == VanillaItemsArmor.frozenBoots && body == VanillaItemsArmor.frozenBody && legs == VanillaItemsArmor.frozenLegs && helmet == VanillaItemsArmor.frozenHelmet && !evt.player.worldObj.isRemote && Ticker.tick % 10 == 0) {
            List<Entity> entities = evt.player.worldObj.getEntitiesWithinAABB(EntityMob.class, evt.player.boundingBox.expand(6, 6, 6));
            for(Entity e : entities) {
            	((EntityMob)e).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 40, 1, true));
            }
        }

        //Terran
        if (boots == VanillaItemsArmor.terranBoots && body == VanillaItemsArmor.terranBody && legs == VanillaItemsArmor.terranLegs && helmet == VanillaItemsArmor.terranHelmet) {
            evt.player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 20, 2, true));
        }

        //Skeleman
        if (boots == VanillaItemsArmor.skelemanBoots && body == VanillaItemsArmor.skelemanBody && legs == VanillaItemsArmor.skelemanLegs && helmet == VanillaItemsArmor.skelemanHelmet) {
            if (evt.player.getFoodStats().needFood()) {
                evt.player.getFoodStats().addStats(1, 0);
            }
        }

        //Santa
        if (boots == IceikaItems.santaBoots && body == IceikaItems.santaTunic && legs == IceikaItems.santaPants && helmet == IceikaItems.santaCap) {
            if (evt.player.worldObj.provider.dimensionId == ConfigurationHelper.iceika) {
                if (evt.player.getFoodStats().needFood()) {
                    evt.player.getFoodStats().addStats(1, 0);
                }
                speedMultiplier = 2;
            }
        }
        
        //Vethean
        
        if(body == VetheaItems.glisteningBody && legs == VetheaItems.glisteningLegs && boots == VetheaItems.glisteningBoots && helmet == VetheaItems.glisteningMask) {
        	speedMultiplier = 1.4f;
        }
        
        if(body == VetheaItems.demonizedBody && legs == VetheaItems.demonizedLegs && boots == VetheaItems.demonizedBoots && helmet == VetheaItems.demonizedMask) {
        	speedMultiplier = 1.8f;
        }
        
        if(body == VetheaItems.tormentedBody && legs == VetheaItems.tormentedLegs && boots == VetheaItems.tormentedBoots && helmet == VetheaItems.tormentedMask) {
        	speedMultiplier = 2.2f;
        }
        
        ObfuscationReflectionHelper.setPrivateValue(PlayerCapabilities.class, evt.player.capabilities, 0.1f*speedMultiplier, walkSpeed);
        
        if(body == VetheaItems.glisteningBody && legs == VetheaItems.glisteningLegs && boots == VetheaItems.glisteningBoots && helmet == VetheaItems.glisteningHood) {
        	evt.player.fallDistance = -0.5F;
        }
            
        if(body == VetheaItems.demonizedBody && legs == VetheaItems.demonizedLegs && boots == VetheaItems.demonizedBoots && helmet == VetheaItems.demonizedHood) {
        	evt.player.fallDistance = -0.5F;
        }
            
        if(body == VetheaItems.tormentedBody && legs == VetheaItems.tormentedLegs && boots == VetheaItems.tormentedBoots && helmet == VetheaItems.tormentedHood) {
        	evt.player.fallDistance = -0.5F;
        }
        
        if(evt.player.inventory.hasItem(VetheaItems.minersAmulet)) evt.player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 1, 2, true));
    }

}
