package divinerpg.objects.entities.assets.render.projectiles;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.projectiles.EntityCoriShot;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCoriShot extends RenderProjectile<EntityCoriShot> {
    private ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/projectiles/cori_shot.png");

    public RenderCoriShot(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityCoriShot entity) {
        return TEXTURE;
    }
}
