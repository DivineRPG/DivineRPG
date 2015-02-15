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
	
	public ItemTeleportationCrystal(String name) {
		super(name);
		setCreativeTab(DivineRPGTabs.utility);
		LangRegistry.addItem(this);
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
                y = world.getTopSolidOrLiquidBlock(x, z);
		    }
		    if (player.dimension != 0) {
		        MinecraftServer.getServer().getConfigurationManager().transferPlayerToDimension((EntityPlayerMP) player, 0);
		    }
		    player.setPositionAndUpdate(x, y, z);
		    player.setPositionAndRotation(x, y, z, player.rotationYaw, 0.0F);
            player.motionX = player.motionY = player.motionZ = 0.0D;            
		}
		return stack;
	}
	
	@Override
	public void addInformation(ItemStack item, EntityPlayer player, List infoList, boolean par4) {
		infoList.add("Teleport to Bed/Spawn");
	}
}
