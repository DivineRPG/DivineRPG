package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.capability.ArcanaProvider;
import divinerpg.registries.LevelRegistry;
import divinerpg.util.DamageSources;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class ArmorAbilitiesEvent {
    @SubscribeEvent
    public void onJump(LivingEvent.LivingJumpEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            Item boots = player.inventory.armor.get(0).getItem();
            Item legs = player.inventory.armor.get(1).getItem();
            Item body = player.inventory.armor.get(2).getItem();
            Item helmet = player.inventory.armor.get(3).getItem();

            //Divine
            if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_helmet"))) {
                player.setDeltaMovement(player.getDeltaMovement().add(0, 0.2D, 0));
            }

            //Skythern
            if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_helmet"))) {
                player.setDeltaMovement(player.getDeltaMovement().add(0, 0.5D, 0));
            }

            //Vethean
            if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_boots")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_hood"))) {
                player.setDeltaMovement(player.getDeltaMovement().add(0, 0.2D, 0));
            }

            if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_boots")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_hoot"))) {
                player.setDeltaMovement(player.getDeltaMovement().add(0, 0.3D, 0));
            }

            if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_boots")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_hood"))) {
                player.setDeltaMovement(player.getDeltaMovement().add(0, 0.4D, 0));
            }

        }
    }

    @SubscribeEvent
    public void onPlayerAttackEvent(LivingAttackEvent e) {
        if (e.getEntity() instanceof Player) {
            Player player = (Player) e.getEntity();

            Item boots = player.getItemBySlot(EquipmentSlot.FEET).getItem();
            Item legs = player.getItemBySlot(EquipmentSlot.LEGS).getItem();
            Item body = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
            Item helmet = player.getItemBySlot(EquipmentSlot.HEAD).getItem();

            DamageSource s = e.getSource();

            if ((boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "aquastrive_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "aquastrive_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "aquastrive_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "aquastrive_helmet")))
                    || (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "kraken_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "kraken_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "kraken_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "kraken_helmet")))) {
                if (s.equals(DamageSource.DROWN)) {
                    e.setCanceled(true);
                }
            }

            if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_boots")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_leggings")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_chestplate")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "apalachia_helmet"))) {
                if (s.equals(DamageSource.CACTUS) || s.equals(DamageSource.FALLING_BLOCK) || s.equals(DamageSource.ANVIL) || s.equals(DamageSource.IN_WALL) || s.equals(DamageSources.trapSource)) {
                    e.setCanceled(true);
                }
            }

            if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wither_reaper_boots")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wither_reaper_leggings")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wither_reaper_chestplate")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wither_reaper_helmet"))) {
                if (s.equals(DamageSource.WITHER)) {
                    e.setCanceled(true);
                }
            }

            if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jungle_boots")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jungle_leggings")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jungle_chestplate")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "jungle_helmet"))) {
                if (s.equals(DamageSource.MAGIC)) {
                    e.setCanceled(true);
                }
            }
            if ((boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "bedrock_boots")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "bedrock_leggings")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "bedrock_chestplate")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "bedrock_helmet")))) {
                if (s.isExplosion()) {
                    e.setCanceled(true);
                }
            }

            //Ender
            if ((boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "ender_boots")) || boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "red_ender_boots")) || boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "yellow_ender_boots")) || boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "green_ender_boots")) || boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_ender_boots")) || boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "gray_ender_boots"))) && (legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "ender_leggings")) || legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "red_ender_leggings")) || legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "yellow_ender_leggings")) || legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "green_ender_leggings")) || legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_ender_leggings")) || legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "gray_ender_leggings"))) && (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "ender_chestplate")) || body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "red_ender_chestplate")) || body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "yellow_ender_chestplate")) || body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "green_ender_chestplate")) || body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_ender_chestplate")) || body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "gray_ender_chestplate"))) && (helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "ender_helmet")) || helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "red_ender_helmet")) || helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "yellow_ender_helmet")) || helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "green_ender_helmet")) || helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_ender_helmet")) || helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "gray_ender_helmet")))) {
                if (s.isExplosion()) {
                    e.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public void onLivingHurtEvent(LivingDamageEvent event) {
        if(event.getSource().getEntity() instanceof LivingEntity) {
            LivingEntity target = event.getEntity();
            float amount = event.getAmount();
            LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
            Item boots = attacker.getItemBySlot(EquipmentSlot.FEET).getItem();
            Item legs = attacker.getItemBySlot(EquipmentSlot.LEGS).getItem();
            Item body = attacker.getItemBySlot(EquipmentSlot.CHEST).getItem();
            Item helmet = attacker.getItemBySlot(EquipmentSlot.HEAD).getItem();
            DamageSource source = event.getSource();

            if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "santa_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "santa_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "santa_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "santa_helmet"))) {
                if ((attacker.level.dimension() == LevelRegistry.ICEIKA) && ((attacker instanceof Player) && !source.isProjectile() && !source.isMagic())) {
                    event.setAmount(amount + 6);
                    return;
                }
            }
            //Halite
            if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "halite_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "halite_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "halite_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "halite_helmet"))) {
                if (((attacker instanceof Player) && !source.isProjectile() && !source.isMagic())) {
                    event.setAmount(amount + 16);
                    return;
                }
            }
            //Awakened Halite
            if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "awakened_halite_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "awakened_halite_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "awakened_halite_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "awakened_halite_helmet"))) {
                if (((attacker instanceof Player) && !source.isProjectile() && !source.isMagic())) {
                    event.setAmount(amount + 20);
                    return;
                }
                if (((attacker instanceof Player) && source.isProjectile())) {
                    event.setAmount(amount * 1.5F);
                    return;
                }
            }
            //Divine
            if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_helmet"))) {
                if (((attacker instanceof Player) && !source.isProjectile() && !source.isMagic())) {
                    event.setAmount(amount + 6);
                    return;
                }
            }

            //Corrupted
            if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "corrupted_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "corrupted_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "corrupted_boots")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "corrupted_helmet"))) {
                if (attacker instanceof Player && source.isProjectile()) {
                    event.setAmount(amount * 1.5F);
                    return;
                }
            }

            //Vethean
            if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_boots")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_helmet"))) {
                if (((attacker instanceof Player) && !source.isProjectile() && !source.isMagic())) {
                    event.setAmount(amount + 3);
                    return;
                }
            }

            if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_boots")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_helmet"))) {
                if (((attacker instanceof Player) && !source.isProjectile() && !source.isMagic())) {
                    event.setAmount(amount + 6);
                    return;
                }
            }
            if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_boots")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_helmet"))) {
                if (((attacker instanceof Player) && !source.isProjectile() && !source.isMagic())) {
                    event.setAmount(amount + 9);
                    return;
                }
            }

            //Arlemite
            if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "arlemite_boots")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "arlemite_leggings")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "arlemite_chestplate")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "arlemite_helmet"))) {
                if (source.isProjectile() || source.msgId.equals("thrown")) {
                    event.setAmount(amount * 0.3F);
                    return;
                }
            }

            //Rupee
            if ((boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "rupee_boots")) || boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "red_rupee_boots")) || boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "yellow_rupee_boots")) || boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "green_rupee_boots")) || boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_rupee_boots")) || boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "gray_rupee_boots"))) && (legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "rupee_leggings")) || legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "red_rupee_leggings")) || legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "yellow_rupee_leggings")) || legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "green_rupee_leggings")) || legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_rupee_leggings")) || legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "gray_rupee_leggings"))) && (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "rupee_chestplate")) || body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "red_rupee_chestplate")) || body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "yellow_rupee_chestplate")) || body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "green_rupee_chestplate")) || body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_rupee_chestplate")) || body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "gray_rupee_chestplate"))) && (helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "rupee_helmet")) || helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "red_rupee_helmet")) || helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "yellow_rupee_helmet")) || helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "green_rupee_helmet")) || helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "blue_rupee_helmet")) || helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "gray_rupee_helmet")))) {
                if ((source.msgId.equals("mob")) && !source.isProjectile()) {
                    event.setAmount(amount * 0.3F);
                    return;
                }
            }

            //Santa
            if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "santa_boots")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "santa_leggings")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "santa_chestplate")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "santa_helmet"))) {
                if (target.level.dimension() == LevelRegistry.ICEIKA) {
                    event.setAmount(amount * 0.2F);
                    return;
                }
            }

            //Vethean

            if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "degraded_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "degraded_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "degraded_boots"))) {
                if ((helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "degraded_helmet")) && !source.isProjectile() && !source.isMagic()) || (helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "degraded_mask")) && source.isProjectile() && !source.isMagic()) || (helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "degraded_hood")) && source.isMagic())) {
                    event.setAmount(amount * 0.82F);
                    return;
                }
            }

            if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "finished_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "finished_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "finished_boots"))) {
                if ((helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "finished_helmet")) && !source.isProjectile() && !source.isMagic()) || (helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "finished_mask")) && source.isProjectile() && !source.isMagic()) || (helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "finished_hood")) && source.isMagic())) {
                    event.setAmount(amount * 0.773F);
                    return;
                }
            }

            if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_boots"))) {
                if ((helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_helmet")) && !source.isProjectile() && !source.isMagic()) || (helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_mask")) && source.isProjectile() && !source.isMagic()) || (helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_hood")) && source.isMagic())) {
                    event.setAmount(amount * 0.7F);
                    return;
                }
            }

            if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_boots"))) {
                if ((helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_helmet")) && !source.isProjectile() && !source.isMagic()) || (helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_mask")) && source.isProjectile() && !source.isMagic()) || (helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_hood")) && source.isMagic())) {
                    event.setAmount(amount * 0.625F);
                    return;
                }
            }

            if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_boots"))) {
                if ((helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_helmet")) && !source.isProjectile() && !source.isMagic()) || (helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_mask")) && source.isProjectile() && !source.isMagic()) || (helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_hood")) && source.isMagic())) {
                    event.setAmount(amount * 0.348F);
                    return;
                }
            }
        }
    }

    private static final String SWIM_MOD_STRING = "c7b490d7-2bfc-400f-b7bb-e89670daea62";
    public static final AttributeModifier SWIM_MOD = new AttributeModifier(SWIM_MOD_STRING, 2.0D, AttributeModifier.Operation.ADDITION);

    @SuppressWarnings("deprecation")
    @SubscribeEvent
    public void onTickEvent(TickEvent.PlayerTickEvent evt) {
        Player player = evt.player;
        AttributeInstance swim = player.getAttribute(ForgeMod.SWIM_SPEED.get());

        Item boots = player.inventory.armor.get(0).getItem();
        Item legs = player.inventory.armor.get(1).getItem();
        Item body = player.inventory.armor.get(2).getItem();
        Item helmet = player.inventory.armor.get(3).getItem();

        if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "angelic_boots")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "angelic_leggings")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "angelic_chestplate")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "angelic_helmet"))) {
            player.getPersistentData().putBoolean("flight_armour", true);
            player.fallDistance = 0;
        } else {
            player.getPersistentData().putBoolean("flight_armour", false);
        }

        if (player.getPersistentData().getBoolean("flight_armour") && !player.getPersistentData().getBoolean("flight_abilities")) {
            player.abilities.mayfly = true;
            player.getPersistentData().putBoolean("flight_abilities", true);
        }
        if (!player.getPersistentData().getBoolean("flight_armour") && player.getPersistentData().getBoolean("flight_abilities")) {
            player.abilities.mayfly = false;
            player.abilities.flying = false;
            player.getPersistentData().putBoolean("flight_abilities", false);
        }

        if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "aquastrive_boots")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "aquastrive_leggings")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "aquastrive_chestplate")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "aquastrive_helmet"))) {
            player.getPersistentData().putBoolean("swim_armour", true);
        } else {
            player.getPersistentData().putBoolean("swim_armour", false);
        }

        if (player.getPersistentData().getBoolean("swim_armour") && !player.getPersistentData().getBoolean("swim_abilities")) {
            swim.addTransientModifier(SWIM_MOD);
            player.getPersistentData().putBoolean("swim_abilities", true);
        }
        if (!player.getPersistentData().getBoolean("swim_armour") && player.getPersistentData().getBoolean("swim_abilities")) {
            swim.removeModifier(SWIM_MOD);
            player.getPersistentData().putBoolean("swim_abilities", false);
        }


        //Elite _realmite
        if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "elite_realmite_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "elite_realmite_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "elite_realmite_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "elite_realmite_helmet"))) {
            evt.player.fallDistance = -0.5F;
        }

        //Divine
        if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "divine_helmet"))) {
            evt.player.fallDistance = -0.5F;
        }

        //Wildwood
        if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "wildwood_helmet"))) {
            if(evt.player.isInWater()) {
                float current = evt.player.getHealth();
                if((current > 0F) && (current < 20F)) evt.player.heal(.25f);
            }
            if(evt.player.level.isRainingAt(evt.player.blockPosition())) evt.player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 1, true, true, true));
        }

        //Korma
        if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "korma_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "korma_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "korma_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "korma_helmet"))) {
            player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
                arcana.fill(evt.player, 1);
            });
        }

        //Vemos
        if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "vemos_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "vemos_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "vemos_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "vemos_helmet"))) {
            float current = evt.player.getHealth();
            if ((current > 0.0F) && (current < 20.0F)) {
                evt.player.setHealth(current + 0.1F);
            }
        }

        //Mortum
        if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "mortum_helmet"))) {
            evt.player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 210, 10, true, false));
        }

        //Skythern
        if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skythern_helmet"))) {
            evt.player.fallDistance = -0.5F;
        }

        //Torridite, Inferno, and Bedrock
        if ((boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "torridite_boots")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "torridite_leggings")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "torridite_chestplate")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "torridite_helmet")))
                || (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "inferno_boots")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "inferno_leggings")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "inferno_chestplate")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "inferno_helmet")))
                || (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "bedrock_boots")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "bedrock_leggings")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "bedrock_chestplate")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "bedrock_helmet")))) {
            evt.player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
        }

        if (player.getPersistentData().get("shadow") == null) {
            player.getPersistentData().putBoolean("shadow", true);
        }

        //Shadow
        if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shadow_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shadow_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shadow_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shadow_helmet"))) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 2, false, false));
            if (player.getPersistentData().getBoolean("shadow")) {
                evt.player.maxUpStep = 1;
                player.getPersistentData().putBoolean("shadow", false);
            }
        }
        if (boots != ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shadow_boots")) || legs != ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shadow_leggings")) || body != ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shadow_chestplate")) || helmet != ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "shadow_helmet"))) {
            if (!player.getPersistentData().getBoolean("shadow")) {
                evt.player.maxUpStep = 0.6F;
            }
            player.getPersistentData().putBoolean("shadow", true);
        }

        //Frozen
        if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "frozen_helmet")) && !evt.player.getCommandSenderWorld().isClientSide) {
            List<Mob> entities = evt.player.getCommandSenderWorld().getEntitiesOfClass(Mob.class, evt.player.getBoundingBox().expandTowards(6, 6, 6));
            for (Entity e : entities) {
                ((Mob) e).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1, true, false));
            }
        }

        //Terran
        if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "terran_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "terran_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "terran_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "terran_helmet"))) {
            evt.player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20, 2, true, false));
        }

        //Skeleman
        if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skeleman_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skeleman_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skeleman_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "skeleman_helmet"))) {
            if (evt.player.getFoodData().needsFood()) {
                evt.player.getFoodData().eat(1, 0);
            }
        }

        //Santa
        if (boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "santa_boots")) && body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "santa_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "santa_leggings")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "santa_helmet"))) {
            if (evt.player.level.dimension() == LevelRegistry.ICEIKA) {
                if (evt.player.getFoodData().needsFood()) {
                    evt.player.getFoodData().eat(1, 0);
                }
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 1, false, false));
            }
        }
        //Vethean

        if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_boots")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_mask"))) {

            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 0, false, false));
        }

        if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_boots")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_mask"))) {

            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 1, false, false));
        }

        if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_boots")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_mask"))) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 2, false, false));
        }

        if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_boots")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "glistening_hood"))) {
            evt.player.fallDistance = -0.5F;
        }

        if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_boots")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "demonized_hood"))) {
            evt.player.fallDistance = -0.5F;
        }

        if (body == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_chestplate")) && legs == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_leggings")) && boots == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_boots")) && helmet == ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "tormented_hood"))) {
            evt.player.fallDistance = -0.5F;
        }

        if (evt.player.inventory.contains(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "miners_amulet")))))
            evt.player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1, 2, true, false));
    }
}