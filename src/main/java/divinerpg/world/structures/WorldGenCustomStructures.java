package divinerpg.world.structures;

import divinerpg.config.Config;
import divinerpg.dimensions.iceika.structures.IceikaDungeon;
import divinerpg.dimensions.iceika.structures.WorldGenHouse1;
import divinerpg.dimensions.iceika.structures.WorldGenLibrary;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.DimensionRegistry;
import divinerpg.registry.LootTableRegistry;
import divinerpg.utils.DRPGStructureHandler;
import divinerpg.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.StreamSupport;

/**
 * Created by LiteWolf101 on Jan /27/2019
 */
public class WorldGenCustomStructures implements IWorldGenerator {
    //vanilla
    public final DRPGStructureHandler HUT = new DRPGStructureHandler("overworld/livestock_merchant_hut");

    //Iceika
//    public final DRPGStructureHandler ICEIKA_DUNGEON = new DRPGStructureHandler("iceika_dungeon",
//            LootTableRegistry.ICEIKA_CHEST_DUNGEON);
//    public final DRPGStructureHandler ICEIKA_DUNGEON_ROLLUM = new DRPGStructureHandler("iceika_dungeon_rollum",
//            LootTableRegistry.ICEIKA_CHEST_DUNGEON);

    public final List<DRPGStructureHandler> Lamps = new ArrayList<DRPGStructureHandler>() {{
        add(new DRPGStructureHandler("iceika/lamps/coalstone_lamp_1"));
        add(new DRPGStructureHandler("iceika/lamps/coalstone_lamp_2"));
        add(new DRPGStructureHandler("iceika/lamps/coalstone_lamp_3"));
    }};

    public final List<DRPGStructureHandler> Houses = new ArrayList<DRPGStructureHandler>() {{
        add(new DRPGStructureHandler("iceika/houses/workshop_house_1", LootTableRegistry.ICEIKA_CHEST_HUT));
        add(new DRPGStructureHandler("iceika/houses/workshop_house_2", LootTableRegistry.ICEIKA_CHEST_HUT));
        add(new DRPGStructureHandler("iceika/houses/workshop_house_3", LootTableRegistry.ICEIKA_CHEST_HUT));
        add(new DRPGStructureHandler("iceika/houses/workshop_house_4", LootTableRegistry.ICEIKA_CHEST_HUT));
        add(new DRPGStructureHandler("iceika/houses/workshop_house_5", LootTableRegistry.ICEIKA_CHEST_HUT));
        add(new DRPGStructureHandler("iceika/houses/workshop_house_6", LootTableRegistry.ICEIKA_CHEST_HUT));

        add(new DRPGStructureHandler("iceika/workshop_library", LootTableRegistry.ICEIKA_CHEST_HUT));
    }};

    public final DRPGStructureHandler SUNSTORM_DUNGEON = new DRPGStructureHandler("twilight/sunstorm_dungeon");
    public final DRPGStructureHandler TERMASECT_NEST = new DRPGStructureHandler("twilight/termasect_nest");
    public final DRPGStructureHandler ETERNAL_ARCHER_DUNGEON = new DRPGStructureHandler("twilight/eternal_archer_dungeon");
    public final DRPGStructureHandler EXPERIENCED_CORI_DUNGEON = new DRPGStructureHandler("twilight/experienced_cori_dungeon");

    private WorldGenerator rollum = new IceikaDungeon(BlockRegistry.rollumSpawner);
    private WorldGenerator archer = new IceikaDungeon(BlockRegistry.frostArcherSpawner);

