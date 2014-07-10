package net.divinerpg.dimensions.iceika.village;

import java.util.Random;

import net.divinerpg.api.items.ItemModDoor;
import net.divinerpg.api.worldgen.WorldGenAPI;
import net.divinerpg.blocks.iceika.container.tile_entity.TileEntityFrostedChest;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.divinerpg.utils.items.IceikaItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLights extends WorldGenerator {

	@Override
	public boolean generate(World var1, Random var2, int var3, int var4, int var5) {
		return false;
	}

	//Made all the light classes into 1 class, because its a waste to have multiple of them with very little code
	public static class Light1 extends WorldGenLights {

		@Override
		public boolean generate(World w, Random r, int x, int y, int z) {
			WorldGenAPI.addRectangle(5, 1, 1, w, x, y, z, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(3, 1, 1, w, x + 1, y, z + 1, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(3, 1, 1, w, x + 1, y, z - 1, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(1, 1, 1, w, x + 2, y, z - 2, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(1, 1, 1, w, x + 2, y, z + 2, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(3, 1, 1, w, x + 1, y + 1, z, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(1, 3, 1, w, x + 2, y + 1, z - 1, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(1, 1, 5, w, x + 2, y, z, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(1, 3, 1, w, x + 2, y + 4, z - 1, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(1, 1, 2, w, x + 2, y + 4, z - 1, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(1, 1, 2, w, x + 2, y + 4, z + 1, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(1, 1, 1, w, x + 2, y + 6, z - 1, IceikaBlocks.workshopLamp);
			WorldGenAPI.addRectangle(1, 1, 1, w, x + 2, y + 6, z + 1, IceikaBlocks.workshopLamp);
			return true;
		}
	}

	public static class Light2 extends WorldGenLights {

		@Override
		public boolean generate(World w, Random r, int x, int y, int z) {
			WorldGenAPI.addRectangle(3, 3, 2, w, x, y, z - 1, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(5, 5, 2, w, x - 1, y - 1, z - 2, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(5, 1, 2, w, x - 1, y, z, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(1, 5, 2, w, x + 1, y, z - 2, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(1, 1, 6, w, x + 1, y, z, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(3, 1, 1, w, x, y + 6, z, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(1, 3, 1, w, x + 1, y + 6, z - 1, IceikaBlocks.coalstone);
			w.setBlock(x + 1, y + 5, z + 1, IceikaBlocks.workshopLamp);
			w.setBlock(x + 1, y + 5, z - 1, IceikaBlocks.workshopLamp);
			w.setBlock(x, y + 5, z, IceikaBlocks.workshopLamp);
			w.setBlock(x + 2, y + 5, z, IceikaBlocks.workshopLamp);
			return true;
		}
	}

	public static class Light3 extends WorldGenLights {

		@Override
		public boolean generate(World w, Random r, int x, int y, int z) {
			WorldGenAPI.addRectangle(3, 1, 1, w, x + 1, y + 1, z, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(1, 3, 1, w, x + 2, y + 1, z - 1, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(1, 1, 5, w, x + 2, y, z, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(1, 3, 1, w, x + 2, y + 3, z - 1, IceikaBlocks.coalstone);
			WorldGenAPI.addRectangle(1, 1, 1, w, x + 2, y + 5, z, IceikaBlocks.workshopLamp);
			return true;
		}
	}
}