package net.divinerpg.client.render.entity.vethea.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class Ehu extends ModelBase
{
    //fields
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer spine;
    ModelRenderer head;
    ModelRenderer body;

    public Ehu()
    {
        textureWidth = 64;
        textureHeight = 32;

        leg1 = new ModelRenderer(this, 0, 16);
        leg1.addBox(-2F, 0F, -2F, 4, 7, 4);
        leg1.setRotationPoint(-3F, 17F, 7F);
        leg1.setTextureSize(64, 32);
        leg1.mirror = true;
        setRotation(leg1, 0F, 0F, 0F);
        leg2 = new ModelRenderer(this, 0, 16);
        leg2.addBox(-2F, 0F, -2F, 4, 7, 4);
        leg2.setRotationPoint(3F, 17F, 7F);
        leg2.setTextureSize(64, 32);
        leg2.mirror = true;
        setRotation(leg2, 0F, 0F, 0F);
        leg3 = new ModelRenderer(this, 0, 16);
        leg3.addBox(-2F, 0F, -2F, 4, 7, 4);
        leg3.setRotationPoint(-3F, 17F, -4F);
        leg3.setTextureSize(64, 32);
        leg3.mirror = true;
        setRotation(leg3, 0F, 0F, 0F);
        leg4 = new ModelRenderer(this, 0, 16);
        leg4.addBox(-2F, 0F, -2F, 4, 7, 4);
        leg4.setRotationPoint(3F, 17F, -4F);
        leg4.setTextureSize(64, 32);
        leg4.mirror = true;
        setRotation(leg4, 0F, 0F, 0F);
        spine = new ModelRenderer(this, 17, 10);
        spine.addBox(0F, -6F, 0F, 0, 14, 5);
        spine.setRotationPoint(0F, 12.64F, 0F);
        spine.setTextureSize(64, 32);
        spine.mirror = true;
        setRotation(spine, 1.689768F, 0F, 0F);
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -5F, -5F, 8, 6, 5);
        head.setRotationPoint(0F, 17F, -5F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 28, 8);
        body.addBox(-5F, -10F, -7F, 10, 16, 8);
        body.setRotationPoint(0F, 11F, 3F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 1.689768F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        leg1.render(f5);
        leg2.render(f5);
        leg3.render(f5);
        leg4.render(f5);
        spine.render(f5);
        head.render(f5);
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
