package divinerpg.client.models.vethea;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.*;

public class ModelBiphron<T extends Entity> extends SegmentedModel<T> 
{
    //fields
    ModelRenderer head;
    ModelRenderer bodytop;
    ModelRenderer rightarmts1;
    ModelRenderer leftarmts1;
    ModelRenderer rightlegts1;
    ModelRenderer leftlegts1;
    ModelRenderer leftlegts2;
    ModelRenderer rightlegts2;
    ModelRenderer rightarmtspike1;
    ModelRenderer leftarmtspike1;
    ModelRenderer rightarmts2;
    ModelRenderer leftarmts2;
    ModelRenderer leftarmtspike2;
    ModelRenderer rightarmtspike2;
    ModelRenderer bodybottom;
    ModelRenderer rightarms1;
    ModelRenderer leftarms1;
    ModelRenderer leftarms2;
    ModelRenderer leftarmspike1;
    ModelRenderer leftarmspike2;
    ModelRenderer rightarmspike1;
    ModelRenderer rightarms2;
    ModelRenderer rightarmspike2;
    ModelRenderer leftlegs1;
    ModelRenderer leftlegs2;
    ModelRenderer rightlegs2;
    ModelRenderer rightlegs1;

    public ModelBiphron()
    {
        texWidth = 64;
        texHeight = 32;

        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setPos(0F, 0F, 0F);
        head.setTexSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        bodytop = new ModelRenderer(this, 16, 16);
        bodytop.addBox(-4F, 0F, -2F, 8, 12, 4);
        bodytop.setPos(0F, -8F, 0F);
        bodytop.setTexSize(64, 32);
        bodytop.mirror = true;
        setRotation(bodytop, -3.141593F, 0F, 0F);
        rightarmts1 = new ModelRenderer(this, 48, 12);
        rightarmts1.addBox(-3F, -2F, -2F, 4, 3, 4);
        rightarmts1.setPos(-5F, -10F, 0F);
        rightarmts1.setTexSize(64, 32);
        rightarmts1.mirror = true;
        setRotation(rightarmts1, -3.141593F, 0F, 0F);
        leftarmts1 = new ModelRenderer(this, 48, 12);
        leftarmts1.addBox(7F, -2F, -2F, 4, 3, 4);
        leftarmts1.setPos(-3F, -10F, 0F);
        leftarmts1.setTexSize(64, 32);
        leftarmts1.mirror = true;
        setRotation(leftarmts1, -3.141593F, 0F, 0F);
        rightlegts1 = new ModelRenderer(this, 41, 23);
        rightlegts1.addBox(-3F, -3F, -3F, 6, 3, 6);
        rightlegts1.setPos(-6F, -20F, 0F);
        rightlegts1.setTexSize(64, 32);
        rightlegts1.mirror = true;
        setRotation(rightlegts1, -3.141593F, 0F, 0F);
        leftlegts1 = new ModelRenderer(this, 41, 23);
        leftlegts1.addBox(-3F, -3F, -3F, 6, 3, 6);
        leftlegts1.setPos(6F, -20F, 0F);
        leftlegts1.setTexSize(64, 32);
        leftlegts1.mirror = true;
        setRotation(leftlegts1, -3.141593F, 0F, 0F);
        leftlegts2 = new ModelRenderer(this, 0, 16);
        leftlegts2.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftlegts2.setPos(6F, -20F, 0F);
        leftlegts2.setTexSize(64, 32);
        leftlegts2.mirror = true;
        setRotation(leftlegts2, -3.141593F, 0F, 0F);
        rightlegts2 = new ModelRenderer(this, 0, 16);
        rightlegts2.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightlegts2.setPos(-6F, -20F, 0F);
        rightlegts2.setTexSize(64, 32);
        rightlegts2.mirror = true;
        setRotation(rightlegts2, -3.141593F, 0F, 0F);
        rightarmtspike1 = new ModelRenderer(this, 33, 0);
        rightarmtspike1.addBox(-7F, 6F, 1F, 1, 8, 1);
        rightarmtspike1.setPos(-5F, -10F, 0F);
        rightarmtspike1.setTexSize(64, 32);
        rightarmtspike1.mirror = true;
        setRotation(rightarmtspike1, -3.141593F, 0F, 0F);
        leftarmtspike1 = new ModelRenderer(this, 33, 0);
        leftarmtspike1.addBox(6F, 6F, 1F, 1, 8, 1);
        leftarmtspike1.setPos(5F, -10F, 0F);
        leftarmtspike1.setTexSize(64, 32);
        leftarmtspike1.mirror = true;
        setRotation(leftarmtspike1, -3.141593F, 0F, 0F);
        rightarmts2 = new ModelRenderer(this, 37, 0);
        rightarmts2.addBox(-7F, -2F, -2F, 4, 8, 4);
        rightarmts2.setPos(-5F, -10F, 0F);
        rightarmts2.setTexSize(64, 32);
        rightarmts2.mirror = true;
        setRotation(rightarmts2, -3.141593F, 0F, 0F);
        leftarmts2 = new ModelRenderer(this, 37, 0);
        leftarmts2.addBox(3F, -2F, -2F, 4, 8, 4);
        leftarmts2.setPos(5F, -10F, 0F);
        leftarmts2.setTexSize(64, 32);
        leftarmts2.mirror = true;
        setRotation(leftarmts2, -3.141593F, 0F, 0F);
        leftarmtspike2 = new ModelRenderer(this, 33, 0);
        leftarmtspike2.addBox(6F, 6F, -2F, 1, 8, 1);
        leftarmtspike2.setPos(5F, -10F, 0F);
        leftarmtspike2.setTexSize(64, 32);
        leftarmtspike2.mirror = true;
        setRotation(leftarmtspike2, -3.141593F, 0F, 0F);
        rightarmtspike2 = new ModelRenderer(this, 33, 0);
        rightarmtspike2.addBox(-7F, 6F, -2F, 1, 8, 1);
        rightarmtspike2.setPos(-5F, -10F, 0F);
        rightarmtspike2.setTexSize(64, 32);
        rightarmtspike2.mirror = true;
        setRotation(rightarmtspike2, -3.141593F, 0F, 0F);
        bodybottom = new ModelRenderer(this, 16, 16);
        bodybottom.addBox(-4F, 0F, -2F, 8, 12, 4);
        bodybottom.setPos(0F, 0F, 0F);
        bodybottom.setTexSize(64, 32);
        bodybottom.mirror = true;
        setRotation(bodybottom, 0F, 0F, 0F);
        rightarms1 = new ModelRenderer(this, 48, 12);
        rightarms1.addBox(-3F, -2F, -2F, 4, 3, 4);
        rightarms1.setPos(-5F, 2F, 0F);
        rightarms1.setTexSize(64, 32);
        rightarms1.mirror = true;
        setRotation(rightarms1, 0F, 0F, 0F);
        leftarms1 = new ModelRenderer(this, 48, 12);
        leftarms1.addBox(7F, -2F, -2F, 4, 3, 4);
        leftarms1.setPos(-3F, 2F, 0F);
        leftarms1.setTexSize(64, 32);
        leftarms1.mirror = true;
        setRotation(leftarms1, 0F, 0F, 0F);
        leftarms2 = new ModelRenderer(this, 37, 0);
        leftarms2.addBox(3F, -2F, -2F, 4, 8, 4);
        leftarms2.setPos(5F, 2F, 0F);
        leftarms2.setTexSize(64, 32);
        leftarms2.mirror = true;
        setRotation(leftarms2, 0F, 0F, 0F);
        leftarmspike1 = new ModelRenderer(this, 33, 0);
        leftarmspike1.addBox(6F, 6F, 1F, 1, 8, 1);
        leftarmspike1.setPos(5F, 2F, 0F);
        leftarmspike1.setTexSize(64, 32);
        leftarmspike1.mirror = true;
        setRotation(leftarmspike1, 0F, 0F, 0F);
        leftarmspike2 = new ModelRenderer(this, 33, 0);
        leftarmspike2.addBox(6F, 6F, -2F, 1, 8, 1);
        leftarmspike2.setPos(5F, 2F, 0F);
        leftarmspike2.setTexSize(64, 32);
        leftarmspike2.mirror = true;
        setRotation(leftarmspike2, 0F, 0F, 0F);
        rightarmspike1 = new ModelRenderer(this, 33, 0);
        rightarmspike1.addBox(-7F, 6F, -2F, 1, 8, 1);
        rightarmspike1.setPos(-5F, 2F, 0F);
        rightarmspike1.setTexSize(64, 32);
        rightarmspike1.mirror = true;
        setRotation(rightarmspike1, 0F, 0F, 0F);
        rightarms2 = new ModelRenderer(this, 37, 0);
        rightarms2.addBox(-7F, -2F, -2F, 4, 8, 4);
        rightarms2.setPos(-5F, 2F, 0F);
        rightarms2.setTexSize(64, 32);
        rightarms2.mirror = true;
        setRotation(rightarms2, 0F, 0F, 0F);
        rightarmspike2 = new ModelRenderer(this, 33, 0);
        rightarmspike2.addBox(-7F, 6F, 1F, 1, 8, 1);
        rightarmspike2.setPos(-5F, 2F, 0F);
        rightarmspike2.setTexSize(64, 32);
        rightarmspike2.mirror = true;
        setRotation(rightarmspike2, 0F, 0F, 0F);
        leftlegs1 = new ModelRenderer(this, 0, 16);
        leftlegs1.addBox(-2F, 0F, -2F, 4, 12, 4);
        leftlegs1.setPos(6F, 12F, 0F);
        leftlegs1.setTexSize(64, 32);
        leftlegs1.mirror = true;
        setRotation(leftlegs1, 0F, 0F, 0F);
        leftlegs2 = new ModelRenderer(this, 41, 23);
        leftlegs2.addBox(-3F, -3F, -3F, 6, 3, 6);
        leftlegs2.setPos(6F, 12F, 0F);
        leftlegs2.setTexSize(64, 32);
        leftlegs2.mirror = true;
        setRotation(leftlegs2, 0F, 0F, 0F);
        rightlegs2 = new ModelRenderer(this, 41, 23);
        rightlegs2.addBox(-3F, -3F, -3F, 6, 3, 6);
        rightlegs2.setPos(-6F, 12F, 0F);
        rightlegs2.setTexSize(64, 32);
        rightlegs2.mirror = true;
        setRotation(rightlegs2, 0F, 0F, 0F);
        rightlegs1 = new ModelRenderer(this, 0, 16);
        rightlegs1.addBox(-2F, 0F, -2F, 4, 12, 4);
        rightlegs1.setPos(-6F, 12F, 0F);
        rightlegs1.setTexSize(64, 32);
        rightlegs1.mirror = true;
        setRotation(rightlegs1, 0F, 0F, 0F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(head, bodytop, rightarmts1, leftarmts1, rightlegts1, leftlegts1, leftlegts2, rightlegts2, rightarmtspike1, leftarmtspike1, rightarmts2, leftarmts2, leftarmtspike2, rightarmtspike2, bodybottom, rightarms1, leftarms1, leftarms2, leftarmspike1, leftarmspike2, rightarmspike1, rightarms2, rightarmspike2, leftlegs1, leftlegs2, rightlegs2, rightlegs1);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    @Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.leftlegs1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftlegs2.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

        this.rightlegs1.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightlegs2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

        this.rightarms1.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarms2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarmspike1.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarmspike2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;

        this.leftarms1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarms2.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarmspike1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarmspike2.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;

        this.leftlegts1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - (float)Math.PI;
        this.leftlegts2.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount - (float)Math.PI;

        this.rightlegts1.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount - (float)Math.PI;
        this.rightlegts2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount - (float)Math.PI;

        this.rightarmts1.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - (float)Math.PI;
        this.rightarmts2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - (float)Math.PI;
        this.rightarmtspike1.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - (float)Math.PI;
        this.rightarmtspike2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F - (float)Math.PI;

        this.leftarmts1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - (float)Math.PI;
        this.leftarmts2.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - (float)Math.PI;
        this.leftarmtspike1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - (float)Math.PI;
        this.leftarmtspike2.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F - (float)Math.PI;
    }

}