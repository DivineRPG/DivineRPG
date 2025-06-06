package divinerpg.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import divinerpg.DivineRPG;
import divinerpg.registries.RecipeRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
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

public class MaulSmashingRecipe implements Recipe<RecipeInput> {
    public static final RecipeType<MaulSmashingRecipe> TYPE = RecipeType.simple(
            ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "maul_smashing"));

    private final Ingredient input;
    private final ItemStack output;
    @Nullable
    private final TagKey<Block> requiredBaseBlockTag;

    public MaulSmashingRecipe(Ingredient input, ItemStack output, @Nullable TagKey<Block> requiredBaseBlockTag) {
        this.input = input;
        this.output = output;
        this.requiredBaseBlockTag = requiredBaseBlockTag;
    }

    public boolean matches(ItemStack stack) {
        return input.test(stack);
    }

    public ItemStack getResult() {
        return output.copy();
    }

    @Override
    public boolean matches(RecipeInput container, Level level) {
        return input.test(container.getItem(0));
    }

    @Override
    public ItemStack assemble(RecipeInput container, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeRegistry.Serailizers.MAUL_SMASHING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return RecipeRegistry.Types.MAUL_SMASHING.get();
    }

    public Ingredient getInput() {
        return input;
    }

    public ItemStack getOutput() {
        return output;
    }

    @Nullable
    public TagKey<Block> getRequiredBaseBlockTag() {
        return requiredBaseBlockTag;
    }

    public static class Serializer implements RecipeSerializer<MaulSmashingRecipe> {
        private static final MapCodec<MaulSmashingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("input").forGetter(MaulSmashingRecipe::getInput),
                ItemStack.CODEC.fieldOf("output").forGetter(MaulSmashingRecipe::getOutput),
                TagKey.hashedCodec(Registries.BLOCK)
                        .optionalFieldOf("required_base_block")
                        .forGetter(r -> Optional.ofNullable(r.getRequiredBaseBlockTag()))
        ).apply(instance, (input, output, baseOpt) -> new MaulSmashingRecipe(input, output, baseOpt.orElse(null))));

        public static final StreamCodec<RegistryFriendlyByteBuf, MaulSmashingRecipe> STREAM_CODEC = StreamCodec.of(
                Serializer::toNetwork, Serializer::fromNetwork
        );

        public static void toNetwork(RegistryFriendlyByteBuf buffer, MaulSmashingRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.input);
            ItemStack.STREAM_CODEC.encode(buffer, recipe.output);

            if (recipe.requiredBaseBlockTag != null) {
                buffer.writeBoolean(true);
                buffer.writeResourceLocation(recipe.requiredBaseBlockTag.location());
            } else {
                buffer.writeBoolean(false);
            }
        }

        @Nullable
        public static MaulSmashingRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            Ingredient input = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            ItemStack output = ItemStack.STREAM_CODEC.decode(buffer);

            TagKey<Block> tag = null;
            if (buffer.readBoolean()) {
                ResourceLocation tagId = buffer.readResourceLocation();
                tag = TagKey.create(Registries.BLOCK, tagId);
            }

            return new MaulSmashingRecipe(input, output, tag);
        }

        @Override
        public MapCodec<MaulSmashingRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, MaulSmashingRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
