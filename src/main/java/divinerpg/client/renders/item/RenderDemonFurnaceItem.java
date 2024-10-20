package divinerpg.client.renders.item;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.client.models.block.ModelDemonFurnace;
import divinerpg.registries.BlockRegistry;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;

public class RenderDemonFurnaceItem extends BlockEntityWithoutLevelRenderer {
    private final ModelDemonFurnace<?> model;

    public RenderDemonFurnaceItem(BlockEntityRenderDispatcher dispatcher, EntityModelSet set) {
        super(dispatcher, set);
        model = new ModelDemonFurnace<>(set.bakeLayer(ModelDemonFurnace.LAYER_LOCATION));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemDisplayContext context, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.renderByItem(stack, context, matrixStack, buffer, combinedLight, combinedOverlay);
        Item item = stack.getItem();
        if (item == BlockRegistry.demonFurnace.asItem()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5, 0.5, 0.5);
            matrixStack.mulPose(Axis.YP.rotationDegrees(270));
            matrixStack.mulPose(Axis.YN.rotationDegrees(270));
            VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/model/demon_furnace.png")));
            this.model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay);
            matrixStack.popPose();
        }

    }

}
