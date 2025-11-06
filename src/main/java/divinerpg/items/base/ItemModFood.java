package divinerpg.items.base;

import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

import static net.neoforged.api.distmarker.Dist.CLIENT;

public class ItemModFood extends ItemMod {
    protected boolean fastFood;
    //Base constructor
    public ItemModFood(Properties properties, FoodProperties food) {super(properties.food(food));}
    //Stacks to 64
    public ItemModFood(FoodProperties food) {this(new Properties(), food);}
    //Stacks to 1 or 16
    public ItemModFood(boolean stacksToOne, FoodProperties food) {
        this(new Properties().stacksTo(stacksToOne ? 1 : 16), food);
    }
    //Stacks to 1 or 16, custom craft remainder
    public ItemModFood(boolean stacksToOne, Item craftRemainder, FoodProperties food) {
        this(new Properties().craftRemainder(craftRemainder).stacksTo(stacksToOne ? 1 : 16), food);
    }
    //Stacks to 64, instant consumption
    public ItemModFood(FoodProperties food, boolean instantConsumption) {
        this(new Properties(), food);
        fastFood = instantConsumption;
    }
    //Stacks to 1 or 16, instant consumption
    public ItemModFood(boolean stacksToOne, FoodProperties food, boolean instantConsumption) {
        this(new Properties().stacksTo(stacksToOne ? 1 : 16), food);
        fastFood = instantConsumption;
    }
    @Override public int getUseDuration(ItemStack stack, LivingEntity entity) {return fastFood ? 1 : super.getUseDuration(stack, entity);}
    @OnlyIn(CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        if(fastFood) tooltip.add(LocalizeUtils.instantConsumption());
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}