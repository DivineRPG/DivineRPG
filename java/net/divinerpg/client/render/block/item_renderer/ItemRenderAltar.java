package net.divinerpg.client.render.block.item_renderer;

import net.divinerpg.client.render.block.model.ModelDramixAltar;
import net.divinerpg.client.render.block.model.ModelExtractor;
import net.divinerpg.client.render.block.model.ModelParasectaAltar;
import net.divinerpg.libs.Reference;
import net.divinerpg.utils.blocks.ArcanaBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

public class ItemRenderAltar implements IItemRenderer {

	private String texture;
	
	public ItemRenderAltar(String tex) {
		texture = tex;
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
	public void renderItem(ItemRenderType type, ItemStack item, Object ... data) {
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.PREFIX + "textures/model/" + texture + ".png"));

		GL11.glPushMatrix();
		if(item.getItem() == Item.getItemFromBlock(ArcanaBlocks.dramixAltar)){
			float scale = 0.1F;
			switch(type){
			case EQUIPPED:
				GL11.glTranslatef(0.5F, -0.2F, 0.5F);
				GL11.glScalef(scale, scale, scale);
				break;
			case INVENTORY:
				GL11.glTranslatef(0.0F, -1.2F, 0.0F);
				GL11.glScalef(scale, scale, scale);
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glScalef(scale, scale, scale);
				break;
			case ENTITY:
				GL11.glScalef(scale, scale, scale);
				break;
			default: 
				break;
			}
			new ModelDramixAltar().render(0.652F);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		if(item.getItem() == Item.getItemFromBlock(ArcanaBlocks.parasectaAltar)){
			float scale = 0.1F;
			switch(type){
			case EQUIPPED:
				GL11.glTranslatef(0.5F, -0.2F, 0.5F);
				GL11.glScalef(scale, scale, scale);
				break;
			case INVENTORY:
				GL11.glTranslatef(0.0F, -1.2F, 0.0F);
				GL11.glScalef(scale, scale, scale);
				break;
			case EQUIPPED_FIRST_PERSON:
				GL11.glScalef(scale, scale, scale);
				break;
			case ENTITY:
				GL11.glScalef(scale, scale, scale);
				break;
			default: 
				break;
			}
			new ModelParasectaAltar().render(0.652F);
		}
		GL11.glPopMatrix();
		GL11.glPushMatrix();
		if(item.getItem() == Item.getItemFromBlock(ArcanaBlocks.arcanaExtractor)){
			switch(type){
			case EQUIPPED:
				GL11.glTranslatef(0.5F, 0.0F, 0.5F);
				GL11.glScalef(0.9F, 0.9F, 0.9F);
				break;
			case INVENTORY:
				GL11.glTranslatef(0.0F, -0.7F, 0.0F);
				GL11.glScalef(0.9F, 0.9F, 0.9F);
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
			new ModelExtractor().render(0.0652F);
		}
		GL11.glPopMatrix();
	}
}