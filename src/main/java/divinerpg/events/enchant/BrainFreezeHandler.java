package divinerpg.events.enchant;

import divinerpg.DivineRPG;
import divinerpg.registries.EnchantmentRegistry;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BrainFreezeHandler {
    @SubscribeEvent
    public static void onHurt(LivingAttackEvent event) {
        if(event.isCanceled()) return;
        Entity entity = event.getSource().getDirectEntity();
        if(!(entity instanceof LivingEntity livingEntity)) return;
        int level = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.BRAIN_FREEZE.get(), livingEntity);
        if(level < 1) return;
        if(livingEntity.getRandom().nextInt(100) > 30 - level * 5) return;
        event.getEntity().addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20 * level, 10, true, false, false));
    }
}