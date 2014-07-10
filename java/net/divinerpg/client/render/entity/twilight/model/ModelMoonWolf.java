package net.divinerpg.client.render.entity.twilight.model;

import net.divinerpg.entities.twilight.EntityMoonWolf;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

import org.lwjgl.opengl.GL11;


public class ModelMoonWolf extends ModelBase {
 
	ModelRenderer WolfHead;
	ModelRenderer Body;
	ModelRenderer Mane;
	ModelRenderer Leg1;
	ModelRenderer Leg2;
	ModelRenderer Leg3;
	ModelRenderer Leg4;
	ModelRenderer Ear1;
	ModelRenderer Ear2;
	ModelRenderer Nose;
	ModelRenderer Ear4;
	ModelRenderer Ear3;
	ModelRenderer spike1;
	ModelRenderer spike2;
	ModelRenderer spike3;
	ModelRenderer spike4;
	ModelRenderer Shape1;
	ModelRenderer Shape2;

	public ModelMoonWolf() {
		textureWidth = 64;
		textureHeight = 32;

		WolfHead = new ModelRenderer(this, 0, 0);
		WolfHead.addBox(-3F, -3F, -2F, 6, 6, 4);
		WolfHead.setRotationPoint(-1F, 13.5F, -7F);
		WolfHead.setTextureSize(64, 32);
		WolfHead.mirror = true;
		setRotation(WolfHead, 0F, 0F, 0F);
		Body = new ModelRenderer(this, 18, 14);
		Body.addBox(-4F, -3F, -3F, 6, 9, 6);
		Body.setRotationPoint(0F, 14F, 2F);
		Body.setTextureSize(64, 32);
		Body.mirror = true;
		setRotation(Body, 1.570796F, 0F, 0F);
		Mane = new ModelRenderer(this, 21, 0);
		Mane.addBox(-4F, -3F, -3F, 8, 6, 7);
		Mane.setRotationPoint(-1F, 14F, -3F);
		Mane.setTextureSize(64, 32);
		Mane.mirror = true;
		setRotation(Mane, 1.570796F, 0F, 0F);
		Leg1 = new ModelRenderer(this, 0, 18);
		Leg1.addBox(-1F, 0F, -1F, 2, 8, 2);
		Leg1.setRotationPoint(-2.5F, 16F, 7F);
		Leg1.setTextureSize(64, 32);
		Leg1.mirror = true;
		setRotation(Leg1, 0F, 0F, 0F);
		Leg2 = new ModelRenderer(this, 0, 18);
		Leg2.addBox(-1F, 0F, -1F, 2, 8, 2);
		Leg2.setRotationPoint(0.5F, 16F, 7F);
		Leg2.setTextureSize(64, 32);
		Leg2.mirror = true;
		setRotation(Leg2, 0F, 0F, 0F);
		Leg3 = new ModelRenderer(this, 0, 18);
		Leg3.addBox(-1F, 0F, -1F, 2, 8, 2);
		Leg3.setRotationPoint(-2.5F, 16F, -4F);
		Leg3.setTextureSize(64, 32);
		Leg3.mirror = true;
		setRotation(Leg3, 0F, 0F, 0F);
		Leg4 = new ModelRenderer(this, 0, 18);
		Leg4.addBox(-1F, 0F, -1F, 2, 8, 2);
		Leg4.setRotationPoint(0.5F, 16F, -4F);
		Leg4.setTextureSize(64, 32);
		Leg4.mirror = true;
		setRotation(Leg4, 0F, 0F, 0F);
		Ear1 = new ModelRenderer(this, 16, 14);
		Ear1.addBox(-3F, -5F, 0F, 2, 2, 1);
		Ear1.setRotationPoint(-1F, 13.5F, -7F);
		Ear1.setTextureSize(64, 32);
		Ear1.mirror = true;
		setRotation(Ear1, 0F, 0F, 0F);
		Ear2 = new ModelRenderer(this, 16, 14);
		Ear2.addBox(1F, -5F, 0F, 2, 2, 1);
		Ear2.setRotationPoint(-1F, 13.5F, -7F);
		Ear2.setTextureSize(64, 32);
		Ear2.mirror = true;
		setRotation(Ear2, 0F, 0F, 0F);
		Nose = new ModelRenderer(this, 0, 10);
		Nose.addBox(-2F, 0F, -5F, 3, 3, 4);
		Nose.setRotationPoint(-0.5F, 13.5F, -7F);
		Nose.setTextureSize(64, 32);
		Nose.mirror = true;
		setRotation(Nose, 0F, 0F, 0F);
		Ear4 = new ModelRenderer(this, 16, 14);
		Ear4.addBox(0F, 0F, 0F, 2, 2, 1);
		Ear4.setRotationPoint(0F, 8F, -5F);
		Ear4.setTextureSize(64, 32);
		Ear4.mirror = true;
		setRotation(Ear4, 0F, 0F, 0F);
		Ear3 = new ModelRenderer(this, 16, 14);
		Ear3.addBox(0F, 0F, 0F, 2, 2, 1);
		Ear3.setRotationPoint(-4F, 8F, -5F);
		Ear3.setTextureSize(64, 32);
		Ear3.mirror = true;
		setRotation(Ear3, 0F, 0F, 0F);
		spike1 = new ModelRenderer(this, 37, 0);
		spike1.addBox(-1F, -8F, 0F, 2, 6, 1);
		spike1.setRotationPoint(0F, 14F, 2F);
		spike1.setTextureSize(64, 32);
		spike1.mirror = true;
		setRotation(spike1, 0F, 0F, 0.7853982F);
		spike2 = new ModelRenderer(this, 37, 0);
		spike2.addBox(-1F, -8F, 3F, 2, 6, 1);
		spike2.setRotationPoint(0F, 14F, 3F);
		spike2.setTextureSize(64, 32);
		spike2.mirror = true;
		setRotation(spike2, 0F, 0F, 0.7853982F);
		spike3 = new ModelRenderer(this, 37, 0);
		spike3.addBox(-2F, -8F, 0F, 2, 6, 1);
		spike3.setRotationPoint(-1F, 14F, 2F);
		spike3.setTextureSize(64, 32);
		spike3.mirror = true;
		setRotation(spike3, 0F, 0F, -0.7853982F);
		spike4 = new ModelRenderer(this, 37, 0);
		spike4.addBox(-2F, -9F, 4F, 2, 6, 1);
		spike4.setRotationPoint(0F, 14F, 2F);
		spike4.setTextureSize(64, 32);
		spike4.mirror = true;
		setRotation(spike4, 0F, 0F, -0.7853982F);
		Shape1 = new ModelRenderer(this, 4, 0);
		Shape1.addBox(0F, 0F, 0F, 1, 1, 4);
		Shape1.setRotationPoint(1F, 11F, -12F);
		Shape1.setTextureSize(64, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 4, 0);
		Shape2.addBox(0F, 0F, 0F, 1, 1, 4);
		Shape2.setRotationPoint(-4F, 11F, -12F);
		Shape2.setTextureSize(64, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		WolfHead.render(f5);
		Body.render(f5);
		Mane.render(f5);
		Leg1.render(f5);
		Leg2.render(f5);
		Leg3.render(f5);
		Leg4.render(f5);
		Ear1.render(f5);
		Ear2.render(f5);
		Nose.render(f5);
		Ear4.render(f5);
		Ear3.render(f5);
		spike1.render(f5);
		spike2.render(f5);
		spike3.render(f5);
		spike4.render(f5);
		Shape1.render(f5);
		Shape2.render(f5);
	}

	private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
		var1.rotateAngleX = var2;
		var1.rotateAngleY = var3;
		var1.rotateAngleZ = var4;
	}

