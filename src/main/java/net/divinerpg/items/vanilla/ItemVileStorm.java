package net.divinerpg.items.vanilla;

import java.util.List;

import net.divinerpg.entities.vanilla.projectile.EntityVileStorm;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemVileStorm extends ItemMod {
		
	public ItemVileStorm() {
		super("vileStorm");
		setCreativeTab(DivineRPGTabs.ranged);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!player.capabilities.isCreativeMode) stack.stackSize--;
		if(!world.isRemote) {
			world.playSoundAtEntity(player, "random.bow", 1, 1);
			EntityThrowable bullet = new EntityVileStorm(world, player);
			world.spawnEntityInWorld(bullet);
		}
		return stack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(TooltipLocalizer.rangedDam(4));
		list.add("Poisons Enemies");
	}
}
