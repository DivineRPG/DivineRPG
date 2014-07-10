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

public class WorldGenHouse3 extends WorldGenerator{

	public boolean locationIsValidSpawn(World w, int x, int y, int z){
		for(int i = 0; i < 10; i++) {
			for(int l = 0; l < 10; l++) {
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
		WorldGenAPI.addRectangle(10, 10, 3, w, x, y + 1, z, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(8, 8, 4, w, x + 1, y + 1, z + 1, Blocks.air);
		WorldGenAPI.addRectangle(8, 8, 1, w, x + 1, y + 4, z + 1, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(6, 6, 1, w, x + 2, y + 4, z + 2, Blocks.air);
		WorldGenAPI.addRectangle(6, 6, 1, w, x + 2, y + 5, z + 2, IceikaBlocks.snowBricks);
		WorldGenAPI.addRectangle(8, 8, 1, w, x + 1, y, z + 1, IceikaBlocks.workshopCarpet);
		WorldGenAPI.addRectangle(4, 1, 4, w, x + 3, y, z, IceikaBlocks.coalstone);
		ItemDoor.placeDoorBlock(w, x + 5, y + 1, z, 1, IceikaBlocks.steelDoorBlock);
		ItemDoor.placeDoorBlock(w, x + 4, y + 1, z, 1, IceikaBlocks.steelDoorBlock);
		WorldGenAPI.addRectangle(1, 1, 3, w, x, y + 1, z, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 1, 3, w, x + 9, y + 1, z, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 1, 3, w, x, y + 1, z + 9, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 1, 3, w, x + 9, y + 1, z + 9, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 3, 3, w, x + 1, y + 1, z + 1, IceikaBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(3, 1, 1, w, x + 1, y + 1, z + 8, IceikaBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(1, 3, 3, w, x + 4, y + 1, z + 6, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 2, 1, w, x + 4, y + 4, z + 6, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 3, 4, w, x + 5, y + 1, z + 5, IceikaBlocks.coalstone);
		WorldGenAPI.addRectangle(1, 2, 1, w, x + 5, y + 3, z + 7, IceikaBlocks.workshopLamp);
		WorldGenAPI.addRectangle(1, 2, 2, w, x + 5, y + 1, z + 7, IceikaBlocks.workshopBookcase);
		WorldGenAPI.addRectangle(1, 1, 4, w, x + 6, y + 1, z + 6, IceikaBlocks.coalstone);
		WorldGenAPI.addBlock(w, x + 1, y + 2, z + 1, IceikaBlocks.workshopLamp);
		WorldGenAPI.addBlock(w, x + 1, y, z + 8, IceikaBlocks.workshopLamp);
		WorldGenAPI.addBlock(w, x + 8, y - 1, z + 1, IceikaBlocks.workshopLamp);
		WorldGenAPI.addBlock(w, x + 8, y - 1, z + 8, IceikaBlocks.workshopLamp);
		WorldGenAPI.addBlock(w, x + 5, y, z + 5, IceikaBlocks.coalstoneFurnace);
		WorldGenAPI.placeIceikaChest(w, x + 4, y + 1, z + 5, 2);
		WorldGenAPI.addBlock(w, x + 6, y + 1, z + 9, IceikaBlocks.frostedGlass);
		WorldGenAPI.addBlock(w, x + 9, y + 1, z + 6, IceikaBlocks.frostedGlass);
		WorldGenAPI.addBlock(w, x + 9, y + 1, z + 3, IceikaBlocks.frostedGlass);
		WorldGenAPI.addBlock(w, x, y + 1, z + 7, IceikaBlocks.frostedGlass);
		WorldGenAPI.addBlock(w, x, y + 1, z + 5, IceikaBlocks.frostedGlass);
		EntityWorkshopMerchant mer = new EntityWorkshopMerchant(w);
		EntityWorkshopTinkerer tink = new EntityWorkshopTinkerer(w);

		if(!w.isRemote){
			mer.setLocationAndAngles(x + 3, y + 1, z + 3, 0.0F, 0.0F);
			tink.setLocationAndAngles(x + 7, y + 1, z + 3, 0.0F, 0.0F);
			w.spawnEntityInWorld(tink);
			w.spawnEntityInWorld(mer);
		}
		return true;
	}
}