package naturix.divinerpg.registry;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.hostile.entity.dramcryx.JungleStegosaurus;
import naturix.divinerpg.entities.hostile.model.ModelDramcryx;
import naturix.divinerpg.entities.hostile.render.RenderDramcryx;
import naturix.divinerpg.entities.projectile.serenade.EntityDeath;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
public class ModEntities {
	public static void init() {
		int id = 1;
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "serenade_death"), EntityDeath.class, "death", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "serenade_ice"), EntityDeath.class, "ice", id++, DivineRPG.instance, 64, 3, true);
		id = 100;
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "dramcryx_jungle"), JungleStegosaurus.class, "dramcryx_jungle", id++, DivineRPG.instance, 64, 3, true, 0x222222, 0x555555);
        
		LootTableList.register(JungleStegosaurus.LOOT);
		DivineRPG.logger.info(DivineRPG.modId +" entities have been loaded");
	}
	public static void initModels() {
		RenderingRegistry.registerEntityRenderingHandler(JungleStegosaurus.class, new RenderDramcryx(1));
		//RenderingRegistry.registerEntityRenderingHandler(JungleStegosaurus.class, RenderDramcryx.FACTORY);}
}
}
