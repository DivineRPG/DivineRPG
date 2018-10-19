package naturix.divinerpg.registry;

import naturix.divinerpg.dimensions.eden.BiomeEden;
import naturix.divinerpg.dimensions.wildwood.BiomeWildWood;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBiomes {
	public static final Biome Eden = new BiomeEden("biome_eden");
	public static final Biome WildWood = new BiomeWildWood("biome_wildwood");

    @SubscribeEvent
    public static void registerBiomes(IForgeRegistry<Biome> iForgeRegistry) {
        IForgeRegistry<Biome> registry = iForgeRegistry;
        registry.registerAll(
        		Eden,
        		WildWood
        		);

//        BiomeDictionary.addTypes(Eden, BiomeDictionary.Type.MAGICAL);


//        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(Eden, 100));
        
        //BiomeManager.addSpawnBiome(Eden);


        //BiomeProvider.allowedBiomes.add(Eden);

    }
}