package divinerpg.dimensions.arcana;

import divinerpg.registry.ModBiomes;
import net.minecraft.world.biome.BiomeProviderSingle;

public class BiomeProviderArcana extends BiomeProviderSingle {

    public BiomeProviderArcana() {
        super(ModBiomes.biomeArcana);
    }
}