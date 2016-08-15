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
import net.divinerpg.dimensions.twilight.wildwood.BiomeGenWildwood;
import net.divinerpg.dimensions.twilight.wildwood.WorldProviderWildwood;
import net.divinerpg.dimensions.vethea.BiomeGenVethea;
import net.divinerpg.dimensions.vethea.WorldProviderVethea;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;

public class DimensionHelper {

	protected static final BiomeGenBase.Height iceikaHeight 	= new BiomeGenBase.Height(0.0F, 0.7F); 
	protected static final BiomeGenBase.Height vetheaHeight 	= new BiomeGenBase.Height(-1.0F, 0.0F);
	protected static final BiomeGenBase.Height apalachiaHeight	= new BiomeGenBase.Height(0.5F, 2.0F);
	
	public static BiomeGenBase edenBiome 		= new BiomeGenEden(ConfigurationHelper.edenBiome);
	public static BiomeGenBase wildwoodBiome	= new BiomeGenWildwood(ConfigurationHelper.wildwoodBiome);
	public static BiomeGenBase apalachiaBiome	= new BiomeGenApalachia(ConfigurationHelper.apalachiaBiome);
	public static BiomeGenBase skythernBiome	= new BiomeGenSkythern(ConfigurationHelper.skythernBiome);
	public static BiomeGenBase mortumBiome 		= new BiomeGenMortum(ConfigurationHelper.mortumBiome);
	public static BiomeGenBase iceikaBiome 		= new BiomeGenIceika(ConfigurationHelper.iceikaBiome).setHeight(iceikaHeight);
	public static BiomeGenBase vetheaBiome 		= new BiomeGenVethea(ConfigurationHelper.vetheaBiome).setHeight(vetheaHeight);
	public static BiomeGenBase arcanaBiome 		= new BiomeGenArcana(ConfigurationHelper.arcanaBiome);

	public static void init(){
		addDimension(ConfigurationHelper.eden, WorldProviderEden.class, ConfigurationHelper.keepLoadingEden);
		addDimension(ConfigurationHelper.wildwood, WorldProviderWildwood.class, ConfigurationHelper.keepLoadingWildwood);
		addDimension(ConfigurationHelper.arcana, WorldProviderArcana.class, ConfigurationHelper.keepLoadingArcana);
		addDimension(ConfigurationHelper.iceika, WorldProviderIceika.class, ConfigurationHelper.keepLoadingIceika);
		addDimension(ConfigurationHelper.vethea, WorldProviderVethea.class, ConfigurationHelper.keepLoadingVethea);
		addDimension(ConfigurationHelper.apalachia, WorldProviderApalachia.class, ConfigurationHelper.keepLoadingApalachia);
		addDimension(ConfigurationHelper.skythern, WorldProviderSkythern.class, ConfigurationHelper.keepLoadingSkythern);
		addDimension(ConfigurationHelper.mortum, WorldProviderMortum.class, ConfigurationHelper.keepLoadingMortum);
	}

	private static void addDimension(int id, Class<? extends WorldProvider> w, boolean keeploading){
	    LogHelper.debug("Registering dimension ID: " + id);
		DimensionManager.registerProviderType(id, w, keeploading);
		DimensionManager.registerDimension(id, id);
	}

}
