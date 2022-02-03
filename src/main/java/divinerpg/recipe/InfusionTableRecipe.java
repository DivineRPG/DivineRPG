package divinerpg.recipe;

import com.google.gson.*;
import divinerpg.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.registries.*;

import javax.annotation.*;

public class InfusionTableRecipe implements IRecipe<IInventory> {
    public static final Serializer SERIALIZER = new Serializer();

    public    final Ingredient input;
    public    final Ingredient template;
    public    final ItemStack output;
    public    final int count;
    private   final ResourceLocation id;

    public InfusionTableRecipe(ResourceLocation id, Ingredient input, Ingredient template, ItemStack output, int count) {

        this.id = id;
        this.input = input;
        this.template = template;
        this.output = output;
        this.count = count;
    }


    @Override
    public boolean matches(IInventory inv, World worldIn){
        ItemStack stack = inv.getItem(0);
        return input.test(stack) && template.test(inv.getItem(1)) && inv.getItem(0).getCount() >= this.count;
    }

    @Override
    public ItemStack assemble(IInventory inv){
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return this.output;
    }

    public NonNullList<Ingredient> getTemplate() {
        return NonNullList.of(this.template);
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public IRecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public IRecipeType<?> getType() {
        return DivineRPG.INFUSION_TABLE_RECIPE;
    }


    private static class Serializer extends ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<InfusionTableRecipe> {

        Serializer() {
            this.setRegistryName(new ResourceLocation(DivineRPG.MODID, "infusion_table"));
        }

        int count = 1;
        @Override
        public InfusionTableRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            ItemStack input;
            if (json.get("input").isJsonObject()) {
                input = ShapedRecipe.itemFromJson(json.getAsJsonObject("input"));
            } else {
                ResourceLocation id = new ResourceLocation(JSONUtils.getAsString(json, "input"));
                Item item = ForgeRegistries.ITEMS.getValue(id);
                if (item == null) {
                    throw new JsonSyntaxException("Unknown item '" + id + "'");
                }
                if (!json.has("count")) {
                    count = 1;
                } else {
                    count = JSONUtils.getAsInt(json, "count");
                }
                input = new ItemStack(item, count);
            }


            final JsonElement templateElement = JSONUtils.isArrayNode(json, "template") ? JSONUtils.getAsJsonArray(json, "template") : JSONUtils.getAsJsonObject(json, "template");
            final Ingredient template = Ingredient.fromJson(templateElement);

            final ItemStack output = ShapedRecipe.itemFromJson(JSONUtils.getAsJsonObject(json, "output"));

            return new InfusionTableRecipe(recipeId, Ingredient.of(input), template, output, input.getCount());
        }

        @Nullable
        @Override
        public InfusionTableRecipe fromNetwork(ResourceLocation resourceLocation, PacketBuffer buffer) {
            final Ingredient input = Ingredient.fromNetwork(buffer);
            final Ingredient template = Ingredient.fromNetwork(buffer);
            final ItemStack output = buffer.readItem();
            final int count = buffer.readByte();

            return new InfusionTableRecipe(resourceLocation, input, template, output, count);
        }

        @Override
        public void toNetwork(PacketBuffer buffer, InfusionTableRecipe recipe) {
            recipe.input.toNetwork(buffer);
            recipe.template.toNetwork(buffer);
            buffer.writeItem(recipe.output);
            buffer.writeByte(recipe.count);
        }
    }
}
