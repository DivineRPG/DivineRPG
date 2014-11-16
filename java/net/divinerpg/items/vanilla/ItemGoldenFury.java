package net.divinerpg.items.vanilla;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.vanilla.projectile.EntityGoldenFury;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.google.common.collect.Multimap;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGoldenFury extends ItemMod {
	
	public ItemGoldenFury(String name) {
		super(name);
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote){
			if(player.inventory.hasItem(Items.gold_nugget) || player.capabilities.isCreativeMode) {
				if(!player.capabilities.isCreativeMode) player.inventory.consumeInventoryItem(Items.gold_nugget);
				world.playSoundAtEntity(player, Sounds.blitz.getPrefixedName(), 1.0F, 1.0F);
				EntityThrowable entity = new EntityGoldenFury(world, player);
				world.spawnEntityInWorld(entity);
			}
		}
		return stack;
	}
	
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(32 + " Ranged damage");
		par3List.add("Ammo: " + StatCollector.translateToLocal(Items.gold_nugget.getUnlocalizedName()+".name"));
		par3List.add(ChatFormats.DIVINERPG);
	}
}
