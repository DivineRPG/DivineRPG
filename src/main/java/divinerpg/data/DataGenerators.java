package divinerpg.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

public class DataGenerators {
    public static void genData(GatherDataEvent.Client event) {
        PackOutput output = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> world = event.getWorldLookupProvider();
        CompletableFuture<HolderLookup.Provider> reloadable = event.getReloadableLookupProvider();
        DataGenerator generator = event.getGenerator();

        generator.addProvider(true, new ModLangProvider(output, "en_us"));
        event.createProvider(ModModelProvider::new);

        event.createBlockAndItemTags(ModBlockTagsProvider::new, ModItemTagsProvider::new);
        event.createProvider(ModFluidTagsProvider::new);
        event.createProvider(ModEntityTypeTagsProvider::new);

        DatapackBuiltinEntriesProvider datapackProvider = ModDatapackProvider.create(output, world);
        generator.addProvider(true, datapackProvider);

        CompletableFuture<HolderLookup.Provider> fullLookup = datapackProvider.getRegistryProvider();

        DatapackBuiltinEntriesProvider reloadableProvider = ModDatapackProvider.createReloadable(output, fullLookup, reloadable);
        generator.addProvider(true, reloadableProvider);

        generator.addProvider(true, new ModLootModifierProvider(output, fullLookup));
        generator.addProvider(true, new ModEnchantmentTagsProvider(output, fullLookup));
        generator.addProvider(true, new ModDamageTagsProvider(output, fullLookup));
        generator.addProvider(true, new ModPaintingTagsProvider(output, fullLookup));
        generator.addProvider(true, new ModDimensionTagsProvider(output, fullLookup));
        generator.addProvider(true, new ModBiomeTagsProvider(output, fullLookup));
        generator.addProvider(true, new ModStructureTagsProvider(output, fullLookup));
        generator.addProvider(true, new ModSoundProvider(output));
        generator.addProvider(true, new ModEquipmentAssetProvider(output));
    }
}