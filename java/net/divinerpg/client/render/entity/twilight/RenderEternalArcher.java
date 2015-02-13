package net.divinerpg.client.render.entity.twilight;

import net.divinerpg.client.render.RenderLivingCreature;
import net.divinerpg.client.render.entity.twilight.model.ModelEternalArcher;
import net.divinerpg.entities.base.DivineBossStatus;
import net.divinerpg.entities.base.EntityDivineRPGBoss;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

import org.lwjgl.opengl.GL11;

public class RenderEternalArcher extends RenderLivingCreature {
	
	private float scale;
	public int bossTextureID;
	
	public RenderEternalArcher(ModelBase var1, float var2, ResourceLocation texture, int id) {
		this(var1, var2, 1.0F, texture, id);
	}
	
	public RenderEternalArcher(ModelBase var1, float var2, float var3, ResourceLocation texture, int id) {
		super(var1, var2 * var3, texture);
		bossTextureID = id;
		this.scale = var3;
	}

	public void preRenderScale(EntityMob var1, float var2) {
		GL11.glScalef(this.scale, this.scale, this.scale);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase var1, float var2) {
		this.preRenderScale((EntityDivineRPGBoss)var1, var2);
	}
	
	@Override
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
		super.doRender(par1Entity, par2, par4, par6, par8, par9);
		DivineBossStatus.setBossStatus((EntityDivineRPGBoss)par1Entity, bossTextureID);
	}
	
	@Override
	protected void renderEquippedItems(EntityLivingBase var1, float var2) {
		super.renderEquippedItems(var1, var2);
		ItemStack var3 = var1.getHeldItem();

		if (var3 != null) {
			for(ModelRenderer r : ((ModelEternalArcher)this.mainModel).armsRight) {
				GL11.glPushMatrix();
				r.postRender(0.0625F);
				GL11.glTranslatef(0.57F, 0F, 0.0625F);
				IItemRenderer var5 = MinecraftForgeClient.getItemRenderer(var3, IItemRenderer.ItemRenderType.EQUIPPED);
				boolean var6 = (var5 != null) && (var5.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, var3, IItemRenderer.ItemRendererHelper.BLOCK_3D));

				float var4 = 0.4F;
				GL11.glTranslatef(-0.75F, 0.5F, -0.4F);
				GL11.glScalef(var4, -var4, var4);
				GL11.glRotatef(120.0F, 0.07F, 1F, -0.6F);

				this.renderManager.itemRenderer.renderItem(var1, var3, 0);
		
				if (var3.getItem().requiresMultipleRenderPasses()) {
					for (int var7 = 1; var7 < var3.getItem().getRenderPasses(var3.getItemDamage()); var7++) {
						this.renderManager.itemRenderer.renderItem(var1, var3, var7);
					}
				}

				GL11.glPopMatrix();
			}
			
			for(ModelRenderer r : ((ModelEternalArcher)this.mainModel).armsLeft) {
				GL11.glPushMatrix();
				r.postRender(0.0625F);
				GL11.glTranslatef(0.67F, 0F, 0.0625F);
				IItemRenderer var5 = MinecraftForgeClient.getItemRenderer(var3, IItemRenderer.ItemRenderType.EQUIPPED);
				boolean var6 = (var5 != null) && (var5.shouldUseRenderHelper(IItemRenderer.ItemRenderType.EQUIPPED, var3, IItemRenderer.ItemRendererHelper.BLOCK_3D));

				float var4 = 0.4F;
				GL11.glTranslatef(-0.75F, 0.5F, -0.4F);
				GL11.glScalef(var4, -var4, var4);
				GL11.glRotatef(120.0F, -0.05F, 1F, -0.6F);

				this.renderManager.itemRenderer.renderItem(var1, var3, 0);
		
				if (var3.getItem().requiresMultipleRenderPasses()) {
					for (int var7 = 1; var7 < var3.getItem().getRenderPasses(var3.getItemDamage()); var7++) {
						this.renderManager.itemRenderer.renderItem(var1, var3, var7);
					}
				}

				GL11.glPopMatrix();
			}
		}
	}
}