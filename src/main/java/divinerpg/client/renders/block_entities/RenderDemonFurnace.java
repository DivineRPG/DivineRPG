package divinerpg.client.renders.block_entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.block_entities.furnace.DemonFurnaceBlockEntity;
import divinerpg.client.models.block.ModelDemonFurnace;
import divinerpg.client.renders.state.FurnaceRenderState;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Unit;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

public class RenderDemonFurnace implements BlockEntityRenderer<DemonFurnaceBlockEntity, FurnaceRenderState> {
    private final Identifier
            off = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/model/demon_furnace.png"),
            on = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/model/demon_furnace_on.png");
    private final ModelDemonFurnace model;
    public RenderDemonFurnace(BlockEntityRendererProvider.Context context) {
        model = new ModelDemonFurnace(context.bakeLayer(ModelDemonFurnace.LAYER_LOCATION));
    }
    @Override
    public void extractRenderState(DemonFurnaceBlockEntity blockEntity, FurnaceRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        if(blockEntity.hasLevel()) {
            state.rotation = blockEntity.getBlockState().getValue(AbstractFurnaceBlock.FACING).toYRot();
            state.lit = blockEntity.isLit;
            int blockLight = blockEntity.getLevel().getBrightness(LightLayer.BLOCK, blockEntity.getBlockPos());
            int skyLight = blockEntity.getLevel().getBrightness(LightLayer.SKY, blockEntity.getBlockPos());
            state.lightCoords = (skyLight << 20) | (blockLight << 4);
        } else {
            state.rotation = 0F;
            state.lightCoords = 15728880;
        }
    }
    @Override
    public FurnaceRenderState createRenderState() {
        return new FurnaceRenderState();
    }
    @Override
    public void submit(FurnaceRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();
        poseStack.translate(0.5D, 0D, 0.5D);
        poseStack.rotate(Axis.YP.rotationDegrees(-state.rotation));
        submitNodeCollector.submitModel(model, Unit.INSTANCE, poseStack, model.renderType(state.lit ? on : off), state.lightCoords, OverlayTexture.NO_OVERLAY, -1, null, 0);
        if(state.breakProgress != null) submitNodeCollector.submitCrumblingOverlay(model, Unit.INSTANCE, poseStack, model.renderType(state.lit ? on : off), state.lightCoords, OverlayTexture.NO_OVERLAY, -1, state.breakProgress);
        poseStack.popPose();
    }
}