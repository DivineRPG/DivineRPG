package naturix.divinerpg.registry;

import naturix.divinerpg.entities.EntityThrower;
import naturix.divinerpg.entities.render.RenderThrower;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ModEntities {

	private static RenderManager RenderManager;

	public static void init() {
		RenderingRegistry.registerEntityRenderingHandler(EntityThrower.class, new RenderThrower(RenderManager, "ball_thrown"));
	}
	
}
