package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.api.ArmorHandlers;
import divinerpg.api.Reference;
import divinerpg.api.armorNew.ArmorSet;
import divinerpg.api.armorNew.PoweredArmor;
import divinerpg.api.armorNew.interfaces.IArmorSet;
import divinerpg.api.armorNew.interfaces.IEquipped;
import divinerpg.api.armorNew.interfaces.IPoweredArmor;
import divinerpg.objects.blocks.twilight.BlockTwilightOre;
import divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModArmorEvents {
    public static final ResourceLocation JACKOMAN = new ResourceLocation(Reference.MODID, "jack_o_man_power_set");
    public static final ResourceLocation CORRUPTED = new ResourceLocation(Reference.MODID, "corrupted_set");


    /**
     * All handlers are available by indexes so it makes much easier to point on
     * needed handler from server to client
     */
    // public static final ArrayList<PoweredArmor> ALL_HANDLERS = new ArrayList<>();
    @SubscribeEvent
    public static void init(RegistryEvent.Register<IPoweredArmor> registryEvent) {
        DivineRPG.logger.info("Registering armor handlers");

        IArmorSet rupeeArmorDescriber = new ArmorSet()
                .withVariant(ModItems.rupeeHelmet, ModItems.rupeeChestplate, ModItems.rupeeLeggings, ModItems.rupeeBoots)
                .withVariant(ModItems.blueRupeeHelmet, ModItems.blueRupeeChestplate, ModItems.blueRupeeLeggings, ModItems.blueRupeeBoots)
                .withVariant(ModItems.grayRupeeHelmet, ModItems.grayRupeeChestplate, ModItems.grayRupeeLeggings, ModItems.grayRupeeBoots)
                .withVariant(ModItems.greenRupeeHelmet, ModItems.greenRupeeChestplate, ModItems.greenRupeeLeggings, ModItems.greenRupeeBoots)
                .withVariant(ModItems.redRupeeHelmet, ModItems.redRupeeChestplate, ModItems.redRupeeLeggings, ModItems.redRupeeBoots)
                .withVariant(ModItems.yellowRupeeHelmet, ModItems.yellowRupeeChestplate, ModItems.yellowRupeeLeggings, ModItems.yellowRupeeBoots);

        IArmorSet enderArmorDescriber = new ArmorSet()
                .withVariant(ModItems.enderHelmet, ModItems.enderChestplate, ModItems.enderLeggings, ModItems.enderBoots)
                .withVariant(ModItems.blueEnderHelmet, ModItems.blueEnderChestplate, ModItems.blueEnderLeggings, ModItems.blueEnderBoots)
                .withVariant(ModItems.grayEnderHelmet, ModItems.grayEnderChestplate, ModItems.grayEnderLeggings, ModItems.grayEnderBoots)
                .withVariant(ModItems.greenEnderHelmet, ModItems.greenEnderChestplate, ModItems.greenEnderLeggings, ModItems.greenEnderBoots)
                .withVariant(ModItems.redEnderHelmet, ModItems.redEnderChestplate, ModItems.redEnderLeggings, ModItems.redEnderBoots)
                .withVariant(ModItems.yellowEnderHelmet, ModItems.yellowEnderChestplate, ModItems.yellowEnderLeggings, ModItems.yellowEnderBoots);

        IEquipped stopSpeeUp = (player, isFullEquipped) -> {
            if (!isFullEquipped) {
                ArmorHandlers.removeSpeed(player);
            }
        };

        List<IPoweredArmor> handlers = Arrays.asList(
                new PoweredArmor(ModItems.angelicHelmet, ModItems.angelicChestplate, ModItems.angelicLeggings, ModItems.angelicBoots,
                        ArmorHandlers::onCanFlyChanged)
                        .addAbility(TickEvent.PlayerTickEvent.class, event -> ArmorHandlers.onCanFlyChanged(event.player, true))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "angelic")),

                new PoweredArmor(ModItems.divineHelmet, ModItems.divineChestplate, ModItems.divineLeggings, ModItems.divineBoots)
                        .addAbility(LivingHurtEvent.class, event -> ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 6))
                        .addAbility(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.2, 0))
                        .addAbility(TickEvent.PlayerTickEvent.class, event -> event.player.fallDistance -= 0.5F)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "divine")),

                new PoweredArmor(ModItems.bedrockHelmet, ModItems.bedrockChestplate, ModItems.bedrockLeggings, ModItems.bedrockBoots)
                        .addAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event,
                                source -> source.isFireDamage() || source.isExplosion() || source == DamageSource.LAVA))
                        .addAbility(TickEvent.PlayerTickEvent.class, event -> {
                            event.player.extinguish();
                            event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "bedrock")),

                new PoweredArmor(enderArmorDescriber, null)
                        .addAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, DamageSource::isExplosion))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "ender")),

                new PoweredArmor(rupeeArmorDescriber, null)
                        .addAbility(LivingHurtEvent.class, event -> ArmorHandlers.onPlayerReceiveDamage(event, ArmorHandlers::isMeeleeDamage, aFloat -> aFloat * 0.25F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "rupee")),

                new PoweredArmor(ModItems.santaCap, ModItems.santaTunic, ModItems.santaPants, ModItems.santaBoots, stopSpeeUp)
                        .addAbility(LivingHurtEvent.class, event -> {
                            if (event.getEntityLiving().world.provider.getDimension() == ModDimensions.iceikaDimension.getId()) {
                                ArmorHandlers.onPlayerReceiveDamage(event, ArmorHandlers::isMeeleeDamage, aFloat -> aFloat * 0.25F);
                                ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 6);
                            }
                        }).addAbility(TickEvent.PlayerTickEvent.class, event -> {
                    if (event.player.world.provider.getDimension() == ModDimensions.iceikaDimension.getId()) {
                        ArmorHandlers.refillHunger(event);
                        ArmorHandlers.speedUpPlayer(event.player, 2, false);
                    }
                })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "santa")),

                new PoweredArmor(ModItems.skelemanHelmet, ModItems.skelemanChestplate, ModItems.skelemanLeggings, ModItems.skelemanBoots)
                        .addAbility(TickEvent.PlayerTickEvent.class, ArmorHandlers::refillHunger)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "skeleman")),

                new PoweredArmor(ModItems.terranHelmet, ModItems.terranChestplate, ModItems.terranLeggings, ModItems.terranBoots)
                        .addAbility(TickEvent.PlayerTickEvent.class, event -> event.player.addPotionEffect(new PotionEffect(MobEffects.HASTE,
                                20, 2, true, false)))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "terrain")),

                new PoweredArmor(ModItems.frozenHelmet, ModItems.frozenChestplate, ModItems.frozenLeggings, ModItems.frozenBoots)
                        .addAbility(TickEvent.PlayerTickEvent.class, event -> ArmorHandlers.frozeNearMobs(event, 10, 6))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "frozen")),

                new PoweredArmor(ModItems.shadowHelmet, ModItems.shadowChestplate, ModItems.shadowLeggings, ModItems.shadowBoots, stopSpeeUp)
                        .addAbility(TickEvent.PlayerTickEvent.class, event ->
                                ArmorHandlers.speedUpPlayer(event.player, 3, false))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "shadow")),

                new PoweredArmor(ModItems.arlemiteHelmet, ModItems.arlemiteChestplate, ModItems.arlemiteLeggings, ModItems.arlemiteBoots)
                        .addAbility(LivingHurtEvent.class, event -> ArmorHandlers.onPlayerReceiveDamage(event,
                                source -> source.isProjectile() || source.damageType.equals("thrown"), aFloat -> aFloat * 0.2f))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "arlemite")),

                new PoweredArmor(ModItems.skythernHelmet, ModItems.skythernChestplate, ModItems.skythernLeggings, ModItems.skythernBoots)
                        .addAbility(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.5, 0))
                        .addAbility(TickEvent.PlayerTickEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "skythernm")),

                new PoweredArmor(ModItems.haliteHelmet, ModItems.haliteChestplate, ModItems.haliteLeggings, ModItems.haliteBoots)
                        .addAbility(LivingHurtEvent.class, event -> ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 16))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "halite")),

                new PoweredArmor(ModItems.aquastriveHelmet, ModItems.aquastriveChestplate, ModItems.aquastriveLeggings, ModItems.aquastriveBoots)
                        .addAbility(TickEvent.PlayerTickEvent.class, event ->
                                ArmorHandlers.speedUpInWater(event.player, 1.2F))
                        .addAbility(TickEvent.PlayerTickEvent.class, ArmorHandlers::breatheUnderwater)
                        .addAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.DROWN)))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "aqua")),

                new PoweredArmor(ModItems.krakenHelmet, ModItems.krakenChestplate, ModItems.krakenLeggings, ModItems.krakenBoots)
                        .addAbility(TickEvent.PlayerTickEvent.class, ArmorHandlers::breatheUnderwater)
                        .addAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.DROWN)))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "kraken")),

                new PoweredArmor(ModItems.netheriteHelmet, ModItems.netheriteChestplate, ModItems.netheriteLeggings, ModItems.netheriteBoots)
                        .addAbility(TickEvent.PlayerTickEvent.class, event -> {
                            event.player.extinguish();
                            event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "netherite")),

                new PoweredArmor(ModItems.infernoHelmet, ModItems.infernoChestplate, ModItems.infernoLeggings, ModItems.infernoBoots)
                        .addAbility(TickEvent.PlayerTickEvent.class, event -> {
                            event.player.extinguish();
                            event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "inferno")),

                new PoweredArmor(ModItems.mortumHelmet, ModItems.mortumChestplate, ModItems.mortumLeggings, ModItems.mortumBoots)
                        .addAbility(TickEvent.PlayerTickEvent.class, event -> event.player.addPotionEffect(
                                new PotionEffect(MobEffects.NIGHT_VISION, 210, 10, true, false)))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "mortum")),

                new PoweredArmor(ModItems.eliteRealmiteHelmet, ModItems.eliteRealmiteChestplate, ModItems.eliteRealmiteLeggings, ModItems.eliteRealmiteBoots)
                        .addAbility(TickEvent.PlayerTickEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "realmite")),

                new PoweredArmor(ModItems.wildwoodHelmet, ModItems.wildwoodChestplate, ModItems.wildwoodLeggings, ModItems.wildwoodBoots)
                        .addAbility(TickEvent.PlayerTickEvent.class, event -> {
                            EntityPlayer player = event.player;
                            if (player.isInWater()) {
                                player.heal(0.25F);
                            }
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "wildwood")),

                new PoweredArmor(ModItems.kormaHelmet, ModItems.kormaChestplate, ModItems.kormaLeggings, ModItems.kormaBoots)
                        .addAbility(TickEvent.PlayerTickEvent.class, event -> event.player.heal(1))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "korma")),

                new PoweredArmor(ModItems.vemosHelmet, ModItems.vemosChestplate, ModItems.vemosLeggings, ModItems.vemosBoots)
                        .addAbility(TickEvent.PlayerTickEvent.class, event -> event.player.heal(0.1F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "vemos")),

                new PoweredArmor(ModItems.jungleHelmet, ModItems.jungleChestplate, ModItems.jungleLeggings, ModItems.jungleBoots)
                        .addAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, DamageSource::isMagicDamage))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "jungle")),

                new PoweredArmor(ModItems.witherReaperHelmet, ModItems.witherReaperChestplate, ModItems.witherReaperLeggings, ModItems.witherReaperBoots)
                        .addAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.WITHER)))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "wither")),

                new PoweredArmor(ModItems.apalachiaHelmet, ModItems.apalachiaChestplate, ModItems.apalachiaLeggings, ModItems.apalachiaBoots)
                        .addAbility(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event,
                                s -> s.equals(DamageSource.CACTUS)
                                        || s.equals(DamageSource.FALLING_BLOCK)
                                        || s.equals(DamageSource.ANVIL)
                                        || s.equals(DamageSource.IN_WALL)
                                        || s.equals(Utils.trapSource)))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "apalachia")),

                new PoweredArmor(ModItems.edenHelmet, ModItems.edenChestplate, ModItems.edenLeggings, ModItems.edenBoots)
                        .addAbility(BlockEvent.HarvestDropsEvent.class, event -> {
                            if (event.getState().getBlock() instanceof BlockTwilightOre && !event.isSilkTouching()) {
                                ItemStack fragment = event.getDrops().get(0);
                                event.getDrops().addAll(Collections.nCopies(3, fragment.copy()));
                            }
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "eden")),

                new PoweredArmor(ModItems.corruptedHelmet, ModItems.corruptedChestplate, ModItems.corruptedLeggings, ModItems.corruptedBoots)
                        .addAbility(LivingHurtEvent.class, event -> ArmorHandlers.onAddRangedDamage(event, CORRUPTED, x -> x * 1.5F))
                        .setRegistryName(CORRUPTED),

                new PoweredArmor(ModItems.jackOManHelmet, ModItems.jackOManChestplate, ModItems.jackOManLeggings, ModItems.jackOManBoots)
                        .setRegistryName(JACKOMAN),


                ///////////////////////////////
                // VETHEA
                //////////////////////////////
                new PoweredArmor(ModItems.degradedHood, ModItems.degradedChestplate, ModItems.degradedLeggings, ModItems.degradedBoots)
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.82F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "degradedHood")),

                new PoweredArmor(ModItems.degradedHelmet, ModItems.degradedChestplate, ModItems.degradedLeggings, ModItems.degradedBoots)
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.82F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "degradedHelmet")),

                new PoweredArmor(ModItems.degradedMask, ModItems.degradedChestplate, ModItems.degradedLeggings, ModItems.degradedBoots)
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.82F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "degradedMask")),


                new PoweredArmor(ModItems.finishedHood, ModItems.finishedChestplate, ModItems.finishedLeggings, ModItems.finishedBoots)
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.773F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "finishedHood")),

                new PoweredArmor(ModItems.finishedHelmet, ModItems.finishedChestplate, ModItems.finishedLeggings, ModItems.finishedBoots)
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.773F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "finishedHelmet")),

                new PoweredArmor(ModItems.finishedMask, ModItems.finishedChestplate, ModItems.finishedLeggings, ModItems.finishedBoots)
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.773F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "finishedMask")),


                new PoweredArmor(ModItems.glisteningHood, ModItems.glisteningChestplate, ModItems.glisteningLeggings, ModItems.glisteningBoots)
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.7F))
                        .addAbility(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.2, 0))
                        .addAbility(TickEvent.PlayerTickEvent.class, event -> event.player.fallDistance = -0.5F)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "glisteningHood")),

                new PoweredArmor(ModItems.glisteningHelmet, ModItems.glisteningChestplate, ModItems.glisteningLeggings, ModItems.glisteningBoots)
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.7F))
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onAddMeleeDamage(e, x -> x + 3))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "glisteningHelmet")),

                new PoweredArmor(ModItems.glisteningMask, ModItems.glisteningChestplate, ModItems.glisteningLeggings, ModItems.glisteningBoots, stopSpeeUp)
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.7F))
                        .addAbility(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 1.4F, false))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "glisteningMask")),


                new PoweredArmor(ModItems.demonizedHood, ModItems.demonizedChestplate, ModItems.demonizedLeggings, ModItems.demonizedBoots)
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.625F))
                        .addAbility(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.3, 0))
                        .addAbility(TickEvent.PlayerTickEvent.class, event -> event.player.fallDistance = -0.5F)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "demonizedHood")),

                new PoweredArmor(ModItems.demonizedHelmet, ModItems.demonizedChestplate, ModItems.demonizedLeggings, ModItems.demonizedBoots)
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.625F))
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onAddMeleeDamage(e, x -> x + 6))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "demonizedHelmet")),

                new PoweredArmor(ModItems.demonizedMask, ModItems.demonizedChestplate, ModItems.demonizedLeggings, ModItems.demonizedBoots, stopSpeeUp)
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.625F))
                        .addAbility(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 1.8F, false))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "demonizedMask")),


                new PoweredArmor(ModItems.tormentedHood, ModItems.tormentedChestplate, ModItems.tormentedLeggings, ModItems.tormentedBoots)
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.348F))
                        .addAbility(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.4, 0))
                        .addAbility(TickEvent.PlayerTickEvent.class, event -> event.player.fallDistance = -0.5F)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "tormentedHood")),

                new PoweredArmor(ModItems.tormentedHelmet, ModItems.tormentedChestplate, ModItems.tormentedLeggings, ModItems.tormentedBoots)
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.348F))
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onAddMeleeDamage(e, x -> x + 9))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "tormentedHelmet")),

                new PoweredArmor(ModItems.tormentedMask, ModItems.tormentedChestplate, ModItems.tormentedLeggings, ModItems.tormentedBoots, stopSpeeUp)
                        .addAbility(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.348F))
                        .addAbility(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 2.2F, false))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "tormentedMask"))
        );

        IForgeRegistry<IPoweredArmor> registry = registryEvent.getRegistry();
        handlers.forEach(registry::register);
    }
}
