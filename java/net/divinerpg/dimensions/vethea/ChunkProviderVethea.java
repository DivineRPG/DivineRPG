package net.divinerpg.dimensions.vethea;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.divinerpg.dimensions.vethea.all.CeilingTexture;
import net.divinerpg.dimensions.vethea.all.WorldGenConeDown;
import net.divinerpg.dimensions.vethea.layer1.Crypt1;
import net.divinerpg.dimensions.vethea.layer1.Crypt2;
import net.divinerpg.dimensions.vethea.layer1.WorldGenLayer1Forest;
import net.divinerpg.dimensions.vethea.layer2.HiveNest;
import net.divinerpg.dimensions.vethea.layer2.Pyramid1;
import net.divinerpg.dimensions.vethea.layer2.Pyramid2;
import net.divinerpg.dimensions.vethea.layer2.WorldGenLayer2Forest;
import net.divinerpg.dimensions.vethea.layer3.KarosMadhouse;
import net.divinerpg.dimensions.vethea.layer3.QuadroticPost;
import net.divinerpg.dimensions.vethea.layer3.Tree7;
import net.divinerpg.dimensions.vethea.layer3.Tree8;
import net.divinerpg.dimensions.vethea.layer3.WorldGenLayer3SmallTree;
import net.divinerpg.dimensions.vethea.layer4.Evergarden;
import net.divinerpg.dimensions.vethea.layer4.Layer4Tree1;
import net.divinerpg.dimensions.vethea.layer4.Layer4Tree2;
import net.divinerpg.dimensions.vethea.layer4.RaglokChamber;
import net.divinerpg.dimensions.vethea.layer4.WreckHall;
import net.divinerpg.dimensions.vethea.village.WorldGenVillageIsland;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;

public class ChunkProviderVethea implements IChunkProvider {

	private Random rand;
	private World worldObj;
	private BiomeGenBase[] biomesForGeneration;
	private final ArrayList<WorldGenerator> crypts;
	private final ArrayList<WorldGenerator> pyramids;
	private final ArrayList<WorldGenerator> l3Trees;
	private final ArrayList<WorldGenerator> l4Trees;
	private final ArrayList<WorldGenerator> l3Altars;
	private final ArrayList<WorldGenerator> l4Altars;
	//private final WorldGenerator layer3TreeBig;
	private final MapGenFloorCrystals firecrystals = new MapGenFloorCrystals();
	private final CeilingTexture ceilingTexture;
	private final WorldGenerator cracklespikes;
	private final WorldGenerator fernites;
	private final WorldGenerator bulatobes;
	private final WorldGenerator shinegrass;
	private final WorldGenerator shimmers;
	private final WorldGenerator dreamglows;
	private final WorldGenerator greenGemTops;
	private final WorldGenerator purpleGemTops;
	private final WorldGenerator yellowDulahs;
	private final WorldGenerator greenDulahs;
	private final WorldGenerator hungerVillages;
	private final WorldGenerator l1Forest = new WorldGenLayer1Forest(false);
	private final WorldGenerator l2Forest = new WorldGenLayer2Forest(false);

	public ChunkProviderVethea(World par1World, long par2) {
		this.worldObj = par1World;
		this.rand = new Random(par2);
		
		this.crypts = new ArrayList(2);
		crypts.add(new Crypt1());
		crypts.add(new Crypt2());     
		
		ceilingTexture = new CeilingTexture(Blocks.air);
		hungerVillages = new WorldGenVillageIsland();
		
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
		l4Trees.add(new Layer4Tree1());
		l4Trees.add(new Layer4Tree2());

		
		//layer3TreeBig = new WorldGenLayer3BigTree(false);

		cracklespikes = new WorldGenVetheanFlower(VetheaBlocks.cracklespike);
		fernites = new WorldGenVetheanFlower(VetheaBlocks.fernite);
		bulatobes = new WorldGenVetheanFlower(VetheaBlocks.bulatobe);
		shinegrass = new WorldGenVetheanFlower(VetheaBlocks.shineGrass);
		shimmers = new WorldGenVetheanFlower(VetheaBlocks.shimmer);
		dreamglows = new WorldGenVetheanFlower(VetheaBlocks.dreamglow);
		greenGemTops = new WorldGenVetheanFlower(VetheaBlocks.gemtopGreen);
		purpleGemTops = new WorldGenVetheanFlower(VetheaBlocks.gemtopPurple);
		yellowDulahs = new WorldGenVetheanFlower(VetheaBlocks.yellowDulah);
		greenDulahs = new WorldGenVetheanFlower(VetheaBlocks.greenDulah);
		
	}

