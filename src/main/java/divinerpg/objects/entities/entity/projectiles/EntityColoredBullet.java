package divinerpg.objects.entities.entity.projectiles;

import divinerpg.DivineRPG;
import divinerpg.enums.BulletType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityColoredBullet extends EntityShooterBullet {

    public EntityColoredBullet(World world) {
        super(world);
    }

    public EntityColoredBullet(World world, EntityLivingBase entity, BulletType bulletType) {
        super(world, entity, bulletType);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void onUpdate() {
        super.onUpdate();
        for (int var3 = 0; var3 < 8; ++var3) {
            double x = this.posX + (this.rand.nextDouble() - this.rand.nextDouble()) / 4;
            double y = this.posY + (this.rand.nextDouble() - this.rand.nextDouble()) / 4;
            double z = this.posZ + (this.rand.nextDouble() - this.rand.nextDouble()) / 4;
            DivineRPG.proxy.spawnColoredParticle(this.world, x, y, z, this.getBulletType().getColor(), true, false);
        }
    }
}