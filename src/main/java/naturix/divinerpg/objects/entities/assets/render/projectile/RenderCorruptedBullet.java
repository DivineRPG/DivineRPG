package naturix.divinerpg.objects.entities.assets.render.projectile;

import naturix.divinerpg.objects.entities.entity.projectiles.EntityCorruptedBullet;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCorruptedBullet extends RenderProjectile<EntityCorruptedBullet> {
    private ResourceLocation TEXTURE = new ResourceLocation("divinerpg:textures/items/corrupted_bullet.png");

    public RenderCorruptedBullet(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCorruptedBullet entity) {
        return TEXTURE;
    }
}
