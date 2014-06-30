package net.divinerpg.client.render.entity.vanilla.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class ModelScorcher extends ModelBase
{
    ModelRenderer mainBody;
    ModelRenderer head;
    ModelRenderer rightArm;
    ModelRenderer leftArm;
    ModelRenderer rightArm2;
    ModelRenderer leftArm2;
    ModelRenderer leftHorn;
    ModelRenderer leftHorn2;
    ModelRenderer rightHorn;
    ModelRenderer rightHorn2;

    public ModelScorcher()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.mainBody = new ModelRenderer(this, 0, 0);
        this.mainBody.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
        this.mainBody.setRotationPoint(-4.0F, 14.0F, -5.0F);
        this.mainBody.setTextureSize(64, 64);
        this.mainBody.mirror = true;
        this.setRotation(this.mainBody, 0.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 16);
        this.head.addBox(0.0F, 0.0F, 0.0F, 6, 6, 6);
        this.head.setRotationPoint(-3.0F, 8.0F, -4.0F);
        this.head.setTextureSize(64, 64);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
        this.rightArm = new ModelRenderer(this, 0, 48);
        this.rightArm.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.rightArm.setRotationPoint(-9.0F, 19.0F, -2.0F);
        this.rightArm.setTextureSize(64, 64);
        this.rightArm.mirror = true;
        this.setRotation(this.rightArm, 0.0F, 0.0F, 0.0F);
        this.leftArm = new ModelRenderer(this, 0, 48);
        this.leftArm.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.leftArm.setRotationPoint(3.0F, 19.0F, -2.0F);
        this.leftArm.setTextureSize(64, 64);
        this.leftArm.mirror = true;
        this.setRotation(this.leftArm, 0.0F, 0.0F, 0.0F);
        this.rightArm2 = new ModelRenderer(this, 0, 48);
        this.rightArm2.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.rightArm2.setRotationPoint(-9.0F, 19.0F, -2.0F);
        this.rightArm2.setTextureSize(64, 64);
        this.rightArm2.mirror = true;
        this.setRotation(this.rightArm2, 0.0F, 0.0F, -((float)Math.PI / 2F));
        this.leftArm2 = new ModelRenderer(this, 0, 48);
        this.leftArm2.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.leftArm2.setRotationPoint(7.0F, 19.0F, -2.0F);
        this.leftArm2.setTextureSize(64, 64);
        this.leftArm2.mirror = true;
        this.setRotation(this.leftArm2, 0.0F, 0.0F, -((float)Math.PI / 2F));
        this.leftHorn = new ModelRenderer(this, 0, 48);
        this.leftHorn.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.leftHorn.setRotationPoint(2.0F, 9.0F, 0.0F);
        this.leftHorn.setTextureSize(64, 64);
        this.leftHorn.mirror = true;
        this.setRotation(this.leftHorn, 0.0F, 0.0F, 0.0F);
        this.leftHorn2 = new ModelRenderer(this, 0, 48);
        this.leftHorn2.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.leftHorn2.setRotationPoint(6.0F, 9.0F, 0.0F);
        this.leftHorn2.setTextureSize(64, 64);
        this.leftHorn2.mirror = true;
        this.setRotation(this.leftHorn2, 0.0F, 0.0F, -((float)Math.PI / 2F));
        this.rightHorn = new ModelRenderer(this, 0, 48);
        this.rightHorn.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.rightHorn.setRotationPoint(-8.0F, 9.0F, 0.0F);
        this.rightHorn.setTextureSize(64, 64);
        this.rightHorn.mirror = true;
        this.setRotation(this.rightHorn, 0.0F, 0.0F, 0.0F);
        this.rightHorn2 = new ModelRenderer(this, 0, 48);
        this.rightHorn2.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2);
        this.rightHorn2.setRotationPoint(-8.0F, 9.0F, 0.0F);
        this.rightHorn2.setTextureSize(64, 64);
        this.rightHorn2.mirror = true;
        this.setRotation(this.rightHorn2, 0.0F, 0.0F, -((float)Math.PI / 2F));
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.mainBody.render(var7);
        this.head.render(var7);
        this.rightArm.render(var7);
        this.leftArm.render(var7);
        this.rightArm2.render(var7);
        this.leftArm2.render(var7);
        this.leftHorn.render(var7);
        this.leftHorn2.render(var7);
        this.rightHorn.render(var7);
        this.rightHorn2.render(var7);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }
}
