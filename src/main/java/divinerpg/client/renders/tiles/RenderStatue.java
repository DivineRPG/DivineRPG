package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import divinerpg.tiles.bosses.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.state.properties.*;
import net.minecraft.util.math.vector.*;

public class RenderStatue extends TileEntityRenderer<TileEntityStatue> {

    public RenderStatue(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);
    }

    @Override
    public void render(TileEntityStatue te, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        EntityModel model = te.statueType.getModel();
        matrixStack.pushPose();
        float scale = 0.5F;
        matrixStack.translate(0.75F, 0.75F, 0.0F);
        matrixStack.scale(scale, scale, scale);
        matrixStack.mulPose(Vector3f.YN.rotationDegrees(te.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot()));
        matrixStack.mulPose(Vector3f.XN.rotationDegrees(180));
        matrixStack.translate(-0.75F, -0.75F, 0.0F);
        IVertexBuilder builder = buffer.getBuffer(RenderType.entityCutout((te.statueType.getTexture())));
        model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.popPose();
    }


}
