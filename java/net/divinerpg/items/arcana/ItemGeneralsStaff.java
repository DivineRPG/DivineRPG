package net.divinerpg.items.arcana;

import java.util.List;
import java.util.Random;

import net.divinerpg.entities.arcana.EntityGeneralsStaff;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.items.vethea.ItemStaff;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.events.ArcanaHelper;
import net.divinerpg.utils.events.Ticker;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemGeneralsStaff extends ItemMod {
	private Random rand = new Random();
	public ItemGeneralsStaff() {
		super("general'sStaff");
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
		ItemStaff.staffList.add(this);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		if (!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
		
		if(Ticker.tick >= stack.getTagCompound().getLong("CanShootTime")) {
			if(ArcanaHelper.getProperties(player).useBar(20)) {
				if(!world.isRemote)world.playSoundAtEntity(player, Sounds.starlight.getPrefixedName(), 1.0F, 1.0F);
				EntityThrowable entity = new EntityGeneralsStaff(world, player);
				if(!world.isRemote) {
					world.spawnEntityInWorld(entity);
					stack.getTagCompound().setLong("CanShootTime", Ticker.tick + 12);
				}
			}
		}
		if(player instanceof EntityPlayerMP)((EntityPlayerMP)player).sendContainerToPlayer(player.inventoryContainer);
		if (stack.getTagCompound().getLong("CanShootTime") >= 100000 || stack.getTagCompound().getLong("CanShootTime") > Ticker.tick + 141)stack.getTagCompound().setLong("CanShootTime", 0);
		return stack;
	}
	
    @SideOnly(Side.CLIENT)
    public boolean isFull3D() {
        return true;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add("18 Ranged Damage");
		list.add("Projectile splits into 6 on impact");
		list.add("Consumes 20 Arcana");
		list.add("Infinite Uses");
	}
}
