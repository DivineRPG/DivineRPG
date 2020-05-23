package divinerpg.objects.entities.assets.render.projectiles;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.projectiles.EntityVileStorm;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderVileStorm extends RenderProjectile<EntityVileStorm> {
    private ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/items/vile_storm.png");

    public RenderVileStorm(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityVileStorm entity) {
        return TEXTURE;
    }
}
