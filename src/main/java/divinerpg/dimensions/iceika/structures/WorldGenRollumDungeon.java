package divinerpg.dimensions.iceika.structures;

import divinerpg.objects.blocks.tile.entity.TileEntityFrostedChest;
import divinerpg.registry.BlockRegistry;
import divinerpg.registry.LootTableRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityLockableLoot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenRollumDungeon extends WorldGenerator {

    public boolean locationIsValidSpawn(World w, int x, int y, int z) {
        for (int i = 0; i < 10; i++) {
            for (int l = 0; l < 10; l++) {
                if (w.getBlockState(new BlockPos(x + i, y, z + l)) != BlockRegistry.frozenStone.getDefaultState()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean generate(World w, Random rand, BlockPos pos) {

        // todo too big
        int x = pos.getX() + 5, y = pos.getY(), z = pos.getZ() + 5;
        if (!locationIsValidSpawn(w, x, y, z)) return false;
        WorldGenAPI.addRectangle(6, 4, 5, w, x, y, z, BlockRegistry.icyBricks);
        WorldGenAPI.addRectangle(8, 8, 5, w, x + 5, y, z - 2, BlockRegistry.icyBricks);
        WorldGenAPI.addRectangle(8, 6, 3, w, x + 6, y + 1, z - 1, Blocks.AIR);
        WorldGenAPI.addRectangle(7, 2, 3, w, x, y + 1, z + 1, Blocks.AIR);
        WorldGenAPI.addRectangle(7, 2, 1, w, x, y, z + 1, BlockRegistry.icyStone);
        WorldGenAPI.addRectangle(7, 8, 1, w, x + 5, y, z - 2, BlockRegistry.icyStone);
        WorldGenAPI.addRectangle(1, 4, 4, w, x + 12, y, z - 1, BlockRegistry.icyBricks);
        WorldGenAPI.addRectangle(4, 4, 5, w, x + 13, y, z + 2, BlockRegistry.icyBricks);
        WorldGenAPI.addRectangle(4, 6, 5, w, x + 13, y, z + 3, BlockRegistry.icyBricks);
        WorldGenAPI.addRectangle(5, 2, 1, w, x + 12, y, z + 3, BlockRegistry.icyStone);
        WorldGenAPI.addRectangle(2, 5, 3, w, x + 14, y + 1, z + 3, Blocks.AIR);
        WorldGenAPI.addRectangle(2, 5, 1, w, x + 14, y, z + 3, BlockRegistry.icyStone);
        WorldGenAPI.addRectangle(1, 2, 3, w, x + 13, y + 1, z + 3, Blocks.AIR);
        WorldGenAPI.addRectangle(8, 4, 5, w, x + 16, y, z + 5, BlockRegistry.icyBricks);
        WorldGenAPI.addRectangle(7, 2, 3, w, x + 16, y + 1, z + 6, Blocks.AIR);
        WorldGenAPI.addRectangle(7, 2, 1, w, x + 16, y, z + 6, BlockRegistry.icyStone);
        WorldGenAPI.addRectangle(4, 3, 5, w, x + 20, y, z + 3, BlockRegistry.icyBricks);
        WorldGenAPI.addRectangle(8, 8, 5, w, x + 18, y, z - 5, BlockRegistry.icyBricks);
        WorldGenAPI.addRectangle(6, 6, 3, w, x + 19, y + 1, z - 4, Blocks.AIR);
        WorldGenAPI.addRectangle(6, 6, 1, w, x + 19, y, z - 4, BlockRegistry.icyStone);
        WorldGenAPI.addRectangle(2, 4, 3, w, x + 21, y + 1, z + 2, Blocks.AIR);
        WorldGenAPI.addRectangle(2, 4, 1, w, x + 21, y, z + 2, BlockRegistry.icyStone);
        WorldGenAPI.addBlock(w, x + 20, y, z - 1, BlockRegistry.rollumSpawner);
        WorldGenAPI.addBlock(w, x + 23, y, z - 1, BlockRegistry.rollumSpawner);
        WorldGenAPI.addBlock(w, x + 8, y, z + 1, BlockRegistry.rollumSpawner);
        w.setBlockState(new BlockPos(x + 24, y + 1, z - 4), BlockRegistry.frostedChest.getDefaultState(), 1);
        w.setBlockState(new BlockPos(x + 19, y + 1, z - 4), BlockRegistry.frostedChest.getDefaultState(), 1);
        WorldGenAPI.addRectangle(10, 2, 3, w, x - 5, y + 1, z + 1, Blocks.AIR);
        TileEntity tileentity1 = w.getTileEntity(new BlockPos(x + 24, y + 1, z - 4));
        TileEntity tileentity2 = w.getTileEntity(new BlockPos(x + 19, y + 1, z - 4));
        if (tileentity1 instanceof TileEntityLockableLoot) {
            ((TileEntityLockableLoot) tileentity1).setLootTable(LootTableRegistry.ICEIKA_CHEST_DUNGEON, rand.nextLong());
        }
        if (tileentity2 instanceof TileEntityFrostedChest) {
            ((TileEntityLockableLoot) tileentity2).setLootTable(LootTableRegistry.ICEIKA_CHEST_DUNGEON, rand.nextLong());
        }
        return true;
    }
}