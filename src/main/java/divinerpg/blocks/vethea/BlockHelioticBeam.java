package divinerpg.blocks.vethea;

import divinerpg.blocks.base.*;
import divinerpg.entities.projectile.*;
import divinerpg.registries.*;
import net.minecraft.util.math.*;
import net.minecraft.world.*;

public class BlockHelioticBeam extends BlockModUnbreakable {

    public BlockHelioticBeam(String name) {
        super(name);
    }

    public void dropBomb(World w, BlockPos pos) {
        double var5 = pos.getX();
        double var7 = pos.getY();
        double var9 = pos.getZ();
        EntityZoragonBomb var11 = new EntityZoragonBomb(EntityRegistry.ZORAGON_BOMB, var5 + 0.5D, var7 - 0.5D, var9 + 0.5D, w);
        var11.setDeltaMovement(0, -0.1, 0);
        w.addFreshEntity(var11);
    }
}
