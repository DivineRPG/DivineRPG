package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.entities.arcana.projectile.EntityLamona;
import net.divinerpg.entities.vanilla.projectile.EntityShooterBullet;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLamona extends ItemMod {
		
	public ItemLamona() {
		super("lamona");
		setCreativeTab(DivineRPGTabs.utility);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!player.capabilities.isCreativeMode) stack.stackSize--;
		if(!world.isRemote) {
			world.playSoundAtEntity(player, "random.bow", 1, 1);
			EntityThrowable bullet = new EntityLamona(world, player);
			world.spawnEntityInWorld(bullet);
		}
		return stack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add("Casts light when thrown");
	}
}
