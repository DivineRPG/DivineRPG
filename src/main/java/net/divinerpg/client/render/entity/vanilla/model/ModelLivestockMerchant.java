package net.divinerpg.client.render.entity.vanilla.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelLivestockMerchant extends ModelBase {
	ModelRenderer head;
	ModelRenderer hatbottom;
	ModelRenderer body;
	ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer hatTop;
	ModelRenderer frontRightCorner;
	ModelRenderer frontLeftCorner;
	ModelRenderer backRightCorner;
	ModelRenderer backLeftCorner;

	public ModelLivestockMerchant() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(64, 64);
		head.mirror = true;
		setRotation(head, 0F, 0F, 0F);
		hatbottom = new ModelRenderer(this, 0, 42);
		hatbottom.addBox(-7F, -8F, -7F, 14, 1, 14);
		hatbottom.setRotationPoint(0F, 0F, 0F);
		hatbottom.setTextureSize(64, 64);
		hatbottom.mirror = true;
		setRotation(hatbottom, 0F, 0F, 0F);
		body = new ModelRenderer(this, 16, 16);
		body.addBox(-4F, 0F, -2F, 8, 12, 4);
		body.setRotationPoint(0F, 0F, 0F);
		body.setTextureSize(64, 64);
		body.mirror = true;
		setRotation(body, 0F, 0F, 0F);
		rightarm = new ModelRenderer(this, 40, 16);
		rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
		rightarm.setRotationPoint(-5F, 2F, 0F);
		rightarm.setTextureSize(64, 64);
		rightarm.mirror = true;
		setRotation(rightarm, 0F, 0F, 0F);
		leftarm = new ModelRenderer(this, 40, 16);
		leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
		leftarm.setRotationPoint(5F, 2F, 0F);
		leftarm.setTextureSize(64, 64);
		leftarm.mirror = true;
		setRotation(leftarm, 0F, 0F, 0F);
		rightleg = new ModelRenderer(this, 0, 16);
		rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		rightleg.setRotationPoint(-2F, 12F, 0F);
		rightleg.setTextureSize(64, 64);
		rightleg.mirror = true;
		setRotation(rightleg, 0F, 0F, 0F);
		leftleg = new ModelRenderer(this, 0, 16);
		leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
		leftleg.setRotationPoint(2F, 12F, 0F);
		leftleg.setTextureSize(64, 64);
		leftleg.mirror = true;
		setRotation(leftleg, 0F, 0F, 0F);
		hatTop = new ModelRenderer(this, 0, 32);
		hatTop.addBox(-4F, -10F, -4F, 8, 2, 8);
		hatTop.setRotationPoint(0F, 0F, 0F);
		hatTop.setTextureSize(64, 64);
		hatTop.mirror = true;
		setRotation(hatTop, 0F, 0F, 0F);
		frontRightCorner = new ModelRenderer(this, 0, 62);
		frontRightCorner.addBox(-7F, -8F, -7F, 1, 1, 1);
		frontRightCorner.setRotationPoint(0F, 0F, 0F);
		frontRightCorner.setTextureSize(64, 64);
		frontRightCorner.mirror = true;
		setRotation(frontRightCorner, 0F, 0F, 0F);
		frontLeftCorner = new ModelRenderer(this, 4, 62);
		frontLeftCorner.addBox(6F, -8F, -7F, 1, 1, 1);
		frontLeftCorner.setRotationPoint(0F, 0F, 0F);
		frontLeftCorner.setTextureSize(64, 64);
		frontLeftCorner.mirror = true;
		setRotation(frontLeftCorner, 0F, 0F, 0F);
		backRightCorner = new ModelRenderer(this, 8, 62);
		backRightCorner.addBox(-7F, -8F, 6F, 1, 1, 1);
		backRightCorner.setRotationPoint(0F, 0F, 0F);
		backRightCorner.setTextureSize(64, 64);
		backRightCorner.mirror = true;
		setRotation(backRightCorner, 0F, 0F, 0F);
		backLeftCorner = new ModelRenderer(this, 12, 62);
		backLeftCorner.addBox(6F, -8F, 6F, 1, 1, 1);
		backLeftCorner.setRotationPoint(0F, 0F, 0F);
		backLeftCorner.setTextureSize(64, 64);
		backLeftCorner.mirror = true;
		setRotation(backLeftCorner, 0F, 0F, 0F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		head.render(f5);
		hatbottom.render(f5);
		body.render(f5);
		rightarm.render(f5);
		leftarm.render(f5);
		rightleg.render(f5);
		leftleg.render(f5);
		hatTop.render(f5);
		frontRightCorner.render(f5);
		frontLeftCorner.render(f5);
		backRightCorner.render(f5);
		backLeftCorner.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.hatTop.rotateAngleY = this.hatbottom.rotateAngleY = this.frontRightCorner.rotateAngleY = this.backRightCorner.rotateAngleY = this.backLeftCorner.rotateAngleY = this.frontLeftCorner.rotateAngleY = this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
		this.hatTop.rotateAngleX = this.hatbottom.rotateAngleX = this.frontRightCorner.rotateAngleX = this.backRightCorner.rotateAngleX = this.backLeftCorner.rotateAngleX = this.frontLeftCorner.rotateAngleX = this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
		this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
        this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
	}

}
