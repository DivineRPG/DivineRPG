package divinerpg.registry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import divinerpg.api.java.divinerpg.api.ArmorHandlers;
import divinerpg.api.java.divinerpg.api.DivineAPI;
import divinerpg.api.java.divinerpg.api.armorset.ArmorSetVariant;
import divinerpg.api.java.divinerpg.api.armorset.FullArmorHandler;
import divinerpg.api.java.divinerpg.api.armorset.IEquipped;
import divinerpg.events.armorEvents.ArmorTickEvent;
import divinerpg.events.armorEvents.HandlerCollection;
import divinerpg.objects.blocks.twilight.BlockTwilightOre;
import divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ModArmorEvents {

    /**
     * The list of all handlers with isEquipped status.
     */
    //public static final Map<FullArmorHandler, Boolean> HANDLERS_MAP = new HashMap<>();
    public static final HandlerCollection ARMOR_HANDLERS = new HandlerCollection();

    /**
     * All handlers are available by indexes so it makes much easier to point on
     * needed handler from server to client
     */
    // public static final ArrayList<FullArmorHandler> ALL_HANDLERS = new ArrayList<>();
    public static void init() {
        ArmorSetVariant rupeeArmorDescriber = new ArmorSetVariant(ModItems.rupeeHelmet, ModItems.rupeeBody, ModItems.rupeeLegs, ModItems.rupeeBoots)
                .addSetVariant(ModItems.blueRupeeHelmet, ModItems.blueRupeeBody, ModItems.blueRupeeLegs, ModItems.blueRupeeBoots)
                .addSetVariant(ModItems.grayRupeeHelmet, ModItems.grayRupeeBody, ModItems.grayRupeeLegs, ModItems.grayRupeeBoots)
                .addSetVariant(ModItems.greenRupeeHelmet, ModItems.greenRupeeBody, ModItems.greenRupeeLegs, ModItems.greenRupeeBoots)
                .addSetVariant(ModItems.redRupeeHelmet, ModItems.redRupeeBody, ModItems.redRupeeLegs, ModItems.redRupeeBoots)
                .addSetVariant(ModItems.yellowRupeeHelmet, ModItems.yellowRupeeBody, ModItems.yellowRupeeLegs, ModItems.yellowRupeeBoots);

        ArmorSetVariant enderArmorDescriber = new ArmorSetVariant(ModItems.enderHelmet, ModItems.enderBody, ModItems.enderLegs, ModItems.enderBoots)
                .addSetVariant(ModItems.blueEnderHelmet, ModItems.blueEnderBody, ModItems.blueEnderLegs, ModItems.blueEnderBoots)
                .addSetVariant(ModItems.grayEnderHelmet, ModItems.grayEnderBody, ModItems.grayEnderLegs, ModItems.grayEnderBoots)
                .addSetVariant(ModItems.greenEnderHelmet, ModItems.greenEnderBody, ModItems.greenEnderLegs, ModItems.greenEnderBoots)
                .addSetVariant(ModItems.redEnderHelmet, ModItems.redEnderBody, ModItems.redEnderLegs, ModItems.redEnderBoots)
                .addSetVariant(ModItems.yellowEnderHelmet, ModItems.yellowEnderBody, ModItems.yellowEnderLegs, ModItems.yellowEnderBoots);

        IEquipped stopSpeeUp = (player, isFullEquipped) -> {
            if (!isFullEquipped) {
                ArmorHandlers.removeSpeed(player);
            }
        };

        List<FullArmorHandler> handlers = Arrays.asList(
                new FullArmorHandler(ModItems.angelicHelmet, ModItems.angelicBody, ModItems.angelicLegs, ModItems.angelicBoots,
                        ArmorHandlers::onCanFlyChanged)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> ArmorHandlers.onCanFlyChanged(event.player, true)),

                new FullArmorHandler(ModItems.divineHelmet, ModItems.divineBody, ModItems.divineLegs, ModItems.divineBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 6))
                        .withAbility(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.2, 0))
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.fallDistance -= 0.5F),

                new FullArmorHandler(ModItems.bedrockHelmet, ModItems.bedrockBody, ModItems.bedrockLegs, ModItems.bedrockBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event,
                                source -> source.isFireDamage() || source.isExplosion() || source == DamageSource.LAVA)),

                new FullArmorHandler(enderArmorDescriber)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, DamageSource::isExplosion)),

                new FullArmorHandler(rupeeArmorDescriber)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onPlayerReceiveDamage(event, ArmorHandlers::isMeeleeDamage, aFloat -> aFloat * 0.25F)),

                new FullArmorHandler(ModItems.santaCap, ModItems.santaTunic, ModItems.santaPants, ModItems.santaBoots, stopSpeeUp)
                        .withAbility(LivingHurtEvent.class, event -> {
                            if (event.getEntityLiving().world.provider.getDimension() == ModDimensions.iceikaDimension.getId()) {
                                ArmorHandlers.onPlayerReceiveDamage(event, ArmorHandlers::isMeeleeDamage, aFloat -> aFloat * 0.25F);
                                ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 6);
                            }
                        }).withAbility(TickEvent.PlayerTickEvent.class, event -> {
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

                new FullArmorHandler(ModItems.shadowHelmet, ModItems.shadowBody, ModItems.shadowLegs, ModItems.shadowBoots, stopSpeeUp)
                        .withAbility(TickEvent.PlayerTickEvent.class, event ->
                                ArmorHandlers.speedUpPlayer(event.player, 3, false)),

                new FullArmorHandler(ModItems.arlemiteHelmet, ModItems.arlemiteBody, ModItems.arlemiteLegs, ModItems.arlemiteBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onPlayerReceiveDamage(event,
                                source -> source.isProjectile() || source.damageType.equals("thrown"), aFloat -> aFloat * 0.2f)),

                new FullArmorHandler(ModItems.skythernHelmet, ModItems.skythernChestplate, ModItems.skythernLeggings, ModItems.skythernBoots)
                        .withAbility(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.5, 0))
                        .withAbility(TickEvent.PlayerTickEvent.class, ArmorHandlers::disableFallDamage),

                new FullArmorHandler(ModItems.haliteHelmet, ModItems.haliteChestplate, ModItems.haliteLeggings, ModItems.haliteBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 16)),

                new FullArmorHandler(ModItems.aquastriveHelmet, ModItems.aquastriveBody, ModItems.aquastriveLegs, ModItems.aquastriveBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, event ->
                                ArmorHandlers.speedUpInWater(event.player, 1.2F))
                        .withAbility(TickEvent.PlayerTickEvent.class, ArmorHandlers::breatheUnderwater)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.DROWN))),

                new FullArmorHandler(ModItems.krakenHelmet, ModItems.krakenBody, ModItems.krakenLegs, ModItems.krakenBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, ArmorHandlers::breatheUnderwater)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.DROWN))),

                new FullArmorHandler(ModItems.netheriteHelmet, ModItems.netheriteBody, ModItems.netheriteLegs, ModItems.netheriteBoots)
                        .withVariants(ModItems.bedrockHelmet, ModItems.bedrockBody, ModItems.bedrockLegs, ModItems.bedrockBoots)
                        .withVariants(ModItems.infernoHelmet, ModItems.infernoBody, ModItems.infernoLegs, ModItems.infernoBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> {
                            event.player.extinguish();
                            event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
                        }),

                new FullArmorHandler(ModItems.mortumHelmet, ModItems.mortumChestplate, ModItems.mortumLeggings, ModItems.mortumBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.addPotionEffect(
                                new PotionEffect(MobEffects.NIGHT_VISION, 210, 10, true, false))),

                new FullArmorHandler(ModItems.eliteRealmiteHelmet, ModItems.eliteRealmiteBody, ModItems.eliteRealmiteLegs, ModItems.eliteRealmiteBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, ArmorHandlers::disableFallDamage),

                new FullArmorHandler(ModItems.apalachiaHelmet, ModItems.apalachiaChestplate, ModItems.apalachiaLeggings, ModItems.apalachiaBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> {
                            EntityPlayer player = event.player;
                            if (player.isInWater()) {
                                player.heal(0.25F);
                            }
                        }),

                new FullArmorHandler(ModItems.kormaHelmet, ModItems.kormaBody, ModItems.kormaLegs, ModItems.kormaBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.heal(1)),

                new FullArmorHandler(ModItems.vemosHelmet, ModItems.vemosBody, ModItems.vemosLegs, ModItems.vemosBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.heal(0.1F)),

                new FullArmorHandler(ModItems.jungleHelmet, ModItems.jungleBody, ModItems.jungleLegs, ModItems.jungleBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, DamageSource::isMagicDamage)),

                new FullArmorHandler(ModItems.witherReaperHelmet, ModItems.witherReaperBody, ModItems.witherReaperLegs, ModItems.witherReaperBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.WITHER))),

                new FullArmorHandler(ModItems.apalachiaHelmet, ModItems.apalachiaChestplate, ModItems.apalachiaLeggings, ModItems.apalachiaBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event,
                                s -> s.equals(DamageSource.CACTUS)
                                        || s.equals(DamageSource.FALLING_BLOCK)
                                        || s.equals(DamageSource.ANVIL)
                                        || s.equals(DamageSource.IN_WALL)
                                        || s.equals(Utils.trapSource))),

                new FullArmorHandler(ModItems.edenHelmet, ModItems.edenChestplate, ModItems.edenLeggings, ModItems.edenBoots)
                        .withAbility(BlockEvent.HarvestDropsEvent.class, event -> {
                            if (event.getState().getBlock() instanceof BlockTwilightOre && !event.isSilkTouching()) {
                                ItemStack fragment = event.getDrops().get(0);
                                event.getDrops().addAll(Collections.nCopies(3, fragment.copy()));
                            }
                        }),

                new FullArmorHandler(ModItems.corruptedHelmet, ModItems.corruptedBody, ModItems.corruptedLegs, ModItems.corruptedBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onAddRangedDamage(event, aFloat -> aFloat * 1.2F)),


                ///////////////////////////////
                // VETHEA
                //////////////////////////////
                new FullArmorHandler(ModItems.degradedHood, ModItems.degradedBody, ModItems.degradedLegs, ModItems.degradedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.82F)),

                new FullArmorHandler(ModItems.degradedHelmet, ModItems.degradedBody, ModItems.degradedLegs, ModItems.degradedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.82F)),

                new FullArmorHandler(ModItems.degradedMask, ModItems.degradedBody, ModItems.degradedLegs, ModItems.degradedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.82F)),


                new FullArmorHandler(ModItems.finishedHood, ModItems.finishedBody, ModItems.finishedLegs, ModItems.finishedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.773F)),

                new FullArmorHandler(ModItems.finishedHelmet, ModItems.finishedBody, ModItems.finishedLegs, ModItems.finishedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.773F)),

                new FullArmorHandler(ModItems.finishedMask, ModItems.finishedBody, ModItems.finishedLegs, ModItems.finishedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.773F)),


                new FullArmorHandler(ModItems.glisteningHood, ModItems.glisteningBody, ModItems.glisteningLegs, ModItems.glisteningBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.7F))
                        .withAbility(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.2, 0))
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.fallDistance = -0.5F),

                new FullArmorHandler(ModItems.glisteningHelmet, ModItems.glisteningBody, ModItems.glisteningLegs, ModItems.glisteningBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.7F))
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onAddMeleeDamage(e, x -> x + 3)),

                new FullArmorHandler(ModItems.glisteningMask, ModItems.glisteningBody, ModItems.glisteningLegs, ModItems.glisteningBoots, stopSpeeUp)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.7F))
                        .withAbility(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 1.4F, false)),



                new FullArmorHandler(ModItems.demonizedHood, ModItems.demonizedBody, ModItems.demonizedLegs, ModItems.demonizedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.625F))
                        .withAbility(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.3, 0))
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.fallDistance = -0.5F),

                new FullArmorHandler(ModItems.demonizedHelmet, ModItems.demonizedBody, ModItems.demonizedLegs, ModItems.demonizedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.625F))
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onAddMeleeDamage(e, x -> x + 6)),

                new FullArmorHandler(ModItems.demonizedMask, ModItems.demonizedBody, ModItems.demonizedLegs, ModItems.demonizedBoots, stopSpeeUp)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.625F))
                        .withAbility(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 1.8F, false)),



                new FullArmorHandler(ModItems.tormentedHood, ModItems.tormentedBody, ModItems.tormentedLegs, ModItems.tormentedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.348F))
                        .withAbility(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.4, 0))
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.fallDistance = -0.5F),

                new FullArmorHandler(ModItems.tormentedHelmet, ModItems.tormentedBody, ModItems.tormentedLegs, ModItems.tormentedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.348F))
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onAddMeleeDamage(e, x -> x + 9)),

                new FullArmorHandler(ModItems.tormentedMask, ModItems.tormentedBody, ModItems.tormentedLegs, ModItems.tormentedBoots, stopSpeeUp)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.348F))
                        .withAbility(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 2.2F, false))

        );

        DivineAPI.ARMOR_REGISTRY = ARMOR_HANDLERS;
        handlers.forEach(DivineAPI.ARMOR_REGISTRY::addHandler);

        MinecraftForge.EVENT_BUS.register(new ArmorTickEvent());
    }
}
