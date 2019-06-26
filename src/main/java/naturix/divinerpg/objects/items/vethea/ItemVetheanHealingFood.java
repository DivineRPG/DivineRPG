package naturix.divinerpg.objects.items.vethea;

import java.util.List;

import javax.annotation.Nullable;

import naturix.divinerpg.utils.TooltipLocalizer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemVetheanHealingFood extends ItemVetheanFood {

    private int healthGain;

    public ItemVetheanHealingFood(int par2, float par3, boolean par4, int par5, String name) {
        super(par2, par3, name);
        this.healthGain = par5;
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
    public void addInformation(ItemStack item, @Nullable World worldIn, List<String> list, ITooltipFlag flagIn) {
    	list.add("Replenishes " + this.healthGain + " Health");
        list.add(saturation + " Saturation");
        list.add("Pet Food: False");
        list.add(TooltipLocalizer.vethean());
    }
}