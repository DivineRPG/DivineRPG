package naturix.divinerpg.registry;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModRenders {

	@SideOnly(Side.CLIENT)
	public static void renderItem(ItemStack stack, double x, double y, double z, float scale) {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		if(stack != null) {
			GL11.glTranslated(x, y, z);
			scale(scale);
		    //FIXME
			//renderItem.renderItemModelForEntity(stack, null, null);
		}
	}
	public static void scale(float scale) {
		GL11.glScalef(scale, scale, scale);
	}
}
