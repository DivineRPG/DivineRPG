package naturix.divinerpg.registry;

import naturix.divinerpg.entities.EntityThrower;
import naturix.divinerpg.entities.projectile.serenade.EntitySerenadeOfIce;
import naturix.divinerpg.entities.render.EntityResourceLocation;
import naturix.divinerpg.entities.render.RenderSpecialProjectile;
import naturix.divinerpg.entities.render.RenderThrower;
import naturix.divinerpg.utils.Utils;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ModEntities {

	private static RenderManager RenderManager;

	public static void init() {
		Utils.registerProjectile(EntitySerenadeOfIce.class, "Ice"); 
		
		
		RenderingRegistry.registerEntityRenderingHandler(EntityThrower.class, new RenderThrower(RenderManager, "ball_thrown"));
		RenderingRegistry.registerEntityRenderingHandler(EntitySerenadeOfIce.class, new RenderSpecialProjectile(EntityResourceLocation.blank));

	}
	
}
