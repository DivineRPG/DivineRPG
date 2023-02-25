package divinerpg.registries;

import static divinerpg.DivineRPG.MODID;

import divinerpg.recipe.*;
import net.minecraft.world.item.crafting.*;
import net.minecraftforge.registries.*;

public class RecipeRegistry {
    public static class Types {
        public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, MODID);

        public static final RegistryObject<RecipeType<? extends AbstractCookingRecipe>> ARCANIUM_EXTRACTOR_RECIPE_TYPE = RECIPE_TYPES.register("arcanium_extractor", () -> ArcaniumExtractorRecipe.Type.INSTANCE);
        public static final RegistryObject<RecipeType<?>> INFUSIION_TABLE_RECIPE_TYPE = RECIPE_TYPES.register("infusion_table", () -> InfusionTableRecipe.Type.INSTANCE);
    }
    public static class Serailizers {
        public static final DeferredRegister<RecipeSerializer<?>> SERIALIZER = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MODID);
        public static final RegistryObject<SimpleCookingSerializer<ArcaniumExtractorRecipe>> ARCANIUM_EXTRACTOR_SERIALIZER = SERIALIZER.register("arcanium_extractor", () -> new SimpleCookingSerializer<>(ArcaniumExtractorRecipe::new, 100));
        public static final RegistryObject<RecipeSerializer<InfusionTableRecipe>> INFUSION_TABLE_SERIALIZER = SERIALIZER.register("infusion_table", InfusionTableRecipe.Serializer::new);
    }
}