package divinerpg.data;

import divinerpg.registries.FluidRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.material.Fluid;

import java.util.concurrent.CompletableFuture;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.TagRegistry.Fluids.*;
import static net.minecraft.core.registries.Registries.FLUID;

public class ModFluidTagsProvider extends FluidTagsProvider {
    public ModFluidTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, MODID);
    }
    @SuppressWarnings("unchecked")
    @Override protected void addTags(HolderLookup.Provider registries) {
        tag(commonTag("tar")).addTag(SMOLDERING_TAR);
        tag(SMOLDERING_TAR).add(FluidRegistry.SMOLDERING_TAR_FLUID.key(), FluidRegistry.SMOLDERING_TAR_FLUID_FLOWING.key());
        tag(commonTag("smoldering_tar")).addTag(SMOLDERING_TAR);
    }
    private static TagKey<Fluid> commonTag(String name){
        return TagKey.create(FLUID, Identifier.fromNamespaceAndPath("c", name));
    }
}