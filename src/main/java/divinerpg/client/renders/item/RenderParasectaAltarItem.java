package divinerpg.client.renders.item;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.client.models.block.ModelParasectaAltar;
import divinerpg.registries.BlockRegistry;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

public class RenderParasectaAltarItem extends BlockEntityWithoutLevelRenderer {
    private final ModelParasectaAltar<?> model;

    public RenderParasectaAltarItem(BlockEntityRenderDispatcher dispatcher, EntityModelSet set) {
        super(dispatcher, set);
        model = new ModelParasectaAltar<>(set.bakeLayer(ModelParasectaAltar.LAYER_LOCATION));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext context, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.renderByItem(stack, context, matrixStack, buffer, combinedLight, combinedOverlay);
        Item item = stack.getItem();
        if (item == BlockRegistry.parasectaAltar.asItem()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5, -0.5, 0.5);
            matrixStack.mulPose(Axis.YP.rotationDegrees(270));
            matrixStack.mulPose(Axis.YN.rotationDegrees(270));
            VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/model/parasecta_altar.png")));
            this.model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStack.popPose();
        }

    }

}
