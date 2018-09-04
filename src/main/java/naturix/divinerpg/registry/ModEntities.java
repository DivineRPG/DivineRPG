package naturix.divinerpg.registry;

import naturix.divinerpg.Config;
import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.entities.assets.model.iceika.model.RenderWorkshopTinkerer;
import naturix.divinerpg.entities.assets.render.RenderAcidHag;
import naturix.divinerpg.entities.assets.render.RenderAncientEntity;
import naturix.divinerpg.entities.assets.render.RenderEnderTriplets;
import naturix.divinerpg.entities.assets.render.RenderEye;
import naturix.divinerpg.entities.assets.render.RenderProjectile;
import naturix.divinerpg.entities.assets.render.RenderRotatick;
import naturix.divinerpg.entities.assets.render.RenderShark;
import naturix.divinerpg.entities.assets.render.RenderVamacheron;
import naturix.divinerpg.entities.assets.render.RenderWatcher;
import naturix.divinerpg.entities.assets.render.RenderWildFire;
import naturix.divinerpg.entities.assets.render.arcana.RenderDeathHound;
import naturix.divinerpg.entities.assets.render.arcana.RenderDeathcryx;
import naturix.divinerpg.entities.assets.render.arcana.RenderDramcryx;
import naturix.divinerpg.entities.assets.render.arcana.RenderDramix;
import naturix.divinerpg.entities.assets.render.arcana.RenderDungeonDemon;
import naturix.divinerpg.entities.assets.render.arcana.RenderLeorna;
import naturix.divinerpg.entities.assets.render.arcana.RenderParasecta;
import naturix.divinerpg.entities.assets.render.arcana.RenderParatiku;
import naturix.divinerpg.entities.assets.render.arcana.RenderRazorback;
import naturix.divinerpg.entities.assets.render.arcana.RenderRejuvGolem;
import naturix.divinerpg.entities.assets.render.arcana.RenderRoamer;
import naturix.divinerpg.entities.assets.render.arcana.RenderSeimer;
import naturix.divinerpg.entities.assets.render.arcana.RenderWraith;
import naturix.divinerpg.entities.assets.render.iceika.RenderAlicanto;
import naturix.divinerpg.entities.assets.render.iceika.RenderFractite;
import naturix.divinerpg.entities.assets.render.iceika.RenderFrosty;
import naturix.divinerpg.entities.assets.render.iceika.RenderGlacide;
import naturix.divinerpg.entities.assets.render.iceika.RenderHastreus;
import naturix.divinerpg.entities.assets.render.iceika.RenderRollum;
import naturix.divinerpg.entities.assets.render.iceika.RenderWorkshopMerchant;
import naturix.divinerpg.entities.entity.AcidHag;
import naturix.divinerpg.entities.entity.AncientEntity;
import naturix.divinerpg.entities.entity.EnderTriplets;
import naturix.divinerpg.entities.entity.EntityTeakerDisc;
import naturix.divinerpg.entities.entity.LandShark;
import naturix.divinerpg.entities.entity.Rotatick;
import naturix.divinerpg.entities.entity.TheEye;
import naturix.divinerpg.entities.entity.TheWatcher;
import naturix.divinerpg.entities.entity.Vamecheron;
import naturix.divinerpg.entities.entity.WildFire;
import naturix.divinerpg.entities.entity.arcana.DeathHound;
import naturix.divinerpg.entities.entity.arcana.Deathcryx;
import naturix.divinerpg.entities.entity.arcana.Dramix;
import naturix.divinerpg.entities.entity.arcana.DungeonDemon;
import naturix.divinerpg.entities.entity.arcana.JungleStegosaurus;
import naturix.divinerpg.entities.entity.arcana.Leorna;
import naturix.divinerpg.entities.entity.arcana.Parasecta;
import naturix.divinerpg.entities.entity.arcana.Paratiku;
import naturix.divinerpg.entities.entity.arcana.Razorback;
import naturix.divinerpg.entities.entity.arcana.RejuvGolem;
import naturix.divinerpg.entities.entity.arcana.Roamer;
import naturix.divinerpg.entities.entity.arcana.Seimer;
import naturix.divinerpg.entities.entity.arcana.Wraith;
import naturix.divinerpg.entities.entity.iceika.Alicanto;
import naturix.divinerpg.entities.entity.iceika.Fractite;
import naturix.divinerpg.entities.entity.iceika.Frosty;
import naturix.divinerpg.entities.entity.iceika.Glacide;
import naturix.divinerpg.entities.entity.iceika.Hastreus;
import naturix.divinerpg.entities.entity.iceika.Rollum;
import naturix.divinerpg.entities.entity.iceika.WorkshopMerchant;
import naturix.divinerpg.entities.entity.iceika.WorkshopTinkerer;
import naturix.divinerpg.entities.entity.projectiles.InfernoArrow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
public class ModEntities {

