package divinerpg.dimensions.vethea.all;

import java.util.Random;

import divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenConeDown extends WorldGenerator {
	
	private Block block;
	
	public WorldGenConeDown(Block b) {
		this.block = b;
	}
	
	@Override
	public boolean generate(World par1, Random par2, BlockPos pos) {
		int par3 = pos.getX();
		int par4 = pos.getY();
		int par5 = pos.getZ();

		int var2 = par2.nextInt(3);
		for (int i = 0; i < var2; i++) {
			this.placeBlockCircle(par1, par3, par4 - i, par5, var2 - i);
		}
		return true;
	}
	
	void placeBlockCircle (World par1World, int x, int y, int z, int radius) {
		for (int i = 0; i < radius*4; i++) {
			for (float j = 0; j < 2*Math.PI*i; j += 0.5)
			{
				par1World.setBlockState(new BlockPos((int)Math.floor(x + Math.sin(j) * i), y, (int)Math.floor(z + Math.cos(j) * i)), block.getDefaultState());
				par1World.setBlockState(new BlockPos((int)Math.floor(x + Math.sin(j) * i), y-1, (int)Math.floor(z + Math.cos(j) * i)), ModBlocks.dreamGrass.getDefaultState());
			}
		}
	}
}