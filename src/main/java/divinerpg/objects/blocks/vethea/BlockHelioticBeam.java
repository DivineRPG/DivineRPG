package divinerpg.objects.blocks.vethea;

import java.util.Random;

import divinerpg.objects.blocks.BlockModUnbreakable;
import divinerpg.objects.entities.entity.projectiles.EntityZoragonBomb;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockHelioticBeam extends BlockModUnbreakable {

    public BlockHelioticBeam(String name) {
        super(name);
    }

    @Override
    public int quantityDropped(Random par1Random) {
        return 0;
    }

    public void dropBomb(World w, BlockPos pos) {
        double var5 = pos.getX();
        double var7 = pos.getY();
        double var9 = pos.getZ();
        EntityZoragonBomb var11 = new EntityZoragonBomb(w, var5 + 0.5D, var7 - 0.5D, var9 + 0.5D);
        var11.motionX = 0D;
        var11.motionY = -0.1D;
        var11.motionZ = 0D;
        w.spawnEntity(var11);
    }

}