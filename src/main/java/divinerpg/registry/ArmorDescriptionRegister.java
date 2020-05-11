package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.api.ArmorHandlers;
import divinerpg.api.DivineAPI;
import divinerpg.api.Reference;
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
public class ArmorDescriptionRegister {

    public static final ResourceLocation AWAKENED_HALITE = new ResourceLocation(Reference.MODID, "awakened_halite");
    public static final ResourceLocation CORRUPTED = new ResourceLocation(Reference.MODID, "corrupted");
    public static final ResourceLocation JACKOMAN = new ResourceLocation(Reference.MODID, "jackoman");

    @SubscribeEvent
    public static void registerArmors(RegistryEvent.Register<IArmorDescription> registryEvent) {
        DivineRPG.logger.info("Registering armor descriptions");

        IForgeRegistry<IArmorDescription> registry = registryEvent.getRegistry();

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD,
                                ModArmor.rupeeHelmet,
                                ModArmor.blueRupeeHelmet,
                                ModArmor.grayRupeeHelmet,
                                ModArmor.greenRupeeHelmet,
                                ModArmor.redRupeeHelmet,
                                ModArmor.yellowRupeeHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.rupeeChestplate,
                                ModArmor.blueRupeeChestplate,
                                ModArmor.grayRupeeChestplate,
                                ModArmor.greenRupeeChestplate,
                                ModArmor.redRupeeChestplate,
                                ModArmor.yellowRupeeChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.rupeeLeggings,
                                ModArmor.blueRupeeLeggings,
                                ModArmor.grayRupeeLeggings,
                                ModArmor.greenRupeeLeggings,
                                ModArmor.redRupeeLeggings,
                                ModArmor.yellowRupeeLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.rupeeBoots,
                                ModArmor.blueRupeeBoots,
                                ModArmor.grayRupeeBoots,
                                ModArmor.greenRupeeBoots,
                                ModArmor.redRupeeBoots,
                                ModArmor.yellowRupeeBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, ArmorHandlers::isMeeleeDamage, f -> {
                            float multiplier = 0.25F;
//                            IArmorPowers powers = DivineAPI.getArmorPowers(e.getEntity());
//
//                            if (powers != null) {
//                                if (powers.currentItems(EntityEquipmentSlot.OFFHAND).contains(ModArmor.rupee_shield)){
//                                    multiplier /= 2;
//                                }
//                            }

                            return f * multiplier;
                        }))
                        .setRegistryName(Reference.MODID, "rupee")
        );


        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.enderHelmet,
                                ModArmor.blueEnderHelmet,
                                ModArmor.grayEnderHelmet,
                                ModArmor.greenEnderHelmet,
                                ModArmor.redEnderHelmet,
                                ModArmor.yellowEnderHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.enderChestplate,
                                ModArmor.blueEnderChestplate,
                                ModArmor.grayEnderChestplate,
                                ModArmor.greenEnderChestplate,
                                ModArmor.redEnderChestplate,
                                ModArmor.yellowEnderChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.enderLeggings,
                                ModArmor.blueEnderLeggings,
                                ModArmor.grayEnderLeggings,
                                ModArmor.greenEnderLeggings,
                                ModArmor.redEnderLeggings,
                                ModArmor.yellowEnderLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.enderBoots,
                                ModArmor.blueEnderBoots,
                                ModArmor.grayEnderBoots,
                                ModArmor.greenEnderBoots,
                                ModArmor.redEnderBoots,
                                ModArmor.yellowEnderBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onCancelPlayerReceiveDamage(e, DamageSource::isExplosion))
                        .setRegistryName(Reference.MODID, "ender")
        );

        registry.register(
                new ArmorDescription(ArmorHandlers::onCanFlyChanged)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.angelicHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.angelicChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.angelicLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.angelicBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.onCanFlyChanged(e.player, true))
                        .setRegistryName(Reference.MODID, "angelic")
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.bedrockHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.bedrockChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.bedrockLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.bedrockBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event,
                                source -> source.isFireDamage() || source.isExplosion() || source == DamageSource.LAVA))
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> {
                            event.player.extinguish();
                            event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
                        }).setRegistryName(Reference.MODID, "bedrock")
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.divineHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.divineChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.divineLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.divineBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 6))
                        .withHandler(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.2, 0))
                        .withHandler(LivingFallEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(Reference.MODID, "divine")
        );

        IEquipped stopSpeedUp = (player, isFullEquipped) -> {
            if (!isFullEquipped) {
                ArmorHandlers.removeSpeed(player);
            }
        };

        registry.register(
                new ArmorDescription(stopSpeedUp)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.santaHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.santaChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.santaLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.santaBoots)
                        .withHandler(LivingHurtEvent.class, event -> {
                            if (event.getEntityLiving().world.provider.getDimensionType() == ModDimensions.iceikaDimension) {
                                ArmorHandlers.onPlayerReceiveDamage(event, ArmorHandlers::isMeeleeDamage, aFloat -> aFloat * 0.25F);
                                ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 6);
                            }
                        }).withHandler(TickEvent.PlayerTickEvent.class, event -> {
                    if (event.player.world.provider.getDimensionType() == ModDimensions.iceikaDimension) {
                        ArmorHandlers.refillHunger(event);
                        ArmorHandlers.speedUpPlayer(event.player, 2, false);
                    } else {
                        ArmorHandlers.removeSpeed(event.player);
                    }
                })
                        .setRegistryName(Reference.MODID, "santa")
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.skelemanHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.skelemanChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.skelemanLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.skelemanBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, ArmorHandlers::refillHunger)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "skeleman"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.terranHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.terranChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.terranLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.terranBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> event.player.addPotionEffect(new PotionEffect(MobEffects.HASTE,
                                20, 2, true, false)))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "terrain"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.frozenHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.frozenChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.frozenLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.frozenBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> ArmorHandlers.frozeNearMobs(event, 10, 6))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "frozen"))
        );

        registry.register(
                new ArmorDescription(stopSpeedUp)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.shadowHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.shadowChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.shadowLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.shadowBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event ->
                                ArmorHandlers.speedUpPlayer(event.player, 3, false))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "shadow"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.arlemiteHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.arlemiteChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.arlemiteLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.arlemiteBoots)
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
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.skythernHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.skythernChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.skythernLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.skythernBoots)
                        .withHandler(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.5, 0))
                        .withHandler(LivingFallEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "skythernm"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.haliteHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.haliteChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.haliteLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.haliteBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onAddMeleeDamage(event, amount -> amount + 16))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "halite"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.awakened_haliteHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.awakened_haliteChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.awakened_haliteLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.awakened_haliteBoots)
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
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.aquastriveHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.aquastriveChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.aquastriveLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.aquastriveBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event ->
                                ArmorHandlers.speedUpInWater(event.player, 5, false))
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.DROWN)))
                        .withHandler(TickEvent.PlayerTickEvent.class, ArmorHandlers::breatheUnderwater)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "aqua"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.krakenHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.krakenChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.krakenLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.krakenBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, ArmorHandlers::breatheUnderwater)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.DROWN)))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "kraken"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.netheriteHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.netheriteChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.netheriteLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.netheriteBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> {
                            event.player.extinguish();
                            event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "netherite"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.infernoHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.infernoChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.infernoLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.infernoBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> {
                            event.player.extinguish();
                            event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 40, 0, true, false));
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "inferno"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.mortumHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.mortumChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.mortumLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.mortumBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> event.player.addPotionEffect(
                                new PotionEffect(MobEffects.NIGHT_VISION, 210, 10, true, false)))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "mortum"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.eliteRealmiteHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.eliteRealmiteChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.eliteRealmiteLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.eliteRealmiteBoots)
                        .withHandler(LivingFallEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "realmite"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.wildwoodHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.wildwoodChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.wildwoodLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.wildwoodBoots)
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
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.kormaHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.kormaChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.kormaLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.kormaBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> {
                            IArcana arcana = DivineAPI.getArcana(event.player);
                            if (arcana != null)
                                arcana.fill(event.player, 1);
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "korma"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.vemosHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.vemosChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.vemosLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.vemosBoots)
                        .withHandler(TickEvent.PlayerTickEvent.class, event -> event.player.heal(0.1F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "vemos"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.jungleHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.jungleChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.jungleLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.jungleBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, DamageSource::isMagicDamage))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "jungle"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.witherReaperHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.witherReaperChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.witherReaperLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.witherReaperBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onCancelPlayerReceiveDamage(event, source -> source.equals(DamageSource.WITHER)))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "wither"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.apalachiaHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.apalachiaChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.apalachiaLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.apalachiaBoots)
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
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.edenHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.edenChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.edenLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.edenBoots)
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
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.corruptedHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.corruptedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.corruptedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.corruptedBoots)
                        .withHandler(LivingHurtEvent.class, event -> ArmorHandlers.onAddRangedDamage(event, CORRUPTED, x -> x * 1.5F))
                        .setRegistryName(CORRUPTED)
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.jackOManHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.jackOManChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.jackOManLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.jackOManBoots)
                        .setRegistryName(JACKOMAN)
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.degradedHood)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.degradedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.degradedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.degradedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.82F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "degradedHood"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.degradedHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.degradedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.degradedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.degradedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.82F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "degradedHelmet"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.degradedMask)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.degradedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.degradedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.degradedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.82F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "degradedMask"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.finishedHood)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.finishedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.finishedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.finishedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.773F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "finishedHood"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.finishedHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.finishedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.finishedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.finishedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.773F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "finishedHelmet"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.finishedMask)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.finishedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.finishedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.finishedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.773F))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "finishedMask"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.glisteningHood)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.glisteningChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.glisteningLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.glisteningBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.7F))
                        .withHandler(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.2, 0))
                        .withHandler(LivingFallEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "glisteningHood"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.glisteningHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.glisteningChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.glisteningLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.glisteningBoots)
                        .withHandler(LivingHurtEvent.class, e -> {
                            ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.7F);
                            ArmorHandlers.onAddMeleeDamage(e, x -> x + 3);
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "glisteningHelmet"))
        );

        registry.register(
                new ArmorDescription(stopSpeedUp)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.glisteningMask)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.glisteningChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.glisteningLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.glisteningBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.7F))
                        .withHandler(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 1.4F, false))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "glisteningMask"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.demonizedHood)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.demonizedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.demonizedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.demonizedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.625F))
                        .withHandler(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.3, 0))
                        .withHandler(LivingFallEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "demonizedHood"))
        );
        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.demonizedHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.demonizedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.demonizedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.demonizedBoots)
                        .withHandler(LivingHurtEvent.class, e -> {
                            ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.625F);
                            ArmorHandlers.onAddMeleeDamage(e, x -> x + 6);
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "demonizedHelmet"))
        );

        registry.register(
                new ArmorDescription(stopSpeedUp)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.demonizedMask)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.demonizedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.demonizedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.demonizedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.625F))
                        .withHandler(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 1.8F, false))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "demonizedMask"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.tormentedHood)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.tormentedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.tormentedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.tormentedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, DamageSource::isMagicDamage, x -> x * 0.348F))
                        .withHandler(LivingEvent.LivingJumpEvent.class, event -> event.getEntityLiving().addVelocity(0, 0.4, 0))
                        .withHandler(LivingFallEvent.class, ArmorHandlers::disableFallDamage)
                        .setRegistryName(new ResourceLocation(Reference.MODID, "tormentedHood"))
        );

        registry.register(
                new ArmorDescription()
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.tormentedHelmet)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.tormentedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.tormentedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.tormentedBoots)
                        .withHandler(LivingHurtEvent.class, e -> {
                            ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && !x.isProjectile(), x -> x * 0.348F);
                            ArmorHandlers.onAddMeleeDamage(e, x -> x + 9);
                        })
                        .setRegistryName(new ResourceLocation(Reference.MODID, "tormentedHelmet"))
        );

        registry.register(
                new ArmorDescription(stopSpeedUp)
                        .withPossibleItems(EntityEquipmentSlot.HEAD, ModArmor.tormentedMask)
                        .withPossibleItems(EntityEquipmentSlot.CHEST, ModArmor.tormentedChestplate)
                        .withPossibleItems(EntityEquipmentSlot.LEGS, ModArmor.tormentedLeggings)
                        .withPossibleItems(EntityEquipmentSlot.FEET, ModArmor.tormentedBoots)
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, x -> !x.isMagicDamage() && x.isProjectile(), x -> x * 0.348F))
                        .withHandler(TickEvent.PlayerTickEvent.class, e -> ArmorHandlers.speedUpPlayer(e.player, 2.2F, false))
                        .setRegistryName(new ResourceLocation(Reference.MODID, "tormentedMask"))
        );
    }
}
