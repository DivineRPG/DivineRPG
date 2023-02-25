package divinerpg.items.base;

import divinerpg.*;
import divinerpg.util.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.entity.*;
import net.minecraft.world.food.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;

import javax.annotation.*;
import java.util.*;

public class ItemHealingFood extends ItemModFood {
    private final int healthGain;

    public ItemHealingFood(FoodProperties food) {
        super(food, DivineRPG.tabs.food);
        this.healthGain = food.getNutrition();
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 16;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level world, LivingEntity entity) {
        if (entity.getHealth() < entity.getMaxHealth()) {
            entity.heal(healthGain);
        }
        return super.finishUsingItem(stack, world, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.food.heal", healthGain));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}