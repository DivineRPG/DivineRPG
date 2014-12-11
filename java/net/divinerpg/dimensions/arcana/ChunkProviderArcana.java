package net.divinerpg.dimensions.arcana;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.divinerpg.dimensions.arcana.components.DungeonCeiling;
import net.divinerpg.dimensions.arcana.components.DungeonComponenet18;
import net.divinerpg.dimensions.arcana.components.DungeonComponenet19;
import net.divinerpg.dimensions.arcana.components.DungeonComponent;
import net.divinerpg.dimensions.arcana.components.DungeonComponent1;
import net.divinerpg.dimensions.arcana.components.DungeonComponent10;
import net.divinerpg.dimensions.arcana.components.DungeonComponent11;
import net.divinerpg.dimensions.arcana.components.DungeonComponent12;
import net.divinerpg.dimensions.arcana.components.DungeonComponent13;
import net.divinerpg.dimensions.arcana.components.DungeonComponent14;
import net.divinerpg.dimensions.arcana.components.DungeonComponent15;
import net.divinerpg.dimensions.arcana.components.DungeonComponent16;
import net.divinerpg.dimensions.arcana.components.DungeonComponent17;
import net.divinerpg.dimensions.arcana.components.DungeonComponent2;
import net.divinerpg.dimensions.arcana.components.DungeonComponent22;
import net.divinerpg.dimensions.arcana.components.DungeonComponent3;
import net.divinerpg.dimensions.arcana.components.DungeonComponent4;
import net.divinerpg.dimensions.arcana.components.DungeonComponent5;
import net.divinerpg.dimensions.arcana.components.DungeonComponent6;
import net.divinerpg.dimensions.arcana.components.DungeonComponent7;
import net.divinerpg.dimensions.arcana.components.DungeonComponent8;
import net.divinerpg.dimensions.arcana.components.DungeonComponent9;
import net.divinerpg.dimensions.arcana.components.DungeonComponentBase;
import net.divinerpg.dimensions.arcana.components.DungeonComponentDramix;
import net.divinerpg.dimensions.arcana.components.DungeonComponentParasecta;
import net.minecraft.block.Block;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class ChunkProviderArcana implements IChunkProvider{

	private ArrayList<Object> Rooms;
	private ArrayList<Object> BossRooms;
	private DungeonCeiling Ceiling;
	private World worldObj;
	private Random random;
	private final Block[] cachedBlockIDs = new Block[256];
	private final byte[] cachedBlockMetadata = new byte[256];


	public ChunkProviderArcana(World world, long seed){

		worldObj = world;
		random = new Random(seed);

		Rooms = new ArrayList<Object>(21);
		BossRooms = new ArrayList<Object>(2);
		
		Rooms.add(new DungeonComponent());
		Rooms.add(new DungeonComponent1());
		Rooms.add(new DungeonComponent2());
		Rooms.add(new DungeonComponent3());
		Rooms.add(new DungeonComponent4());
		Rooms.add(new DungeonComponent5());
		Rooms.add(new DungeonComponent6());
		Rooms.add(new DungeonComponent7());
		Rooms.add(new DungeonComponent9());
		Rooms.add(new DungeonComponent10());
		Rooms.add(new DungeonComponent11());
		Rooms.add(new DungeonComponent12());
		Rooms.add(new DungeonComponent13());
		Rooms.add(new DungeonComponent14());
		Rooms.add(new DungeonComponent15());
		Rooms.add(new DungeonComponent16());
		Rooms.add(new DungeonComponent17());
		Rooms.add(new DungeonComponent22());
		Rooms.add(new DungeonComponenet18());
		Rooms.add(new DungeonComponenet19());
		Rooms.add(new DungeonComponent8());
		BossRooms.add(new DungeonComponentParasecta());
		BossRooms.add(new DungeonComponentDramix());
		Ceiling = new DungeonCeiling();

	}

	@Override
	public boolean chunkExists(int i, int j) {	
		return false;
	}

	@Override
	public Chunk provideChunk(int par1, int par2) {
		ArcanaChunk c = new ArcanaChunk();
        int l;
        
        int roomToGenerate;
        
        for (int i = 1; i < 5; i++) {
			roomToGenerate = random.nextInt(21);
			DungeonComponentBase room = (DungeonComponentBase)(Rooms.get(roomToGenerate));
			
			if(room instanceof DungeonComponent8 && i < 4) room = (DungeonComponentBase)(Rooms.get(this.random.nextInt(10)+10));

			room.generate(c, random, 0, i * 8, 0);			
		}
        
		Ceiling.generate(c, random, 0, 40, 0);
        
		Chunk chunk = new Chunk(this.worldObj, c.getChunkData(), par1, par2);
        chunk.generateSkylightMap();
        BiomeGenBase[] abiomegenbase = this.worldObj.getWorldChunkManager().loadBlockGeneratorData((BiomeGenBase[])null, par1 * 16, par2 * 16, 16, 16);
        byte[] abyte = chunk.getBiomeArray();

        for (l = 0; l < abyte.length; ++l)
        {
            abyte[l] = (byte)abiomegenbase[l].biomeID;
        }

        chunk.generateSkylightMap();
        return chunk;
	}

	@Override
	public Chunk loadChunk(int i, int j) {
		return this.provideChunk(i, j);
	}

	@Override
	public void populate(IChunkProvider chunkProvider, int chunkX, int chunkY) {
		int x = chunkX * 16;
		int y = chunkY * 16;
		BiomeGenBase biome = this.worldObj.getBiomeGenForCoords(x + 16, y + 16);
		boolean flag = false;
		this.random.setSeed(this.worldObj.getSeed());
		long var8 = this.random.nextLong() / 2L * 2L + 1L;
		long var10 = this.random.nextLong() / 2L * 2L + 1L;
		this.random.setSeed(chunkX * var8 + chunkY * var10 ^ this.worldObj.getSeed());
		int roomToGenerate;
		int boosRoomFlag;

		Random rand = random;
		Chunk chunk = this.worldObj.getChunkFromChunkCoords(chunkX, chunkY);

			roomToGenerate = rand.nextInt(2);
			boosRoomFlag = rand.nextInt(5);

			if(this.random.nextInt(50) == 0){
				((WorldGenerator)(BossRooms.get(roomToGenerate))).generate(this.worldObj, rand, x, 3 * 8, y);
				this.random.setSeed(chunkX * var8 + chunkY * var10 ^ this.worldObj.getSeed());
			}

	}

	@Override
	public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
		return true;
	}

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
		return "Arcana";
	}

	@Override
	public List getPossibleCreatures(EnumCreatureType enumcreaturetype, int i, int j, int k) {
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(i, k);
		return biomegenbase == null ? null : biomegenbase.getSpawnableList(enumcreaturetype);
	}

	@Override
	public int getLoadedChunkCount() {
		return 0;
	}

	@Override
	public void recreateStructures(int i, int j) {}

	@Override
	public void saveExtraData() { }

	@Override
	public ChunkPosition func_147416_a(World var1, String var2, int var3, int var4, int var5) {
		return null;
	}
}