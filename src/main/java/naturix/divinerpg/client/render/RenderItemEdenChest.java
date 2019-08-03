package naturix.divinerpg.client.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import naturix.divinerpg.objects.blocks.tile.entity.TileEntityEdenChest;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderItemEdenChest extends TileEntityItemStackRenderer {

    @Override
    public void renderByItem(ItemStack itemStackIn, float partialTicks) {
        RenderHelper.enableStandardItemLighting();
        TileEntityRendererDispatcher.instance.render(new TileEntityEdenChest(), 0.0D, 0.0D, 0.0D, 0.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
    }
}
