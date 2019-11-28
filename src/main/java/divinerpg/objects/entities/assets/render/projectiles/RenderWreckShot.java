package divinerpg.objects.entities.assets.render.projectiles;

import divinerpg.objects.entities.entity.projectiles.EntityWreckShot;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderWreckShot extends RenderProjectile<EntityWreckShot> {
    private ResourceLocation TEXTURE = new ResourceLocation(
            "divinerpg:textures/projectiles/wreck_shot.png");

    public RenderWreckShot(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityWreckShot entity) {
        return TEXTURE;
    }
}
