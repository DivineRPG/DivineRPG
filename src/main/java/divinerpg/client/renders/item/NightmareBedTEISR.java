package divinerpg.client.renders.item;

import com.mojang.blaze3d.matrix.*;
import divinerpg.registries.*;
import divinerpg.tiles.*;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.renderer.tileentity.*;
import net.minecraft.item.*;

import java.util.concurrent.*;

public class NightmareBedTEISR extends ItemStackTileEntityRenderer implements Callable<ItemStackTileEntityRenderer> {
    public static final ItemStackTileEntityRenderer instance = new ItemStackTileEntityRenderer();
    private final TileEntityNightmareBed bed = new TileEntityNightmareBed(TileRegistry.NIGHTMARE_BED);

    public void renderByItem(ItemStack stack, ItemCameraTransforms.TransformType p_239207_2_, MatrixStack matrixStack, IRenderTypeBuffer buffer, int combinedLight, int combinedOverlay) {
        //TODO - render bed teisr
        TileEntityRendererDispatcher.instance.renderItem(bed, matrixStack, buffer, combinedLight, combinedOverlay);
    }

    @Override
    public ItemStackTileEntityRenderer call() throws Exception {
        return instance;
    }
}
