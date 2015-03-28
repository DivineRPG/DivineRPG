package net.divinerpg.items.base;

import java.util.List;

import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.ItemsFood;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemModFood extends ItemFood {

    protected String name;

    public ItemModFood(int food, float sat, boolean wolfFood, String name) {
        super(food, sat, wolfFood);
        this.name = name;
        setCreativeTab(DivineRPGTabs.food);
        setTextureName(Reference.PREFIX + name);
        setUnlocalizedName(name);
        GameRegistry.registerItem(this, name);
        LangRegistry.addItem(this);
    }

    public ItemModFood(String name, int food, float sat, boolean wolfFood, int potionID, int potionDuration, int potionAmplifier, float potionEffectProbability) {
        this(food, sat, wolfFood, name);
        setPotionEffect(potionID, potionDuration, potionAmplifier, potionEffectProbability);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack item, World world, EntityPlayer player) {
    	super.onItemUseFinish(item, world, player);
    	if(item.getItem() == ItemsFood.chickenDinner)
    		player.triggerAchievement(DivineRPGAchievements.mealToRemember);
    	return item;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add("Fills " + (double) getHealAmount(stack) / 2 + " Hunger Bars");
        list.add(getSaturationModifier(stack) + " Saturation");
        list.add(!isWolfsFavoriteMeat() ? Util.BLUE + "Pet Food:" + EnumChatFormatting.RESET + " false" : Util.BLUE + "Pet Food:" + EnumChatFormatting.RESET + " true");
    }

}
