package net.divinerpg.client.render.entity.vethea.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHungerHungry extends ModelBase
{
    //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarmm;
    ModelRenderer leftarmb;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer leftarmt;
    ModelRenderer leftarmm;
    ModelRenderer rightarmt;
    ModelRenderer rightarmb;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape7;
    ModelRenderer Shape6;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;

    public ModelHungerHungry()
    {
        textureWidth = 56;
        textureHeight = 64;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(56, 64);
        head.mirror = true;
        setRotation(head, -0.7853982F, 0F, 0F);
        body = new ModelRenderer(this, 16, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setRotationPoint(0F, 0F, 0F);
        body.setTextureSize(56, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarmm = new ModelRenderer(this, 40, 16);
        rightarmm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarmm.setRotationPoint(-5F, 7F, 0.5F);
        rightarmm.setTextureSize(56, 64);
        rightarmm.mirror = true;
        setRotation(rightarmm, 0.1745329F, 0F, 1.570796F);
        leftarmb = new ModelRenderer(this, 40, 16);
        leftarmb.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarmb.setRotationPoint(3F, 9F, 0.5F);
        leftarmb.setTextureSize(56, 64);
        leftarmb.mirror = true;
        setRotation(leftarmb, 0.1745329F, 0F, -0.9250245F);
        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setRotationPoint(-2F, 12F, 0F);
        rightleg.setTextureSize(56, 64);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setRotationPoint(2F, 12F, 0F);
        leftleg.setTextureSize(56, 64);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        leftarmt = new ModelRenderer(this, 40, 16);
        leftarmt.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarmt.setRotationPoint(5F, 3F, 0.5F);
        leftarmt.setTextureSize(56, 64);
        leftarmt.mirror = true;
        setRotation(leftarmt, 0.1745329F, 0F, -2.042035F);
        leftarmm = new ModelRenderer(this, 40, 16);
        leftarmm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarmm.setRotationPoint(5F, 7F, 0.5F);
        leftarmm.setTextureSize(56, 64);
        leftarmm.mirror = true;
        setRotation(leftarmm, 0.1745329F, 0F, -1.570796F);
        rightarmt = new ModelRenderer(this, 40, 16);
        rightarmt.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarmt.setRotationPoint(-5F, 3F, 0.5F);
        rightarmt.setTextureSize(56, 64);
        rightarmt.mirror = true;
        setRotation(rightarmt, 0.1745329F, 0F, 2.042035F);
        rightarmb = new ModelRenderer(this, 40, 16);
        rightarmb.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarmb.setRotationPoint(-3F, 9F, 0.5F);
        rightarmb.setTextureSize(56, 64);
        rightarmb.mirror = true;
        setRotation(rightarmb, 0.1745329F, 0F, 0.9250245F);
        Shape1 = new ModelRenderer(this, 0, 32);
        Shape1.addBox(0F, 0F, -9F, 8, 2, 9);
        Shape1.setRotationPoint(-4F, 2F, -1F);
        Shape1.setTextureSize(56, 64);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 0, 32);
        Shape2.addBox(0F, 0F, -7F, 6, 1, 8);
        Shape2.setRotationPoint(-3F, 1F, -2F);
        Shape2.setTextureSize(56, 64);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 0, 32);
        Shape3.addBox(0F, 0F, -9F, 8, 2, 9);
        Shape3.setRotationPoint(-4F, 8F, -1F);
        Shape3.setTextureSize(56, 64);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
        Shape3.mirror = false;
        Shape4 = new ModelRenderer(this, 0, 32);
        Shape4.addBox(0F, 0F, -7F, 6, 1, 8);
        Shape4.setRotationPoint(-3F, 10F, -2F);
        Shape4.setTextureSize(56, 64);
        Shape4.mirror = true;
        setRotation(Shape4, 0F, 0F, 0F);
        Shape4.mirror = false;
        Shape5 = new ModelRenderer(this, 0, 0);
        Shape5.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape5.setRotationPoint(2F, 3.4F, -9F);
        Shape5.setTextureSize(56, 64);
        Shape5.mirror = true;
        setRotation(Shape5, 0F, 0F, 0F);
        Shape7 = new ModelRenderer(this, 0, 0);
        Shape7.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape7.setRotationPoint(-0.5F, 3.4F, -9F);
        Shape7.setTextureSize(56, 64);
        Shape7.mirror = true;
        setRotation(Shape7, 0F, 0F, 0F);
        Shape6 = new ModelRenderer(this, 0, 0);
        Shape6.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape6.setRotationPoint(-3F, 3.4F, -9F);
        Shape6.setTextureSize(56, 64);
        Shape6.mirror = true;
        setRotation(Shape6, 0F, 0F, 0F);
        Shape8 = new ModelRenderer(this, 0, 0);
        Shape8.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape8.setRotationPoint(2F, 3.4F, -7F);
        Shape8.setTextureSize(56, 64);
        Shape8.mirror = true;
        setRotation(Shape8, 0F, 0F, 0F);
        Shape9 = new ModelRenderer(this, 0, 0);
        Shape9.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape9.setRotationPoint(2F, 3.4F, -5F);
        Shape9.setTextureSize(56, 64);
        Shape9.mirror = true;
        setRotation(Shape9, 0F, 0F, 0F);
        Shape10 = new ModelRenderer(this, 0, 0);
        Shape10.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape10.setRotationPoint(-3F, 3.4F, -7F);
        Shape10.setTextureSize(56, 64);
        Shape10.mirror = true;
        setRotation(Shape10, 0F, 0F, 0F);
        Shape11 = new ModelRenderer(this, 0, 0);
        Shape11.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape11.setRotationPoint(-3F, 3.4F, -5F);
        Shape11.setTextureSize(56, 64);
        Shape11.mirror = true;
        setRotation(Shape11, 0F, 0F, 0F);
        Shape12 = new ModelRenderer(this, 0, 0);
        Shape12.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape12.setRotationPoint(-1.7F, 7.4F, -9F);
        Shape12.setTextureSize(56, 64);
        Shape12.mirror = true;
        setRotation(Shape12, 0F, 0F, 0F);
        Shape13 = new ModelRenderer(this, 0, 0);
        Shape13.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape13.setRotationPoint(2F, 7.4F, -6F);
        Shape13.setTextureSize(56, 64);
        Shape13.mirror = true;
        setRotation(Shape13, 0F, 0F, 0F);
        Shape14 = new ModelRenderer(this, 0, 0);
        Shape14.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape14.setRotationPoint(-3F, 7.4F, -6F);
        Shape14.setTextureSize(56, 64);
        Shape14.mirror = true;
        setRotation(Shape14, 0F, 0F, 0F);
        Shape15 = new ModelRenderer(this, 0, 0);
        Shape15.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape15.setRotationPoint(0.7F, 7.4F, -9F);
        Shape15.setTextureSize(56, 64);
        Shape15.mirror = true;
        setRotation(Shape15, 0F, 0F, 0F);
        Shape16 = new ModelRenderer(this, 0, 0);
        Shape16.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape16.setRotationPoint(2F, 7.4F, -8F);
        Shape16.setTextureSize(56, 64);
        Shape16.mirror = true;
        setRotation(Shape16, 0F, 0F, 0F);
        Shape17 = new ModelRenderer(this, 0, 0);
        Shape17.addBox(0F, 0F, 0F, 1, 2, 1);
        Shape17.setRotationPoint(-3F, 7.4F, -8F);
        Shape17.setTextureSize(56, 64);
        Shape17.mirror = true;
        setRotation(Shape17, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        head.render(f5);
        body.render(f5);
        rightarmm.render(f5);
        leftarmb.render(f5);
        rightleg.render(f5);
        leftleg.render(f5);
        leftarmt.render(f5);
        leftarmm.render(f5);
        rightarmt.render(f5);
        rightarmb.render(f5);
        Shape1.render(f5);
        Shape2.render(f5);
        Shape3.render(f5);
        Shape4.render(f5);
        Shape5.render(f5);
        Shape7.render(f5);
        Shape6.render(f5);
        Shape8.render(f5);
        Shape9.render(f5);
        Shape10.render(f5);
        Shape11.render(f5);
        Shape12.render(f5);
        Shape13.render(f5);
        Shape14.render(f5);
        Shape15.render(f5);
        Shape16.render(f5);
        Shape17.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
    }

}
