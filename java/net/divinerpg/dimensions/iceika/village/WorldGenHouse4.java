package net.divinerpg.dimensions.iceika.village;

import java.util.Random;

import net.divinerpg.api.worldgen.WorldGenAPI;
import net.divinerpg.entities.iceika.EntityWorkshopMerchant;
import net.divinerpg.entities.iceika.EntityWorkshopTinkerer;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenHouse4 extends WorldGenerator{
	
	public boolean locationIsValidSpawn(World w, int x, int y, int z){
		for(int i = 0; i < 12; i++) {
			for(int l = 0; l < 10; l++) {
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
		WorldGenAPI.addRectangle(6, 6, 1, w, x, y, z, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(4, 4, 1, w, x + 1, y, z + 1, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(6, 6, 2, w, x, y + 1, z, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(6, 6, 1, w, x, y + 3, z, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(5, 5, 3, w, x, y + 1, z, Blocks.air);
		WorldGenAPI.addRectangle(3, 11, 1, w, x + 6, y, z, IceikaBlocks.workshopCarpet);
		WorldGenAPI.addRectangle(6, 5, 1, w, x, y, z + 6, IceikaBlocks.workshopCarpet);
		WorldGenAPI.addRectangle(3, 11, 1, w, x + 6, y + 4, z, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(1, 13, 3, w, x + 9, y + 1, z - 1, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(5, 1, 3, w, x + 5, y + 1, z - 1, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 7, 3, w, x - 1, y + 1, z + 5, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(11, 1, 3, w, x - 1, y + 1, z + 11, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(7, 5, 3, w, x, y + 4, z + 6, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(7, 5, 1, w, x, y + 7, z + 6, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(5, 3, 1, w, x + 1, y + 8, z + 7, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(5, 3, 1, w, x + 1, y + 7, z + 7, Blocks.air);
		WorldGenAPI.addRectangle(3, 1, 2, w, x + 6, y + 1, z - 1, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(1, 5, 2, w, x - 1, y + 1, z + 6, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(9, 1, 2, w, x, y + 1, z + 11, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(1, 11, 2, w, x + 9, y + 1, z, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(5, 3, 3, w, x + 1, y + 4, z + 7, Blocks.air);
		ItemDoor.placeDoorBlock(w, x + 2, y + 1, z + 5, 1, IceikaBlocks.steelDoorBlock);
		ItemDoor.placeDoorBlock(w, x + 1, y + 1, z + 5, 1, IceikaBlocks.steelDoorBlock);
		ItemDoor.placeDoorBlock(w, x + 5, y + 1, z + 1, 0, IceikaBlocks.steelDoorBlock);
		ItemDoor.placeDoorBlock(w, x + 5, y + 1, z + 2, 0, IceikaBlocks.steelDoorBlock);
		WorldGenAPI.addRectangle(1, 8, 1, w, x + 7, y, z + 1, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 6, 1, w, x + 7, y, z + 2, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 5, 2, w, x, y + 1, z + 6, IceikaBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(1, 5, 1, w, x, y + 3, z + 6, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 3, 1, w, x, y + 3, z + 7, IceikaBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(3, 3, 2, w, x + 2, y + 3, z + 7, IceikaBlocks.brittleLeaves);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 3, y + 5, z + 8, IceikaBlocks.brittleLeaves);
		WorldGenAPI.addRectangle(1, 1, 3, w, x + 3, y + 1, z + 8, IceikaBlocks.frozenWood);
		WorldGenAPI.addRectangle(3, 1, 1, w, x + 2, y + 8, z + 8, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(3, 1, 1, w, x + 2, y + 6, z + 6, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(3, 1, 1, w, x + 2, y + 6, z + 10, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(1, 1, 1, w, x, y + 6, z + 8, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 6, y + 6, z + 8, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 4, y + 2, z + 5, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 5, y + 2, z + 4, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(1, 1, 1, w, x, y + 2, z + 5, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(1, 1, 1, w, x + 5, y + 2, z, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(1, 2, 1, w, x + 9, y + 2, z + 5, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(2, 1, 1, w, x + 3, y + 2, z + 11, IceikaBlocks.frostedGlass);

		EntityWorkshopMerchant mer = new EntityWorkshopMerchant(w);
    	EntityWorkshopTinkerer tink = new EntityWorkshopTinkerer(w);
    	if(!w.isRemote){
    		mer.setLocationAndAngles(x + 8, y + 1, z + 9, 0.0F, 0.0F);
    		tink.setLocationAndAngles(x + 8, y + 1, z + 4, 0.0F, 0.0F);
    		w.spawnEntityInWorld(mer);
    		w.spawnEntityInWorld(tink);
    	}
		return true;
	}
}