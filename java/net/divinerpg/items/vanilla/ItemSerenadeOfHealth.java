package net.divinerpg.items.vanilla;

import java.util.List;

import net.divinerpg.blocks.vanilla.VanillaBlock;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.Sounds;
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
		setMaxDurability(20);
		setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		float current = player.getHealth();
        if ((current >= 0.0F) && (current < 20.0F)) {
            player.setHealth(20.0F);
            stack.damageItem(1, player);
            Sounds.getSoundName(Sounds.heal);
        }
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
		infoList.add(20 - item.getMetadata() + " Uses Remaining");
	}
}
