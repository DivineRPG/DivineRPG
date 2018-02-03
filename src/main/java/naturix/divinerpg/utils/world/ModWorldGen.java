package naturix.divinerpg.utils.world;

import java.util.Random;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.utils.predicate.NetherGenPredicate;
import naturix.divinerpg.utils.predicate.StonePredicate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGen implements IWorldGenerator {

	// World Generators
	private WorldGenerator arlemite_overworld;
	private WorldGenerator bloodgem_nether;
	private WorldGenerator netherite_nether;
	private WorldGenerator realmite;
	private WorldGenerator rupee;


	/**
	 * The constructor initializes our fields
	 */
	public ModWorldGen() {
		arlemite_overworld = new WorldGenMinable(
				ModBlocks.oreArlemite.getDefaultState(), 3, new StonePredicate());
		bloodgem_nether = new WorldGenMinable(
				ModBlocks.orebloodgem.getDefaultState(), 5, new NetherGenPredicate());
		netherite_nether = new WorldGenMinable(
				ModBlocks.oreNetherite.getDefaultState(), 3, new NetherGenPredicate());
		realmite = new WorldGenMinable(
				ModBlocks.oreRealmite.getDefaultState(), 5, new StonePredicate());
	rupee = new WorldGenMinable(
			ModBlocks.oreRupee.getDefaultState(), 3, new StonePredicate());
	}

	/**
	 * Will generate our ore using the correct fields on where to generate
	 * @param generator The actual world generator which holds which block to place
	 * @param world The world to spawn the block in
	 * @param rand The random object used for randomisation
	 * @param chunk_X The chunks X position in the world
	 * @param chunk_Z The chunks Z position in the world
	 * @param chancesToSpawn How many times it will spawn per chunk
	 * @param minHeight The minimum height the ore can spawn
	 * @param maxHeight The maximum height the ore can spawn
	 */
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z,
			int chancesToSpawn, int minHeight, int maxHeight) {
		if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
			throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

		int heightDiff = maxHeight - minHeight + 1;
		for (int i = 0; i < chancesToSpawn; i++) {
			int x = chunk_X * 16 + rand.nextInt(16);
			int y = minHeight + rand.nextInt(heightDiff);
			int z = chunk_Z * 16 + rand.nextInt(16);
			generator.generate(world, rand, new BlockPos(x, y, z));
		}
	}

	/**
	 * Actually runs the world generator when called
	 */
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.getDimension()) {
		case 0: // Overworld
			this.runGenerator(arlemite_overworld, world, random, chunkX, chunkZ, 15, 1, 16);
			this.runGenerator(realmite, world, random, chunkX, chunkZ, 15, 1, 30);
			this.runGenerator(rupee, world, random, chunkX, chunkZ, 10, 1, 255);
			
			break;
		case 1: // End
			break;
		case -1: // Nether
			this.runGenerator(bloodgem_nether, world, random, chunkX, chunkZ, 30, 1, 255);
			this.runGenerator(netherite_nether, world, random, chunkX, chunkZ, 30, 1, 255);
			break;
		}
	}

}
