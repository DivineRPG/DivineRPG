package divinerpg.blocks.vethea;

import divinerpg.blocks.base.BlockModUnbreakable;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.phys.Vec3;

public class BlockHelioticBeam extends BlockModUnbreakable {
    public BlockHelioticBeam() {super(MapColor.WOOL);}
    public void dropBomb(Level level, BlockPos pos) {
        ThrowableProjectile bullet = EntityRegistry.ZORAGON_BOMB.get().create(level, EntitySpawnReason.EVENT);
        bullet.setPos(new Vec3(pos.getX() + .5, pos.getY() - .5, pos.getZ() + .5));
        bullet.setDeltaMovement(0, -.1, 0);
        level.addFreshEntity(bullet);
    }
}