package divinerpg.items.base;

import divinerpg.util.LocalizeUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.*;
import java.util.List;

public class ItemHealingFood extends ItemModFood {
	int healAmount;
    public ItemHealingFood(FoodProperties food) {
        super(food);
        healAmount = food.nutrition();
    }
    @Override public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if(entity.getHealth() < entity.getMaxHealth()) entity.heal(healAmount);
        return super.finishUsingItem(stack, world, entity);
    }
    @Override public int getUseDuration(ItemStack stack) {return 16;}
    @OnlyIn(Dist.CLIENT)
    @Override public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.healthHeal(healAmount / 2));
        super.appendHoverText(stack, context, tooltip, flagIn);
    }
}