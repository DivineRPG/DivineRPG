package naturix.divinerpg.client.render;

import naturix.divinerpg.objects.blocks.tile.block.TileEntityFrostedChest;
import naturix.divinerpg.objects.blocks.tile.block.TileEntityPresentBox;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class RenderItemPresentBox extends TileEntityItemStackRenderer {

    @Override
    public void renderByItem(ItemStack itemStackIn, float partialTicks) {
        RenderHelper.enableStandardItemLighting();
        TileEntityRendererDispatcher.instance.render(new TileEntityPresentBox(), 0.0D, 0.0D, 0.0D, 0.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
    }
}
