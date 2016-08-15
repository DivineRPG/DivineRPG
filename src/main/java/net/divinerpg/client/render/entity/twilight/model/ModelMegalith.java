package net.divinerpg.client.render.entity.twilight.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelMegalith extends ModelBase {
    
    ModelRenderer torso;
    ModelRenderer body;
    ModelRenderer rightArm;
    ModelRenderer rightHand;
    ModelRenderer leftArm;
    ModelRenderer leftHand;
    ModelRenderer rightLeg;
    ModelRenderer leftLeg;
    ModelRenderer upperBody;
    ModelRenderer head;

    public ModelMegalith() {
        textureWidth = 256;
        textureHeight = 64;

        torso = new ModelRenderer(this, 64, 0);
        torso.addBox(0F, 0F, 0F, 16, 16, 8);
        torso.setRotationPoint(-8F, -8F, -4F);
        torso.setTextureSize(256, 64);
        torso.mirror = true;
        setRotation(torso, 0F, 0F, 0F);
        body = new ModelRenderer(this, 0, 0);
        body.addBox(0F, 0F, 0F, 20, 12, 12);
        body.setRotationPoint(-10F, -20F, -6F);
        body.setTextureSize(256, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightArm = new ModelRenderer(this, 30, 42);
        rightArm.addBox(-3F, 3F, -3F, 6, 16, 6);
        rightArm.setRotationPoint(-13F, -32F, 0F);
        rightArm.setTextureSize(256, 64);
        rightArm.mirror = true;
        setRotation(rightArm, 0F, 0F, 0.0872665F);
        rightHand = new ModelRenderer(this, 0, 24);
        rightHand.addBox(-4.5F, 19F, -4.5F, 9, 8, 9);
        rightHand.setRotationPoint(-13F, -32F, 0F);
        rightHand.setTextureSize(256, 64);
        rightHand.mirror = true;
        setRotation(rightHand, 0F, 0F, 0.0872665F);
        leftArm = new ModelRenderer(this, 30, 42);
        leftArm.addBox(-3F, 3F, -3F, 6, 16, 6);
        leftArm.setRotationPoint(13F, -32F, 0F);
        leftArm.setTextureSize(256, 64);
        leftArm.mirror = true;
        setRotation(leftArm, 0F, 0F, -0.0872665F);
        leftHand = new ModelRenderer(this, 0, 24);
        leftHand.addBox(-4.5F, 19F, -4.5F, 9, 8, 9);
        leftHand.setRotationPoint(13F, -32F, 0F);
        leftHand.setTextureSize(256, 64);
        leftHand.mirror = true;
        setRotation(leftHand, 0F, 0F, -0.0872665F);
        rightLeg = new ModelRenderer(this, 54, 38);
        rightLeg.addBox(-4F, 0F, -5F, 8, 16, 10);
        rightLeg.setRotationPoint(-6F, 8F, 0F);
        rightLeg.setTextureSize(256, 64);
        rightLeg.mirror = true;
        setRotation(rightLeg, 0F, 0F, 0F);
        leftLeg = new ModelRenderer(this, 54, 38);
        leftLeg.addBox(-4F, 0F, -5F, 8, 16, 10);
        leftLeg.setRotationPoint(6F, 8F, 0F);
        leftLeg.setTextureSize(256, 64);
        leftLeg.mirror = true;
        setRotation(leftLeg, 0F, 0F, 0F);
        upperBody = new ModelRenderer(this, 112, 0);
        upperBody.addBox(0F, 0F, 0F, 22, 12, 14);
        upperBody.setRotationPoint(-11F, -32F, -7F);
        upperBody.setTextureSize(256, 64);
        upperBody.mirror = true;
        setRotation(upperBody, 0F, 0F, 0F);
        head = new ModelRenderer(this, 0, 49);
        head.addBox(-3F, 0F, -3F, 6, 9, 6);
        head.setRotationPoint(0F, -41F, 0F);
        head.setTextureSize(256, 64);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        torso.render(f5);
        body.render(f5);
        rightArm.render(f5);
        rightHand.render(f5);
        leftArm.render(f5);
        leftHand.render(f5);
        rightLeg.render(f5);
        leftLeg.render(f5);
        upperBody.render(f5);
        head.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
        this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
        this.leftLeg.rotateAngleX = this.rightHand.rotateAngleX = this.rightArm.rotateAngleX = MathHelper.cos(f)*f1;
        this.rightLeg.rotateAngleX = this.leftHand.rotateAngleX = this.leftArm.rotateAngleX = MathHelper.cos(f+(float)Math.PI)*f1*0.7f;
    }

}
