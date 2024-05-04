package divinerpg.client.renders.entity.projectile;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.entities.projectile.EntityShooterBullet;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.joml.*;

public class RenderShooterBullet extends EntityRenderer<EntityShooterBullet> {
    public RenderShooterBullet(final Context context) {super(context);}
    @Override public void render(EntityShooterBullet entity, float yaw, float partialTicks, PoseStack matrix, MultiBufferSource buffer, int packedLight) {
        if (entity.tickCount >= 2 || !(entityRenderDispatcher.camera.getEntity().distanceToSqr(entity) < 12.25)) {
            matrix.pushPose();
            matrix.scale(.5F, .5F, .5F);
            matrix.mulPose(entityRenderDispatcher.cameraOrientation());
            matrix.mulPose(Axis.YP.rotationDegrees(180));
            PoseStack.Pose matrixEntry = matrix.last();
            Matrix4f matrix4f = matrixEntry.pose();
            Matrix3f normal = matrixEntry.normal();
            VertexConsumer vertexBuilder = buffer.getBuffer(RenderType.entityCutout(getTextureLocation(entity)));
            pos(vertexBuilder, matrix4f, normal, packedLight, 0, 0, 0, 1);
            pos(vertexBuilder, matrix4f, normal, packedLight, 1, 0, 1, 1);
            pos(vertexBuilder, matrix4f, normal, packedLight, 1, 1, 1, 0);
            pos(vertexBuilder, matrix4f, normal, packedLight, 0, 1, 0, 0);
            matrix.popPose();
            super.render(entity, yaw, partialTicks, matrix, buffer, packedLight);
        }
    }
    private static void pos(VertexConsumer vertexBuilder, Matrix4f matrix4f, Matrix3f normal, int lightmapUV, float x, float y, float u, float v) {vertexBuilder.vertex(matrix4f, x - .5F, y - .25F, 0).color(255, 255, 255, 255).uv(u, v).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(lightmapUV).normal(normal, 0, 1, 0).endVertex();}
    @Override public ResourceLocation getTextureLocation(EntityShooterBullet entity) {return entity.getTexture() != null ? entity.getTexture() : new ResourceLocation("textures/particle/generic_" + entity.level().random.nextInt(7) + ".png");}
}