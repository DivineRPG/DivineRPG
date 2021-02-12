package divinerpg.client.models.twilight;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelTwilightGolem<T extends Entity> extends SegmentedModel<T> {
    ModelRenderer torso;
    ModelRenderer body;
    ModelRenderer headLeft;
    ModelRenderer headRight;
    ModelRenderer rightShoulder;
    ModelRenderer rightArm;
    ModelRenderer rightHand;
    ModelRenderer leftShoulder;
    ModelRenderer leftArm;
    ModelRenderer leftHand;
    ModelRenderer rightLeg;
    ModelRenderer leftLeg;

    public ModelTwilightGolem() {
        textureWidth = 128;
        textureHeight = 64;

        torso = new ModelRenderer(this, 64, 0);
        torso.addBox(0F, 0F, 0F, 16, 16, 8);
        torso.setRotationPoint(-8F, -8F, -4F);
        torso.setTextureSize(128, 64);
        torso.mirror = true;
        setRotation(torso, 0F, 0F, 0F);
        body = new ModelRenderer(this, 0, 0);
        body.addBox(0F, 0F, 0F, 20, 12, 12);
        body.setRotationPoint(-10F, -20F, -6F);
        body.setTextureSize(128, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        headLeft = new ModelRenderer(this, 0, 44);
        headLeft.addBox(-4F, -5F, -8F, 7, 12, 8);
        headLeft.setRotationPoint(5F, -20F, -2F);
        headLeft.setTextureSize(128, 64);
        headLeft.mirror = true;
        setRotation(headLeft, 0F, 0F, 0F);
        headRight = new ModelRenderer(this, 0, 44);
        headRight.addBox(-4F, -5F, -8F, 7, 12, 8);
        headRight.setRotationPoint(-4F, -20F, -2F);
        headRight.setTextureSize(128, 64);
        headRight.mirror = true;
        setRotation(headRight, 0F, 0F, 0F);
        rightShoulder = new ModelRenderer(this, 0, 32);
        rightShoulder.addBox(-3F, -3F, -3F, 6, 6, 6);
        rightShoulder.setRotationPoint(-12F, -20F, 0F);
        rightShoulder.setTextureSize(128, 64);
        rightShoulder.mirror = true;
        setRotation(rightShoulder, 0F, 0F, 0F);
        rightArm = new ModelRenderer(this, 30, 44);
        rightArm.addBox(-2F, 3F, -2F, 4, 16, 4);
        rightArm.setRotationPoint(-12F, -20F, 0F);
        rightArm.setTextureSize(128, 64);
        rightArm.mirror = true;
        setRotation(rightArm, 0F, 0F, 0F);
        rightHand = new ModelRenderer(this, 0, 32);
        rightHand.addBox(-3F, 19F, -3F, 6, 6, 6);
        rightHand.setRotationPoint(-12F, -20F, 0F);
        rightHand.setTextureSize(128, 64);
        rightHand.mirror = true;
        setRotation(rightHand, 0F, 0F, 0F);
        leftShoulder = new ModelRenderer(this, 0, 32);
        leftShoulder.addBox(-3F, -3F, -3F, 6, 6, 6);
        leftShoulder.setRotationPoint(12F, -20F, 0F);
        leftShoulder.setTextureSize(128, 64);
        leftShoulder.mirror = true;
        setRotation(leftShoulder, 0F, 0F, 0F);
        leftArm = new ModelRenderer(this, 30, 44);
        leftArm.addBox(-2F, 3F, -2F, 4, 16, 4);
        leftArm.setRotationPoint(12F, -20F, 0F);
        leftArm.setTextureSize(128, 64);
        leftArm.mirror = true;
        setRotation(leftArm, 0F, 0F, 0F);
        leftHand = new ModelRenderer(this, 0, 32);
        leftHand.addBox(-3F, 19F, -3F, 6, 6, 6);
        leftHand.setRotationPoint(12F, -20F, 0F);
        leftHand.setTextureSize(128, 64);
        leftHand.mirror = true;
        setRotation(leftHand, 0F, 0F, 0F);
        rightLeg = new ModelRenderer(this, 46, 40);
        rightLeg.addBox(-4F, 0F, -4F, 8, 16, 8);
        rightLeg.setRotationPoint(-6F, 8F, 0F);
        rightLeg.setTextureSize(128, 64);
        rightLeg.mirror = true;
        setRotation(rightLeg, 0F, 0F, 0F);
        leftLeg = new ModelRenderer(this, 46, 40);
        leftLeg.addBox(-4F, 0F, -4F, 8, 16, 8);
        leftLeg.setRotationPoint(6F, 8F, 0F);
        leftLeg.setTextureSize(128, 64);
        leftLeg.mirror = true;
        setRotation(leftLeg, 0F, 0F, 0F);
    }

    @Override
    public Iterable<ModelRenderer> getParts() {
        return ImmutableList.of(torso, body, headLeft, headRight, rightShoulder, rightArm, rightHand, leftShoulder, leftArm, leftHand, rightLeg, leftLeg);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    @Override
    public void setRotationAngles(T e, float f, float f1, float f2, float f3, float f4) {
        this.headLeft.rotateAngleX = this.headRight.rotateAngleX = f4 / (180F / (float)Math.PI);
        this.headLeft.rotateAngleY = this.headRight.rotateAngleY = f3 / (180F / (float)Math.PI);
        this.leftLeg.rotateAngleX = this.rightHand.rotateAngleX = this.rightArm.rotateAngleX = this.rightShoulder.rotateAngleX = MathHelper.cos(f)*f1;
        this.rightLeg.rotateAngleX = this.leftHand.rotateAngleX = this.leftArm.rotateAngleX = this.leftShoulder.rotateAngleX = MathHelper.cos(f+(float)Math.PI)*f1*0.7f;
    }

}
