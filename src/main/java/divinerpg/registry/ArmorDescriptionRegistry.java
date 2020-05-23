package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.api.ArmorHandlers;
import divinerpg.api.DivineAPI;
import divinerpg.api.arcana.IArcana;
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
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Collections;

@Mod.EventBusSubscriber
public class ArmorDescriptionRegistry {

    public static final ResourceLocation AWAKENED_HALITE = new ResourceLocation(DivineRPG.MODID, "awakened_halite");
    public static final ResourceLocation CORRUPTED = new ResourceLocation(DivineRPG.MODID, "corrupted");
    public static final ResourceLocation JACKOMAN = new ResourceLocation(DivineRPG.MODID, "jackoman");

    @SubscribeEvent
    public static void registerArmors(RegistryEvent.Register<IArmorDescription> registryEvent) {
        DivineRPG.logger.info("Registering armor descriptions");

        IForgeRegistry<IArmorDescription> registry = registryEvent.getRegistry();

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD,
                                ArmorRegistry.rupeeHelmet,
                                ArmorRegistry.blueRupeeHelmet,
                                ArmorRegistry.grayRupeeHelmet,
                                ArmorRegistry.greenRupeeHelmet,
                                ArmorRegistry.redRupeeHelmet,
                                ArmorRegistry.yellowRupeeHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.rupeeChestplate,
                                ArmorRegistry.blueRupeeChestplate,
                                ArmorRegistry.grayRupeeChestplate,
                                ArmorRegistry.greenRupeeChestplate,
                                ArmorRegistry.redRupeeChestplate,
                                ArmorRegistry.yellowRupeeChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.rupeeLeggings,
                                ArmorRegistry.blueRupeeLeggings,
                                ArmorRegistry.grayRupeeLeggings,
                                ArmorRegistry.greenRupeeLeggings,
                                ArmorRegistry.redRupeeLeggings,
                                ArmorRegistry.yellowRupeeLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.rupeeBoots,
                                ArmorRegistry.blueRupeeBoots,
                                ArmorRegistry.grayRupeeBoots,
                                ArmorRegistry.greenRupeeBoots,
                                ArmorRegistry.redRupeeBoots,
                                ArmorRegistry.yellowRupeeBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, ArmorHandlers::isMeeleeDamage, f -> {
                            float multiplier = 0.25F;
//                            IArmorPowers powers = DivineAPI.getArmorPowers(e.getEntity());
//
//                            if (powers != null) {
//                                if (powers.currentItems(EntityEquipmentSlot.OFFHAND).contains(ArmorRegistry.rupee_shield)){
//                                    multiplier /= 2;
//                                }
//                            }

                            return f * multiplier;
                        }))
                        .setRegistryName(DivineRPG.MODID, "rupee")
        );


        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.enderHelmet,
                                ArmorRegistry.blueEnderHelmet,
                                ArmorRegistry.grayEnderHelmet,
                                ArmorRegistry.greenEnderHelmet,
                                ArmorRegistry.redEnderHelmet,
                                ArmorRegistry.yellowEnderHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.enderChestplate,
                                ArmorRegistry.blueEnderChestplate,
                                ArmorRegistry.grayEnderChestplate,
                                ArmorRegistry.greenEnderChestplate,
                                ArmorRegistry.redEnderChestplate,
                                ArmorRegistry.yellowEnderChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.enderLeggings,
                                ArmorRegistry.blueEnderLeggings,
                                ArmorRegistry.grayEnderLeggings,
                                ArmorRegistry.greenEnderLeggings,
                                ArmorRegistry.redEnderLeggings,
                                ArmorRegistry.yellowEnderLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.enderBoots,
                                ArmorRegistry.blueEnderBoots,
                                ArmorRegistry.grayEnderBoots,
                                ArmorRegistry.greenEnderBoots,
                                ArmorRegistry.redEnderBoots,
                                ArmorRegistry.yellowEnderBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onCancelPlayerReceiveDamage(e, DamageSource::isExplosion))
                        .setRegistryName(DivineRPG.MODID, "ender")
        );

        registry.register(
                new ArmorDescription(ArmorHandlers::onCanFlyChanged)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.angelicHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.angelicChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.angelicLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.angelicBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.onCanFlyChanged(e.player, true))
                        .setRegistryName(DivineRPG.MODID, "angelic")
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.bedrockHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.bedrockChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.bedrockLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.bedrockBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event,
                                source -> source.isFireDamage() || source.isExplosion() || source == DamageSource.LAVA))
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> {
                            event.player.extinguish();
                            event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
                        }).setRegistryName(DivineRPG.MODID, "bedrock")
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.divineHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.divineChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.divineLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.divineBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 6))
                        .withHandler(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.2, 0))
                        .withHandler(LivingFallEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(DivineRPG.MODID, "divine")
        );

        IEquipped stopSpeedUp = (player, isFullEquipped) -> {
            if (!isFullEquipped) {
                ArmorHandlers.removeSpeed(player);
            }
        };

        registry.register(
                new ArmorDescription(stopSpeedUp)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.santaHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.santaChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.santaLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.santaBoots)
                        .withHandler(LivingHurtEvent.class, event -> {
                            if (event.getEntityLiving().world.provider.getDimensionType() == DimensionRegistry.iceikaDimension) {
                                ArmorHandlers.onPlayerReceiveDamage(event, ArmorHandlers::isMeeleeDamage, aFloat -> aFloat * 0.25F);
                                ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 6);
                            }
                        }).withHandler(TickEvent.PlayerTickEvent.class, event -> {
                    if (event.player.world.provider.getDimensionType() == DimensionRegistry.iceikaDimension) {
                        ArmorHandlers.refillHunger(event);
                        ArmorHandlers.speedUpPlayer(event.player, 2, false);
                    } else {
                        ArmorHandlers.removeSpeed(event.player);
                    }
                })
                        .setRegistryName(DivineRPG.MODID, "santa")
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.skelemanHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.skelemanChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.skelemanLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.skelemanBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, ArmorHandlers::refillHunger)
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "skeleman"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.terranHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.terranChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.terranLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.terranBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> event.player.addPotionEffect(new PotionEffect(MobEffects.HASTE,
                                20, 2, true, false)))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "terrain"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.frozenHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.frozenChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.frozenLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.frozenBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> ArmorHandlers.frozeNearMobs(event, 10, 6))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "frozen"))
        );

        registry.register(
                new ArmorDescription(stopSpeedUp)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.shadowHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.shadowChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.shadowLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.shadowBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event ->
                                ArmorHandlers.speedUpPlayer(event.player, 3, false))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "shadow"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.arlemiteHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.arlemiteChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.arlemiteLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.arlemiteBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onPlayerReceiveDamage(event,
                                source -> source.isProjectile() || source.damageType.equals("thrown"),
                                aFloat -> {
                                    float multiplier = 0.2F;

                                    IArmorPowers powers = DivineAPI.getArmorPowers(event.getEntity());
                                    if (powers != null) {
                                        if (powers.currentItems(EntityEquipmentSlot.OFFHAND).contains(ItemRegistry.arlemite_shield)) {
                                            multiplier /= 2;
                                        }
                                    }

                                    return aFloat * multiplier;
                                }))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "arlemite"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.skythernHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.skythernChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.skythernLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.skythernBoots)
                        .withHandler(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.5, 0))
                        .withHandler(LivingFallEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "skythernm"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.haliteHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.haliteChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.haliteLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.haliteBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 16))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "halite"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.awakened_haliteHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.awakened_haliteChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.awakened_haliteLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.awakened_haliteBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 20))
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onAddRangedDamage(event, AWAKENED_HALITE, x -> x * 1.5F))
                        .setRegistryName(AWAKENED_HALITE)
        );

        IEquipped stopSpeedUpInWater = (player, isFullEquipped) -> {
            if (!isFullEquipped) {
                ArmorHandlers.speedUpInWater(player, 0, true);
            }
        };

        registry.register(
                new ArmorDescription(stopSpeedUpInWater)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.aquastriveHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.aquastriveChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.aquastriveLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.aquastriveBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event ->
                                ArmorHandlers.speedUpInWater(event.player, 5, false))
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.DROWN)))
                        .withHandler(TickEvent.PlayerTickEvent.class, ArmorHandlers::breatheUnderwater)
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "aqua"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.krakenHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.krakenChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.krakenLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.krakenBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, ArmorHandlers::breatheUnderwater)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.DROWN)))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "kraken"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.netheriteHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.netheriteChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.netheriteLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.netheriteBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> {
                            event.player.extinguish();
                            event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
                        })
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "netherite"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.infernoHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.infernoChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.infernoLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.infernoBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> {
                            event.player.extinguish();
                            event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
                        })
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "inferno"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.mortumHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.mortumChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.mortumLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.mortumBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> event.player.addPotionEffect(
                                new PotionEffect(MobEffects.NIGHT_VISION, 210, 10, true, false)))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "mortum"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.eliteRealmiteHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.eliteRealmiteChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.eliteRealmiteLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.eliteRealmiteBoots)
                        .withHandler(LivingFallEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "realmite"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.wildwoodHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.wildwoodChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.wildwoodLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.wildwoodBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> {
                            EntityPlayer player = event.player;
                            if (player.isInWater()) {
                                player.heal(0.25F);
                            }
                        })
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "wildwood"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.kormaHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.kormaChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.kormaLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.kormaBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> {
                            IArcana arcana = DivineAPI.getArcana(event.player);
                            if (arcana != null)
                                arcana.fill(event.player, 1);
                        })
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "korma"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.vemosHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.vemosChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.vemosLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.vemosBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> event.player.heal(0.1F))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "vemos"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.jungleHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.jungleChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.jungleLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.jungleBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, DamageSource::isMagicDamage))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "jungle"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.witherReaperHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.witherReaperChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.witherReaperLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.witherReaperBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.WITHER)))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "wither"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.apalachiaHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.apalachiaChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.apalachiaLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.apalachiaBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event,
                                s -> s.equals(DamageSource.CACTUS)
                                        || s.equals(DamageSource.FALLING_BLOCK)
                                        || s.equals(DamageSource.ANVIL)
                                        || s.equals(DamageSource.IN_WALL)
                                        || s.equals(Utils.trapSource)))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "apalachia"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.edenHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.edenChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.edenLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.edenBoots)
                        .withHandler(BlockEvent.HarvestDropsEvent.class, event -> {
                            if (event.getState().getBlock() instanceof BlockTwilightOre && !event.isSilkTouching()) {
                                ItemStack fragment = event.getDrops().get(0);
                                event.getDrops().addAll(Collections.nCopies(3, fragment.copy()));
                            }
                        })
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "eden"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.corruptedHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.corruptedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.corruptedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.corruptedBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onAddRangedDamage(event, CORRUPTED, x -> x * 1.5F))
                        .setRegistryName(CORRUPTED)
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.jackOManHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.jackOManChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.jackOManLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.jackOManBoots)
                        .setRegistryName(JACKOMAN)
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.degradedHood)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.degradedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.degradedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.degradedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.82F))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "degradedHood"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.degradedHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.degradedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.degradedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.degradedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.82F))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "degradedHelmet"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.degradedMask)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.degradedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.degradedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.degradedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.82F))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "degradedMask"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.finishedHood)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.finishedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.finishedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.finishedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.773F))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "finishedHood"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.finishedHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.finishedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.finishedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.finishedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.773F))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "finishedHelmet"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.finishedMask)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.finishedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.finishedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.finishedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.773F))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "finishedMask"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.glisteningHood)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.glisteningChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.glisteningLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.glisteningBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.7F))
                        .withHandler(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.2, 0))
                        .withHandler(LivingFallEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "glisteningHood"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.glisteningHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.glisteningChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.glisteningLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.glisteningBoots)
                        .withHandler(LivingHurtEvent.class, e -> {
                            ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.7F);
                            ArmorHandlers.onAddMeleeDamage(e, x -> x + 3);
                        })
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "glisteningHelmet"))
        );

        registry.register(
                new ArmorDescription(stopSpeedUp)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.glisteningMask)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.glisteningChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.glisteningLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.glisteningBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.7F))
                        .withHandler(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 1.4F, false))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "glisteningMask"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.demonizedHood)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.demonizedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.demonizedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.demonizedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.625F))
                        .withHandler(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.3, 0))
                        .withHandler(LivingFallEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "demonizedHood"))
        );
        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.demonizedHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.demonizedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.demonizedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.demonizedBoots)
                        .withHandler(LivingHurtEvent.class, e -> {
                            ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.625F);
                            ArmorHandlers.onAddMeleeDamage(e, x -> x + 6);
                        })
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "demonizedHelmet"))
        );

        registry.register(
                new ArmorDescription(stopSpeedUp)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.demonizedMask)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.demonizedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.demonizedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.demonizedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.625F))
                        .withHandler(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 1.8F, false))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "demonizedMask"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.tormentedHood)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.tormentedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.tormentedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.tormentedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.348F))
                        .withHandler(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.4, 0))
                        .withHandler(LivingFallEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "tormentedHood"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.tormentedHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.tormentedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.tormentedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.tormentedBoots)
                        .withHandler(LivingHurtEvent.class, e -> {
                            ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.348F);
                            ArmorHandlers.onAddMeleeDamage(e, x -> x + 9);
                        })
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "tormentedHelmet"))
        );

        registry.register(
                new ArmorDescription(stopSpeedUp)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ArmorRegistry.tormentedMask)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ArmorRegistry.tormentedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ArmorRegistry.tormentedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ArmorRegistry.tormentedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.348F))
                        .withHandler(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 2.2F, false))
                        .setRegistryName(new ResourceLocation(DivineRPG.MODID, "tormentedMask"))
        );
    }
}
