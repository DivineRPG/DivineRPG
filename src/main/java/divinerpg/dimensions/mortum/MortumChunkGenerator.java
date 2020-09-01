package divinerpg.dimensions.mortum;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import divinerpg.DivineRPG;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.StructureRegistry;
import divinerpg.structure.base.DRPGStructureHandler;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCavesHell;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenBush;
import net.minecraft.world.gen.feature.WorldGenFire;
import net.minecraft.world.gen.feature.WorldGenGlowStone1;
import net.minecraft.world.gen.feature.WorldGenGlowStone2;
import net.minecraft.world.gen.feature.WorldGenHellLava;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.gen.structure.MapGenNetherBridge;

public class MortumChunkGenerator implements IChunkGenerator
{
    protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
    protected static final IBlockState STONE = BlockRegistry.twilightStone.getDefaultState();
    protected static final IBlockState BEDROCK = Blocks.BEDROCK.getDefaultState();
    protected static final IBlockState TAR = BlockRegistry.smolderingTar.getDefaultState();
    protected static final IBlockState GRASS = BlockRegistry.mortumGrass.getDefaultState();
    protected static final IBlockState DIRT = BlockRegistry.mortumDirt.getDefaultState();
    private final World world;
    private final Random rand;
    private double[] slowsandNoise = new double[256];
    private double[] gravelNoise = new double[256];
    private double[] depthBuffer = new double[256];
    private double[] buffer;
    double[] pnr;
    double[] ar;
    double[] br;
    double[] noiseData4;
    double[] dr;
    private NoiseGeneratorOctaves lperlinNoise1;
    private NoiseGeneratorOctaves lperlinNoise2;
    private NoiseGeneratorOctaves perlinNoise1;
    private NoiseGeneratorOctaves slowsandGravelNoiseGen;
    private NoiseGeneratorOctaves netherrackExculsivityNoiseGen;
    public NoiseGeneratorOctaves scaleNoise;
    public NoiseGeneratorOctaves depthNoise;
    private final WorldGenerator ore = new WorldGenMinable(BlockRegistry.mortumOre.getDefaultState(), 8, BlockMatcher.forBlock(STONE.getBlock()));
    

