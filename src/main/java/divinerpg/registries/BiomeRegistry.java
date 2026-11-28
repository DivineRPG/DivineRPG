package divinerpg.registries;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

import static divinerpg.DivineRPG.MODID;
import static net.minecraft.core.registries.Registries.BIOME;
import static net.minecraft.resources.Identifier.fromNamespaceAndPath;

public class BiomeRegistry {
    public static final ResourceKey<Biome>
        ICEIKA = register("iceika"),
        ICEIKA_BONEYARD = register("iceika/boneyard"),
        ICEIKA_BOREALIS_STEEPS = register("iceika/borealis_steeps"),
        ICEIKA_CHILLY_CAVERN = register("iceika/chilly_cavern"),
        ICEIKA_CHILL_PASSAGE = register("iceika/chill_passage"),
        ICEIKA_COZYBARK_FOREST = register("iceika/cozybark_forest"),
        ICEIKA_DEEP_FROZEN_OCEAN = register("iceika/deep_frozen_ocean"),
        ICEIKA_FRACTAL_FOREST = register("iceika/fractal_forest"),
        ICEIKA_FROZEN_MENAGERIE = register("iceika/frozen_menagerie"),
        ICEIKA_FROZEN_OCEAN = register("iceika/frozen_ocean"),
        ICEIKA_FROZEN_PEAKS = register("iceika/frozen_peaks"),
        ICEIKA_GEYSER_PLATEAU = register("iceika/geyser_plateau"),
        ICEIKA_GLOWING_DEEP = register("iceika/glowing_deep"),
        ICEIKA_ICE_SHEET = register("iceika/ice_sheet"),
        ICEIKA_ICE_SPIKES = register("iceika/ice_spikes"),
        ICEIKA_MORGUE_MARSH = register("iceika/morgue_marsh"),
        ICEIKA_SHELTERED_GARDEN = register("iceika/sheltered_garden"),
        ICEIKA_SHIVERSPINE_FOREST = register("iceika/shiverspine_forest"),
        ICEIKA_SNOWY_PEAKS = register("iceika/snowy_peaks"),
        ICEIKA_SNOW_BOG = register("iceika/snow_bog"),
        ICEIKA_THERMAL_VENTS = register("iceika/thermal_vents"),
        ICEIKA_TUNDRA = register("iceika/tundra"),

        ARCANA = register("arcana"),
        ARCANA_DUNE_VALLEY = register("arcana/dune_valley"),
        ARCANA_BARON_HIGHLANDS = register("arcana/baron_highlands"),

        EDEN = register("eden"),
        EDEN_DRAVITE_CAVES = register("eden/dravite_caves"),
        EDEN_DRAVITE_HILLS = register("eden/dravite_hills"),
        EDEN_FOREST = register("eden/forest"),
        EDEN_GOLDEN_PEAKS = register("eden/golden_peaks"),
        EDEN_MAGNETIC_ISLES = register("eden/magnetic_isles"),
        EDEN_PLAINS = register("eden/plains"),

        WILDWOOD = register("wildwood"),
        APALACHIA = register("apalachia"),
        SKYTHERN = register("skythern"),
        MORTUM = register("mortum"),

        VETHEA = register("vethea"),
        VETHEA_EMBER_CAVERNS = register("vethea/ember_caverns"),
        VETHEA_DREAM_GROUNDS = register("vethea/dream_grounds"),
        VETHEA_HYRELANDS = register("vethea/hyrelands"),
        VETHEA_SCORCHED_TOPS = register("vethea/scorched_tops");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(BIOME, fromNamespaceAndPath(MODID, name));
    }
}