package net.divinerpg.items.vanilla;

import java.util.List;

import cpw.mods.fml.common.registry.GameRegistry;
import net.divinerpg.items.base.ItemMod;
import net.divinerpg.libs.Sounds;
import net.divinerpg.utils.LangRegistry;
import net.divinerpg.utils.Util;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;

public class ItemTeleportationCrystal extends ItemMod {
	
	public ItemTeleportationCrystal() {
		super("teleportationCrystal");
		setCreativeTab(DivineRPGTabs.utility);
		setMaxStackSize(1);
		setMaxDamage(10);
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (player instanceof EntityPlayerMP && !player.isRiding()) {
		    ChunkCoordinates bedSpawn = player.getBedLocation(0);
		    int x;
		    int y;
		    int z;

		    if (bedSpawn != null) {
                x = bedSpawn.posX;
                y = bedSpawn.posY;
                z = bedSpawn.posZ;
		    } else {
                x = world.getWorldInfo().getSpawnX();
                z = world.getWorldInfo().getSpawnZ();
                y = world.getHeightValue(x, z);
		    }
		    if (player.dimension != 0) {
		        MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) player, 0);
		    }
		    player.setPositionAndUpdate(x + 0.5D, y + 0.5D, z + 0.5D);
		    player.setPositionAndRotation(x + 0.5D, y + 0.5D, z + 0.5D, player.rotationYaw, 0.0F);
            player.motionX = player.motionY = player.motionZ = 0.0D;
            if(!player.capabilities.isCreativeMode)stack.damageItem(1, player);
		}
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		list.add("Teleport to spawn point");
		list.add(stack.getMaxDamage()-stack.getItemDamage() + " Uses Remaining");
	}
}
