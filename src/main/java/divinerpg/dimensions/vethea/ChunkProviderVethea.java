package divinerpg.dimensions.vethea;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import divinerpg.dimensions.vethea.all.CeilingTexture;
import divinerpg.dimensions.vethea.all.WorldGenConeDown;
/*import divinerpg.dimensions.vethea.layer1.Crypt1;
import divinerpg.dimensions.vethea.layer1.Crypt2;
import divinerpg.dimensions.vethea.layer1.WorldGenLayer1Forest;
import divinerpg.dimensions.vethea.layer2.HiveNest;
//import divinerpg.dimensions.vethea.layer2.Pyramid1;
import divinerpg.dimensions.vethea.layer2.Pyramid2;
import divinerpg.dimensions.vethea.layer2.WorldGenLayer2Forest;
import divinerpg.dimensions.vethea.layer3.KarosMadhouse;
import divinerpg.dimensions.vethea.layer3.QuadroticPost;
import divinerpg.dimensions.vethea.layer3.Tree7;
import divinerpg.dimensions.vethea.layer3.Tree8;
import divinerpg.dimensions.vethea.layer3.WorldGenLayer3SmallTree;
import divinerpg.dimensions.vethea.layer4.Evergarden;
import divinerpg.dimensions.vethea.layer4.Layer4Tree1;
import divinerpg.dimensions.vethea.layer4.Layer4Tree2;
import divinerpg.dimensions.vethea.layer4.RaglokChamber;
import divinerpg.dimensions.vethea.layer4.WreckHall;
import divinerpg.dimensions.vethea.village.WorldGenVillageIsland;*/
import divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;

public class ChunkProviderVethea implements IChunkGenerator {

	private Random rand;
	private World worldObj;
	private Biome[] biomesForGeneration;
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
	//private final WorldGenerator hungerVillages;
	//private final WorldGenerator l1Forest = new WorldGenLayer1Forest(false);
	//private final WorldGenerator l2Forest = new WorldGenLayer2Forest(false);

	public ChunkProviderVethea(World par1World, long par2) {
		this.worldObj = par1World;
		this.rand = new Random(par2);
		
		this.crypts = new ArrayList(2);
		//crypts.add(new Crypt1());
		//crypts.add(new Crypt2());
		
		ceilingTexture = new CeilingTexture(Blocks.AIR);
		//hungerVillages = new WorldGenVillageIsland();
		
		this.pyramids = new ArrayList(3);
		//pyramids.add(new Pyramid1());
		//pyramids.add(new Pyramid2());
		//pyramids.add(new HiveNest());

		this.l3Trees = new ArrayList(3);
		//l3Trees.add(new Tree7());
		//l3Trees.add(new Tree8());
		//l3Trees.add(new WorldGenLayer3SmallTree(false));

		this.l3Altars = new ArrayList(2);
		//l3Altars.add(new QuadroticPost());
		//l3Altars.add(new KarosMadhouse());

		this.l4Altars = new ArrayList(3);
		//l4Altars.add(new Evergarden());
		//l4Altars.add(new RaglokChamber());
		//l4Altars.add(new WreckHall());
		
		this.l4Trees = new ArrayList(2);
		//l4Trees.add(new Layer4Tree1());
		//l4Trees.add(new Layer4Tree2());

		
		//layer3TreeBig = new WorldGenLayer3BigTree(false);

		cracklespikes = new WorldGenVetheanFlower(ModBlocks.cracklespike);
		fernites = new WorldGenVetheanFlower(ModBlocks.fernite);
		bulatobes = new WorldGenVetheanFlower(ModBlocks.bulatobe);
		shinegrass = new WorldGenVetheanFlower(ModBlocks.shineGrass);
		shimmers = new WorldGenVetheanFlower(ModBlocks.shimmer);
		dreamglows = new WorldGenVetheanFlower(ModBlocks.dreamglow);
		greenGemTops = new WorldGenVetheanFlower(ModBlocks.gemtopGreen);
		purpleGemTops = new WorldGenVetheanFlower(ModBlocks.gemtopPurple);
		yellowDulahs = new WorldGenVetheanFlower(ModBlocks.yellowDulah);
		greenDulahs = new WorldGenVetheanFlower(ModBlocks.greenDulah);
		
	}

