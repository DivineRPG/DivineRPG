package net.divinerpg.blocks.vethea;

import java.util.Random;

import net.divinerpg.api.blocks.BlockMod;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHelioticBeam extends BlockMod {

    public BlockHelioticBeam(String name) {
        super(name, 1.0F, DivineRPGTabs.vethea);
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return 0;
    }

    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6)
    {
        /*byte var7 = 4;
        int var8 = var7 + 1;

        if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8))
        {
            for (int var9 = -var7; var9 <= var7; ++var9)
            {
                for (int var10 = -var7; var10 <= var7; ++var10)
                {
                    for (int var11 = -var7; var11 <= var7; ++var11)
                    {
                        int var12 = par1World.getBlockId(par2 + var9, par3 + var10, par4 + var11);

                        if (Block.blocksList[var12] != null)
                        {
                            Block.blocksList[var12].beginLeavesDecay(par1World, par2 + var9, par3 + var10, par4 + var11);
                        }
                    }
                }
            }
        }*/
    }

    public void dispense(World par0World, int par2, int par3, int par4)
    {
        double var5 = par2;
        double var7 = par3;
        double var9 = par4;
       // EntityZoragonBomb var11 = new EntityZoragonBomb(par0World, var5 + 0.5D, var7 - 0.5D, var9 + 0.5D);
      //  var11.motionX = 0D;
      //  var11.motionY = -0.1D;
      //  var11.motionZ = 0D;
      //  par0World.spawnEntityInWorld(var11);
    }

    @Override
    public int onBlockPlaced(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8, int par9)
    {
        int var10 = par9 & 3;
        byte var11 = 0;

        switch (par5)
        {
            case 0:
            case 1:
                var11 = 0;
                break;
            case 2:
            case 3:
                var11 = 8;
                break;
            case 4:
            case 5:
                var11 = 4;
        }

        return var10 | var11;
    }

    @Override
    public int damageDropped(int par1)
    {
        return par1 & 3;
    }

    @Override
    public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }

    @Override
    public boolean isWood(IBlockAccess world, int x, int y, int z)
    {
        return true;
    }
}