package net.divinerpg.dimensions.vethea.layer1;

import java.util.Random;

import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLayer1Forest extends WorldGenerator
{
    public WorldGenLayer1Forest(boolean par1)
    {
        super(par1);
    }

    public boolean generate(World world, Random par2Random, int x, int y, int z)
    {
        int var6 = par2Random.nextInt(3) + 5;
        boolean var7 = true;

        if (y >= 1 && y + var6 + 1 <= 256)
        {
            int var8;
            int var10;
            int var11;
            int var12;

            for (var8 = y; var8 <= y + 1 + var6; ++var8)
            {
                byte var9 = 0;

                if (var8 == y)
                {
                    var9 = 0;
                }

                if (var8 >= y + 1 + var6 - 2)
                {
                    var9 = 1;
                }

                for (var10 = x - var9; var10 <= x + var9 && var7; ++var10)
                {
                    for (var11 = z - var9; var11 <= z + var9 && var7; ++var11)
                    {
                        if (var8 >= 0 && var8 < 256)
                        {
                            Block b = world.getBlock(var10, var8, var11);

                            Block block = b;

                            if (b != null && (block != null && !block.isLeaves(world, var10,  var8, var11)))
                            {
                                var7 = false;
                            }
                        }
                        else
                        {
                            var7 = false;
                        }
                    }
                }
            }

                Block b = world.getBlock(x, y - 1, z);
                if ((b == VetheaBlocks.dreamGrass || b == VetheaBlocks.dreamDirt) && y < 256 - var6 - 1)
                {
                    world.setBlock(x, y - 1, z, VetheaBlocks.dreamDirt);
                    int var16;

                    for (var16 = y - 3 + var6; var16 <= y + var6; ++var16)
                    {
                        var10 = var16 - (y + var6);
                        var11 = 1 - var10 / 2;

                        for (var12 = x - var11; var12 <= x + var11; ++var12)
                        {
                            int var13 = var12 - x;

                            for (int var14 = z - var11; var14 <= z + var11; ++var14)
                            {
                                int var15 = var14 - z;

                                Block block = world.getBlock(var12, var16, var14);

                                if ((Math.abs(var13) != var11 || Math.abs(var15) != var11 || par2Random.nextInt(2) != 0 && var10 != 0) && (block == null || block.canBeReplacedByLeaves(world, var12, var16, var14))) {
                                    world.setBlock(var12, var16, var14, VetheaBlocks.hyrewoodLeaves);

                                }
                            }
                        }
                    }

                    for (int lol = 0; lol < var6; lol++)
                    {
                       Block b1 = world.getBlock(x, y + var16, z);

                        Block block = b1;

                        if (b1 == Blocks.air || block == Blocks.air || block.isLeaves(world, x, y + lol, z))
                        {
                        	world.setBlock(x, y + lol, z, VetheaBlocks.hyrewood);
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            //}
        }
        else
        {
            return false;
        }
    }
}