package divinerpg.objects.entities.assets.render;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.ResourceLocation;

public class RenderDivineThrowable extends RenderDivineProjectile<EntityThrowable> {
    private ResourceLocation texture;
    private float scaleFactor;

    public RenderDivineThrowable(RenderManager renderManager, ResourceLocation texture) {
        super(renderManager, 1F);
        this.texture = texture;
    }

    public RenderDivineThrowable(RenderManager renderManager, float scaleFactor, ResourceLocation texture) {
        super(renderManager, scaleFactor);
        this.texture = texture;
    }

    protected ResourceLocation getEntityTexture(EntityThrowable entity) {
        return texture;
    }
}
