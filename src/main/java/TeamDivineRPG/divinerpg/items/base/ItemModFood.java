package TeamDivineRPG.divinerpg.items.base;

import TeamDivineRPG.divinerpg.DivineRPG;
import TeamDivineRPG.divinerpg.util.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class ItemModFood extends ItemMod {
    Food food;
    boolean fastFood;
    public ItemModFood(String name, Properties properties, Food food) {
        super(name, properties);
        this.food=food;
    }
    public ItemModFood(String name, Food food, ItemGroup tab) {
        super(name, new Item.Properties().group(tab).food(food));
        this.food=food;
    }
    public ItemModFood(String name, Food food, ItemGroup tab, boolean fast) {
        super(name, new Item.Properties().group(tab).food(food));
        this.food=food;
        fast=fastFood;
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(food.isMeat()) {
            tooltip.add(new TranslationTextComponent(DivineRPG.MODID + ".tooltip.food.pet").func_240699_a_(TextFormatting.BLUE));
        }
        if(fastFood) {
            tooltip.add(LocalizeUtils.instantConsumption());
        }
    }
}
