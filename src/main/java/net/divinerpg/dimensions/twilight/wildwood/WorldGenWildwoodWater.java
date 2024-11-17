package net.divinerpg.dimensions.twilight.wildwood;

import java.util.Random;

import net.divinerpg.utils.blocks.TwilightBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWildwoodWater extends WorldGenerator {
	
    public boolean generate(World world, Random rand, int i, int j, int k) {
    	
    	if (world.getBlock(i, j, k) != TwilightBlocks.wildwoodGrass || world.getBlock(i, j-1, k).getMaterial() != Material.air) return false;
      
    	world.setBlock(i, j, k, Blocks.flowing_water, 0, 2);
    	return true;
    }
}