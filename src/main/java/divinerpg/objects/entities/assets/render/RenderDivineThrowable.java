package divinerpg.objects.entities.assets.render;

import divinerpg.objects.entities.assets.render.projectiles.RenderProjectile;
import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.ResourceLocation;

public class RenderDivineThrowable extends RenderProjectile<EntityThrowable> {
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
