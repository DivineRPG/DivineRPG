package net.divinerpg.items.base;

import java.util.ArrayList;
import java.util.List;

import net.divinerpg.entities.twilight.EntityParticleBullet;
import net.divinerpg.entities.vanilla.projectile.EntityShooterBullet;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.events.Ticker;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemThrowable extends ItemMod {
	
	protected float damage;
	
	public ItemThrowable(String name, float damage) {
		super(name);
		setCreativeTab(DivineRPGTabs.ranged);
		this.damage = damage;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!player.capabilities.isCreativeMode) stack.stackSize--;
		if(!world.isRemote) {
			world.playSoundAtEntity(player, "random.bow", 1, 1);
			EntityThrowable bullet = new EntityShooterBullet(world, player, this.damage, this);
			world.spawnEntityInWorld(bullet);
		}
		return stack;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(TooltipLocalizer.rangedDam(damage));
	}
}
