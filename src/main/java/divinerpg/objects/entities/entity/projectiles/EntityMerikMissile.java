package divinerpg.objects.entities.entity.projectiles;

import divinerpg.objects.entities.assets.render.projectiles.RenderMerikMissile;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityMerikMissile extends EntityHeatSeekingProjectile {
    float damage = 8.0F;

    public EntityMerikMissile(World w) {
        super(w);
    }

    public EntityMerikMissile(World w, EntityLivingBase e, float damage) {
        super(w, e);
        this.damage = damage;
    }

    @Override
    protected void onImpact(RayTraceResult pos) {
        if (pos.entityHit != null) {
            pos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), this.damage);
        }
        if (!this.world.isRemote) {
            this.world.createExplosion(this, this.posX, this.posY, this.posZ, 2, false);
            this.setDead();
        }
    }
}