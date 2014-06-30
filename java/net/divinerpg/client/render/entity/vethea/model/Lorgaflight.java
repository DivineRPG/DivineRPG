package net.divinerpg.client.render.entity.vethea.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Lorgaflight extends ModelBase
{
    //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer body4;
    ModelRenderer body5;
    ModelRenderer body6;
    ModelRenderer body7;
    ModelRenderer body8;

    public Lorgaflight()
    {
        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, -3F, 0F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 21, 16);
        body.addBox(-1F, 3F, 5F, 10, 4, 4);
        body.setRotationPoint(-4F, 7F, 0F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 0.6981317F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 2, 12, 4);
        rightarm.setRotationPoint(-5F, 1F, 3F);
        rightarm.setTextureSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 1.047198F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 2, 12, 4);
        leftarm.setRotationPoint(7F, -1F, 3F);
        leftarm.setTextureSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, -1.047198F);
        body2 = new ModelRenderer(this, 26, 0);
        body2.addBox(-1F, 0F, -2F, 2, 2, 2);
        body2.setRotationPoint(2F, -3F, 1F);
        body2.setTextureSize(64, 32);
        body2.mirror = true;
        setRotation(body2, 0.6981317F, 0F, 0F);
        body2.mirror = false;
        body3 = new ModelRenderer(this, 55, 0);
        body3.addBox(-1F, 0F, -2F, 2, 12, 2);
        body3.setRotationPoint(0F, -4F, 1F);
        body3.setTextureSize(64, 32);
        body3.mirror = true;
        setRotation(body3, 0.6981317F, 0F, 0F);
        body4 = new ModelRenderer(this, 26, 0);
        body4.addBox(-1F, 0F, -2F, 2, 2, 2);
        body4.setRotationPoint(-2F, -3F, 1F);
        body4.setTextureSize(64, 32);
        body4.mirror = true;
        setRotation(body4, 0.6981317F, 0F, 0F);
        body5 = new ModelRenderer(this, 36, 0);
        body5.addBox(-1F, 0F, 1F, 5, 2, 2);
        body5.setRotationPoint(-5F, 1F, 1F);
        body5.setTextureSize(64, 32);
        body5.mirror = true;
        setRotation(body5, 0.6981317F, 0F, 0F);
        body6 = new ModelRenderer(this, 36, 0);
        body6.addBox(-1F, 0F, 1F, 5, 2, 2);
        body6.setRotationPoint(2F, 1F, 1F);
        body6.setTextureSize(64, 32);
        body6.mirror = true;
        setRotation(body6, 0.6981317F, 0F, 0F);
        body7 = new ModelRenderer(this, 26, 0);
        body7.addBox(-1F, 0F, 4F, 2, 2, 2);
        body7.setRotationPoint(-2F, 5F, 1F);
        body7.setTextureSize(64, 32);
        body7.mirror = true;
        setRotation(body7, 0.6981317F, 0F, 0F);
        body8 = new ModelRenderer(this, 26, 0);
        body8.addBox(-1F, 0F, 4F, 2, 2, 2);
        body8.setRotationPoint(2F, 5F, 1F);
        body8.setTextureSize(64, 32);
        body8.mirror = true;
        setRotation(body8, 0.6981317F, 0F, 0F);
        body8.mirror = false;
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        head.render(f5);
        body.render(f5);
        rightarm.render(f5);
        leftarm.render(f5);
        body2.render(f5);
        body3.render(f5);
        body4.render(f5);
        body5.render(f5);
        body6.render(f5);
        body7.render(f5);
        body8.render(f5);
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
