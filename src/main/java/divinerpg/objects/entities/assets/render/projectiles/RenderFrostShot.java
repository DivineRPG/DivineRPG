package divinerpg.objects.entities.assets.render.projectiles;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.entity.projectiles.EntityFrostShot;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderFrostShot extends RenderProjectile<EntityFrostShot> {
    private ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/projectiles/frost_shot.png");

    public RenderFrostShot(RenderManager manager, float scaleIn) {
        super(manager, scaleIn);
        this.bindTexture(TEXTURE);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityFrostShot entity) {
        return TEXTURE;
    }
}
