package divinerpg.client.models.vethea;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelMandragora<T extends Entity> extends SegmentedModel<T>
{
    //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape4;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
    ModelRenderer Shape10;
    ModelRenderer Shape11;
    ModelRenderer Shape12;
    ModelRenderer Shape13;
    ModelRenderer Shape14;

    public ModelMandragora()
    {
        texWidth = 64;
        texHeight = 32;

        Shape1 = new ModelRenderer(this, 24, 13);
        Shape1.addBox(0F, 16F, 0F, 2, 9, 2);
        Shape1.setPos(-1F, -14F, -1F);
        Shape1.setTexSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 13, 4);
        Shape2.addBox(0F, 1F, -2F, 2, 5, 4);
        Shape2.setPos(0F, 10F, -1F);
        Shape2.setTexSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, -1.570796F, -0.7853982F);
        Shape3 = new ModelRenderer(this, 0, 21);
        Shape3.addBox(-1F, 0F, -1F, 6, 5, 6);
        Shape3.setPos(-2F, -23F, -2F);
        Shape3.setTexSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
        Shape4 = new ModelRenderer(this, 31, 0);
        Shape4.addBox(-1F, 5F, 1F, 6, 4, 0);
        Shape4.setPos(-1F, 0F, -1F);
        Shape4.setTexSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, 0F, 0F, -0.3490659F);
        Shape5 = new ModelRenderer(this, 13, 4);
        Shape5.addBox(0F, -1F, -2F, 2, 5, 4);
        Shape5.setPos(0F, 10F, -2F);
        Shape5.setTexSize(64, 32);
        Shape5.mirror = true;
        setRotation(Shape5, 0F, -1.570796F, 0.7853982F);
        Shape6 = new ModelRenderer(this, 13, 4);
        Shape6.addBox(0F, 1F, -2F, 2, 5, 4);
        Shape6.setPos(-1F, 10F, 0F);
        Shape6.setTexSize(64, 32);
        Shape6.mirror = true;
        setRotation(Shape6, 0F, 0F, -0.7853982F);
        Shape7 = new ModelRenderer(this, 13, 4);
        Shape7.addBox(0F, -1F, -2F, 2, 5, 4);
        Shape7.setPos(-2F, 10F, 0F);
        Shape7.setTexSize(64, 32);
        Shape7.mirror = true;
        setRotation(Shape7, 0F, 0F, 0.7853982F);
        Shape8 = new ModelRenderer(this, 0, 3);
        Shape8.addBox(0F, 0F, 0F, 2, 16, 2);
        Shape8.setPos(-1F, -14F, -1F);
        Shape8.setTexSize(64, 32);
        Shape8.mirror = true;
        setRotation(Shape8, 0F, 0F, 0F);
        Shape9 = new ModelRenderer(this, 31, 0);
        Shape9.addBox(-3F, 5F, 1F, 6, 4, 0);
        Shape9.setPos(-1F, -14F, -1F);
        Shape9.setTexSize(64, 32);
        Shape9.mirror = true;
        setRotation(Shape9, 0F, 0F, 0.3490659F);
        Shape10 = new ModelRenderer(this, 31, 0);
        Shape10.addBox(-8F, 17F, -1F, 6, 4, 0);
        Shape10.setPos(1F, -14F, -1F);
        Shape10.setTexSize(64, 32);
        Shape10.mirror = true;
        setRotation(Shape10, 0F, 1.570796F, -0.3490659F);
        Shape11 = new ModelRenderer(this, 31, 0);
        Shape11.addBox(0F, 2F, 1F, 6, 4, 0);
        Shape11.setPos(-1F, -14F, -1F);
        Shape11.setTexSize(64, 32);
        Shape11.mirror = true;
        setRotation(Shape11, 0F, 0F, -0.3490659F);
        Shape12 = new ModelRenderer(this, 31, 0);
        Shape12.addBox(-2F, 7F, -1F, 6, 4, 0);
        Shape12.setPos(-1F, -14F, -1F);
        Shape12.setTexSize(64, 32);
        Shape12.mirror = true;
        setRotation(Shape12, 0F, -1.570796F, -0.3490659F);
        Shape13 = new ModelRenderer(this, 24, 24);
        Shape13.addBox(-1F, 13F, -1F, 4, 4, 4);
        Shape13.setPos(-1F, -14F, -1F);
        Shape13.setTexSize(64, 32);
        Shape13.mirror = true;
        setRotation(Shape13, 0F, 0F, 0F);
        Shape14 = new ModelRenderer(this, 8, 13);
        Shape14.addBox(-1F, 0F, -1F, 4, 4, 4);
        Shape14.setPos(-1F, -18F, -1F);
        Shape14.setTexSize(64, 32);
        Shape14.mirror = true;
        setRotation(Shape14, 0F, 0F, 0F);
    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(Shape1, Shape2, Shape3, Shape4, Shape5, Shape6, Shape7, Shape8, Shape9, Shape10, Shape11, Shape12, Shape13, Shape14);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
    	model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }

    @Override
	public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
}