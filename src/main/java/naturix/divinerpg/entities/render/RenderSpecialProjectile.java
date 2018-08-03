package naturix.divinerpg.entities.render;


import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderSpecialProjectile extends Render {
	
    public ResourceLocation texture;
    private float scale;
    private static RenderManager renderManager;
    public RenderSpecialProjectile(ResourceLocation par1) {
    	super(renderManager);
        texture = par1;
        scale = 1F;
    }

    public RenderSpecialProjectile(ResourceLocation par1, float scaleFactor) {
    	super(renderManager);
        texture = par1;
        scale = scaleFactor;
    }

    @Override
    public void doRender(Entity projectile, double x, double y, double z, float par8, float par9) {
        GL11.glPushMatrix();
        this.bindEntityTexture(projectile);
        GL11.glTranslatef((float)x, (float)y, (float)z);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glScalef(scale * 0.5F, scale * 0.5F, scale * 0.5F);
        Tessellator tessellator = Tessellator.getInstance();
		BufferBuilder buffer = tessellator.getBuffer();
        float minU = 0;
        float maxU = 1;
        float minV = 0;
        float maxV = 1;
        float f7 = 1.0F;
        float f8 = 0.5F;
        float f9 = 0.25F;
        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        buffer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
        //tessellator.setNormal(0.0F, 1.0F, 0.0F);
        addVertexWithUV(buffer, maxV, minV, maxU, minU, f8);
        //tessellator.addVertexWithUV(0.0F - f8, 0.0F - f9, 0.0D, minU, maxV);
        //tessellator.addVertexWithUV(f7 - f8, 0.0F - f9, 0.0D, maxU, maxV);
        //tessellator.addVertexWithUV(f7 - f8, 1.0F - f9, 0.0D, maxU, minV);
        //tessellator.addVertexWithUV(0.0F - f8, 1.0F - f9, 0.0D, minU, minV);
        tessellator.draw();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }
    private void addVertexWithUV(BufferBuilder buffer, float x, float y, float z, double u, double v) {
		buffer.pos(x / 2f, y, z / 2f).tex(u, v).endVertex();
	}
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}