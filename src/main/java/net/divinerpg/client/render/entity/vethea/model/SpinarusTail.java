package net.divinerpg.client.render.entity.vethea.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class SpinarusTail extends ModelBase
{
    //fields
    ModelRenderer part1;
    ModelRenderer part2;
    ModelRenderer part3;

    public SpinarusTail()
    {
        textureWidth = 64;
        textureHeight = 32;

        part1 = new ModelRenderer(this, 0, 0);
        part1.addBox(-5F, -2F, -10F, 10, 4, 10);
        part1.setRotationPoint(0F, 0F, 0F);
        part1.setTextureSize(64, 32);
        part1.mirror = true;
        setRotation(part1, 0F, 0F, 0F);
        part2 = new ModelRenderer(this, 0, 14);
        part2.addBox(-4F, -1F, 0F, 8, 3, 5);
        part2.setRotationPoint(0F, 0F, 0F);
        part2.setTextureSize(64, 32);
        part2.mirror = true;
        setRotation(part2, 0F, 0F, 0F);
        part3 = new ModelRenderer(this, 0, 22);
        part3.addBox(-4F, -1F, 0F, 6, 1, 5);
        part3.setRotationPoint(1F, 1F, 5F);
        part3.setTextureSize(64, 32);
        part3.mirror = true;
        setRotation(part3, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        part1.render(f5);
        part2.render(f5);
        part3.render(f5);
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
