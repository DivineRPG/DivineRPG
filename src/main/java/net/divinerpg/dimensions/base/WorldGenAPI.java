package net.divinerpg.dimensions.base;

import java.util.Random;

import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.items.IceikaItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntitySign;
import net.minecraft.world.World;

public class WorldGenAPI {

	public static void addCube(int size, World w, int x, int y, int z, Block b){
		for(int x1 = 0; x1 < size; x1++){
			for(int z1 = 0; z1 < size; z1++){
				for(int y1 = 0; y1 < size; y1++){
					w.setBlock(x + x1, y + y1 + 1, z + z1, b);
				}
			}
		}
	}
	
	public static void addBlock(World w, int x, int y, int z, Block b) {
		addCube(1, w, x, y, z, b);
	}

	public static void addHollowCube(int size, World w, int x, int y, int z, Block b){
		for(int x1 = 0; x1 < size; x1++){
			for(int z1 = 0; z1 < size; z1++){
				for(int y1 = 0; y1 < size; y1++){
					w.setBlock(x + x1, y + y1 + 1, z + z1, b);
				}
			}
		}

		for(int x1 = 0; x1 < size - 2; x1++){
			for(int z1 = 0; z1 < size - 2; z1++){
				for(int y1 = 0; y1 < size - 2; y1++){
					w.setBlock(x + x1 + 1, y + y1 + 2, z + z1 + 1, Blocks.air);
				}
			}
		}
	}

	public static void addRectangle(int east, int south, int height, World w, int x, int y, int z, Block b){
		for(int x1 = 0; x1 < east; x1++){
			for(int z1 = 0; z1 < south; z1++){
				for(int y1 = 0; y1 < height; y1++){
					w.setBlock(x + x1, y + y1, z + z1, b);
				}
			}
		}
	}
	
	public static void addCornerlessRectangle(int east, int south, int height, World w, int x, int y, int z, Block b){
		addRectangle(east, south, height, w, x, y, z, b);
		addRectangle(1, 1, height, w, x, y, z, Blocks.air);
		addRectangle(1, 1, height, w, x+east-1 , y, z, Blocks.air);
		addRectangle(1, 1, height, w, x, y, z+south-1, Blocks.air);
		addRectangle(1, 1, height, w, x+east-1, y, z+south-1, Blocks.air);
	}

	public static void placeChestWithContents(World w, int x, int y, int z, int meta, int amountOfItems, boolean trapped, ItemStack...is){
		Random r = new Random();
		if(trapped) w.setBlock(x, y, z, Blocks.trapped_chest, meta, 2);
		else w.setBlock(x, y, z, Blocks.chest, meta, 2);
		TileEntityChest chest = (TileEntityChest)w.getTileEntity(x, y, z);
		if(chest != null && !w.isRemote){// DOESNT WORK IF GENERATING 1 ITEM
			for(int i = 0; i < chest.getSizeInventory(); i++){
				ItemStack it = is[r.nextInt(is.length) + 1];
				chest.setInventorySlotContents(chest.getSizeInventory(), it);
			}
		}
	}
	
	public static void placeModdedChestWithContents(World w, int x, int y, int z, int meta, int amountOfItems, Block c, ItemStack...is){
		Random r = new Random();
		w.setBlock(x, y, z, c, meta, 2);
		TileEntityChest chest = (TileEntityChest)w.getTileEntity(x, y, z);
		if(chest != null && !w.isRemote){
			for(int i = 0; i < chest.getSizeInventory(); i++){
				ItemStack it = is[r.nextInt(is.length) + 1];
				chest.setInventorySlotContents(chest.getSizeInventory(), it);
			}
		}
	}
	
	//Matches the 1.12.2 iceika_chest_hut loot table: {item, weight, min, max}
	private static final Object[][] ICEIKA_CHEST_LOOT = {
		{IceikaItems.iceShards, 12, 1, 8},
		{IceikaItems.snowCones, 7, 1, 8},
		{IceikaItems.chocolateLog, 7, 1, 4},
		{IceikaItems.peppermints, 6, 1, 5},
		{IceikaItems.eggNog, 4, 1, 3},
		{IceikaItems.fruitCake, 4, 1, 3},
		{IceikaItems.soundOfCarols, 2, 1, 1},
		{IceikaItems.icicleBane, 2, 1, 1},
		{IceikaItems.santaCap, 1, 1, 1},
		{IceikaItems.santaTunic, 1, 1, 1},
		{IceikaItems.santaPants, 1, 1, 1},
		{IceikaItems.santaBoots, 1, 1, 1}
	};

	public static void placeIceikaChest(World w, int x, int y, int z, int meta){
		Random r = new Random();
		w.setBlock(x, y, z, IceikaBlocks.decorativeFrostedChest, meta, 2);
		TileEntityChest chest = (TileEntityChest)w.getTileEntity(x, y, z);
		if(chest != null && !w.isRemote){
			putInRandomSlot(chest, r, new ItemStack(IceikaItems.snowflake));
			int totalWeight = 0;
			for(Object[] entry : ICEIKA_CHEST_LOOT) totalWeight += (Integer)entry[1];
			int rolls = r.nextInt(5) + 4;
			for(int i = 0; i < rolls; i++){
				int pick = r.nextInt(totalWeight);
				for(Object[] entry : ICEIKA_CHEST_LOOT){
					pick -= (Integer)entry[1];
					if(pick < 0){
						int min = (Integer)entry[2], max = (Integer)entry[3];
						putInRandomSlot(chest, r, new ItemStack((Item)entry[0], min + r.nextInt(max - min + 1)));
						break;
					}
				}
			}
		}
	}

	private static void putInRandomSlot(TileEntityChest chest, Random r, ItemStack is){
		for(int tries = 0; tries < 10; tries++){
			int slot = r.nextInt(chest.getSizeInventory());
			if(chest.getStackInSlot(slot) == null){
				chest.setInventorySlotContents(slot, is);
				return;
			}
		}
	}

	public static void placeSignWithText(World w, int x, int y, int z, int meta, String[] text, boolean standing){
		if(standing) w.setBlock(x, y, z, Blocks.standing_sign, meta, 2);
		else w.setBlock(x, y, z, Blocks.wall_sign, meta, 2);

		TileEntitySign sign = (TileEntitySign)w.getTileEntity(x, y, z);

		if(sign != null && !w.isRemote)
			sign.signText = text;
	}

	/*public static void addHollowRectangle(int east, int south, int height, World w, int x, int y, int z, Block b){
		for(int x1 = 0; x1 < east; x1++){
			for(int z1 = 0; z1 < south; z1++){
				for(int y1 = 0; y1 < height; y1++){
					w.setBlock(x + x1, y + y1, z + z1, b);
				}
			}
		}

		for(int x1 = 0; x1 < east; x1++){
			for(int z1 = 0; z1 < south; z1++){
				for(int y1 = 0; y1 < height - 2; y1++){
					w.setBlock(x + x1 + 1, y + y1 + 1, z + z1 + 1, Blocks.air);
				}
			}
		}
	}*/

	public static void addCone(int width, int length, int height, World w, int x, int y, int z, Block b){
		for(int x1 = 0; x1 < width; x1++){
			for(int z1 = 0; z1 < length; z1++){
				for(int y1 = 0; y1 < height; y1++){
					w.setBlock(x + x1, y + y1, z + z1, b);//WIP (Not working as of yet)
				}
			}
		}
	}
}