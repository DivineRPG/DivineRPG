package net.divinerpg.client.render.entity.twilight.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelSunArcher extends ModelBase {
    ModelRenderer legRight;
    ModelRenderer legLeft;
    ModelRenderer body;
    ModelRenderer footRight;
    ModelRenderer footLeft;
    ModelRenderer spine1;
    ModelRenderer spine2;
    ModelRenderer spine3;
    ModelRenderer spine4;
    ModelRenderer spine5;
    ModelRenderer head;
    public ModelRenderer armRight;
    ModelRenderer armBandRight;
    ModelRenderer armLeft;
    ModelRenderer armBandLeft;

    public ModelSunArcher() {
        textureWidth = 128;
        textureHeight = 64;

        legRight = new ModelRenderer(this, 0, 0);
        legRight.addBox(-1F, 0F, -1F, 2, 13, 2);
        legRight.setRotationPoint(-4F, 11F, 1F);
        legRight.setTextureSize(128, 64);
        legRight.mirror = true;
        setRotation(legRight, 0F, 0F, 0F);
        legLeft = new ModelRenderer(this, 0, 0);
        legLeft.addBox(-1F, 0F, -1F, 2, 13, 2);
        legLeft.setRotationPoint(4F, 11F, 1F);
        legLeft.setTextureSize(128, 64);
        legLeft.mirror = true;
        setRotation(legLeft, 0F, 0F, 0F);
        body = new ModelRenderer(this, 0, 43);
        body.addBox(0F, 0F, 0F, 12, 16, 5);
        body.setRotationPoint(-6F, -5F, -1.5F);
        body.setTextureSize(128, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        footRight = new ModelRenderer(this, 0, 15);
        footRight.addBox(-1.5F, 12F, -2.5F, 3, 1, 4);
        footRight.setRotationPoint(-4F, 11F, 1F);
        footRight.setTextureSize(128, 64);
        footRight.mirror = true;
        setRotation(footRight, 0F, 0F, 0F);
        footLeft = new ModelRenderer(this, 0, 15);
        footLeft.addBox(-1.5F, 12F, -2.5F, 3, 1, 4);
        footLeft.setRotationPoint(4F, 11F, 1F);
        footLeft.setTextureSize(128, 64);
        footLeft.mirror = true;
        setRotation(footLeft, 0F, 0F, 0F);
        spine1 = new ModelRenderer(this, 8, 0);
        spine1.addBox(0F, -4F, 0F, 3, 4, 1);
        spine1.setRotationPoint(-1.5F, 0F, 2.5F);
        spine1.setTextureSize(128, 64);
        spine1.mirror = true;
        setRotation(spine1, -0.5235988F, 0F, 0F);
        spine2 = new ModelRenderer(this, 8, 0);
        spine2.addBox(0F, -4F, 0F, 3, 4, 1);
        spine2.setRotationPoint(-1.5F, 3F, 2.5F);
        spine2.setTextureSize(128, 64);
        spine2.mirror = true;
        setRotation(spine2, -0.5235988F, 0F, 0F);
        spine3 = new ModelRenderer(this, 8, 0);
        spine3.addBox(0F, -4F, 0F, 3, 4, 1);
        spine3.setRotationPoint(-1.5F, 6F, 2.5F);
        spine3.setTextureSize(128, 64);
        spine3.mirror = true;
        setRotation(spine3, -0.5235988F, 0F, 0F);
        spine4 = new ModelRenderer(this, 8, 0);
        spine4.addBox(0F, -4F, 0F, 3, 4, 1);
        spine4.setRotationPoint(-1.5F, 9F, 2.5F);
        spine4.setTextureSize(128, 64);
        spine4.mirror = true;
        setRotation(spine4, -0.5235988F, 0F, 0F);
        spine5 = new ModelRenderer(this, 8, 0);
        spine5.addBox(0F, -4F, 0F, 3, 4, 1);
        spine5.setRotationPoint(-1.5F, -3F, 2.5F);
        spine5.setTextureSize(128, 64);
        spine5.mirror = true;
        setRotation(spine5, -0.5235988F, 0F, 0F);
        head = new ModelRenderer(this, 0, 31);
        head.addBox(-3F, -6F, -3F, 6, 6, 6);
        head.setRotationPoint(0F, -5F, 0F);
        head.setTextureSize(128, 64);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        armRight = new ModelRenderer(this, 16, 0);
        armRight.addBox(-1F, 0F, -1F, 2, 12, 2);
        armRight.setRotationPoint(-7F, -4F, 1F);
        armRight.setTextureSize(128, 64);
        armRight.mirror = true;
        setRotation(armRight, -1.308997F, 0F, 0F);
        armBandRight = new ModelRenderer(this, 24, 0);
        armBandRight.addBox(-1.5F, 3F, -1.5F, 3, 6, 3);
        armBandRight.setRotationPoint(-7F, -4F, 1F);
        armBandRight.setTextureSize(128, 64);
        armBandRight.mirror = true;
        setRotation(armBandRight, -1.308997F, 0F, 0F);
        armLeft = new ModelRenderer(this, 16, 0);
        armLeft.addBox(-1F, 0F, -1F, 2, 12, 2);
        armLeft.setRotationPoint(6.5F, -4F, 1F);
        armLeft.setTextureSize(128, 64);
        armLeft.mirror = true;
        setRotation(armLeft, 0F, 0F, -0.0872665F);
        armBandLeft = new ModelRenderer(this, 24, 0);
        armBandLeft.addBox(-1.5F, 3F, -1.5F, 3, 6, 3);
        armBandLeft.setRotationPoint(6.5F, -4F, 1F);
        armBandLeft.setTextureSize(128, 64);
        armBandLeft.mirror = true;
        setRotation(armBandLeft, 0F, 0F, -0.0872665F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        legRight.render(f5);
        legLeft.render(f5);
        body.render(f5);
        footRight.render(f5);
        footLeft.render(f5);
        spine1.render(f5);
        spine2.render(f5);
        spine3.render(f5);
        spine4.render(f5);
        spine5.render(f5);
        head.render(f5);
        armRight.render(f5);
        armBandRight.render(f5);
        armLeft.render(f5);
        armBandLeft.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
        this.legLeft.rotateAngleX = this.footLeft.rotateAngleX = MathHelper.cos(f)*f1;
        this.legRight.rotateAngleX = this.footRight.rotateAngleX = MathHelper.cos(f+(float)Math.PI)*f1;
        
        this.armRight.rotateAngleX = this.armBandRight.rotateAngleX = -1.308997f + MathHelper.cos(f)*f1*0.3f;
        this.armLeft.rotateAngleX = this.armBandLeft.rotateAngleX = MathHelper.cos(f)*f1;
    }

}
