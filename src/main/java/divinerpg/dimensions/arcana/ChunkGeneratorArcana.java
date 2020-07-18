package divinerpg.dimensions.arcana;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import divinerpg.dimensions.arcana.components.DungeonCeiling;
import divinerpg.dimensions.arcana.components.DungeonComponent00;
import divinerpg.dimensions.arcana.components.DungeonComponent01;
import divinerpg.dimensions.arcana.components.DungeonComponent02;
import divinerpg.dimensions.arcana.components.DungeonComponent03;
import divinerpg.dimensions.arcana.components.DungeonComponent04;
import divinerpg.dimensions.arcana.components.DungeonComponent05;
import divinerpg.dimensions.arcana.components.DungeonComponent06;
import divinerpg.dimensions.arcana.components.DungeonComponent07;
import divinerpg.dimensions.arcana.components.DungeonComponent08;
import divinerpg.dimensions.arcana.components.DungeonComponent09;
import divinerpg.dimensions.arcana.components.DungeonComponent10;
import divinerpg.dimensions.arcana.components.DungeonComponent11;
import divinerpg.dimensions.arcana.components.DungeonComponent12;
import divinerpg.dimensions.arcana.components.DungeonComponent13;
import divinerpg.dimensions.arcana.components.DungeonComponent14;
import divinerpg.dimensions.arcana.components.DungeonComponent15;
import divinerpg.dimensions.arcana.components.DungeonComponent16;
import divinerpg.dimensions.arcana.components.DungeonComponent17;
import divinerpg.dimensions.arcana.components.DungeonComponent18;
import divinerpg.dimensions.arcana.components.DungeonComponent19;
import divinerpg.dimensions.arcana.components.DungeonComponent20;
import divinerpg.dimensions.arcana.components.DungeonComponentBase;
import divinerpg.dimensions.arcana.components.DungeonComponentDramix;
import divinerpg.dimensions.arcana.components.DungeonComponentParasecta;
import divinerpg.dimensions.arcana.mazegen.ArcanaMazeGenerator;
import divinerpg.dimensions.arcana.mazegen.Cell;
import divinerpg.dimensions.arcana.mazegen.MazeMapMemoryStorage;
import divinerpg.registry.StructureRegistry;
import divinerpg.structure.arcana.ArcanaStructureHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.tileentity.TileEntity;
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
    private ArrayList<DungeonComponentBase> Rooms = new ArrayList<DungeonComponentBase>();
    private DungeonComponentBase doubleHeightComponent = new DungeonComponent08();
    private DungeonCeiling Ceiling;
    private final Random rand;
    private final World world;
    private double[] buffer;
    private Biome[] biomesForGeneration;
    private int chunkX = 0;
    private int chunkZ = 0;
    private Map chunkTileEntityMap;

    public ChunkGeneratorArcana(World world, long seed) {
        this.world = world;
        this.rand = new Random(seed);

        Rooms.add(new DungeonComponent00());
        Rooms.add(new DungeonComponent01());
        Rooms.add(new DungeonComponent02());
        Rooms.add(new DungeonComponent03());
        Rooms.add(new DungeonComponent04());
        Rooms.add(new DungeonComponent05());
        Rooms.add(new DungeonComponent06());
        Rooms.add(new DungeonComponent07());
        //Component 8 is the 2-high one, skipping that
        Rooms.add(new DungeonComponent09());
        Rooms.add(new DungeonComponent10());
        Rooms.add(new DungeonComponent11());
        Rooms.add(new DungeonComponent12());
        Rooms.add(new DungeonComponent13());
        Rooms.add(new DungeonComponent14());
        Rooms.add(new DungeonComponent15());
        Rooms.add(new DungeonComponent16());
        Rooms.add(new DungeonComponent17());
        Rooms.add(new DungeonComponent18());
        Rooms.add(new DungeonComponent19());
        Rooms.add(new DungeonComponent20());
        Rooms.add(new DungeonComponentDramix());
        Rooms.add(new DungeonComponentParasecta());

        Ceiling = new DungeonCeiling();
        this.chunkTileEntityMap = new HashMap();
    }

    public Chunk generateChunk(int x, int z) {
        this.chunkX = x;
        this.chunkZ = z;
        //this.rand.setSeed((long) x * 341873128712L + (long) z * 132897987541L);
        this.biomesForGeneration = this.world.getBiomeProvider().getBiomes(this.biomesForGeneration, x * 16, z * 16, 16,
                16);



        Chunk chunk = new Chunk(this.world, new ChunkPrimer(), x, z);
        byte[] abyte = chunk.getBiomeArray();

        for (int i = 0; i < abyte.length; ++i) {
            abyte[i] = (byte) Biome.getIdForBiome(this.biomesForGeneration[i]);
        }

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
        this.rand.setSeed((long) chunkX * k + (long) chunkZ * l ^ this.world.getSeed());
        //this.rand is not used for overall maze generation which is specific to the region root instead of the specific chunk
        //however, it will be used to determine per-chunk things like the specific room variant picked, as well as randomize specific things within a chunk

        //MAZE GENERATION
        Cell[][] mazeMap;

        int regionRootX, regionRootZ;
        int mapCoordinateX, mapCoordinateZ;
        regionRootX = roundUp(chunkX, ArcanaMazeGenerator.MAZE_SIZE);
        regionRootZ = roundUp(chunkZ, ArcanaMazeGenerator.MAZE_SIZE);
        
        ChunkPos regionRoot = new ChunkPos(regionRootX, regionRootZ);
        Cell[][] storedGrid = MazeMapMemoryStorage.getMapForChunkPos(regionRoot);
        if(storedGrid == null) {
            mazeMap = ArcanaMazeGenerator.generate(regionRootX, regionRootZ, world.getSeed());
            MazeMapMemoryStorage.addMap(regionRoot, mazeMap);
        }
        else {
            mazeMap = storedGrid;
        }

        if(chunkX <= 0) {
            mapCoordinateX = Math.abs(chunkX % ArcanaMazeGenerator.MAZE_SIZE);
        }
        else {
            mapCoordinateX = ArcanaMazeGenerator.MAZE_SIZE - (chunkX % ArcanaMazeGenerator.MAZE_SIZE);
            if(mapCoordinateX == ArcanaMazeGenerator.MAZE_SIZE) { //bit messy but it works
                mapCoordinateX = 0;
            }
        }
        if(chunkZ <= 0) {
            mapCoordinateZ = Math.abs(chunkZ % ArcanaMazeGenerator.MAZE_SIZE);
        }
        else {
            mapCoordinateZ = ArcanaMazeGenerator.MAZE_SIZE - (chunkZ % ArcanaMazeGenerator.MAZE_SIZE);
            if(mapCoordinateZ == ArcanaMazeGenerator.MAZE_SIZE) {
                mapCoordinateZ = 0;
            }
        }

        Cell cell = mazeMap[mapCoordinateZ][mapCoordinateX]; //z has to come first because arrays are backwards from Cartesian plane logic
        ArcanaStructureHandler toGenerate = null;
        switch(cell.getPieceType()) {
            case CROSSROADS:
                toGenerate = StructureRegistry.CROSSROADS_TEST;
                break;
            case THREE_WAY:
                toGenerate = StructureRegistry.TPIECE_TEST;
                break;
            case CORNER:
                toGenerate = StructureRegistry.CORNER_TEST;
                break;
            case HALLWAY:
                toGenerate = StructureRegistry.HALLWAY_TEST;
                break;
            case DEAD_END:
                toGenerate = StructureRegistry.DEAD_END_TEST;
                break;
        }

        Rotation rotation = cell.getRotation();
        toGenerate.generateWithRotation(this.world, this.rand, new BlockPos(x + 8, 8, z + 8), rotation);

        //biome.decorate(this.world, this.rand, pos);

        List<BlockPos> chunkTileEntityPositions = (List<BlockPos>) chunkTileEntityMap.get(chunkpos);
        if (chunkTileEntityPositions != null) {
            Chunk chunk = this.world.getChunkFromChunkCoords(chunkX, chunkZ);
            for (int i = 0; i < chunkTileEntityPositions.size(); i++) {
                BlockPos chunkPosition = chunkTileEntityPositions.get(i);
                IBlockState state = chunk.getBlockState(chunkPosition.getX(), chunkPosition.getY(),
                        chunkPosition.getZ());
                TileEntity te = state.getBlock().createTileEntity(this.world, state);
                this.world.setTileEntity(chunkPosition.add(x, 0, z), te);
            }
            chunkTileEntityMap.remove(chunkpos);
        }

        WorldEntitySpawner.performWorldGenSpawning(this.world, biome, x + 8, z + 8, 16, 16, this.rand);
    }

    private static int roundUp(int numToRound, int multiple)
    {
        if (multiple == 0)
            return numToRound;

        int remainder = Math.abs(numToRound) % multiple;
        if (remainder == 0)
            return numToRound;

        if (numToRound < 0)
            return -1 * (Math.abs(numToRound) - remainder);
        else
            return numToRound + multiple - remainder;
    }
}