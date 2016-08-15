package net.divinerpg.blocks.vethea;

import java.util.Random;

import net.divinerpg.blocks.base.BlockMod;
import net.divinerpg.entities.vethea.projectile.EntityZoragonBomb;
import net.divinerpg.utils.tabs.DivineRPGTabs;
import net.minecraft.block.Block;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHelioticBeam extends BlockMod {

    public BlockHelioticBeam(String name) {
        super(name, false, DivineRPGTabs.vethea);
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return 0;
    }

    public void dispense(World w, int x, int y, int z) {
        double var5 = x;
        double var7 = y;
        double var9 = z;
        EntityZoragonBomb var11 = new EntityZoragonBomb(w, var5 + 0.5D, var7 - 0.5D, var9 + 0.5D);
        var11.motionX = 0D;
        var11.motionY = -0.1D;
        var11.motionZ = 0D;
        w.spawnEntityInWorld(var11);
    }

}