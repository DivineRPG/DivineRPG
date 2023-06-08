package divinerpg.blocks.vethea;

import divinerpg.blocks.base.BlockModUnbreakable;
import divinerpg.entities.projectile.EntityZoragonBomb;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.MapColor;

public class BlockHelioticBeam extends BlockModUnbreakable {

    public BlockHelioticBeam() {
        super(MapColor.WOOL);
    }

    public void dropBomb(Level w, BlockPos pos) {
        double var5 = pos.getX();
        double var7 = pos.getY();
        double var9 = pos.getZ();
        EntityZoragonBomb var11 = new EntityZoragonBomb(EntityRegistry.ZORAGON_BOMB.get(), var5 + 0.5D, var7 - 0.5D, var9 + 0.5D, w);
        var11.setDeltaMovement(0, -0.1, 0);
        w.addFreshEntity(var11);
    }
}