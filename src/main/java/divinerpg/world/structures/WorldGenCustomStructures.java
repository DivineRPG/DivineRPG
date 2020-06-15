package divinerpg.world.structures;

import divinerpg.config.Config;
import divinerpg.dimensions.iceika.structures.WorldGenArcherDungeon;
import divinerpg.dimensions.iceika.structures.WorldGenHouse1;
import divinerpg.dimensions.iceika.structures.WorldGenLibrary;
import divinerpg.dimensions.iceika.structures.WorldGenRollumDungeon;
import divinerpg.registry.DimensionRegistry;
import divinerpg.registry.LootTableRegistry;
import divinerpg.registry.BlockRegistry;
import divinerpg.utils.DRPGStructureHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by LiteWolf101 on Jan /27/2019
 */
public class WorldGenCustomStructures implements IWorldGenerator {
    //Iceika
    public static final DRPGStructureHandler ICEIKA_DUNGEON = new DRPGStructureHandler("iceika_dungeon",
            LootTableRegistry.ICEIKA_CHEST_DUNGEON);
    public static final DRPGStructureHandler ICEIKA_DUNGEON_ROLLUM = new DRPGStructureHandler("iceika_dungeon_rollum",
            LootTableRegistry.ICEIKA_CHEST_DUNGEON);
    public static final DRPGStructureHandler COALSTONE_LAMP_1 = new DRPGStructureHandler("coalstone_lamp_1");
    public static final DRPGStructureHandler COALSTONE_LAMP_2 = new DRPGStructureHandler("coalstone_lamp_2");
    public static final DRPGStructureHandler COALSTONE_LAMP_3 = new DRPGStructureHandler("coalstone_lamp_3");
    public static final DRPGStructureHandler WORKSHOP_HOUSE_1 = new DRPGStructureHandler("workshop_house_1",
            LootTableRegistry.ICEIKA_CHEST_HUT);
    public static final DRPGStructureHandler WORKSHOP_HOUSE_2 = new DRPGStructureHandler("workshop_house_2",
            LootTableRegistry.ICEIKA_CHEST_HUT);
    public static final DRPGStructureHandler WORKSHOP_HOUSE_3 = new DRPGStructureHandler("workshop_house_3",
            LootTableRegistry.ICEIKA_CHEST_HUT);
    public static final DRPGStructureHandler WORKSHOP_HOUSE_4 = new DRPGStructureHandler("workshop_house_4",
            LootTableRegistry.ICEIKA_CHEST_HUT);
    public static final DRPGStructureHandler WORKSHOP_HOUSE_5 = new DRPGStructureHandler("workshop_house_5",
            LootTableRegistry.ICEIKA_CHEST_HUT);
    public static final DRPGStructureHandler WORKSHOP_HOUSE_6 = new DRPGStructureHandler("workshop_house_6",
            LootTableRegistry.ICEIKA_CHEST_HUT);
    public static final DRPGStructureHandler WORKSHOP_LIBRARY = new DRPGStructureHandler("workshop_library",
            LootTableRegistry.ICEIKA_CHEST_HUT);

    public static final DRPGStructureHandler SUNSTORM_DUNGEON = new DRPGStructureHandler("twilight/sunstorm_dungeon");
    public static final DRPGStructureHandler TERMASECT_NEST = new DRPGStructureHandler("twilight/termasect_nest");
    public static final DRPGStructureHandler ETERNAL_ARCHER_DUNGEON = new DRPGStructureHandler("twilight/eternal_archer_dungeon");
    public static final DRPGStructureHandler EXPERIENCED_CORI_DUNGEON = new DRPGStructureHandler("twilight/experienced_cori_dungeon");

    private WorldGenRollumDungeon rollum = new WorldGenRollumDungeon();
    private WorldGenArcherDungeon archer = new WorldGenArcherDungeon();
    private WorldGenLibrary library = new WorldGenLibrary();
    private WorldGenHouse1 house1 = new WorldGenHouse1();
    
