package divinerpg.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.world.level.Level;

import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.LevelRegistry.*;
import static divinerpg.registries.TagRegistry.Dimensions.*;
import static net.minecraft.world.level.Level.*;

public class ModDimensionTagsProvider extends TagsProvider<Level> {
    public ModDimensionTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.DIMENSION, lookupProvider, MODID);
    }
    @SuppressWarnings("unchecked")
    @Override protected void addTags(HolderLookup.Provider registries) {
        tag(STABLE_RIFT_OVERWORLD).add(
//        OVERWORLD, END,
        ICEIKA,
//        NETHER,
        EDEN); // TODO: IllegalStateException: Unbound values in registry ResourceKey[minecraft:root / minecraft:dimension]: [minecraft:overworld, minecraft:the_end, minecraft:the_nether]
        tag(STABLE_RIFT_EDEN).add(
//        OVERWORLD,
        EDEN, WILDWOOD);
        tag(STABLE_RIFT_WILDWOOD).add(EDEN, WILDWOOD, APALACHIA);
        tag(STABLE_RIFT_APALACHIA).add(WILDWOOD, APALACHIA, SKYTHERN);
        tag(STABLE_RIFT_SKYTHERN).add(APALACHIA, SKYTHERN, MORTUM);
        tag(STABLE_RIFT_MORTUM).add(SKYTHERN, MORTUM, VETHEA);
    }
}