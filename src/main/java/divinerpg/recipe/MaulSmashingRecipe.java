package divinerpg.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import javax.annotation.Nullable;
import java.util.Optional;

import static divinerpg.DivineRPG.MODID;
import static divinerpg.registries.RecipeRegistry.Serializers.MAUL_SMASHING_SERIALIZER;
import static divinerpg.registries.RecipeRegistry.Types.MAUL_SMASHING;
import static net.minecraft.core.registries.Registries.BLOCK;

public record MaulSmashingRecipe(Ingredient input, ItemStack output, @Nullable TagKey<Block> requiredBaseBlockTag) implements Recipe<RecipeInput> {
    public static final RecipeType<MaulSmashingRecipe> TYPE = RecipeType.simple(ResourceLocation.fromNamespaceAndPath(MODID, "maul_smashing"));
    public boolean matches(ItemStack stack) {return input.test(stack);}
    public ItemStack getResult() {return output.copy();}
    @Override public boolean matches(RecipeInput container, Level level) {return input.test(container.getItem(0));}
    @Override public ItemStack assemble(RecipeInput container, HolderLookup.Provider provider) {return output.copy();}
    @Override public boolean canCraftInDimensions(int width, int height) {return true;}
    @Override public ItemStack getResultItem(HolderLookup.Provider provider) {return output.copy();}
    @Override public RecipeSerializer<?> getSerializer() {return MAUL_SMASHING_SERIALIZER.get();}
    @Override public RecipeType<?> getType() {return MAUL_SMASHING.get();}
    public static class Serializer implements RecipeSerializer<MaulSmashingRecipe> {
        private static final MapCodec<MaulSmashingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("input").forGetter(MaulSmashingRecipe::input),
                ItemStack.CODEC.fieldOf("output").forGetter(MaulSmashingRecipe::output),
                TagKey.hashedCodec(BLOCK)
                        .optionalFieldOf("required_base_block")
                        .forGetter(r -> Optional.ofNullable(r.requiredBaseBlockTag()))
        ).apply(instance, (input, output, baseOpt) -> new MaulSmashingRecipe(input, output, baseOpt.orElse(null))));
        public static final StreamCodec<RegistryFriendlyByteBuf, MaulSmashingRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        public static void toNetwork(RegistryFriendlyByteBuf buffer, MaulSmashingRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.input);
            ItemStack.STREAM_CODEC.encode(buffer, recipe.output);
            if(recipe.requiredBaseBlockTag != null) {
                buffer.writeBoolean(true);
                buffer.writeResourceLocation(recipe.requiredBaseBlockTag.location());
            } else buffer.writeBoolean(false);
        }
        @Nullable
        public static MaulSmashingRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            Ingredient input = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            ItemStack output = ItemStack.STREAM_CODEC.decode(buffer);
            TagKey<Block> tag = null;
            if(buffer.readBoolean()) {
                ResourceLocation tagId = buffer.readResourceLocation();
                tag = TagKey.create(BLOCK, tagId);
            } return new MaulSmashingRecipe(input, output, tag);
        }
        @Override public MapCodec<MaulSmashingRecipe> codec() {return CODEC;}
        @Override public StreamCodec<RegistryFriendlyByteBuf, MaulSmashingRecipe> streamCodec() {return STREAM_CODEC;}
    }
}