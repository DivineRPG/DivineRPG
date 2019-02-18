package naturix.divinerpg.dimensions.eden.chunk;


import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.*;
import net.minecraft.world.gen.feature.WorldGenEndIsland;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkGeneratorEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.List;
import java.util.Random;

public class ChunkGeneratorEden implements  IChunkGenerator {
    /*
	private Random rand;

	private World worldObj;

	private NoiseGeneratorOctaves noiseGen1, perlinNoise1;

	private double buffer[];

	double pnr[], ar[], br[];


	public ChunkGeneratorEden(World world, long seed)
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

        		IBlockState top = ModBlocks.grassEden.getDefaultState();
        		IBlockState filler = ModBlocks.dirtEden.getDefaultState();

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
	}*/

    /** RNG. */
    private final Random rand;
    protected static final IBlockState END_STONE = Blocks.END_STONE.getDefaultState();
    protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
    private NoiseGeneratorOctaves lperlinNoise1;
    private NoiseGeneratorOctaves lperlinNoise2;
    private NoiseGeneratorOctaves perlinNoise1;
    /** A NoiseGeneratorOctaves used in generating terrain */
    public NoiseGeneratorOctaves noiseGen5;
    /** A NoiseGeneratorOctaves used in generating terrain */
    public NoiseGeneratorOctaves noiseGen6;
    /** Reference to the World object. */
    private final World world;
    private NoiseGeneratorSimplex islandNoise;
    private double[] buffer;
    /** The biomes that are used to generate the chunk */
    private Biome[] biomesForGeneration;
    double[] pnr;
    double[] ar;
    double[] br;
    private final WorldGenEndIsland endIslands = new WorldGenEndIsland();
    // temporary variables used during event handling
    private int chunkX = 0;
    private int chunkZ = 0;

    public ChunkGeneratorEden(World p_i47241_1_, long p_i47241_3_)
    {
        this.world = p_i47241_1_;
        this.rand = new Random(p_i47241_3_);
        this.lperlinNoise1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.lperlinNoise2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.perlinNoise1 = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
        this.islandNoise = new NoiseGeneratorSimplex(this.rand);

        net.minecraftforge.event.terraingen.InitNoiseGensEvent.ContextEnd ctx =
                new net.minecraftforge.event.terraingen.InitNoiseGensEvent.ContextEnd(lperlinNoise1, lperlinNoise2, perlinNoise1, noiseGen5, noiseGen6, islandNoise);
        ctx = net.minecraftforge.event.terraingen.TerrainGen.getModdedNoiseGenerators(p_i47241_1_, this.rand, ctx);
        this.lperlinNoise1 = ctx.getLPerlin1();
        this.lperlinNoise2 = ctx.getLPerlin2();
        this.perlinNoise1 = ctx.getPerlin();
        this.noiseGen5 = ctx.getDepth();
        this.noiseGen6 = ctx.getScale();
        this.islandNoise = ctx.getIsland();
    }

