package net.divinerpg.utils.events;

import java.util.Random;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.client.ArcanaHelper;
import net.divinerpg.entities.vanilla.EntityJungleDramcryx;
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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class EventArmorFullSet {

    private float                flyTemp;

    private Item                 boots          = null;
    private Item                 body           = null;
    private Item                 legs           = null;
    private Item                 helmet         = null;

    public static final String[] isImmuneToFire = new String[] { "ag", "field_70178_ae", "isImmuneToFire" };
    public static final String[] isJumping      = new String[] { "bd", "field_70703_bu", "isJumping" };

    private World                world;
    
    public static int size = 0;

    @SubscribeEvent
    public void onPlayerHurtEvent(LivingHurtEvent e) {
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

            //Ender and Bedrock
            if ((boots == VanillaItemsArmor.enderBoots && legs == VanillaItemsArmor.enderLegs && body == VanillaItemsArmor.enderBody && helmet == VanillaItemsArmor.enderHelmet)
                    || (boots == VanillaItemsArmor.bedrockBoots && legs == VanillaItemsArmor.bedrockLegs && body == VanillaItemsArmor.bedrockBody && helmet == VanillaItemsArmor.bedrockHelmet)) {
                if (s.isExplosion()) {
                    e.setCanceled(true);
                }
            }

            //Arlemite
            if (boots == VanillaItemsArmor.arlemiteBoots && legs == VanillaItemsArmor.arlemiteLegs && body == VanillaItemsArmor.arlemiteBody && helmet == VanillaItemsArmor.arlemiteHelmet) {
                if (s.isProjectile() || s.damageType.equals("thrown")) {
                    e.ammount *= 0.4;
                }
            }

            //Rupee
            if (boots == VanillaItemsArmor.rupeeBoots && legs == VanillaItemsArmor.rupeeLegs && body == VanillaItemsArmor.rupeeBody && helmet == VanillaItemsArmor.rupeeHelmet) {
                if ((s.damageType.equals("mob")) && !s.isProjectile()) {
                    e.ammount *= 0.4;
                }
            }

            //Santa
            if (boots == IceikaItems.santaBoots && legs == IceikaItems.santaLegs && body == IceikaItems.santaBody && helmet == IceikaItems.santaHead) {
                if (e.entityLiving.worldObj.provider.dimensionId == ConfigurationHelper.iceika) {
                    e.ammount *= 0.2;
                }
            }

            //Divine

            /*//Degraded Melee
            else if (helmet == DivineRPG.degradedHelmetMelee)
            {
            	if (this.isMelee(s))
            	{
            		double a = 0.15 * 0.2;
            		if (body == DivineRPG.degradedChest)
            		{
            			a += 0.15 * 0.4;
            		}
            		if (legs == DivineRPG.degradedLegs)
            		{
            			a += 0.15 * 0.3;
            		}
            		if (boots == DivineRPG.degradedBoots)
            		{
            			a += 0.15 * 0.1;
            		}

            		e.ammount *= 1 - a;
            	}
            }

            //Degraded Ranged
            else if (helmet == DivineRPG.degradedHelmetRanged)
            {
            	if (this.isRanged(s))
            	{
            		double a = 0.15 * 0.2;
            		if (body == DivineRPG.degradedChest)
            		{
            			a += 0.15 * 0.4;
            		}
            		if (legs == DivineRPG.degradedLegs)
            		{
            			a += 0.15 * 0.3;
            		}
            		if (boots == DivineRPG.degradedBoots)
            		{
            			a += 0.15 * 0.1;
            		}

            		e.ammount *= 1 - a;
            	}
            }

            //Degraded Arcana
            else if (helmet == DivineRPG.degradedHelmetArcana)
            {
            	if (this.isArcana(s))
            	{
            		double a = 0.15 * 0.2;
            		if (body == DivineRPG.degradedChest)
            		{
            			a += 0.15 * 0.4;
            		}
            		if (legs == DivineRPG.degradedLegs)
            		{
            			a += 0.15 * 0.3;
            		}
            		if (boots == DivineRPG.degradedBoots)
            		{
            			a += 0.15 * 0.1;
            		}

            		e.ammount *= 1 - a;
            	}
            }

            //glistening Melee
            else if (helmet == DivineRPG.glisteningHelmetMelee)
            {
            	if (this.isMelee(s))
            	{
            		double a = 0.15 * 0.2;
            		if (body == DivineRPG.glisteningChest)
            		{
            			a += 0.15 * 0.4;
            		}
            		if (legs == DivineRPG.glisteningLegs)
            		{
            			a += 0.15 * 0.3;
            		}
            		if (boots == DivineRPG.glisteningBoots)
            		{
            			a += 0.15 * 0.1;
            		}

            		e.ammount *= 1 - a;
            	}
            }

            //glistening Ranged
            else if (helmet == DivineRPG.glisteningHelmetRanged)
            {
            	if (this.isRanged(s))
            	{
            		double a = 0.15 * 0.2;
            		if (body == DivineRPG.glisteningChest)
            		{
            			a += 0.15 * 0.4;
            		}
            		if (legs == DivineRPG.glisteningLegs)
            		{
            			a += 0.15 * 0.3;
            		}
            		if (boots == DivineRPG.glisteningBoots)
            		{
            			a += 0.15 * 0.1;
            		}

            		e.ammount *= 1 - a;
            	}
            }

            //glistening Arcana
            else if (helmet == DivineRPG.glisteningHelmetArcana)
            {
            	if (this.isArcana(s))
            	{
            		double a = 0.15 * 0.2;
            		if (body == DivineRPG.glisteningChest)
            		{
            			a += 0.15 * 0.4;
            		}
            		if (legs == DivineRPG.glisteningLegs)
            		{
            			a += 0.15 * 0.3;
            		}
            		if (boots == DivineRPG.glisteningBoots)
            		{
            			a += 0.15 * 0.1;
            		}

            		e.ammount *= 1 - a;
            	}
            }

            //finished Melee
            else if (helmet == DivineRPG.finishedHelmetMelee)
            {
            	if (this.isMelee(s))
            	{
            		double a = 0.15 * 0.2;
            		if (body == DivineRPG.finishedChest)
            		{
            			a += 0.15 * 0.4;
            		}
            		if (legs == DivineRPG.finishedLegs)
            		{
            			a += 0.15 * 0.3;
            		}
            		if (boots == DivineRPG.finishedBoots)
            		{
            			a += 0.15 * 0.1;
            		}

            		e.ammount *= 1 - a;
            	}
            }

            //finished Ranged
            else if (helmet == DivineRPG.finishedHelmetRanged)
            {
            	if (this.isRanged(s))
            	{
            		double a = 0.15 * 0.2;
            		if (body == DivineRPG.finishedChest)
            		{
            			a += 0.15 * 0.4;
            		}
            		if (legs == DivineRPG.finishedLegs)
            		{
            			a += 0.15 * 0.3;
            		}
            		if (boots == DivineRPG.finishedBoots)
            		{
            			a += 0.15 * 0.1;
            		}

            		e.ammount *= 1 - a;
            	}
            }

            //finished Arcana
            else if (helmet == DivineRPG.finishedHelmetArcana)
            {
            	if (this.isArcana(s))
            	{
            		double a = 0.15 * 0.2;
            		if (body == DivineRPG.finishedChest)
            		{
            			a += 0.15 * 0.4;
            		}
            		if (legs == DivineRPG.finishedLegs)
            		{
            			a += 0.15 * 0.3;
            		}
            		if (boots == DivineRPG.finishedBoots)
            		{
            			a += 0.15 * 0.1;
            		}

            		e.ammount *= 1 - a;
            	}
            }

            //demonized Melee
            else if (helmet == DivineRPG.demonizedHelmetMelee)
            {
            	if (this.isMelee(s))
            	{
            		double a = 0.15 * 0.2;
            		if (body == DivineRPG.demonizedChest)
            		{
            			a += 0.15 * 0.4;
            		}
            		if (legs == DivineRPG.demonizedLegs)
            		{
            			a += 0.15 * 0.3;
            		}
            		if (boots == DivineRPG.demonizedBoots)
            		{
            			a += 0.15 * 0.1;
            		}

            		e.ammount *= 1 - a;
            	}
            }

            //demonized Ranged
            else if (helmet == DivineRPG.demonizedHelmetRanged)
            {
            	if (this.isRanged(s))
            	{
            		double a = 0.15 * 0.2;
            		if (body == DivineRPG.demonizedChest)
            		{
            			a += 0.15 * 0.4;
            		}
            		if (legs == DivineRPG.demonizedLegs)
            		{
            			a += 0.15 * 0.3;
            		}
            		if (boots == DivineRPG.demonizedBoots)
            		{
            			a += 0.15 * 0.1;
            		}

            		e.ammount *= 1 - a;
            	}
            }

            //demonized Arcana
            else if (helmet == DivineRPG.demonizedHelmetArcana)
            {
            	if (this.isArcana(s))
            	{
            		double a = 0.15 * 0.2;
            		if (body == DivineRPG.demonizedChest)
            		{
            			a += 0.15 * 0.4;
            		}
            		if (legs == DivineRPG.demonizedLegs)
            		{
            			a += 0.15 * 0.3;
            		}
            		if (boots == DivineRPG.demonizedBoots)
            		{
            			a += 0.15 * 0.1;
            		}

            		e.ammount *= 1 - a;
            	}
            }

            //tormented Melee
            else if (helmet == DivineRPG.tormentedHelmetMelee)
            {
            	if (this.isMelee(s))
            	{
            		double a = 0.15 * 0.2;
            		if (body == DivineRPG.tormentedChest)
            		{
            			a += 0.15 * 0.4;
            		}
            		if (legs == DivineRPG.tormentedLegs)
            		{
            			a += 0.15 * 0.3;
            		}
            		if (boots == DivineRPG.tormentedBoots)
            		{
            			a += 0.15 * 0.1;
            		}

            		e.ammount *= 1 - a;
            	}
            }

            //tormented Ranged
            else if (helmet == DivineRPG.tormentedHelmetRanged)
            {
            	if (this.isRanged(s))
            	{
            		double a = 0.15 * 0.2;
            		if (body == DivineRPG.tormentedChest)
            		{
            			a += 0.15 * 0.4;
            		}
            		if (legs == DivineRPG.tormentedLegs)
            		{
            			a += 0.15 * 0.3;
            		}
            		if (boots == DivineRPG.tormentedBoots)
            		{
            			a += 0.15 * 0.1;
            		}

            		e.ammount *= 1 - a;
            	}
            }

            //tormented Arcana
            else if (helmet == DivineRPG.tormentedHelmetArcana)
            {
            	if (this.isArcana(s))
            	{
            		double a = 0.15 * 0.2;
            		if (body == DivineRPG.tormentedChest)
            		{
            			a += 0.15 * 0.4;
            		}
            		if (legs == DivineRPG.tormentedLegs)
            		{
            			a += 0.15 * 0.3;
            		}
            		if (boots == DivineRPG.tormentedBoots)
            		{
            			a += 0.15 * 0.1;
            		}

            		e.ammount *= 1 - a;
            	}
            }
            }*/
        }
    }

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
                ArcanaHelper.removeBarValue(1);
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
        if ((size != 1) && (boots == TwilightItemsArmor.haliteBoots && legs == TwilightItemsArmor.haliteLegs && body == TwilightItemsArmor.haliteBody && helmet == TwilightItemsArmor.haliteHelmet))
        	size = 1;
        else if (size == 1)
        	size = 0;
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
            if (boots == TwilightItemsArmor.skythernBoots && body == TwilightItemsArmor.skythernBody && legs == TwilightItemsArmor.skythernLegs && helmet == TwilightItemsArmor.skythernHelmet) {
                player.addVelocity(0, 0.5D, 0);
            }

        }
    }

    @SubscribeEvent
    public void onInteractEvent(PlayerInteractEvent event) {
        ItemStack stackBoots = event.entityPlayer.inventory.armorItemInSlot(0);
        ItemStack stackLegs = event.entityPlayer.inventory.armorItemInSlot(1);
        ItemStack stackBody = event.entityPlayer.inventory.armorItemInSlot(2);
        ItemStack stackHelmet = event.entityPlayer.inventory.armorItemInSlot(3);

        if (stackBoots != null) boots = stackBoots.getItem();
        else boots = null;

        if (stackBody != null) body = stackBody.getItem();
        else body = null;

        if (stackLegs != null) legs = stackLegs.getItem();
        else legs = null;

        if (stackHelmet != null) helmet = stackHelmet.getItem();
        else helmet = null;

        //Eden
        if (boots == TwilightItemsArmor.edenBoots && body == TwilightItemsArmor.edenBody && legs == TwilightItemsArmor.edenLegs && helmet == TwilightItemsArmor.edenHelmet) {
            Random rand = new Random();
            BlockMod.edenArmor = rand.nextInt(3) + 3;
        } else {
            BlockMod.edenArmor = 1;
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
            if (boots == TwilightItemsArmor.apalachiaBoots && legs == TwilightItemsArmor.apalachiaLegs && body == TwilightItemsArmor.apalachiaBody && helmet == TwilightItemsArmor.apalachiaHelmet) {
                if (s.equals(DamageSource.cactus) || s.equals(DamageSource.fallingBlock) || s.equals(DamageSource.anvil) || s.equals(DamageSource.inWall)) {
                    e.setCanceled(true);
                }
            }

            //Wither Reaper
            if (boots == VanillaItemsArmor.witherReaperBoots && legs == VanillaItemsArmor.witherReaperLegs && body == VanillaItemsArmor.witherReaperBody && helmet == VanillaItemsArmor.witherReaperHelmet) {
                if (s.equals(DamageSource.wither)) {
                    e.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public void onLivingHurtEvent(LivingHurtEvent e) {
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
        }

        if (!(e.entity instanceof EntityPlayer)) {
            DamageSource s = e.source;

            //Santa
            if (boots == IceikaItems.santaBoots && body == IceikaItems.santaBody && legs == IceikaItems.santaLegs && helmet == IceikaItems.santaHead) {
                if ((e.entityLiving.worldObj.provider.dimensionId == ConfigurationHelper.iceika) && ((s.getEntity() instanceof EntityPlayer) && !s.isProjectile())) {
                    e.ammount += 6;
                }
            }

            //Halite
            if (boots == TwilightItemsArmor.haliteBoots && legs == TwilightItemsArmor.haliteLegs && body == TwilightItemsArmor.haliteBody && helmet == TwilightItemsArmor.haliteHelmet) {
                if ((s.getEntity() instanceof EntityPlayer) && !s.isProjectile()) {
                    e.ammount += 24;
                }
            }
        }
    }
}
