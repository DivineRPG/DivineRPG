package divinerpg.blocks.vethea;

import divinerpg.blocks.base.BlockModUnbreakable;
import divinerpg.entities.projectile.EntityShooterBullet;
import divinerpg.enums.BulletType;
import divinerpg.registries.EntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.MapColor;

public class BlockHelioticBeam extends BlockModUnbreakable {
    public BlockHelioticBeam() {super(MapColor.WOOL);}
    public void dropBomb(Level level, BlockPos pos) {
        //TODO: for some reason it uses the tomato texture... And I'm not sure why
        ThrowableProjectile bullet = new EntityShooterBullet(EntityRegistry.SHOOTER_BULLET.get(), pos.getX() + .5, pos.getY() - .5, pos.getZ() + .5, level, BulletType.KAROS_BOMB);
        bullet.setDeltaMovement(0, -.1, 0);
        level.addFreshEntity(bullet);
    }
}