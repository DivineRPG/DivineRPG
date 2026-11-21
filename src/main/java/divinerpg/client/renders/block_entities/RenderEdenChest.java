package divinerpg.client.renders.block_entities;

import com.mojang.blaze3d.vertex.PoseStack;
import divinerpg.DivineRPG;
import divinerpg.block_entities.chest.EdenChestBlockEntity;
import divinerpg.client.models.block.ModelEdenChest;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.blockentity.state.ChestRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.phys.Vec3;
import org.jspecify.annotations.Nullable;

import static divinerpg.utils.Utils.createLocation;
import static net.minecraft.client.renderer.blockentity.ChestRenderer.modelTransformation;

public class RenderEdenChest implements BlockEntityRenderer<EdenChestBlockEntity, ChestRenderState> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/model/eden_chest.png");
    public static final ModelLayerLocation LAYER_LOCATION = createLocation("eden_chest");
    private final ModelEdenChest model;
    public RenderEdenChest(BlockEntityRendererProvider.Context context) {
        model = new ModelEdenChest(context.bakeLayer(LAYER_LOCATION));
    }
    @Override
    public void extractRenderState(EdenChestBlockEntity blockEntity, ChestRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        boolean hasLevel = blockEntity.getLevel() != null;
        state.facing = hasLevel ? blockEntity.getBlockState().getValue(ChestBlock.FACING) : Direction.SOUTH;
        state.open = hasLevel ? blockEntity.getOpenNess(partialTicks) : 0;
    }
    @Override
    public void submit(ChestRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState camera) {
        poseStack.pushPose();
        poseStack.mulPose(modelTransformation(state.facing));
        poseStack.scale(1.0F, -1.0F, 1.0F);
        poseStack.translate(0.0F, -1.0F, 0.0F);
        float open = state.open;
        open = 1F - open;
        open = 1F - open * open * open;
        submitNodeCollector.submitModel(model, open, poseStack, model.renderType(TEXTURE), state.lightCoords, OverlayTexture.NO_OVERLAY, -1, null, 0);
        if (state.breakProgress != null) {
            submitNodeCollector.order(1).submitCrumblingOverlay(model, open, poseStack, model.renderType(TEXTURE), state.lightCoords, OverlayTexture.NO_OVERLAY, -1, state.breakProgress);
        }
        poseStack.popPose();
    }
    @Override
    public ChestRenderState createRenderState() {
        return new ChestRenderState();
    }
}