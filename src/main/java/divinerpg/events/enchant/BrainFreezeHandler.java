package divinerpg.events.enchant;

import divinerpg.DivineRPG;
import divinerpg.registries.EnchantmentRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;

@EventBusSubscriber(modid = DivineRPG.MODID, bus = EventBusSubscriber.Bus.MOD)
public class BrainFreezeHandler {
    @SubscribeEvent
    public static void onHurt(LivingIncomingDamageEvent event) {
        if(event.isCanceled()) return;
        Entity entity = event.getSource().getDirectEntity();
        if(!(entity instanceof LivingEntity livingEntity)) return;
        int level = EnchantmentHelper.getEnchantmentLevel(entity.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getHolderOrThrow(EnchantmentRegistry.BRAIN_FREEZE), livingEntity);
        if(level < 1) return;
        if(livingEntity.getRandom().nextInt(100) > 30 - level * 5) return;
        event.getEntity().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20 * level, 10, true, false, false));
    }
}