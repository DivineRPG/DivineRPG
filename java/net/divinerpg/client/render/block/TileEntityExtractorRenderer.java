package net.divinerpg.client.render.block;

import org.lwjgl.opengl.GL11;

import net.divinerpg.client.render.block.model.ModelExtractor;
import net.divinerpg.libs.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityExtractorRenderer extends TileEntitySpecialRenderer {

	private ModelExtractor model;
	
	public TileEntityExtractorRenderer() {
		model = new ModelExtractor();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity var1, double x, double y, double z, float var8) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.PREFIX + "textures/model/extractor.png"));
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5F, (float)y, (float)z + 0.5F);
        model.render(0.0625F);
        GL11.glPopMatrix();
	}
}