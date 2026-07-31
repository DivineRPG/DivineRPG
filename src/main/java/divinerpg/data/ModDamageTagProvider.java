package divinerpg.data;

import divinerpg.registries.TagRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.tags.DamageTypeTags;

import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;

public class ModDamageTagProvider extends DamageTypeTagsProvider {

    public ModDamageTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        tag(TagRegistry.MAGE_RESIST).addTags(DamageTypeTags.WITCH_RESISTANT_TO);
    }
}
