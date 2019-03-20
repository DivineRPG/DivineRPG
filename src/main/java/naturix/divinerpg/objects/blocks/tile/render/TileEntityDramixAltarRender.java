package naturix.divinerpg.objects.blocks.tile.render;

import org.lwjgl.opengl.GL11;

import naturix.divinerpg.objects.blocks.tile.model.DramixAltarModel;
import naturix.divinerpg.utils.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityDramixAltarRender extends TileEntitySpecialRenderer {

	private DramixAltarModel model;

	public TileEntityDramixAltarRender() {
		model = new DramixAltarModel();
	}

	@Override
	public void render(TileEntity te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {	
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.MODID + ":textures/model/altar_dramix.png"));
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y - 0.6F, (float)z + 0.5F);
		model.render(0.0625F);
		GL11.glPopMatrix();
	}

}