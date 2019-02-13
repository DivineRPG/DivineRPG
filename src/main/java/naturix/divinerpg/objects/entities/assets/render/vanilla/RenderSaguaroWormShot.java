package naturix.divinerpg.objects.entities.assets.render.vanilla;

import naturix.divinerpg.objects.entities.assets.model.vanilla.model.ModelSaguaroWormShot;
import naturix.divinerpg.objects.entities.entity.projectiles.SaguaroWormShot;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderSaguaroWormShot extends Render<SaguaroWormShot> {
    private ResourceLocation TEXTURE = new ResourceLocation(
            "divinerpg:textures/entity/projectiles/saguaro_worm_shot.png");
    private ModelSaguaroWormShot model = new ModelSaguaroWormShot();

    public RenderSaguaroWormShot(RenderManager manager) {
        super(manager);
        this.bindTexture(TEXTURE);
    }

    public void doRender(SaguaroWormShot entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        this.bindEntityTexture(entity);
        GlStateManager.translate((float) x, (float) y, (float) z);
        GlStateManager.enableRescaleNormal();
        model.renderAll();
        GlStateManager.popMatrix();
    }

    protected ResourceLocation getEntityTexture(SaguaroWormShot entity) {
        return TEXTURE;
    }
}
