package divinerpg.items.base;

import divinerpg.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.entity.*;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;

import javax.annotation.*;
import java.util.*;

public class ItemHealingFood extends ItemModFood {
    private int healthGain;

    public ItemHealingFood(Food food, String name) {
        super(name, food, DivineRPG.tabs.food);
        this.healthGain = food.getNutrition();
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return 16;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, World world, LivingEntity entity) {
        if(entity.getHealth() < entity.getMaxHealth()){
            entity.heal(healthGain);
        }
        return super.finishUsingItem(stack, world, entity);
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(LocalizeUtils.i18n("tooltip.food.heal", healthGain));
        super.appendHoverText(stack, worldIn, tooltip, flagIn);
    }

}