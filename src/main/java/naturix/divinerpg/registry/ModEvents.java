package naturix.divinerpg.registry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.events.EventArmorSet;
import naturix.divinerpg.objects.items.ItemSpawnEgg;
import naturix.divinerpg.utils.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber(modid = Reference.MODID)
public class ModEvents {
	public static final ExecutorService THREAD_POOL = new ThreadPoolExecutor(0, 2, 1, TimeUnit.MINUTES,
	        new LinkedBlockingQueue<Runnable>());

	@SubscribeEvent(priority = EventPriority.HIGHEST, receiveCanceled = true)
	public static void onEvent(RightClickBlock event) {
		EntityPlayer thePlayer = event.getEntityPlayer();
		if (thePlayer instanceof EntityPlayerMP) {
			EntityPlayerMP thePlayerMP = (EntityPlayerMP) thePlayer;

			// DEBUG
			//System.out.println("Right clicking block with " + thePlayer.getHeldItem(event.getHand()));

			if (thePlayer.getHeldItem(event.getHand()).getItem() instanceof ItemSpawnEgg) {
				ModTriggers.SPAWN_PET.trigger(thePlayerMP);
			}
		}
	}

	public static void postForgeEvent(Object o) {
		MinecraftForge.EVENT_BUS.register(o);
	}

	public static void preInit() {
		postForgeEvent(new EventArmorSet());
	}
}
