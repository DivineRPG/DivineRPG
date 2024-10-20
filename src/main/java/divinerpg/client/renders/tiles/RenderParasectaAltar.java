package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.vertex.*;
import divinerpg.*;
import divinerpg.client.models.block.*;
import divinerpg.block_entities.bosses.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.resources.*;

public class RenderParasectaAltar implements BlockEntityRenderer<ParasectaAltarBlockEntity> {
    private ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/model/parasecta_altar.png");
    private final ModelParasectaAltar<?> model;
    public RenderParasectaAltar(BlockEntityRendererProvider.Context context) {
        model = new ModelParasectaAltar<>(context.bakeLayer(ModelParasectaAltar.LAYER_LOCATION));
    }

    @Override
    public void render(ParasectaAltarBlockEntity te, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {

        matrixStack.pushPose();
        matrixStack.translate(0.5D, -0.625D, 0.5D);
        VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(TEXTURE));
        model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay);
        matrixStack.popPose();
    }
}