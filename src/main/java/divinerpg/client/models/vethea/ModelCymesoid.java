package divinerpg.client.models.vethea;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.*;

public class ModelCymesoid<T extends Entity> extends SegmentedModel<T> 
{
    //fields
    ModelRenderer head;
    ModelRenderer bodyext1;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer body;
    ModelRenderer bodyext2;
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;

    public ModelCymesoid()
    {
        texWidth = 64;
        texHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setPos(0F, 0F, 0F);
        head.setTexSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        bodyext1 = new ModelRenderer(this, 20, 22);
        bodyext1.addBox(-12F, 0F, 2F, 8, 6, 2);
        bodyext1.setPos(4F, 8F, 0F);
        bodyext1.setTexSize(64, 32);
        bodyext1.mirror = true;
        setRotation(bodyext1, 0F, 0F, 0F);
        rightarm = new ModelRenderer(this, 40, 16);
        rightarm.addBox(-3F, -2F, -2F, 4, 12, 4);
        rightarm.setPos(-5F, 2F, 0F);
        rightarm.setTexSize(64, 32);
        rightarm.mirror = true;
        setRotation(rightarm, 0F, 0F, 0F);
        leftarm = new ModelRenderer(this, 40, 16);
        leftarm.addBox(-1F, -2F, -2F, 4, 12, 4);
        leftarm.setPos(5F, 2F, 0F);
        leftarm.setTexSize(64, 32);
        leftarm.mirror = true;
        setRotation(leftarm, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 16);
        rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightleg.setPos(-2F, 12F, 0F);
        rightleg.setTexSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 16);
        leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftleg.setPos(2F, 12F, 0F);
        leftleg.setTexSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        body = new ModelRenderer(this, 16, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setPos(0F, 0F, 0F);
        body.setTexSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        bodyext2 = new ModelRenderer(this, 19, 22);
        bodyext2.addBox(-4F, 0F, 2F, 8, 6, 2);
        bodyext2.setPos(4F, 8F, 0F);
        bodyext2.setTexSize(64, 32);
        bodyext2.mirror = true;
        setRotation(bodyext2, 0F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 35, 0);
        Shape1.addBox(0F, 0F, 0F, 12, 14, 0);
        Shape1.setPos(1F, 0F, 2F);
        Shape1.setTexSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, -2.094395F, -0.7853982F);
        Shape2 = new ModelRenderer(this, 35, 0);
        Shape2.addBox(0F, 0F, 0F, 12, 14, 0);
        Shape2.setPos(1F, 0F, 2F);
        Shape2.setTexSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, -2.356194F, -0.6108652F);
        Shape3 = new ModelRenderer(this, 35, 0);
        Shape3.addBox(0F, 0F, 0F, 12, 14, 0);
        Shape3.setPos(1F, 0F, 2F);
        Shape3.setTexSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, -2.617994F, -0.4363323F);
        Shape4 = new ModelRenderer(this, 35, 0);
        Shape4.addBox(2F, 0F, 0F, 12, 14, 0);
        Shape4.setPos(2F, 0F, 2F);
        Shape4.setTexSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, 0F, -2.96706F, -0.2617994F);
        Shape5 = new ModelRenderer(this, 35, 0);
        Shape5.addBox(0F, 0F, 0F, 12, 14, 0);
        Shape5.setPos(2F, 0F, 2F);
        Shape5.setTexSize(64, 32);
        Shape5.mirror = true;
        setRotation(Shape5, 0F, -0.2617994F, -0.2617994F);
        Shape6 = new ModelRenderer(this, 35, 0);
        Shape6.addBox(0F, 0F, 0F, 12, 14, 0);
        Shape6.setPos(0F, 0F, 2F);
        Shape6.setTexSize(64, 32);
        Shape6.mirror = true;
        setRotation(Shape6, 0F, -0.5235988F, -0.4363323F);
        Shape7 = new ModelRenderer(this, 35, 0);
        Shape7.addBox(0F, 0F, 0F, 12, 14, 0);
        Shape7.setPos(-1F, 0F, 2F);
        Shape7.setTexSize(64, 32);
        Shape7.mirror = true;
        setRotation(Shape7, 0F, -0.7853982F, -0.6108652F);
        Shape8 = new ModelRenderer(this, 35, 0);
        Shape8.addBox(0F, 0F, 0F, 12, 14, 0);
        Shape8.setPos(-1F, 0F, 2F);
        Shape8.setTexSize(64, 32);
        Shape8.mirror = true;
        setRotation(Shape8, 0F, -1.047198F, -0.7853982F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, bodyext1, rightarm, leftarm, rightleg, leftleg, body, bodyext2, Shape1, Shape2, Shape3, Shape4, Shape5, Shape6, Shape7, Shape8);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }
    
    @Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.leftleg.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

        this.rightleg.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

        this.rightarm.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F + 0.0872665F;

        this.leftarm.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F + 0.0872665F;
    }

}