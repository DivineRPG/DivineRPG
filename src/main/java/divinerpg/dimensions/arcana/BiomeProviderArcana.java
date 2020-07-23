package divinerpg.dimensions.arcana;

import divinerpg.registry.BiomeRegistry;
import net.minecraft.world.biome.BiomeProviderSingle;

public class BiomeProviderArcana extends BiomeProviderSingle {

    public BiomeProviderArcana() {
        super(BiomeRegistry.biomeArcana);
    }
}