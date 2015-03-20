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

public class ItemTwilightSpawner extends ItemMod {

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
						EntityKarot e = new EntityKarot(world);
						e.setPosition(x, y+1, z);
						if(world.getCollidingBoundingBoxes(e, e.boundingBox).isEmpty()) {
							world.spawnEntityInWorld(e);
							if(!player.capabilities.isCreativeMode) player.inventory.consumeInventoryItem(stack.getItem());
						}
						return true;
					}
					if(stack.getItem() == TwilightItemsOther.densosCrystal || stack.getItem() == TwilightItemsOther.reyvorCrystal){
						EntityDensos e = new EntityDensos(world);
						e.setPosition(x, y+1, z);
						EntityReyvor e1 = new EntityReyvor(world);
						e1.setPosition(x, y+1, z);
						if(world.getCollidingBoundingBoxes(e, e.boundingBox).isEmpty() && world.getCollidingBoundingBoxes(e1, e1.boundingBox).isEmpty()) {
							world.spawnEntityInWorld(e);
							world.spawnEntityInWorld(e1);
							if(!player.capabilities.isCreativeMode) player.inventory.consumeInventoryItem(stack.getItem());
							player.triggerAchievement(DivineRPGAchievements.tenHeadsIsBetterThanOne);
						}
						return true;
					}
					if(stack.getItem() == TwilightItemsOther.soulFiendCrystal){
						EntitySoulFiend e = new EntitySoulFiend(world);
						e.setPosition(x, y+1, z);
						if(world.getCollidingBoundingBoxes(e, e.boundingBox).isEmpty()) {
							world.spawnEntityInWorld(e);
							if(!player.capabilities.isCreativeMode) player.inventory.consumeInventoryItem(stack.getItem());
						}
						return true;
					}
					if(stack.getItem() == TwilightItemsOther.twilightDemonCrystal){
						EntityTwilightDemon e = new EntityTwilightDemon(world);
						e.setPosition(x, y+1, z);
						if(world.getCollidingBoundingBoxes(e, e.boundingBox).isEmpty()) {
							world.spawnEntityInWorld(e);
							if(!player.capabilities.isCreativeMode) player.inventory.consumeInventoryItem(stack.getItem());
						}
						return true;
					}
					if(stack.getItem() == TwilightItemsOther.vamacheronCrystal){
						EntityVamacheron e = new EntityVamacheron(world);
						e.setPosition(x, y+1, z);
						if(world.getCollidingBoundingBoxes(e, e.boundingBox).isEmpty()) {
							world.spawnEntityInWorld(e);
							if(!player.capabilities.isCreativeMode) player.inventory.consumeInventoryItem(stack.getItem());
						}
						return true;
					}
					if(stack.getItem() == TwilightItemsOther.eternalArcherCrystal){
						EntityEternalArcher e = new EntityEternalArcher(world);
						e.setPosition(x, y+1, z);
						if(world.getCollidingBoundingBoxes(e, e.boundingBox).isEmpty()) {
							world.spawnEntityInWorld(e);
							if(!player.capabilities.isCreativeMode) player.inventory.consumeInventoryItem(stack.getItem());
							player.triggerAchievement(DivineRPGAchievements.sixInOne);
						}
						return true;
					}
			} else {
				player.addChatMessage(Util.getChatComponent(Util.AQUA + "This item can only be used in Mortum."));
			}
		}
		return false;
	}
}