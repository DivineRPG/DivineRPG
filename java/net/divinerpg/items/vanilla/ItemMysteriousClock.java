package net.divinerpg.items.vanilla;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.vanilla.EntityAncientEntity;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ItemMysteriousClock extends ItemMod {

	public ItemMysteriousClock(String name) {
		super(name);
		setMaxStackSize(1);
		setCreativeTab(DivineRPGTabs.spawner);
	}

	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
		int var4 = 0;
		if(!par3World.isRemote){
			if(player.capabilities.isCreativeMode){
				while(var4 < 1) {
					EntityAncientEntity var5 = new EntityAncientEntity(par3World);
					var5.setPosition(par4, par5 +1, par6);
					par3World.spawnEntityInWorld(var5);
					var4++;
				}
			} else {
				while(var4 < 1) {
					EntityAncientEntity var5 = new EntityAncientEntity(par3World);
					var5.setPosition(par4, par5 + 1, par6);
					par3World.spawnEntityInWorld(var5);
					var4++;
					par1ItemStack.stackSize--;
				}
			}
		}
		return true;
	}
}