package divinerpg.client.models.vethea;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.*;

public class ModelHoverStinger<T extends Entity> extends SegmentedModel<T>
{
    //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Wing1;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Wing2;
    ModelRenderer Wing3;
    ModelRenderer Wing4;

    public ModelHoverStinger()
    {
        texWidth = 64;
        texHeight = 32;

        Shape1 = new ModelRenderer(this, 0, 0);
        Shape1.addBox(0F, 0F, 1F, 8, 3, 8);
        Shape1.setPos(-4F, -1F, -3F);
        Shape1.setTexSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 0, 0);
        Shape2.addBox(0F, 0F, 0F, 6, 6, 6);
        Shape2.setPos(-3F, 8F, -1F);
        Shape2.setTexSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, -0.6108652F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 0, 0);
        Shape3.addBox(1F, 3F, 2F, 4, 6, 4);
        Shape3.setPos(-3F, 8F, -1F);
        Shape3.setTexSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, -0.7853982F, 0F, 0F);
        Shape4 = new ModelRenderer(this, 0, 18);
        Shape4.addBox(2F, 7F, 4F, 2, 5, 2);
        Shape4.setPos(-3F, 8F, -1F);
        Shape4.setTexSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, -0.9599311F, 0F, 0F);
        Shape5 = new ModelRenderer(this, 0, 0);
        Shape5.addBox(0F, 0F, 1F, 8, 6, 8);
        Shape5.setPos(-4F, 4F, -2F);
        Shape5.setTexSize(64, 32);
        Shape5.mirror = true;
        setRotation(Shape5, -0.4363323F, 0F, 0F);
        Shape6 = new ModelRenderer(this, 0, 0);
        Shape6.addBox(0F, 0F, 1F, 10, 6, 10);
        Shape6.setPos(-5F, 2F, -4F);
        Shape6.setTexSize(64, 32);
        Shape6.mirror = true;
        setRotation(Shape6, 0F, 0F, 0F);
        Shape7 = new ModelRenderer(this, 42, 0);
        Shape7.addBox(0F, 0F, 1F, 2, 8, 2);
        Shape7.setPos(4F, -15F, -8F);
        Shape7.setTexSize(64, 32);
        Shape7.mirror = true;
        setRotation(Shape7, 0F, 0F, 0F);
        Wing1 = new ModelRenderer(this, 0, 26);
        Wing1.addBox(0F, -2F, 1F, 10, 6, 0);
        Wing1.setPos(5F, 4F, 4F);
        Wing1.setTexSize(64, 32);
        Wing1.mirror = true;
        setRotation(Wing1, 0F, 0F, 0F);
        Wing1.mirror = false;
        Shape8 = new ModelRenderer(this, 22, 16);
        Shape8.addBox(0F, 0F, 1F, 8, 8, 8);
        Shape8.setPos(-4F, -11F, -10F);
        Shape8.setTexSize(64, 32);
        Shape8.mirror = true;
        setRotation(Shape8, 0F, 0F, 0F);
        Shape9 = new ModelRenderer(this, 42, 0);
        Shape9.addBox(0F, 0F, 1F, 2, 8, 2);
        Shape9.setPos(-6F, -15F, -8F);
        Shape9.setTexSize(64, 32);
        Shape9.mirror = true;
        setRotation(Shape9, 0F, 0F, 0F);
        Shape10 = new ModelRenderer(this, 0, 0);
        Shape10.addBox(0F, 0F, 1F, 10, 6, 10);
        Shape10.setPos(-5F, -7F, -4F);
        Shape10.setTexSize(64, 32);
        Shape10.mirror = true;
        setRotation(Shape10, 0F, 0F, 0F);
        Wing2 = new ModelRenderer(this, 0, 26);
        Wing2.addBox(-9F, -2F, 1F, 10, 6, 0);
        Wing2.setPos(-6F, 4F, 4F);
        Wing2.setTexSize(64, 32);
        Wing2.mirror = false;
        setRotation(Wing2, 0F, 0F, 0F);
        Wing3 = new ModelRenderer(this, 0, 26);
        Wing3.addBox(0F, -2F, 1F, 10, 6, 0);
        Wing3.setPos(5F, -5F, 2F);
        Wing3.setTexSize(64, 32);
        Wing3.mirror = true;
        setRotation(Wing3, 0F, 0F, 0F);
        Wing3.mirror = false;
        Wing4 = new ModelRenderer(this, 0, 26);
        Wing4.addBox(-9F, -2F, 1F, 10, 6, 0);
        Wing4.setPos(-6F, -5F, 2F);
        Wing4.setTexSize(64, 32);
        Wing4.mirror = false;
        setRotation(Wing4, 0F, 0F, 0F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(Shape1, Shape2, Shape3, Shape4, Shape5, Shape6, Shape7, Wing1, Shape8, Shape9, Shape10, Wing2, Wing3, Wing4);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    @Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.Wing1.yRot = MathHelper.cos(ageInTicks * 1.3F) * (float)Math.PI * 0.25F;
        this.Wing2.yRot = -this.Wing1.yRot;
        this.Wing3.yRot = MathHelper.cos(ageInTicks * 1.3F) * (float)Math.PI * 0.25F;
        this.Wing4.yRot = -this.Wing3.yRot;
    }
}