package divinerpg.objects.entities.entity.projectiles;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class EntitySoundOfMusic extends EntityThrowable {
    Random r = new Random();
    int color = r.nextInt(25);

    public EntitySoundOfMusic(World var1) {
        super(var1);
    }

    public EntitySoundOfMusic(World var1, double var2, double var4, double var6) {
        super(var1, var2, var4, var6);
    }

    public EntitySoundOfMusic(World var1, EntityPlayer var2) {
        super(var1, var2);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void onUpdate() {
        super.onUpdate();
        this.world.spawnParticle(EnumParticleTypes.NOTE, this.posX, this.posY, this.posZ, (double) color / 24.0D, 0.0D,
                0.0D);
    }

    @Override
    protected void onImpact(RayTraceResult var1) {
        if (var1.entityHit != null) {
            var1.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 10.0F);
        }

        if (!this.world.isRemote) {
            this.setDead();
        }
    }
}