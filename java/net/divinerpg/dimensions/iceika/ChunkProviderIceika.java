package net.divinerpg.dimensions.iceika;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.divinerpg.api.items.WorldGenSantaHouse;
import net.divinerpg.dimensions.iceika.village.WorldGenHouse1;
import net.divinerpg.dimensions.iceika.village.WorldGenHouse2;
import net.divinerpg.dimensions.iceika.village.WorldGenHouse3;
import net.divinerpg.dimensions.iceika.village.WorldGenHouse4;
import net.divinerpg.dimensions.iceika.village.WorldGenHouse5;
import net.divinerpg.dimensions.iceika.village.WorldGenLibrary;
import net.divinerpg.dimensions.iceika.village.WorldGenLights;
import net.divinerpg.dimensions.iceika.village.WorldGenWorkShop;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;

public class ChunkProviderIceika implements IChunkProvider {

	private Random rand;
	private NoiseGeneratorOctaves noiseGen1, noiseGen2, noiseGen3, noiseGen5, noiseGen6;
	private NoiseGeneratorPerlin noiseGen4;
	private World worldObj;
	private WorldType type;
	private final double[] da;
	private final float[] parabolicField;
	private double[] stoneNoise = new double[256];
	private MapGenBase caveGenerator = new MapGenIceikaCaves();
	private BiomeGenBase[] biomesForGeneration;
	private double[] gen1, gen2, gen3, gen4;
	private int[][] ia = new int[32][32];
	private ArrayList<WorldGenerator> lights, village, dungeons, rareHouses;

