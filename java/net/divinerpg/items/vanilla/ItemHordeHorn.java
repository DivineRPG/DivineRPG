package net.divinerpg.items.vanilla;

import net.divinerpg.api.items.ItemMod;
import net.divinerpg.blocks.vanilla.container.tile_entity.TileEntityAyeracoSpawn;
import net.divinerpg.entities.vanilla.EntityAyeracoBlue;
import net.divinerpg.entities.vanilla.EntityAyeracoGreen;
import net.divinerpg.entities.vanilla.EntityAyeracoPurple;
import net.divinerpg.entities.vanilla.EntityAyeracoRed;
import net.divinerpg.entities.vanilla.EntityAyeracoYellow;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

public class ItemHordeHorn extends ItemMod {

	public ItemHordeHorn(String name) {
		super(name);
		this.maxStackSize = 1;
		this.setCreativeTab(DivineRPGTabs.spawner);
	}

	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int var7, float xFloat, float yFloat, float zFloat) {
		if(world.isRemote) {
			return true;
		} else {
			x += Facing.offsetsXForSide[var7];
			y += Facing.offsetsYForSide[var7];
			z += Facing.offsetsZForSide[var7];

			if (world.provider.dimensionId == 1) {
			    world.playSoundAtEntity(player, Sounds.ayeracoSpawn.getPrefixedName(), 20.0F, 1.0F);
				TileEntity ayeracoSpawnTE = new TileEntityAyeracoSpawn();
				world.setTileEntity(x, y, z, ayeracoSpawnTE);
				if(!player.capabilities.isCreativeMode) {
					player.inventory.consumeInventoryItem(this);
				}
			} else 
				player.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "The Ayeraco Horde Can Only Be Spawned In The End"));
			return false;
		}
	}
}