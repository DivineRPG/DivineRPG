package divinerpg.client.renders.entity.projectile;

import divinerpg.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.projectile.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.util.*;

public class RenderSaguaroWormShot extends EntityRenderer<EntitySaguaroWormShot> {
    private ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/projectiles/saguaro_worm_shot.png");
    private ModelSaguaroWormShot model = new ModelSaguaroWormShot();

    public RenderSaguaroWormShot(EntityRendererManager manager) {
        super(manager);
    }

    //TODO - render saguaro worm shot
//    public void doRender(EntitySaguaroWormShot entity, double x, double y, double z, float entityYaw,
//                         float partialTicks) {
//        GlStateManager.pushMatrix();
//        this.bindEntityTexture(entity);
//        GlStateManager.translate((float) x, (float) y, (float) z);
//        GlStateManager.enableRescaleNormal();
//        model.renderAll();
//        GlStateManager.popMatrix();
//    }

    @Override
    public ResourceLocation getTextureLocation(EntitySaguaroWormShot entity) {
        return TEXTURE;
    }
}