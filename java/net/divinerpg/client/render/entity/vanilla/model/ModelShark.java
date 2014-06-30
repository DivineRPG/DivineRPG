package net.divinerpg.client.render.entity.vanilla.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class ModelShark extends ModelBase
{
    ModelRenderer bodyTop;
    ModelRenderer flipperL;
    ModelRenderer flipperR;
    ModelRenderer tailConnector;
    ModelRenderer tailTop;
    ModelRenderer tailBottom;
    ModelRenderer fin;
    ModelRenderer bodyBottom;
    ModelRenderer bodyMiddle;
    ModelRenderer bodyBack;

    public ModelShark()
    {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.bodyTop = new ModelRenderer(this, 0, 0);
        this.bodyTop.addBox(0.0F, 0.0F, 0.0F, 8, 2, 26);
        this.bodyTop.setRotationPoint(-5.0F, 18.0F, -11.0F);
        this.bodyTop.setTextureSize(64, 64);
        this.bodyTop.mirror = true;
        this.setRotation(this.bodyTop, 0.0F, 0.0F, 0.0F);
        this.flipperL = new ModelRenderer(this, 0, 58);
        this.flipperL.addBox(0.0F, 0.0F, -3.0F, 10, 2, 4);
        this.flipperL.setRotationPoint(1.0F, 21.0F, 2.0F);
        this.flipperL.setTextureSize(64, 64);
        this.flipperL.mirror = true;
        this.setRotation(this.flipperL, 0.0F, -0.6108652F, 0.0F);
        this.flipperR = new ModelRenderer(this, 0, 58);
        this.flipperR.addBox(-6.0F, 0.0F, -3.0F, 10, 2, 4);
        this.flipperR.setRotationPoint(-6.0F, 21.0F, 4.0F);
        this.flipperR.setTextureSize(64, 64);
        this.flipperR.mirror = true;
        this.setRotation(this.flipperR, 0.0F, 0.6108652F, 0.0F);
        this.tailConnector = new ModelRenderer(this, 0, 2);
        this.tailConnector.addBox(-2.0F, -1.0F, 0.0F, 4, 2, 5);
        this.tailConnector.setRotationPoint(-1.0F, 21.0F, 16.0F);
        this.tailConnector.setTextureSize(64, 64);
        this.tailConnector.mirror = true;
        this.setRotation(this.tailConnector, 0.0F, 0.0F, ((float)Math.PI / 2F));
        this.tailTop = new ModelRenderer(this, 0, 0);
        this.tailTop.addBox(-1.0F, -1.0F, 0.0F, 2, 3, 8);
        this.tailTop.setRotationPoint(-1.0F, 20.0F, 20.0F);
        this.tailTop.setTextureSize(64, 64);
        this.tailTop.mirror = true;
        this.setRotation(this.tailTop, 0.6108652F, 0.0F, 0.0F);
        this.tailBottom = new ModelRenderer(this, 0, 0);
        this.tailBottom.addBox(-1.0F, -1.0F, 0.0F, 2, 3, 8);
        this.tailBottom.setRotationPoint(-1.0F, 21.0F, 19.0F);
        this.tailBottom.setTextureSize(64, 64);
        this.tailBottom.mirror = true;
        this.setRotation(this.tailBottom, -0.6108652F, 0.0F, 0.0F);
        this.fin = new ModelRenderer(this, 0, 0);
        this.fin.addBox(0.0F, 0.0F, 0.0F, 2, 3, 8);
        this.fin.setRotationPoint(-2.0F, 18.0F, 0.0F);
        this.fin.setTextureSize(64, 64);
        this.fin.mirror = true;
        this.setRotation(this.fin, 0.9599311F, 0.0F, 0.0F);
        this.bodyBottom = new ModelRenderer(this, 0, 32);
        this.bodyBottom.addBox(0.0F, 0.0F, 0.0F, 8, 2, 24);
        this.bodyBottom.setRotationPoint(-5.0F, 22.0F, -9.0F);
        this.bodyBottom.setTextureSize(64, 64);
        this.bodyBottom.mirror = true;
        this.setRotation(this.bodyBottom, 0.0F, 0.0F, 0.0F);
        this.bodyMiddle = new ModelRenderer(this, 3, 1);
        this.bodyMiddle.addBox(0.0F, 0.0F, 0.0F, 8, 2, 21);
        this.bodyMiddle.setRotationPoint(-5.0F, 20.0F, -6.0F);
        this.bodyMiddle.setTextureSize(64, 64);
        this.bodyMiddle.mirror = true;
        this.setRotation(this.bodyMiddle, 0.0F, 0.0F, 0.0F);
        this.bodyBack = new ModelRenderer(this, 24, 8);
        this.bodyBack.addBox(0.0F, 0.0F, 0.0F, 8, 6, 1);
        this.bodyBack.setRotationPoint(-5.0F, 18.0F, 15.0F);
        this.bodyBack.setTextureSize(64, 64);
        this.bodyBack.mirror = true;
        this.setRotation(this.bodyBack, 0.0F, 0.0F, 0.0F);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7)
    {
        super.render(var1, var2, var3, var4, var5, var6, var7);
        this.bodyTop.render(var7);
        this.flipperL.render(var7);
        this.flipperR.render(var7);
        this.tailConnector.render(var7);
        this.tailTop.render(var7);
        this.tailBottom.render(var7);
        this.fin.render(var7);
        this.bodyBottom.render(var7);
        this.bodyMiddle.render(var7);
        this.bodyBack.render(var7);
    }

    private void setRotation(ModelRenderer var1, float var2, float var3, float var4)
    {
        var1.rotateAngleX = var2;
        var1.rotateAngleY = var3;
        var1.rotateAngleZ = var4;
    }
}
