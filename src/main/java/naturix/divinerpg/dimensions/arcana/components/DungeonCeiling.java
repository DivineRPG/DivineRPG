package naturix.divinerpg.dimensions.arcana.components;

import java.util.Random;

import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.Chunk;

public class DungeonCeiling extends DungeonComponentBase {

    @Override
    public boolean generate(Chunk chunk, Random rand, int x, int y, int z) {
        BlockPos.MutableBlockPos mutPos = new BlockPos.MutableBlockPos(x, y, z);
        IBlockState dungeonBricks = ModBlocks.degradedBrick.getDefaultState();
        int scanX, scanZ;

        for (scanX = x; scanX < x + 16; scanX++) {
            for (scanZ = z; scanZ < z + 16; scanZ++) {
                mutPos.setPos(scanX, y, scanZ);
                chunk.setBlockState(mutPos, dungeonBricks);
            }
        }
        return true;
    }
}
