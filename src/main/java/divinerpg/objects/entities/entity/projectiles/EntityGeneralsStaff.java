package divinerpg.objects.entities.entity.projectiles;

import divinerpg.enums.BulletType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityGeneralsStaff extends EntityColoredBullet {

    public EntityGeneralsStaff(World world) {
        super(world);
    }

    public EntityGeneralsStaff(World world, EntityPlayer player) {
        super(world, player, BulletType.GENERALS_STAFF_SHOT);
    }

    @Override
    public void onImpact(RayTraceResult position) {
        super.onImpact(position);
        if (!this.world.isRemote) {
            for (double theta = 0; theta < Math.PI * 2; theta += Math.PI / 2) {
                EntityColoredBullet e = new EntityColoredBullet(this.world, this.thrower,
                        BulletType.GENERALS_STAFF_SPRAY);
                setHere(e);
                e.shoot(Math.cos(theta), 0.4, Math.sin(theta), 0.7f, 0);
                this.world.spawnEntity(e);
            }

            EntityColoredBullet e = new EntityColoredBullet(this.world, this.thrower, BulletType.GENERALS_STAFF_SPRAY);
            setHere(e);
            e.shoot(0, 1, 0, 0.7f, 0);
            this.world.spawnEntity(e);
        }
    }

    private void setHere(Entity e) {
        e.setPosition(this.posX, this.posY, this.posZ);
    }
}