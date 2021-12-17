package divinerpg.client.renders.item;

import com.mojang.blaze3d.matrix.*;
import com.mojang.blaze3d.vertex.*;
import divinerpg.blocks.base.*;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.item.*;
import net.minecraft.util.math.vector.*;
import net.minecraftforge.api.distmarker.*;

import java.util.concurrent.*;

@OnlyIn(Dist.CLIENT)
public class RenderItemStatue extends ItemStackTileEntityRenderer implements Callable<ItemStackTileEntityRenderer> {
    public final ItemStackTileEntityRenderer instance;

    public RenderItemStatue() {
        instance = this;
    }

    @Override
    public void renderByItem(ItemStack stack, ItemCameraTransforms.TransformType transformType, MatrixStack matrixStack, IRenderTypeBuffer renderType, int combinedLight, int combinedOverlay) {
            if(stack.getItem() instanceof BlockItem){
                Block block = ((BlockItem) stack.getItem()).getBlock();
                if(block instanceof BlockStatue){
                    EntityModel model = ((BlockStatue) block).statueType.getModel();
                    matrixStack.pushPose();
                    matrixStack.translate(0.5, 0.8, 0.5);
                    matrixStack.mulPose(Vector3f.YP.rotationDegrees(-90));
                    matrixStack.mulPose(Vector3f.XP.rotationDegrees(180));
                    matrixStack.scale(0.6F, 0.6F, 0.6F);
                    IVertexBuilder builder = renderType.getBuffer(RenderType.entityCutout(((BlockStatue) block).statueType.getTexture()));
                    model.renderToBuffer(matrixStack, builder, combinedLight, combinedOverlay, 1.0F, 1.0F, 1.0F, 1.0F);
                    matrixStack.popPose();
                }
            }
    }


    @Override
    public ItemStackTileEntityRenderer call() throws Exception {
        return instance;
    }
}
