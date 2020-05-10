package divinerpg.dimensions.iceika;


import java.util.List;
import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.feature.WorldGenLakes;

public class ChunkProviderIceika implements  IChunkGenerator
{

    private final World worldObj;
    private Random rand;
    private Biome[] biomesForGeneration;

	private final MapGenBase caveGenerator;
    private IceikaTerrainGenerator terraingen = new IceikaTerrainGenerator();

	public ChunkProviderIceika(World world, long seed)
	{
        this.worldObj = world;
        this.rand = new Random((seed + 516) * 314);
        terraingen.setup(worldObj, rand);
		caveGenerator = new IceikaCaves();
	}


	public void generateTerrain(int x, int z, ChunkPrimer chunkPrimer) {
		int i = 4;
		int k = i + 1;
		int l = 17;
		int i1 = i + 1;
		int j = worldObj.getSeaLevel(); //sea level

		for (int j1 = 0; j1 < i; ++j1)
			for (int k1 = 0; k1 < i; ++k1)
				for (int l1 = 0; l1 < 16; ++l1) {
					for (int i2 = 0; i2 < 8; ++i2) {
						for (int j2 = 0; j2 < 4; ++j2) {
							for (int k2 = 0; k2 < 4; ++k2) {
								IBlockState iblockstate = null;
								if (l1 * 8 + i2 < j)
								{
									iblockstate = Blocks.WATER.getDefaultState();
								}

								int l2 = j2 + j1 * 4;
								int i3 = i2 + l1 * 8;
								int j3 = k2 + k1 * 4;
								chunkPrimer.setBlockState(l2, i3, j3, iblockstate);
							}
						}
					}
				}
	}

    @Override
    public Chunk generateChunk(int x, int z) {
        ChunkPrimer chunkprimer = new ChunkPrimer();

        // Setup biomes for terraingen
        this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, x * 4 - 2, z * 4 - 2, 10, 10);
        generateTerrain(x, z, chunkprimer);
        terraingen.setBiomesForGeneration(biomesForGeneration);
        terraingen.generate(x, z, chunkprimer);

		// Setup biomes again for actual biome decoration
		this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomes(this.biomesForGeneration, x * 16, z * 16, 16, 16);
		// This will replace stone with the biome specific stones
		terraingen.replaceBiomeBlocks(x, z, chunkprimer, this, biomesForGeneration);

		caveGenerator.generate(worldObj, x, z, chunkprimer);

        Chunk chunk = new Chunk(this.worldObj, chunkprimer, x, z);

        byte[] biomeArray = chunk.getBiomeArray();
        for (int i = 0; i < biomeArray.length; ++i) {
            biomeArray[i] = (byte)Biome.getIdForBiome(this.biomesForGeneration[i]);
        }

        chunk.generateSkylightMap();
        return chunk;
    }

	@Override
	public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) 
	{
		Biome biome = this.worldObj.getBiomeProvider().getBiome(pos);

		return biome != null ? biome.getSpawnableList(creatureType) : null;
	}

	@Override
	public boolean generateStructures(Chunk chunkIn, int chunkX, int chunkZ) 
	{
		return true;
	}

	@Override
	public void recreateStructures(Chunk p_180514_1_, int x, int z)
	{

	}

	@Override
	public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos)
	{
		return false;
	}

	@Override
	public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored)
	{
		return null;
	}

	@Override
	public void populate(int chunkX, int chunkZ)
	{
		int x = chunkX * 16;
		int z = chunkZ * 16;

		BlockPos pos = new BlockPos(x, 0, z);
        ChunkPos chunkpos = new ChunkPos(x, z);

		Biome biome = this.worldObj.getBiome(pos.add(16, 0, 16));

        this.rand.setSeed(this.worldObj.getSeed());
        long k = this.rand.nextLong() / 2L * 2L + 1L;
        long l = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long)x * k + (long)z * l ^ this.worldObj.getSeed());
		biome.decorate(this.worldObj, this.rand, pos);
		
		WorldEntitySpawner.performWorldGenSpawning(this.worldObj, biome, x + 8, z + 8, 16, 16, this.rand);


		boolean flag = false;

		net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, this, this.worldObj, this.rand, x, z, flag);

		if (biome != Biomes.DESERT && biome != Biomes.DESERT_HILLS && !flag)
			if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.worldObj, this.rand, x, z, flag, net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE))
			{
				int i1 = this.rand.nextInt(16) + 8;
				int j1 = this.rand.nextInt(256);
				int k1 = this.rand.nextInt(16) + 8;
				(new WorldGenLakes(Blocks.WATER)).generate(this.worldObj, this.rand, pos.add(i1, j1, k1));
			}
		pos = pos.add(8, 0, 8);

		if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.worldObj, this.rand, x, z, flag, net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE))
		{
			for (int k2 = 0; k2 < 16; ++k2)
			{
				for (int j3 = 0; j3 < 16; ++j3)
				{
					BlockPos blockpos1 = this.worldObj.getPrecipitationHeight(pos.add(k2, 0, j3));
					BlockPos blockpos2 = blockpos1.down();

					if (this.worldObj.canBlockFreezeWater(blockpos2))
					{
						this.worldObj.setBlockState(blockpos2, Blocks.ICE.getDefaultState(), 3);
					}

					if (this.worldObj.canSnowAt(blockpos1, true))
					{
						this.worldObj.setBlockState(blockpos1, Blocks.SNOW_LAYER.getDefaultState(), 3);
					}
				}
			}
		}//Forge: End ICE

	}

}