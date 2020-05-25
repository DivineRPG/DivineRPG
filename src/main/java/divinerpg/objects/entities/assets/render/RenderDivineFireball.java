package divinerpg.objects.entities.assets.render;

import divinerpg.objects.entities.assets.render.projectiles.RenderProjectile;
import divinerpg.objects.entities.entity.EntityDivineRPGMob;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.util.ResourceLocation;

public class RenderDivineFireball extends RenderProjectile<EntityFireball> {
    private ResourceLocation texture;
    private float scaleFactor;

    public RenderDivineFireball(RenderManager renderManager, ResourceLocation texture) {
        super(renderManager, 1F);
        this.texture = texture;
    }

    public RenderDivineFireball(RenderManager renderManager, float scaleFactor, ResourceLocation texture) {
        super(renderManager, scaleFactor);
        this.texture = texture;
    }

    protected ResourceLocation getEntityTexture(EntityFireball entity) {
        return texture;
    }
}
