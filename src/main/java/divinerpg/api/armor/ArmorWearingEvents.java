package divinerpg.api.armor;

import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ArmorWearingEvents {
    // todo Fix all of it

//    @SubscribeEvent
//    public static void notifyChanges(LivingEquipmentChangeEvent event) {
//        IArmorPowers powers = DivineAPI.getArmorPowers(event.getEntity());
//        if (powers == null)
//            return;
//
//        EntityPlayer entity = (EntityPlayer) event.getEntity();
//        ArmorEquippedEvent armorEquippedEvent = new ArmorEquippedEvent(entity);
//        MinecraftForge.EVENT_BUS.post(armorEquippedEvent);
//
//        Set<ResourceLocation> added = armorEquippedEvent.getConfirmed();
//        added.removeAll(powers.wearing());
//
//        Set<ResourceLocation> old = powers.wearing();
//        old.removeAll(armorEquippedEvent.getConfirmed());
//
//        old.forEach(powers::takeOff);
//        added.forEach(powers::putOn);
//    }
//
//    @SubscribeEvent(priority = EventPriority.LOWEST)
//    public static void detectIsOn(ArmorEquippedEvent event) {
//        IForgeRegistry<IArmorDescription> registry = DivineAPI.getArmorDescriptionRegistry();
//        if (registry == null)
//            return;
//
//        registry.getEntries().parallelStream()
//                .filter(x -> x.getValue() != null)
//                .filter(x -> {
//                    IArmorDescription description = x.getValue();
//
//                    for (EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
//                        Set<Item> setItems = description.getPossibleItems(slot);
//                        Set<Item> currentItems = event.getItemsInSlot(slot);
//
//                        if (!setItems.isEmpty() && setItems.stream().noneMatch(currentItems::contains)){
//                            return false;
//                        }
//                    }
//
//                    return true;
//                }).sequential()
//                .forEach(x -> event.confirm(x.getKey()));
//    }
}
