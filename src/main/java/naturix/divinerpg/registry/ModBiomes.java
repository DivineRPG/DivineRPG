package naturix.divinerpg.registry;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.world.biomes.BiomeEden;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;
import net.minecraftforge.common.BiomeManager.BiomeType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModBiomes {
	public static final Biome Eden = new BiomeEden();
	
	public static void registerBiomes()
	{
		initBiome(Eden, "Eden", BiomeType.WARM, Type.END, Type.END, Type.DRY);
		}
	
	private static Biome initBiome(Biome biome, String name, BiomeType biomeType, Type... types)
	{
		biome.setRegistryName(name);
		ForgeRegistries.BIOMES.register(biome);
		DivineRPG.logger.info("Biome Registered");
		BiomeDictionary.addTypes(biome, types);
		BiomeManager.addBiome(biomeType, new BiomeEntry(biome, 10));
		BiomeManager.addSpawnBiome(biome);
		DivineRPG.logger.info("Biome Added");
		return biome;
	}
}
