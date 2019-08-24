package divinerpg.objects.entities.assets.render.projectile;

import divinerpg.objects.entities.entity.projectiles.EntityShuriken;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderShuriken extends RenderProjectile<EntityShuriken> {
    private ResourceLocation TEXTURE = new ResourceLocation("divinerpg:textures/items/shuriken.png");

    public RenderShuriken(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityShuriken entity) {
        return TEXTURE;
    }
}