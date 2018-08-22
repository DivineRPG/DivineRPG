package naturix.divinerpg.registry;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.assets.render.RenderAncientEntity;
import naturix.divinerpg.entities.assets.render.RenderDeathHound;
import naturix.divinerpg.entities.assets.render.RenderDramcryx;
import naturix.divinerpg.entities.assets.render.RenderDramix;
import naturix.divinerpg.entities.assets.render.RenderShark;
import naturix.divinerpg.entities.assets.render.RenderVamecheron;
import naturix.divinerpg.entities.entity.AncientEntity;
import naturix.divinerpg.entities.entity.DeathHound;
import naturix.divinerpg.entities.entity.Dramix;
import naturix.divinerpg.entities.entity.JungleStegosaurus;
import naturix.divinerpg.entities.entity.LandShark;
import naturix.divinerpg.entities.entity.Vamecheron;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
public class ModEntities {
	public static void init() {
		//register basic mobs
		int id = 1;
		id = 100;
		//register advanced mobs
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "dramcryx_jungle"), JungleStegosaurus.class, "dramcryx_jungle", id++, DivineRPG.instance, 64, 3, true, 0x996600, 0x00ff00);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "ancient_entity"), AncientEntity.class, "ancient_entity", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "shark"), LandShark.class, "shark", id++, DivineRPG.instance, 64, 3, true, 0x996600, 0x00ff00);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "death_hound"), DeathHound.class, "death_hound", id++, DivineRPG.instance, 64, 3, true, 0x996600, 0x00ff00);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "vamacheron_boss"), Vamecheron.class, "vamacheron_boss", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "dramix_boss"), Dramix.class, "dramix_boss", id++, DivineRPG.instance, 64, 3, true);


		DivineRPG.logger.info(DivineRPG.modId +" entities have been loaded");
		//Spawn
		EntityRegistry.addSpawn(JungleStegosaurus.class, 250, 1, 10, EnumCreatureType.MONSTER, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.MUTATED_JUNGLE, Biomes.MUTATED_JUNGLE_EDGE);
		
		DivineRPG.logger.info(DivineRPG.modId +" spawns have been loaded");
		
		//loot
		LootTableList.register(JungleStegosaurus.LOOT);
		LootTableList.register(AncientEntity.LOOT);
		LootTableList.register(LandShark.LOOT);
		
		DivineRPG.logger.info(DivineRPG.modId +" loot has been loaded");

	}
	public static void initModels() {
		RenderingRegistry.registerEntityRenderingHandler(JungleStegosaurus.class, RenderDramcryx.FACTORY);
		//RenderingRegistry.registerEntityRenderingHandler(AncientEntity.class, RenderAncientEntity.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(LandShark.class, RenderShark.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(DeathHound.class, RenderDeathHound.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Vamecheron.class, RenderVamecheron.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Dramix.class, RenderDramix.FACTORY);
		}
}
