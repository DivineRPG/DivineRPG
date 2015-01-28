package net.divinerpg.client.render.block;

import net.divinerpg.blocks.iceika.tileentity.TileEntityPresentBox;
import net.divinerpg.client.render.block.model.ModelEdenChest;
import net.divinerpg.client.render.block.model.ModelPresentBox;
import net.divinerpg.libs.Reference;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class RenderPresentBox extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(Reference.PREFIX + "textures/model/presentBox.png");
	private ModelPresentBox model;

	public RenderPresentBox() {
		model = new ModelPresentBox();
	}

	public void render(TileEntityPresentBox entity, double x, double y, double z, float f) {
		model = new ModelPresentBox();//TODO: remove
		int i;
		
		if (!entity.hasWorldObj()) {
			i = 0;
		}
		else {
			i = entity.getBlockMetadata();
		}

		this.bindTexture(texture);

		GL11.glPushMatrix();
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glTranslatef((float)x, (float)y + 1.0F, (float)z + 1.0F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		short rotation = 0;

		if (i == 2) {
			rotation = 180;
		}

		if (i == 3) {
			rotation = 0;
		}

		if (i == 4) {
			rotation = 90;
		}

		if (i == 5) {
			rotation = -90;
		}

		GL11.glRotatef((float)rotation, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		float f1 = entity.prevLidAngle + (entity.lidAngle - entity.prevLidAngle) * f;
		float f2;

		f1 = 1.0F - f1;
		f1 = 1.0F - f1 * f1 * f1;
		model.lid.rotateAngleX = -(f1 * (float)Math.PI / 2.0F);
		model.renderAll();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}


	@Override
	public void renderTileEntityAt(TileEntity var1, double x, double y, double z, float f) {
		this.render((TileEntityPresentBox)var1, x, y, z, f);
	}
}