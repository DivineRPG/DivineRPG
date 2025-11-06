package divinerpg.events;

import divinerpg.attachments.Arcana;
import divinerpg.enums.ToolStats;
import divinerpg.items.base.ItemModSword;
import net.minecraft.world.damagesource.*;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

import static divinerpg.enums.ToolStats.SwordSpecial.ARCANA_DAMAGE;
import static net.minecraft.world.InteractionHand.MAIN_HAND;
import static net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS;

public class ToolAbilities {
    @SubscribeEvent
    public void onLivingHurtEvent(LivingDamageEvent.Pre event) {
    	LivingEntity target = event.getEntity();
        float amount = event.getNewDamage();
        Entity entity = event.getSource().getEntity();
        DamageSource source = event.getSource();
        if(entity instanceof Player attacker) {
        	if(source.is(DamageTypes.PLAYER_ATTACK)) {
        		ItemStack item = attacker.getItemInHand(MAIN_HAND);
        		if(item.getItem() instanceof ItemModSword sword) {
					ToolStats s = sword.sword;
					switch(s.getSwordSpecial()) {
						case SLOW -> target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, s.effectSec * 20, s.effectPower));
						case POISON -> target.addEffect(new MobEffectInstance(MobEffects.POISON, s.effectSec * 20, s.effectPower));
						case FLAME -> target.igniteForSeconds(s.effectSec);
					} if(sword.arcanaConsumedAttack != 0) {
						if(Arcana.hasArcana(attacker) && Arcana.getAmount(attacker) >= sword.arcanaConsumedAttack) {
							Arcana.modifyAmount(attacker, -sword.arcanaConsumedAttack);
							if(s.getSwordSpecial() == ARCANA_DAMAGE) event.setNewDamage(amount + CombatRules.getDamageAfterAbsorb(target, s.effectPower, source, target.getArmorValue(), (float)target.getAttributeValue(ARMOR_TOUGHNESS)));
							sword.arcanicAttack(item, attacker, target);
						}
					}
        		}
        	}
        }
    }
}