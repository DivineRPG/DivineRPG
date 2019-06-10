package naturix.divinerpg.dimensions.arcana.components;

import java.util.Random;

import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.chunk.Chunk;

public class DungeonCeiling extends DungeonComponentBase {

    @Override
    public boolean generate(Chunk chunk, Random rand, int x, int y, int z) {
        Block dungeonBricks = ModBlocks.degradedBrick;
        int scanX, scanZ;

        for (scanX = x; scanX < x + 16; scanX++) {
            for (scanZ = z; scanZ < z + 16; scanZ++) {
                this.setBlock(chunk, scanX, y, scanZ, dungeonBricks);
            }
        }
        return true;
    }
}
