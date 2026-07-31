package divinerpg.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.TagRegistry.*;

public class ModBiomeTagProvider extends BiomeTagsProvider {
    public ModBiomeTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(BASALT_DELTAS).add(Biomes.BASALT_DELTAS);
        tag(CRIMSON_FOREST).add(Biomes.CRIMSON_FOREST);
        tag(IS_DEEP_DARK_OR_MUSHROOM).add(Biomes.DEEP_DARK).addTags(commonTag("is_mushroom"));
        tag(DRIPSTONE_CAVES).add(Biomes.DRIPSTONE_CAVES);
        tag(NETHER_WASTES).add(Biomes.NETHER_WASTES);
        tag(SOUL_SAND_VALLEY).add(Biomes.SOUL_SAND_VALLEY);
        tag(WARM_OCEAN).add(Biomes.LUKEWARM_OCEAN, Biomes.WARM_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN);
    }

    private TagKey<Biome> commonTag(String name){
        return TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath("c", name));
    }
    private TagKey<Biome> minecraftTag(String name){
        return TagKey.create(Registries.BIOME, Identifier.withDefaultNamespace(name));
    }
    private TagKey<Biome> customTag(String name){
        return TagKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(MODID, name));
    }
}
