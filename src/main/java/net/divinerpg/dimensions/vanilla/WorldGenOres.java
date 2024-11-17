package net.divinerpg.dimensions.vanilla;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class WorldGenOres {
	
	private int meta;
	
	public WorldGenOres() {
		meta = 0;
	}
	
	public WorldGenOres(int m) {
		meta = m;
	}
	
	public void generate(Block b, World w, Random r, Block genIn, int posX, int posY, int posZ, int veinSize) {
		int x = posX;
		int y = posY;
		int z = posZ;
		int[] arr = new int[veinSize];
		for(int i=0; i < veinSize; i++) {
			arr[i] = r.nextInt(6);
			for(int j=0; j < i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		for(int k=0; k < veinSize; k++) {
			if(veinSize <= 6) {
				x = posX;
				y = posY;
				z = posZ;
			}
			if(k != 0) {
				switch(arr[k]) {
				case 0:
					x++;
					break;
				case 1:
					x--;
					break;
				case 2:
					z++;
					break;
				case 3:
					z--;
					break;
				case 4:
					y++;
					break;
				case 5:
					y--;
					break;
				}
			}
			if(w.getBlock(x, y, z).isReplaceableOreGen(w, x, y, z, genIn))
				w.setBlock(x, y, z, b, meta, 2);
		}
	}
}
