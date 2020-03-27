package divinerpg.registry;

import divinerpg.DivineRPG;
import divinerpg.api.ArmorHandlers;
import divinerpg.api.Reference;
import divinerpg.api.armor.registry.IArmorDescription;
import divinerpg.capabilities.armor.ArmorDescription;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.registries.IForgeRegistry;

@Mod.EventBusSubscriber
public class ArmorDescriptionRegister {

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
                        .withHandler(LivingHurtEvent.class, e -> ArmorHandlers.onPlayerReceiveDamage(e, ArmorHandlers::isMeeleeDamage, f -> f * 0.25F))
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
    }
}
