package net.divinerpg.client.render.entity.arcana.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

// Date: 12/3/2012 5:06:02 PMage net.minecraft.src;

public class ModelRazorback extends ModelBase
{
    //fields
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer Spike1;
    ModelRenderer Spike2;
    ModelRenderer Spike3;
    ModelRenderer Spike4;
    ModelRenderer Spike5;
    ModelRenderer Spike6;
    ModelRenderer Spike7;
    ModelRenderer Spike8;
    ModelRenderer Spike9;
    ModelRenderer Spike10;

    public ModelRazorback()
    {
        textureWidth = 64;
        textureHeight = 32;
        body = new ModelRenderer(this, 18, 4);
        body.addBox(0F, 0F, 0F, 8, 8, 3);
        body.setRotationPoint(-4F, 22F, -4F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, ((float)Math.PI / 2F), 0F, 0F);
        leg1 = new ModelRenderer(this, 0, 19);
        leg1.addBox(-2F, 0F, 0F, 1, 3, 1);
        leg1.setRotationPoint(-3F, 21F, 3F);
        leg1.setTextureSize(64, 32);
        leg1.mirror = true;
        setRotation(leg1, 0F, 0F, 0F);
        leg2 = new ModelRenderer(this, 0, 19);
        leg2.addBox(0F, 0F, 0F, 1, 3, 1);
        leg2.setRotationPoint(4F, 21F, 3F);
        leg2.setTextureSize(64, 32);
        leg2.mirror = true;
        setRotation(leg2, 0F, 0F, 0F);
        leg3 = new ModelRenderer(this, 0, 19);
        leg3.addBox(-2F, 0F, -1F, 1, 3, 1);
        leg3.setRotationPoint(-3F, 21F, -3F);
        leg3.setTextureSize(64, 32);
        leg3.mirror = true;
        setRotation(leg3, 0F, 0F, 0F);
        leg4 = new ModelRenderer(this, 0, 19);
        leg4.addBox(0F, 0F, -1F, 1, 3, 1);
        leg4.setRotationPoint(4F, 21F, -3F);
        leg4.setTextureSize(64, 32);
        leg4.mirror = true;
        setRotation(leg4, 0F, 0F, 0F);
        Spike1 = new ModelRenderer(this, 0, 25);
        Spike1.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike1.setRotationPoint(3F, 17F, 0F);
        Spike1.setTextureSize(64, 32);
        Spike1.mirror = true;
        setRotation(Spike1, 0F, 0F, 0F);
        Spike2 = new ModelRenderer(this, 0, 25);
        Spike2.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike2.setRotationPoint(-3F, 17F, 0F);
        Spike2.setTextureSize(64, 32);
        Spike2.mirror = true;
        setRotation(Spike2, 0F, 0F, 0F);
        Spike3 = new ModelRenderer(this, 0, 25);
        Spike3.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike3.setRotationPoint(-4F, 17F, -3F);
        Spike3.setTextureSize(64, 32);
        Spike3.mirror = true;
        setRotation(Spike3, 0F, 0F, 0F);
        Spike4 = new ModelRenderer(this, 0, 25);
        Spike4.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike4.setRotationPoint(-4F, 17F, 2F);
        Spike4.setTextureSize(64, 32);
        Spike4.mirror = true;
        setRotation(Spike4, 0F, 0F, 0F);
        Spike5 = new ModelRenderer(this, 0, 25);
        Spike5.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike5.setRotationPoint(2F, 17F, 2F);
        Spike5.setTextureSize(64, 32);
        Spike5.mirror = true;
        setRotation(Spike5, 0F, 0F, 0F);
        Spike6 = new ModelRenderer(this, 0, 25);
        Spike6.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike6.setRotationPoint(2F, 17F, -2F);
        Spike6.setTextureSize(64, 32);
        Spike6.mirror = true;
        setRotation(Spike6, 0F, 0F, 0F);
        Spike7 = new ModelRenderer(this, 0, 25);
        Spike7.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike7.setRotationPoint(0F, 17F, -3F);
        Spike7.setTextureSize(64, 32);
        Spike7.mirror = true;
        setRotation(Spike7, 0F, 0F, 0F);
        Spike8 = new ModelRenderer(this, 0, 25);
        Spike8.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike8.setRotationPoint(-1F, 17F, -1F);
        Spike8.setTextureSize(64, 32);
        Spike8.mirror = true;
        setRotation(Spike8, 0F, 0F, 0F);
        Spike9 = new ModelRenderer(this, 0, 25);
        Spike9.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike9.setRotationPoint(3F, 17F, -4F);
        Spike9.setTextureSize(64, 32);
        Spike9.mirror = true;
        setRotation(Spike9, 0F, 0F, 0F);
        Spike10 = new ModelRenderer(this, 0, 25);
        Spike10.addBox(0F, 0F, 0F, 1, 2, 1);
        Spike10.setRotationPoint(-1F, 17F, 3F);
        Spike10.setTextureSize(64, 32);
        Spike10.mirror = true;
        setRotation(Spike10, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        body.render(f5);
        leg1.render(f5);
        leg2.render(f5);
        leg3.render(f5);
        leg4.render(f5);
        Spike1.render(f5);
        Spike2.render(f5);
        Spike3.render(f5);
        Spike4.render(f5);
        Spike5.render(f5);
        Spike6.render(f5);
        Spike7.render(f5);
        Spike8.render(f5);
        Spike9.render(f5);
        Spike10.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity f6)
    {
        this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    }
}
