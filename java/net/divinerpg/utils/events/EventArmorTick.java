package net.divinerpg.utils.events;

import net.divinerpg.client.ArcanaHelper;
import net.divinerpg.entities.vanilla.projectile.EntityScythe;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.items.ArcanaItems;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.items.TwilightItemsArmor;
import net.divinerpg.utils.items.VanillaItemsArmor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

    public static final String[] isImmuneToFire = new String[] { "ag", "field_70178_ae", "isImmuneToFire" };
    public static final String[] isJumping      = new String[] { "bd", "field_70703_bu", "isJumping" };

    private World                world;
	
	@SubscribeEvent
    public void onTickEvent(PlayerTickEvent event) {
        world = event.player.worldObj;
        ItemStack stackBoots = event.player.inventory.armorItemInSlot(0);
        ItemStack stackLegs = event.player.inventory.armorItemInSlot(1);
        ItemStack stackBody = event.player.inventory.armorItemInSlot(2);
        ItemStack stackHelmet = event.player.inventory.armorItemInSlot(3);

        if (stackBoots != null) boots = stackBoots.getItem();
        else boots = null;

        if (stackBody != null) body = stackBody.getItem();
        else body = null;

        if (stackLegs != null) legs = stackLegs.getItem();
        else legs = null;

        if (stackHelmet != null) helmet = stackHelmet.getItem();
        else helmet = null;

        if (boots == VanillaItemsArmor.angelicBoots && body == VanillaItemsArmor.angelicBody && legs == VanillaItemsArmor.angelicLegs && helmet == VanillaItemsArmor.angelicHelmet) {
            if (event.player.capabilities.isFlying) {
                ArcanaHelper.removeBarValue(0.2);
            }
            if (ArcanaHelper.getBarValue() >= 0) {
                event.player.capabilities.allowFlying = true;
            } else {
                event.player.capabilities.isFlying = false;
            }
            event.player.fallDistance = -0.5F;
            event.player.triggerAchievement(DivineRPGAchievements.whenPigsFly);
        }

        //Elite Realmite
        if (boots == VanillaItemsArmor.eliteRealmiteBoots && body == VanillaItemsArmor.eliteRealmiteBody && legs == VanillaItemsArmor.eliteRealmiteLegs && helmet == VanillaItemsArmor.eliteRealmiteHelmet) {
            event.player.fallDistance = -0.5F;
        }

        //Divine
        if (boots == VanillaItemsArmor.divineBoots && body == VanillaItemsArmor.divineBody && legs == VanillaItemsArmor.divineLegs && helmet == VanillaItemsArmor.divineHelmet) {
            event.player.fallDistance = -0.5F;
        }

        //Wildwood
        if (boots == TwilightItemsArmor.wildwoodBoots && body == TwilightItemsArmor.wildwoodBody && legs == TwilightItemsArmor.wildwoodLegs && helmet == TwilightItemsArmor.wildwoodHelmet) {
            if (event.player.isInsideOfMaterial(Material.water)) {
                float current = event.player.getHealth();
                if ((current > 0.0F) && (current < 20.0F)) {
                    event.player.setHealth(current + 0.1F);
                }
            }
        }

        //Vemos
        if (boots == ArcanaItems.vemosBoots && body == ArcanaItems.vemosBody && legs == ArcanaItems.vemosLegs && helmet == ArcanaItems.vemosHelmet) {
            float current = event.player.getHealth();
            if ((current > 0.0F) && (current < 20.0F)) {
                event.player.setHealth(current + 0.1F);
            }
        }

        //Mortum
        if (boots == TwilightItemsArmor.mortumBoots && body == TwilightItemsArmor.mortumBody && legs == TwilightItemsArmor.mortumLegs && helmet == TwilightItemsArmor.mortumHelmet) {
            boolean light = world.getBlockLightValue((int) event.player.posX, (int) event.player.posY, (int) event.player.posZ) < 7;
            if (light) {
                event.player.addPotionEffect(new PotionEffect(16, 210, 10)); //The 210 is necessary
                //TODO Render a duplicate of what the potion does, instead of adding the potion
            }
        }

        //Skythern
        if (boots == TwilightItemsArmor.skythernBoots && body == TwilightItemsArmor.skythernBody && legs == TwilightItemsArmor.skythernLegs && helmet == TwilightItemsArmor.skythernHelmet) {
            event.player.fallDistance = -0.5F;
        }

        //Netherite, Inferno, and Bedrock
        if ((boots == VanillaItemsArmor.netheriteBoots && legs == VanillaItemsArmor.netheriteLegs && body == VanillaItemsArmor.netheriteBody && helmet == VanillaItemsArmor.netheriteHelmet)
                || (boots == VanillaItemsArmor.infernoBoots && legs == VanillaItemsArmor.infernoLegs && body == VanillaItemsArmor.infernoBody && helmet == VanillaItemsArmor.infernoHelmet)
                || (boots == VanillaItemsArmor.bedrockBoots && legs == VanillaItemsArmor.bedrockLegs && body == VanillaItemsArmor.bedrockBody && helmet == VanillaItemsArmor.bedrockHelmet)) {
            ObfuscationReflectionHelper.setPrivateValue(Entity.class, event.player, true, isImmuneToFire);
        }
        else {
            ObfuscationReflectionHelper.setPrivateValue(Entity.class, event.player, false, isImmuneToFire);
        }

        //Aquastrive
        if (boots == VanillaItemsArmor.aquastriveBoots && body == VanillaItemsArmor.aquastriveBody && legs == VanillaItemsArmor.aquastriveLegs && helmet == VanillaItemsArmor.aquastriveHelmet) {
            float speed = 1.1F;
            boolean isJumping = false;
            isJumping = (Boolean) ObfuscationReflectionHelper.getPrivateValue(EntityLivingBase.class, event.player, EventArmorFullSet.isJumping);

            if (event.player.isInWater()) {
                if (!event.player.isSneaking() && !isJumping) {
                    if (event.player.motionX > -speed && event.player.motionX < speed) {
                        event.player.motionX *= speed;
                        event.player.motionY = 0F;
                    }
                    if (event.player.motionZ > -speed && event.player.motionZ < speed) {
                        event.player.motionZ *= speed;
                        event.player.motionY = 0F;
                    }
                }
                if (isJumping || event.player.isSneaking()) {
                    event.player.motionY *= speed;
                    if (event.player.motionX > -speed && event.player.motionX < speed) {
                        event.player.motionX *= speed;
                    }
                    if (event.player.motionZ > -speed && event.player.motionZ < speed) {
                        event.player.motionZ *= speed;
                    }
                }
            }
        }

        //Shadow
        if (boots == VanillaItemsArmor.shadowBoots && body == VanillaItemsArmor.shadowBody && legs == VanillaItemsArmor.shadowLegs && helmet == VanillaItemsArmor.shadowHelmet) {
            event.player.addPotionEffect(new PotionEffect(1, -1, 1));
        }

        //Skeleman
        if (boots == VanillaItemsArmor.skelemanBoots && body == VanillaItemsArmor.skelemanBody && legs == VanillaItemsArmor.skelemanLegs && helmet == VanillaItemsArmor.skelemanHelmet) {
            if (event.player.getFoodStats().needFood()) {
                event.player.getFoodStats().addStats(1, 0);
            }
        }

        //Santa
        if (boots == IceikaItems.santaBoots && body == IceikaItems.santaBody && legs == IceikaItems.santaLegs && helmet == IceikaItems.santaHead) {
            if (event.player.worldObj.provider.dimensionId == ConfigurationHelper.iceika) {
                if (event.player.getFoodStats().needFood()) {
                    event.player.getFoodStats().addStats(1, 0);
                }
                event.player.addPotionEffect(new PotionEffect(1, -1, 1));
            }
        }

        //Jack O Man
        if (boots == VanillaItemsArmor.jackOManBoots && body == VanillaItemsArmor.jackOManBody && legs == VanillaItemsArmor.jackOManLegs && helmet == VanillaItemsArmor.jackOManHelmet) {
            EntityScythe.damage = 16.0F;
        }
        else if (!(EntityScythe.damage == 4.0F)) {
            EntityScythe.damage = 4.0F;
        }
        
      //Halite
        if ((EventArmorFullSet.size != 1) && (boots == TwilightItemsArmor.haliteBoots && legs == TwilightItemsArmor.haliteLegs && body == TwilightItemsArmor.haliteBody && helmet == TwilightItemsArmor.haliteHelmet))
        	EventArmorFullSet.size = 1;
        else if (EventArmorFullSet.size == 1)
        	EventArmorFullSet.size = 0;
    }

}
