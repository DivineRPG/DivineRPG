package naturix.divinerpg.objects.entities.entity.projectiles;

import naturix.divinerpg.objects.entities.assets.render.projectile.RenderFirefly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityFirefly extends EntityHeatSeekingProjectile {

    public EntityFirefly(World w) {
        super(w);
    }
    
    public EntityFirefly(World w, EntityLivingBase e) {
        super(w, e);
    }
    

    @Override
    protected void onImpact(RayTraceResult pos) {
        if (pos.entityHit != null) pos.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 15);

        if (!this.world.isRemote) this.setDead();
    }
    @SideOnly(Side.CLIENT)
	public static void renderMe() {
    RenderingRegistry.registerEntityRenderingHandler(EntityFirefly.class, manager -> new RenderFirefly(manager));
	}
}