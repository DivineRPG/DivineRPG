package net.divinerpg.client.render.entity.vethea.model;

import net.divinerpg.entities.vethea.EntityDuo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class Duo extends ModelBase
{
    //fields
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer rotates1;
    ModelRenderer rotates2;
    ModelRenderer rotates3;
    ModelRenderer rotates4;
    ModelRenderer rotates5;
    ModelRenderer rotates6;
    ModelRenderer rotates7;
    ModelRenderer rotates8;
    ModelRenderer rotates9;
    ModelRenderer rotates10;
    ModelRenderer rotates11;
    ModelRenderer rotates12;
    ModelRenderer rotates13;
    ModelRenderer rotates14;
    ModelRenderer rotates15;
    ModelRenderer rotates17;
    ModelRenderer rotates16;
    ModelRenderer rotates18;
    ModelRenderer rotates19;
    ModelRenderer rotates20;
    ModelRenderer rightleg2;
    ModelRenderer leftleg2;
    ModelRenderer leftleg3;
    ModelRenderer rightleg3;
    ModelRenderer leftleg4;
    ModelRenderer rightleg4;

    public Duo()
    {
        textureWidth = 128;
        textureHeight = 32;

        rightleg = new ModelRenderer(this, 101, 16);
        rightleg.addBox(-4F, -4F, -3F, 6, 4, 6);
        rightleg.setRotationPoint(-7F, 12F, 0F);
        rightleg.setTextureSize(128, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 101, 16);
        leftleg.addBox(-3F, -4F, -3F, 6, 4, 6);
        leftleg.setRotationPoint(8F, 12F, 0F);
        leftleg.setTextureSize(128, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        rotates1 = new ModelRenderer(this, 82, 16);
        rotates1.addBox(4F, -16F, -12F, 4, 12, 4);
        rotates1.setRotationPoint(1F, 14F, 0F);
        rotates1.setTextureSize(128, 32);
        rotates1.mirror = true;
        setRotation(rotates1, -0.1745329F, -3.141593F, 0F);
        rotates2 = new ModelRenderer(this, 82, 16);
        rotates2.addBox(-8F, -15F, -12F, 4, 12, 4);
        rotates2.setRotationPoint(-1F, 13F, 0F);
        rotates2.setTextureSize(128, 32);
        rotates2.mirror = true;
        setRotation(rotates2, -0.1745329F, -3.141593F, 0F);
        rotates3 = new ModelRenderer(this, 54, 20);
        rotates3.addBox(-7F, -8F, -22F, 2, 2, 10);
        rotates3.setRotationPoint(-1F, 13F, 0F);
        rotates3.setTextureSize(128, 32);
        rotates3.mirror = true;
        setRotation(rotates3, -0.1745329F, -3.141593F, 0F);
        rotates4 = new ModelRenderer(this, 34, 0);
        rotates4.addBox(-3F, -18F, -6F, 6, 12, 4);
        rotates4.setRotationPoint(0F, 12F, 0F);
        rotates4.setTextureSize(128, 32);
        rotates4.mirror = true;
        setRotation(rotates4, 0.2617994F, -3.141593F, 0F);
        rotates5 = new ModelRenderer(this, 40, 16);
        rotates5.addBox(-6F, -15F, -9F, 4, 2, 2);
        rotates5.setRotationPoint(-1F, 13F, 0F);
        rotates5.setTextureSize(128, 32);
        rotates5.mirror = true;
        setRotation(rotates5, 0F, -3.141593F, 0F);
        rotates6 = new ModelRenderer(this, 40, 16);
        rotates6.addBox(2F, -16F, -9F, 4, 2, 2);
        rotates6.setRotationPoint(1F, 14F, 0F);
        rotates6.setTextureSize(128, 32);
        rotates6.mirror = true;
        setRotation(rotates6, 0F, -3.141593F, 0F);
        rotates7 = new ModelRenderer(this, 56, 1);
        rotates7.addBox(-4F, -10F, -7F, 8, 7, 6);
        rotates7.setRotationPoint(0F, 12F, 0F);
        rotates7.setTextureSize(128, 32);
        rotates7.mirror = true;
        setRotation(rotates7, 0.2617994F, -3.141593F, 0F);
        rotates8 = new ModelRenderer(this, 0, 0);
        rotates8.addBox(-4F, -25F, -9F, 8, 8, 8);
        rotates8.setRotationPoint(0F, 12F, 0F);
        rotates8.setTextureSize(128, 32);
        rotates8.mirror = true;
        setRotation(rotates8, 0.1745329F, -3.141593F, 0F);
        rotates9 = new ModelRenderer(this, 0, 0);
        rotates9.addBox(-4F, -25F, -10F, 8, 8, 8);
        rotates9.setRotationPoint(0F, 12F, 0F);
        rotates9.setTextureSize(128, 32);
        rotates9.mirror = true;
        setRotation(rotates9, 0.1745329F, 0F, 0F);
        rotates10 = new ModelRenderer(this, 82, 16);
        rotates10.addBox(4F, -16F, -13F, 4, 12, 4);
        rotates10.setRotationPoint(1F, 14F, 0F);
        rotates10.setTextureSize(128, 32);
        rotates10.mirror = true;
        setRotation(rotates10, -0.1745329F, 0F, 0F);
        rotates11 = new ModelRenderer(this, 40, 16);
        rotates11.addBox(-6F, -15F, -10F, 4, 2, 2);
        rotates11.setRotationPoint(-1F, 13F, 0F);
        rotates11.setTextureSize(128, 32);
        rotates11.mirror = true;
        setRotation(rotates11, 0F, 0F, 0F);
        rotates12 = new ModelRenderer(this, 40, 16);
        rotates12.addBox(2F, -16F, -10F, 4, 2, 2);
        rotates12.setRotationPoint(1F, 14F, 0F);
        rotates12.setTextureSize(128, 32);
        rotates12.mirror = true;
        setRotation(rotates12, 0F, 0F, 0F);
        rotates13 = new ModelRenderer(this, 55, 22);
        rotates13.addBox(5F, -7F, -21F, 2, 2, 8);
        rotates13.setRotationPoint(1F, 14F, 0F);
        rotates13.setTextureSize(128, 32);
        rotates13.mirror = true;
        setRotation(rotates13, -0.1745329F, 0F, 0F);
        rotates14 = new ModelRenderer(this, 55, 22);
        rotates14.addBox(-7F, -6F, -21F, 2, 2, 8);
        rotates14.setRotationPoint(-1F, 13F, 0F);
        rotates14.setTextureSize(128, 32);
        rotates14.mirror = true;
        setRotation(rotates14, -0.1745329F, 0F, 0F);
        rotates15 = new ModelRenderer(this, 86, 2);
        rotates15.addBox(-5F, -4F, 0F, 10, 4, 8);
        rotates15.setRotationPoint(0F, 12F, 0F);
        rotates15.setTextureSize(128, 32);
        rotates15.mirror = true;
        setRotation(rotates15, 0F, 0F, 0F);
        rotates17 = new ModelRenderer(this, 82, 16);
        rotates17.addBox(-8F, -15F, -13F, 4, 12, 4);
        rotates17.setRotationPoint(-1F, 13F, 0F);
        rotates17.setTextureSize(128, 32);
        rotates17.mirror = true;
        setRotation(rotates17, -0.1745329F, 0F, 0F);
        rotates16 = new ModelRenderer(this, 34, 0);
        rotates16.addBox(-3F, -18F, -7F, 6, 12, 4);
        rotates16.setRotationPoint(0F, 12F, 0F);
        rotates16.setTextureSize(128, 32);
        rotates16.mirror = true;
        setRotation(rotates16, 0.2617994F, 0F, 0F);
        rotates18 = new ModelRenderer(this, 50, 16);
        rotates18.addBox(-7F, -6F, -25F, 2, 2, 14);
        rotates18.setRotationPoint(-1F, 13F, 0F);
        rotates18.setTextureSize(128, 32);
        rotates18.mirror = true;
        setRotation(rotates18, -0.1745329F, -3.141593F, 0F);
        rotates19 = new ModelRenderer(this, 56, 1);
        rotates19.addBox(-4F, -10F, -8F, 8, 7, 6);
        rotates19.setRotationPoint(0F, 12F, 0F);
        rotates19.setTextureSize(128, 32);
        rotates19.mirror = true;
        setRotation(rotates19, 0.2617994F, 0F, 0F);
        rotates20 = new ModelRenderer(this, 86, 2);
        rotates20.addBox(-5F, -4F, -8F, 10, 4, 8);
        rotates20.setRotationPoint(0F, 12F, 0F);
        rotates20.setTextureSize(128, 32);
        rotates20.mirror = true;
        setRotation(rotates20, 0F, 0F, 0F);
        rightleg2 = new ModelRenderer(this, 19, 17);
        rightleg2.addBox(1F, 9F, -10F, 2, 3, 12);
        rightleg2.setRotationPoint(-7F, 12F, 0F);
        rightleg2.setTextureSize(128, 32);
        rightleg2.mirror = true;
        setRotation(rightleg2, 0F, 0F, 0F);
        leftleg2 = new ModelRenderer(this, 19, 17);
        leftleg2.addBox(2F, 9F, -10F, 2, 3, 12);
        leftleg2.setRotationPoint(8F, 12F, 0F);
        leftleg2.setTextureSize(128, 32);
        leftleg2.mirror = true;
        setRotation(leftleg2, 0F, 0F, 0F);
        leftleg3 = new ModelRenderer(this, 0, 16);
        leftleg3.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg3.setRotationPoint(8F, 12F, 0F);
        leftleg3.setTextureSize(128, 32);
        leftleg3.mirror = true;
        setRotation(leftleg3, 0F, 0F, 0F);
        rightleg3 = new ModelRenderer(this, 0, 16);
        rightleg3.addBox(-3F, 0F, -2F, 4, 12, 4);
        rightleg3.setRotationPoint(-7F, 12F, 0F);
        rightleg3.setTextureSize(128, 32);
        rightleg3.mirror = true;
        setRotation(rightleg3, 0F, 0F, 0F);
        leftleg4 = new ModelRenderer(this, 19, 17);
        leftleg4.addBox(-4F, 9F, -10F, 2, 3, 12);
        leftleg4.setRotationPoint(8F, 12F, 0F);
        leftleg4.setTextureSize(128, 32);
        leftleg4.mirror = true;
        setRotation(leftleg4, 0F, 0F, 0F);
        rightleg4 = new ModelRenderer(this, 19, 17);
        rightleg4.addBox(-5F, 9F, -10F, 2, 3, 12);
        rightleg4.setRotationPoint(-7F, 12F, 0F);
        rightleg4.setTextureSize(128, 32);
        rightleg4.mirror = true;
        setRotation(rightleg4, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles((EntityDuo)entity, f, f1, f2, f3, f4, f5);
        rightleg.render(f5);
        leftleg.render(f5);
        rotates1.render(f5);
        rotates2.render(f5);
        rotates3.render(f5);
        rotates4.render(f5);
        rotates5.render(f5);
        rotates6.render(f5);
        rotates7.render(f5);
        rotates8.render(f5);
        rotates9.render(f5);
        rotates10.render(f5);
        rotates11.render(f5);
        rotates12.render(f5);
        rotates13.render(f5);
        rotates14.render(f5);
        rotates15.render(f5);
        rotates17.render(f5);
        rotates16.render(f5);
        rotates18.render(f5);
        rotates19.render(f5);
        rotates20.render(f5);
        rightleg2.render(f5);
        leftleg2.render(f5);
        leftleg3.render(f5);
        rightleg3.render(f5);
        leftleg4.render(f5);
        rightleg4.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(EntityDuo entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leftleg2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leftleg3.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leftleg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;

        this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.rightleg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.rightleg3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.rightleg4.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;

        if (entity.ability == 1 && this.rotates1.rotateAngleY < Math.PI)
        {
            this.rotates1.rotateAngleY += 0.15;
            this.rotates2.rotateAngleY += 0.15;
            this.rotates3.rotateAngleY += 0.15;
            this.rotates4.rotateAngleY += 0.15;
            this.rotates5.rotateAngleY += 0.15;
            this.rotates6.rotateAngleY += 0.15;
            this.rotates7.rotateAngleY += 0.15;
            this.rotates8.rotateAngleY += 0.15;
            this.rotates9.rotateAngleY += 0.15;
            this.rotates10.rotateAngleY += 0.15;
            this.rotates11.rotateAngleY += 0.15;
            this.rotates12.rotateAngleY += 0.15;
            this.rotates13.rotateAngleY += 0.15;
            this.rotates14.rotateAngleY += 0.15;
            this.rotates15.rotateAngleY += 0.15;
            this.rotates16.rotateAngleY += 0.15;
            this.rotates17.rotateAngleY += 0.15;
            this.rotates18.rotateAngleY += 0.15;
            this.rotates19.rotateAngleY += 0.15;
            this.rotates20.rotateAngleY += 0.15;
        }
        else if (entity.ability == 0 && this.rotates1.rotateAngleY > 0)
        {
            this.rotates1.rotateAngleY -= 0.15;
            this.rotates2.rotateAngleY -= 0.15;
            this.rotates3.rotateAngleY -= 0.15;
            this.rotates4.rotateAngleY -= 0.15;
            this.rotates5.rotateAngleY -= 0.15;
            this.rotates6.rotateAngleY -= 0.15;
            this.rotates7.rotateAngleY -= 0.15;
            this.rotates8.rotateAngleY -= 0.15;
            this.rotates9.rotateAngleY -= 0.15;
            this.rotates10.rotateAngleY -= 0.15;
            this.rotates11.rotateAngleY -= 0.15;
            this.rotates12.rotateAngleY -= 0.15;
            this.rotates13.rotateAngleY -= 0.15;
            this.rotates14.rotateAngleY -= 0.15;
            this.rotates15.rotateAngleY -= 0.15;
            this.rotates16.rotateAngleY -= 0.15;
            this.rotates17.rotateAngleY -= 0.15;
            this.rotates18.rotateAngleY -= 0.15;
            this.rotates19.rotateAngleY -= 0.15;
            this.rotates20.rotateAngleY -= 0.15;
        }
    }

}
