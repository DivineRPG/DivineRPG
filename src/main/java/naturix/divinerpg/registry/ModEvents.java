package naturix.divinerpg.registry;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.events.EventArmorSet;
import naturix.divinerpg.events.EventArmorTick;
import naturix.divinerpg.objects.entities.entity.twilight.TwilightArcher;
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

		if (Config.debug) {
			DivineRPG.logger.info("Right clicking block with " + thePlayer.getHeldItem(event.getHand()));
		}
		// FIXME - this is not as easy for the Forge Spawn Eggs
		// if (thePlayer.getHeldItem(event.getHand()).getItem() instanceof
		// ItemPetSpawnEgg) {
		// ModTriggers.SPAWN_PET.trigger(thePlayerMP);
		// }
		if (thePlayer.getHeldItem(event.getHand()).getItem() == ModItems.densosCrystal
		        && thePlayer.world.provider.getDimensionType().getId() == Config.mortumDimensionId) {
			ModTriggers.TEN_HEADS.trigger(thePlayerMP);
		}
		if (thePlayer.getHeldItem(event.getHand()).getItem() == ModItems.eternalArcherCrystal
		        && thePlayer.world.provider.getDimensionType().getId() == Config.mortumDimensionId) {
			ModTriggers.SIX_ONE.trigger(thePlayerMP);
		}
		if (thePlayer.getAttackingEntity() instanceof TwilightArcher) {
			ModTriggers.ARROW_KNEE.trigger(thePlayerMP);
		}
	}
}

public static void postForgeEvent(Object o) {
	MinecraftForge.EVENT_BUS.register(o);
}

public static void preInit() {
	postForgeEvent(new EventArmorSet());
	postForgeEvent(new EventArmorTick());
}
}
