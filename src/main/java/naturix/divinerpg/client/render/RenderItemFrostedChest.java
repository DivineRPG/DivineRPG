package naturix.divinerpg.client.render;

import naturix.divinerpg.objects.blocks.tile.entity.TileEntityFrostedChest;
import naturix.divinerpg.registry.ModBlocks;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class RenderItemFrostedChest extends TileEntityItemStackRenderer {

    @Override
    public void renderByItem(ItemStack itemStackIn, float partialTicks) {
        RenderHelper.enableStandardItemLighting();
        TileEntityRendererDispatcher.instance.render(new TileEntityFrostedChest(), 0.0D, 0.0D, 0.0D, 0.0F);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
    }
}
