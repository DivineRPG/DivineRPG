package net.divinerpg.client.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderGiantZombie;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderSizeable extends RenderLivingCreature {
	
	protected float scale;
	
	public RenderSizeable(ModelBase var1, float shadowsize, float scale, ResourceLocation texture) {
		super(var1, shadowsize * scale, texture);
		this.scale = scale;
	}

	public void preRenderScale(EntityMob var1, float var2) {
		GL11.glScalef(this.scale, this.scale, this.scale);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase var1, float var2) {
		this.preRenderScale((EntityMob)var1, var2);
	}
}