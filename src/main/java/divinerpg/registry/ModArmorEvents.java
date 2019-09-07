package divinerpg.registry;

import divinerpg.api.FullArmorHandler;
import divinerpg.events.armorEvents.ArmorHandlers;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModArmorEvents {

    /**
     * The list of all handlers with isEquipped value
     */
    public static final Map<FullArmorHandler, Boolean> ALL_HANDLERS = new HashMap<>();

    public static void addHandler(FullArmorHandler handler) {
        if (handler == null) {
            throw new IllegalArgumentException("Armor handler is null");
        }

        if (ALL_HANDLERS.containsKey(handler)) {
            throw new IllegalArgumentException("Cannot insert handler twice!");
        }

        ALL_HANDLERS.put(handler, false);
    }

    public static void removeHandler(FullArmorHandler handler) {
        if (handler == null) {
            throw new IllegalArgumentException("Armor handler is null");
        }

        if (!ALL_HANDLERS.containsKey(handler)) {
            throw new IllegalArgumentException("Armor handler was never registered");
        }

        ALL_HANDLERS.remove(handler);
    }

    public static void init() {
        List<FullArmorHandler> handlers = Arrays.asList(
                new FullArmorHandler(ModItems.angelicHelmet, ModItems.angelicBody, ModItems.angelicLegs, ModItems.angelicBoots,
                        ArmorHandlers::onAngelicEquipped)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> ArmorHandlers.onAngelicEquipped(event.player, true)),

                new FullArmorHandler(ModItems.divineHelmet, ModItems.divineBody, ModItems.divineLegs, ModItems.divineBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 6))
                        .withAbility(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.2, 0))
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.fallDistance -= 0.5F),

                new FullArmorHandler(ModItems.bedrockHelmet, ModItems.bedrockBody, ModItems.bedrockLegs, ModItems.bedrockBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.cancelDamageSource(event, DamageSource::isExplosion)),

                new FullArmorHandler(ModItems.enderHelmet, ModItems.enderBody, ModItems.enderLegs, ModItems.enderBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.cancelDamageSource(event, DamageSource::isExplosion)),

                new FullArmorHandler(ModItems.rupeeHelmet, ModItems.rupeeBody, ModItems.rupeeLegs, ModItems.rupeeBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.handleDamageSource(event, ArmorHandlers::isMeeleeDamage, aFloat -> aFloat * 0.2F)),

                new FullArmorHandler(ModItems.santaCap, ModItems.santaTunic, ModItems.santaPants, ModItems.santaBoots, (player, isFullEquipped) -> {
                    if (!isFullEquipped) {
                        // remove speed capability
                        ArmorHandlers.speedUpPlayer(player, 1, true);
                    }
                }).withAbility(LivingHurtEvent.class, event -> {
                    if (event.getEntityLiving().world.provider.getDimension() == ModDimensions.iceikaDimension.getId()) {
                        ArmorHandlers.handleDamageSource(event, ArmorHandlers::isMeeleeDamage, aFloat -> aFloat * 0.2F);
                    }
                })
                        .withAbility(LivingHurtEvent.class, event -> {
                            if (event.getEntityLiving().world.provider.getDimension() == ModDimensions.iceikaDimension.getId()) {
                                ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 6);
                            }
                        })
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> {
                            if (event.player.world.provider.getDimension() == ModDimensions.iceikaDimension.getId()) {
                                ArmorHandlers.refillHunger(event);
                                ArmorHandlers.speedUpPlayer(event.player, 2, false);
                            }
                        }),

                new FullArmorHandler(ModItems.skelemanHelmet, ModItems.skelemanBody, ModItems.skelemanLegs, ModItems.skelemanBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, ArmorHandlers::refillHunger),

                new FullArmorHandler(ModItems.terranHelmet, ModItems.terranBody, ModItems.terranLegs, ModItems.terranBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.addPotionEffect(new PotionEffect(MobEffects.HASTE,
                                20, 2, true, false))),

                new FullArmorHandler(ModItems.frozenHelmet, ModItems.frozenBody, ModItems.frozenLegs, ModItems.frozenBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> ArmorHandlers.frozeNearMobs(event, 10, 6)),

                new FullArmorHandler(ModItems.shadowHelmet, ModItems.shadowBody, ModItems.shadowLegs, ModItems.shadowBoots, (player, isFullEquipped) -> {
                    if (!isFullEquipped) {
                        // remove speed capability
                        ArmorHandlers.speedUpPlayer(player, 1, true);
                    }
                }).withAbility(TickEvent.PlayerTickEvent.class, event -> ArmorHandlers.speedUpPlayer(event.player, 3, false))
        );

        handlers.forEach(ModArmorEvents::addHandler);
    }

}
