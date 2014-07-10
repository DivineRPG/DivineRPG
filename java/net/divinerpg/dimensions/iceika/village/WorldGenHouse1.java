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

public class WorldGenHouse1 extends WorldGenerator{
	
	public boolean locationIsValidSpawn(World w, int x, int y, int z){
		for(int i = 0; i < 11; i++) {
			for(int l = 0; l < 9; l++) {
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
		WorldGenAPI.addRectangle(9, 5, 3, w, x, y + 1, z, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(7, 3, 3, w, x + 1, y + 1, z + 1, Blocks.air);
		WorldGenAPI.addRectangle(9, 3, 1, w, x, y, z + 1, IceikaBlocks.workshopCarpet);
		WorldGenAPI.addRectangle(7, 1, 3, w, x + 1, y + 1, z + 4, Blocks.air);
		WorldGenAPI.addRectangle(7, 6, 3, w, x + 1, y + 1, z + 3, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(5, 5, 3, w, x + 2, y + 1, z + 3, Blocks.air);
		WorldGenAPI.addRectangle(7, 1, 3, w, x + 1, y + 1, z + 3, Blocks.air);
		WorldGenAPI.addRectangle(5, 5, 1, w, x + 2, y, z + 3, IceikaBlocks.workshopCarpet);
		WorldGenAPI.addRectangle(1, 1, 2, w, x, y + 1, z + 2, Blocks.air);
		WorldGenAPI.addRectangle(1, 1, 2, w, x + 8, y + 1, z + 2, Blocks.air);
		ItemDoor.placeDoorBlock(w, x, y + 1, z + 2, 0, IceikaBlocks.steelDoorBlock);
		ItemDoor.placeDoorBlock(w, x + 8, y + 1, z + 2, 2, IceikaBlocks.steelDoorBlock);
		WorldGenAPI.addRectangle(1, 3, 1, w, x - 1, y, z + 1, IceikaBlocks.coalstone);
		w.setBlock(x - 1, y + 1, z, IceikaBlocks.snowBricks);
		w.setBlock(x - 1, y + 1, z + 4, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(1, 3, 1, w, x + 9, y, z + 1, IceikaBlocks.workshopBookcase);
		w.setBlock(x + 9, y + 1, z, IceikaBlocks.snowBricks);
		w.setBlock(x + 9, y + 1, z + 4, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(7, 3, 1, w, x + 1, y + 4, z + 1, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(5, 5, 1, w, x + 2, y + 4, z + 4, IceikaBlocks.snowBricks);
		w.setBlock(x + 1, y, z + 3, IceikaBlocks.workshopLamp);
		w.setBlock(x + 7, y, z + 3, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(5, 1, 1, w, x + 2, y + 1, z + 7, IceikaBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(3, 1, 2, w, x + 3, y + 1, z + 7, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 1, 8, w, x + 4, y + 1, z + 7, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(3, 3, 1, w, x + 3, y + 5, z + 6, IceikaBlocks.snowBricks);
		w.setBlock(x + 4, y + 1, z + 7, IceikaBlocks.coalstoneFurnace, 2, 2);
		w.setBlock(x + 4, y + 8, z + 7, IceikaBlocks.workshopLamp);
		w.setBlock(x + 3, y + 2, z, IceikaBlocks.frostedGlass);
		w.setBlock(x + 1, y + 2, z, IceikaBlocks.frostedGlass);
		w.setBlock(x + 5, y + 2, z, IceikaBlocks.frostedGlass);
		w.setBlock(x + 7, y + 2, z, IceikaBlocks.frostedGlass);
		w.setBlock(x + 3, y + 3, z + 8, IceikaBlocks.frostedGlass);
		w.setBlock(x + 5, y + 3, z + 8, IceikaBlocks.frostedGlass);
		
		EntityWorkshopMerchant mer = new EntityWorkshopMerchant(w);
    	EntityWorkshopTinkerer tink = new EntityWorkshopTinkerer(w);
    	if(!w.isRemote){
    		mer.setLocationAndAngles(x + 4, y + 1, z + 4, 0.0F, 0.0F);
    		tink.setLocationAndAngles(x + 6, y + 1, z + 4, 0.0F, 0.0F);
    		w.spawnEntityInWorld(mer);
    		w.spawnEntityInWorld(tink);
    	}
		return true;
	}
}