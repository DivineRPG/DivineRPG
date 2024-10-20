package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Axis;
import divinerpg.DivineRPG;
import divinerpg.blocks.base.BlockModChest;
import divinerpg.client.models.block.ModelEdenChest;
import divinerpg.block_entities.chests.EdenChestBlockEntity;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.blockentity.*;
import net.minecraft.resources.ResourceLocation;

public class RenderEdenChest implements BlockEntityRenderer<EdenChestBlockEntity> {
    private final ModelEdenChest<?> model;
    public RenderEdenChest(BlockEntityRendererProvider.Context context) {
        model = new ModelEdenChest<>(context.bakeLayer(ModelEdenChest.LAYER_LOCATION));
    }

    @Override
    public void render(EdenChestBlockEntity tile, float partialTick, PoseStack matrix, MultiBufferSource buffer, int combinedLight, int combinedOverlay) {
        matrix.pushPose();
        matrix.translate(0.5D, 0.5D, 0.5D);
        matrix.mulPose(Axis.YP.rotationDegrees(-tile.getBlockState().getValue(BlockModChest.FACING).toYRot()));
        matrix.mulPose(Axis.XN.rotationDegrees(180));
        matrix.translate(-0.5D, -0.5D, -0.5D);

        float lidAngle = tile.getOpenNess(partialTick);
        lidAngle = 1.0F - lidAngle;
        lidAngle = 1.0F - lidAngle * lidAngle * lidAngle;
        VertexConsumer builder = buffer.getBuffer(RenderType.entityCutout(ResourceLocation.fromNamespaceAndPath(DivineRPG.MODID, "textures/model/eden_chest.png")));
        model.lid.xRot = -(lidAngle * ((float) Math.PI / 2F));
        model.chestKnobLeft.xRot = model.lid.xRot;
        model.chestKnobMiddle.xRot = model.lid.xRot;
        model.chestKnobRight.xRot = model.lid.xRot;
        model.renderToBuffer(matrix, builder, combinedLight, combinedOverlay);
        matrix.popPose();
    }
}