    private WorldGenLibrary library = new WorldGenLibrary();
    private WorldGenHouse1 house1 = new WorldGenHouse1();


    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
                         IChunkProvider chunkProvider) {

        if (world.provider.getDimensionType() == DimensionRegistry.iceikaDimension) {

            final BlockPos chunkStart = new ChunkPos(chunkX, chunkZ).getBlock(0, 0, 0);
            generateStructure(rollum, world, random, chunkX, chunkZ, 50);
            generateStructure(archer, world, random, chunkX, chunkZ, 50);

            Lamps.stream()
                    .filter(x -> random.nextInt(25) == 0)
                    .forEach(x -> {
                        // causes light update, more offset
                        BlockPos pos = randomPos(world, chunkStart, x.getSize(world), 8);
                        int size = 3;

                        // check the platform
                        boolean canPlace = StreamSupport.stream(BlockPos.getAllInBox(pos, pos.add(size, 0, size)).spliterator(), false)
                                .allMatch(p -> world.getBlockState(p).getBlock() == BlockRegistry.frozenGrass);

                        if (!canPlace)
                            return;

                        x.generateStructure(world, pos);
                    });

            Houses.stream()
                    .filter(x -> random.nextInt(10) == 0)
                    .forEach(x -> {
                        BlockPos size = x.getSize(world);
                        BlockPos pos = randomPos(world, chunkStart, size, 1);

                        // check the platform
                        boolean canPlace = StreamSupport.stream(BlockPos.getAllInBox(pos, pos.add(size.getX(), 0, size.getZ())).spliterator(), false)
                                .allMatch(p -> world.getBlockState(p).getBlock() == BlockRegistry.frozenGrass);

                        if (!canPlace)
                            return;

                        x.generateStructure(world, pos);
                    });

            generateStructure(house1, world, random, chunkX, chunkZ, 10, BlockRegistry.frozenGrass, 14, 14);
            generateStructure(library, world, random, chunkX, chunkZ, 10, BlockRegistry.frozenGrass, 19, 11);
        }
        if (world.provider.getDimensionType() == DimensionType.OVERWORLD) {
            Biome biome = world.getChunkFromChunkCoords(chunkX, chunkZ)
                    .getBiome(new BlockPos(chunkX * 16, 0, chunkZ * 16), world.getBiomeProvider());
            if (Config.generateHuts && world.getWorldType() != WorldType.FLAT
                    && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS)
                    || BiomeDictionary.hasType(biome, BiomeDictionary.Type.SAVANNA))) {
                generateStructure(HUT, world, random, chunkX, chunkZ, 70, Blocks.GRASS, 2, 2);
            }
        }
        if (world.provider.getDimensionType() == DimensionRegistry.edenDimension) {
            generateStructure(SUNSTORM_DUNGEON, world, random, chunkX, chunkZ, 28, BlockRegistry.edenGrass, 10, 10);
        }
        if (world.provider.getDimensionType() == DimensionRegistry.wildwoodDimension) {
            generateStructure(TERMASECT_NEST, world, random, chunkX, chunkZ, 28, BlockRegistry.wildwoodGrass, 10, 10);
        }
        if (world.provider.getDimensionType() == DimensionRegistry.apalachiaDimension) {
            generateStructure(ETERNAL_ARCHER_DUNGEON, world, random, chunkX, chunkZ, 28, BlockRegistry.apalachiaGrass, 10, 10);
        }
        if (world.provider.getDimensionType() == DimensionRegistry.skythernDimension) {
            generateStructure(EXPERIENCED_CORI_DUNGEON, world, random, chunkX, chunkZ, 28, BlockRegistry.skythernGrass, 10, 10);
        }
    }

    /**
     * Generates a structure between y=13 and y=56
     */
    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ,
                                   int chance) {
        int x = chunkX * 16 + 1;
        int z = chunkZ * 16 + 1;
        int y = random.nextInt(43) + 13;
        BlockPos pos = new BlockPos(x, y, z);
        if (random.nextInt(chance) == 0) {
            generator.generate(world, random, pos);
        }
    }

    /**
     * Generates a structure with the specified blocks in a given area
     */
    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ,
                                   int chance, Block topBlock, int xCheckDist, int zCheckDist) {
        int x = chunkX * 16 + 1;
        int z = chunkZ * 16 + 1;
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x, y, z);
        if (random.nextInt(chance) == 0) {
            if (locationIsValidSpawn(world, x, y, z, xCheckDist, zCheckDist, topBlock)) {
                generator.generate(world, random, pos);
            }
        }
    }

    private int calculateGenerationHeight(World world, int x, int z, Block topBlock) {
        int y = world.getHeight();
        boolean foundGround = false;
        while (!foundGround && y-- >= 15) {
            Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
            foundGround = block == topBlock;
        }
        return y;
    }

    public boolean locationIsValidSpawn(World world, int x, int y, int z, int distX, int distZ, Block topBlock) {
        /*
            Check if block (3, 3) away from the selected generation point is equivalent to the grass block.
            This is to ensure flatness in some cases (e.g. to avoid spawning it in a steep hillside).
            However, the checked block is close enough to ensure that generation of the structure is not relegated to entirely flat areas which are probably harder to find.
            Will need tweaking later
         */
        if(world.getBlockState(new BlockPos(x, y, z)).getBlock() == topBlock) {
            if(world.getBlockState(new BlockPos(x + 3, y, z + 3)).getBlock() == topBlock) {
                return true;
            }
        }
        return false;
    }

    private BlockPos randomPos(World world, BlockPos chunkStart, BlockPos size, int minOffset) {
        int x = chunkStart.getX() + minOffset;
        int z = chunkStart.getZ() + minOffset;

        int xOffset = 32 - size.getX() - (minOffset * 2);
        int zOffset = 32 - size.getZ() - (minOffset * 2);

        if (xOffset > 1) {
            x += world.rand.nextInt(xOffset);
        }

        if (zOffset > 1) {
            z += world.rand.nextInt(zOffset);
        }

        int y = Utils.getSurfaceBlockY(world, chunkStart.getX(), chunkStart.getZ(), BlockRegistry.frozenGrass);

        return new BlockPos(x, y, z);
    }
}