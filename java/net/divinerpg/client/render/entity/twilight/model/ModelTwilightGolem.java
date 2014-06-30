package net.divinerpg.client.render.entity.twilight.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelTwilightGolem extends ModelBase
{
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer head1;
    ModelRenderer head2;
    ModelRenderer head3;
    ModelRenderer head4;

    public ModelTwilightGolem()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.head = new ModelRenderer(this, 0, 0);
        this.head.addBox(-4.0F, -8.0F, -3.0F, 12, 8, 8);
        this.head.setRotationPoint(-2.0F, -6.0F, 0.0F);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 7, 8);
        this.body.addBox(-4.0F, 0.0F, -2.0F, 18, 18, 6);
        this.body.setRotationPoint(-5.0F, -6.0F, 0.0F);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0F, 0.0F, 0.0F);
        this.rightarm = new ModelRenderer(this, 40, 3);
        this.rightarm.addBox(-3.0F, -2.0F, -2.0F, 4, 25, 4);
        this.rightarm.setRotationPoint(-10.0F, -4.0F, 1.0F);
        this.rightarm.setTextureSize(64, 32);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0.0F, 0.0F, 0.0F);
        this.leftarm = new ModelRenderer(this, 40, 2);
        this.leftarm.addBox(-1.0F, -2.0F, -1.0F, 4, 24, 4);
        this.leftarm.setRotationPoint(10.0F, -4.0F, 0.0F);
        this.leftarm.setTextureSize(64, 32);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0.0F, 0.0F, 0.0F);
        this.rightleg = new ModelRenderer(this, 0, 16);
        this.rightleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.rightleg.setRotationPoint(-5.0F, 12.0F, 0.0F);
        this.rightleg.setTextureSize(64, 32);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0F, 0.0F, 0.0F);
        this.leftleg = new ModelRenderer(this, 0, 16);
        this.leftleg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4);
        this.leftleg.setRotationPoint(5.0F, 12.0F, 0.0F);
        this.leftleg.setTextureSize(64, 32);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0F, 0.0F, 0.0F);
        this.head1 = new ModelRenderer(this, 2, 0);
        this.head1.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
        this.head1.setRotationPoint(-16.0F, -14.0F, -2.0F);
        this.head1.setTextureSize(64, 32);
        this.head1.mirror = true;
        this.setRotation(this.head1, 0.0F, 0.0F, 0.0F);
        this.head2 = new ModelRenderer(this, 2, 0);
        this.head2.addBox(0.0F, 0.0F, 0.0F, 8, 8, 8);
        this.head2.setRotationPoint(8.0F, -14.0F, -2.0F);
        this.head2.setTextureSize(64, 32);
        this.head2.mirror = true;
        this.setRotation(this.head2, 0.0F, 0.0F, 0.0F);
        this.head3 = new ModelRenderer(this, 33, 0);
        this.head3.addBox(0.0F, 0.0F, 0.0F, 6, 4, 4);
        this.head3.setRotationPoint(-22.0F, -12.0F, 0.0F);
        this.head3.setTextureSize(64, 32);
        this.head3.mirror = true;
        this.setRotation(this.head3, 0.0F, 0.0F, 0.0F);
        this.head4 = new ModelRenderer(this, 33, 0);
        this.head4.addBox(0.0F, 0.0F, 0.0F, 6, 4, 4);
        this.head4.setRotationPoint(16.0F, -12.0F, 0.0F);
        this.head4.setTextureSize(64, 32);
        this.head4.mirror = true;
        this.setRotation(this.head4, 0.0F, 0.0F, 0.0F);
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
        this.head1.render(var7);
        this.head2.render(var7);
        this.head3.render(var7);
        this.head4.render(var7);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6)
    {
        this.head.rotateAngleY = var4 / (180F / (float)Math.PI);
        this.head.rotateAngleX = var5 / (180F / (float)Math.PI);
        this.head1.rotateAngleY = var4 / (180F / (float)Math.PI);
        this.head1.rotateAngleX = var5 / (180F / (float)Math.PI);
        this.head2.rotateAngleY = var4 / (180F / (float)Math.PI);
        this.head2.rotateAngleX = var5 / (180F / (float)Math.PI);
        this.head3.rotateAngleY = var4 / (180F / (float)Math.PI);
        this.head3.rotateAngleX = var5 / (180F / (float)Math.PI);
        this.head4.rotateAngleY = var4 / (180F / (float)Math.PI);
        this.head4.rotateAngleX = var5 / (180F / (float)Math.PI);
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
