package divinerpg.events.enchants;

import divinerpg.registry.EnchantmentRegistry;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class DoubleDealDamage {

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onHurt(LivingHurtEvent e) {
        if (e.isCanceled())
            return;

        Entity entity = e.getSource().getTrueSource();
        if (!(entity instanceof EntityLivingBase))
            return;

        int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.double_dealing_damage, ((EntityLivingBase) entity).getHeldItemMainhand());
        if (level < 1)
            return;

        // we are not lucky
        if (((EntityLivingBase) entity).getRNG().nextInt(100) > level * 5)
            return;

        e.setAmount(e.getAmount() * 2);
    }
}
