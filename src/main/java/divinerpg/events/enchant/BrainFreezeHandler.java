package divinerpg.events.enchant;

import divinerpg.DivineRPG;
import divinerpg.registries.EnchantmentRegistry;
import net.minecraft.world.effect.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = DivineRPG.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BrainFreezeHandler {

    @SubscribeEvent
    public static void onLivingAttack(LivingAttackEvent event) {
        if (event.getSource().getEntity() != null && !event.getSource().getEntity().level().isClientSide) {
            if (event.getSource().getDirectEntity() instanceof Player) {
                Player player = (Player) event.getSource().getDirectEntity();
                int enchantmentLevel = EnchantmentHelper.getEnchantmentLevel(EnchantmentRegistry.BRAIN_FREEZE.get(), player);

                if (enchantmentLevel > 0) {
                    Random random = new Random();
                    int chance = 30 - enchantmentLevel * 5;

                    if (random.nextInt(100) < chance) {
                        LivingEntity target = event.getEntity();

                        // Add null check before accessing level()
                        if (target != null && target.level() != null) {
                            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 2 * enchantmentLevel, 10, true, false, false));
                        }
                    }
                }
            }
        }
    }
}
