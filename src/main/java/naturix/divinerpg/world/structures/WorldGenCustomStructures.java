package naturix.divinerpg.world.structures;

import naturix.divinerpg.objects.blocks.tile.block.TileEntityIceikaChest;
import naturix.divinerpg.registry.ModBlocks;
import naturix.divinerpg.registry.ModDimensions;
import naturix.divinerpg.utils.DRPGLootTables;
import naturix.divinerpg.utils.DRPGStructureHandler;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * Created by LiteWolf101 on Jan
 * /27/2019
 */
public class WorldGenCustomStructures implements IWorldGenerator {
    public static final DRPGStructureHandler ICEIKA_DUNGEON = new DRPGStructureHandler("iceika_dungeon");
    public static final DRPGStructureHandler ICEIKA_DUNGEON_ROLLUM = new DRPGStructureHandler("iceika_dungeon_rollum");
    public static final DRPGStructureHandler COALSTONE_LAMP_1 = new DRPGStructureHandler("coalstone_lamp_1");
    public static final DRPGStructureHandler COALSTONE_LAMP_2 = new DRPGStructureHandler("coalstone_lamp_2");
    public static final DRPGStructureHandler COALSTONE_LAMP_3 = new DRPGStructureHandler("coalstone_lamp_3");

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimensionType() == ModDimensions.iceikaDimension) {
            generateIceikaDungeon(ICEIKA_DUNGEON, world, random, chunkX, chunkZ, 50);
            generateIceikaRollumDungeon(ICEIKA_DUNGEON_ROLLUM, world, random, chunkX, chunkZ, 50);
            generateStructure(COALSTONE_LAMP_1, world, random, chunkX, chunkZ, 25, ModBlocks.grassIceika);
            generateStructure(COALSTONE_LAMP_2, world, random, chunkX, chunkZ, 25, ModBlocks.grassIceika);
            generateStructure(COALSTONE_LAMP_3, world, random, chunkX, chunkZ, 25, ModBlocks.grassIceika);
        }
    }

    /**Generates a structure between y=13 and y=56 */
    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance) {
        int x = chunkX * 16;
        int z = chunkZ * 16;
        int y = random.nextInt(43) + 13;
        BlockPos pos = new BlockPos(x, y, z);
        if (random.nextInt(chance) == 0) {
            generator.generate(world, random, pos);
        }
    }

    /**Generates a structure only on the specified topblock*/
    private void generateStructure(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance, Block topBlock){
        int x = chunkX * 16;
        int z = chunkZ * 16;
        int y = calculateGenerationHeight(world, x, z, topBlock);
        BlockPos pos = new BlockPos(x,y,z);
        if(random.nextInt(chance) == 0){
            generator.generate(world, random, pos);
        }
    }

    /**Generates an Iceika Dungeon with the specified loot*/
    private void generateIceikaDungeon(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance) {
        int x = chunkX * 16;
        int z = chunkZ * 16;
        int y = random.nextInt(43) + 13;
        BlockPos pos = new BlockPos(x, y, z);
        if (random.nextInt(chance) == 0) {
            generator.generate(world, random, pos);
            generateIceikaLoot(world, pos.add(18, 1, 1), random);
            generateIceikaLoot(world, pos.add(23, 1, 1), random);
        }
    }

    /**Generates an Iceika Rollum Dungeon with the specified loot*/
    private void generateIceikaRollumDungeon(WorldGenerator generator, World world, Random random, int chunkX, int chunkZ, int chance) {
        int x = chunkX * 16;
        int z = chunkZ * 16;
        int y = random.nextInt(43) + 13;
        BlockPos pos = new BlockPos(x, y, z);
        if (random.nextInt(chance) == 0) {
            generator.generate(world, random, pos);
            generateIceikaLoot(world, pos.add(1, 1, 9), random);
            generateIceikaLoot(world, pos.add(23, 1, 10), random);
            generateIceikaLoot(world, pos.add(24, 1, 10), random);
            generateIceikaLoot(world, pos.add(28, 1, 11), random);
            generateIceikaLoot(world, pos.add(29, 1, 11), random);
            generateIceikaLoot(world, pos.add(26, 1, 17), random);
            generateIceikaLoot(world, pos.add(26, 1, 18), random);
        }
    }

    private void generateIceikaLoot(World world, BlockPos pos, Random random) {
        TileEntity tileEntity = world.getTileEntity(pos);

        if (tileEntity instanceof TileEntityIceikaChest) {
            ((TileEntityIceikaChest)tileEntity).setLootTable(DRPGLootTables.ICEIKA_CHEST, random.nextLong());
        }
    }

    private static int calculateGenerationHeight(World world, int x, int z, Block topBlock){
        int y = world.getHeight();
        boolean foundGround = false;
        while(!foundGround && y-- >= 15){
            Block block = world.getBlockState(new BlockPos(x,y,z)).getBlock();
            foundGround = block == topBlock;
        }
        return y;
    }
}