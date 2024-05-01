package divinerpg.items.base;

import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.*;
import javax.annotation.Nullable;
import java.util.List;

public class ItemModFood extends ItemMod {
    FoodProperties food;
    boolean fastFood;
    public ItemModFood(Properties properties) {super(properties);}
    public ItemModFood(FoodProperties food) {
        super(new Properties().food(food));
        this.food = food;
    }
    public ItemModFood(FoodProperties food, boolean fastFood) {
        super(new Properties().food(food));
        this.food = food;
        this.fastFood = fastFood;
    }
    @Override public int getUseDuration(ItemStack stack) {return fastFood ? 1 : super.getUseDuration(stack);}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flagIn) {
        if(fastFood) tooltip.add(LocalizeUtils.instantConsumption());
        super.appendHoverText(stack, level, tooltip, flagIn);
    }
}