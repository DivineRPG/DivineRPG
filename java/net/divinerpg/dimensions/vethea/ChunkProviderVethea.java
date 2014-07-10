package net.divinerpg.dimensions.vethea;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.divinerpg.dimensions.vethea.all.Bow;
import net.divinerpg.dimensions.vethea.all.FloatingTree4;
import net.divinerpg.dimensions.vethea.all.FloatingTree5;
import net.divinerpg.dimensions.vethea.all.FloatingTree6;
import net.divinerpg.dimensions.vethea.all.FloatingTree7;
import net.divinerpg.dimensions.vethea.all.Hook;
import net.divinerpg.dimensions.vethea.all.InfusionOutpost;
import net.divinerpg.dimensions.vethea.all.Lamp1;
import net.divinerpg.dimensions.vethea.all.Lamp2;
import net.divinerpg.dimensions.vethea.all.Mushroom;
import net.divinerpg.dimensions.vethea.all.Pickaxe;
import net.divinerpg.dimensions.vethea.all.Pointedsquare;
import net.divinerpg.dimensions.vethea.all.Ring;
import net.divinerpg.dimensions.vethea.all.Sword;
import net.divinerpg.dimensions.vethea.all.TreeFloating1;
import net.divinerpg.dimensions.vethea.all.TreeFloating2;
import net.divinerpg.dimensions.vethea.all.TreeFloating3;
import net.divinerpg.dimensions.vethea.all.Trident;
import net.divinerpg.dimensions.vethea.all.WorldGenConeUp;
import net.divinerpg.dimensions.vethea.all.WorldGenVetheanPillar;
import net.divinerpg.dimensions.vethea.layer1.Crypt1;
import net.divinerpg.dimensions.vethea.layer1.Crypt2;
import net.divinerpg.dimensions.vethea.layer1.Tree4;
import net.divinerpg.dimensions.vethea.layer1.Tree5;
import net.divinerpg.dimensions.vethea.layer1.Tree6;
import net.divinerpg.dimensions.vethea.layer1.WorldGenLayer1Forest;
import net.divinerpg.dimensions.vethea.layer2.HiveNest;
import net.divinerpg.dimensions.vethea.layer2.Pyramid1;
import net.divinerpg.dimensions.vethea.layer2.Pyramid2;
import net.divinerpg.dimensions.vethea.layer2.Tree3;
import net.divinerpg.dimensions.vethea.layer2.WorldGenLayer2Forest;
import net.divinerpg.dimensions.vethea.layer3.KarosMadhouse;
import net.divinerpg.dimensions.vethea.layer3.QuadroticPost;
import net.divinerpg.dimensions.vethea.layer3.Tree7;
import net.divinerpg.dimensions.vethea.layer3.Tree8;
import net.divinerpg.dimensions.vethea.layer3.WorldGenLayer3SmallTree;
import net.divinerpg.dimensions.vethea.layer4.Evergarden;
import net.divinerpg.dimensions.vethea.layer4.RaglokChamber;
import net.divinerpg.dimensions.vethea.layer4.Tree1;
import net.divinerpg.dimensions.vethea.layer4.Tree2;
import net.divinerpg.dimensions.vethea.layer4.WreckHall;
import net.divinerpg.dimensions.vethea.village.WorldGenVillageIsland;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.NoiseGenerator;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.NoiseGeneratorPerlin;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;

import cpw.mods.fml.common.eventhandler.Event.Result;

public class ChunkProviderVethea implements IChunkProvider {

