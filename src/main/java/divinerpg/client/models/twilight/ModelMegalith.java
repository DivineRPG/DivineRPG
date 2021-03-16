package divinerpg.client.models.twilight;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.*;

@OnlyIn(Dist.CLIENT)
public class ModelMegalith<T extends Entity> extends SegmentedModel<T> {
    
    ModelRenderer torso;
    ModelRenderer body;
    ModelRenderer rightArm;
    ModelRenderer rightHand;
    ModelRenderer leftArm;
    ModelRenderer leftHand;
    ModelRenderer rightLeg;
    ModelRenderer leftLeg;
    ModelRenderer upperBody;
    ModelRenderer head;

    public ModelMegalith() {
        texWidth = 256;
        texHeight = 64;

        torso = new ModelRenderer(this, 64, 0);
        torso.addBox(0F, 0F, 0F, 16, 16, 8);
        torso.setPos(-8F, -8F, -4F);
        torso.setTexSize(256, 64);
        torso.mirror = true;
        setRotation(torso, 0F, 0F, 0F);
        body = new ModelRenderer(this, 0, 0);
        body.addBox(0F, 0F, 0F, 20, 12, 12);
        body.setPos(-10F, -20F, -6F);
        body.setTexSize(256, 64);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        rightArm = new ModelRenderer(this, 30, 42);
        rightArm.addBox(-3F, 3F, -3F, 6, 16, 6);
        rightArm.setPos(-13F, -32F, 0F);
        rightArm.setTexSize(256, 64);
        rightArm.mirror = true;
        setRotation(rightArm, 0F, 0F, 0.0872665F);
        rightHand = new ModelRenderer(this, 0, 24);
        rightHand.addBox(-4.5F, 19F, -4.5F, 9, 8, 9);
        rightHand.setPos(-13F, -32F, 0F);
        rightHand.setTexSize(256, 64);
        rightHand.mirror = true;
        setRotation(rightHand, 0F, 0F, 0.0872665F);
        leftArm = new ModelRenderer(this, 30, 42);
        leftArm.addBox(-3F, 3F, -3F, 6, 16, 6);
        leftArm.setPos(13F, -32F, 0F);
        leftArm.setTexSize(256, 64);
        leftArm.mirror = true;
        setRotation(leftArm, 0F, 0F, -0.0872665F);
        leftHand = new ModelRenderer(this, 0, 24);
        leftHand.addBox(-4.5F, 19F, -4.5F, 9, 8, 9);
        leftHand.setPos(13F, -32F, 0F);
        leftHand.setTexSize(256, 64);
        leftHand.mirror = true;
        setRotation(leftHand, 0F, 0F, -0.0872665F);
        rightLeg = new ModelRenderer(this, 54, 38);
        rightLeg.addBox(-4F, 0F, -5F, 8, 16, 10);
        rightLeg.setPos(-6F, 8F, 0F);
        rightLeg.setTexSize(256, 64);
        rightLeg.mirror = true;
        setRotation(rightLeg, 0F, 0F, 0F);
        leftLeg = new ModelRenderer(this, 54, 38);
        leftLeg.addBox(-4F, 0F, -5F, 8, 16, 10);
        leftLeg.setPos(6F, 8F, 0F);
        leftLeg.setTexSize(256, 64);
        leftLeg.mirror = true;
        setRotation(leftLeg, 0F, 0F, 0F);
        upperBody = new ModelRenderer(this, 112, 0);
        upperBody.addBox(0F, 0F, 0F, 22, 12, 14);
        upperBody.setPos(-11F, -32F, -7F);
        upperBody.setTexSize(256, 64);
        upperBody.mirror = true;
        setRotation(upperBody, 0F, 0F, 0F);
        head = new ModelRenderer(this, 0, 49);
        head.addBox(-3F, 0F, -3F, 6, 9, 6);
        head.setPos(0F, -41F, 0F);
        head.setTexSize(256, 64);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(torso, body, rightArm, rightHand, leftArm, leftHand, rightLeg, leftLeg, upperBody, head);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    @Override
    public void setupAnim(T e, float f, float f1, float f2, float f3, float f4) {
        this.head.yRot = f3 / (180F / (float)Math.PI);
        this.leftLeg.xRot = this.rightHand.xRot = this.rightArm.xRot = MathHelper.cos(f)*f1;
        this.rightLeg.xRot = this.leftHand.xRot = this.leftArm.xRot = MathHelper.cos(f+(float)Math.PI)*f1*0.7f;
    }

}
