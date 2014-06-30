package net.divinerpg.helper.entity;

import net.divinerpg.dimension.gen.vanilla.DivineDungeonHooks;
import net.divinerpg.entity.arcana.EntityCaptianMerik;
import net.divinerpg.entity.arcana.EntityDatticon;
import net.divinerpg.entity.arcana.EntityLeorna;
import net.divinerpg.entity.arcana.EntityVatticus;
import net.divinerpg.entity.arcana.EntityZelus;
import net.divinerpg.entity.iceika.EntityAlicanto;
import net.divinerpg.entity.iceika.EntityFractite;
import net.divinerpg.entity.iceika.EntityFrostArcher;
import net.divinerpg.entity.iceika.EntityGlacide;
import net.divinerpg.entity.iceika.EntityHastreus;
import net.divinerpg.entity.iceika.EntityRollum;
import net.divinerpg.entity.twilight.EntityAngryBunny;
import net.divinerpg.entity.twilight.EntityApalachiaArcher;
import net.divinerpg.entity.twilight.EntityApalachiaCadillion;
import net.divinerpg.entity.twilight.EntityApalachiaGolem;
import net.divinerpg.entity.twilight.EntityApalachiaTomo;
import net.divinerpg.entity.twilight.EntityApalachiaWarrior;
import net.divinerpg.entity.twilight.EntityBaslisk;
import net.divinerpg.entity.twilight.EntityBunny;
import net.divinerpg.entity.twilight.EntityEdenCadillion;
import net.divinerpg.entity.twilight.EntityEdenCori;
import net.divinerpg.entity.twilight.EntityEdenTomo;
import net.divinerpg.entity.twilight.EntityMadivel;
import net.divinerpg.entity.twilight.EntityMoonWolf;
import net.divinerpg.entity.twilight.EntityMortumCadillion;
import net.divinerpg.entity.twilight.EntityMortumDemon;
import net.divinerpg.entity.twilight.EntityNesro;
import net.divinerpg.entity.twilight.EntitySamek;
import net.divinerpg.entity.twilight.EntitySkythernArcher;
import net.divinerpg.entity.twilight.EntitySkythernCori;
import net.divinerpg.entity.twilight.EntitySkythernFiend;
import net.divinerpg.entity.twilight.EntitySkythernGolem;
import net.divinerpg.entity.twilight.EntitySoulStealer;
import net.divinerpg.entity.twilight.EntityVerek;
import net.divinerpg.entity.twilight.EntityWildWoodGolem;
import net.divinerpg.entity.twilight.EntityWildWoodTomo;
import net.divinerpg.entity.vanilla.EntityAridWarrior;
import net.divinerpg.entity.vanilla.EntityCaveCrawler;
import net.divinerpg.entity.vanilla.EntityCaveclops;
import net.divinerpg.entity.vanilla.EntityCorruptedDramcryx;
import net.divinerpg.entity.vanilla.EntityCrab;
import net.divinerpg.entity.vanilla.EntityCyclops;
import net.divinerpg.entity.vanilla.EntityDesertCrawler;
import net.divinerpg.entity.vanilla.EntityEnderSpider;
import net.divinerpg.entity.vanilla.EntityEnderTriplets;
import net.divinerpg.entity.vanilla.EntityEnderWatcher;
import net.divinerpg.entity.vanilla.EntityFrost;
import net.divinerpg.entity.vanilla.EntityGlacon;
import net.divinerpg.entity.vanilla.EntityHellPig;
import net.divinerpg.entity.vanilla.EntityHellSpider;
import net.divinerpg.entity.vanilla.EntityIceMan;
import net.divinerpg.entity.vanilla.EntityJackOMan;
import net.divinerpg.entity.vanilla.EntityJungleBat;
import net.divinerpg.entity.vanilla.EntityJungleDramcryx;
import net.divinerpg.entity.vanilla.EntityKingCrab;
import net.divinerpg.entity.vanilla.EntityMiner;
import net.divinerpg.entity.vanilla.EntityRainbour;
import net.divinerpg.entity.vanilla.EntityRotatick;
import net.divinerpg.entity.vanilla.EntityScorcher;
import net.divinerpg.entity.vanilla.EntityShark;
import net.divinerpg.entity.vanilla.EntityTheEye;
import net.divinerpg.entity.vanilla.EntityWhale;
import net.divinerpg.entity.vanilla.EntityWildFire;
import net.divinerpg.entity.vethea.EntityAcidHag;
import net.divinerpg.entity.vethea.EntityBiphron;
import net.divinerpg.entity.vethea.EntityBohemite;
import net.divinerpg.entity.vethea.EntityCymesoid;
import net.divinerpg.entity.vethea.EntityDissiment;
import net.divinerpg.entity.vethea.EntityDreamwrecker;
import net.divinerpg.entity.vethea.EntityDuo;
import net.divinerpg.entity.vethea.EntityEhu;
import net.divinerpg.entity.vethea.EntityEndiku;
import net.divinerpg.entity.vethea.EntityGalroid;
import net.divinerpg.entity.vethea.EntityGorgosion;
import net.divinerpg.entity.vethea.EntityHelio;
import net.divinerpg.entity.vethea.EntityHoverStinger;
import net.divinerpg.entity.vethea.EntityHusk;
import net.divinerpg.entity.vethea.EntityKazrotic;
import net.divinerpg.entity.vethea.EntityLheiva;
import net.divinerpg.entity.vethea.EntityLorga;
import net.divinerpg.entity.vethea.EntityLorgaFlight;
import net.divinerpg.entity.vethea.EntityMandragora;
import net.divinerpg.entity.vethea.EntityMysteriousManLayer1;
import net.divinerpg.entity.vethea.EntityMysteriousManLayer2;
import net.divinerpg.entity.vethea.EntityMysteriousManLayer3;
import net.divinerpg.entity.vethea.EntityShadahier;
import net.divinerpg.entity.vethea.EntityStoneGolem;
import net.divinerpg.entity.vethea.EntityTocaxin;
import net.divinerpg.entity.vethea.EntityTwins;
import net.divinerpg.entity.vethea.EntityVermenous;
import net.divinerpg.entity.vethea.EntityVhraak;
import net.divinerpg.entity.vethea.EntityZone;
import net.divinerpg.entity.vethea.EntityZoragon;
import net.divinerpg.helper.DimensionHelper;
import net.divinerpg.helper.utils.LogHelper;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;

