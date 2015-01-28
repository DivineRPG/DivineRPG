package net.divinerpg.client.render.item;

import net.divinerpg.client.render.block.model.ModelPresentBox;
import net.divinerpg.libs.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRendererPresentBox implements IItemRenderer {

	private ModelPresentBox model;
	private ResourceLocation texture = new ResourceLocation(Reference.PREFIX + "textures/model/presentBox.png");
	
	public ItemRendererPresentBox() {
		model = new ModelPresentBox();
	}
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return true;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return true;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		GL11.glPushMatrix();
		switch(type) {
		case INVENTORY:
			GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(180F, 1.0F, 0.0F, 0.0F);
			GL11.glTranslatef(0.0F, -0.1F, 0F);
			break;
		case EQUIPPED:
			GL11.glRotatef(180F, 0.0F, 0.0F, 0.1F);
			GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
			GL11.glTranslatef(-1.0F, -1.0F, -1.0F);
			break;
		case ENTITY:
			GL11.glRotatef(180F, 1.0F, 0.0F, 0F);
			GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		default:
		}
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		model.renderAll();
		GL11.glPopMatrix();
	}
}