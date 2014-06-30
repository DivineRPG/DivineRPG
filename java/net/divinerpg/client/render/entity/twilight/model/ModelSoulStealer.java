package net.divinerpg.client.render.entity.twilight.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelSoulStealer extends ModelBase
{
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer Shape1;
    ModelRenderer Shape3;
    ModelRenderer Shape2;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer back;
    ModelRenderer back1;
    ModelRenderer back2;
    ModelRenderer back3;
    ModelRenderer back4;

    public ModelSoulStealer()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
        this.head.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 16, 16);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4);
        this.body.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
        this.rightarm = new ModelRenderer(this, 40, 16);
        this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4);
        this.rightarm.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.rightarm.setTextureSize(64, 32);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
        this.leftarm = new ModelRenderer(this, 40, 16);
        this.leftarm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4);
        this.leftarm.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.leftarm.setTextureSize(64, 32);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
        this.rightleg = new ModelRenderer(this, 0, 16);
        this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.rightleg.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.rightleg.setTextureSize(64, 32);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
        this.leftleg = new ModelRenderer(this, 0, 16);
        this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.leftleg.setRotationPoint(2.0F, 12.0F, 0.0F);
        this.leftleg.setTextureSize(64, 32);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
        this.Shape1 = new ModelRenderer(this, 8, 0);
        this.Shape1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 5);
        this.Shape1.setRotationPoint(2.0F, -8.0F, -9.0F);
        this.Shape1.setTextureSize(64, 32);
        this.Shape1.mirror = true;
        this.setRotation(this.Shape1, 0.0F, 0.0F, 0.0F);
        this.Shape3 = new ModelRenderer(this, 8, 0);
        this.Shape3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 5);
        this.Shape3.setRotationPoint(-4.0F, -8.0F, -9.0F);
        this.Shape3.setTextureSize(64, 32);
        this.Shape3.mirror = true;
        this.setRotation(this.Shape3, 0.0F, 0.0F, 0.0F);
        this.Shape2 = new ModelRenderer(this, 9, 0);
        this.Shape2.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2);
        this.Shape2.setRotationPoint(4.0F, -6.0F, -4.0F);
        this.Shape2.setTextureSize(64, 32);
        this.Shape2.mirror = true;
        this.setRotation(this.Shape2, 0.0F, 0.0F, 0.0F);
        this.Shape4 = new ModelRenderer(this, 9, 0);
        this.Shape4.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2);
        this.Shape4.setRotationPoint(-8.0F, -6.0F, -4.0F);
        this.Shape4.setTextureSize(64, 32);
        this.Shape4.mirror = true;
        this.setRotation(this.Shape4, 0.0F, 0.0F, 0.0F);
        this.Shape5 = new ModelRenderer(this, 9, 0);
        this.Shape5.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2);
        this.Shape5.setRotationPoint(4.0F, -3.0F, -4.0F);
        this.Shape5.setTextureSize(64, 32);
        this.Shape5.mirror = true;
        this.setRotation(this.Shape5, 0.0F, 0.0F, 0.0F);
        this.Shape6 = new ModelRenderer(this, 9, 0);
        this.Shape6.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2);
        this.Shape6.setRotationPoint(-8.0F, -3.0F, -4.0F);
        this.Shape6.setTextureSize(64, 32);
        this.Shape6.mirror = true;
        this.setRotation(this.Shape6, 0.0F, 0.0F, 0.0F);
        this.Shape7 = new ModelRenderer(this, 8, 0);
        this.Shape7.addBox(0.0F, 0.0F, 0.0F, 2, 2, 5);
        this.Shape7.setRotationPoint(6.0F, -6.0F, -9.0F);
        this.Shape7.setTextureSize(64, 32);
        this.Shape7.mirror = true;
        this.setRotation(this.Shape7, 0.0F, 0.0F, 0.0F);
        this.Shape8 = new ModelRenderer(this, 8, 0);
        this.Shape8.addBox(0.0F, 0.0F, 0.0F, 2, 2, 5);
        this.Shape8.setRotationPoint(6.0F, -3.0F, -9.0F);
        this.Shape8.setTextureSize(64, 32);
        this.Shape8.mirror = true;
        this.setRotation(this.Shape8, 0.0F, 0.0F, 0.0F);
        this.Shape9 = new ModelRenderer(this, 8, 0);
        this.Shape9.addBox(0.0F, 0.0F, 0.0F, 2, 2, 5);
        this.Shape9.setRotationPoint(-8.0F, -6.0F, -9.0F);
        this.Shape9.setTextureSize(64, 32);
        this.Shape9.mirror = true;
        this.setRotation(this.Shape9, 0.0F, 0.0F, 0.0F);
        this.Shape10 = new ModelRenderer(this, 8, 0);
        this.Shape10.addBox(0.0F, 0.0F, 0.0F, 2, 2, 5);
        this.Shape10.setRotationPoint(-8.0F, -3.0F, -9.0F);
        this.Shape10.setTextureSize(64, 32);
        this.Shape10.mirror = true;
        this.setRotation(this.Shape10, 0.0F, 0.0F, 0.0F);
        this.back = new ModelRenderer(this, 4, 0);
        this.back.addBox(0.0F, 0.0F, 0.0F, 4, 4, 5);
        this.back.setRotationPoint(-2.0F, 0.0F, 2.0F);
        this.back.setTextureSize(64, 32);
        this.back.mirror = true;
        this.setRotation(this.back, 0.0F, 0.0F, 0.0F);
        this.back1 = new ModelRenderer(this, 8, 0);
        this.back1.addBox(0.0F, 0.0F, 0.0F, 5, 2, 2);
        this.back1.setRotationPoint(2.0F, 0.0F, 5.0F);
        this.back1.setTextureSize(64, 32);
        this.back1.mirror = true;
        this.setRotation(this.back1, 0.0F, 0.0F, 0.0F);
        this.back2 = new ModelRenderer(this, 8, 0);
        this.back2.addBox(0.0F, 0.0F, 0.0F, 5, 2, 2);
        this.back2.setRotationPoint(-7.0F, 0.0F, 5.0F);
        this.back2.setTextureSize(64, 32);
        this.back2.mirror = true;
        this.setRotation(this.back2, 0.0F, 0.0F, 0.0F);
        this.back3 = new ModelRenderer(this, 15, 25);
        this.back3.addBox(0.0F, 0.0F, 0.0F, 9, 2, 2);
        this.back3.setRotationPoint(5.0F, 0.0F, 5.0F);
        this.back3.setTextureSize(64, 32);
        this.back3.mirror = true;
        this.setRotation(this.back3, 0.0F, 0.0F, -((float)Math.PI / 2F));
        this.back4 = new ModelRenderer(this, 15, 25);
        this.back4.addBox(0.0F, -1.0F, 0.0F, 9, 2, 2);
        this.back4.setRotationPoint(-6.0F, 0.0F, 5.0F);
        this.back4.setTextureSize(64, 32);
        this.back4.mirror = true;
        this.setRotation(this.back4, 0.0F, 0.0F, -((float)Math.PI / 2F));
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    @Override
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.setRotationAngles(var2, var3, var4, var5, var6, var7);
        this.head.render(var7);
        this.body.render(var7);
        this.rightarm.render(var7);
        this.leftarm.render(var7);
        this.rightleg.render(var7);
        this.leftleg.render(var7);
        this.Shape1.render(var7);
        this.Shape2.render(var7);
        this.Shape3.render(var7);
        this.Shape4.render(var7);
        this.Shape5.render(var7);
        this.Shape6.render(var7);
        this.Shape7.render(var7);
        this.Shape8.render(var7);
        this.Shape9.render(var7);
        this.Shape10.render(var7);
        this.back.render(var7);
        this.back1.render(var7);
        this.back2.render(var7);
        this.back3.render(var7);
        this.back4.render(var7);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        this.rightarm.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
        this.leftarm.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.rightarm.rotateAngleZ = 0.0F;
        this.leftarm.rotateAngleZ = 0.0F;
        this.rightleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.leftleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        this.rightleg.rotateAngleY = 0.0F;
        this.leftleg.rotateAngleY = 0.0F;
    }
}
