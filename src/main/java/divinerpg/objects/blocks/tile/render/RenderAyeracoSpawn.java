package divinerpg.objects.blocks.tile.render;

import divinerpg.DivineRPG;
import divinerpg.objects.blocks.tile.entity.TileEntityAyeracoSpawn;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class RenderAyeracoSpawn extends TileEntitySpecialRenderer<TileEntityAyeracoSpawn> {

    private static ResourceLocation greenTexture = new ResourceLocation(
            DivineRPG.MODID + ":textures/model/green_ayeraco_symbol.png");
    private static ResourceLocation redTexture = new ResourceLocation(
            DivineRPG.MODID + ":textures/model/red_ayeraco_symbol.png");
    private static ResourceLocation yellowTexture = new ResourceLocation(
            DivineRPG.MODID + ":textures/model/yellow_ayeraco_symbol.png");
    private static ResourceLocation blueTexture = new ResourceLocation(
            DivineRPG.MODID + ":textures/model/blue_ayeraco_symbol.png");
    private static ResourceLocation purpleTexture = new ResourceLocation(
            DivineRPG.MODID + ":textures/model/purple_ayeraco_symbol.png");

    public void render(TileEntityAyeracoSpawn te, double x, double y, double z, float partialTicks, int destroyStage,
            float alpha) {
        GL11.glPushMatrix();
        if (te.spawnTick > 430)
            Minecraft.getMinecraft().renderEngine.bindTexture(greenTexture);
        else if (te.spawnTick > 300)
            Minecraft.getMinecraft().renderEngine.bindTexture(blueTexture);
        else if (te.spawnTick > 210)
            Minecraft.getMinecraft().renderEngine.bindTexture(redTexture);
        else if (te.spawnTick > 145)
            Minecraft.getMinecraft().renderEngine.bindTexture(yellowTexture);
        else if (te.spawnTick > 0)
            Minecraft.getMinecraft().renderEngine.bindTexture(purpleTexture);
        GL11.glTranslatef((float) x + 0.5f, (float) y + 0.01f, (float) z + 1.0625f);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glScalef(2, 2, 2);
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        float minU = 0;
        float maxU = 1;
        float minV = 0;
        float maxV = 1;
        float f7 = 1.0F;
        float f8 = 0.5F;
        float f9 = 0.25F;
        GL11.glPushMatrix();
        GL11.glTranslatef(0, 0, -0.28125f);
        GL11.glRotatef(te.getWorld().getTotalWorldTime() * 4, 0F, 1F, 0F);
        GL11.glTranslatef(0, 0, 0.28125f);
        GL11.glRotatef(270, 1F, 0F, 0F);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 0, 65536);
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        bufferbuilder.pos(0.0F - f8, 0.0F - f9, 0.0D).tex(minU, maxV).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferbuilder.pos(f7 - f8, 0.0F - f9, 0.0D).tex(maxU, maxV).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferbuilder.pos(f7 - f8, 1.0F - f9, 0.0D).tex(maxU, minV).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferbuilder.pos(0.0F - f8, 1.0F - f9, 0.0D).tex(minU, minV).normal(0.0F, 1.0F, 0.0F).endVertex();
        tessellator.draw();

        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(0, 0.001f, -0.28125f);
        GL11.glRotatef(-te.getWorld().getTotalWorldTime() * 4, 0F, 1F, 0F);
        GL11.glTranslatef(0, 0, 0.28125f);
        GL11.glRotatef(270, 1F, 0F, 0F);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 0, 65536);
        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
        bufferbuilder.pos(0.0F - f8, 0.0F - f9, 0.0D).tex(minU, maxV).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferbuilder.pos(f7 - f8, 0.0F - f9, 0.0D).tex(maxU, maxV).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferbuilder.pos(f7 - f8, 1.0F - f9, 0.0D).tex(maxU, minV).normal(0.0F, 1.0F, 0.0F).endVertex();
        bufferbuilder.pos(0.0F - f8, 1.0F - f9, 0.0D).tex(minU, minV).normal(0.0F, 1.0F, 0.0F).endVertex();
        tessellator.draw();

        GL11.glPopMatrix();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }
}