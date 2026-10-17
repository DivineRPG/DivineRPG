package divinerpg.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;

public class DataGenerators {

    public static void genData(GatherDataEvent.Client event) {
        PackOutput output = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> world = event.getWorldLookupProvider();
        CompletableFuture<HolderLookup.Provider> reloadable = event.getReloadableLookupProvider();
        DataGenerator generator = event.getGenerator();

        generator.addProvider(true, new ModLangProvider(output, "en_us"));
        event.createProvider(ModModelProvider::new);

        event.createBlockAndItemTags(ModBlockTagsProvider::new, (packOutput, lookup, blockTags) -> new ModItemTagsProvider(packOutput, lookup));
        event.createProvider(ModDamageTagProvider::new);
        event.createProvider(ModBiomeTagProvider::new);
        event.createProvider(ModEntityTypeTagProvider::new);
        event.createProvider(ModFluidTagsProvider::new);

        DatapackBuiltinEntriesProvider datapackProvider = ModDatapackProvider.create(output, world);
        generator.addProvider(true, datapackProvider);

        DatapackBuiltinEntriesProvider reloadableProvider = ModDatapackProvider.createReloadable(output, world, reloadable);
        generator.addProvider(true, reloadableProvider);

        CompletableFuture<HolderLookup.Provider> fullLookup = datapackProvider.getRegistryProvider();

        generator.addProvider(true, new ModLootModifierProvider(output, fullLookup, MODID));
        generator.addProvider(true, new ModPaintingTagsProvider(output, fullLookup));
        generator.addProvider(true, new ModSoundProvider(output));
        generator.addProvider(true, new ModEquipmentAssetProvider(output));
    }
}