package divinerpg.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.List;

import static divinerpg.DivineRPG.MODID;

public record InfusionTableRecipe(Item inputItem, int inputCount, Ingredient template, Item outputItem, int outputCount) implements Recipe<CraftingInput> {

    public static final RecipeType<InfusionTableRecipe> TYPE = RecipeType.simple(Identifier.fromNamespaceAndPath(MODID, "infusion_table"));

    @Override
    public boolean matches(CraftingInput inv, Level worldIn) {
        return inv.getItem(0).is(inputItem) && inv.getItem(0).getCount() >= inputCount && template.test(inv.getItem(1));
    }

    @Override
    public ItemStack assemble(CraftingInput craftingInput) {
        return new ItemStack(outputItem, outputCount);
    }

    public NonNullList<Ingredient> getTemplate() {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        ingredients.add(template);
        return ingredients;
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "infusion_table";
    }

    @Override
    public RecipeSerializer<? extends Recipe<CraftingInput>> getSerializer() {
        return (RecipeSerializer<? extends Recipe<CraftingInput>>) BuiltInRegistries.RECIPE_SERIALIZER.getValueOrThrow(ResourceKey.create(Registries.RECIPE_SERIALIZER, Identifier.fromNamespaceAndPath(MODID, "infusion_table")));
    }

    @Override
    public RecipeType<? extends Recipe<CraftingInput>> getType() {
        return TYPE;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(List.of(Ingredient.of(inputItem), template));
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public record ItemCount(Item item, int count) {}

    public static class Serializer {
        private static final Codec<ItemCount> ITEM_COUNT_CODEC = RecordCodecBuilder.create(instance -> instance.group(BuiltInRegistries.ITEM.byNameCodec().fieldOf("id").forGetter(ItemCount::item), Codec.INT.optionalFieldOf("count", 1).forGetter(ItemCount::count)).apply(instance, ItemCount::new));
        public static final MapCodec<InfusionTableRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(ITEM_COUNT_CODEC.fieldOf("input").forGetter(r -> new ItemCount(r.inputItem(), r.inputCount())), Ingredient.CODEC.fieldOf("template").forGetter(InfusionTableRecipe::template), ITEM_COUNT_CODEC.fieldOf("output").forGetter(r -> new ItemCount(r.outputItem(), r.outputCount()))).apply(instance, (input, template, output) -> new InfusionTableRecipe(input.item(), input.count(), template, output.item(), output.count())));
        public static final StreamCodec<RegistryFriendlyByteBuf, InfusionTableRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        public static final RecipeSerializer<InfusionTableRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

        public static void toNetwork(RegistryFriendlyByteBuf buffer, InfusionTableRecipe recipe) {
            ItemStack.STREAM_CODEC.encode(buffer, new ItemStack(recipe.inputItem, recipe.inputCount));
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.template);
            ItemStack.STREAM_CODEC.encode(buffer, new ItemStack(recipe.outputItem, recipe.outputCount));
        }

        public static InfusionTableRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            ItemStack input = ItemStack.STREAM_CODEC.decode(buffer);
            Ingredient template = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            ItemStack output = ItemStack.STREAM_CODEC.decode(buffer);
            return new InfusionTableRecipe(input.getItem(), input.getCount(), template, output.getItem(), output.getCount());
        }
    }
}