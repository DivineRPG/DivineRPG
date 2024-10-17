package net.divinerpg.items.vanilla;

import java.util.List;

import net.divinerpg.blocks.vanilla.VanillaBlock;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSerenadeOfHealth extends ItemMod {
	
	public ItemSerenadeOfHealth(String name){
		super(name);
		setCreativeTab(DivineRPGTabs.utility);
		setMaxDamage(7);
		setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		float current = player.getHealth();
        if ((current >= 0.0F) && (current < 20.0F)) {
            player.setHealth(20.0F);
            stack.damageItem(1, player);
            world.playSoundAtEntity(player, Sounds.heal.getPrefixedName(), 1, 1);
        }
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getItemDamage()));
	}
}
