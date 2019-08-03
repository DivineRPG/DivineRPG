package naturix.divinerpg.client.render;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import naturix.divinerpg.objects.blocks.BlockStatue;
import naturix.divinerpg.objects.blocks.tile.entity.TileEntityStatue;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderItemStatue extends TileEntityItemStackRenderer {

    @Override
    public void renderByItem(ItemStack itemStackIn, float partialTicks) {
        BlockStatue blockStatue = (BlockStatue) (((ItemBlock) itemStackIn.getItem()).getBlock());
        RenderHelper.enableStandardItemLighting();
        TileEntityRendererDispatcher.instance.render(new TileEntityStatue(blockStatue.statueType), 0.0D, 0.0D, 0.0D,
                0.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
    }
}
