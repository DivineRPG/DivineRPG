package net.divinerpg.items.arcana;

import java.util.List;

import net.divinerpg.entities.arcana.EntityFyracryx;
import net.divinerpg.entities.arcana.EntityGolemOfRejuv;
import net.divinerpg.entities.arcana.EntityParatiku;
import net.divinerpg.entities.arcana.EntitySeimer;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.ChatFormats;
import net.divinerpg.libs.DivineRPGAchievements;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.items.ArcanaItems;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemArcanaSpawnEgg extends ItemMod {

	public ItemArcanaSpawnEgg(String name) {
		super(name, DivineRPGTabs.spawner);
		setMaxStackSize(1);
		setTextureName(Reference.PREFIX + "arcanaSpawnEgg");
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		Item item = stack.getItem();
		EntityFyracryx fyracryx = new EntityFyracryx(world, player);
		EntitySeimer seimer = new EntitySeimer(world, player);
		EntityGolemOfRejuv golem = new EntityGolemOfRejuv(world, player);
		EntityParatiku paratiku = new EntityParatiku(world, player);
		if(!world.isRemote){
			if(item == ArcanaItems.fyracryxSpawner){
				fyracryx.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
				world.spawnEntityInWorld(fyracryx);
			}
			if(item == ArcanaItems.seimerSpawner){
				seimer.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
				world.spawnEntityInWorld(seimer);
			}
			if(item == ArcanaItems.golemSpawner){
				golem.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
				world.spawnEntityInWorld(golem);
			}
			if(item == ArcanaItems.paratikuSpawner){
				paratiku.setLocationAndAngles(x, y + 1, z, 0.0F, 0.0F);
				world.spawnEntityInWorld(paratiku);
			}
			player.triggerAchievement(DivineRPGAchievements.littleCreature);
			stack.stackSize--;
			return true;
		}
		return false;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		Item item = stack.getItem();
		if(item == ArcanaItems.fyracryxSpawner)
			list.add("Spawns a pet Fyracryx");
		
		if(item == ArcanaItems.seimerSpawner)
			list.add("Spawns a pet Seimer");
		
		if(item == ArcanaItems.golemSpawner)
			list.add("Spawns a pet Golem Of Rejuvenation");
		
		if(item == ArcanaItems.paratikuSpawner)
			list.add("Spawns a pet Paratiku");
	}
}