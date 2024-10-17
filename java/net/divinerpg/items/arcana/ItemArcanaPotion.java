package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.client.ArcanaRenderer;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.events.ArcanaHelper;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemArcanaPotion extends ItemMod {

    protected int amountToAdd;

    public ItemArcanaPotion(String name, int amountToAdd) {
        super(name, DivineRPGTabs.utility);
        this.amountToAdd = amountToAdd;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(TooltipLocalizer.arcanaRegen(amountToAdd));
    }

    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) stack.stackSize--;
        ArcanaHelper.getProperties(player).forceRegen(amountToAdd);
        player.triggerAchievement(DivineRPGAchievements.yuk);
        return stack;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return EnumAction.drink;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack par1ItemStack) {
        return 10;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (ArcanaHelper.getProperties(player).getBarValue() != 200 || ArcanaRenderer.value != 200) player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        return stack;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}