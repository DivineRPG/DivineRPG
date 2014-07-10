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

public class WorldGenLibrary extends WorldGenerator{

	public boolean locationIsValidSpawn(World w, int x, int y, int z){
		for(int i = 0; i < 18; i++) {
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
		WorldGenAPI.addRectangle(19, 11, 1, w, x, y, z, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 7, 3, w, x + 1, y + 1, z + 2, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 5, 2, w, x + 1, y + 1, z + 3, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(1, 3, 2, w, x + 1, y + 1, z + 4, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(16, 9, 5, w, x + 2, y + 1, z + 1, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(12, 7, 1, w, x + 2, y + 4, z + 2, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(14, 7, 1, w, x + 4, y + 6, z + 2, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(14, 5, 1, w, x + 4, y + 7, z + 3, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(3, 9, 5, w, x + 2, y + 4, z + 1, Blocks.air);
		WorldGenAPI.addRectangle(15, 7, 2, w, x + 2, y + 1, z + 2, Blocks.air);
		WorldGenAPI.addRectangle(11, 7, 5, w, x + 6, y + 1, z + 2, Blocks.air);
		WorldGenAPI.addRectangle(11, 5, 1, w, x + 6, y + 6, z + 3, Blocks.air);
		WorldGenAPI.addRectangle(15, 7, 1, w, x + 2, y, z + 2, IceikaBlocks.workshopCarpet);
		WorldGenAPI.addRectangle(10, 3, 1, w, x + 6, y, z + 4, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(8, 1, 2, w, x + 7, y + 1, z + 5, IceikaBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(1, 7, 1, w, x + 5, y + 3, z + 2, Blocks.air);
		WorldGenAPI.addRectangle(11, 1, 3, w, x + 6, y + 1, z + 2, IceikaBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(11, 1, 3, w, x + 6, y + 1, z + 8, IceikaBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(14, 1, 2, w, x + 3, y + 1, z + 1, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(14, 1, 2, w, x + 3, y + 1, z + 9, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(11, 1, 2, w, x + 6, y + 3, z + 1, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(11, 1, 2, w, x + 6, y + 3, z + 9, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(3, 7, 1, w, x + 2, y + 3, z + 2, IceikaBlocks.snowBricks);
		w.setBlock(x + 1, y + 1, z + 4, Blocks.air);
		w.setBlock(x + 1, y + 2, z + 4, Blocks.air);
		w.setBlock(x + 1, y + 1, z + 6, Blocks.air);
		w.setBlock(x + 1, y + 2, z + 6, Blocks.air);
		w.setBlock(x + 6, y + 3, z + 2, IceikaBlocks.workshopLamp);
		w.setBlock(x + 6, y + 3, z + 8, IceikaBlocks.workshopLamp);
		w.setBlock(x + 16, y + 3, z + 2, IceikaBlocks.workshopLamp);
		w.setBlock(x + 16, y + 3, z + 8, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 7, 1, w, x + 5, y + 5, z + 2, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(1, 5, 1, w, x + 5, y + 6, z + 3, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(1, 7, 1, w, x + 17, y + 5, z + 2, IceikaBlocks.frostedGlass); 
		WorldGenAPI.addRectangle(1, 5, 1, w, x + 17, y + 6, z + 3, IceikaBlocks.frostedGlass);
		ItemDoor.placeDoorBlock(w, x + 1, y + 1, z + 4, 0, IceikaBlocks.steelDoorBlock);
		ItemDoor.placeDoorBlock(w, x + 1, y + 1, z + 6, 7, IceikaBlocks.steelDoorBlock);
		w.setBlock(x, y, z, IceikaBlocks.frozenGrass);
		w.setBlock(x, y, z + 10, IceikaBlocks.frozenGrass);
		WorldGenAPI.placeIceikaChest(w, x + 15, y + 1, z + 5, 1);
    	
		EntityWorkshopMerchant mer = new EntityWorkshopMerchant(w);
    	EntityWorkshopTinkerer tink = new EntityWorkshopTinkerer(w);
    	if(!w.isRemote){
    		mer.setLocationAndAngles(x + 10, y + 1, z + 4, 0.0F, 0.0F);
    		tink.setLocationAndAngles(x + 10, y + 1, z + 8, 0.0F, 0.0F);
    		w.spawnEntityInWorld(mer);
    		w.spawnEntityInWorld(tink);
    	}
		return true;
	}
}