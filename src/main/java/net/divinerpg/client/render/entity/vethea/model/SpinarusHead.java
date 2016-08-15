package net.divinerpg.client.render.entity.vethea.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SpinarusHead extends ModelBase
{
    //fields
    ModelRenderer part1;
    ModelRenderer part2;
    ModelRenderer part3;
    ModelRenderer part4;
    ModelRenderer part5;
    ModelRenderer part6;
    ModelRenderer part7;
    ModelRenderer part8;
    ModelRenderer part9;

    public SpinarusHead()
    {
        textureWidth = 64;
        textureHeight = 32;

        part1 = new ModelRenderer(this, 0, 0);
        part1.addBox(-5F, -2F, -10F, 10, 4, 10);
        part1.setRotationPoint(0F, 0F, 0F);
        part1.setTextureSize(64, 32);
        part1.mirror = true;
        setRotation(part1, 0F, 0F, 0F);
        part2 = new ModelRenderer(this, 0, 19);
        part2.addBox(-1F, -1F, 15F, 2, 2, 7);
        part2.setRotationPoint(-4F, 0F, -9F);
        part2.setTextureSize(64, 32);
        part2.mirror = true;
        setRotation(part2, 0F, 0.5235988F, 0F);
        part3 = new ModelRenderer(this, 0, 19);
        part3.addBox(-1F, -1F, 15F, 2, 2, 7);
        part3.setRotationPoint(4F, 0F, -9F);
        part3.setTextureSize(64, 32);
        part3.mirror = true;
        setRotation(part3, 0F, -0.5235988F, 0F);
        part4 = new ModelRenderer(this, 0, 14);
        part4.addBox(-1F, -1F, -4F, 1, 1, 4);
        part4.setRotationPoint(-1F, 0F, -10F);
        part4.setTextureSize(64, 32);
        part4.mirror = true;
        setRotation(part4, 0F, 0.3490659F, 0F);
        part5 = new ModelRenderer(this, 0, 14);
        part5.addBox(0F, -1F, -4F, 1, 1, 4);
        part5.setRotationPoint(1F, 0F, -10F);
        part5.setTextureSize(64, 32);
        part5.mirror = true;
        setRotation(part5, 0F, -0.3490659F, 0F);
        part6 = new ModelRenderer(this, 40, 0);
        part6.addBox(-4F, -1F, 0F, 8, 2, 1);
        part6.setRotationPoint(0F, 0F, 0F);
        part6.setTextureSize(64, 32);
        part6.mirror = true;
        setRotation(part6, 0F, 0F, 0F);
        part7 = new ModelRenderer(this, 0, 0);
        part7.addBox(-5F, -2F, 0F, 10, 4, 10);
        part7.setRotationPoint(0F, 0F, 1F);
        part7.setTextureSize(64, 32);
        part7.mirror = true;
        setRotation(part7, 0F, 0F, 0F);
        part8 = new ModelRenderer(this, 0, 19);
        part8.addBox(-1F, -1F, -7F, 2, 2, 7);
        part8.setRotationPoint(4F, 0F, -9F);
        part8.setTextureSize(64, 32);
        part8.mirror = true;
        setRotation(part8, 0F, -0.5235988F, 0F);
        part9 = new ModelRenderer(this, 0, 19);
        part9.addBox(-1F, -1F, -7F, 2, 2, 7);
        part9.setRotationPoint(-4F, 0F, -9F);
        part9.setTextureSize(64, 32);
        part9.mirror = true;
        setRotation(part9, 0F, 0.5235988F, 0F);
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
        part5.render(f5);
        part6.render(f5);
        part7.render(f5);
        part8.render(f5);
        part9.render(f5);
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
