package divinerpg.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.*;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.*;
import net.minecraft.resources.*;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.List;

import static divinerpg.DivineRPG.MODID;

public record InfusionTableRecipe(Ingredient input, int inputCount, Ingredient template, ItemStackTemplate result) implements Recipe<CraftingInput> {
    public static final RecipeType<InfusionTableRecipe> TYPE = RecipeType.simple(Identifier.fromNamespaceAndPath(MODID, "infusion_table"));
    @Override public boolean matches(CraftingInput inv, Level worldIn) {
        return input.test(inv.getItem(0)) && inv.getItem(0).getCount() == inputCount && template.test(inv.getItem(1));
    }
    @Override public ItemStack assemble(CraftingInput craftingInput) {
        return result.create();
    }
    public NonNullList<Ingredient> getTemplate() {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        ingredients.add(template);
        return ingredients;
    }
    @Override public boolean showNotification() {
        return false;
    }
    @Override public String group() {
        return "infusion_table";
    }
    @Override public RecipeSerializer<? extends Recipe<CraftingInput>> getSerializer() {
        return (RecipeSerializer<? extends Recipe<CraftingInput>>) BuiltInRegistries.RECIPE_SERIALIZER.getValueOrThrow(ResourceKey.create(Registries.RECIPE_SERIALIZER, Identifier.fromNamespaceAndPath(MODID, "infusion_table")));
    }
    @Override public RecipeType<? extends Recipe<CraftingInput>> getType() {
        return TYPE;
    }
    @Override public PlacementInfo placementInfo() {
        return PlacementInfo.create(List.of(input, template));
    }
    @Override public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }
    public static class Serializer {
        public static final MapCodec<InfusionTableRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Ingredient.CODEC.fieldOf("ingredient").forGetter(InfusionTableRecipe::input),
            ExtraCodecs.POSITIVE_INT.optionalFieldOf("ingredient_count", 1).forGetter(InfusionTableRecipe::inputCount),
            Ingredient.CODEC.fieldOf("template").forGetter(InfusionTableRecipe::template),
            ItemStackTemplate.CODEC.fieldOf("result").forGetter(InfusionTableRecipe::result)
        ).apply(instance, InfusionTableRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, InfusionTableRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, InfusionTableRecipe::input,
            ByteBufCodecs.VAR_INT, InfusionTableRecipe::inputCount,
            Ingredient.CONTENTS_STREAM_CODEC, InfusionTableRecipe::template,
            ItemStackTemplate.STREAM_CODEC, InfusionTableRecipe::result,
            InfusionTableRecipe::new
        );
        public static final RecipeSerializer<InfusionTableRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);
    }
}