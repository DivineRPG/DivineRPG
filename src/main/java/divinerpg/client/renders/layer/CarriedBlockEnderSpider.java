package divinerpg.client.renders.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import divinerpg.client.models.vanilla.ModelEnderSpider;
import divinerpg.entities.vanilla.end.EntityEnderSpider;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.OnlyIn;

import static net.minecraft.client.renderer.texture.OverlayTexture.NO_OVERLAY;
import static net.neoforged.api.distmarker.Dist.CLIENT;

@OnlyIn(CLIENT)
public class CarriedBlockEnderSpider extends RenderLayer<EntityEnderSpider, ModelEnderSpider> {
    private final BlockRenderDispatcher blockRenderer;
    public CarriedBlockEnderSpider(RenderLayerParent<EntityEnderSpider, ModelEnderSpider> renderer, BlockRenderDispatcher blockRenderer) {
        super(renderer);
        this.blockRenderer = blockRenderer;
    }
    @SuppressWarnings("deprecation")
    @Override public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, EntityEnderSpider livingEntity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        BlockState blockstate = livingEntity.getCarriedBlock();
        if(blockstate != null) {
            poseStack.pushPose();
            getParentModel().head.translateAndRotate(poseStack);
            poseStack.mulPose(Axis.XP.rotationDegrees(20));
            poseStack.translate(.178, .25, -.6875);
            poseStack.mulPose(Axis.YP.rotationDegrees(45));
            float f = .25F;
            poseStack.scale(-f, -f, f);
            poseStack.mulPose(Axis.YP.rotationDegrees(90));
            blockRenderer.renderSingleBlock(blockstate, poseStack, buffer, packedLight, NO_OVERLAY);
            poseStack.popPose();
        }
    }
}