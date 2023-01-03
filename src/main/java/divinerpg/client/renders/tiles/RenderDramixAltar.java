package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.vertex.*;
import divinerpg.*;
import divinerpg.client.models.block.*;
import divinerpg.tiles.bosses.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;

import net.minecraft.resources.ResourceLocation;

public class RenderDramixAltar implements BlockEntityRenderer<TileEntityDramixAltar> {
    private ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/model/dramix_altar.png");
    private final ModelDramixAltar<?> model;
    public RenderDramixAltar(BlockEntityRendererProvider.Context context) {
        model = new ModelDramixAltar<>(context.bakeLayer(ModelDramixAltar.LAYER_LOCATION));
    }

    @Override
    public void render(TileEntityDramixAltar te, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {

        matrixStack.pushPose();
        matrixStack.translate(0.5D, -0.625D, 0.5D);
        VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(TEXTURE));
        model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.popPose();
    }
}
