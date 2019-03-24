package naturix.divinerpg.dimensions.eden.chunk;

import java.util.List;
import java.util.Random;

import naturix.divinerpg.registry.ModBlocks;
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
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorSimplex;

public class ChunkGeneratorEden implements IChunkGenerator {
    /** RNG. */
    private final Random rand;
    protected static final IBlockState AIR = Blocks.AIR.getDefaultState();
    private NoiseGeneratorOctaves lperlinNoise1;
    private NoiseGeneratorOctaves lperlinNoise2;
    private NoiseGeneratorOctaves perlinNoise1;
    /** Reference to the World object. */
    private final World world;
    private NoiseGeneratorSimplex islandNoise;
    private double[] buffer;
    /** The biomes that are used to generate the chunk */
    private Biome[] biomesForGeneration;

    double[] noise3;
    double[] noise1;
    double[] noise2;
    double[] noise5;
    double[] noise6;

    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    private NoiseGeneratorOctaves noiseGen4;
    public NoiseGeneratorOctaves noiseGen5;
    public NoiseGeneratorOctaves noiseGen6;

    // temporary variables used during event handling
    private int chunkX = 0;
    private int chunkZ = 0;

    public ChunkGeneratorEden(World p_i47241_1_, long p_i47241_3_) {
        this.world = p_i47241_1_;
        this.rand = new Random(p_i47241_3_);
        this.lperlinNoise1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.lperlinNoise2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.perlinNoise1 = new NoiseGeneratorOctaves(this.rand, 8);

        this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
        this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
        this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);

        this.islandNoise = new NoiseGeneratorSimplex(this.rand);