	private Random rand;
	private NoiseGeneratorOctaves noiseGen1;
	private NoiseGeneratorOctaves noiseGen2;
	private NoiseGeneratorOctaves noiseGen3;
	private NoiseGeneratorPerlin noiseGen4;
	public NoiseGeneratorOctaves noiseGen5;
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpawnerNoise;
	private World worldObj;
	private double[] noiseArray;
	private double[] stoneNoise = new double[256];
	private MapGenBase caveGenerator = new MapGenFloorCrystals();
	private BiomeGenBase[] biomesForGeneration;
	private final ArrayList<WorldGenerator> items;
	private final ArrayList<WorldGenerator> lamps;
	private final ArrayList<WorldGenerator> floatingTrees;
	private final ArrayList<WorldGenerator> crypts;
	private final ArrayList<WorldGenerator> l1Trees;
	private final ArrayList<WorldGenerator> pyramids;
	private final ArrayList<WorldGenerator> l2Trees;
	private final ArrayList<WorldGenerator> l3Trees;
	private final ArrayList<WorldGenerator> l4Trees;
	private final ArrayList<WorldGenerator> l3Altars;
	private final ArrayList<WorldGenerator> l4Altars;
	//private final WorldGenerator layer3TreeBig;
	private final WorldGenerator ceilingTexture;
	private final WorldGenerator pillar;
	private final WorldGenerator cracklespikes;
	private final WorldGenerator fernites;
	private final WorldGenerator bulatobes;
	private final WorldGenerator shinegrass;
	//private final WorldGenerator shimmers;
	//private final WorldGenerator dreamglows;
	private final WorldGenerator greenGemTops;
	//private final WorldGenerator purpleGemTops;
	private final WorldGenerator yellowDulahs;
	private final WorldGenerator greenDulahs;
	private final WorldGenerator infusion;

	double[] noise3;
	double[] noise1;
	double[] noise2;
	double[] noise5;
	double[] noise6;

	float[] parabolicField;
	int[][] field_73219_j = new int[32][32];

	public ChunkProviderVethea(World par1World, long par2) {
		this.worldObj = par1World;
		this.rand = new Random(par2);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGen4 = new NoiseGeneratorPerlin(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);

		NoiseGenerator[] noiseGens = {noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6, mobSpawnerNoise};
		this.noiseGen4 = (NoiseGeneratorPerlin)noiseGens[3];
		this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];

		this.items = new ArrayList(8);
		items.add(new Bow());
		items.add(new Hook());
		items.add(new Mushroom());
		items.add(new Pickaxe());
		items.add(new Pointedsquare());
		items.add(new Ring());
		items.add(new Sword());
		items.add(new Trident());

		this.lamps = new ArrayList(2);
		lamps.add(new Lamp1());
		lamps.add(new Lamp2());

		this.floatingTrees = new ArrayList(7);
		floatingTrees.add(new TreeFloating1());
		floatingTrees.add(new TreeFloating2());
		floatingTrees.add(new TreeFloating3());
		floatingTrees.add(new FloatingTree4());
		floatingTrees.add(new FloatingTree5());
		floatingTrees.add(new FloatingTree6());
		floatingTrees.add(new FloatingTree7());

		this.l1Trees = new ArrayList(3);
		l1Trees.add(new Tree4());
		l1Trees.add(new Tree5());
		l1Trees.add(new Tree6());
		
		this.l2Trees = new ArrayList(2);
		l1Trees.add(new Tree3());
		l1Trees.add(new Tree6());
		
		this.crypts = new ArrayList(2);
		crypts.add(new Crypt1());
		crypts.add(new Crypt2());     
		
		ceilingTexture = new WorldGenConeUp();
		pillar = new WorldGenVetheanPillar();
		infusion = new InfusionOutpost();
		
		this.pyramids = new ArrayList(3);
		pyramids.add(new Pyramid1());
		pyramids.add(new Pyramid2());
		pyramids.add(new HiveNest());

		this.l3Trees = new ArrayList(3);
		l3Trees.add(new Tree7());
		l3Trees.add(new Tree8());
		l3Trees.add(new WorldGenLayer3SmallTree(false));

		this.l3Altars = new ArrayList(2);
		l3Altars.add(new QuadroticPost());
		l3Altars.add(new KarosMadhouse());

		this.l4Altars = new ArrayList(3);
		l4Altars.add(new Evergarden());
		l4Altars.add(new RaglokChamber());
		l4Altars.add(new WreckHall());
		
		this.l4Trees = new ArrayList(2);
		l4Trees.add(new Tree1());
		l4Trees.add(new Tree2());

		
		//layer3TreeBig = new WorldGenLayer3BigTree(false);

