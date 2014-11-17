package net.divinerpg.items.twilight;

import java.util.List;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTwilightBlitz extends ItemMod {
	private String sound;
	private int damage;
	private Item ammoType;
	private Class<? extends EntityThrowable> projectileClass;
	
	public ItemTwilightBlitz(int damage, Item ammoType, Class<? extends EntityThrowable> projectileClass, String name) {
		super(name);
		this.maxStackSize = 1;
		sound = Sounds.blitz.getPrefixedName();
		this.setMaxDamage(-1);
		this.setCreativeTab(DivineRPGTabs.ranged);
		this.damage = damage;
		this.ammoType = ammoType;
		this.projectileClass = projectileClass;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(player.capabilities.isCreativeMode || player.inventory.hasItem(ammoType)) {
			if(!player.capabilities.isCreativeMode)player.inventory.consumeInventoryItem(ammoType);
			world.playSoundAtEntity(player, Sounds.blitz.getPrefixedName(), 1.0F, 1.0F);
			try{
				EntityThrowable entity = projectileClass.getConstructor(World.class, EntityLivingBase.class).newInstance(world, player);
				if(!world.isRemote)world.spawnEntityInWorld(entity);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return stack;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
	    par3List.add(damage + " Ranged Damage");
	    par3List.add("Ammo: " + StatCollector.translateToLocal(ammoType.getUnlocalizedName() + ".name"));
		par3List.add("Infinite Uses");
	}
}
