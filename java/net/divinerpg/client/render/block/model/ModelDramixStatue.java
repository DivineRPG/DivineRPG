package net.divinerpg.client.render.block.model;

import net.divinerpg.api.model.DivineModel;
import net.divinerpg.api.model.DivineRenderer;
import net.minecraft.client.model.ModelRenderer;

public class ModelDramixStatue extends DivineModel
{
    //fields
    ModelRenderer Leg_Right;
    ModelRenderer Leg_Left;
    ModelRenderer Arm_Right;
    ModelRenderer Arm_Left;
    ModelRenderer Head;
    ModelRenderer Chest;

    public ModelDramixStatue()
    {
        super("statueDramix", 64, 64);

        Leg_Right = new DivineRenderer(this, 0, 22);
        Leg_Right.addBox(-2F, -2F, -3F, 5, 15, 6);
        Leg_Right.setRotationPoint(-4F, 11F, 1F);
        Leg_Right.setTextureSize(64, 64);
        Leg_Right.mirror = true;
        setRotation(Leg_Right, 0F, 0F, 0F);
        Leg_Left = new DivineRenderer(this, 0, 22);
        Leg_Left.addBox(-3F, -2F, -3F, 5, 15, 6);
        Leg_Left.setRotationPoint(4F, 11F, 1F);
        Leg_Left.setTextureSize(64, 64);
        Leg_Left.mirror = true;
        setRotation(Leg_Left, -0.8922867F, 0F, 0F);
        Arm_Right = new DivineRenderer(this, 22, 22);
        Arm_Right.addBox(-2F, -2F, -3F, 4, 16, 6);
        Arm_Right.setRotationPoint(-8F, -5F, 1F);
        Arm_Right.setTextureSize(64, 64);
        Arm_Right.mirror = true;
        setRotation(Arm_Right, -2.342252F, 0F, 0F);
        Arm_Right.mirror = false;
        Arm_Left = new DivineRenderer(this, 22, 22);
        Arm_Left.addBox(-2F, -2F, -3F, 4, 16, 6);
        Arm_Left.setRotationPoint(8F, -5F, 1F);
        Arm_Left.setTextureSize(64, 64);
        Arm_Left.mirror = true;
        setRotation(Arm_Left, -2.342252F, 0F, 0F);
        Head = new DivineRenderer(this, 36, 0);
        Head.addBox(-3F, -5F, -3F, 6, 10, 6);
        Head.setRotationPoint(0F, -12F, 1F);
        Head.setTextureSize(64, 64);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Chest = new DivineRenderer(this, 0, 0);
        Chest.addBox(-6F, -7F, -2F, 12, 16, 6);
        Chest.setRotationPoint(0F, 0F, 0F);
        Chest.setTextureSize(64, 64);
        Chest.mirror = true;
        setRotation(Chest, 0F, 0F, 0F);
    }

}
