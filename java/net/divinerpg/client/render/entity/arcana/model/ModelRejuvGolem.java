package net.divinerpg.client.render.entity.arcana.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelRejuvGolem extends ModelBase {
    ModelRenderer head;
    ModelRenderer rightshoulder;
    ModelRenderer leftshoulder;
    ModelRenderer middle;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;

    public ModelRejuvGolem() {
        textureWidth = 128;
        textureHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 4, 8, 8);
        head.setRotationPoint(2F, 7F, 0F);
        head.setTextureSize(128, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        rightshoulder = new ModelRenderer(this, 73, 3);
        rightshoulder.addBox(-4F, -6F, -3F, 6, 5, 6);
        rightshoulder.setRotationPoint(-6F, 11F, 0F);
        rightshoulder.setTextureSize(128, 32);
        rightshoulder.mirror = true;
        setRotation(rightshoulder, -0.6981317F, 0F, 0F);
        leftshoulder = new ModelRenderer(this, 73, 3);
        leftshoulder.addBox(-2F, -6F, -3F, 6, 5, 6);
        leftshoulder.setRotationPoint(6F, 11F, 0F);
        leftshoulder.setTextureSize(128, 32);
        leftshoulder.mirror = true;
        setRotation(leftshoulder, -0.6981317F, 0F, 0F);
        middle = new ModelRenderer(this, 68, 18);
        middle.addBox(-4F, 0F, -2F, 8, 5, 8);
        middle.setRotationPoint(0F, 7F, -2F);
        middle.setTextureSize(128, 32);
        middle.mirror = true;
        setRotation(middle, 0F, 0F, 0F);
        body = new ModelRenderer(this, 25, 10);
        body.addBox(-4F, 0F, -2F, 10, 12, 10);
        body.setRotationPoint(-1F, 12F, -3F);
        body.setTextureSize(128, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setRotationPoint(-6F, 11F, 0F);
        rightarm.setTextureSize(128, 32);
        rightarm.mirror = true;
        setRotation(rightarm, -0.6981317F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setRotationPoint(6F, 11F, 0F);
        leftarm.setTextureSize(128, 32);
        leftarm.mirror = true;
        setRotation(leftarm, -0.6981317F, 0F, 0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        head.render(f5);
        rightshoulder.render(f5);
        leftshoulder.render(f5);
        middle.render(f5);
        body.render(f5);
        rightarm.render(f5);
        leftarm.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
        this.rightarm.rotateAngleX = this.rightshoulder.rotateAngleX = MathHelper.cos(f)*f1*0.75f - 0.6981317F;
        this.leftarm.rotateAngleX = this.leftshoulder.rotateAngleX = MathHelper.cos(f + (float)Math.PI)*f1*0.75f - 0.6981317F;
    }

}
