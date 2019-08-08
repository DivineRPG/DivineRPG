package naturix.divinerpg.objects.entities.entity.projectiles;

import naturix.divinerpg.objects.entities.assets.render.projectile.RenderMerikMissile;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityMerikMissile extends EntityHeatSeekingProjectile {

    public EntityMerikMissile(World w) {
        super(w);
    }
    
    public EntityMerikMissile(World w, EntityLivingBase e) {
        super(w, e);
    }
    

    @Override
    protected void onImpact(RayTraceResult pos) {
        if (pos.entityHit != null) pos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 22);
        if (!this.world.isRemote) {
            this.world.createExplosion(this, this.posX, this.posY, this.posZ, 2, false);
            this.setDead();
        }
    }
    @SideOnly(Side.CLIENT)
	public static void renderMe() {
        RenderingRegistry.registerEntityRenderingHandler(EntityMerikMissile.class, manager -> new RenderMerikMissile(manager));
    	}
}