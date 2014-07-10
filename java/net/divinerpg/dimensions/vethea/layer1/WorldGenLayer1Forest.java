package net.divinerpg.dimensions.vethea.layer1;

import java.util.Random;

import net.divinerpg.dimensions.vethea.all.WorldAddition;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenLayer1Forest extends WorldGenerator
{
    public WorldGenLayer1Forest(boolean par1)
    {
        super(par1);
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
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
                byte var9 = 0;

                if (var8 == par4)
                {
                    var9 = 0;
                }

                if (var8 >= par4 + 1 + var6 - 2)
                {
                    var9 = 1;
                }

                for (var10 = par3 - var9; var10 <= par3 + var9 && var7; ++var10)
                {
                    for (var11 = par5 - var9; var11 <= par5 + var9 && var7; ++var11)
                    {
                        if (var8 >= 0 && var8 < 256)
                        {
                            Block b = par1World.getBlock(var10, var8, var11);

                            Block block = b;

                            if (b != null && (block != null && !block.isLeaves(par1World, var10,  var8, var11)))
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

            if (!var7)
            {
                return false;
            }
            else
            {
                Block b = par1World.getBlock(par3, par4 - 1, par5);

                if ((b == VetheaBlocks.dreamGrass || b == VetheaBlocks.dreamDirt) && par4 < 256 - var6 - 1)
                {
                    par1World.setBlock(par3, par4 - 1, par5, VetheaBlocks.dreamDirt);
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

                                Block block = par1World.getBlock(var12, var16, var14);
                                
                                if ((Math.abs(var13) != var11 || Math.abs(var15) != var11 || par2Random.nextInt(2) != 0 && var10 != 0) && 
                                    (block == null || block.canBeReplacedByLeaves(par1World, var12, var16, var14)))
                                {
                                    WorldAddition.setBlockWithMetadata(var12, var16, var14, VetheaBlocks.hyrewoodLeaves, 0);
                                }
                            }
                        }
                    }

                    for (var16 = 0; var16 < var6; ++var16)
                    {
                       Block b1 = par1World.getBlock(par3, par4 + var16, par5);

                        Block block = b1;

                        if (b1 == null || block == null || block.isLeaves(par1World, par3, par4 + var16, par5))
                        {
                            WorldAddition.setBlockWithMetadata(par3, par4 + var16, par5, VetheaBlocks.hyrewood, 0);
                        }
                    }

                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
        else
        {
            return false;
        }
    }
}