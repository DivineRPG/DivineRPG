package net.divinerpg.utils;

import net.divinerpg.dimensions.arcana.BiomeGenArcana;
import net.divinerpg.dimensions.arcana.WorldProviderArcana;
import net.divinerpg.dimensions.iceika.BiomeGenIceika;
import net.divinerpg.dimensions.iceika.WorldProviderIceika;
import net.divinerpg.dimensions.twilight.apalachia.BiomeGenApalachia;
import net.divinerpg.dimensions.twilight.apalachia.WorldProviderApalachia;
import net.divinerpg.dimensions.twilight.eden.BiomeGenEden;
import net.divinerpg.dimensions.twilight.eden.WorldProviderEden;
import net.divinerpg.dimensions.twilight.mortum.BiomeGenMortum;
import net.divinerpg.dimensions.twilight.mortum.WorldProviderMortum;
import net.divinerpg.dimensions.twilight.skythern.BiomeGenSkythern;
import net.divinerpg.dimensions.twilight.skythern.WorldProviderSkythern;
import net.divinerpg.dimensions.twilight.wild_woods.BiomeGenWildWoods;
import net.divinerpg.dimensions.twilight.wild_woods.WorldProviderWildWoods;
import net.divinerpg.dimensions.vethea.BiomeGenVethea;
import net.divinerpg.dimensions.vethea.WorldProviderVethea;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class DimensionHelper {

	protected static final BiomeGenBase.Height iceikaHeight = new BiomeGenBase.Height(0.0F, 0.7F); 
	protected static final BiomeGenBase.Height vetheaHeight = new BiomeGenBase.Height(-1.0F, 0.0F);
	
	public static BiomeGenBase Eden 		= new BiomeGenEden(ConfigurationHelper.edenBiome);
	public static BiomeGenBase WildWoods 	= new BiomeGenWildWoods(ConfigurationHelper.wildwoodBiome);
	public static BiomeGenBase Apalachia 	= new BiomeGenApalachia(ConfigurationHelper.apalachiaBiome);
	public static BiomeGenBase Skythern 	= new BiomeGenSkythern(ConfigurationHelper.skythernBiome);
	public static BiomeGenBase Mortum 		= new BiomeGenMortum(ConfigurationHelper.mortumBiome);
	public static BiomeGenBase Iceika 		= new BiomeGenIceika(ConfigurationHelper.iceikaBiome).setHeight(iceikaHeight);
	public static BiomeGenBase Vethea 		= new BiomeGenVethea(ConfigurationHelper.vetheaBiome).setHeight(vetheaHeight);
	public static BiomeGenBase Arcana 		= new BiomeGenArcana(ConfigurationHelper.arcanaBiome);

	public static void init(){
	    LogHelper.info("Adding dimensions");
		addDimension(ConfigurationHelper.eden, WorldProviderEden.class, ConfigurationHelper.keepLoadingEden);
		addDimension(ConfigurationHelper.wildwood, WorldProviderWildWoods.class, ConfigurationHelper.keepLoadingWildwood);
		addDimension(ConfigurationHelper.arcana, WorldProviderArcana.class, ConfigurationHelper.keepLoadingArcana);
		addDimension(ConfigurationHelper.iceika, WorldProviderIceika.class, ConfigurationHelper.keepLoadingIceika);
		addDimension(ConfigurationHelper.vethea, WorldProviderVethea.class, ConfigurationHelper.keepLoadingVethea);
		addDimension(ConfigurationHelper.apalachia, WorldProviderApalachia.class, ConfigurationHelper.keepLoadingApalachia);
		addDimension(ConfigurationHelper.skythern, WorldProviderSkythern.class, ConfigurationHelper.keepLoadingSkythern);
		addDimension(ConfigurationHelper.mortum, WorldProviderMortum.class, ConfigurationHelper.keepLoadingMortum);
	}

	private static void addDimension(int id, Class<? extends WorldProvider> w, boolean keeploading){
	    LogHelper.info("Registering dimension ID: " + id);
		DimensionManager.registerProviderType(id, w, keeploading);
		DimensionManager.registerDimension(id, id);
	}

}
