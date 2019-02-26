package naturix.divinerpg.registry;

import naturix.divinerpg.utils.Reference;
import naturix.divinerpg.world.biomes.BiomeApalachia;
import naturix.divinerpg.world.biomes.BiomeEden;
import naturix.divinerpg.world.biomes.BiomeIceika;
import naturix.divinerpg.world.biomes.BiomeMortum;
import naturix.divinerpg.world.biomes.BiomeSkythern;
import naturix.divinerpg.world.biomes.BiomeWildWood;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = Reference.MODID)
public class ModBiomes {
	public static ArrayList<Biome> BIOME_LIST = new ArrayList<Biome>();

	/**public static final Biome Eden = new BiomeEden("biome_eden");
	public static final Biome WildWood = new BiomeWildWood("biome_wildwood");
	public static final Biome Apalachia = new BiomeApalachia("biome_apalachia");
	public static final Biome Skythern = new BiomeSkythern("biome_skythern");
	public static final Biome Mortum = new BiomeMortum("biome_mortum");
	public static final Biome Iceika = new BiomeIceika("biome_iceika");*/
	public static final Biome Eden = new BiomeEden();
	public static final Biome WildWood = new BiomeWildWood();
	public static final Biome Apalachia = new BiomeApalachia();
	public static final Biome Skythern = new BiomeSkythern();
	public static final Biome Mortum = new BiomeMortum();
	public static final Biome Iceika = new BiomeIceika();

	@SubscribeEvent
	public static void registerBiomes(RegistryEvent.Register<Biome> event) {
		IForgeRegistry<Biome> registry = event.getRegistry();

		registerBiome(registry, Eden, "biome_eden", BiomeManager.BiomeType.WARM, 20, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SPOOKY);
		registerBiome(registry, WildWood, "biome_wildwood", BiomeManager.BiomeType.WARM, 20, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SPOOKY);
		registerBiome(registry, Apalachia, "biome_apalachia", BiomeManager.BiomeType.WARM, 20, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SPOOKY);
		registerBiome(registry, Skythern, "biome_skythern", BiomeManager.BiomeType.WARM, 20, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SPOOKY);
		registerBiome(registry, Mortum, "biome_mortum", BiomeManager.BiomeType.WARM, 20, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SPOOKY);
		registerBiome(registry, Iceika, "biome_iceika", BiomeManager.BiomeType.WARM, 20, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.SPOOKY);


	}

	private static <T extends Biome> void registerBiome(final IForgeRegistry<Biome> registry, final T biome, final String biomeName, final BiomeManager.BiomeType biomeType, final int weight, final BiomeDictionary.Type... types) {
		registry.register(biome.setRegistryName(Reference.MODID, biomeName));
		BiomeDictionary.addTypes(biome, types);
		//BiomeManager.addBiome(biomeType, new BiomeManager.BiomeEntry(biome, weight));
		for(int x = 0; x < weight; x++)
			BIOME_LIST.add((Biome) biome); //temp hack for now
	}
}