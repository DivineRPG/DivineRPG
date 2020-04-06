package divinerpg.events.enchants;

import divinerpg.registry.EnchantRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class EnchantEventHandler {
    @SubscribeEvent
    public static void onBreakBlock(BlockEvent.BreakEvent event) {
        if (!(event.getPlayer() instanceof EntityPlayerMP))
            return;

        // cancel event on sneaking
        if (event.getPlayer().isSneaking())
            return;

        // is already in work
        if (DiggingTask.isInWork(event))
            return;

        int level = EnchantmentHelper.getEnchantmentLevel(EnchantRegister.world_break, event.getPlayer().getHeldItemMainhand());

        // no world break enchanting applied
        if (level < 1)
            return;

        EntityPlayerMP player = (EntityPlayerMP) event.getPlayer();

        if (player.mcServer != null && player.interactionManager != null) {
            // creating task and adding it to list
            DiggingTask task = new DiggingTask(player.mcServer, player, event.getPos(), level);
            // performing task
            task.perform();
        }
    }
}
