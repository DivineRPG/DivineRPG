package net.divinerpg.client.render.entity.twilight.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;


public class ModelEnchantedWarrior extends ModelBase
{
    ModelRenderer head;
    ModelRenderer body;
    public ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer hornright;
    ModelRenderer hornleft;
    ModelRenderer handright;
    ModelRenderer handleft;
    public int heldItemLeft;
    public int heldItemRight;

    public ModelEnchantedWarrior()
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
        this.hornright = new ModelRenderer(this, 38, 2);
        this.hornright.addBox(-8.0F, 0.0F, 0.0F, 8, 4, 4);
        this.hornright.setRotationPoint(-4.0F, -8.0F, -2.0F);
        this.hornright.setTextureSize(64, 32);
        this.hornright.mirror = true;
        this.setRotation(this.hornright, 0.0F, 0.0F, 0.0F);
        this.hornleft = new ModelRenderer(this, 38, 2);
        this.hornleft.addBox(0.0F, 0.0F, 0.0F, 8, 4, 4);
        this.hornleft.setRotationPoint(4.0F, -8.0F, -2.0F);
        this.hornleft.setTextureSize(64, 32);
        this.hornleft.mirror = true;
        this.setRotation(this.hornleft, 0.0F, 0.0F, 0.0F);
        this.handright = new ModelRenderer(this, 1, 20);
        this.handright.addBox(0.0F, 0.0F, 0.0F, 12, 4, 4);
        this.handright.setRotationPoint(-8.0F, 8.0F, 6.0F);
        this.handright.setTextureSize(64, 32);
        this.handright.mirror = true;
        this.setRotation(this.handright, 0.0F, ((float)Math.PI / 2F), 0.0F);
        this.handleft = new ModelRenderer(this, 1, 22);
        this.handleft.addBox(0.0F, 0.0F, 0.0F, 12, 4, 4);
        this.handleft.setRotationPoint(4.0F, 8.0F, 6.0F);
        this.handleft.setTextureSize(64, 32);
        this.handleft.mirror = true;
        this.setRotation(this.handleft, 0.0F, ((float)Math.PI / 2F), 0.0F);
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
        this.hornright.render(var7);
        this.hornleft.render(var7);
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
        this.hornleft.rotateAngleY = var4 / (180F / (float)Math.PI);
        this.hornleft.rotateAngleX = var5 / (180F / (float)Math.PI);
        this.hornright.rotateAngleY = var4 / (180F / (float)Math.PI);
        this.hornright.rotateAngleX = var5 / (180F / (float)Math.PI);
        this.rightarm.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 2.0F * var2 * 0.5F;
        this.leftarm.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.rightarm.rotateAngleZ = 0.0F;
        this.leftarm.rotateAngleZ = 0.0F;
        this.rightleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.leftleg.rotateAngleX = MathHelper.cos(var1 * 0.6662F + (float)Math.PI) * 1.4F * var2;
        this.rightleg.rotateAngleY = 0.0F;
        this.leftleg.rotateAngleY = 0.0F;

        if (this.heldItemLeft != 0)
        {
            this.leftarm.rotateAngleX = this.leftarm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * this.heldItemLeft;
        }

        if (this.heldItemRight != 0)
        {
            this.rightarm.rotateAngleX = this.rightarm.rotateAngleX * 0.5F - ((float)Math.PI / 10F) * this.heldItemRight;
        }

        this.rightarm.rotateAngleY = 0.0F;
        this.leftarm.rotateAngleY = 0.0F;
        this.rightarm.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.leftarm.rotateAngleZ -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.rightarm.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.leftarm.rotateAngleX -= MathHelper.sin(var3 * 0.067F) * 0.05F;
    }
}