	@Override
	public Chunk loadChunk(int par1, int par2) {
		return this.provideChunk(par1, par2);
	}

	@Override
	public Chunk provideChunk(int chunkX, int chunkZ) {
		this.rand.setSeed((long)chunkX * 341873128712L + (long)chunkZ * 132897987541L);
		Block[] block;
		VetheanChunkBuilder builder = new VetheanChunkBuilder();
		builder.rand.setSeed((long)chunkX * 341873128712L + (long)chunkZ * 132897987541L);
		block = builder.buildChunk(chunkX, chunkZ).getChunkData();
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
		this.firecrystals.func_151539_a(this, this.worldObj, chunkX, chunkZ, block);
		Chunk var4 = new Chunk(this.worldObj, block, new byte[65536], chunkX, chunkZ);
		byte[] var5 = var4.getBiomeArray();
		for (int var6 = 0; var6 < var5.length; ++var6) {
			var5[var6] = (byte)this.biomesForGeneration[var6].biomeID;
		}

		var4.generateSkylightMap();
		return var4;
	}

	public boolean chunkExists(int par1, int par2) {
		return true;
	}

	@Override
	public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
		
		int var4 = par2 * 16;
		int var5 = par3 * 16;
		BiomeGenBase var6 = this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		long var7 = this.rand.nextLong() / 2L * 2L + 1L;
		long var9 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed((long)par2 * var7 + (long)par3 * var9 ^ this.worldObj.getSeed());
		boolean var11 = false;
		int var12;
		int var13;
		int var14;

		
				var12 = var4 + this.rand.nextInt(16) + 8;
				var13 = 49;
				var14 = var5 + this.rand.nextInt(16) + 8;
				(ceilingTexture).generate(this.worldObj, this.rand, var12, var13, var14);
				
				if(this.rand.nextInt(5)==0)greenGemTops.generate(worldObj, rand, var4, 17, var5);
				if(this.rand.nextInt(5)==0)purpleGemTops.generate(worldObj, rand, var4, 17, var5);
				if(this.rand.nextInt(5)==0)yellowDulahs.generate(worldObj, rand, var4, 17, var5);
				if(this.rand.nextInt(5)==0)greenDulahs.generate(worldObj, rand, var4, 17, var5);
		        
		        if (this.rand.nextInt(500) == 0) {
		            var12 = var4 + this.rand.nextInt(16) + 8;
		            var13 = 30;
		            var14 = var5 + this.rand.nextInt(16) + 8;
		            (hungerVillages).generate(this.worldObj, this.rand, var12, var13, var14);
		        }
				
		        for (int i = 0; i < 1; i++) {
		            var12 = var4 + this.rand.nextInt(16) + 8;
		            var13 = 17;
		            var14 = var5 + this.rand.nextInt(16) + 8;
		            l1Forest.generate(this.worldObj, this.rand, var12, var13, var14);
		        }
		        
		        if (this.rand.nextInt(250) == 0) {
		            var12 = var4 + this.rand.nextInt(16) + 8;
		            var13 = 13;
		            var14 = var5 + this.rand.nextInt(16) + 8;
		            (crypts.get(this.rand.nextInt(2))).generate(this.worldObj, this.rand, var12, var13, var14);
		        }
		        
				 // Layer 2
				 
				var12 = var4 + this.rand.nextInt(16) + 8;
				var13 = 97;
				var14 = var5 + this.rand.nextInt(16) + 8;
				(ceilingTexture).generate(this.worldObj, this.rand, var12, var13, var14);

				if (this.rand.nextInt(250) == 0) {
					var12 = var4 + this.rand.nextInt(16) + 8;
					var13 = 65;
					var14 = var5 + this.rand.nextInt(16) + 8;
					if(worldObj.getBlock(var12, var13, var14) == Blocks.air)(pyramids.get(this.rand.nextInt(3))).generate(this.worldObj, this.rand, var12, var13, var14);//Add the mobs
				}
				
