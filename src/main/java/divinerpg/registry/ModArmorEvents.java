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
        ArmorSetVariant rupeeArmorDescriber = new ArmorSetVariant(ModItems.rupeeHelmet, ModItems.rupeeChestplate, ModItems.rupeeLeggings, ModItems.rupeeBoots)
                .addSetVariant(ModItems.blueRupeeHelmet, ModItems.blueRupeeChestplate, ModItems.blueRupeeLeggings, ModItems.blueRupeeBoots)
                .addSetVariant(ModItems.grayRupeeHelmet, ModItems.grayRupeeChestplate, ModItems.grayRupeeLeggings, ModItems.grayRupeeBoots)
                .addSetVariant(ModItems.greenRupeeHelmet, ModItems.greenRupeeChestplate, ModItems.greenRupeeLeggings, ModItems.greenRupeeBoots)
                .addSetVariant(ModItems.redRupeeHelmet, ModItems.redRupeeChestplate, ModItems.redRupeeLeggings, ModItems.redRupeeBoots)
                .addSetVariant(ModItems.yellowRupeeHelmet, ModItems.yellowRupeeChestplate, ModItems.yellowRupeeLeggings, ModItems.yellowRupeeBoots);

        ArmorSetVariant enderArmorDescriber = new ArmorSetVariant(ModItems.enderHelmet, ModItems.enderChestplate, ModItems.enderLeggings, ModItems.enderBoots)
                .addSetVariant(ModItems.blueEnderHelmet, ModItems.blueEnderChestplate, ModItems.blueEnderLeggings, ModItems.blueEnderBoots)
                .addSetVariant(ModItems.grayEnderHelmet, ModItems.grayEnderChestplate, ModItems.grayEnderLeggings, ModItems.grayEnderBoots)
                .addSetVariant(ModItems.greenEnderHelmet, ModItems.greenEnderChestplate, ModItems.greenEnderLeggings, ModItems.greenEnderBoots)
                .addSetVariant(ModItems.redEnderHelmet, ModItems.redEnderChestplate, ModItems.redEnderLeggings, ModItems.redEnderBoots)
                .addSetVariant(ModItems.yellowEnderHelmet, ModItems.yellowEnderChestplate, ModItems.yellowEnderLeggings, ModItems.yellowEnderBoots);

        IEquipped stopSpeeUp = (player, isFullEquipped) -> {
            if (!isFullEquipped) {
                ArmorHandlers.removeSpeed(player);
            }
        };

        List<FullArmorHandler> handlers = Arrays.asList(
                new FullArmorHandler(ModItems.angelicHelmet, ModItems.angelicChestplate, ModItems.angelicLeggings, ModItems.angelicBoots,
                        ArmorHandlers::onCanFlyChanged)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> ArmorHandlers.onCanFlyChanged(event.player, true)),

                new FullArmorHandler(ModItems.divineHelmet, ModItems.divineChestplate, ModItems.divineLeggings, ModItems.divineBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 6))
                        .withAbility(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.2, 0))
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.fallDistance -= 0.5F),

                new FullArmorHandler(ModItems.bedrockHelmet, ModItems.bedrockChestplate, ModItems.bedrockLeggings, ModItems.bedrockBoots)
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

                new FullArmorHandler(ModItems.skelemanHelmet, ModItems.skelemanChestplate, ModItems.skelemanLeggings, ModItems.skelemanBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, ArmorHandlers::refillHunger),

                new FullArmorHandler(ModItems.terranHelmet, ModItems.terranChestplate, ModItems.terranLeggings, ModItems.terranBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.addPotionEffect(new PotionEffect(MobEffects.HASTE,
                                20, 2, true, false))),

                new FullArmorHandler(ModItems.frozenHelmet, ModItems.frozenChestplate, ModItems.frozenLeggings, ModItems.frozenBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> ArmorHandlers.frozeNearMobs(event, 10, 6)),

                new FullArmorHandler(ModItems.shadowHelmet, ModItems.shadowChestplate, ModItems.shadowLeggings, ModItems.shadowBoots, stopSpeeUp)
                        .withAbility(TickEvent.PlayerTickEvent.class, event ->
                                ArmorHandlers.speedUpPlayer(event.player, 3, false)),

                new FullArmorHandler(ModItems.arlemiteHelmet, ModItems.arlemiteChestplate, ModItems.arlemiteLeggings, ModItems.arlemiteBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onPlayerReceiveDamage(event,
                                source -> source.isProjectile() || source.damageType.equals("thrown"), aFloat -> aFloat * 0.2f)),

                new FullArmorHandler(ModItems.skythernHelmet, ModItems.skythernChestplate, ModItems.skythernLeggings, ModItems.skythernBoots)
                        .withAbility(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.5, 0))
                        .withAbility(TickEvent.PlayerTickEvent.class, ArmorHandlers::disableFallDamage),

                new FullArmorHandler(ModItems.haliteHelmet, ModItems.haliteChestplate, ModItems.haliteLeggings, ModItems.haliteBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 16)),

                new FullArmorHandler(ModItems.aquastriveHelmet, ModItems.aquastriveChestplate, ModItems.aquastriveLeggings, ModItems.aquastriveBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, event ->
                                ArmorHandlers.speedUpInWater(event.player, 1.2F))
                        .withAbility(TickEvent.PlayerTickEvent.class, ArmorHandlers::breatheUnderwater)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.DROWN))),

                new FullArmorHandler(ModItems.krakenHelmet, ModItems.krakenChestplate, ModItems.krakenLeggings, ModItems.krakenBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, ArmorHandlers::breatheUnderwater)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.DROWN))),

                new FullArmorHandler(ModItems.netheriteHelmet, ModItems.netheriteChestplate, ModItems.netheriteLeggings, ModItems.netheriteBoots)
                        .withVariants(ModItems.bedrockHelmet, ModItems.bedrockChestplate, ModItems.bedrockLeggings, ModItems.bedrockBoots)
                        .withVariants(ModItems.infernoHelmet, ModItems.infernoChestplate, ModItems.infernoLeggings, ModItems.infernoBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> {
                            event.player.extinguish();
                            event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
                        }),

                new FullArmorHandler(ModItems.mortumHelmet, ModItems.mortumChestplate, ModItems.mortumLeggings, ModItems.mortumBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.addPotionEffect(
                                new PotionEffect(MobEffects.NIGHT_VISION, 210, 10, true, false))),

                new FullArmorHandler(ModItems.eliteRealmiteHelmet, ModItems.eliteRealmiteChestplate, ModItems.eliteRealmiteLeggings, ModItems.eliteRealmiteBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, ArmorHandlers::disableFallDamage),

                new FullArmorHandler(ModItems.apalachiaHelmet, ModItems.apalachiaChestplate, ModItems.apalachiaLeggings, ModItems.apalachiaBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> {
                            EntityPlayer player = event.player;
                            if (player.isInWater()) {
                                player.heal(0.25F);
                            }
                        }),

                new FullArmorHandler(ModItems.kormaHelmet, ModItems.kormaChestplate, ModItems.kormaLeggings, ModItems.kormaBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.heal(1)),

                new FullArmorHandler(ModItems.vemosHelmet, ModItems.vemosChestplate, ModItems.vemosLeggings, ModItems.vemosBoots)
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.heal(0.1F)),

                new FullArmorHandler(ModItems.jungleHelmet, ModItems.jungleChestplate, ModItems.jungleLeggings, ModItems.jungleBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, DamageSource::isMagicDamage)),

                new FullArmorHandler(ModItems.witherReaperHelmet, ModItems.witherReaperChestplate, ModItems.witherReaperLeggings, ModItems.witherReaperBoots)
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

                new FullArmorHandler(ModItems.corruptedHelmet, ModItems.corruptedChestplate, ModItems.corruptedLeggings, ModItems.corruptedBoots)
                        .withAbility(LivingHurtEvent.class, event -> ArmorHandlers.onAddRangedDamage(event, aFloat -> aFloat * 1.2F)),


                ///////////////////////////////
                // VETHEA
                //////////////////////////////
                new FullArmorHandler(ModItems.degradedHood, ModItems.degradedChestplate, ModItems.degradedLeggings, ModItems.degradedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.82F)),

                new FullArmorHandler(ModItems.degradedHelmet, ModItems.degradedChestplate, ModItems.degradedLeggings, ModItems.degradedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.82F)),

                new FullArmorHandler(ModItems.degradedMask, ModItems.degradedChestplate, ModItems.degradedLeggings, ModItems.degradedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.82F)),


                new FullArmorHandler(ModItems.finishedHood, ModItems.finishedChestplate, ModItems.finishedLeggings, ModItems.finishedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.773F)),

                new FullArmorHandler(ModItems.finishedHelmet, ModItems.finishedChestplate, ModItems.finishedLeggings, ModItems.finishedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.773F)),

                new FullArmorHandler(ModItems.finishedMask, ModItems.finishedChestplate, ModItems.finishedLeggings, ModItems.finishedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.773F)),


                new FullArmorHandler(ModItems.glisteningHood, ModItems.glisteningChestplate, ModItems.glisteningLeggings, ModItems.glisteningBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.7F))
                        .withAbility(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.2, 0))
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.fallDistance = -0.5F),

                new FullArmorHandler(ModItems.glisteningHelmet, ModItems.glisteningChestplate, ModItems.glisteningLeggings, ModItems.glisteningBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.7F))
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onAddMeleeDamage(e, x -> x + 3)),

                new FullArmorHandler(ModItems.glisteningMask, ModItems.glisteningChestplate, ModItems.glisteningLeggings, ModItems.glisteningBoots, stopSpeeUp)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.7F))
                        .withAbility(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 1.4F, false)),



                new FullArmorHandler(ModItems.demonizedHood, ModItems.demonizedChestplate, ModItems.demonizedLeggings, ModItems.demonizedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.625F))
                        .withAbility(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.3, 0))
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.fallDistance = -0.5F),

                new FullArmorHandler(ModItems.demonizedHelmet, ModItems.demonizedChestplate, ModItems.demonizedLeggings, ModItems.demonizedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.625F))
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onAddMeleeDamage(e, x -> x + 6)),

                new FullArmorHandler(ModItems.demonizedMask, ModItems.demonizedChestplate, ModItems.demonizedLeggings, ModItems.demonizedBoots, stopSpeeUp)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.625F))
                        .withAbility(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 1.8F, false)),



                new FullArmorHandler(ModItems.tormentedHood, ModItems.tormentedChestplate, ModItems.tormentedLeggings, ModItems.tormentedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.348F))
                        .withAbility(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.4, 0))
                        .withAbility(TickEvent.PlayerTickEvent.class, event -> event.player.fallDistance = -0.5F),

                new FullArmorHandler(ModItems.tormentedHelmet, ModItems.tormentedChestplate, ModItems.tormentedLeggings, ModItems.tormentedBoots)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.348F))
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onAddMeleeDamage(e, x -> x + 9)),

                new FullArmorHandler(ModItems.tormentedMask, ModItems.tormentedChestplate, ModItems.tormentedLeggings, ModItems.tormentedBoots, stopSpeeUp)
                        .withAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.348F))
                        .withAbility(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 2.2F, false))

        );

        DivineAPI.ARMOR_REGISTRY = ARMOR_HANDLERS;
        handlers.forEach(DivineAPI.ARMOR_REGISTRY::addHandler);

        MinecraftForge.EVENT_BUS.register(new ArmorTickEvent());
    }
}
