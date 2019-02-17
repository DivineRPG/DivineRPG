package naturix.divinerpg.objects.entities.assets.render.projectile;

import naturix.divinerpg.objects.entities.entity.projectiles.EntityKingOfScorchersMeteor;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderKingofScorchersMeteor extends RenderProjectile<EntityKingOfScorchersMeteor> {
    private ResourceLocation TEXTURE = new ResourceLocation(
            "divinerpg:textures/entity/projectiles/king_of_scorchers_meteor.png");

    public RenderKingofScorchersMeteor(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityKingOfScorchersMeteor entity) {
        return TEXTURE;
    }
}
