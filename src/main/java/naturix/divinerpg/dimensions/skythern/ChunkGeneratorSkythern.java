package naturix.divinerpg.dimensions.skythern;


import java.util.List;
import java.util.Random;

import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
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
import net.minecraft.world.gen.NoiseGeneratorOctaves;

public class ChunkGeneratorSkythern implements  IChunkGenerator
{

	private Random rand;

	private World worldObj;

	private NoiseGeneratorOctaves noiseGen1, perlinNoise1;

	private double buffer[];

	double pnr[], ar[], br[];


	public ChunkGeneratorSkythern(World world, long seed)
	{
		this.worldObj = world;

		this.rand = new Random(seed);
		
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.perlinNoise1 = new NoiseGeneratorOctaves(this.rand, 8);
	}

	public void setBlocksInChunk(int x, int z, ChunkPrimer chunkPrimer)
    {
        this.buffer = this.setupNoiseGenerators(this.buffer, x * 2, z * 2);

        for(int i1 = 0; i1 < 2; i1++)
        {
            for(int j1 = 0; j1 < 2; j1++)
            {
                for(int k1 = 0; k1 < 32; k1++)
                {
                    double d1 = this.buffer[(i1 * 3 + j1) * 33 + k1];
                    double d2 = this.buffer[(i1 * 3 + (j1 + 1)) * 33 + k1];
                    double d3 = this.buffer[((i1 + 1) * 3 + j1) * 33 + k1];
                    double d4 = this.buffer[((i1 + 1) * 3 + (j1 + 1)) * 33 + k1];

                    double d5 = (this.buffer[(i1 * 3 + j1) * 33 + (k1 + 1)] - d1) * 0.25D;
                    double d6 = (this.buffer[(i1 * 3 + (j1 + 1)) * 33 + (k1 + 1)] - d2) * 0.25D;
                    double d7 = (this.buffer[((i1 + 1) * 3 + j1) * 33 + (k1 + 1)] - d3) * 0.25D;
                    double d8 = (this.buffer[((i1 + 1) * 3 + (j1 + 1)) * 33 + (k1 + 1)] - d4) * 0.25D;

                    for(int l1 = 0; l1 < 4; l1++)
                    {
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * 0.125D;
                        double d13 = (d4 - d2) * 0.125D;

                        for(int i2 = 0; i2 < 8; i2++)
                        {
                            double d15 = d10;
                            double d16 = (d11 - d10) * 0.125D;

                            for(int k2 = 0; k2 < 8; k2++)
                            {
                            	int x1 = i2 + i1 * 8;
                            	int y = l1 + k1 * 4;
                            	int z1 = k2 + j1 * 8;

                                IBlockState filler = Blocks.AIR.getDefaultState();

                            	if (d15 < -38D)
                            	{
                         	}

                                if (d15 < -39D && d15 > -43D)
                                {
                                	if (d15 < -41D)
                                	{
                          	}

                          }

                                if (d15 < -44D && d15 > -46D)
                                {
                                	if (d15 < -44.25D)
                                	{
                 	}
}

                                if(d15 > 0.0D)
                                {
                                	filler = ModBlocks.rockTwilight.getDefaultState();
                                }

                                chunkPrimer.setBlockState(x1, y, z1, filler);

                                d15 += d16;
                            }

                            d10 += d12;
                            d11 += d13;
                        }

                        d1 += d5;
                        d2 += d6;
                        d3 += d7;
                        d4 += d8;
                    }

                }

            }

        }

    }

	public void buildSurfaces(int i, int j, ChunkPrimer chunkPrimer)
    {
        for(int k = 0; k < 16; k++)
        {
            for(int l = 0; l < 16; l++)
            {
                int j1 = -1;
                int i1 = (int)(3.0D + this.rand.nextDouble() * 0.25D);

        		IBlockState top = ModBlocks.grassSkythern.getDefaultState();
        		IBlockState filler = ModBlocks.dirtSkythern.getDefaultState();

                for (int k1 = 127; k1 >= 0; k1--)
				{
					Block block = chunkPrimer.getBlockState(k, k1, l).getBlock();

					if (block == Blocks.AIR)
					{
						j1 = -1;
					}
					else if (block == ModBlocks.rockTwilight)
					{
						if (j1 == -1)
						{
							if (i1 <= 0)
							{
								top = Blocks.AIR.getDefaultState();
								filler = ModBlocks.rockTwilight.getDefaultState();
							}

							j1 = i1;

							if (k1 >= 0)
							{
								chunkPrimer.setBlockState(k, k1, l, top);
							}
							else
							{
								chunkPrimer.setBlockState(k, k1, l, filler);
							}
						}
						else if (j1 > 0)
						{
							--j1;
							chunkPrimer.setBlockState(k, k1, l, filler);
						}
					}
				}
            }
        }
    }

    private double[] setupNoiseGenerators(double buffer[], int x, int z)
    {
        if(buffer == null)
        {
        	buffer = new double[3366];
        }

        double d = 1368.824D;
        double d1 = 684.41200000000003D;

        this.pnr = this.perlinNoise1.generateNoiseOctaves(this.pnr, x, 0, z, 3, 33, 3, d / 80D, d1 / 160D, d / 80D);
        this.ar = this.noiseGen1.generateNoiseOctaves(this.ar, x, 0, z, 3, 33, 3, d, d1, d);
        this.br = this.noiseGen1.generateNoiseOctaves(this.br, x, 0, z, 3, 33, 3, d, d1, d);

        int id = 0;

        for(int j2 = 0; j2 < 3; j2++)
        {
            for(int l2 = 0; l2 < 3; l2++)
            {
                for(int j3 = 0; j3 < 33; j3++)
                {
                	double d8;

                    double d10 = this.ar[id] / 512D;
                    double d11 = this.br[id] / 512D;
                    double d12 = (this.pnr[id] / 10D + 1.0D) / 2D;

                    if(d12 < 0.0D)
                    {
                        d8 = d10;
                    } 
                    else if(d12 > 1.0D)
                    {
                        d8 = d11;
                    }
                    else
                    {
                        d8 = d10 + (d11 - d10) * d12;
                    }

                    d8 -= 8D;

                    if(j3 > 33 - 32)
                    {
                        double d13 = (float)(j3 - (33 - 32)) / ((float)32 - 1.0F);
                        d8 = d8 * (1.0D - d13) + -30D * d13;
                    }

                    if(j3 < 8)
                    {
                        double d14 = (float)(8 - j3) / ((float)8 - 1.0F);
                        d8 = d8 * (1.0D - d14) + -30D * d14;
                    }

                    buffer[id] = d8;

                    id++;
                }

            }

        }

        return buffer;
    }

	@Override
	public Chunk generateChunk(int x, int z) 
	{
        this.rand.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
		ChunkPrimer chunkPrimer = new ChunkPrimer();

        this.setBlocksInChunk(x, z, chunkPrimer);
        this.buildSurfaces(x, z, chunkPrimer);



        Chunk chunk = new Chunk(this.worldObj, chunkPrimer, x, z);
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
		return false;
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
        ChunkPos chunkpos = new ChunkPos(chunkX, chunkZ);

		Biome biome = this.worldObj.getBiome(pos.add(16, 0, 16));

        this.rand.setSeed(this.worldObj.getSeed());
        long k = this.rand.nextLong() / 2L * 2L + 1L;
        long l = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long)x * k + (long)z * l ^ this.worldObj.getSeed());
		biome.decorate(this.worldObj, this.rand, pos);
		
		WorldEntitySpawner.performWorldGenSpawning(this.worldObj, biome, x + 8, z + 8, 16, 16, this.rand);

	}

}