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
            Item boots = player.getItemBySlot(EquipmentSlot.FEET).getItem();
            Item legs = player.getItemBySlot(EquipmentSlot.LEGS).getItem();
            Item body = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
            Item helmet = player.getItemBySlot(EquipmentSlot.HEAD).getItem();

            double jumpHeightModifier = 0;

            if (isWearingFullArmor(player, boots, legs, body, helmet, "divine")) {
                jumpHeightModifier = 0.2D;
            }

            if (isWearingFullArmor(player, boots, legs, body, helmet, "skythern")) {
                jumpHeightModifier = 0.5D;
            }

            if (isWearingFullArmor(player, boots, legs, body, helmet, "glistening") && helmet == getArmorItem("glistening", "hood")) {
                jumpHeightModifier = 0.2D;
            }

            if (isWearingFullArmor(player, boots, legs, body, helmet, "demonized") && helmet == getArmorItem("demonized", "hood")) {
                jumpHeightModifier = 0.3D;
            }

            if (isWearingFullArmor(player, boots, legs, body, helmet, "tormented") && helmet == getArmorItem("tormented", "hood")) {
                jumpHeightModifier = 0.4D;
            }

            player.setDeltaMovement(player.getDeltaMovement().add(0, jumpHeightModifier, 0));
        }
    }

    @SubscribeEvent
    public void onPlayerAttackEvent(LivingAttackEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }

        Player player = (Player) e.getEntity();
        Item boots = player.getItemBySlot(EquipmentSlot.FEET).getItem();
        Item legs = player.getItemBySlot(EquipmentSlot.LEGS).getItem();
        Item body = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
        Item helmet = player.getItemBySlot(EquipmentSlot.HEAD).getItem();

        DamageSource source = e.getSource();

        if (isWearingFullArmor(player, boots, legs, body, helmet, "aquastrive")) {
            if (source.equals(DamageSource.DROWN)) {
                e.setCanceled(true);
            }
        } else if (isWearingFullArmor(player, boots, legs, body, helmet, "apalachia")) {
            if (source.isProjectile() || source.equals(DamageSource.CACTUS) || source.equals(DamageSource.fallingBlock(e.getEntity())) || source.equals(DamageSource.anvil(e.getEntity())) || source.equals(DamageSource.IN_WALL) || source.equals(DamageSources.trapSource)) {
                e.setCanceled(true);
            }
        } else if (isWearingFullArmor(player, boots, legs, body, helmet, "wither_reaper")) {
            if (source.equals(DamageSource.WITHER)) {
                e.setCanceled(true);
            }
        } else if (isWearingFullArmor(player, boots, legs, body, helmet, "jungle")) {
            if (source.equals(DamageSource.MAGIC)) {
                e.setCanceled(true);
            }
        } else if (isWearingFullArmor(player, boots, legs, body, helmet, "bedrock")) {
            if (source.isExplosion()) {
                e.setCanceled(true);
            }
        } else if (isWearingFullEnderArmor(player, boots, legs, body, helmet)) {
            if (source.isFire() || source.isExplosion()) {
                e.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public void onLivingHurtEvent(LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof LivingEntity) {
            LivingEntity target = event.getEntity();
            float amount = event.getAmount();
            LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
            Item boots = attacker.getItemBySlot(EquipmentSlot.FEET).getItem();
            Item legs = attacker.getItemBySlot(EquipmentSlot.LEGS).getItem();
            Item body = attacker.getItemBySlot(EquipmentSlot.CHEST).getItem();
            Item helmet = attacker.getItemBySlot(EquipmentSlot.HEAD).getItem();
            DamageSource source = event.getSource();

            if (isWearingFullArmor(attacker, boots, legs, body, helmet, "seng_fur")) {
                if ((attacker.level.dimension() == LevelRegistry.ICEIKA) && ((attacker instanceof Player) && !source.isProjectile() && !source.isMagic())) {
                    event.setAmount(amount + 6);
                    return;
                }
            }

            //Halite
            if (isWearingFullArmor(attacker, boots, legs, body, helmet, "halite")) {
                if (((attacker instanceof Player) && !source.isProjectile() && !source.isMagic())) {
                    event.setAmount(amount + 16);
                    return;
                }
            }

            //Awakened Halite
            if (isWearingFullArmor(attacker, boots, legs, body, helmet, "awakened_halite")) {
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
            if (isWearingFullArmor(attacker, boots, legs, body, helmet, "divine")) {
                if (((attacker instanceof Player) && !source.isProjectile() && !source.isMagic())) {
                    event.setAmount(amount + 6);
                    return;
                }
            }

            //Corrupted
            if (isWearingFullArmor(attacker, boots, legs, body, helmet, "corrupted")) {
                if (attacker instanceof Player && source.isProjectile()) {
                    event.setAmount(amount * 1.5F);
                    return;
                }
            }

            //Vethean
            if (isWearingFullArmor(attacker, boots, legs, body, helmet, "glistening")) {
                if (((attacker instanceof Player) && !source.isProjectile() && !source.isMagic())) {
                    event.setAmount(amount + 3);
                    return;
                }
            }

            if (isWearingFullArmor(attacker, boots, legs, body, helmet, "demonized")) {
                if (((attacker instanceof Player) && !source.isProjectile() && !source.isMagic())) {
                    event.setAmount(amount + 6);
                    return;
                }
            }
            //Tormented
            if (isWearingFullArmor(attacker, boots, legs, body, helmet, "tormented")) {
                if (!event.getSource().isProjectile() && !event.getSource().isMagic()) {
                    event.setAmount(event.getAmount() + 9);
                    return;
                }
            }

            //Arlemite
            if (isWearingFullArmor(attacker, boots, legs, body, helmet, "arlemite")) {
                if (event.getSource().isProjectile() || event.getSource().getMsgId().equals("thrown")) {
                    event.setAmount(event.getAmount() * 0.3F);
                    return;
                }
            }

            //Rupee
            if (isWearingFullArmor(attacker, boots, legs, body, helmet, "rupee")) {
                if (event.getSource().getMsgId().equals("mob") && !event.getSource().isProjectile()) {
                    event.setAmount(event.getAmount() * 0.3F);
                    return;
                }
            }

            //Seng Fur
            if (isWearingFullArmor(attacker, boots, legs, body, helmet, "seng_fur")) {
                if (target.level.dimension() == LevelRegistry.ICEIKA) {
                    event.setAmount(event.getAmount() * 0.2F);
                    return;
                }
            }

            //Vethean
            if (isWearingFullArmor(attacker, boots, legs, body, helmet, "degraded") && (helmet == getArmorItem("degraded", "hood") && source.isMagic() || helmet == getArmorItem("degraded", "helmet") && !source.isProjectile() && !source.isMagic() || helmet == getArmorItem("degraded", "mask") && source.isProjectile() && !source.isMagic())) {
                event.setAmount(amount * 0.82F);
                return;
            }

            if (isWearingFullArmor(attacker, boots, legs, body, helmet, "finished") && (helmet == getArmorItem("finished", "hood") && source.isMagic() || helmet == getArmorItem("finished", "helmet") && !source.isProjectile() && !source.isMagic() || helmet == getArmorItem("finished", "mask") && source.isProjectile() && !source.isMagic())) {
                event.setAmount(amount * 0.773F);
                return;
            }

            if (isWearingFullArmor(attacker, boots, legs, body, helmet, "glistening") && (helmet == getArmorItem("glistening", "hood") && source.isMagic() || helmet == getArmorItem("glistening", "helmet") && !source.isProjectile() && !source.isMagic() || helmet == getArmorItem("glistening", "mask") && source.isProjectile() && !source.isMagic())) {
                event.setAmount(amount * 0.7F);
                return;
            }

            if (isWearingFullArmor(attacker, boots, legs, body, helmet, "demonized") && (helmet == getArmorItem("demonized", "hood") && source.isMagic() || helmet == getArmorItem("demonized", "helmet") && !source.isProjectile() && !source.isMagic() || helmet == getArmorItem("demonized", "mask") && source.isProjectile() && !source.isMagic())) {
                event.setAmount(amount * 0.625F);
                return;
            }

            if (isWearingFullArmor(attacker, boots, legs, body, helmet, "tormented") && (helmet == getArmorItem("tormented", "hood") && source.isMagic() || helmet == getArmorItem("tormented", "helmet") && !source.isProjectile() && !source.isMagic() || helmet == getArmorItem("tormented", "mask") && source.isProjectile() && !source.isMagic())) {
                event.setAmount(amount * 0.348F);
                return;
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
        Item boots = player.getItemBySlot(EquipmentSlot.FEET).getItem();
        Item legs = player.getItemBySlot(EquipmentSlot.LEGS).getItem();
        Item body = player.getItemBySlot(EquipmentSlot.CHEST).getItem();
        Item helmet = player.getItemBySlot(EquipmentSlot.HEAD).getItem();

        if (isWearingFullArmor(player, boots, legs, body, helmet, "angelic")) {
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

        if (isWearingFullArmor(player, boots, legs, body, helmet, "aquastrive")) {
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

        if (isWearingFullArmor(player, boots, legs, body, helmet, "elite_realmite")) {
            evt.player.fallDistance = -0.5F;
        }

        if (isWearingFullArmor(player, boots, legs, body, helmet, "divine")) {
            evt.player.fallDistance = -0.5F;
        }

        // Wildwood armor effect: heal player when in water and apply regeneration when raining
        if (isWearingFullArmor(player, boots, legs, body, helmet, "wildwood")) {
            if (evt.player.isInWater()) {
                float current = evt.player.getHealth();
                if ((current > 0F) && (current < 20F)) {
                    evt.player.heal(.25f);
                }
            }
            if (evt.player.level.isRainingAt(evt.player.blockPosition())) {
                evt.player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20, 1, true, true, true));
            }
        }

        // Korma armor effect: fill player's arcana by 1
        if (isWearingFullArmor(player, boots, legs, body, helmet, "korma")) {
            player.getCapability(ArcanaProvider.ARCANA).ifPresent(arcana -> {
                arcana.fill(evt.player, 1);
            });
        }

        // Vemos armor effect: regenerate player's health by 0.1F if their health is less than 20
        if (isWearingFullArmor(player, boots, legs, body, helmet, "vemos")) {
            float current = evt.player.getHealth();
            if ((current > 0.0F) && (current < 20.0F)) {
                evt.player.setHealth(current + 0.1F);
            }
        }

        // Mortum armor effect: give night vision to the player
        if (isWearingFullArmor(player, boots, legs, body, helmet, "mortum")) {
            evt.player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 210, 10, true, false));
        }

        // Skythern armor effect: reduce fall damage
        if (isWearingFullArmor(player, boots, legs, body, helmet, "skythern")) {
            evt.player.fallDistance = -0.5F;
        }

        // Torridite, Inferno, and Bedrock armor effect: give fire resistance to the player
        if (isWearingFullArmor(player, boots, legs, body, helmet, "torridite") || isWearingFullArmor(player, boots, legs, body, helmet, "inferno") || isWearingFullArmor(player, boots, legs, body, helmet, "bedrock")) {
            evt.player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
        }

        // Shadow armor effect: increase movement speed and max step height
        if (isWearingFullArmor(player, boots, legs, body, helmet, "shadow")) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 2, false, false));
            if (player.getPersistentData().getBoolean("shadow")) {
                evt.player.maxUpStep = 1;
                player.getPersistentData().putBoolean("shadow", false);
            }
        }
        else {
            if (!player.getPersistentData().getBoolean("shadow")) {
                evt.player.maxUpStep = 0.6F;
            }
        }
        //Frozen
        if (isWearingFullArmor(player, boots, legs, body, helmet, "frozen")) {
            List<Mob> entities = evt.player.getCommandSenderWorld().getEntitiesOfClass(Mob.class, evt.player.getBoundingBox().expandTowards(6, 6, 6));
            for (Entity e : entities) {
                ((Mob) e).addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 1, true, false));
            }
        }

        //Terran
        if (isWearingFullArmor(player, boots, legs, body, helmet, "terran")) {
            evt.player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 20, 2, true, false));
        }

        //Skeleman
        if (isWearingFullArmor(player, boots, legs, body, helmet, "skeleman")) {
            if (evt.player.getFoodData().needsFood()) {
                evt.player.getFoodData().eat(1, 0);
            }
        }

        //Seng Fur
        if (isWearingFullArmor(player, boots, legs, body, helmet, "seng_fur")) {
            if (evt.player.level.dimension() == LevelRegistry.ICEIKA) {
                if (evt.player.getFoodData().needsFood()) {
                    evt.player.getFoodData().eat(1, 0);
                }
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 1, false, false));
            }
        }

        // Vethean
        if (isWearingFullArmor(player, boots, legs, body, helmet, "glistening") && helmet == getArmorItem("glistening", "mask")) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 0, false, false));
        }

        if (isWearingFullArmor(player, boots, legs, body, helmet, "demonized") && helmet == getArmorItem("demonized", "mask")) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 1, false, false));
        }

        if (isWearingFullArmor(player, boots, legs, body, helmet, "tormented") && helmet == getArmorItem("tormented", "mask")) {
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3, 2, false, false));
        }

        if (isWearingFullArmor(player, boots, legs, body, helmet, "glistening") && helmet == getArmorItem("glistening", "hood")) {
            evt.player.fallDistance = -0.5F;
        }

        if (isWearingFullArmor(player, boots, legs, body, helmet, "demonized") && helmet == getArmorItem("demonized", "hood")) {
            evt.player.fallDistance = -0.5F;
        }

        if (isWearingFullArmor(player, boots, legs, body, helmet, "tormented") && helmet == getArmorItem("tormented", "hood")) {
            evt.player.fallDistance = -0.5F;
        }

        if (evt.player.inventory.contains(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, "miners_amulet")))))
            evt.player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 1, 2, true, false));

    }



    private boolean isWearingFullArmor(LivingEntity player, Item boots, Item legs, Item body, Item head, String armorName) {
        Item helmet = player.getItemBySlot(EquipmentSlot.HEAD).getItem();
        Item hood = getArmorItem(armorName, "hood");
        Item mask = getArmorItem(armorName, "mask");

        if ((helmet != getArmorItem(armorName, "helmet")) && (helmet != hood) && (helmet != mask)) {
            return false;
        }

        return boots == getArmorItem(armorName, "boots") &&
                legs == getArmorItem(armorName, "leggings") &&
                body == getArmorItem(armorName, "chestplate");
    }

    private boolean isWearingFullEnderArmor(LivingEntity player, Item boots, Item legs, Item body, Item helmet) {
        for (ResourceLocation location : ENDER_ARMOR_LOCATIONS) {
            Item enderArmor = ForgeRegistries.ITEMS.getValue(location);
            if (boots == enderArmor || legs == enderArmor || body == enderArmor || helmet == enderArmor) {
                return false;
            }
        }
        return true;
    }

    private Item getArmorItem(String armorName, String slotName) {
        String fullArmorName = armorName + "_" + slotName;
        Item armorItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, fullArmorName));
        if (armorItem == null) {
            fullArmorName = armorName + "_helmet";
            armorItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, fullArmorName));
        }
        return armorItem;
    }

    private static final ResourceLocation[] ENDER_ARMOR_LOCATIONS = {
            new ResourceLocation(DivineRPG.MODID, "blue_ender_boots"),
            new ResourceLocation(DivineRPG.MODID, "ender_boots"),
            new ResourceLocation(DivineRPG.MODID, "gray_ender_boots"),
            new ResourceLocation(DivineRPG.MODID, "green_ender_boots"),
            new ResourceLocation(DivineRPG.MODID, "red_ender_boots"),
            new ResourceLocation(DivineRPG.MODID, "yellow_ender_boots"),
            new ResourceLocation(DivineRPG.MODID, "blue_ender_leggings"),
            new ResourceLocation(DivineRPG.MODID, "ender_leggings"),
            new ResourceLocation(DivineRPG.MODID, "gray_ender_leggings"),
            new ResourceLocation(DivineRPG.MODID, "green_ender_leggings"),
            new ResourceLocation(DivineRPG.MODID, "red_ender_leggings"),
            new ResourceLocation(DivineRPG.MODID, "yellow_ender_leggings"),
            new ResourceLocation(DivineRPG.MODID, "blue_ender_chestplate"),
            new ResourceLocation(DivineRPG.MODID, "ender_chestplate"),
            new ResourceLocation(DivineRPG.MODID, "gray_ender_chestplate"),
            new ResourceLocation(DivineRPG.MODID, "green_ender_chestplate"),
            new ResourceLocation(DivineRPG.MODID, "red_ender_chestplate"),
            new ResourceLocation(DivineRPG.MODID, "yellow_ender_chestplate"),
            new ResourceLocation(DivineRPG.MODID, "blue_ender_helmet"),
            new ResourceLocation(DivineRPG.MODID, "ender_helmet"),
            new ResourceLocation(DivineRPG.MODID, "gray_ender_helmet"),
            new ResourceLocation(DivineRPG.MODID, "green_ender_helmet"),
            new ResourceLocation(DivineRPG.MODID, "red_ender_helmet"),
            new ResourceLocation(DivineRPG.MODID, "yellow_ender_helmet")
    };
}
