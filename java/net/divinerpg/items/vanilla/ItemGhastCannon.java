package net.divinerpg.items.vanilla;

import java.util.List;
import java.util.Random;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.vanilla.projectile.EntityGhastCannon;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGhastCannon extends ItemMod {
	private Random rand = new Random();
	
	public ItemGhastCannon(String name) {
		super(name);
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
		setMaxDamage(100);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		world.playSoundAtEntity(player, Sounds.ghastCannon.getPrefixedName(), 1.0F, 1.0F);
		if(!player.capabilities.isCreativeMode)stack.damageItem(1, player);
		EntityThrowable entity = new EntityGhastCannon(world, player);
		if(!world.isRemote)world.spawnEntityInWorld(entity);
		return stack;
	}
	
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("40 Ranged damage");
		par3List.add("Infinite ammo");
		par3List.add(var1.getMaxDamage() - var1.getItemDamage() + " Uses remaining");
		par3List.add(ChatFormats.DIVINERPG);
	}
}
