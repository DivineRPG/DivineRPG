package net.divinerpg.items.arcana;

import java.util.List;
import java.util.Random;

import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.entities.vanilla.projectile.EntityCorruptedBullet;
import net.divinerpg.entities.vanilla.projectile.EntityShooterBullet;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.items.base.ItemProjectileShooter;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.events.ArcanaHelper;
import net.divinerpg.utils.events.Ticker;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArcaniteBlaster extends ItemMod {
	private Random rand = new Random();
	public ItemArcaniteBlaster() {
		super("arcaniteBlaster");
		setCreativeTab(DivineRPGTabs.ranged);
		setMaxStackSize(1);
		setMaxDamage(6500);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		
		if (!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
		
		if(Ticker.tick >= stack.getTagCompound().getLong("CanShootTime")) {
			if(ArcanaHelper.getProperties(player).useBar(20)) {
			if(!world.isRemote)world.playSoundAtEntity(player, Sounds.ghastCannon.getPrefixedName(), 1.0F, 1.0F);
				for(int i = 0; i < 30; i++) {
					EntityThrowable entity = new EntityShooterBullet(world, player, 23, EntityResourceLocation.arcaniteBlaster.toString());
					entity.posX += (this.rand.nextDouble()-this.rand.nextDouble())*1.5;
					entity.posY += (this.rand.nextDouble()-this.rand.nextDouble())*1.5;
					entity.posZ += (this.rand.nextDouble()-this.rand.nextDouble())*1.5;
					if(!world.isRemote) {
						world.spawnEntityInWorld(entity);
						stack.getTagCompound().setLong("CanShootTime", Ticker.tick + 7);
					}
				}
				stack.damageItem(1, player);
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
		list.add(TooltipLocalizer.bowDam("30x23"));
		list.add(TooltipLocalizer.arcanaConsumed(20));
		list.add(TooltipLocalizer.usesRemaining(stack.getMaxDamage() - stack.getItemDamage()));
	}
}
