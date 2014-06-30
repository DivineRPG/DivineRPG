package net.divinerpg.client.render.block.model;

import net.divinerpg.api.model.DivineModel;
import net.divinerpg.api.model.DivineRenderer;
import net.minecraft.client.model.ModelRenderer;

public class ModelVamacheronStatue extends DivineModel
{
    //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer horn1;
    ModelRenderer horn2;
    ModelRenderer Horn;
    ModelRenderer Shape17;
    ModelRenderer head2;
    ModelRenderer horn3;
    ModelRenderer horn4;
    ModelRenderer Horn5;
    ModelRenderer Shape1;

    public ModelVamacheronStatue()
    {
        super("statueVamacheron", 64, 32);

        head = new DivineRenderer(this, 0, 0);
        head.addBox(-4F, -4F, -6F, 8, 8, 6);
        head.setRotationPoint(-6F, 4F, -8F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new DivineRenderer(this, 18, 4);
        body.addBox(-6F, -10F, -7F, 8, 18, 10);
        body.setRotationPoint(2F, 5F, 2F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 1.570796F, 0F, 0F);
        leg1 = new DivineRenderer(this, 0, 16);
        leg1.addBox(-3F, 0F, -2F, 4, 12, 4);
        leg1.setRotationPoint(-2F, 12F, 7F);
        leg1.setTextureSize(64, 32);
        leg1.mirror = true;
        setRotation(leg1, 0.4833219F, 0F, 0F);
        leg2 = new DivineRenderer(this, 0, 16);
        leg2.addBox(-1F, 0F, -2F, 4, 12, 4);
        leg2.setRotationPoint(2F, 12F, 7F);
        leg2.setTextureSize(64, 32);
        leg2.mirror = true;
        setRotation(leg2, -0.2230717F, 0F, 0F);
        leg2.mirror = false;
        leg3 = new DivineRenderer(this, 0, 16);
        leg3.addBox(-3F, 0F, -3F, 4, 12, 4);
        leg3.setRotationPoint(-2F, 12F, -5F);
        leg3.setTextureSize(64, 32);
        leg3.mirror = true;
        setRotation(leg3, 0.2974289F, 0F, 0F);
        leg4 = new DivineRenderer(this, 0, 16);
        leg4.addBox(-1F, 0F, -3F, 4, 12, 4);
        leg4.setRotationPoint(2F, 12F, -5F);
        leg4.setTextureSize(64, 32);
        leg4.mirror = true;
        setRotation(leg4, -0.3717861F, 0F, 0F);
        horn1 = new DivineRenderer(this, 54, 0);
        horn1.addBox(-4F, -5F, -4F, 1, 3, 3);
        horn1.setRotationPoint(-6F, 2F, -8F);
        horn1.setTextureSize(64, 32);
        horn1.mirror = true;
        setRotation(horn1, 0F, 0F, 0F);
        horn2 = new DivineRenderer(this, 55, 0);
        horn2.addBox(3F, -5F, -4F, 1, 3, 3);
        horn2.setRotationPoint(-6F, 2F, -8F);
        horn2.setTextureSize(64, 32);
        horn2.mirror = true;
        setRotation(horn2, 0F, 0F, 0F);
        Horn = new DivineRenderer(this, 55, 7);
        Horn.addBox(0F, 0F, 0F, 2, 7, 2);
        Horn.setRotationPoint(-7F, 0F, -20F);
        Horn.setTextureSize(64, 32);
        Horn.mirror = true;
        setRotation(Horn, 1.22173F, 0F, 0F);
        Shape17 = new DivineRenderer(this, 9, 0);
        Shape17.addBox(0F, 0F, 0F, 2, 2, 2);
        Shape17.setRotationPoint(-7F, 3F, -15F);
        Shape17.setTextureSize(64, 32);
        Shape17.mirror = true;
        setRotation(Shape17, 0F, 0F, 0F);
        head2 = new DivineRenderer(this, 0, 0);
        head2.addBox(0F, 0F, 0F, 8, 8, 6);
        head2.setRotationPoint(2F, 0F, -14F);
        head2.setTextureSize(64, 32);
        head2.mirror = true;
        setRotation(head2, 0F, 0F, 0F);
        horn3 = new DivineRenderer(this, 55, 0);
        horn3.addBox(0F, 0F, 0F, 1, 3, 3);
        horn3.setRotationPoint(2F, -3F, -12F);
        horn3.setTextureSize(64, 32);
        horn3.mirror = true;
        setRotation(horn3, 0F, 0F, 0F);
        horn4 = new DivineRenderer(this, 55, 0);
        horn4.addBox(0F, 0F, 0F, 1, 3, 3);
        horn4.setRotationPoint(9F, -3F, -12F);
        horn4.setTextureSize(64, 32);
        horn4.mirror = true;
        setRotation(horn4, 0F, 0F, 0F);
        Horn5 = new DivineRenderer(this, 55, 7);
        Horn5.addBox(0F, 0F, 0F, 2, 7, 2);
        Horn5.setRotationPoint(5F, 0F, -20F);
        Horn5.setTextureSize(64, 32);
        Horn5.mirror = true;
        setRotation(Horn5, 1.22173F, 0F, 0F);
        Shape1 = new DivineRenderer(this, 9, 0);
        Shape1.addBox(0F, 0F, 0F, 2, 2, 2);
        Shape1.setRotationPoint(5F, 3F, -15F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
    }

}
