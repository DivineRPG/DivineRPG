package net.divinerpg.client.render.entity.arcana;

import java.util.Random;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderStarlight extends Render {

	private ResourceLocation texture;
	private Random r = new Random();
	
	public RenderStarlight(ResourceLocation par1) {
		this.texture = par1;
	}

	public void render(EntityThrowable projectile, double x, double y, double z) {
		GL11.glPushMatrix();
		this.bindEntityTexture(projectile);
		GL11.glTranslatef((float)x, (float)y, (float)z);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		Tessellator tessellator = Tessellator.instance;
		float minU = 0;
		float maxU = 1;
		float minV = 0;
		float maxV = 1;
		float f7 = 1.0F;
		float f8 = 0.5F;
		float f9 = 0.25F;
		GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
		GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
		tessellator.startDrawingQuads();
		tessellator.setColorRGBA_F(r.nextFloat(), r.nextFloat(), r.nextFloat(), 255);
		tessellator.setNormal(0.0F, 1.0F, 0.0F);
		tessellator.addVertexWithUV(0.0F - f8, 0.0F - f9, 0.0D, minU, maxV);
		tessellator.addVertexWithUV(f7 - f8, 0.0F - f9, 0.0D, maxU, maxV);
		tessellator.addVertexWithUV(f7 - f8, 1.0F - f9, 0.0D, maxU, minV);
		tessellator.addVertexWithUV(0.0F - f8, 1.0F - f9, 0.0D, minU, minV);
		tessellator.draw();
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture;
	}

	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		this.render((EntityThrowable)par1Entity, par2, par4, par6);
	}
}