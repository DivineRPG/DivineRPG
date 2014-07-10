package net.divinerpg.api.items;

import java.util.List;

import net.divinerpg.client.ArcanaHelper;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemModPotion extends ItemMod {

    protected int amountToAdd;

    public ItemModPotion(String name, int amountToAdd) {
        super(name, DivineRPGTabs.utility);
        this.amountToAdd = amountToAdd;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add("Replenishes: " + amountToAdd + " Arcana");
        list.add(Util.DARK_AQUA + Reference.MOD_NAME);
    }

    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player) {
        if (!player.capabilities.isCreativeMode) stack.stackSize--;
        if (!world.isRemote) ArcanaHelper.setBarValue(amountToAdd);
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
        if (ArcanaHelper.getBarValue() != 200) player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        return stack;
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}