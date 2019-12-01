package divinerpg.objects.entities.assets.render.projectiles;

import divinerpg.objects.entities.entity.projectiles.EntityMandragoraProjectile;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderMandragoraProjectile extends RenderProjectile<EntityMandragoraProjectile> {
    private ResourceLocation TEXTURE = new ResourceLocation(
            "divinerpg:textures/projectiles/mandragora_projectile.png");

    public RenderMandragoraProjectile(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMandragoraProjectile entity) {
        return TEXTURE;
    }
}
