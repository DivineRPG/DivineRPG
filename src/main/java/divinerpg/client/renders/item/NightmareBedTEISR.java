package divinerpg.client.renders.item;

import com.mojang.blaze3d.matrix.MatrixStack;
import divinerpg.blocks.vethea.BlockNightmareBed;
import divinerpg.registries.TileRegistry;
import divinerpg.tiles.TileEntityNightmareBed;
import net.minecraft.block.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.item.*;
import net.minecraft.tileentity.*;

public class NightmareBedTEISR extends ItemStackTileEntityRenderer {
    public static final ItemStackTileEntityRenderer instance = new ItemStackTileEntityRenderer();
    private final TileEntityNightmareBed bed = new TileEntityNightmareBed(TileRegistry.NIGHTMARE_BED);

    public void func_239207_a_(ItemStack stack, ItemCameraTransforms.TransformType p_239207_2_, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        Item item = stack.getItem();
        if (item instanceof BlockItem) {
            Block block = ((BlockItem) item).getBlock();
                TileEntity tileentity = null;
                if (block instanceof BlockNightmareBed) {
                    tileentity = this.bed;
                }
                TileEntityRendererDispatcher.instance.renderItem(tileentity, matrixStack, buffer, combinedLight, combinedOverlay);
        }
    }
}
