package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import divinerpg.tiles.bosses.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.texture.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.state.*;

public class RenderStatue extends TileEntityRenderer<TileEntityStatue> {
    public static final DirectionProperty FACING = HorizontalBlock.FACING;
    public static final int[] facingToRotation = new int[] { 0, 270, 180, 90 };

    public RenderStatue(TileEntityRendererDispatcher dispatcher) {
        super(dispatcher);

    }

    @Override
    public void render(TileEntityStatue te, float partialTicks, MatrixStack matrix, IRenderTypeBuffer buffer, int combinedLightIn, int combinedOverlayIn) {
        EntityModel model = te.statueType.getModel();
        RenderMaterial material = new RenderMaterial(AtlasTexture.LOCATION_BLOCKS, te.statueType.getTexture());
        matrix.pushPose();
        matrix.translate(0.5f, 0, 0.5f);

        float scale = 0.5F;

        matrix.translate(0, -0.1, 0);
        matrix.scale(scale, scale, scale);
        matrix.translate(0, (1 / scale), 0);
        IVertexBuilder builder = material.buffer(buffer, RenderType::entitySolid);
        model.renderToBuffer(matrix, builder,  0, 0, 0, 0, 0, 0);

        matrix.popPose();
    }
}
