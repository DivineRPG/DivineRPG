package net.divinerpg.items.vanilla;

import java.util.List;
import java.util.Random;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.entities.vanilla.projectile.EntityCorruptedBullet;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCorruptedCannon extends ItemMod {
	private Random rand = new Random();
	private int counter = 0;
	public ItemCorruptedCannon(String name) {
		super(name);
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(counter == 0){
			if(player.inventory.hasItem(VanillaItemsOther.corruptedBullet) || player.capabilities.isCreativeMode) {
				if(!player.capabilities.isCreativeMode) player.inventory.consumeInventoryItem(VanillaItemsOther.corruptedBullet);
				if(!world.isRemote)world.playSoundAtEntity(player, Sounds.ghastCannon.getPrefixedName(), 1.0F, 1.0F);
				for(int i = 0; i < 4; i++){
					EntityThrowable entity = new EntityCorruptedBullet(world, player);
					entity.posX += (this.rand.nextDouble()-this.rand.nextDouble())/2;
					entity.posY += (this.rand.nextDouble()-this.rand.nextDouble())/2;
					entity.posZ += (this.rand.nextDouble()-this.rand.nextDouble())/2;
					if(!world.isRemote)world.spawnEntityInWorld(entity);
				}
			}
		}
		counter++;
		if(counter >= 5)counter = 0;
		return stack;
	}
	
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack var1, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("4x14 Ranged damage");
		par3List.add("Ammo: " + StatCollector.translateToLocal(VanillaItemsOther.corruptedBullet.getUnlocalizedName()+".name"));
	}
}
