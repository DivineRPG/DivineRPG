package divinerpg.items.base;

import divinerpg.utils.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.level.Level;
import java.util.function.Consumer;

public class ItemHealingFood extends ItemModFood {
    protected int healAmount;
    public ItemHealingFood(FoodProperties food, Properties properties) {
        super(food, properties);
        healAmount = food.nutrition() * 2;
    }
    @Override public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if(entity.getHealth() < entity.getMaxHealth()) entity.heal(healAmount);
        return super.finishUsingItem(stack, world, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltip, Consumer<Component> builder, TooltipFlag flagIn) {
        builder.accept(LocalizeUtils.healthHeal(healAmount/2));
        super.appendHoverText(stack, context, tooltip, builder, flagIn);
    }
}