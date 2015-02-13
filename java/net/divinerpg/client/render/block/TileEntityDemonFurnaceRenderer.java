package net.divinerpg.client.render.block;

import net.divinerpg.blocks.base.tileentity.TileEntityInfiniteFurnace;
import net.divinerpg.client.render.block.model.ModelDemonFurnace;
import net.divinerpg.libs.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

public class TileEntityDemonFurnaceRenderer extends TileEntitySpecialRenderer {
	private static ModelDemonFurnace model = new ModelDemonFurnace();
	@Override
	public void renderTileEntityAt(TileEntity entity, double x, double y, double z, float ticks) {
		String tex = "demonFurnace";
		TileEntityInfiniteFurnace te = (TileEntityInfiniteFurnace)entity;
        int rotation = 0;
        if(entity.getWorldObj() != null) rotation = entity.getBlockMetadata();    
		if(rotation >= 8) {
			tex = "demonFurnace_on";
			rotation = rotation - 8;
		}
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.PREFIX + "textures/model/" + tex + ".png"));
        GL11.glPushMatrix();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glTranslatef((float)x + 0.5F, (float)y + 0.5F, (float)z + 0.5F);
        GL11.glRotatef(rotation * 90, 0.0F, 1.0F, 0.0F);
        model.render(0.0625F);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
	}
}