		cracklespikes = new WorldGenVetheanFlower(VetheaBlocks.cracklespike);
		fernites = new WorldGenVetheanFlower(VetheaBlocks.fernite);
		bulatobes = new WorldGenVetheanFlower(VetheaBlocks.bulatobe);
		shinegrass = new WorldGenVetheanFlower(VetheaBlocks.shineGrass);
		//shimmers = new WorldGenVetheanFlower(VetheaBlocks.shimmer);
		//dreamglows = new WorldGenVetheanFlower(VetheaBlocks.dreamglow);
		greenGemTops = new WorldGenVetheanFlower(VetheaBlocks.gemtopGreen);
		//purpleGemTops = new WorldGenVetheanFlower(VetheaBlocks.gemtopPurple);
		yellowDulahs = new WorldGenVetheanFlower(VetheaBlocks.yellowDulah);
		greenDulahs = new WorldGenVetheanFlower(VetheaBlocks.greenDulah);
		
	}

	public void generateTerrain(int i, int j, Block[] b) {
		byte var4 = 8;
		byte var5 = 4;
		byte var6 = 63;
		int var7 = var4 + 1;
		byte var8 = 17;
		int var9 = var4 + 1;

		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, i * 4 - 2, j * 4 - 2, var7 + 5, var9 + 5);
		this.noiseArray = this.initializeNoiseField(this.noiseArray, i * var4, 0, j * var4, var7, var8, var9);

		for (int var10 = 0; var10 < var4; ++var10) {
			for (int var11 = 0; var11 < var4; ++var11) {
				for (int var12 = 0; var12 < var5; ++var12) {
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
								double var13 = 0.25D;
								double var15 = this.noiseArray[k1 + k2];
								double var17 = this.noiseArray[l1 + k2];
								double var19 = this.noiseArray[i1 + k2];
								double var21 = this.noiseArray[j2 + k2];
								double var23 = (this.noiseArray[k1 + k2 + 1] - var15) * d0;
								double var25 = (this.noiseArray[l1 + k2 + 1] - var17) * d0;
								double var27 = (this.noiseArray[i2 + k2 + 1] - var19) * d0;
								double var29 = (this.noiseArray[j2 + k2 + 1] - var12) * d0;

								for (int var31 = 0; var31 < 8; ++var31) {
									double var32 = 0.25D;
									double var34 = var15;
									double var36 = var17;
									double var38 = (var19 - var15) * var32;
									double var40 = (var21 - var17) * var32;

									for (int var42 = 0; var42 < 4; ++var42) {
										int var43 = var42 + var10 * 2 << 11 | 0 + var11 * 2 << 7 | var12 * 4 + var31;
										short var44 = 64;
										var43 -= var44;
										double var45 = 0.25D;
										double var49 = (var36 - var34) * var45;
										double var47 = var34 - var49;

										for (int var51 = 0; var51 < 4; ++var51) {
											if ((var47 += var49) > 0.0D) {
												b[var43 += var44] = VetheaBlocks.dreamStone;
											}
											else if (var12 * 8 + var31 < var6) {
												b[var43 += var44] = VetheaBlocks.dreamGrass;
											} else {
												b[var43 += var44] = null;
											}
										}
										var34 += var38;
										var36 += var40;
									}
									var15 += var23;
									var17 += var25;
									var19 += var27;
									var21 += var29;
								}
							}
						}
					}
				}
			}
		}
	}

	private double[] initializeNoiseField(double[] par1ArrayOfDouble, int par2, int par3, int par4, int par5, int par6, int par7) {
		ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this, par1ArrayOfDouble, par2, par3, par4, par5, par6, par7);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY)
			return event.noisefield;

		if (par1ArrayOfDouble == null) {
			par1ArrayOfDouble = new double[par5 * par6 * par7];
		}

		if (this.parabolicField == null) {
			this.parabolicField = new float[25];

			for (int var8 = -2; var8 <= 2; ++var8) {
				for (int var9 = -2; var9 <= 2; ++var9) {
					float var10 = 10.0F / MathHelper.sqrt_float((float)(var8 * var8 + var9 * var9) + 0.2F);
					this.parabolicField[var8 + 2 + (var9 + 2) * 5] = var10;
				}
			}
		}

		double var44 = 684.412D;
		double var45 = 684.412D;
		this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, par2, par3, par4, par5, par6, par7, var44, var45, var44);
		this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, par2, par3, par4, par5, par6, par7, var44, var45, var44);
		this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, par2, par3, par4, par5, par6, par7, var44, var45, var44);
		this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, par2, par3, par4, par5, par6, par7, var44, var45, var44);
		this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, par2, par3, par4, par5, par6, par7, var44, var45, var44);
		boolean var43 = false;
		boolean var42 = false;
		int var12 = 0;
		int var13 = 0;

		for (int var14 = 0; var14 < par5; ++var14) {
			for (int var15 = 0; var15 < par7; ++var15) {
				float var16 = 0.0F;
				float var17 = 0.0F;
				float var18 = 0.0F;
				byte var19 = 2;
				BiomeGenBase var20 = this.biomesForGeneration[var14 + 2 + (var15 + 2) * (par5 + 5)];

				for (int var21 = -var19; var21 <= var19; ++var21) {
					for (int var22 = -var19; var22 <= var19; ++var22) {
						BiomeGenBase var23 = this.biomesForGeneration[var14 + var21 + 2 + (var15 + var22 + 2) * (par5 + 5)];
						float var24 = this.parabolicField[var21 + 2 + (var22 + 2) * 5] / (var23.rootHeight + 2.0F);

						if (var23.rootHeight > var20.heightVariation) {
							var24 /= 3.0F;
						}

						var16 += var23.rootHeight * var24;
						var17 += var23.rootHeight * var24;
						var18 += var24;
					}
				}

				var16 /= var18;
				var17 /= var18;
				var16 = var16 * 0.9F + 0.1F;
				var17 = (var17 * 4.0F - 1.0F) / 8.0F;
				double var47 = this.noise6[var13] / 8000.0D;

				if (var47 < 0.0D) {
					var47 = -var47 * 0.3D;
				}

				var47 = var47 * 3.0D - 2.0D;

				if (var47 < 0.0D) {
					var47 /= 2.0D;

					if (var47 < -1.0D) {
						var47 = -1.0D;
					}

					var47 /= 1.4D;
					var47 /= 2.0D;
				} else {
					if (var47 > 1.0D) {
						var47 = 1.0D;
					}

					var47 /= 8.0D;
				}

				++var13;

				for (int var46 = 0; var46 < par6; ++var46) {
					double var48 = (double)var17;
					double var26 = (double)var16;
					var48 += var47 * 0.2D;
					var48 = var48 * (double)par6 / 16.0D;
					double var28 = (double)par6 / 2.0D + var48 * 4.0D;
					double var30 = 0.0D;
					double var32 = ((double)var46 - var28) * 12.0D * 128.0D / 128.0D / var26;

					if (var32 < 0.0D) {
						var32 *= 4.0D;
					}

					double var34 = this.noise1[var12] / 512.0D;
					double var36 = this.noise2[var12] / 512.0D;
					double var38 = (this.noise3[var12] / 10.0D + 1.0D) / 2.0D;

					if (var38 < 0.0D) {
						var30 = var34;
					}
					else if (var38 > 1.0D) {
						var30 = var36;
					} else {
						var30 = var34 + (var36 - var34) * var38;
					}

					var30 -= var32;

					if (var46 > par6 - 4) {
						double var40 = (double)((float)(var46 - (par6 - 4)) / 3.0F);
						var30 = var30 * (1.0D - var40) + -10.0D * var40;
					}

					par1ArrayOfDouble[var12] = var30;
					++var12;
				}
			}
		}

		return par1ArrayOfDouble;
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

	public final void genBiomeTerrain(World p_150560_1_, Random p_150560_2_, Block[] p_150560_3_, byte[] p_150560_4_, int p_150560_5_, int p_150560_6_, double p_150560_7_, BiomeGenBase b) {
		boolean flag = true;
		Block block = b.topBlock;
		byte b0 = (byte)(b.field_150604_aj & 255);
		Block block1 = b.fillerBlock;
		int k = -1;
		int l = (int)(p_150560_7_ / 3.0D + 3.0D + p_150560_2_.nextDouble() * 0.25D);
		int i1 = p_150560_5_ & 15;
		int j1 = p_150560_6_ & 15;
		int k1 = p_150560_3_.length / 256;

		for (int l1 = 255; l1 >= 0; --l1) {
			int i2 = (j1 * 16 + i1) * k1 + l1;

			if (l1 <= 0 + p_150560_2_.nextInt(5)) {
				p_150560_3_[i2] = VetheaBlocks.dreamStone;
			} else {
				Block block2 = p_150560_3_[i2];

				if (block2 != null && block2.getMaterial() != Material.air) {
					if (block2 == VetheaBlocks.dreamStone) {
						if (k == -1) {
							if (l <= 0) {
								block = null;
								b0 = 0;
								block1 = VetheaBlocks.dreamStone;
							}
							else if (l1 >= 59 && l1 <= 64) {
								block = b.topBlock;
								b0 = (byte)(b.field_150604_aj & 255);
								block1 = b.topBlock;
							}

							if (l1 < 63 && (block == null || block.getMaterial() == Material.air)) {
								if (b.getFloatTemperature(p_150560_5_, l1, p_150560_6_) < 0.15F) {
									block = b.topBlock;
									b0 = 0;
								}
							}

							k = l;

							if (l1 >= 62) {
								p_150560_3_[i2] = block;
								p_150560_4_[i2] = b0;
							}
							else if (l1 < 56 - l) {
								block = null;
								block1 = b.topBlock;
								p_150560_3_[i2] = b.topBlock;
							} else {
								p_150560_3_[i2] = block1;
							}
						}
						else if (k > 0) {
							--k;
							p_150560_3_[i2] = block1;

							if (k == 0 && block1 == VetheaBlocks.dreamStone) {
								k = p_150560_2_.nextInt(4) + Math.max(0, l1 - 63);
								block1 = VetheaBlocks.dreamStone;//
							}
						}
					}
				} else {
					k = -1;
				}
			}
		}
	}

	public Chunk loadChunk(int par1, int par2) {
		return this.provideChunk(par1, par2);
	}

	public Chunk provideChunk(int par1, int par2) {
		this.rand.setSeed((long)par1 * 341873128712L + (long)par2 * 132897987541L);
		Block[] block = new Block[65536];
		byte[] by = new byte[65536];
		this.generateTerrain(par1, par2, block);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
		this.replaceBlocksForBiome(par1, par2, block, by, this.biomesForGeneration);
		Chunk var4 = new Chunk(this.worldObj, block, par1, par2);
		byte[] var5 = var4.getBiomeArray();
		caveGenerator.func_151539_a(this, worldObj, par1, par2, block);
		for (int var6 = 0; var6 < var5.length; ++var6) {
			var5[var6] = (byte)this.biomesForGeneration[var6].biomeID;
		}

		var4.generateSkylightMap();
		return var4;
	}

	public boolean chunkExists(int par1, int par2) {
		return true;
	}

	public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
		BlockSand.fallInstantly = true;
		int var4 = par2 * 16;
		int var5 = par3 * 16;
		BiomeGenBase var6 = this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		long var7 = this.rand.nextLong() / 2L * 2L + 1L;
		long var9 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed((long)par2 * var7 + (long)par3 * var9 ^ this.worldObj.getSeed());
		boolean var11 = false;

		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(par1IChunkProvider, worldObj, rand, par2, par3, var11));

		int var12;
		int var13;
		int var14;

		for (int i = 0; i < 3; i++) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 64;

			var14 = var5 + this.rand.nextInt(16) + 8;
			(new WorldGenConeUp()).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		//greenGemTops.generate(worldObj, rand, var4, 0, var5);
		//purpleGemTops.generate(worldObj, rand, var4, 0, var5);
		//yellowDulahs.generate(worldObj, rand, var4, 0, var5);
		//greenDulahs.generate(worldObj, rand, var4, 0, var5);

		if (this.rand.nextInt(16) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 20 - this.rand.nextInt(2);
			var14 = var5 + this.rand.nextInt(16) + 8;
			(new WorldGenVetheanPillar()).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		for(int i = 0; i < 2; i++) {
			var12 = 16;
			var13 = 20;
			var14 = 16;
			(new WorldGenMinable(VetheaBlocks.dreamGrass, 16, VetheaBlocks.dreamStone)).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		for(int i = 0; i < 1; i++) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = rand.nextInt(256);
			var14 = var5 + this.rand.nextInt(16) + 8;
			(new WorldGenMinable(VetheaBlocks.fireCrystal, 90, VetheaBlocks.dreamGrass)).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(32) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 20;
			var14 = var5 + this.rand.nextInt(16) + 8;
			while(this.worldObj.isAirBlock(var12, var13, var14))
				var13--;
			infusion.generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(32) == 0) {
            var12 = var4 + this.rand.nextInt(16);
            var13 = 20 - this.rand.nextInt(2);
            var14 = var5 + this.rand.nextInt(16);
            (this.items.get(this.rand.nextInt(7))).generate(this.worldObj, this.rand, var12, var13, var14);
        }
		
		for (int i = 0; i < 1; ++i) {
            var12 = var4 + this.rand.nextInt(16) + 8;
            var13 = 30;
            var14 = var5 + this.rand.nextInt(16) + 8;
            (this.floatingTrees.get(this.rand.nextInt(6))).generate(this.worldObj, this.rand, var12, var13, var14);
        }

        if (this.rand.nextInt(2) == 0) {
            var12 = var4 + this.rand.nextInt(16) + 8;
            var13 = 20;
            var14 = var5 + this.rand.nextInt(16) + 8;
            (this.lamps.get(this.rand.nextInt(2))).generate(this.worldObj, this.rand, var12, var13 - 2, var14);
        }
        
        if (this.rand.nextInt(500) == 0) {
            var12 = var4 + this.rand.nextInt(16) + 8;
            var13 = 40;
            var14 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenVillageIsland()).generate(this.worldObj, this.rand, var12, var13, var14);//TODO add hunger
        }
		
        for (int i = 0; i < 1; i++) {
            var12 = var4 + this.rand.nextInt(16) + 8;
            var13 = 20;
            var14 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenLayer1Forest(false)).generate(this.worldObj, this.rand, var12, var13, var14);
        }
        
        if (this.rand.nextInt(250) == 0) {
            var12 = var4 + this.rand.nextInt(16) + 8;
            var13 = 15;
            var14 = var5 + this.rand.nextInt(16) + 8;
            (crypts.get(this.rand.nextInt(2))).generate(this.worldObj, this.rand, var12, var13, var14);//TODO add crypt keeper
        }
        
        if (this.rand.nextInt(250) == 0) {
            var12 = var4 + this.rand.nextInt(16) + 8;
            var13 = 15;
            var14 = var5 + this.rand.nextInt(16) + 8;
            (l1Trees.get(this.rand.nextInt(2))).generate(this.worldObj, this.rand, var12, var13, var14);
        }
        
		/*
		 * Layer 2
		 */
		for (int i = 0; i < 3; i++) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 128;
			var14 = var5 + this.rand.nextInt(16) + 8;
			 (ceilingTexture).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(16) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 84 - this.rand.nextInt(2);
			var14 = var5 + this.rand.nextInt(16) + 8;
			pillar.generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if(this.rand.nextInt(32) == 0) {
			var12 = var4 + rand.nextInt(16);
			var13 = 84;
			var14 = var5 + rand.nextInt(16);
			(this.items.get(this.rand.nextInt(6))).generate(this.worldObj, rand, var12, var13, var14);
		}

		if (this.rand.nextInt(32) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 85;
			var14 = var5 + this.rand.nextInt(16) + 8;
			while(this.worldObj.isAirBlock(var12, var13, var14)) {
				var13--;
			}
			infusion.generate(this.worldObj, this.rand, var12, var13, var14);
		}

		for (int i = 0; i < 3; ++i) {
			var12 = var4 + this.rand.nextInt(16);
			var13 = 90;
			var14 = var5 + this.rand.nextInt(16);
			(this.floatingTrees.get(this.rand.nextInt(6))).generate(this.worldObj, rand, var12, var13, var14);
		}

		if (this.rand.nextInt(2) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 80;
			var14 = var5 + this.rand.nextInt(16) + 8;
			while(!this.worldObj.isAirBlock(var12, var13, var14)) {
				var13++;
			}
			 (this.lamps.get(this.rand.nextInt(2))).generate(this.worldObj, this.rand, var12, var13 - 2, var14);
		}

		if (this.rand.nextInt(250) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 80;
			var14 = var5 + this.rand.nextInt(16) + 8;
			while(!this.worldObj.isAirBlock(var12, var13, var14)) {
				var13++;
			}
			(pyramids.get(this.rand.nextInt(3))).generate(this.worldObj, this.rand, var12, var13, var14);//Add the mobs
		}
		
		for (int i = 0; i < 3; i++) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 84;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(new WorldGenLayer2Forest(false)).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 20 + 64;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(fernites).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 20 + 64;
			var14 = var5 + this.rand.nextInt(16) + 8;
			//(dreamglows).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 20 + 64;
			var14 = var5 + this.rand.nextInt(16) + 8;
			//(shimmers).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		/*
		  * layer 3
		  */
		for (int i = 0; i < 3; i++) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 192;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(ceilingTexture).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(16) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 148;
			var14 = var5 + this.rand.nextInt(16) + 8;
			pillar.generate(this.worldObj, this.rand, var12, var13, var14);
		}

		for (int i = 0; i < 3; i++) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 148;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(new WorldGenLayer1Forest(false)).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(32) == 0) {
			var12 = var4 + rand.nextInt(16);
			var13 = 148;
			var14 = var5 + rand.nextInt(16);
			(this.items.get(this.rand.nextInt(7))).generate(this.worldObj, rand, var12, var13, var14);
		}


		if (this.rand.nextInt(32) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 148;
			var14 = var5 + this.rand.nextInt(16) + 8;
			while(this.worldObj.isAirBlock(var12, var13, var14)) {
				var13--;
			}
			infusion.generate(this.worldObj, this.rand, var12, var13, var14);
		}

		for (int i = 0; i < 3; ++i) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 158;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(this.floatingTrees.get(this.rand.nextInt(6))).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(2) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 19 + 128;
			var14 = var5 + this.rand.nextInt(16) + 8;
			while(!this.worldObj.isAirBlock(var12, var13, var14)) {
				var13++;
			}
			(this.lamps.get(this.rand.nextInt(2))).generate(this.worldObj, this.rand, var12, var13 - 2, var14);
		}

		if (this.rand.nextInt(250) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 144 ;
			var14 = var5 + this.rand.nextInt(16) + 8;
			while(!this.worldObj.isAirBlock(var12, var13, var14)) {
				var13++;
			}
			(l3Altars.get(this.rand.nextInt(2))).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 20 + 128;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(shinegrass).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 20 + 128;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(cracklespikes).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 20 + 128;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(bulatobes).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		/*
		   * Layer 4
		   */
		if (this.rand.nextInt(32) == 0) {
			var12 = var4 + rand.nextInt(16);
			var13 = 212;
			var14 = var5 + rand.nextInt(16);
			(this.items.get(this.rand.nextInt(7))).generate(this.worldObj, rand, var12, var13, var14);
		}

		if (this.rand.nextInt(32) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 212;
			var14 = var5 + this.rand.nextInt(16) + 8;
			while(this.worldObj.isAirBlock(var12, var13, var14)) {
				var13--;
			}
			infusion.generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(2) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 210;
			var14 = var5 + this.rand.nextInt(16) + 8;
			while(!this.worldObj.isAirBlock(var12, var13, var14)) {
				var13++;
			}
			(this.lamps.get(this.rand.nextInt(2))).generate(this.worldObj, this.rand, var12, var13 - 2, var14);
		}

		for (int i = 0; i < 5; i++) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 212;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(new WorldGenLayer2Forest(false)).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		for (int i = 0; i < 3; ++i) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 222 + this.rand.nextInt(23);
			var14 = var5 + this.rand.nextInt(16) + 8;
			(this.floatingTrees.get(this.rand.nextInt(6))).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(150) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 210 ;
			var14 = var5 + this.rand.nextInt(16) + 8;
			while(!this.worldObj.isAirBlock(var12, var13, var14)) {
				var13++;
			}
			(l4Altars.get(this.rand.nextInt(3))).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		/*if (this.rand.nextInt(150) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 19 + 196;
			var14 = var5 + this.rand.nextInt(16) + 8;  
			while(!this.worldObj.isAirBlock(var12, var13, var14)) {
				var13++;
			}
			(new Layer4MassiveTree(false)).generate(this.worldObj, this.rand, var12, var13, var14);
		}*/

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 212;
			var14 = var5 + this.rand.nextInt(16) + 8;
			//(shimmers).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 212;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(shinegrass).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 212;
			var14 = var5 + this.rand.nextInt(16) + 8;
			//(dreamglows).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(par1IChunkProvider, worldObj, rand, par2, par3, var11));
		BlockSand.fallInstantly = false;
	}

	public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate) {
		return true;
	}

	public boolean canSave() {
		return true;
	}

	public String makeString() {
		return "Vethea";
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType enumcreaturetype, int i, int j, int k) {
		BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(i, k);
		return var5 == null ? null : var5.getSpawnableList(enumcreaturetype);
	}

	public int getLoadedChunkCount() {
		return 0;
	}

	public void recreateStructures(int par1, int par2) { }

	@Override
	public boolean unloadQueuedChunks() {
		return false;
	}

	@Override
	public void saveExtraData() { }

	@Override
	public ChunkPosition func_147416_a(World var1, String var2, int var3, int var4, int var5) {
		return null;
	}
}