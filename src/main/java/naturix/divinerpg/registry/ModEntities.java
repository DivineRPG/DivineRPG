package naturix.divinerpg.registry;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.hostile.dramcryx.JungleStegosaurus;
import naturix.divinerpg.entities.hostile.render.RenderDramcryx;
import naturix.divinerpg.entities.projectile.serenade.EntityDeath;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities {

	private static RenderManager RenderManager;

	public static void init() {
		int id = 1;
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "serenade_death"), EntityDeath.class, "death", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "serenade_ice"), EntityDeath.class, "ice", id++, DivineRPG.instance, 64, 3, true);
		id = 100;
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "dramcryx_jungle"), JungleStegosaurus.class, "dramcryx_jungle", id++, DivineRPG.instance, 64, 3, true, 0x996600, 0x00ff00);
		
		LootTableList.register(JungleStegosaurus.LOOT);
		DivineRPG.logger.info(DivineRPG.modId +" entities have been loaded");
	}
	public static void initModels() {
		//RenderingRegistry.registerEntityRenderingHandler(EntityThrower.class, new RenderThrower(RenderManager, "ball_thrown"));
		//RenderingRegistry.registerEntityRenderingHandler(EntitySerenadeOfIce.class, new RenderSpecialProjectile(EntityResourceLocation.blank));
		//RenderingRegistry.registerEntityRenderingHandler(EntityDeath.class, new RenderSpecialProjectile(EntityResourceLocation.death));

		RenderingRegistry.registerEntityRenderingHandler(JungleStegosaurus.class, RenderDramcryx.FACTORY);
		}
}
