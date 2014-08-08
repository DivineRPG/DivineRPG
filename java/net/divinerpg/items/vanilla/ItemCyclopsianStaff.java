package net.divinerpg.items.vanilla;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.vanilla.projectile.EntityCyclopsianStaff;
import net.divinerpg.entities.vanilla.projectile.EntityScythe;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCyclopsianStaff extends ItemMod {

	public ItemCyclopsianStaff(String name) {
		super(name);
		this.setMaxStackSize(1);
		this.setMaxDamage(3000);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
		if(!var2.isRemote){ 
			if(var3.inventory.hasItem(VanillaItemsOther.cyclopsEyeShards) || var3.capabilities.isCreativeMode){
				Sounds.getSoundName(Sounds.staff);
				var2.spawnEntityInWorld(new EntityCyclopsianStaff(var2, var3));
				var1.damageItem(1, var3);
				var3.inventory.consumeInventoryItem(VanillaItemsOther.cyclopsEyeShards);
			}
		}
		return var1;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(EntityCyclopsianStaff.damage + " Ranged damage");
		par3List.add("Ammo: Cyclops Eye Shards");
		par3List.add(var1.getMaxDamage() - var1.getItemDamage() + " Uses");
		par3List.add(ChatFormats.DIVINERPG);
	}
}