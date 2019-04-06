package naturix.divinerpg.objects.entities.entity.projectiles;

import java.awt.Color;

import naturix.divinerpg.DivineRPG;
import naturix.divinerpg.enums.ProjectileType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityColoredBullet extends EntityShooterBullet {

    public EntityColoredBullet(World world) {
        super(world);
    }

    public EntityColoredBullet(World world, EntityLivingBase entity, ProjectileType projectileType) {
        super(world, entity, projectileType);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void onUpdate() {
        super.onUpdate();
        for (int var3 = 0; var3 < 8; ++var3) {
            double x = this.posX + (this.rand.nextDouble() - this.rand.nextDouble()) / 4;
            double y = this.posY + (this.rand.nextDouble() - this.rand.nextDouble()) / 4;
            double z = this.posZ + (this.rand.nextDouble() - this.rand.nextDouble()) / 4;
            DivineRPG.proxy.spawnColoredParticle(this.world, x, y, z, new Color(0, 0, 0), true, false);
        }
    }
}