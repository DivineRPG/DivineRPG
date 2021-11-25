package divinerpg.client.renders.entity.projectile;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import divinerpg.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.projectile.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;

public class RenderSaguaroWormShot extends EntityRenderer<EntitySaguaroWormShot> {
    private ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/projectiles/saguaro_worm_shot.png");
    private ModelSaguaroWormShot model = new ModelSaguaroWormShot();

    public RenderSaguaroWormShot(EntityRendererManager manager) {
        super(manager);
    }


    @Override
    public void render(EntitySaguaroWormShot entity, float yaw, float ticks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLightCoords) {
        super.render(entity, yaw, ticks, matrixStack, buffer, packedLightCoords);
        matrixStack.pushPose();
        IVertexBuilder vertexBuilder = buffer.getBuffer(RenderType.entityCutout(TEXTURE));
        model.renderToBuffer(matrixStack, vertexBuilder, packedLightCoords, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySaguaroWormShot entity) {
        return TEXTURE;
    }
}