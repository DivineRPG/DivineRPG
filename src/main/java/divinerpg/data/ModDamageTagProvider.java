package divinerpg.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.DamageTypeTagsProvider;
import net.minecraft.tags.DamageTypeTags;

import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.DamageRegistry.*;
import static divinerpg.registries.TagRegistry.DamageTypes.*;

public class ModDamageTagProvider extends DamageTypeTagsProvider {
    public ModDamageTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }
    @SuppressWarnings("unchecked")
    @Override protected void addTags(HolderLookup.Provider registries) {
        tag(DamageTypeTags.BYPASSES_ARMOR).add(ACID);
        tag(DamageTypeTags.BYPASSES_WOLF_ARMOR).add(ACID);
        tag(DamageTypeTags.BYPASSES_SHIELD).add(SPIKE, TAR);

        tag(AVOIDS_SAGUARO_THORNS).addTag(DamageTypeTags.AVOIDS_GUARDIAN_THORNS);
        tag(DamageTypeTags.WITCH_RESISTANT_TO).add(ARCANA);
        tag(MAGE_RESISTANT_TO).addTag(DamageTypeTags.WITCH_RESISTANT_TO);
        tag(DamageTypeTags.SULFUR_CUBE_WITH_BLOCK_IMMUNE_TO).add(HAIL, SPIKE);

        tag(DamageTypeTags.PANIC_CAUSES).add(ARCANA);
        tag(DamageTypeTags.PANIC_ENVIRONMENTAL_CAUSES).add(ACID, HAIL, SPIKE, TAR);

        tag(DamageTypeTags.NO_KNOCKBACK).add(ACID, HAIL, SPIKE, TAR);
        tag(DamageTypeTags.IS_FIRE).add(TAR);
    }
}