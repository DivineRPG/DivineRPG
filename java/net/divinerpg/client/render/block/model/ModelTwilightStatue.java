package net.divinerpg.client.render.block.model;

import net.divinerpg.api.model.DivineModel;
import net.divinerpg.api.model.DivineRenderer;
import net.minecraft.client.model.ModelRenderer;

public class ModelTwilightStatue extends DivineModel
{
    //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer connector;
    ModelRenderer head2;
    ModelRenderer Spear2;
    ModelRenderer Shape1;
    ModelRenderer head3;
    ModelRenderer connector1;
    ModelRenderer connector2;

    public ModelTwilightStatue()
    {
        super("statueTwilightDemon", 64, 32);

        head = new DivineRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(0F, 0F, 0F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        body = new DivineRenderer(this, 16, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setRotationPoint(0F, 0F, 0F);
        body.setTextureSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightarm = new DivineRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setRotationPoint(-5F, 2F, 0F);
        rightarm.setTextureSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, -5.576792F, 0F, 0F);
        leftarm = new DivineRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setRotationPoint(5F, 2F, 0F);
        leftarm.setTextureSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, -0.669215F, 0F);
        rightleg = new DivineRenderer(this, 0, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setRotationPoint(-2F, 12F, 0F);
        rightleg.setTextureSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new DivineRenderer(this, 0, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setRotationPoint(2F, 12F, 0F);
        leftleg.setTextureSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, -0.5948578F, 0F);
        connector = new DivineRenderer(this, 0, 20);
        connector.addBox(0F, 0F, 0F, 4, 4, 6);
        connector.setRotationPoint(6F, -6F, -11F);
        connector.setTextureSize(64, 32);
        connector.mirror = true;
        setRotation(connector, 0F, 0F, 0F);
        head2 = new DivineRenderer(this, 32, 0);
        head2.addBox(1F, 0F, -3F, 8, 8, 8);
        head2.setRotationPoint(4F, -8F, -16F);
        head2.setTextureSize(64, 32);
        head2.mirror = true;
        setRotation(head2, 0F, -0.3717861F, 0F);
        Spear2 = new DivineRenderer(this, -2, 0);
        Spear2.addBox(1F, 0F, 0F, 1, 1, 13);
        Spear2.setRotationPoint(5.5F, 10F, -1F);
        Spear2.setTextureSize(64, 32);
        Spear2.mirror = true;
        setRotation(Spear2, 3.141593F, -0.669215F, 0F);
        Shape1 = new DivineRenderer(this, 0, 0);
        Shape1.addBox(1F, -4F, -6F, 1, 1, 13);
        Shape1.setRotationPoint(-7F, 10F, -1F);
        Shape1.setTextureSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, -2.435199F, 0F, 0F);
        head3 = new DivineRenderer(this, 32, 0);
        head3.addBox(0F, 0F, 0F, 8, 8, 8);
        head3.setRotationPoint(-11.4F, -8F, -16F);
        head3.setTextureSize(64, 32);
        head3.mirror = true;
        setRotation(head3, 0F, 0F, 0F);
        connector1 = new DivineRenderer(this, 0, 20);
        connector1.addBox(0F, 0F, 0F, 4, 4, 6);
        connector1.setRotationPoint(-10F, -6F, -11F);
        connector1.setTextureSize(64, 32);
        connector1.mirror = true;
        setRotation(connector1, 0F, 0F, 0F);
        connector2 = new DivineRenderer(this, 0, 20);
        connector2.addBox(-4F, 0F, 0F, 20, 4, 4);
        connector2.setRotationPoint(-6F, -6F, -5F);
        connector2.setTextureSize(64, 32);
        connector2.mirror = true;
        setRotation(connector2, 0F, 0F, 0F);
    }

}
