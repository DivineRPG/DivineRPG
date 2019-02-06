package naturix.divinerpg.registry;

import naturix.divinerpg.world.biomes.BiomeApalachia;
import naturix.divinerpg.world.biomes.BiomeEden;
import naturix.divinerpg.world.biomes.BiomeIceika;
import naturix.divinerpg.world.biomes.BiomeMortum;
import naturix.divinerpg.world.biomes.BiomeSkythern;
import naturix.divinerpg.world.biomes.BiomeWildWood;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBiomes {
	public static final Biome Eden = new BiomeEden("biome_eden");
	public static final Biome WildWood = new BiomeWildWood("biome_wildwood");
	public static final Biome Apalachia = new BiomeApalachia("biome_apalachia");
	public static final Biome Skythern = new BiomeSkythern("biome_skythern");
	public static final Biome Mortum = new BiomeMortum("biome_mortum");
	public static final Biome Iceika = new BiomeIceika("biome_iceika");
	
    @SubscribeEvent
    public static void registerBiomes(IForgeRegistry<Biome> iForgeRegistry) {
        IForgeRegistry<Biome> registry = iForgeRegistry;
        registry.registerAll(
        		Eden,
        		WildWood,
        		Apalachia,
        		Skythern,
        		Mortum,
        		Iceika
        		);

		BiomeDictionary.addTypes(Iceika, BiomeDictionary.Type.COLD, BiomeDictionary.Type.DRY, BiomeDictionary.Type.DENSE, BiomeDictionary.Type.FOREST);

//        BiomeDictionary.addTypes(Eden, BiomeDictionary.Type.MAGICAL);


//        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(Eden, 100));
        
        //BiomeManager.addSpawnBiome(Eden);


        //BiomeProvider.allowedBiomes.add(Eden);

    }
}