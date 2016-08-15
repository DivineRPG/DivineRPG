package net.divinerpg.client.render.entity.vethea.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class Helio extends ModelBase
{
    //fields
    ModelRenderer head;
    ModelRenderer body1;
    ModelRenderer leftarmp1;
    ModelRenderer rightlegt;
    ModelRenderer leftlegt;
    ModelRenderer body2;
    ModelRenderer body3;
    ModelRenderer body4;
    ModelRenderer body5;
    ModelRenderer body6;
    ModelRenderer leftlegm;
    ModelRenderer rightlegm;
    ModelRenderer leftleg;
    ModelRenderer rightleg;
    ModelRenderer leftarmp2;
    ModelRenderer leftarmp3;
    ModelRenderer leftarmp4;
    ModelRenderer leftarmp5;
    ModelRenderer leftarmp6;

    public Helio()
    {
        textureWidth = 256;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(256, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body1 = new ModelRenderer(this, 76, 0);
        body1.addBox(-4F, 0F, -2F, 6, 10, 3);
        body1.setRotationPoint(7F, 0F, -1F);
        body1.setTextureSize(256, 32);
        body1.mirror = true;
        setRotation(body1, 0F, 0F, 0F);
        leftarmp1 = new ModelRenderer(this, 226, 6);
        leftarmp1.addBox(-1F, -3F, -3F, 8, 6, 6);
        leftarmp1.setRotationPoint(10F, 2F, 0F);
        leftarmp1.setTextureSize(256, 32);
        leftarmp1.mirror = true;
        setRotation(leftarmp1, 0F, 0F, 0F);
        rightlegt = new ModelRenderer(this, 199, 17);
        rightlegt.addBox(-3F, -2F, -3F, 6, 5, 6);
        rightlegt.setRotationPoint(-6F, 12F, 0F);
        rightlegt.setTextureSize(256, 32);
        rightlegt.mirror = true;
        setRotation(rightlegt, 0F, 0F, 0F);
        leftlegt = new ModelRenderer(this, 199, 17);
        leftlegt.addBox(-3F, -2F, -3F, 6, 5, 6);
        leftlegt.setRotationPoint(6F, 12F, 0F);
        leftlegt.setTextureSize(256, 32);
        leftlegt.mirror = true;
        setRotation(leftlegt, 0F, 0F, 0F);
        body2 = new ModelRenderer(this, 76, 0);
        body2.addBox(-4F, 0F, -2F, 6, 10, 3);
        body2.setRotationPoint(7F, 0F, 2F);
        body2.setTextureSize(256, 32);
        body2.mirror = true;
        setRotation(body2, 0F, 0F, 0F);
        body3 = new ModelRenderer(this, 58, 0);
        body3.addBox(-4F, 0F, -2F, 6, 12, 3);
        body3.setRotationPoint(1F, -2F, -1F);
        body3.setTextureSize(256, 32);
        body3.mirror = true;
        setRotation(body3, 0F, 0F, 0F);
        body4 = new ModelRenderer(this, 16, 16);
        body4.addBox(-4F, 0F, -2F, 6, 12, 3);
        body4.setRotationPoint(1F, -2F, 2F);
        body4.setTextureSize(256, 32);
        body4.mirror = true;
        setRotation(body4, 0F, 0F, 0F);
        body5 = new ModelRenderer(this, 40, 0);
        body5.addBox(-4F, 0F, -2F, 6, 10, 3);
        body5.setRotationPoint(-5F, 0F, -1F);
        body5.setTextureSize(256, 32);
        body5.mirror = true;
        setRotation(body5, 0F, 0F, 0F);
        body6 = new ModelRenderer(this, 40, 0);
        body6.addBox(-4F, 0F, -2F, 6, 10, 3);
        body6.setRotationPoint(-5F, 0F, 2F);
        body6.setTextureSize(256, 32);
        body6.mirror = true;
        setRotation(body6, 0F, 0F, 0F);
        leftlegm = new ModelRenderer(this, 97, 0);
        leftlegm.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftlegm.setRotationPoint(6F, 12F, 0F);
        leftlegm.setTextureSize(256, 32);
        leftlegm.mirror = true;
        setRotation(leftlegm, 0F, 0F, 0F);
        rightlegm = new ModelRenderer(this, 97, 0);
        rightlegm.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightlegm.setRotationPoint(-6F, 12F, 0F);
        rightlegm.setTextureSize(256, 32);
        rightlegm.mirror = true;
        setRotation(rightlegm, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 97, 20);
        leftleg.addBox(-3F, 7F, -3F, 6, 5, 6);
        leftleg.setRotationPoint(6F, 12F, 0F);
        leftleg.setTextureSize(256, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 97, 20);
        rightleg.addBox(-3F, 7F, -3F, 6, 5, 6);
        rightleg.setRotationPoint(-6F, 12F, 0F);
        rightleg.setTextureSize(256, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftarmp2 = new ModelRenderer(this, 140, 11);
        leftarmp2.addBox(3F, 10F, 10F, 12, 9, 12);
        leftarmp2.setRotationPoint(10F, 2F, 0F);
        leftarmp2.setTextureSize(256, 32);
        leftarmp2.mirror = true;
        setRotation(leftarmp2, -1.570796F, 0.6108652F, 0F);
        leftarmp3 = new ModelRenderer(this, 36, 16);
        leftarmp3.addBox(1F, -2F, -2F, 4, 12, 4);
        leftarmp3.setRotationPoint(10F, 2F, 0F);
        leftarmp3.setTextureSize(256, 32);
        leftarmp3.mirror = true;
        setRotation(leftarmp3, 0F, 0F, 0F);
        leftarmp4 = new ModelRenderer(this, 69, 17);
        leftarmp4.addBox(0F, 6F, 0F, 6, 9, 6);
        leftarmp4.setRotationPoint(10F, 2F, 0F);
        leftarmp4.setTextureSize(256, 32);
        leftarmp4.mirror = true;
        setRotation(leftarmp4, -0.5235988F, 0F, 0F);
        leftarmp5 = new ModelRenderer(this, 116, 1);
        leftarmp5.addBox(1F, 9F, 3F, 8, 9, 8);
        leftarmp5.setRotationPoint(10F, 2F, 0F);
        leftarmp5.setTextureSize(256, 32);
        leftarmp5.mirror = true;
        setRotation(leftarmp5, -0.8726646F, 0.2974289F, 0F);
        leftarmp6 = new ModelRenderer(this, 193, 10);
        leftarmp6.addBox(0F, 9F, 9F, 10, 9, 10);
        leftarmp6.setRotationPoint(10F, 2F, 0F);
        leftarmp6.setTextureSize(256, 32);
        leftarmp6.mirror = true;
        setRotation(leftarmp6, -1.396263F, 0.2974289F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        head.render(f5);
        body1.render(f5);
        leftarmp1.render(f5);
        rightlegt.render(f5);
        leftlegt.render(f5);
        body2.render(f5);
        body3.render(f5);
        body4.render(f5);
        body5.render(f5);
        body6.render(f5);
        leftlegm.render(f5);
        rightlegm.render(f5);
        leftleg.render(f5);
        rightleg.render(f5);
        leftarmp2.render(f5);
        leftarmp3.render(f5);
        leftarmp4.render(f5);
        leftarmp5.render(f5);
        leftarmp6.render(f5);
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
