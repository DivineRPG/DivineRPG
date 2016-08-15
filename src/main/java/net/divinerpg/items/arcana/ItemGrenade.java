package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.entities.arcana.projectile.EntityGrenade;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGrenade extends ItemMod {
	
	private int counter = 0;

	public ItemGrenade(String name) {
		super(name, DivineRPGTabs.ranged);
		
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(counter == 0) {
			if(!world.isRemote) {
				if(!world.isRemote) {
					world.spawnEntityInWorld(new EntityGrenade(world, player));
					world.playSoundAtEntity(player, "random.bow", 1, 1);
				}
				if(!player.capabilities.isCreativeMode) stack.stackSize--;
			}
		}
		if(counter < 3) counter++;
		if(counter == 3) counter = 0;
		return stack;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(TooltipLocalizer.explosiveShots());
	}
}