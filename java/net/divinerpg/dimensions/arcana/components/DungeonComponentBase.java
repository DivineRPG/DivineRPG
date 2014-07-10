package net.divinerpg.dimensions.arcana.components;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;

public abstract class DungeonComponentBase
{
    /**
     * Sets wither or not the generator should notify blocks of blocks it changes. When the world is first generated,
     * this is false, when saplings grow, this is true.
     */
    private final boolean doBlockNotify;

    public DungeonComponentBase()
    {
        this.doBlockNotify = false;
    }

    public DungeonComponentBase(boolean par1)
    {
        this.doBlockNotify = par1;
    }

    public abstract boolean generate(Chunk var1, Random var2, int var3, int var4, int var5);

    /**
     * Rescales the generator settings, only used in WorldGenBigTree
     */
    public void setScale(double par1, double par3, double par5) {}

    /**
     * Sets the block without metadata in the world, notifying neighbors if enabled.
     */
    protected void setBlock(World par1World, int par2, int par3, int par4, Block par5)
    {
        this.setBlockAndMetadata(par1World, par2, par3, par4, par5, 0);
    }

    /**
     * Sets the block in the world, notifying neighbors if enabled.
     */
    protected void setBlockAndMetadata(World par1World, int par2, int par3, int par4, Block par5, int par6)
    {
        if (this.doBlockNotify)
        {
            par1World.setBlock(par2, par3, par4, par5, par6, 2);
        }
        else
        {
            par1World.setBlock(par2, par3, par4, par5, par6, 2);
        }
    }
}