    /**
     * Generates a bare-bones chunk of nothing but stone or ocean blocks, formed, but featureless.
     */
    public void setBlocksInChunk(int x, int z, ChunkPrimer primer)
    {
        int i = 2;
        int j = 3;
        int k = 33;
        int l = 3;
        this.buffer = this.getHeights(this.buffer, x * 2, 0, z * 2, 3, 33, 3);

        for (int i1 = 0; i1 < 2; ++i1)
        {
            for (int j1 = 0; j1 < 2; ++j1)
            {
                for (int k1 = 0; k1 < 32; ++k1)
                {
                    double d0 = 0.25D;
                    double d1 = this.buffer[((i1 + 0) * 3 + j1 + 0) * 33 + k1 + 0];
                    double d2 = this.buffer[((i1 + 0) * 3 + j1 + 1) * 33 + k1 + 0];
                    double d3 = this.buffer[((i1 + 1) * 3 + j1 + 0) * 33 + k1 + 0];
                    double d4 = this.buffer[((i1 + 1) * 3 + j1 + 1) * 33 + k1 + 0];
                    double d5 = (this.buffer[((i1 + 0) * 3 + j1 + 0) * 33 + k1 + 1] - d1) * 0.25D;
                    double d6 = (this.buffer[((i1 + 0) * 3 + j1 + 1) * 33 + k1 + 1] - d2) * 0.25D;
                    double d7 = (this.buffer[((i1 + 1) * 3 + j1 + 0) * 33 + k1 + 1] - d3) * 0.25D;
                    double d8 = (this.buffer[((i1 + 1) * 3 + j1 + 1) * 33 + k1 + 1] - d4) * 0.25D;

                    for (int l1 = 0; l1 < 4; ++l1)
                    {
                        double d9 = 0.125D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * 0.125D;
                        double d13 = (d4 - d2) * 0.125D;

                        for (int i2 = 0; i2 < 8; ++i2)
                        {
                            double d14 = 0.125D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * 0.125D;

                            for (int j2 = 0; j2 < 8; ++j2)
                            {
                                IBlockState iblockstate = AIR;

                                if (d15 > 0.0D)
                                {
                                    iblockstate = ModBlocks.rockTwilight.getDefaultState();
                                }

                                int k2 = i2 + i1 * 8;
                                int l2 = l1 + k1 * 4;
                                int i3 = j2 + j1 * 8;
                                primer.setBlockState(k2, l2, i3, iblockstate);
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

    public void buildSurfaces(ChunkPrimer primer)
    {
        if (!net.minecraftforge.event.ForgeEventFactory.onReplaceBiomeBlocks(this, this.chunkX, this.chunkZ, primer, this.world)) return;
        for (int i = 0; i < 16; ++i)
        {
            for (int j = 0; j < 16; ++j)
            {
                int k = 1;
                int l = -1;
                IBlockState iblockstate = ModBlocks.grassEden.getDefaultState();
                IBlockState iblockstate1 = ModBlocks.dirtEden.getDefaultState();

                for (int i1 = 127; i1 >= 0; --i1)
                {
                    IBlockState iblockstate2 = primer.getBlockState(i, i1, j);

                    if (iblockstate2.getMaterial() == Material.AIR)
                    {
                        l = -1;
                    }
                    else if (iblockstate2.getBlock() == ModBlocks.rockTwilight)
                    {
                        if (l == -1)
                        {
                            l = 3;

                            if (i1 >= 0)
                            {
                                primer.setBlockState(i, i1, j, iblockstate);
                            }
                            else
                            {
                                primer.setBlockState(i, i1, j, iblockstate1);
                            }
                        }
                        else if (l > 0)
                        {
                            --l;
                            primer.setBlockState(i, i1, j, iblockstate1);
                        }
                    }
                }
            }
        }
    }

    /**
     * Generates the chunk at the specified position, from scratch
     */
    public Chunk generateChunk(int x, int z)
    {
        this.chunkX = x; this.chunkZ = z;
        this.rand.setSeed((long)x * 341873128712L + (long)z * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.biomesForGeneration = this.world.getBiomeProvider().getBiomes(this.biomesForGeneration, x * 16, z * 16, 16, 16);
        this.setBlocksInChunk(x, z, chunkprimer);
        this.buildSurfaces(chunkprimer);

        Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
        byte[] abyte = chunk.getBiomeArray();

        for (int i = 0; i < abyte.length; ++i)
        {
            abyte[i] = (byte)Biome.getIdForBiome(this.biomesForGeneration[i]);
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    private float getIslandHeightValue(int p_185960_1_, int p_185960_2_, int p_185960_3_, int p_185960_4_)
    {
        float f = (float)(p_185960_1_ * 2 + p_185960_3_);
        float f1 = (float)(p_185960_2_ * 2 + p_185960_4_);
        float f2 = 100.0F - MathHelper.sqrt(f * f + f1 * f1) * 8.0F;

        if (f2 > 80.0F)
        {
            f2 = 80.0F;
        }

        if (f2 < -100.0F)
        {
            f2 = -100.0F;
        }

        for (int i = -12; i <= 12; ++i)
        {
            for (int j = -12; j <= 12; ++j)
            {
                long k = (long)(p_185960_1_ + i);
                long l = (long)(p_185960_2_ + j);

                if (k * k + l * l > 4096L && this.islandNoise.getValue((double)k, (double)l) < -0.8999999761581421D)
                {
                    float f3 = (MathHelper.abs((float)k) * 3439.0F + MathHelper.abs((float)l) * 147.0F) % 13.0F + 9.0F;
                    f = (float)(p_185960_3_ - i * 2);
                    f1 = (float)(p_185960_4_ - j * 2);
                    float f4 = 100.0F - MathHelper.sqrt(f * f + f1 * f1) * f3;

                    if (f4 > 80.0F)
                    {
                        f4 = 80.0F;
                    }

                    if (f4 < -100.0F)
                    {
                        f4 = -100.0F;
                    }

                    if (f4 > f2)
                    {
                        f2 = f4;
                    }
                }
            }
        }

        return f2;
    }

    public boolean isIslandChunk(int p_185961_1_, int p_185961_2_)
    {
        return (long)p_185961_1_ * (long)p_185961_1_ + (long)p_185961_2_ * (long)p_185961_2_ > 4096L && this.getIslandHeightValue(p_185961_1_, p_185961_2_, 1, 1) >= 0.0F;
    }

    private double[] getHeights(double[] p_185963_1_, int p_185963_2_, int p_185963_3_, int p_185963_4_, int p_185963_5_, int p_185963_6_, int p_185963_7_)
    {
        net.minecraftforge.event.terraingen.ChunkGeneratorEvent.InitNoiseField event = new net.minecraftforge.event.terraingen.ChunkGeneratorEvent.InitNoiseField(this, p_185963_1_, p_185963_2_, p_185963_3_, p_185963_4_, p_185963_5_, p_185963_6_, p_185963_7_);
        net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event);
        if (event.getResult() == net.minecraftforge.fml.common.eventhandler.Event.Result.DENY) return event.getNoisefield();

        if (p_185963_1_ == null)
        {
            p_185963_1_ = new double[p_185963_5_ * p_185963_6_ * p_185963_7_];
        }

        double d0 = 684.412D;
        double d1 = 684.412D;
        d0 = d0 * 2.0D;
        this.pnr = this.perlinNoise1.generateNoiseOctaves(this.pnr, p_185963_2_, p_185963_3_, p_185963_4_, p_185963_5_, p_185963_6_, p_185963_7_, d0 / 80.0D, 4.277575000000001D, d0 / 80.0D);
        this.ar = this.lperlinNoise1.generateNoiseOctaves(this.ar, p_185963_2_, p_185963_3_, p_185963_4_, p_185963_5_, p_185963_6_, p_185963_7_, d0, 684.412D, d0);
        this.br = this.lperlinNoise2.generateNoiseOctaves(this.br, p_185963_2_, p_185963_3_, p_185963_4_, p_185963_5_, p_185963_6_, p_185963_7_, d0, 684.412D, d0);
        int i = p_185963_2_ / 2;
        int j = p_185963_4_ / 2;
        int k = 0;

        for (int l = 0; l < p_185963_5_; ++l)
        {
            for (int i1 = 0; i1 < p_185963_7_; ++i1)
            {
                float f = this.getIslandHeightValue(i, j, l, i1);

                for (int j1 = 0; j1 < p_185963_6_; ++j1)
                {
                    double d2 = this.ar[k] / 512.0D;
                    double d3 = this.br[k] / 512.0D;
                    double d5 = (this.pnr[k] / 10.0D + 1.0D) / 2.0D;
                    double d4;

                    if (d5 < 0.0D)
                    {
                        d4 = d2;
                    }
                    else if (d5 > 1.0D)
                    {
                        d4 = d3;
                    }
                    else
                    {
                        d4 = d2 + (d3 - d2) * d5;
                    }

                    d4 = d4 - 8.0D;
                    d4 = d4 + (double)f;
                    int k1 = 2;

                    if (j1 > p_185963_6_ / 2 - k1)
                    {
                        double d6 = (double)((float)(j1 - (p_185963_6_ / 2 - k1)) / 64.0F);
                        d6 = MathHelper.clamp(d6, 0.0D, 1.0D);
                        d4 = d4 * (1.0D - d6) + -3000.0D * d6;
                    }

                    k1 = 8;

                    if (j1 < k1)
                    {
                        double d7 = (double)((float)(k1 - j1) / ((float)k1 - 1.0F));
                        d4 = d4 * (1.0D - d7) + -30.0D * d7;
                    }

                    p_185963_1_[k] = d4;
                    ++k;
                }
            }
        }

        return p_185963_1_;
    }

    /**
     * Generate initial structures in this chunk, e.g. mineshafts, temples, lakes, and dungeons
     */
    public void populate(int x, int z)
    {
        BlockFalling.fallInstantly = true;
        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(true, this, this.world, this.rand, x, z, false);
        BlockPos blockpos = new BlockPos(x * 16, 0, z * 16);

        this.world.getBiome(blockpos.add(16, 0, 16)).decorate(this.world, this.world.rand, blockpos);
        long i = (long)x * (long)x + (long)z * (long)z;

        if (i > 4096L)
        {
            float f = this.getIslandHeightValue(x, z, 1, 1);

            if (f < -20.0F && this.rand.nextInt(14) == 0)
            {
                //this.endIslands.generate(this.world, this.rand, blockpos.add(this.rand.nextInt(16) + 8, 55 + this.rand.nextInt(16), this.rand.nextInt(16) + 8));

                if (this.rand.nextInt(4) == 0)
                {
                    //this.endIslands.generate(this.world, this.rand, blockpos.add(this.rand.nextInt(16) + 8, 55 + this.rand.nextInt(16), this.rand.nextInt(16) + 8));
                }
            }

            if (this.getIslandHeightValue(x, z, 1, 1) > 40.0F)
            {
                int j = this.rand.nextInt(5);

                for (int k = 0; k < j; ++k)
                {
                    int l = this.rand.nextInt(16) + 8;
                    int i1 = this.rand.nextInt(16) + 8;
                    int j1 = this.world.getHeight(blockpos.add(l, 0, i1)).getY();

                    if (j1 > 0)
                    {
                        int k1 = j1 - 1;
                    }
                }

                if (this.rand.nextInt(700) == 0)
                {
                    int l1 = this.rand.nextInt(16) + 8;
                    int i2 = this.rand.nextInt(16) + 8;
                    int j2 = this.world.getHeight(blockpos.add(l1, 0, i2)).getY();

                }
            }
        }

        net.minecraftforge.event.ForgeEventFactory.onChunkPopulate(false, this, this.world, this.rand, x, z, false);
        BlockFalling.fallInstantly = false;
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

	/*@Override
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

	}*/


}