package naturix.divinerpg.registry;

import naturix.divinerpg.dimensions.apalachia.BiomeApalachia;
import naturix.divinerpg.dimensions.eden.BiomeEden;
import naturix.divinerpg.dimensions.iceika.BiomeIceika;
import naturix.divinerpg.dimensions.mortum.BiomeMortum;
import naturix.divinerpg.dimensions.skythern.BiomeSkythern;
import naturix.divinerpg.dimensions.wildwood.BiomeWildWood;
import net.minecraft.world.biome.Biome;
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

//        BiomeDictionary.addTypes(Eden, BiomeDictionary.Type.MAGICAL);


//        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(Eden, 100));
        
        //BiomeManager.addSpawnBiome(Eden);


        //BiomeProvider.allowedBiomes.add(Eden);

    }
}