package divinerpg.client.renders.entity.projectile;

import com.mojang.blaze3d.vertex.*;
import divinerpg.*;
import divinerpg.client.models.vanilla.*;
import divinerpg.entities.projectile.*;
import divinerpg.entities.vanilla.overworld.EntitySaguaroWorm;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.*;

import net.minecraft.resources.ResourceLocation;

public class RenderSaguaroWormShot extends EntityRenderer<EntitySaguaroWormShot> {
    private final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/projectiles/saguaro_worm_shot.png");
    private final ModelSaguaroWormShot<EntitySaguaroWorm> model;

    public RenderSaguaroWormShot(Context context) {
        super(context);
        model = new ModelSaguaroWormShot<>(context);
    }


    @Override
    public void render(EntitySaguaroWormShot entity, float yaw, float ticks, PoseStack matrixStack, MultiBufferSource buffer, int packedLightCoords) {
        super.render(entity, yaw, ticks, matrixStack, buffer, packedLightCoords);
        matrixStack.pushPose();
        VertexConsumer vertexBuilder = buffer.getBuffer(RenderType.entityCutout(TEXTURE));
        model.renderToBuffer(matrixStack, vertexBuilder, packedLightCoords, OverlayTexture.NO_OVERLAY, 1);
        matrixStack.popPose();
    }

    @Override
    public ResourceLocation getTextureLocation(EntitySaguaroWormShot entity) {
        return TEXTURE;
    }
}