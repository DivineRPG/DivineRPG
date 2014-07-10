package net.divinerpg.client.render.block.item_renderer;

import net.divinerpg.client.render.block.model.ModelDemonFurnace;
import net.divinerpg.libs.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRenderDemonFurnace implements IItemRenderer {

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
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.PREFIX + "textures/model/demonFurnace.png"));
		GL11.glPushMatrix();
			switch(type){
			case EQUIPPED:
				GL11.glTranslatef(0.4F, 0.4F, 0.4F);
				GL11.glScalef(0.9F, 0.9F, 0.9F);
				GL11.glRotatef(180F, 0.3F, -10.0F, 0.0F);
				break;
			case INVENTORY:
				GL11.glTranslatef(-0.2F, -0.4F, 0.0F);
				GL11.glScalef(0.7F, 0.7F, 0.7F);
				GL11.glRotatef(180F, 0.0F, -10.0F, 0.0F);
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glScalef(0.9F, 0.9F, 0.9F);
				break;
			case ENTITY:
				GL11.glTranslatef(0.0F, 0.0F, 0.0F);
				GL11.glScalef(0.9F, 0.9F, 0.9F);
				break;
			default: 
				break;
			}
			new ModelDemonFurnace().render(0.0652F);
		GL11.glPopMatrix();
	}
}