    public MortumChunkGenerator(World worldIn, long seed)
    {
        this.world = worldIn;
        this.rand = new Random(seed);
        this.lperlinNoise1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.lperlinNoise2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.perlinNoise1 = new NoiseGeneratorOctaves(this.rand, 8);
        this.slowsandGravelNoiseGen = new NoiseGeneratorOctaves(this.rand, 4);
        this.netherrackExculsivityNoiseGen = new NoiseGeneratorOctaves(this.rand, 4);
        this.scaleNoise = new NoiseGeneratorOctaves(this.rand, 10);
        this.depthNoise = new NoiseGeneratorOctaves(this.rand, 16);
        worldIn.setSeaLevel(63);

        net.minecraftforge.event.terraingen.InitNoiseGensEvent.ContextHell ctx =
                new net.minecraftforge.event.terraingen.InitNoiseGensEvent.ContextHell(lperlinNoise1, lperlinNoise2, perlinNoise1, slowsandGravelNoiseGen, netherrackExculsivityNoiseGen, scaleNoise, depthNoise);
        ctx = net.minecraftforge.event.terraingen.TerrainGen.getModdedNoiseGenerators(worldIn, this.rand, ctx);
        this.lperlinNoise1 = ctx.getLPerlin1();
        this.lperlinNoise2 = ctx.getLPerlin2();
        this.perlinNoise1 = ctx.getPerlin();
        this.slowsandGravelNoiseGen = ctx.getPerlin2();
        this.netherrackExculsivityNoiseGen = ctx.getPerlin3();
        this.scaleNoise = ctx.getScale();
        this.depthNoise = ctx.getDepth();
        }
    private void generateBedrockLayers(ChunkPrimer primer) {
        for(int posX = 0; posX < 16; posX++) {
            for (int posZ = 0; posZ < 16; posZ++) {
                primer.setBlockState(posX, 0, posZ, Blocks.BEDROCK.getDefaultState());
                primer.setBlockState(posX, 128, posZ, Blocks.BEDROCK.getDefaultState());
            }
        }
    }
    public void prepareHeights(int p_185936_1_, int p_185936_2_, ChunkPrimer primer)
    {
        int i = 4;
        int j = this.world.getSeaLevel() / 2 + 1;
        int k = 5;
        int l = 17;
        int i1 = 5;
        this.buffer = this.getHeights(this.buffer, p_185936_1_ * 4, 0, p_185936_2_ * 4, 5, 17, 5);

        for (int j1 = 0; j1 < 4; ++j1)
        {
            for (int k1 = 0; k1 < 4; ++k1)
            {
                for (int l1 = 0; l1 < 16; ++l1)
                {
                    double d0 = 0.125D;
                    double d1 = this.buffer[((j1 + 0) * 5 + k1 + 0) * 17 + l1 + 0];
                    double d2 = this.buffer[((j1 + 0) * 5 + k1 + 1) * 17 + l1 + 0];
                    double d3 = this.buffer[((j1 + 1) * 5 + k1 + 0) * 17 + l1 + 0];
                    double d4 = this.buffer[((j1 + 1) * 5 + k1 + 1) * 17 + l1 + 0];
                    double d5 = (this.buffer[((j1 + 0) * 5 + k1 + 0) * 17 + l1 + 1] - d1) * 0.125D;
                    double d6 = (this.buffer[((j1 + 0) * 5 + k1 + 1) * 17 + l1 + 1] - d2) * 0.125D;
                    double d7 = (this.buffer[((j1 + 1) * 5 + k1 + 0) * 17 + l1 + 1] - d3) * 0.125D;
                    double d8 = (this.buffer[((j1 + 1) * 5 + k1 + 1) * 17 + l1 + 1] - d4) * 0.125D;

                    for (int i2 = 0; i2 < 8; ++i2)
                    {
                        double d9 = 0.25D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * 0.25D;
                        double d13 = (d4 - d2) * 0.25D;

                        for (int j2 = 0; j2 < 4; ++j2)
                        {
                            double d14 = 0.25D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * 0.25D;

                            for (int k2 = 0; k2 < 4; ++k2)
                            {
                                IBlockState iblockstate = null;

                                if (l1 * 8 + i2 < j)
                                {
                                    iblockstate = TAR;
                                }

                                if (d15 > 0.0D)
                                {
                                    iblockstate = STONE;
                                }

                                int l2 = j2 + j1 * 4;
                                int i3 = i2 + l1 * 8;
                                int j3 = k2 + k1 * 4;
                                primer.setBlockState(l2, i3, j3, iblockstate);
                                
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

    protected void buildSurfaces(int i, int j, ChunkPrimer chunkPrimer) {
        for (int k = 0; k < 16; k++) {
            for (int l = 0; l < 16; l++) {
                int j1 = -1;
                int i1 = (int) (3.0D + this.rand.nextDouble() * 0.25D);

                IBlockState top = GRASS;
                IBlockState filler = DIRT;

                for (int k1 = 127; k1 >= 0; k1--) {
                    IBlockState state = chunkPrimer.getBlockState(k, k1, l);

                    if (state == AIR) {
                        j1 = -1;
                    } else if (state == STONE) {
                        if (j1 == -1) {
                            if (i1 <= 0) {
                                top = AIR;
                                filler = STONE;
                            }
                            j1 = i1;
                            if (k1 >= 0) {
                                chunkPrimer.setBlockState(k, k1, l, top);
                            } else {
                                chunkPrimer.setBlockState(k, k1, l, filler);
                            }
                        } else if (j1 > 0) {
                            --j1;
                            chunkPrimer.setBlockState(k, k1, l, filler);
                        }
                    }
                }
            }
        }
    }
    
    @Override
    public Chunk generateChunk(int x, int z) {
        this.rand.setSeed((long) x * 341873128712L + (long) z * 132897987541L);
        ChunkPrimer chunkPrimer = new ChunkPrimer();
        this.prepareHeights(x, z, chunkPrimer);
        this.buildSurfaces(x, z, chunkPrimer);
        this.generateBedrockLayers(chunkPrimer);
        Chunk chunk = new Chunk(this.world, chunkPrimer, x, z);
        chunk.generateSkylightMap();
        return chunk;
    }

    private double[] getHeights(double[] noise, int x, int y, int z, int sizeX, int sizeY, int sizeZ) {
		if (noise == null)
			noise = new double[sizeX * sizeY * sizeZ];

		double d = 684.412D;
		double d1 = 2053.236D;
		noiseData4 = netherrackExculsivityNoiseGen.generateNoiseOctaves(noiseData4, x, y, z, sizeX, 1, sizeZ, 1D, 0D, 1D);
		dr = scaleNoise.generateNoiseOctaves(dr, x, y, z, sizeX, 1, sizeZ, 100D, 0D, 100D);
		pnr = perlinNoise1.generateNoiseOctaves(pnr, x, y, z, sizeX, sizeY, sizeZ, d * 0.0125D, d1 / 60D, d * 0.0125D);
		ar = lperlinNoise1.generateNoiseOctaves(ar, x, y, z, sizeX, sizeY, sizeZ, d, d1, d);
		br = lperlinNoise2.generateNoiseOctaves(br, x, y, z, sizeX, sizeY, sizeZ, d, d1, d);
		int index = 0;
		int j = 0;
		double ad[] = new double[sizeY];
		double oneOver512 = 1D / 512D;
		double groundNoiseMp = 1D / 2048D;

		for (int k = 0; k < sizeY; ++k) {
			ad[k] = Math.cos(k * Math.PI * 6D / sizeY) * 2D;
			double d2 = k;

			if (k > sizeY / 2)
				d2 = sizeY - 1 - k;

			if (d2 < 4D) {
				d2 = 4D - d2;
				ad[k] -= d2 * d2 * d2 * 10D;
			}
		}

		for (int xx = 0; xx < sizeX; ++xx)
			for (int zz = 0; zz < sizeZ; ++zz) {
				double d3 = (noiseData4[j] + 256D) * oneOver512;

				if (d3 > 1.0D)
					d3 = 1.0D;

				double d4 = 0.0D;
				double d5 = dr[j] * 0.000125D;

				if (d5 < 0.0D)
					d5 = -d5;

				d5 = d5 * 3D - 3D;

				if (d5 < 0.0D) {
					d5 /= 2D;

					if (d5 < -1D)
						d5 = -1D;

					d5 /= 1.4D;
					d5 *= 0.5D;
					d3 = 0.0D;
				} else {
					if (d5 > 1.0D)
						d5 = 1.0D;

					d5 /= 6D;
				}

				d3 += 0.5D;
				d5 = d5 * sizeY * 0.0625D;
				j++;

				for (int yy = 0; yy < sizeY; ++yy) {
					double d6 = 0.0D;
					double d7 = ad[yy];
					double d8 = ar[index] * groundNoiseMp;
					double d9 = br[index] * groundNoiseMp;
					double d10 = (pnr[index] * 0.1D + 1.0D) * 0.5D;

					if (d10 < 0.0D)
						d6 = d8;
					else if (d10 > 1.0D)
						d6 = d9;
					else
						d6 = d8 + (d9 - d8) * d10;

					d6 -= d7;

					if (yy > sizeY - 4) {
						double d11 = (yy - (sizeY - 4)) / 3F;
						d6 = d6 * (1.0D - d11) + -10D * d11;
					}

					if (yy < d4) {
						double d12 = (d4 - yy) * 0.25D;
						if (d12 < 0.0D)
							d12 = 0.0D;
						if (d12 > 1.0D)
							d12 = 1.0D;

						d6 = d6 * (1.0D - d12) + -10D * d12;
					}

					noise[index] = d6;
					++index;
				}
			}

		return noise;
	}

    public void populate(int x, int z)
    {
        BlockFalling.fallInstantly = true;
        int i = x * 16;
        int j = z * 16;
        BlockPos blockpos = new BlockPos(i, 0, j);
        Biome biome = this.world.getBiome(blockpos.add(16, 0, 16));
        int var13;
        int var14;
        int var15;
        int var16;

        if (net.minecraftforge.event.terraingen.TerrainGen.generateOre(this.world, this.rand, ore, blockpos, net.minecraftforge.event.terraingen.OreGenEvent.GenerateMinable.EventType.QUARTZ))
        	for (var13 = 0; var13 < 2; ++var13) {
                var14 = i + this.rand.nextInt(16);
                var15 = this.rand.nextInt(128);
                var16 = j + this.rand.nextInt(16);
                ore.generate(world, rand, blockpos);
        }
        
        BlockFalling.fallInstantly = false;
        biome.decorate(this.world, this.rand, blockpos);
    }

    public boolean generateStructures(Chunk chunkIn, int x, int z)
    {
        return false;
    }

    public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos)
    {
        Biome biome = this.world.getBiome(pos);
        return biome.getSpawnableList(creatureType);
    }

    @Nullable
    public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position, boolean findUnexplored)
    {
        return null;
    }

	@Override
	public void recreateStructures(Chunk chunkIn, int x, int z) {
		
	}

	@Override
	public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
		return false;
	}

}