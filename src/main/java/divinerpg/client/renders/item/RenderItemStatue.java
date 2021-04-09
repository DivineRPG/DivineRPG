package divinerpg.client.renders.item;

import com.mojang.blaze3d.matrix.*;
import divinerpg.blocks.base.*;
import divinerpg.tiles.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.item.*;
import net.minecraftforge.api.distmarker.*;
import org.lwjgl.opengl.*;

import java.util.concurrent.*;

@OnlyIn(Dist.CLIENT)
public class RenderItemStatue extends ItemStackTileEntityRenderer implements Callable<ItemStackTileEntityRenderer> {
    public final ItemStackTileEntityRenderer instance;

    public RenderItemStatue() {
        instance = this;
    }

    @Override
    public void renderByItem(ItemStack stack, ItemCameraTransforms.TransformType transformType, MatrixStack matrixStack, IRenderTypeBuffer renderType, int p_239207_5_, int p_239207_6_) {
        BlockStatue blockStatue = (BlockStatue) (((BlockItem) stack.getItem()).getBlock());
        RenderHelper.setupFor3DItems();
        TileEntityRendererDispatcher.instance.render(new TileEntityStatue(blockStatue.statueType), 0.0F, matrixStack, renderType);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
    }


    @Override
    public ItemStackTileEntityRenderer call() throws Exception {
        return instance;
    }
}
