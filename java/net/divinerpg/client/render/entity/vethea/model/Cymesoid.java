package net.divinerpg.client.render.entity.vethea.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class Cymesoid extends ModelBase
{
    //fields
    ModelRenderer head;
    ModelRenderer bodyext1;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer body;
    ModelRenderer bodyext2;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;

    public Cymesoid()
    {
        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        bodyext1 = new ModelRenderer(this, 20, 22);
        bodyext1.addBox(-12F, 0F, 2F, 8, 6, 2);
        bodyext1.setRotationPoint(4F, 8F, 0F);
        bodyext1.setTextureSize(64, 32);
        bodyext1.mirror = true;
        setRotation(bodyext1, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setRotationPoint(-5F, 2F, 0F);
        rightarm.setTextureSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setRotationPoint(5F, 2F, 0F);
        leftarm.setTextureSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setRotationPoint(-2F, 12F, 0F);
        rightleg.setTextureSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setRotationPoint(2F, 12F, 0F);
        leftleg.setTextureSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        body = new ModelRenderer(this, 16, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setRotationPoint(0F, 0F, 0F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        bodyext2 = new ModelRenderer(this, 19, 22);
        bodyext2.addBox(-4F, 0F, 2F, 8, 6, 2);
        bodyext2.setRotationPoint(4F, 8F, 0F);
        bodyext2.setTextureSize(64, 32);
        bodyext2.mirror = true;
        setRotation(bodyext2, 0F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 35, 0);
        Shape1.addBox(0F, 0F, 0F, 12, 14, 0);
        Shape1.setRotationPoint(1F, 0F, 2F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, -2.094395F, -0.7853982F);
        Shape2 = new ModelRenderer(this, 35, 0);
        Shape2.addBox(0F, 0F, 0F, 12, 14, 0);
        Shape2.setRotationPoint(1F, 0F, 2F);
        Shape2.setTextureSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, -2.356194F, -0.6108652F);
        Shape3 = new ModelRenderer(this, 35, 0);
        Shape3.addBox(0F, 0F, 0F, 12, 14, 0);
        Shape3.setRotationPoint(1F, 0F, 2F);
        Shape3.setTextureSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, -2.617994F, -0.4363323F);
        Shape4 = new ModelRenderer(this, 35, 0);
        Shape4.addBox(2F, 0F, 0F, 12, 14, 0);
        Shape4.setRotationPoint(2F, 0F, 2F);
        Shape4.setTextureSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, 0F, -2.96706F, -0.2617994F);
        Shape5 = new ModelRenderer(this, 35, 0);
        Shape5.addBox(0F, 0F, 0F, 12, 14, 0);
        Shape5.setRotationPoint(2F, 0F, 2F);
        Shape5.setTextureSize(64, 32);
        Shape5.mirror = true;
        setRotation(Shape5, 0F, -0.2617994F, -0.2617994F);
        Shape6 = new ModelRenderer(this, 35, 0);
        Shape6.addBox(0F, 0F, 0F, 12, 14, 0);
        Shape6.setRotationPoint(0F, 0F, 2F);
        Shape6.setTextureSize(64, 32);
        Shape6.mirror = true;
        setRotation(Shape6, 0F, -0.5235988F, -0.4363323F);
        Shape7 = new ModelRenderer(this, 35, 0);
        Shape7.addBox(0F, 0F, 0F, 12, 14, 0);
        Shape7.setRotationPoint(-1F, 0F, 2F);
        Shape7.setTextureSize(64, 32);
        Shape7.mirror = true;
        setRotation(Shape7, 0F, -0.7853982F, -0.6108652F);
        Shape8 = new ModelRenderer(this, 35, 0);
        Shape8.addBox(0F, 0F, 0F, 12, 14, 0);
        Shape8.setRotationPoint(-1F, 0F, 2F);
        Shape8.setTextureSize(64, 32);
        Shape8.mirror = true;
        setRotation(Shape8, 0F, -1.047198F, -0.7853982F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        head.render(f5);
        bodyext1.render(f5);
        rightarm.render(f5);
        leftarm.render(f5);
        rightleg.render(f5);
        leftleg.render(f5);
        body.render(f5);
        bodyext2.render(f5);
        Shape1.render(f5);
        Shape2.render(f5);
        Shape3.render(f5);
        Shape4.render(f5);
        Shape5.render(f5);
        Shape6.render(f5);
        Shape7.render(f5);
        Shape8.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;

        this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;

        this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F + 0.0872665F;

        this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F + 0.0872665F;
    }

}
