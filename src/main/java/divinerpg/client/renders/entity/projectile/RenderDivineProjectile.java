package divinerpg.client.renders.entity.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import divinerpg.DivineRPG;
import divinerpg.items.ranged.ItemRangedWeapon;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.projectile.Projectile;
import org.joml.Matrix4f;

public class RenderDivineProjectile<T extends Projectile> extends EntityRenderer<T, RenderDivineProjectile.DivineProjectileRenderState> {
    protected final Identifier texture;
    protected final RenderType renderType;

    public RenderDivineProjectile(final EntityRendererProvider.Context context, final String name) {
        this(context, Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/projectiles/" + name + ".png"));
    }

    public RenderDivineProjectile(final EntityRendererProvider.Context context) {
        this(context, ItemRangedWeapon.GENERIC);
    }

    public RenderDivineProjectile(final EntityRendererProvider.Context context, final Identifier texture) {
        super(context);
        this.texture = texture;
        this.renderType = RenderTypes.entityCutout(texture);
    }

    @Override
    public DivineProjectileRenderState createRenderState() {
        return new DivineProjectileRenderState();
    }

    @Override
    public void extractRenderState(T entity, DivineProjectileRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);

        double cameraDistSqr = entity.level().isClientSide()
                ? this.entityRenderDispatcher.camera.entity().distanceToSqr(entity)
                : 0;

        // Ported condition: entity.tickCount > 2 or distance check
        state.visible = entity.tickCount > 2 || cameraDistSqr >= 12.25;
    }

    @Override
    public void submit(DivineProjectileRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        if (!state.visible) {
            return;
        }

        super.submit(state, poseStack, submitNodeCollector, camera);

        poseStack.pushPose();
        poseStack.scale(0.5F, 0.5F, 0.5F);
        poseStack.mulPose(camera.orientation);

        submitNodeCollector.submitCustomGeometry(
                poseStack,
                this.renderType,
                (pose, vertexBuilder) -> {
                    Matrix4f matrix4f = pose.pose();
                    pos(vertexBuilder, matrix4f, pose, state.lightCoords, 0.0F, 0.0F, 0.0F, 1.0F);
                    pos(vertexBuilder, matrix4f, pose, state.lightCoords, 1.0F, 0.0F, 1.0F, 1.0F);
                    pos(vertexBuilder, matrix4f, pose, state.lightCoords, 1.0F, 1.0F, 1.0F, 0.0F);
                    pos(vertexBuilder, matrix4f, pose, state.lightCoords, 0.0F, 1.0F, 0.0F, 0.0F);
                }
        );

        poseStack.popPose();
    }

    private static void pos(VertexConsumer vertexBuilder, Matrix4f matrix4f, PoseStack.Pose pose, int lightmapUV, float x, float y, float u, float v) {
        vertexBuilder.addVertex(matrix4f, x - 0.5F, y - 0.25F, 0.0F)
                .setColor(255, 255, 255, 255)
                .setUv(u, v)
                .setOverlay(OverlayTexture.NO_OVERLAY)
                .setLight(lightmapUV)
                .setNormal(pose, 0.0F, 1.0F, 0.0F);
    }

    /**
     * Custom RenderState storing state-extracted visibility flag.
     */
    public static class DivineProjectileRenderState extends EntityRenderState {
        public boolean visible = true;
    }
}