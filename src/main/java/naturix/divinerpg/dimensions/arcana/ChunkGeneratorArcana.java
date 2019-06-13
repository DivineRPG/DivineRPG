package naturix.divinerpg.dimensions.arcana;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import naturix.divinerpg.dimensions.arcana.components.DungeonCeiling;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent00;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent01;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent10;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent11;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent12;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent13;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent14;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent15;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent16;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent17;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent18;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent19;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent02;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent20;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent03;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent04;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent05;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent06;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent07;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent08;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponent09;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponentBase;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponentDramix;
import naturix.divinerpg.dimensions.arcana.components.DungeonComponentParasecta;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEntitySpawner;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkPrimer;
import net.minecraft.world.gen.IChunkGenerator;

public class ChunkGeneratorArcana implements IChunkGenerator {
    private ArrayList Rooms;
    private ArrayList BossRooms;
    private DungeonCeiling Ceiling;
    private final Random rand;
    private final World world;
    private double[] buffer;
    private Biome[] biomesForGeneration;
    private int chunkX = 0;
    private int chunkZ = 0;

    public ChunkGeneratorArcana(World world, long seed) {
        this.world = world;
        this.rand = new Random(seed);
        Rooms = new ArrayList(21);
        BossRooms = new ArrayList(2);

        Rooms.add(new DungeonComponent00());
        Rooms.add(new DungeonComponent01());
        Rooms.add(new DungeonComponent02());
        Rooms.add(new DungeonComponent03());
        Rooms.add(new DungeonComponent04());
        Rooms.add(new DungeonComponent05());
        Rooms.add(new DungeonComponent06());
        Rooms.add(new DungeonComponent07());
        Rooms.add(new DungeonComponent09());
        Rooms.add(new DungeonComponent10());
        Rooms.add(new DungeonComponent11());
        Rooms.add(new DungeonComponent12());
        Rooms.add(new DungeonComponent13());
        Rooms.add(new DungeonComponent14());
        Rooms.add(new DungeonComponent15());
        Rooms.add(new DungeonComponent16());
        Rooms.add(new DungeonComponent17());
        Rooms.add(new DungeonComponent20());
        Rooms.add(new DungeonComponent18());
        Rooms.add(new DungeonComponent19());
        Rooms.add(new DungeonComponent08());
        BossRooms.add(new DungeonComponentParasecta());
        BossRooms.add(new DungeonComponentDramix());
        Ceiling = new DungeonCeiling();
    }

    public Chunk generateChunk(int x, int z) {
        this.chunkX = x;
        this.chunkZ = z;
        this.rand.setSeed((long) x * 341873128712L + (long) z * 132897987541L);
        ChunkPrimer chunkprimer = new ChunkPrimer();
        this.biomesForGeneration = this.world.getBiomeProvider().getBiomes(this.biomesForGeneration, x * 16, z * 16, 16,
                16);
        Chunk chunk = new Chunk(this.world, chunkprimer, x, z);
        byte[] abyte = chunk.getBiomeArray();

        for (int i = 0; i < abyte.length; ++i) {
            abyte[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);
        }

        for (int i = 4; i > 0; i--) {
            DungeonComponentBase room = (DungeonComponentBase) (Rooms.get(rand.nextInt(21)));
            if (room instanceof DungeonComponent08 && i >= 3)
                room = (DungeonComponentBase) (Rooms.get(this.rand.nextInt(10) + 10));

            room.generate(chunk, rand, 0, i * 8, 0);
        }

        Ceiling.generate(chunk, rand, 0, 40, 0);

        chunk.generateSkylightMap();
        return chunk;
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