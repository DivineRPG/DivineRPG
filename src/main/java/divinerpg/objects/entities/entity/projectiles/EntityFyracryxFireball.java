package divinerpg.objects.entities.entity.projectiles;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFyracryxFireball extends EntitySmallFireball {

    public EntityFyracryxFireball(World worldIn) {
        super(worldIn);
    }

    @SideOnly(Side.CLIENT)
    public EntityFyracryxFireball(World worldIn, double x, double y, double z, double accelX, double accelY,
            double accelZ) {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
    }

    public EntityFyracryxFireball(World worldIn, EntityLivingBase shooter, double accelX, double accelY,
            double accelZ) {
        super(worldIn, shooter, accelX, accelY, accelZ);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!this.world.isRemote) {
            if (result.entityHit != null)
                result.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 6);
            this.world.newExplosion((Entity) null, this.posX, this.posY, this.posZ, 1.0F, true, false);
            this.setDead();
        }
    }
}