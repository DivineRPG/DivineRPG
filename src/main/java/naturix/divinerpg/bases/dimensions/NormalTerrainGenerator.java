package naturix.divinerpg.bases.dimensions;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NormalTerrainGenerator {
	
	private Block block;
	
	public NormalTerrainGenerator(Block b) {
		this.block = b;
	}

	public boolean generate(World w, Random rand, int i, int j, int k) {
        boolean generated = false;

        for (int l = 0; l < 64; ++l)
        {
            int x = i + rand.nextInt(8) - rand.nextInt(8);
            int y = j + rand.nextInt(4) - rand.nextInt(4);
            int z = k + rand.nextInt(8) - rand.nextInt(8);
            BlockPos pos = null;
            if (w.isAirBlock(pos) && (!w.provider.hasSkyLight() || y < 254) && this.block.canPlaceBlockAt(w, pos)) {
                w.setBlockState(pos, null);
                w.setBlockState(pos, null);
                DivineRPG.logger.info(pos + " is where stuff SHOULD be");
                generated = true;
            }
        }

        return generated;
    }
}