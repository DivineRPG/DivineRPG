package divinerpg.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.registries.RecipeRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

import static divinerpg.DivineRPG.MODID;
import static net.minecraft.core.registries.Registries.BLOCK;

public record MaulSmashingRecipe(
        Ingredient input,
        Item outputItem,
        int outputCount,
        @Nullable TagKey<Block> requiredBaseBlockTag
) implements Recipe<SingleRecipeInput> {

    public static final RecipeType<MaulSmashingRecipe> TYPE = RecipeType.simple(
            Identifier.fromNamespaceAndPath(MODID, "maul_smashing")
    );

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        return this.input.test(input.getItem(0));
    }

    @Override
    public ItemStack assemble(SingleRecipeInput singleRecipeInput) {
        return new ItemStack(outputItem, outputCount);
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "maul_smashing";
    }

    @Override
    public RecipeSerializer<? extends Recipe<SingleRecipeInput>> getSerializer() {
        return (RecipeSerializer<? extends Recipe<SingleRecipeInput>>) BuiltInRegistries.RECIPE_SERIALIZER.getValueOrThrow(ResourceKey.create(Registries.RECIPE_SERIALIZER, Identifier.fromNamespaceAndPath(MODID, "maul_smashing")));
    }

    @Override
    public RecipeType<? extends Recipe<SingleRecipeInput>> getType() {
        return TYPE;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(input);
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer {
        public static final MapCodec<MaulSmashingRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("input").forGetter(MaulSmashingRecipe::input),
                BuiltInRegistries.ITEM.byNameCodec().fieldOf("result").forGetter(MaulSmashingRecipe::outputItem),
                Codec.INT.optionalFieldOf("count", 1).forGetter(MaulSmashingRecipe::outputCount),
                TagKey.hashedCodec(BLOCK)
                        .optionalFieldOf("required_base_block")
                        .forGetter(r -> Optional.ofNullable(r.requiredBaseBlockTag()))
        ).apply(instance, (input, item, count, baseOpt) -> new MaulSmashingRecipe(input, item, count, baseOpt.orElse(null))));

        public static final StreamCodec<RegistryFriendlyByteBuf, MaulSmashingRecipe> STREAM_CODEC = StreamCodec.of(
                Serializer::toNetwork,
                Serializer::fromNetwork
        );

        public static final RecipeSerializer<MaulSmashingRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

        public static void toNetwork(RegistryFriendlyByteBuf buffer, MaulSmashingRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.input);
            ItemStack.STREAM_CODEC.encode(buffer, new ItemStack(recipe.outputItem, recipe.outputCount));
            if (recipe.requiredBaseBlockTag != null) {
                buffer.writeBoolean(true);
                buffer.writeIdentifier(recipe.requiredBaseBlockTag.location());
            } else {
                buffer.writeBoolean(false);
            }
        }

        public static MaulSmashingRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            Ingredient input = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            ItemStack output = ItemStack.STREAM_CODEC.decode(buffer);
            TagKey<Block> tag = null;
            if (buffer.readBoolean()) {
                Identifier tagId = buffer.readIdentifier();
                tag = TagKey.create(BLOCK, tagId);
            }
            return new MaulSmashingRecipe(input, output.getItem(), output.getCount(), tag);
        }
    }
}