				for (int i = 0; i < 3; i++) {
					var12 = var4 + this.rand.nextInt(16) + 8;
					var13 = 65;
					var14 = var5 + this.rand.nextInt(16) + 8;
					l2Forest.generate(this.worldObj, this.rand, var12, var13, var14);
				}

				if (this.rand.nextInt(10) == 0) {
					var12 = var4 + this.rand.nextInt(16) + 8;
					var13 = 65;
					var14 = var5 + this.rand.nextInt(16) + 8;
					(fernites).generate(this.worldObj, this.rand, var12, var13, var14);
				}

				if (this.rand.nextInt(10) == 0) {
					var12 = var4 + this.rand.nextInt(16) + 8;
					var13 = 65;
					var14 = var5 + this.rand.nextInt(16) + 8;
					(dreamglows).generate(this.worldObj, this.rand, var12, var13, var14);
				}

				if (this.rand.nextInt(10) == 0) {
					var12 = var4 + this.rand.nextInt(16) + 8;
					var13 = 65;
					var14 = var5 + this.rand.nextInt(16) + 8;
					(shimmers).generate(this.worldObj, this.rand, var12, var13, var14);
				}
				

				/*
				  * layer 3
				  */
				var12 = var4 + this.rand.nextInt(16) + 8;
				var13 = 145;
				var14 = var5 + this.rand.nextInt(16) + 8;
				(ceilingTexture).generate(this.worldObj, this.rand, var12, var13, var14);

				for (int i = 0; i < 3; i++) {
					var12 = var4 + this.rand.nextInt(16) + 8;
					var13 = 113;
					var14 = var5 + this.rand.nextInt(16) + 8;
					l1Forest.generate(this.worldObj, this.rand, var12, var13, var14);
				}

				if (this.rand.nextInt(250) == 0) {
					var12 = var4 + this.rand.nextInt(16) + 8;
					var13 = 113;
					var14 = var5 + this.rand.nextInt(16) + 8;
					(l3Altars.get(this.rand.nextInt(2))).generate(this.worldObj, this.rand, var12, var13, var14);
				}

				if (this.rand.nextInt(10) == 0) {
					var12 = var4 + this.rand.nextInt(16) + 8;
					var13 = 113;
					var14 = var5 + this.rand.nextInt(16) + 8;
					(shinegrass).generate(this.worldObj, this.rand, var12, var13, var14);
				}

				if (this.rand.nextInt(10) == 0) {
					var12 = var4 + this.rand.nextInt(16) + 8;
					var13 = 113;
					var14 = var5 + this.rand.nextInt(16) + 8;
					(cracklespikes).generate(this.worldObj, this.rand, var12, var13, var14);
				}

				if (this.rand.nextInt(10) == 0) {
					var12 = var4 + this.rand.nextInt(16) + 8;
					var13 = 113;
					var14 = var5 + this.rand.nextInt(16) + 8;
					(bulatobes).generate(this.worldObj, this.rand, var12, var13, var14);
				}

				   //Layer 4
				
				
				for (int i = 0; i < 5; i++) {
					var12 = var4 + this.rand.nextInt(16) + 8;
					var13 = 161;
					var14 = var5 + this.rand.nextInt(16) + 8;
					(new WorldGenLayer2Forest(false)).generate(this.worldObj, this.rand, var12, var13, var14);
				}

				if (this.rand.nextInt(150) == 0) {
					var12 = var4 + this.rand.nextInt(16) + 8;
					var13 = 161;
					var14 = var5 + this.rand.nextInt(16) + 8;
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
					var13 = 161;
					var14 = var5 + this.rand.nextInt(16) + 8;
					(shimmers).generate(this.worldObj, this.rand, var12, var13, var14);
				}

				if (this.rand.nextInt(10) == 0) {
					var12 = var4 + this.rand.nextInt(16) + 8;
					var13 = 161;
					var14 = var5 + this.rand.nextInt(16) + 8;
					(shinegrass).generate(this.worldObj, this.rand, var12, var13, var14);
				}

				if (this.rand.nextInt(10) == 0) {
					var12 = var4 + this.rand.nextInt(16) + 8;
					var13 = 161;
					var14 = var5 + this.rand.nextInt(16) + 8;
					(dreamglows).generate(this.worldObj, this.rand, var12, var13, var14);
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