package divinerpg.client.renders.block_entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.block_entities.furnace.ArcaniumExtractorBlockEntity;
import divinerpg.blocks.arcana.ArcaniumExtractor;
import divinerpg.client.models.block.ModelArcaniumExtractor;
import divinerpg.client.renders.state.RotationalRenderState;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Unit;
import net.minecraft.world.phys.*;

public class RenderArcaniumExtractor implements BlockEntityRenderer<ArcaniumExtractorBlockEntity, RotationalRenderState> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/model/arcanium_extractor.png");
    private final ModelArcaniumExtractor model;

    public RenderArcaniumExtractor(BlockEntityRendererProvider.Context context) {
        this.model = new ModelArcaniumExtractor(context.bakeLayer(ModelArcaniumExtractor.LAYER_LOCATION));
    }
    @Override
    public RotationalRenderState createRenderState() {
        return new RotationalRenderState();
    }
    @Override
    public void extractRenderState(ArcaniumExtractorBlockEntity blockEntity, RotationalRenderState state, float partialTick, Vec3 cameraPosition, ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTick, cameraPosition, breakProgress);
        state.rotation = blockEntity.hasLevel() ? blockEntity.getBlockState().getValue(ArcaniumExtractor.FACING).toYRot() : 0;
    }
    @Override
    public void submit(RotationalRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 0D, 0.5D);
        poseStack.rotate(Axis.YP.rotationDegrees(-state.rotation));
        submitNodeCollector.submitModel(model, Unit.INSTANCE, poseStack, model.renderType(TEXTURE), state.lightCoords, OverlayTexture.NO_OVERLAY, -1, null, 0);
        poseStack.popPose();
    }
    @Override
    public AABB getRenderBoundingBox(ArcaniumExtractorBlockEntity blockEntity) {
        BlockPos p = blockEntity.getBlockPos();
        return new AABB(p.getX(), p.getY(), p.getZ(), p.getX() + 1, p.getY() + 2, p.getZ() + 1);
    }
}