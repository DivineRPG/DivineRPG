package divinerpg.events;

import divinerpg.attachments.Arcana;
import divinerpg.effect.mob.armor.*;
import divinerpg.enums.ToolStats.SwordSpecial;
import divinerpg.items.base.*;
import divinerpg.registries.MobEffectRegistry;
import divinerpg.util.DamageSources;
import net.minecraft.core.Holder;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.*;
import java.util.ArrayList;

public class ArmorAbilitiesEvent {
	@SubscribeEvent
	public void onEquipmentChanged(LivingEquipmentChangeEvent event) {
		LivingEntity entity = event.getEntity();
		EquipmentSlot slot = event.getSlot();
		if(slot.isArmor()) {
			ItemStack s = event.getFrom();//remove armor effects of the previous armor piece
			if(s != null && s.getItem() instanceof ItemDivineArmor armor && !s.is(event.getTo().getItem()) && armor.supportedEffects != null) for(Holder<MobEffect> effect : armor.supportedEffects) entity.removeEffect(effect);
			updateAbilities(entity);
		} else for(MobEffectInstance instance : entity.getActiveEffects()) if(instance.getEffect() instanceof UpdatableArmorEffect update) update.update(entity);
	}
	public static void updateAbilities(LivingEntity entity) {
		ArrayList<Holder<MobEffect>> supportedEffects = new ArrayList<>();
		ArrayList<Integer> amplifiers = new ArrayList<>();
		ItemStack[] stack = {entity.getItemBySlot(EquipmentSlot.HEAD), entity.getItemBySlot(EquipmentSlot.CHEST), entity.getItemBySlot(EquipmentSlot.LEGS), entity.getItemBySlot(EquipmentSlot.FEET)};
		ArrayList<ItemDivineArmor> equipment = new ArrayList<>();
		for(ItemStack s : stack) if(s != null && s.getItem() instanceof ItemDivineArmor armor) equipment.add(armor);//list all divine armor pieces
		for(ItemDivineArmor armor : equipment) if(armor.supportedEffects != null) for(int i = 0; i < armor.supportedEffects.length; i++) {//list all theoretically supported armor effects and their amplifiers
			Holder<MobEffect> supportedEffect = armor.supportedEffects[i];
			if(!supportedEffects.contains(supportedEffect)) {
				supportedEffects.add(supportedEffect);
				amplifiers.add(armor.amplifier == null ? 0 : armor.amplifier[i]);
			}
		} boolean fullArmor = equipment.size() == 4;
		if(fullArmor) {
			ArmorMaterial mat = equipment.get(0).getMaterial().value();
			for(int i = 1; fullArmor && i < 4; i++) if(equipment.get(i).getMaterial().value() != mat) fullArmor = false;//check if all armor pieces are of the same type
			if(fullArmor) for(int i = 0; i < supportedEffects.size(); i++) {//apply all not yet present supported effects with their respected amplifiers
				MobEffectInstance instance;
				Holder<MobEffect> supportedEffect = supportedEffects.get(i);
				boolean shouldRemove = false;
				if(!entity.hasEffect(supportedEffect) || (shouldRemove = !(instance = entity.getEffect(supportedEffect)).isInfiniteDuration() || !(instance instanceof ArmorEffectInstance))) {
					if(shouldRemove) entity.removeEffect(supportedEffect);
					entity.addEffect(new ArmorEffectInstance(supportedEffect, amplifiers.get(i)));
				} else if(supportedEffect instanceof UpdatableArmorEffect update) update.update(entity);
			}
		}//the following if case is intentionally not an else case
		if(!fullArmor) for(Holder<MobEffect> supportedEffect : supportedEffects) if(entity.hasEffect(supportedEffect) && entity.getEffect(supportedEffect).isInfiniteDuration()) entity.removeEffect(supportedEffect);//remove all theoretically supported effects if full armor set is not present
	}
    @SubscribeEvent
    public void onLivingHurtEvent(LivingDamageEvent.Pre event) {
    	LivingEntity target = event.getEntity();
        float amount = event.getNewDamage();
        Entity entity = event.getSource().getEntity();
        DamageSource source = event.getSource();
        if(entity instanceof Player attacker) {
        	if(source.is(DamageTypes.PLAYER_ATTACK)) {
        		ItemStack item = attacker.getItemInHand(InteractionHand.MAIN_HAND);
        		if(item.getItem() instanceof ItemModSword sword && sword.arcanaConsumedAttack != 0) {
        			if(Arcana.hasArcana(attacker) && Arcana.getAmount(attacker) >= sword.arcanaConsumedAttack) {
    					Arcana.modifyAmount(attacker, -sword.arcanaConsumedAttack);
    					if(sword.sword.getSwordSpecial() == SwordSpecial.ARCANA_DAMAGE) event.setNewDamage(amount + CombatRules.getDamageAfterAbsorb(target, sword.sword.effectPower, source, target.getArmorValue(), (float)target.getAttributeValue(Attributes.ARMOR_TOUGHNESS)));
    					sword.arcanicAttack(item, attacker, target);
        			}
        		}
        		if(attacker.hasEffect(MobEffectRegistry.HALITE_STRENGTH))
					event.setNewDamage(amount + CombatRules.getDamageAfterAbsorb(target, 16, source, target.getArmorValue(), (float)target.getAttributeValue(Attributes.ARMOR_TOUGHNESS)));
        		else if(attacker.hasEffect(MobEffectRegistry.DIVINE_STRENGTH) || attacker.hasEffect(MobEffectRegistry.DEMONIZED_HELMET))
					event.setNewDamage(amount + CombatRules.getDamageAfterAbsorb(target, 6, source, target.getArmorValue(), (float)target.getAttributeValue(Attributes.ARMOR_TOUGHNESS)));
        		else if(attacker.hasEffect(MobEffectRegistry.GLISTENING_HELMET))
					event.setNewDamage(amount + CombatRules.getDamageAfterAbsorb(target, 3, source, target.getArmorValue(), (float)target.getAttributeValue(Attributes.ARMOR_TOUGHNESS)));
        		else if(attacker.hasEffect(MobEffectRegistry.SENG_FUR_STRENGTH))
					event.setNewDamage(amount + CombatRules.getDamageAfterAbsorb(target, 2, source, target.getArmorValue(), (float)target.getAttributeValue(Attributes.ARMOR_TOUGHNESS)));
        		else if(attacker.hasEffect(MobEffectRegistry.TORMENTED_HELMET))
					event.setNewDamage(amount + CombatRules.getDamageAfterAbsorb(target, 9, source, target.getArmorValue(), (float)target.getAttributeValue(Attributes.ARMOR_TOUGHNESS)));
        		else if(attacker.hasEffect(MobEffectRegistry.AWAKENED_HALITE_STRENGTH))
					event.setNewDamage(amount + CombatRules.getDamageAfterAbsorb(target, 20, source, target.getArmorValue(), (float)target.getAttributeValue(Attributes.ARMOR_TOUGHNESS)));
        	} else if((attacker.hasEffect(MobEffectRegistry.AWAKENED_HALITE_STRENGTH) || attacker.hasEffect(MobEffectRegistry.CORRUPTED_STRENGTH))
					&& (source.is(DamageTypes.MOB_PROJECTILE) || source.is(DamageTypes.ARROW) || source.is(DamageTypes.THROWN) || source.is(DamageTypes.TRIDENT)))
				event.setNewDamage(amount * 1.5F);
        } if(target instanceof Player) {
            if((target.hasEffect(MobEffectRegistry.PROJECTILE_PROTECTION) && (source.is(DamageTypes.MOB_PROJECTILE) || source.is(DamageTypes.ARROW) || source.is(DamageTypes.THROWN) || source.is(DamageTypes.TRIDENT)))) {
				event.setNewDamage(amount * .34F);
			} else if(target.hasEffect(MobEffectRegistry.MELEE_PROTECTION) && (source.is(DamageTypes.MOB_ATTACK) || source.is(DamageTypes.PLAYER_ATTACK) || source.is(DamageTypes.GENERIC)) && !source.is(DamageTypes.MOB_PROJECTILE)) {
                event.setNewDamage(amount * .67F);
            } else if(target.hasEffect(MobEffectRegistry.SENG_FUR_STRENGTH)) {
            	event.setNewDamage(amount * .7F);
            } else if((target.hasEffect(MobEffectRegistry.DEGRADED_HOOD) && source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.DEGRADED_HELMET) && !source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.DEGRADED_MASK) && source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))) {
                event.setNewDamage(amount * .82F);
            } else if((target.hasEffect(MobEffectRegistry.FINISHED_HOOD) && source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.FINISHED_HELMET) && !source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.FINISHED_MASK) && source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))) {
                event.setNewDamage(amount * .773F);
            } else if((target.hasEffect(MobEffectRegistry.GLISTENING_HOOD) && source.is(DamageTypes.MAGIC)
            		|| (target.hasEffect(MobEffectRegistry.GLISTENING_HELMET) && !source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.GLISTENING_MASK) && source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC)))) {
                event.setNewDamage(amount * .7F);
            } else if((target.hasEffect(MobEffectRegistry.DEMONIZED_HOOD) && source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.DEMONIZED_HELMET) && !source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.DEMONIZED_MASK) && source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))) {
                event.setNewDamage(amount * .625F);
            } else if((target.hasEffect(MobEffectRegistry.TORMENTED_HOOD) && source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.TORMENTED_HELMET) && !source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))
            		|| (target.hasEffect(MobEffectRegistry.TORMENTED_MASK) && source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC))) {
                event.setNewDamage(amount * .348F);
            } else if(target.hasEffect(MobEffectRegistry.BLOCK_PROTECTION) && (source.is(DamageTypes.MOB_PROJECTILE) || source.is(DamageTypes.CACTUS) || source.equals(target.damageSources().fallingBlock(target)) || source.equals(target.damageSources().anvil(target)) || source.equals(target.damageSources().inWall()) || source.equals(DamageSources.source(target.level(), DamageSources.TRAP)))) {
            	event.setNewDamage(0F);
            } else if(target.hasEffect(MobEffectRegistry.EXPLOSION_PROTECTION) && (source.is(DamageTypes.EXPLOSION) || source.is(DamageTypes.PLAYER_EXPLOSION))) event.setNewDamage(0F);
        }
    }
}