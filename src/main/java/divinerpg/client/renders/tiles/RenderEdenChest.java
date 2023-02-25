package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.*;
import divinerpg.*;
import divinerpg.blocks.base.*;
import divinerpg.client.models.block.*;
import divinerpg.tiles.chests.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.resources.*;

public class RenderEdenChest implements BlockEntityRenderer<TileEntityEdenChest> {
    private final ModelEdenChest<?> model;
    public RenderEdenChest(BlockEntityRendererProvider.Context context) {
        model = new ModelEdenChest<>(context.bakeLayer(ModelEdenChest.LAYER_LOCATION));
    }

    @Override
    public void render(TileEntityEdenChest tile, float partialTick, PoseStack matrix, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        matrix.pushPose();
        if (!tile.isRemoved()) {
            matrix.translate(0.5D, 0.5D, 0.5D);
            matrix.mulPose(Vector3f.YP.rotationDegrees(-tile.getBlockState().getValue(BlockModChest.FACING).toYRot()));
            matrix.mulPose(Vector3f.XN.rotationDegrees(180));
            matrix.translate(-0.5D, -0.5D, -0.5D);
        }
        float lidAngle = tile.getOpenNess(1F);
        lidAngle = 1.0F - lidAngle;
        lidAngle = 1.0F - lidAngle * lidAngle * lidAngle;
        VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(DivineRPG.MODID, "textures/model/eden_chest.png")));
        model.lid.xRot = -(lidAngle * ((float) Math.PI / 2F));
        model.chestKnobLeft.xRot = model.lid.xRot;
        model.chestKnobMiddle.xRot = model.lid.xRot;
        model.chestKnobRight.xRot = model.lid.xRot;
        model.renderToBuffer(matrix, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrix.popPose();
    }
}
