package net.divinerpg.client.render.entity.vethea.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class Husk extends ModelBase
{
    //fields
    ModelRenderer head;
    ModelRenderer tooth2;
    ModelRenderer tooth1;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer leg2;
    ModelRenderer leg1;
    ModelRenderer body;

    public Husk()
    {
        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -4F, -6F, 8, 8, 6);
        head.setRotationPoint(0F, 4F, -7F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        tooth2 = new ModelRenderer(this, 22, 0);
        tooth2.addBox(2F, -7F, 6F, 1, 3, 1);
        tooth2.setRotationPoint(0F, 3F, -6F);
        tooth2.setTextureSize(64, 32);
        tooth2.mirror = true;
        setRotation(tooth2, -3.141593F, 0F, 0F);
        tooth1 = new ModelRenderer(this, 22, 0);
        tooth1.addBox(-3F, -7F, 6F, 1, 3, 1);
        tooth1.setRotationPoint(0F, 3F, -6F);
        tooth1.setTextureSize(64, 32);
        tooth1.mirror = true;
        setRotation(tooth1, -3.141593F, 0F, 0F);
        leg3 = new ModelRenderer(this, 0, 13);
        leg3.addBox(-3F, 0F, -3F, 4, 15, 4);
        leg3.setRotationPoint(-3F, 9F, -5F);
        leg3.setTextureSize(64, 32);
        leg3.mirror = true;
        setRotation(leg3, 0F, 0F, 0F);
        leg4 = new ModelRenderer(this, 0, 13);
        leg4.addBox(-1F, 0F, -3F, 4, 15, 4);
        leg4.setRotationPoint(3F, 9F, -5F);
        leg4.setTextureSize(64, 32);
        leg4.mirror = true;
        setRotation(leg4, 0F, 0F, 0F);
        leg2 = new ModelRenderer(this, 0, 16);
        leg2.addBox(-1F, 0F, -2F, 4, 12, 4);
        leg2.setRotationPoint(3F, 12F, 5F);
        leg2.setTextureSize(64, 32);
        leg2.mirror = true;
        setRotation(leg2, 0F, 0F, 0F);
        leg1 = new ModelRenderer(this, 0, 16);
        leg1.addBox(-3F, 0F, -2F, 4, 12, 4);
        leg1.setRotationPoint(-3F, 12F, 5F);
        leg1.setTextureSize(64, 32);
        leg1.mirror = true;
        setRotation(leg1, 0F, 0F, 0F);
        body = new ModelRenderer(this, 18, 4);
        body.addBox(-6F, -10F, -7F, 12, 18, 10);
        body.setRotationPoint(0F, 5F, 2F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 1.362596F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        head.render(f5);
        tooth2.render(f5);
        tooth1.render(f5);
        leg3.render(f5);
        leg4.render(f5);
        leg2.render(f5);
        leg1.render(f5);
        body.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;

        this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;

        this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    }

}
