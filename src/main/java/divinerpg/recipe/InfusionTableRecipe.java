package divinerpg.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import divinerpg.DivineRPG;
import divinerpg.registries.RecipeRegistry;
import net.minecraft.core.*;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public record InfusionTableRecipe(ItemStack input, Ingredient template, ItemStack output) implements Recipe<CraftingInput> {
    private static final MapCodec<InfusionTableRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
        ItemStack.CODEC.fieldOf("input").forGetter(table -> table.input),
        Ingredient.CODEC.fieldOf("template").forGetter(table -> table.template),
        ItemStack.CODEC.fieldOf("output").forGetter(table -> table.output)
    ).apply(instance, InfusionTableRecipe::new));
    public static final RecipeType<InfusionTableRecipe> TYPE = RecipeType.simple(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "infusion_table"));
    @Override
    public boolean matches(CraftingInput inv, Level worldIn) {
        return inv.getItem(0).is(input.getItem()) && template.test(inv.getItem(1)) && inv.getItem(0).getCount() == input.getCount();
    }
    @Override
    public ItemStack assemble(CraftingInput inv, Provider access) {
        return output.copy();
    }
    @Override
    public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
        return true;
    }
    @Override
    public ItemStack getResultItem(Provider access) {
        return output;
    }
    public NonNullList<Ingredient> getTemplate() {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        ingredients.add(Ingredient.of(input));
        return ingredients;
    }
    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeRegistry.Serializers.INFUSION_TABLE_SERIALIZER.get();
    }
    @Override
    public RecipeType<?> getType() {
        return RecipeRegistry.Types.INFUSION_TABLE_RECIPE_TYPE.get();
    }
    public static class Serializer implements RecipeSerializer<InfusionTableRecipe> {
        public static final StreamCodec<RegistryFriendlyByteBuf, InfusionTableRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        @Nullable
        public static InfusionTableRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            ItemStack input = ItemStack.STREAM_CODEC.decode(buffer);
            Ingredient template = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            ItemStack output = ItemStack.STREAM_CODEC.decode(buffer);
            return new InfusionTableRecipe(input, template, output);
        }
        public static void toNetwork(RegistryFriendlyByteBuf buffer, InfusionTableRecipe recipe) {
            ItemStack.STREAM_CODEC.encode(buffer, recipe.input);
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.template);
            ItemStack.STREAM_CODEC.encode(buffer, recipe.output);
        }
        @Override public MapCodec<InfusionTableRecipe> codec() {
            return CODEC;
        }
        @Override public StreamCodec<RegistryFriendlyByteBuf, InfusionTableRecipe> streamCodec() {return STREAM_CODEC;}
    }
}
