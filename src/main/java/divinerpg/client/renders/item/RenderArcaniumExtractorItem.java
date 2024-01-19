package divinerpg.client.renders.item;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.client.models.block.ModelArcaniumExtractor;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

public class RenderArcaniumExtractorItem extends BlockEntityWithoutLevelRenderer {
    private final ModelArcaniumExtractor<?> model;

    public RenderArcaniumExtractorItem(BlockEntityRenderDispatcher dispatcher, EntityModelSet set) {
        super(dispatcher, set);
        model = new ModelArcaniumExtractor<>(set.bakeLayer(ModelArcaniumExtractor.LAYER_LOCATION));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext context, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.renderByItem(stack, context, matrixStack, buffer, combinedLight, combinedOverlay);
        Item item = stack.getItem();
        if (item == BuiltInRegistries.BLOCK.get(new ResourceLocation(DivineRPG.MODID, "arcanium_extractor")).asItem()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5, 0, 0.5);
            matrixStack.mulPose(Axis.YP.rotationDegrees(270));
            matrixStack.mulPose(Axis.YN.rotationDegrees(270));
            VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(DivineRPG.MODID, "textures/model/arcanium_extractor.png")));
            this.model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStack.popPose();
        }
    }

}