	public ChunkProviderIceika(World par1World, long par2) {
		this.worldObj = par1World;
		this.type = par1World.getWorldInfo().getTerrainType();
		this.rand = new Random(par2);
		
		lights = new ArrayList(2);
		lights.add(new WorldGenLights.Light1());
		lights.add(new WorldGenLights.Light2());
		lights.add(new WorldGenLights.Light3());
		
		village = new ArrayList(5);
		village.add(new WorldGenLibrary());
		village.add(new WorldGenWorkShop());
		village.add(new WorldGenHouse1());
		village.add(new WorldGenHouse2());
		village.add(new WorldGenHouse3());
		village.add(new WorldGenHouse4());
		village.add(new WorldGenHouse5());
		
		rareHouses = new ArrayList(0);
		rareHouses.add(new WorldGenSantaHouse());
		
		dungeons = new ArrayList(1);
		dungeons.add(new WorldGenRollumDungeon());
		dungeons.add(new WorldGenGlacideDungeon());
		
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGen4 = new NoiseGeneratorPerlin(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.da = new double[825];
		this.parabolicField = new float[25];
		for(int j = -2; j <= 2; ++j) {
			for(int k = -2; k <= 2; ++k) {
				float f = 10.0F / MathHelper.sqrt_float((float)(j * j + k * k) + 0.2F);
				this.parabolicField[j + 2 + (k + 2) * 5] = f;
			}
		}

		NoiseGenerator[] noiseGens = {noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6};
		noiseGens = TerrainGen.getModdedNoiseGenerators(par1World, this.rand, noiseGens);
		this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
		this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
		this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
		this.noiseGen4 = (NoiseGeneratorPerlin)noiseGens[3];
		this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
		this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
	}

	public void generate(int i, int j, Block[] b) {
		byte b0 = 63;
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, i * 4 - 2, j * 4 - 2, 10, 10);
		this.generate(i * 4, 0, j * 4);

		for(int k = 0; k < 4; ++k) {
			int l = k * 5;
			int i1 = (k + 1) * 5;

			for(int j1 = 0; j1 < 4; ++j1) {
				int k1 = (l + j1) * 33;
				int l1 = (l + j1 + 1) * 33;
				int i2 = (i1 + j1) * 33;
				int j2 = (i1 + j1 + 1) * 33;

				for(int k2 = 0; k2 < 32; ++k2) {
					double d0 = 0.125D;
					double d1 = this.da[k1 + k2];
					double d2 = this.da[l1 + k2];
					double d3 = this.da[i2 + k2];
					double d4 = this.da[j2 + k2];
					double d5 = (this.da[k1 + k2 + 1] - d1) * d0;
					double d6 = (this.da[l1 + k2 + 1] - d2) * d0;
					double d7 = (this.da[i2 + k2 + 1] - d3) * d0;
					double d8 = (this.da[j2 + k2 + 1] - d4) * d0;

					for(int l2 = 0; l2 < 8; ++l2) {
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;

						for(int i3 = 0; i3 < 4; ++i3) {
							int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
							short short1 = 256;
							j3 -= short1;
							double d14 = 0.25D;
							double d16 = (d11 - d10) * d14;
							double d15 = d10 - d16;

							for(int k3 = 0; k3 < 4; ++k3) {
								if((d15 += d16) > 0.0D) 
									b[j3 += short1] = IceikaBlocks.frozenStone;

								else if(k2 * 8 + l2 < 62) 
									b[j3 += short1] = IceikaBlocks.frozenDirt;
								
								else if(k2 * 8 + l2 < b0) 
									b[j3 += short1] = IceikaBlocks.frozenGrass;
								
								else 
									b[j3 += short1] = null;
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

	public void replaceBlocksForBiome(int i, int j, Block[] ba, byte[] by, BiomeGenBase[] b) {
		double d0 = 0.03125D;
		this.stoneNoise = this.noiseGen4.func_151599_a(this.stoneNoise, (double)(i * 16), (double)(j * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);

		for(int k = 0; k < 16; ++k) {
			for(int l = 0; l < 16; ++l) {
				BiomeGenBase biomegenbase = b[l + k * 16];
				genBiomeTerrain(this.worldObj, this.rand, ba, by, i * 16 + k, j * 16 + l, this.stoneNoise[l + k * 16], biomegenbase);
			}
		}
	}

	public final void genBiomeTerrain(World w, Random rand, Block[] blocks, byte[] bytes, int i, int j, double d, BiomeGenBase b) {
		boolean flag = true;
		Block block = b.topBlock;
		byte b0 = (byte)(b.field_150604_aj & 255);
		Block block1 = b.fillerBlock;
		int k = -1;
		int l = (int)(d / 3.0D + 3.0D + rand.nextDouble() * 0.25D);
		int i1 = i & 15;
		int j1 = j & 15;
		int k1 = blocks.length / 256;

		for(int l1 = 255; l1 >= 0; --l1) {
			int i2 = (j1 * 16 + i1) * k1 + l1;
			if(l1 <= 0 + rand.nextInt(5)) {
				blocks[i2] = Blocks.bedrock;
			} else {
				Block block2 = blocks[i2];
				if(block2 != null && block2.getMaterial() != Material.air) {
					if(block2 == IceikaBlocks.frozenStone) {
						if(k == -1) {
							if(l <= 0) {
								block = null;
								b0 = 0;
								block1 = IceikaBlocks.frozenStone;
							}
							else if(l1 >= 59 && l1 <= 64) {
								block = b.topBlock;
								b0 = (byte)(b.field_150604_aj & 255);
								block1 = b.fillerBlock;
							}

							if(l1 < 63 && (block == null || block.getMaterial() == Material.air)) {
								if(b.getFloatTemperature(i, l1, j) < 0.15F) {
									block = Blocks.ice;
									b0 = 0;
								} else {
									block = IceikaBlocks.frozenStone;
									b0 = 0;
								}
							}
							k = l;
							if(l1 >= 62) {
								blocks[i2] = block;
								bytes[i2] = b0;
							}
							else if(l1 < 56 - l) {
								block = null;
								block1 = IceikaBlocks.frozenStone;
								blocks[i2] = IceikaBlocks.frozenStone;
							} else {
								blocks[i2] = block1;
							}
						}
						else if(k > 0) {
							--k;
							blocks[i2] = block1;
							if(k == 0 && block1 == IceikaBlocks.frozenStone){
								k = rand.nextInt(4) + Math.max(0, l1 - 63);
								block1 = IceikaBlocks.frozenStone;
							}
						}
					}
				} else {
					k = -1;
				}
			}
		}
	}

	@Override
	public Chunk loadChunk(int par1, int par2) {
		return this.provideChunk(par1, par2);
	}

	@Override
	public Chunk provideChunk(int par1, int par2) {
		this.rand.setSeed((long)par1 * 341873128712L + (long)par2 * 132897987541L);
		Block[] ablock = new Block[65536];
		byte[] abyte = new byte[65536];
		this.generate(par1, par2, ablock);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
		this.replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration);
		this.caveGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
		Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
		byte[] abyte1 = chunk.getBiomeArray();

		for(int k = 0; k < abyte1.length; ++k) 
			abyte1[k] = (byte)this.biomesForGeneration[k].biomeID;

		chunk.generateSkylightMap();
		return chunk;
	}

	private void generate(int x, int y, int z) {
		double d0 = 684.412D;
		double d1 = 684.412D;
		double d2 = 512.0D;
		double d3 = 512.0D;
		this.gen4 = this.noiseGen6.generateNoiseOctaves(this.gen4, x, z, 5, 5, 200.0D, 200.0D, 0.5D);
		this.gen1 = this.noiseGen3.generateNoiseOctaves(this.gen1, x, y, z, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
		this.gen2 = this.noiseGen1.generateNoiseOctaves(this.gen2, x, y, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		this.gen3 = this.noiseGen2.generateNoiseOctaves(this.gen3, x, y, z, 5, 33, 5, 684.412D, 684.412D, 684.412D);
		boolean flag1 = false;
		boolean flag = false;
		int l = 0;
		int i1 = 0;
		double d4 = 8.5D;

		for(int j1 = 0; j1 < 5; ++j1) {
			for(int k1 = 0; k1 < 5; ++k1) {
				float f = 0.0F;
				float f1 = 0.0F;
				float f2 = 0.0F;
				byte b0 = 2;
				BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];

				for(int l1 = -b0; l1 <= b0; ++l1) {
					for(int i2 = -b0; i2 <= b0; ++i2) {
						BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
						float f3 = biomegenbase1.rootHeight;
						float f4 = biomegenbase1.heightVariation;

						if(this.type == WorldType.AMPLIFIED && f3 > 0.0F) {
							f3 = 1.0F + f3 * 2.0F;
							f4 = 1.0F + f4 * 4.0F;
						}

						float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);

						if(biomegenbase1.rootHeight > biomegenbase.rootHeight)
							f5 /= 2.0F;

						f += f4 * f5;
						f1 += f3 * f5;
						f2 += f5;
					}
				}

				f /= f2;
				f1 /= f2;
				f = f * 0.9F + 0.1F;
				f1 = (f1 * 4.0F - 1.0F) / 8.0F;
				double d12 = this.gen4[i1] / 8000.0D;

				if(d12 < 0.0D) {
					d12 = -d12 * 0.3D;
				}

				d12 = d12 * 3.0D - 2.0D;

				if(d12 < 0.0D) {
					d12 /= 2.0D;

					if(d12 < -1.0D) 
						d12 = -1.0D;

					d12 /= 1.4D;
					d12 /= 2.0D;
				} else {
					if(d12 > 1.0D) 
						d12 = 1.0D;

					d12 /= 8.0D;
				}

				++i1;
				double d13 = (double)f1;
				double d14 = (double)f;
				d13 += d12 * 0.2D;
				d13 = d13 * 8.5D / 8.0D;
				double d5 = 8.5D + d13 * 4.0D;

				for(int j2 = 0; j2 < 33; ++j2) {
					double d6 = ((double)j2 - d5) * 12.0D * 128.0D / 256.0D / d14;

					if(d6 < 0.0D) 
						d6 *= 4.0D;


					double d7 = this.gen2[l] / 512.0D;
					double d8 = this.gen3[l] / 512.0D;
					double d9 = (this.gen1[l] / 10.0D + 1.0D) / 2.0D;
					double d10 = MathHelper.denormalizeClamp(d7, d8, d9) - d6;

					if(j2 > 29) {
						double d11 = (double)((float)(j2 - 29) / 3.0F);
						d10 = d10 * (1.0D - d11) + -10.0D * d11;
					}

					this.da[l] = d10;
					++l;
				}
			}
		}
	}

	@Override
	public boolean chunkExists(int par1, int par2) {
		return true;
	}

	@Override
	public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
		int var4 = par2 * 16;
		int var5 = par3 * 16;
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
		long p1 = this.rand.nextLong() / 2L * 2L + 1L;
		long j1 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed(this.worldObj.getSeed());
		this.rand.setSeed((long)par2 * p1 + (long)par3 * j1 ^ this.worldObj.getSeed());
		int j, var12, var13, var14, x, i, y, z;
		
		if(rand.nextInt(5) == 0) { 
			x = var4 + this.rand.nextInt(16);
			z = var5 + this.rand.nextInt(16);
			y = rand.nextInt(50);
			(dungeons.get(rand.nextInt(dungeons.size()))).generate(this.worldObj, this.rand, x, y, z);
		}
		
		for(i = 0; i < 2; i++) {
			x = var4 + this.rand.nextInt(16);
			z = var5 + this.rand.nextInt(16);
			boolean foundGround = false;
			for(y = 32; i < 128; i++) {
				if(worldObj.getBlock(x, i, z) == IceikaBlocks.frozenGrass) {
					y = i;
					foundGround = true;
					break;
				}
			}
			if(foundGround) {
				if (rand.nextInt(4) == 3) { 
					(lights.get(rand.nextInt(lights.size()))).generate(this.worldObj, this.rand, x, y, z);
				}
			}
		}
		
		for(i = 0; i < 2; i++) { 
			x = var4 + this.rand.nextInt(16);
			z = var5 + this.rand.nextInt(16);
			boolean foundGround = false;
			for(y = 32; i < 128; i++) {
				if(worldObj.getBlock(x, i, z) == IceikaBlocks.frozenGrass) {
					y = i;
					foundGround = true;
					break;
				}
			}
			if(foundGround) {
				if (rand.nextInt(4) == 3) { 
					(village.get(rand.nextInt(village.size()))).generate(this.worldObj, this.rand, x, y, z);
				}
			}
		}
		
		if(rand.nextInt(8) == 0) { 
			x = var4 + this.rand.nextInt(16);
			z = var5 + this.rand.nextInt(16);
			boolean foundGround = false;
			for(y = 32; i < 128; i++) {
				if(worldObj.getBlock(x, i, z) == IceikaBlocks.frozenGrass) {
					y = i;
					foundGround = true;
					break;
				}
			}
			if(foundGround) (rareHouses.get(rand.nextInt(rareHouses.size()))).generate(this.worldObj, this.rand, x, y, z);
		}

		if(rand.nextInt(4) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = this.rand.nextInt(128);
			var14 = var5 + this.rand.nextInt(16) + 8;
			(new WorldGenLakes(Blocks.ice)).generate(this.worldObj, this.rand, var12, var13, var14);
		}
		
		for(i = 0; i < 5; i++) {
			x = var4 + this.rand.nextInt(16);
			z = var5 + this.rand.nextInt(16);
			y = this.worldObj.getHeightValue(x, z);
			(new WorldGenGiantTree(true)).generate(this.worldObj, this.rand, x, y, z);
		}
	}

	@Override
	public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate) {
		return true;
	}

	@Override
	public void saveExtraData() { }

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public boolean canSave() {
		return true;
	}

	@Override
	public String makeString() {
		return "Iceika";
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(par2, par4);
		return biomegenbase.getSpawnableList(par1EnumCreatureType);
	}

	@Override
	public ChunkPosition func_147416_a(World w, String s, int x, int y, int z) {
		return null;
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(int par1, int par2) { }
}