    //vanilla
    public static final DRPGStructureHandler HUT = new DRPGStructureHandler("hut");

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
            IChunkProvider chunkProvider) {

        if (world.provider.getDimensionType() == DimensionRegistry.iceikaDimension) {
    		generateStructure(rollum, world, random, chunkX, chunkZ, 50);
    		generateStructure(archer, world, random, chunkX, chunkZ, 50);
//            generateStructure(ICEIKA_DUNGEON, world, random, chunkX, chunkZ, 50);
//            generateStructure(ICEIKA_DUNGEON_ROLLUM, world, random, chunkX, chunkZ, 50);
            generateStructure(COALSTONE_LAMP_1, world, random, chunkX, chunkZ, 25, BlockRegistry.frozenGrass);
            generateStructure(COALSTONE_LAMP_2, world, random, chunkX, chunkZ, 25, BlockRegistry.frozenGrass);
            generateStructure(COALSTONE_LAMP_3, world, random, chunkX, chunkZ, 25, BlockRegistry.frozenGrass);
//            generateStructure(WORKSHOP_HOUSE_1, world, random, chunkX, chunkZ, 10, BlockRegistry.frozenGrass, 14, 14);
            generateStructure(house1, world, random, chunkX, chunkZ, 10, BlockRegistry.frozenGrass, 14, 14);
            generateStructure(WORKSHOP_HOUSE_2, world, random, chunkX, chunkZ, 10, BlockRegistry.frozenGrass, 13, 12);
            generateStructure(WORKSHOP_HOUSE_3, world, random, chunkX, chunkZ, 10, BlockRegistry.frozenGrass, 11, 11);
            generateStructure(WORKSHOP_HOUSE_4, world, random, chunkX, chunkZ, 10, BlockRegistry.frozenGrass, 10, 10);
            generateStructure(WORKSHOP_HOUSE_5, world, random, chunkX, chunkZ, 10, BlockRegistry.frozenGrass, 12, 8);
            generateStructure(WORKSHOP_HOUSE_6, world, random, chunkX, chunkZ, 10, BlockRegistry.frozenGrass, 10, 9);
//            generateStructure(WORKSHOP_LIBRARY, world, random, chunkX, chunkZ, 10, BlockRegistry.frozenGrass, 19, 11);
            generateStructure(library, world, random, chunkX, chunkZ, 10, BlockRegistry.frozenGrass, 19, 11);
        }
        	if (world.provider.getDimensionType() == DimensionType.OVERWORLD) {
            Biome biome = world.getChunkFromChunkCoords(chunkX, chunkZ)
                    .getBiome(new BlockPos(chunkX * 16, 0, chunkZ * 16), world.getBiomeProvider());
            if (Config.generateHuts && world.getWorldType() != WorldType.FLAT
                    && (BiomeDictionary.hasType(biome, BiomeDictionary.Type.PLAINS)
                            || BiomeDictionary.hasType(biome, BiomeDictionary.Type.SAVANNA))) {
                generateStructure(HUT, world, random, chunkX, chunkZ, 20, Blocks.GRASS, 11, 11);
            }
        }
        	if(world.provider.getDimensionType() == DimensionRegistry.edenDimension) {
        		generateStructure(SUNSTORM_DUNGEON, world, random, chunkX, chunkZ, 5, BlockRegistry.edenGrass, 10, 10);
        	}
        	if(world.provider.getDimensionType() == DimensionRegistry.wildwoodDimension) {
        		generateStructure(TERMASECT_NEST, world, random, chunkX, chunkZ, 5, BlockRegistry.wildwoodGrass, 10, 10);
        	}
        	if(world.provider.getDimensionType() == DimensionRegistry.apalachiaDimension) {
        		generateStructure(ETERNAL_ARCHER_DUNGEON, world, random, chunkX, chunkZ, 5, BlockRegistry.apalachiaGrass, 10, 10);
        	}
        	if(world.provider.getDimensionType() == DimensionRegistry.skythernDimension) {
        		generateStructure(EXPERIENCED_CORI_DUNGEON, world, random, chunkX, chunkZ, 8, BlockRegistry.skythernGrass, 10, 10);
        	}
    }

    /** Generates a structure between y=13 and y=56 */
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

    /** Generates a structure only on the specified topblock */
    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ,
            int chance, Block topBlock) {
        int x = chunkX * 16 + 1;
        int z = chunkZ * 16 + 1;
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x, y, z);
        if (random.nextInt(chance) == 0) {
            generator.generate(world, random, pos);
        }
    }

    /** Generates a structure with the specified blocks in a given area */
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

    private static int calculateGenerationHeight(World world, int x, int z, Block topBlock) {
        int y = world.getHeight();
        boolean foundGround = false;
        while (!foundGround && y-- >= 15) {
            Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();
            foundGround = block == topBlock;
        }
        return y;
    }

    public boolean locationIsValidSpawn(World world, int x, int y, int z, int distX, int distZ, Block topBlock) {
        for (int i = 0; i < distX; i++) {
            for (int l = 0; l < distZ; l++) {
                if (world.getBlockState(new BlockPos(x + i, y, z + l)).getBlock() != topBlock) {
                    return false;
                }
            }
        }
        return true;
    }
}