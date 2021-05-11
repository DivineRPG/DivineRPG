package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import divinerpg.*;
import divinerpg.blocks.base.*;
import divinerpg.client.models.block.*;
import divinerpg.tiles.chests.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.util.*;
import net.minecraft.util.math.vector.*;

public class RenderBoneChest extends TileEntityRenderer<TileEntityBoneChest> {

    public RenderBoneChest(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(TileEntityBoneChest tile, float partialTick, MatrixStack matrix, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        //TODO - flip
        ModelBoneChest model = new ModelBoneChest();
        matrix.pushPose();
        if (!tile.isRemoved()) {
            matrix.translate(0.5D, 0.5D, 0.5D);
            matrix.mulPose(Vector3f.YP.rotationDegrees(-tile.getBlockState().getValue(BlockModChest.FACING).toYRot()));
            matrix.translate(-0.5D, -0.5D, -0.5D);
        }
        float lidAngle = tile.oOpenness + (tile.openness - tile.oOpenness) * partialTick;
        lidAngle = 1.0F - lidAngle;
        lidAngle = 1.0F - lidAngle * lidAngle * lidAngle;
        IVertexBuilder builder = buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(DivineRPG.MODID, "textures/model/bone_chest.png")));
        model.lid.xRot = -(lidAngle * ((float) Math.PI / 2F));
        model.handle.xRot = model.lid.xRot;
        model.renderToBuffer(matrix, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrix.popPose();
    }
}
