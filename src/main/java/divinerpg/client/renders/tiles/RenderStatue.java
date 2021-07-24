package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import divinerpg.blocks.arcana.*;
import divinerpg.tiles.bosses.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.util.math.vector.*;

public class RenderStatue extends TileEntityRenderer<TileEntityStatue> {

    public RenderStatue(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(TileEntityStatue te, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        EntityModel model = te.statueType.getModel();
        matrixStack.pushPose();
        matrixStack.translate(0.5D, 1.5D, 0.5D);
        matrixStack.mulPose(Vector3f.YP.rotationDegrees(-te.getBlockState().getValue(BlockDemonFurnace.FACING).toYRot()));
        matrixStack.mulPose(Vector3f.XP.rotationDegrees(180));
        IVertexBuilder builder = buffer.getBuffer(RenderType.entityCutout((te.statueType.getTexture())));
        model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.popPose();
    }


}
