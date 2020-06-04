package divinerpg.objects.entities.entity.projectiles;

import java.awt.Color;

import divinerpg.DivineRPG;
import divinerpg.enums.BulletType;
import divinerpg.objects.entities.entity.mortum.EntitySoulSpider;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitySoulFiendShot extends EntityShooterBullet {
    public EntitySoulFiendShot(World world) {
        super(world);
    }

    public EntitySoulFiendShot(World world, EntityLivingBase entity) {
        super(world, entity, BulletType.SOUL_FIEND_SHOT);
    }

    @Override
    public void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            if (result.entityHit != null) {
                for (int i = 0; i < 3; i++) {
                    EntitySoulSpider soulSpider = new EntitySoulSpider(this.world);
                    soulSpider.setLocationAndAngles(this.posX, this.posY, this.posZ, 0, 0);
                    this.world.spawnEntity(soulSpider);
                }
                this.setDead();
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void onUpdate() {
        super.onUpdate();
        for (int cnt = 0; cnt < 8; ++cnt) {
            DivineRPG.proxy.spawnColoredParticle(this.world, this.posX + (rand.nextDouble() - rand.nextDouble()) / 4,
                    this.posY + (rand.nextDouble() - rand.nextDouble()) / 4,
                    this.posZ + (rand.nextDouble() - rand.nextDouble()) / 4, new Color(0, 0, 0), true, false);
            DivineRPG.proxy.spawnColoredParticle(this.world, this.posX + (rand.nextDouble() - rand.nextDouble()) / 4,
                    this.posY + (rand.nextDouble() - rand.nextDouble()) / 4,
                    this.posZ + (rand.nextDouble() - rand.nextDouble()) / 4, new Color(255, 0, 0), true, true);
        }
        if (!this.world.isRemote && this.ticksExisted > 20) {
            this.setDead();
        }
    }
}
