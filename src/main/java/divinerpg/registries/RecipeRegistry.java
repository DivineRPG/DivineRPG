package divinerpg.registries;

import divinerpg.recipe.*;
import divinerpg.recipe.brewing.*;
import net.minecraft.core.registries.*;
import net.minecraft.world.item.crafting.*;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;
import net.neoforged.neoforge.registries.*;

import static divinerpg.DivineRPG.MODID;

public class RecipeRegistry {
    public static class Types {
        public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, MODID);

        public static final DeferredHolder<RecipeType<?>, RecipeType<? extends AbstractCookingRecipe>> ARCANIUM_EXTRACTOR_RECIPE_TYPE = RECIPE_TYPES.register("arcanium_extractor", () -> ArcaniumExtractorRecipe.Type.INSTANCE);
        public static final DeferredHolder<RecipeType<?>, RecipeType<?>> INFUSIION_TABLE_RECIPE_TYPE = RECIPE_TYPES.register("infusion_table", () -> InfusionTableRecipe.Type.INSTANCE);
        public static final DeferredHolder<RecipeType<?>, RecipeType<?>> MAUL_SMASHING = RECIPE_TYPES.register("maul_smashing", () -> MaulSmashingRecipe.TYPE);
    }
    public static class Serailizers {
        public static final DeferredRegister<RecipeSerializer<?>> SERIALIZER = DeferredRegister.create(Registries.RECIPE_SERIALIZER, MODID);
        public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ArcaniumExtractorRecipe>> ARCANIUM_EXTRACTOR_SERIALIZER = SERIALIZER.register("arcanium_extractor", () -> new SimpleCookingSerializer<>(ArcaniumExtractorRecipe::new, 100));
        public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<InfusionTableRecipe>> INFUSION_TABLE_SERIALIZER = SERIALIZER.register("infusion_table", InfusionTableRecipe.Serializer::new);
        public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<MaulSmashingRecipe>> MAUL_SMASHING_SERIALIZER = SERIALIZER.register("maul_smashing", MaulSmashingRecipe.Serializer::new);
    }
    @SubscribeEvent
    public void registerBrewingRecipes(RegisterBrewingRecipesEvent e) {
        e.getBuilder().addRecipe(new PotionOfWarmthRecipe());
        e.getBuilder().addRecipe(new PotionOfLongWarmthRecipe());
        e.getBuilder().addRecipe(new TeaRecipe());
        e.getBuilder().addRecipe(new GrogRecipe());
    }
}