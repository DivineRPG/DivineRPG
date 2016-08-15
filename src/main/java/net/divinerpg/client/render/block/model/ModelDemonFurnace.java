package net.divinerpg.client.render.block.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelDemonFurnace extends ModelBase {
    //fields
    ModelRenderer Box;
    ModelRenderer Arm1;
    ModelRenderer Arm2;
    ModelRenderer Arm3;
    ModelRenderer Arm4;
    ModelRenderer Arm5;
    ModelRenderer Arm6;


    public ModelDemonFurnace()
    {

        textureWidth = 64;
        textureHeight = 64;

        Box = new ModelRenderer(this, 0, 0);
        Box.addBox(0F, 0F, 0F, 16, 16, 16);
        Box.setRotationPoint(8F, 8F, -8F);
        Box.setTextureSize(64, 64);
        Box.mirror = true;
        setRotation(Box, 0F, 0F, 3.141593F);
        Arm1 = new ModelRenderer(this, 0, 32);
        Arm1.addBox(0F, 0F, 0F, 4, 19, 2);
        Arm1.setRotationPoint(-7F, -7F, 3F);
        Arm1.setTextureSize(64, 64);
        Arm1.mirror = true;
        setRotation(Arm1, 0F, 0F, 1.256637F);
        Arm2 = new ModelRenderer(this, 0, 32);
        Arm2.addBox(0F, 0F, 0F, 4, 16, 2);
        Arm2.setRotationPoint(-8F, 8F, 3F);
        Arm2.setTextureSize(64, 64);
        Arm2.mirror = true;
        setRotation(Arm2, 0F, 0F, 0F);
        Arm3 = new ModelRenderer(this, 0, 32);
        Arm3.addBox(0F, 0F, 0F, 4, 16, 2);
        Arm3.setRotationPoint(4F, 8F, 3F);
        Arm3.setTextureSize(64, 64);
        Arm3.mirror = true;
        setRotation(Arm3, 0F, 0F, 0F);
        Arm4 = new ModelRenderer(this, 0, 32);
        Arm4.addBox(0F, 0F, 0F, 4, 19, 2);
        Arm4.setRotationPoint(-8F, -4F, 3F);
        Arm4.setTextureSize(64, 64);
        Arm4.mirror = true;
        setRotation(Arm4, 0F, 0F, 0.6632251F);
        Arm5 = new ModelRenderer(this, 0, 32);
        Arm5.addBox(0F, 0F, 0F, 4, 19, 2);
        Arm5.setRotationPoint(6F, -3F, 3F);
        Arm5.setTextureSize(64, 64);
        Arm5.mirror = true;
        setRotation(Arm5, 0F, 0F, -1.256637F);
        Arm6 = new ModelRenderer(this, 0, 32);
        Arm6.addBox(0F, 0F, 0F, 4, 19, 2);
        Arm6.setRotationPoint(4F, -3F, 3F);
        Arm6.setTextureSize(64, 64);
        Arm6.mirror = true;
        setRotation(Arm6, 0F, 0F, -0.6632251F);
    }

    public void render(float f5)
    {
        Box.render(f5);
        Arm1.render(f5);
        Arm2.render(f5);
        Arm3.render(f5);
        Arm4.render(f5);
        Arm5.render(f5);
        Arm6.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity f6)
    {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, f6);
    }
}
