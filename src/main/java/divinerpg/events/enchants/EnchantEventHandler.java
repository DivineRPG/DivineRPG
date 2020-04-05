package divinerpg.events.enchants;

import divinerpg.registry.EnchantRegister;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Mod.EventBusSubscriber
public class EnchantEventHandler {
    /**
     * Map of digging tasks to prevent cascading digging
     */
    private static final Queue<DiggingTask> diggingTasks = new ConcurrentLinkedQueue<>();


    @SubscribeEvent
    public static void onBreakBlock(BlockEvent.BreakEvent event) {
        if (!(event.getPlayer() instanceof EntityPlayerMP))
            return;

        // cancel event on sneaking
        if (event.getPlayer().isSneaking())
            return;

        // is already in work
        if (diggingTasks.stream().anyMatch(x -> x.isInWork(event.getPlayer(), event.getPos())))
            return;

        int level = EnchantmentHelper.getEnchantmentLevel(EnchantRegister.world_break, event.getPlayer().getHeldItemMainhand());

        // no world break enchanting applied
        if (level < 1)
            return;

        // creating task and adding it to list
        DiggingTask task = new DiggingTask((EntityPlayerMP) event.getPlayer(), event.getPos(), level);
        diggingTasks.add(task);

        // perform task and remove it from list
        task.perform();
        diggingTasks.remove(task);
    }
}
