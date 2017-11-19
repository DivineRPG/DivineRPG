package net.divinerpg.utils.entities;

import java.util.List;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.common.registry.EntityRegistry;
import net.divinerpg.entities.arcana.EntityCaptianMerik;
import net.divinerpg.entities.arcana.EntityDatticon;
import net.divinerpg.entities.arcana.EntityLeorna;
import net.divinerpg.entities.arcana.EntityVatticus;
import net.divinerpg.entities.arcana.EntityWarGeneral;
import net.divinerpg.entities.arcana.EntityZelus;
import net.divinerpg.entities.iceika.EntityAlicanto;
import net.divinerpg.entities.iceika.EntityFractite;
import net.divinerpg.entities.iceika.EntityFrostArcher;
import net.divinerpg.entities.iceika.EntityFrosty;
import net.divinerpg.entities.iceika.EntityGlacide;
import net.divinerpg.entities.iceika.EntityHastreus;
import net.divinerpg.entities.iceika.EntityRollum;
import net.divinerpg.entities.twilight.EntityApalachiaArcher;
import net.divinerpg.entities.twilight.EntityApalachiaCadillion;
import net.divinerpg.entities.twilight.EntityApalachiaGolem;
import net.divinerpg.entities.twilight.EntityApalachiaTomo;
import net.divinerpg.entities.twilight.EntityApalachiaWarrior;
import net.divinerpg.entities.twilight.EntityBaslisk;
import net.divinerpg.entities.twilight.EntityBehemoth;
import net.divinerpg.entities.twilight.EntityBunny;
import net.divinerpg.entities.twilight.EntityEdenCadillion;
import net.divinerpg.entities.twilight.EntityEdenCori;
import net.divinerpg.entities.twilight.EntityEdenTomo;
import net.divinerpg.entities.twilight.EntityEpiphite;
import net.divinerpg.entities.twilight.EntityGreenfeet;
import net.divinerpg.entities.twilight.EntityMadivel;
import net.divinerpg.entities.twilight.EntityMage;
import net.divinerpg.entities.twilight.EntityMegalith;
import net.divinerpg.entities.twilight.EntityMoonWolf;
import net.divinerpg.entities.twilight.EntityMortumCadillion;
import net.divinerpg.entities.twilight.EntityMortumDemon;
import net.divinerpg.entities.twilight.EntityMystic;
import net.divinerpg.entities.twilight.EntitySamek;
import net.divinerpg.entities.twilight.EntitySkythernArcher;
import net.divinerpg.entities.twilight.EntitySkythernCori;
import net.divinerpg.entities.twilight.EntitySkythernFiend;
import net.divinerpg.entities.twilight.EntitySkythernGolem;
import net.divinerpg.entities.twilight.EntitySorcerer;
import net.divinerpg.entities.twilight.EntitySoulStealer;
import net.divinerpg.entities.twilight.EntitySpellbinder;
import net.divinerpg.entities.twilight.EntitySunArcher;
import net.divinerpg.entities.twilight.EntityTwilightArcher;
import net.divinerpg.entities.twilight.EntityVerek;
import net.divinerpg.entities.twilight.EntityWildwoodCadillion;
import net.divinerpg.entities.twilight.EntityWildwoodGolem;
import net.divinerpg.entities.twilight.EntityWildwoodTomo;
import net.divinerpg.entities.vanilla.EntityAridWarrior;
import net.divinerpg.entities.vanilla.EntityCaveCrawler;
import net.divinerpg.entities.vanilla.EntityCaveclops;
import net.divinerpg.entities.vanilla.EntityCrab;
import net.divinerpg.entities.vanilla.EntityCyclops;
import net.divinerpg.entities.vanilla.EntityDesertCrawler;
import net.divinerpg.entities.vanilla.EntityEnderSpider;
import net.divinerpg.entities.vanilla.EntityEnderTriplets;
import net.divinerpg.entities.vanilla.EntityEnderWatcher;
import net.divinerpg.entities.vanilla.EntityEnthralledDramcryx;
import net.divinerpg.entities.vanilla.EntityFrost;
import net.divinerpg.entities.vanilla.EntityGlacon;
import net.divinerpg.entities.vanilla.EntityHellPig;
import net.divinerpg.entities.vanilla.EntityHellSpider;
import net.divinerpg.entities.vanilla.EntityJackOMan;
import net.divinerpg.entities.vanilla.EntityJungleBat;
import net.divinerpg.entities.vanilla.EntityJungleDramcryx;
import net.divinerpg.entities.vanilla.EntityJungleSpider;
import net.divinerpg.entities.vanilla.EntityKingCrab;
import net.divinerpg.entities.vanilla.EntityKobblin;
import net.divinerpg.entities.vanilla.EntityLiopleurodon;
import net.divinerpg.entities.vanilla.EntityMiner;
import net.divinerpg.entities.vanilla.EntityPumpkinSpider;
import net.divinerpg.entities.vanilla.EntityRainbour;
import net.divinerpg.entities.vanilla.EntityRotatick;
import net.divinerpg.entities.vanilla.EntitySaguaroWorm;
import net.divinerpg.entities.vanilla.EntityScorcher;
import net.divinerpg.entities.vanilla.EntityShark;
import net.divinerpg.entities.vanilla.EntityTheEye;
import net.divinerpg.entities.vanilla.EntityTheGrue;
import net.divinerpg.entities.vanilla.EntityWhale;
import net.divinerpg.entities.vanilla.EntityWildfire;
import net.divinerpg.entities.vethea.EntityAcidHag;
import net.divinerpg.entities.vethea.EntityBiphron;
import net.divinerpg.entities.vethea.EntityBohemite;
import net.divinerpg.entities.vethea.EntityCymesoid;
import net.divinerpg.entities.vethea.EntityDissiment;
import net.divinerpg.entities.vethea.EntityDreamwrecker;
import net.divinerpg.entities.vethea.EntityDuo;
import net.divinerpg.entities.vethea.EntityGalroid;
import net.divinerpg.entities.vethea.EntityGorgosion;
import net.divinerpg.entities.vethea.EntityHelio;
import net.divinerpg.entities.vethea.EntityHoverStinger;
import net.divinerpg.entities.vethea.EntityKazrotic;
import net.divinerpg.entities.vethea.EntityLheiva;
import net.divinerpg.entities.vethea.EntityLorga;
import net.divinerpg.entities.vethea.EntityLorgaFlight;
import net.divinerpg.entities.vethea.EntityMandragora;
import net.divinerpg.entities.vethea.EntityMysteriousManLayer1;
import net.divinerpg.entities.vethea.EntityMysteriousManLayer2;
import net.divinerpg.entities.vethea.EntityMysteriousManLayer3;
import net.divinerpg.entities.vethea.EntityShadahier;
import net.divinerpg.entities.vethea.EntityTocaxin;
import net.divinerpg.entities.vethea.EntityTwins;
import net.divinerpg.entities.vethea.EntityVermenous;
import net.divinerpg.entities.vethea.EntityVhraak;
import net.divinerpg.entities.vethea.EntityZone;
import net.divinerpg.entities.vethea.EntityZoragon;
import net.divinerpg.utils.DimensionHelper;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class MobSpawning {
	public static void addSpawns(){
		addArcanaSpawns();
		addOverworldSpawns();
		addTwilightSpawns();
		addVetheaSpawns();
		addIceikaSpawns();
	}
	
	public static void addIceikaSpawns() {
		BiomeGenBase[] iceikaBiome = new BiomeGenBase[] {DimensionHelper.iceikaBiome};

		EntityRegistry.addSpawn(EntityAlicanto.class, 2, 1, 10, EnumCreatureType.monster,  iceikaBiome);
        EntityRegistry.addSpawn(EntityFractite.class, 2, 1, 10, EnumCreatureType.monster,  iceikaBiome);
        EntityRegistry.addSpawn(EntityGlacide.class, 2, 1, 10, EnumCreatureType.monster, iceikaBiome);
        EntityRegistry.addSpawn(EntityHastreus.class, 2, 1, 10, EnumCreatureType.monster, iceikaBiome);
        EntityRegistry.addSpawn(EntityFrostArcher.class, 2, 1, 10, EnumCreatureType.monster, iceikaBiome);
        EntityRegistry.addSpawn(EntityFrosty.class, 2, 1, 10, EnumCreatureType.monster, iceikaBiome);
        EntityRegistry.addSpawn(EntityRollum.class, 2, 1, 10, EnumCreatureType.monster, iceikaBiome);
	}

	public static void addArcanaSpawns() {
		BiomeGenBase[] arcanaBiome = new BiomeGenBase[] {DimensionHelper.arcanaBiome};

		EntityRegistry.addSpawn(EntityLeorna.class, 1, 1, 1, EnumCreatureType.creature, arcanaBiome);
		EntityRegistry.addSpawn(EntityDatticon.class, 1, 1, 1, EnumCreatureType.creature, arcanaBiome);
		EntityRegistry.addSpawn(EntityZelus.class, 1, 1, 1, EnumCreatureType.creature, arcanaBiome);
		EntityRegistry.addSpawn(EntityVatticus.class, 1, 1, 1, EnumCreatureType.creature, arcanaBiome);
		EntityRegistry.addSpawn(EntityCaptianMerik.class, 1, 1, 1, EnumCreatureType.creature, arcanaBiome);
		EntityRegistry.addSpawn(EntityWarGeneral.class, 1, 1, 1, EnumCreatureType.creature, arcanaBiome);
	}

	public static void addTwilightSpawns() {
		BiomeGenBase[] edenBiome = new BiomeGenBase[] {DimensionHelper.edenBiome};
		BiomeGenBase[] wildwoodBiome = new BiomeGenBase[] {DimensionHelper.wildwoodBiome};
		BiomeGenBase[] apalachiaBiome = new BiomeGenBase[] {DimensionHelper.apalachiaBiome};
		BiomeGenBase[] skythernBiome = new BiomeGenBase[] {DimensionHelper.skythernBiome};
		BiomeGenBase[] mortumBiome = new BiomeGenBase[] {DimensionHelper.mortumBiome};

		EntityRegistry.addSpawn(EntityEdenTomo.class, 20, 4, 4, EnumCreatureType.monster, edenBiome);
		EntityRegistry.addSpawn(EntityEdenCadillion.class, 20, 4, 4, EnumCreatureType.monster, edenBiome);
		EntityRegistry.addSpawn(EntityBunny.class, 20, 4, 4, EnumCreatureType.monster, edenBiome);
		EntityRegistry.addSpawn(EntityEdenTomo.class, 20, 4, 4, EnumCreatureType.creature, edenBiome);
		EntityRegistry.addSpawn(EntityEdenCadillion.class, 20, 4, 4, EnumCreatureType.creature, edenBiome);
		EntityRegistry.addSpawn(EntityBunny.class, 20, 4, 4, EnumCreatureType.creature, edenBiome);
		EntityRegistry.addSpawn(EntityEdenCori.class, 1, 4, 4, EnumCreatureType.creature, edenBiome);
		EntityRegistry.addSpawn(EntityEdenCori.class, 1, 4, 4, EnumCreatureType.monster, edenBiome);
		EntityRegistry.addSpawn(EntityGreenfeet.class, 20, 4, 4, EnumCreatureType.monster, edenBiome);
		EntityRegistry.addSpawn(EntityMadivel.class, 20, 4, 4, EnumCreatureType.monster, edenBiome);
		EntityRegistry.addSpawn(EntitySunArcher.class, 6, 4, 4, EnumCreatureType.creature, edenBiome);
		EntityRegistry.addSpawn(EntitySunArcher.class, 6, 4, 4, EnumCreatureType.monster, edenBiome);

		EntityRegistry.addSpawn(EntityWildwoodCadillion.class, 4, 4, 4, EnumCreatureType.monster, wildwoodBiome);
		EntityRegistry.addSpawn(EntityWildwoodTomo.class, 4, 4, 4, EnumCreatureType.monster, wildwoodBiome);
		EntityRegistry.addSpawn(EntityWildwoodCadillion.class, 4, 4, 4, EnumCreatureType.creature, wildwoodBiome);
		EntityRegistry.addSpawn(EntityWildwoodTomo.class, 4, 4, 4, EnumCreatureType.creature, wildwoodBiome);
		EntityRegistry.addSpawn(EntityEpiphite.class, 1, 2, 2, EnumCreatureType.monster, wildwoodBiome);
		EntityRegistry.addSpawn(EntityEpiphite.class, 1, 2, 2, EnumCreatureType.creature, wildwoodBiome);
        EntityRegistry.addSpawn(EntityBehemoth.class, 1, 1, 1, EnumCreatureType.monster, wildwoodBiome);
        EntityRegistry.addSpawn(EntityBehemoth.class, 1, 1, 1, EnumCreatureType.creature, wildwoodBiome);
        EntityRegistry.addSpawn(EntityWildwoodGolem.class, 3, 4, 4, EnumCreatureType.monster, wildwoodBiome);
		EntityRegistry.addSpawn(EntityVerek.class, 4, 4, 4, EnumCreatureType.monster, wildwoodBiome);
		EntityRegistry.addSpawn(EntityMage.class, 2, 4, 4, EnumCreatureType.monster, wildwoodBiome);
		EntityRegistry.addSpawn(EntityMoonWolf.class, 4, 4, 4, EnumCreatureType.creature, wildwoodBiome);

		EntityRegistry.addSpawn(EntityApalachiaCadillion.class, 2, 4, 4, EnumCreatureType.monster, apalachiaBiome);
		EntityRegistry.addSpawn(EntityApalachiaGolem.class, 2, 4, 4, EnumCreatureType.monster, apalachiaBiome);
		EntityRegistry.addSpawn(EntityApalachiaTomo.class, 2, 4, 4, EnumCreatureType.monster, apalachiaBiome);
		EntityRegistry.addSpawn(EntityApalachiaWarrior.class, 2, 4, 4, EnumCreatureType.monster, apalachiaBiome);
		EntityRegistry.addSpawn(EntityApalachiaArcher.class, 2, 4, 4, EnumCreatureType.monster, apalachiaBiome);
		EntityRegistry.addSpawn(EntitySpellbinder.class, 1, 4, 4, EnumCreatureType.monster, apalachiaBiome);

		EntityRegistry.addSpawn(EntitySkythernFiend.class, 4, 4, 4, EnumCreatureType.monster, skythernBiome);
		EntityRegistry.addSpawn(EntitySkythernGolem.class, 4, 4, 4, EnumCreatureType.monster, skythernBiome);
		EntityRegistry.addSpawn(EntitySkythernArcher.class, 4, 4, 4, EnumCreatureType.monster, skythernBiome);
		EntityRegistry.addSpawn(EntitySamek.class, 4, 4, 4, EnumCreatureType.monster, skythernBiome);
		EntityRegistry.addSpawn(EntitySkythernCori.class, 1, 4, 4, EnumCreatureType.monster, skythernBiome);
		EntityRegistry.addSpawn(EntityMystic.class, 2, 4, 4, EnumCreatureType.monster, skythernBiome);
		EntityRegistry.addSpawn(EntityMegalith.class, 1, 4, 4, EnumCreatureType.monster, skythernBiome);

		EntityRegistry.addSpawn(EntityMortumDemon.class, 2, 4, 4, EnumCreatureType.monster, mortumBiome);
		EntityRegistry.addSpawn(EntityBaslisk.class, 2, 4, 4, EnumCreatureType.monster, mortumBiome);
		EntityRegistry.addSpawn(EntitySoulStealer.class, 2, 4, 4, EnumCreatureType.monster, mortumBiome);
		EntityRegistry.addSpawn(EntityMortumCadillion.class, 2, 4, 4, EnumCreatureType.monster, mortumBiome);
		EntityRegistry.addSpawn(EntityTwilightArcher.class, 2, 4, 4, EnumCreatureType.monster, mortumBiome);
		EntityRegistry.addSpawn(EntitySorcerer.class, 1, 4, 4, EnumCreatureType.monster, mortumBiome);
	}

	public static void addOverworldSpawns() {
		for (int i = 0; i < BiomeGenBase.getBiomeGenArray().length; i++) {
			BiomeGenBase biome = BiomeGenBase.getBiomeGenArray()[i];
			if (biome != null){
				if (BiomeDictionary.isBiomeOfType(biome, Type.END)) {
					EntityRegistry.addSpawn(EntityEnderSpider.class, 2, 1, 4, EnumCreatureType.monster, biome);
					EntityRegistry.addSpawn(EntityEnderTriplets.class, 1, 1, 4, EnumCreatureType.monster, biome);
					EntityRegistry.addSpawn(EntityEnderWatcher.class, 10, 4, 4, EnumCreatureType.monster, biome);
				} else if (BiomeDictionary.isBiomeOfType(biome, Type.NETHER)) {
					//EntityRegistry.addSpawn(EntityHellBat.class, 50, 1, 1, EnumCreatureType.monster, biome);
					EntityRegistry.addSpawn(EntityHellPig.class, 25, 5, 50, EnumCreatureType.creature, biome);
					EntityRegistry.addSpawn(EntityHellSpider.class, 50, 1, 1, EnumCreatureType.monster, biome);
					EntityRegistry.addSpawn(EntityScorcher.class, 7, 4, 4, EnumCreatureType.monster, biome);
					EntityRegistry.addSpawn(EntityWildfire.class, 50, 1, 1, EnumCreatureType.monster, biome);
				} else if(overworldBiome(biome)) {
					if (BiomeDictionary.isBiomeOfType(biome, Type.SNOWY)) {
						EntityRegistry.addSpawn(EntityGlacon.class, 30, 1, 1, EnumCreatureType.monster, biome);
						EntityRegistry.addSpawn(EntityGlacon.class, 30, 1, 1, EnumCreatureType.creature, biome);
						EntityRegistry.addSpawn(EntityFrost.class, 50, 1, 4, EnumCreatureType.monster, biome);
					}
					if (BiomeDictionary.isBiomeOfType(biome, Type.SANDY)) {
						EntityRegistry.addSpawn(EntityDesertCrawler.class, 50, 1, 4, EnumCreatureType.monster, biome);
						EntityRegistry.addSpawn(EntityAridWarrior.class, 35, 1, 4, EnumCreatureType.monster, biome);
						EntityRegistry.addSpawn(EntitySaguaroWorm.class, 20, 1, 4, EnumCreatureType.monster, biome);
					}
					if (biome == BiomeGenBase.ocean || biome == BiomeGenBase.deepOcean) {
						EntityRegistry.addSpawn(EntityWhale.class, 1, 1, 1, EnumCreatureType.waterCreature, biome);
						EntityRegistry.addSpawn(EntityShark.class, 1, 1, 1, EnumCreatureType.waterCreature, biome);
						EntityRegistry.addSpawn(EntityLiopleurodon.class, 1, 1, 1, EnumCreatureType.waterCreature, biome);
					}
					if (BiomeDictionary.isBiomeOfType(biome, Type.BEACH)) {
						EntityRegistry.addSpawn(EntityCrab.class, 100, 4, 4, EnumCreatureType.monster, biome);
						EntityRegistry.addSpawn(EntityKingCrab.class, 40, 4, 4, EnumCreatureType.monster, biome);
					}
					if (BiomeDictionary.isBiomeOfType(biome, Type.JUNGLE)) {
						EntityRegistry.addSpawn(EntityJungleBat.class, 50, 1, 4, EnumCreatureType.monster, biome);
						EntityRegistry.addSpawn(EntityJungleDramcryx.class, 80, 1, 4, EnumCreatureType.monster, biome);
						EntityRegistry.addSpawn(EntityJungleSpider.class, 80, 1, 4, EnumCreatureType.monster, biome);
					}
					if(BiomeDictionary.isBiomeOfType(biome, Type.PLAINS)) {
						EntityRegistry.addSpawn(EntityKobblin.class, 5, 1, 1, EnumCreatureType.monster, biome);
					}
					if(BiomeDictionary.isBiomeOfType(biome, Type.PLAINS) || BiomeDictionary.isBiomeOfType(biome, Type.MOUNTAIN)) {
					    EntityRegistry.addSpawn(EntityCyclops.class, 80, 2, 4, EnumCreatureType.monster, biome);
					}
					if(BiomeDictionary.isBiomeOfType(biome, Type.FOREST)) {
                        EntityRegistry.addSpawn(EntityPumpkinSpider.class, 20, 1, 1, EnumCreatureType.monster, biome);
                    }
					EntityRegistry.addSpawn(EntityMiner.class, 5, 1, 1, EnumCreatureType.monster, biome);
					EntityRegistry.addSpawn(EntityJackOMan.class, 5, 1, 1, EnumCreatureType.monster, biome);
					EntityRegistry.addSpawn(EntityCaveCrawler.class, 70, 2, 3, EnumCreatureType.monster, biome);
					EntityRegistry.addSpawn(EntityRotatick.class, 70, 3, 4, EnumCreatureType.monster, biome);
					EntityRegistry.addSpawn(EntityEnthralledDramcryx.class, 70, 3, 4, EnumCreatureType.monster, biome);
					EntityRegistry.addSpawn(EntityTheEye.class, 30, 1, 4, EnumCreatureType.monster, biome);
					EntityRegistry.addSpawn(EntityTheGrue.class, 30, 1, 4, EnumCreatureType.monster, biome);
					EntityRegistry.addSpawn(EntityCaveclops.class, 70, 1, 4, EnumCreatureType.monster, biome);
					EntityRegistry.addSpawn(EntityEnderSpider.class, 4, 1, 4, EnumCreatureType.monster, biome);
					EntityRegistry.addSpawn(EntityRainbour.class, 1, 1, 1, EnumCreatureType.ambient, biome);
				}
			}
		}
	}

	public static void addVetheaSpawns() {
		BiomeGenBase[] vetheaBiome = new BiomeGenBase[] {DimensionHelper.vetheaBiome};

		EntityRegistry.addSpawn(EntityVermenous.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);
		EntityRegistry.addSpawn(EntityCymesoid.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityDreamwrecker.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityDuo.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityTwins.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityBohemite.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityTocaxin.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityMandragora.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityShadahier.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityLheiva.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityHoverStinger.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityAcidHag.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityKazrotic.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityVhraak.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityHelio.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);
		EntityRegistry.addSpawn(EntityBiphron.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityZoragon.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityGorgosion.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityDissiment.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityZone.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityLorga.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityLorgaFlight.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);	
		EntityRegistry.addSpawn(EntityGalroid.class, 1, 1, 1, EnumCreatureType.monster, vetheaBiome);
		EntityRegistry.addSpawn(EntityMysteriousManLayer1.class, 1, 1, 1, EnumCreatureType.creature, vetheaBiome);
		EntityRegistry.addSpawn(EntityMysteriousManLayer2.class, 1, 1, 1, EnumCreatureType.creature, vetheaBiome);
		EntityRegistry.addSpawn(EntityMysteriousManLayer3.class, 1, 1, 1, EnumCreatureType.creature, vetheaBiome);
	}
	
	public static boolean overworldBiome(BiomeGenBase b) {
	    List<SpawnListEntry> monsterList = ObfuscationReflectionHelper.getPrivateValue(BiomeGenBase.class, b, "as", "field_76761_J", "spawnableMonsterList");
	    for(SpawnListEntry e : monsterList) {
	        if(e.entityClass == EntityZombie.class) return true;
	    }
	    return false;
	}
}
