package naturix.divinerpg.registry;

import net.minecraftforge.common.MinecraftForge;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ModEvents {
	public static final ExecutorService THREAD_POOL = new ThreadPoolExecutor(0, 2, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<Runnable>());
	
	public static void postForgeEvent(Object o) {
        MinecraftForge.EVENT_BUS.register(o);
    }
	public static void preInit() {
        //postForgeEvent(new EventArmorSet());
		 }
	}
