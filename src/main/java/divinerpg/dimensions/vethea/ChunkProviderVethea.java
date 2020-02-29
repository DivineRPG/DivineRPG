package divinerpg.dimensions.vethea;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import divinerpg.dimensions.vethea.all.CeilingTexture;
import divinerpg.dimensions.vethea.all.WorldGenConeDown;
import divinerpg.dimensions.vethea.layer1.Crypt1;
import divinerpg.dimensions.vethea.layer1.Crypt2;
import divinerpg.dimensions.vethea.layer1.WorldGenLayer1Forest;
import divinerpg.dimensions.vethea.layer2.HiveNest;
import divinerpg.dimensions.vethea.layer2.Pyramid1;
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
import divinerpg.dimensions.vethea.village.WorldGenVillageIsland;
import divinerpg.registry.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.state.pattern.BlockStateMatcher;
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
	private final CeilingTexture ceilingTexture;
	private final WorldGenerator cracklespikes;
	private final WorldGenerator fernites;
	private final WorldGenerator bulbatobes;
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

	private final WorldGenMinable firecrystals = new WorldGenMinable(ModBlocks.fireCrystal.getDefaultState(), 70, BlockStateMatcher.forBlock(ModBlocks.dreamGrass));

	public ChunkProviderVethea(World par1World, long par2) {
		this.worldObj = par1World;
		this.rand = new Random(par2);
		
		this.crypts = new ArrayList(2);
		crypts.add(new Crypt1());
		crypts.add(new Crypt2());
		
		ceilingTexture = new CeilingTexture(Blocks.AIR);
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

		cracklespikes = new WorldGenVetheanFlower(ModBlocks.cracklespike);
		fernites = new WorldGenVetheanFlower(ModBlocks.fernite);
		bulbatobes = new WorldGenVetheanFlower(ModBlocks.bulbatobe);
		shinegrass = new WorldGenVetheanFlower(ModBlocks.shineGrass);
		shimmers = new WorldGenVetheanFlower(ModBlocks.shimmer);
		dreamglows = new WorldGenVetheanFlower(ModBlocks.dreamglow);
		greenGemTops = new WorldGenVetheanFlower(ModBlocks.greenGemtop);
		purpleGemTops = new WorldGenVetheanFlower(ModBlocks.purpleGemtop);
		//yellowGemTops = new WorldGenVetheanFlower(ModBlocks.yellowGemtop);
		yellowDulahs = new WorldGenVetheanFlower(ModBlocks.yellowDulah);
		greenDulahs = new WorldGenVetheanFlower(ModBlocks.greenDulah);
		
	}

	@Override
	public Chunk generateChunk(int chunkX, int chunkZ) {
		ChunkPrimer chunkPrimer = new ChunkPrimer();
		this.rand.setSeed((long)chunkX * 341873128712L + (long)chunkZ * 132897987541L);
		VetheanChunkBuilder builder = new VetheanChunkBuilder(worldObj);
		builder.rand.setSeed((long)chunkX * 341873128712L + (long)chunkZ * 132897987541L);

		// Setup biomes again for actual biome decoration
		this.biomesForGeneration = this.worldObj.getBiomeProvider().getBiomes(this.biomesForGeneration, chunkX * 16, chunkZ * 16, 16, 16);
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
		int var4 = par2 * 16 + 8;
		int var5 = par3 * 16 + 8;
		this.rand.setSeed(this.worldObj.getSeed());
		long var7 = this.rand.nextLong() / 2L * 2L + 1L;
		long var9 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed((long)par2 * var7 + (long)par3 * var9 ^ this.worldObj.getSeed());

		//layer1
		if(rand.nextInt(7) == 0) firecrystals.generate(worldObj, rand, new BlockPos(var4 + rand.nextInt(8), 17, var5 + rand.nextInt(8)));

		if(this.rand.nextInt(5)==0)greenGemTops.generate(worldObj, rand, new BlockPos(var4, 17, var5));
		if(this.rand.nextInt(5)==0)purpleGemTops.generate(worldObj, rand, new BlockPos(var4, 17, var5));
		if(this.rand.nextInt(5)==0)yellowDulahs.generate(worldObj, rand, new BlockPos(var4, 17, var5));
		if(this.rand.nextInt(5)==0)greenDulahs.generate(worldObj, rand, new BlockPos(var4, 17, var5));

		int height = 0;
		
		if (this.rand.nextInt(500) == 0) {
			height = 30;
			(hungerVillages).generate(this.worldObj, this.rand, new BlockPos(var4, height, var5));
		}

		for (int i = 0; i < 1; i++) {
			height = 17;
			l1Forest.generate(this.worldObj, this.rand, new BlockPos(var4, height, var5));
		}

		if (this.rand.nextInt(250) == 0) {
			height = 13;
			(crypts.get(this.rand.nextInt(crypts.size()))).generate(this.worldObj, this.rand, new BlockPos(var4, height, var5));
		}

		// Layer 2
		int l2GroundHeight = 65;
		if (this.rand.nextInt(250) == 0) {
			if(worldObj.getBlockState(new BlockPos(var4, l2GroundHeight, var5)).getBlock() == Blocks.AIR) {
				(pyramids.get(this.rand.nextInt(pyramids.size()))).generate(this.worldObj, this.rand, new BlockPos(var4, l2GroundHeight, var5));
			}

		}

		if(rand.nextInt(7) == 0) firecrystals.generate(worldObj, rand, new BlockPos(var4 + rand.nextInt(8), l2GroundHeight, var5 + rand.nextInt(8)));

		for (int i = 0; i < 3; i++) {
			l2Forest.generate(this.worldObj, this.rand, new BlockPos(var4, l2GroundHeight, var5));
		}

		if (this.rand.nextInt(10) == 0) {
			(fernites).generate(this.worldObj, this.rand, new BlockPos(var4, l2GroundHeight, var5));
		}

		if (this.rand.nextInt(10) == 0) {
			(dreamglows).generate(this.worldObj, this.rand, new BlockPos(var4, l2GroundHeight, var5));
		}

		if (this.rand.nextInt(10) == 0) {
			(shimmers).generate(this.worldObj, this.rand, new BlockPos(var4, l2GroundHeight, var5));
		}

		//Layer 3
		int l3GroundHeight = 113;
		if(rand.nextInt(7) == 0) firecrystals.generate(worldObj, rand, new BlockPos(var4 + rand.nextInt(8), l3GroundHeight, var5 + rand.nextInt(8)));

		for (int i = 0; i < 3; i++) {
			l1Forest.generate(this.worldObj, this.rand, new BlockPos(var4, l3GroundHeight, var5));
		}

		if (this.rand.nextInt(250) == 0) {
			(l3Altars.get(this.rand.nextInt(l3Altars.size()))).generate(this.worldObj, this.rand, new BlockPos(var4, l3GroundHeight, var5));
		}

		if (this.rand.nextInt(10) == 0) {
			(shinegrass).generate(this.worldObj, this.rand, new BlockPos(var4, l3GroundHeight, var5));
		}

		if (this.rand.nextInt(10) == 0) {
			(cracklespikes).generate(this.worldObj, this.rand, new BlockPos(var4, l3GroundHeight, var5));
		}

		if (this.rand.nextInt(10) == 0) {
			(bulbatobes).generate(this.worldObj, this.rand, new BlockPos(var4, l3GroundHeight, var5));
		}

		//Layer 4
		int l4GroundHeight = 161;
		if(rand.nextInt(7) == 0) firecrystals.generate(worldObj, rand, new BlockPos(var4 + rand.nextInt(8), l4GroundHeight, var5 + rand.nextInt(8)));

		for (int i = 0; i < 5; i++) {
			(new WorldGenLayer2Forest(false)).generate(this.worldObj, this.rand, new BlockPos(var4, l4GroundHeight, var5));
		}

		if (this.rand.nextInt(150) == 0) {
			(l4Altars).get(this.rand.nextInt(l4Altars.size())).generate(this.worldObj, this.rand, new BlockPos(var4, l4GroundHeight, var5));
		}
		
		if (this.rand.nextInt(10) == 0) {
			(shimmers).generate(this.worldObj, this.rand, new BlockPos(var4, l4GroundHeight, var5));
		}

		if (this.rand.nextInt(10) == 0) {
			(shinegrass).generate(this.worldObj, this.rand, new BlockPos(var4, l4GroundHeight, var5));
		}

		if (this.rand.nextInt(10) == 0) {
			(dreamglows).generate(this.worldObj, this.rand, new BlockPos(var4, l4GroundHeight, var5));
		}

		/*
		if (this.rand.nextInt(150) == 0) {
			var4 = var4 + this.rand.nextInt(16) + 8;
			height = 19 + 196;
			var5 = var5 + this.rand.nextInt(16) + 8;
			while(!this.worldObj.isAirBlock(new BlockPos(var4, height, var5))) {
				height++;
			}
			(new Layer4MassiveTree(false)).generate(this.worldObj, this.rand, var4, height, var5);
		}*/

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