package divinerpg.events.enchant;

import divinerpg.registries.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.common.*;

@Mod.EventBusSubscriber
public class AftershockEnchant {
    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onHurt(LivingHurtEvent e) {
        if (e.isCanceled())
            return;

        Entity entity = e.getSource().getDirectEntity();
        if (!(entity instanceof LivingEntity))
            return;

        int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.AFTERSHOCK.get(), ((LivingEntity) entity));
        if (level < 1)
            return;

        // we are not lucky
        if (((LivingEntity) entity).getRandom().nextInt(100) > level * 5)
            return;

        e.setAmount(e.getAmount() * 2);
    }
}
