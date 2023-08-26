package divinerpg.items.base;

import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;
import java.util.*;

public class ItemModFood extends ItemMod {
    FoodProperties food;
    boolean fastFood;

    public ItemModFood(Properties properties, FoodProperties food) {
        super(properties);
        this.food = food;
    }

    public ItemModFood(FoodProperties food) {
        super(new Properties().food(food));
        this.food = food;
    }

    public ItemModFood(FoodProperties food, boolean fastFood) {
        super(new Item.Properties().food(food));
        this.food = food;
        this.fastFood = fastFood;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return fastFood ? 1 : super.getUseDuration(stack);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (fastFood) {
            tooltip.add(LocalizeUtils.instantConsumption());
        }
    }
}
