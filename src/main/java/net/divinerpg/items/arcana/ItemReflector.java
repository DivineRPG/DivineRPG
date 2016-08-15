package net.divinerpg.items.arcana;

import java.util.List;
import java.util.Random;

import net.divinerpg.entities.arcana.projectile.EntityReflector;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.TooltipLocalizer;
import net.divinerpg.utils.events.ArcanaHelper;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemReflector extends ItemMod {
	private Random rand = new Random();
	public ItemReflector() {
		super("arcaniumReflector");
		setCreativeTab(DivineRPGTabs.utility);
		setMaxStackSize(1);
		setFull3D();
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {	
		if(!world.isRemote && ArcanaHelper.getProperties(player).useBar(20)) {
			if(!world.isRemote)world.playSoundAtEntity(player, Sounds.reflector.getPrefixedName(), 1.0F, 1.0F);
			EntityThrowable entity = new EntityReflector(world, player);
			world.spawnEntityInWorld(entity);
		}
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add("Knocks mobs away");
		list.add(TooltipLocalizer.arcanaConsumed(20));
		list.add(TooltipLocalizer.infiniteUses());
	}
}
