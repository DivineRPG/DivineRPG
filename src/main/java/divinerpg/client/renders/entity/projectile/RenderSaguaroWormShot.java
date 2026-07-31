package divinerpg.client.renders.entity.projectile;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.client.models.vanilla.ModelSaguaroWormShot;
import divinerpg.entities.projectile.bullet.EntitySaguaroWormShot;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;

import static divinerpg.DivineRPG.MODID;

public class RenderSaguaroWormShot extends EntityRenderer<EntitySaguaroWormShot, EntityRenderState> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MODID, "textures/projectiles/saguaro_worm_shot.png");
    private final ModelSaguaroWormShot model;
    private final RenderType renderType;

    public RenderSaguaroWormShot(EntityRendererProvider.Context context) {
        super(context);
        this.model = new ModelSaguaroWormShot(context);
        this.renderType = RenderTypes.entityCutout(TEXTURE);
    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }

    @Override
    public void extractRenderState(EntitySaguaroWormShot entity, EntityRenderState state, float partialTicks) {
        super.extractRenderState(entity, state, partialTicks);
    }

    @Override
    public void submit(EntityRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        super.submit(state, poseStack, submitNodeCollector, camera);

        poseStack.pushPose();

        submitNodeCollector.submitCustomGeometry(
                poseStack,
                this.renderType,
                (pose, vertexBuilder) -> {
                    this.model.setupAnim(state);
                    this.model.renderToBuffer(poseStack, vertexBuilder, state.lightCoords, OverlayTexture.NO_OVERLAY, 1);
                }
        );

        poseStack.popPose();
    }
}