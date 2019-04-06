package naturix.divinerpg.objects.entities.assets.render.projectile;

import naturix.divinerpg.objects.entities.entity.projectiles.EntityWatcherShot;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderWatcherShot extends RenderProjectile<EntityWatcherShot> {
    private ResourceLocation TEXTURE = new ResourceLocation("divinerpg:textures/projectiles/watcher_shot.png");

    public RenderWatcherShot(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWatcherShot entity) {
        return TEXTURE;
    }
}
