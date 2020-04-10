package divinerpg.events.enchants;

import divinerpg.registry.EnchantRegister;
import divinerpg.utils.tasks.ITask;
import divinerpg.utils.tasks.TaskFactory;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.UUID;

public class DiggingTaskFactory extends TaskFactory<BlockEvent.HarvestDropsEvent> {
    public DiggingTaskFactory() {
        super(e -> e.getHarvester() == null ? null : e.getHarvester().getUniqueID());
    }

    @Override
    protected ITask<BlockEvent.HarvestDropsEvent> createTask(UUID id, BlockEvent.HarvestDropsEvent event) {
        if (event.getHarvester() instanceof EntityPlayerMP) {
            return new DiggingTask(event);
        }

        return null;
    }

    @Override
    protected boolean shouldProceed(BlockEvent.HarvestDropsEvent event) {
        if (event == null || event.getHarvester() == null || event.getPos() == null)
            return false;

        EntityPlayer player = event.getHarvester();
        // server side only
        if (player.isSneaking() || !(player instanceof EntityPlayerMP))
            return false;

        int level = EnchantmentHelper.getEnchantmentLevel(EnchantRegister.world_break, event.getHarvester().getHeldItemMainhand());
        return level >= 1;
    }

    @Override
    protected IThreadListener getListener(BlockEvent.HarvestDropsEvent event) {
        return event.getHarvester().getServer();
    }

    @SubscribeEvent
    public void onListen(BlockEvent.HarvestDropsEvent event) {
        super.listen(event);
    }
}
