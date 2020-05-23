package divinerpg.dimensions.mortum;

import divinerpg.dimensions.wildwood.LargeWildWoodTree;
import divinerpg.registry.BlockRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by LiteWolf101 on 10/8/2018.
 */
public class MortumTreeLarge extends LargeWildWoodTree {

    public MortumTreeLarge(boolean notify, int minTrunkHeight) {
        super(notify, minTrunkHeight, BlockRegistry.mortumLog.getDefaultState(), BlockRegistry.mortumLeaves.getDefaultState(), BlockRegistry.mortumGrass);
    }

    @Override
    public boolean generate(World world, Random random, BlockPos blockPos) {
        int trunkHeight = random.nextInt(4) + minTrunkHeight;
        int treeHeight = 10 + trunkHeight;
        IBlockState groundState = world.getBlockState(blockPos.down());

        //return false if these conditions are met
        // Spawns only on grass
        if (blockPos.getY() <= 13 && blockPos.getY() + treeHeight + 1 >= world.getHeight()
                || groundState.getMaterial() != Material.GROUND) {
            return false;
        }

        return generateTree(world, blockPos, treeHeight, trunkHeight);
    }
}
