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

public class WorldGenWorkShop extends WorldGenerator{
	
	public boolean locationIsValidSpawn(World w, int x, int y, int z){
		for(int i = 0; i < 13; i++) {
			for(int l = 0; l < 13; l++) {
				if(w.getBlock(x + i, y, z + l) != IceikaBlocks.frozenGrass) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean generate(World w, Random r, int x, int y, int z) {
		if(!locationIsValidSpawn(w, x, y, z) || !locationIsValidSpawn(w, x + 3, y, z) || !locationIsValidSpawn(w, x + 3, y, z + 3) || !locationIsValidSpawn(w, x, y, z + 3))
			return false;
		WorldGenAPI.addRectangle(14, 14, 1, w, x, y, z, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(14, 14, 1, w, x, y + 1, z, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(14, 14, 1, w, x, y + 2, z, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(14, 14, 1, w, x, y + 3, z, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(14, 14, 1, w, x, y + 4, z, IceikaBlocks.snowBricks);
		WorldGenAPI.addCube(12, w, x + 1, y, z + 1, Blocks.air);
		WorldGenAPI.addRectangle(12, 12, 1, w, x + 1, y + 5, z + 1, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(10, 10, 1, w, x + 2, y + 5, z + 2, Blocks.air);
		WorldGenAPI.addRectangle(10, 10, 1, w, x + 2, y + 6, z + 2, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(8, 8, 1, w, x + 3, y + 6, z + 3, Blocks.air);
		WorldGenAPI.addRectangle(8, 8, 1, w, x + 3, y + 7, z + 3, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(6, 6, 1, w, x + 4, y + 7, z + 4, Blocks.air);
		WorldGenAPI.addRectangle(6, 6, 1, w, x + 4, y + 8, z + 4, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(4, 4, 1, w, x + 5, y + 8, z + 5, Blocks.air);
		WorldGenAPI.addRectangle(4, 4, 1, w, x + 5, y + 9, z + 5, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(2, 2, 1, w, x + 6, y + 9, z + 6, Blocks.air);
		WorldGenAPI.addRectangle(2, 2, 1, w, x + 6, y + 9, z + 6, IceikaBlocks.frostedGlass);
		WorldGenAPI.addRectangle(12, 12, 1, w, x + 1, y, z + 1, IceikaBlocks.workshopCarpet);
		WorldGenAPI.addRectangle(10, 10, 1, w, x + 2, y, z + 2, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(8, 8, 1, w, x + 3, y, z + 3, IceikaBlocks.workshopCarpet);
		WorldGenAPI.addRectangle(6, 6, 1, w, x + 4, y, z + 4, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(4, 4, 1, w, x + 5, y, z + 5, IceikaBlocks.workshopCarpet);
		WorldGenAPI.addRectangle(4, 4, 1, w, x + 5, y, z + 5, IceikaBlocks.workshopCarpet);
		WorldGenAPI.addRectangle(6, 6, 1, w, x + 4, y + 4, z + 4, IceikaBlocks.brittleLeaves);
		WorldGenAPI.addRectangle(4, 4, 1, w, x + 5, y + 5, z + 5, IceikaBlocks.brittleLeaves);
		WorldGenAPI.addRectangle(2, 2, 1, w, x + 6, y + 6, z + 6, IceikaBlocks.brittleLeaves);
		WorldGenAPI.addRectangle(2, 2, 5, w, x + 6, y + 1, z + 6, IceikaBlocks.frozenWood);
		WorldGenAPI.addRectangle(2, 2, 3, w, x + 1, y + 1, z + 1, IceikaBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(2, 2, 3, w, x + 11, y + 1, z + 11, IceikaBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(2, 2, 3, w, x + 11, y + 1, z + 1, IceikaBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(2, 2, 3, w, x + 1, y + 1, z + 11, IceikaBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(1, 1, 3, w, x + 2, y, z + 2, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 1, 3, w, x + 11, y, z + 11, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 1, 3, w, x + 11, y, z + 2, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 1, 3, w, x + 2, y, z + 11, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 1, 3, w, x + 2, y + 1, z + 2, Blocks.air);
		WorldGenAPI.addRectangle(1, 1, 3, w, x + 11, y + 1, z + 11, Blocks.air);
		WorldGenAPI.addRectangle(1, 1, 3, w, x + 11, y + 1, z + 2, Blocks.air);
		WorldGenAPI.addRectangle(1, 1, 3, w, x + 2, y + 1, z + 11, Blocks.air);
		WorldGenAPI.placeIceikaChest(w, x + 7, y + 1, z + 5, 2);
		WorldGenAPI.placeIceikaChest(w, x + 8, y + 1, z + 6, 2);
		WorldGenAPI.addRectangle(4, 1, 3, w, x + 5, y + 1, z, IceikaBlocks.coalstone);
		ItemDoor.placeDoorBlock(w, x + 6, y + 1, z, 4, IceikaBlocks.steelDoorBlock);
		ItemDoor.placeDoorBlock(w, x + 7, y + 1, z, 1, IceikaBlocks.steelDoorBlock);
		EntityWorkshopMerchant mer = new EntityWorkshopMerchant(w);
    	EntityWorkshopTinkerer tink = new EntityWorkshopTinkerer(w);
    	if(!w.isRemote){
    		mer.setLocationAndAngles(x + 9, y + 1, z + 4, 0.0F, 0.0F);
    		tink.setLocationAndAngles(x + 5, y + 1, z + 4, 0.0F, 0.0F);
    		w.spawnEntityInWorld(mer);
    		w.spawnEntityInWorld(tink);
    	}
		return true;
	}
}