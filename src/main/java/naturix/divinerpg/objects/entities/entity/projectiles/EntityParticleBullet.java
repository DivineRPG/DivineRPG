package naturix.divinerpg.objects.entities.entity.projectiles;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.enums.BulletType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityParticleBullet extends EntityShooterBullet {

    public EntityParticleBullet(World world) {
        super(world);
    }

    public EntityParticleBullet(World world, EntityLivingBase entity, BulletType bulletType) {
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
            DivineRPG.proxy.spawnParticle(this.world, this.getBulletType().getParticle(), x, y, z, 0, 0, 0);
        }
    }
}