package net.divinerpg.items.base;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class ItemModFood extends ItemMod {
    protected boolean fastFood;
    public ItemModFood(FoodProperties food, Properties properties) {
        super(properties.food(food));
    }

    public ItemModFood(FoodProperties food) {
        this(food, new Properties());
    }

    public ItemModFood(boolean stacksToOne, FoodProperties food, Properties properties) {
        this(food, properties.stacksTo(stacksToOne ? 1 : 16));
    }

    public ItemModFood(boolean stacksToOne, Item craftRemainder, FoodProperties food, Properties properties) {
        this(food, properties.craftRemainder(craftRemainder).stacksTo(stacksToOne ? 1 : 16));
    }

    public ItemModFood(FoodProperties food, boolean instantConsumption, Properties properties) {
        this(food, properties);
        this.fastFood = instantConsumption;
    }

    public ItemModFood(boolean stacksToOne, FoodProperties food, boolean instantConsumption, Properties properties) {
        this(food, properties.stacksTo(stacksToOne ? 1 : 16));
        this.fastFood = instantConsumption;
    }
    @Override public int getUseDuration(ItemStack stack, LivingEntity entity) {return fastFood ? 1 : super.getUseDuration(stack, entity);}

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        //TODO - insta eat tooltip
//        if(fastFood) tooltip.add(LocalizeUtils.instantConsumption());
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
    }
}