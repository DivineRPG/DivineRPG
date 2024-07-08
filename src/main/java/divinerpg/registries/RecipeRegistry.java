package divinerpg.registries;

import divinerpg.recipe.ArcaniumExtractorRecipe;
import divinerpg.recipe.InfusionTableRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCookingSerializer;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static divinerpg.DivineRPG.MODID;

public class RecipeRegistry {
    public static class Types {
        public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, MODID);

        public static final DeferredHolder<RecipeType<?>, RecipeType<? extends AbstractCookingRecipe>> ARCANIUM_EXTRACTOR_RECIPE_TYPE = RECIPE_TYPES.register("arcanium_extractor", () -> ArcaniumExtractorRecipe.Type.INSTANCE);
        public static final DeferredHolder<RecipeType<?>, RecipeType<?>> INFUSIION_TABLE_RECIPE_TYPE = RECIPE_TYPES.register("infusion_table", () -> InfusionTableRecipe.Type.INSTANCE);
    }
    public static class Serailizers {
        public static final DeferredRegister<RecipeSerializer<?>> SERIALIZER = DeferredRegister.create(Registries.RECIPE_SERIALIZER, MODID);
        public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ArcaniumExtractorRecipe>> ARCANIUM_EXTRACTOR_SERIALIZER = SERIALIZER.register("arcanium_extractor", () -> new SimpleCookingSerializer<>(ArcaniumExtractorRecipe::new, 100));
        public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<InfusionTableRecipe>> INFUSION_TABLE_SERIALIZER = SERIALIZER.register("infusion_table", InfusionTableRecipe.Serializer::new);
    }
    public static class BrewingRecipes {
    	public static void init() {
    		//TODO - brewing recipes
//            addRecipe(new PotionOfWarmthRecipe());
//    		addRecipe(new PotionOfLongWarmthRecipe());
//    		addRecipe(new TeaRecipe());
//    		addRecipe(new GrogRecipe());
    	}
    }
}