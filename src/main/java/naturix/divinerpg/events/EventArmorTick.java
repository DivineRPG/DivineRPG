package naturix.divinerpg.events;

import java.util.List;

import naturix.divinerpg.Config;
import naturix.divinerpg.registry.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

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
		EntityPlayer player = evt.player;
		world = evt.player.world;
        ItemStack stackBoots = evt.player.inventory.armorInventory.get(0);
        ItemStack stackLegs = evt.player.inventory.armorInventory.get(1);
        ItemStack stackBody = evt.player.inventory.armorInventory.get(2);
        ItemStack stackHelmet = evt.player.inventory.armorInventory.get(3);
        
        float speedMultiplier = 1;

        if (stackBoots != null) boots = stackBoots.getItem();
        else boots = null;

        if (stackBody != null) body = stackBody.getItem();
        else body = null;

        if (stackLegs != null) legs = stackLegs.getItem();
        else legs = null;

        if (stackHelmet != null) helmet = stackHelmet.getItem();
        else helmet = null;       
                
        if(boots != ModItems.angelicBoots && body != ModItems.angelicBody && legs != ModItems.angelicLegs && helmet != ModItems.angelicHelmet) {
            if (!player.capabilities.isCreativeMode) {
                player.capabilities.allowFlying = false;
        }
        
//            if (boots == ModItems.angelicBoots && body == ModItems.angelicBody && legs == ModItems.angelicLegs && helmet == ModItems.angelicHelmet && ArcanaHelper.getProperties(evt.player).getBarValue() != 0) {
            	if (boots == ModItems.angelicBoots && body == ModItems.angelicBody && legs == ModItems.angelicLegs && helmet == ModItems.angelicHelmet) {
                        evt.player.fallDistance = -0.5F;
//            evt.player.triggerAchievement(DivineRPGAchievements.whenPigsFly);
            evt.player.capabilities.allowFlying = true;
//            if(evt.player.capabilities.isFlying && !evt.player.capabilities.isCreativeMode && !FlyingHelper.getProperties(evt.player).couldFly) ArcanaHelper.getProperties(evt.player).useBar(0.5f);
//            if(ArcanaHelper.getProperties(evt.player).getBarValue() < 1 && !evt.player.capabilities.isCreativeMode && !FlyingHelper.getProperties(evt.player).couldFly) {
            	evt.player.capabilities.isFlying = false;
            	evt.player.capabilities.allowFlying = false;
//            }
        }
        else if(evt.player.capabilities.allowFlying && !evt.player.capabilities.isCreativeMode){
        	evt.player.capabilities.isFlying = false;
        	evt.player.capabilities.allowFlying = false;
        }
        
        //Elite Realmite
        if (boots == ModItems.eliteRealmiteBoots && body == ModItems.eliteRealmiteBody && legs == ModItems.eliteRealmiteLegs && helmet == ModItems.eliteRealmiteHelmet) {
            evt.player.fallDistance = -0.5F;
        }

        //Divine
        if (boots == ModItems.divineBoots && body == ModItems.divineBody && legs == ModItems.divineLegs && helmet == ModItems.divineHelmet) {
            evt.player.fallDistance = -0.5F;
        }

        //Wildwood
        if (boots == ModItems.wildwoodBoots && body == ModItems.wildwoodChestplate && legs == ModItems.wildwoodLeggings && helmet == ModItems.wildwoodHelmet) {
            if (evt.player.isInsideOfMaterial(Material.WATER)) {
                float current = evt.player.getHealth();
                if ((current > 0.0F) && (current < 20.0F)) {
                    evt.player.heal(0.25f);
                }
            }
        }
        
        //Korma
        if (boots == ModItems.kormaBoots && body == ModItems.kormaBody && legs == ModItems.kormaLegs && helmet == ModItems.kormaHelmet) {
//        	ArcanaHelper.getProperties(evt.player).regen(1);
        	player.heal(1);
        }

        //Vemos
        if (boots == ModItems.vemosBoots && body == ModItems.vemosBody && legs == ModItems.vemosLegs && helmet == ModItems.vemosHelmet) {
            float current = evt.player.getHealth();
            if ((current > 0.0F) && (current < 20.0F)) {
                evt.player.setHealth(current + 0.1F);
            }
        }

        //Mortum
        if (boots == ModItems.mortumBoots && body == ModItems.mortumChestplate && legs == ModItems.mortumLeggings && helmet == ModItems.mortumHelmet) {
            evt.player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 210, 10, true, false));
        }

        //Skythern
        if (boots == ModItems.skythernBoots && body == ModItems.skythernChestplate && legs == ModItems.skythernLeggings && helmet == ModItems.skythernHelmet) {
            evt.player.fallDistance = -0.5F;
        }

        //Netherite, Inferno, and Bedrock
        if ((boots == ModItems.netheriteBoots && legs == ModItems.netheriteLegs && body == ModItems.netheriteBody && helmet == ModItems.netheriteHelmet)
                || (boots == ModItems.infernoBoots && legs == ModItems.infernoLegs && body == ModItems.infernoBody && helmet == ModItems.infernoHelmet)
                || (boots == ModItems.bedrockBoots && legs == ModItems.bedrockLegs && body == ModItems.bedrockBody && helmet == ModItems.bedrockHelmet)) {
            evt.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
        }

        //Aquastrive
        if (boots == ModItems.aquastriveBoots && body == ModItems.aquastriveBody && legs == ModItems.aquastriveLegs && helmet == ModItems.aquastriveHelmet) {
            float speed = 1.1F;
            boolean isJumping = false;
            isJumping = (Boolean) ObfuscationReflectionHelper.getPrivateValue(EntityLivingBase.class, evt.player, EventArmorTick.isJumping);

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
        if (boots == ModItems.shadowBoots && body == ModItems.shadowBody && legs == ModItems.shadowLegs && helmet == ModItems.shadowHelmet) {
            speedMultiplier = 3;
        }
        //Frozen
        if (boots == ModItems.frozenBoots && body == ModItems.frozenBody && legs == ModItems.frozenLegs && helmet == ModItems.frozenHelmet && !evt.player.world.isRemote && Ticker.tick % 10 == 0) {
            List<Entity> entities = evt.player.world.getEntitiesWithinAABB(EntityMob.class, evt.player.getEntityBoundingBox().expand(6, 6, 6));
            for(Entity e : entities) {
            	((EntityMob)e).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 40, 1, true, false));
            }
        }

        //Terran
        if (boots == ModItems.terranBoots && body == ModItems.terranBody && legs == ModItems.terranLegs && helmet == ModItems.terranHelmet) {
            evt.player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 20, 2, true, false));
        }

        //Skeleman
        if (boots == ModItems.skelemanBoots && body == ModItems.skelemanBody && legs == ModItems.skelemanLegs && helmet == ModItems.skelemanHelmet) {
            if (evt.player.getFoodStats().needFood()) {
                evt.player.getFoodStats().addStats(1, 0);
            }
        }

        //Santa
        if (boots == ModItems.santaBoots && body == ModItems.santaTunic && legs == ModItems.santaPants && helmet == ModItems.santaCap) {
            if (evt.player.world.provider.getDimension() == Config.iceikaDimensionId) {
                if (evt.player.getFoodStats().needFood()) {
                    evt.player.getFoodStats().addStats(1, 0);
                }
                speedMultiplier = 2;
            }
        }
        
        //Vethean
        
        if(body == ModItems.glisteningBody && legs == ModItems.glisteningLegs && boots == ModItems.glisteningBoots && helmet == ModItems.glisteningMask) {
        	speedMultiplier = 1.4f;
        }
        
        if(body == ModItems.demonizedBody && legs == ModItems.demonizedLegs && boots == ModItems.demonizedBoots && helmet == ModItems.demonizedMask) {
        	speedMultiplier = 1.8f;
        }
        
        if(body == ModItems.tormentedBody && legs == ModItems.tormentedLegs && boots == ModItems.tormentedBoots && helmet == ModItems.tormentedMask) {
        	speedMultiplier = 2.2f;
        }
        
        ObfuscationReflectionHelper.setPrivateValue(PlayerCapabilities.class, evt.player.capabilities, 0.1f*speedMultiplier, walkSpeed);
        
        if(body == ModItems.glisteningBody && legs == ModItems.glisteningLegs && boots == ModItems.glisteningBoots && helmet == ModItems.glisteningHood) {
        	evt.player.fallDistance = -0.5F;
        }
            
        if(body == ModItems.demonizedBody && legs == ModItems.demonizedLegs && boots == ModItems.demonizedBoots && helmet == ModItems.demonizedHood) {
        	evt.player.fallDistance = -0.5F;
        }
            
        if(body == ModItems.tormentedBody && legs == ModItems.tormentedLegs && boots == ModItems.tormentedBoots && helmet == ModItems.tormentedHood) {
        	evt.player.fallDistance = -0.5F;
        }
        
        if(evt.player.inventory.hasItemStack(new ItemStack(ModItems.minersAmulet))) evt.player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 1, 2, true, false));
    }

}
}