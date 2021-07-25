package divinerpg.client.renders.tiles;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import divinerpg.*;
import divinerpg.client.models.block.*;
import divinerpg.tiles.bosses.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.util.*;

public class RenderDramixAltar extends TileEntityRenderer<TileEntityDramixAltar> {
    private ResourceLocation TEXTURE = new ResourceLocation(DivineRPG.MODID, "textures/model/dramix_altar.png");

    public RenderDramixAltar(TileEntityRendererDispatcher p_i226006_1_) {
        super(p_i226006_1_);
    }

    @Override
    public void render(TileEntityDramixAltar te, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        Model model = new ModelDramixAltar();

        matrixStack.pushPose();
        matrixStack.translate(0.5D, -0.625D, 0.5D);
        IVertexBuilder builder = buffer.getBuffer(RenderType.entityCutout(TEXTURE));
        model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
        matrixStack.popPose();
    }
}