	public static void init() {
		//register basic mobs
		int id = 1;
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "teaker_disc"), EntityTeakerDisc.class, "teaker_disc", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "arrow_inferno"), InfernoArrow.class, "arrow_inferno", id++, DivineRPG.instance, 64, 3, true);
		
		id = 100;
		//register advanced mobs
		//arcana
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "deathcryx"), Deathcryx.class, "deathcryx", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "death_hound"), DeathHound.class, "death_hound", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "dramix_boss"), Dramix.class, "dramix_boss", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "dramcryx_jungle"), JungleStegosaurus.class, "dramcryx_jungle", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "dungeon_demon"), DungeonDemon.class, "dungeon_demon", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "leorna"), Leorna.class, "leorna", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "parasecta"), Parasecta.class, "parasecta", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "paratiku"), Paratiku.class, "paratiku", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "razorback"), Razorback.class, "razorback", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "golem_rejuv"), RejuvGolem.class, "golem_rejuv", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "roamer"), Roamer.class, "roamer", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "seimer"), Seimer.class, "seimer", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "wraith"), Wraith.class, "wraith", id++, DivineRPG.instance, 64, 3, true);
		
		//iceika
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "alicanto"), Alicanto.class, "allicanto", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "fractite"), Fractite.class, "fractite", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "frosty"), Frosty.class, "frosty", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "glacide"), Glacide.class, "glacide", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "hastreus"), Hastreus.class, "hastreus", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "rollum"), Rollum.class, "rollum", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "workshop_merchant"), WorkshopMerchant.class, "workshop_merchant", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "workshop_tinkerer"), WorkshopTinkerer.class, "workshop_tinkerer", id++, DivineRPG.instance, 64, 3, true);
		
		//twilight
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "vamacheron_boss"), Vamecheron.class, "vamacheron_boss", id++, DivineRPG.instance, 64, 3, true);
		
		//vanilla
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "ancient_entity"), AncientEntity.class, "ancient_entity", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "shark"), LandShark.class, "shark", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "wildfire"), WildFire.class, "wildfire", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "rotatick"), Rotatick.class, "rotatick", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "eye"), TheEye.class, "eye", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "ender_triplets"), EnderTriplets.class, "ender_triplets", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "watcher"), TheWatcher.class, "watcher", id++, DivineRPG.instance, 64, 3, true);
		
		//vethia
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "acid_hag"), AcidHag.class, "acid_hag", id++, DivineRPG.instance, 64, 3, true);


		DivineRPG.logger.info(DivineRPG.modId +" entities have been loaded");
		
		//Spawn
		EntityRegistry.addSpawn(JungleStegosaurus.class, 50 * Config.mobSpawnMultiplier, 1, 10, EnumCreatureType.MONSTER, Biomes.JUNGLE, Biomes.JUNGLE_EDGE, Biomes.JUNGLE_HILLS, Biomes.MUTATED_JUNGLE, Biomes.MUTATED_JUNGLE_EDGE);
		EntityRegistry.addSpawn(WildFire.class, 50 * Config.mobSpawnMultiplier, 1, 3, EnumCreatureType.MONSTER, Biomes.HELL);
		EntityRegistry.addSpawn(TheEye.class, 50 * Config.mobSpawnMultiplier, 1, 3, EnumCreatureType.MONSTER, Biomes.SKY);
		EntityRegistry.addSpawn(EnderTriplets.class, 50 * Config.mobSpawnMultiplier, 1, 3, EnumCreatureType.MONSTER, Biomes.SKY);
		
		DivineRPG.logger.info(DivineRPG.modId +" spawns have been loaded");
		
		//loot
		LootTableList.register(JungleStegosaurus.LOOT);
		LootTableList.register(LandShark.LOOT);
		LootTableList.register(WildFire.LOOT);
		LootTableList.register(Rotatick.LOOT);
		LootTableList.register(EnderTriplets.LOOT);
		LootTableList.register(Leorna.LOOT);
		LootTableList.register(Parasecta.LOOT);
		LootTableList.register(Paratiku.LOOT);
		LootTableList.register(AcidHag.LOOT);
		LootTableList.register(Razorback.LOOT);
		LootTableList.register(RejuvGolem.LOOT);
		LootTableList.register(Roamer.LOOT);
		LootTableList.register(Seimer.LOOT);
		LootTableList.register(Wraith.LOOT);
		LootTableList.register(Alicanto.LOOT);
		LootTableList.register(Fractite.LOOT);
		LootTableList.register(Frosty.LOOT);
		LootTableList.register(Glacide.LOOT);
		LootTableList.register(Hastreus.LOOT);
		LootTableList.register(Rollum.LOOT);
		LootTableList.register(WorkshopTinkerer.LOOT);
		
		
		DivineRPG.logger.info(DivineRPG.modId +" loot has been loaded");
	}
	public static void initModels() {
		//arcana 
		RenderingRegistry.registerEntityRenderingHandler(Deathcryx.class, RenderDeathcryx.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(DeathHound.class, RenderDeathHound.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(DungeonDemon.class, RenderDungeonDemon.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Dramix.class, RenderDramix.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Razorback.class, RenderRazorback.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(RejuvGolem.class, RenderRejuvGolem.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Roamer.class, RenderRoamer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Seimer.class, RenderSeimer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Wraith.class, RenderWraith.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Leorna.class, RenderLeorna.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Parasecta.class, RenderParasecta.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Paratiku.class, RenderParatiku.FACTORY);
		
		//iceika
		RenderingRegistry.registerEntityRenderingHandler(Alicanto.class, RenderAlicanto.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Fractite.class, RenderFractite.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Frosty.class, RenderFrosty.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Glacide.class, RenderGlacide.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Hastreus.class, RenderHastreus.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Rollum.class, RenderRollum.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(WorkshopTinkerer.class, RenderWorkshopTinkerer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(WorkshopMerchant.class, RenderWorkshopMerchant.FACTORY);
		
		//twilight
		RenderingRegistry.registerEntityRenderingHandler(Vamecheron.class, RenderVamacheron.FACTORY);
		
		//vanilla
		RenderingRegistry.registerEntityRenderingHandler(JungleStegosaurus.class, RenderDramcryx.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(AncientEntity.class, RenderAncientEntity.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(LandShark.class, RenderShark.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(WildFire.class, RenderWildFire.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Rotatick.class, RenderRotatick.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(TheEye.class, RenderEye.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EnderTriplets.class, RenderEnderTriplets.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(TheWatcher.class, RenderWatcher.FACTORY);
		
		//vethia
		RenderingRegistry.registerEntityRenderingHandler(AcidHag.class, RenderAcidHag.FACTORY);
		
		//other
		RenderingRegistry.registerEntityRenderingHandler(EntityTeakerDisc.class, new RenderProjectile(new ResourceLocation("divinerpg:textures/items/amthirmisdisk.png"), 1));
		RenderingRegistry.registerEntityRenderingHandler(InfernoArrow.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(),new ItemStack(ModItems.arrowInferno).getItem(), Minecraft.getMinecraft().getRenderItem()));
		
	}
}
