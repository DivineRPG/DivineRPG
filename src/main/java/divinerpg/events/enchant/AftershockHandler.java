package divinerpg.events.enchant;

import divinerpg.registries.EnchantmentRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

@EventBusSubscriber
public class AftershockHandler {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onHurt(LivingDamageEvent.Pre event) {
//        if(event.isCanceled()) return;
        Entity entity = event.getSource().getDirectEntity();
        if(!(entity instanceof LivingEntity livingEntity)) return;
        int level = EnchantmentHelper.getEnchantmentLevel(entity.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(EnchantmentRegistry.AFTERSHOCK), livingEntity);
        if(level < 1) return;
        //Hooray for me, I'm the lucky one!
        if(livingEntity.getRandom().nextInt(100) > level * 5) return;
        event.setNewDamage(event.getNewDamage() * 2);
    }
}