package divinerpg.objects.entities.assets.render.projectiles;

import divinerpg.objects.entities.entity.projectiles.EntitySerenadeOfIce;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSerenadeOfIce extends RenderProjectile<EntitySerenadeOfIce> {
    private ResourceLocation TEXTURE = new ResourceLocation("divinerpg:textures/projectiles/blank.png");

    public RenderSerenadeOfIce(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntitySerenadeOfIce entity) {
        return TEXTURE;
    }
}
