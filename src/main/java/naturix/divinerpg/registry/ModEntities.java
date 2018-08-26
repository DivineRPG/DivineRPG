package naturix.divinerpg.registry;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.assets.render.RenderAncientEntity;
import naturix.divinerpg.entities.assets.render.RenderDeathHound;
import naturix.divinerpg.entities.assets.render.RenderDramcryx;
import naturix.divinerpg.entities.assets.render.RenderDramix;
import naturix.divinerpg.entities.assets.render.RenderDungeonDemon;
import naturix.divinerpg.entities.assets.render.RenderEnderTriplets;
import naturix.divinerpg.entities.assets.render.RenderEye;
import naturix.divinerpg.entities.assets.render.RenderLeorna;
import naturix.divinerpg.entities.assets.render.RenderRotatick;
import naturix.divinerpg.entities.assets.render.RenderShark;
import naturix.divinerpg.entities.assets.render.RenderVamecheron;
import naturix.divinerpg.entities.assets.render.RenderWatcher;
import naturix.divinerpg.entities.assets.render.RenderWildFire;
import naturix.divinerpg.entities.entity.AncientEntity;
import naturix.divinerpg.entities.entity.DeathHound;
import naturix.divinerpg.entities.entity.Dramix;
import naturix.divinerpg.entities.entity.DungeonDemon;
import naturix.divinerpg.entities.entity.EnderTriplets;
import naturix.divinerpg.entities.entity.JungleStegosaurus;
import naturix.divinerpg.entities.entity.LandShark;
import naturix.divinerpg.entities.entity.Leorna;
import naturix.divinerpg.entities.entity.Rotatick;
import naturix.divinerpg.entities.entity.TheEye;
import naturix.divinerpg.entities.entity.TheWatcher;
import naturix.divinerpg.entities.entity.Vamecheron;
import naturix.divinerpg.entities.entity.WildFire;
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
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "wildfire"), WildFire.class, "wildfire", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "dungeon_demon"), DungeonDemon.class, "dungeon_demon", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "rotatick"), Rotatick.class, "rotatick", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "eye"), TheEye.class, "eye", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "ender_triplets"), EnderTriplets.class, "ender_triplets", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "watcher"), TheWatcher.class, "watcher", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "leorna"), Leorna.class, "leorna", id++, DivineRPG.instance, 64, 3, true);


		DivineRPG.logger.info(DivineRPG.modId +" entities have been loaded");
		//Spawn
		EntityRegistry.addSpawn(JungleStegosaurus.class, 250, 1, 10, EnumCreatureType.MONSTER, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.MUTATED_JUNGLE, Biomes.MUTATED_JUNGLE_EDGE);
		EntityRegistry.addSpawn(WildFire.class, 250, 1, 3, EnumCreatureType.MONSTER, Biomes.HELL);
		EntityRegistry.addSpawn(TheEye.class, 250, 1, 3, EnumCreatureType.MONSTER, Biomes.SKY);
		EntityRegistry.addSpawn(EnderTriplets.class, 250, 1, 3, EnumCreatureType.MONSTER, Biomes.SKY);
		
		DivineRPG.logger.info(DivineRPG.modId +" spawns have been loaded");
		
		//loot
		LootTableList.register(JungleStegosaurus.LOOT);
		LootTableList.register(LandShark.LOOT);
		LootTableList.register(WildFire.LOOT);
		LootTableList.register(Rotatick.LOOT);
		LootTableList.register(EnderTriplets.LOOT);
		LootTableList.register(Leorna.LOOT);
		
		DivineRPG.logger.info(DivineRPG.modId +" loot has been loaded");
	}
	public static void initModels() {
		RenderingRegistry.registerEntityRenderingHandler(JungleStegosaurus.class, RenderDramcryx.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(AncientEntity.class, RenderAncientEntity.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(LandShark.class, RenderShark.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(DeathHound.class, RenderDeathHound.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Vamecheron.class, RenderVamecheron.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Dramix.class, RenderDramix.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(WildFire.class, RenderWildFire.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(DungeonDemon.class, RenderDungeonDemon.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Rotatick.class, RenderRotatick.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(TheEye.class, RenderEye.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EnderTriplets.class, RenderEnderTriplets.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(TheWatcher.class, RenderWatcher.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Leorna.class, RenderLeorna.FACTORY);
		
	}
}
