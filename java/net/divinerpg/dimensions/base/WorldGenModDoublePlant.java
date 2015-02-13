package net.divinerpg.dimensions.base;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenModDoublePlant extends WorldGenerator {
	
	private Block block;
	
	public WorldGenModDoublePlant(Block b) {
		this.block = b;
	}

	@Override
    public boolean generate(World w, Random rand, int i, int j, int k) {
        boolean generated = false;

        for (int l = 0; l < 64; ++l)
        {
            int x = i + rand.nextInt(8) - rand.nextInt(8);
            int y = j + rand.nextInt(4) - rand.nextInt(4);
            int z = k + rand.nextInt(8) - rand.nextInt(8);

            if (w.isAirBlock(x, y, z) && (!w.provider.hasNoSky || y < 254) && this.block.canPlaceBlockAt(w, x, y, z)) {
                w.setBlock(x, y, z, this.block);
                w.setBlock(x, y+1, z, this.block, 1, 2);
                generated = true;
            }
        }

        return generated;
    }
}