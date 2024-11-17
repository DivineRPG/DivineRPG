package net.divinerpg.client.render.entity.vethea.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class Biphron extends ModelBase
{
    //fields
    ModelRenderer head;
    ModelRenderer bodytop;
    ModelRenderer rightarmts1;
    ModelRenderer leftarmts1;
    ModelRenderer rightlegts1;
    ModelRenderer leftlegts1;
    ModelRenderer leftlegts2;
    ModelRenderer rightlegts2;
    ModelRenderer rightarmtspike1;
    ModelRenderer leftarmtspike1;
    ModelRenderer rightarmts2;
    ModelRenderer leftarmts2;
    ModelRenderer leftarmtspike2;
    ModelRenderer rightarmtspike2;
    ModelRenderer bodybottom;
    ModelRenderer rightarms1;
    ModelRenderer leftarms1;
    ModelRenderer leftarms2;
    ModelRenderer leftarmspike1;
    ModelRenderer leftarmspike2;
    ModelRenderer rightarmspike1;
    ModelRenderer rightarms2;
    ModelRenderer rightarmspike2;
    ModelRenderer leftlegs1;
    ModelRenderer leftlegs2;
    ModelRenderer rightlegs2;
    ModelRenderer rightlegs1;

    public Biphron()
    {
        textureWidth = 64;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        bodytop = new ModelRenderer(this, 16, 16);
        bodytop.addBox(-4F, 0F, -2F, 8, 12, 4);
        bodytop.setRotationPoint(0F, -8F, 0F);
        bodytop.setTextureSize(64, 32);
        bodytop.mirror = true;
        setRotation(bodytop, -3.141593F, 0F, 0F);
        rightarmts1 = new ModelRenderer(this, 48, 12);
        rightarmts1.addBox(-3F, -2F, -2F, 4, 3, 4);
        rightarmts1.setRotationPoint(-5F, -10F, 0F);
        rightarmts1.setTextureSize(64, 32);
        rightarmts1.mirror = true;
        setRotation(rightarmts1, -3.141593F, 0F, 0F);
        leftarmts1 = new ModelRenderer(this, 48, 12);
        leftarmts1.addBox(7F, -2F, -2F, 4, 3, 4);
        leftarmts1.setRotationPoint(-3F, -10F, 0F);
        leftarmts1.setTextureSize(64, 32);
        leftarmts1.mirror = true;
        setRotation(leftarmts1, -3.141593F, 0F, 0F);
        rightlegts1 = new ModelRenderer(this, 41, 23);
        rightlegts1.addBox(-3F, -3F, -3F, 6, 3, 6);
        rightlegts1.setRotationPoint(-6F, -20F, 0F);
        rightlegts1.setTextureSize(64, 32);
        rightlegts1.mirror = true;
        setRotation(rightlegts1, -3.141593F, 0F, 0F);
        leftlegts1 = new ModelRenderer(this, 41, 23);
        leftlegts1.addBox(-3F, -3F, -3F, 6, 3, 6);
        leftlegts1.setRotationPoint(6F, -20F, 0F);
        leftlegts1.setTextureSize(64, 32);
        leftlegts1.mirror = true;
        setRotation(leftlegts1, -3.141593F, 0F, 0F);
        leftlegts2 = new ModelRenderer(this, 0, 16);
        leftlegts2.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftlegts2.setRotationPoint(6F, -20F, 0F);
        leftlegts2.setTextureSize(64, 32);
        leftlegts2.mirror = true;
        setRotation(leftlegts2, -3.141593F, 0F, 0F);
        rightlegts2 = new ModelRenderer(this, 0, 16);
        rightlegts2.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightlegts2.setRotationPoint(-6F, -20F, 0F);
        rightlegts2.setTextureSize(64, 32);
        rightlegts2.mirror = true;
        setRotation(rightlegts2, -3.141593F, 0F, 0F);
        rightarmtspike1 = new ModelRenderer(this, 33, 0);
        rightarmtspike1.addBox(-7F, 6F, 1F, 1, 8, 1);
        rightarmtspike1.setRotationPoint(-5F, -10F, 0F);
        rightarmtspike1.setTextureSize(64, 32);
        rightarmtspike1.mirror = true;
        setRotation(rightarmtspike1, -3.141593F, 0F, 0F);
        leftarmtspike1 = new ModelRenderer(this, 33, 0);
        leftarmtspike1.addBox(6F, 6F, 1F, 1, 8, 1);
        leftarmtspike1.setRotationPoint(5F, -10F, 0F);
        leftarmtspike1.setTextureSize(64, 32);
        leftarmtspike1.mirror = true;
        setRotation(leftarmtspike1, -3.141593F, 0F, 0F);
        rightarmts2 = new ModelRenderer(this, 37, 0);
        rightarmts2.addBox(-7F, -2F, -2F, 4, 8, 4);
        rightarmts2.setRotationPoint(-5F, -10F, 0F);
        rightarmts2.setTextureSize(64, 32);
        rightarmts2.mirror = true;
        setRotation(rightarmts2, -3.141593F, 0F, 0F);
        leftarmts2 = new ModelRenderer(this, 37, 0);
        leftarmts2.addBox(3F, -2F, -2F, 4, 8, 4);
        leftarmts2.setRotationPoint(5F, -10F, 0F);
        leftarmts2.setTextureSize(64, 32);
        leftarmts2.mirror = true;
        setRotation(leftarmts2, -3.141593F, 0F, 0F);
        leftarmtspike2 = new ModelRenderer(this, 33, 0);
        leftarmtspike2.addBox(6F, 6F, -2F, 1, 8, 1);
        leftarmtspike2.setRotationPoint(5F, -10F, 0F);
        leftarmtspike2.setTextureSize(64, 32);
        leftarmtspike2.mirror = true;
        setRotation(leftarmtspike2, -3.141593F, 0F, 0F);
        rightarmtspike2 = new ModelRenderer(this, 33, 0);
        rightarmtspike2.addBox(-7F, 6F, -2F, 1, 8, 1);
        rightarmtspike2.setRotationPoint(-5F, -10F, 0F);
        rightarmtspike2.setTextureSize(64, 32);
        rightarmtspike2.mirror = true;
        setRotation(rightarmtspike2, -3.141593F, 0F, 0F);
        bodybottom = new ModelRenderer(this, 16, 16);
        bodybottom.addBox(-4F, 0F, -2F, 8, 12, 4);
        bodybottom.setRotationPoint(0F, 0F, 0F);
        bodybottom.setTextureSize(64, 32);
        bodybottom.mirror = true;
        setRotation(bodybottom, 0F, 0F, 0F);
        rightarms1 = new ModelRenderer(this, 48, 12);
        rightarms1.addBox(-3F, -2F, -2F, 4, 3, 4);
        rightarms1.setRotationPoint(-5F, 2F, 0F);
        rightarms1.setTextureSize(64, 32);
        rightarms1.mirror = true;
        setRotation(rightarms1, 0F, 0F, 0F);
        leftarms1 = new ModelRenderer(this, 48, 12);
        leftarms1.addBox(7F, -2F, -2F, 4, 3, 4);
        leftarms1.setRotationPoint(-3F, 2F, 0F);
        leftarms1.setTextureSize(64, 32);
        leftarms1.mirror = true;
        setRotation(leftarms1, 0F, 0F, 0F);
        leftarms2 = new ModelRenderer(this, 37, 0);
        leftarms2.addBox(3F, -2F, -2F, 4, 8, 4);
        leftarms2.setRotationPoint(5F, 2F, 0F);
        leftarms2.setTextureSize(64, 32);
        leftarms2.mirror = true;
        setRotation(leftarms2, 0F, 0F, 0F);
        leftarmspike1 = new ModelRenderer(this, 33, 0);
        leftarmspike1.addBox(6F, 6F, 1F, 1, 8, 1);
        leftarmspike1.setRotationPoint(5F, 2F, 0F);
        leftarmspike1.setTextureSize(64, 32);
        leftarmspike1.mirror = true;
        setRotation(leftarmspike1, 0F, 0F, 0F);
        leftarmspike2 = new ModelRenderer(this, 33, 0);
        leftarmspike2.addBox(6F, 6F, -2F, 1, 8, 1);
        leftarmspike2.setRotationPoint(5F, 2F, 0F);
        leftarmspike2.setTextureSize(64, 32);
        leftarmspike2.mirror = true;
        setRotation(leftarmspike2, 0F, 0F, 0F);
        rightarmspike1 = new ModelRenderer(this, 33, 0);
        rightarmspike1.addBox(-7F, 6F, -2F, 1, 8, 1);
        rightarmspike1.setRotationPoint(-5F, 2F, 0F);
        rightarmspike1.setTextureSize(64, 32);
        rightarmspike1.mirror = true;
        setRotation(rightarmspike1, 0F, 0F, 0F);
        rightarms2 = new ModelRenderer(this, 37, 0);
        rightarms2.addBox(-7F, -2F, -2F, 4, 8, 4);
        rightarms2.setRotationPoint(-5F, 2F, 0F);
        rightarms2.setTextureSize(64, 32);
        rightarms2.mirror = true;
        setRotation(rightarms2, 0F, 0F, 0F);
        rightarmspike2 = new ModelRenderer(this, 33, 0);
        rightarmspike2.addBox(-7F, 6F, 1F, 1, 8, 1);
        rightarmspike2.setRotationPoint(-5F, 2F, 0F);
        rightarmspike2.setTextureSize(64, 32);
        rightarmspike2.mirror = true;
        setRotation(rightarmspike2, 0F, 0F, 0F);
        leftlegs1 = new ModelRenderer(this, 0, 16);
        leftlegs1.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftlegs1.setRotationPoint(6F, 12F, 0F);
        leftlegs1.setTextureSize(64, 32);
        leftlegs1.mirror = true;
        setRotation(leftlegs1, 0F, 0F, 0F);
        leftlegs2 = new ModelRenderer(this, 41, 23);
        leftlegs2.addBox(-3F, -3F, -3F, 6, 3, 6);
        leftlegs2.setRotationPoint(6F, 12F, 0F);
        leftlegs2.setTextureSize(64, 32);
        leftlegs2.mirror = true;
        setRotation(leftlegs2, 0F, 0F, 0F);
        rightlegs2 = new ModelRenderer(this, 41, 23);
        rightlegs2.addBox(-3F, -3F, -3F, 6, 3, 6);
        rightlegs2.setRotationPoint(-6F, 12F, 0F);
        rightlegs2.setTextureSize(64, 32);
        rightlegs2.mirror = true;
        setRotation(rightlegs2, 0F, 0F, 0F);
        rightlegs1 = new ModelRenderer(this, 0, 16);
        rightlegs1.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightlegs1.setRotationPoint(-6F, 12F, 0F);
        rightlegs1.setTextureSize(64, 32);
        rightlegs1.mirror = true;
        setRotation(rightlegs1, 0F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
    {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5);
        head.render(f5);
        bodytop.render(f5);
        rightarmts1.render(f5);
        leftarmts1.render(f5);
        rightlegts1.render(f5);
        leftlegts1.render(f5);
        leftlegts2.render(f5);
        rightlegts2.render(f5);
        rightarmtspike1.render(f5);
        leftarmtspike1.render(f5);
        rightarmts2.render(f5);
        leftarmts2.render(f5);
        leftarmtspike2.render(f5);
        rightarmtspike2.render(f5);
        bodybottom.render(f5);
        rightarms1.render(f5);
        leftarms1.render(f5);
        leftarms2.render(f5);
        leftarmspike1.render(f5);
        leftarmspike2.render(f5);
        rightarmspike1.render(f5);
        rightarms2.render(f5);
        rightarmspike2.render(f5);
        leftlegs1.render(f5);
        leftlegs2.render(f5);
        rightlegs2.render(f5);
        rightlegs1.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5)
    {
        this.leftlegs1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
        this.leftlegs2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;

        this.rightlegs1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
        this.rightlegs2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;

        this.rightarms1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
        this.rightarms2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
        this.rightarmspike1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
        this.rightarmspike2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;

        this.leftarms1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.leftarms2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.leftarmspike1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
        this.leftarmspike2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;

        this.leftlegts1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1 - (float)Math.PI;
        this.leftlegts2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1 - (float)Math.PI;

        this.rightlegts1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1 - (float)Math.PI;
        this.rightlegts2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1 - (float)Math.PI;

        this.rightarmts1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F - (float)Math.PI;
        this.rightarmts2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F - (float)Math.PI;
        this.rightarmtspike1.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F - (float)Math.PI;
        this.rightarmtspike2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F - (float)Math.PI;

        this.leftarmts1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F - (float)Math.PI;
        this.leftarmts2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F - (float)Math.PI;
        this.leftarmtspike1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F - (float)Math.PI;
        this.leftarmtspike2.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F - (float)Math.PI;
    }

}
