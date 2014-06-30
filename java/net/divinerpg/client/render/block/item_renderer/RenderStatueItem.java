package net.divinerpg.client.render.block.item_renderer;

import org.lwjgl.opengl.GL11;

import net.divinerpg.api.blocks.BlockStatue;
import net.divinerpg.api.model.DivineModel;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class RenderStatueItem implements IItemRenderer {

	private DivineModel model;
	private ResourceLocation texture;

	public RenderStatueItem(BlockStatue statueBlock) {
		this.model = statueBlock.getModel();
		this.texture = statueBlock.getTexture();
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

		GL11.glScalef(-0.6F, -0.6F, 0.6F);

		switch(type){
		case INVENTORY: 
			GL11.glTranslatef(0, 0.12F, 0);
			break;
		case EQUIPPED: 
			GL11.glTranslatef(-0.8F, -0.2F, 0.7F);
			break;
		case EQUIPPED_FIRST_PERSON: 
			GL11.glTranslatef(0, -0.7F, 0.7F);
			break;
		default:
		}

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

		model.render(0.0625F);

		GL11.glPopMatrix();

	}
}