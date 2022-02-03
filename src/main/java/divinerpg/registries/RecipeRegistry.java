package divinerpg.registries;

import divinerpg.*;
import divinerpg.recipe.*;
import net.minecraft.item.crafting.*;
import net.minecraftforge.fml.*;
import net.minecraftforge.registries.*;

public class RecipeRegistry {

    public static class Serailizers {
        public static final DeferredRegister<IRecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, DivineRPG.MODID);
        public static final RegistryObject<IRecipeSerializer<ArcaniumExtractorRecipe>> ARCANIUM_EXTRACTOR_SERIALIZER = RECIPE_SERIALIZERS.register("arcanium_extractor", ArcaniumExtractorRecipe.Serializer::new);
    }

    public static class RecipeTypes {
        public static final IRecipeType<ArcaniumExtractorRecipe> ARCANIUM_EXTRACTOR_RECIPE_TYPE = IRecipeType.register(DivineRPG.MODID + ":arcanium_extractor");
    }
}
