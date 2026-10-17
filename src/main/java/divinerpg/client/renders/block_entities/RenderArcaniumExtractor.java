package divinerpg.client.renders.block_entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.logging.LogUtils;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.block_entities.furnace.ArcaniumExtractorBlockEntity;
import divinerpg.blocks.arcana.BlockArcaniumExtractor;
import divinerpg.client.models.block.ModelArcaniumExtractor;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Unit;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.phys.Vec3;

public class RenderArcaniumExtractor implements BlockEntityRenderer<ArcaniumExtractorBlockEntity, RenderArcaniumExtractor.ArcaniumExtractorRenderState> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/model/arcanium_extractor.png");
    private final ModelArcaniumExtractor model;

    public RenderArcaniumExtractor(BlockEntityRendererProvider.Context context) {
        this.model = new ModelArcaniumExtractor(context.bakeLayer(ModelArcaniumExtractor.LAYER_LOCATION));
    }

    @Override
    public ArcaniumExtractorRenderState createRenderState() {
        return new ArcaniumExtractorRenderState();
    }

    @Override
    public void extractRenderState(ArcaniumExtractorBlockEntity blockEntity, ArcaniumExtractorRenderState state, float partialTick, Vec3 cameraPosition, ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTick, cameraPosition, breakProgress);
        if (blockEntity != null && blockEntity.hasLevel()) {
            state.rotation = blockEntity.getBlockState().getValue(BlockArcaniumExtractor.FACING).toYRot();
            int blockLight = blockEntity.getLevel().getBrightness(LightLayer.BLOCK, blockEntity.getBlockPos());
            int skyLight = blockEntity.getLevel().getBrightness(LightLayer.SKY, blockEntity.getBlockPos());
            state.lightCoords = (skyLight << 20) | (blockLight << 4);
        } else {
            state.rotation = 0.0F;
            state.lightCoords = 15728880;
        }
    }

    @Override
    public void submit(ArcaniumExtractorRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 0D, 0.5D);
        poseStack.rotate(Axis.YP.rotationDegrees(-state.rotation));
        submitNodeCollector.submitModel(model, Unit.INSTANCE, poseStack, model.renderType(TEXTURE), state.lightCoords, OverlayTexture.NO_OVERLAY, -1, null, 0);
        poseStack.popPose();
    }

    public static class ArcaniumExtractorRenderState extends BlockEntityRenderState {
        public float rotation;
    }
}