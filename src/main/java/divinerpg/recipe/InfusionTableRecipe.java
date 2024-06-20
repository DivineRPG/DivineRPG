package divinerpg.recipe;

import com.google.gson.*;
import divinerpg.registries.RecipeRegistry;
import net.minecraft.core.*;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class InfusionTableRecipe implements Recipe<Container> {
    public final ItemStack input, template, output;
    public final int count;
    private final ResourceLocation id;
    public InfusionTableRecipe(ResourceLocation id, ItemStack input, ItemStack template, ItemStack output, int count) {
        this.id = id;
        this.input = input;
        this.template = template;
        this.output = output;
        this.count = count;
    }
    @Override
    public boolean matches(Container inv, Level worldIn){
        return ItemStack.isSameItem(input, inv.getItem(0)) && ItemStack.isSameItem(template, inv.getItem(1)) && inv.getItem(0).getCount() == count;
    }
    public int getCount() {
        return count;
    }
    @Override
    public ItemStack assemble(Container inv, RegistryAccess access) {
        return output.copy();
    }
    @Override
    public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
        return true;
    }
    @Override
    public ItemStack getResultItem(RegistryAccess access) {
        return output;
    }
    public NonNullList<Ingredient> getTemplate() {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        ingredients.add(Ingredient.of(input));
        return ingredients;
    }
    @Override
    public ResourceLocation getId() {
        return id;
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
        int count = 1;
        @Override
        public InfusionTableRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            ItemStack inputItem;
            if(json.get("input").isJsonObject()) inputItem = ShapedRecipe.itemStackFromJson(json.getAsJsonObject("input"));
            else {
                ResourceLocation id = new ResourceLocation(GsonHelper.getAsString(json, "input"));
                Item item = ForgeRegistries.ITEMS.getValue(id);
                if(item == null) throw new JsonSyntaxException("Unknown item '" + id + "'");
	            if(!json.has("count")) count = 1;
	            else count = GsonHelper.getAsInt(json, "count");
                inputItem = new ItemStack(item, count);
            }
            ItemStack template = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "template"), false);
            ItemStack output = CraftingHelper.getItemStack(GsonHelper.getAsJsonObject(json, "output"), false);
            return new InfusionTableRecipe(recipeId, inputItem, template, output, inputItem.getCount());
        }
        @Nullable @Override
        public InfusionTableRecipe fromNetwork(ResourceLocation resourceLocation, FriendlyByteBuf buffer) {
            final ItemStack input = buffer.readItem();
            final ItemStack template = buffer.readItem();
            final ItemStack output = buffer.readItem();
            final int count = buffer.readInt();
            return new InfusionTableRecipe(resourceLocation, input, template, output, count);
        }
        @Override
        public void toNetwork(FriendlyByteBuf buffer, InfusionTableRecipe recipe) {
            buffer.writeItem(recipe.input);
            buffer.writeItem(recipe.template);
            buffer.writeItem(recipe.output);
            buffer.writeInt(recipe.count);
        }
    }
}
