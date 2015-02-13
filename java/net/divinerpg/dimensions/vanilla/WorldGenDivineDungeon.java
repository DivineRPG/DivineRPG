package net.divinerpg.dimensions.vanilla;

import java.util.Random;

import net.divinerpg.blocks.base.tileentity.TileEntityStupidSpawner;
import net.divinerpg.utils.blocks.VanillaBlocks;
import net.divinerpg.utils.items.VanillaItemsOther;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenDivineDungeon extends WorldGenerator {

	public static final WeightedRandomChestContent[] items = new WeightedRandomChestContent[] {new WeightedRandomChestContent(VanillaItemsOther.rupeeIngot, 0, 1, 1, 2), new WeightedRandomChestContent(VanillaItemsOther.arlemiteIngot, 0, 1, 1, 3), new WeightedRandomChestContent(VanillaItemsOther.bloodgem, 0, 1, 3, 5), new WeightedRandomChestContent(VanillaItemsOther.realmiteIngot, 0, 1, 4, 8)};

	@Override
	public boolean generate(World world, Random rand, int x, int y, int z) {
		byte b0 = 3;
		int l = rand.nextInt(2) + 2;
		int i1 = rand.nextInt(2) + 2;
		int j1 = 0, k1, l1, i2;

		for(k1 = x - l - 1; k1 <= x + l + 1; ++k1) {
			for(l1 = y - 1; l1 <= y + b0 + 1; ++l1) {
				for(i2 = z - i1 - 1; i2 <= z + i1 + 1; ++i2) {
					Material material = world.getBlock(k1, l1, i2).getMaterial();
					if(l1 == y - 1 && !material.isSolid()) return false;      
					if(l1 == y + b0 + 1 && !material.isSolid()) return false;
					if((k1 == x - l - 1 || k1 == x + l + 1 || i2 == z - i1 - 1 || i2 == z + i1 + 1) && l1 == y && world.isAirBlock(k1, l1, i2) && world.isAirBlock(k1, l1 + 1, i2))
						++j1;
				}
			}
		}

		if(j1 >= 1 && j1 <= 5) {
			for(k1 = x - l - 1; k1 <= x + l + 1; ++k1) {
				for(l1 = y + b0; l1 >= y - 1; --l1) {
					for(i2 = z - i1 - 1; i2 <= z + i1 + 1; ++i2) {
						if(k1 != x - l - 1 && l1 != y - 1 && i2 != z - i1 - 1 && k1 != x + l + 1 && l1 != y + b0 + 1 && i2 != z + i1 + 1)
							world.setBlockToAir(k1, l1, i2);

						else if(l1 >= 0 && !world.getBlock(k1, l1 - 1, i2).getMaterial().isSolid())
							world.setBlockToAir(k1, l1, i2);

						else if(world.getBlock(k1, l1, i2).getMaterial().isSolid()) {
							if(l1 == y - 1 && rand.nextInt(4) != 0) world.setBlock(k1, l1, i2, VanillaBlocks.divineMossystone, 0, 2);
							else world.setBlock(k1, l1, i2, Blocks.cobblestone, 0, 2);
						}
					}
				}
			}
			k1 = 0;
			while(k1 < 2) {
				l1 = 0;
				while(true) {
					if(l1 < 3) {
						label101: {
						i2 = x + rand.nextInt(l * 2 + 1) - l;
						int j2 = z + rand.nextInt(i1 * 2 + 1) - i1;
						if (world.isAirBlock(i2, y, j2)) {
							int k2 = 0;
							if(world.getBlock(i2 - 1, y, j2).getMaterial().isSolid()) ++k2;
							if(world.getBlock(i2 + 1, y, j2).getMaterial().isSolid()) ++k2;
							if(world.getBlock(i2, y, j2 - 1).getMaterial().isSolid()) ++k2;
							if(world.getBlock(i2, y, j2 + 1).getMaterial().isSolid()) ++k2;
							if(k2 == 1) {
								world.setBlock(i2, y, j2, Blocks.chest, 0, 2);
								TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(i2, y, j2);
								if(tileentitychest != null) {
									WeightedRandomChestContent.generateChestContents(rand, items, tileentitychest, 5);
								}
								break label101;
							}
						}
						++l1;
						continue;
					}
					}
					++k1;
					break;
				}
			}
			
			switch(rand.nextInt(2)) {
			case 0:
				world.setBlock(x, y, z, VanillaBlocks.rotatickSpawner, 0, 2);break;
			case 1:
				world.setBlock(x, y, z, VanillaBlocks.enthralledDramcryxSpawner, 0, 2);break;
			}

			return true;
		}
		else return false;
	}
}
