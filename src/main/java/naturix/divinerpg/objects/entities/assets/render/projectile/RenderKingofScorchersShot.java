package naturix.divinerpg.objects.entities.assets.render.projectile;

import naturix.divinerpg.objects.entities.entity.projectiles.EntityKingOfScorchersShot;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderKingofScorchersShot extends RenderProjectile<EntityKingOfScorchersShot> {
    private ResourceLocation TEXTURE = new ResourceLocation(
            "divinerpg:textures/entity/projectiles/king_of_scorchers_shot.png");

    public RenderKingofScorchersShot(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityKingOfScorchersShot entity) {
        return TEXTURE;
    }
}
