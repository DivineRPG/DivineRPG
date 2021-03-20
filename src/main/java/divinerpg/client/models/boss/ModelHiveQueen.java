package divinerpg.client.models.boss;

import com.google.common.collect.*;
import net.minecraft.client.renderer.entity.model.*;
import net.minecraft.client.renderer.model.*;
import net.minecraft.entity.*;

public class ModelHiveQueen<T extends Entity> extends SegmentedModel<T>
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
    ModelRenderer Shape30;
    ModelRenderer Shape31;
    ModelRenderer Shape32;
    ModelRenderer Shape33;

    public ModelHiveQueen()
    {
        texWidth = 64;
        texHeight = 32;

        Shape1 = new ModelRenderer(this, 24, 12);
        Shape1.addBox(0F, 0F, 0F, 10, 10, 10);
        Shape1.setPos(-5F, 14F, -5F);
        Shape1.setTexSize(64, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 0, 0);
        Shape2.addBox(0F, 0F, 0F, 6, 6, 6);
        Shape2.setPos(5F, 19F, -2F);
        Shape2.setTexSize(64, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, -2.268928F);
        Shape3 = new ModelRenderer(this, 0, 0);
        Shape3.addBox(-2F, 19F, 1F, 4, 6, 4);
        Shape3.setPos(-11F, 19F, -2F);
        Shape3.setTexSize(64, 32);
        Shape3.mirror = true;
        setRotation(Shape3, 0F, 0F, -1.919862F);
        Shape4 = new ModelRenderer(this, 29, 0);
        Shape4.addBox(6F, 22F, 2F, 2, 6, 2);
        Shape4.setPos(-11F, 17F, -2F);
        Shape4.setTexSize(64, 32);
        Shape4.mirror = true;
        setRotation(Shape4, 0F, 0F, -1.570796F);
        Shape5 = new ModelRenderer(this, 0, 0);
        Shape5.addBox(1F, -4F, 1F, 4, 6, 4);
        Shape5.setPos(-11F, 14F, -2F);
        Shape5.setTexSize(64, 32);
        Shape5.mirror = true;
        setRotation(Shape5, 0F, 0F, -1.134464F);
        Shape6 = new ModelRenderer(this, 0, 0);
        Shape6.addBox(0F, 0F, 0F, 6, 6, 6);
        Shape6.setPos(-11F, 14F, -2F);
        Shape6.setTexSize(64, 32);
        Shape6.mirror = true;
        setRotation(Shape6, 0F, 0F, -0.7853982F);
        Shape7 = new ModelRenderer(this, 29, 0);
        Shape7.addBox(3F, -8F, 2F, 2, 6, 2);
        Shape7.setPos(-11F, 14F, -2F);
        Shape7.setTexSize(64, 32);
        Shape7.mirror = true;
        setRotation(Shape7, 0F, 0F, -1.48353F);
        Shape8 = new ModelRenderer(this, 29, 0);
        Shape8.addBox(3F, -8F, 2F, 2, 6, 2);
        Shape8.setPos(2F, 21F, 10F);
        Shape8.setTexSize(64, 32);
        Shape8.mirror = true;
        setRotation(Shape8, 0F, 2.094395F, -2.268928F);
        Shape9 = new ModelRenderer(this, 29, 0);
        Shape9.addBox(1F, -4F, 1F, 2, 6, 2);
        Shape9.setPos(6F, 21F, -1F);
        Shape9.setTexSize(64, 32);
        Shape9.mirror = true;
        setRotation(Shape9, 0F, -2.617994F, -2.617994F);
        Shape10 = new ModelRenderer(this, 0, 0);
        Shape10.addBox(0F, 0F, 0F, 4, 4, 4);
        Shape10.setPos(6F, 21F, -1F);
        Shape10.setTexSize(64, 32);
        Shape10.mirror = true;
        setRotation(Shape10, 0F, -2.617994F, -2.268928F);
        Shape11 = new ModelRenderer(this, 29, 0);
        Shape11.addBox(16F, 16F, 2F, 2, 6, 2);
        Shape11.setPos(-11F, 21F, -3F);
        Shape11.setTexSize(64, 32);
        Shape11.mirror = true;
        setRotation(Shape11, 0F, 0F, -0.8726646F);
        Shape12 = new ModelRenderer(this, 0, 0);
        Shape12.addBox(8F, 17F, 1F, 4, 6, 4);
        Shape12.setPos(-11F, 21F, -3F);
        Shape12.setTexSize(64, 32);
        Shape12.mirror = true;
        setRotation(Shape12, 0F, 0F, -1.22173F);
        Shape13 = new ModelRenderer(this, 0, 0);
        Shape13.addBox(0F, 0F, 0F, 6, 6, 6);
        Shape13.setPos(5F, 21F, -3F);
        Shape13.setTexSize(64, 32);
        Shape13.mirror = true;
        setRotation(Shape13, 0F, 0F, -1.570796F);
        Shape14 = new ModelRenderer(this, 0, 0);
        Shape14.addBox(0F, 0F, 0F, 6, 6, 6);
        Shape14.setPos(2F, 21F, 10F);
        Shape14.setTexSize(64, 32);
        Shape14.mirror = true;
        setRotation(Shape14, 0F, 2.094395F, -1.570796F);
        Shape15 = new ModelRenderer(this, 0, 0);
        Shape15.addBox(1F, -4F, 1F, 4, 6, 4);
        Shape15.setPos(2F, 21F, 10F);
        Shape15.setTexSize(64, 32);
        Shape15.mirror = true;
        setRotation(Shape15, 0F, 2.094395F, -1.919862F);
        Shape16 = new ModelRenderer(this, 0, 0);
        Shape16.addBox(0F, 0F, 0F, 4, 4, 4);
        Shape16.setPos(-4F, 21F, -4F);
        Shape16.setTexSize(64, 32);
        Shape16.mirror = true;
        setRotation(Shape16, 0F, -0.5235988F, -2.268928F);
        Shape17 = new ModelRenderer(this, 29, 0);
        Shape17.addBox(1F, -4F, 1F, 2, 6, 2);
        Shape17.setPos(-4F, 21F, -4F);
        Shape17.setTexSize(64, 32);
        Shape17.mirror = true;
        setRotation(Shape17, 0F, -0.5235988F, -2.617994F);
        Shape18 = new ModelRenderer(this, 0, 0);
        Shape18.addBox(0F, 0F, 0F, 6, 6, 6);
        Shape18.setPos(-11F, 21F, -3F);
        Shape18.setTexSize(64, 32);
        Shape18.mirror = true;
        setRotation(Shape18, 0F, 0F, -1.570796F);
        Shape19 = new ModelRenderer(this, 0, 0);
        Shape19.addBox(1F, -4F, 1F, 4, 6, 4);
        Shape19.setPos(-11F, 21F, -3F);
        Shape19.setTexSize(64, 32);
        Shape19.mirror = true;
        setRotation(Shape19, 0F, 0F, -1.919862F);
        Shape30 = new ModelRenderer(this, 29, 0);
        Shape30.addBox(3F, -8F, 2F, 2, 6, 2);
        Shape30.setPos(-11F, 21F, -3F);
        Shape30.setTexSize(64, 32);
        Shape30.mirror = true;
        setRotation(Shape30, 0F, 0F, -2.268928F);
        Shape31 = new ModelRenderer(this, 0, 0);
        Shape31.addBox(0F, 0F, 0F, 6, 6, 6);
        Shape31.setPos(-9F, 21F, 7F);
        Shape31.setTexSize(64, 32);
        Shape31.mirror = true;
        setRotation(Shape31, 0F, 1.047198F, -1.570796F);
        Shape32 = new ModelRenderer(this, 0, 0);
        Shape32.addBox(1F, -4F, 1F, 4, 6, 4);
        Shape32.setPos(-9F, 21F, 7F);
        Shape32.setTexSize(64, 32);
        Shape32.mirror = true;
        setRotation(Shape32, 0F, 1.047198F, -1.919862F);
        Shape33 = new ModelRenderer(this, 29, 0);
        Shape33.addBox(3F, -8F, 2F, 2, 6, 2);
        Shape33.setPos(-9F, 21F, 7F);
        Shape33.setTexSize(64, 32);
        Shape33.mirror = true;
        setRotation(Shape33, 0F, 1.047198F, -2.268928F);
    }

    @Override
    public void setupAnim(T p_225597_1_, float p_225597_2_, float p_225597_3_, float p_225597_4_, float p_225597_5_, float p_225597_6_) {

    }

    @Override
    public Iterable<ModelRenderer> parts() {
        return ImmutableList.of(Shape1, Shape2, Shape3, Shape4, Shape5, Shape6, Shape7, Shape8, Shape9, Shape10, Shape11, Shape12, Shape13, Shape14,
        Shape15, Shape16, Shape17, Shape18, Shape19, Shape30, Shape31, Shape32, Shape33);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z)
    {
        model.xRot = x;
        model.yRot = y;
        model.zRot = z;
    }


}
