package net.divinerpg.items.iceika;

import java.util.List;

import net.divinerpg.entities.iceika.projectile.EntityCarol;
import net.divinerpg.entities.iceika.projectile.EntitySerenadeOfIce;
import net.divinerpg.entities.iceika.projectile.EntityMusic;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.items.IceikaItems;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemSerenadeOfIce extends ItemMod {
	
	public ItemSerenadeOfIce(String name){
		super(name);
		setCreativeTab(DivineRPGTabs.utility);
		setMaxDamage(100);
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if(!world.isRemote) {
			world.spawnEntityInWorld(new EntitySerenadeOfIce(world, player));
			world.playSoundAtEntity(player, Sounds.serenade.getPrefixedName(), 1, 1);
			stack.damageItem(1, player);
		}
		
		return stack;
	}

	@Override
	public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
		infoList.add("Slows mobs for 5 seconds");
		infoList.add(TooltipLocalizer.usesRemaining(getMaxDamage() - item.getItemDamage()));
	}
}