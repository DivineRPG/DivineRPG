package divinerpg.recipe;

import com.mojang.serialization.*;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.DivineRPG;
import divinerpg.registries.RecipeRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;

import java.util.Optional;

public record FireConversionRecipe(Ingredient inputItem, RuleTest inputState, Optional<ItemStack> outputItem, Optional<BlockStateProvider> outputState, Optional<ResourceLocation> advancement, Optional<String> advancementCriteria) implements Recipe<RecipeInput> {
    public static final MapCodec<FireConversionRecipe> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
        Ingredient.CODEC.fieldOf("input_item").forGetter(FireConversionRecipe::inputItem),
        RuleTest.CODEC.fieldOf("input_state").forGetter(FireConversionRecipe::inputState),
        ItemStack.OPTIONAL_CODEC.optionalFieldOf("output_item").forGetter(FireConversionRecipe::outputItem),
        BlockStateProvider.CODEC.optionalFieldOf("output_state").forGetter(FireConversionRecipe::outputState),
        ResourceLocation.CODEC.optionalFieldOf("advancement").forGetter(FireConversionRecipe::advancement),
        Codec.STRING.optionalFieldOf("advancement_criteria").forGetter(FireConversionRecipe::advancementCriteria)
    ).apply(instance, FireConversionRecipe::new));
    public static final RecipeType<FireConversionRecipe> TYPE = RecipeType.simple(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "maul_smashing"));
    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        return inputItem.test(recipeInput.getItem(0));
    }
    @Override
    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return outputItem.orElse(ItemStack.EMPTY).copy();
    }
    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }
    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return outputItem.orElse(ItemStack.EMPTY).copy();
    }
    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeRegistry.Serializers.FIRE_CONVERSION_SERIALIZER.get();
    }
    @Override
    public RecipeType<?> getType() {
        return RecipeRegistry.Types.FIRE_CONVERSION.get();
    }
    public static class Serializer implements RecipeSerializer<FireConversionRecipe> {
        public static final StreamCodec<RegistryFriendlyByteBuf, FireConversionRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        public static FireConversionRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            Ingredient inputItem = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            RuleTest inputState = buffer.readJsonWithCodec(RuleTest.CODEC);
            ItemStack outputItem = ItemStack.OPTIONAL_STREAM_CODEC.decode(buffer);
            Optional<BlockStateProvider> outputState = buffer.readBoolean() ? Optional.of(buffer.readJsonWithCodec(BlockStateProvider.CODEC)) : Optional.empty();
            Optional<ResourceLocation> advancement = buffer.readBoolean() ? Optional.of(buffer.readResourceLocation()) : Optional.empty();
            Optional<String> advancementCriteria = buffer.readBoolean() ? Optional.of(buffer.readUtf()) : Optional.empty();
            return new FireConversionRecipe(inputItem, inputState, Optional.of(outputItem), outputState, advancement, advancementCriteria);
        }
        public static void toNetwork(RegistryFriendlyByteBuf buffer, FireConversionRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.inputItem);
            buffer.writeJsonWithCodec(RuleTest.CODEC, recipe.inputState);
            ItemStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.outputItem.orElse(ItemStack.EMPTY));
            if(recipe.outputState.isPresent()) {
                buffer.writeBoolean(true);
                buffer.writeJsonWithCodec(BlockStateProvider.CODEC, recipe.outputState.get());
            } else buffer.writeBoolean(false);
            if(recipe.advancement.isPresent()) {
                buffer.writeBoolean(true);
                buffer.writeResourceLocation(recipe.advancement.get());
            } else buffer.writeBoolean(false);
            if(recipe.advancementCriteria.isPresent()) {
                buffer.writeBoolean(true);
                buffer.writeUtf(recipe.advancementCriteria.get());
            } else buffer.writeBoolean(false);
        }
        @Override public MapCodec<FireConversionRecipe> codec() {return CODEC;}
        @Override public StreamCodec<RegistryFriendlyByteBuf, FireConversionRecipe> streamCodec() {return STREAM_CODEC;}
    }
}
