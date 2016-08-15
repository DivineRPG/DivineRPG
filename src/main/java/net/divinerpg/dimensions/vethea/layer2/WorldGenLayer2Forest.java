package net.divinerpg.dimensions.vethea.layer2;

import java.util.Random;

import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLayer2Forest extends WorldGenerator
{
    public WorldGenLayer2Forest(boolean par1)
    {
        super(par1);
    }

    public boolean generate(World world, Random par2Random, int par3, int par4, int par5)
    {
        int var6 = par2Random.nextInt(3) + 5;
        boolean var7 = true;

        if (par4 >= 1 && par4 + var6 + 1 <= 256)
        {
            int var8;
            int var10;
            int var11;
            int var12;
            
            for (var8 = par4; var8 <= par4 + 1 + var6; ++var8)
            {
                byte var9 = 1;

                if (var8 == par4)
                {
                    var9 = 0;
                }

                if (var8 >= par4 + 1 + var6 - 2)
                {
                    var9 = 2;
                }

                for (var10 = par3 - var9; var10 <= par3 + var9 && var7; ++var10)
                {
                    for (var11 = par5 - var9; var11 <= par5 + var9 && var7; ++var11)
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

                Block b1 = world.getBlock(par3, par4 - 1, par5);

                if ((b1 == VetheaBlocks.dreamGrass || b1 == VetheaBlocks.dreamDirt) && par4 < 256 - var6 - 1)
                {
                    world.setBlock(par3, par4 - 1, par5, VetheaBlocks.dreamDirt);
                    int var16;

                    for (var16 = par4 - 3 + var6; var16 <= par4 + var6; ++var16)
                    {
                        var10 = var16 - (par4 + var6);
                        var11 = 1 - var10 / 2;

                        for (var12 = par3 - var11; var12 <= par3 + var11; ++var12)
                        {
                            int var13 = var12 - par3;

                            for (int var14 = par5 - var11; var14 <= par5 + var11; ++var14)
                            {
                                int var15 = var14 - par5;

                                Block block = world.getBlock(var12, var16, var14);
                                
                                if ((Math.abs(var13) != var11 || Math.abs(var15) != var11 || par2Random.nextInt(2) != 0 && var10 != 0) && 
                                    (block == null || block.canBeReplacedByLeaves(world, var12, var16, var14)))
                                {
                                    world.setBlock(var12, var16, var14, VetheaBlocks.firewoodLeaves, 0, 2);
                                } 
                            }
                        }
                    }

                    for (var16 = 0; var16 < var6; ++var16)
                    {
                        Block b3 = world.getBlock(par3, par4 + var16, par5);

                        Block block = b3;

                        if (b3 == Blocks.air || block == Blocks.air || block.isLeaves(world, par3, par4 + var16, par5))
                        {
                            world.setBlock(par3, par4 + var16, par5, VetheaBlocks.firewood, 0, 2);
                        }
                    } 

                    return true;
                }
                else
                {
                    return false;
                }
        }
        else
        {
            return false;
        }
    }
}