package net.divinerpg.items.vanilla;

import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

public class ItemHordeHorn extends ItemMod {

	public ItemHordeHorn(String name) {
		super(name);
		this.maxStackSize = 1;
		this.setCreativeTab(DivineRPGTabs.spawner);
	}

	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float xFloat, float yFloat, float zFloat) {
		if(world.isRemote) {
			return true;
		} else {
			x += Facing.offsetsXForSide[side];
			y += Facing.offsetsYForSide[side];
			z += Facing.offsetsZForSide[side];

			if (world.provider.dimensionId == 1) {
			    if (world.getBlock(x, y, z) != Blocks.air) {
			        return false;
			    }
			    world.playSoundAtEntity(player, Sounds.ayeracoSpawn.getPrefixedName(), 20.0F, 1.0F);
				world.setBlock(x, y, z, VanillaBlocks.ayeracoSpawn);
				if(!player.capabilities.isCreativeMode) {
					player.inventory.consumeInventoryItem(this);
				}
			} else 
				player.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "The Ayeraco Horde can only be spawned in The End"));
			return false;
		}
	}
}