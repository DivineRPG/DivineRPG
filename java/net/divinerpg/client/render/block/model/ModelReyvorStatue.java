package net.divinerpg.client.render.block.model;

import net.divinerpg.api.model.DivineModel;
import net.divinerpg.api.model.DivineRenderer;
import net.minecraft.client.model.ModelRenderer;

public class ModelReyvorStatue extends DivineModel
{
    //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer head2;
    ModelRenderer head3;
    ModelRenderer head4;
    ModelRenderer head5;

    public ModelReyvorStatue()
    {
        super("TODO", 64, 32); //TODO

        head = new DivineRenderer(this, 0, 0);
        head.addBox(-11F, -8F, -4F, 8, 8, 8);
        head.setRotationPoint(1F, 0F, 0F);
        head.setTextureSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, -0.5576792F, 0F);
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
        setRotation(rightarm, -0.669215F, 0F, 0F);
        leftarm = new DivineRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setRotationPoint(5F, 2F, 0F);
        leftarm.setTextureSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, -0.5576792F, 0F);
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
        setRotation(leftleg, 0F, -0.3717861F, 0F);
        head2 = new DivineRenderer(this, 0, 0);
        head2.addBox(0F, 0F, 0F, 8, 8, 8);
        head2.setRotationPoint(1.466667F, -8F, -4F);
        head2.setTextureSize(64, 32);
        head2.mirror = true;
        setRotation(head2, 0F, -0.5576792F, 0F);
        head3 = new DivineRenderer(this, 0, 0);
        head3.addBox(-1F, 0F, -1F, 8, 8, 8);
        head3.setRotationPoint(-4F, -16F, 0F);
        head3.setTextureSize(64, 32);
        head3.mirror = true;
        setRotation(head3, 0F, -0.5576792F, 0F);
        head4 = new DivineRenderer(this, 0, 0);
        head4.addBox(-2F, 0F, -6F, 8, 8, 8);
        head4.setRotationPoint(-14F, -16F, 0F);
        head4.setTextureSize(64, 32);
        head4.mirror = true;
        setRotation(head4, 0F, -0.5576792F, 0F);
        head5 = new DivineRenderer(this, 0, 0);
        head5.addBox(0F, 0F, 4F, 8, 8, 8);
        head5.setRotationPoint(6F, -16F, 0F);
        head5.setTextureSize(64, 32);
        head5.mirror = true;
        setRotation(head5, 0F, -0.5576792F, 0F);
    }

}
