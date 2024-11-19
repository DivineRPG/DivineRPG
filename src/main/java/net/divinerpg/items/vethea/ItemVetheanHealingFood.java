package net.divinerpg.items.vethea;

import java.util.List;

import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.MessageLocalizer;
import net.divinerpg.utils.Util;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
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
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add((MessageLocalizer.norecolor("tooltip.fills")) + this.healthGain + (MessageLocalizer.norecolor("tooltip.health")));
        list.add(func_150906_h(stack) + (MessageLocalizer.norecolor("tooltip.saturation")));
        list.add(!isWolfsFavoriteMeat() ? Util.BLUE + (MessageLocalizer.norecolor("tooltip.petfood")) + EnumChatFormatting.RESET + (MessageLocalizer.norecolor("tooltip.true")): Util.BLUE + (MessageLocalizer.norecolor("tooltip.petfood")) + EnumChatFormatting.RESET + (MessageLocalizer.norecolor("tooltip.false")));
    }
}
