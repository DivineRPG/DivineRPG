package divinerpg.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.StructureTagsProvider;

import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.StructureRegistry.*;
import static divinerpg.registries.TagRegistry.Structures.*;

public class ModStructureTagsProvider extends StructureTagsProvider {
    public ModStructureTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }
    @SuppressWarnings("unchecked")
    @Override protected void addTags(HolderLookup.Provider registries) {
        tag(ICEIKA_DUNGEON).add(Iceika.DUNGEON);
        tag(GROGLIN_RAID_TARGETS).add(Iceika.VILLAGE, Iceika.GRUZZORLUG_VILLAGE);
        tag(GRUZZORLUG_RAID_TARGETS).add(Iceika.VILLAGE, Iceika.GROGLIN_VILLAGE);
        tag(WHALE_SKULL).add(Iceika.WHALE_SKULL);
    }
}