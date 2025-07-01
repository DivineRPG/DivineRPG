package divinerpg.client.renders.item;

import com.mojang.blaze3d.vertex.*;
import divinerpg.items.base.ItemDivineShield;
import net.minecraft.client.model.ShieldModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.world.item.*;

import static net.minecraft.client.model.geom.ModelLayers.SHIELD;

public class DivineShieldRenderer extends BlockEntityWithoutLevelRenderer {
    private final ShieldModel model;
    public DivineShieldRenderer(BlockEntityRenderDispatcher dispatcher, EntityModelSet set) {
        super(dispatcher, set);
        model = new ShieldModel(set.bakeLayer(SHIELD));
    }
    @Override public void renderByItem(ItemStack stack, ItemDisplayContext context, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.renderByItem(stack, context, matrixStack, buffer, combinedLight, combinedOverlay);
        Item item = stack.getItem();
        if(item instanceof ItemDivineShield) {
            matrixStack.pushPose();
            matrixStack.scale(1, -1, -1);
            VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(((ItemDivineShield)item).resource));
            model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay);
            matrixStack.popPose();
        }
    }
}