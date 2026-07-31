package divinerpg.data;

import divinerpg.DivineRPG;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.PaintingVariantTags;
import net.minecraft.tags.TagBuilder;
import net.minecraft.tags.TagEntry;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;

import java.util.concurrent.CompletableFuture;

public class ModPaintingTagsProvider extends TagsProvider<PaintingVariant> {

    public ModPaintingTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.PAINTING_VARIANT, lookupProvider, DivineRPG.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider lookupProvider) {
        TagBuilder placeableBuilder = this.getOrCreateRawBuilder(PaintingVariantTags.PLACEABLE);

        addPainting(placeableBuilder, "fall");
        addPainting(placeableBuilder, "moonlight_rave");
        addPainting(placeableBuilder, "grazing");
        addPainting(placeableBuilder, "disturbed");
        addPainting(placeableBuilder, "levels");
        addPainting(placeableBuilder, "ice_age");
        addPainting(placeableBuilder, "crawling");
        addPainting(placeableBuilder, "howling_at_the_moon");
        addPainting(placeableBuilder, "lurking_terror");
    }

    private void addPainting(TagBuilder builder, String name) {
        Identifier id = Identifier.fromNamespaceAndPath(DivineRPG.MODID, name);
        builder.add(TagEntry.optionalElement(id));
    }
}