package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import divinerpg.*;
import divinerpg.blocks.arcana.*;
import divinerpg.client.models.block.*;
import divinerpg.tiles.furnace.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.state.properties.*;
import net.minecraft.util.*;
import net.minecraft.util.math.vector.*;

public class RenderDemonFurnace extends TileEntityRenderer<TileEntityDemonFurnace> {
    private ResourceLocation off = new ResourceLocation(DivineRPG.MODID, "textures/model/demon_furnace.png");
    private ResourceLocation on = new ResourceLocation(DivineRPG.MODID, "textures/model/demon_furnace_on.png");

    public RenderDemonFurnace(TileEntityRendererDispatcher p_i226006_1_) {
        super(p_i226006_1_);
    }

    @Override
    public void render(TileEntityDemonFurnace te, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        EntityModel model = new ModelDemonFurnace();

        matrixStack.pushPose();
        matrixStack.translate(0.5D, 0.5D, 0.5D);
        matrixStack.mulPose(Vector3f.YP.rotationDegrees(te.getBlockState().getValue(BlockDemonFurnace.FACING).toYRot()));
        IVertexBuilder builder = buffer.getBuffer(RenderType.entityCutout(te.getBlockState().getValue(BlockStateProperties.LIT).booleanValue()? off : on));
        model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.popPose();
    }
}
