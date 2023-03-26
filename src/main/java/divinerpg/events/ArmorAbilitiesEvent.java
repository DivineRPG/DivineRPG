package divinerpg.events;

import divinerpg.DivineRPG;
import divinerpg.effect.mob.armor.*;
import divinerpg.items.base.ItemDivineArmor;
import divinerpg.registries.MobEffectRegistry;
import divinerpg.util.DamageSources;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;

public class ArmorAbilitiesEvent {
	@SubscribeEvent
	public void onEquipmentChanged(LivingEquipmentChangeEvent event) {
		if(event.getSlot().isArmor()) updateAbilities(event.getEntity());
		else {
			LivingEntity entity = event.getEntity();
			for(MobEffectInstance instance : entity.getActiveEffects()) if(instance.getEffect() instanceof UpdatableArmorEffect update) update.update(entity);
		}
	}
	public static void updateAbilities(LivingEntity entity) {
		ArrayList<MobEffect> effectRemoval = new ArrayList<>();
		if(entity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof ItemDivineArmor helmet && helmet.supportedEffects != null) {
			MobEffect effects[] = helmet.supportedEffects;
			for(MobEffectInstance instance : entity.getActiveEffects()) if(instance.isInfiniteDuration()) { //remove all armor effects that do not match the helmet
				MobEffect effect = instance.getEffect();
				boolean dump = true;
				for(MobEffect supportedEffect : effects) if(effect == supportedEffect) dump = false;
				if(dump) effectRemoval.add(effect);
			}
			if(isWearingFullArmor(entity, helmet.armorInfo.armorName)) { //add missing effects if full armor set is equipped, otherwise remove them
    			for(MobEffect effect : effects) {
    				if(!entity.hasEffect(effect) || !entity.getEffect(effect).isInfiniteDuration()) entity.addEffect(new MobEffectInstance(effect, -1, helmet.amplifier, true, false));
        			else if(effect instanceof UpdatableArmorEffect update) update.update(entity);
    			}
    		} else for(MobEffect effect : effects) entity.removeEffect(effect);
		} else for(MobEffectInstance instance : entity.getActiveEffects()) if(instance.isInfiniteDuration()) effectRemoval.add(instance.getEffect());  //remove all armor effects
		for(MobEffect effect : effectRemoval) entity.removeEffect(effect);
	}
    private static boolean isWearingFullArmor(LivingEntity entity, String armorName) {
    	boolean b = true;
    	Item pieces[] = new Item[] {
    			entity.getItemBySlot(EquipmentSlot.FEET).getItem(),
    			entity.getItemBySlot(EquipmentSlot.LEGS).getItem(),
    			entity.getItemBySlot(EquipmentSlot.CHEST).getItem()
    	};
    	for(int i = 0; b && i < 3; i++) if(!(pieces[i] instanceof ItemDivineArmor armor && armor.armorInfo.armorName.equals(armorName))) b = false;
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
    public void onPlayerAttackEvent(LivingAttackEvent e) {
        if(!(e.getEntity() instanceof Player)) return;
        Player player = (Player) e.getEntity();
        DamageSource source = e.getSource();
        
        if(player.hasEffect(MobEffectRegistry.BLOCK_PROTECTION.get()) && source.is(DamageTypes.MOB_PROJECTILE) || source.is(DamageTypes.CACTUS) || source.equals(player.damageSources().fallingBlock(player)) || source.equals(player.damageSources().anvil(e.getEntity())) || source.equals(player.damageSources().inWall()) || source.equals(DamageSources.source(e.getEntity().level, DamageSources.TRAP))) {
            e.setCanceled(true);
        }
        if(player.hasEffect(MobEffectRegistry.EXPLOSION_PROTECTION.get()) && source.is(DamageTypes.EXPLOSION)) e.setCanceled(true);
    }

    @SubscribeEvent
    public void onLivingHurtEvent(LivingDamageEvent event) {
        if(event.getSource().getEntity() instanceof LivingEntity) {
            LivingEntity target = event.getEntity();
            float amount = event.getAmount();
            LivingEntity attacker = (LivingEntity) event.getSource().getEntity();
            DamageSource source = event.getSource();
            
            if(attacker instanceof Player) {
            	if(attacker.hasEffect(MobEffectRegistry.HALITE_STRENGTH.get()) && !source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC)) {
                	event.setAmount(amount + 16);
                } else if(attacker.hasEffect(MobEffectRegistry.AWAKENED_HALITE_STRENGTH.get())) {
                	if(source.is(DamageTypes.MOB_PROJECTILE)) event.setAmount(amount * 1.5F);
                	else if(!source.is(DamageTypes.MAGIC)) event.setAmount(amount + 20);
                } else if((attacker.hasEffect(MobEffectRegistry.DIVINE_STRENGTH.get()) || attacker.hasEffect(MobEffectRegistry.DEMONIZED_HELMET.get())) && !source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC)) {
                	event.setAmount(amount + 6);
                } else if(attacker.hasEffect(MobEffectRegistry.CORRUPTED_STRENGTH.get()) && source.is(DamageTypes.MOB_PROJECTILE)) {
                	event.setAmount(amount * 1.5F);
                } else if(attacker.hasEffect(MobEffectRegistry.GLISTENING_HELMET.get()) && !source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC)) {
                    event.setAmount(amount + 3);
                } else if(attacker.hasEffect(MobEffectRegistry.TORMENTED_HELMET.get()) && !source.is(DamageTypes.MOB_PROJECTILE) && !source.is(DamageTypes.MAGIC)) {
                    event.setAmount(amount + 9);
                }
            }
            if(target instanceof Player) {
                if((target.hasEffect(MobEffectRegistry.PROJECTILE_PROTECTION.get()) && source.is(DamageTypes.MOB_PROJECTILE) || event.getSource().getMsgId().equals("thrown"))
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
                }
            }
        }
    }
}
