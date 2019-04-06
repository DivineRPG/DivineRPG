package naturix.divinerpg.objects.entities.assets.render.projectile;

import naturix.divinerpg.objects.entities.entity.projectiles.EntityScorcherShot;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderScorcherShot extends RenderProjectile<EntityScorcherShot> {
    private ResourceLocation TEXTURE = new ResourceLocation("divinerpg:textures/projectiles/scorcher_shot.png");

    public RenderScorcherShot(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityScorcherShot entity) {
        return TEXTURE;
    }
}
