package net.divinerpg.client.render.block;

import net.divinerpg.blocks.vanilla.container.tileentity.TileEntityAyeracoSpawn;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.events.ClientTicker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class RenderAyeracoSpawn extends TileEntitySpecialRenderer {
	
	private static ResourceLocation greenTexture = new ResourceLocation(Reference.PREFIX + "textures/model/ayeracoSymbolGreen.png");
	private static ResourceLocation redTexture = new ResourceLocation(Reference.PREFIX + "textures/model/ayeracoSymbolRed.png");
	private static ResourceLocation yellowTexture = new ResourceLocation(Reference.PREFIX + "textures/model/ayeracoSymbolYellow.png");
	private static ResourceLocation blueTexture = new ResourceLocation(Reference.PREFIX + "textures/model/ayeracoSymbolBlue.png");
	private static ResourceLocation purpleTexture = new ResourceLocation(Reference.PREFIX + "textures/model/ayeracoSymbolPurple.png");
	
	public void renderTileEntity(TileEntityAyeracoSpawn te, double x, double y, double z, float f) {
		GL11.glPushMatrix();
        if(te.spawnTick > 430)Minecraft.getMinecraft().renderEngine.bindTexture(greenTexture);
        else if(te.spawnTick > 300)Minecraft.getMinecraft().renderEngine.bindTexture(blueTexture);
        else if(te.spawnTick > 210)Minecraft.getMinecraft().renderEngine.bindTexture(redTexture);
        else if(te.spawnTick > 145)Minecraft.getMinecraft().renderEngine.bindTexture(yellowTexture);
        else if(te.spawnTick > 0)Minecraft.getMinecraft().renderEngine.bindTexture(purpleTexture);
        GL11.glTranslatef((float)x+0.5f, (float)y+0.01f, (float)z+1.0625f);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glScalef(2, 2, 2);
        Tessellator tessellator = Tessellator.instance;
        float minU = 0;
        float maxU = 1;
        float minV = 0;
        float maxV = 1;
        float f7 = 1.0F;
        float f8 = 0.5F;
        float f9 = 0.25F;
        GL11.glPushMatrix();
        GL11.glTranslatef(0, 0, -0.28125f);
        GL11.glRotatef(ClientTicker.tick*4, 0F, 1F, 0F);
        GL11.glTranslatef(0, 0, 0.28125f);
        GL11.glRotatef(270, 1F, 0F, 0F);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  0,  65536);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV(0.0F - f8, 0.0F - f9, 0.0D, minU, maxV);
        tessellator.addVertexWithUV(f7 - f8, 0.0F - f9, 0.0D, maxU, maxV);
        tessellator.addVertexWithUV(f7 - f8, 1.0F - f9, 0.0D, maxU, minV);
        tessellator.addVertexWithUV(0.0F - f8, 1.0F - f9, 0.0D, minU, minV);
        tessellator.draw();
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(0, 0.001f, -0.28125f);
        GL11.glRotatef(-ClientTicker.tick*4, 0F, 1F, 0F);
        GL11.glTranslatef(0, 0, 0.28125f);
        GL11.glRotatef(270, 1F, 0F, 0F);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,  0,  65536);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV(0.0F - f8, 0.0F - f9, 0.0D, minU, maxV);
        tessellator.addVertexWithUV(f7 - f8, 0.0F - f9, 0.0D, maxU, maxV);
        tessellator.addVertexWithUV(f7 - f8, 1.0F - f9, 0.0D, maxU, minV);
        tessellator.addVertexWithUV(0.0F - f8, 1.0F - f9, 0.0D, minU, minV);
        tessellator.draw();
        GL11.glPopMatrix();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }
	
	@Override
	public void renderTileEntityAt(TileEntity t, double x, double y, double z, float f) {
		 this.renderTileEntity((TileEntityAyeracoSpawn)t, x, y, z, f);
	}

}