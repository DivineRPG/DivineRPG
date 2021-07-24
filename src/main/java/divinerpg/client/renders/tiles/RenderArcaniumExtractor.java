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
import net.minecraft.util.*;
import net.minecraft.util.math.vector.*;

public class RenderArcaniumExtractor extends TileEntityRenderer<TileEntityArcaniumExtractor> {
    private ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/model/arcanium_extractor.png");

    public RenderArcaniumExtractor(TileEntityRendererDispatcher p_i226006_1_) {
        super(p_i226006_1_);
    }

    @Override
    public void render(TileEntityArcaniumExtractor te, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        EntityModel model = new ModelArcaniumExtractor();

        matrixStack.pushPose();
        matrixStack.translate(0.5D, 0D, 0.5D);
        matrixStack.mulPose(Vector3f.YP.rotationDegrees(te.getBlockState().getValue(BlockDemonFurnace.FACING).toYRot()));
        IVertexBuilder builder = buffer.getBuffer(RenderType.entityCutout(TEXTURE));
        model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.popPose();
    }
}
