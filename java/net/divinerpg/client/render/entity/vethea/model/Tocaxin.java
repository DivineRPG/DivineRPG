package net.divinerpg.client.render.entity.vethea.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class Tocaxin extends ModelBase
{
    //fields
    ModelRenderer part1;
    ModelRenderer part2;
    ModelRenderer rightarm1;
    ModelRenderer leftarm1;
    ModelRenderer leftleg1;
    ModelRenderer rightleg1;
    ModelRenderer leftleg2;
    ModelRenderer rightleg2;
    ModelRenderer part3;
    ModelRenderer part4;
    ModelRenderer part5;
    ModelRenderer part6;
    ModelRenderer rightarm2;
    ModelRenderer leftarm2;
    ModelRenderer rightarm3;
    ModelRenderer leftarm3;
    ModelRenderer part7;
    ModelRenderer part8;
    ModelRenderer part9;
    ModelRenderer part10;
    ModelRenderer part11;

    public Tocaxin()
    {
        textureWidth = 128;
        textureHeight = 32;

        part1 = new ModelRenderer(this, 0, 0);
        part1.addBox(-4F, -10F, -4F, 8, 8, 8);
        part1.setRotationPoint(0F, -22F, -7F);
        part1.setTextureSize(128, 32);
        part1.mirror = true;
        setRotation(part1, 0.4014257F, 0F, 0F);
        part2 = new ModelRenderer(this, 34, 2);
        part2.addBox(-2F, -15F, -4F, 4, 6, 2);
        part2.setRotationPoint(0F, -12F, 0F);
        part2.setTextureSize(128, 32);
        part2.mirror = true;
        setRotation(part2, 0.4014257F, 0F, 0F);
        rightarm1 = new ModelRenderer(this, 64, 0);
        rightarm1.addBox(-2F, 8F, 4F, 2, 2, 30);
        rightarm1.setRotationPoint(-11F, -10F, 0F);
        rightarm1.setTextureSize(128, 32);
        rightarm1.mirror = true;
        setRotation(rightarm1, -1.570796F, 0F, 0F);
        leftarm1 = new ModelRenderer(this, 40, 16);
        leftarm1.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm1.setRotationPoint(11F, -10F, 0F);
        leftarm1.setTextureSize(128, 32);
        leftarm1.mirror = true;
        setRotation(leftarm1, -1.047198F, 0F, 0F);
        leftleg1 = new ModelRenderer(this, 0, 16);
        leftleg1.addBox(-2F, 12F, -1F, 2, 12, 2);
        leftleg1.setRotationPoint(-1F, 0F, 0F);
        leftleg1.setTextureSize(128, 32);
        leftleg1.mirror = true;
        setRotation(leftleg1, 0F, 0F, 0F);
        rightleg1 = new ModelRenderer(this, 0, 16);
        rightleg1.addBox(-2F, 12F, -1F, 2, 12, 2);
        rightleg1.setRotationPoint(3F, 0F, 0F);
        rightleg1.setTextureSize(128, 32);
        rightleg1.mirror = true;
        setRotation(rightleg1, 0F, 0F, 0F);
        leftleg2 = new ModelRenderer(this, 0, 16);
        leftleg2.addBox(-2F, 0F, -1F, 2, 12, 2);
        leftleg2.setRotationPoint(-1F, 0F, 0F);
        leftleg2.setTextureSize(128, 32);
        leftleg2.mirror = true;
        setRotation(leftleg2, 0F, 0F, 0F);
        rightleg2 = new ModelRenderer(this, 0, 16);
        rightleg2.addBox(-2F, 0F, -1F, 2, 12, 2);
        rightleg2.setRotationPoint(3F, 0F, 0F);
        rightleg2.setTextureSize(128, 32);
        rightleg2.mirror = true;
        setRotation(rightleg2, 0F, 0F, 0F);
        part3 = new ModelRenderer(this, 46, 9);
        part3.addBox(-7F, 0F, 0F, 20, 3, 2);
        part3.setRotationPoint(-3F, -12F, -4F);
        part3.setTextureSize(128, 32);
        part3.mirror = true;
        setRotation(part3, 0.4014257F, 0F, 0F);
        part4 = new ModelRenderer(this, 68, 15);
        part4.addBox(-4F, -12F, -2F, 8, 12, 2);
        part4.setRotationPoint(0F, -12F, -4F);
        part4.setTextureSize(128, 32);
        part4.mirror = true;
        setRotation(part4, 0.4014257F, 0F, 0F);
        part5 = new ModelRenderer(this, 59, 2);
        part5.addBox(-4F, -4F, 0F, 14, 3, 2);
        part5.setRotationPoint(-3F, -12F, -4F);
        part5.setTextureSize(128, 32);
        part5.mirror = true;
        setRotation(part5, 0.4014257F, 0F, 0F);
        part6 = new ModelRenderer(this, 59, 2);
        part6.addBox(-4F, -9F, 0F, 14, 3, 2);
        part6.setRotationPoint(-3F, -12F, -4F);
        part6.setTextureSize(128, 32);
        part6.mirror = true;
        setRotation(part6, 0.4014257F, 0F, 0F);
        rightarm2 = new ModelRenderer(this, 40, 16);
        rightarm2.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm2.setRotationPoint(-11F, -10F, 0F);
        rightarm2.setTextureSize(128, 32);
        rightarm2.mirror = true;
        setRotation(rightarm2, -1.047198F, 0F, 0F);
        leftarm2 = new ModelRenderer(this, 64, 0);
        leftarm2.addBox(0F, 8F, 4F, 2, 2, 30);
        leftarm2.setRotationPoint(11F, -10F, 0F);
        leftarm2.setTextureSize(128, 32);
        leftarm2.mirror = true;
        setRotation(leftarm2, -1.570796F, 0F, 0F);
        rightarm3 = new ModelRenderer(this, 100, 16);
        rightarm3.addBox(-4F, 6F, 1F, 6, 6, 6);
        rightarm3.setRotationPoint(-11F, -10F, 0F);
        rightarm3.setTextureSize(128, 32);
        rightarm3.mirror = true;
        setRotation(rightarm3, -1.570796F, 0F, 0F);
        leftarm3 = new ModelRenderer(this, 100, 16);
        leftarm3.addBox(-2F, 6F, 1F, 6, 6, 6);
        leftarm3.setRotationPoint(11F, -10F, 0F);
        leftarm3.setTextureSize(128, 32);
        leftarm3.mirror = true;
        setRotation(leftarm3, -1.570796F, 0F, 0F);
        part7 = new ModelRenderer(this, 41, 16);
        part7.addBox(-4F, 0F, -2F, 8, 12, 2);
        part7.setRotationPoint(0F, -12F, 0F);
        part7.setTextureSize(128, 32);
        part7.mirror = true;
        setRotation(part7, 0.4014257F, 0F, 0F);
        part8 = new ModelRenderer(this, 41, 16);
        part8.addBox(-4F, 0F, -2F, 8, 12, 2);
        part8.setRotationPoint(0F, -12F, -4F);
        part8.setTextureSize(128, 32);
        part8.mirror = true;
        setRotation(part8, 0.4014257F, 0F, 0F);
        part9 = new ModelRenderer(this, 59, 2);
        part9.addBox(-4F, 10F, 0F, 14, 3, 2);
        part9.setRotationPoint(-3F, -12F, -4F);
        part9.setTextureSize(128, 32);
        part9.mirror = true;
        setRotation(part9, 0.4014257F, 0F, 0F);
        part10 = new ModelRenderer(this, 59, 2);
        part10.addBox(-4F, 5F, 0F, 14, 3, 2);
        part10.setRotationPoint(-3F, -12F, -4F);
        part10.setTextureSize(128, 32);
        part10.mirror = true;
        setRotation(part10, 0.4014257F, 0F, 0F);
        part11 = new ModelRenderer(this, 68, 15);
        part11.addBox(-4F, -12F, -2F, 8, 12, 2);
        part11.setRotationPoint(0F, -12F, 0F);
        part11.setTextureSize(128, 32);
        part11.mirror = true;
        setRotation(part11, 0.4014257F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        part1.render(f5);
        part2.render(f5);
        rightarm1.render(f5);
        leftarm1.render(f5);
        leftleg1.render(f5);
        rightleg1.render(f5);
        leftleg2.render(f5);
        rightleg2.render(f5);
        part3.render(f5);
        part4.render(f5);
        part5.render(f5);
        part6.render(f5);
        rightarm2.render(f5);
        leftarm2.render(f5);
        rightarm3.render(f5);
        leftarm3.render(f5);
        part7.render(f5);
        part8.render(f5);
        part9.render(f5);
        part10.render(f5);
        part11.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.leftleg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leftleg2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;

        this.rightleg1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.rightleg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;

        this.rightarm1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F + -1.570796F;
        this.rightarm2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F-1.047198F;
        this.rightarm3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F-1.570796F;

        this.leftarm1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F-1.047198F;
        this.leftarm2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F-1.570796F;
        this.leftarm3.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F-1.570796F;
    }

}
