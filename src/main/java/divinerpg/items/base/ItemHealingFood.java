package divinerpg.items.base;

import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import javax.annotation.Nullable;
import java.util.List;

public class ItemHealingFood extends ItemModFood {
    private final int healthGain;
    public ItemHealingFood(FoodProperties food) {
        super(food);
        healthGain = food.getNutrition();
    }
    @Override public int getUseDuration(ItemStack stack) {return 16;}
    @Override public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if(entity.getHealth() < entity.getMaxHealth()) entity.heal(healthGain);
        return super.finishUsingItem(stack, world, entity);
    }
    @Override public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.food.heal", healthGain));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }
}