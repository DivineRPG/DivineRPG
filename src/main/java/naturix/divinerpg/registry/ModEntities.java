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
import naturix.divinerpg.entities.assets.render.RenderWatcher;
import naturix.divinerpg.entities.assets.render.RenderWildFire;
import naturix.divinerpg.entities.assets.render.arcana.*;
import naturix.divinerpg.entities.assets.render.iceika.*;
import naturix.divinerpg.entities.assets.render.twilight.*;
import naturix.divinerpg.entities.entity.AcidHag;
import naturix.divinerpg.entities.entity.AncientEntity;
import naturix.divinerpg.entities.entity.EnderTriplets;
import naturix.divinerpg.entities.entity.EntityTeakerDisc;
import naturix.divinerpg.entities.entity.LandShark;
import naturix.divinerpg.entities.entity.Rotatick;
import naturix.divinerpg.entities.entity.TheEye;
import naturix.divinerpg.entities.entity.TheWatcher;
import naturix.divinerpg.entities.entity.WildFire;
import naturix.divinerpg.entities.entity.arcana.*;
import naturix.divinerpg.entities.entity.iceika.*;
import naturix.divinerpg.entities.entity.projectiles.InfernoArrow;
import naturix.divinerpg.entities.entity.twilight.*;
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
		
		
		//register advanced mobs
		id = 100;
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
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "seimer"), Seimer.class, "seimer", id++, DivineRPG.instance, 64, 3, true, 0x00000, 0xff0000);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "wraith"), Wraith.class, "wraith", id++, DivineRPG.instance, 64, 3, true);
		id = 200;
		//iceika
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "alicanto"), Alicanto.class, "allicanto", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "fractite"), Fractite.class, "fractite", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "frosty"), Frosty.class, "frosty", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "glacide"), Glacide.class, "glacide", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "hastreus"), Hastreus.class, "hastreus", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "rollum"), Rollum.class, "rollum", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "workshop_merchant"), WorkshopMerchant.class, "workshop_merchant", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "workshop_tinkerer"), WorkshopTinkerer.class, "workshop_tinkerer", id++, DivineRPG.instance, 64, 3, true);
		id = 300;
		//twilight
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "bunny_angry"), AngryBunny.class, "bunny_angry", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "basalisk"), Basalisk.class, "basalisk", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "behemoth"), Bohemoth.class, "behemoth", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "bunny"), Bunny.class, "bunny", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "cadillion"), Cadillion.class, "cadillion", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "cori"), Cori.class, "cori", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "demon_dense"), DenseDemon.class, "demon_dense", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "densos"), Densos.class, "densos", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "archer_enchanted"), EnchantedArcher.class, "archer_enchanted", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "warrior_enchanted"), EnchantedWarrior.class, "warrior_enchanted", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "epiphite"), Epiphite.class, "epiphite", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "archer_eternal"), EternalArcher.class, "archer_eternal", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "greenfeet"), Greenfeet.class, "greenfeet", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "karot"), Karot.class, "karot", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "madivel"), Madivel.class, "madivel", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "mage"), Mage.class, "mage", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "megalith"), Megalith.class, "megalith", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "wolf_moon"), MoonWolf.class, "wolf_moon", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "mystic"), Mystic.class, "mystic", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "samek"), Samek.class, "samek", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "fiend_skythern"), SkythernFiend.class, "fiend_skythern", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "sorcerer"), Sorcerer.class, "sorcerer", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "fiend_soul"), SoulFiend.class, "fiend_soul", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "spider_soul"), SoulSpider.class, "spider_soul", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "stealer_soul"), SoulStealer.class, "stealer_soul", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "archer_sun"), SunArcher.class, "archer_sun", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "tomo"), Tomo.class, "tomo", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "archer_twilight"), TwilightArcher.class, "archer_twilight", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "demon_twilight"), TwilightDemon.class, "demon_twilight", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "golem_twilight"), TwilightGolem.class, "golem_twilight", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "vamacheron_boss"), Vamecheron.class, "vamacheron_boss", id++, DivineRPG.instance, 64, 3, true);
		id = 400;
		//vanilla
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "ancient_entity"), AncientEntity.class, "ancient_entity", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "shark"), LandShark.class, "shark", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "wildfire"), WildFire.class, "wildfire", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "rotatick"), Rotatick.class, "rotatick", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "eye"), TheEye.class, "eye", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "ender_triplets"), EnderTriplets.class, "ender_triplets", id++, DivineRPG.instance, 64, 3, true);
		EntityRegistry.registerModEntity(new ResourceLocation(DivineRPG.modId, "watcher"), TheWatcher.class, "watcher", id++, DivineRPG.instance, 64, 3, true);
		id = 500;
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
		LootTableList.register(AngryBunny.LOOT);
		LootTableList.register(Basalisk.LOOT);
		LootTableList.register(Bohemoth.LOOT);
		LootTableList.register(Bunny.LOOT);
		LootTableList.register(Cadillion.LOOT);
		LootTableList.register(Cori.LOOT);
		LootTableList.register(DenseDemon.LOOT);
		LootTableList.register(Densos.LOOT);
		LootTableList.register(EnchantedArcher.LOOT);
		LootTableList.register(EnchantedWarrior.LOOT);
		LootTableList.register(Epiphite.LOOT);
		LootTableList.register(EternalArcher.LOOT);
		LootTableList.register(Greenfeet.LOOT);
		LootTableList.register(Karot.LOOT);
		LootTableList.register(Madivel.LOOT);
		LootTableList.register(Mage.LOOT);
		LootTableList.register(Megalith.LOOT);
		LootTableList.register(MoonWolf.LOOT);
		LootTableList.register(Mystic.LOOT);
		LootTableList.register(Samek.LOOT);
		LootTableList.register(SkythernFiend.LOOT);
		LootTableList.register(Sorcerer.LOOT);
		LootTableList.register(SoulFiend.LOOT);
		LootTableList.register(SoulSpider.LOOT);
		LootTableList.register(SoulStealer.LOOT);
		LootTableList.register(SunArcher.LOOT);
		LootTableList.register(Tomo.LOOT);
		LootTableList.register(TwilightArcher.LOOT);
		LootTableList.register(TwilightDemon.LOOT);
		LootTableList.register(TwilightGolem.LOOT);
		
		
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
		RenderingRegistry.registerEntityRenderingHandler(AngryBunny.class, RenderAngryBunny.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Basalisk.class, RenderBasalisk.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Bohemoth.class, RenderBehemoth.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Bunny.class, RenderBunny.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Cadillion.class, RenderCadillion.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Cori.class, RenderCori.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(DenseDemon.class, RenderDenseDemon.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Densos.class, RenderDensos.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EnchantedArcher.class, RenderEnchantedArcher.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EnchantedWarrior.class, RenderEnchantedWarrior.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Epiphite.class, RenderEpiphite.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EternalArcher.class, RenderEternalArcher.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Greenfeet.class, RenderGreenfeet.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Karot.class, RenderKarot.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Madivel.class, RenderMadivel.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Mage.class, RenderMage.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Megalith.class, RenderMegalith.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(MoonWolf.class, RenderMoonWolf.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Mystic.class, RenderMystic.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Samek.class, RenderSamek.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(SkythernFiend.class, RenderSkythernFiend.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Sorcerer.class, RenderSorcerer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(SoulFiend.class, RenderSoulFiend.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(SoulSpider.class, RenderSoulSpider.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(SoulStealer.class, RenderSoulStealer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(SunArcher.class, RenderSunArcher.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(Tomo.class, RenderTomo.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(TwilightArcher.class, RenderTwilightArcher.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(TwilightDemon.class, RenderTwilightDemon.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(TwilightGolem.class, RenderTwilightGolem.FACTORY);
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
