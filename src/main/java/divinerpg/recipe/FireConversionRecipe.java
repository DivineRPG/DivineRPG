package divinerpg.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.DivineRPG;
import divinerpg.registries.RecipeRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.Optional;

import static divinerpg.DivineRPG.MODID;

public record FireConversionRecipe(Ingredient inputItem, RuleTest inputState, Optional<ItemStack> outputItem, Optional<BlockStateProvider> outputState, Optional<Identifier> advancement, Optional<String> advancementCriteria, Optional<RuleTest> frame, Optional<BlockStateProvider> portal) implements Recipe<RecipeInput> {

    public static final RecipeType<FireConversionRecipe> TYPE = RecipeType.simple(Identifier.fromNamespaceAndPath(MODID, "fire_conversion"));

    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        return inputItem.test(recipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(RecipeInput recipeInput) {
        return outputItem.orElse(ItemStack.EMPTY).copy();
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "fire_conversion";
    }

    @Override
    public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
        return (RecipeSerializer<? extends Recipe<RecipeInput>>) BuiltInRegistries.RECIPE_SERIALIZER.getValueOrThrow(
                ResourceKey.create(Registries.RECIPE_SERIALIZER, Identifier.fromNamespaceAndPath(MODID, "fire_conversion"))
        );
    }

    @Override
    public RecipeType<? extends Recipe<RecipeInput>> getType() {
        return TYPE;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer {
        public static final MapCodec<FireConversionRecipe> MAP_CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Ingredient.CODEC.fieldOf("input_item").forGetter(FireConversionRecipe::inputItem), RuleTest.CODEC.fieldOf("input_state").forGetter(FireConversionRecipe::inputState), ItemStack.OPTIONAL_CODEC.optionalFieldOf("output_item").forGetter(FireConversionRecipe::outputItem), BlockStateProvider.CODEC.optionalFieldOf("output_state").forGetter(FireConversionRecipe::outputState), Identifier.CODEC.optionalFieldOf("advancement").forGetter(FireConversionRecipe::advancement), Codec.STRING.optionalFieldOf("advancement_criteria").forGetter(FireConversionRecipe::advancementCriteria), RuleTest.CODEC.optionalFieldOf("frame").forGetter(FireConversionRecipe::frame), BlockStateProvider.CODEC.optionalFieldOf("portal").forGetter(FireConversionRecipe::portal)).apply(instance, FireConversionRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, FireConversionRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        public static final RecipeSerializer<FireConversionRecipe> SERIALIZER = new RecipeSerializer<>(MAP_CODEC, STREAM_CODEC);

        public static void toNetwork(RegistryFriendlyByteBuf buffer, FireConversionRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.inputItem());
            buffer.writeJsonWithCodec(RuleTest.CODEC, recipe.inputState());
            ItemStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.outputItem().orElse(ItemStack.EMPTY));
            buffer.writeBoolean(recipe.outputState().isPresent());
            recipe.outputState().ifPresent(state -> buffer.writeJsonWithCodec(BlockStateProvider.CODEC, state));
            buffer.writeBoolean(recipe.advancement().isPresent());
            recipe.advancement().ifPresent(buffer::writeIdentifier);
            buffer.writeBoolean(recipe.advancementCriteria().isPresent());
            recipe.advancementCriteria().ifPresent(buffer::writeUtf);
            buffer.writeBoolean(recipe.frame().isPresent());
            recipe.frame().ifPresent(frame -> buffer.writeJsonWithCodec(RuleTest.CODEC, frame));
            buffer.writeBoolean(recipe.portal().isPresent());
            recipe.portal().ifPresent(portal -> buffer.writeJsonWithCodec(BlockStateProvider.CODEC, portal));
        }

        public static FireConversionRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            Ingredient inputItem = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            RuleTest inputState = buffer.readLenientJsonWithCodec(RuleTest.CODEC);
            ItemStack outputItem = ItemStack.OPTIONAL_STREAM_CODEC.decode(buffer);
            Optional<BlockStateProvider> outputState = buffer.readBoolean() ? Optional.of(buffer.readLenientJsonWithCodec(BlockStateProvider.CODEC)) : Optional.empty();
            Optional<Identifier> advancement = buffer.readBoolean() ? Optional.of(buffer.readIdentifier()) : Optional.empty();
            Optional<String> advancementCriteria = buffer.readBoolean() ? Optional.of(buffer.readUtf()) : Optional.empty();
            Optional<RuleTest> frame = buffer.readBoolean() ? Optional.of(buffer.readLenientJsonWithCodec(RuleTest.CODEC)) : Optional.empty();
            Optional<BlockStateProvider> portal = buffer.readBoolean() ? Optional.of(buffer.readLenientJsonWithCodec(BlockStateProvider.CODEC)) : Optional.empty();
            return new FireConversionRecipe(inputItem, inputState, Optional.of(outputItem), outputState, advancement, advancementCriteria, frame, portal);
        }
    }
}