package naturix.divinerpg.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderItemParasectaAltar {
	public void renderChestBrightness(Block blockIn, float color) {
		GlStateManager.color(color, color, color, 1.0F);
		GlStateManager.rotate(90.0F, 0.0F, 1.0F, 0.0F);
		ItemStack stack = new ItemStack(blockIn);
		stack.getItem().getTileEntityItemStackRenderer().renderByItem(stack);
	}
}