public class MobSpawning {

	public static BiomeGenBase[] iceBiomes = new BiomeGenBase[]{BiomeGenBase.taiga, BiomeGenBase.icePlains, BiomeGenBase.iceMountains, BiomeGenBase.taigaHills};
	public static BiomeGenBase[] allBiomes = new BiomeGenBase[]{BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.beach, BiomeGenBase.desert,
		BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.icePlains, BiomeGenBase.iceMountains, BiomeGenBase.river,
		BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.coldBeach, BiomeGenBase.coldTaiga, BiomeGenBase.coldTaigaHills, BiomeGenBase.deepOcean,
		BiomeGenBase.extremeHillsPlus, BiomeGenBase.jungleEdge, BiomeGenBase.megaTaiga, BiomeGenBase.megaTaigaHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F,
		BiomeGenBase.roofedForest, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.stoneBeach};

	public static void addSpawns(){
		LogHelper.info("Adding mob spawns");
		addArcanaSpawns();
		addOverworldSpawns();
		addTwilightSpawns();
		addVetheaSpawns();
		addIceikaSpawns();
		addDungeonSpawns();
	}

	public static void addDungeonSpawns() {
		DivineDungeonHooks.addDungeonMob("Jungle Dramcryx", 100);
		DivineDungeonHooks.addDungeonMob("Crab", 100);
		DivineDungeonHooks.addDungeonMob("Caveclops", 100);
		DivineDungeonHooks.addDungeonMob("Jungle Bat", 100);
	}
	
