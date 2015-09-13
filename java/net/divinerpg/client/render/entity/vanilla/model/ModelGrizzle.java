package net.divinerpg.client.render.entity.vanilla.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGrizzle extends ModelBase {
	ModelRenderer leg1;
	ModelRenderer leg2;
	ModelRenderer leg4;
	ModelRenderer leg3;
	ModelRenderer body;
	ModelRenderer head;
	ModelRenderer snout;
	ModelRenderer ear2;
	ModelRenderer ear1;
	ModelRenderer tail;

	public ModelGrizzle() {
		textureWidth = 128;
		textureHeight = 128;

		leg1 = new ModelRenderer(this, 0, 0);
		leg1.addBox(-1.9999F, 0F, -2F, 4, 10, 4);
		leg1.setRotationPoint(-4F, 14F, -8F);
		leg1.setTextureSize(128, 128);
		leg1.mirror = true;
		setRotation(leg1, 0F, 0F, 0F);
		leg2 = new ModelRenderer(this, 0, 0);
		leg2.addBox(-1.9999F, 0F, -2F, 4, 8, 4);
		leg2.setRotationPoint(-4F, 16F, 8F);
		leg2.setTextureSize(128, 128);
		leg2.mirror = true;
		setRotation(leg2, 0F, 0F, 0F);
		leg4 = new ModelRenderer(this, 0, 0);
		leg4.addBox(-2.0001F, 0F, -2F, 4, 8, 4);
		leg4.setRotationPoint(4F, 16F, 8F);
		leg4.setTextureSize(128, 128);
		leg4.mirror = true;
		setRotation(leg4, 0F, 0F, 0F);
		leg3 = new ModelRenderer(this, 0, 0);
		leg3.addBox(-2.0001F, 0F, -2F, 4, 10, 4);
		leg3.setRotationPoint(4F, 14F, -8F);
		leg3.setTextureSize(128, 128);
		leg3.mirror = true;
		setRotation(leg3, 0F, 0F, 0F);
		body = new ModelRenderer(this, 0, 0);
		body.addBox(0F, 0F, 0F, 12, 10, 22);
		body.setRotationPoint(-6F, 4.5F, -11F);
		body.setTextureSize(128, 128);
		body.mirror = true;
		setRotation(body, -0.0872665F, 0F, 0F);
		head = new ModelRenderer(this, 0, 32);
		head.addBox(-4F, -3F, -5F, 8, 8, 6);
		head.setRotationPoint(0F, 5F, -11F);
		head.setTextureSize(128, 128);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		snout = new ModelRenderer(this, 0, 46);
		snout.addBox(-2F, 1F, -9F, 4, 4, 4);
		snout.setRotationPoint(0F, 5F, -11F);
		snout.setTextureSize(128, 128);
		snout.mirror = true;
		setRotation(snout, 0F, 0F, 0F);
		ear2 = new ModelRenderer(this, 0, 14);
		ear2.addBox(3F, -4F, -1F, 2, 2, 1);
		ear2.setRotationPoint(0F, 5F, -11F);
		ear2.setTextureSize(128, 128);
		ear2.mirror = true;
		setRotation(ear2, 0F, 0F, 0F);
		ear1 = new ModelRenderer(this, 0, 14);
		ear1.addBox(-5F, -4F, -1F, 2, 2, 1);
		ear1.setRotationPoint(0F, 5F, -11F);
		ear1.setTextureSize(128, 128);
		ear1.mirror = true;
		setRotation(ear1, 0F, 0F, 0F);
		tail = new ModelRenderer(this, 0, 26);
		tail.addBox(5F, 4F, 21.54F, 2, 2, 2);
		tail.setRotationPoint(-6F, 4.5F, -11F);
		tail.setTextureSize(128, 128);
		tail.mirror = true;
		setRotation(tail, -0.0872665F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		leg1.render(f5);
		leg2.render(f5);
		leg4.render(f5);
		leg3.render(f5);
		body.render(f5);
		head.render(f5);
		snout.render(f5);
		ear2.render(f5);
		ear1.render(f5);
		tail.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		
		this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
        this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * f1;
        this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F) * f1;
        this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * f1;
        
        this.head.rotateAngleX = this.ear1.rotateAngleX = this.ear2.rotateAngleX = this.snout.rotateAngleX = f4 / (180F / (float)Math.PI);
        this.head.rotateAngleY = this.ear1.rotateAngleY = this.ear2.rotateAngleY = this.snout.rotateAngleY = f3 / (180F / (float)Math.PI);
	}

}
