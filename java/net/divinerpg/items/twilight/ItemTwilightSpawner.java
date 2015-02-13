package net.divinerpg.items.twilight;

import net.divinerpg.entities.twilight.EntityDensos;
import net.divinerpg.entities.twilight.EntityEternalArcher;
import net.divinerpg.entities.twilight.EntityKarot;
import net.divinerpg.entities.twilight.EntityReyvor;
import net.divinerpg.entities.twilight.EntitySoulFiend;
import net.divinerpg.entities.twilight.EntityTwilightDemon;
import net.divinerpg.entities.twilight.EntityVamacheron;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.config.ConfigurationHelper;
import net.divinerpg.utils.items.TwilightItemsOther;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemTwilightSpawner extends ItemMod{

	public ItemTwilightSpawner(String name) {
		super(name);
		setMaxStackSize(1);
		this.setCreativeTab(DivineRPGTabs.spawner);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10) {
		if (!world.isRemote) {
			if(world.provider.dimensionId == ConfigurationHelper.mortum){
					if(stack.getItem() == TwilightItemsOther.karotCrystal){
						EntityKarot var5 = new EntityKarot(world);
						var5.setPosition(x, y+1, z);
						world.spawnEntityInWorld(var5);
						--stack.stackSize;
						return true;
					}
					if(stack.getItem() == TwilightItemsOther.densosCrystal || stack.getItem() == TwilightItemsOther.reyvorCrystal){
						EntityDensos var5 = new EntityDensos(world);
						var5.setPosition(x, y+1, z);
						world.spawnEntityInWorld(var5);
						EntityReyvor var6 = new EntityReyvor(world);
						var6.setPosition(x, y+1, z);
						world.spawnEntityInWorld(var6);
						--stack.stackSize;
						player.triggerAchievement(DivineRPGAchievements.tenHeadsIsBetterThanOne);
						return true;
					}
					if(stack.getItem() == TwilightItemsOther.soulFiendCrystal){
						EntitySoulFiend var5 = new EntitySoulFiend(world);
						var5.setPosition(x, y+1, z);
						world.spawnEntityInWorld(var5);
						--stack.stackSize;
						return true;
					}
					if(stack.getItem() == TwilightItemsOther.twilightDemonCrystal){
						EntityTwilightDemon var5 = new EntityTwilightDemon(world);
						var5.setPosition(x, y+1, z);
						world.spawnEntityInWorld(var5);
						--stack.stackSize;
						return true;
					}
					if(stack.getItem() == TwilightItemsOther.vamacheronCrystal){
						EntityVamacheron var5 = new EntityVamacheron(world);
						var5.setPosition(x, y+1, z);
						world.spawnEntityInWorld(var5);
						--stack.stackSize;
						return true;
					}
					if(stack.getItem() == TwilightItemsOther.eternalArcherCrystal){
						EntityEternalArcher var5 = new EntityEternalArcher(world);
						var5.setPosition(x, y+1, z);
						world.spawnEntityInWorld(var5);
						--stack.stackSize;
						return true;
					}
			} else {
				player.addChatMessage(Util.getChatComponent(Util.AQUA + "This item can only be used in Mortum."));
			}
		}
		return false;
	}
}