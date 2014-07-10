package net.divinerpg.client.render.block;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.divinerpg.blocks.iceika.container.tile_entity.TileEntityFrostedChest;
import net.divinerpg.libs.Reference;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderTileEntityFrostedChest extends TileEntitySpecialRenderer {

	private static final ResourceLocation texture = new ResourceLocation(Reference.PREFIX + "textures/model/iceikaChest.png");
	private ModelChest model;

	public RenderTileEntityFrostedChest() {
		model = new ModelChest();
	}

	public void render(TileEntityFrostedChest entity, double x, double y, double z, float f) {
		
		int i;
		
		if (!entity.hasWorldObj()) {
			i = 0;
		}
		else {
			i = entity.getBlockMetadata();
		}

		if (entity.adjacentChestZNeg == null && entity.adjacentChestXNeg == null) {
			if (entity.adjacentChestXPos == null && entity.adjacentChestZPos == null) {
				this.bindTexture(texture);
			}
		}

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

		if (i == 2 && entity.adjacentChestXPos != null) {
			GL11.glTranslatef(1.0F, 0.0F, 0.0F);
		}

		if (i == 5 && entity.adjacentChestZPos != null) {
			GL11.glTranslatef(0.0F, 0.0F, -1.0F);
		}

		GL11.glRotatef((float)rotation, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		float f1 = entity.prevLidAngle + (entity.lidAngle - entity.prevLidAngle) * f;
		float f2;

		if (entity.adjacentChestZNeg != null) {
			f2 = entity.adjacentChestZNeg.prevLidAngle + (entity.adjacentChestZNeg.lidAngle - entity.adjacentChestZNeg.prevLidAngle) * f;

			if (f2 > f1) {
				f1 = f2;
			}
		}

		if (entity.adjacentChestXNeg != null) {
			f2 = entity.adjacentChestXNeg.prevLidAngle + (entity.adjacentChestXNeg.lidAngle - entity.adjacentChestXNeg.prevLidAngle) * f;

			if (f2 > f1) {
				f1 = f2;
			}
		}

		f1 = 1.0F - f1;
		f1 = 1.0F - f1 * f1 * f1;
		model.chestLid.rotateAngleX = -(f1 * (float)Math.PI / 2.0F);
		model.renderAll();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}


	@Override
	public void renderTileEntityAt(TileEntity var1, double x, double y, double z, float f) {
		this.render((TileEntityFrostedChest)var1, x, y, z, f);
	}
}