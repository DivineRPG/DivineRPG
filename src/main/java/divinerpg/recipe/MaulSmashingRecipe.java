package divinerpg.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.*;
import net.minecraft.resources.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

import static divinerpg.DivineRPG.MODID;
import static net.minecraft.core.registries.BuiltInRegistries.*;
import static net.minecraft.core.registries.Registries.BLOCK;

public record MaulSmashingRecipe(Ingredient input, ItemStackTemplate result, @Nullable TagKey<Block> requiredBaseBlockTag) implements Recipe<SingleRecipeInput> {
    public static final RecipeType<MaulSmashingRecipe> TYPE = RecipeType.simple(Identifier.fromNamespaceAndPath(MODID, "maul_smashing"));
    @Override public boolean matches(SingleRecipeInput input, Level level) {
        return this.input.test(input.getItem(0));
    }
    @Override public ItemStack assemble(SingleRecipeInput singleRecipeInput) {
        return result.create();
    }
    @Override public boolean showNotification() {
        return false;
    }
    @Override public String group() {
        return "maul_smashing";
    }
    @Override public RecipeSerializer<? extends Recipe<SingleRecipeInput>> getSerializer() {
        return (RecipeSerializer<? extends Recipe<SingleRecipeInput>>) RECIPE_SERIALIZER.getValueOrThrow(ResourceKey.create(Registries.RECIPE_SERIALIZER, Identifier.fromNamespaceAndPath(MODID, "maul_smashing")));
    }
    @Override public RecipeType<? extends Recipe<SingleRecipeInput>> getType() {
        return TYPE;
    }
    @Override public PlacementInfo placementInfo() {
        return PlacementInfo.create(input);
    }
    @Override public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }
    public static class Serializer {
        public static final MapCodec<MaulSmashingRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            Ingredient.CODEC.fieldOf("ingredient").forGetter(MaulSmashingRecipe::input),
            ItemStackTemplate.CODEC.fieldOf("result").forGetter(MaulSmashingRecipe::result),
            TagKey.hashedCodec(BLOCK).optionalFieldOf("required_base_block").forGetter(r -> Optional.ofNullable(r.requiredBaseBlockTag()))
        ).apply(instance, (input, result, baseOpt) -> new MaulSmashingRecipe(input, result, baseOpt.orElse(null))));
        public static final StreamCodec<RegistryFriendlyByteBuf, MaulSmashingRecipe> STREAM_CODEC = StreamCodec.composite(
            Ingredient.CONTENTS_STREAM_CODEC, MaulSmashingRecipe::input,
            ItemStackTemplate.STREAM_CODEC, MaulSmashingRecipe::result,
            ByteBufCodecs.optional(TagKey.streamCodec(BLOCK)), r -> Optional.ofNullable(r.requiredBaseBlockTag()),
            (input, result, baseOpt) -> new MaulSmashingRecipe(input, result, baseOpt.orElse(null))
        );
        public static final RecipeSerializer<MaulSmashingRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);
    }
}