	public void setLivingAnimations(EntityLivingBase var1, float var2, float var3, float var4) {
		EntityMoonWolf var5 = (EntityMoonWolf)var1;

		if(var5.isSitting()) {
			this.Mane.setRotationPoint(-1.0F, 16.0F, -3.0F);
			this.Mane.rotateAngleX = ((float)Math.PI * 2F / 5F);
			this.Mane.rotateAngleY = 0.0F;
			this.Body.setRotationPoint(0.0F, 18.0F, 0.0F);
			this.Body.rotateAngleX = ((float)Math.PI / 4F);
			spike1.setRotationPoint(0F, 18F, 2F);
			spike2.setRotationPoint(0F, 18F, 3F);
			spike3.setRotationPoint(-1F, 18F, 2F);
			spike4.setRotationPoint(0F, 18F, 2F);

			this.Leg1.setRotationPoint(-2.5F, 22.0F, 2.0F);
			this.Leg1.rotateAngleX = ((float)Math.PI * 3F / 2F);
			this.Leg2.setRotationPoint(0.5F, 22.0F, 2.0F);
			this.Leg2.rotateAngleX = ((float)Math.PI * 3F / 2F);
			this.Leg3.rotateAngleX = 5.811947F;
			this.Leg3.setRotationPoint(-2.49F, 17.0F, -4.0F);
			this.Leg4.rotateAngleX = 5.811947F;
			this.Leg4.setRotationPoint(0.51F, 17.0F, -4.0F);
		} else {
			this.Body.setRotationPoint(0.0F, 14.0F, 2.0F);
			this.Body.rotateAngleX = ((float)Math.PI / 2F);
			spike1.setRotationPoint(0F, 14F, 2F);
			spike2.setRotationPoint(0F, 14F, 3F);
			spike3.setRotationPoint(-1F, 14F, 2F);
			spike4.setRotationPoint(0F, 14F, 2F);

			this.Mane.setRotationPoint(-1.0F, 14.0F, -3.0F);
			this.Mane.rotateAngleX = this.Body.rotateAngleX;
			this.Leg1.setRotationPoint(-2.5F, 16.0F, 7.0F);
			this.Leg2.setRotationPoint(0.5F, 16.0F, 7.0F);
			this.Leg3.setRotationPoint(-2.5F, 16.0F, -4.0F);
			this.Leg4.setRotationPoint(0.5F, 16.0F, -4.0F);
			this.Leg1.rotateAngleX = MathHelper.cos(var2 * 0.6662F) * 1.4F * var3;
			this.Leg2.rotateAngleX = MathHelper.cos(var2 * 0.6662F + (float)Math.PI) * 1.4F * var3;
			this.Leg3.rotateAngleX = MathHelper.cos(var2 * 0.6662F + (float)Math.PI) * 1.4F * var3;
			this.Leg4.rotateAngleX = MathHelper.cos(var2 * 0.6662F) * 1.4F * var3;
		}

		this.WolfHead.rotateAngleZ = var5.getInterestedAngle(var4) + var5.getShakeAngle(var4, 0.0F);
		this.Mane.rotateAngleZ = var5.getShakeAngle(var4, -0.08F);
		this.Body.rotateAngleZ = var5.getShakeAngle(var4, -0.16F);

		if(var5.getWolfShaking()) {
			float var6 = var5.getBrightness(var4) * var5.getShadingWhileShaking(var4);
			GL11.glColor3f(var6, var6, var6);
		}
	}

	public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6) {
		this.WolfHead.rotateAngleX = var5 / (180F / (float)Math.PI);
		this.WolfHead.rotateAngleY = var4 / (180F / (float)Math.PI);
		this.Nose.rotateAngleX = var5 / (180F / (float)Math.PI);
		this.Nose.rotateAngleY = var4 / (180F / (float)Math.PI);
		this.Ear1.rotateAngleX = var5 / (180F / (float)Math.PI);
		this.Ear1.rotateAngleY = var4 / (180F / (float)Math.PI);
		this.Ear2.rotateAngleX = var5 / (180F / (float)Math.PI);
		this.Ear2.rotateAngleY = var4 / (180F / (float)Math.PI);
		this.Ear3.rotateAngleX = var5 / (180F / (float)Math.PI);
		this.Ear3.rotateAngleY = var4 / (180F / (float)Math.PI);
		this.Ear4.rotateAngleX = var5 / (180F / (float)Math.PI);
		this.Ear4.rotateAngleY = var4 / (180F / (float)Math.PI);
	}
}