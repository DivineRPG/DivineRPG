package net.divinerpg.blocks.vethea;

import java.util.Random;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.utils.blocks.VetheaBlocks;
import net.divinerpg.utils.material.EnumBlockType;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.world.World;

public class BlockKarosHeatTile extends BlockMod {
    private final boolean powered;
    public boolean        override;

    public BlockKarosHeatTile(boolean powered, String name) {
        super(EnumBlockType.GLASS, name, false, DivineRPGTabs.vethea);
        this.powered = powered;
        this.override = false;
        if (this == VetheaBlocks.karosHeatTileRed) {
            this.setTickRandomly(true);
        }
    }

    public void onBlockAdded(World var1, int var2, int var3, int var4) {

        if (this == VetheaBlocks.karosHeatTileGreen) {
            if (!var1.isRemote && !this.override)
            {
                if (this.powered && !var1.isBlockIndirectlyGettingPowered(var2, var3, var4))
                {
                    var1.scheduleBlockUpdate(var2, var3, var4, this, 4);
                }
                else if (!this.powered && var1.isBlockIndirectlyGettingPowered(var2, var3, var4))
                {
                    var1.setBlock(var2, var3, var4, VetheaBlocks.karosHeatTileRed);
                }
            }
        }
        else if (this == VetheaBlocks.karosHeatTileRed) {

            if (!var1.isRemote) {
                var1.setBlock(var2, var3, var4, VetheaBlocks.karosHeatTileRed);
            }
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which
     * neighbor changed (coordinates passed are their own) Args: x, y, z,
     * neighbor blockID
     */
    public void onNeighborBlockChange(World var1, int var2, int var3, int var4, int var5)
    {
        if (this == VetheaBlocks.karosHeatTileGreen) {
            if (!var1.isRemote && !this.override)
            {
                if (this.powered && !var1.isBlockIndirectlyGettingPowered(var2, var3, var4))
                {
                    var1.scheduleBlockUpdate(var2, var3, var4, this, 4);
                }
                else if (!this.powered && var1.isBlockIndirectlyGettingPowered(var2, var3, var4))
                {
                    var1.setBlock(var2, var3, var4, VetheaBlocks.karosHeatTileRed);
                }
            }
        }
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World var1, int var2, int var3, int var4, Random var5)
    {
        if (!var1.isRemote && this.powered && !var1.isBlockIndirectlyGettingPowered(var2, var3, var4) && !this.override)
        {
            if (this == VetheaBlocks.karosHeatTileGreen) {
                var1.setBlock(var2, var3, var4, VetheaBlocks.karosHeatTileRed);
            }
            else if (this == VetheaBlocks.karosHeatTileRed) {
                var1.setBlock(var2, var3, var4, VetheaBlocks.karosHeatTileGreen);
            }
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public Block idDropped(int var1, Random var2, int var3)
    {
        return VetheaBlocks.karosHeatTileGreen;
    }

}
