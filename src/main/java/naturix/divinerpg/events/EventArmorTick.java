package naturix.divinerpg.events;

import naturix.divinerpg.Config;
import naturix.divinerpg.registry.ModItems;
import naturix.divinerpg.utils.FullSetArmorHelper;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

import java.util.List;

public class EventArmorTick {

    // private float flyTemp;

    public static final String[] isJumping = new String[] { "field_70703_bu", "isJumping" };
    public static final String[] walkSpeed = new String[] { "field_75097_g", "walkSpeed" };

    //private World world;

    @SubscribeEvent
    public void onTickEvent(PlayerTickEvent evt) {
        EntityPlayer player = evt.player;
        //world = player.world;

        FullSetArmorHelper armorHelper = new FullSetArmorHelper(player);

        float speedMultiplier = 1;


        if (armorHelper.isAngelic()) {
            if (!player.capabilities.isCreativeMode) {
                player.capabilities.allowFlying = true;
            }
        } else if (!player.capabilities.isCreativeMode && player.capabilities.allowFlying) {
            if (!armorHelper.isAngelic()) {
                player.capabilities.allowFlying = false;
                player.capabilities.isFlying = false;
            }
        }

        //Elite Realmite
        if (armorHelper.isEliteRealmite()
            //Divine
            || armorHelper.isDivine()
            // Skythern
            || armorHelper.isSkythern()) {
            player.fallDistance = -0.5F;
        }


        if (armorHelper.isDivine()) {
            player.fallDistance = -0.5F;
        }

        //Wildwood
        if (armorHelper.isWildwood()) {
            if (player.isInsideOfMaterial(Material.WATER)) {
                float current = player.getHealth();
                if ((current > 0.0F) && (current < 20.0F)) {
                    player.heal(0.25f);
                }
            }
        }

        //Korma
        if (armorHelper.isKorma()) {
            //        	ArcanaHelper.getProperties(player).regen(1);
            player.heal(1);
        }

        //Vemos
        if (armorHelper.isVemos()) {
            float current = player.getHealth();
            if ((current > 0.0F) && (current < 20.0F)) {
                player.setHealth(current + 0.1F);
            }
        }

        //Mortum
        if (armorHelper.isMortum()) {
            player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 210, 10, true, false));
        }

        //Netherite, Inferno, and Bedrock
        if (armorHelper.isNetherite()
            || armorHelper.isInfernal()
            || armorHelper.isBedrock()) {
            player.extinguish();
            player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
        }

        //Aquastrive
        if (armorHelper.isAquastrive()) {
            float speed = 1.1F;
            boolean isJumping = false;
            isJumping = (Boolean) ObfuscationReflectionHelper.getPrivateValue(EntityLivingBase.class, player,
                    EventArmorTick.isJumping);

            if (player.isInWater()) {
                if (!player.isSneaking() && !isJumping) {
                    if (player.motionX > -speed && player.motionX < speed) {
                        player.motionX *= speed;
                        player.motionY = 0F;
                    }
                    if (player.motionZ > -speed && player.motionZ < speed) {
                        player.motionZ *= speed;
                        player.motionY = 0F;
                    }
                }
                if (isJumping || player.isSneaking()) {
                    player.motionY *= speed;
                    if (player.motionX > -speed && player.motionX < speed) {
                        player.motionX *= speed;
                    }
                    if (player.motionZ > -speed && player.motionZ < speed) {
                        player.motionZ *= speed;
                    }
                }
            }
        }

        //Shadow
        if (armorHelper.isShadow()) {
            speedMultiplier = 3;
        }

        //Frozen
        if (armorHelper.isFrozen()
                && !player.world.isRemote
                && Ticker.tick % 10 == 0) {
            List<Entity> entities = player.world.getEntitiesWithinAABB(EntityMob.class,
                    player.getEntityBoundingBox().expand(6, 6, 6));
            for (Entity e : entities) {
                ((EntityMob) e).addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, 40, 1, true, false));
            }
        }

        //Terran
        if (armorHelper.isTerran()) {
            player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 20, 2, true, false));
        }

        //Skeleman
        if (armorHelper.isSkeleman()) {
            if (player.getFoodStats().needFood()) {
                player.getFoodStats().addStats(1, 0);
            }
        }

        //Santa
        if (armorHelper.isSanta()) {
            if (player.world.provider.getDimension() == Config.iceikaDimensionId) {
                if (player.getFoodStats().needFood()) {
                    player.getFoodStats().addStats(1, 0);
                }
                speedMultiplier = 2;
            }
        }

        //Vethean
        if (armorHelper.isGlistening(ModItems.glisteningMask)) {
            speedMultiplier = 1.4f;
        }

        if (armorHelper.isDemonised(ModItems.demonizedMask)) {
            speedMultiplier = 1.8f;
        }

        if (armorHelper.isTormented(ModItems.tormentedMask)) {
            speedMultiplier = 2.2f;
        }

        ObfuscationReflectionHelper.setPrivateValue(PlayerCapabilities.class, player.capabilities,
                0.1f * speedMultiplier, walkSpeed);

        if (armorHelper.isGlistening(ModItems.glisteningHood)) {
            player.fallDistance = -0.5F;
        }

        if (armorHelper.isDemonised(ModItems.demonizedHood)) {
            player.fallDistance = -0.5F;
        }

        if (armorHelper.isTormented(ModItems.tormentedHood)) {
            player.fallDistance = -0.5F;
        }

        if (player.inventory.hasItemStack(new ItemStack(ModItems.minersAmulet)))
            player.addPotionEffect(new PotionEffect(MobEffects.HASTE, 1, 2, true, false));
    }
}