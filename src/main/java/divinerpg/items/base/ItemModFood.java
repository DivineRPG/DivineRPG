package divinerpg.items.base;

import divinerpg.*;
import divinerpg.util.*;
import net.minecraft.client.util.*;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraft.world.*;
import net.minecraftforge.api.distmarker.*;

import javax.annotation.*;
import java.util.*;

public class ItemModFood extends ItemMod {
    Food food;
    boolean fastFood;

    public ItemModFood(String name, Properties properties, Food food) {
        super(name, properties);
        this.food = food;
    }

    public ItemModFood(String name, Food food, ItemGroup tab) {
        super(name, new Properties().tab(tab).food(food));
        this.food = food;
    }

    public ItemModFood(String name, Food food, ItemGroup tab, boolean fastFood) {
        super(name, new Item.Properties().tab(tab).food(food));
        this.food = food;
        this.fastFood = fastFood;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return fastFood? 1 : super.getUseDuration(stack);
    }

    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (food.isMeat()) {
            tooltip.add(new TranslationTextComponent(DivineRPG.MODID + ".tooltip.food.pet").withStyle(TextFormatting.BLUE));
        }
        if (fastFood) {
            tooltip.add(LocalizeUtils.instantConsumption());
        }
    }
}
