package net.divinerpg.client.render.entity.vethea.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class Shadahier extends ModelBase
{
    //fields
    ModelRenderer part1;
    ModelRenderer part2;
    ModelRenderer part3;
    ModelRenderer part4;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer rightarm1;
    ModelRenderer leftarm1;
    ModelRenderer leftarm2;
    ModelRenderer rightarm2;
    ModelRenderer leftarm3;
    ModelRenderer rightarm3;
    ModelRenderer leftarm4;
    ModelRenderer rightarm4;
    ModelRenderer leftarm5;
    ModelRenderer rightarm5;
    ModelRenderer leftarm6;
    ModelRenderer rightarm6;
    ModelRenderer part5;
    ModelRenderer part6;
    ModelRenderer part7;
    ModelRenderer part8;
    ModelRenderer part9;
    ModelRenderer part10;
    ModelRenderer part11;
    ModelRenderer part12;
    ModelRenderer part13;
    ModelRenderer part14;

    public Shadahier()
    {
        textureWidth = 64;
        textureHeight = 32;

        part1 = new ModelRenderer(this, 56, 26);
        part1.addBox(8F, -9F, -3F, 2, 4, 2);
        part1.setRotationPoint(0F, 10F, 0F);
        part1.setTextureSize(64, 32);
        part1.mirror = true;
        setRotation(part1, 0F, 0F, 0F);
        part2 = new ModelRenderer(this, 16, 16);
        part2.addBox(-4F, 0F, -2F, 8, 7, 4);
        part2.setRotationPoint(0F, 10F, 0F);
        part2.setTextureSize(64, 32);
        part2.mirror = true;
        setRotation(part2, 0F, 0F, 0F);
        part3 = new ModelRenderer(this, 33, 0);
        part3.addBox(-3F, -3F, -3F, 6, 4, 6);
        part3.setRotationPoint(-7F, 12F, 0F);
        part3.setTextureSize(64, 32);
        part3.mirror = true;
        setRotation(part3, 0F, 0F, 0F);
        part4 = new ModelRenderer(this, 33, 0);
        part4.addBox(-3F, -3F, -3F, 6, 4, 6);
        part4.setRotationPoint(7F, 12F, 0F);
        part4.setTextureSize(64, 32);
        part4.mirror = true;
        setRotation(part4, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 21);
        rightleg.addBox(-2F, 0F, -2F, 4, 7, 4);
        rightleg.setRotationPoint(-3F, 17F, 0F);
        rightleg.setTextureSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 21);
        leftleg.addBox(-2F, 0F, -2F, 4, 7, 4);
        leftleg.setRotationPoint(3F, 17F, 0F);
        leftleg.setTextureSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        rightarm1 = new ModelRenderer(this, 58, 0);
        rightarm1.addBox(-1F, 2F, 2F, 2, 8, 1);
        rightarm1.setRotationPoint(-7F, 12F, 0F);
        rightarm1.setTextureSize(64, 32);
        rightarm1.mirror = true;
        setRotation(rightarm1, 0F, 0F, 0.5235988F);
        leftarm1 = new ModelRenderer(this, 58, 0);
        leftarm1.addBox(-1F, 2F, 2F, 2, 8, 1);
        leftarm1.setRotationPoint(7F, 12F, 0F);
        leftarm1.setTextureSize(64, 32);
        leftarm1.mirror = true;
        setRotation(leftarm1, 0F, 0F, -0.5235988F);
        leftarm2 = new ModelRenderer(this, 40, 12);
        leftarm2.addBox(0F, 6F, -7F, 2, 2, 6);
        leftarm2.setRotationPoint(7F, 12F, 0F);
        leftarm2.setTextureSize(64, 32);
        leftarm2.mirror = true;
        setRotation(leftarm2, 0F, 0F, 0F);
        rightarm2 = new ModelRenderer(this, 40, 12);
        rightarm2.addBox(-2F, 6F, -7F, 2, 2, 6);
        rightarm2.setRotationPoint(-7F, 12F, 0F);
        rightarm2.setTextureSize(64, 32);
        rightarm2.mirror = true;
        setRotation(rightarm2, 0F, 0F, 0F);
        leftarm3 = new ModelRenderer(this, 58, 0);
        leftarm3.addBox(-1F, 2F, -1F, 2, 8, 1);
        leftarm3.setRotationPoint(7F, 12F, 1F);
        leftarm3.setTextureSize(64, 32);
        leftarm3.mirror = true;
        setRotation(leftarm3, 0F, 0F, -0.5235988F);
        rightarm3 = new ModelRenderer(this, 58, 0);
        rightarm3.addBox(-1F, 2F, -1F, 2, 8, 1);
        rightarm3.setRotationPoint(-7F, 12F, 1F);
        rightarm3.setTextureSize(64, 32);
        rightarm3.mirror = true;
        setRotation(rightarm3, 0F, 0F, 0.5235988F);
        leftarm4 = new ModelRenderer(this, 58, 0);
        leftarm4.addBox(-1F, 2F, -3F, 2, 8, 1);
        leftarm4.setRotationPoint(7F, 12F, 0F);
        leftarm4.setTextureSize(64, 32);
        leftarm4.mirror = true;
        setRotation(leftarm4, 0F, 0F, -0.5235988F);
        rightarm4 = new ModelRenderer(this, 58, 0);
        rightarm4.addBox(-1F, 2F, -3F, 2, 8, 1);
        rightarm4.setRotationPoint(-7F, 12F, 0F);
        rightarm4.setTextureSize(64, 32);
        rightarm4.mirror = true;
        setRotation(rightarm4, 0F, 0F, 0.5235988F);
        leftarm5 = new ModelRenderer(this, 58, 0);
        leftarm5.addBox(-1F, 2F, -1F, 2, 8, 1);
        leftarm5.setRotationPoint(7F, 12F, 0F);
        leftarm5.setTextureSize(64, 32);
        leftarm5.mirror = true;
        setRotation(leftarm5, 0F, 0F, -0.5235988F);
        rightarm5 = new ModelRenderer(this, 58, 0);
        rightarm5.addBox(-1F, 2F, -1F, 2, 8, 1);
        rightarm5.setRotationPoint(-7F, 12F, 0F);
        rightarm5.setTextureSize(64, 32);
        rightarm5.mirror = true;
        setRotation(rightarm5, 0F, 0F, 0.5235988F);
        leftarm6 = new ModelRenderer(this, 40, 20);
        leftarm6.addBox(-1F, 1F, -2F, 4, 8, 4);
        leftarm6.setRotationPoint(7F, 12F, 0F);
        leftarm6.setTextureSize(64, 32);
        leftarm6.mirror = true;
        setRotation(leftarm6, 0F, 0F, 0F);
        rightarm6 = new ModelRenderer(this, 40, 20);
        rightarm6.addBox(-3F, 1F, -2F, 4, 8, 4);
        rightarm6.setRotationPoint(-7F, 12F, 0F);
        rightarm6.setTextureSize(64, 32);
        rightarm6.mirror = true;
        setRotation(rightarm6, 0F, 0F, 0F);
        part5 = new ModelRenderer(this, 52, 11);
        part5.addBox(1F, -4F, -5F, 2, 2, 4);
        part5.setRotationPoint(0F, 10F, 0F);
        part5.setTextureSize(64, 32);
        part5.mirror = true;
        setRotation(part5, 0.7853982F, 0F, 0F);
        part6 = new ModelRenderer(this, 56, 26);
        part6.addBox(-10F, -9F, -3F, 2, 4, 2);
        part6.setRotationPoint(0F, 10F, 0F);
        part6.setTextureSize(64, 32);
        part6.mirror = true;
        setRotation(part6, 0F, 0F, 0F);
        part7 = new ModelRenderer(this, 33, 11);
        part7.addBox(4F, -7F, -3F, 4, 2, 2);
        part7.setRotationPoint(0F, 10F, 0F);
        part7.setTextureSize(64, 32);
        part7.mirror = true;
        setRotation(part7, 0F, 0F, 0F);
        part8 = new ModelRenderer(this, 33, 11);
        part8.addBox(-8F, -7F, -3F, 4, 2, 2);
        part8.setRotationPoint(0F, 10F, 0F);
        part8.setTextureSize(64, 32);
        part8.mirror = true;
        setRotation(part8, 0F, 0F, 0F);
        part9 = new ModelRenderer(this, 56, 26);
        part9.addBox(-10F, -9F, 1F, 2, 4, 2);
        part9.setRotationPoint(0F, 10F, 0F);
        part9.setTextureSize(64, 32);
        part9.mirror = true;
        setRotation(part9, 0F, 0F, 0F);
        part10 = new ModelRenderer(this, 33, 11);
        part10.addBox(-8F, -7F, 1F, 4, 2, 2);
        part10.setRotationPoint(0F, 10F, 0F);
        part10.setTextureSize(64, 32);
        part10.mirror = true;
        setRotation(part10, 0F, 0F, 0F);
        part11 = new ModelRenderer(this, 33, 11);
        part11.addBox(4F, -7F, 1F, 4, 2, 2);
        part11.setRotationPoint(0F, 10F, 0F);
        part11.setTextureSize(64, 32);
        part11.mirror = true;
        setRotation(part11, 0F, 0F, 0F);
        part12 = new ModelRenderer(this, 56, 26);
        part12.addBox(8F, -9F, 1F, 2, 4, 2);
        part12.setRotationPoint(0F, 10F, 0F);
        part12.setTextureSize(64, 32);
        part12.mirror = true;
        setRotation(part12, 0F, 0F, 0F);
        part13 = new ModelRenderer(this, 0, 0);
        part13.addBox(-4F, -8F, -4F, 8, 8, 8);
        part13.setRotationPoint(0F, 10F, 0F);
        part13.setTextureSize(64, 32);
        part13.mirror = true;
        setRotation(part13, 0F, 0F, 0F);
        part14 = new ModelRenderer(this, 52, 11);
        part14.addBox(-3F, -4F, -5F, 2, 2, 4);
        part14.setRotationPoint(0F, 10F, 0F);
        part14.setTextureSize(64, 32);
        part14.mirror = true;
        setRotation(part14, 0.7853982F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        part1.render(f5);
        part2.render(f5);
        part3.render(f5);
        part4.render(f5);
        rightleg.render(f5);
        leftleg.render(f5);
        rightarm1.render(f5);
        leftarm1.render(f5);
        leftarm2.render(f5);
        rightarm2.render(f5);
        leftarm3.render(f5);
        rightarm3.render(f5);
        leftarm4.render(f5);
        rightarm4.render(f5);
        leftarm5.render(f5);
        rightarm5.render(f5);
        leftarm6.render(f5);
        rightarm6.render(f5);
        part5.render(f5);
        part6.render(f5);
        part7.render(f5);
        part8.render(f5);
        part9.render(f5);
        part10.render(f5);
        part11.render(f5);
        part12.render(f5);
        part13.render(f5);
        part14.render(f5);
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

        this.rightarm1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
        this.rightarm2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
        this.rightarm3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
        this.rightarm4.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
        this.rightarm5.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
        this.rightarm6.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;

        this.leftarm1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.leftarm2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.leftarm3.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.leftarm4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.leftarm5.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.leftarm6.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    }

}