	public static void addIceikaSpawns(){
		EntityRegistry.addSpawn(EntityAlicanto.class, 2, 1, 10, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Iceika});
        EntityRegistry.addSpawn(EntityFractite.class, 2, 1, 10, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Iceika});
        EntityRegistry.addSpawn(EntityGlacide.class, 2, 1, 10, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Iceika});
        EntityRegistry.addSpawn(EntityHastreus.class, 2, 1, 10, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Iceika});
        EntityRegistry.addSpawn(EntityFrostArcher.class, 2, 1, 10, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Iceika});
        EntityRegistry.addSpawn(EntityRollum.class, 2, 1, 10, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Iceika});
	}

	public static void addArcanaSpawns(){
		EntityRegistry.addSpawn(EntityLeorna.class, 1, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] {DimensionHelper.Arcana});
		EntityRegistry.addSpawn(EntityDatticon.class, 1, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] {DimensionHelper.Arcana});
		EntityRegistry.addSpawn(EntityZelus.class, 1, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] {DimensionHelper.Arcana});
		EntityRegistry.addSpawn(EntityVatticus.class, 1, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] {DimensionHelper.Arcana});
		EntityRegistry.addSpawn(EntityCaptianMerik.class, 1, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] {DimensionHelper.Arcana});
	}

	public static void addTwilightSpawns(){
		EntityRegistry.addSpawn(EntityEdenTomo.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Eden});
		EntityRegistry.addSpawn(EntityEdenCadillion.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Eden});
		EntityRegistry.addSpawn(EntityBunny.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Eden});
		EntityRegistry.addSpawn(EntityEdenCori.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Eden});
		EntityRegistry.addSpawn(EntityNesro.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Eden});
		EntityRegistry.addSpawn(EntityMadivel.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Eden});

		EntityRegistry.addSpawn(EntityEdenCadillion.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.WildWoods});
		EntityRegistry.addSpawn(EntityWildWoodTomo.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.WildWoods});
		EntityRegistry.addSpawn(EntityWildWoodGolem.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.WildWoods});
		EntityRegistry.addSpawn(EntityVerek.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.WildWoods});
		EntityRegistry.addSpawn(EntityMoonWolf.class, 1, 4, 4, EnumCreatureType.creature, new BiomeGenBase[] {DimensionHelper.WildWoods});;

		EntityRegistry.addSpawn(EntityApalachiaCadillion.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Apalachia});
		EntityRegistry.addSpawn(EntityApalachiaGolem.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Apalachia});
		EntityRegistry.addSpawn(EntityApalachiaTomo.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Apalachia});
		EntityRegistry.addSpawn(EntityApalachiaWarrior.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Apalachia});
		EntityRegistry.addSpawn(EntityApalachiaArcher.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Apalachia});

		EntityRegistry.addSpawn(EntitySkythernFiend.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Skythern});
		EntityRegistry.addSpawn(EntitySkythernGolem.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Skythern});
		EntityRegistry.addSpawn(EntitySkythernArcher.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Skythern});
		EntityRegistry.addSpawn(EntitySamek.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Skythern});
		EntityRegistry.addSpawn(EntitySkythernCori.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Skythern});

		EntityRegistry.addSpawn(EntityAngryBunny.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Mortum});
		EntityRegistry.addSpawn(EntityMortumDemon.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Mortum});
		EntityRegistry.addSpawn(EntityBaslisk.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Mortum});
		EntityRegistry.addSpawn(EntitySoulStealer.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Mortum});
		EntityRegistry.addSpawn(EntityMortumCadillion.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Mortum});
		EntityRegistry.addSpawn(EntityApalachiaArcher.class, 1, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Mortum});
	}

	public static void addOverworldSpawns(){
		EntityRegistry.addSpawn(EntityIceMan.class, 10, 1, 1, EnumCreatureType.monster, iceBiomes);
		EntityRegistry.addSpawn(EntityGlacon.class, 10, 1, 1, EnumCreatureType.monster, iceBiomes);
		EntityRegistry.addSpawn(EntityFrost.class, 10, 1, 4, EnumCreatureType.monster, iceBiomes);
		EntityRegistry.addSpawn(EntityHellSpider.class, 50, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.hell});
		//EntityRegistry.addSpawn(EntityHellBat.class, 50, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.hell});
		EntityRegistry.addSpawn(EntityScorcher.class, 7, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.hell});
		//EntityRegistry.addSpawn(EntityJungleSpider.class, 10, 1, 4, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.jungle, BiomeGenBase.jungleHills});
		EntityRegistry.addSpawn(EntityCyclops.class, 1, 1, 1, EnumCreatureType.monster, allBiomes);
		EntityRegistry.addSpawn(EntityMiner.class, 1, 1, 1, EnumCreatureType.monster, allBiomes);
		EntityRegistry.addSpawn(EntityJackOMan.class, 1, 1, 1, EnumCreatureType.creature, allBiomes);
		EntityRegistry.addSpawn(EntityHellPig.class, 25, 5, 50, EnumCreatureType.creature, new BiomeGenBase[] {BiomeGenBase.hell});
		EntityRegistry.addSpawn(EntityEnderWatcher.class, 10, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.sky});
		EntityRegistry.addSpawn(EntityCrab.class, 15, 4, 4, EnumCreatureType.creature, new BiomeGenBase[] {BiomeGenBase.beach});
		EntityRegistry.addSpawn(EntityKingCrab.class, 5, 4, 4, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.beach});
		EntityRegistry.addSpawn(EntityWhale.class, 50, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean});
		EntityRegistry.addSpawn(EntityShark.class, 50, 1, 1, EnumCreatureType.waterCreature, new BiomeGenBase[] {BiomeGenBase.ocean});
		EntityRegistry.addSpawn(EntityCaveCrawler.class, 20, 2, 3, EnumCreatureType.monster, allBiomes);
		EntityRegistry.addSpawn(EntityDesertCrawler.class, 3, 1, 4, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.desertHills});
		EntityRegistry.addSpawn(EntityAridWarrior.class, 3, 1, 4, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.desertHills});
		EntityRegistry.addSpawn(EntityRotatick.class, 20, 3, 4, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.icePlains, BiomeGenBase.iceMountains, BiomeGenBase.river});
		EntityRegistry.addSpawn(EntityJungleDramcryx.class, 20, 1, 4, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.jungle, BiomeGenBase.jungleHills});
		EntityRegistry.addSpawn(EntityCorruptedDramcryx.class, 20, 3, 4, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.plains, BiomeGenBase.extremeHills, BiomeGenBase.beach, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.forest, BiomeGenBase.forestHills, BiomeGenBase.icePlains, BiomeGenBase.iceMountains, BiomeGenBase.river});
		EntityRegistry.addSpawn(EntityTheEye.class, 7, 1, 4, EnumCreatureType.monster, allBiomes);
		EntityRegistry.addSpawn(EntityEnderTriplets.class, 1, 1, 4, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.sky});
		EntityRegistry.addSpawn(EntityJungleBat.class, 20, 1, 4, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.jungle, BiomeGenBase.jungleHills});
		EntityRegistry.addSpawn(EntityCaveclops.class, 20, 1, 4, EnumCreatureType.monster, allBiomes);
		EntityRegistry.addSpawn(EntityEnderSpider.class, 2, 1, 4, EnumCreatureType.monster, allBiomes);
		EntityRegistry.addSpawn(EntityRainbour.class, 2, 1, 1, EnumCreatureType.creature, allBiomes);
		EntityRegistry.addSpawn(EntityWildFire.class, 50, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {BiomeGenBase.hell});
	}

	public static void addVetheaSpawns(){
		EntityRegistry.addSpawn(EntityVermenous.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});
		EntityRegistry.addSpawn(EntityCymesoid.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityDreamwrecker.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityDuo.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityTwins.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityBohemite.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityTocaxin.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityMandragora.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityShadahier.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityLheiva.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityHoverStinger.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityAcidHag.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityKazrotic.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityVhraak.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityEndiku.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityHelio.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityBiphron.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityZoragon.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityGorgosion.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityDissiment.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityZone.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityLorga.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityLorgaFlight.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});	
		EntityRegistry.addSpawn(EntityGalroid.class, 1, 1, 1, EnumCreatureType.monster, new BiomeGenBase[] {DimensionHelper.Vethea});
		EntityRegistry.addSpawn(EntityMysteriousManLayer1.class, 1, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] {DimensionHelper.Vethea});
		EntityRegistry.addSpawn(EntityMysteriousManLayer2.class, 1, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] {DimensionHelper.Vethea});
		EntityRegistry.addSpawn(EntityMysteriousManLayer3.class, 1, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] {DimensionHelper.Vethea});
		EntityRegistry.addSpawn(EntityEhu.class, 1, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] {DimensionHelper.Vethea});
		EntityRegistry.addSpawn(EntityHusk.class, 1, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] {DimensionHelper.Vethea});
		EntityRegistry.addSpawn(EntityStoneGolem.class, 1, 1, 1, EnumCreatureType.creature, new BiomeGenBase[] {DimensionHelper.Vethea});
	}
}