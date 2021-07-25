package divinerpg.client.renders.item;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import divinerpg.*;
import divinerpg.client.models.block.*;
import divinerpg.registries.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.math.vector.*;

import java.util.concurrent.*;

public class RenderDramixAltarItem extends ItemStackTileEntityRenderer implements Callable<ItemStackTileEntityRenderer> {
    public final ItemStackTileEntityRenderer instance;

    private final ModelDramixAltar model = new ModelDramixAltar();

    public RenderDramixAltarItem() {
        instance = this;
    }

    @Override
    public void renderByItem(ItemStack stack, ItemCameraTransforms.TransformType transformType, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        super.renderByItem(stack, transformType, matrixStack, buffer, combinedLight, combinedOverlay);
        Item item = stack.getItem();
        if (item == Item.byBlock(BlockRegistry.dramixAltar)) {
            matrixStack.pushPose();
            matrixStack.translate(0.5, -0.5, 0.5);
            matrixStack.mulPose(Vector3f.YP.rotationDegrees(270));
            IVertexBuilder builder = buffer.getBuffer(RenderType.entityCutout(new ResourceLocation(DivineRPG.MODID, "textures/model/dramix_altar.png")));
            this.model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStack.popPose();
        }

    }

    @Override
    public ItemStackTileEntityRenderer call() throws Exception {
        return instance;
    }
}
