package divinerpg.client.models.vethea;

import com.google.common.collect.ImmutableList;

import net.minecraft.client.renderer.entity.model.SegmentedModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelZoragon<T extends Entity> extends SegmentedModel<T>
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
    ModelRenderer Shape15;
    ModelRenderer Shape16;
    ModelRenderer Shape17;
    ModelRenderer Shape18;
    ModelRenderer Shape19;
    ModelRenderer Shape20;
    ModelRenderer Shape21;

    public ModelZoragon()
    {
        texWidth = 128;
        texHeight = 32;Shape1 = new ModelRenderer(this, 64, 14);
        Shape1.addBox(-6F, 9F, -8F, 2, 2, 16);
        Shape1.setPos(14F, 4F, 0F);
        Shape1.setTexSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 0, 0);
        Shape2.addBox(-8F, -7F, -8F, 16, 16, 16);
        Shape2.setPos(0F, 4F, 0F);
        Shape2.setTexSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
        Shape3 = new ModelRenderer(this, 64, 0);
        Shape3.addBox(-8F, -7F, -8F, 2, 18, 2);
        Shape3.setPos(16F, 2F, 16F);
        Shape3.setTexSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, 0F);
        Shape4 = new ModelRenderer(this, 64, 0);
        Shape4.addBox(-8F, -7F, -8F, 2, 18, 2);
        Shape4.setPos(-2F, 4F, 16F);
        Shape4.setTexSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, 0F, 0F, 0F);
        Shape5 = new ModelRenderer(this, 74, 0);
        Shape5.addBox(-6F, 9F, -8F, 18, 2, 2);
        Shape5.setPos(-2F, 4F, 16F);
        Shape5.setTexSize(64, 32);
        Shape5.mirror = true;
        setRotation(Shape5, 0F, 0F, 0F);
        Shape6 = new ModelRenderer(this, 74, 0);
        Shape6.addBox(-6F, 9F, -8F, 18, 2, 2);
        Shape6.setPos(-4F, -14F, -2F);
        Shape6.setTexSize(64, 32);
        Shape6.mirror = true;
        setRotation(Shape6, 0F, 0F, 0F);
        Shape7 = new ModelRenderer(this, 64, 0);
        Shape7.addBox(-8F, -7F, -8F, 2, 18, 2);
        Shape7.setPos(-2F, 4F, -2F);
        Shape7.setTexSize(64, 32);
        Shape7.mirror = true;
        setRotation(Shape7, 0F, 0F, 0F);
        Shape8 = new ModelRenderer(this, 95, 7);
        Shape8.addBox(-1F, 4F, -3F, 10, 2, 2);
        Shape8.setPos(-2F, 16F, 8F);
        Shape8.setTexSize(64, 32);
        Shape8.mirror = true;
        setRotation(Shape8, 0F, 0F, -0.7853982F);
        Shape9 = new ModelRenderer(this, 64, 0);
        Shape9.addBox(-8F, -7F, -8F, 2, 18, 2);
        Shape9.setPos(16F, 2F, -2F);
        Shape9.setTexSize(64, 32);
        Shape9.mirror = true;
        setRotation(Shape9, 0F, 0F, 0F);
        Shape10 = new ModelRenderer(this, 74, 0);
        Shape10.addBox(-6F, 9F, -8F, 18, 2, 2);
        Shape10.setPos(-4F, -14F, 16F);
        Shape10.setTexSize(64, 32);
        Shape10.mirror = true;
        setRotation(Shape10, 0F, 0F, 0F);
        Shape11 = new ModelRenderer(this, 64, 14);
        Shape11.addBox(-6F, 9F, -8F, 2, 2, 16);
        Shape11.setPos(14F, -14F, 0F);
        Shape11.setTexSize(64, 32);
        Shape11.mirror = true;
        setRotation(Shape11, 0F, 0F, 0F);
        Shape12 = new ModelRenderer(this, 64, 14);
        Shape12.addBox(-6F, 9F, -8F, 2, 2, 16);
        Shape12.setPos(-4F, -14F, 0F);
        Shape12.setTexSize(64, 32);
        Shape12.mirror = true;
        setRotation(Shape12, 0F, 0F, 0F);
        Shape13 = new ModelRenderer(this, 64, 14);
        Shape13.addBox(-6F, 9F, -8F, 2, 2, 16);
        Shape13.setPos(-4F, 4F, 0F);
        Shape13.setTexSize(64, 32);
        Shape13.mirror = true;
        setRotation(Shape13, 0F, 0F, 0F);
        Shape14 = new ModelRenderer(this, 74, 0);
        Shape14.addBox(-6F, 9F, -8F, 18, 2, 2);
        Shape14.setPos(-2F, 4F, -2F);
        Shape14.setTexSize(64, 32);
        Shape14.mirror = true;
        setRotation(Shape14, 0F, 0F, 0F);
        Shape15 = new ModelRenderer(this, 95, 7);
        Shape15.addBox(-6F, 1F, -3F, 10, 2, 2);
        Shape15.setPos(-2F, 16F, 8F);
        Shape15.setTexSize(64, 32);
        Shape15.mirror = true;
        setRotation(Shape15, 0F, 0F, 0.7853982F);
        Shape16 = new ModelRenderer(this, 95, 7);
        Shape16.addBox(-1F, 4F, -3F, 10, 2, 2);
        Shape16.setPos(4F, 16F, -2F);
        Shape16.setTexSize(64, 32);
        Shape16.mirror = true;
        Shape15.mirror = false;
        setRotation(Shape16, 0F, -1.570796F, -0.7853982F);
        Shape17 = new ModelRenderer(this, 95, 7);
        Shape17.addBox(-6F, 1F, -3F, 10, 2, 2);
        Shape17.setPos(4F, 16F, -2F);
        Shape17.setTexSize(64, 32);
        Shape17.mirror = true;
        setRotation(Shape17, 0F, -1.570796F, 0.7853982F);
        Shape18 = new ModelRenderer(this, 95, 7);
        Shape18.addBox(-1F, 4F, -3F, 10, 2, 2);
        Shape18.setPos(-2F, 16F, -4F);
        Shape18.setTexSize(64, 32);
        Shape18.mirror = true;
        setRotation(Shape18, 0F, 0F, -0.7853982F);
        Shape19 = new ModelRenderer(this, 95, 7);
        Shape19.addBox(-6F, 1F, -3F, 10, 2, 2);
        Shape19.setPos(-2F, 16F, -4F);
        Shape19.setTexSize(64, 32);
        Shape19.mirror = true;
        setRotation(Shape19, 0F, 0F, 0.7853982F);
        Shape20 = new ModelRenderer(this, 95, 7);
        Shape20.addBox(-1F, 4F, -3F, 10, 2, 2);
        Shape20.setPos(-8F, 16F, -2F);
        Shape20.setTexSize(64, 32);
        Shape20.mirror = true;
        setRotation(Shape20, 0F, -1.570796F, -0.7853982F);
        Shape21 = new ModelRenderer(this, 95, 7);
        Shape21.addBox(-6F, 1F, -3F, 10, 2, 2);
        Shape21.setPos(-8F, 16F, -2F);
        Shape21.setTexSize(64, 32);
        Shape21.mirror = true;
        setRotation(Shape21, 0F, -1.570796F, 0.7853982F);

    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(Shape1, Shape2, Shape3, Shape4, Shape5, Shape6, Shape7, Shape8, Shape9, Shape10, Shape11, Shape12, Shape13, Shape14, Shape15, Shape16, Shape17, Shape18, Shape19, Shape20, Shape21);
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