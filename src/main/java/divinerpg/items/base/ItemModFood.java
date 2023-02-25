package divinerpg.items.base;

import divinerpg.*;
import divinerpg.util.*;
import net.minecraft.*;
import net.minecraft.network.chat.*;
import net.minecraft.world.food.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.*;
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

    public ItemModFood(FoodProperties food, CreativeModeTab tab) {
        super(new Properties().tab(tab).food(food));
        this.food = food;
    }

    public ItemModFood(FoodProperties food, CreativeModeTab tab, boolean fastFood) {
        super(new Item.Properties().tab(tab).food(food));
        this.food = food;
        this.fastFood = fastFood;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return fastFood ? 1 : super.getUseDuration(stack);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level worldIn, List<Component> tooltip, TooltipFlag flagIn) {
        if (food.isMeat()) {
            tooltip.add(Component.translatable(DivineRPG.MODID + ".tooltip.food.pet").withStyle(ChatFormatting.BLUE));
        }
        if (fastFood) {
            tooltip.add(LocalizeUtils.instantConsumption());
        }
    }
}
