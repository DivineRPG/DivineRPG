package divinerpg.objects.entities.assets.render.projectiles;

import divinerpg.DivineRPG;
import divinerpg.objects.entities.assets.model.vanilla.ModelSaguaroWormShot;
import divinerpg.objects.entities.entity.projectiles.EntitySaguaroWormShot;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSaguaroWormShot extends Render<EntitySaguaroWormShot> {
    private ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/projectiles/saguaro_worm_shot.png");
    private ModelSaguaroWormShot model = new ModelSaguaroWormShot();

    public RenderSaguaroWormShot(RenderManager manager) {
        super(manager);
        this.bindTexture(TEXTURE);
    }

    public void doRender(EntitySaguaroWormShot entity, double x, double y, double z, float entityYaw,
            float partialTicks) {
        GlStateManager.pushMatrix();
        this.bindEntityTexture(entity);
        GlStateManager.translate((float) x, (float) y, (float) z);
        GlStateManager.enableRescaleNormal();
        model.renderAll();
        GlStateManager.popMatrix();
    }

    protected ResourceLocation getEntityTexture(EntitySaguaroWormShot entity) {
        return TEXTURE;
    }
}
