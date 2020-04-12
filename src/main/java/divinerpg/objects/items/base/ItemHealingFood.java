package divinerpg.objects.items.base;

import divinerpg.utils.LocalizeUtils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemHealingFood extends ItemModFood {
    private int healthGain;

    public ItemHealingFood(int hungerGain, float saturation, int healthGain, String name) {
        super(hungerGain, saturation, name);
        this.healthGain = healthGain;
        this.setAlwaysEdible();
    }

    @Override
    public int getMaxItemUseDuration(ItemStack var1) {
        return 16;
    }

    @Override
    public void onFoodEaten(ItemStack par1ItemStack, World par2World, EntityPlayer player) {
        if (player.getHealth() < player.getMaxHealth()) {
            player.heal(healthGain);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
        list.add(LocalizeUtils.i18n("tooltip.food.heal", healthGain));
        list.add(LocalizeUtils.i18n("tooltip.food.satiety", getHealAmount(item)));
        list.add(LocalizeUtils.i18n("tooltip.food.saturation", getHealAmount(item) * getSaturationModifier(item) * 2));
    }
}
