package divinerpg.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import divinerpg.registries.RecipeRegistry;
import net.minecraft.core.*;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public class InfusionTableRecipe implements Recipe<CraftingInput> {
    public final ItemStack input, template, output;
//    public final int count;
    public InfusionTableRecipe(ItemStack input, ItemStack template, ItemStack output) {
        this.input = input;
        this.template = template;
        this.output = output;
    }
    @Override
    public boolean matches(CraftingInput inv, Level worldIn){
        return ItemStack.isSameItem(input, inv.getItem(0)) && ItemStack.isSameItem(template, inv.getItem(1)) && inv.getItem(0).getCount() == input.getCount();
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
        return RecipeRegistry.Serailizers.INFUSION_TABLE_SERIALIZER.get();
    }
    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }
    public static class Type implements RecipeType<InfusionTableRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "infusion_table";
    }
    public static class Serializer implements RecipeSerializer<InfusionTableRecipe> {
    	private static final MapCodec<InfusionTableRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
    		ItemStack.STRICT_CODEC.fieldOf("input").forGetter(table -> table.input),
    		ItemStack.STRICT_CODEC.fieldOf("template").forGetter(table -> table.template),
    		ItemStack.STRICT_CODEC.fieldOf("output").forGetter(table -> table.output)
		).apply(instance, InfusionTableRecipe::new));
    	public static final StreamCodec<RegistryFriendlyByteBuf, InfusionTableRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);
        int count = 1;
//        @Override
//        public InfusionTableRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
//            ItemStack inputItem;
//            if(json.get("input").isJsonObject()) inputItem = ShapedRecipe.itemStackFromJson(json.getAsJsonObject("input"));
//            else {
//                ResourceLocation id = ResourceLocation.parse(GsonHelper.getAsString(json, "input"));
//                Item item = BuiltInRegistries.ITEM.get(id);
//                if(item == null) throw new JsonSyntaxException("Unknown item '" + id + "'");
//	            if(!json.has("count")) count = 1;
//	            else count = GsonHelper.getAsInt(json, "count");
//                inputItem = new ItemStack(item, count);
//            }
//            ItemStack template = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "template"), false);
//            ItemStack output = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "output"), false);
//            return new InfusionTableRecipe(recipeId, inputItem, template, output, inputItem.getCount());
//        }
        @Nullable
        public static  InfusionTableRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
        	ItemStack input = ItemStack.STREAM_CODEC.decode(buffer);
        	ItemStack template = ItemStack.STREAM_CODEC.decode(buffer);
        	ItemStack output = ItemStack.STREAM_CODEC.decode(buffer);
            return new InfusionTableRecipe(input, template, output);
        }
       
        public static void toNetwork(RegistryFriendlyByteBuf buffer, InfusionTableRecipe recipe) {
        	ItemStack.STREAM_CODEC.encode(buffer, recipe.input);
        	ItemStack.STREAM_CODEC.encode(buffer, recipe.template);
        	ItemStack.STREAM_CODEC.encode(buffer, recipe.output);
        }
		@Override
		public MapCodec<InfusionTableRecipe> codec() {
			return CODEC;
		}
		@Override
		public StreamCodec<RegistryFriendlyByteBuf, InfusionTableRecipe> streamCodec() {
			return STREAM_CODEC;
		}
    }
}
