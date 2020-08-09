package divinerpg.dimensions.arcana;

import java.util.List;
import java.util.Random;

import divinerpg.capabilities.arcana.Arcana;
import divinerpg.dimensions.arcana.mazegen.ArcanaMazeGenerator;
import divinerpg.dimensions.arcana.mazegen.Cell;
import divinerpg.dimensions.arcana.mazegen.MazeMapMemoryStorage;
import divinerpg.registry.StructureRegistry;
import divinerpg.structure.arcana.ArcanaStructureHandler;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.init.Blocks;
import net.minecraft.util.Rotation;
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
    private final Random rand;
    private final World world;
    private Biome[] biomesForGeneration;

    public ChunkGeneratorArcana(World world, long seed) {
        this.world = world;
        this.rand = new Random(seed);
    }

    @Override
    public Chunk generateChunk(int x, int z) {
        this.rand.setSeed((long) x * 341873128712L + (long) z * 132897987541L);
        this.biomesForGeneration = this.world.getBiomeProvider().getBiomes(this.biomesForGeneration, x * 16, z * 16, 16,
                16);

        ChunkPrimer primer = new ChunkPrimer();
        generateBedrockLayers(primer);

        Chunk chunk = new Chunk(this.world, primer, x, z);
        byte[] abyte = chunk.getBiomeArray();

        for (int i = 0; i < abyte.length; ++i) {
            abyte[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);
        }

        chunk.generateSkylightMap();
        return chunk;
    }

    private void generateBedrockLayers(ChunkPrimer primer) {
        for(int posX = 0; posX < 16; posX++) {
            for (int posZ = 0; posZ < 16; posZ++) {
                primer.setBlockState(posX, 7, posZ, Blocks.BEDROCK.getDefaultState());
                primer.setBlockState(posX, 20, posZ, Blocks.BEDROCK.getDefaultState());
            }
        }
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
        Biome biome = this.world.getBiome(pos.add(16, 0, 16));

        this.rand.setSeed(this.world.getSeed());
        long k = this.rand.nextLong() / 2L * 2L + 1L;
        long l = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long) chunkX * k + (long) chunkZ * l ^ this.world.getSeed());

        //this.rand is not used for overall maze generation which is specific to the region root instead of the specific chunk
        //However, it will be used to determine per-chunk things like the specific room variant picked, as well as randomize specific things within a chunk

        //Only generate maze if there's no blocks already there in order to avoid overwriting portal room floor
        //THIS CURRENTLY SEEMS TO BE BROKEN, still debugging it
        if(this.world.getBlockState(new BlockPos(x + 8, 8, z + 8)).getBlock() == Blocks.AIR) {
            long worldSeed = this.world.getSeed();
            Cell cell = ArcanaMazeGenerator.obtainMazePiece(chunkX, chunkZ, worldSeed);

            ArcanaStructureHandler toGenerate;
            boolean debug = false; //temporary, switch to true to generate debug rooms
            if(debug) {
                toGenerate = ArcanaRooms.getTestRoomByType(cell.getPieceType());
            }
            else {
                toGenerate = ArcanaRooms.getRandomStructureByType(this.rand, cell.getPieceType());
            }

            Rotation rotation = cell.getRotation();
            toGenerate.generateWithRotation(this.world, this.rand, new BlockPos(x + 8, 8, z + 8), rotation);
        }

        WorldEntitySpawner.performWorldGenSpawning(this.world, biome, x + 8, z + 8, 16, 16, this.rand);
    }
}