	@Override
	public Chunk generateChunk(int chunkX, int chunkZ) {
		System.out.println("Attempting to generate chunk");
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		this.rand.setSeed((long)chunkX * 341873128712L + (long)chunkZ * 132897987541L);
		VetheanChunkBuilder builder = new VetheanChunkBuilder(worldObj);
		builder.rand.setSeed((long)chunkX * 341873128712L + (long)chunkZ * 132897987541L);

		// Setup biomes again for actual biome decoration
		this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomes(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
		this.firecrystals.generate(this.worldObj, chunkX, chunkZ, chunkPrimer);
		Chunk chunk = new VetheanChunkBuilder(this.worldObj).buildChunk(chunkX, chunkZ);

		byte[] biomeArray = chunk.getBiomeArray();
		for (int i = 0; i < biomeArray.length; ++i) {
			biomeArray[i] = (byte)Biome.getIdForBiome(this.biomesForGeneration[i]);
		}

		chunk.generateSkylightMap();
		return chunk;
	}

	public boolean chunkExists(int par1, int par2) {
		return true;
	}

	@Override
	public void populate(int par2, int par3) {
		System.out.println("Attempting to populate chunk");
		int var4 = par2 * 16;
		int var5 = par3 * 16;
		Biome var6 = this.worldObj.getBiome(new BlockPos(var4, 0, var5).add(16, 0, 16));
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
		(ceilingTexture).generate(this.worldObj, this.rand, new BlockPos(var12, var13, var14));

		if(this.rand.nextInt(5)==0)greenGemTops.generate(worldObj, rand, new BlockPos(var4, 17, var5));
		if(this.rand.nextInt(5)==0)purpleGemTops.generate(worldObj, rand, new BlockPos(var4, 17, var5));
		if(this.rand.nextInt(5)==0)yellowDulahs.generate(worldObj, rand, new BlockPos(var4, 17, var5));
		if(this.rand.nextInt(5)==0)greenDulahs.generate(worldObj, rand, new BlockPos(var4, 17, var5));

		if (this.rand.nextInt(500) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 30;
			var14 = var5 + this.rand.nextInt(16) + 8;
			//(hungerVillages).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		for (int i = 0; i < 1; i++) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 17;
			var14 = var5 + this.rand.nextInt(16) + 8;
			//l1Forest.generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(250) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 13;
			var14 = var5 + this.rand.nextInt(16) + 8;
			//(crypts.get(this.rand.nextInt(2))).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		// Layer 2

		var12 = var4 + this.rand.nextInt(16) + 8;
		var13 = 97;
		var14 = var5 + this.rand.nextInt(16) + 8;
		(ceilingTexture).generate(this.worldObj, this.rand, new BlockPos(var12, var13, var14));

		if (this.rand.nextInt(250) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 65;
			var14 = var5 + this.rand.nextInt(16) + 8;
			//if(worldObj.getBlock(var12, var13, var14) == Blocks.air)(pyramids.get(this.rand.nextInt(3))).generate(this.worldObj, this.rand, var12, var13, var14);//Add the mobs
		}

		for (int i = 0; i < 3; i++) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 65;
			var14 = var5 + this.rand.nextInt(16) + 8;
			//l2Forest.generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 65;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(fernites).generate(this.worldObj, this.rand, new BlockPos(var12, var13, var14));
		}

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 65;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(dreamglows).generate(this.worldObj, this.rand, new BlockPos(var12, var13, var14));
		}

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 65;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(shimmers).generate(this.worldObj, this.rand, new BlockPos(var12, var13, var14));
		}


		/*
		 * layer 3
		 */
		var12 = var4 + this.rand.nextInt(16) + 8;
		var13 = 145;
		var14 = var5 + this.rand.nextInt(16) + 8;
		(ceilingTexture).generate(this.worldObj, this.rand, new BlockPos(var12, var13, var14));

		for (int i = 0; i < 3; i++) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 113;
			var14 = var5 + this.rand.nextInt(16) + 8;
			//l1Forest.generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(250) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 113;
			var14 = var5 + this.rand.nextInt(16) + 8;
			//(l3Altars.get(this.rand.nextInt(2))).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 113;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(shinegrass).generate(this.worldObj, this.rand, new BlockPos(var12, var13, var14));
		}

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 113;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(cracklespikes).generate(this.worldObj, this.rand, new BlockPos(var12, var13, var14));
		}

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 113;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(bulatobes).generate(this.worldObj, this.rand, new BlockPos(var12, var13, var14));
		}

		//Layer 4


		for (int i = 0; i < 5; i++) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 161;
			var14 = var5 + this.rand.nextInt(16) + 8;
			//(new WorldGenLayer2Forest(false)).generate(this.worldObj, this.rand, var12, var13, var14);
		}

		if (this.rand.nextInt(150) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 161;
			var14 = var5 + this.rand.nextInt(16) + 8;
			//(l4Altars.get(this.rand.nextInt(3))).generate(this.worldObj, this.rand, var12, var13, var14);
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
			(shimmers).generate(this.worldObj, this.rand, new BlockPos(var12, var13, var14));
		}

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 161;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(shinegrass).generate(this.worldObj, this.rand, new BlockPos(var12, var13, var14));
		}

		if (this.rand.nextInt(10) == 0) {
			var12 = var4 + this.rand.nextInt(16) + 8;
			var13 = 161;
			var14 = var5 + this.rand.nextInt(16) + 8;
			(dreamglows).generate(this.worldObj, this.rand, new BlockPos(var12, var13, var14));
		}

		//MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(par1IChunkProvider, worldObj, rand, par2, par3, var11));
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
	public List<Biome.SpawnListEntry> getPossibleCreatures(EnumCreatureType creatureType, BlockPos pos)
	{
		Biome biome = this.worldObj.getBiomeProvider().getBiome(pos);

		return biome != null ? biome.getSpawnableList(creatureType) : null;
	}

	public int getLoadedChunkCount() {
		return 0;
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
}