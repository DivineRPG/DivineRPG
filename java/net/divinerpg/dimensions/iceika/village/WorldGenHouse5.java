package net.divinerpg.dimensions.iceika.village;

import java.util.Random;

import net.divinerpg.api.worldgen.WorldGenAPI;
import net.divinerpg.entities.iceika.EntityWorkshopMerchant;
import net.divinerpg.entities.iceika.EntityWorkshopTinkerer;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemDoor;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenHouse5 extends WorldGenerator{

	public boolean locationIsValidSpawn(World w, int x, int y, int z){
		for(int i = 0; i < 13; i++) {
			for(int l = 0; l < 11; l++) {
				if(w.getBlock(x + i, y, z + l) != IceikaBlocks.frozenGrass) {
					return false;
				}
			}
		}
		return true;
	}
	
	@Override
	public boolean generate(World w, Random var2, int x, int y, int z) {
		if(!locationIsValidSpawn(w, x, y, z))
			return false;
		WorldGenAPI.addRectangle(5, 13, 4, w, x, y, z, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(3, 11, 3, w, x + 1, y + 1, z + 1, Blocks.air);
		WorldGenAPI.addRectangle(3, 11, 1, w, x + 1, y, z + 1, IceikaBlocks.workshopCarpet);
		WorldGenAPI.addRectangle(8, 7, 3, w, x - 7, y + 1, z + 6, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(7, 5, 3, w, x - 6, y + 1, z + 7, Blocks.air);
		WorldGenAPI.addRectangle(7, 5, 1, w, x - 6, y, z + 7, IceikaBlocks.workshopCarpet);
		WorldGenAPI.addRectangle(1, 4, 1, w, x - 1, y + 1, z + 1, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(1, 5, 4, w, x, y, z + 1, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(6, 1, 3, w, x - 6, y + 1, z + 6, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(1, 5, 3, w, x - 7, y + 1, z + 7, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(1, 11, 3, w, x + 4, y + 1, z + 1, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(10, 1, 3, w, x - 6, y + 1, z + 12, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(3, 1, 3, w, x + 1, y + 1, z, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(1, 2, 1, w, x - 1, y, z + 2, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 2, 2, w, x - 1, y + 1, z + 2, Blocks.air);
		ItemDoor.placeDoorBlock(w, x, y + 1, z + 2, 0, IceikaBlocks.steelDoorBlock);
		ItemDoor.placeDoorBlock(w, x, y + 1, z + 3, 0, IceikaBlocks.steelDoorBlock);
		WorldGenAPI.addRectangle(3, 11, 1, w, x + 1, y + 4, z + 1, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(7, 5, 1, w, x - 6, y + 4, z + 7, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(1, 9, 1, w, x + 2, y + 4, z + 2, Blocks.air);
		WorldGenAPI.addRectangle(1, 9, 1, w, x + 2, y + 5, z + 2, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(7, 3, 1, w, x - 5, y + 4, z + 8, Blocks.air);
		WorldGenAPI.addRectangle(7, 3, 1, w, x - 5, y + 5, z + 8, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(6, 1, 1, w, x - 4, y + 5, z + 9, Blocks.air);
		WorldGenAPI.addRectangle(6, 1, 1, w, x - 4, y + 6, z + 9, IceikaBlocks.snowBricks);
		WorldGenAPI.addBlock(w, x + 1, y - 1, z + 1, IceikaBlocks.workshopLamp);
		WorldGenAPI.addBlock(w, x + 3, y - 1, z + 1, IceikaBlocks.workshopLamp);
		WorldGenAPI.addBlock(w, x + 3, y - 1, z + 11, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 5, 3, w, x - 6, y + 1, z + 7, IceikaBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(1, 3, 1, w, x - 6, y + 3, z + 8, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 3, 1, w, x - 6, y + 2, z + 8, Blocks.air);
		WorldGenAPI.addRectangle(1, 3, 1, w, x - 7, y + 2, z + 8, IceikaBlocks.frostedGlass);
		WorldGenAPI.addBlock(w, x + 2, y + 1, z, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(5, 1, 1, w, x - 5, y + 2, z + 6, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(3, 3, 2, w, x - 2, y + 3, z + 8, IceikaBlocks.brittleLeaves);
		WorldGenAPI.addRectangle(1, 1, 1, w, x - 1, y + 5, z + 9, IceikaBlocks.brittleLeaves);
		WorldGenAPI.addRectangle(1, 1, 3, w, x - 1, y + 1, z + 9, IceikaBlocks.frozenWood);

		EntityWorkshopMerchant mer = new EntityWorkshopMerchant(w);
    	EntityWorkshopTinkerer tink = new EntityWorkshopTinkerer(w);
    	if(!w.isRemote){
    		mer.setLocationAndAngles(x + 2, y + 1, z + 9, 0.0F, 0.0F);
    		tink.setLocationAndAngles(x + 2, y + 1, z + 2, 0.0F, 0.0F);
    		w.spawnEntityInWorld(mer);
    		w.spawnEntityInWorld(tink);
    	}
		return true;
	}
}