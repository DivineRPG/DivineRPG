package net.divinerpg.client.render.entity.twilight.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelNesro extends ModelBase
{
    //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leftarmbox;
    ModelRenderer leftarm;
    ModelRenderer rightlegext;
    ModelRenderer leftlegext;
    ModelRenderer leftleg;
    ModelRenderer rightleg;
    ModelRenderer rightarm;
    ModelRenderer rightarmbox;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;

    public ModelNesro()
    {
        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 2F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 25, 16);
        body.addBox(-7F, 0F, -2F, 14, 12, 4);
        body.setRotationPoint(0F, 0F, 2F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 0.4461433F, 0F, 0F);
        leftarmbox = new ModelRenderer(this, 32, 0);
        leftarmbox.addBox(-2F, 10F, -3F, 6, 4, 6);
        leftarmbox.setRotationPoint(8F, 2F, 3F);
        leftarmbox.setTextureSize(64, 32);
        leftarmbox.mirror = true;
        setRotation(leftarmbox, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setRotationPoint(8F, 2F, 3F);
        leftarm.setTextureSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightlegext = new ModelRenderer(this, 0, 16);
        rightlegext.addBox(-2F, 0F, -6F, 4, 3, 8);
        rightlegext.setRotationPoint(-4F, 9F, 4F);
        rightlegext.setTextureSize(64, 32);
        rightlegext.mirror = true;
        setRotation(rightlegext, 0F, 0F, 0F);
        leftlegext = new ModelRenderer(this, 0, 16);
        leftlegext.addBox(-2F, 0F, -6F, 4, 3, 8);
        leftlegext.setRotationPoint(4F, 9F, 4F);
        leftlegext.setTextureSize(64, 32);
        leftlegext.mirror = true;
        setRotation(leftlegext, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-2F, 3F, -6F, 4, 12, 4);
        leftleg.setRotationPoint(4F, 9F, 4F);
        leftleg.setTextureSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-2F, 3F, -6F, 4, 12, 4);
        rightleg.setRotationPoint(-4F, 9F, 4F);
        rightleg.setTextureSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setRotationPoint(-8F, 2F, 3F);
        rightarm.setTextureSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        rightarmbox = new ModelRenderer(this, 32, 0);
        rightarmbox.addBox(-4F, 10F, -3F, 6, 4, 6);
        rightarmbox.setRotationPoint(-8F, 2F, 3F);
        rightarmbox.setTextureSize(64, 32);
        rightarmbox.mirror = true;
        setRotation(rightarmbox, 0F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 57, 0);
        Shape1.addBox(-5F, 0F, 0F, 2, 9, 1);
        Shape1.setRotationPoint(-1F, -3F, 10F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, -0.5948578F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 57, 0);
        Shape2.addBox(-5F, 0F, 0F, 2, 9, 1);
        Shape2.setRotationPoint(-1F, 0F, 12F);
        Shape2.setTextureSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, -0.5948578F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 57, 0);
        Shape3.addBox(0F, 0F, 0F, 2, 9, 1);
        Shape3.setRotationPoint(-1F, -3F, 10F);
        Shape3.setTextureSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, -0.5948578F, 0F, 0F);
        Shape4 = new ModelRenderer(this, 57, 0);
        Shape4.addBox(0F, 0F, 0F, 2, 9, 1);
        Shape4.setRotationPoint(-1F, 0F, 12F);
        Shape4.setTextureSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, -0.5948578F, 0F, 0F);
        Shape5 = new ModelRenderer(this, 57, 0);
        Shape5.addBox(5F, 0F, 0F, 2, 9, 1);
        Shape5.setRotationPoint(-1F, -3F, 10F);
        Shape5.setTextureSize(64, 32);
        Shape5.mirror = true;
        setRotation(Shape5, -0.5948578F, 0F, 0F);
        Shape6 = new ModelRenderer(this, 57, 0);
        Shape6.addBox(5F, 0F, 0F, 2, 9, 1);
        Shape6.setRotationPoint(-1F, 0F, 12F);
        Shape6.setTextureSize(64, 32);
        Shape6.mirror = true;
        setRotation(Shape6, -0.5948578F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        head.render(f5);
        body.render(f5);
        leftarmbox.render(f5);
        leftarm.render(f5);
        rightlegext.render(f5);
        leftlegext.render(f5);
        leftleg.render(f5);
        rightleg.render(f5);
        rightarm.render(f5);
        rightarmbox.render(f5);
        Shape1.render(f5);
        Shape2.render(f5);
        Shape3.render(f5);
        Shape4.render(f5);
        Shape5.render(f5);
        Shape6.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        this.head.rotateAngleY = var4 / (180F / (float)Math.PI);
        this.head.rotateAngleX = var5 / (180F / (float)Math.PI);
        this.rightarm.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
        this.rightarmbox.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
        this.leftarm.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.leftarmbox.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.rightarm.rotateAngleZ = 0.0F;
        this.rightarmbox.rotateAngleZ = 0.0F;
        this.leftarm.rotateAngleZ = 0.0F;
        this.leftarmbox.rotateAngleZ = 0.0F;
        this.rightleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.rightlegext.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.leftleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        this.leftlegext.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        this.rightleg.rotateAngleY = 0.0F;
        this.rightlegext.rotateAngleY = 0.0F;
        this.leftleg.rotateAngleY = 0.0F;
        this.leftlegext.rotateAngleY = 0.0F;

        this.rightarm.rotateAngleY = 0.0F;
        this.rightarmbox.rotateAngleY = 0.0F;
        this.leftarm.rotateAngleY = 0.0F;
        this.leftarmbox.rotateAngleY = 0.0F;

        this.rightarm.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.leftarm.rotateAngleZ -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.rightarmbox.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.leftarmbox.rotateAngleZ -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;

        this.rightarm.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.leftarm.rotateAngleX -= MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.rightarmbox.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.leftarmbox.rotateAngleX -= MathHelper.sin(var3 * 0.067F) * 0.05F;
    }

}
