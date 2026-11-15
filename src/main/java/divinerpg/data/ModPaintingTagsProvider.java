package divinerpg.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.PaintingVariantTagsProvider;

import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.PaintingRegistry.*;
import static net.minecraft.tags.PaintingVariantTags.PLACEABLE;

public class ModPaintingTagsProvider extends PaintingVariantTagsProvider {
    public ModPaintingTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }
    @SuppressWarnings("unchecked")
    @Override protected void addTags(HolderLookup.Provider registries) {
        tag(PLACEABLE).add(
                // 1x1
                CRAWLING, GRAZING,
                // 1x2
                MOONLIGHT_RAVE,
                // 2x1
                DISTURBED,
                // 2x2
                FALL, LEVELS, LURKING_TERROR,
                // 2x4
                HOWLING_AT_THE_MOON,
                // 4x4
                ICE_AGE);
    }
}