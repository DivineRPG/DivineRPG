package divinerpg.recipe;

import com.google.gson.*;
import divinerpg.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraftforge.common.crafting.*;
import net.minecraftforge.registries.*;

import javax.annotation.*;

public class InfusionTableRecipe implements IRecipe<IInventory> {
    public static final Serializer SERIALIZER = new Serializer();

    public    final ItemStack input;
    public    final ItemStack template;
    public    final ItemStack output;
    public    final int count;
    private   final ResourceLocation id;

    public InfusionTableRecipe(ResourceLocation id, ItemStack input, ItemStack template, ItemStack output, int count) {

        this.id = id;
        this.input = input;
        this.template = template;
        this.output = output;
        this.count = count;
    }


    @Override
    public boolean matches(IInventory inv, World worldIn){
        return ItemStack.isSame(input, inv.getItem(0)) && ItemStack.isSame(template, inv.getItem(1)) && inv.getItem(0).getCount() == count;
    }

    @Override
    public ItemStack assemble(IInventory inv){
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int p_194133_1_, int p_194133_2_) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return output.copy();
    }

    public NonNullList<Ingredient> getTemplate() {
        NonNullList<Ingredient> ingredients = NonNullList.create();
        ingredients.add(Ingredient.of(input));
        return ingredients;
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
        return InfusionTableRecipe.SERIALIZER;
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
                if (!json.has("count")) {
                    count = 1;
                } else {
                    count = JSONUtils.getAsInt(json, "count");
                }

            ItemStack input = CraftingHelper.getItemStack(JSONUtils.getAsJsonObject(json, "input"), false);
            ItemStack template = CraftingHelper.getItemStack(JSONUtils.getAsJsonObject(json, "template"), false);
            ItemStack output = CraftingHelper.getItemStack(JSONUtils.getAsJsonObject(json, "output"), false);


            return new InfusionTableRecipe(recipeId, new ItemStack(input.getItem(), count), template, output, input.getCount());
        }

        @Nullable
        @Override
        public InfusionTableRecipe fromNetwork(ResourceLocation resourceLocation, PacketBuffer buffer) {
            final ItemStack input = buffer.readItem();
            final ItemStack template = buffer.readItem();
            final ItemStack output = buffer.readItem();
            final int count = buffer.readByte();

            return new InfusionTableRecipe(resourceLocation, input, template, output, count);
        }

        @Override
        public void toNetwork(PacketBuffer buffer, InfusionTableRecipe recipe) {
            buffer.writeItem(recipe.input);
            buffer.writeItem(recipe.template);
            buffer.writeItem(recipe.output);
            buffer.writeByte(recipe.count);
        }
    }
}
