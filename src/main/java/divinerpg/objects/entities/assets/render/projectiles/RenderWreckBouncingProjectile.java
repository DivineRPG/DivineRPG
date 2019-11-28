package divinerpg.objects.entities.assets.render.projectiles;

import divinerpg.objects.entities.entity.projectiles.EntityWreckBouncingProjectile;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderWreckBouncingProjectile extends RenderProjectile<EntityWreckBouncingProjectile> {
    private ResourceLocation TEXTURE = new ResourceLocation(
            "divinerpg:textures/projectiles/wreck_bouncing_projectile.png");

    public RenderWreckBouncingProjectile(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWreckBouncingProjectile entity) {
        return TEXTURE;
    }
}
