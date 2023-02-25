package divinerpg.client.renders.item;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Vector3f;
import divinerpg.DivineRPG;
import divinerpg.client.models.block.ModelParasectaAltar;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.ForgeRegistries;

public class RenderParasectaAltarItem extends BlockEntityWithoutLevelRenderer {
    private final ModelParasectaAltar<?> model;

    public RenderParasectaAltarItem(BlockEntityRenderDispatcher dispatcher, EntityModelSet set) {
        super(dispatcher, set);
        model = new ModelParasectaAltar<>(set.bakeLayer(ModelParasectaAltar.LAYER_LOCATION));
    }

    @Override
    public void renderByItem(ItemStack stack, ItemTransforms.TransformType transformType, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        super.renderByItem(stack, transformType, matrixStack, buffer, combinedLight, combinedOverlay);
        Item item = stack.getItem();
        if (item == ForgeRegistries.BLOCKS.getValue(new ResourceLocation(DivineRPG.MODID, "parasecta_altar")).asItem()) {
            matrixStack.pushPose();
            matrixStack.translate(0.5, -0.5, 0.5);
            matrixStack.mulPose(Vector3f.YP.rotationDegrees(270));
            VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(DivineRPG.MODID, "textures/model/parasecta_altar.png")));
            this.model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStack.popPose();
        }

    }

}
