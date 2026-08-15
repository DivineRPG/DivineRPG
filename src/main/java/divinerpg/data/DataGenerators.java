package divinerpg.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;

public class DataGenerators {

    public static void genData(GatherDataEvent.Client event) {
        PackOutput output = event.getGenerator().getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        DataGenerator generator = event.getGenerator();
        String[] popularLanguages = {"es_es", "fr_fr", "de_de", "zh_cn", "ja_jp", "ru_ru", "hi_in", "ar_sa", "th_th", "tk_ph", "sv_se", "pt_pt", "it_it"};


        generator.addProvider(true, new ModLangProvider(output, "en_us"));
        //Uncomment to see all the languages in popularLanguages generate (takes a long time to generate/translate)
//        for (String lang : popularLanguages) {event.getGenerator().addProvider(true, new ModLangProvider(output, lang));}

        event.createProvider(ModModelProvider::new);
        event.createBlockAndItemTags(ModBlockTagsProvider::new, (packOutput, lookup, blockTags) -> new ModItemTagsProvider(packOutput, lookup));
        event.createProvider(ModLootTableProvider::create);
        event.createProvider(ModDamageTagProvider::new);
        event.createProvider(ModBiomeTagProvider::new);
        event.createProvider(ModEntityTypeTagProvider::new);
        event.createProvider(ModFluidTagsProvider::new);

        generator.addProvider(true, new ModLootModifierProvider(output, lookupProvider, MODID));
        generator.addProvider(true, new ModPaintingTagsProvider(output, lookupProvider));
        generator.addProvider(true, new ModDatapackProvider(output, lookupProvider));
        generator.addProvider(true, new ModSoundProvider(output));
        generator.addProvider(true, new RecipeProvider.Runner(output, lookupProvider) {@Override public String getName() { return "DivineRPG Recipes"; } @Override protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput recipeOutput) {return new ModRecipeProvider(registries, recipeOutput);}});
        generator.addProvider(true, new ModEquipmentAssetProvider(output));
        generator.addProvider(true, new AdvancementProvider(event.getGenerator().getPackOutput(), event.getLookupProvider(), List.of(new ModAdvancementProvider())));

    }
}