package net.divinerpg.client.render.entity.twilight.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelCadillion extends ModelBase {
	ModelRenderer body;
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer leg3;
	ModelRenderer leg4;
	ModelRenderer head;
	ModelRenderer horn1;
	ModelRenderer horn2;
	ModelRenderer Horn;

	public ModelCadillion() {
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.body = new ModelRenderer(this, 18, 4);
		this.body.addBox(-6.0F, -10.0F, -7.0F, 8, 18, 10);
		this.body.setRotationPoint(2.0F, 5.0F, 2.0F);
		this.body.setTextureSize(64, 32);
		this.body.mirror = true;
		setRotation(this.body, 1.570796F, 0.0F, 0.0F);
		this.leg1 = new ModelRenderer(this, 0, 16);
		this.leg1.addBox(-3.0F, 0.0F, -2.0F, 4, 12, 4);
		this.leg1.setRotationPoint(-2.0F, 12.0F, 7.0F);
		this.leg1.setTextureSize(64, 32);
		this.leg1.mirror = true;
		setRotation(this.leg1, 0.0F, 0.0F, 0.0F);
		this.leg2 = new ModelRenderer(this, 0, 16);
		this.leg2.addBox(-1.0F, 0.0F, -2.0F, 4, 12, 4);
		this.leg2.setRotationPoint(2.0F, 12.0F, 7.0F);
		this.leg2.setTextureSize(64, 32);
		this.leg2.mirror = true;
		setRotation(this.leg2, 0.0F, 0.0F, 0.0F);
		this.leg2.mirror = false;
		this.leg3 = new ModelRenderer(this, 0, 16);
		this.leg3.addBox(-3.0F, 0.0F, -3.0F, 4, 12, 4);
		this.leg3.setRotationPoint(-2.0F, 12.0F, -5.0F);
		this.leg3.setTextureSize(64, 32);
		this.leg3.mirror = true;
		setRotation(this.leg3, 0.0F, 0.0F, 0.0F);
		this.leg4 = new ModelRenderer(this, 0, 16);
		this.leg4.addBox(-1.0F, 0.0F, -3.0F, 4, 12, 4);
		this.leg4.setRotationPoint(2.0F, 12.0F, -5.0F);
		this.leg4.setTextureSize(64, 32);
		this.leg4.mirror = true;
		setRotation(this.leg4, 0.0F, 0.0F, 0.0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-4.0F, -3.0F, -6.0F, 8, 8, 6);
		this.head.setRotationPoint(0.0F, 3.0F, -8.0F);
		this.head.setTextureSize(64, 32);
		this.head.mirror = true;
		setRotation(this.head, 0.0F, 0.0F, 0.0F);
		this.horn1 = new ModelRenderer(this, 55, 0);
		this.horn1.addBox(-3.0F, -6.0F, -5.0F, 1, 3, 3);
		this.horn1.setRotationPoint(0.0F, 3.0F, -8.0F);
		this.horn1.setTextureSize(64, 32);
		this.horn1.mirror = true;
		setRotation(this.horn1, 0.0F, 0.0F, 0.0F);
		this.horn2 = new ModelRenderer(this, 55, 0);
		this.horn2.addBox(2.0F, -6.0F, -5.0F, 1, 3, 3);
		this.horn2.setRotationPoint(0.0F, 3.0F, -8.0F);
		this.horn2.setTextureSize(64, 32);
		this.horn2.mirror = true;
		setRotation(this.horn2, 0.0F, 0.0F, 0.0F);
		this.Horn = new ModelRenderer(this, 55, 5);
		this.Horn.addBox(-1.0F, 3.0F, 2.0F, 2, 8, 2);
		this.Horn.setRotationPoint(0.0F, 3.0F, -8.0F);
		this.Horn.setTextureSize(64, 32);
		this.Horn.mirror = true;
		setRotation(this.Horn, -2.13777F, 0.0F, 0.0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5);
		this.body.render(f5);
		this.leg1.render(f5);
		this.leg2.render(f5);
		this.leg3.render(f5);
		this.leg4.render(f5);
		this.head.render(f5);
		this.horn1.render(f5);
		this.horn2.render(f5);
		this.Horn.render(f5);
	}

	private void setRotation(ModelRenderer var1, float var2, float var3, float var4) {
		var1.rotateAngleX = var2;
		var1.rotateAngleY = var3;
		var1.rotateAngleZ = var4;
	}

	public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6) {
		this.head.rotateAngleY = (var4 / 57.295776F);
		this.Horn.rotateAngleY = (var4 / 63.661976F);
		this.horn1.rotateAngleY = var4 / (180F / (float)Math.PI);
		this.horn2.rotateAngleY = var4 / (180F / (float)Math.PI);
		this.body.rotateAngleX = 1.570796F;
		this.leg1.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2);
		this.leg2.rotateAngleX = (MathHelper.cos(var1 * 0.6662F + 3.141593F) * 1.4F * var2);
		this.leg3.rotateAngleX = (MathHelper.cos(var1 * 0.6662F + 3.141593F) * 1.4F * var2);
		this.leg4.rotateAngleX = (MathHelper.cos(var1 * 0.6662F) * 1.4F * var2);
	}
}
