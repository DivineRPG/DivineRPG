package divinerpg.objects.entities.entity.projectiles;

import divinerpg.objects.entities.assets.render.projectiles.RenderKingofScorchersShot;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityKingOfScorchersShot extends EntityThrowable {

    public EntityKingOfScorchersShot(World par1World) {
        super(par1World);
    }

    public EntityKingOfScorchersShot(World par1World, EntityLivingBase e) {
        super(par1World, e);
    }

    public EntityKingOfScorchersShot(World par1World, double par2, double par4, double par6) {
        super(par1World, par2, par4, par6);
    }

    @SideOnly(Side.CLIENT)
    public static void renderMe() {
        RenderingRegistry.registerEntityRenderingHandler(EntityKingOfScorchersShot.class,
                manager -> new RenderKingofScorchersShot(manager, 1f));
    }

    @Override
    public float getGravityVelocity() {
        return 0;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if (!world.isRemote) {
            if (this.ticksExisted > 200)
                this.setDead();
        }
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!world.isRemote) {
            if (result.entityHit != null) {
                result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 14);
                result.entityHit.setFire(8);
            }
            this.setDead();
        }
    }
}