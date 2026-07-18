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

public record PortalCreationRecipe(Ingredient lighter, RuleTest flame, RuleTest frame, BlockStateProvider portal, BlockStateProvider rift, Optional<Byte> timeOfDay) implements Recipe<RecipeInput> {
    public static final MapCodec<PortalCreationRecipe> CODEC = RecordCodecBuilder.mapCodec((instance) -> instance.group(
            Ingredient.CODEC.fieldOf("lighter").forGetter(PortalCreationRecipe::lighter),
            RuleTest.CODEC.fieldOf("flame").forGetter(PortalCreationRecipe::flame),
            RuleTest.CODEC.fieldOf("frame").forGetter(PortalCreationRecipe::frame),
            BlockStateProvider.CODEC.fieldOf("portal").forGetter(PortalCreationRecipe::portal),
            BlockStateProvider.CODEC.fieldOf("rift").forGetter(PortalCreationRecipe::rift),
            Codec.BYTE.optionalFieldOf("time_of_day").forGetter(PortalCreationRecipe::timeOfDay)
    ).apply(instance, PortalCreationRecipe::new));
    public static final RecipeType<PortalCreationRecipe> TYPE = RecipeType.simple(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "portal_creation"));
    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        return lighter.test(recipeInput.getItem(0));
    }
    @Override
    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }
    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }
    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }
    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeRegistry.Serializers.PORTAL_CREATION_SERIALIZER.get();
    }
    @Override
    public RecipeType<?> getType() {
        return RecipeRegistry.Types.PORTAL_CREATION.get();
    }
    public static class Serializer implements RecipeSerializer<PortalCreationRecipe> {
        public static final StreamCodec<RegistryFriendlyByteBuf, PortalCreationRecipe> STREAM_CODEC = StreamCodec.of(PortalCreationRecipe.Serializer::toNetwork, PortalCreationRecipe.Serializer::fromNetwork);
        public static PortalCreationRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            Ingredient lighter = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            RuleTest flame = buffer.readJsonWithCodec(RuleTest.CODEC);
            RuleTest frame = buffer.readJsonWithCodec(RuleTest.CODEC);
            BlockStateProvider portal = buffer.readJsonWithCodec(BlockStateProvider.CODEC);
            BlockStateProvider rift = buffer.readJsonWithCodec(BlockStateProvider.CODEC);
            Optional<Byte> timeOfDay = buffer.readBoolean() ? Optional.of(buffer.readByte()) : Optional.empty();
            return new PortalCreationRecipe(lighter, flame, frame, portal, rift, timeOfDay);
        }
        public static void toNetwork(RegistryFriendlyByteBuf buffer, PortalCreationRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.lighter);
            buffer.writeJsonWithCodec(RuleTest.CODEC, recipe.flame);
            buffer.writeJsonWithCodec(RuleTest.CODEC, recipe.frame);
            buffer.writeJsonWithCodec(BlockStateProvider.CODEC, recipe.portal);
            buffer.writeJsonWithCodec(BlockStateProvider.CODEC, recipe.rift);
            if(recipe.timeOfDay.isPresent()) {
                buffer.writeBoolean(true);
                buffer.writeByte(recipe.timeOfDay.get());
            } else buffer.writeBoolean(false);
        }
        @Override public MapCodec<PortalCreationRecipe> codec() {return CODEC;}
        @Override public StreamCodec<RegistryFriendlyByteBuf, PortalCreationRecipe> streamCodec() {return STREAM_CODEC;}
    }
}