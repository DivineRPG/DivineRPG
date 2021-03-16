package divinerpg.client.models.arcana;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;

public class ModelDramix<T extends Entity> extends SegmentedModel<T>
{
    //fields
    ModelRenderer Leg_Right;
    ModelRenderer Leg_Left;
    ModelRenderer Arm_Right;
    ModelRenderer Arm_Left;
    ModelRenderer Head;
    ModelRenderer Chest;

    public ModelDramix()
    {
        texWidth = 64;
        texHeight = 64;
        Leg_Right = new ModelRenderer(this, 0, 22);
        Leg_Right.addBox(-2F, -2F, -3F, 5, 15, 6);
        Leg_Right.setPos(-4F, 11F, 1F);
        Leg_Right.setTexSize(64, 64);
        Leg_Right.mirror = true;
        setRotation(Leg_Right, 0F, 0F, 0F);
        Leg_Left = new ModelRenderer(this, 0, 22);
        Leg_Left.addBox(-3F, -2F, -3F, 5, 15, 6);
        Leg_Left.setPos(4F, 11F, 1F);
        Leg_Left.setTexSize(64, 64);
        Leg_Left.mirror = true;
        setRotation(Leg_Left, 0F, 0F, 0F);
        Arm_Right = new ModelRenderer(this, 22, 22);
        Arm_Right.addBox(-2F, -2F, -3F, 4, 16, 6);
        Arm_Right.setPos(-8F, -5F, 1F);
        Arm_Right.setTexSize(64, 64);
        Arm_Right.mirror = true;
        setRotation(Arm_Right, 0F, 0F, 0F);
        Arm_Left = new ModelRenderer(this, 22, 22);
        Arm_Left.addBox(-2F, -2F, -3F, 4, 16, 6);
        Arm_Left.setPos(8F, -5F, 1F);
        Arm_Left.setTexSize(64, 64);
        Arm_Left.mirror = true;
        setRotation(Arm_Left, 0F, 0F, 0F);
        Head = new ModelRenderer(this, 36, 0);
        Head.addBox(-3F, -5F, -3F, 6, 10, 6);
        Head.setPos(0F, -12F, 1F);
        Head.setTexSize(64, 64);
        Head.mirror = true;
        setRotation(Head, 0F, 0F, 0F);
        Chest = new ModelRenderer(this, 0, 0);
        Chest.addBox(-6F, -7F, -2F, 12, 16, 6);
        Chest.setPos(0F, 0F, 0F);
        Chest.setTexSize(64, 64);
        Chest.mirror = true;
        setRotation(Chest, 0F, 0F, 0F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(Leg_Right, Leg_Left, Arm_Right, Arm_Left, Head, Chest);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks,
                                  float netHeadYaw, float headPitch) {
        this.Arm_Right.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.Arm_Left.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.Arm_Right.zRot = 0.0F;
        this.Leg_Left.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.Leg_Right.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.Leg_Left.yRot = 0.0F;
        this.Leg_Right.yRot = 0.0F;
    }
}
