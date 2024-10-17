package net.divinerpg.items.vanilla;

import java.util.List;

import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemSerenadeOfInfusion extends ItemMod {
    
    public ItemSerenadeOfInfusion(String name){
        super(name);
        setCreativeTab(DivineRPGTabs.utility);
        setMaxDamage(15);
        setMaxStackSize(1);
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        world.playSoundAtEntity(player, Sounds.heal.getPrefixedName(), 1, 1);
        player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 80, 2, true));
        if(!player.capabilities.isCreativeMode)stack.damageItem(1, player);
        return stack;
    }
    
    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
        list.add(TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getItemDamage()));
    }
}
