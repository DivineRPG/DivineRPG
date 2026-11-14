package divinerpg.client.renders.block_entities;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.block_entities.block.AltarOfCorruptionBlockEntity;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.object.book.BookModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.client.renderer.blockentity.state.EnchantTableRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.sprite.*;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.EnchantingTableBlockEntity;
import net.minecraft.world.phys.*;
import org.jspecify.annotations.Nullable;

public class RenderAltarOfCorruption implements BlockEntityRenderer<AltarOfCorruptionBlockEntity, EnchantTableRenderState> {
    public static final Identifier TEXTURE_BOOK = Identifier.fromNamespaceAndPath(DivineRPG.MODID, "textures/model/altar_book.png");
    private final BookModel bookModel;

    public RenderAltarOfCorruption(BlockEntityRendererProvider.Context context) {
        bookModel = new BookModel(context.bakeLayer(ModelLayers.BOOK));
    }
    @Override
    public void extractRenderState(AltarOfCorruptionBlockEntity blockEntity, EnchantTableRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        state.flip = Mth.lerp(partialTicks, blockEntity.oFlip, blockEntity.flip);
        state.open = Mth.lerp(partialTicks, blockEntity.oOpen, blockEntity.open);
        state.time = (float)blockEntity.time + partialTicks;
        float or = blockEntity.rot - blockEntity.oRot;
        while(or >= (float)Math.PI) or -= ((float)Math.PI * 2F);
        while(or < -(float)Math.PI) or += ((float)Math.PI * 2F);
        state.yRot = blockEntity.oRot + or * partialTicks;
    }
    @Override
    public EnchantTableRenderState createRenderState() {
        return new EnchantTableRenderState();
    }
    public AABB getRenderBoundingBox(EnchantingTableBlockEntity blockEntity) {
        BlockPos pos = blockEntity.getBlockPos();
        return new AABB(pos.getX(), pos.getY(), pos.getZ(), pos.getX() + 1, pos.getY() + 1.5, pos.getZ() + 1);
    }
    @Override
    public void submit(EnchantTableRenderState state, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        poseStack.pushPose();
        poseStack.translate(.5F, .75F, .5F);
        poseStack.translate(0F, .1F + Mth.sin(state.time * .1) * .01F, 0F);
        float yRot = state.yRot;
        poseStack.rotate(Axis.YP, -yRot);
        poseStack.rotateDegrees(Axis.ZP, 80F);
        float ff1 = Mth.frac(state.flip + .25F) * 1.6F - .3F;
        float ff2 = Mth.frac(state.flip + .75F) * 1.6F - .3F;
        BookModel.State bookState = BookModel.State.forAnimation(state.time, Mth.clamp(ff1, 0F, 1F), Mth.clamp(ff2, 0F, 1F), state.open);
        submitNodeCollector.submitModel(bookModel, bookState, poseStack, bookModel.renderType(TEXTURE_BOOK), state.lightCoords, OverlayTexture.NO_OVERLAY, -1);
        if(state.breakProgress != null) submitNodeCollector.order(1).submitCrumblingOverlay(bookModel, bookState, poseStack, bookModel.renderType(TEXTURE_BOOK), state.lightCoords, OverlayTexture.NO_OVERLAY, -1, state.breakProgress);
        poseStack.popPose();
    }
}