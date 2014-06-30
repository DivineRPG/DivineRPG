package net.divinerpg.client.render.entity.iceika.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelWorkshop extends ModelBase
{
    //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarmtop;
    ModelRenderer rightlegbottom;
    ModelRenderer rightleg;
    ModelRenderer leftlegbottom;
    ModelRenderer leftleg;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer leftarmtop;

    public ModelWorkshop()
    {
        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, -7F, 0F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new ModelRenderer(this, 30, 14);
        body.addBox(-4F, 0F, -2F, 8, 14, 4);
        body.setRotationPoint(0F, -7F, 0F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarmtop = new ModelRenderer(this, 37, 16);
        rightarmtop.addBox(-6F, -3F, -2F, 8, 5, 6);
        rightarmtop.setRotationPoint(-6F, -5F, -1F);
        rightarmtop.setTextureSize(64, 32);
        rightarmtop.mirror = true;
        setRotation(rightarmtop, 0F, 0F, 0F);
        rightlegbottom = new ModelRenderer(this, 0, 16);
        rightlegbottom.addBox(-3F, 8F, -3F, 6, 9, 6);
        rightlegbottom.setRotationPoint(-4F, 7F, 0F);
        rightlegbottom.setTextureSize(64, 32);
        rightlegbottom.mirror = true;
        setRotation(rightlegbottom, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setRotationPoint(-4F, 7F, 0F);
        rightleg.setTextureSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftlegbottom = new ModelRenderer(this, 0, 16);
        leftlegbottom.addBox(-3F, 8F, -3F, 6, 9, 6);
        leftlegbottom.setRotationPoint(4F, 7F, 0F);
        leftlegbottom.setTextureSize(64, 32);
        leftlegbottom.mirror = true;
        setRotation(leftlegbottom, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setRotationPoint(4F, 7F, 0F);
        leftleg.setTextureSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-5F, 2F, -2F, 4, 12, 4);
        rightarm.setRotationPoint(-6F, -5F, 0F);
        rightarm.setTextureSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(0F, 2F, -2F, 4, 12, 4);
        leftarm.setRotationPoint(7F, -5F, 0F);
        leftarm.setTextureSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        leftarmtop = new ModelRenderer(this, 36, 16);
        leftarmtop.addBox(-3F, -3F, -2F, 8, 5, 6);
        leftarmtop.setRotationPoint(7F, -5F, -1F);
        leftarmtop.setTextureSize(64, 32);
        leftarmtop.mirror = true;
        setRotation(leftarmtop, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        body.render(f5);
        rightarmtop.render(f5);
        rightlegbottom.render(f5);
        rightleg.render(f5);
        leftlegbottom.render(f5);
        leftleg.render(f5);
        rightarm.render(f5);
        leftarm.render(f5);
        leftarmtop.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
    {
        this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
        this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
        this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
        this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.rightarm.rotateAngleZ = 0.0F;
        this.leftarm.rotateAngleZ = 0.0F;
        this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.rightleg.rotateAngleY = 0.0F;
        this.leftleg.rotateAngleY = 0.0F;
        this.rightarmtop.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
        this.leftarmtop.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.rightarmtop.rotateAngleZ = 0.0F;
        this.leftarmtop.rotateAngleZ = 0.0F;
        this.rightlegbottom.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leftlegbottom.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.rightlegbottom.rotateAngleY = 0.0F;
        this.leftlegbottom.rotateAngleY = 0.0F;
    }

}
