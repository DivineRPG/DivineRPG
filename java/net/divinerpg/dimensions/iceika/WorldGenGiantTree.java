package net.divinerpg.dimensions.iceika;

import java.util.Random;

import net.divinerpg.api.worldgen.WorldGenAPI;
import net.divinerpg.utils.blocks.IceikaBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenGiantTree extends WorldGenerator {


    private void setBlockandMetadataIfChunkExists(World world, int x, int y, int z, int blockId, int metadata) {
        if (world.getChunkProvider().chunkExists(x >> 4, z >> 4)){
            this.generate(world, world.rand, x, y, z);
        }
    }

    public WorldGenGiantTree(boolean doNotify) {
        super(doNotify);
    }

    @Override
    public boolean generate(World world, Random rand, int x, int y, int z) {
    	final int height = 20 + rand.nextInt(10);
        final int leafStart = 1 + rand.nextInt(12);
        final int leafHeight = height - leafStart;
        final int l = 2 + rand.nextInt(9);
        /*int width = 6;
        int xChange = 2;
        
        for (int down = height; down >= leafStart; down-=4) {
        	WorldGenAPI.addRectangle(width, width, 1, world, x-xChange, y + down, z-xChange, IceikaBlocks.brittleLeaves);
        	width+=2;
        	xChange++;
        }
        WorldGenAPI.addRectangle(4, 4, leafHeight, world, x-1, y + leafStart, z-1, IceikaBlocks.brittleLeaves);
        WorldGenAPI.addRectangle(2, 2, height, world, x, y, z, IceikaBlocks.frozenWood);
        WorldGenAPI.addRectangle(2, 2, 1, world, x, y + height + 1, z, IceikaBlocks.brittleLeaves);*/

        if (y < 1 || y + height + 1 > 256) return false;

        for (int y1 = y; y1 <= y + 1 + height; y1++) {

            if (y1 < 0 && y1 >= 256) return false;

            int k1 = 1;

            if (y1 - y < leafStart) {
                k1 = 0;
            } else {
                k1 = l;
            }

            for (int x1 = x - k1; x1 <= x + k1; x1++) {
                for (int z1 = z - k1; z1 <= z + k1; z1++) {

                    if (!world.getChunkProvider().chunkExists(x1 >> 4, z1 >> 4)) return false;

                    final Block id = world.getBlock(x1, y1, z1);
                    
                    if (Block.getIdFromBlock(id) != 0 && !id.isLeaves(null, x1, y1, z1)) return false;
                }
            }
        }

        if (world.getBlock(x, y - 1, z) != IceikaBlocks.frozenGrass || y >= 256 - height - 1)
            return false;

        world.setBlock(x, y - 1, z, IceikaBlocks.frozenGrass);
        world.setBlock(x - 1, y - 1, z, IceikaBlocks.frozenGrass);
        world.setBlock(x, y - 1, z - 1, IceikaBlocks.frozenGrass);
        world.setBlock(x - 1, y - 1, z - 1, IceikaBlocks.frozenGrass);
        int l1 = rand.nextInt(2);
        int j2 = 1;
        boolean flag1 = false;

        for (int i3 = 0; i3 <= leafHeight; i3++) {
            final int k3 = y + height - i3;

            for (int i4 = x - l1; i4 <= x + l1; i4++) {
                final int k4 = i4 - x;

                for (int l4 = z - l1; l4 <= z + l1; l4++) {
                    final int i5 = l4 - z;

                    final int block = Block.getIdFromBlock(world.getBlock(i4, k3, l4));
                    final Block b = Block.getBlockById(block);
                    
                    if ((Math.abs(k4) != l1 || Math.abs(i5) != l1 || l1 <= 0)
                            && (b == null || b.canBeReplacedByLeaves(world, i4, k3, l4))) {
                    	world.setBlock(i4, k3, l4, IceikaBlocks.brittleLeaves);
                    	world.setBlock(i4 - 1, k3, l4, IceikaBlocks.brittleLeaves);
                    	world.setBlock(i4, k3, l4 - 1, IceikaBlocks.brittleLeaves);
                    	world.setBlock(i4 - 1, k3, l4 - 1, IceikaBlocks.brittleLeaves);
                    }
                }
            }

            if (l1 >= j2) {
                l1 = flag1 ? 1 : 0;
                flag1 = true;

                if (++j2 > l) {
                    j2 = l;
                }
            } else {
                l1++;
            }
        }

        final int j3 = rand.nextInt(3);

        for (int l3 = 0; l3 < height - j3; l3++) {
            final Block id = world.getBlock(x, y + l3, z);
            final int b = Block.getIdFromBlock(id);
            
            if (b == 0 || id.isLeaves(world, x, y + l3, z)) {
            	world.setBlock(x, y + l3, z, IceikaBlocks.frozenWood);
            	world.setBlock(x - 1, y + l3, z, IceikaBlocks.frozenWood);
            	world.setBlock(x, y + l3, z - 1, IceikaBlocks.frozenWood);
            	world.setBlock(x - 1, y + l3, z - 1, IceikaBlocks.frozenWood);
            }
        }
        return true;
    }
}