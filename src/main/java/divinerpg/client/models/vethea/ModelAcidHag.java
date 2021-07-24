package divinerpg.client.models.vethea;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.*;

public class ModelAcidHag<T extends Entity> extends SegmentedModel<T> 
{
    //fields
    ModelRenderer body;
    ModelRenderer leftarmtop;
    ModelRenderer rightarmtop;
    ModelRenderer leftarmbottom;
    ModelRenderer rightarmbottom;
    ModelRenderer leftarms1;
    ModelRenderer rightarms1;
    ModelRenderer leftarms2;
    ModelRenderer rightarms2;
    ModelRenderer leftarms3;
    ModelRenderer rightarms3;
    ModelRenderer leftlegs1;
    ModelRenderer rightlegs1;
    ModelRenderer rightfoot;
    ModelRenderer leftfoot;
    ModelRenderer rightlegs2;
    ModelRenderer leftlegs2;
    ModelRenderer leftlegs3;
    ModelRenderer rightlegs3;
    ModelRenderer horn1;
    ModelRenderer head;
    ModelRenderer horn2;

    public ModelAcidHag()
    {
        texWidth = 64;
        texHeight = 32;

        body = new ModelRenderer(this, 16, 16);
        body.addBox(-4F, 0F, -2F, 8, 12, 4);
        body.setPos(0F, 0F, 0F);
        body.setTexSize(64, 32);
        body.mirror = true;
        setRotation(body, 0F, 0F, 0F);
        leftarmtop = new ModelRenderer(this, 40, 16);
        leftarmtop.addBox(-1F, -2F, -2F, 4, 8, 4);
        leftarmtop.setPos(5F, 2F, 0F);
        leftarmtop.setTexSize(64, 32);
        leftarmtop.mirror = true;
        setRotation(leftarmtop, 0F, 0F, 0F);
        rightarmtop = new ModelRenderer(this, 40, 16);
        rightarmtop.addBox(-3F, -2F, -2F, 4, 8, 4);
        rightarmtop.setPos(-5F, 2F, 0F);
        rightarmtop.setTexSize(64, 32);
        rightarmtop.mirror = true;
        setRotation(rightarmtop, 0F, 0F, 0F);
        leftarmbottom = new ModelRenderer(this, 40, 25);
        leftarmbottom.addBox(-1F, 18F, -5F, 4, 3, 4);
        leftarmbottom.setPos(5F, 2F, 0F);
        leftarmbottom.setTexSize(64, 32);
        leftarmbottom.mirror = true;
        setRotation(leftarmbottom, 0.3490659F, 0F, 0F);
        rightarmbottom = new ModelRenderer(this, 40, 25);
        rightarmbottom.addBox(-3F, 18F, -5F, 4, 3, 4);
        rightarmbottom.setPos(-5F, 2F, 0F);
        rightarmbottom.setTexSize(64, 32);
        rightarmbottom.mirror = true;
        setRotation(rightarmbottom, 0.3490659F, 0F, 0F);
        leftarms1 = new ModelRenderer(this, 40, 20);
        leftarms1.addBox(-1F, 6F, -2F, 4, 4, 4);
        leftarms1.setPos(5F, 2F, 0F);
        leftarms1.setTexSize(64, 32);
        leftarms1.mirror = true;
        setRotation(leftarms1, 0.0872665F, 0F, 0F);
        rightarms1 = new ModelRenderer(this, 40, 20);
        rightarms1.addBox(-3F, 6F, -2F, 4, 4, 4);
        rightarms1.setPos(-5F, 2F, 0F);
        rightarms1.setTexSize(64, 32);
        rightarms1.mirror = true;
        setRotation(rightarms1, 0.0872665F, 0F, 0F);
        leftarms2 = new ModelRenderer(this, 40, 20);
        leftarms2.addBox(-1F, 10F, -3F, 4, 4, 4);
        leftarms2.setPos(5F, 2F, 0F);
        leftarms2.setTexSize(64, 32);
        leftarms2.mirror = true;
        setRotation(leftarms2, 0.1745329F, 0F, 0F);
        rightarms2 = new ModelRenderer(this, 40, 20);
        rightarms2.addBox(-3F, 10F, -3F, 4, 4, 4);
        rightarms2.setPos(-5F, 2F, 0F);
        rightarms2.setTexSize(64, 32);
        rightarms2.mirror = true;
        setRotation(rightarms2, 0.1745329F, 0F, 0F);
        leftarms3 = new ModelRenderer(this, 40, 20);
        leftarms3.addBox(-1F, 14F, -4F, 4, 4, 4);
        leftarms3.setPos(5F, 2F, 0F);
        leftarms3.setTexSize(64, 32);
        leftarms3.mirror = true;
        setRotation(leftarms3, 0.2617994F, 0F, 0F);
        rightarms3 = new ModelRenderer(this, 40, 20);
        rightarms3.addBox(-3F, 14F, -4F, 4, 4, 4);
        rightarms3.setPos(-5F, 2F, 0F);
        rightarms3.setTexSize(64, 32);
        rightarms3.mirror = true;
        setRotation(rightarms3, 0.2617994F, 0F, 0F);
        leftlegs1 = new ModelRenderer(this, 0, 16);
        leftlegs1.addBox(0F, 3F, -2F, 2, 3, 4);
        leftlegs1.setPos(2F, 12F, 0F);
        leftlegs1.setTexSize(64, 32);
        leftlegs1.mirror = true;
        setRotation(leftlegs1, 0F, 0F, 0F);
        rightlegs1 = new ModelRenderer(this, 0, 16);
        rightlegs1.addBox(-2F, 3F, -2F, 2, 3, 4);
        rightlegs1.setPos(-2F, 12F, 0F);
        rightlegs1.setTexSize(64, 32);
        rightlegs1.mirror = true;
        setRotation(rightlegs1, 0F, 0F, 0F);
        rightfoot = new ModelRenderer(this, 32, 0);
        rightfoot.addBox(-2F, 6F, -6F, 3, 3, 7);
        rightfoot.setPos(-2F, 15F, 0F);
        rightfoot.setTexSize(64, 32);
        rightfoot.mirror = true;
        setRotation(rightfoot, 0F, 0F, 0F);
        leftfoot = new ModelRenderer(this, 32, 0);
        leftfoot.addBox(-1F, 6F, -6F, 3, 3, 7);
        leftfoot.setPos(2F, 15F, 0F);
        leftfoot.setTexSize(64, 32);
        leftfoot.mirror = true;
        setRotation(leftfoot, 0F, 0F, 0F);
        rightlegs2 = new ModelRenderer(this, 0, 16);
        rightlegs2.addBox(-2F, 0F, -2F, 3, 3, 4);
        rightlegs2.setPos(-2F, 12F, 0F);
        rightlegs2.setTexSize(64, 32);
        rightlegs2.mirror = true;
        setRotation(rightlegs2, 0F, 0F, 0F);
        leftlegs2 = new ModelRenderer(this, 0, 16);
        leftlegs2.addBox(-1F, 0F, -2F, 3, 3, 4);
        leftlegs2.setPos(2F, 12F, 0F);
        leftlegs2.setTexSize(64, 32);
        leftlegs2.mirror = true;
        setRotation(leftlegs2, 0F, 0F, 0F);
        leftlegs3 = new ModelRenderer(this, 0, 16);
        leftlegs3.addBox(-1F, 6F, -2F, 3, 3, 4);
        leftlegs3.setPos(2F, 12F, 0F);
        leftlegs3.setTexSize(64, 32);
        leftlegs3.mirror = true;
        setRotation(leftlegs3, 0F, 0F, 0F);
        rightlegs3 = new ModelRenderer(this, 0, 16);
        rightlegs3.addBox(-2F, 6F, -2F, 3, 3, 4);
        rightlegs3.setPos(-2F, 12F, 0F);
        rightlegs3.setTexSize(64, 32);
        rightlegs3.mirror = true;
        setRotation(rightlegs3, 0F, 0F, 0F);
        horn1 = new ModelRenderer(this, 32, 0);
        horn1.addBox(1F, -7F, -12F, 2, 2, 8);
        horn1.setPos(0F, 5F, 0F);
        horn1.setTexSize(64, 32);
        horn1.mirror = true;
        setRotation(horn1, -0.7853982F, 0F, 0F);
        head = new ModelRenderer(this, 0, 0);
        head.addBox(-4F, -8F, -4F, 8, 8, 8);
        head.setPos(0F, 5F, 0F);
        head.setTexSize(64, 32);
        head.mirror = true;
        setRotation(head, 0F, 0F, 0F);
        horn2 = new ModelRenderer(this, 32, 0);
        horn2.addBox(-3F, -7F, -12F, 2, 2, 8);
        horn2.setPos(0F, 5F, 0F);
        horn2.setTexSize(64, 32);
        horn2.mirror = true;
        setRotation(horn2, -0.7853982F, 0F, 0F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(body, leftarmtop, rightarmtop, leftarmbottom, rightarmbottom, leftarms1, rightarms1, leftarms2, rightarms2, leftarms3, rightarms3, leftlegs1, rightlegs1, rightfoot, leftfoot, rightlegs2, leftlegs2, leftlegs3, rightlegs3, horn1, head, horn2);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        this.leftlegs1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftlegs2.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftlegs3.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftfoot.xRot = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

        this.rightlegs1.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightlegs2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightlegs3.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.rightfoot.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;

        this.rightarms1.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F + 0.0872665F;
        this.rightarms2.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F + 0.1745329F;
        this.rightarms3.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F + 0.2617994F;
        this.rightarmtop.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.rightarmbottom.xRot = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 2.0F * limbSwingAmount * 0.5F + 0.3490659F;

        this.leftarms1.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F + 0.0872665F;
        this.leftarms2.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F + 0.1745329F;
        this.leftarms3.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F + 0.2617994F;
        this.leftarmtop.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
        this.leftarmbottom.xRot = MathHelper.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F + 0.3490659F;
    }
}