package divinerpg.blocks.iceika;

import divinerpg.blocks.base.BlockMod;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.WorldEntitySpawner;

import java.util.Random;

public class BlockFrostedAllure extends BlockMod {
    public BlockFrostedAllure(String name) {
        super(name, 0.8F);
        ticksRandomly(this.getDefaultState());
    }

    @Deprecated
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        //TODO - Spawns below the allure for some reason even though it gets top block
        WorldEntitySpawner.performWorldGenSpawning(worldIn, worldIn.getBiome(pos), pos.getX() + 8, pos.getZ() + 8, random);
        this.tick(state, worldIn, pos, random);
    }

}
