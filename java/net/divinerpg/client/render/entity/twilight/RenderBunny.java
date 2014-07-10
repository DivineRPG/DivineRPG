package net.divinerpg.client.render.entity.twilight;

import net.divinerpg.client.render.EntityResourceLocation;
import net.divinerpg.entities.twilight.EntityAngryBunny;
import net.divinerpg.entities.twilight.EntityBunny;
import net.divinerpg.libs.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderBunny extends RenderLiving {

	private static final ResourceLocation bunny = EntityResourceLocation.bunny;
	private static final ResourceLocation bunnyTame = EntityResourceLocation.bunnyTamed;
	private static final ResourceLocation angryBunny = EntityResourceLocation.angryBunny;
	private static final ResourceLocation angryBunnyTame = EntityResourceLocation.angryBunnyTamed;
	private float scale;

	public RenderBunny(ModelBase par1ModelBase, float shadowSize) {
		super(par1ModelBase, shadowSize);
		this.scale = 2.0F;
	}

	protected ResourceLocation texture(EntityBunny b) {
		ResourceLocation tex = null;
		if(b instanceof EntityAngryBunny)
			tex = b.isTamed() ? angryBunnyTame : angryBunny;
		else
			tex = b.isTamed() ? bunnyTame : bunny;
		return tex;
	}

	public void preRenderScale(EntityBunny var1, float var2) {
		if(var1 instanceof EntityAngryBunny)
			GL11.glScalef(this.scale, this.scale, this.scale);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase var1, float var2) {
		this.preRenderScale((EntityBunny)var1, var2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1) {
		return texture((EntityBunny)var1);
	}
}