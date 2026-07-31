package divinerpg.client.renders.entity.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import divinerpg.DivineRPG;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import org.joml.Matrix4f;

public class RenderDivineFireball<T extends Entity> extends EntityRenderer<T, EntityRenderState> {
    protected final Identifier texture;
    protected final RenderType renderType;

    public RenderDivineFireball(final EntityRendererProvider.Context context, final String name) {
        this(context, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/projectiles/" + name + ".png"));
    }

    public RenderDivineFireball(final EntityRendererProvider.Context context, final Identifier texture) {
        super(context);
        this.texture = texture;
        this.renderType = RenderTypes.entityCutout(texture);
    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }

    @Override
    public void extractRenderState(T entity, EntityRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
    }

    @Override
    public void submit(EntityRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        super.submit(state, poseStack, submitNodeCollector, camera);
        poseStack.pushPose();
        poseStack.scale(0.5F, 0.5F, 0.5F);
        poseStack.mulPose(camera.orientation);
        submitNodeCollector.submitCustomGeometry(poseStack, this.renderType,
                (pose, vertexBuilder) -> {
                    Matrix4f matrix4f = pose.pose();
                    addVertex(vertexBuilder, matrix4f, pose, state.lightCoords, 0.0F, 0.0F, 0.0F, 1.0F);
                    addVertex(vertexBuilder, matrix4f, pose, state.lightCoords, 1.0F, 0.0F, 1.0F, 1.0F);
                    addVertex(vertexBuilder, matrix4f, pose, state.lightCoords, 1.0F, 1.0F, 1.0F, 0.0F);
                    addVertex(vertexBuilder, matrix4f, pose, state.lightCoords, 0.0F, 1.0F, 0.0F, 0.0F);
                }
        );
        poseStack.popPose();
    }

    private static void addVertex(VertexConsumer builder, Matrix4f matrix4f, PoseStack.Pose pose, int light, float x, float y, float u, float v) {
        builder.addVertex(matrix4f, x - 0.5F, y - 0.25F, 0.0F)
                .setColor(255, 255, 255, 255)
                .setUv(u, v)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(light)
                .setNormal(pose, 0.0F, 1.0F, 0.0F);
    }
}