package net.divinerpg.helper;

import net.divinerpg.dimension.gen.arcana.BiomeGenArcana;
import net.divinerpg.dimension.gen.arcana.WorldProviderArcana;
import net.divinerpg.dimension.gen.iceika.BiomeGenIceika;
import net.divinerpg.dimension.gen.iceika.WorldProviderIceika;
import net.divinerpg.dimension.gen.twilight.apalachia.BiomeGenApalachia;
import net.divinerpg.dimension.gen.twilight.apalachia.WorldProviderApalachia;
import net.divinerpg.dimension.gen.twilight.eden.BiomeGenEden;
import net.divinerpg.dimension.gen.twilight.eden.WorldProviderEden;
import net.divinerpg.dimension.gen.twilight.mortum.BiomeGenMortum;
import net.divinerpg.dimension.gen.twilight.mortum.WorldProviderMortum;
import net.divinerpg.dimension.gen.twilight.skythern.BiomeGenSkythern;
import net.divinerpg.dimension.gen.twilight.skythern.WorldProviderSkythern;
import net.divinerpg.dimension.gen.twilight.wild_woods.BiomeGenWildWoods;
import net.divinerpg.dimension.gen.twilight.wild_woods.WorldProviderWildWoods;
import net.divinerpg.dimension.gen.vethea.BiomeGenVethea;
import net.divinerpg.dimension.gen.vethea.WorldProviderVethea;
import net.divinerpg.helper.config.ConfigurationHelper;
import net.divinerpg.helper.utils.LogHelper;
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
