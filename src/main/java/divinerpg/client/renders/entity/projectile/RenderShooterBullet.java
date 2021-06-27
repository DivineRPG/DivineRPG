package divinerpg.client.renders.entity.projectile;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import divinerpg.entities.projectile.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.util.*;
import net.minecraft.util.math.vector.*;

public class RenderShooterBullet<T extends EntityShooterBullet> extends EntityRenderer<T> {
    public RenderShooterBullet(final EntityRendererManager renderManager) {
        super(renderManager);
    }

    @Override
    public void render(T entity, float yaw, float partialTicks, MatrixStack matrix, IRenderTypeBuffer buffer, int packedLight) {
        super.render(entity, yaw, partialTicks, matrix, buffer, packedLight);
        matrix.pushPose();
        matrix.scale(0.5f, 0.5f, 0.5f);
        matrix.mulPose(this.entityRenderDispatcher.cameraOrientation());
        matrix.mulPose(Vector3f.YP.rotationDegrees(180.0F));
        MatrixStack.Entry matrixEntry = matrix.last();
        Matrix4f matrix4f = matrixEntry.pose();
        Matrix3f normal = matrixEntry.normal();
        IVertexBuilder vertexBuilder = buffer.getBuffer(RenderType.entityCutout(getTextureLocation(entity)));

        pos(vertexBuilder, matrix4f, normal, packedLight, 0, 0, 0, 1);
        pos(vertexBuilder, matrix4f, normal, packedLight, 1, 0, 1, 1);
        pos(vertexBuilder, matrix4f, normal, packedLight, 1, 1, 1, 0);
        pos(vertexBuilder, matrix4f, normal, packedLight, 0, 1, 0, 0);
        matrix.popPose();
    }

    private static void pos(IVertexBuilder vertexBuilder, Matrix4f matrix4f, Matrix3f normal, int lightmapUV, float x, float y, float u, float v) {
        vertexBuilder.vertex(matrix4f, x - 0.5F, y - 0.25f, 0).color(255, 255, 255, 255).uv(u, v).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(lightmapUV).normal(normal, 0, 1, 0).endVertex();
    }

    @Override
    public ResourceLocation getTextureLocation(EntityShooterBullet entity) {
        return entity.getTexture();
    }
}