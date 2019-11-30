package divinerpg.objects.entities.assets.render.projectiles;

import divinerpg.objects.entities.entity.projectiles.EntityDissimentShot;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDissimentShot extends RenderProjectile<EntityDissimentShot> {
    private ResourceLocation TEXTURE = new ResourceLocation(
            "divinerpg:textures/projectiles/dissiment_shot.png");

    public RenderDissimentShot(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityDissimentShot entity) {
        return TEXTURE;
    }
}
