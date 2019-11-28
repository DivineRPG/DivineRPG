package divinerpg.objects.entities.assets.render.projectiles;

import divinerpg.objects.entities.entity.projectiles.EntityWreckExplosiveShot;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderWreckExplosiveShot extends RenderProjectile<EntityWreckExplosiveShot> {
    private ResourceLocation TEXTURE = new ResourceLocation(
            "divinerpg:textures/projectiles/wreck_explosive_shot.png");

    public RenderWreckExplosiveShot(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWreckExplosiveShot entity) {
        return TEXTURE;
    }
}
