package divinerpg.client.models.vethea;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.*;

public class ModelShadahier<T extends Entity> extends SegmentedModel<T>
{
    //fields
    ModelRenderer part1;
    ModelRenderer part2;
    ModelRenderer part3;
    ModelRenderer part4;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer rightarm1;
    ModelRenderer leftarm1;
    ModelRenderer leftarm2;
    ModelRenderer rightarm2;
    ModelRenderer leftarm3;
    ModelRenderer rightarm3;
    ModelRenderer leftarm4;
    ModelRenderer rightarm4;
    ModelRenderer leftarm5;
    ModelRenderer rightarm5;
    ModelRenderer leftarm6;
    ModelRenderer rightarm6;
    ModelRenderer part5;
    ModelRenderer part6;
    ModelRenderer part7;
    ModelRenderer part8;
    ModelRenderer part9;
    ModelRenderer part10;
    ModelRenderer part11;
    ModelRenderer part12;
    ModelRenderer part13;
    ModelRenderer part14;

    public ModelShadahier()
    {
        texWidth = 64;
        texHeight = 32;

        part1 = new ModelRenderer(this, 56, 26);
        part1.addBox(8F, -9F, -3F, 2, 4, 2);
        part1.setPos(0F, 10F, 0F);
        part1.setTexSize(64, 32);
        part1.mirror = true;
        setRotation(part1, 0F, 0F, 0F);
        part2 = new ModelRenderer(this, 16, 16);
        part2.addBox(-4F, 0F, -2F, 8, 7, 4);
        part2.setPos(0F, 10F, 0F);
        part2.setTexSize(64, 32);
        part2.mirror = true;
        setRotation(part2, 0F, 0F, 0F);
        part3 = new ModelRenderer(this, 33, 0);
        part3.addBox(-3F, -3F, -3F, 6, 4, 6);
        part3.setPos(-7F, 12F, 0F);
        part3.setTexSize(64, 32);
        part3.mirror = true;
        setRotation(part3, 0F, 0F, 0F);
        part4 = new ModelRenderer(this, 33, 0);
        part4.addBox(-3F, -3F, -3F, 6, 4, 6);
        part4.setPos(7F, 12F, 0F);
        part4.setTexSize(64, 32);
        part4.mirror = true;
        setRotation(part4, 0F, 0F, 0F);
        rightleg = new ModelRenderer(this, 0, 21);
        rightleg.addBox(-2F, 0F, -2F, 4, 7, 4);
        rightleg.setPos(-3F, 17F, 0F);
        rightleg.setTexSize(64, 32);
        rightleg.mirror = true;
        setRotation(rightleg, 0F, 0F, 0F);
        leftleg = new ModelRenderer(this, 0, 21);
        leftleg.addBox(-2F, 0F, -2F, 4, 7, 4);
        leftleg.setPos(3F, 17F, 0F);
        leftleg.setTexSize(64, 32);
        leftleg.mirror = true;
        setRotation(leftleg, 0F, 0F, 0F);
        rightarm1 = new ModelRenderer(this, 58, 0);
        rightarm1.addBox(-1F, 2F, 2F, 2, 8, 1);
        rightarm1.setPos(-7F, 12F, 0F);
        rightarm1.setTexSize(64, 32);
        rightarm1.mirror = true;
        setRotation(rightarm1, 0F, 0F, 0.5235988F);
        leftarm1 = new ModelRenderer(this, 58, 0);
        leftarm1.addBox(-1F, 2F, 2F, 2, 8, 1);
        leftarm1.setPos(7F, 12F, 0F);
        leftarm1.setTexSize(64, 32);
        leftarm1.mirror = true;
        setRotation(leftarm1, 0F, 0F, -0.5235988F);
        leftarm2 = new ModelRenderer(this, 40, 12);
        leftarm2.addBox(0F, 6F, -7F, 2, 2, 6);
        leftarm2.setPos(7F, 12F, 0F);
        leftarm2.setTexSize(64, 32);
        leftarm2.mirror = true;
        setRotation(leftarm2, 0F, 0F, 0F);
        rightarm2 = new ModelRenderer(this, 40, 12);
        rightarm2.addBox(-2F, 6F, -7F, 2, 2, 6);
        rightarm2.setPos(-7F, 12F, 0F);
        rightarm2.setTexSize(64, 32);
        rightarm2.mirror = true;
        setRotation(rightarm2, 0F, 0F, 0F);
        leftarm3 = new ModelRenderer(this, 58, 0);
        leftarm3.addBox(-1F, 2F, -1F, 2, 8, 1);
        leftarm3.setPos(7F, 12F, 1F);
        leftarm3.setTexSize(64, 32);
        leftarm3.mirror = true;
        setRotation(leftarm3, 0F, 0F, -0.5235988F);
        rightarm3 = new ModelRenderer(this, 58, 0);
        rightarm3.addBox(-1F, 2F, -1F, 2, 8, 1);
        rightarm3.setPos(-7F, 12F, 1F);
        rightarm3.setTexSize(64, 32);
        rightarm3.mirror = true;
        setRotation(rightarm3, 0F, 0F, 0.5235988F);
        leftarm4 = new ModelRenderer(this, 58, 0);
        leftarm4.addBox(-1F, 2F, -3F, 2, 8, 1);
        leftarm4.setPos(7F, 12F, 0F);
        leftarm4.setTexSize(64, 32);
        leftarm4.mirror = true;
        setRotation(leftarm4, 0F, 0F, -0.5235988F);
        rightarm4 = new ModelRenderer(this, 58, 0);
        rightarm4.addBox(-1F, 2F, -3F, 2, 8, 1);
        rightarm4.setPos(-7F, 12F, 0F);
        rightarm4.setTexSize(64, 32);
        rightarm4.mirror = true;
        setRotation(rightarm4, 0F, 0F, 0.5235988F);
        leftarm5 = new ModelRenderer(this, 58, 0);
        leftarm5.addBox(-1F, 2F, -1F, 2, 8, 1);
        leftarm5.setPos(7F, 12F, 0F);
        leftarm5.setTexSize(64, 32);
        leftarm5.mirror = true;
        setRotation(leftarm5, 0F, 0F, -0.5235988F);
        rightarm5 = new ModelRenderer(this, 58, 0);
        rightarm5.addBox(-1F, 2F, -1F, 2, 8, 1);
        rightarm5.setPos(-7F, 12F, 0F);
        rightarm5.setTexSize(64, 32);
        rightarm5.mirror = true;
        setRotation(rightarm5, 0F, 0F, 0.5235988F);
        leftarm6 = new ModelRenderer(this, 40, 20);
        leftarm6.addBox(-1F, 1F, -2F, 4, 8, 4);
        leftarm6.setPos(7F, 12F, 0F);
        leftarm6.setTexSize(64, 32);
        leftarm6.mirror = true;
        setRotation(leftarm6, 0F, 0F, 0F);
        rightarm6 = new ModelRenderer(this, 40, 20);
        rightarm6.addBox(-3F, 1F, -2F, 4, 8, 4);
        rightarm6.setPos(-7F, 12F, 0F);
        rightarm6.setTexSize(64, 32);
        rightarm6.mirror = true;
        setRotation(rightarm6, 0F, 0F, 0F);
        part5 = new ModelRenderer(this, 52, 11);
        part5.addBox(1F, -4F, -5F, 2, 2, 4);
        part5.setPos(0F, 10F, 0F);
        part5.setTexSize(64, 32);
        part5.mirror = true;
        setRotation(part5, 0.7853982F, 0F, 0F);
        part6 = new ModelRenderer(this, 56, 26);
        part6.addBox(-10F, -9F, -3F, 2, 4, 2);
        part6.setPos(0F, 10F, 0F);
        part6.setTexSize(64, 32);
        part6.mirror = true;
        setRotation(part6, 0F, 0F, 0F);
        part7 = new ModelRenderer(this, 33, 11);
        part7.addBox(4F, -7F, -3F, 4, 2, 2);
        part7.setPos(0F, 10F, 0F);
        part7.setTexSize(64, 32);
        part7.mirror = true;
        setRotation(part7, 0F, 0F, 0F);
        part8 = new ModelRenderer(this, 33, 11);
        part8.addBox(-8F, -7F, -3F, 4, 2, 2);
        part8.setPos(0F, 10F, 0F);
        part8.setTexSize(64, 32);
        part8.mirror = true;
        setRotation(part8, 0F, 0F, 0F);
        part9 = new ModelRenderer(this, 56, 26);
        part9.addBox(-10F, -9F, 1F, 2, 4, 2);
        part9.setPos(0F, 10F, 0F);
        part9.setTexSize(64, 32);
        part9.mirror = true;
        setRotation(part9, 0F, 0F, 0F);
        part10 = new ModelRenderer(this, 33, 11);
        part10.addBox(-8F, -7F, 1F, 4, 2, 2);
        part10.setPos(0F, 10F, 0F);
        part10.setTexSize(64, 32);
        part10.mirror = true;
        setRotation(part10, 0F, 0F, 0F);
        part11 = new ModelRenderer(this, 33, 11);
        part11.addBox(4F, -7F, 1F, 4, 2, 2);
        part11.setPos(0F, 10F, 0F);
        part11.setTexSize(64, 32);
        part11.mirror = true;
        setRotation(part11, 0F, 0F, 0F);
        part12 = new ModelRenderer(this, 56, 26);
        part12.addBox(8F, -9F, 1F, 2, 4, 2);
        part12.setPos(0F, 10F, 0F);
        part12.setTexSize(64, 32);
        part12.mirror = true;
        setRotation(part12, 0F, 0F, 0F);
        part13 = new ModelRenderer(this, 0, 0);
        part13.addBox(-4F, -8F, -4F, 8, 8, 8);
        part13.setPos(0F, 10F, 0F);
        part13.setTexSize(64, 32);
        part13.mirror = true;
        setRotation(part13, 0F, 0F, 0F);
        part14 = new ModelRenderer(this, 52, 11);
        part14.addBox(-3F, -4F, -5F, 2, 2, 4);
        part14.setPos(0F, 10F, 0F);
        part14.setTexSize(64, 32);
        part14.mirror = true;
        setRotation(part14, 0.7853982F, 0F, 0F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(part1, part2, part3, part4, rightleg, leftleg, rightarm1, leftarm1, leftarm2, rightarm2, leftarm3, rightarm3, leftarm4, rightarm4, leftarm5, rightarm5, leftarm6, rightarm6, part5, part6, part7, part8, part9, part10, part11, part12, part13, part14);
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

        this.rightarm1.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarm2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarm3.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarm4.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarm5.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarm6.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;

        this.leftarm1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarm2.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarm3.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarm4.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarm5.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarm6.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
    }
}