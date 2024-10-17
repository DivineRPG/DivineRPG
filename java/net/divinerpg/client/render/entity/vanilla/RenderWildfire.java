package net.divinerpg.client.render.entity.vanilla;

import net.divinerpg.client.render.entity.vanilla.model.ModelWildfire;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderWildfire extends RenderLiving {
	protected ModelWildfire mainModel;
	private ResourceLocation texture;

	public RenderWildfire(ModelWildfire var1, ResourceLocation var2) {
		super(var1, 0.6f);
		this.mainModel = var1;
		this.texture = var2;
	}

	@Override
	protected void renderEquippedItems(EntityLivingBase var1, float var2) {
		super.renderEquippedItems(var1, var2);
		ItemStack var3 = var1.getHeldItem();

		if (var3 != null) {
			GL11.glPushMatrix();
			this.mainModel.rightarm.postRender(0.0625F);
			GL11.glTranslatef(-0.0625F, 0.4375F, 0.0625F);
			IItemRenderer var5 = MinecraftForgeClient.getItemRenderer(var3, IItemRenderer.ItemRenderType.EQUIPPED);
			boolean var6 = (var5 != null) && (var5.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, var3, IItemRenderer.ItemRendererHelper.BLOCK_3D));

			float var4 = 0.4F;
			GL11.glTranslatef(0, 0, -0.4F);
			GL11.glScalef(var4, -var4, var4);
			GL11.glRotatef(120.0F, 0.1F, 1F, -0.8F);

			this.renderManager.itemRenderer.renderItem(var1, var3, 0);

			if (var3.getItem().requiresMultipleRenderPasses()) {
				for (int var7 = 1; var7 < var3.getItem().getRenderPasses(var3.getItemDamage()); var7++) {
					this.renderManager.itemRenderer.renderItem(var1, var3, var7);
				}
			}

			GL11.glPopMatrix();
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity e) {
		return texture;
	}
}