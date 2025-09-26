package divinerpg.client.renders.entity.projectile;

import com.mojang.blaze3d.vertex.*;
import divinerpg.client.models.vanilla.ModelSaguaroWormShot;
import divinerpg.entities.projectile.bullet.EntitySaguaroWormShot;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.*;

import static divinerpg.DivineRPG.MODID;

@OnlyIn(Dist.CLIENT)
public class RenderSaguaroWormShot extends EntityRenderer<EntitySaguaroWormShot> {
    private final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(MODID, "textures/projectiles/saguaro_worm_shot.png");
    private final ModelSaguaroWormShot model;
    public RenderSaguaroWormShot(EntityRendererProvider.Context context) {
        super(context);
        model = new ModelSaguaroWormShot(context);
    }
    @Override public void render(EntitySaguaroWormShot entity, float yaw, float ticks, PoseStack matrixStack, MultiBufferSource buffer, int packedLightCoords) {
        super.render(entity, yaw, ticks, matrixStack, buffer, packedLightCoords);
        matrixStack.pushPose();
        VertexConsumer vertexBuilder = buffer.getBuffer(RenderType.entityCutout(TEXTURE));
        model.renderToBuffer(matrixStack, vertexBuilder, packedLightCoords, OverlayTexture.NO_OVERLAY, 1);
        matrixStack.popPose();
    }
    @Override public ResourceLocation getTextureLocation(EntitySaguaroWormShot entity) {return TEXTURE;}
}