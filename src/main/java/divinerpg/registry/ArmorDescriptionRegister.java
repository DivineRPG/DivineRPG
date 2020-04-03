package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.api.ArmorHandlers;
import divinerpg.api.DivineAPI;
import divinerpg.api.Reference;
import divinerpg.api.armor.IEquipped;
import divinerpg.api.armor.cap.IArmorPowers;
import divinerpg.api.armor.registry.IArmorDescription;
import divinerpg.capabilities.armor.ArmorDescription;
import divinerpg.objects.blocks.twilight.BlockTwilightOre;
import divinerpg.utils.Utils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
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

import java.util.Collections;

@Mod.EventBusSubscriber
public class ArmorDescriptionRegister {

    public static final ResourceLocation CORRUPTED = new ResourceLocation(Reference.MODID, "corrupted");
    public static final ResourceLocation JACKOMAN = new ResourceLocation(Reference.MODID, "jackoman");

    @SubscribeEvent
    public static void registerArmors(RegistryEvent.Register<IArmorDescription> registryEvent) {
        DivineRPG.logger.info("Registering armor descriptions");

        IForgeRegistry<IArmorDescription> registry = registryEvent.getRegistry();

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD,
                                ModItems.rupeeHelmet,
                                ModItems.blueRupeeHelmet,
                                ModItems.grayRupeeHelmet,
                                ModItems.greenRupeeHelmet,
                                ModItems.redRupeeHelmet,
                                ModItems.yellowRupeeHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.rupeeChestplate,
                                ModItems.blueRupeeChestplate,
                                ModItems.grayRupeeChestplate,
                                ModItems.greenRupeeChestplate,
                                ModItems.redRupeeChestplate,
                                ModItems.yellowRupeeChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.rupeeLeggings,
                                ModItems.blueRupeeLeggings,
                                ModItems.grayRupeeLeggings,
                                ModItems.greenRupeeLeggings,
                                ModItems.redRupeeLeggings,
                                ModItems.yellowRupeeLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.rupeeBoots,
                                ModItems.blueRupeeBoots,
                                ModItems.grayRupeeBoots,
                                ModItems.greenRupeeBoots,
                                ModItems.redRupeeBoots,
                                ModItems.yellowRupeeBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, ArmorHandlers::isMeeleeDamage, f -> {
                            float multiplier = 0.25F;
//                            IArmorPowers powers = DivineAPI.getArmorPowers(e.getEntity());
//
//                            if (powers != null) {
//                                if (powers.currentItems(EntityEquipmentSlot.OFFHAND).contains(ModItems.rupee_shield)){
//                                    multiplier /= 2;
//                                }
//                            }

                            return f * multiplier;
                        }))
                        .setRegistryName(Reference.MODID, "rupee")
        );


        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.enderHelmet,
                                ModItems.blueEnderHelmet,
                                ModItems.grayEnderHelmet,
                                ModItems.greenEnderHelmet,
                                ModItems.redEnderHelmet,
                                ModItems.yellowEnderHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.enderChestplate,
                                ModItems.blueEnderChestplate,
                                ModItems.grayEnderChestplate,
                                ModItems.greenEnderChestplate,
                                ModItems.redEnderChestplate,
                                ModItems.yellowEnderChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.enderLeggings,
                                ModItems.blueEnderLeggings,
                                ModItems.grayEnderLeggings,
                                ModItems.greenEnderLeggings,
                                ModItems.redEnderLeggings,
                                ModItems.yellowEnderLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.enderBoots,
                                ModItems.blueEnderBoots,
                                ModItems.grayEnderBoots,
                                ModItems.greenEnderBoots,
                                ModItems.redEnderBoots,
                                ModItems.yellowEnderBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onCancelPlayerReceiveDamage(e, DamageSource::isExplosion))
                        .setRegistryName(Reference.MODID, "ender")
        );

        registry.register(
                new ArmorDescription(ArmorHandlers::onCanFlyChanged)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.angelicHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.angelicChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.angelicLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.angelicBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.onCanFlyChanged(e.player, true))
                        .setRegistryName(Reference.MODID, "angelic")
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.bedrockHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.bedrockChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.bedrockLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.bedrockBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event,
                                source -> source.isFireDamage() || source.isExplosion() || source == DamageSource.LAVA))
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> {
                            event.player.extinguish();
                            event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
                        }).setRegistryName(Reference.MODID, "bedrock")
        );

        registry.register(
                new ArmorDescription(ArmorHandlers::onCanFlyChanged)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.divineHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.divineChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.divineLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.divineBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 6))
                        .withHandler(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.2, 0))
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> event.player.fallDistance -= 0.5F)
                        .setRegistryName(Reference.MODID, "divine")
        );

        IEquipped stopSpeedUp = (player, isFullEquipped) -> {
            if (!isFullEquipped) {
                ArmorHandlers.removeSpeed(player);
            }
        };

        registry.register(
                new ArmorDescription(stopSpeedUp)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.santaCap)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.santaTunic)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.santaPants)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.santaBoots)
                        .withHandler(LivingHurtEvent.class, event -> {
                            if (event.getEntityLiving().world.provider.getDimension() == ModDimensions.iceikaDimension.getId()) {
                                ArmorHandlers.onPlayerReceiveDamage(event, ArmorHandlers::isMeeleeDamage, aFloat -> aFloat * 0.25F);
                                ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 6);
                            }
                        }).withHandler(TickEvent.PlayerTickEvent.class, event -> {
                    if (event.player.world.provider.getDimension() == ModDimensions.iceikaDimension.getId()) {
                        ArmorHandlers.refillHunger(event);
                        ArmorHandlers.speedUpPlayer(event.player, 2, false);
                    }
                })
                        .setRegistryName(Reference.MODID, "santa")
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.skelemanHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.skelemanChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.skelemanLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.skelemanBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, ArmorHandlers::refillHunger)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "skeleman"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.terranHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.terranChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.terranLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.terranBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> event.player.addPotionEffect(new PotionEffect(MobEffects.HASTE,
                                20, 2, true, false)))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "terrain"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.frozenHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.frozenChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.frozenLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.frozenBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> ArmorHandlers.frozeNearMobs(event, 10, 6))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "frozen"))
        );

        registry.register(
                new ArmorDescription(stopSpeedUp)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.shadowHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.shadowChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.shadowLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.shadowBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event ->
                                ArmorHandlers.speedUpPlayer(event.player, 3, false))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "shadow"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.arlemiteHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.arlemiteChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.arlemiteLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.arlemiteBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onPlayerReceiveDamage(event,
                                source -> source.isProjectile() || source.damageType.equals("thrown"),
                                aFloat -> {
                                    float multiplier = 0.2F;

                                    IArmorPowers powers = DivineAPI.getArmorPowers(event.getEntity());
                                    if (powers != null) {
                                        if (powers.currentItems(EntityEquipmentSlot.OFFHAND).contains(ModItems.arlemite_shield)) {
                                            multiplier /= 2;
                                        }
                                    }

                                    return aFloat * multiplier;
                                }))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "arlemite"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.skythernHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.skythernChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.skythernLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.skythernBoots)
                        .withHandler(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.5, 0))
                        .withHandler(TickEvent.PlayerTickEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "skythernm"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.haliteHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.haliteChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.haliteLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.haliteBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 16))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "halite"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.aquastriveHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.aquastriveChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.aquastriveLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.aquastriveBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event ->
                                ArmorHandlers.speedUpInWater(event.player, 1.2F))
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.DROWN)))
                        .withHandler(TickEvent.PlayerTickEvent.class, ArmorHandlers::breatheUnderwater)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "aqua"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.krakenHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.krakenChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.krakenLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.krakenBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, ArmorHandlers::breatheUnderwater)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.DROWN)))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "kraken"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.netheriteHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.netheriteChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.netheriteLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.netheriteBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> {
                            event.player.extinguish();
                            event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "netherite"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.infernoHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.infernoChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.infernoLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.infernoBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> {
                            event.player.extinguish();
                            event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "inferno"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.mortumHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.mortumChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.mortumLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.mortumBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> event.player.addPotionEffect(
                                new PotionEffect(MobEffects.NIGHT_VISION, 210, 10, true, false)))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "mortum"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.eliteRealmiteHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.eliteRealmiteChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.eliteRealmiteLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.eliteRealmiteBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "realmite"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.wildwoodHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.wildwoodChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.wildwoodLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.wildwoodBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> {
                            EntityPlayer player = event.player;
                            if (player.isInWater()) {
                                player.heal(0.25F);
                            }
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "wildwood"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.kormaHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.kormaChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.kormaLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.kormaBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> event.player.heal(1))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "korma"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.vemosHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.vemosChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.vemosLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.vemosBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> event.player.heal(0.1F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "vemos"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.jungleHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.jungleChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.jungleLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.jungleBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, DamageSource::isMagicDamage))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "jungle"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.witherReaperHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.witherReaperChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.witherReaperLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.witherReaperBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.WITHER)))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "wither"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.apalachiaHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.apalachiaChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.apalachiaLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.apalachiaBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event,
                                s -> s.equals(DamageSource.CACTUS)
                                        || s.equals(DamageSource.FALLING_BLOCK)
                                        || s.equals(DamageSource.ANVIL)
                                        || s.equals(DamageSource.IN_WALL)
                                        || s.equals(Utils.trapSource)))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "apalachia"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.edenHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.edenChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.edenLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.edenBoots)
                        .withHandler(BlockEvent.HarvestDropsEvent.class, event -> {
                            if (event.getState().getBlock() instanceof BlockTwilightOre && !event.isSilkTouching()) {
                                ItemStack fragment = event.getDrops().get(0);
                                event.getDrops().addAll(Collections.nCopies(3, fragment.copy()));
                            }
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "eden"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.corruptedHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.corruptedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.corruptedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.corruptedBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onAddRangedDamage(event, CORRUPTED, x -> x * 1.5F))
                        .setRegistryName(CORRUPTED)
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.jackOManHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.jackOManChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.jackOManLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.jackOManBoots)
                        .setRegistryName(JACKOMAN)
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.degradedHood)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.degradedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.degradedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.degradedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.82F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "degradedHood"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.degradedHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.degradedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.degradedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.degradedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.82F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "degradedHelmet"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.degradedMask)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.degradedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.degradedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.degradedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.82F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "degradedMask"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.finishedHood)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.finishedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.finishedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.finishedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.773F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "finishedHood"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.finishedHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.finishedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.finishedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.finishedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.773F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "finishedHelmet"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.finishedMask)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.finishedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.finishedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.finishedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.773F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "finishedMask"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.glisteningHood)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.glisteningChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.glisteningLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.glisteningBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.7F))
                        .withHandler(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.2, 0))
                        .withHandler(TickEvent.PlayerTickEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "glisteningHood"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.glisteningHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.glisteningChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.glisteningLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.glisteningBoots)
                        .withHandler(LivingHurtEvent.class, e -> {
                            ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.7F);
                            ArmorHandlers.onAddMeleeDamage(e, x -> x + 3);
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "glisteningHelmet"))
        );

        registry.register(
                new ArmorDescription(stopSpeedUp)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.glisteningMask)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.glisteningChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.glisteningLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.glisteningBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.7F))
                        .withHandler(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 1.4F, false))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "glisteningMask"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.demonizedHood)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.demonizedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.demonizedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.demonizedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.625F))
                        .withHandler(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.3, 0))
                        .withHandler(TickEvent.PlayerTickEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "demonizedHood"))
        );
        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.demonizedHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.demonizedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.demonizedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.demonizedBoots)
                        .withHandler(LivingHurtEvent.class, e -> {
                            ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.625F);
                            ArmorHandlers.onAddMeleeDamage(e, x -> x + 6);
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "demonizedHelmet"))
        );

        registry.register(
                new ArmorDescription(stopSpeedUp)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.demonizedMask)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.demonizedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.demonizedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.demonizedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.625F))
                        .withHandler(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 1.8F, false))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "demonizedMask"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.tormentedHood)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.tormentedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.tormentedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.tormentedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.348F))
                        .withHandler(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.4, 0))
                        .withHandler(TickEvent.PlayerTickEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "tormentedHood"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.tormentedHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.tormentedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.tormentedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.tormentedBoots)
                        .withHandler(LivingHurtEvent.class, e -> {
                            ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.348F);
                            ArmorHandlers.onAddMeleeDamage(e, x -> x + 9);
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "tormentedHelmet"))
        );

        registry.register(
                new ArmorDescription(stopSpeedUp)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModItems.tormentedMask)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModItems.tormentedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModItems.tormentedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModItems.tormentedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.348F))
                        .withHandler(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 2.2F, false))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "tormentedMask"))
        );
    }
}
