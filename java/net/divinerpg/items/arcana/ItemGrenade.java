package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.arcana.projectile.EntityGrenade;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemGrenade extends ItemMod {

	public ItemGrenade(String name) {
		super(name, DivineRPGTabs.ranged);
		
	}

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par3World, EntityPlayer par2EntityPlayer) {
		if(!par3World.isRemote){
			par3World.spawnEntityInWorld(new EntityGrenade(par3World, par2EntityPlayer));
			Sounds.playSound(par2EntityPlayer, par3World, Sounds.laVekor);
			if(!par2EntityPlayer.capabilities.isCreativeMode)
				par1ItemStack.stackSize--;
		}
		return par1ItemStack;
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add("Explosive projectile");
		list.add(ChatFormats.DIVINERPG);
	}
}