package divinerpg.dimensions.arcana.components;

import java.util.Random;

import divinerpg.dimensions.arcana.ArcanaChunkPrimer;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.Block;

public class DungeonCeiling extends DungeonComponentBase {

    @Override
    public boolean generate(ArcanaChunkPrimer chunk, Random rand, int x, int y, int z) {
        Block dungeonBricks = BlockRegistry.degradedBrick;
        int scanX, scanZ;

        for (scanX = x; scanX < x + 16; scanX++) {
            for (scanZ = z; scanZ < z + 16; scanZ++) {
                this.setBlock(chunk, scanX, y, scanZ, dungeonBricks);
            }
        }
        return true;
    }
}
