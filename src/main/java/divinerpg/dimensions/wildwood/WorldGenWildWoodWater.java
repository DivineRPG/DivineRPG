package divinerpg.dimensions.wildwood;

import java.util.Random;

import divinerpg.registry.BlockRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWildWoodWater extends WorldGenerator {

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {
        BlockPos pos2 = new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ());
        if (world.getBlockState(pos) != BlockRegistry.wildwoodGrass
                || world.getBlockState(pos2).getMaterial() != Material.AIR)
            return false;

        world.setBlockState(pos, Blocks.FLOWING_WATER.getDefaultState(), 0);
        return true;
    }
}