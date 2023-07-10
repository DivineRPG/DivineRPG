package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.effect.mob.armor.*;
import divinerpg.enums.ArmorStats;
import divinerpg.items.base.ItemDivineArmor;
import divinerpg.registries.MobEffectRegistry;
import divinerpg.util.DamageSources;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;

public class ArmorAbilitiesEvent {
	@SubscribeEvent
	public void onJoinWorld(EntityJoinLevelEvent event) {
		if(event.getEntity() instanceof LivingEntity entity) {
			for(MobEffectInstance instance : entity.getActiveEffects()) if(instance.isInfiniteDuration()) entity.removeEffect(instance.getEffect());
			updateAbilities(entity);
		}
	}
	@SubscribeEvent
	public void onEquipmentChanged(LivingEquipmentChangeEvent event) {
		LivingEntity entity = event.getEntity();
		if(event.getSlot().isArmor()) updateAbilities(entity);
		else for(MobEffectInstance instance : entity.getActiveEffects()) if(instance.getEffect() instanceof UpdatableArmorEffect update) update.update(entity);
	}
	public static void updateAbilities(LivingEntity entity) {
		ArrayList<MobEffect> effectRemoval = new ArrayList<>();
		if(entity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof ItemDivineArmor helmet && helmet.supportedEffects != null) {
			MobEffect effects[] = helmet.supportedEffects;
			for(MobEffectInstance instance : entity.getActiveEffects()) if(instance instanceof ArmorEffectInstance) { //remove all armor effects that do not match the helmet
				MobEffect effect = instance.getEffect();
				boolean dump = true;
				for(MobEffect supportedEffect : effects) if(effect == supportedEffect) dump = false;
				if(dump) effectRemoval.add(effect);
			}
			if(isWearingFullArmor(entity, (ArmorStats) helmet.getMaterial())) { //add missing effects if full armor set is equipped, otherwise remove them
    			for(int i = 0; i < effects.length; i++) {
    				MobEffect effect = effects[i];
    				if(!entity.hasEffect(effect) || !entity.getEffect(effect).isInfiniteDuration()) entity.addEffect(new ArmorEffectInstance(effect, helmet.amplifier == null ? 0 : helmet.amplifier[i]));
        			else if(effect instanceof UpdatableArmorEffect update) update.update(entity);
    			}
    		} else for(MobEffect effect : effects) entity.removeEffect(effect);
		} else for(MobEffectInstance instance : entity.getActiveEffects()) if(instance instanceof ArmorEffectInstance) effectRemoval.add(instance.getEffect());  //remove all armor effects
		for(MobEffect effect : effectRemoval) entity.removeEffect(effect);
	}
    private static boolean isWearingFullArmor(LivingEntity entity, ArmorStats type) {
    	boolean b = true;
    	Item pieces[] = new Item[] {
    			entity.getItemBySlot(EquipmentSlot.FEET).getItem(),
    			entity.getItemBySlot(EquipmentSlot.LEGS).getItem(),
    			entity.getItemBySlot(EquipmentSlot.CHEST).getItem()
    	};
    	for(int i = 0; b && i < 3; i++) if(!(pieces[i] instanceof ItemDivineArmor armor && armor.getMaterial() == type)) b = false;
    	return b;
    }
    public static Item getArmorItem(String armorName, String slotName) {
        String fullArmorName = armorName + "_" + slotName;
        Item armorItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, fullArmorName));
        if(armorItem == null) {
            fullArmorName = armorName + "_helmet";
            armorItem = ForgeRegistries.ITEMS.getValue(new ResourceLocation(DivineRPG.MODID, fullArmorName));
        } return armorItem;
    }

    @SubscribeEvent
    public void onLivingHurtEvent(LivingDamageEvent event) {
    	LivingEntity target = event.getEntity();
        float amount = event.getAmount();
        Entity entity = event.getSource().getEntity();
        DamageSource source = event.getSource();
        
        if(entity instanceof Player attacker) {
        	if(source.is(DamageTypes.PLAYER_ATTACK)) {
        		if(attacker.hasEffect(MobEffectRegistry.HALITE_STRENGTH.get())) event.setAmount(amount + 16);
        		else if(attacker.hasEffect(MobEffectRegistry.DIVINE_STRENGTH.get()) || attacker.hasEffect(MobEffectRegistry.DEMONIZED_HELMET.get())) event.setAmount(amount + 6);
        		else if(attacker.hasEffect(MobEffectRegistry.GLISTENING_HELMET.get())) event.setAmount(amount + 3);
        		else if(attacker.hasEffect(MobEffectRegistry.SENG_FUR.get())) event.setAmount(amount + 2);
        		else if(attacker.hasEffect(MobEffectRegistry.TORMENTED_HELMET.get())) event.setAmount(amount + 9);
        		else if(attacker.hasEffect(MobEffectRegistry.AWAKENED_HALITE_STRENGTH.get())) event.setAmount(amount + 20);
        	} else if(attacker.hasEffect(MobEffectRegistry.AWAKENED_HALITE_STRENGTH.get()) && (source.is(DamageTypes.MOB_PROJECTILE) || source.is(DamageTypes.ARROW))) event.setAmount(amount * 1.5F);
            else if(attacker.hasEffect(MobEffectRegistry.CORRUPTED_STRENGTH.get()) && (source.is(DamageTypes.MOB_PROJECTILE) || source.is(DamageTypes.ARROW) || source.is(DamageTypes.THROWN) || source.is(DamageTypes.TRIDENT))) {
            	event.setAmount(amount * 1.5F);
            }
        }
        if(target instanceof Player) {
            if((target.hasEffect(MobEffectRegistry.PROJECTILE_PROTECTION.get()) && (source.is(DamageTypes.MOB_PROJECTILE) || source.is(DamageTypes.ARROW) || source.is(DamageTypes.THROWN) || source.is(DamageTypes.TRIDENT)))
            		|| (target.hasEffect(MobEffectRegistry.MELEE_PROTECTION.get()) && (source.is(DamageTypes.MOB_ATTACK) || source.is(DamageTypes.PLAYER_ATTACK) || source.is(DamageTypes.GENERIC)) && !source.is(DamageTypes.MOB_PROJECTILE))) {
                event.setAmount(event.getAmount() * .34F);
            } else if(target.hasEffect(MobEffectRegistry.SENG_FUR.get())) {
            	event.setAmount(event.getAmount() * .2F);
            } else if((target.hasEffect(MobEffectRegistry.DEGRADED_HOOD.get()) && source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.DEGRADED_HELMET.get()) && !source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.DEGRADED_MASK.get()) && source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))) {
                event.setAmount(amount * .82F);
            } else if((target.hasEffect(MobEffectRegistry.FINISHED_HOOD.get()) && source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.FINISHED_HELMET.get()) && !source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.FINISHED_MASK.get()) && source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))) {
                event.setAmount(amount * .773F);
            } else if((target.hasEffect(MobEffectRegistry.GLISTENING_HOOD.get()) && source.is(DamageTypes.MAGIC)
            		|| (target.hasEffect(MobEffectRegistry.GLISTENING_HELMET.get()) && !source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.GLISTENING_MASK.get()) && source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC)))) {
                event.setAmount(amount * .7F);
            } else if((target.hasEffect(MobEffectRegistry.DEMONIZED_HOOD.get()) && source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.DEMONIZED_HELMET.get()) && !source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.DEMONIZED_MASK.get()) && source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))) {
                event.setAmount(amount * .625F);
            } else if((target.hasEffect(MobEffectRegistry.TORMENTED_HOOD.get()) && source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.TORMENTED_HELMET.get()) && !source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.TORMENTED_MASK.get()) && source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))) {
                event.setAmount(amount * .348F);
            } else if(target.hasEffect(MobEffectRegistry.BLOCK_PROTECTION.get()) && (source.is(DamageTypes.MOB_PROJECTILE) || source.is(DamageTypes.CACTUS) || source.equals(target.damageSources().fallingBlock(target)) || source.equals(target.damageSources().anvil(target)) || source.equals(target.damageSources().inWall()) || source.equals(DamageSources.source(target.level(), DamageSources.TRAP)))) {
            	event.setCanceled(true);
            } else if(target.hasEffect(MobEffectRegistry.EXPLOSION_PROTECTION.get()) && (source.is(DamageTypes.EXPLOSION) || source.is(DamageTypes.PLAYER_EXPLOSION))) event.setCanceled(true);
        }
    }
}
