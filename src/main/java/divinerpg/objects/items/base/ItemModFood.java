package divinerpg.objects.items.base;

import divinerpg.DivineRPG;
import divinerpg.registry.DivineRPGTabs;
import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemModFood extends ItemFood {
    private final ITextComponent petFood;

    public ItemModFood(int healAmount, float saturation, String name) {
        this(healAmount, saturation, false, name);
    }

    public ItemModFood(int healAmount, float saturation, boolean isWolfFood, String name) {
        super(healAmount, saturation, isWolfFood);
        setUnlocalizedName(name);
        setRegistryName(DivineRPG.MODID, name);
        this.setCreativeTab(DivineRPGTabs.food);

        petFood = new TextComponentTranslation("tooltip.food.pet");
        petFood.getStyle().setColor(TextFormatting.BLUE);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(LocalizeUtils.i18n("tooltip.food.satiety", getHealAmount(item)));
        list.add(LocalizeUtils.i18n("tooltip.food.saturation", getHealAmount(item) * getSaturationModifier(item) * 2));

        if (isWolfsFavoriteMeat()) {
            list.add(petFood.getFormattedText());
        }
    }
}