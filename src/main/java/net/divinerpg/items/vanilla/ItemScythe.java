package net.divinerpg.items.vanilla;

import java.util.List;
import java.util.Random;

import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.entities.vanilla.projectile.EntityShooterBullet;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.items.VanillaItemsArmor;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemScythe extends ItemMod {
	public ItemScythe() {
		super("scythe");
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
			if(!world.isRemote) {
				world.playSoundAtEntity(player, Sounds.deepLaugh.getPrefixedName(), 1.0F, 1.0F);
				
				ItemStack boots = player.inventory.armorItemInSlot(0);
		        ItemStack legs = player.inventory.armorItemInSlot(1);
		        ItemStack body = player.inventory.armorItemInSlot(2);
		        ItemStack helmet = player.inventory.armorItemInSlot(3);
		        
		        int damage = 6;
		        
		        if(boots != null && legs != null && body != null && helmet != null && boots.getItem() == VanillaItemsArmor.jackOManBoots && body.getItem() == VanillaItemsArmor.jackOManBody && legs.getItem() == VanillaItemsArmor.jackOManLegs && helmet.getItem() == VanillaItemsArmor.jackOManHelmet) damage = 18;
				
				EntityShooterBullet entity = new EntityShooterBullet(world, player, damage, EntityResourceLocation.scytheProjectile.toString());
				world.spawnEntityInWorld(entity);
			}

		return stack;
	}
	
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add(TooltipLocalizer.rangedDam(6));
		list.add(TooltipLocalizer.infiniteAmmo());
		list.add(TooltipLocalizer.infiniteUses());
	}
}
