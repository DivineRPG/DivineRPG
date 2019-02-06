package naturix.divinerpg.utils.block;

import com.google.common.collect.Maps;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by LiteWolf101 on Jan
 * /31/2019
 */
public class CoalstoneFurnaceRecipes {
    private static final CoalstoneFurnaceRecipes INSTANCE = new CoalstoneFurnaceRecipes();
    private final Map<ItemStack, ItemStack> smeltingList = Maps.<ItemStack, ItemStack>newHashMap();
    private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();

    public static CoalstoneFurnaceRecipes getInstance() {
        return INSTANCE;
    }

    private CoalstoneFurnaceRecipes(){
        addCoalstoneFurnaceRecipe(new ItemStack(Blocks.COBBLESTONE),new ItemStack(Blocks.STONE), 2.8F);
    }

    public void addCoalstoneFurnaceRecipe(ItemStack input, ItemStack output, float exp){
        if (getResult(input) != ItemStack.EMPTY) {
            return;
        }
        this.smeltingList.put(input, output);
        this.experienceList.put(output, Float.valueOf(exp));
    }

    public ItemStack getResult(ItemStack stack) {
        for (Entry<ItemStack, ItemStack> entry : this.smeltingList.entrySet())
        {
            if (this.compareItemStacks(stack, entry.getKey()))
            {
                return entry.getValue();
            }
        }

        return ItemStack.EMPTY;
    }

    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());    }

    public Map<ItemStack, ItemStack> getSmeltingList()
    {
        return this.smeltingList;
    }

    public float getSmeltingExperience(ItemStack stack)
    {
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;

        for (Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if (this.compareItemStacks(stack, entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }

        return 0.0F;
    }
}