        net.minecraftforge.event.terraingen.InitNoiseGensEvent.ContextEnd ctx = new net.minecraftforge.event.terraingen.InitNoiseGensEvent.ContextEnd(
                lperlinNoise1, lperlinNoise2, perlinNoise1, noiseGen5, noiseGen6, islandNoise);
        ctx = net.minecraftforge.event.terraingen.TerrainGen.getModdedNoiseGenerators(p_i47241_1_, this.rand, ctx);
        this.lperlinNoise1 = ctx.getLPerlin1();
        this.lperlinNoise2 = ctx.getLPerlin2();
        this.perlinNoise1 = ctx.getPerlin();
        this.islandNoise = ctx.getIsland();
    }

    /**
     * Generates a bare-bones chunk of nothing but stone or ocean blocks, formed,
     * but featureless.
     */
    public void setBlocksInChunk(int x, int z, ChunkPrimer primer) {
        int i = 2;
        int j = 3;
        int k = 33;
        int l = 3;
        this.buffer = this.getHeights(this.buffer, x * 2, 0, z * 2, 3, 33, 3);

        for (int i1 = 0; i1 < 2; ++i1) {
            for (int j1 = 0; j1 < 2; ++j1) {
                for (int k1 = 0; k1 < 32; ++k1) {
                    double d0 = 0.25D;
                    double d1 = this.buffer[((i1 + 0) * 3 + j1 + 0) * 33 + k1 + 0];
                    double d2 = this.buffer[((i1 + 0) * 3 + j1 + 1) * 33 + k1 + 0];
                    double d3 = this.buffer[((i1 + 1) * 3 + j1 + 0) * 33 + k1 + 0];
                    double d4 = this.buffer[((i1 + 1) * 3 + j1 + 1) * 33 + k1 + 0];
                    double d5 = (this.buffer[((i1 + 0) * 3 + j1 + 0) * 33 + k1 + 1] - d1) * 0.25D;
                    double d6 = (this.buffer[((i1 + 0) * 3 + j1 + 1) * 33 + k1 + 1] - d2) * 0.25D;
                    double d7 = (this.buffer[((i1 + 1) * 3 + j1 + 0) * 33 + k1 + 1] - d3) * 0.25D;
                    double d8 = (this.buffer[((i1 + 1) * 3 + j1 + 1) * 33 + k1 + 1] - d4) * 0.25D;

                    for (int l1 = 0; l1 < 4; ++l1) {
                        double d9 = 0.125D;
                        double d10 = d1;
                        double d11 = d2;
                        double d12 = (d3 - d1) * 0.125D;
                        double d13 = (d4 - d2) * 0.125D;

                        for (int i2 = 0; i2 < 8; ++i2) {
                            double d14 = 0.125D;
                            double d15 = d10;
                            double d16 = (d11 - d10) * 0.125D;

                            for (int j2 = 0; j2 < 8; ++j2) {
                                IBlockState iblockstate = AIR;

                                if (d15 > 0.0D) {
                                    iblockstate = ModBlocks.twilightStone.getDefaultState();
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

    public void buildSurfaces(ChunkPrimer primer) {
        if (!net.minecraftforge.event.ForgeEventFactory.onReplaceBiomeBlocks(this, this.chunkX, this.chunkZ, primer,
                this.world))
            return;
        for (int i = 0; i < 16; ++i) {
            for (int j = 0; j < 16; ++j) {
                int k = 1;
                int l = -1;
                IBlockState iblockstate = ModBlocks.edenGrass.getDefaultState();
                IBlockState iblockstate1 = ModBlocks.edenDirt.getDefaultState();

                for (int i1 = 127; i1 >= 0; --i1) {
                    IBlockState iblockstate2 = primer.getBlockState(i, i1, j);

                    if (iblockstate2.getMaterial() == Material.AIR) {
                        l = -1;
                    } else if (iblockstate2.getBlock() == ModBlocks.twilightStone) {
                        if (l == -1) {
                            l = 3;

                            if (i1 >= 0) {
                                primer.setBlockState(i, i1, j, iblockstate);
                            } else {
                                primer.setBlockState(i, i1, j, iblockstate1);
                            }
                        } else if (l > 0) {
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
    public Chunk generateChunk(int x, int z) {
        this.chunkX = x;
        this.chunkZ = z;
        this.rand.setSeed((long) x * 341873128712L + (long) z * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.biomesForGeneration = this.world.getBiomeProvider().getBiomes(this.biomesForGeneration, x * 16, z * 16, 16,
                16);
        this.setBlocksInChunk(x, z, chunkprimer);
        this.buildSurfaces(chunkprimer);

        Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
        byte[] abyte = chunk.getBiomeArray();

        for (int i = 0; i < abyte.length; ++i) {
            abyte[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    private float getIslandHeightValue(int p_185960_1_, int p_185960_2_, int p_185960_3_, int p_185960_4_) {
        float f = (float) (p_185960_1_ * 2 + p_185960_3_);
        float f1 = (float) (p_185960_2_ * 2 + p_185960_4_);
        float f2 = 100.0F - MathHelper.sqrt(f * f + f1 * f1) * 8.0F;

        if (f2 > 80.0F) {
            f2 = 80.0F;
        }

        if (f2 < -100.0F) {
            f2 = -100.0F;
        }

        for (int i = -12; i <= 12; ++i) {
            for (int j = -12; j <= 12; ++j) {
                long k = (long) (p_185960_1_ + i);
                long l = (long) (p_185960_2_ + j);

                if (k * k + l * l > 4096L && this.islandNoise.getValue((double) k, (double) l) < -0.8999999761581421D) {
                    float f3 = (MathHelper.abs((float) k) * 3439.0F + MathHelper.abs((float) l) * 147.0F) % 13.0F
                            + 9.0F;
                    f = (float) (p_185960_3_ - i * 2);
                    f1 = (float) (p_185960_4_ - j * 2);
                    float f4 = 100.0F - MathHelper.sqrt(f * f + f1 * f1) * f3;

                    if (f4 > 80.0F) {
                        f4 = 80.0F;
                    }

                    if (f4 < -100.0F) {
                        f4 = -100.0F;
                    }

                    if (f4 > f2) {
                        f2 = f4;
                    }
                }
            }
        }

        return f2;
    }

    public boolean isIslandChunk(int p_185961_1_, int p_185961_2_) {
        return (long) p_185961_1_ * (long) p_185961_1_ + (long) p_185961_2_ * (long) p_185961_2_ > 4096L
                && this.getIslandHeightValue(p_185961_1_, p_185961_2_, 1, 1) >= 0.0F;
    }

    private double[] getHeights(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
        if (var1 == null) {
            var1 = new double[var5 * var6 * var7];
        }

        double var8 = 684.412D;
        double var10 = 684.412D;
        this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
        this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
        var8 *= 2.0D;
        this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, var2, var3, var4, var5, var6, var7, var8 / 80.0D,
                var8 / 160.0D, var8 / 80.0D);
        this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, var2, var3, var4, var5, var6, var7, var8, var10,
                var8);
        this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, var2, var3, var4, var5, var6, var7, var8, var10,
                var8);
        int var12 = 0;
        int var13 = 0;
        int var14 = 16 / var5;

        for (int var15 = 0; var15 < var5; ++var15) {
            int var16 = var15 * var14 + var14 / 2;

            for (int var17 = 0; var17 < var7; ++var17) {
                int var18 = var17 * var14 + var14 / 2;
                double var19 = (this.noise5[var13] + 256.0D) / 512.0D;
                double var21 = this.noise6[var13] / 8000.0D;

                if (var21 < 0.0D) {
                    var21 = -var21 * 0.3D;
                }

                var21 = var21 * 3.0D - 2.0D;

                if (var21 > 1.0D) {
                    var21 = 1.0D;
                }

                var21 /= 8.0D;
                var21 = 0.0D;

                if (var19 < 0.0D) {
                    var19 = 0.0D;
                }

                var19 += 0.5D;
                var21 = var21 * var6 / 16.0D;
                ++var13;
                double var23 = var6 / 2.0D;

                for (int var25 = 0; var25 < var6; ++var25) {
                    double var26 = 0.0D;
                    double var28 = (var25 - var23) * 8.0D / var19;

                    if (var28 < 0.0D) {
                        var28 *= -1.0D;
                    }

                    double var30 = this.noise1[var12] / 512.0D;
                    double var32 = this.noise2[var12] / 512.0D;
                    double var34 = (this.noise3[var12] / 10.0D + 1.0D) / 2.0D;

                    if (var34 < 0.0D) {
                        var26 = var30;
                    } else if (var34 > 1.0D) {
                        var26 = var32;
                    } else {
                        var26 = var30 + (var32 - var30) * var34;
                    }

                    var26 -= 8.0D;
                    byte var36 = 32;
                    double var37;

                    if (var25 > var6 - var36) {
                        var37 = (var25 - (var6 - var36)) / (var36 - 1.0F);
                        var26 = var26 * (1.0D - var37) + -30.0D * var37;
                    }

                    var36 = 8;

                    if (var25 < var36) {
                        var37 = (var36 - var25) / (var36 - 1.0F);
                        var26 = var26 * (1.0D - var37) + -30.0D * var37;
                    }

                    var1[var12] = var26;
                    ++var12;
                }
            }
        }

        return var1;
    }

    @Override
    public List<SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos) {
        Biome biome = this.world.getBiomeProvider().getBiome(pos);

        return biome != null ? biome.getSpawnableList(creatureType) : null;
    }

    @Override
    public boolean generateStructures(Chunk chunkIn, int chunkX, int chunkZ) {
        return false;
    }

    @Override
    public void recreateStructures(Chunk p_180514_1_, int x, int z) {

    }

    @Override
    public boolean isInsideStructure(World worldIn, String structureName, BlockPos pos) {
        return false;
    }

    @Override
    public BlockPos getNearestStructurePos(World worldIn, String structureName, BlockPos position,
            boolean findUnexplored) {
        return null;
    }

    @Override
    public void populate(int chunkX, int chunkZ) {
        int x = chunkX * 16;
        int z = chunkZ * 16;

        BlockPos pos = new BlockPos(x, 0, z);
        ChunkPos chunkpos = new ChunkPos(chunkX, chunkZ);

        Biome biome = this.world.getBiome(pos.add(16, 0, 16));

        this.rand.setSeed(this.world.getSeed());
        long k = this.rand.nextLong() / 2L * 2L + 1L;
        long l = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long) x * k + (long) z * l ^ this.world.getSeed());
        biome.decorate(this.world, this.rand, pos);

        WorldEntitySpawner.performWorldGenSpawning(this.world, biome, x + 8, z + 8, 16, 16, this.rand);
    }
}