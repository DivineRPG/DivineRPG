package divinerpg.client.renders.item;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.client.models.block.ModelPresentBox;
import divinerpg.registries.BlockRegistry;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

public class RenderPresentBoxItem extends BlockEntityWithoutLevelRenderer {
    private final ModelPresentBox<?> model;

    public RenderPresentBoxItem(BlockEntityRenderDispatcher dispatcher, EntityModelSet set) {
        super(dispatcher, set);
        model = new ModelPresentBox<>(set.bakeLayer(ModelPresentBox.LAYER_LOCATION));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext context, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.renderByItem(stack, context, matrixStack, buffer, combinedLight, combinedOverlay);
        Item item = stack.getItem();
        if (item == BlockRegistry.presentBox.asItem()) {
            matrixStack.pushPose();
            matrixStack.translate(0.0, 1.0, 0.0);
            matrixStack.mulPose(Axis.YP.rotationDegrees(-90));
            matrixStack.mulPose(Axis.XP.rotationDegrees(180));
            VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(DivineRPG.MODID, "textures/model/present_box.png")));
            this.model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStack.popPose();
        }

    }

}
