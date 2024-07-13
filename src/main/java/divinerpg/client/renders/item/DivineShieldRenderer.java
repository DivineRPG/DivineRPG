package divinerpg.client.renders.item;

import com.mojang.blaze3d.vertex.*;
import divinerpg.items.base.DivineShield;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.item.*;

public class DivineShieldRenderer extends BlockEntityWithoutLevelRenderer {
    private final ShieldModel model;

    public DivineShieldRenderer(BlockEntityRenderDispatcher dispatcher, EntityModelSet set) {
        super(dispatcher, set);
        model = new ShieldModel(set.bakeLayer(ModelLayers.SHIELD));
    }


    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext context, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.renderByItem(stack, context, matrixStack, buffer, combinedLight, combinedOverlay);
        Item item = stack.getItem();

        if (item instanceof DivineShield) {
            matrixStack.pushPose();
            matrixStack.scale(1.0F, -1.0F, -1.0F);
            VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(((DivineShield) item).resource));
            this.model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1);
            matrixStack.popPose();
        }

    }

}
