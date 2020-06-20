package divinerpg.dimensions.iceika;


import java.util.List;
import java.util.Random;

import divinerpg.registry.BlockRegistry;
import divinerpg.registry.StructureRegistry;
import divinerpg.structure.iceika.archerdungeon.ArcherDungeon;
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

public class ChunkProviderIceika implements IChunkGenerator
{

    private final World world;
    private Random rand;
    private Biome[] biomesForGeneration;

	private final MapGenBase caveGenerator;
    private IceikaTerrainGenerator terraingen = new IceikaTerrainGenerator();

    private ArcherDungeon archerDungeonGenerator;

	public ChunkProviderIceika(World world, long seed)
	{
        this.world = world;
        this.rand = new Random((seed + 516) * 314);
        terraingen.setup(world, rand);
		caveGenerator = new IceikaCaves();

		this.archerDungeonGenerator = new ArcherDungeon(world);
	}


	public void generateTerrain(int x, int z, ChunkPrimer chunkPrimer) {
		int i = 4;
		int k = i + 1;
		int l = 17;
		int i1 = i + 1;
		int j = world.getSeaLevel(); //sea level

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
        this.biomesForGeneration = this.world.getBiomeProvider().getBiomesForGeneration(this.biomesForGeneration, x * 4 - 2, z * 4 - 2, 10, 10);
        generateTerrain(x, z, chunkprimer);
        terraingen.setBiomesForGeneration(biomesForGeneration);
        terraingen.generate(x, z, chunkprimer);

		// Setup biomes again for actual biome decoration
		this.biomesForGeneration = this.world.getBiomeProvider().getBiomes(this.biomesForGeneration, x * 16, z * 16, 16, 16);
		// This will replace stone with the biome specific stones
		terraingen.replaceBiomeBlocks(x, z, chunkprimer, this, biomesForGeneration);

		caveGenerator.generate(world, x, z, chunkprimer);

		//Generate archer dungeon
		this.archerDungeonGenerator.generate(this.world, x, z, chunkprimer);

        Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
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
		Biome biome = this.world.getBiomeProvider().getBiome(pos);

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
		//HANDLE LATER!
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
		this.rand.setSeed(this.world.getSeed());
		long k = this.rand.nextLong() / 2L * 2L + 1L;
		long l = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(chunkX * k + chunkZ * l ^ this.world.getSeed());

		int baseX = chunkX * 16 + 1;
		int baseZ = chunkZ * 16 + 1;
		BlockPos pos = new BlockPos(baseX, 0, baseZ);
		Biome biome = this.world.getBiome(new BlockPos(baseX, 0, baseZ));

		ChunkPos chunkpos = new ChunkPos(chunkX, chunkZ);
		this.archerDungeonGenerator.generateStructure(this.world, this.rand, chunkpos);

		if(this.rand.nextInt(35) == 0) {
			int x = baseX + rand.nextInt(16);
			int z = baseZ + rand.nextInt(16);
			int y = world.getHeight(x, z);

			if(this.world.getBlockState(new BlockPos(x + 3, y - 1, z + 3)).getBlock() == BlockRegistry.frozenGrass) {
				int houseNumber = this.rand.nextInt(StructureRegistry.WORKSHOP_HOUSES.length);
				StructureRegistry.WORKSHOP_HOUSES[houseNumber].generate(world, this.rand, new BlockPos(x, y - 1, z));
				System.out.println("Iceika house " + houseNumber + " structure generated at: " + x + " " + y + " " + z);
			}
		}
		else if(this.rand.nextInt(15) == 0) {
			int x = baseX + rand.nextInt(16);
			int z = baseZ + rand.nextInt(16);
			int y = world.getHeight(x, z);

			if(this.world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == BlockRegistry.frozenGrass) {
				int lampNumber = this.rand.nextInt(StructureRegistry.COALSTONE_LAMPS.length);
				StructureRegistry.COALSTONE_LAMPS[lampNumber].generate(world, this.rand, new BlockPos(x, y - 1, z));
				System.out.println("Coalstone lamp " + lampNumber + " structure generated at: " + x + " " + y + " " + z);
			}
		}

		this.rand.setSeed(chunkX * k + chunkZ * l ^ this.world.getSeed());
		biome.decorate(this.world, this.rand, pos);
		WorldEntitySpawner.performWorldGenSpawning(this.world, biome, baseX + 8, baseZ + 8, 16, 16, this.rand);

		//Old code starts here, will probably need tweaking and rearranging

		/*
		boolean flag = false;

		net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, this, this.world, this.rand, x, z, flag);

		//Create lakes
		if (biome != Biomes.DESERT && biome != Biomes.DESERT_HILLS && !flag)
			if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, x, z, flag, net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE))
			{
				int i1 = this.rand.nextInt(16) + 8;
				int j1 = this.rand.nextInt(256);
				int k1 = this.rand.nextInt(16) + 8;
				(new WorldGenLakes(Blocks.WATER)).generate(this.world, this.rand, pos.add(i1, j1, k1));
			}
		pos = pos.add(8, 0, 8);

		//Create snow and freeze top of water areas
		if (net.minecraftforge.event.terraingen.TerrainGen.populate(this, this.world, this.rand, x, z, flag, net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE))
		{
			for (int k2 = 0; k2 < 16; ++k2)
			{
				for (int j3 = 0; j3 < 16; ++j3)
				{
					BlockPos blockpos1 = this.world.getPrecipitationHeight(pos.add(k2, 0, j3));
					BlockPos blockpos2 = blockpos1.down();

					if (this.world.canBlockFreezeWater(blockpos2))
					{
						this.world.setBlockState(blockpos2, Blocks.ICE.getDefaultState(), 3);
					}

					if (this.world.canSnowAt(blockpos1, true))
					{
						this.world.setBlockState(blockpos1, Blocks.SNOW_LAYER.getDefaultState(), 3);
					}
				}
			}
		}*/
	}

}