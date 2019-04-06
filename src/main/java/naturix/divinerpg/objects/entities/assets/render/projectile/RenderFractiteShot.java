package naturix.divinerpg.objects.entities.assets.render.projectile;

import naturix.divinerpg.objects.entities.entity.projectiles.EntityFractiteShot;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFractiteShot extends RenderProjectile<EntityFractiteShot> {
    private ResourceLocation TEXTURE = new ResourceLocation("divinerpg:textures/projectiles/fractite_shot.png");

    public RenderFractiteShot(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityFractiteShot entity) {
        return TEXTURE;
    }
}
