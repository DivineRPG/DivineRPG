package divinerpg.events.enchant;

import divinerpg.registries.EnchantmentRegistry;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class AftershockHandler {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onHurt(LivingHurtEvent event) {
        if(event.isCanceled()) return;
        Entity entity = event.getSource().getDirectEntity();
        if(!(entity instanceof LivingEntity livingEntity)) return;
        int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.AFTERSHOCK.get(), livingEntity);
        if(level < 1) return;
        //Hooray for me, I'm the lucky one!
        if(livingEntity.getRandom().nextInt(100) > level * 5) return;
        event.setAmount(event.getAmount() * 2);
    }
}