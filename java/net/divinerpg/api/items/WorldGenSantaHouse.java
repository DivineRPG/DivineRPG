package net.divinerpg.api.items;

import java.util.Random;

import net.divinerpg.api.worldgen.WorldGenAPI;
import net.divinerpg.entities.iceika.EntityWorkshopMerchant;
import net.divinerpg.entities.iceika.EntityWorkshopTinkerer;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSantaHouse extends WorldGenerator{

	public boolean locationIsValidSpawn(World w, int x, int y, int z){
		for(int i = 0; i < 15; i++) {
			for(int l = 0; l < 15; l++) {
				if(w.getBlock(x + i, y, z + l) != IceikaBlocks.frozenGrass) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean generate(World w, Random r, int x, int y, int z) {
		if(!locationIsValidSpawn(w, x, y, z))
			return false;
		WorldGenAPI.addRectangle(5, 6, 8, w, x, y, z, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 2, y, z, IceikaBlocks.workshopCarpet);
		ItemDoor.placeDoorBlock(w, x + 2, y + 1, z, 1, IceikaBlocks.steelDoorBlock);
		WorldGenAPI.addRectangle(13, 7, 8, w, x - 4, y, z + 5, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(11, 5, 8, w, x - 3, y + 1, z + 6, Blocks.air);
		WorldGenAPI.addRectangle(3, 5, 8, w, x + 1, y + 1, z + 1, Blocks.air);
		WorldGenAPI.addRectangle(11, 5, 1, w, x - 3, y, z + 6, IceikaBlocks.workshopCarpet);
		WorldGenAPI.addRectangle(12, 4, 1, w, x - 4, y + 4, z + 6, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(3, 5, 1, w, x + 1, y, z + 1, IceikaBlocks.workshopCarpet);
		WorldGenAPI.addRectangle(3, 5, 1, w, x + 1, y + 4, z + 1, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 1, y, z + 1, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 3, y, z + 1, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 1, y, z + 5, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 3, y, z + 5, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 1, y + 4, z + 5, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 3, y + 4, z + 5, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 3, y + 4, z + 10, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 2, y + 4, z + 10, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(3, 1, 1, w, x + 1, y + 3, z + 10, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(6, 1, 1, w, x - 1, y + 2, z + 10, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(8, 1, 1, w, x - 2, y + 1, z + 10, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 2, y + 1, z + 10, IceikaBlocks.coalstoneFurnace);
		WorldGenAPI.addRectangle(1, 1, 1, w, x - 3, y, z + 10, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 7, y, z + 10, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 1, 1, w, x - 3, y + 4, z + 10, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 7, y + 4, z + 10, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(3, 1, 3, w, x + 1, y + 5, z + 1, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 2, y + 5, z + 1, IceikaBlocks.coalstoneFurnace);
		WorldGenAPI.addRectangle(11, 5, 1, w, x - 3, y + 8, z + 6, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(3, 5, 1, w, x + 1, y + 8, z + 1, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(1, 1, 3, w, x + 2, y + 8, z + 1, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(3, 1, 1, w, x + 1, y + 9, z + 1, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 2, y + 11, z + 1, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 5, 3, w, x + 7, y + 5, z + 6, IceikaBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(1, 3, 1, w, x + 8, y + 6, z + 7, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(1, 3, 1, w, x + 7, y + 6, z + 7, Blocks.air);
		WorldGenAPI.addRectangle(1, 5, 3, w, x - 3, y + 5, z + 6, IceikaBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(1, 3, 1, w, x - 4, y + 6, z + 7, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(1, 3, 1, w, x - 3, y + 6, z + 7, Blocks.air);
		WorldGenAPI.addRectangle(1, 3, 1, w, x - 4, y + 2, z + 7, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(1, 3, 1, w, x + 8, y + 2, z + 7, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(1, 5, 1, w, x + 2, y + 8, z + 3, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(9, 3, 1, w, x - 2, y + 8, z + 7, IceikaBlocks.frostedGlass);
		WorldGenAPI.placeSignWithText(w, x + 2, y + 3, z - 1, 2, new String[]{"", "Santa's Home", "", ""}, false);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 2, y + 6, z - 1, Blocks.fence);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 2, y + 6, z - 2, Blocks.fence);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 2, y + 5, z - 2, Blocks.fence);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 2, y + 4, z - 2, IceikaBlocks.workshopLamp);
		for(int i = 0; i < 4; i++){
			w.setBlock(x - 2 + i, y + 1 + i, z + 10, IceikaBlocks.coalstoneStairs);
			w.setBlock(x + 6 - i, y + 1 + i, z + 10, IceikaBlocks.coalstoneStairs, 1, 2);
		}
		EntityWorkshopMerchant mer = new EntityWorkshopMerchant(w);
		EntityWorkshopTinkerer tink = new EntityWorkshopTinkerer(w);
		if(!w.isRemote){
			mer.setLocationAndAngles(x + 4, y + 5, z + 7, 0.0F, 0.0F);
			tink.setLocationAndAngles(x + 5, y + 1, z + 8, 0.0F, 0.0F);
			w.spawnEntityInWorld(mer);
			w.spawnEntityInWorld(tink);
		}
		return true;
	}
}